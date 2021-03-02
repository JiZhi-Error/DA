package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static final float DEFAULT_NEAR_FAR_DIVIDE_RATIO = 3.0f;
    private static final float DEFAULT_NEAR_FAR_MAX_VALUE = 10.0f;
    private static final float DEFAULT_PROXIMITY_TRIGGER = 0.5f;
    private static final String TAG = "MicroMsg.SensorController";
    public static double configNearFarDivideRatio = -1.0d;
    private static float minValue = 4.2949673E9f;
    private static float proximityTrig = DEFAULT_PROXIMITY_TRIGGER;
    public static boolean sensorNearFar = false;
    private Context context;
    private boolean isHeadSetPlug = false;
    private boolean isRegistered = false;
    private final boolean isSensorEnable;
    private float lastProximity;
    private float lastValue = -1.0f;
    private float maxValue = -1.0f;
    private Sensor proximitySensor;
    private SensorEventCallBack sensorEventCallBack;
    private SensorManager sensorManager;

    public interface SensorEventCallBack {
        void onSensorEvent(boolean z);
    }

    public SensorController(Context context2) {
        boolean z;
        AppMethodBeat.i(157825);
        if (context2 == null) {
            this.isSensorEnable = false;
            AppMethodBeat.o(157825);
            return;
        }
        this.context = context2;
        this.sensorManager = (SensorManager) context2.getSystemService("sensor");
        this.proximitySensor = this.sensorManager.getDefaultSensor(8);
        if (this.proximitySensor != null) {
            this.maxValue = Math.min((float) DEFAULT_NEAR_FAR_MAX_VALUE, this.proximitySensor.getMaximumRange());
        }
        if (this.maxValue < 0.0f) {
            Log.e(TAG, "error, getMaximumRange return %s, set to 1", Float.valueOf(this.maxValue));
            this.maxValue = 1.0f;
        }
        if (this.proximitySensor != null) {
            z = true;
        } else {
            z = false;
        }
        this.isSensorEnable = z;
        this.lastProximity = proximityTrig + 1.0f;
        AppMethodBeat.o(157825);
    }

    public void setSensorCallBack(SensorEventCallBack sensorEventCallBack2) {
        AppMethodBeat.i(157826);
        Log.i(TAG, "sensor callback set, isRegistered:" + this.isRegistered + ", proximitySensor: " + this.proximitySensor + ", maxValue: " + this.maxValue);
        if (!this.isRegistered) {
            this.lastValue = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.sensorManager.registerListener(this, this.proximitySensor, 2);
            this.isRegistered = true;
        }
        this.sensorEventCallBack = sensorEventCallBack2;
        AppMethodBeat.o(157826);
    }

    public void removeSensorCallBack() {
        AppMethodBeat.i(157827);
        Log.i(TAG, "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e2) {
            Log.v(TAG, "sensor receiver has already unregistered");
        }
        this.sensorManager.unregisterListener(this, this.proximitySensor);
        this.sensorManager.unregisterListener(this);
        this.isRegistered = false;
        this.sensorEventCallBack = null;
        this.lastValue = -1.0f;
        AppMethodBeat.o(157827);
    }

    public boolean hasRegistered() {
        return this.isRegistered;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public boolean isSensorEnable() {
        return this.isSensorEnable;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(157828);
        if (sensorEvent == null || sensorEvent.sensor == null || this.proximitySensor == null) {
            AppMethodBeat.o(157828);
        } else if (this.isHeadSetPlug) {
            AppMethodBeat.o(157828);
        } else {
            float f2 = sensorEvent.values[0];
            double d2 = 3.0d;
            Log.i(TAG, "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f2), Float.valueOf(this.maxValue), Double.valueOf(3.0d), Double.valueOf(configNearFarDivideRatio), Float.valueOf(this.lastValue), Float.valueOf(this.proximitySensor.getMaximumRange()));
            if (configNearFarDivideRatio > 0.0d) {
                d2 = configNearFarDivideRatio;
            }
            float maximumRange = (configNearFarDivideRatio > 0.0d || this.maxValue < 0.0f) ? this.proximitySensor.getMaximumRange() : this.maxValue;
            float max = Math.max(0.1f, (float) (((double) maximumRange) / d2));
            Log.i(TAG, "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(max), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.sensorEventCallBack != null) {
                        if (f2 != this.lastValue) {
                            if (f2 < max) {
                                Log.i(TAG, "sensor near-far event near false");
                                this.sensorEventCallBack.onSensorEvent(false);
                            } else {
                                Log.i(TAG, "sensor near-far event far true");
                                this.sensorEventCallBack.onSensorEvent(true);
                            }
                            this.lastValue = f2;
                            break;
                        } else {
                            AppMethodBeat.o(157828);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(157828);
                        return;
                    }
            }
            AppMethodBeat.o(157828);
        }
    }

    public void onReceive(Context context2, Intent intent) {
        AppMethodBeat.i(157829);
        if (intent == null) {
            AppMethodBeat.o(157829);
            return;
        }
        String action = intent.getAction();
        if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra("state", 0);
            if (intExtra == 1) {
                this.isHeadSetPlug = true;
            }
            if (intExtra == 0) {
                this.isHeadSetPlug = false;
            }
        }
        AppMethodBeat.o(157829);
    }
}
