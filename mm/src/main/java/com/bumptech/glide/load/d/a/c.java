package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c implements k<Bitmap> {
    public static final h<Integer> aKK = h.c("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final h<Bitmap.CompressFormat> aKL = h.Q("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final b aCo;

    @Override // com.bumptech.glide.load.d
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, i iVar) {
        AppMethodBeat.i(77354);
        boolean a2 = a((v) obj, file, iVar);
        AppMethodBeat.o(77354);
        return a2;
    }

    static {
        AppMethodBeat.i(77355);
        AppMethodBeat.o(77355);
    }

    public c(b bVar) {
        this.aCo = bVar;
    }

    @Deprecated
    public c() {
        this.aCo = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8 A[SYNTHETIC, Splitter:B:35:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4 A[SYNTHETIC, Splitter:B:43:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.bumptech.glide.load.b.v<android.graphics.Bitmap> r11, java.io.File r12, com.bumptech.glide.load.i r13) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.c.a(com.bumptech.glide.load.b.v, java.io.File, com.bumptech.glide.load.i):boolean");
    }

    @Override // com.bumptech.glide.load.k
    public final com.bumptech.glide.load.c b(i iVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }
}
