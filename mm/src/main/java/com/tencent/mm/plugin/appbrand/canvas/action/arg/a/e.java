package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;

public final class e extends b {
    private static e lae = new e();

    static {
        AppMethodBeat.i(145323);
        AppMethodBeat.o(145323);
    }

    private e() {
    }

    public static e bzp() {
        return lae;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
    public final void a(a aVar) {
        AppMethodBeat.i(145321);
        aVar.reset();
        aVar.release();
        aVar.setStyle(Paint.Style.FILL);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.zD(1));
        super.a(aVar);
        AppMethodBeat.o(145321);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
    public final a bzm() {
        AppMethodBeat.i(145322);
        a aVar = new a();
        aVar.setStyle(Paint.Style.FILL);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.zD(1));
        AppMethodBeat.o(145322);
        return aVar;
    }
}
