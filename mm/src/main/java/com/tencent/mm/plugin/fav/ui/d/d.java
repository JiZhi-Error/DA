package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends b {

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
    }

    public d(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107452);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7d, null), aVar, gVar);
            aVar.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar.jBR = (TextView) view.findViewById(R.id.cbo);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        String str = gVar.field_favProto.title;
        if (Util.isNullOrNil(str) || (gVar.tad && c2 != null)) {
            str = c2.title;
        }
        aVar.jVO.setText(str);
        aVar.jBR.setText(com.tencent.mm.plugin.fav.a.b.getLengthStr((float) c2.LvI));
        if (c2.Lwv == 2) {
            aVar.jBR.setText(">" + ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true) + "MB");
        }
        aVar.nnL.setImageResource(e.asl(c2.LvC));
        AppMethodBeat.o(107452);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107453);
        g gVar = ((a) view.getTag()).tbr;
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), gVar, and);
        AppMethodBeat.o(107453);
    }
}
