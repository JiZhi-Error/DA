package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/UnusedImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-gallery_release"})
public final class g extends b<GalleryItem.MediaItem> {
    @Override // com.tencent.mm.loader.d.b
    public final void a(a<GalleryItem.MediaItem> aVar, com.tencent.mm.loader.f.g gVar, b.AbstractC0401b bVar) {
        AppMethodBeat.i(164912);
        p.h(aVar, "url");
        p.h(gVar, "fileNameCreator");
        p.h(bVar, "callback");
        AppMethodBeat.o(164912);
    }
}
