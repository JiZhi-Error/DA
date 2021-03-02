package com.tencent.mm.plugin.sport.model;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Calendar;
import org.json.JSONObject;

public final class f implements SensorEventListener {
    private static long Fjs = 0;
    private static long Fjt = 0;
    private static long Fju = 0;
    private static long Fjv = 0;
    private static long Fjw = 0;
    private static long Fjx = 0;
    private static long Fjy = 0;
    private static long Fjz = 0;
    private IListener<qb> FjA = new IListener<qb>() {
        /* class com.tencent.mm.plugin.sport.model.f.AnonymousClass1 */

        {
            AppMethodBeat.i(161593);
            this.__eventId = qb.class.getName().hashCode();
            AppMethodBeat.o(161593);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qb qbVar) {
            AppMethodBeat.i(149308);
            Log.i("MicroMsg.Sport.PushSportStepDetector", "pushKeepAliveEvent %d", Long.valueOf((System.currentTimeMillis() - f.Fjx) / Util.MILLSECONDS_OF_MINUTE));
            if (f.this.Fjm && f.fmw()) {
                SportForegroundService.fmE();
            }
            AppMethodBeat.o(149308);
            return false;
        }
    };
    private boolean Fjm = false;
    private Sensor sensor;
    private SensorManager sensorManager;

    public static long fms() {
        return Fjt;
    }

    public static long fmt() {
        return Fjv;
    }

