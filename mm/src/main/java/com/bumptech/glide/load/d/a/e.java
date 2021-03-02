package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class e implements j<ByteBuffer, Bitmap> {
    private final h aKM;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, i iVar) {
        AppMethodBeat.i(77361);
        v<Bitmap> a2 = this.aKM.a(a.d(byteBuffer), i2, i3, iVar, h.aLh);
        AppMethodBeat.o(77361);
        return a2;
    }

    public e(h hVar) {
        this.aKM = hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, i iVar) {
        return true;
    }
}
