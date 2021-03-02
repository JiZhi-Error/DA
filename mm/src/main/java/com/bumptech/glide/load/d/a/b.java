package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b implements k<BitmapDrawable> {
    private final e aCj;
    private final k<Bitmap> aGF;

    @Override // com.bumptech.glide.load.d
    public final /* synthetic */ boolean a(Object obj, File file, i iVar) {
        AppMethodBeat.i(77352);
        boolean a2 = this.aGF.a(new d(((BitmapDrawable) ((v) obj).get()).getBitmap(), this.aCj), file, iVar);
        AppMethodBeat.o(77352);
        return a2;
    }

    public b(e eVar, k<Bitmap> kVar) {
        this.aCj = eVar;
        this.aGF = kVar;
    }

    @Override // com.bumptech.glide.load.k
    public final c b(i iVar) {
        AppMethodBeat.i(77351);
        c b2 = this.aGF.b(iVar);
        AppMethodBeat.o(77351);
        return b2;
    }
}
