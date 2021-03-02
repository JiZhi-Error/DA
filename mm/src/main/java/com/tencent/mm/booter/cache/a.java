package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.cache.h;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.IniParser;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends h.a {
    public static a gnv;
    private final f<String, Bitmap> gnw;

    private a() {
        String str;
        AppMethodBeat.i(19918);
        Context context = MMApplicationContext.getContext();
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = IniParser.parse(Util.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Exception e2) {
                Log.e("MicroMsg.ProfileUtil", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        if (com.tencent.mm.platformtools.a.a.values == null) {
            str = null;
        } else {
            str = com.tencent.mm.platformtools.a.a.values.get("BACKGROUND_BITMAP_CACHE_LIMIT");
        }
        this.gnw = new b(Util.getInt(str, 2000), getClass());
        AppMethodBeat.o(19918);
    }

    public static void prepare() {
        AppMethodBeat.i(19919);
        if (gnv == null) {
            gnv = new a();
        }
        AppMethodBeat.o(19919);
    }

    public static void destroy() {
        AppMethodBeat.i(19920);
        if (gnv == null) {
            AppMethodBeat.o(19920);
            return;
        }
        gnv.gnw.clear();
        AppMethodBeat.o(19920);
    }

    @Override // com.tencent.mm.cache.h
    public final Bitmap getBitmap(String str) {
        AppMethodBeat.i(19921);
        Log.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        Bitmap bitmap = this.gnw.get(str);
        AppMethodBeat.o(19921);
        return bitmap;
    }

    @Override // com.tencent.mm.cache.h
    public final MCacheItem CV(String str) {
        AppMethodBeat.i(19922);
        Log.v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        AppMethodBeat.o(19922);
        return null;
    }

    @Override // com.tencent.mm.cache.h
    public final void b(String str, Bitmap bitmap) {
        AppMethodBeat.i(19923);
        Log.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.gnw.x(str, bitmap);
        AppMethodBeat.o(19923);
    }

    @Override // com.tencent.mm.cache.h
    public final void CW(String str) {
        AppMethodBeat.i(19924);
        Log.v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
        AppMethodBeat.o(19924);
    }
}
