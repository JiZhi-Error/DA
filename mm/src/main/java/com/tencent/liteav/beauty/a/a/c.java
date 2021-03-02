package com.tencent.liteav.beauty.a.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private Surface f505b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f506c;

    public c(a aVar, int i2, int i3, boolean z) {
        super(aVar);
        AppMethodBeat.i(15280);
        a(i2, i3);
        this.f506c = z;
        AppMethodBeat.o(15280);
    }

    public void c() {
        AppMethodBeat.i(15281);
        a();
        if (this.f505b != null) {
            if (this.f506c) {
                this.f505b.release();
            }
            this.f505b = null;
        }
        AppMethodBeat.o(15281);
    }
}
