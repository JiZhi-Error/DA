package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends b {
    private final int tlc;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$a  reason: collision with other inner class name */
    public static class C1048a extends b.C1049b {
        TextView jVO;
        ImageView nnL;
        ImageView tld;
    }

    public a(o oVar) {
        super(oVar);
        AppMethodBeat.i(235375);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        AppMethodBeat.o(235375);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        C1048a aVar;
        Pair<String, Integer> pair;
        AppMethodBeat.i(235376);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new C1048a();
            view = a(View.inflate(context, R.layout.a7b, null), aVar, gVar);
            aVar.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar.tld = (ImageView) view.findViewById(R.id.cc9);
            aVar.jVO = (TextView) view.findViewById(R.id.cdm);
        } else {
            aVar = (C1048a) view.getTag();
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        String str = gVar.field_favProto.title;
        if (Util.isNullOrNil(str)) {
            str = c2.title;
        }
        aVar.jVO.setText(str);
        aVar.tli.setImageResource(R.raw.icons_outlined_mini_program);
        aVar.tli.setIconColor(context.getResources().getColor(R.color.BW_0_Alpha_0_3));
        aVar.tli.setAlpha(0.3f);
        aVar.tli.setVisibility(0);
        if (gVar.field_favProto.Lxf == null || gVar.field_favProto.Lxf.subType != 1) {
            aVar.tld.setVisibility(8);
        } else {
            aVar.tld.setVisibility(0);
        }
        if (gVar.field_favProto.Lxf != null) {
            pair = ((f) com.tencent.mm.kernel.g.af(f.class)).vN(gVar.field_favProto.Lxf.dMe);
        } else {
            pair = null;
        }
        if (pair == null || Util.isNullOrNil((String) pair.first)) {
            aVar.tlj.setText((CharSequence) null);
            aVar.tlj.setVisibility(8);
        } else {
            aVar.tlj.setText((CharSequence) pair.first);
            aVar.tlj.setBackgroundResource(((Integer) pair.second).intValue());
            aVar.tlj.setVisibility(0);
        }
        o.a(aVar.nnL, (int) R.raw.fav_list_icon_miniprogram_default, c2, gVar, false, this.tlc, this.tlc);
        AppMethodBeat.o(235376);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(235377);
        amj amj = ((b.C1049b) view.getTag()).tbr.field_favProto.Lxf;
        if (amj == null) {
            Log.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
            AppMethodBeat.o(235377);
            return;
        }
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = amj.username;
        gVar.appId = amj.appId;
        gVar.iOo = amj.dMe;
        gVar.version = amj.version;
        gVar.kHw = amj.dCx;
        gVar.scene = 1010;
        gVar.kHF = new AppBrandLaunchReferrer();
        gVar.kHF.eda = amj.eda;
        gVar.kHF.leo = 6;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(view.getContext(), gVar);
        AppMethodBeat.o(235377);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(b.C1049b bVar) {
        AppMethodBeat.i(235378);
        String string = bVar.kgE.getContext().getString(R.string.a0f);
        if (bVar.tbr.field_favProto.Lxf != null) {
            WxaAttributes Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(bVar.tbr.field_favProto.Lxf.username);
            string = Xk != null ? Xk.field_nickname : bVar.kgE.getContext().getString(R.string.a0f);
        }
        bVar.kgE.setText(string);
        AppMethodBeat.o(235378);
    }
}
