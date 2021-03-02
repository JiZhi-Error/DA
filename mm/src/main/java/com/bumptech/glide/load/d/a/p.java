package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.d;
import com.bumptech.glide.g.h;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class p implements j<InputStream, Bitmap> {
    private final b aFo;
    private final h aKM;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ v<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar) {
        AppMethodBeat.i(77433);
        v<Bitmap> a2 = a(inputStream, i2, i3, iVar);
        AppMethodBeat.o(77433);
        return a2;
    }

    public p(h hVar, b bVar) {
        this.aKM = hVar;
        this.aFo = bVar;
    }

    private v<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar) {
        boolean z;
        n nVar;
        AppMethodBeat.i(77432);
        if (inputStream instanceof n) {
            nVar = (n) inputStream;
            z = false;
        } else {
            z = true;
            nVar = new n(inputStream, this.aFo);
        }
        d e2 = d.e(nVar);
        try {
            return this.aKM.a(new h(e2), i2, i3, iVar, new a(nVar, e2));
        } finally {
            e2.release();
            if (z) {
                nVar.release();
            }
            AppMethodBeat.o(77432);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements h.a {
        private final n aFn;
        private final d aLu;

        a(n nVar, d dVar) {
            this.aFn = nVar;
            this.aLu = dVar;
        }

        @Override // com.bumptech.glide.load.d.a.h.a
        public final void pD() {
            AppMethodBeat.i(77430);
            this.aFn.pH();
            AppMethodBeat.o(77430);
        }

        @Override // com.bumptech.glide.load.d.a.h.a
        public final void a(e eVar, Bitmap bitmap) {
            AppMethodBeat.i(77431);
            IOException iOException = this.aLu.aNP;
            if (iOException != null) {
                if (bitmap != null) {
                    eVar.g(bitmap);
                }
                AppMethodBeat.o(77431);
                throw iOException;
            }
            AppMethodBeat.o(77431);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ boolean a(InputStream inputStream, i iVar) {
        return true;
    }
}
