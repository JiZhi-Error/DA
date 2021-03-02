package com.tencent.toybrick.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.f.a;

public abstract class g<S extends g, T extends com.tencent.toybrick.f.a> extends f<S, T> implements Comparable<g> {
    CharSequence Hn;
    public boolean SnX;
    private int[] SnY;
    public int bJH;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(g gVar) {
        return this.bJH - gVar.bJH;
    }

    public b hpJ() {
        return b.NORMAL;
    }

    public final int[] hN(View view) {
        View findViewById = view.findViewById(16908310);
        this.SnY[0] = findViewById == null ? (int) this.SnR.getResources().getDimension(R.dimen.br) : findViewById.getLeft();
        this.SnY[1] = (int) this.SnR.getResources().getDimension(R.dimen.br);
        return this.SnY;
    }

    public enum b {
        NORMAL,
        HINT;

        public static b valueOf(String str) {
            AppMethodBeat.i(159959);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(159959);
            return bVar;
        }

        static {
            AppMethodBeat.i(159960);
            AppMethodBeat.o(159960);
        }
    }

    public enum a {
        RED_NEW,
        RED_DOT,
        RED_NUM,
        NONE;

        public static a valueOf(String str) {
            AppMethodBeat.i(159956);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(159956);
            return aVar;
        }

        static {
            AppMethodBeat.i(159957);
            AppMethodBeat.o(159957);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.SnT == null || !gVar.SnT.equals(this.SnT) || gVar.Hn == null || !gVar.Hn.equals(this.Hn) || gVar.SnX != this.SnX || gVar.isVisible != this.isVisible || gVar.SnU != this.SnU) {
            return false;
        }
        return true;
    }
}
