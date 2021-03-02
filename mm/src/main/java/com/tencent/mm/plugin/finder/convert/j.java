package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J@\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J \u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\rH\u0017J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "checkPostOk", "", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLayoutId", "", "handleLinkTvOnClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "link", "", "handlePoiOnClick", "poiText", "isNewsObject", "isSelfScene", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshActivity", "refreshAvatar", "refreshContentTime", "refreshDescContent", "refreshLink", "refreshLoadingLayout", "refreshNickName", "refreshPoi", "Companion", "plugin-finder_release"})
public final class j extends com.tencent.mm.view.recyclerview.e<t> {
    public static final a tzG = new a((byte) 0);
    final com.tencent.mm.plugin.finder.feed.f tzF;

    static {
        AppMethodBeat.i(242807);
        AppMethodBeat.o(242807);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        public static final d tzJ = new d();

        static {
            AppMethodBeat.i(242796);
            AppMethodBeat.o(242796);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(242795);
            bool.booleanValue();
            x xVar = x.SXb;
            AppMethodBeat.o(242795);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isCollapse", "", "invoke"})
    static final class e extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ t tzI;
        final /* synthetic */ j tzK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(j jVar, t tVar, com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tzK = jVar;
            this.tzI = tVar;
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            FrameLayout loadingLayout;
            FrameLayout loadingLayout2;
            AppMethodBeat.i(242797);
            boolean booleanValue = bool.booleanValue();
            this.tzI.isContentCollapsed = booleanValue;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                if (!booleanValue) {
                    com.tencent.mm.plugin.finder.view.builder.b bVar = this.tzK.tzF.tMP;
                    if (!(bVar == null || (loadingLayout2 = bVar.getLoadingLayout()) == null)) {
                        loadingLayout2.setVisibility(8);
                    }
                    com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b(fH);
                    if (b2 != null) {
                        b2.cZR().El(this.tzI.tHo.field_id);
                    }
                } else {
                    com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tzK.tzF.tMP;
                    if (!(bVar2 == null || (loadingLayout = bVar2.getLoadingLayout()) == null)) {
                        loadingLayout.setVisibility(0);
                    }
                    com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b(fH);
                    if (b3 != null) {
                        b3.cZR().Em(this.tzI.tHo.field_id);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(242797);
            return xVar;
        }
    }

    public j(com.tencent.mm.plugin.finder.feed.f fVar) {
        p.h(fVar, "presenter");
        AppMethodBeat.i(242806);
        this.tzF = fVar;
        AppMethodBeat.o(242806);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0196, code lost:
        if (r2 == null) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02e4, code lost:
        if (r1 != false) goto L_0x02e6;
     */
    @Override // com.tencent.mm.view.recyclerview.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h r14, com.tencent.mm.plugin.finder.model.t r15, int r16, int r17, boolean r18, java.util.List r19) {
        /*
        // Method dump skipped, instructions count: 1096
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.j.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3111a;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(242804);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        FinderCollapsibleTextView finderCollapsibleTextView = (FinderCollapsibleTextView) hVar.Mn(R.id.ik5);
        finderCollapsibleTextView.getContentTextView().setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(finderCollapsibleTextView.getContentTextView(), new o(hVar.getContext())));
        NeatTextView contentTextView = finderCollapsibleTextView.getContentTextView();
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        contentTextView.setTextColor(context.getResources().getColor(R.color.BW_0_Alpha_0_9));
        finderCollapsibleTextView.setLimitLine(10);
        AppMethodBeat.o(242804);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b implements View.OnLongClickListener {
        public static final b tzH = new b();

        static {
            AppMethodBeat.i(242793);
            AppMethodBeat.o(242793);
        }

        b() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(242792);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242792);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ j tzK;

        h(j jVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzK = jVar;
            this.qhp = hVar;
        }

        public final void run() {
            FrameLayout loadingLayout;
            AppMethodBeat.i(242800);
            com.tencent.mm.plugin.finder.view.builder.b bVar = this.tzK.tzF.tMP;
            if (bVar == null || (loadingLayout = bVar.getLoadingLayout()) == null) {
                AppMethodBeat.o(242800);
                return;
            }
            int paddingLeft = loadingLayout.getPaddingLeft();
            View view = this.qhp.aus;
            p.g(view, "holder.itemView");
            loadingLayout.setPadding(paddingLeft, view.getHeight(), loadingLayout.getPaddingRight(), loadingLayout.getPaddingBottom());
            AppMethodBeat.o(242800);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$$special$$inlined$apply$lambda$1"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ azs UHS;
        final /* synthetic */ t tzO;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        l(azs azs, com.tencent.mm.view.recyclerview.h hVar, t tVar) {
            this.UHS = azs;
            this.tzq = hVar;
            this.tzO = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260195);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("key_activity_id", this.UHS.twd);
            intent.putExtra("key_activity_name", this.UHS.eventName);
            intent.putExtra("key_nick_name", this.UHS.LJx);
            intent.putExtra("key_feed_ref_id", this.tzO.tHo.getFeedObject().id);
            Log.i("Finder.FeedConvert", "eventTopicId :" + this.UHS.twd + " eventName:" + this.UHS.eventName + " refId: " + this.tzO.tHo.getFeedObject().id);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.tzq.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260195);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.utils.a.aa((MMActivity) context, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260195);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        i(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242801);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View Mn = this.qhp.Mn(R.id.x1);
            if (Mn != null) {
                Mn.callOnClick();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242801);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ t tzI;

        c(t tVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tzI = tVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242794);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("finder_username", this.tzI.tHo.getUserName());
            intent.putExtra("finder_read_feed_id", this.tzI.tHo.getId());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC.a.a(context, intent, this.tzI.tHo.field_id, 1, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.qhp.getContext();
            p.g(context2, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242794);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$1"})
    static final class f implements Runnable {
        final /* synthetic */ j tzK;
        final /* synthetic */ TextView tzL;
        final /* synthetic */ String tzM;
        final /* synthetic */ View tzN;
        final /* synthetic */ t tzO;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        f(TextView textView, String str, j jVar, com.tencent.mm.view.recyclerview.h hVar, View view, t tVar) {
            this.tzL = textView;
            this.tzM = str;
            this.tzK = jVar;
            this.tzq = hVar;
            this.tzN = view;
            this.tzO = tVar;
        }

        public final void run() {
            AppMethodBeat.i(242798);
            View view = this.tzN;
            p.g(view, "linkLayout");
            int width = view.getWidth();
            if (width > 0) {
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
                TextView textView = this.tzL;
                p.g(textView, "linkTv");
                if (textView.getPaint().measureText(this.tzM) + ((float) fromDPToPix) > ((float) width)) {
                    TextView textView2 = this.tzL;
                    p.g(textView2, "linkTv");
                    TextView textView3 = this.tzL;
                    p.g(textView3, "linkTv");
                    textView2.setText(TextUtils.ellipsize(this.tzM, textView3.getPaint(), (float) (width - fromDPToPix), TextUtils.TruncateAt.END));
                }
            }
            AppMethodBeat.o(242798);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$2"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ String nNF;
        final /* synthetic */ j tzK;
        final /* synthetic */ View tzN;
        final /* synthetic */ t tzO;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        g(String str, j jVar, com.tencent.mm.view.recyclerview.h hVar, View view, t tVar) {
            this.nNF = str;
            this.tzK = jVar;
            this.tzq = hVar;
            this.tzN = view;
            this.tzO = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242799);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            j.a(this.tzq, this.tzO.tHo, this.nNF);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242799);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$1"})
    /* renamed from: com.tencent.mm.plugin.finder.convert.j$j  reason: collision with other inner class name */
    static final class RunnableC1100j implements Runnable {
        final /* synthetic */ j tzK;
        final /* synthetic */ t tzO;
        final /* synthetic */ View tzP;
        final /* synthetic */ TextView tzQ;
        final /* synthetic */ String tzR;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        RunnableC1100j(View view, TextView textView, String str, j jVar, com.tencent.mm.view.recyclerview.h hVar, t tVar) {
            this.tzP = view;
            this.tzQ = textView;
            this.tzR = str;
            this.tzK = jVar;
            this.tzq = hVar;
            this.tzO = tVar;
        }

        public final void run() {
            AppMethodBeat.i(242802);
            View view = this.tzP;
            p.g(view, "positionLayout");
            int width = view.getWidth();
            if (width > 0) {
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
                TextView textView = this.tzQ;
                p.g(textView, "poiTv");
                if (textView.getPaint().measureText(this.tzR) + ((float) fromDPToPix) > ((float) width)) {
                    TextView textView2 = this.tzQ;
                    p.g(textView2, "poiTv");
                    TextView textView3 = this.tzQ;
                    p.g(textView3, "poiTv");
                    textView2.setText(TextUtils.ellipsize(this.tzR, textView3.getPaint(), (float) (width - fromDPToPix), TextUtils.TruncateAt.END));
                }
            }
            AppMethodBeat.o(242802);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$2"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ j tzK;
        final /* synthetic */ t tzO;
        final /* synthetic */ String tzR;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        k(String str, j jVar, com.tencent.mm.view.recyclerview.h hVar, t tVar) {
            this.tzR = str;
            this.tzK = jVar;
            this.tzq = hVar;
            this.tzO = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242803);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            j.b(this.tzq, this.tzO.tHo, this.tzR);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242803);
        }
    }

    public static final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
        int i2;
        com.tencent.mm.plugin.finder.event.a b2;
        AppMethodBeat.i(242808);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        Intent intent = new Intent();
        String d2 = m.d(str, 156, i2 + 10000, (int) (System.currentTimeMillis() / 1000));
        Log.i("Finder.FeedConvert", "click linkLayout, url:" + str + ", urlWithReportParams:" + d2);
        intent.putExtra("rawUrl", d2);
        com.tencent.mm.br.c.b(hVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (fH2 == null || (b2 = FinderReporterUIC.b(fH2)) == null) {
            AppMethodBeat.o(242808);
            return;
        }
        b2.cZR().Ez(finderItem.getId());
        AppMethodBeat.o(242808);
    }

    public static final /* synthetic */ void b(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
        boolean z = true;
        AppMethodBeat.i(242809);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drN()) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drP()) {
                y yVar = y.vXH;
                if (y.In(finderItem.getUserName()) && !finderItem.isPostFinish() && (finderItem.isPostFailed() || (!finderItem.isPostFinish() && finderItem.getPostInfo().Mpc < 100))) {
                    z = false;
                }
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("key_topic_type", 2);
                    intent.putExtra("key_ref_object_id", finderItem.getId());
                    intent.putExtra("key_topic_title", str);
                    intent.putExtra("key_topic_poi_location", finderItem.getLocation().toByteArray());
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    Context context = hVar.getContext();
                    p.g(context, "holder.context");
                    FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context2 = hVar.getContext();
                    p.g(context2, "holder.context");
                    com.tencent.mm.plugin.finder.utils.a.O(context2, intent);
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    Context context3 = hVar.getContext();
                    p.g(context3, "holder.context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                    if (fH != null) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        long id = finderItem.getId();
                        if (str == null) {
                            str = "";
                        }
                        com.tencent.mm.plugin.finder.report.k.a(id, str, 2, fH.tCE);
                        intent.putExtra("KEY_TAB_TYPE", fH.wtW);
                        com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b(fH);
                        if (b2 != null) {
                            b2.cZR().Eu(finderItem.getId());
                            AppMethodBeat.o(242809);
                            return;
                        }
                        AppMethodBeat.o(242809);
                        return;
                    }
                    AppMethodBeat.o(242809);
                    return;
                }
                Log.i("Finder.FeedConvert", "click poi but isPostOk false");
                AppMethodBeat.o(242809);
                return;
            }
        }
        y yVar2 = y.vXH;
        Context context4 = hVar.getContext();
        p.g(context4, "holder.context");
        y.a(context4, finderItem.getLocation());
        AppMethodBeat.o(242809);
    }
}
