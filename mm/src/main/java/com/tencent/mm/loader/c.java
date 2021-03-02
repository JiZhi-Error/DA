package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0017B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J%\u0010\b\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0013J)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/loader/ImageLoader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "Lcom/tencent/mm/loader/Loader;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "url", "(Lcom/tencent/mm/loader/model/data/ILoaderData;)Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Lcom/tencent/mm/loader/model/data/ILoaderData;Lcom/tencent/mm/loader/model/data/ILoaderData;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "", "(Lcom/tencent/mm/loader/model/data/ILoaderData;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "(Lcom/tencent/mm/loader/model/data/ILoaderData;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "loadLocal", "Companion", "libimageloader_release"})
public final class c<T extends com.tencent.mm.loader.h.a.c> extends d<T> {
    public static final a hXS = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d<T, Bitmap> dVar) {
        super(dVar);
        p.h(dVar, "configuration");
    }

    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b a(Object obj, e eVar) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        p.h(cVar, "url");
        p.h(eVar, "options");
        com.tencent.mm.loader.a.a aVar = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(cVar), this.gVF);
        aVar.a(eVar);
        return aVar;
    }

    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ void a(Object obj, ImageView imageView, e eVar) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        p.h(cVar, "url");
        p.h(imageView, "view");
        p.h(eVar, "options");
        new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(cVar), this.gVF).a(eVar).c(imageView);
    }

    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b bP(Object obj) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        p.h(cVar, "url");
        return new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(cVar), this.gVF);
    }

    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b bQ(Object obj) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        p.h(cVar, "url");
        return new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(cVar), this.gVF);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/ImageLoader$Companion;", "", "()V", "TAG2", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
