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
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;

public final class o extends b {
    private final String tlM = "";
    private final int tlc;

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        MMImageView thK;
        TextView tln;
    }

    public o(com.tencent.mm.plugin.fav.ui.o oVar) {
        super(oVar);
        AppMethodBeat.i(107486);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        AppMethodBeat.o(107486);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107487);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar, gVar);
            aVar.thK = (MMImageView) view.findViewById(R.id.cc2);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar.jBR = (TextView) view.findViewById(R.id.cbl);
            aVar.tln = (TextView) view.findViewById(R.id.cd0);
            aVar.tln.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        ank ank = gVar.field_favProto.LwW;
        if (ank != null) {
            aVar.jVO.setText(Util.nullAsNil(ank.title));
            aVar.jBR.setText(Util.nullAsNil(ank.desc));
        } else {
            aVar.jVO.setText("");
            aVar.jBR.setText("");
        }
        aVar.tln.setText(Util.nullAs(com.tencent.mm.plugin.fav.a.b.getAppName(context, gVar.field_favProto.Lya.appId), this.tlM));
        this.tdg.a(aVar.thK, null, gVar, R.raw.app_attach_file_icon_unknow, this.tlc, this.tlc);
        AppMethodBeat.o(107487);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107488);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107488);
    }
}
