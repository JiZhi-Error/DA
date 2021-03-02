package com.tencent.mm.plugin.sport.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.ar;

public final class c implements SensorEventListener {
    private long Fjk = 0;
    private long Fjl = 0;
    private boolean Fjm;
    private Sensor sensor;
    private SensorManager sensorManager;

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(149293);
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            final long j2 = (long) sensorEvent.values[0];
            final long j3 = sensorEvent.timestamp;
            Log.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", Long.valueOf(j2), Long.valueOf(j3));
            if (Math.abs(j2 - this.Fjk) >= 20 || System.currentTimeMillis() - this.Fjl >= Util.MILLSECONDS_OF_MINUTE) {
                Log.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", Long.valueOf(j2), Long.valueOf(j3));
                this.Fjk = j2;
                this.Fjl = System.currentTimeMillis();
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.sport.model.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(149292);
                        try {
                            Uri parse = Uri.parse("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_SPORT());
                            MMApplicationContext.getContext().getContentResolver().query(parse, null, "Key_mmSensorChange", new String[]{String.valueOf(j2), String.valueOf(j3)}, null);
                            AppMethodBeat.o(149292);
                        } catch (Exception e2) {
                            AppMethodBeat.o(149292);
                        }
                    }
                }, "Sport.onSensorChange");
            }
            AppMethodBeat.o(149293);
        } else if (sensorEvent == null || sensorEvent.values == null) {
            Object[] objArr = new Object[2];
            if (sensorEvent == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            if (sensorEvent != null) {
                z2 = true;
            }
            objArr[1] = Boolean.valueOf(z2);
            Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", objArr);
            AppMethodBeat.o(149293);
        } else {
            Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", Integer.valueOf(i2), Float.valueOf(fArr[i3]));
                i3++;
                i2++;
            }
            AppMethodBeat.o(149293);
        }
    }

    public final void onAccuracyChanged(Sensor sensor2, int i2) {
    }

    public c() {
        AppMethodBeat.i(149294);
        this.Fjm = k.hg(MMApplicationContext.getContext()) && k.fmg();
        Log.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.Fjm));
        if (this.Fjm) {
            fmr();
        }
        AppMethodBeat.o(149294);
    }

    public final boolean fmp() {
        AppMethodBeat.i(149295);
        this.Fjm = k.hg(MMApplicationContext.getContext()) && k.fmg();
        if (this.Fjm) {
            fmq();
            boolean fmr = fmr();
            AppMethodBeat.o(149295);
            return fmr;
        }
        fmq();
        AppMethodBeat.o(149295);
        return false;
    }

    public final void fmq() {
        AppMethodBeat.i(149296);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            Log.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.o(149296);
        } catch (Exception e2) {
            Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", e2.getMessage());
            AppMethodBeat.o(149296);
        }
    }

    private boolean fmr() {
        AppMethodBeat.i(149297);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                Log.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
                AppMethodBeat.o(149297);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                Log.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.o(149297);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, g.fmy().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                g.aAh().azQ().set(ar.a.USERINFO_REGISTER_STEP_COUNTER_FAIL_INT, (Object) 1);
                fmq();
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_REGISTER_STEP_COUNTER_FAIL_INT, (Object) 0);
            }
            Log.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.o(149297);
            return registerListener;
        } catch (Exception e2) {
            Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", e2.getMessage());
        }
    }
}
