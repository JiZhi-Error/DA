package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> bat = new HashMap(3);
    SparseArray<Map<BitmapType, com.github.henryye.nativeiv.bitmap.b>> bau = new SparseArray<>();

    public b() {
        AppMethodBeat.i(127329);
        this.bat.put(BitmapType.Native, new com.github.henryye.nativeiv.bitmap.b() {
            /* class com.github.henryye.nativeiv.b.AnonymousClass1 */

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final IBitmap sP() {
                AppMethodBeat.i(127326);
                c.b bVar = new c.b();
                AppMethodBeat.o(127326);
                return bVar;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final boolean a(com.github.henryye.nativeiv.bitmap.c cVar) {
                return false;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final void destroy() {
            }
        });
        this.bat.put(BitmapType.Legacy, new com.github.henryye.nativeiv.bitmap.b<Bitmap>() {
            /* class com.github.henryye.nativeiv.b.AnonymousClass2 */

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final IBitmap<Bitmap> sP() {
                AppMethodBeat.i(127327);
                LegacyBitmap legacyBitmap = new LegacyBitmap();
                AppMethodBeat.o(127327);
                return legacyBitmap;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final boolean a(com.github.henryye.nativeiv.bitmap.c cVar) {
                return true;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final void destroy() {
            }
        });
        this.bat.put(BitmapType.Undefined, new com.github.henryye.nativeiv.bitmap.b() {
            /* class com.github.henryye.nativeiv.b.AnonymousClass3 */

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final IBitmap sP() {
                AppMethodBeat.i(127328);
                c.a aVar = new c.a();
                AppMethodBeat.o(127328);
                return aVar;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final boolean a(com.github.henryye.nativeiv.bitmap.c cVar) {
                return true;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final void destroy() {
            }
        });
        AppMethodBeat.o(127329);
    }

    static void b(Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> map) {
        AppMethodBeat.i(127330);
        if (map == null) {
            AppMethodBeat.o(127330);
            return;
        }
        for (com.github.henryye.nativeiv.bitmap.b bVar : map.values()) {
            bVar.destroy();
        }
        AppMethodBeat.o(127330);
    }

    static IBitmap a(com.github.henryye.nativeiv.bitmap.c cVar, Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> map) {
        AppMethodBeat.i(127331);
        if (map.get(BitmapType.Native).a(cVar)) {
            IBitmap sP = map.get(BitmapType.Native).sP();
            AppMethodBeat.o(127331);
            return sP;
        } else if (map.get(BitmapType.Legacy).a(cVar)) {
            IBitmap sP2 = map.get(BitmapType.Legacy).sP();
            AppMethodBeat.o(127331);
            return sP2;
        } else {
            IBitmap sP3 = map.get(BitmapType.Undefined).sP();
            AppMethodBeat.o(127331);
            return sP3;
        }
    }
}
