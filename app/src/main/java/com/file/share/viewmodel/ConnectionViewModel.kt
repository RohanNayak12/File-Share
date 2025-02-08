package com.file.share.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.file.share.manager.BluetoothManager
import com.file.share.manager.WifiDirectManager
import kotlinx.coroutines.flow.StateFlow

class ConnectionViewModel(application: Application) : AndroidViewModel(application) {
    // Initialize managers for Wi-Fi Direct and Bluetooth
    private val wifiDirectManager = WifiDirectManager(application)
    private val bluetoothManager = BluetoothManager(application)

    // Expose discovered devices as state flows
    val wifiDevices: StateFlow<List<android.net.wifi.p2p.WifiP2pDevice>> = wifiDirectManager.discoveredDevices
    val bluetoothDevices: StateFlow<List<android.bluetooth.BluetoothDevice>> = bluetoothManager.discoveredDevices

    init {
        // Register receivers and start device discovery
        wifiDirectManager.registerReceiver()
        bluetoothManager.registerReceiver()
        wifiDirectManager.discoverPeers()
        bluetoothManager.startDiscovery()
    }

    override fun onCleared() {
        super.onCleared()
        // Unregister receivers to avoid leaks
        wifiDirectManager.unregisterReceiver()
        bluetoothManager.unregisterReceiver()
    }
}