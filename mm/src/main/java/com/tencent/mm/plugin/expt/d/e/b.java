package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public int index;
    public int intValue;
    public String name;
    public String stringValue;
    public long syi;
    public int type;

    public final String toString() {
        AppMethodBeat.i(220338);
        String str = "";
        if (this.type == 2) {
            str = String.valueOf(this.syi);
        } else if (this.type == 1) {
            str = String.valueOf(this.intValue);
        } else if (this.type == 0) {
            str = this.stringValue;
        }
        String str2 = "EdgeComputingDataModel{index=" + this.index + ", type=" + this.type + ", name='" + this.name + '\'' + ", value=" + str + '\'' + '}';
        AppMethodBeat.o(220338);
        return str2;
    }
}
