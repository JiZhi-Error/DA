package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements r, v<Bitmap> {
    private final e aCj;
    private final Bitmap bitmap;

    public static d a(Bitmap bitmap2, e eVar) {
        AppMethodBeat.i(77356);
        if (bitmap2 == null) {
            AppMethodBeat.o(77356);
            return null;
        }
        d dVar = new d(bitmap2, eVar);
        AppMethodBeat.o(77356);
        return dVar;
    }

    public d(Bitmap bitmap2, e eVar) {
        AppMethodBeat.i(77357);
        this.bitmap = (Bitmap) j.checkNotNull(bitmap2, "Bitmap must not be null");
        this.aCj = (e) j.checkNotNull(eVar, "BitmapPool must not be null");
        AppMethodBeat.o(77357);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<Bitmap> oV() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77358);
        int k = k.k(this.bitmap);
        AppMethodBeat.o(77358);
        return k;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
        AppMethodBeat.i(77359);
        this.aCj.g(this.bitmap);
        AppMethodBeat.o(77359);
    }

    @Override // com.bumptech.glide.load.b.r
    public final void initialize() {
        AppMethodBeat.i(77360);
        this.bitmap.prepareToDraw();
        AppMethodBeat.o(77360);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.b.v
    public final /* bridge */ /* synthetic */ Bitmap get() {
        return this.bitmap;
    }
}
