package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.a;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.d;

public final class c extends a {
    private TextPaint ayn = new TextPaint();

    public c() {
        AppMethodBeat.i(241698);
        AppMethodBeat.o(241698);
    }

    @Override // com.tencent.mm.danmaku.render.a
    public final boolean f(a aVar) {
        return true;
    }

    @Override // com.tencent.mm.danmaku.render.a
    public final com.tencent.mm.danmaku.e.a g(a aVar) {
        AppMethodBeat.i(241699);
        m asO = com.tencent.mm.danmaku.c.a.asO();
        float a2 = d.a(asO.gPN, String.valueOf(aVar.mData)) + asO.gPQ + asO.gPQ;
        float ap = (asO.gPP * 2.0f) + d.ap(asO.gPN);
        aVar.gPc = ap;
        aVar.gPb = a2;
        com.tencent.mm.danmaku.e.a aVar2 = new com.tencent.mm.danmaku.e.a(a2, ap);
        AppMethodBeat.o(241699);
        return aVar2;
    }

    @Override // com.tencent.mm.danmaku.render.a
    public final void b(Canvas canvas, a aVar, float f2, float f3) {
        AppMethodBeat.i(241700);
        m asO = com.tencent.mm.danmaku.c.a.asO();
        this.ayn.setTextSize(asO.gPN);
        this.ayn.setColor(-1);
        canvas.drawText(String.valueOf(aVar.mData), asO.gPQ + f2, (asO.gPP + f3) - this.ayn.ascent(), this.ayn);
        AppMethodBeat.o(241700);
    }
}
