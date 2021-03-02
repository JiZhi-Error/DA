package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowNewConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollow;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bl extends bh<av> {
    private final String TAG = "Finder.FinderMsgFollowConvert";
    private final int scene;

    public bl(int i2) {
        super(R.layout.ah6, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, av avVar) {
        int i2;
        AppMethodBeat.i(243198);
        av avVar2 = avVar;
        p.h(hVar, "holder");
        p.h(avVar2, "item");
        y yVar = y.vXH;
        String a2 = y.a(avVar2);
        View Mn = hVar.Mn(R.id.g7s);
        p.g(Mn, "holder.getView<View>(R.id.over_lap_layout)");
        Mn.setVisibility(avVar2.uNF.isOverlap() ? 0 : 8);
        View Mn2 = hVar.Mn(R.id.g0x);
        p.g(Mn2, "holder.getView<View>(R.id.not_over_lap_layout)");
        if (avVar2.uNF.isOverlap()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        Mn2.setVisibility(i2);
        if (avVar2.uNF.isOverlap()) {
            Log.i(this.TAG, "overlap " + avVar2.uNF.dym() + " content " + Util.secPrint(avVar2.uNF.field_content) + " id " + avVar2.uNF.field_id + " time " + avVar2.uNF.field_createTime);
            View Mn3 = hVar.Mn(R.id.x1);
            p.g(Mn3, "holder.getView<View>(R.id.avatar_iv)");
            Mn3.setVisibility(8);
            View Mn4 = hVar.Mn(R.id.g7w);
            p.g(Mn4, "holder.getView<View>(R.id.overlap_avatar_rl)");
            Mn4.setVisibility(0);
            aym aym = avVar2.uNF.field_aggregatedContacts;
            if (aym != null) {
                if (aym.LIH.size() > 0) {
                    m mVar = m.uJa;
                    d<o> dkb = m.dkb();
                    a aVar = new a(aym.LIH.get(0).headUrl);
                    View Mn5 = hVar.Mn(R.id.g7u);
                    p.g(Mn5, "holder.getView(R.id.overlap_avatar2_iv)");
                    m mVar2 = m.uJa;
                    dkb.a(aVar, (ImageView) Mn5, m.a(m.a.WX_AVATAR));
                }
                if (aym.LIH.size() > 1) {
                    m mVar3 = m.uJa;
                    d<o> dkb2 = m.dkb();
                    a aVar2 = new a(aym.LIH.get(1).headUrl);
                    View Mn6 = hVar.Mn(R.id.g7t);
                    p.g(Mn6, "holder.getView(R.id.overlap_avatar1_iv)");
                    m mVar4 = m.uJa;
                    dkb2.a(aVar2, (ImageView) Mn6, m.a(m.a.WX_AVATAR));
                }
            }
            View Mn7 = hVar.Mn(R.id.ipm);
            p.g(Mn7, "holder.getView<TextView>(R.id.title)");
            ((TextView) Mn7).setText(hVar.getContext().getString(R.string.coq, k.Lw(avVar2.uNF.field_aggregatedContacts.LII)));
            View Mn8 = hVar.Mn(R.id.fmb);
            p.g(Mn8, "holder.getView<TextView>(R.id.msg_content)");
            ((TextView) Mn8).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), a2));
            AppMethodBeat.o(243198);
            return;
        }
        Log.i(this.TAG, "username " + Util.nullAs(avVar2.uNF.field_username, "") + " nickname " + Util.nullAs(avVar2.uNF.field_nickname, "") + " url " + Util.nullAs(avVar2.uNF.field_headUrl, "") + " flag " + avVar2.uNF.field_extFlag + " content " + Util.secPrint(avVar2.uNF.field_content) + " id " + avVar2.uNF.field_id + " time " + avVar2.uNF.field_createTime);
        View Mn9 = hVar.Mn(R.id.x1);
        p.g(Mn9, "holder.getView<View>(R.id.avatar_iv)");
        Mn9.setVisibility(0);
        View Mn10 = hVar.Mn(R.id.g7w);
        p.g(Mn10, "holder.getView<View>(R.id.overlap_avatar_rl)");
        Mn10.setVisibility(8);
        a aVar3 = new a(avVar2.uNF.field_headUrl);
        TextView textView = (TextView) hVar.Mn(R.id.g0z);
        if ((avVar2.uNF.field_extFlag & 2) == 0 && (avVar2.uNF.field_extFlag & 1) == 0) {
            m mVar5 = m.uJa;
            d<o> dkb3 = m.dkb();
            View Mn11 = hVar.Mn(R.id.x1);
            p.g(Mn11, "holder.getView(R.id.avatar_iv)");
            m mVar6 = m.uJa;
            dkb3.a(aVar3, (ImageView) Mn11, m.a(m.a.WX_AVATAR));
        } else {
            m mVar7 = m.uJa;
            d<o> dka = m.dka();
            View Mn12 = hVar.Mn(R.id.x1);
            p.g(Mn12, "holder.getView(R.id.avatar_iv)");
            m mVar8 = m.uJa;
            dka.a(aVar3, (ImageView) Mn12, m.a(m.a.AVATAR));
        }
        p.g(textView, "nickTv");
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), a2));
        View Mn13 = hVar.Mn(R.id.g0y);
        p.g(Mn13, "holder.getView<TextView>…not_over_lap_msg_content)");
        ((TextView) Mn13).setText(hVar.getContext().getString(R.string.d24));
        AppMethodBeat.o(243198);
    }
}
