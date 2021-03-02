package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends e<String, Bitmap> {
    public static final int hYM = d.aJz();
    public static final int hYO = d.aJy();
    public static final int hYP = d.aJA();
    private f<String, Bitmap> hYQ = d.aJB();
    private f<String, Bitmap> hYR;

    public b() {
        d dVar = d.hYV;
        d dVar2 = d.hYV;
        this.hYR = d.aJC();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.c.a, java.lang.Object] */
    @Override // com.tencent.mm.loader.b.b.e
    public final /* synthetic */ void a(a<String> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (aVar == null) {
            return;
        }
        if (Util.isNullOrNil(aVar.value())) {
            Log.w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap2 == null) {
            Log.w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long bR = com.tencent.mm.loader.l.a.bR(bitmap2);
            Log.d("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", aVar.value(), Long.valueOf(bR), Util.getSizeKB(bR));
            if (bR > ((long) hYO)) {
                this.hYR.put(b(aVar, aVar2), bitmap2);
            } else {
                this.hYQ.put(b(aVar, aVar2), bitmap2);
            }
        }
    }

    static {
        d dVar = d.hYV;
        d dVar2 = d.hYV;
        d dVar3 = d.hYV;
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final e<Bitmap> a(a<String> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2) {
        Bitmap bitmap;
        if (!Util.isNullOrNil(aVar.value())) {
            String b2 = b(aVar, aVar2);
            Bitmap bitmap2 = this.hYQ.get(b2);
            if (bitmap2 == null) {
                bitmap = this.hYR.get(b2);
            } else {
                bitmap = bitmap2;
            }
            if (bitmap != null) {
                return new e<>(bitmap);
            }
        }
        return null;
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final void a(a<String> aVar) {
        this.hYQ.remove(aVar.value());
        this.hYR.remove(aVar.value());
    }
}
