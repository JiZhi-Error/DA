package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b<NativeBitmapStruct> {
    HashMap<Integer, NativeImage> bbp = new HashMap<>();
    private NativeImageJni jni = new NativeImageJni();

    public a() {
        AppMethodBeat.i(127373);
        NativeImageJni nativeImageJni = this.jni;
        if (nativeImageJni.mNativeInst != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("NativeImageJni not released last time");
            AppMethodBeat.o(127373);
            throw illegalStateException;
        }
        nativeImageJni.mNativeInst = nativeImageJni.nativeInit();
        AppMethodBeat.o(127373);
    }

    @Override // com.github.henryye.nativeiv.bitmap.b
    public final IBitmap<NativeBitmapStruct> sP() {
        AppMethodBeat.i(127374);
        NativeImage nativeImage = new NativeImage(this.jni, this);
        AppMethodBeat.o(127374);
        return nativeImage;
    }

    @Override // com.github.henryye.nativeiv.bitmap.b
    public final boolean a(c cVar) {
        return cVar == c.PNG || cVar == c.JPG;
    }

    @Override // com.github.henryye.nativeiv.bitmap.b
    public final void destroy() {
        AppMethodBeat.i(127375);
        NativeImageJni nativeImageJni = this.jni;
        if (nativeImageJni.mNativeInst != 0) {
            nativeImageJni.nativeDestroy(nativeImageJni.mNativeInst);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            try {
                for (NativeImage nativeImage : this.bbp.values()) {
                    linkedList.push(nativeImage);
                }
                this.bbp.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(127375);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((NativeImage) it.next()).recycle();
        }
        linkedList.clear();
        AppMethodBeat.o(127375);
    }
}
