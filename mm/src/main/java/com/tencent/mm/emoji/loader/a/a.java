package com.tencent.mm.emoji.loader.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a {
    private static final String TAG = TAG;
    private static final LruCache<String, WeakReference<Drawable>> cache = new LruCache<>(20);
    public static final a gVS = new a();

    static {
        AppMethodBeat.i(105412);
        AppMethodBeat.o(105412);
    }

    private a() {
    }

    public static Drawable EO(String str) {
        AppMethodBeat.i(105410);
        Log.i(TAG, "get ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(105410);
            return null;
        }
        WeakReference<Drawable> weakReference = cache.get(str);
        if (weakReference != null) {
            Drawable drawable = weakReference.get();
            AppMethodBeat.o(105410);
            return drawable;
        }
        AppMethodBeat.o(105410);
        return null;
    }

    public static void put(String str, Drawable drawable) {
        AppMethodBeat.i(105411);
        Log.i(TAG, "put ".concat(String.valueOf(str)));
        if (str != null) {
            if (drawable != null) {
                cache.put(str, new WeakReference<>(drawable));
                AppMethodBeat.o(105411);
                return;
            }
            cache.remove(str);
        }
        AppMethodBeat.o(105411);
    }
}
