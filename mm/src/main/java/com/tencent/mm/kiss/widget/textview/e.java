package com.tencent.mm.kiss.widget.textview;

import android.text.Layout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private final d[] huE = new d[3];
    private final Object mLock = new Object();
    private int mPoolSize;

    public e() {
        AppMethodBeat.i(141032);
        AppMethodBeat.o(141032);
    }

    public final d aBm() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.mPoolSize > 0) {
                int i2 = this.mPoolSize - 1;
                dVar = this.huE[i2];
                this.huE[i2] = null;
                this.mPoolSize--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        boolean z;
        AppMethodBeat.i(141033);
        synchronized (this.mLock) {
            int i2 = 0;
            while (true) {
                try {
                    if (i2 >= this.mPoolSize) {
                        z = false;
                        break;
                    } else if (this.huE[i2] == dVar) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                } finally {
                    AppMethodBeat.o(141033);
                }
            }
            if (z) {
                IllegalStateException illegalStateException = new IllegalStateException("Already in the pool!");
                AppMethodBeat.o(141033);
                throw illegalStateException;
            }
            dVar.hur = null;
            dVar.hus = null;
            dVar.hut = 0;
            dVar.huu = 0;
            dVar.huv = new TextPaint();
            dVar.width = 0;
            dVar.huw = Layout.Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.hux = null;
            dVar.huy = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.huz = null;
            dVar.huA = 0.0f;
            dVar.huB = 1.0f;
            dVar.huC = false;
            dVar.maxLength = 0;
            dVar.huD = null;
            dVar.breakStrategy = -1;
            if (this.mPoolSize < this.huE.length) {
                this.huE[this.mPoolSize] = dVar;
                this.mPoolSize++;
                return true;
            }
            AppMethodBeat.o(141033);
            return false;
        }
    }
}
