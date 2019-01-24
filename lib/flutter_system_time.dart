import 'dart:async';

import 'package:flutter/services.dart';

class FlutterSystemTime {
  static const MethodChannel _channel =
      const MethodChannel('flutter_system_time');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<int> elapsedRealtime() async {
  	final int time = await _channel.invokeMethod("getElapsedRealtime");
  	return time;
	}
}
