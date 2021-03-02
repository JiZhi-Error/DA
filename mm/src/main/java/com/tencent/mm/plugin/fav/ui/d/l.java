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
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Util;

public final class l extends b {
    private final String tlM;
    private final int tlc;

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
        TextView tln;
    }

    public l(o oVar) {
        super(oVar);
        AppMethodBeat.i(107474);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        this.tlM = oVar.context.getString(R.string.cax);
        AppMethodBeat.o(107474);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107475);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar, gVar);
            aVar.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar.jBR = (TextView) view.findViewById(R.id.cbl);
            aVar.jBR.setVisibility(8);
            aVar.tln = (TextView) view.findViewById(R.id.cd0);
            aVar.tln.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aVar.jVO.setText(Util.nullAsNil(gVar.field_favProto.LwU.title));
        aVar.tln.setText(Util.nullAs(com.tencent.mm.plugin.fav.a.b.getAppName(context, gVar.field_favProto.Lya.appId), this.tlM));
        this.tdg.a(aVar.nnL, null, gVar, R.raw.app_attach_file_icon_unknow, this.tlc, this.tlc);
        AppMethodBeat.o(107475);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107476);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107476);
    }
}
