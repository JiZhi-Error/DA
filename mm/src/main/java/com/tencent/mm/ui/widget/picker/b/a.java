package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a {
    private com.tencent.mm.ui.widget.picker.c.a QSH = new com.tencent.mm.ui.widget.picker.c.a(1);

    public a(Context context, e eVar) {
        AppMethodBeat.i(198512);
        this.QSH.context = context;
        this.QSH.QUz = eVar;
        AppMethodBeat.o(198512);
    }

    public final a apt(int i2) {
        this.QSH.jKu = i2;
        return this;
    }

    public final a apu(int i2) {
        this.QSH.option = i2;
        return this;
    }

    public final void a(com.tencent.mm.ui.widget.picker.g.a aVar) {
        AppMethodBeat.i(198513);
        aVar.b(this.QSH);
        AppMethodBeat.o(198513);
    }
}
