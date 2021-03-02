package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac {
    public final int height;
    public final int width;

    public ac(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return this.width == acVar.width && this.height == acVar.height;
    }

    public final String toString() {
        AppMethodBeat.i(155822);
        String str = this.width + "x" + this.height;
        AppMethodBeat.o(155822);
        return str;
    }

    public final int hashCode() {
        return this.height ^ ((this.width << 16) | (this.width >>> 16));
    }
}
