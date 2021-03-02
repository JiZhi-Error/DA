package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
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

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 491;
    public static final String NAME = "enableDeviceMotionChangeListening";

    public static final class a extends bc {
        private static final int CTRL_INDEX = 490;
        private static final String NAME = "onDeviceMotionChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137631);
        final l lVar = new l(NAME);
        AnonymousClass1 r3 = new b(fVar) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(137629);
                h.b(fVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(137629);
            }
        };
        if (i.mqN.bIG()) {
            i.a a2 = lVar.a(fVar, jSONObject, r3, z(fVar), new ArrayList(Arrays.asList(11)));
            fVar.i(i2, n(a2.errMsg, a2.values));
            AppMethodBeat.o(137631);
            return;
        }
        i.a a3 = lVar.a(fVar, jSONObject, r3, z(fVar), new ArrayList(Arrays.asList(3)));
        fVar.i(i2, n(a3.errMsg, a3.values));
        AppMethodBeat.o(137631);
    }

    private static String z(f fVar) {
        AppMethodBeat.i(193695);
        String str = "JsApi#SensorDeviceMotion" + fVar.hashCode();
        AppMethodBeat.o(193695);
        return str;
    }

    static abstract class b extends l.a implements SensorEventListener {
        private o mqi;
        private boolean mqm;
        a mqu = new a();
        float[] mqv = new float[9];
        float[] mqw = new float[3];
        final double mqx = 6.283185307179586d;
        float[] values = new float[3];

        b(final f fVar) {
            this.mqu.h(fVar);
            this.mqi = new o((long) i.mqN.bID(), new o.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.y.d.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.o.a
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(137630);
                    float[] fArr = (float[]) objArr[0];
                    HashMap hashMap = new HashMap();
                    hashMap.put("alpha", Float.valueOf(fArr[0]));
                    hashMap.put("beta", Float.valueOf(fArr[1]));
                    hashMap.put("gamma", Float.valueOf(fArr[2]));
                    b.this.mqu.L(hashMap);
                    boolean a2 = k.a.mqW.a(b.this.mqu, fVar);
                    AppMethodBeat.o(137630);
                    return a2;
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.mqm) {
                if (i.mqN.bIG()) {
                    if (sensorEvent.sensor.getType() == 11) {
                        SensorManager.getRotationMatrixFromVector(this.mqv, sensorEvent.values);
                        SensorManager.getOrientation(this.mqv, this.mqw);
                        if (this.mqw[0] < 0.0f) {
                            float[] fArr = this.mqw;
                            fArr[0] = (float) (((double) fArr[0]) + 6.283185307179586d);
                        }
                        this.mqw[2] = -this.mqw[2];
                        this.values[0] = (float) Math.toDegrees((double) this.mqw[0]);
                        this.values[1] = (float) Math.toDegrees((double) this.mqw[1]);
                        this.values[2] = (float) Math.toDegrees((double) this.mqw[2]);
                        Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", Boolean.valueOf(this.mqi.l(this.values)));
                    }
                } else if (sensorEvent.sensor.getType() == 3) {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 == null || fArr2.length < 3) {
                        Log.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
                        return;
                    }
                    Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", Boolean.valueOf(this.mqi.l(fArr2)));
                }
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
