package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ShakeManager {
    private static final String TAG = "MicroMsg.ShakeManager";
    private ShakeSensorListener listener;
    private SensorManager manager;

    public ShakeManager(Context context) {
        AppMethodBeat.i(157832);
        this.manager = (SensorManager) context.getSystemService("sensor");
        AppMethodBeat.o(157832);
    }

    public boolean startShake(Runnable runnable) {
        AppMethodBeat.i(157833);
        if (this.manager == null) {
            AppMethodBeat.o(157833);
            return false;
        }
        List<Sensor> sensorList = this.manager.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            AppMethodBeat.o(157833);
            return false;
        }
        this.listener = new ShakeSensorListener(runnable);
        this.manager.registerListener(this.listener, 2, 3);
        AppMethodBeat.o(157833);
        return true;
    }

    public void stopShake() {
        AppMethodBeat.i(157834);
        if (!(this.manager == null || this.listener == null)) {
            this.manager.unregisterListener(this.listener, 2);
        }
        AppMethodBeat.o(157834);
    }

    /* access modifiers changed from: package-private */
    public static class ShakeSensorListener implements SensorListener {
        private Runnable callback;
        private float[] mPrev = {0.0f, 0.0f, 0.0f};

        public ShakeSensorListener(Runnable runnable) {
            AppMethodBeat.i(157830);
            this.callback = runnable;
            AppMethodBeat.o(157830);
        }

        public void onAccuracyChanged(int i2, int i3) {
        }

        public void onSensorChanged(int i2, float[] fArr) {
            AppMethodBeat.i(157831);
            float[] fArr2 = new float[3];
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                fArr2[i3] = Math.abs(fArr[i3] - this.mPrev[i3]);
                if (this.mPrev[i3] != 0.0f && fArr2[i3] > 1.0f) {
                    z = true;
                    Log.d(ShakeManager.TAG, "isONShake:" + fArr2[i3]);
                }
                this.mPrev[i3] = fArr[i3];
            }
            if (z) {
                this.callback.run();
            }
            AppMethodBeat.o(157831);
        }
    }
}
