package com.example.testbluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.os.ParcelFileDescriptor
import androidx.annotation.NonNull
import com.example.tscdll.TSCActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID


class MainActivity : FlutterActivity() {
    companion object {
        private const val REQUEST_ENABLE_BT = 1
        private const val PRINTER_NAME = "YourPrinterName"
        private val UUID_BT_PRINTER = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB") // Standard SPP UUID
    }

    private var bluetoothSocket: BluetoothSocket? = null
    private var tscActivity: TSCActivity? = null
    private val channel = "com.example.testbluetooth/printer"
    private var outStream: OutputStream? = null
    private var inStream: InputStream? = null
    private var btSocket: BluetoothSocket? = null
    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            channel
        )


}}


//private fun setupPrinter(result: MethodChannel.Result) {
//    val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
//    val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices
//    pairedDevices?.let {
//        for (device in it) {
//            if (device.name == "3R20P-9271-LE") {
//                ConnectThread(device, result).start()
//                return
//            }
//        }
//    }
//    result.error("PRINTER_NOT_FOUND", "No paired printer found with the specified name", null)
//}
//private inner class ConnectThread(private val device: BluetoothDevice, private val result: MethodChannel.Result) : Thread() {
//    private var mmSocket: BluetoothSocket? = null
//
//    init {
//        try {
//            mmSocket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
//        } catch (e: IOException) {
//            result.error("SOCKET_CREATION_FAILED", "Could not create Bluetooth socket", e)
//        }
//    }
//
//    override fun run() {
//        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
//        bluetoothAdapter.cancelDiscovery()
//        mmSocket?.let { socket ->
//            try {
//                socket.connect()
//                bluetoothSocket = socket
//                tscActivity = TSCActivity().apply {
//                    openPort(socket)
//                }
//                result.success("Printer setup completed")
//            } catch (e: IOException) {
//                try {
//                    socket.close()
//                } catch (closeException: IOException) {
//                    closeException.printStackTrace()
//                }
//                result.error("CONNECTION_FAILED", "Could not connect to the printer", e)
//            }
//        }
//    }
//}


//             batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
//         } else {
//             val intent = ContextWrapper(applicationContext).registerReceiver(null, IntentFilter(
//                 Intent.ACTION_BATTERY_CHANGED))
//             batteryLevel = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) * 100 / intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
//         }
//
//         return batteryLevel
//     }
//     private fun printText(text: String, result: MethodChannel.Result) {
//         if (tscActivity != null && bluetoothSocket?.isConnected == true) {
//             tscActivity?.sendcommand("SIZE 50 mm, 30 mm")
//             tscActivity?.sendcommand("GAP 3 mm, 0")
//             tscActivity?.sendcommand("CLS")
//             tscActivity?.sendcommand("TEXT 100,100,\"TSS24.BF2\",0,1,1,\"$text\"")
//             tscActivity?.sendcommand("PRINT 1,1")
//             result.success("Printed text: $text")
//         } else {
//             setupPrinter(object: MethodChannel.Result {
//                 override fun success(result: Any?) {
//                     tscActivity?.sendcommand("TEXT 100,100,\"TSS24.BF2\",0,1,1,\"$text\"")
//                     tscActivity?.sendcommand("PRINT 1,1")
//                     result.success("Printed text: $text")
//                 }
//
//                 override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
//                     result.error(errorCode, errorMessage, errorDetails)
//                 }
//
//                 override fun notImplemented() {
//                     result.notImplemented()
//                 }
//             })
//         }
//     }
//    private fun addPrinter(printer:String?) : String {
////        try {
//        var connectedPrinter: String = tscPrinterName.restart()
//        var connectedPrinter: String = tscPrinterName.openport(printer)
//        tscPrinterName.clearbuffer()
//        tscPrinterName.sendcommand("Test print nid noy")
//    }
//        return connectedPrinter
//    }






