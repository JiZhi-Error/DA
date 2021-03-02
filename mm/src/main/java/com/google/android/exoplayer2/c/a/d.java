package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.o;

abstract class d {
    protected final m biA;

    /* access modifiers changed from: protected */
    public abstract void a(com.google.android.exoplayer2.i.m mVar, long j2);

    /* access modifiers changed from: protected */
    public abstract boolean a(com.google.android.exoplayer2.i.m mVar);

    public static final class a extends o {
        public a(String str) {
            super(str);
        }
    }

    protected d(m mVar) {
        this.biA = mVar;
    }

    public final void b(com.google.android.exoplayer2.i.m mVar, long j2) {
        if (a(mVar)) {
            a(mVar, j2);
        }
    }
}
