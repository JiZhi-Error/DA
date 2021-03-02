package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b {
    public a jKP = new a(2);

    public b(Context context, e eVar) {
        AppMethodBeat.i(175330);
        this.jKP.context = context;
        this.jKP.jKS = eVar;
        AppMethodBeat.o(175330);
    }

    public final b b(boolean[] zArr) {
        this.jKP.jKX = zArr;
        return this;
    }

    public final b a(Calendar calendar) {
        this.jKP.jKY = calendar;
        return this;
    }

    public final b a(Calendar calendar, Calendar calendar2) {
        this.jKP.jKZ = calendar;
        this.jKP.jLa = calendar2;
        return this;
    }

    public final b bkZ() {
        this.jKP.jKV = false;
        return this;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(175331);
        cVar.b(this.jKP);
        AppMethodBeat.o(175331);
    }
}
