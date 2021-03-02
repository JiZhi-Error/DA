package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaThumbProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
public final class d extends b {
    @Override // com.tencent.mm.loader.d.d
    public final e<Bitmap> a(g<?> gVar, f<?, Bitmap> fVar, a aVar) {
        Bitmap hB;
        AppMethodBeat.i(164900);
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(aVar, "input");
        Object tag = aVar.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
            AppMethodBeat.o(164900);
            throw tVar;
        }
        GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) tag;
        if (mediaItem.getType() == 2) {
            hB = n.a(mediaItem.xiZ, mediaItem.getType(), mediaItem.xiW, mediaItem.xiW);
        } else if (mediaItem.xjd) {
            hB = n.hB(mediaItem.xiW, mediaItem.xiW);
        } else {
            Bitmap aw = n.aw(mediaItem.xiW, mediaItem.xiZ);
            hB = aw == null ? n.hB(mediaItem.xiW, mediaItem.xiW) : aw;
        }
        e<Bitmap> eVar = new e<>(hB);
        AppMethodBeat.o(164900);
        return eVar;
    }
}
