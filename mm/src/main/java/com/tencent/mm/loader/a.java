package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.c.c;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0012\u001a\u00020\u0002J@\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2 \u0010\u0014\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001f\u001a\u00020\u0002¨\u0006 "}, hxF = {"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "loadAssert", "assertPath", "loadBitmap", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "loadDrawable", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
public final class a extends d<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(d<String, Bitmap> dVar) {
        super(dVar);
        p.h(dVar, "configuration");
    }

    /* Return type fixed from 'com.tencent.mm.loader.a.b' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.loader.c.e] */
    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b<String, Bitmap> a(String str, e eVar) {
        String str2 = str;
        p.h(str2, "url");
        p.h(eVar, "options");
        com.tencent.mm.loader.a.a aVar = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str2), this.gVF);
        if (eVar.hZE) {
            aVar.a(new com.tencent.mm.loader.e.c.a(new c(0.5f).aJY()));
        }
        aVar.a(eVar);
        return aVar;
    }

    /* Return type fixed from 'com.tencent.mm.loader.a.b' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b<String, Bitmap> bP(String str) {
        String str2 = str;
        p.h(str2, "url");
        return new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str2), this.gVF);
    }

    /* Return type fixed from 'com.tencent.mm.loader.a.b' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.loader.d
    public final /* synthetic */ b<String, Bitmap> bQ(String str) {
        String str2 = str;
        p.h(str2, "url");
        return new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str2), this.gVF);
    }

    public final void a(String str, ImageView imageView, e eVar) {
        p.h(str, "url");
        p.h(imageView, "view");
        p.h(eVar, "options");
        com.tencent.mm.loader.a.a aVar = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str), this.gVF);
        if (eVar.hZE) {
            aVar.a(new com.tencent.mm.loader.e.c.a(new c(0.5f).aJY()));
        }
        aVar.a(eVar).c(imageView);
    }

    public final void a(String str, ImageView imageView, e eVar, m<? super g<?>, ? super Bitmap, x> mVar) {
        p.h(str, "url");
        p.h(imageView, "view");
        p.h(eVar, "options");
        com.tencent.mm.loader.a.a aVar = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str), this.gVF);
        if (eVar.hZE) {
            aVar.a(new com.tencent.mm.loader.e.c.a(new c(0.5f).aJY()));
        }
        aVar.a(eVar);
        aVar.a(imageView, mVar);
    }

    public final b<String, Bitmap> He(String str) {
        p.h(str, "assertPath");
        com.tencent.mm.loader.h.a.a a2 = com.tencent.mm.loader.h.a.a.a(str, com.tencent.mm.loader.h.a.b.ASSET_DATA);
        p.g(a2, "DataItem.create(assertPath, DataType.ASSET_DATA)");
        return new com.tencent.mm.loader.a.a(a2, this.gVF);
    }

    public final b<String, Bitmap> Hf(String str) {
        p.h(str, "filePath");
        com.tencent.mm.loader.h.a.a a2 = com.tencent.mm.loader.h.a.a.a(str, com.tencent.mm.loader.h.a.b.LOCAL_PATH);
        p.g(a2, "DataItem.create(filePath, DataType.LOCAL_PATH)");
        return new com.tencent.mm.loader.a.a(a2, this.gVF);
    }
}
