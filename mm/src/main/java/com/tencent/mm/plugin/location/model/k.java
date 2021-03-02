package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class k {
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.model.k.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(55700);
            if (!z) {
                AppMethodBeat.o(55700);
                return false;
            }
            if (!(k.this.yFQ == -1000.0d || k.this.yFR == -1000.0d)) {
                k.this.yFT = f.a(k.this.yFR, k.this.yFQ, (double) f2, (double) f3, i2, d2);
            }
            k.this.yFQ = (double) f3;
            k.this.yFR = (double) f2;
            if (k.this.yFP == 900.0d || k.this.yFO == 900.0d) {
                k kVar = k.this;
                k kVar2 = k.this;
                double h2 = f.h((double) f3, (double) f2);
                kVar2.yFO = h2;
                kVar.yFP = h2;
            } else {
                k.this.yFP = k.this.yFO;
                k.this.yFO = f.h((double) f3, (double) f2);
            }
            Log.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", Double.valueOf(k.this.yFO), Double.valueOf(k.this.yFP), Boolean.valueOf(k.this.yFT));
            AppMethodBeat.o(55700);
            return true;
        }
    };
    private d iOv;
    private SensorManager mSensorManager = ((SensorManager) MMApplicationContext.getContext().getSystemService("sensor"));
    private b yFM = new b();
    HashSet<WeakReference<a>> yFN = new HashSet<>();
    double yFO = 900.0d;
    double yFP = 900.0d;
    double yFQ = -1000.0d;
    double yFR = -1000.0d;
    double yFS = 0.0d;
    boolean yFT = false;

    public interface a {
        void w(double d2);
    }

    public k() {
        AppMethodBeat.i(55702);
        AppMethodBeat.o(55702);
    }

    /* access modifiers changed from: protected */
    public class b implements SensorEventListener {
        private float mbC = 0.0f;
        private long timestamp = 200;

        protected b() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f2;
            int i2 = 0;
            AppMethodBeat.i(55701);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float f3 = sensorEvent.values[0];
                if (f3 > 0.0f) {
                    f2 = f3 % 360.0f;
                } else {
                    f2 = (f3 + ((float) ((((((int) f3) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1))) % 360.0f;
                }
                if (currentTimeMillis > 200 && Math.abs(f2 - this.mbC) > 3.0f) {
                    k kVar = k.this;
                    float f4 = this.mbC;
                    kVar.yFS = (double) f2;
                    Object[] objArr = new Object[3];
                    objArr[0] = Float.valueOf(f4);
                    objArr[1] = Float.valueOf(f2);
                    if (kVar.yFN != null) {
                        i2 = kVar.yFN.size();
                    }
                    objArr[2] = Integer.valueOf(i2);
                    Log.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", objArr);
                    if (kVar.yFN != null) {
                        Iterator<WeakReference<a>> it = kVar.yFN.iterator();
                        while (it.hasNext()) {
                            WeakReference<a> next = it.next();
                            if (!(next == null || next.get() == null)) {
                                next.get().w(kVar.ecL());
                            }
                        }
                    }
                    this.mbC = f2;
                    this.timestamp = System.currentTimeMillis();
                }
            }
            AppMethodBeat.o(55701);
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    public final double ecL() {
        AppMethodBeat.i(55703);
        if (this.yFT) {
            Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", Double.valueOf(this.yFO));
            double d2 = this.yFO;
            AppMethodBeat.o(55703);
            return d2;
        }
        Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", Double.valueOf(this.yFS));
        double d3 = this.yFS;
        AppMethodBeat.o(55703);
        return d3;
    }

    private void cED() {
        AppMethodBeat.i(55704);
        Log.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.iOv == null) {
            this.iOv = d.bca();
        }
        this.iOv.b(this.gmA, true);
        this.mSensorManager.registerListener(this.yFM, this.mSensorManager.getDefaultSensor(3), 1);
        AppMethodBeat.o(55704);
    }

    /* access modifiers changed from: package-private */
    public final void ecM() {
        AppMethodBeat.i(55705);
        Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.mSensorManager.unregisterListener(this.yFM);
        d.bca().c(this.gmA);
        AppMethodBeat.o(55705);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(55706);
        Iterator<WeakReference<a>> it = this.yFN.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                AppMethodBeat.o(55706);
                return;
            }
        }
        this.yFN.add(new WeakReference<>(aVar));
        Log.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", Integer.valueOf(this.yFN.size()));
        if (this.yFN.size() == 1) {
            cED();
        }
        AppMethodBeat.o(55706);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(55707);
        if (this.yFN == null || aVar == null) {
            AppMethodBeat.o(55707);
            return;
        }
        Iterator<WeakReference<a>> it = this.yFN.iterator();
        while (true) {
            if (it.hasNext()) {
                WeakReference<a> next = it.next();
                if (next != null && next.get() != null && next.get().equals(aVar)) {
                    this.yFN.remove(next);
                    break;
                }
            } else {
                break;
            }
        }
        Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", Integer.valueOf(this.yFN.size()));
        if (this.yFN.size() == 0) {
            ecM();
        }
        AppMethodBeat.o(55707);
    }
}
