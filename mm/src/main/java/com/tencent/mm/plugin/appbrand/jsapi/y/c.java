package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
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

public final class c extends d {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";

    public static final class a extends bc {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137628);
        final l lVar = new l(NAME);
        i.a a2 = lVar.a(fVar, jSONObject, new b(fVar) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(137626);
                h.b(fVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(137626);
            }
        }, "JsApi#SensorMagneticField" + fVar.hashCode(), new ArrayList(Arrays.asList(2, 1)));
        fVar.i(i2, n(a2.errMsg, a2.values));
        AppMethodBeat.o(137628);
    }

    static abstract class b extends l.a implements SensorEventListener {
        private o mqi;
        private boolean mqm;
        private float[] mqn = new float[3];
        private float[] mqo = new float[3];
        private String mqp = "unknow";
        private int mqq = 0;
        a mqr = new a();

        b(final f fVar) {
            this.mqr.h(fVar);
            this.mqi = new o((long) i.mqN.bID(), new o.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.y.c.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.o.a
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(137627);
                    Log.v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, b.this.mqn, b.this.mqo);
                    SensorManager.getOrientation(fArr2, fArr);
                    HashMap hashMap = new HashMap();
                    float degrees = (float) Math.toDegrees((double) fArr[0]);
                    if (degrees < 0.0f) {
                        degrees += 360.0f;
                    }
                    hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(degrees));
                    if (b.this.mqp.equalsIgnoreCase("unknow")) {
                        hashMap.put("accuracy", b.this.mqp + "{value:" + b.this.mqq + "}");
                    } else {
                        hashMap.put("accuracy", b.this.mqp);
                    }
                    b.this.mqr.L(hashMap);
                    boolean a2 = k.a.mqW.a(b.this.mqr, fVar);
                    AppMethodBeat.o(137627);
                    return a2;
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.l.a
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.mqm) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    Log.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                    return;
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.mqo = sensorEvent.values;
                    switch (sensorEvent.accuracy) {
                        case -1:
                            this.mqp = "no-contact";
                            break;
                        case 0:
                            this.mqp = "unreliable";
                            break;
                        case 1:
                            this.mqp = "low";
                            break;
                        case 2:
                            this.mqp = FirebaseAnalytics.b.MEDIUM;
                            break;
                        case 3:
                            this.mqp = "high";
                            break;
                        default:
                            this.mqp = "unknow";
                            this.mqq = sensorEvent.accuracy;
                            break;
                    }
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.mqn = sensorEvent.values;
                } else {
                    return;
                }
                Log.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", Boolean.valueOf(this.mqi.l(new Object[0])));
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
