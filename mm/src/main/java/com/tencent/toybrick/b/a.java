package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a {
    private static RecyclerView.m Snf;

    static {
        AppMethodBeat.i(159916);
        RecyclerView.m mVar = new RecyclerView.m();
        Snf = mVar;
        mVar.aw(d.Sno, 10);
        Snf.aw(e.Sno, 10);
        Snf.aw(com.tencent.toybrick.c.a.Sno, 10);
        Snf.aw(b.Sno, 10);
        Snf.aw(c.Sno, 10);
        AppMethodBeat.o(159916);
    }

    public static RecyclerView.m hpI() {
        return Snf;
    }
}
