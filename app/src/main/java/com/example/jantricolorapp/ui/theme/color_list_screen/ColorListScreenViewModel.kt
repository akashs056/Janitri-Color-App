package com.example.jantricolorapp.ui.theme.color_list_screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jantricolorapp.data.Color
import com.example.jantricolorapp.data.ColorRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class ColorListScreenViewModel @Inject constructor(
    private val repository: ColorRepository,
    private val firestore: FirebaseFirestore,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val allColors = repository.getAllColors()

    private val _pendingCount = MutableStateFlow(0)
    val pendingCount: StateFlow<Int> = _pendingCount.asStateFlow()

    private var syncJob: Job? = null

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getPendingColors()
                    .collect { colors ->
                        _pendingCount.value = colors.size
                    }
            }
        }
    }

    fun onEvent(event: ColorEvent){
        when(event){
            is ColorEvent.OnAddColorClick ->{
                viewModelScope.launch {
                    val randomColor = generateRandomColor()
                    val currentTimestamp = System.currentTimeMillis()
                    withContext(Dispatchers.IO) {
                        repository.insertColor(
                            Color(
                                color = randomColor,
                                timestamp = currentTimestamp
                            )
                        )
                    }
                }
            }
            is ColorEvent.OnSyncColorClick -> {
                syncJob = viewModelScope.launch {
                    syncPendingColors()
                }
            }
        }
    }

    private suspend fun syncPendingColors() {
        withContext(Dispatchers.IO) {
            repository.getPendingColors().collect { colors ->
                colors.forEach { color ->
                    syncColorWithFirestore(color)
                    repository.markAsSynced(color.id!!)
                }
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Syncing process is completed", Toast.LENGTH_SHORT).show()
                }
                syncJob?.cancel()
            }
        }
    }

    private suspend fun syncColorWithFirestore(color: Color) {
        try {
            firestore.collection("colors")
                .document(color.id.toString())
                .set(color)
                .await()
        } catch (e: Exception) {
            Log.e("Debugg", "Exception is $e")
        }
    }

    private fun generateRandomColor(): String {
        val random = Random()
        val color = String.format("#%06X", random.nextInt(0xFFFFFF + 1))
        return color
    }
}