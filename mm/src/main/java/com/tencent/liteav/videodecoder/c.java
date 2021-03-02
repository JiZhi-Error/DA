package com.tencent.liteav.videodecoder;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

class c {

    /* renamed from: a  reason: collision with root package name */
    protected a f1216a = new a(50);

    /* renamed from: b  reason: collision with root package name */
    int f1217b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f1218c;

    /* renamed from: d  reason: collision with root package name */
    private int f1219d;

    /* renamed from: e  reason: collision with root package name */
    private int f1220e;

    /* renamed from: f  reason: collision with root package name */
    private final OutputStream f1221f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f1222g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private int f1223h;

    public c(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(222613);
        this.f1218c = inputStream;
        this.f1221f = outputStream;
        this.f1219d = inputStream.read();
        this.f1220e = inputStream.read();
        AppMethodBeat.o(222613);
    }

    public boolean a(boolean z) {
        AppMethodBeat.i(222614);
        if (b(z) == 1) {
            AppMethodBeat.o(222614);
            return true;
        }
        AppMethodBeat.o(222614);
        return false;
    }

    public int b(boolean z) {
        int i2 = -1;
        AppMethodBeat.i(222615);
        if (this.f1217b == 8) {
            d();
            if (this.f1219d == -1) {
                AppMethodBeat.o(222615);
                return i2;
            }
        }
        i2 = (this.f1219d >> (7 - this.f1217b)) & 1;
        this.f1217b++;
        if (z && this.f1221f != null) {
            d(i2);
        }
        AppMethodBeat.o(222615);
        return i2;
    }

    public long a(int i2) {
        AppMethodBeat.i(222616);
        if (i2 > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
            AppMethodBeat.o(222616);
            throw illegalArgumentException;
        }
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 1) | ((long) b(true));
        }
        AppMethodBeat.o(222616);
        return j2;
    }

    public void b(int i2) {
        AppMethodBeat.i(222617);
        if (i2 > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
            AppMethodBeat.o(222617);
            throw illegalArgumentException;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            b(true);
        }
        AppMethodBeat.o(222617);
    }

    private void d() {
        AppMethodBeat.i(222618);
        this.f1219d = this.f1220e;
        this.f1220e = this.f1218c.read();
        this.f1217b = 0;
        AppMethodBeat.o(222618);
    }

    public long a(int i2, String str) {
        AppMethodBeat.i(222619);
        long a2 = a(i2);
        a(str, String.valueOf(a2));
        AppMethodBeat.o(222619);
        return a2;
    }

    public void b(int i2, String str) {
        AppMethodBeat.i(222620);
        b(i2);
        a(str, "skip NBits");
        AppMethodBeat.o(222620);
    }

    private int e() {
        int i2 = 0;
        AppMethodBeat.i(222621);
        int i3 = 0;
        while (b(true) == 0) {
            i3++;
        }
        if (i3 > 0) {
            i2 = (int) (((long) ((1 << i3) - 1)) + a(i3));
        }
        AppMethodBeat.o(222621);
        return i2;
    }

    private void f() {
        AppMethodBeat.i(222622);
        int i2 = 0;
        while (b(true) == 0) {
            i2++;
        }
        if (i2 > 0) {
            b(i2);
        }
        AppMethodBeat.o(222622);
    }

    public int a(String str) {
        AppMethodBeat.i(222623);
        int e2 = e();
        a(str, String.valueOf(e2));
        AppMethodBeat.o(222623);
        return e2;
    }

    public void b(String str) {
        AppMethodBeat.i(222624);
        f();
        a(str, "skip UE");
        AppMethodBeat.o(222624);
    }

    public int c(String str) {
        AppMethodBeat.i(222625);
        int e2 = e();
        int i2 = ((e2 & 1) + (e2 >> 1)) * (((e2 & 1) << 1) - 1);
        a(str, String.valueOf(i2));
        AppMethodBeat.o(222625);
        return i2;
    }

    public boolean d(String str) {
        AppMethodBeat.i(222626);
        boolean a2 = a(true);
        a(str, a2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(222626);
        return a2;
    }

    public boolean e(String str) {
        AppMethodBeat.i(222627);
        boolean a2 = a(false);
        a(str, a2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(222627);
        return a2;
    }

    public void c(int i2) {
        AppMethodBeat.i(222628);
        int[] iArr = new int[i2];
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((c("deltaScale") + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i5] = i4;
            i4 = iArr[i5];
        }
        AppMethodBeat.o(222628);
    }

    public void a() {
        AppMethodBeat.i(222629);
        for (int i2 = this.f1223h; i2 < 8; i2++) {
            this.f1222g[i2] = 0;
        }
        this.f1223h = 0;
        g();
        AppMethodBeat.o(222629);
    }

    private void g() {
        AppMethodBeat.i(222630);
        this.f1221f.write((this.f1222g[0] << 7) | (this.f1222g[1] << 6) | (this.f1222g[2] << 5) | (this.f1222g[3] << 4) | (this.f1222g[4] << 3) | (this.f1222g[5] << 2) | (this.f1222g[6] << 1) | this.f1222g[7]);
        AppMethodBeat.o(222630);
    }

    public void d(int i2) {
        AppMethodBeat.i(222631);
        if (this.f1223h == 8) {
            this.f1223h = 0;
            g();
        }
        int[] iArr = this.f1222g;
        int i3 = this.f1223h;
        this.f1223h = i3 + 1;
        iArr[i3] = i2;
        AppMethodBeat.o(222631);
    }

    public void a(long j2, int i2) {
        AppMethodBeat.i(222632);
        for (int i3 = 0; i3 < i2; i3++) {
            d(((int) (j2 >> ((i2 - i3) - 1))) & 1);
        }
        AppMethodBeat.o(222632);
    }

    public void b() {
        AppMethodBeat.i(222633);
        a(0, 8 - this.f1223h);
        AppMethodBeat.o(222633);
    }

    public void e(int i2) {
        AppMethodBeat.i(222634);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                i3 = 0;
                break;
            } else if (i2 < (1 << i3) + i4) {
                break;
            } else {
                i4 += 1 << i3;
                i3++;
            }
        }
        a(0, i3);
        d(1);
        a((long) (i2 - i4), i3);
        AppMethodBeat.o(222634);
    }

    public void c(int i2, String str) {
        AppMethodBeat.i(222635);
        e(i2);
        AppMethodBeat.o(222635);
    }

    public void a(boolean z, String str) {
        AppMethodBeat.i(222636);
        d(z ? 1 : 0);
        AppMethodBeat.o(222636);
    }

    public void c() {
        AppMethodBeat.i(222637);
        d(1);
        b();
        a();
        AppMethodBeat.o(222637);
    }

    private void a(String str, String str2) {
    }
}
