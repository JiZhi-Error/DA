package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.d;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h implements j<a, Bitmap> {
    private final e aCj;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<Bitmap> a(a aVar, int i2, int i3, i iVar) {
        AppMethodBeat.i(77524);
        d a2 = d.a(aVar.oj(), this.aCj);
        AppMethodBeat.o(77524);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ boolean a(a aVar, i iVar) {
        return true;
    }

    public h(e eVar) {
        this.aCj = eVar;
    }
}
