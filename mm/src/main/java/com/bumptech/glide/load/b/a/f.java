package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f implements e {
    @Override // com.bumptech.glide.load.b.a.e
    public void g(Bitmap bitmap) {
        AppMethodBeat.i(77080);
        bitmap.recycle();
        AppMethodBeat.o(77080);
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77081);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        AppMethodBeat.o(77081);
        return createBitmap;
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final void oZ() {
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final void trimMemory(int i2) {
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final Bitmap g(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77082);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        AppMethodBeat.o(77082);
        return createBitmap;
    }
}
