package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016J3\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n0\tH\u0002J@\u0010\u000f\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016JL\u0010\u0013\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016JZ\u0010\u0017\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "plugin-gallery_release"})
public final class a extends com.tencent.mm.loader.b.a.a<GalleryItem.MediaItem> {
    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(164891);
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "opts");
        p.h(fVar2, "reaper");
        AppMethodBeat.o(164891);
        return false;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(164892);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        AppMethodBeat.o(164892);
        return false;
    }

    @Override // com.tencent.mm.loader.b.a.a, com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, f<?> fVar, com.tencent.mm.loader.h.e<Bitmap> eVar, com.tencent.mm.loader.h.e<Bitmap> eVar2, e eVar3, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(164893);
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "source");
        p.h(eVar3, "opts");
        p.h(fVar2, "reaper");
        AppMethodBeat.o(164893);
        return false;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(164894);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        com.tencent.mm.loader.h.b.a j2 = com.tencent.mm.loader.h.b.a.j(aVar.value().xiW, aVar.value());
        AppMethodBeat.o(164894);
        return j2;
    }
}
