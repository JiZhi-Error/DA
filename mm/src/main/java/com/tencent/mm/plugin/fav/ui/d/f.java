package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;

public final class f extends b {
    private static int tlc;

    public static class a extends b.C1049b {
        ImageView tlo;
    }

    public f(o oVar) {
        super(oVar);
        AppMethodBeat.i(107454);
        tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.eb);
        AppMethodBeat.o(107454);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107455);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7i, null), aVar2, gVar);
            aVar2.tlo = (ImageView) view.findViewById(R.id.cc_);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        ImageView imageView = aVar.tlo;
        int i2 = tlc;
        o.a(imageView, (int) R.raw.fav_list_img_default, c2, gVar, false, i2, i2);
        AppMethodBeat.o(107455);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107456);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107456);
    }
}
