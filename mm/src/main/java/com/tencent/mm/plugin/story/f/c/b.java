package com.tencent.mm.plugin.story.f.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.a.a;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J3\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0002J@\u0010\u0011\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016JL\u0010\u0015\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
public final class b extends a<d> {
    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<d> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(118891);
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "opts");
        p.h(fVar2, "reaper");
        AppMethodBeat.o(118891);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(118892);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        AppMethodBeat.o(118892);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.a, com.tencent.mm.loader.b.a.d
    public final String c(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(118893);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        String kX = com.tencent.mm.plugin.story.f.l.FmK.kX(aVar.value().FoD.Id, aVar.value().username);
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
        com.tencent.mm.plugin.story.f.l.aLP(kX);
        AppMethodBeat.o(118893);
        return kX;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(118894);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        String c2 = c(aVar, eVar, fVar);
        boolean YS = s.YS(c2);
        Log.i(g.getTAG(), "url " + aVar + " and path " + c2 + " ret " + YS);
        if (YS) {
            com.tencent.mm.loader.h.b.a Hk = com.tencent.mm.loader.h.b.a.Hk(c2);
            AppMethodBeat.o(118894);
            return Hk;
        }
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
        String aRV = com.tencent.mm.plugin.story.f.l.aRV(aVar.value().FoD.Id);
        boolean YS2 = s.YS(aRV);
        Log.i(g.getTAG(), "thumb url " + aVar + " and path " + c2 + " ret " + YS2);
        if (YS2) {
            com.tencent.mm.loader.h.b.a Hk2 = com.tencent.mm.loader.h.b.a.Hk(aRV);
            AppMethodBeat.o(118894);
            return Hk2;
        }
        AppMethodBeat.o(118894);
        return null;
    }
}
