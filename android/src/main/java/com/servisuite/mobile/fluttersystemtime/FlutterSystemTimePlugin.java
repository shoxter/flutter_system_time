package com.servisuite.mobile.fluttersystemtime;

import android.os.SystemClock;

import io.flutter.embedding.engine.plugins.FlutterPlugin;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterSystemTimePlugin */
public class FlutterSystemTimePlugin implements FlutterPlugin, MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_system_time");
    channel.setMethodCallHandler(new FlutterSystemTimePlugin());
  }

  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding) {
    final MethodChannel channel = new MethodChannel(binding.getBinaryMessenger(), "flutter_system_time");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding binding) {

  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("getElapsedRealtime")) {
			long realtime = SystemClock.elapsedRealtime();
			result.success(realtime);
    } else {
      result.notImplemented();
    }
  }
}
