package com.tencent.mm.plugin.expt.b;

import android.app.Application;

public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        void aof(String str);

        void aog(String str);

        void aoh(String str);

        void aoi(String str);

        void aoj(String str);

        void d(String str, int i2, long j2);

        void dj(String str, int i2);

        void e(String str, int i2, long j2);

        void f(String str, int i2, long j2);

        void g(String str, int i2, long j2);

        void h(String str, int i2, long j2);
    }

    public interface b {
        void Dm(long j2);

        void R(int i2, long j2);

        void S(int i2, long j2);

        void b(String str, String str2, int i2, long j2);

        void c(String str, String str2, int i2, long j2);
    }

    public interface c {
        void a(String str, int i2, int i3, long j2, int i4);

        void i(String str, int i2, long j2);

        void j(String str, int i2, long j2);
    }

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void k(Application application);
}
