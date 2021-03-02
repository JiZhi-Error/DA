package com.tencent.mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;

public final class i implements k {
    public k rbC;

    public i(k kVar) {
        this.rbC = kVar;
    }

    @Override // com.tencent.mm.av.a.c.k
    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
        AppMethodBeat.i(108632);
        if (this.rbC != null) {
            this.rbC.a(str, view, bitmap, objArr);
        }
        AppMethodBeat.o(108632);
    }
}
