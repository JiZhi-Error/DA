package com.google.android.exoplayer2.h.a;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;

public interface a {

    public interface b {
        void a(a aVar, g gVar);

        void a(a aVar, g gVar, g gVar2);

        void c(g gVar);
    }

    NavigableSet<g> a(String str, b bVar);

    void a(g gVar);

    void b(g gVar);

    long bp(String str);

    g e(String str, long j2);

    File e(String str, long j2, long j3);

    long f(String str, long j2, long j3);

    g f(String str, long j2);

    void g(String str, long j2);

    void w(File file);

    long wN();

    /* renamed from: com.google.android.exoplayer2.h.a.a$a  reason: collision with other inner class name */
    public static class C0112a extends IOException {
        public C0112a(String str) {
            super(str);
        }

        public C0112a(IOException iOException) {
            super(iOException);
        }
    }
}
