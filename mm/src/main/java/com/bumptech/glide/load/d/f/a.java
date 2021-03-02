package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.b.b;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat aMf;
    private final int quality;

    public a() {
        this(Bitmap.CompressFormat.JPEG);
    }

    private a(Bitmap.CompressFormat compressFormat) {
        this.aMf = compressFormat;
        this.quality = 100;
    }

    @Override // com.bumptech.glide.load.d.f.e
    public final v<byte[]> a(v<Bitmap> vVar, i iVar) {
        AppMethodBeat.i(77529);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.aMf, this.quality, byteArrayOutputStream);
        vVar.recycle();
        b bVar = new b(byteArrayOutputStream.toByteArray());
        AppMethodBeat.o(77529);
        return bVar;
    }
}
