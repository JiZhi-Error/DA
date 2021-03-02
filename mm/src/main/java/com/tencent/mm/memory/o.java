package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class o extends e<Bitmap, b> {
    public static o itM = new o();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Bitmap b(b bVar) {
        AppMethodBeat.i(156462);
        Bitmap a2 = a(bVar);
        AppMethodBeat.o(156462);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Bitmap bitmap) {
        AppMethodBeat.i(156457);
        f(bitmap);
        AppMethodBeat.o(156457);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ long bV(Bitmap bitmap) {
        int allocationByteCount;
        AppMethodBeat.i(156458);
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            AppMethodBeat.o(156458);
            return 0;
        }
        if (d.oE(19)) {
            allocationByteCount = bitmap2.getByteCount();
        } else {
            allocationByteCount = bitmap2.getAllocationByteCount();
        }
        long j2 = (long) allocationByteCount;
        AppMethodBeat.o(156458);
        return j2;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ b bW(Bitmap bitmap) {
        AppMethodBeat.i(156459);
        Bitmap bitmap2 = bitmap;
        b bVar = new b(bitmap2.getWidth(), bitmap2.getHeight());
        AppMethodBeat.o(156459);
        return bVar;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ b c(b bVar) {
        return bVar;
    }

    /* Return type fixed from 'com.tencent.mm.memory.d' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ d<Bitmap, b> d(b bVar) {
        AppMethodBeat.i(156460);
        a aVar = new a(bVar);
        AppMethodBeat.o(156460);
        return aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Bitmap e(b bVar) {
        AppMethodBeat.i(156461);
        Bitmap b2 = b(bVar);
        AppMethodBeat.o(156461);
        return b2;
    }

    static {
        AppMethodBeat.i(156463);
        AppMethodBeat.o(156463);
    }

    private o() {
    }

    public final synchronized Bitmap a(b bVar) {
        Bitmap bitmap;
        AppMethodBeat.i(156454);
        bitmap = (Bitmap) super.b((Comparable) bVar);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = b(bVar);
        }
        AppMethodBeat.o(156454);
        return bitmap;
    }

    public final synchronized void f(Bitmap bitmap) {
        AppMethodBeat.i(156455);
        if (bitmap != null && !bitmap.isRecycled()) {
            super.bU(bitmap);
        }
        AppMethodBeat.o(156455);
    }

    private static Bitmap b(b bVar) {
        AppMethodBeat.i(156456);
        Bitmap createBitmap = Bitmap.createBitmap(bVar.width, bVar.height, k.itA);
        AppMethodBeat.o(156456);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        return 1228800;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 307200;
    }

    static class a extends d<Bitmap, b> {
        public a(b bVar) {
            super(bVar);
        }
    }

    public static class b implements Comparable {
        public int height;
        private String itN;
        public int width;

        public b(int i2, int i3) {
            AppMethodBeat.i(156453);
            this.width = i2;
            this.height = i3;
            this.itN = String.format("SightBitmapSize: [%s, %s]", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(156453);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            if (obj == null) {
                return 0;
            }
            if (!(obj instanceof b)) {
                return 0;
            }
            if (this.width == ((b) obj).width && this.height == ((b) obj).height) {
                return 0;
            }
            if (this.height * this.width > ((b) obj).width * ((b) obj).height) {
                return 1;
            }
            return -1;
        }

        public final String toString() {
            return this.itN;
        }
    }
}
