package com.b.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import com.b.a.a.d;
import com.b.a.a.j;
import com.b.a.a.k;
import com.b.a.a.r;
import com.b.a.a.s;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Array;
import java.util.List;

/* access modifiers changed from: package-private */
public class n extends b {
    private final i cjA;
    final s cjB;
    private long cjC;
    private long cjD;
    private long cjE;
    private int cjF;
    private long cjG;
    private boolean cjH;
    private Location cjI;
    private int cjJ;
    private float cjK;
    private float cjL;
    private float cjM;
    private int cjN;
    private int cjO;
    private long cjP;
    private final e cjx = new e(this, (byte) 0);
    final j cjy = new j();
    private final d cjz = new d((byte) 0);

    n() {
        AppMethodBeat.i(88030);
        if (i.chY == null) {
            i.chY = new i();
        }
        this.cjA = i.chY;
        this.cjH = true;
        this.cjB = new s(this);
        AppMethodBeat.o(88030);
    }

    /* access modifiers changed from: package-private */
    public class e {
        long cjY;
        boolean cjZ;

        private e() {
            this.cjZ = y.cns;
        }

        /* synthetic */ e(n nVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void bK(boolean z) {
            AppMethodBeat.i(88028);
            if (this.cjZ ^ z) {
                this.cjZ = !this.cjZ;
                n.this.cjB.Jo();
                n.this.cjB.Jq();
                n.this.cjy.bK(this.cjZ);
                n.this.Jd();
                if (y.cnn) {
                    String str = "vehicle mode: " + (this.cjZ ? "enable" : "disable");
                    o.t("filter_input_log_" + y.cnu, str);
                    o.t("filter_output_log_" + y.cnu, str);
                }
            }
            AppMethodBeat.o(88028);
        }

        static /* synthetic */ void a(e eVar) {
            AppMethodBeat.i(88029);
            eVar.reset();
            AppMethodBeat.o(88029);
        }

        private void reset() {
            this.cjY = 0;
            this.cjZ = y.cns;
        }
    }

