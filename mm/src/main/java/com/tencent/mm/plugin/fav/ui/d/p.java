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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.and;

public final class p extends b {

    public static class a extends b.C1049b {
        TextView gBb;
    }

    public p(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107489);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7n, null), aVar2, gVar);
            aVar2.gBb = (TextView) view.findViewById(R.id.cdk);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        if (gVar.field_favProto.desc == null || gVar.field_favProto.desc.length() <= 0) {
            aVar.gBb.setText("");
            AppMethodBeat.o(107489);
        } else {
            aVar.gBb.setText(l.b(aVar.gBb.getContext(), gVar.field_favProto.desc, aVar.gBb.getTextSize()));
            AppMethodBeat.o(107489);
        }
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107490);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107490);
    }
}
