package com.tencent.toybrick.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.f.a;

public final class e extends g<e, a> {
    public static final int Sno = R.layout.byl;
    private int FfN;

    @Override // com.tencent.toybrick.c.f
    public final int getLayoutResource() {
        return Sno;
    }

    @Override // com.tencent.toybrick.c.g
    public final g.b hpJ() {
        return g.b.HINT;
    }

    @Override // com.tencent.toybrick.c.f
    public final void a(a aVar) {
        AppMethodBeat.i(159952);
        if (this.FfN == 0) {
            this.FfN = (int) this.SnR.getResources().getDimension(R.dimen.cb);
        }
        aVar.aus.setLayoutParams(new RecyclerView.LayoutParams(-1, this.FfN));
        AppMethodBeat.o(159952);
    }

    @Override // com.tencent.toybrick.c.f
    public final a hM(View view) {
        AppMethodBeat.i(159953);
        a aVar = new a(view);
        AppMethodBeat.o(159953);
        return aVar;
    }
}
