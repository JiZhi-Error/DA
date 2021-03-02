package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a {
    private com.tencent.mm.picker.c.a jKP = new com.tencent.mm.picker.c.a(1);

    public a(Context context, c cVar) {
        AppMethodBeat.i(175328);
        this.jKP.context = context;
        this.jKP.jKR = cVar;
        AppMethodBeat.o(175328);
    }

    public final a uM(int i2) {
        this.jKP.jKu = i2;
        return this;
    }

    public final a uN(int i2) {
        this.jKP.option = i2;
        return this;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(175329);
        bVar.a(this.jKP);
        AppMethodBeat.o(175329);
    }
}
