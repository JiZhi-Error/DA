package com.bumptech.glide.load.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.m;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements e<Bitmap, BitmapDrawable> {
    private final Resources aKy;

    public b(Resources resources) {
        AppMethodBeat.i(77530);
        this.aKy = (Resources) j.checkNotNull(resources, "Argument must not be null");
        AppMethodBeat.o(77530);
    }

    @Override // com.bumptech.glide.load.d.f.e
    public final v<BitmapDrawable> a(v<Bitmap> vVar, i iVar) {
        AppMethodBeat.i(77531);
        v<BitmapDrawable> a2 = m.a(this.aKy, vVar);
        AppMethodBeat.o(77531);
        return a2;
    }
}
