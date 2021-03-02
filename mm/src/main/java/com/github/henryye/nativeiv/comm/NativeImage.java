package com.github.henryye.nativeiv.comm;

import android.graphics.Rect;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.a;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

/* access modifiers changed from: package-private */
@Keep
public class NativeImage implements IBitmap<NativeBitmapStruct> {
    private static final String TAG = "Ni.NativeImage";
    private a factory;
    private NativeImageJni jni;
    private long lastDecodeUsing = -1;
    private NativeBitmapStruct mNativeBitmapStruct = null;

    public /* bridge */ /* synthetic */ void forceSet(Object obj) {
        AppMethodBeat.i(127372);
        forceSet((NativeBitmapStruct) obj);
        AppMethodBeat.o(127372);
    }

    public NativeImage(NativeImageJni nativeImageJni, a aVar) {
        AppMethodBeat.i(127366);
        this.jni = nativeImageJni;
        this.factory = aVar;
        synchronized (this) {
            try {
                synchronized (aVar) {
                    try {
                        aVar.bbp.put(Integer.valueOf(hashCode()), this);
                    } catch (Throwable th) {
                        AppMethodBeat.o(127366);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.o(127366);
            }
        }
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public BitmapType getType() {
        return BitmapType.Native;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043 A[SYNTHETIC, Splitter:B:23:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void decodeInputStream(java.io.InputStream r13, com.github.henryye.nativeiv.ImageDecodeConfig r14, com.github.henryye.nativeiv.bitmap.c r15) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.henryye.nativeiv.comm.NativeImage.decodeInputStream(java.io.InputStream, com.github.henryye.nativeiv.ImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c):void");
    }

    public void decodeInputStreamRegion(InputStream inputStream, Rect rect, ImageDecodeConfig imageDecodeConfig, c cVar) {
        AppMethodBeat.i(127368);
        IOException iOException = new IOException("Stub!");
        AppMethodBeat.o(127368);
        throw iOException;
    }

    public void forceSet(NativeBitmapStruct nativeBitmapStruct) {
        this.mNativeBitmapStruct = nativeBitmapStruct;
    }

    public synchronized a<Integer> dump() {
        a<Integer> aVar;
        AppMethodBeat.i(127369);
        aVar = new a<>();
        if (this.mNativeBitmapStruct != null) {
            aVar.width = this.mNativeBitmapStruct.width;
            aVar.height = this.mNativeBitmapStruct.height;
            aVar.bbd = true;
            aVar.bbe = (ConfType) Integer.valueOf(this.mNativeBitmapStruct.glFormat);
            aVar.bbf = this.lastDecodeUsing;
        }
        AppMethodBeat.o(127369);
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public long getDecodeTime() {
        return this.lastDecodeUsing;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public NativeBitmapStruct provide() {
        return this.mNativeBitmapStruct;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public synchronized void recycle() {
        AppMethodBeat.i(127370);
        if (!(this.mNativeBitmapStruct == null || this.mNativeBitmapStruct.ptr == -1)) {
            NativeImageJni nativeImageJni = this.jni;
            long j2 = this.mNativeBitmapStruct.ptr;
            if (nativeImageJni.mNativeInst != 0) {
                nativeImageJni.nativeRecycleNative(nativeImageJni.mNativeInst, j2);
            }
            this.mNativeBitmapStruct = null;
        }
        if (this.factory != null) {
            a aVar = this.factory;
            synchronized (aVar) {
                try {
                    aVar.bbp.remove(Integer.valueOf(hashCode()));
                } finally {
                    AppMethodBeat.o(127370);
                }
            }
            this.factory = null;
        }
    }
}
