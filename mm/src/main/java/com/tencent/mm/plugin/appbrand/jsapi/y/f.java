package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.jsapi.y.k;
import com.tencent.mm.plugin.appbrand.jsapi.y.l;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends d {
    public static final int CTRL_INDEX = 488;
    public static final String NAME = "enableGyroscope";

    public static final class a extends bc {
        private static final int CTRL_INDEX = 489;
        private static final String NAME = "onGyroscopeChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137638);
        final l lVar = new l(NAME);
        i.a a2 = lVar.a(fVar, jSONObject, new b(fVar) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(137636);
                h.b(fVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(137636);
            }
        }, "JsApi#SensorGyroscope" + fVar.hashCode(), new ArrayList(Arrays.asList(4)));
        fVar.i(i2, n(a2.errMsg, a2.values));
        AppMethodBeat.o(137638);
    }

    static abstract class b extends l.a implements SensorEventListener {
        a mqG = new a();
        private o mqi;
        private boolean mqm;

        b(final com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            this.mqG.h(fVar);
            this.mqi = new o((long) i.mqN.bID(), new o.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.y.f.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.o.a
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(137637);
                    float[] fArr = (float[]) objArr[0];
                    HashMap hashMap = new HashMap();
                    hashMap.put("x", Float.valueOf(fArr[0]));
                    hashMap.put("y", Float.valueOf(fArr[1]));
                    hashMap.put("z", Float.valueOf(fArr[2]));
                    b.this.mqG.L(hashMap);
                    boolean a2 = k.a.mqW.a(b.this.mqG, fVar);
                    AppMethodBeat.o(137637);
                    return a2;
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.mqm && sensorEvent.sensor.getType() == 4) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    Log.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
                    return;
                }
                Log.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", Boolean.valueOf(this.mqi.l(fArr)));
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public final void bIH() {
            this.mqm = true;
        }
    }
}
