package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.and;

public final class q extends b {
    public q(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        AppMethodBeat.i(107491);
        View view2 = new View(viewGroup.getContext());
        AppMethodBeat.o(107491);
        return view2;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107492);
        if (view != null) {
            Toast.makeText(view.getContext(), (int) R.string.ccy, 0).show();
        }
        AppMethodBeat.o(107492);
    }
}
