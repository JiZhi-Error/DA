package com.google.b.f.b;

import com.google.b.f.a.a;
import com.google.b.f.a.b;
import com.google.b.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    b cfK;
    a cfL;
    c cfM;
    int cfN = -1;
    public b cfO;

    public final String toString() {
        AppMethodBeat.i(12361);
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.cfK);
        sb.append("\n ecLevel: ");
        sb.append(this.cfL);
        sb.append("\n version: ");
        sb.append(this.cfM);
        sb.append("\n maskPattern: ");
        sb.append(this.cfN);
        if (this.cfO == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.cfO);
        }
        sb.append(">>\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(12361);
        return sb2;
    }
}
