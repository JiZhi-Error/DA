package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

public class SensorManagerWorker {
    private static final String TAG = "MicroMsg.LightSensor";
    private boolean mHasStarted;
    private LightSensorListener mLightSensorListener;
    private OnGetValue mOnGetValue;
    private SensorManager mSensorManager;

    public interface OnGetValue {
        void onGetValue(float f2);
    }

    private SensorManagerWorker() {
        this.mHasStarted = false;
    }

    public static SensorManagerWorker getInstance() {
        AppMethodBeat.i(43414);
        SensorManagerWorker sensorManagerWorker = Singleton.instance;
        AppMethodBeat.o(43414);
        return sensorManagerWorker;
    }

    /* access modifiers changed from: package-private */
    public static class Singleton {
        private static SensorManagerWorker instance = new SensorManagerWorker();

        private Singleton() {
        }

        static {
            AppMethodBeat.i(43413);
            AppMethodBeat.o(43413);
        }
    }

    public int start(Context context, OnGetValue onGetValue) {
        AppMethodBeat.i(43415);
        if (this.mHasStarted) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[SensorManagerWorker.start] light sensor has started");
            AppMethodBeat.o(43415);
            return 2;
        }
        this.mHasStarted = true;
        this.mSensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.mLightSensorListener = new LightSensorListener();
            this.mSensorManager.registerListener(this.mLightSensorListener, defaultSensor, 3);
            this.mOnGetValue = onGetValue;
            AppMethodBeat.o(43415);
            return 0;
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[SensorManagerWorker.start] System do not have lightSensor");
        AppMethodBeat.o(43415);
        return 1;
    }

    public float getLux() {
        AppMethodBeat.i(43416);
        if (this.mLightSensorListener != null) {
            new StringBuilder("Light lux: ").append(this.mLightSensorListener.lux);
            float f2 = this.mLightSensorListener.lux;
            AppMethodBeat.o(43416);
            return f2;
        }
        AppMethodBeat.o(43416);
        return -1.0f;
    }

    public void stop() {
        AppMethodBeat.i(43417);
        if (!this.mHasStarted || this.mSensorManager == null) {
            AppMethodBeat.o(43417);
            return;
        }
        this.mHasStarted = false;
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        AppMethodBeat.o(43417);
    }

    /* access modifiers changed from: package-private */
    public class LightSensorListener implements SensorEventListener {
        private float lux;

        private LightSensorListener() {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(43412);
            if (sensorEvent.sensor.getType() == 5) {
                this.lux = sensorEvent.values[0];
                if (SensorManagerWorker.this.mOnGetValue != null) {
                    SensorManagerWorker.this.mOnGetValue.onGetValue(this.lux);
                }
            }
            AppMethodBeat.o(43412);
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }
}
