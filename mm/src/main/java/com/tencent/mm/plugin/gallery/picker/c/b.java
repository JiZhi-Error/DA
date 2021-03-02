package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J/\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0002J.\u0010\u000f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J&\u0010\u0011\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapMemoryCache;", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "plugin-gallery_release"})
public final class b extends e<GalleryItem.MediaItem, Bitmap> {
    private static final String TAG = TAG;
    public static final a xlk = new a((byte) 0);
    private final com.tencent.mm.memory.a.b<Bitmap> hYL = new com.tencent.mm.memory.a.b<>(200, getClass());

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(164897);
        AppMethodBeat.o(164897);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.c.a, java.lang.Object] */
    @Override // com.tencent.mm.loader.b.b.e
    public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2, Bitmap bitmap) {
        AppMethodBeat.i(164896);
        Bitmap bitmap2 = bitmap;
        p.h(aVar, "url");
        p.h(bitmap2, "value");
        this.hYL.put(b(aVar, aVar2), bitmap2);
        AppMethodBeat.o(164896);
    }

    static {
        AppMethodBeat.i(164898);
        AppMethodBeat.o(164898);
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2) {
        AppMethodBeat.i(164895);
        p.h(aVar, "url");
        Bitmap bitmap = this.hYL.get(b(aVar, aVar2));
        if (bitmap != null) {
            com.tencent.mm.loader.h.e<Bitmap> eVar = new com.tencent.mm.loader.h.e<>(bitmap);
            AppMethodBeat.o(164895);
            return eVar;
        }
        AppMethodBeat.o(164895);
        return null;
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final void a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar) {
        AppMethodBeat.i(257776);
        p.h(aVar, "url");
        this.hYL.remove(b(aVar, null));
        AppMethodBeat.o(257776);
    }
}
