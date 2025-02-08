package com.file.share

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.file.share.ui.LocalFileSharingAppTheme
import com.file.share.ui.MainScreen
import com.file.share.viewmodel.ConnectionViewModel

class MainActivity : ComponentActivity() {

    private lateinit var connectionViewModel: ConnectionViewModel

    private val requestNearbyWifiPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        //to be defined
    }

    private val requestBluetoothScanPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        //permission result to be defined
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Checking for NEARBY_WIFI_DEVICES permission.
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.NEARBY_WIFI_DEVICES
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestNearbyWifiPermissionLauncher.launch(Manifest.permission.NEARBY_WIFI_DEVICES)
            }
        }

        // Checking for BLUETOOTH_SCAN permission.
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                requestBluetoothScanPermissionLauncher.launch(Manifest.permission.BLUETOOTH_SCAN)
            }
        }

        // VM initialization
        connectionViewModel = ConnectionViewModel(application)

        setContent {
            LocalFileSharingAppTheme {
                MainScreen(viewModel = connectionViewModel)
            }
        }
    }
}