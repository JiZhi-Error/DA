package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    private int index = 0;
    StringBuffer jlx = new StringBuffer();
    StringBuffer jly = new StringBuffer();

    public m() {
        AppMethodBeat.i(150969);
        AppMethodBeat.o(150969);
    }

    public final void m(String str, Object obj) {
        AppMethodBeat.i(150970);
        this.jlx.append(this.index + " " + str + "->" + obj + "\n");
        this.jly.append(obj);
        this.index++;
        AppMethodBeat.o(150970);
    }

    public final void n(String str, Object obj) {
        AppMethodBeat.i(150971);
        this.jlx.append(str + "->" + obj + "\n");
        this.jly.append(obj);
        AppMethodBeat.o(150971);
    }

    public final String toString() {
        AppMethodBeat.i(150972);
        String stringBuffer = this.jly.toString();
        AppMethodBeat.o(150972);
        return stringBuffer;
    }

    public final String abW() {
        AppMethodBeat.i(150973);
        this.index = 0;
        this.jlx.append("--end--\n\n");
        String stringBuffer = this.jlx.toString();
        AppMethodBeat.o(150973);
        return stringBuffer;
    }
}
