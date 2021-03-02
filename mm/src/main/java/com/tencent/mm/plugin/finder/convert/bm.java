package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectLikeLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectLikeLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bm extends bh<ay> {
    private final String TAG = "Finder.FinderMsgFriendObjectLikeLikeConvert";
    private final int scene;

    public bm(int i2) {
        super(R.layout.ah8, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, ay ayVar) {
        AppMethodBeat.i(243200);
        ay ayVar2 = ayVar;
        p.h(hVar, "holder");
        p.h(ayVar2, "item");
        y yVar = y.vXH;
        String a2 = y.a(ayVar2);
        if (ayVar2.uNF.isOverlap()) {
            Log.i(this.TAG, "overlap " + ayVar2.uNF.dym() + " content " + Util.secPrint(ayVar2.uNF.field_content) + " id " + ayVar2.uNF.field_id + " time " + ayVar2.uNF.field_createTime);
            View Mn = hVar.Mn(R.id.x1);
            p.g(Mn, "holder.getView<View>(R.id.avatar_iv)");
            Mn.setVisibility(8);
            View Mn2 = hVar.Mn(R.id.g7w);
            p.g(Mn2, "holder.getView<View>(R.id.overlap_avatar_rl)");
            Mn2.setVisibility(0);
            TextView textView = (TextView) hVar.Mn(R.id.ie1);
            p.g(textView, "suffixTv");
            textView.setText("");
            textView.setVisibility(0);
            aym aym = ayVar2.uNF.field_aggregatedContacts;
            if (aym != null) {
                if (aym.LIH.size() > 0) {
                    m mVar = m.uJa;
                    d<o> dkb = m.dkb();
                    com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(aym.LIH.get(0).headUrl);
                    View Mn3 = hVar.Mn(R.id.g7u);
                    p.g(Mn3, "holder.getView(R.id.overlap_avatar2_iv)");
                    m mVar2 = m.uJa;
                    dkb.a(aVar, (ImageView) Mn3, m.a(m.a.WX_AVATAR));
                }
                if (aym.LIH.size() > 1) {
                    m mVar3 = m.uJa;
                    d<o> dkb2 = m.dkb();
                    com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(aym.LIH.get(1).headUrl);
                    View Mn4 = hVar.Mn(R.id.g7t);
                    p.g(Mn4, "holder.getView(R.id.overlap_avatar1_iv)");
                    m mVar4 = m.uJa;
                    dkb2.a(aVar2, (ImageView) Mn4, m.a(m.a.WX_AVATAR));
                }
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.fzg);
            textView2.post(new a(hVar, textView2, a2, textView, ayVar2));
        } else {
            Log.i(this.TAG, "username " + Util.nullAs(ayVar2.uNF.field_username, "") + " nickname " + Util.nullAs(ayVar2.uNF.field_nickname, "") + " url " + Util.nullAs(ayVar2.uNF.field_headUrl, "") + " flag " + ayVar2.uNF.field_extFlag + " content " + Util.secPrint(ayVar2.uNF.field_content) + " id " + ayVar2.uNF.field_id + " time " + ayVar2.uNF.field_createTime);
            View Mn5 = hVar.Mn(R.id.x1);
            p.g(Mn5, "holder.getView<View>(R.id.avatar_iv)");
            Mn5.setVisibility(0);
            View Mn6 = hVar.Mn(R.id.g7w);
            p.g(Mn6, "holder.getView<View>(R.id.overlap_avatar_rl)");
            Mn6.setVisibility(8);
            View Mn7 = hVar.Mn(R.id.ie1);
            p.g(Mn7, "holder.getView<TextView>(R.id.suffix_desc_tv)");
            ((TextView) Mn7).setVisibility(8);
            com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(ayVar2.uNF.field_headUrl);
            TextView textView3 = (TextView) hVar.Mn(R.id.fzg);
            if ((ayVar2.uNF.field_extFlag & 2) == 0 && (ayVar2.uNF.field_extFlag & 1) == 0) {
                m mVar5 = m.uJa;
                d<o> dkb3 = m.dkb();
                View Mn8 = hVar.Mn(R.id.x1);
                p.g(Mn8, "holder.getView(R.id.avatar_iv)");
                m mVar6 = m.uJa;
                dkb3.a(aVar3, (ImageView) Mn8, m.a(m.a.WX_AVATAR));
            } else {
                m mVar7 = m.uJa;
                d<o> dka = m.dka();
                View Mn9 = hVar.Mn(R.id.x1);
                p.g(Mn9, "holder.getView(R.id.avatar_iv)");
                m mVar8 = m.uJa;
                dka.a(aVar3, (ImageView) Mn9, m.a(m.a.AVATAR));
            }
            p.g(textView3, "nickTv");
            textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), a2));
        }
        if (this.scene == 1) {
            View Mn10 = hVar.Mn(R.id.ebh);
            p.g(Mn10, "holder.getView<View>(R.id.like_iv)");
            Mn10.setVisibility(0);
            View Mn11 = hVar.Mn(R.id.fmb);
            p.g(Mn11, "holder.getView<View>(R.id.msg_content)");
            Mn11.setVisibility(8);
            View Mn12 = hVar.Mn(R.id.ebi);
            p.g(Mn12, "holder.getView<View>(R.id.like_iv_after)");
            Mn12.setVisibility(8);
            g gVar = g.vGW;
            azu Lj = g.Lj((int) ayVar2.uNF.field_objectType);
            if (Lj != null) {
                String str = Lj.LJH;
                if (!(str == null || str.length() == 0)) {
                    m mVar9 = m.uJa;
                    d<o> djY = m.djY();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(Lj.LJH, x.FULL_IMAGE);
                    View Mn13 = hVar.Mn(R.id.ebh);
                    p.g(Mn13, "holder.getView<ImageView>(R.id.like_iv)");
                    m mVar10 = m.uJa;
                    djY.a(pVar, (ImageView) Mn13, m.a(m.a.TIMELINE));
                    ((ImageView) hVar.Mn(R.id.ebh)).setColorFilter(com.tencent.mm.cb.a.n(hVar.getContext(), R.color.FG_1), PorterDuff.Mode.SRC_ATOP);
                }
            }
            View Mn14 = hVar.Mn(R.id.ebh);
            if (Mn14 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(243200);
                throw tVar;
            }
            Context context = hVar.getContext();
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            ((WeImageView) Mn14).setImageDrawable(ar.m(context, R.raw.icon_outlined_awesome, context2.getResources().getColor(R.color.FG_1)));
            View Mn15 = hVar.Mn(R.id.ebh);
            if (Mn15 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(243200);
                throw tVar2;
            }
            ((WeImageView) Mn15).setIconColor(com.tencent.mm.cb.a.n(hVar.getContext(), R.color.FG_1));
        } else {
            View Mn16 = hVar.Mn(R.id.ebh);
            p.g(Mn16, "holder.getView<View>(R.id.like_iv)");
            Mn16.setVisibility(8);
            View Mn17 = hVar.Mn(R.id.ebh);
            if (Mn17 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(243200);
                throw tVar3;
            }
            ((WeImageView) Mn17).setIconColor(MMApplicationContext.getResources().getColor(R.color.FG_1));
            View Mn18 = hVar.Mn(R.id.fmb);
            p.g(Mn18, "holder.getView<View>(R.id.msg_content)");
            Mn18.setVisibility(0);
            View Mn19 = hVar.Mn(R.id.fmb);
            p.g(Mn19, "holder.getView<TextView>(R.id.msg_content)");
            ((TextView) Mn19).setText(hVar.getContext().getString(R.string.d25));
            View Mn20 = hVar.Mn(R.id.ebi);
            p.g(Mn20, "holder.getView<View>(R.id.like_iv_after)");
            Mn20.setVisibility(0);
        }
        View Mn21 = hVar.Mn(R.id.ik6);
        p.g(Mn21, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn21).setVisibility(8);
        m mVar11 = m.uJa;
        d<o> djY2 = m.djY();
        com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(ayVar2.uNF.field_thumbUrl, x.THUMB_IMAGE);
        View Mn22 = hVar.Mn(R.id.ime);
        p.g(Mn22, "holder.getView(R.id.thumb_view)");
        m mVar12 = m.uJa;
        djY2.a(pVar2, (ImageView) Mn22, m.a(m.a.MSG_THUMB));
        if (Util.isNullOrNil(ayVar2.uNF.field_thumbUrl) && ayVar2.uNF.field_mediaType == 1) {
            View Mn23 = hVar.Mn(R.id.ik6);
            p.g(Mn23, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn23).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), ayVar2.uNF.field_description));
            View Mn24 = hVar.Mn(R.id.ik6);
            p.g(Mn24, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn24).setVisibility(0);
        }
        AppMethodBeat.o(243200);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ h qhp;
        final /* synthetic */ TextView tEU;
        final /* synthetic */ String tEV;
        final /* synthetic */ TextView tEW;
        final /* synthetic */ ay tFc;

        a(h hVar, TextView textView, String str, TextView textView2, ay ayVar) {
            this.qhp = hVar;
            this.tEU = textView;
            this.tEV = str;
            this.tEW = textView2;
            this.tFc = ayVar;
        }

        public final void run() {
            AppMethodBeat.i(243199);
            View Mn = this.qhp.Mn(R.id.ftc);
            p.g(Mn, "holder.getView<View>(R.id.name_container)");
            int width = Mn.getWidth();
            TextView textView = this.tEU;
            p.g(textView, "nickTv");
            if (((float) width) > textView.getPaint().measureText(this.tEV)) {
                TextView textView2 = this.tEW;
                p.g(textView2, "suffixTv");
                textView2.setVisibility(8);
                TextView textView3 = this.tEU;
                p.g(textView3, "nickTv");
                textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), this.tEV));
                AppMethodBeat.o(243199);
                return;
            }
            TextView textView4 = this.tEW;
            p.g(textView4, "suffixTv");
            textView4.setVisibility(0);
            TextView textView5 = this.tEW;
            p.g(textView5, "suffixTv");
            textView5.setText(this.qhp.getContext().getString(R.string.d2i, k.Lw(this.tFc.uNF.field_aggregatedContacts.LII)));
            TextView textView6 = this.tEU;
            p.g(textView6, "nickTv");
            textView6.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), this.tEV));
            AppMethodBeat.o(243199);
        }
    }
}
