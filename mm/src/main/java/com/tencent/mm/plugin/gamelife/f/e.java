package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.a;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.c.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-gamelife_release"})
public final class e {
    private static final com.tencent.mm.loader.c.e gVE;
    private static final d<a, Bitmap> gVF = new a().a(new b()).a(new com.tencent.mm.loader.b.b.a()).a(new c()).b(gVE).b(new c(0.1f).aJY()).aJE();
    private static final com.tencent.mm.loader.d<a> gVG = com.tencent.mm.loader.e.a(gVF);
    public static final e ycg = new e();

    static {
        AppMethodBeat.i(241389);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        aVar.hZN = 132;
        aVar.hZM = 132;
        gVE = aVar.aJT();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        AppMethodBeat.o(241389);
    }

    private e() {
    }

    public static com.tencent.mm.loader.d<a> getLoader() {
        return gVG;
    }
}
