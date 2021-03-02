package com.tencent.mm.danmaku.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.render.h;

public class e extends d {
    public h.a gPk;
    public boolean gPl = false;

    public e(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final int getType() {
        return -2147483647;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final void reset() {
        AppMethodBeat.i(241679);
        super.reset();
        this.gPl = false;
        AppMethodBeat.o(241679);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.gPk.c(r4);
     */
    @Override // com.tencent.mm.danmaku.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.mm.danmaku.d.b b(com.tencent.mm.danmaku.d.h r4) {
        /*
            r3 = this;
            r2 = 241680(0x3b010, float:3.38666E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.danmaku.render.h$a r0 = r3.gPk
            if (r0 == 0) goto L_0x001a
            com.tencent.mm.danmaku.render.h$a r0 = r3.gPk
            android.view.View r0 = r0.c(r4)
            if (r0 == 0) goto L_0x001a
            com.tencent.mm.danmaku.b.e$1 r1 = new com.tencent.mm.danmaku.b.e$1
            r1.<init>(r0)
            com.tencent.mm.danmaku.f.b.post(r1)
        L_0x001a:
            com.tencent.mm.danmaku.d.b r0 = super.b(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.b.e.b(com.tencent.mm.danmaku.d.h):com.tencent.mm.danmaku.d.b");
    }
}
