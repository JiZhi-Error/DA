package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.h;
import java.util.HashMap;

public final class l {
    private static final HashMap<String, HandlerThread> mqY = new HashMap<>();
    private Handler mHandler;
    private SensorManager mSensorManager;
    private String mqX = null;

    static {
        AppMethodBeat.i(193703);
        AppMethodBeat.o(193703);
    }

    private static HandlerThread aaI(String str) {
        HandlerThread handlerThread;
        AppMethodBeat.i(193701);
        String concat = "MicroMsg.UnitSensor.".concat(String.valueOf(str));
        synchronized (mqY) {
            try {
                handlerThread = mqY.get(concat);
                if (handlerThread == null) {
                    handlerThread = d.hD(concat, 5);
                    mqY.put(concat, handlerThread);
                }
            } finally {
                AppMethodBeat.o(193701);
            }
        }
        if (handlerThread.getLooper() == null) {
            handlerThread.start();
        }
        return handlerThread;
    }

    public l(String str) {
        AppMethodBeat.i(193702);
        this.mHandler = new Handler(aaI(str).getLooper());
        AppMethodBeat.o(193702);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.jsapi.file.i.a a(com.tencent.mm.plugin.appbrand.jsapi.f r8, org.json.JSONObject r9, com.tencent.mm.plugin.appbrand.jsapi.y.l.a r10, java.lang.String r11, java.util.List<java.lang.Integer> r12) {
        /*
        // Method dump skipped, instructions count: 508
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.y.l.a(com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, com.tencent.mm.plugin.appbrand.jsapi.y.l$a, java.lang.String, java.util.List):com.tencent.mm.plugin.appbrand.jsapi.file.i$a");
    }

    public final void a(a aVar) {
        AppMethodBeat.i(137658);
        this.mSensorManager.unregisterListener(aVar);
        if (!TextUtils.isEmpty(this.mqX)) {
            ad.aVe().JW(this.mqX);
        }
        AppMethodBeat.o(137658);
    }

    public static abstract class a extends h.c implements SensorEventListener {
        a() {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void bIH() {
        }
    }
}
