package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.List;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0017J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000bH\u0017J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class h extends com.tencent.mm.view.recyclerview.e<s> {
    public static final a tzo = new a((byte) 0);
    private final CommentDrawerContract.NPresenter tzm;
    private final boolean tzn;

    static {
        AppMethodBeat.i(165328);
        AppMethodBeat.o(165328);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$4$1"})
    static final class l extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(165320);
            boolean booleanValue = bool.booleanValue();
            Object hgv = this.tzq.hgv();
            if (hgv == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedComment");
                AppMethodBeat.o(165320);
                throw tVar;
            }
            ((s) hgv).uOa = booleanValue;
            x xVar = x.SXb;
            AppMethodBeat.o(165320);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$5$1"})
    static final class m extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(165321);
            boolean booleanValue = bool.booleanValue();
            Object hgv = this.tzq.hgv();
            if (hgv == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedComment");
                AppMethodBeat.o(165321);
                throw tVar;
            }
            ((s) hgv).uNZ = booleanValue;
            x xVar = x.SXb;
            AppMethodBeat.o(165321);
            return xVar;
        }
    }

    public h(CommentDrawerContract.NPresenter nPresenter, boolean z) {
        kotlin.g.b.p.h(nPresenter, "presenter");
        AppMethodBeat.i(178106);
        this.tzm = nPresenter;
        this.tzn = z;
        AppMethodBeat.o(178106);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, s sVar, int i2, int i3, boolean z, List list) {
        SpannableString spannableString;
        CharSequence charSequence;
        boolean z2;
        kotlin.o oVar;
        String dyd;
        AppMethodBeat.i(165326);
        s sVar2 = sVar;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(sVar2, "item");
        hVar.et(sVar2);
        TextView textView = (TextView) hVar.Mn(R.id.fzc);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        textView.setTextColor(context.getResources().getColor(R.color.FG_1));
        textView.setOnClickListener(null);
        hVar.Mn(R.id.x1).setOnClickListener(null);
        hVar.mf(R.id.dax, 8);
        if (cZA()) {
            this.tzm.dcE();
            this.tzm.dcF();
            Context context2 = hVar.getContext();
            y yVar = y.vXH;
            String username = sVar2.uOf.getUsername();
            if (username == null) {
                username = "";
            }
            String nickname = sVar2.uOf.getNickname();
            if (nickname == null) {
                nickname = "";
            }
            spannableString = new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.c(context2, y.hf(username, nickname)));
            SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) spannableString);
            kotlin.g.b.p.g(append, "SpannableStringBuilder()…end(nickNameCharsequence)");
            if (sVar2.uNX) {
                d dVar = d.tyZ;
                kotlin.g.b.p.g(textView, "nickNameTv");
                dVar.d(textView, append);
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.drL()) {
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    textView.setTextColor(context3.getResources().getColor(R.color.x0));
                    textView.setOnClickListener(new c(sVar2, hVar));
                    hVar.Mn(R.id.x1).setOnClickListener(new f(sVar2, hVar));
                    charSequence = spannableString;
                }
                charSequence = spannableString;
            } else {
                d dVar2 = d.tyZ;
                kotlin.g.b.p.g(textView, "nickNameTv");
                dVar2.d(textView, append);
                charSequence = spannableString;
            }
        } else {
            Context context4 = hVar.getContext();
            String nickname2 = sVar2.uOf.getNickname();
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context4, nickname2 != null ? nickname2 : "");
            kotlin.g.b.p.g(c2, "MMSpanManager.spanForSmi…ommentObj.nickname ?: \"\")");
            spannableString = c2;
            d dVar3 = d.tyZ;
            kotlin.g.b.p.g(textView, "nickNameTv");
            dVar3.d(textView, spannableString);
            charSequence = spannableString;
        }
        String m2 = com.tencent.mm.plugin.finder.utils.k.m(hVar.getContext(), sVar2.uOf.dyb().createtime * 1000);
        hVar.e(R.id.b9i, m2);
        StringBuilder append2 = new StringBuilder("username=").append(sVar2.uOf.getUsername()).append(", nickName=");
        String nickname3 = sVar2.uOf.getNickname();
        if (nickname3 == null) {
            nickname3 = "";
        }
        Log.d("Finder.FinderFeedCommentConvert", append2.append(nickname3).append(" content=").append(sVar2.uOf.getContent()).toString());
        ImageView imageView = (ImageView) hVar.Mn(R.id.x1);
        if (sVar2.uOf.dyj()) {
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(sVar2.uOf.dyc());
            kotlin.g.b.p.g(imageView, "avatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            hVar.mf(R.id.gft, 0);
            z2 = true;
        } else if (sVar2.uOf.dyk()) {
            hVar.mf(R.id.gft, 8);
            com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka2 = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(sVar2.uOf.dyc());
            kotlin.g.b.p.g(imageView, "avatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka2.a(aVar2, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            z2 = true;
        } else {
            hVar.mf(R.id.gft, 8);
            if (!Util.isNullOrNil(sVar2.uOf.dyc())) {
                com.tencent.mm.plugin.finder.loader.m mVar5 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(sVar2.uOf.dyc());
                kotlin.g.b.p.g(imageView, "avatarIv");
                com.tencent.mm.plugin.finder.loader.m mVar6 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dkb.a(aVar3, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
            } else {
                imageView.setImageResource(R.drawable.bca);
            }
            String userName = this.tzm.dcB().getUserName();
            imageView.setOnClickListener(new g(hVar, userName, sVar2));
            textView.setOnClickListener(new View$OnClickListenerC1099h(hVar, userName, sVar2));
            z2 = false;
        }
        if (z2) {
            Context context5 = hVar.getContext();
            kotlin.g.b.p.g(context5, "holder.context");
            textView.setTextColor(context5.getResources().getColor(R.color.x0));
            textView.setOnClickListener(new i(this, sVar2, hVar));
            hVar.Mn(R.id.x1).setOnClickListener(new j(this, sVar2, hVar));
        }
        if (!z) {
            FinderCollapsibleTextView finderCollapsibleTextView = (FinderCollapsibleTextView) hVar.Mn(R.id.h36);
            Object hgv = hVar.hgv();
            if (hgv == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedComment");
                AppMethodBeat.o(165326);
                throw tVar;
            }
            finderCollapsibleTextView.setCollapse(((s) hgv).uOa);
            x xVar = x.SXb;
            x xVar2 = x.SXb;
            FinderCollapsibleTextView finderCollapsibleTextView2 = (FinderCollapsibleTextView) hVar.Mn(R.id.b8e);
            Object hgv2 = hVar.hgv();
            if (hgv2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedComment");
                AppMethodBeat.o(165326);
                throw tVar2;
            }
            finderCollapsibleTextView2.setCollapse(((s) hgv2).uNZ);
            x xVar3 = x.SXb;
            x xVar4 = x.SXb;
            ((FinderCollapsibleTextView) hVar.Mn(R.id.b8e)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), sVar2.uOf.getContent()));
            StringBuilder append3 = new StringBuilder("onBindViewHolder replyCommentId:").append(sVar2.uOf.dyb().replyCommentId).append(", content:").append(sVar2.uOf.dye()).append(", nickname:");
            String dyd2 = sVar2.uOf.dyd();
            if (dyd2 == null) {
                dyd2 = "";
            }
            Log.i("Finder.FinderFeedCommentConvert", append3.append(dyd2).toString());
            FinderCollapsibleTextView finderCollapsibleTextView3 = (FinderCollapsibleTextView) hVar.Mn(R.id.h36);
            if (sVar2.uOf.dyb().replyCommentId == 0 || !this.tzn) {
                hVar.mf(R.id.h37, 8);
                finderCollapsibleTextView3.setText("");
            } else {
                hVar.mf(R.id.h37, 0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (cZA()) {
                    y yVar2 = y.vXH;
                    String dyf = sVar2.uOf.dyf();
                    if (dyf == null) {
                        dyf = "";
                    }
                    String dyd3 = sVar2.uOf.dyd();
                    if (dyd3 == null) {
                        dyd3 = "";
                    }
                    dyd = y.hf(dyf, dyd3);
                } else {
                    dyd = sVar2.uOf.dyd();
                    if (dyd == null) {
                        dyd = "";
                    }
                }
                d dVar4 = d.tyZ;
                NeatTextView contentTextView = finderCollapsibleTextView3.getContentTextView();
                kotlin.g.b.p.g(contentTextView, "replyContentTv.contentTextView");
                TextPaint paint = contentTextView.getPaint();
                kotlin.g.b.p.g(paint, "replyContentTv.contentTextView.paint");
                d dVar5 = d.tyZ;
                Context context6 = hVar.getContext();
                kotlin.g.b.p.g(context6, "holder.context");
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int Z = d.Z(context6, com.tencent.mm.plugin.finder.storage.c.drZ());
                d dVar6 = d.tyZ;
                Context context7 = hVar.getContext();
                kotlin.g.b.p.g(context7, "holder.context");
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                spannableStringBuilder.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), d.a(paint, dyd, Z, d.Z(context7, com.tencent.mm.plugin.finder.storage.c.drZ() + 1))));
                spannableStringBuilder.append((CharSequence) hVar.getContext().getString(R.string.cjd));
                spannableStringBuilder.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), sVar2.uOf.dye()));
                finderCollapsibleTextView3.setText(spannableStringBuilder);
            }
        }
        j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean a2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.a(this.tzm.dcB().field_id, sVar2.uOf, this.tzm.dcA());
        if (a2) {
            if (this.tzm.isCommentClose()) {
                Integer valueOf = Integer.valueOf((int) R.raw.icon_filled_awesome);
                Context context8 = hVar.getContext();
                kotlin.g.b.p.g(context8, "holder.context");
                oVar = new kotlin.o(valueOf, Integer.valueOf(context8.getResources().getColor(R.color.BW_90)));
            } else {
                Integer valueOf2 = Integer.valueOf((int) R.raw.icon_filled_awesome);
                Context context9 = hVar.getContext();
                kotlin.g.b.p.g(context9, "holder.context");
                oVar = new kotlin.o(valueOf2, Integer.valueOf(context9.getResources().getColor(R.color.Red_90)));
            }
        } else if (this.tzm.isCommentClose()) {
            Integer valueOf3 = Integer.valueOf((int) R.raw.icon_outlined_awesome);
            Context context10 = hVar.getContext();
            kotlin.g.b.p.g(context10, "holder.context");
            oVar = new kotlin.o(valueOf3, Integer.valueOf(context10.getResources().getColor(R.color.BW_90)));
        } else {
            Integer valueOf4 = Integer.valueOf((int) R.raw.icon_outlined_awesome);
            Context context11 = hVar.getContext();
            kotlin.g.b.p.g(context11, "holder.context");
            oVar = new kotlin.o(valueOf4, Integer.valueOf(context11.getResources().getColor(R.color.FG_1)));
        }
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.xm);
        weImageView.setImageResource(intValue);
        weImageView.setIconColor(intValue2);
        if (!sVar2.uOf.dyi()) {
            hVar.mf(R.id.xm, 8);
        } else {
            hVar.mf(R.id.xm, 0);
        }
        j.a aVar5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        int b2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.b(this.tzm.dcB().field_id, sVar2.uOf, this.tzm.dcA());
        if (b2 > 0) {
            hVar.mf(R.id.xn, 0);
            hVar.e(R.id.xn, String.valueOf(b2));
        } else {
            hVar.mf(R.id.xn, 8);
            hVar.e(R.id.xn, "");
        }
        if (this.tzm.isCommentClose()) {
            Context context12 = hVar.getContext();
            kotlin.g.b.p.g(context12, "holder.context");
            ((TextView) hVar.Mn(R.id.xn)).setTextColor(context12.getResources().getColor(R.color.BW_90));
        } else if (a2) {
            Context context13 = hVar.getContext();
            kotlin.g.b.p.g(context13, "holder.context");
            ((TextView) hVar.Mn(R.id.xn)).setTextColor(context13.getResources().getColor(R.color.Red_100));
        } else {
            Context context14 = hVar.getContext();
            kotlin.g.b.p.g(context14, "holder.context");
            ((TextView) hVar.Mn(R.id.xn)).setTextColor(context14.getResources().getColor(R.color.BW_0_Alpha_0_3));
        }
        d dVar7 = d.tyZ;
        Context context15 = hVar.getContext();
        kotlin.g.b.p.g(context15, "holder.context");
        View Mn = hVar.Mn(R.id.cek);
        kotlin.g.b.p.g(Mn, "holder.getView<View>(R.id.feed_comment_layout)");
        View Mn2 = hVar.Mn(R.id.fzc);
        kotlin.g.b.p.g(Mn2, "holder.getView(R.id.nickname)");
        View Mn3 = hVar.Mn(R.id.b9i);
        kotlin.g.b.p.g(Mn3, "holder.getView(R.id.comment_time)");
        View Mn4 = hVar.Mn(R.id.gft);
        kotlin.g.b.p.g(Mn4, "holder.getView(R.id.poster_tag)");
        View Mn5 = hVar.Mn(R.id.dax);
        kotlin.g.b.p.g(Mn5, "holder.getView(R.id.friend_tag)");
        kotlin.g.b.p.g(m2, "commentTimeText");
        d.a(context15, Mn, (TextView) Mn2, (TextView) Mn3, hVar.Mn(R.id.xm), (TextView) hVar.Mn(R.id.xn), (TextView) Mn4, (TextView) Mn5, charSequence, m2);
        if (sVar2.uOf.field_state == -1) {
            hVar.mf(R.id.b8s, 0);
            hVar.mf(R.id.b8t, 0);
            TextView textView2 = (TextView) hVar.Mn(R.id.b8t);
            if (sVar2.uOf.field_failedFlag == 1) {
                hVar.nm(R.id.b8t, R.string.cjh);
                hVar.Mn(R.id.b8u).setOnClickListener(null);
            } else {
                hVar.nm(R.id.b8t, R.string.cmt);
                hVar.Mn(R.id.b8u).setOnClickListener(new k(this, textView2, hVar));
            }
        } else {
            hVar.mf(R.id.b8s, 8);
            hVar.mf(R.id.b8t, 8);
        }
        if ((sVar2.uOf.dyb().displayFlag & 1) != 0) {
            hVar.mf(R.id.eb7, 0);
        } else {
            hVar.mf(R.id.eb7, 8);
        }
        hVar.mf(R.id.cei, 8);
        Log.i("Finder.FinderFeedCommentConvert", "maskView gone " + i2 + ", blink " + sVar2.uOb + ", hasBlink " + sVar2.uOc);
        if (sVar2.uOb && !sVar2.uOc) {
            Log.i("Finder.FinderFeedCommentConvert", "begin blink animation ".concat(String.valueOf(i2)));
            sVar2.uOc = true;
            View Mn6 = hVar.Mn(R.id.cei);
            kotlin.g.b.p.g(Mn6, "maskView");
            Mn6.setVisibility(0);
            Mn6.setAlpha(1.0f);
            Mn6.animate().alpha(0.0f).setDuration(1000).setListener(new d(Mn6, i2)).start();
        }
        y yVar3 = y.vXH;
        if (y.In(this.tzm.dcB().getUserName())) {
            View Mn7 = hVar.Mn(R.id.b98);
            Mn7.setVisibility(0);
            Mn7.setOnClickListener(new b(this, hVar, sVar2));
            x xVar5 = x.SXb;
        } else {
            View Mn8 = hVar.Mn(R.id.b98);
            kotlin.g.b.p.g(Mn8, "holder.getView<View>(comment_more_iv)");
            Mn8.setVisibility(8);
        }
        if (this.tzn) {
            View Mn9 = hVar.Mn(R.id.hqz);
            kotlin.g.b.p.g(Mn9, "holder.getView<View>(show_level2_comments)");
            Mn9.setVisibility(8);
            View Mn10 = hVar.Mn(R.id.i3t);
            kotlin.g.b.p.g(Mn10, "holder.getView<View>(split_line)");
            Mn10.setVisibility(0);
            AppMethodBeat.o(165326);
            return;
        }
        int i4 = sVar2.uOf.dyb().expandCommentCount;
        View Mn11 = hVar.Mn(R.id.hqz);
        String string = hVar.getContext().getString(R.string.hp1, com.tencent.mm.plugin.finder.utils.k.gm(2, i4));
        kotlin.g.b.p.g(string, "holder.context.getString…NE_WX, totalLevel2Count))");
        boolean b3 = this.tzm.b(sVar2, true);
        if (i4 <= 0 || !b3) {
            if (!b3) {
                View Mn12 = hVar.Mn(R.id.i3t);
                kotlin.g.b.p.g(Mn12, "holder.getView<View>(split_line)");
                Mn12.setVisibility(8);
            } else {
                View Mn13 = hVar.Mn(R.id.i3t);
                kotlin.g.b.p.g(Mn13, "holder.getView<View>(split_line)");
                Mn13.setVisibility(0);
            }
            kotlin.g.b.p.g(Mn11, "level2TipsLayout");
            Mn11.setVisibility(8);
            AppMethodBeat.o(165326);
            return;
        }
        kotlin.g.b.p.g(Mn11, "level2TipsLayout");
        Mn11.setVisibility(0);
        ((TextView) Mn11.findViewById(R.id.hr1)).setText(string);
        View findViewById = Mn11.findViewById(R.id.hqy);
        kotlin.g.b.p.g(findViewById, "arrowIv");
        findViewById.setVisibility(0);
        View findViewById2 = Mn11.findViewById(R.id.hr0);
        kotlin.g.b.p.g(findViewById2, "loadingView");
        findViewById2.setVisibility(8);
        Mn11.setOnClickListener(new e(this, findViewById, findViewById2, sVar2));
        View Mn14 = hVar.Mn(R.id.i3t);
        kotlin.g.b.p.g(Mn14, "holder.getView<View>(split_line)");
        Mn14.setVisibility(0);
        AppMethodBeat.o(165326);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3112b;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    @SuppressLint({"ResourceType"})
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(165324);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.cek);
        ak akVar = new ak(Mn);
        kotlin.g.b.p.g(Mn, "footerTouchDelegateView");
        Mn.setTouchDelegate(akVar);
        int aH = com.tencent.mm.cb.a.aH(hVar.getContext(), R.dimen.cb);
        View Mn2 = hVar.Mn(R.id.b98);
        if (Mn2 != null) {
            Mn2.post(new n(Mn2, aH, akVar));
        }
        View Mn3 = hVar.Mn(R.id.xm);
        if (Mn3 != null) {
            Mn3.post(new o(Mn3, aH, akVar));
        }
        hVar.Mn(R.id.xm).setOnClickListener(new p(this, hVar));
        FinderCollapsibleTextView finderCollapsibleTextView = (FinderCollapsibleTextView) hVar.Mn(R.id.h36);
        finderCollapsibleTextView.setLimitLine(2);
        finderCollapsibleTextView.setCollapse(true);
        finderCollapsibleTextView.oV(false);
        finderCollapsibleTextView.setOnCollapse(new l(hVar));
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        finderCollapsibleTextView.setTextColor(context.getResources().getColor(R.color.BW_0_Alpha_0_3));
        FinderCollapsibleTextView finderCollapsibleTextView2 = (FinderCollapsibleTextView) hVar.Mn(R.id.b8e);
        finderCollapsibleTextView2.setLimitLine(4);
        finderCollapsibleTextView2.setCollapse(true);
        finderCollapsibleTextView2.oV(false);
        finderCollapsibleTextView2.setOnCollapse(new m(hVar));
        AppMethodBeat.o(165324);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$1$1"})
    static final class n implements Runnable {
        final /* synthetic */ ak tzA;
        final /* synthetic */ View tzy;
        final /* synthetic */ int tzz;

        n(View view, int i2, ak akVar) {
            this.tzy = view;
            this.tzz = i2;
            this.tzA = akVar;
        }

        public final void run() {
            AppMethodBeat.i(242788);
            Rect rect = new Rect();
            this.tzy.getHitRect(rect);
            rect.inset(-this.tzz, -this.tzz);
            this.tzA.a(new al(rect, this.tzy));
            AppMethodBeat.o(242788);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
    static final class o implements Runnable {
        final /* synthetic */ ak tzA;
        final /* synthetic */ View tzy;
        final /* synthetic */ int tzz;

        o(View view, int i2, ak akVar) {
            this.tzy = view;
            this.tzz = i2;
            this.tzA = akVar;
        }

        public final void run() {
            AppMethodBeat.i(242789);
            Rect rect = new Rect();
            this.tzy.getHitRect(rect);
            rect.inset(-this.tzz, -this.tzz);
            this.tzA.a(new al(rect, this.tzy));
            AppMethodBeat.o(242789);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ h tzp;

        p(h hVar, com.tencent.mm.view.recyclerview.h hVar2) {
            this.tzp = hVar;
            this.qhp = hVar2;
        }

        public final void onClick(View view) {
            Drawable m;
            AppMethodBeat.i(242790);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.tzp.tzm.isCommentClose()) {
                u.makeText(this.qhp.getContext(), (int) R.string.cjc, 0).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(242790);
            } else if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(242790);
                throw tVar;
            } else {
                ImageView imageView = (ImageView) view;
                s sVar = (s) this.qhp.hgv();
                j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                boolean z = !com.tencent.mm.plugin.finder.upload.action.j.vUv.a(this.tzp.tzm.dcB().field_id, sVar.uOf, this.tzp.tzm.dcA());
                if (z) {
                    Context context = this.qhp.getContext();
                    Context context2 = this.qhp.getContext();
                    kotlin.g.b.p.g(context2, "holder.context");
                    m = ar.m(context, R.raw.icon_filled_awesome, context2.getResources().getColor(R.color.Red_90));
                } else {
                    Context context3 = this.qhp.getContext();
                    Context context4 = this.qhp.getContext();
                    kotlin.g.b.p.g(context4, "holder.context");
                    m = ar.m(context3, R.raw.icon_outlined_awesome, context4.getResources().getColor(R.color.fo));
                }
                imageView.setImageDrawable(m);
                this.tzp.tzm.a(imageView, this.qhp.lR());
                j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                int b2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.b(this.tzp.tzm.dcB().field_id, sVar.uOf, this.tzp.tzm.dcA());
                if (b2 > 0) {
                    this.qhp.mf(R.id.xn, 0);
                    this.qhp.e(R.id.xn, String.valueOf(b2));
                } else {
                    this.qhp.mf(R.id.xn, 8);
                    this.qhp.e(R.id.xn, "");
                }
                if (z) {
                    Context context5 = this.qhp.getContext();
                    kotlin.g.b.p.g(context5, "holder.context");
                    ((TextView) this.qhp.Mn(R.id.xn)).setTextColor(context5.getResources().getColor(R.color.Red_100));
                } else {
                    Context context6 = this.qhp.getContext();
                    kotlin.g.b.p.g(context6, "holder.context");
                    ((TextView) this.qhp.Mn(R.id.xn)).setTextColor(context6.getResources().getColor(R.color.BW_0_Alpha_0_3));
                }
                if (z) {
                    com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                    com.tencent.mm.plugin.finder.view.animation.c.ei(imageView);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(242790);
            }
        }
    }

    private final boolean cZA() {
        AppMethodBeat.i(165325);
        if (this.tzm.dcA() == 2) {
            AppMethodBeat.o(165325);
            return true;
        }
        AppMethodBeat.o(165325);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;

        c(s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzs = sVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165316);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            String username = this.tzs.uOf.getUsername();
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.d(username, context);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, fH.tCE, 2, this.tzs.uOf.getUsername());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165316);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;

        f(s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzs = sVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165317);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            String username = this.tzs.uOf.getUsername();
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.d(username, context);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, fH.tCE, 2, this.tzs.uOf.getUsername());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165317);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;
        final /* synthetic */ String tzw;

        g(com.tencent.mm.view.recyclerview.h hVar, String str, s sVar) {
            this.qhp = hVar;
            this.tzw = str;
            this.tzs = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178101);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            y.a(this.qhp, this.tzw, this.tzs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178101);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.convert.h$h  reason: collision with other inner class name */
    static final class View$OnClickListenerC1099h implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;
        final /* synthetic */ String tzw;

        View$OnClickListenerC1099h(com.tencent.mm.view.recyclerview.h hVar, String str, s sVar) {
            this.qhp = hVar;
            this.tzw = str;
            this.tzs = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178102);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            y.a(this.qhp, this.tzw, this.tzs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178102);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ h tzp;
        final /* synthetic */ s tzs;

        i(h hVar, s sVar, com.tencent.mm.view.recyclerview.h hVar2) {
            this.tzp = hVar;
            this.tzs = sVar;
            this.qhp = hVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165318);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = d.tyZ;
            String username = this.tzs.uOf.getUsername();
            s sVar = this.tzs;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            d.a(username, sVar, context, this.tzp.tzm.getCommentScene());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165318);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ h tzp;
        final /* synthetic */ s tzs;

        j(h hVar, s sVar, com.tencent.mm.view.recyclerview.h hVar2) {
            this.tzp = hVar;
            this.tzs = sVar;
            this.qhp = hVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242787);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = d.tyZ;
            String username = this.tzs.uOf.getUsername();
            s sVar = this.tzs;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            d.a(username, sVar, context, this.tzp.tzm.getCommentScene());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242787);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ h tzp;
        final /* synthetic */ TextView tzx;

        k(h hVar, TextView textView, com.tencent.mm.view.recyclerview.h hVar2) {
            this.tzp = hVar;
            this.tzx = textView;
            this.qhp = hVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178105);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CommentDrawerContract.NPresenter nPresenter = this.tzp.tzm;
            TextView textView = this.tzx;
            kotlin.g.b.p.g(textView, "commentFailTV");
            nPresenter.af(textView, this.qhp.lR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178105);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$10", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ View tzt;

        d(View view, int i2) {
            this.tzt = view;
            this.gUj = i2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(242785);
            View view = this.tzt;
            kotlin.g.b.p.g(view, "maskView");
            view.setVisibility(8);
            Log.i("Finder.FinderFeedCommentConvert", "maskView gone " + this.gUj);
            AppMethodBeat.o(242785);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h tzp;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ s tzr;

        b(h hVar, com.tencent.mm.view.recyclerview.h hVar2, s sVar) {
            this.tzp = hVar;
            this.tzq = hVar2;
            this.tzr = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242784);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CommentDrawerContract.NPresenter nPresenter = this.tzp.tzm;
            View view2 = this.tzq.aus;
            kotlin.g.b.p.g(view2, "holder.itemView");
            nPresenter.a(view2, this.tzr);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242784);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ h tzp;
        final /* synthetic */ s tzs;
        final /* synthetic */ View tzu;
        final /* synthetic */ View tzv;

        e(h hVar, View view, View view2, s sVar) {
            this.tzp = hVar;
            this.tzu = view;
            this.tzv = view2;
            this.tzs = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242786);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.tzu;
            kotlin.g.b.p.g(view2, "arrowIv");
            view2.setVisibility(8);
            View view3 = this.tzv;
            kotlin.g.b.p.g(view3, "loadingView");
            view3.setVisibility(0);
            this.tzp.tzm.a(this.tzs, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242786);
        }
    }
}
