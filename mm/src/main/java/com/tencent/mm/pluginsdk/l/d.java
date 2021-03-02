package com.tencent.mm.pluginsdk.l;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class d {
    private a KaL;
    private SensorManager manager = ((SensorManager) MMApplicationContext.getContext().getSystemService("sensor"));

    public d() {
        AppMethodBeat.i(152093);
        AppMethodBeat.o(152093);
    }

    public final boolean gok() {
        return this.KaL != null;
    }

    public final void gol() {
        AppMethodBeat.i(152094);
        if (this.KaL != null) {
            this.KaL.reset();
        }
        AppMethodBeat.o(152094);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(152095);
        cBo();
        if (gon()) {
            this.KaL = aVar;
            this.manager.registerListener(this.KaL, this.manager.getDefaultSensor(1), 1);
            AppMethodBeat.o(152095);
            return;
        }
        Log.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
        AppMethodBeat.o(152095);
    }

    public final void cBo() {
        AppMethodBeat.i(152096);
        if (this.KaL != null) {
            this.KaL.onRelease();
            this.manager.unregisterListener(this.KaL, this.manager.getDefaultSensor(1));
            this.KaL = null;
        }
        AppMethodBeat.o(152096);
    }

    public final boolean gom() {
        AppMethodBeat.i(152097);
        if (gon()) {
            AppMethodBeat.o(152097);
            return true;
        }
        AppMethodBeat.o(152097);
        return false;
    }

    private boolean gon() {
        AppMethodBeat.i(152098);
        if (this.manager == null) {
            Log.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            AppMethodBeat.o(152098);
            return false;
        }
        List<Sensor> sensorList = this.manager.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            AppMethodBeat.o(152098);
            return false;
        }
        AppMethodBeat.o(152098);
        return true;
    }

    public static abstract class a implements SensorEventListener {
        private static final String LG_E510 = "LG-E510";
        private static final String TAG = "MicroMsg.ShakeSensorListener";
        private static int THREAHOLD;
        private float[] mPrev = new float[3];
        private final float[] mScale = {2.0f, 2.5f, 0.5f};

        public abstract void onRelease();

        public abstract void onShake(boolean z);

        public void onShake(float[] fArr) {
        }

        public void reset() {
            Log.d(TAG, "reset threadHold");
            THREAHOLD = 5;
            if (Build.MODEL.equals(LG_E510)) {
                THREAHOLD = 4;
            }
        }

        static {
            THREAHOLD = 5;
            if (Build.MODEL.equals(LG_E510)) {
                THREAHOLD = 4;
            }
        }

        private float selfAdaptation(float f2) {
            if (f2 >= 4.0f) {
                Log.v(TAG, "result:" + f2 + " THREAHOLD:" + THREAHOLD);
            }
            if (THREAHOLD < 9) {
                if (f2 >= 14.0f) {
                    THREAHOLD = 9;
                } else {
                    int i2 = (int) f2;
                    if (THREAHOLD < i2 - 4) {
                        THREAHOLD = i2 - 4;
                    }
                }
            }
            return f2;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = new float[3];
            float[] fArr2 = sensorEvent.values;
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i2] = (float) Math.round(this.mScale[i2] * (fArr2[i2] - this.mPrev[i2]) * 0.45f);
                if (selfAdaptation(Math.abs(fArr[i2])) > ((float) THREAHOLD)) {
                    z = true;
                }
                this.mPrev[i2] = fArr2[i2];
            }
            if (z) {
                Log.d(TAG, "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
                onShake(true);
                onShake(sensorEvent.values);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }
}