    public f() {
        long[] jArr;
        AppMethodBeat.i(149309);
        if (d.oD(28)) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
            this.FjA.alive();
        }
        this.Fjm = k.hg(MMApplicationContext.getContext()) && k.fmJ();
        Log.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.Fjm));
        if (this.Fjm) {
            fmr();
        }
        Fjz = 0;
        try {
            if (s.YS(a.FiU)) {
                i iVar = new i(a.FiU);
                Fjv = iVar.getLong(202, 0) * 10000;
                Fjt = iVar.getLong(201, 0);
                Fjs = iVar.getLong(203, 0);
                Fjw = iVar.getLong(204, 0);
                Fjy = iVar.getLong(209, 0);
                Fju = Fjt;
                Fjx = Fjw;
                j.aRF(fmu());
                s.deleteFile(a.FiU);
            } else {
                String fmD = j.fmD();
                Log.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", fmD);
                if (!Util.isNullOrNil(fmD)) {
                    jArr = k.aRG(fmD);
                } else {
                    jArr = new long[7];
                }
                Fjv = jArr[0];
                Fjw = jArr[1];
                Fjx = jArr[2];
                Fjy = jArr[3];
                Fjs = jArr[4];
                Fjt = jArr[5];
                Fju = jArr[6];
            }
            Log.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", Long.valueOf(Fjt), k.AF(Fjv));
        } catch (Exception e2) {
            Fjv = 0;
            Fjw = 0;
            Fjx = 0;
            Fjy = 0;
            Fjs = 0;
            Fjt = 0;
            Fju = 0;
            Log.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", e2, "PushSportStepDetector constructor", new Object[0]);
        }
        if (Fjv != k.fmH()) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", k.AF(Fjv));
            Fjv = 0;
            Fjw = 0;
            Fjx = 0;
            Fjy = 0;
            Fjs = 0;
            Fjt = 0;
            Fju = 0;
        }
        AppMethodBeat.o(149309);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(149310);
        Log.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", Long.valueOf((long) sensorEvent.values[0]), Long.valueOf(sensorEvent.timestamp));
        if (MMApplicationContext.isMMProcessExist() && !SportForegroundService.fmG()) {
            Log.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
            AppMethodBeat.o(149310);
        } else if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            b((long) sensorEvent.values[0], sensorEvent.timestamp, "PUSH");
            AppMethodBeat.o(149310);
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
            Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", objArr);
            AppMethodBeat.o(149310);
        } else {
            Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", Integer.valueOf(i3), Float.valueOf(fArr[i2]));
                i2++;
                i3++;
            }
            AppMethodBeat.o(149310);
        }
    }

    public final void b(long j2, long j3, String str) {
        String str2;
        boolean z;
        long j4;
        AppMethodBeat.i(149311);
        JSONObject fmy = g.fmy();
        if (fmy.optInt("deviceStepSwitch") != 1) {
            fmq();
            Log.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
            AppMethodBeat.o(149311);
            return;
        }
        int optInt = fmy.optInt("stepCounterMaxStep5m", 3000);
        long fmH = k.fmH();
        if (j2 < 0) {
            AppMethodBeat.o(149311);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Fjv != fmH) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", k.AF(fmH), k.AF(Fjv));
            Fjs = j2;
            Fjt = 0;
            Fju = 0;
            Fjv = fmH;
            Fjw = currentTimeMillis;
            Fjx = currentTimeMillis;
            Fjy = j3;
            j.aRF(fmu());
            AppMethodBeat.o(149311);
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        long j5 = 0;
        long j6 = ((currentTimeMillis - Fjx) / 300000) + ((long) ((currentTimeMillis - Fjx) % 300000 > 0 ? 1 : 0));
        long j7 = (((j3 / TimeUtil.SECOND_TO_US) - (Fjy / TimeUtil.SECOND_TO_US)) / 300000) + ((long) (((j3 / TimeUtil.SECOND_TO_US) - (Fjy / TimeUtil.SECOND_TO_US)) % 300000 > 0 ? 1 : 0));
        boolean z2 = false;
        String str3 = "";
        if (currentTimeMillis2 > Fjw) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", Long.valueOf(currentTimeMillis2), k.AF(currentTimeMillis2), Long.valueOf(Fjw));
            long j8 = j2 - Fju;
            if (j8 <= 0 || (j8 >= ((long) optInt) * j7 && j8 >= ((long) optInt) * j6)) {
                j4 = 0;
            } else {
                str3 = "rebootIncrease Valid Step diffStep > 0";
                j4 = j8;
            }
            if (j8 < 0 && (j2 < ((long) optInt) * j7 || j2 < ((long) optInt) * j6)) {
                str3 = "rebootIncrease Valid Step diffStep < 0";
                j4 = j2;
            }
            j5 = j4;
            str2 = str3;
            z = true;
        } else {
            if (j2 < Fjs) {
                Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", Long.valueOf(j2), Long.valueOf(Fjs), Long.valueOf(Fju));
                Fjs = j2;
                Fju = j2;
                z2 = true;
            }
            if (j2 - Fjs < j7 * ((long) optInt) || j2 - Fjs < j6 * ((long) optInt)) {
                j5 = j2 - Fjs;
                str2 = "normalIncrease Valid Step";
                z = z2;
            } else {
                str2 = str3;
                z = z2;
            }
        }
        Log.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", str, str2, Long.valueOf(j5), Boolean.valueOf(z), Long.valueOf(Fjz), Long.valueOf(Fjt), Long.valueOf(Fju));
        Fjt += j5;
        Fjz += j5;
        if (currentTimeMillis - Fjw > ((long) fmy.optInt("stepCounterSaveInterval", 60000)) || j2 - Fju > ((long) fmy.optInt("stepCounterSaveStep")) || z) {
            Fjw = currentTimeMillis;
            Fju = j2;
            Fjs = j2;
            Fjx = currentTimeMillis;
            Fjy = j3;
            String fmu = fmu();
            Log.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", fmu);
            j.aRF(fmu);
            if (Fjz >= 500) {
                fmv();
                Fjz = 0;
            }
            AppMethodBeat.o(149311);
            return;
        }
        Fjs = j2;
        Fjx = currentTimeMillis;
        Fjy = j3;
        AppMethodBeat.o(149311);
    }

    private static String fmu() {
        AppMethodBeat.i(149312);
        String format = String.format("%d,%d,%d,%d,%d,%d,%d", Long.valueOf(Fjv), Long.valueOf(Fjw), Long.valueOf(Fjx), Long.valueOf(Fjy), Long.valueOf(Fjs), Long.valueOf(Fjt), Long.valueOf(Fju));
        AppMethodBeat.o(149312);
        return format;
    }

    private static void fmv() {
        AppMethodBeat.i(149313);
        Log.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
        Intent intent = new Intent();
        intent.setPackage(MMApplicationContext.getContext().getPackageName());
        intent.setAction("com.tencent.mm.plugin.sport.uploadstep");
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(149313);
    }

    public final void onAccuracyChanged(Sensor sensor2, int i2) {
    }

    private boolean fmr() {
        AppMethodBeat.i(149314);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                Log.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
                AppMethodBeat.o(149314);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                Log.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.o(149314);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, g.fmy().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                fmq();
            }
            Log.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.o(149314);
            return registerListener;
        } catch (Exception e2) {
            Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", e2.getMessage());
        }
    }

    private void fmq() {
        AppMethodBeat.i(149315);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            Log.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.o(149315);
        } catch (Exception e2) {
            Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", e2.getMessage());
            AppMethodBeat.o(149315);
        }
    }

    public final boolean fmp() {
        AppMethodBeat.i(149316);
        this.Fjm = k.hg(MMApplicationContext.getContext()) && k.fmJ();
        if (this.Fjm) {
            fmq();
            boolean fmr = fmr();
            AppMethodBeat.o(149316);
            return fmr;
        }
        fmq();
        AppMethodBeat.o(149316);
        return false;
    }

    static /* synthetic */ boolean fmw() {
        AppMethodBeat.i(149317);
        if (((PowerManager) MMApplicationContext.getContext().getSystemService("power")).isScreenOn()) {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "Screen On");
        } else {
            Calendar instance = Calendar.getInstance();
            if (instance.get(11) == 21) {
                if (instance.getTimeInMillis() - Fjx > 900000) {
                    AppMethodBeat.o(149317);
                    return true;
                }
                AppMethodBeat.o(149317);
                return false;
            } else if (instance.getTimeInMillis() - Fjx > 1800000) {
                AppMethodBeat.o(149317);
                return true;
            }
        }
        AppMethodBeat.o(149317);
        return false;
    }
}
