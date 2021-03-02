package com.tencent.matrix.a.b.a;

import android.content.Context;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.f;

public final class h extends a {

    public static class a extends g.a<a> {
        public g.a.c.b<Long> cTA = g.a.c.b.b(0L);
        public g.a.c.b<Long> cTB = g.a.c.b.b(0L);
        public g.a.c.b<Long> cTC = g.a.c.b.b(0L);
        public g.a.c.b<Long> cTD = g.a.c.b.b(0L);
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MIN_VALUE;
    }

    public static a aZ(Context context) {
        f.a bg = f.bg(context);
        if (bg == null) {
            return null;
        }
        a aVar = new a();
        aVar.cTA = g.a.c.b.b(Long.valueOf(bg.cUj));
        aVar.cTB = g.a.c.b.b(Long.valueOf(bg.cUk));
        aVar.cTC = g.a.c.b.b(Long.valueOf(bg.cUl));
        aVar.cTD = g.a.c.b.b(Long.valueOf(bg.cUm));
        return aVar;
    }
}
