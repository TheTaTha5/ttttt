import 'dart:developer';

import 'package:flutter/services.dart';

class PrinterService {
  static const platform = MethodChannel('com.example.testbluetooth/printer');

  Future<void> printLabel(String printerName) async {
    // try {

    await platform.invokeMethod('printLabel', {'printerName': printerName});
    // log('printer level: $result');

    // } on PlatformException catch (e) {
    // log("Failed to print label:${e.code} '${e.message}' ${e.details}.");
    // return false;
    // }
  }

  Future<bool> checkConnection(String address) async {
    late bool result;
    try {
      result =
          await platform.invokeMethod('connectToPrinter', {'address': address});
      log('connectToPrinter: $result');
    } on PlatformException catch (e) {
      log("Failed to connectToPrinter: '${e.message}'.");
    }
    return result;
  }

  Future<void> restartPrinter() async {
    try {
      final result = await platform.invokeMethod('restart');
      if (result == '1') {
        log('Printer restarted successfully.');
      } else {
        log('Failed to restart printer.');
      }
    } on PlatformException catch (e) {
      log("Error occurred: '${e.message}'.");
    }
  }

  // Future<void> testPrinterCodePage() async {
  //   try {
  //     final String result = await platform.invokeMethod('printCodeSheet');
  //     log('printer level: $result');
  //   } on PlatformException catch (e) {
  //     log("Failed to print label: '${e.message}'.");
  //   }
  // }

  // Future<void> testPrinterCodePage() async {
  //   try {
  //     final String result = await platform.invokeMethod('printCodeSheet');
  //     log('printer level: $result');
  //   } on PlatformException catch (e) {
  //     log("Failed to print label: '${e.message}'.");
  //   }
  // }

  // Future<void> addPrinterTest(String address) async {
  //   try {
  //     final String result =
  //         await platform.invokeMethod('addPrinter', {'address': address});
  //     log('addPrinterTest reult: $result');
  //   } on PlatformException catch (e) {
  //     log("Failed to connect print label: '${e.message}'.");
  //   }
  // }
}
