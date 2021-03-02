package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(207052);
        try {
            freeNatives();
        } finally {
            super.finalize();
            AppMethodBeat.o(207052);
        }
    }

    public void freeNatives() {
        AppMethodBeat.i(207053);
        if (this.mNativePointer != 0) {
            long j2 = this.mNativePointer;
            this.mNativePointer = 0;
            YogaNative.jni_YGConfigFreeJNI(j2);
        }
        AppMethodBeat.o(207053);
    }
}
