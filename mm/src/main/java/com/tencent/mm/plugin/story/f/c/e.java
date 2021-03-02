package com.tencent.mm.plugin.story.f.c;

import android.graphics.drawable.ColorDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.e.a;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e {
    public d<d> FoE;
    private final a FoF = new a();
    public final com.tencent.mm.loader.c.e FoG;
    public final com.tencent.mm.loader.c.e FoH;

    public e() {
        AppMethodBeat.i(118905);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        this.FoG = aVar.aJT();
        e.a aVar2 = new e.a();
        aVar2.hZJ = true;
        aVar2.hZI = true;
        e.a w = aVar2.w(new ColorDrawable(MMApplicationContext.getContext().getResources().getColor(R.color.f3046d)));
        w.hZN = ((a.C1744a) com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNY;
        w.hZM = ((a.C1744a) com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNZ;
        this.FoH = w.aJT();
        com.tencent.mm.loader.c.d aJE = new com.tencent.mm.loader.c.a().a(new b()).a(new c()).a(this.FoF).a(new com.tencent.mm.loader.b.b.a()).b(this.FoG).aJE();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        this.FoE = com.tencent.mm.loader.e.a(aJE);
        AppMethodBeat.o(118905);
    }
}
