package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d {
    private static final b<Bitmap> hYL;
    private static final int hYM = 50;
    private static final int hYO = 524288;
    private static final int hYP = 10;
    private static final b<Bitmap> hYU;
    public static final d hYV;

    static {
        d dVar = new d();
        hYV = dVar;
        hYL = new b<>(hYM, dVar.getClass());
        hYU = new b<>(hYP, dVar.getClass());
    }

    private d() {
    }

    public static int aJy() {
        return hYO;
    }

    public static int aJz() {
        return hYM;
    }

    public static int aJA() {
        return hYP;
    }

    public static b<Bitmap> aJB() {
        return hYL;
    }

    public static b<Bitmap> aJC() {
        return hYU;
    }
}
