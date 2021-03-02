package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.d;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e<Drawable, byte[]> {
    private final e aCj;
    private final e<Bitmap, byte[]> aMg;
    private final e<com.bumptech.glide.load.d.e.c, byte[]> aMh;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.load.d.e.c, byte[]> eVar3) {
        this.aCj = eVar;
        this.aMg = eVar2;
        this.aMh = eVar3;
    }

    @Override // com.bumptech.glide.load.d.f.e
    public final v<byte[]> a(v<Drawable> vVar, i iVar) {
        AppMethodBeat.i(77532);
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            v<byte[]> a2 = this.aMg.a(d.a(((BitmapDrawable) drawable).getBitmap(), this.aCj), iVar);
            AppMethodBeat.o(77532);
            return a2;
        } else if (drawable instanceof com.bumptech.glide.load.d.e.c) {
            v<byte[]> a3 = this.aMh.a(vVar, iVar);
            AppMethodBeat.o(77532);
            return a3;
        } else {
            AppMethodBeat.o(77532);
            return null;
        }
    }
}
