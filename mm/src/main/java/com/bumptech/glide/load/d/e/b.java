package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements a.AbstractC0062a {
    private final e aCj;
    private final com.bumptech.glide.load.b.a.b aCo;

    public b(e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this.aCj = eVar;
        this.aCo = bVar;
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77476);
        Bitmap g2 = this.aCj.g(i2, i3, config);
        AppMethodBeat.o(77476);
        return g2;
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final void f(Bitmap bitmap) {
        AppMethodBeat.i(77477);
        this.aCj.g(bitmap);
        AppMethodBeat.o(77477);
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final byte[] de(int i2) {
        AppMethodBeat.i(77478);
        if (this.aCo == null) {
            byte[] bArr = new byte[i2];
            AppMethodBeat.o(77478);
            return bArr;
        }
        byte[] bArr2 = (byte[]) this.aCo.a(i2, byte[].class);
        AppMethodBeat.o(77478);
        return bArr2;
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final void k(byte[] bArr) {
        AppMethodBeat.i(77479);
        if (this.aCo == null) {
            AppMethodBeat.o(77479);
            return;
        }
        this.aCo.put(bArr);
        AppMethodBeat.o(77479);
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final int[] df(int i2) {
        AppMethodBeat.i(77480);
        if (this.aCo == null) {
            int[] iArr = new int[i2];
            AppMethodBeat.o(77480);
            return iArr;
        }
        int[] iArr2 = (int[]) this.aCo.a(i2, int[].class);
        AppMethodBeat.o(77480);
        return iArr2;
    }

    @Override // com.bumptech.glide.b.a.AbstractC0062a
    public final void p(int[] iArr) {
        AppMethodBeat.i(77481);
        if (this.aCo == null) {
            AppMethodBeat.o(77481);
            return;
        }
        this.aCo.put(iArr);
        AppMethodBeat.o(77481);
    }
}
