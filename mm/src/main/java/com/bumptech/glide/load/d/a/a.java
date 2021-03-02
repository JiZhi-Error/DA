package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<DataType> implements j<DataType, BitmapDrawable> {
    private final j<DataType, Bitmap> aKJ;
    private final Resources aKy;

    public a(Resources resources, j<DataType, Bitmap> jVar) {
        AppMethodBeat.i(77348);
        this.aKy = (Resources) com.bumptech.glide.g.j.checkNotNull(resources, "Argument must not be null");
        this.aKJ = (j) com.bumptech.glide.g.j.checkNotNull(jVar, "Argument must not be null");
        AppMethodBeat.o(77348);
    }

    @Override // com.bumptech.glide.load.j
    public final boolean a(DataType datatype, i iVar) {
        AppMethodBeat.i(77349);
        boolean a2 = this.aKJ.a(datatype, iVar);
        AppMethodBeat.o(77349);
        return a2;
    }

    @Override // com.bumptech.glide.load.j
    public final v<BitmapDrawable> a(DataType datatype, int i2, int i3, i iVar) {
        AppMethodBeat.i(77350);
        v<BitmapDrawable> a2 = m.a(this.aKy, this.aKJ.a(datatype, i2, i3, iVar));
        AppMethodBeat.o(77350);
        return a2;
    }
}
