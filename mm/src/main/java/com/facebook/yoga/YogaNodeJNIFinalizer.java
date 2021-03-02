package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public YogaNodeJNIFinalizer() {
    }

    public YogaNodeJNIFinalizer(YogaConfig yogaConfig) {
        super(yogaConfig);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(207059);
        try {
            freeNatives();
        } finally {
            super.finalize();
            AppMethodBeat.o(207059);
        }
    }

    public void freeNatives() {
        AppMethodBeat.i(207060);
        if (this.mNativePointer != 0) {
            long j2 = this.mNativePointer;
            this.mNativePointer = 0;
            YogaNative.jni_YGNodeFreeJNI(j2);
        }
        AppMethodBeat.o(207060);
    }
}
