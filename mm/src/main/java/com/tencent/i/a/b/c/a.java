package com.tencent.i.a.b.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.SparseArray;
import com.tencent.h.c.h;
import com.tencent.i.a.a.d;
import com.tencent.i.a.b.c.a.c;
import com.tencent.i.a.b.c.a.e;
import com.tencent.i.a.b.c.b.b;
import com.tencent.i.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a extends com.tencent.i.a.b.c.a.a implements SensorEventListener {
    private c Srl;
    private com.tencent.i.a.a.a Srm = new com.tencent.i.a.a.a("sensor_task") {
        /* class com.tencent.i.a.b.c.a.AnonymousClass1 */
    };
    private final SparseArray<com.tencent.i.a.b.c.b.a> Srn = new SparseArray<>();
    private final Object mLock = new Object();
    private SensorManager mSensorManager;

    public a(com.tencent.i.a.a.c cVar) {
        super(cVar);
        AppMethodBeat.i(214703);
        AppMethodBeat.o(214703);
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final int getTaskId() {
        return 0;
    }

    @Override // com.tencent.i.a.b.c.a.d, com.tencent.i.a.b.c.a.a
    public final boolean hqq() {
        AppMethodBeat.i(214705);
        if (this.Srn.size() <= 0) {
            AppMethodBeat.o(214705);
        } else {
            for (int i2 = 0; i2 < this.Srn.size(); i2++) {
                com.tencent.i.a.b.c.b.a valueAt = this.Srn.valueAt(i2);
                if (valueAt != null) {
                    List<g> hqt = valueAt.hqt();
                    h.i("sensor_SensorTask", "[method: notifyTaskDataPush ] controller getPointerSize : " + hqt.size());
                    kg(hqt);
                }
            }
            AppMethodBeat.o(214705);
        }
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final boolean Qt() {
        AppMethodBeat.i(214706);
        synchronized (this.mLock) {
            try {
                this.Srl = null;
            } catch (Throwable th) {
                AppMethodBeat.o(214706);
                throw th;
            }
        }
        h.i("sensor_SensorTask", "[method: unregisterSensor ] unregister sensor: " + Thread.currentThread().getName());
        if (this.mSensorManager == null || this.Srn.size() <= 0) {
            AppMethodBeat.o(214706);
        } else {
            for (int i2 = 0; i2 < this.Srn.size(); i2++) {
                com.tencent.i.a.b.c.b.a valueAt = this.Srn.valueAt(i2);
                if (!(valueAt == null || valueAt.pKK == null)) {
                    h.i("sensor_SensorTask", "[method: stop ] controller getPointerSize : " + valueAt.hqu());
                    this.mSensorManager.unregisterListener(this, valueAt.pKK);
                }
            }
            this.Srn.clear();
            AppMethodBeat.o(214706);
        }
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final void a(e eVar) {
        this.Srl = (c) eVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        b bVar;
        AppMethodBeat.i(214707);
        try {
            int type = sensorEvent.sensor.getType();
            com.tencent.i.a.b.c.b.a aVar = this.Srn.get(type);
            if (aVar == null) {
                AppMethodBeat.o(214707);
                return;
            }
            if (sensorEvent == null) {
                h.i("sensor_EventController", "[method: isFilterEvent ] ");
                z = true;
            } else if (sensorEvent.timestamp <= 0 || !aVar.BTt) {
                aVar.BTt = true;
                h.i("sensor_EventController", "[method: isFilterEvent ] " + sensorEvent.timestamp);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar = null;
            } else {
                if (aVar.Sru <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    bVar = com.tencent.i.a.b.c.b.a.a(sensorEvent, aVar.hqs());
                } else {
                    long OJ = aVar.OJ(sensorEvent.timestamp);
                    long j2 = OJ - aVar.Sry;
                    boolean z4 = false;
                    if (j2 < ((long) aVar.Sru) - 5) {
                        z4 = true;
                    }
                    if (z4) {
                        bVar = null;
                    } else {
                        if (((long) aVar.Sru) == j2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            bVar = com.tencent.i.a.b.c.b.a.a(sensorEvent, aVar.hqs());
                        } else {
                            boolean z5 = false;
                            if (!(aVar.Srw == null || aVar.Srw.timestamp == 0)) {
                                z5 = true;
                            }
                            if (z5) {
                                long j3 = aVar.Sry + ((long) aVar.Sru);
                                if (Math.abs(j3 - aVar.OJ(aVar.hqs().timestamp)) < Math.abs(j3 - OJ)) {
                                    bVar = aVar.hqs();
                                } else {
                                    bVar = com.tencent.i.a.b.c.b.a.a(sensorEvent, aVar.hqs());
                                }
                            } else {
                                boolean z6 = false;
                                if (j2 > ((long) aVar.Sru) + 5) {
                                    z6 = true;
                                }
                                if (z6) {
                                    bVar = com.tencent.i.a.b.c.b.a.a(sensorEvent, aVar.hqs());
                                } else {
                                    com.tencent.i.a.b.c.b.a.a(sensorEvent, aVar.hqs());
                                    bVar = null;
                                }
                            }
                        }
                    }
                }
            }
            if (bVar != null) {
                g gVar = null;
                switch (type) {
                    case 1:
                        gVar = new g();
                        gVar.RNh = 0;
                        gVar.Ekw = bVar.values[0] / 9.8f;
                        gVar.Ekx = bVar.values[1] / 9.8f;
                        gVar.Eky = bVar.values[2] / 9.8f;
                        break;
                    case 2:
                        gVar = new g();
                        gVar.RNh = 5;
                        gVar.Ekw = bVar.values[0];
                        gVar.Ekx = bVar.values[1];
                        gVar.Eky = bVar.values[2];
                        break;
                    case 4:
                        gVar = new g();
                        gVar.RNh = 2;
                        gVar.Ekw = bVar.values[0];
                        gVar.Ekx = bVar.values[1];
                        gVar.Eky = bVar.values[2];
                        break;
                    case 5:
                        gVar = new g();
                        gVar.RNh = 1;
                        gVar.Ekw = bVar.values[0];
                        break;
                    case 8:
                        gVar = new g();
                        gVar.RNh = 3;
                        gVar.Ekw = bVar.values[0];
                        break;
                    case 9:
                        gVar = new g();
                        gVar.RNh = 4;
                        gVar.Ekw = bVar.values[0] / 9.8f;
                        gVar.Ekx = bVar.values[1] / 9.8f;
                        gVar.Eky = (-bVar.values[2]) / 9.8f;
                        break;
                    case 19:
                        gVar = new g();
                        gVar.RNh = 6;
                        gVar.Ekw = bVar.values[0];
                        break;
                }
                if (gVar != null) {
                    gVar.RNA = aVar.OJ(bVar.timestamp);
                    if (gVar != null) {
                        aVar.Srx.add(gVar);
                        aVar.Sry = gVar.RNA;
                    }
                    if (aVar.hqu() >= 5) {
                        kg(aVar.hqt());
                    }
                }
                if (bVar != null) {
                    bVar.values[0] = Float.NaN;
                    bVar.values[1] = Float.NaN;
                    bVar.values[2] = Float.NaN;
                    bVar.timestamp = 0;
                }
            }
            AppMethodBeat.o(214707);
        } catch (Throwable th) {
            this.SqM.SqP.b(th, "onSensorChanged");
            AppMethodBeat.o(214707);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    private void kg(List<g> list) {
        AppMethodBeat.i(214708);
        synchronized (this.mLock) {
            try {
                if (!(this.Srl == null || list == null || list.isEmpty())) {
                    this.Srl.kf(list);
                }
            } finally {
                AppMethodBeat.o(214708);
            }
        }
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final boolean hqp() {
        int[] iArr;
        AppMethodBeat.i(214704);
        int[] iArr2 = d.SqU;
        if (iArr2.length <= 0) {
            iArr = d.SqT;
        } else {
            iArr = iArr2;
        }
        int i2 = this.SqM.SqN.hqa().Sqy;
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) this.SqM.mAppContext.getSystemService("sensor");
        }
        this.Srn.clear();
        h.i("sensor_SensorTask", "[method: registerSensor ] begin register sensor");
        for (int i3 : iArr) {
            boolean z = Build.VERSION.SDK_INT < 9 && i3 == 9;
            if (Build.VERSION.SDK_INT < 19 && i3 == 19) {
                z = true;
            }
            if (!z) {
                Sensor defaultSensor = this.mSensorManager.getDefaultSensor(i3);
                h.i("sensor_SensorTask", new StringBuilder("[method: registerSensor ] sensor is null ? ").append(defaultSensor == null).toString());
                if (defaultSensor != null) {
                    this.Srn.put(i3, new com.tencent.i.a.b.c.b.a(defaultSensor, i2));
                    this.mSensorManager.registerListener(this, defaultSensor, 0, this.Srm.Son);
                }
            }
        }
        h.i("sensor_SensorTask", "[method: registerSensor ] register completed");
        AppMethodBeat.o(214704);
        return true;
    }
}
