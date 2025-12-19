package com.example.pt12.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pt12.repositori.AplikasiDataSiswa
import com.example.pt12.viewmodel.EntryViewModel
import com.example.pt12.viewmodel.HomeViewModel

// Extension function untuk mengambil instance aplikasi
fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        // Initializer untuk HomeViewModel
        initializer {
            HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
        // Initializer untuk EntryViewModel
        initializer {
            EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
    }
}