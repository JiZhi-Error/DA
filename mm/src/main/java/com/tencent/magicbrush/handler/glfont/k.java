package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.List;

/* access modifiers changed from: package-private */
public final class k {
    static final k cNF;
    float cNG;
    float cNH;
    float cNI;
    float cNJ;
    float cNK;
    float cNL;
    boolean cNM;
    int cNN = 1;
    float height;
    float width;

    k() {
    }

    static {
        AppMethodBeat.i(140056);
        k kVar = new k();
        cNF = kVar;
        kVar.setEmpty();
        AppMethodBeat.o(140056);
    }

    public final void setEmpty() {
        this.height = 0.0f;
        this.width = 0.0f;
        this.cNH = 0.0f;
        this.cNG = 0.0f;
        this.cNL = 0.0f;
        this.cNK = 0.0f;
        this.cNJ = 0.0f;
        this.cNI = 0.0f;
        this.cNN = 1;
        this.cNM = false;
    }

    public final void u(float f2, float f3) {
        this.width = f2;
        this.height = f3;
    }

    public final void k(float f2, float f3, float f4, float f5) {
        this.cNI = f2;
        this.cNJ = f3;
        this.cNK = f4;
        this.cNL = f5;
    }

    static void a(FloatBuffer floatBuffer, List<k> list) {
        AppMethodBeat.i(140054);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(140054);
            return;
        }
        for (k kVar : list) {
            if (kVar != null) {
                floatBuffer.put(kVar.cNG).put(kVar.cNH).put(kVar.width).put(kVar.height).put(kVar.cNI).put(kVar.cNJ).put(kVar.cNK).put(kVar.cNL).put(kVar.cNM ? 1.0f : 0.0f).put((float) kVar.cNN);
            }
        }
        AppMethodBeat.o(140054);
    }

    public final String toString() {
        AppMethodBeat.i(140055);
        String str = "glyph(" + this.cNG + ", " + this.cNH + ", [" + this.width + ", " + this.height + "], [" + this.cNI + ", " + this.cNJ + ", " + this.cNK + ", " + this.cNL + ", " + this.cNM + "])";
        AppMethodBeat.o(140055);
        return str;
    }
}
