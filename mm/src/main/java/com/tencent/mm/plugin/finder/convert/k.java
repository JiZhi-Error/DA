package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J@\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0017J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class k extends com.tencent.mm.view.recyclerview.e<s> {
    public static final a tzS = new a((byte) 0);
    private final CommentDrawerContract.NPresenter tzm;

    static {
        AppMethodBeat.i(178121);
        AppMethodBeat.o(178121);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke"})
    static final class j extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ k tzT;
        final /* synthetic */ s tzs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(k kVar, s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tzT = kVar;
            this.tzs = sVar;
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(242813);
            String str2 = str;
            p.h(str2, ch.COL_USERNAME);
            d dVar = d.tyZ;
            s sVar = this.tzs;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            d.a(str2, sVar, context, this.tzT.tzm.getCommentScene());
            x xVar = x.SXb;
            AppMethodBeat.o(242813);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
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
            AppMethodBeat.i(178115);
            boolean booleanValue = bool.booleanValue();
            Object hgv = this.tzq.hgv();
            if (hgv == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedComment");
                AppMethodBeat.o(178115);
                throw tVar;
            }
            ((s) hgv).uNZ = booleanValue;
            x xVar = x.SXb;
            AppMethodBeat.o(178115);
            return xVar;
        }
    }

    public k(CommentDrawerContract.NPresenter nPresenter) {
        p.h(nPresenter, "presenter");
        AppMethodBeat.i(178120);
        this.tzm = nPresenter;
        AppMethodBeat.o(178120);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x04a1, code lost:
        if (r5 != false) goto L_0x04a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x04ee  */
    @Override // com.tencent.mm.view.recyclerview.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h r19, com.tencent.mm.plugin.finder.model.s r20, int r21, int r22, boolean r23, java.util.List r24) {
        /*
        // Method dump skipped, instructions count: 2285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.k.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List):void");
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3113c;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
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
        AppMethodBeat.i(178116);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        FinderCollapsibleTextView finderCollapsibleTextView = (FinderCollapsibleTextView) hVar.Mn(R.id.b8e);
        finderCollapsibleTextView.setLimitLine(4);
        finderCollapsibleTextView.setCollapse(true);
        finderCollapsibleTextView.oV(false);
        finderCollapsibleTextView.setOnCollapse(new l(hVar));
        AppMethodBeat.o(178116);
    }

    private final boolean cZA() {
        AppMethodBeat.i(178117);
        if (this.tzm.dcA() == 2) {
            AppMethodBeat.o(178117);
            return true;
        }
        AppMethodBeat.o(178117);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;
        final /* synthetic */ String tzw;

        c(com.tencent.mm.view.recyclerview.h hVar, String str, s sVar) {
            this.qhp = hVar;
            this.tzw = str;
            this.tzs = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178108);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            y.a(this.qhp, this.tzw, this.tzs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178108);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;
        final /* synthetic */ String tzw;

        e(com.tencent.mm.view.recyclerview.h hVar, String str, s sVar) {
            this.qhp = hVar;
            this.tzw = str;
            this.tzs = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178109);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            y.a(this.qhp, this.tzw, this.tzs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178109);
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
            AppMethodBeat.i(178110);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            String username = this.tzs.uOf.getUsername();
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.d(username, context);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.qhp.getContext();
            p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, fH.tCE, 2, this.tzs.uOf.getUsername());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178110);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ s tzs;

        g(s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzs = sVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178111);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            String username = this.tzs.uOf.getUsername();
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.d(username, context);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.qhp.getContext();
            p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, fH.tCE, 2, this.tzs.uOf.getUsername());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178111);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ k tzT;
        final /* synthetic */ s tzs;

        h(k kVar, s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzT = kVar;
            this.tzs = sVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242811);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = d.tyZ;
            String username = this.tzs.uOf.getUsername();
            s sVar = this.tzs;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            d.a(username, sVar, context, this.tzT.tzm.getCommentScene());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242811);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ k tzT;
        final /* synthetic */ s tzs;

        i(k kVar, s sVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzT = kVar;
            this.tzs = sVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242812);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = d.tyZ;
            String username = this.tzs.uOf.getUsername();
            s sVar = this.tzs;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            d.a(username, sVar, context, this.tzT.tzm.getCommentScene());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242812);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.convert.k$k  reason: collision with other inner class name */
    static final class View$OnClickListenerC1101k implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ k tzT;
        final /* synthetic */ TextView tzx;

        View$OnClickListenerC1101k(k kVar, TextView textView, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzT = kVar;
            this.tzx = textView;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242814);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CommentDrawerContract.NPresenter nPresenter = this.tzT.tzm;
            TextView textView = this.tzx;
            p.g(textView, "commentFailTV");
            nPresenter.af(textView, this.qhp.lR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242814);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$10", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
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
            AppMethodBeat.i(242810);
            View view = this.tzt;
            p.g(view, "maskView");
            view.setVisibility(8);
            Log.i("Finder.FinderFeedCommentConvert", "maskView gone " + this.gUj);
            AppMethodBeat.o(242810);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void a(View view, String str, s sVar, boolean z) {
        AppMethodBeat.i(178119);
        view.setVisibility(0);
        ((TextView) view.findViewById(R.id.hr1)).setText(str);
        View findViewById = view.findViewById(R.id.hqy);
        p.g(findViewById, "arrowIv");
        findViewById.setVisibility(0);
        View findViewById2 = view.findViewById(R.id.hr0);
        p.g(findViewById2, "loadingView");
        findViewById2.setVisibility(8);
        view.setOnClickListener(new b(this, findViewById, findViewById2, sVar, z));
        AppMethodBeat.o(178119);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ k tzT;
        final /* synthetic */ s tzU;
        final /* synthetic */ boolean tzV;
        final /* synthetic */ View tzu;
        final /* synthetic */ View tzv;

        b(k kVar, View view, View view2, s sVar, boolean z) {
            this.tzT = kVar;
            this.tzu = view;
            this.tzv = view2;
            this.tzU = sVar;
            this.tzV = z;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178107);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.tzu;
            p.g(view2, "arrowIv");
            view2.setVisibility(8);
            View view3 = this.tzv;
            p.g(view3, "loadingView");
            view3.setVisibility(0);
            this.tzT.tzm.a(this.tzU, this.tzV);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178107);
        }
    }
}
