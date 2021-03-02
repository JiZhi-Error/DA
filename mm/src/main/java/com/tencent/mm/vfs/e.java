package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;

public final class e {
    public final String NGP;
    public final long RbH;
    public final long RbI;
    public final boolean RbJ;
    final FileSystem.b RbK;
    public final String name;
    public final long size;

    public e(FileSystem.b bVar, String str, String str2, long j2, long j3, long j4, boolean z) {
        this.RbK = bVar;
        this.NGP = str;
        this.name = str2;
        this.size = j2;
        this.RbH = j3;
        this.RbI = j4;
        this.RbJ = z;
    }

    public final boolean hdW() {
        AppMethodBeat.i(187648);
        if (this.RbJ) {
            boolean dy = this.RbK.dy(this.NGP, true);
            AppMethodBeat.o(187648);
            return dy;
        }
        boolean gC = this.RbK.gC(this.NGP);
        AppMethodBeat.o(187648);
        return gC;
    }

    public final boolean delete() {
        AppMethodBeat.i(258774);
        boolean hdW = hdW();
        AppMethodBeat.o(258774);
        return hdW;
    }

    public final String toString() {
        AppMethodBeat.i(187650);
        String str = this.NGP + " -> " + this.RbK.hdQ().toString();
        if (this.RbJ) {
            String concat = "[DIR] ".concat(String.valueOf(str));
            AppMethodBeat.o(187650);
            return concat;
        }
        AppMethodBeat.o(187650);
        return str;
    }
}
