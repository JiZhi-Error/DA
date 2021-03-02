package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a {
    public int[] jGI;
    public int jGJ;
    private String jGK;
    private long jGL;

    public a(int i2) {
        this.jGJ = i2;
    }

    public a(int[] iArr) {
        this.jGI = iArr;
    }

    public final String toString() {
        AppMethodBeat.i(187622);
        String str = "OpenGLInfo{ids=" + Arrays.toString(this.jGI) + ", error=" + this.jGJ + ", javaStack='" + this.jGK + '\'' + ", nativeStack=" + this.jGL + '}';
        AppMethodBeat.o(187622);
        return str;
    }
}
