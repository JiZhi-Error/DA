package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bq extends bh<ba> {
    final String TAG = "Finder.FinderMsgLikeConvert";
    private final int scene;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class b<T, R> implements e<o, Bitmap> {
        final /* synthetic */ h qhp;
        final /* synthetic */ z.f tFe;

        b(z.f fVar, h hVar) {
            this.tFe = fVar;
            this.qhp = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, Bitmap bitmap) {
            AppMethodBeat.i(243209);
            final Bitmap bitmap2 = bitmap;
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.convert.bq.b.AnonymousClass1 */
                final /* synthetic */ b tFj;

                {
                    this.tFj = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(243208);
                    if (bitmap2 != null) {
                        this.tFj.tFe.SYG.setImageBitmap(bitmap2);
                        this.tFj.tFe.SYG.setIconColor(com.tencent.mm.cb.a.n(this.tFj.qhp.getContext(), R.color.FG_1));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(243208);
                    return xVar;
                }
            });
            AppMethodBeat.o(243209);
        }
    }

    public bq(int i2) {
        super(R.layout.ahb, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, ba baVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(165439);
        ba baVar2 = baVar;
        p.h(hVar, "holder");
        p.h(baVar2, "item");
        y yVar = y.vXH;
        String a2 = y.a(baVar2);
        if (baVar2.uNF.isOverlap()) {
            Log.i(this.TAG, "overlap " + baVar2.uNF.dym() + " content " + Util.secPrint(baVar2.uNF.field_content) + " id " + baVar2.uNF.field_id + " time " + baVar2.uNF.field_createTime);
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
            aym aym = baVar2.uNF.field_aggregatedContacts;
            if (aym != null) {
                if (aym.LIH.size() > 0) {
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> dkb = m.dkb();
                    com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(aym.LIH.get(0).headUrl);
                    View Mn3 = hVar.Mn(R.id.g7u);
                    p.g(Mn3, "holder.getView(R.id.overlap_avatar2_iv)");
                    m mVar2 = m.uJa;
                    dkb.a(aVar, (ImageView) Mn3, m.a(m.a.WX_AVATAR));
                }
                if (aym.LIH.size() > 1) {
                    m mVar3 = m.uJa;
                    com.tencent.mm.loader.d<o> dkb2 = m.dkb();
                    com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(aym.LIH.get(1).headUrl);
                    View Mn4 = hVar.Mn(R.id.g7t);
                    p.g(Mn4, "holder.getView(R.id.overlap_avatar1_iv)");
                    m mVar4 = m.uJa;
                    dkb2.a(aVar2, (ImageView) Mn4, m.a(m.a.WX_AVATAR));
                }
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.fzg);
            textView2.post(new a(this, hVar, textView2, a2, baVar2, textView));
        } else {
            Log.i(this.TAG, "username " + Util.nullAs(baVar2.uNF.field_username, "") + " nickname " + Util.nullAs(baVar2.uNF.field_nickname, "") + " url " + Util.nullAs(baVar2.uNF.field_headUrl, "") + " flag " + baVar2.uNF.field_extFlag + " content " + Util.secPrint(baVar2.uNF.field_content) + " id " + baVar2.uNF.field_id + " time " + baVar2.uNF.field_createTime);
            View Mn5 = hVar.Mn(R.id.x1);
            p.g(Mn5, "holder.getView<View>(R.id.avatar_iv)");
            Mn5.setVisibility(0);
            View Mn6 = hVar.Mn(R.id.g7w);
            p.g(Mn6, "holder.getView<View>(R.id.overlap_avatar_rl)");
            Mn6.setVisibility(8);
            View Mn7 = hVar.Mn(R.id.ie1);
            p.g(Mn7, "holder.getView<View>(R.id.suffix_desc_tv)");
            Mn7.setVisibility(8);
            com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(baVar2.uNF.field_headUrl);
            TextView textView3 = (TextView) hVar.Mn(R.id.fzg);
            if ((baVar2.uNF.field_extFlag & 2) == 0 && (baVar2.uNF.field_extFlag & 1) == 0) {
                m mVar5 = m.uJa;
                com.tencent.mm.loader.d<o> dkb3 = m.dkb();
                View Mn8 = hVar.Mn(R.id.x1);
                p.g(Mn8, "holder.getView(R.id.avatar_iv)");
                m mVar6 = m.uJa;
                dkb3.a(aVar3, (ImageView) Mn8, m.a(m.a.WX_AVATAR));
            } else {
                m mVar7 = m.uJa;
                com.tencent.mm.loader.d<o> dka = m.dka();
                View Mn9 = hVar.Mn(R.id.x1);
                p.g(Mn9, "holder.getView(R.id.avatar_iv)");
                m mVar8 = m.uJa;
                dka.a(aVar3, (ImageView) Mn9, m.a(m.a.AVATAR));
            }
            p.g(textView3, "nickTv");
            textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), a2));
        }
        View Mn10 = hVar.Mn(R.id.ebh);
        p.g(Mn10, "holder.getView<View>(R.id.like_iv)");
        Mn10.setVisibility(0);
        if (!Util.isNullOrNil(baVar2.uNF.field_refContent)) {
            z = true;
        } else {
            z = false;
        }
        if (this.scene == 1 && ((int) baVar2.uNF.field_objectType) == 2 && !z) {
            View Mn11 = hVar.Mn(R.id.ebl);
            p.g(Mn11, "holder.getView<View>(R.id.like_ll)");
            Mn11.setVisibility(8);
            View Mn12 = hVar.Mn(R.id.ebo);
            p.g(Mn12, "holder.getView<View>(R.id.like_mv)");
            Mn12.setVisibility(0);
            View Mn13 = hVar.Mn(R.id.fn3);
            p.g(Mn13, "holder.getView<TextView>(R.id.msg_text_content)");
            ((TextView) Mn13).setText(hVar.getContext().getString(R.string.d2a));
        } else {
            View Mn14 = hVar.Mn(R.id.ebl);
            p.g(Mn14, "holder.getView<View>(R.id.like_ll)");
            Mn14.setVisibility(0);
            View Mn15 = hVar.Mn(R.id.ebo);
            p.g(Mn15, "holder.getView<View>(R.id.like_mv)");
            Mn15.setVisibility(8);
            View Mn16 = hVar.Mn(R.id.fmb);
            p.g(Mn16, "holder.getView<View>(R.id.msg_content)");
            Mn16.setVisibility(8);
        }
        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj((int) baVar2.uNF.field_objectType);
        if (z) {
            View Mn17 = hVar.Mn(R.id.ebh);
            if (Mn17 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(165439);
                throw tVar;
            }
            Context context = hVar.getContext();
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            ((WeImageView) Mn17).setImageDrawable(ar.m(context, R.raw.icon_outlined_awesome, context2.getResources().getColor(R.color.FG_1)));
            View Mn18 = hVar.Mn(R.id.ebh);
            if (Mn18 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(165439);
                throw tVar2;
            }
            ((WeImageView) Mn18).setIconColor(com.tencent.mm.cb.a.n(hVar.getContext(), R.color.FG_1));
        } else {
            if (Lj != null) {
                String str = Lj.LJH;
                if (str == null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z.f fVar = new z.f();
                    fVar.SYG = (T) ((WeImageView) hVar.Mn(R.id.ebh));
                    String str2 = ao.isDarkMode() ? Lj.LJG : Lj.LJH;
                    m mVar9 = m.uJa;
                    com.tencent.mm.loader.d<o> djY = m.djY();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str2, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                    m mVar10 = m.uJa;
                    djY.a(pVar, m.a(m.a.TIMELINE)).a(new b(fVar, hVar)).vC();
                }
            }
            View Mn19 = hVar.Mn(R.id.ebh);
            if (Mn19 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(165439);
                throw tVar3;
            }
            Context context3 = hVar.getContext();
            Context context4 = hVar.getContext();
            p.g(context4, "holder.context");
            ((WeImageView) Mn19).setImageDrawable(ar.m(context3, R.raw.icon_outlined_awesome, context4.getResources().getColor(R.color.FG_1)));
            View Mn20 = hVar.Mn(R.id.ebh);
            if (Mn20 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
                AppMethodBeat.o(165439);
                throw tVar4;
            }
            ((WeImageView) Mn20).setIconColor(com.tencent.mm.cb.a.n(hVar.getContext(), R.color.FG_1));
        }
        if (z) {
            View Mn21 = hVar.Mn(R.id.gy9);
            p.g(Mn21, "holder.getView<View>(R.id.ref_comment_container)");
            Mn21.setVisibility(0);
            if (!Util.isNullOrNil(baVar2.uNF.field_replayNickname)) {
                View Mn22 = hVar.Mn(R.id.fmt);
                p.g(Mn22, "holder.getView<TextView>(R.id.msg_ref_content)");
                ((TextView) Mn22).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), hVar.getContext().getString(R.string.d2h, baVar2.uNF.field_replayNickname, baVar2.uNF.field_refContent)));
            } else {
                View Mn23 = hVar.Mn(R.id.fmt);
                p.g(Mn23, "holder.getView<TextView>(R.id.msg_ref_content)");
                ((TextView) Mn23).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), baVar2.uNF.field_refContent));
            }
        } else {
            View Mn24 = hVar.Mn(R.id.gy9);
            p.g(Mn24, "holder.getView<View>(R.id.ref_comment_container)");
            Mn24.setVisibility(8);
        }
        View Mn25 = hVar.Mn(R.id.ik6);
        p.g(Mn25, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn25).setVisibility(8);
        m mVar11 = m.uJa;
        com.tencent.mm.loader.d<o> djY2 = m.djY();
        com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(baVar2.uNF.field_thumbUrl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE);
        View Mn26 = hVar.Mn(R.id.ime);
        p.g(Mn26, "holder.getView(R.id.thumb_view)");
        m mVar12 = m.uJa;
        djY2.a(pVar2, (ImageView) Mn26, m.a(m.a.MSG_THUMB));
        if (Util.isNullOrNil(baVar2.uNF.field_thumbUrl) && baVar2.uNF.field_mediaType == 1) {
            View Mn27 = hVar.Mn(R.id.ik6);
            p.g(Mn27, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn27).setText(baVar2.uNF.field_description);
            View Mn28 = hVar.Mn(R.id.ik6);
            p.g(Mn28, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn28).setVisibility(0);
        }
        AppMethodBeat.o(165439);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ h qhp;
        final /* synthetic */ TextView tEU;
        final /* synthetic */ String tEV;
        final /* synthetic */ TextView tEW;
        final /* synthetic */ bq tFh;
        final /* synthetic */ ba tFi;

        a(bq bqVar, h hVar, TextView textView, String str, ba baVar, TextView textView2) {
            this.tFh = bqVar;
            this.qhp = hVar;
            this.tEU = textView;
            this.tEV = str;
            this.tFi = baVar;
            this.tEW = textView2;
        }

        public final void run() {
            AppMethodBeat.i(243207);
            View Mn = this.qhp.Mn(R.id.ftc);
            p.g(Mn, "holder.getView<View>(R.id.name_container)");
            int width = Mn.getWidth();
            TextView textView = this.tEU;
            p.g(textView, "nickTv");
            float measureText = textView.getPaint().measureText(this.tEV);
            Log.d(this.tFh.TAG, "allWidth:" + width + " nicknameWidth:" + measureText + " count:" + this.tFi.uNF.dym());
            if (((float) width) > measureText) {
                TextView textView2 = this.tEW;
                p.g(textView2, "suffixTv");
                textView2.setVisibility(8);
                TextView textView3 = this.tEU;
                p.g(textView3, "nickTv");
                textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), this.tEV));
                AppMethodBeat.o(243207);
                return;
            }
            TextView textView4 = this.tEW;
            p.g(textView4, "suffixTv");
            textView4.setVisibility(0);
            TextView textView5 = this.tEW;
            p.g(textView5, "suffixTv");
            textView5.setText(this.qhp.getContext().getString(R.string.d2i, k.Lw(this.tFi.uNF.field_aggregatedContacts.LII)));
            TextView textView6 = this.tEU;
            p.g(textView6, "nickTv");
            textView6.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), this.tEV));
            AppMethodBeat.o(243207);
        }
    }
}
