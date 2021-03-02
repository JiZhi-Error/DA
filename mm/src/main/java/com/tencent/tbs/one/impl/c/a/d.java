package com.tencent.tbs.one.impl.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.util.UnknownFormatConversionException;

public final class d implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f2431a = {127, 'E', 'L', 'F', 0};

    /* renamed from: b  reason: collision with root package name */
    final char[] f2432b = new char[16];

    /* renamed from: c  reason: collision with root package name */
    boolean f2433c;

    /* renamed from: d  reason: collision with root package name */
    j[] f2434d;

    /* renamed from: e  reason: collision with root package name */
    l[] f2435e;

    /* renamed from: f  reason: collision with root package name */
    byte[] f2436f;

    /* renamed from: g  reason: collision with root package name */
    private final a f2437g;

    /* renamed from: h  reason: collision with root package name */
    private final a f2438h;

    /* renamed from: i  reason: collision with root package name */
    private final k[] f2439i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f2440j;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        short f2441a;

        /* renamed from: b  reason: collision with root package name */
        short f2442b;

        /* renamed from: c  reason: collision with root package name */
        int f2443c;

        /* renamed from: d  reason: collision with root package name */
        int f2444d;

        /* renamed from: e  reason: collision with root package name */
        short f2445e;

        /* renamed from: f  reason: collision with root package name */
        short f2446f;

        /* renamed from: g  reason: collision with root package name */
        short f2447g;

        /* renamed from: h  reason: collision with root package name */
        short f2448h;

        /* renamed from: i  reason: collision with root package name */
        short f2449i;

        /* renamed from: j  reason: collision with root package name */
        short f2450j;

        /* access modifiers changed from: package-private */
        public abstract long a();

        /* access modifiers changed from: package-private */
        public abstract long b();
    }

    static class b extends a {
        int k;
        int l;
        int m;

        b() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.tbs.one.impl.c.a.d.a
        public final long a() {
            return (long) this.m;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.tbs.one.impl.c.a.d.a
        public final long b() {
            return (long) this.l;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        int f2451a;

        /* renamed from: b  reason: collision with root package name */
        int f2452b;

        /* renamed from: c  reason: collision with root package name */
        int f2453c;

        /* renamed from: d  reason: collision with root package name */
        int f2454d;

        /* renamed from: e  reason: collision with root package name */
        int f2455e;

        /* renamed from: f  reason: collision with root package name */
        int f2456f;

        c() {
        }
    }

    /* renamed from: com.tencent.tbs.one.impl.c.a.d$d  reason: collision with other inner class name */
    static class C2196d extends k {

        /* renamed from: a  reason: collision with root package name */
        int f2457a;

        /* renamed from: b  reason: collision with root package name */
        int f2458b;

        /* renamed from: c  reason: collision with root package name */
        int f2459c;

        /* renamed from: d  reason: collision with root package name */
        int f2460d;

        /* renamed from: e  reason: collision with root package name */
        int f2461e;

        /* renamed from: f  reason: collision with root package name */
        int f2462f;

        C2196d() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.d.k
        public final int a() {
            return this.f2460d;
        }

        @Override // com.tencent.tbs.one.impl.c.a.d.k
        public final long b() {
            return (long) this.f2459c;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends l {

        /* renamed from: a  reason: collision with root package name */
        int f2463a;

        /* renamed from: b  reason: collision with root package name */
        int f2464b;

        e() {
        }
    }

    static class f extends a {
        long k;
        long l;
        long m;

        f() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.tbs.one.impl.c.a.d.a
        public final long a() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.tbs.one.impl.c.a.d.a
        public final long b() {
            return this.l;
        }
    }

    /* access modifiers changed from: package-private */
    public static class g extends j {

        /* renamed from: a  reason: collision with root package name */
        long f2465a;

        /* renamed from: b  reason: collision with root package name */
        long f2466b;

        /* renamed from: c  reason: collision with root package name */
        long f2467c;

        /* renamed from: d  reason: collision with root package name */
        long f2468d;

        /* renamed from: e  reason: collision with root package name */
        long f2469e;

        /* renamed from: f  reason: collision with root package name */
        long f2470f;

        g() {
        }
    }

    static class h extends k {

        /* renamed from: a  reason: collision with root package name */
        long f2471a;

        /* renamed from: b  reason: collision with root package name */
        long f2472b;

        /* renamed from: c  reason: collision with root package name */
        long f2473c;

        /* renamed from: d  reason: collision with root package name */
        long f2474d;

        /* renamed from: e  reason: collision with root package name */
        long f2475e;

        /* renamed from: f  reason: collision with root package name */
        long f2476f;

        h() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.d.k
        public final int a() {
            return (int) this.f2474d;
        }

        @Override // com.tencent.tbs.one.impl.c.a.d.k
        public final long b() {
            return this.f2473c;
        }
    }

    /* access modifiers changed from: package-private */
    public static class i extends l {

        /* renamed from: a  reason: collision with root package name */
        long f2477a;

        /* renamed from: b  reason: collision with root package name */
        long f2478b;

        i() {
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class j {

        /* renamed from: g  reason: collision with root package name */
        int f2479g;

        /* renamed from: h  reason: collision with root package name */
        int f2480h;

        j() {
        }
    }

    public static abstract class k {

        /* renamed from: g  reason: collision with root package name */
        int f2481g;

        /* renamed from: h  reason: collision with root package name */
        int f2482h;

        /* renamed from: i  reason: collision with root package name */
        int f2483i;

        /* renamed from: j  reason: collision with root package name */
        int f2484j;

        public abstract int a();

        public abstract long b();
    }

    /* access modifiers changed from: package-private */
    public static abstract class l {

        /* renamed from: c  reason: collision with root package name */
        int f2485c;

        /* renamed from: d  reason: collision with root package name */
        char f2486d;

        /* renamed from: e  reason: collision with root package name */
        char f2487e;

        /* renamed from: f  reason: collision with root package name */
        short f2488f;

        l() {
        }
    }

    public d(File file) {
        boolean z = true;
        AppMethodBeat.i(173813);
        a aVar = new a(file);
        this.f2437g = aVar;
        aVar.a(this.f2432b);
        if (!(this.f2432b[0] == f2431a[0])) {
            UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(file)));
            AppMethodBeat.o(173813);
            throw unknownFormatConversionException;
        }
        aVar.f2422a = this.f2432b[5] != 1 ? false : z;
        boolean a2 = a();
        if (a2) {
            f fVar = new f();
            fVar.f2441a = aVar.a();
            fVar.f2442b = aVar.a();
            fVar.f2443c = aVar.b();
            fVar.k = aVar.c();
            fVar.l = aVar.c();
            fVar.m = aVar.c();
            this.f2438h = fVar;
        } else {
            b bVar = new b();
            bVar.f2441a = aVar.a();
            bVar.f2442b = aVar.a();
            bVar.f2443c = aVar.b();
            bVar.k = aVar.b();
            bVar.l = aVar.b();
            bVar.m = aVar.b();
            this.f2438h = bVar;
        }
        a aVar2 = this.f2438h;
        aVar2.f2444d = aVar.b();
        aVar2.f2445e = aVar.a();
        aVar2.f2446f = aVar.a();
        aVar2.f2447g = aVar.a();
        aVar2.f2448h = aVar.a();
        aVar2.f2449i = aVar.a();
        aVar2.f2450j = aVar.a();
        this.f2439i = new k[aVar2.f2449i];
        for (int i2 = 0; i2 < aVar2.f2449i; i2++) {
            aVar.a(aVar2.a() + ((long) (aVar2.f2448h * i2)));
            if (a2) {
                h hVar = new h();
                hVar.f2481g = aVar.b();
                hVar.f2482h = aVar.b();
                hVar.f2471a = aVar.c();
                hVar.f2472b = aVar.c();
                hVar.f2473c = aVar.c();
                hVar.f2474d = aVar.c();
                hVar.f2483i = aVar.b();
                hVar.f2484j = aVar.b();
                hVar.f2475e = aVar.c();
                hVar.f2476f = aVar.c();
                this.f2439i[i2] = hVar;
            } else {
                C2196d dVar = new C2196d();
                dVar.f2481g = aVar.b();
                dVar.f2482h = aVar.b();
                dVar.f2457a = aVar.b();
                dVar.f2458b = aVar.b();
                dVar.f2459c = aVar.b();
                dVar.f2460d = aVar.b();
                dVar.f2483i = aVar.b();
                dVar.f2484j = aVar.b();
                dVar.f2461e = aVar.b();
                dVar.f2462f = aVar.b();
                this.f2439i[i2] = dVar;
            }
        }
        if (aVar2.f2450j < 0 || aVar2.f2450j >= this.f2439i.length) {
            UnknownFormatConversionException unknownFormatConversionException2 = new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar2.f2450j));
            AppMethodBeat.o(173813);
            throw unknownFormatConversionException2;
        }
        k kVar = this.f2439i[aVar2.f2450j];
        if (kVar.f2482h == 3) {
            this.f2440j = new byte[kVar.a()];
            aVar.a(kVar.b());
            aVar.a(this.f2440j);
            if (this.f2433c) {
                b();
            }
            AppMethodBeat.o(173813);
            return;
        }
        UnknownFormatConversionException unknownFormatConversionException3 = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar2.f2450j));
        AppMethodBeat.o(173813);
        throw unknownFormatConversionException3;
    }

    private boolean a() {
        return this.f2432b[4] == 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r11) {
        /*
            r0 = 1
            r1 = 0
            r10 = 173816(0x2a6f8, float:2.43568E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
            r6 = 0
            r4 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x0027, all -> 0x0041 }
            java.lang.String r2 = "r"
            r3.<init>(r11, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0041 }
            int r2 = r3.readInt()     // Catch:{ Throwable -> 0x0051 }
            long r4 = (long) r2
            com.tencent.tbs.one.impl.a.c.a(r3)
            r2 = r4
        L_0x001c:
            r4 = 2135247942(0x7f454c46, double:1.0549526535E-314)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x004a
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
        L_0x0026:
            return r0
        L_0x0027:
            r2 = move-exception
            r3 = r4
        L_0x0029:
            java.lang.String r4 = "Failed to read file %s to determine if it is a elf file"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x004f }
            r8 = 0
            java.lang.String r9 = r11.getAbsolutePath()     // Catch:{ all -> 0x004f }
            r5[r8] = r9     // Catch:{ all -> 0x004f }
            r8 = 1
            r5[r8] = r2     // Catch:{ all -> 0x004f }
            com.tencent.tbs.one.impl.a.f.c(r4, r5)     // Catch:{ all -> 0x004f }
            com.tencent.tbs.one.impl.a.c.a(r3)
            r2 = r6
            goto L_0x001c
        L_0x0041:
            r0 = move-exception
            r3 = r4
        L_0x0043:
            com.tencent.tbs.one.impl.a.c.a(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            throw r0
        L_0x004a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            r0 = r1
            goto L_0x0026
        L_0x004f:
            r0 = move-exception
            goto L_0x0043
        L_0x0051:
            r2 = move-exception
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.c.a.d.a(java.io.File):boolean");
    }

    private void b() {
        k kVar;
        String str;
        AppMethodBeat.i(173814);
        a aVar = this.f2438h;
        a aVar2 = this.f2437g;
        boolean a2 = a();
        k[] kVarArr = this.f2439i;
        int length = kVarArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                kVar = null;
                break;
            }
            k kVar2 = kVarArr[i2];
            int i3 = kVar2.f2481g;
            if (i3 == 0) {
                str = "SHN_UNDEF";
            } else {
                int i4 = i3;
                while (this.f2440j[i4] != 0) {
                    i4++;
                }
                str = new String(this.f2440j, i3, i4 - i3);
            }
            if (".dynsym".equals(str)) {
                kVar = kVar2;
                break;
            }
            i2++;
        }
        if (kVar != null) {
            aVar2.a(kVar.b());
            int a3 = kVar.a() / (a2 ? 24 : 16);
            this.f2435e = new l[a3];
            char[] cArr = new char[1];
            for (int i5 = 0; i5 < a3; i5++) {
                if (a2) {
                    i iVar = new i();
                    iVar.f2485c = aVar2.b();
                    aVar2.a(cArr);
                    iVar.f2486d = cArr[0];
                    aVar2.a(cArr);
                    iVar.f2487e = cArr[0];
                    iVar.f2477a = aVar2.c();
                    iVar.f2478b = aVar2.c();
                    iVar.f2488f = aVar2.a();
                    this.f2435e[i5] = iVar;
                } else {
                    e eVar = new e();
                    eVar.f2485c = aVar2.b();
                    eVar.f2463a = aVar2.b();
                    eVar.f2464b = aVar2.b();
                    aVar2.a(cArr);
                    eVar.f2486d = cArr[0];
                    aVar2.a(cArr);
                    eVar.f2487e = cArr[0];
                    eVar.f2488f = aVar2.a();
                    this.f2435e[i5] = eVar;
                }
            }
            k kVar3 = this.f2439i[kVar.f2483i];
            aVar2.a(kVar3.b());
            this.f2436f = new byte[kVar3.a()];
            aVar2.a(this.f2436f);
        }
        this.f2434d = new j[aVar.f2447g];
        for (int i6 = 0; i6 < aVar.f2447g; i6++) {
            aVar2.a(aVar.b() + ((long) (aVar.f2446f * i6)));
            if (a2) {
                g gVar = new g();
                gVar.f2479g = aVar2.b();
                gVar.f2480h = aVar2.b();
                gVar.f2465a = aVar2.c();
                gVar.f2466b = aVar2.c();
                gVar.f2467c = aVar2.c();
                gVar.f2468d = aVar2.c();
                gVar.f2469e = aVar2.c();
                gVar.f2470f = aVar2.c();
                this.f2434d[i6] = gVar;
            } else {
                c cVar = new c();
                cVar.f2479g = aVar2.b();
                cVar.f2480h = aVar2.b();
                cVar.f2451a = aVar2.b();
                cVar.f2452b = aVar2.b();
                cVar.f2453c = aVar2.b();
                cVar.f2454d = aVar2.b();
                cVar.f2455e = aVar2.b();
                cVar.f2456f = aVar2.b();
                this.f2434d[i6] = cVar;
            }
        }
        AppMethodBeat.o(173814);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(173815);
        this.f2437g.close();
        AppMethodBeat.o(173815);
    }
}
