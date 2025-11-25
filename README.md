# File-Share 📱

A modern Android application for local file sharing using Wi-Fi Direct and Bluetooth technologies. Built with Kotlin and Jetpack Compose, this app enables seamless peer-to-peer file transfer without requiring an internet connection.

## 🌟 Features

- **Wi-Fi Direct Support**: High-speed file transfer using Wi-Fi Direct technology
- **Bluetooth Integration**: Alternative connectivity option for file sharing
- **Modern UI**: Built with Jetpack Compose for a smooth, native Android experience
- **Permission Management**: Runtime permission handling for Android 12+ (API 31+)
- **MVVM Architecture**: Clean separation of concerns using ViewModel pattern
- **Offline Transfer**: No internet connection required for file sharing

## 🛠️ Technologies Used

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern declarative UI toolkit
- **Material Design 3**: Latest Material Design components
- **Android Architecture Components**: ViewModel, LiveData
- **Wi-Fi Direct API**: Peer-to-peer connectivity
- **Bluetooth API**: Alternative wireless protocol

## 📋 Requirements

- **Minimum SDK**: API 28 (Android 9.0)
- **Target SDK**: API 35 (Android 15)
- **Compile SDK**: API 35
- **Java Version**: 11
- **Kotlin Compiler**: 1.5.1

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog | 2023.1.1 or later
- Android SDK with API 35 installed
- Physical Android device (recommended for testing Wi-Fi Direct and Bluetooth)

### Installation

1. **Clone the repository**:
   git clone https://github.com/RohanNayak12/File-Share.git
   cd File-Share

2. **Open in Android Studio**:
   - Launch Android Studio
   - Select `File > Open`
   - Navigate to the cloned directory and open it

3. **Sync Gradle**:
   - Android Studio should automatically sync Gradle
   - If not, click `File > Sync Project with Gradle Files`

4. **Run the app**:
   - Connect an Android device or start an emulator
   - Click the `Run` button (green play icon) or press `Shift + F10`

### Building from Command Line

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing configuration)
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug

## 🔑 Permissions

The app requires the following permissions for full functionality:

### Required Permissions
- `ACCESS_FINE_LOCATION`: Required for Wi-Fi Direct device discovery
- `ACCESS_WIFI_STATE`: Check Wi-Fi status
- `CHANGE_WIFI_STATE`: Enable/disable Wi-Fi
- `ACCESS_NETWORK_STATE`: Network connectivity information
- `BLUETOOTH`: Basic Bluetooth operations
- `BLUETOOTH_ADMIN`: Bluetooth device discovery

### Android 12+ Permissions
- `NEARBY_WIFI_DEVICES`: Required for Wi-Fi Direct on Android 13+
- `BLUETOOTH_CONNECT`: Connect to paired Bluetooth devices
- `BLUETOOTH_SCAN`: Discover Bluetooth devices

All permissions are requested at runtime following Android best practices.

## 💡 Usage

1. **Launch the app** on two Android devices
2. **Grant permissions** when prompted
3. **Select connection method**: Wi-Fi Direct or Bluetooth
4. **Discover nearby devices** using the scan feature
5. **Connect** to the target device
6. **Select files** to share from your device
7. **Transfer files** securely between devices

## 🏗️ Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Data layer with connection managers (`WifiDirectManager`, `BluetoothManager`)
- **View**: Jetpack Compose UI components (`MainScreen`)
- **ViewModel**: `ConnectionViewModel` manages UI state and business logic

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines

- Follow Kotlin coding conventions
- Write meaningful commit messages
- Add unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Rohan Nayak**
- GitHub: [@RohanNayak12](https://github.com/RohanNayak12)

## 🐛 Known Issues

- Wi-Fi Direct discovery may be slow on some devices
- Bluetooth transfer speed is limited compared to Wi-Fi Direct
- Some Android 14+ devices may require additional permissions

## 🔮 Future Enhancements

- [ ] Multiple file selection and batch transfer
- [ ] Transfer progress indicators
- [ ] QR code pairing for easier device discovery
- [ ] Transfer history and statistics
- [ ] Dark mode toggle
- [ ] File encryption for secure transfers
- [ ] Support for larger file sizes (>2GB)


---

**⭐ Star this repository if you find it helpful!**
