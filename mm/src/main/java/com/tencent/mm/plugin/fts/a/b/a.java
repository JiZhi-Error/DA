package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a {
    public List<a> aQz;
    public int end;
    public int start;
    public a wXr;
    public boolean wXs;

    public a(int i2, int i3, a aVar) {
        this.start = i2;
        this.end = i3;
        this.wXr = aVar;
    }

    public final String toString() {
        AppMethodBeat.i(131719);
        if (this.wXr == null) {
            String format = String.format("[%d,%d]", Integer.valueOf(this.start), Integer.valueOf(this.end));
            AppMethodBeat.o(131719);
            return format;
        }
        String format2 = String.format("%s [%d,%d]", this.wXr, Integer.valueOf(this.start), Integer.valueOf(this.end));
        AppMethodBeat.o(131719);
        return format2;
    }
}
