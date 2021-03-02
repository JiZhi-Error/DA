package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;

public final class c extends b {

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
        TextView tln;
    }

    public c(o oVar) {
        super(oVar);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107449);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar, gVar);
            aVar.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar.jVO.setSingleLine(false);
            aVar.jVO.setMaxLines(2);
            aVar.jBR = (TextView) view.findViewById(R.id.cbl);
            aVar.tln = (TextView) view.findViewById(R.id.cd0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        ca.a aEK = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEK(com.tencent.mm.plugin.fav.a.b.c(gVar).desc);
        if (aEK.dkU == null || aEK.dkU.length() <= 0) {
            Log.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (Util.isNullOrNil(a(aEK))) {
            aVar.jBR.setVisibility(8);
        } else {
            aVar.jBR.setText(a(aEK));
        }
        aVar.tln.setText(R.string.c_n);
        aVar.tln.setVisibility(0);
        ImageView imageView = aVar.nnL;
        String str = aEK.dkU;
        if (Util.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.bca);
        } else {
            a.b.c(imageView, str);
        }
        AppMethodBeat.o(107449);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107450);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107450);
    }

    private static String a(ca.a aVar) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(107451);
        String str = aVar.fMb;
        if (Util.isNullOrNil(str)) {
            str = aVar.dkU;
            if (as.bjx(str) || ab.IR(str)) {
                z3 = true;
            }
            z = z3;
        } else {
            z = false;
        }
        if (z || ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjG(str)) {
            z2 = z;
        }
        boolean rR = ab.rR(aVar.IOs);
        if (z2 || rR) {
            AppMethodBeat.o(107451);
            return "";
        }
        AppMethodBeat.o(107451);
        return str;
    }
}
