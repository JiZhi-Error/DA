package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.a;
import com.tencent.mm.loader.c.b;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerThumbLoader;", "", "()V", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "plugin-sticker_release"})
public final class h {
    public static final h NNV = new h();
    private static final d<a> gVG;

    static {
        AppMethodBeat.i(105950);
        b a2 = new a().a(new c()).a(new b());
        e.a aVar = new e.a();
        aVar.hZJ = true;
        com.tencent.mm.loader.c.d aJE = a2.b(aVar.aJT()).aJE();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        gVG = com.tencent.mm.loader.e.a(aJE);
        AppMethodBeat.o(105950);
    }

    private h() {
    }

    public static d<a> getLoader() {
        return gVG;
    }
}
