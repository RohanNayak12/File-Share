package com.file.share.ui

import android.bluetooth.BluetoothDevice
import android.net.wifi.p2p.WifiP2pDevice
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.file.share.viewmodel.ConnectionViewModel

@Suppress("MissingPermission")
@Composable
fun MainScreen(viewModel: ConnectionViewModel) {
    // Collect state flows from the ViewModel
    val wifiDevices = viewModel.wifiDevices.collectAsState().value
    val bluetoothDevices = viewModel.bluetoothDevices.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Wi-Fi Direct Devices",
            style = MaterialTheme.typography.bodyMedium
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(wifiDevices) { device: WifiP2pDevice ->
                Text(text = device.deviceName)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Bluetooth Devices",
            style = MaterialTheme.typography.bodyMedium
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(bluetoothDevices) { device: BluetoothDevice ->
                Text(text = device.name ?: "Unknown Device")
            }
        }
    }
}