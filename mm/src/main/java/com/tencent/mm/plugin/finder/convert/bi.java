package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.bc;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApply;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "setAccept", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "acceptBtn", "Landroid/widget/TextView;", "setAccepted", "setInvalid", "setRevoke", "plugin-finder_release"})
public final class bi extends bh<aw> {
    private final String TAG;
    final int scene;

    private bi() {
        super(R.layout.ah5, 1);
        this.scene = 1;
        this.TAG = "Finder.FinderMsgFollowApplyConvert";
    }

    public /* synthetic */ bi(byte b2) {
        this();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, aw awVar) {
        AppMethodBeat.i(243193);
        aw awVar2 = awVar;
        p.h(hVar, "holder");
        p.h(awVar2, "item");
        y yVar = y.vXH;
        String a2 = y.a(awVar2);
        if (awVar2.uNF.isOverlap()) {
            Log.i(this.TAG, "overlap " + awVar2.uNF.dym() + " content " + Util.secPrint(awVar2.uNF.field_content) + " id " + awVar2.uNF.field_id + " time " + awVar2.uNF.field_createTime);
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
            aym aym = awVar2.uNF.field_aggregatedContacts;
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
            textView2.post(new a(hVar, textView2, a2, textView, awVar2));
        } else {
            Log.i(this.TAG, "username " + Util.nullAs(awVar2.uNF.field_username, "") + " nickname " + Util.nullAs(awVar2.uNF.field_nickname, "") + " url " + Util.nullAs(awVar2.uNF.field_headUrl, "") + " flag " + awVar2.uNF.field_extFlag + " content " + Util.secPrint(awVar2.uNF.field_content) + " id " + awVar2.uNF.field_id + " time " + awVar2.uNF.field_createTime);
            View Mn5 = hVar.Mn(R.id.x1);
            p.g(Mn5, "holder.getView<View>(R.id.avatar_iv)");
            Mn5.setVisibility(0);
            View Mn6 = hVar.Mn(R.id.g7w);
            p.g(Mn6, "holder.getView<View>(R.id.overlap_avatar_rl)");
            Mn6.setVisibility(8);
            View Mn7 = hVar.Mn(R.id.ie1);
            p.g(Mn7, "holder.getView<TextView>(R.id.suffix_desc_tv)");
            ((TextView) Mn7).setVisibility(8);
            com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(awVar2.uNF.field_headUrl);
            TextView textView3 = (TextView) hVar.Mn(R.id.fzg);
            if ((awVar2.uNF.field_extFlag & 2) == 0 && (awVar2.uNF.field_extFlag & 1) == 0) {
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
        View Mn10 = hVar.Mn(R.id.fmb);
        p.g(Mn10, "holder.getView<TextView>(R.id.msg_content)");
        ((TextView) Mn10).setText(hVar.getContext().getString(R.string.d22));
        TextView textView4 = (TextView) hVar.Mn(R.id.d0b);
        p.g(textView4, "acceptBtn");
        ao.a(textView4.getPaint(), 0.8f);
        f fVar = f.vGV;
        switch (f.d(awVar2.uNF)) {
            case 2:
                a(textView4, hVar);
                AppMethodBeat.o(243193);
                return;
            case 3:
                textView4.setBackground(null);
                textView4.setOnClickListener(null);
                textView4.setText(hVar.getContext().getString(R.string.d1v));
                ao.a(textView4.getPaint(), 0.0f);
                Context context = hVar.getContext();
                p.g(context, "holder.context");
                textView4.setTextColor(context.getResources().getColor(R.color.FG_2));
                AppMethodBeat.o(243193);
                return;
            case 4:
                textView4.setBackground(null);
                textView4.setOnClickListener(null);
                textView4.setText(hVar.getContext().getString(R.string.d1w));
                ao.a(textView4.getPaint(), 0.0f);
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                textView4.setTextColor(context2.getResources().getColor(R.color.FG_2));
                AppMethodBeat.o(243193);
                return;
            default:
                com.tencent.mm.plugin.finder.storage.ao aoVar = awVar2.uNF;
                k kVar = k.vfA;
                String str = aoVar.field_username;
                p.g(str, "mention.field_username");
                k.ad(str, 2, cl.aWB());
                textView4.setBackgroundResource(R.drawable.a2_);
                textView4.setOnClickListener(new b(this, aoVar, textView4, hVar));
                textView4.setText(hVar.getContext().getString(R.string.d1u));
                Context context3 = hVar.getContext();
                p.g(context3, "holder.context");
                textView4.setTextColor(context3.getResources().getColor(R.color.FG_0));
                AppMethodBeat.o(243193);
                return;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ h qhp;
        final /* synthetic */ TextView tEU;
        final /* synthetic */ String tEV;
        final /* synthetic */ TextView tEW;
        final /* synthetic */ aw tEX;

        a(h hVar, TextView textView, String str, TextView textView2, aw awVar) {
            this.qhp = hVar;
            this.tEU = textView;
            this.tEV = str;
            this.tEW = textView2;
            this.tEX = awVar;
        }

        public final void run() {
            AppMethodBeat.i(243191);
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
                AppMethodBeat.o(243191);
                return;
            }
            TextView textView4 = this.tEW;
            p.g(textView4, "suffixTv");
            textView4.setVisibility(0);
            TextView textView5 = this.tEW;
            p.g(textView5, "suffixTv");
            textView5.setText(this.qhp.getContext().getString(R.string.d2i, com.tencent.mm.plugin.finder.utils.k.Lw(this.tEX.uNF.field_aggregatedContacts.LII)));
            TextView textView6 = this.tEU;
            p.g(textView6, "nickTv");
            textView6.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), this.tEV));
            AppMethodBeat.o(243191);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ bi tEY;
        final /* synthetic */ com.tencent.mm.plugin.finder.storage.ao tEZ;
        final /* synthetic */ TextView tFa;

        b(bi biVar, com.tencent.mm.plugin.finder.storage.ao aoVar, TextView textView, h hVar) {
            this.tEY = biVar;
            this.tEZ = aoVar;
            this.tFa = textView;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243192);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            k kVar = k.vfA;
            String str = this.tEZ.field_username;
            p.g(str, "mention.field_username");
            k.ad(str, 1, cl.aWB());
            bi.a(this.tFa, this.qhp);
            f fVar = f.vGV;
            f.c(this.tEZ);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.qhp.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243192);
                throw tVar;
            }
            g.azz().b(new bc(this.tEZ, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class)).dIx(), this.tEY.scene));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243192);
        }
    }

    static void a(TextView textView, h hVar) {
        AppMethodBeat.i(243194);
        textView.setBackground(null);
        textView.setOnClickListener(null);
        textView.setText(hVar.getContext().getString(R.string.d1x));
        ao.a(textView.getPaint(), 0.0f);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        textView.setTextColor(context.getResources().getColor(R.color.FG_2));
        AppMethodBeat.o(243194);
    }
}
