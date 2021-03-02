package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j implements SensorEventListener {
    public static final j CUb = new j();
    public Sensor CTX = this.mSensorManager.getDefaultSensor(1);
    public float[] CTY = new float[3];
    public int CTZ;
    private long CUa;
    public SensorManager mSensorManager = ((SensorManager) MMApplicationContext.getContext().getSystemService("sensor"));

    static {
        AppMethodBeat.i(52061);
        AppMethodBeat.o(52061);
    }

    private j() {
        AppMethodBeat.i(52059);
        AppMethodBeat.o(52059);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(52060);
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            Log.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
            if (this.CTY[0] == 0.0f && this.CTY[1] == 0.0f && this.CTY[2] == 0.0f) {
                this.CTY[0] = fArr[0];
                this.CTY[1] = fArr[1];
                this.CTY[2] = fArr[2];
                AppMethodBeat.o(52060);
                return;
            }
            if (Math.abs(fArr[0] - this.CTY[0]) > 0.7f || Math.abs(fArr[1] - this.CTY[1]) > 0.7f || Math.abs(fArr[2] - this.CTY[2]) > 0.7f) {
                Log.d("MicroMsg.ScanStableDetector", "scan unstable");
                this.CTZ = 0;
            } else {
                if (this.CTZ == 0) {
                    this.CUa = System.currentTimeMillis();
                }
                this.CTZ++;
                if (this.CTZ >= 5) {
                    Log.d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.CTY[0] = fArr[0];
            this.CTY[1] = fArr[1];
            this.CTY[2] = fArr[2];
        }
        AppMethodBeat.o(52060);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final long eRV() {
        if (this.CTZ >= 5) {
            return this.CUa;
        }
        return 0;
    }
}
