package com.tencent.toybrick.c;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;

public final class b extends g<b, a> {
    public static final int Sno = R.layout.aub;

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(159938);
        ((a) aVar).Snz.setText(this.Hn);
        AppMethodBeat.o(159938);
    }

    @Override // com.tencent.toybrick.c.f
    public final int getLayoutResource() {
        return Sno;
    }

    @Override // com.tencent.toybrick.c.g
    public final g.b hpJ() {
        return g.b.HINT;
    }

    public class a extends com.tencent.toybrick.f.a {
        TextView Snz;

        public a(View view) {
            super(view);
            AppMethodBeat.i(159936);
            this.Snz = (TextView) view.findViewById(16908310);
            AppMethodBeat.o(159936);
        }
    }

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ com.tencent.toybrick.f.a hM(View view) {
        AppMethodBeat.i(159937);
        a aVar = new a(view);
        AppMethodBeat.o(159937);
        return aVar;
    }
}
