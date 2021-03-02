package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.c.d;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o implements j<Uri, Bitmap> {
    private final e aCj;
    private final d aLt;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<Bitmap> a(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77428);
        v<Drawable> m = this.aLt.m(uri);
        if (m == null) {
            AppMethodBeat.o(77428);
            return null;
        }
        v<Bitmap> a2 = i.a(this.aCj, m.get(), i2, i3);
        AppMethodBeat.o(77428);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ boolean a(Uri uri, i iVar) {
        AppMethodBeat.i(77429);
        boolean equals = "android.resource".equals(uri.getScheme());
        AppMethodBeat.o(77429);
        return equals;
    }

    public o(d dVar, e eVar) {
        this.aLt = dVar;
        this.aCj = eVar;
    }
}
