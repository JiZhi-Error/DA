package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements j<Bitmap, Bitmap> {
    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<Bitmap> a(Bitmap bitmap, int i2, int i3, i iVar) {
        AppMethodBeat.i(77438);
        a aVar = new a(bitmap);
        AppMethodBeat.o(77438);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, i iVar) {
        return true;
    }

    static final class a implements v<Bitmap> {
        private final Bitmap bitmap;

        a(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        @Override // com.bumptech.glide.load.b.v
        public final Class<Bitmap> oV() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.b.v
        public final int getSize() {
            AppMethodBeat.i(77437);
            int k = k.k(this.bitmap);
            AppMethodBeat.o(77437);
            return k;
        }

        @Override // com.bumptech.glide.load.b.v
        public final void recycle() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.load.b.v
        public final /* bridge */ /* synthetic */ Bitmap get() {
            return this.bitmap;
        }
    }
}
