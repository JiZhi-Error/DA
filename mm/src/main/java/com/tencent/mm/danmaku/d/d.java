package com.tencent.mm.danmaku.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;

public final class d<T> {
    private LruCache<String, T> gQx = new LruCache<String, T>(((int) Runtime.getRuntime().maxMemory()) / 32) {
        /* class com.tencent.mm.danmaku.d.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.util.LruCache
        public final /* synthetic */ int sizeOf(String str, Object obj) {
            int z;
            AppMethodBeat.i(241746);
            if (obj == null) {
                AppMethodBeat.o(241746);
                return 0;
            }
            if (obj instanceof Bitmap) {
                z = d.z((Bitmap) obj);
            } else {
                z = obj instanceof BitmapDrawable ? d.z(((BitmapDrawable) obj).getBitmap()) : 0;
            }
            if (z == 0) {
                AppMethodBeat.o(241746);
                return 0;
            }
            AppMethodBeat.o(241746);
            return z;
        }
    };

    public d() {
        AppMethodBeat.i(241747);
        AppMethodBeat.o(241747);
    }

    static int z(Bitmap bitmap) {
        AppMethodBeat.i(241748);
        if (bitmap == null) {
            AppMethodBeat.o(241748);
            return 0;
        }
        int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        AppMethodBeat.o(241748);
        return rowBytes;
    }

    public final void atl() {
        AppMethodBeat.i(241749);
        if (a.atp()) {
            synchronized (this) {
                try {
                    this.gQx.trimToSize(0);
                } finally {
                    AppMethodBeat.o(241749);
                }
            }
            return;
        }
        AppMethodBeat.o(241749);
    }
}