    private boolean a(long j2, int i2, double d2, double d3, double d4, float f2, int i3, float f3) {
        boolean z;
        AppMethodBeat.i(88031);
        long j3 = j2 / 1000;
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        if (this.cjH) {
            this.cjy.a(j3, radians, radians2, f2, this.cjx.cjZ, y.cnt);
            this.cjH = false;
            z = true;
        } else {
            z = false;
        }
        j.a aVar = new j.a(i2, (double) j3, radians, radians2, d4, (double) f2, i3, (double) f3, 0, 0.0d, 0.0d);
        this.cjy.a(aVar);
        if (y.cnn) {
            o.t("filter_input_log_" + y.cnu, aVar.toString());
        }
        AppMethodBeat.o(88031);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void Jd() {
        this.cjH = true;
        this.cjI = null;
        this.cjJ = 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public final void a(List<ScanResult> list, long j2, long j3) {
        boolean z;
        String str;
        AppMethodBeat.i(88032);
        long aM = aa.aM(j2);
        if (this.cjD == 0 || j3 - this.cjD >= this.cjC) {
            z = true;
        } else {
            z = false;
        }
        String a2 = v.a(list, z);
        String a3 = this.cjz.a(a2, j3, z);
        if (z) {
            r Jg = r.Jg();
            int i2 = this.cjO;
            if (a3 != null) {
                if (Jg.isRunning) {
                    if (Jg.Ji()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (Jg.ckn != null) {
                            Jg.ckn.execute(new r.e(Jg, a3, currentTimeMillis, elapsedRealtime, i2));
                        }
                    } else {
                        Jg.Jh();
                    }
                }
                long aM2 = aa.aM(System.currentTimeMillis());
                if (Jg.ckn != null) {
                    Jg.ckn.execute(new r.c(Jg, a3, aM2, 0, (byte) 0));
                }
            }
        } else {
            r.Jg().cB(v.b(a3, aM, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
        if (d.o(j3, this.cjE)) {
            if (!z) {
                str = a2;
            } else {
                str = null;
            }
            if (str == null) {
                str = v.a(list, false);
            }
            String b2 = v.b(str, aM, "2");
            s sVar = this.cjB;
            float f2 = this.cjK;
            float f3 = this.cjL;
            float f4 = this.cjM;
            float f5 = (float) this.cjN;
            int i3 = this.cjF;
            if (sVar.ckE != 0.0f) {
                z.b(null).execute(new s.a(sVar, f2, f3, f4, f5, i3, b2, (byte) 0));
            }
        }
        AppMethodBeat.o(88032);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public final void a(float f2, float f3, int i2, float f4, float f5, float f6, long j2) {
        int i3;
        boolean z;
        double d2;
        String str;
        AppMethodBeat.i(88034);
        e eVar = this.cjx;
        if (j2 - eVar.cjY > 5000) {
            eVar.bK(false);
        }
        if (j2 - this.cjE > 5000) {
            Je();
        }
        this.cjK = f2;
        this.cjL = f3;
        this.cjM = f5;
        this.cjN = i2;
        this.cjE = j2;
        if (f6 > 0.0f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        this.cjO = i3;
        if (this.cjD != 0 || j2 - this.cjP >= 30000) {
            boolean z2 = i3 == 0;
            if (!z2 || !this.cjx.cjZ) {
                ab.JD().bJ(z2);
                k.Jc().bJ(z2);
            }
        }
        double[] dArr = new double[2];
        i iVar = this.cjA;
        double[] dArr2 = {(double) f2, (double) f3};
        if (iVar.cif) {
            dArr[0] = iVar.chZ;
            dArr[1] = iVar.cia;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) iVar.anchorY))) / ((double) iVar.cid));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) iVar.anchorX))) / ((double) iVar.cie));
            if (dArr[0] > 90.0d) {
                dArr[0] = 180.0d - dArr[0];
            } else if (dArr[0] < -90.0d) {
                dArr[0] = -180.0d - dArr[0];
            }
            if (dArr[1] > 180.0d) {
                dArr[1] = dArr[1] - 360.0d;
            } else if (dArr[1] < -180.0d) {
                dArr[1] = dArr[1] + 360.0d;
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(88034);
            return;
        }
        double d3 = dArr[0];
        double d4 = dArr[1];
        i iVar2 = this.cjA;
        float f7 = ((f5 - iVar2.cib) / 10.0f) + iVar2.cic;
        float f8 = 0.0f;
        Location location = new Location("S");
        location.setLatitude(d3);
        location.setLongitude(d4);
        if (this.cjI != null) {
            f8 = this.cjI.bearingTo(location);
        }
        this.cjI = location;
        int max = Math.max(0, i2 - this.cjJ);
        this.cjJ = i2;
        j.a aVar = new j.a(3, (double) (j2 / 1000), Math.toRadians(d3), Math.toRadians(d4), 0.0d, (double) f7, 0, (double) f6, max, (double) f4, Math.toRadians((double) f8));
        this.cjy.a(aVar);
        if (y.cnn) {
            o.t("filter_input_log_" + y.cnu, aVar.toString());
        }
        double[] dArr3 = new double[4];
        long j3 = j2 / 1000;
        double[] dArr4 = new double[2];
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
        j jVar = this.cjy;
        double d5 = ((double) j3) - jVar.cih.cij;
        double d6 = d5 * d5;
        double[] dArr7 = new double[2];
        double[] dArr8 = {jVar.cih.ciS[0] + (jVar.cih.ciS[2] * d5), (d5 * jVar.cih.ciS[3]) + jVar.cih.ciS[1]};
        double[] dArr9 = {jVar.cih.ciS[2], jVar.cih.ciS[3]};
        if (jVar.cih.ciA) {
            dArr7[0] = dArr8[0] - jVar.cih.ciB[0];
            dArr7[1] = dArr8[1] - jVar.cih.ciB[1];
            double sqrt = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
            d2 = sqrt * sqrt * jVar.cih.ciV;
        } else {
            d2 = 0.0d;
        }
        dArr5[0][0] = jVar.cih.ciT[0][0] + (jVar.cih.ciT[2][2] * d6) + d2;
        dArr5[0][1] = jVar.cih.ciT[0][1] + (jVar.cih.ciT[2][3] * d6);
        dArr5[1][0] = jVar.cih.ciT[1][0] + (jVar.cih.ciT[3][2] * d6);
        dArr5[1][1] = d2 + (d6 * jVar.cih.ciT[3][3]) + jVar.cih.ciT[1][1];
        dArr6[0][0] = jVar.cih.ciT[2][2];
        dArr6[0][1] = jVar.cih.ciT[2][3];
        dArr6[1][0] = jVar.cih.ciT[3][2];
        dArr6[1][1] = jVar.cih.ciT[3][3];
        jVar.a(1, dArr8, dArr4);
        dArr3[0] = Math.toDegrees(dArr4[0]);
        dArr3[1] = Math.toDegrees(dArr4[1]);
        dArr3[2] = Math.sqrt((dArr5[0][0] + dArr5[1][1]) / 2.0d);
        dArr3[3] = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
        if (y.cnn) {
            o.t("filter_output_log_" + y.cnu, String.valueOf(String.valueOf(j3)) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
        }
        double d7 = dArr3[0];
        double d8 = dArr3[1];
        int intValue = Double.valueOf(dArr3[2]).intValue();
        int intValue2 = Double.valueOf(dArr3[3]).intValue();
        int i4 = this.cjF;
        if (!v.b(d7, d8)) {
            str = "";
        } else {
            str = String.valueOf("&SD=") + d7 + ',' + d8 + ',' + 0 + ',' + intValue + ',' + i4 + ',' + 0 + ',' + intValue2 + ',' + 0 + ',' + 0 + ',' + 0;
        }
        this.cjz.n(str, j2);
        c(new a(d7, d8, intValue, this.cjF, this.cjG));
        AppMethodBeat.o(88034);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public final void a(double d2, double d3, int i2, int i3, int i4, int i5, int i6, float f2, long j2, long j3) {
        String str;
        AppMethodBeat.i(88035);
        if (i3 <= 0) {
            AppMethodBeat.o(88035);
            return;
        }
        e eVar = this.cjx;
        if (i4 >= 3) {
            if (j3 - eVar.cjY <= 5000) {
                eVar.bK(true);
            }
            eVar.cjY = j3;
        }
        int round = Math.round(f2);
        if (!v.b(d2, d3)) {
            str = "";
        } else {
            str = String.valueOf("&GD=") + d2 + ',' + d3 + ',' + i2 + ',' + i4 + ',' + i6 + ',' + i3 + ',' + round + ',' + j2 + ',';
        }
        this.cjz.m(str, j3);
        if (a(j3, 1, d2, d3, (double) i2, (float) i3, i6, (float) i4)) {
            this.cjA.a(d2, d3, (float) i3, this.cjK, this.cjL, this.cjM);
        }
        if (d.o(j3, this.cjE)) {
            this.cjB.a(d2, d3, (double) i3, f2, (double) this.cjK, (double) this.cjL, (double) this.cjM, j3);
        }
        if (y.cnn) {
            o.t("gps_log_" + y.cnu, String.valueOf(String.valueOf(d2)) + ',' + d3 + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + i6 + ',' + f2 + ',' + j2);
        }
        AppMethodBeat.o(88035);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public void a(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(88036);
        c(new b(i2, str, (byte) 0));
        if (i2 == -4 || i2 == -5) {
            stop();
        }
        AppMethodBeat.o(88036);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final synchronized void stop() {
        AppMethodBeat.i(88038);
        this.cjB.Jo();
        super.stop();
        AppMethodBeat.o(88038);
    }

    private void Je() {
        AppMethodBeat.i(88039);
        this.cjA.cif = false;
        this.cjB.Jq();
        this.cjz.reset();
        e.a(this.cjx);
        Jd();
        this.cjD = 0;
        this.cjE = SystemClock.elapsedRealtime();
        this.cjK = 0.0f;
        this.cjL = 0.0f;
        this.cjM = 0.0f;
        this.cjN = 0;
        this.cjO = 0;
        this.cjF = 0;
        AppMethodBeat.o(88039);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public final k.a a(d.a aVar) {
        AppMethodBeat.i(88040);
        k.a aVar2 = new k.a(0);
        AppMethodBeat.o(88040);
        return aVar2;
    }

    static class c extends d.a {
        final long cjT;

        c(long j2, long j3) {
            super(Math.max(j2, 3000L));
            AppMethodBeat.i(88025);
            this.cjT = j3;
            AppMethodBeat.o(88025);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        private String cjU;
        private long cjV;
        private String cjW;
        private long cjX;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized String a(String str, long j2, boolean z) {
            String str2;
            AppMethodBeat.i(88026);
            if (z) {
                if (this.cjU != null && o(j2, this.cjV)) {
                    str = String.valueOf(str) + this.cjU;
                    this.cjU = null;
                }
                str2 = str;
                if (this.cjW != null && o(j2, this.cjX)) {
                    str2 = String.valueOf(str2) + this.cjW;
                    this.cjW = null;
                }
            } else {
                if (this.cjU != null && o(j2, this.cjV)) {
                    str = String.valueOf(str) + v.cG(this.cjU);
                    this.cjU = null;
                }
                str2 = str;
                if (this.cjW != null && o(j2, this.cjX)) {
                    str2 = String.valueOf(str2) + v.cF(this.cjW);
                    this.cjW = null;
                }
            }
            AppMethodBeat.o(88026);
            return str2;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void m(String str, long j2) {
            this.cjU = str;
            this.cjV = j2;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void n(String str, long j2) {
            this.cjW = str;
            this.cjX = j2;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            this.cjU = null;
            this.cjW = null;
            this.cjV = 0;
            this.cjX = 0;
        }

        static boolean o(long j2, long j3) {
            AppMethodBeat.i(88027);
            if (Math.abs(j2 - j3) <= 10000) {
                AppMethodBeat.o(88027);
                return true;
            }
            AppMethodBeat.o(88027);
            return false;
        }
    }

    static class a extends p {
        final int cjQ;
        final int cjR;
        final long cjS;
        final double lat;
        final double lng;

        a(double d2, double d3, int i2, int i3, long j2) {
            super(9901);
            this.lat = d2;
            this.lng = d3;
            this.cjQ = i2;
            this.cjR = i3;
            this.cjS = j2;
        }
    }

    static class b extends p {
        final boolean authResult;
        final int code;
        final String message;

        private b(int i2, String str) {
            super(9902);
            this.code = i2;
            this.message = str;
            this.authResult = false;
        }

        b(int i2, String str, byte b2) {
            this(i2, str);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.b
    public void a(x xVar, long j2, long j3) {
        AppMethodBeat.i(88033);
        this.cjD = xVar.ckz;
        this.cjF = xVar.level;
        this.cjG = xVar.cjS;
        if (xVar.provider.equals(QLog.TAG_REPORTLEVEL_COLORUSER) && a(j3, 2, xVar.latitude, xVar.longitude, xVar.altitude, xVar.cjn, xVar.cne, xVar.bdN)) {
            this.cjA.a(xVar.latitude, xVar.longitude, xVar.cjn, this.cjK, this.cjL, this.cjM);
        }
        if (!u.Jx().clx) {
            c(new a(xVar.latitude, xVar.longitude, Float.valueOf(xVar.cjn).intValue(), this.cjF, this.cjG));
        }
        AppMethodBeat.o(88033);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d, com.b.a.a.b
    public synchronized void a(Handler handler, d.a aVar) {
        c cVar;
        AppMethodBeat.i(88037);
        if (aVar instanceof c) {
            cVar = (c) aVar;
        } else {
            cVar = new c(aVar != null ? aVar.chx : 5000, 9000);
        }
        this.cjC = cVar.cjT;
        Je();
        this.cjB.ckJ = handler;
        this.cjP = SystemClock.elapsedRealtime();
        super.a(handler, cVar);
        AppMethodBeat.o(88037);
    }
}
