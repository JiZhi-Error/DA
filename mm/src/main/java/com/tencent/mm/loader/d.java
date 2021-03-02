package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ=\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J%\u0010\t\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0014J)\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/loader/Loader;", "T", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "getConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "urlThumb", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Ljava/lang/Object;Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "", "(Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "(Ljava/lang/Object;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "loadLocal", "libimageloader_release"})
public abstract class d<T> {
    public final com.tencent.mm.loader.c.d<T, Bitmap> gVF;

    public abstract b<T, Bitmap> a(T t, e eVar);

    public abstract void a(T t, ImageView imageView, e eVar);

    public abstract b<T, Bitmap> bP(T t);

    public abstract b<T, Bitmap> bQ(T t);

    public d(com.tencent.mm.loader.c.d<T, Bitmap> dVar) {
        p.h(dVar, "configuration");
        this.gVF = dVar;
    }
}
