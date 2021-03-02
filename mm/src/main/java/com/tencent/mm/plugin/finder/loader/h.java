package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.a.a;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J3\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0002J@\u0010\u0011\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016JL\u0010\u0015\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-finder_release"})
public final class h extends a<o> {
    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<o> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(166311);
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "opts");
        p.h(fVar2, "reaper");
        AppMethodBeat.o(166311);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<o> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(166312);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        AppMethodBeat.o(166312);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.a, com.tencent.mm.loader.b.a.d
    public final String c(com.tencent.mm.loader.h.a.a<o> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(166313);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        String path = aVar.value().getPath();
        AppMethodBeat.o(166313);
        return path;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<o> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(166314);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        String c2 = c(aVar, eVar, fVar);
        Log.v("Finder.Loader", "url " + aVar + " and path " + c2 + " fileret " + s.YS(c2) + " type " + aVar.value().djU());
        if (s.YS(c2)) {
            com.tencent.mm.loader.h.b.a Hk = com.tencent.mm.loader.h.b.a.Hk(c2);
            AppMethodBeat.o(166314);
            return Hk;
        }
        if (aVar.value().djU() == x.THUMB_IMAGE) {
            if (s.YS(aVar.value().aBE())) {
                com.tencent.mm.loader.h.b.a Hk2 = com.tencent.mm.loader.h.b.a.Hk(aVar.value().aBE());
                AppMethodBeat.o(166314);
                return Hk2;
            }
        } else if (s.YS(aVar.value().getUrl())) {
            com.tencent.mm.loader.h.b.a Hk3 = com.tencent.mm.loader.h.b.a.Hk(aVar.value().getUrl());
            AppMethodBeat.o(166314);
            return Hk3;
        }
        AppMethodBeat.o(166314);
        return null;
    }
}
