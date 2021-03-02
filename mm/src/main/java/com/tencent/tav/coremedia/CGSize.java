package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CGSize implements Cloneable {
    public static final CGSize CGSizeZero = new CGSize(0.0f, 0.0f);
    public float height;
    public float width;

    static {
        AppMethodBeat.i(199390);
        AppMethodBeat.o(199390);
    }

    public CGSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
    }

    public CGSize() {
        this(1.0f, 1.0f);
    }

    public String toString() {
        AppMethodBeat.i(199387);
        String str = "[" + this.width + "," + this.height + "]";
        AppMethodBeat.o(199387);
        return str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CGSize)) {
            return false;
        }
        if (((CGSize) obj).width == this.width && ((CGSize) obj).height == this.height) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public CGSize clone() {
        AppMethodBeat.i(199388);
        CGSize cGSize = new CGSize(this.width, this.height);
        AppMethodBeat.o(199388);
        return cGSize;
    }
}
