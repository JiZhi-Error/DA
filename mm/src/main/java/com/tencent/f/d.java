package com.tencent.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static e RSQ = new c((byte) 0);
    public static f RSR = new C0137d((byte) 0);
    public static a RSS = new b((byte) 0);

    public interface a {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public interface e {
        void a(String str, int i2, int i3, long j2, String str2);

        void a(String str, int i2, f fVar, long j2, long j3, String str2, boolean z);

        void a(String str, int i2, Throwable th);

        void g(String str, int i2, String str2);

        void shutdown();
    }

    public interface f {
        void a(Thread thread, String str, long j2);

        void b(Thread thread, String str, long j2);

        void c(Thread thread, String str, long j2);
    }

    static {
        AppMethodBeat.i(183137);
        AppMethodBeat.o(183137);
    }

    static class c implements e {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, f fVar, long j2, long j3, String str2, boolean z) {
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, Throwable th) {
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, int i3, long j2, String str2) {
        }

        @Override // com.tencent.f.d.e
        public final void g(String str, int i2, String str2) {
        }

        @Override // com.tencent.f.d.e
        public final void shutdown() {
        }
    }

    /* renamed from: com.tencent.f.d$d  reason: collision with other inner class name */
    static class C0137d implements f {
        private C0137d() {
        }

        /* synthetic */ C0137d(byte b2) {
            this();
        }

        @Override // com.tencent.f.d.f
        public final void a(Thread thread, String str, long j2) {
        }

        @Override // com.tencent.f.d.f
        public final void b(Thread thread, String str, long j2) {
        }

        @Override // com.tencent.f.d.f
        public final void c(Thread thread, String str, long j2) {
        }
    }

    static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.f.d.a
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(183134);
            String.format(str2, objArr);
            AppMethodBeat.o(183134);
        }

        @Override // com.tencent.f.d.a
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(183135);
            String.format(str2, objArr);
            AppMethodBeat.o(183135);
        }

        @Override // com.tencent.f.d.a
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(183136);
            String.format(str2, objArr);
            AppMethodBeat.o(183136);
        }
    }
}
