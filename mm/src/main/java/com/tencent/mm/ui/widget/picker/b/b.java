package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b {
    public a QSH = new a(2);

    public b(Context context, g gVar) {
        AppMethodBeat.i(198514);
        this.QSH.context = context;
        this.QSH.QUA = gVar;
        AppMethodBeat.o(198514);
    }

    public final b c(boolean[] zArr) {
        this.QSH.jKX = zArr;
        return this;
    }

    public final b b(Calendar calendar) {
        this.QSH.jKY = calendar;
        return this;
    }

    public final b b(Calendar calendar, Calendar calendar2) {
        this.QSH.jKZ = calendar;
        this.QSH.jLa = calendar2;
        return this;
    }

    public final b hcv() {
        this.QSH.jKV = false;
        return this;
    }

    public final void c(h hVar) {
        AppMethodBeat.i(198515);
        hVar.a(this.QSH);
        AppMethodBeat.o(198515);
    }
}
