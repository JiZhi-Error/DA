package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public final int height;
    public final int width;

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.width == bVar.width && this.height == bVar.height) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public final String toString() {
        AppMethodBeat.i(12281);
        String str = this.width + "x" + this.height;
        AppMethodBeat.o(12281);
        return str;
    }
}
