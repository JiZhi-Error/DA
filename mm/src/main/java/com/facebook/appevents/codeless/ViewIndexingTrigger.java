package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(17526);
        if (this.mListener != null) {
            float f2 = sensorEvent.values[0];
            double d2 = (double) (f2 / 9.80665f);
            double d3 = (double) (sensorEvent.values[1] / 9.80665f);
            double d4 = (double) (sensorEvent.values[2] / 9.80665f);
            if (Math.sqrt((d3 * d3) + (d2 * d2) + (d4 * d4)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
        AppMethodBeat.o(17526);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }
}
