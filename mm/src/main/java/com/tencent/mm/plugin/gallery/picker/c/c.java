package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaHDProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
public final class c extends b {
    @Override // com.tencent.mm.loader.d.d
    public final e<Bitmap> a(g<?> gVar, f<?, Bitmap> fVar, a aVar) {
        AppMethodBeat.i(164899);
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(aVar, "input");
        Object tag = aVar.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
            AppMethodBeat.o(164899);
            throw tVar;
        }
        GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) tag;
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(mediaItem.xiW, fVar.hXX.hZA, fVar.hXX.hZz, false);
        int checkDegree = BitmapUtil.checkDegree(mediaItem.xiW);
        Bitmap handleDegree = BitmapUtil.handleDegree(BitmapUtil.checkDegree(mediaItem.xiW), extractThumbNail);
        StringBuilder sb = new StringBuilder("bitmapW=");
        p.g(handleDegree, "result");
        Log.i("MicroMsg.Loader.ImageBitmapProducer", sb.append(handleDegree.getWidth()).append(" bitmapH=").append(handleDegree.getHeight()).append(" degree=").append(checkDegree).toString());
        e<Bitmap> eVar = new e<>(handleDegree);
        AppMethodBeat.o(164899);
        return eVar;
    }
}
