package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b implements SensorEventListener {
    final AtomicBoolean AEP = new AtomicBoolean(false);
    a AEQ = null;
    final Map<Integer, c> AER = new HashMap();
    final SensorManager mSensorManager = ((SensorManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("sensor"));

    public interface a {
        void hA(int i2, int i3);

        void p(int i2, List<com.tencent.mm.normsg.b> list);
    }

    public b(a aVar) {
        AppMethodBeat.i(187595);
        this.AEQ = aVar;
        AppMethodBeat.o(187595);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        ArrayList arrayList;
        boolean z2;
        AppMethodBeat.i(187596);
        try {
            int TO = com.tencent.mm.plugin.normsg.c.a.a.a.TO(sensorEvent.sensor.getType());
            c cVar = this.AER.get(Integer.valueOf(TO));
            if (cVar == null) {
                AppMethodBeat.o(187596);
                return;
            }
            if (sensorEvent == null || sensorEvent.values == null || sensorEvent.timestamp <= 0) {
                z = true;
            } else if (!cVar.AET) {
                cVar.AET = true;
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                long j2 = sensorEvent.timestamp / TimeUtil.SECOND_TO_US;
                long j3 = j2 - cVar.AEV;
                if (!com.tencent.mm.plugin.normsg.c.a.a.b.Hx(j3)) {
                    if (j3 == 20) {
                        cVar.a(sensorEvent);
                    } else {
                        if (0 != cVar.AES.timestamp) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            long j4 = cVar.AEV + 20;
                            if (Math.abs(j4 - cVar.AES.timestamp) < Math.abs(j4 - j2)) {
                                cVar.a(cVar.AES);
                            } else {
                                cVar.a(sensorEvent);
                            }
                        } else if (com.tencent.mm.plugin.normsg.c.a.a.b.Hy(j3)) {
                            cVar.a(sensorEvent);
                        } else {
                            cVar.AES.b(sensorEvent);
                        }
                    }
                }
            }
            if (cVar.AEU.size() < 20) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(cVar.AEU);
                cVar.AEU.clear();
                arrayList = arrayList2;
            }
            if (arrayList == null) {
                AppMethodBeat.o(187596);
                return;
            }
            this.AEQ.p(TO, arrayList);
            AppMethodBeat.o(187596);
        } catch (Throwable th) {
            Log.e("MicroMsg.NormsgSensorListener", "onSensorChanged() error:" + th.toString());
            AppMethodBeat.o(187596);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }
}
