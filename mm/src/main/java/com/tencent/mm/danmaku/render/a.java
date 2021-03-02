package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import com.tencent.mm.danmaku.b.a;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<D extends com.tencent.mm.danmaku.b.a> {
    private ArrayList<Object> gPT;

    public abstract void b(Canvas canvas, D d2, float f2, float f3);

    public abstract boolean f(com.tencent.mm.danmaku.b.a aVar);

    public abstract com.tencent.mm.danmaku.e.a g(D d2);

    public void h(D d2) {
    }

    public final void a(Canvas canvas, D d2, float f2, float f3) {
        b(canvas, d2, f2, f3);
        atc();
    }

    private void atc() {
        if (this.gPT != null) {
            Iterator<Object> it = this.gPT.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
