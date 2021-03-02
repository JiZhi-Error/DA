package com.tencent.mm.plugin.fav.ui.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class g extends b {

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
    }

    public g(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    @SuppressLint({"ResourceType"})
    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.g gVar) {
        a aVar;
        AppMethodBeat.i(107457);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7d, null), aVar2, gVar);
            aVar2.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar2.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar2.jBR = (TextView) view.findViewById(R.id.cbo);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aVar.nnL.setImageResource(R.raw.app_attach_file_icon_location);
        ams ams = gVar.field_favProto.LwQ;
        String str = gVar.field_favProto.remark;
        if (!Util.isNullOrNil(str)) {
            aVar.jVO.setText(l.b(aVar.jVO.getContext(), str, aVar.jVO.getTextSize()));
            if (n.asr(b(ams))) {
                aVar.jBR.setText(b(ams));
                AppMethodBeat.o(107457);
                return view;
            }
        } else if (n.asr(b(ams))) {
            aVar.jVO.setText(b(ams));
        } else {
            aVar.jVO.setText(a(ams));
            aVar.jBR.setVisibility(8);
            AppMethodBeat.o(107457);
            return view;
        }
        aVar.jBR.setText(a(ams));
        AppMethodBeat.o(107457);
        return view;
    }

    private static String a(ams ams) {
        AppMethodBeat.i(107458);
        if (ams == null) {
            Log.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
            AppMethodBeat.o(107458);
            return "";
        }
        String str = ams.label;
        AppMethodBeat.o(107458);
        return str;
    }

    private static String b(ams ams) {
        AppMethodBeat.i(107459);
        if (ams == null) {
            Log.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
            AppMethodBeat.o(107459);
            return "";
        }
        String str = ams.dWi;
        AppMethodBeat.o(107459);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107460);
        if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(view.getContext())) {
            AppMethodBeat.o(107460);
            return;
        }
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107460);
    }
}
