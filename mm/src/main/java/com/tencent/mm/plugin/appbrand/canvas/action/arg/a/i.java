package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;

public final class i extends b {
    public static final i lai = new i();

    static {
        AppMethodBeat.i(145332);
        AppMethodBeat.o(145332);
    }

    public static i bzt() {
        return lai;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
    public final void a(a aVar) {
        AppMethodBeat.i(145330);
        aVar.reset();
        aVar.release();
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.zD(1));
        super.a(aVar);
        AppMethodBeat.o(145330);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
    public final a bzm() {
        AppMethodBeat.i(145331);
        a aVar = new a();
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.zD(1));
        AppMethodBeat.o(145331);
        return aVar;
    }
}
