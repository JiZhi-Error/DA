package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"})
public final class b {
    private static final com.tencent.mm.memory.a.b<Bitmap> gVT = new com.tencent.mm.memory.a.b<>(300, b.class);
    public static final b gVU = new b();

    static {
        AppMethodBeat.i(105416);
        AppMethodBeat.o(105416);
    }

    private b() {
    }

    public static Bitmap EP(String str) {
        AppMethodBeat.i(105413);
        Log.d(c.TAG, "get: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(105413);
            return null;
        }
        Bitmap bitmap = gVT.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(105413);
            return null;
        }
        AppMethodBeat.o(105413);
        return bitmap;
    }

    public static void put(String str, Bitmap bitmap) {
        AppMethodBeat.i(105414);
        Log.d(c.TAG, "put: " + str + ", " + bitmap);
        if (str != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                gVT.remove(str);
            } else {
                gVT.put(str, bitmap);
                AppMethodBeat.o(105414);
                return;
            }
        }
        AppMethodBeat.o(105414);
    }

    public static void clear() {
        AppMethodBeat.i(105415);
        gVT.clear();
        AppMethodBeat.o(105415);
    }
}
