package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.and;

public final class t extends b {

    public static class a extends b.C1049b {
        TextView jVO;
    }

    public t(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        String string;
        AppMethodBeat.i(107501);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7o, null), aVar2, gVar);
            aVar2.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        int AO = (int) com.tencent.mm.plugin.fav.a.b.AO((long) com.tencent.mm.plugin.fav.a.b.c(gVar).duration);
        TextView textView = aVar.jVO;
        Context context2 = this.tdg.context;
        if (AO <= 0) {
            string = context2.getString(R.string.cd3, 0);
        } else {
            string = context2.getString(R.string.cd3, Integer.valueOf(AO));
        }
        textView.setText(string);
        AppMethodBeat.o(107501);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107502);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107502);
    }
}
