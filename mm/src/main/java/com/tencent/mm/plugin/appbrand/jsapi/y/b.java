package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.jsapi.y.k;
import com.tencent.mm.plugin.appbrand.jsapi.y.l;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";

    public static final class a extends bc {
        private static final int CTRL_INDEX = 93;
        private static final String NAME = "onAccelerometerChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137625);
        final l lVar = new l(NAME);
        i.a a2 = lVar.a(fVar, jSONObject, new AbstractC0726b(fVar) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(137623);
                h.b(fVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(137623);
            }
        }, "JsApi#SensorAccelerometer" + fVar.hashCode(), new ArrayList(Arrays.asList(1)));
        fVar.i(i2, n(a2.errMsg, a2.values));
        AppMethodBeat.o(137625);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.y.b$b  reason: collision with other inner class name */
    static abstract class AbstractC0726b extends l.a implements SensorEventListener {
        private o mqi;
        a mqj = new a();

        AbstractC0726b(final f fVar) {
            this.mqj.h(fVar);
            this.mqi = new o((long) i.mqN.bID(), new o.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.y.b.AbstractC0726b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.o.a
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(137624);
                    float[] fArr = (float[]) objArr[0];
                    HashMap hashMap = new HashMap();
                    hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
                    hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
                    hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
                    AbstractC0726b.this.mqj.L(hashMap);
                    boolean a2 = k.a.mqW.a(AbstractC0726b.this.mqj, fVar);
                    AppMethodBeat.o(137624);
                    return a2;
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    Log.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                    return;
                }
                Log.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", Boolean.valueOf(this.mqi.l(fArr)));
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }
}
