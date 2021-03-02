package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.tav.coremedia.TimeUtil;

public final class m {
    public static int VaH = 0;
    public static int VaI = 0;
    private final float DsZ = 1.0E-9f;
    private final long Dta = TimeUtil.SECOND_TO_US;
    private final int Dtb = 5;
    public Sensor Dtc;
    public boolean Dtd = false;
    private volatile double Dte = 0.0d;
    private volatile long Dtf = 0;
    public volatile long Dtg = 0;
    public SensorEventListener Dth = new SensorEventListener() {
        /* class com.tencent.mm.plugin.sns.ad.e.m.AnonymousClass1 */

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(201944);
            if (sensorEvent.sensor.getType() == 4) {
                long floor = (long) Math.floor((double) (sensorEvent.values[2] * 1000000.0f));
                if (m.this.Dtg == 0 && floor != 0) {
                    m.this.Dtg = floor;
                }
                if (m.this.Dtg == floor) {
                    AppMethodBeat.o(201944);
                    return;
                } else if (m.this.Dtf != 0) {
                    float f2 = ((float) (sensorEvent.timestamp - m.this.Dtf)) * 1.0E-9f;
                    m.this.Dtf = sensorEvent.timestamp;
                    if (Math.abs(sensorEvent.values[2]) >= 5.0f) {
                        if (m.this.Dti != null) {
                            m.this.Dti.eWR();
                        }
                        AppMethodBeat.o(201944);
                        return;
                    }
                    m.this.Dte += (double) (f2 * sensorEvent.values[2]);
                    float degrees = (float) Math.toDegrees(m.this.Dte);
                    if (m.this.Dti != null) {
                        m.this.Dti.bS(degrees);
                    }
                    AppMethodBeat.o(201944);
                    return;
                } else {
                    m.this.Dtf = sensorEvent.timestamp;
                }
            }
            AppMethodBeat.o(201944);
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };
    public a Dti;
    public SensorManager mSensorManager;

    public interface a {
        void bS(float f2);

        void eWR();
    }

    public m(Context context) {
        AppMethodBeat.i(201945);
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.Dtc = this.mSensorManager.getDefaultSensor(4);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (VaH == 0 && this.mSensorManager.getDefaultSensor(1) != null) {
                VaH = 1;
            }
            if (VaI == 0 && this.mSensorManager.getDefaultSensor(9) != null) {
                VaI = 1;
            }
            new StringBuilder("get sensor cost=").append(System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th) {
            new StringBuilder("get sensor exp=").append(th.toString());
        }
        if (this.Dtc == null) {
            new StringBuilder("device has no Gyroscope sensor, model=").append(Build.MODEL).append(", brand=").append(Build.BRAND);
            uJ(false);
            AppMethodBeat.o(201945);
            return;
        }
        uJ(true);
        AppMethodBeat.o(201945);
    }

    public final void reset() {
        this.Dtf = 0;
        this.Dte = 0.0d;
    }

    private static void uJ(boolean z) {
        AppMethodBeat.i(201946);
        if (z) {
            h.INSTANCE.dN(1572, 1);
            j.b(j.DEd, "", 1, 1, "");
            AppMethodBeat.o(201946);
            return;
        }
        h.INSTANCE.dN(1572, 2);
        j.b(j.DEd, "", 1, 2, "");
        AppMethodBeat.o(201946);
    }
}
