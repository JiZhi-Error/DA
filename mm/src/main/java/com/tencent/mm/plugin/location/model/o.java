package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o implements a {
    private Bitmap pqA = null;
    private f<String, Bitmap> yGD = new b(20, getClass());

    public o() {
        AppMethodBeat.i(55750);
        AppMethodBeat.o(55750);
    }

    @Override // com.tencent.mm.bx.a.a
    public final synchronized Bitmap aCX(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(55751);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(55751);
            bitmap = null;
        } else {
            bitmap = this.yGD.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.o(55751);
                bitmap = null;
            } else {
                AppMethodBeat.o(55751);
            }
        }
        return bitmap;
    }

    @Override // com.tencent.mm.bx.a.a
    public final synchronized void p(String str, Bitmap bitmap) {
        AppMethodBeat.i(55752);
        if (this.yGD.get(str) != null) {
            Bitmap bitmap2 = this.yGD.get(str);
            if (!bitmap2.isRecycled()) {
                Log.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", bitmap2.toString());
                bitmap2.recycle();
            }
            this.yGD.remove(str);
        }
        this.yGD.put(str, bitmap);
        Log.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", str, Integer.valueOf(this.yGD.size()));
        AppMethodBeat.o(55752);
    }

    @Override // com.tencent.mm.bx.a.a
    public final synchronized void aer(String str) {
        AppMethodBeat.i(55753);
        Log.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", str);
        for (String str2 : this.yGD.snapshot().keySet()) {
            if (str2.startsWith(str)) {
                this.yGD.remove(str2);
            }
        }
        AppMethodBeat.o(55753);
    }
}
