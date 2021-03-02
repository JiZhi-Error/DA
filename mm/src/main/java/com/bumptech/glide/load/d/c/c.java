package com.bumptech.glide.load.d.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class c extends b<Drawable> {
    static v<Drawable> u(Drawable drawable) {
        AppMethodBeat.i(77456);
        if (drawable != null) {
            c cVar = new c(drawable);
            AppMethodBeat.o(77456);
            return cVar;
        }
        AppMethodBeat.o(77456);
        return null;
    }

    private c(Drawable drawable) {
        super(drawable);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<android.graphics.drawable.Drawable> */
    @Override // com.bumptech.glide.load.b.v
    public final Class<Drawable> oV() {
        AppMethodBeat.i(77457);
        Class cls = this.drawable.getClass();
        AppMethodBeat.o(77457);
        return cls;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77458);
        int max = Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
        AppMethodBeat.o(77458);
        return max;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
    }
}
