package com.tencent.e.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g {
    private static final int[] RMX = {1, 4, 9};
    private final HashSet<Sensor> RMV = new HashSet<>();
    public final SparseArray<i> RMW = new SparseArray<>();
    public a RMY = new a();
    private final SensorManager mSensorManager = ((SensorManager) MMApplicationContext.getContext().getSystemService("sensor"));

    public class a implements SensorEventListener {
        long RMO = 0;
        final AtomicBoolean RMZ = new AtomicBoolean(false);
        int RNa = 0;
        long RNb = 0;

        a() {
            AppMethodBeat.i(138396);
            AppMethodBeat.o(138396);
        }

        public final long hkI() {
            long j2;
            synchronized (this.RMZ) {
                j2 = this.RMO;
            }
            return j2;
        }

        public final long hkJ() {
            long j2;
            synchronized (this.RMZ) {
                j2 = this.RNb;
            }
            return j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
            if (r10.sensor != null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(138397);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r2 = new com.tencent.e.e.a.a.j(r10, java.lang.System.currentTimeMillis());
            r1 = r9.RMZ;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4 = r2.timestamp - r9.RMO;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (r4 >= 0) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
            r1 = r2.RNh;
            r3 = (int) (r4 / com.tencent.e.e.a.a.f.RMS);
            r4 = r9.RNc.RMW;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r0 = (com.tencent.e.e.a.a.i) r9.RNc.RMW.get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
            if (r0 != null) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
            r0 = new com.tencent.e.e.a.a.i(r1, com.tencent.e.e.a.a.f.RMT, r9.RNa);
            r9.RNc.RMW.put(r1, r0);
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0074, code lost:
            if (r3 >= r1.dpI) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
            if (r3 <= r1.acm) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
            r5 = r3 / r1.RNg;
            r0 = (java.util.List) r1.OW[r5];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
            if (r0 != null) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
            r0 = new java.util.ArrayList();
            r1.OW[r5] = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
            r0.add(r2);
            r1.acm = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(138397);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a0, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a2, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(138397);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a5, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a6, code lost:
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r10 == null) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSensorChanged(android.hardware.SensorEvent r10) {
            /*
            // Method dump skipped, instructions count: 168
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.e.e.a.a.g.a.onSensorChanged(android.hardware.SensorEvent):void");
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    public g() {
        AppMethodBeat.i(138398);
        AppMethodBeat.o(138398);
    }

    public final synchronized boolean Ox(long j2) {
        boolean z;
        AppMethodBeat.i(138399);
        if (this.mSensorManager == null) {
            AppMethodBeat.o(138399);
            z = false;
        } else {
            a aVar = this.RMY;
            synchronized (aVar.RMZ) {
                try {
                    if (!aVar.RMZ.get()) {
                        aVar.RMZ.set(true);
                        aVar.RMO = System.currentTimeMillis();
                        aVar.RNa = (int) Math.ceil(((double) j2) / ((double) f.RMS));
                    }
                } finally {
                    AppMethodBeat.o(138399);
                }
            }
            synchronized (this.RMV) {
                try {
                    this.RMV.clear();
                } finally {
                    AppMethodBeat.o(138399);
                }
            }
            synchronized (this.RMV) {
                try {
                    z = false;
                    for (int i2 : RMX) {
                        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(i2);
                        if (defaultSensor != null && this.mSensorManager.registerListener(this.RMY, defaultSensor, 0)) {
                            this.RMV.add(defaultSensor);
                            z = true;
                        }
                    }
                } finally {
                    AppMethodBeat.o(138399);
                }
            }
            if (!z) {
                hkG();
            }
        }
        return z;
    }

    public final synchronized void hkG() {
        AppMethodBeat.i(138400);
        if (this.mSensorManager == null) {
            AppMethodBeat.o(138400);
        } else {
            synchronized (this.RMV) {
                try {
                    Iterator<Sensor> it = this.RMV.iterator();
                    while (it.hasNext()) {
                        this.mSensorManager.unregisterListener(this.RMY, it.next());
                    }
                    this.RMV.clear();
                } finally {
                    AppMethodBeat.o(138400);
                }
            }
            a aVar = this.RMY;
            synchronized (aVar.RMZ) {
                try {
                    if (aVar.RMZ.get()) {
                        aVar.RMZ.set(false);
                        aVar.RNb = System.currentTimeMillis() - aVar.RMO;
                        if (aVar.RNb < 0) {
                            aVar.RNb = 0;
                        }
                        aVar.RMO = 0;
                        AppMethodBeat.o(138400);
                    }
                } finally {
                    AppMethodBeat.o(138400);
                }
            }
        }
    }

    public final SparseArray<i> hkH() {
        AppMethodBeat.i(138401);
        synchronized (this.RMW) {
            try {
                SparseArray<i> sparseArray = new SparseArray<>();
                for (int i2 = 0; i2 < this.RMW.size(); i2++) {
                    sparseArray.append(this.RMW.keyAt(i2), this.RMW.valueAt(i2));
                }
                if (h(sparseArray)) {
                    return sparseArray;
                }
                SparseArray<i> sparseArray2 = new SparseArray<>();
                AppMethodBeat.o(138401);
                return sparseArray2;
            } finally {
                AppMethodBeat.o(138401);
            }
        }
    }

    private static boolean h(SparseArray<i> sparseArray) {
        Object[] hkM;
        AppMethodBeat.i(138402);
        if (sparseArray.size() == 0) {
            AppMethodBeat.o(138402);
            return false;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            i valueAt = sparseArray.valueAt(i2);
            if (!(valueAt == null || (hkM = valueAt.hkM()) == null || hkM.length == 0)) {
                int i3 = 0;
                for (int i4 = 0; i4 < valueAt.OW.length; i4++) {
                    if (((List) valueAt.OW[i4]) != null) {
                        i3++;
                    }
                }
                if (i3 < 3) {
                    AppMethodBeat.o(138402);
                    return false;
                }
                for (Object obj : hkM) {
                    List list = (List) obj;
                    if (list != null && list.size() < f.RMT / 2) {
                        AppMethodBeat.o(138402);
                        return false;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(138402);
        return true;
    }
}
