package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.f.h;
import com.tencent.f.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* access modifiers changed from: package-private */
public abstract class aw<T> implements g, aa, Callable<T> {
    protected volatile long mWG = 0;
    protected volatile long mWH = 0;
    protected volatile long mWI = 0;
    private boolean mWJ = true;

    /* access modifiers changed from: package-private */
    public abstract String getTag();

    aw() {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public boolean bNh() {
        return this.mWJ;
    }

    public void hX(boolean z) {
        this.mWJ = z;
    }

    final class a implements g, Callable<T> {
        a() {
        }

        @Override // com.tencent.f.i.g
        public final String getKey() {
            AppMethodBeat.i(227094);
            String key = aw.this.getKey();
            AppMethodBeat.o(227094);
            return key;
        }

        @Override // java.util.concurrent.Callable
        public final T call() {
            AppMethodBeat.i(227095);
            aw.this.mWG = Util.nowMilliSecond();
            try {
                return (T) aw.this.call();
            } finally {
                aw.this.mWH = Util.nowMilliSecond();
                aw.this.mWI = aw.this.mWH - aw.this.mWG;
                AppMethodBeat.o(227095);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Future<T> bNN() {
        return h.RTc.d(new a());
    }

    public final T bNO() {
        this.mWG = Util.nowMilliSecond();
        try {
            return (T) call();
        } finally {
            this.mWH = Util.nowMilliSecond();
            this.mWI = this.mWH - this.mWG;
        }
    }

    @Override // com.tencent.f.i.g
    public final String getKey() {
        return getTag();
    }
}
