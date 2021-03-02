package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class e implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f2186a = {127, 'E', 'L', 'F', 0};

    /* renamed from: b  reason: collision with root package name */
    final char[] f2187b = new char[16];

    /* renamed from: c  reason: collision with root package name */
    boolean f2188c;

    /* renamed from: d  reason: collision with root package name */
    j[] f2189d;

    /* renamed from: e  reason: collision with root package name */
    l[] f2190e;

    /* renamed from: f  reason: collision with root package name */
    byte[] f2191f;

    /* renamed from: g  reason: collision with root package name */
    private final c f2192g;

    /* renamed from: h  reason: collision with root package name */
    private final a f2193h;

    /* renamed from: i  reason: collision with root package name */
    private final k[] f2194i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f2195j;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        short f2196a;

        /* renamed from: b  reason: collision with root package name */
        short f2197b;

        /* renamed from: c  reason: collision with root package name */
        int f2198c;

        /* renamed from: d  reason: collision with root package name */
        int f2199d;

        /* renamed from: e  reason: collision with root package name */
        short f2200e;

        /* renamed from: f  reason: collision with root package name */
        short f2201f;

        /* renamed from: g  reason: collision with root package name */
        short f2202g;

        /* renamed from: h  reason: collision with root package name */
        short f2203h;

        /* renamed from: i  reason: collision with root package name */
        short f2204i;

        /* renamed from: j  reason: collision with root package name */
        short f2205j;

        /* access modifiers changed from: package-private */
        public abstract long a();

        /* access modifiers changed from: package-private */
        public abstract long b();
    }

    public static abstract class k {

        /* renamed from: g  reason: collision with root package name */
        int f2236g;

        /* renamed from: h  reason: collision with root package name */
        int f2237h;

        /* renamed from: i  reason: collision with root package name */
        int f2238i;

        /* renamed from: j  reason: collision with root package name */
        int f2239j;

        public abstract int a();

        public abstract long b();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f2187b[0] == f2186a[0];
    }

    /* access modifiers changed from: package-private */
    public final char b() {
        return this.f2187b[4];
    }

    /* access modifiers changed from: package-private */
    public final char c() {
        return this.f2187b[5];
    }

    public final boolean d() {
        AppMethodBeat.i(53938);
        if (b() == 2) {
            AppMethodBeat.o(53938);
            return true;
        }
        AppMethodBeat.o(53938);
        return false;
    }

    public final boolean e() {
        AppMethodBeat.i(53939);
        if (c() == 1) {
            AppMethodBeat.o(53939);
            return true;
        }
        AppMethodBeat.o(53939);
        return false;
    }

    static class b extends a {
        int k;
        int l;
        int m;

        b() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.smtt.utils.e.a
        public long a() {
            return (long) this.m;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.smtt.utils.e.a
        public long b() {
            return (long) this.l;
        }
    }

    static class f extends a {
        long k;
        long l;
        long m;

        f() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.smtt.utils.e.a
        public long a() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.smtt.utils.e.a
        public long b() {
            return this.l;
        }
    }

    static class d extends k {

        /* renamed from: a  reason: collision with root package name */
        int f2212a;

        /* renamed from: b  reason: collision with root package name */
        int f2213b;

        /* renamed from: c  reason: collision with root package name */
        int f2214c;

        /* renamed from: d  reason: collision with root package name */
        int f2215d;

        /* renamed from: e  reason: collision with root package name */
        int f2216e;

        /* renamed from: f  reason: collision with root package name */
        int f2217f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.f2215d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return (long) this.f2214c;
        }
    }

    static class h extends k {

        /* renamed from: a  reason: collision with root package name */
        long f2226a;

        /* renamed from: b  reason: collision with root package name */
        long f2227b;

        /* renamed from: c  reason: collision with root package name */
        long f2228c;

        /* renamed from: d  reason: collision with root package name */
        long f2229d;

        /* renamed from: e  reason: collision with root package name */
        long f2230e;

        /* renamed from: f  reason: collision with root package name */
        long f2231f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.f2229d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f2228c;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class l {

        /* renamed from: c  reason: collision with root package name */
        int f2240c;

        /* renamed from: d  reason: collision with root package name */
        char f2241d;

        /* renamed from: e  reason: collision with root package name */
        char f2242e;

        /* renamed from: f  reason: collision with root package name */
        short f2243f;

        l() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.smtt.utils.e$e  reason: collision with other inner class name */
    public static class C2188e extends l {

        /* renamed from: a  reason: collision with root package name */
        int f2218a;

        /* renamed from: b  reason: collision with root package name */
        int f2219b;

        C2188e() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class i extends l {

        /* renamed from: a  reason: collision with root package name */
        long f2232a;

        /* renamed from: b  reason: collision with root package name */
        long f2233b;

        i() {
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class j {

        /* renamed from: g  reason: collision with root package name */
        int f2234g;

        /* renamed from: h  reason: collision with root package name */
        int f2235h;

        j() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        int f2206a;

        /* renamed from: b  reason: collision with root package name */
        int f2207b;

        /* renamed from: c  reason: collision with root package name */
        int f2208c;

        /* renamed from: d  reason: collision with root package name */
        int f2209d;

        /* renamed from: e  reason: collision with root package name */
        int f2210e;

        /* renamed from: f  reason: collision with root package name */
        int f2211f;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class g extends j {

        /* renamed from: a  reason: collision with root package name */
        long f2220a;

        /* renamed from: b  reason: collision with root package name */
        long f2221b;

        /* renamed from: c  reason: collision with root package name */
        long f2222c;

        /* renamed from: d  reason: collision with root package name */
        long f2223d;

        /* renamed from: e  reason: collision with root package name */
        long f2224e;

        /* renamed from: f  reason: collision with root package name */
        long f2225f;

        g() {
        }
    }

    public e(File file) {
        AppMethodBeat.i(53940);
        c cVar = new c(file);
        this.f2192g = cVar;
        cVar.a(this.f2187b);
        if (!a()) {
            UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(file)));
            AppMethodBeat.o(53940);
            throw unknownFormatConversionException;
        }
        cVar.a(e());
        boolean d2 = d();
        if (d2) {
            f fVar = new f();
            fVar.f2196a = cVar.a();
            fVar.f2197b = cVar.a();
            fVar.f2198c = cVar.b();
            fVar.k = cVar.c();
            fVar.l = cVar.c();
            fVar.m = cVar.c();
            this.f2193h = fVar;
        } else {
            b bVar = new b();
            bVar.f2196a = cVar.a();
            bVar.f2197b = cVar.a();
            bVar.f2198c = cVar.b();
            bVar.k = cVar.b();
            bVar.l = cVar.b();
            bVar.m = cVar.b();
            this.f2193h = bVar;
        }
        a aVar = this.f2193h;
        aVar.f2199d = cVar.b();
        aVar.f2200e = cVar.a();
        aVar.f2201f = cVar.a();
        aVar.f2202g = cVar.a();
        aVar.f2203h = cVar.a();
        aVar.f2204i = cVar.a();
        aVar.f2205j = cVar.a();
        this.f2194i = new k[aVar.f2204i];
        for (int i2 = 0; i2 < aVar.f2204i; i2++) {
            cVar.a(aVar.a() + ((long) (aVar.f2203h * i2)));
            if (d2) {
                h hVar = new h();
                hVar.f2236g = cVar.b();
                hVar.f2237h = cVar.b();
                hVar.f2226a = cVar.c();
                hVar.f2227b = cVar.c();
                hVar.f2228c = cVar.c();
                hVar.f2229d = cVar.c();
                hVar.f2238i = cVar.b();
                hVar.f2239j = cVar.b();
                hVar.f2230e = cVar.c();
                hVar.f2231f = cVar.c();
                this.f2194i[i2] = hVar;
            } else {
                d dVar = new d();
                dVar.f2236g = cVar.b();
                dVar.f2237h = cVar.b();
                dVar.f2212a = cVar.b();
                dVar.f2213b = cVar.b();
                dVar.f2214c = cVar.b();
                dVar.f2215d = cVar.b();
                dVar.f2238i = cVar.b();
                dVar.f2239j = cVar.b();
                dVar.f2216e = cVar.b();
                dVar.f2217f = cVar.b();
                this.f2194i[i2] = dVar;
            }
        }
        if (aVar.f2205j < 0 || aVar.f2205j >= this.f2194i.length) {
            UnknownFormatConversionException unknownFormatConversionException2 = new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar.f2205j));
            AppMethodBeat.o(53940);
            throw unknownFormatConversionException2;
        }
        k kVar = this.f2194i[aVar.f2205j];
        if (kVar.f2237h == 3) {
            this.f2195j = new byte[kVar.a()];
            cVar.a(kVar.b());
            cVar.a(this.f2195j);
            if (this.f2188c) {
                f();
            }
            AppMethodBeat.o(53940);
            return;
        }
        UnknownFormatConversionException unknownFormatConversionException3 = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar.f2205j));
        AppMethodBeat.o(53940);
        throw unknownFormatConversionException3;
    }

    private void f() {
        AppMethodBeat.i(53941);
        a aVar = this.f2193h;
        c cVar = this.f2192g;
        boolean d2 = d();
        k a2 = a(".dynsym");
        if (a2 != null) {
            cVar.a(a2.b());
            int a3 = a2.a() / (d2 ? 24 : 16);
            this.f2190e = new l[a3];
            char[] cArr = new char[1];
            for (int i2 = 0; i2 < a3; i2++) {
                if (d2) {
                    i iVar = new i();
                    iVar.f2240c = cVar.b();
                    cVar.a(cArr);
                    iVar.f2241d = cArr[0];
                    cVar.a(cArr);
                    iVar.f2242e = cArr[0];
                    iVar.f2232a = cVar.c();
                    iVar.f2233b = cVar.c();
                    iVar.f2243f = cVar.a();
                    this.f2190e[i2] = iVar;
                } else {
                    C2188e eVar = new C2188e();
                    eVar.f2240c = cVar.b();
                    eVar.f2218a = cVar.b();
                    eVar.f2219b = cVar.b();
                    cVar.a(cArr);
                    eVar.f2241d = cArr[0];
                    cVar.a(cArr);
                    eVar.f2242e = cArr[0];
                    eVar.f2243f = cVar.a();
                    this.f2190e[i2] = eVar;
                }
            }
            k kVar = this.f2194i[a2.f2238i];
            cVar.a(kVar.b());
            this.f2191f = new byte[kVar.a()];
            cVar.a(this.f2191f);
        }
        this.f2189d = new j[aVar.f2202g];
        for (int i3 = 0; i3 < aVar.f2202g; i3++) {
            cVar.a(aVar.b() + ((long) (aVar.f2201f * i3)));
            if (d2) {
                g gVar = new g();
                gVar.f2234g = cVar.b();
                gVar.f2235h = cVar.b();
                gVar.f2220a = cVar.c();
                gVar.f2221b = cVar.c();
                gVar.f2222c = cVar.c();
                gVar.f2223d = cVar.c();
                gVar.f2224e = cVar.c();
                gVar.f2225f = cVar.c();
                this.f2189d[i3] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.f2234g = cVar.b();
                cVar2.f2235h = cVar.b();
                cVar2.f2206a = cVar.b();
                cVar2.f2207b = cVar.b();
                cVar2.f2208c = cVar.b();
                cVar2.f2209d = cVar.b();
                cVar2.f2210e = cVar.b();
                cVar2.f2211f = cVar.b();
                this.f2189d[i3] = cVar2;
            }
        }
        AppMethodBeat.o(53941);
    }

    public final k a(String str) {
        AppMethodBeat.i(53942);
        k[] kVarArr = this.f2194i;
        for (k kVar : kVarArr) {
            if (str.equals(a(kVar.f2236g))) {
                AppMethodBeat.o(53942);
                return kVar;
            }
        }
        AppMethodBeat.o(53942);
        return null;
    }

    public final String a(int i2) {
        AppMethodBeat.i(53943);
        if (i2 == 0) {
            AppMethodBeat.o(53943);
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (this.f2195j[i3] != 0) {
            i3++;
        }
        String str = new String(this.f2195j, i2, i3 - i2);
        AppMethodBeat.o(53943);
        return str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(53944);
        this.f2192g.close();
        AppMethodBeat.o(53944);
    }

    public static boolean a(File file) {
        AppMethodBeat.i(53945);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = (long) randomAccessFile.readInt();
            randomAccessFile.close();
            if (readInt == 2135247942) {
                AppMethodBeat.o(53945);
                return true;
            }
            AppMethodBeat.o(53945);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(53945);
            return false;
        }
    }

    public static boolean b(File file) {
        AppMethodBeat.i(53946);
        if (g() && a(file)) {
            try {
                new e(file);
            } catch (IOException e2) {
                new StringBuilder("checkElfFile IOException: ").append(e2);
                AppMethodBeat.o(53946);
                return false;
            } catch (UnknownFormatConversionException e3) {
                new StringBuilder("checkElfFile UnknownFormatConversionException: ").append(e3);
            } catch (Throwable th) {
                new StringBuilder("checkElfFile Throwable: ").append(th);
            }
        }
        AppMethodBeat.o(53946);
        return true;
    }

    private static boolean g() {
        AppMethodBeat.i(53947);
        String property = System.getProperty("java.vm.version");
        if (property == null || !property.startsWith("2")) {
            AppMethodBeat.o(53947);
            return false;
        }
        AppMethodBeat.o(53947);
        return true;
    }
}
