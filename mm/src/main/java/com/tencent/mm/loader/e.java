package com.tencent.mm.loader;

import android.graphics.Bitmap;
import com.tencent.mm.loader.c.c;
import com.tencent.mm.loader.c.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u000b0\nJ \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "defaultImageLoader", "Lcom/tencent/mm/loader/DefaultImageLoader;", "instance", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "instanceDefault", "", "newInstance", "libimageloader_release"})
public final class e {
    private static a hXT = new a(new c());
    public static final e hXU = new e();

    private e() {
    }

    public static <T extends com.tencent.mm.loader.h.a.c> d<T> a(d<T, Bitmap> dVar) {
        p.h(dVar, "configuration");
        return new c(dVar);
    }

    public static a aJs() {
        return hXT;
    }
}
