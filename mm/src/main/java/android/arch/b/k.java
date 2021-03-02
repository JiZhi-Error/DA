package android.arch.b;

import android.support.v7.h.d;

final class k {

    static class a implements d {
        private final int fs;
        private final d ft;

        /* synthetic */ a(int i2, d dVar, byte b2) {
            this(i2, dVar);
        }

        private a(int i2, d dVar) {
            this.fs = i2;
            this.ft = dVar;
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            this.ft.f(this.fs + i2, i3);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            this.ft.k(this.fs + i2, i3);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            this.ft.l(this.fs + i2, this.fs + i3);
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            this.ft.c(this.fs + i2, i3, obj);
        }
    }
}
