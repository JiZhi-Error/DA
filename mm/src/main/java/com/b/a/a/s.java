package com.b.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class s {
    private long ckD;
    float ckE;
    private ArrayList<String> ckF = new ArrayList<>();
    private ArrayList<float[]> ckG = new ArrayList<>();
    private ArrayList<double[]> ckH = new ArrayList<>();
    final d ckI;
    Handler ckJ;

    public s(d dVar) {
        AppMethodBeat.i(88004);
        this.ckI = dVar;
        AppMethodBeat.o(88004);
    }

    private void d(p pVar) {
        AppMethodBeat.i(88005);
        if (this.ckJ != null) {
            this.ckJ.post(new d(this, pVar, (byte) 0));
        }
        AppMethodBeat.o(88005);
    }

    /* access modifiers changed from: package-private */
    public static class e extends p {
        final int ckU;

        e(int i2) {
            super(8901);
            this.ckU = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class g extends p {
        final boolean ckV;

        g(boolean z) {
            super(8902);
            this.ckV = z;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private final p chs;

        private d(p pVar) {
            this.chs = pVar;
        }

        /* synthetic */ d(s sVar, p pVar, byte b2) {
            this(pVar);
        }

        public final void run() {
            AppMethodBeat.i(88002);
            s.this.ckI.c(this.chs);
            AppMethodBeat.o(88002);
        }
    }

    private static void writeLog(String str) {
        AppMethodBeat.i(88006);
        o.t("post_processing_log_" + y.cnu, str);
        AppMethodBeat.o(88006);
    }

    /* access modifiers changed from: package-private */
    public final void Jo() {
        AppMethodBeat.i(88007);
        z.b(null).execute(new c(this, (byte) 0));
        AppMethodBeat.o(88007);
    }

    class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(s sVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(88001);
            s.this.Jp();
            AppMethodBeat.o(88001);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void Jp() {
        AppMethodBeat.i(88008);
        try {
            bM(true);
            AppMethodBeat.o(88008);
        } catch (Exception e2) {
            AppMethodBeat.o(88008);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Jq() {
        AppMethodBeat.i(88009);
        this.ckD = 0;
        this.ckE = 0.0f;
        z.b(null).execute(new f(this, (byte) 0));
        AppMethodBeat.o(88009);
    }

    class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(s sVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(88003);
            s.this.reset();
            AppMethodBeat.o(88003);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void reset() {
        AppMethodBeat.i(88010);
        Jr();
        Js();
        AppMethodBeat.o(88010);
    }

    private synchronized void Jr() {
        AppMethodBeat.i(88011);
        this.ckH.clear();
        AppMethodBeat.o(88011);
    }

    private synchronized void Js() {
        AppMethodBeat.i(88012);
        this.ckF.clear();
        this.ckG.clear();
        AppMethodBeat.o(88012);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x026a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void bM(boolean r39) {
        /*
        // Method dump skipped, instructions count: 1304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.s.bM(boolean):void");
    }

    class a implements Runnable {
        final int cjR;
        final float ckK;
        final float ckL;
        final String ckM;
        final float x;
        final float y;

        private a(float f2, float f3, float f4, float f5, int i2, String str) {
            this.x = f2;
            this.y = f3;
            this.ckK = f4;
            this.ckL = f5;
            this.cjR = i2;
            this.ckM = str;
        }

        /* synthetic */ a(s sVar, float f2, float f3, float f4, float f5, int i2, String str, byte b2) {
            this(f2, f3, f4, f5, i2, str);
        }

        public final void run() {
            AppMethodBeat.i(87999);
            s.this.a(this.x, this.y, this.ckK, this.ckL, this.cjR, this.ckM);
            AppMethodBeat.o(87999);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(float f2, float f3, float f4, float f5, int i2, String str) {
        AppMethodBeat.i(88014);
        this.ckF.add(str);
        this.ckG.add(new float[]{f2, f3, f4, 0.0f, (float) i2, f5});
        if (this.ckF.size() > 256) {
            this.ckF.subList(0, 1).clear();
            this.ckF.trimToSize();
            if (this.ckG.size() > 256) {
                this.ckG.subList(0, 1).clear();
                this.ckG.trimToSize();
            }
        }
        AppMethodBeat.o(88014);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(double d2, double d3, double d4, float f2, double d5, double d6, double d7, long j2) {
        AppMethodBeat.i(88015);
        if (f2 < y.cny) {
            AppMethodBeat.o(88015);
            return false;
        } else if (j2 - this.ckD >= 1000 || f2 > this.ckE) {
            z.b(null).execute(new b(this, d2, d3, d4, (double) f2, d5, d6, d7, (double) j2, (byte) 0));
            this.ckD = j2;
            this.ckE = f2;
            AppMethodBeat.o(88015);
            return true;
        } else {
            AppMethodBeat.o(88015);
            return false;
        }
    }

    class b implements Runnable {
        final double ckO;
        final double ckP;
        final double ckQ;
        final double ckR;
        final double ckS;
        final double ckT;
        final double lat;
        final double lng;

        private b(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            this.lat = d2;
            this.lng = d3;
            this.ckO = d4;
            this.ckP = d5;
            this.ckQ = d6;
            this.ckR = d7;
            this.ckS = d8;
            this.ckT = d9;
        }

        /* synthetic */ b(s sVar, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, byte b2) {
            this(d2, d3, d4, d5, d6, d7, d8, d9);
        }

        public final void run() {
            AppMethodBeat.i(88000);
            s.this.a(this.lat, this.lng, this.ckO, this.ckP, this.ckQ, this.ckR, this.ckS, this.ckT);
            AppMethodBeat.o(88000);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        boolean z;
        AppMethodBeat.i(88016);
        int size = this.ckH.size();
        int size2 = this.ckF.size();
        if (size <= 0) {
            this.ckH.add(new double[]{d2, d3, d4, d5, d6, d7, d8, (double) size2, d9});
            z = true;
        } else {
            double[] dArr = this.ckH.get(size - 1);
            if (d9 - dArr[8] >= 30000.0d) {
                float[] fArr = new float[1];
                Location.distanceBetween(dArr[0], dArr[1], d2, d3, fArr);
                if (fArr[0] >= 30.0f) {
                    this.ckH.add(new double[]{d2, d3, d4, d5, d6, d7, d8, (double) size2, d9});
                    z = true;
                    if (size >= 8) {
                        this.ckH.subList(0, 1).clear();
                        this.ckH.trimToSize();
                    }
                    try {
                        bM(false);
                    } catch (Exception e2) {
                    }
                }
            } else if (d5 >= dArr[3]) {
                float[] fArr2 = {30.0f};
                if (size > 1) {
                    double[] dArr2 = this.ckH.get(size - 2);
                    Location.distanceBetween(dArr2[0], dArr2[1], d2, d3, fArr2);
                }
                if (fArr2[0] >= 30.0f) {
                    System.arraycopy(new double[]{d2, d3, d4, d5, d6, d7, d8, (double) size2, d9}, 0, dArr, 0, dArr.length);
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            int size3 = this.ckH.size();
            d(new e(size3));
            if (size3 == 1) {
                Js();
            }
        }
        AppMethodBeat.o(88016);
    }
}
