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
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Util;

public final class r extends b {
    private final int tlc;

    public static class a extends b.C1049b {
        TextView jVO;
        ImageView nnL;
        ImageView tlu;
    }

    public r(o oVar) {
        super(oVar);
        AppMethodBeat.i(107493);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        AppMethodBeat.o(107493);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107494);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar2, gVar);
            aVar2.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar2.tlu = (ImageView) view.findViewById(R.id.cc7);
            aVar2.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar2.jVO.setMaxLines(2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        anq anq = gVar.field_favProto.LwS;
        TextView textView = aVar.jVO;
        aml c3 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        String str = "";
        if (anq != null) {
            str = anq.title;
        }
        if (Util.isNullOrNil(str) && c3 != null) {
            str = c3.title;
        }
        if (Util.isNullOrNil(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        int bcX = f.bcX(c2.LvC);
        o oVar = this.tdg;
        ImageView imageView = aVar.nnL;
        if (bcX == f.glU()) {
            bcX = R.raw.app_attach_file_icon_webpage;
        }
        oVar.a(imageView, c2, gVar, bcX, this.tlc, this.tlc);
        if ((gVar.field_favProto.IXu == null || gVar.field_favProto.IXu.iwc != 5) && (anq == null || Util.isNullOrNil(anq.LyH))) {
            aVar.tlu.setVisibility(8);
        } else {
            aVar.tlu.setImageResource(R.raw.shortvideo_play_btn);
            aVar.tlu.setVisibility(0);
        }
        AppMethodBeat.o(107494);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(b.C1049b bVar) {
        AppMethodBeat.i(107495);
        try {
            anq anq = bVar.tbr.field_favProto.LwS;
            if (anq == null || Util.isNullOrNil(anq.LyH)) {
                super.a(bVar);
                AppMethodBeat.o(107495);
                return;
            }
            bVar.kgE.setText(R.string.hr6);
            AppMethodBeat.o(107495);
        } catch (Exception e2) {
            AppMethodBeat.o(107495);
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107496);
        a aVar = (a) view.getTag();
        Context context = view.getContext();
        ImageView imageView = aVar.nnL;
        g gVar = aVar.tbr;
        if (!(gVar.field_favProto == null || gVar.field_favProto.IXu == null || gVar.field_favProto.IXu.iwc < 0)) {
            int[] iArr = new int[2];
            if (imageView != null) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                imageView.getLocationInWindow(iArr);
                amt amt = gVar.field_favProto.IXu;
                amt.LxS = new amu();
                amt.LxS.left = iArr[0];
                amt.LxS.top = iArr[1];
                amt.LxS.width = width;
                amt.LxS.height = height;
            }
        }
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(context, aVar.tbr, and);
        AppMethodBeat.o(107496);
    }
}
