package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static final Object baw = new Object();
    b baA;
    BitmapType bar = null;
    IBitmap bax = new a();
    IImageDecodeService.b bay;
    com.github.henryye.nativeiv.api.a baz;

    static {
        AppMethodBeat.i(127335);
        AppMethodBeat.o(127335);
    }

    public c(b bVar, com.github.henryye.nativeiv.api.a aVar) {
        AppMethodBeat.i(127334);
        this.baA = bVar;
        this.baz = aVar;
        AppMethodBeat.o(127334);
    }

    public final d h(InputStream inputStream) {
        AppMethodBeat.i(219794);
        sQ();
        if (inputStream != null) {
            d i2 = i(inputStream);
            AppMethodBeat.o(219794);
            return i2;
        }
        AppMethodBeat.o(219794);
        return null;
    }

    /* access modifiers changed from: protected */
    public d i(InputStream inputStream) {
        AppMethodBeat.i(219795);
        d k = com.github.henryye.nativeiv.c.d.k(inputStream);
        AppMethodBeat.o(219795);
        return k;
    }

    private void sQ() {
        AppMethodBeat.i(219796);
        if (this.bax != null) {
            this.bax.recycle();
        }
        AppMethodBeat.o(219796);
    }

    public final void forceSetUseType(BitmapType bitmapType) {
        this.bar = bitmapType;
    }

    public final void a(com.github.henryye.nativeiv.bitmap.b<Bitmap> bVar) {
        AppMethodBeat.i(219797);
        BitmapType bitmapType = BitmapType.Legacy;
        synchronized (baw) {
            try {
                if (this.bax.getType() == bitmapType) {
                    sQ();
                }
                b bVar2 = this.baA;
                int hashCode = hashCode();
                Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> map = bVar2.bau.get(hashCode);
                if (map == null) {
                    map = new HashMap<>(2);
                }
                map.put(bitmapType, bVar);
                bVar2.bau.append(hashCode, map);
            } finally {
                AppMethodBeat.o(219797);
            }
        }
    }

    static class a implements IBitmap<Object> {
        a() {
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final BitmapType getType() {
            return BitmapType.Undefined;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.github.henryye.nativeiv.bitmap.c cVar) {
            AppMethodBeat.i(127332);
            IOException iOException = new IOException("Stub");
            AppMethodBeat.o(127332);
            throw iOException;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final long getDecodeTime() {
            return 0;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final Object provide() {
            return null;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final void recycle() {
        }
    }

    static class b implements IBitmap<NativeBitmapStruct> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final /* bridge */ /* synthetic */ NativeBitmapStruct provide() {
            return null;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final BitmapType getType() {
            return BitmapType.Native;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final long getDecodeTime() {
            return 0;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final void recycle() {
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public final void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.github.henryye.nativeiv.bitmap.c cVar) {
            AppMethodBeat.i(127333);
            if (inputStream == null) {
                IOException iOException = new IOException("Null input stream");
                AppMethodBeat.o(127333);
                throw iOException;
            }
            AppMethodBeat.o(127333);
        }
    }
}
