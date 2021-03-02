package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends b {
    private final int tlc;

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
        TextView tln;
    }

    public h(o oVar) {
        super(oVar);
        AppMethodBeat.i(107461);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        AppMethodBeat.o(107461);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107462);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar, gVar);
            aVar.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar.jBR = (TextView) view.findViewById(R.id.cbl);
            aVar.tln = (TextView) view.findViewById(R.id.cd0);
            aVar.tln.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        ana ana = gVar.field_favProto.LwU;
        aVar.jVO.setText(Util.nullAsNil(ana.title));
        aVar.jBR.setText(Util.nullAsNil(ana.desc));
        aVar.jVO.setSingleLine(false);
        aVar.jVO.setMaxLines(2);
        this.tdg.a(aVar.nnL, null, gVar, R.raw.app_attach_file_icon_unknow, this.tlc, this.tlc);
        AppMethodBeat.o(107462);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107463);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107463);
    }
}
