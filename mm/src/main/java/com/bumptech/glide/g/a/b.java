package com.bumptech.glide.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b {
    /* access modifiers changed from: package-private */
    public abstract void aH(boolean z);

    public abstract void qz();

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
    }

    public static class a extends b {
        private volatile boolean isReleased;

        public a() {
            super((byte) 0);
        }

        @Override // com.bumptech.glide.g.a.b
        public final void qz() {
            AppMethodBeat.i(77795);
            if (this.isReleased) {
                IllegalStateException illegalStateException = new IllegalStateException("Already released");
                AppMethodBeat.o(77795);
                throw illegalStateException;
            }
            AppMethodBeat.o(77795);
        }

        @Override // com.bumptech.glide.g.a.b
        public final void aH(boolean z) {
            this.isReleased = z;
        }
    }
}
