package com.tencent.mm.plugin.finder.search;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.cb;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.search.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class f implements e.b {
    public static final a vuD = new a((byte) 0);
    private final String TAG = "Finder.FinderMixSearchViewCallback";
    private MMActivity gte;
    View hSw;
    RecyclerView hak;
    private RefreshLoadMoreLayout tLS;
    TextView vtJ;
    private e.a vuC;

    static {
        AppMethodBeat.i(251337);
        AppMethodBeat.o(251337);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(MMActivity mMActivity, final e.a aVar) {
        com.tencent.mm.plugin.finder.event.base.f d2;
        p.h(mMActivity, "context");
        p.h(aVar, "presenter");
        AppMethodBeat.i(166842);
        this.gte = mMActivity;
        this.vuC = aVar;
        View findViewById = mMActivity.findViewById(R.id.h7t);
        p.g(findViewById, "context.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById;
        View findViewById2 = mMActivity.findViewById(R.id.g01);
        p.g(findViewById2, "context.findViewById(R.id.no_result_tv)");
        this.vtJ = (TextView) findViewById2;
        View findViewById3 = mMActivity.findViewById(R.id.epl);
        p.g(findViewById3, "context.findViewById(R.id.loading_layout)");
        this.hSw = findViewById3;
        this.hak = this.tLS.getRecyclerView();
        this.hak.setLayoutManager(new FinderStaggeredGridLayoutManager(2));
        this.hak.setAdapter(new b());
        Resources resources = this.gte.getResources();
        if (resources == null) {
            p.hyc();
        }
        this.hak.b(new c((int) resources.getDimension(R.dimen.bt)));
        this.tLS.setEnablePullDownHeader(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        View inflate = aa.jQ(mMActivity).inflate(R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        refreshLoadMoreLayout.setLoadMoreFooter(inflate);
        this.tLS.setActionCallback(new RefreshLoadMoreLayout.a(this) {
            /* class com.tencent.mm.plugin.finder.search.f.AnonymousClass1 */
            final /* synthetic */ f vuE;

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                AppMethodBeat.i(251326);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(251326);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c cVar) {
                AppMethodBeat.i(251328);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                super.a(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(251328);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
                AppMethodBeat.i(251327);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                super.onRefreshEnd(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(251327);
            }

            {
                this.vuE = r1;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                View findViewById;
                TextView textView;
                TextView textView2;
                View findViewById2;
                TextView textView3;
                TextView textView4;
                AppMethodBeat.i(166828);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                String unused = this.vuE.TAG;
                h.hkS();
                if (aVar.dpC()) {
                    View loadMoreFooter = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = this.vuE.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(166828);
            }
        });
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(mMActivity);
        if (fH == null || (d2 = FinderReporterUIC.d(fH)) == null) {
            AppMethodBeat.o(166842);
            return;
        }
        d2.m(this.hak);
        AppMethodBeat.o(166842);
    }

    public final void dpF() {
        AppMethodBeat.i(251333);
        this.tLS.setVisibility(0);
        AppMethodBeat.o(251333);
    }

    public final void dpG() {
        AppMethodBeat.i(251334);
        this.tLS.setVisibility(4);
        AppMethodBeat.o(251334);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(251335);
        if (this.tLS.getVisibility() == 0) {
            AppMethodBeat.o(251335);
            return true;
        }
        AppMethodBeat.o(251335);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.search.e.b
    public final void gg(int i2, int i3) {
        AppMethodBeat.i(166840);
        int size = this.vuC.dpA().size();
        int size2 = this.vuC.cYD().size();
        dpF();
        if (size > 0 || size2 > 0) {
            this.vtJ.setVisibility(8);
            this.hSw.setVisibility(8);
            this.hak.setVisibility(0);
        } else {
            this.vtJ.setVisibility(0);
            this.hSw.setVisibility(8);
            this.hak.setVisibility(8);
        }
        if (i2 == 0 && i3 == 0) {
            RecyclerView.a adapter = this.hak.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            int gh = gh(i2, i3) + i3;
            int gh2 = gh(size, size2) + size2;
            RecyclerView.a adapter2 = this.hak.getAdapter();
            if (adapter2 != null) {
                adapter2.as(gh, gh2);
            }
        }
        this.tLS.apT(0);
        AppMethodBeat.o(166840);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.b
    public final void ci(int i2) {
        AppMethodBeat.i(251336);
        RecyclerView.a adapter = this.hak.getAdapter();
        if (adapter != null) {
            adapter.ci(i2);
            AppMethodBeat.o(251336);
            return;
        }
        AppMethodBeat.o(251336);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.b
    public final void dpE() {
        AppMethodBeat.i(166841);
        this.hak.setVisibility(8);
        this.vtJ.setVisibility(8);
        this.hSw.setVisibility(0);
        RecyclerView recyclerView = this.hak;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(166841);
    }

    private static int gh(int i2, int i3) {
        if (i2 > 3 && i3 > 0) {
            return 4;
        }
        if (i2 > 0) {
            return i2 + 1;
        }
        return 0;
    }

    public final class b extends RecyclerView.a<RecyclerView.v> {

        public static final class c extends q implements kotlin.g.a.b<Integer, x> {
            final /* synthetic */ int gUj;
            final /* synthetic */ b vuG;
            final /* synthetic */ BaseFinderFeed vuH;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar, BaseFinderFeed baseFinderFeed, int i2) {
                super(1);
                this.vuG = bVar;
                this.vuH = baseFinderFeed;
                this.gUj = i2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                awe liveInfo;
                AppMethodBeat.i(251329);
                num.intValue();
                if (this.vuH.feedObject.isLiveFeed() || ((liveInfo = this.vuH.feedObject.getLiveInfo()) != null && liveInfo.liveStatus == 1)) {
                    k.vkd.a(this.vuH, (long) this.gUj, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene);
                }
                y yVar = y.vXH;
                if (y.w(this.vuH)) {
                    f.this.vuC.q(this.vuH);
                } else {
                    f.this.vuC.r(this.vuH);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(251329);
                return xVar;
            }
        }

        public b() {
            f.this = r1;
        }

        public final List<BaseFinderFeed> dpH() {
            AppMethodBeat.i(251330);
            List<BaseFinderFeed> cYD = f.this.vuC.cYD();
            AppMethodBeat.o(251330);
            return cYD;
        }

        public final int KL(int i2) {
            AppMethodBeat.i(251331);
            int b2 = f.b(f.this);
            if (i2 < b2) {
                AppMethodBeat.o(251331);
                return -1;
            } else if (i2 == b2) {
                AppMethodBeat.o(251331);
                return -1;
            } else {
                int i3 = (i2 - b2) - 1;
                AppMethodBeat.o(251331);
                return i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(166832);
            if (!f.this.vuC.cYD().isEmpty()) {
                int b2 = f.b(f.this) + f.this.vuC.cYD().size() + 1;
                AppMethodBeat.o(166832);
                return b2;
            }
            int b3 = f.b(f.this);
            AppMethodBeat.o(166832);
            return b3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(166833);
            if (f.this.vuC == null) {
                p.hyc();
            }
            int b2 = f.b(f.this);
            if (i2 < b2) {
                if (i2 == 0) {
                    AppMethodBeat.o(166833);
                    return 1;
                }
                AppMethodBeat.o(166833);
                return 2;
            } else if (i2 == b2) {
                AppMethodBeat.o(166833);
                return 3;
            } else {
                AppMethodBeat.o(166833);
                return 4;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void k(RecyclerView.v vVar) {
            boolean z = true;
            AppMethodBeat.i(166834);
            p.h(vVar, "holder");
            super.k(vVar);
            View view = vVar.aus;
            p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                if (!(vVar.lU() == 1 || vVar.lU() == 2 || vVar.lU() == 3)) {
                    z = false;
                }
                layoutParams2.aC(z);
            }
            AppMethodBeat.o(166834);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(166835);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 1:
                    MMActivity mMActivity = f.this.gte;
                    if (mMActivity == null) {
                        p.hyc();
                    }
                    View inflate = mMActivity.getLayoutInflater().inflate(R.layout.ags, viewGroup, false);
                    p.g(inflate, "headerLayout");
                    b bVar = new b(inflate);
                    AppMethodBeat.o(166835);
                    return bVar;
                case 2:
                    MMActivity mMActivity2 = f.this.gte;
                    if (mMActivity2 == null) {
                        p.hyc();
                    }
                    View inflate2 = mMActivity2.getLayoutInflater().inflate(R.layout.a_1, viewGroup, false);
                    p.g(inflate2, "contactLayout");
                    c cVar = new c(inflate2);
                    AppMethodBeat.o(166835);
                    return cVar;
                case 3:
                    View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ab7, viewGroup, false);
                    p.g(inflate3, "convertView");
                    d dVar = new d(inflate3);
                    AppMethodBeat.o(166835);
                    return dVar;
                default:
                    View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.agt, viewGroup, false);
                    p.g(inflate4, "convertView");
                    cb cbVar = new cb(inflate4);
                    AppMethodBeat.o(166835);
                    return cbVar;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void i(android.support.v7.widget.RecyclerView.v r11, int r12) {
            /*
            // Method dump skipped, instructions count: 2206
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.f.b.i(android.support.v7.widget.RecyclerView$v, int):void");
        }

        public static final class a implements View.OnClickListener {
            final /* synthetic */ b vuG;

            a(b bVar) {
                this.vuG = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(166829);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.this.vuC.dpB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(166829);
            }
        }

        /* renamed from: com.tencent.mm.plugin.finder.search.f$b$b */
        public static final class View$OnClickListenerC1272b implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b vuG;

            View$OnClickListenerC1272b(b bVar, int i2) {
                this.vuG = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(166830);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                p.g(view, LocaleUtil.ITALIAN);
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
                    AppMethodBeat.o(166830);
                    throw tVar;
                }
                bbz bbz = (bbz) tag;
                FinderContact finderContact = bbz.contact;
                if (finderContact != null && finderContact.liveStatus == 1) {
                    k kVar = k.vkd;
                    FinderContact finderContact2 = bbz.contact;
                    if (finderContact2 == null || (str = finderContact2.username) == null) {
                        str = "";
                    }
                    kVar.a(null, str, (long) this.gUj, s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR, "23");
                }
                f.this.vuC.a(bbz, this.gUj - 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(166830);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2, List<Object> list) {
            AppMethodBeat.i(166836);
            p.h(vVar, "holder");
            p.h(list, "payloads");
            i(vVar, i2);
            AppMethodBeat.o(166836);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(166838);
            p.h(vVar, "holder");
            i(vVar, i2);
            AppMethodBeat.o(166838);
        }
    }

    public final class c extends RecyclerView.h {
        private final int tCv;

        public c(int i2) {
            f.this = r1;
            this.tCv = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00ba  */
        @Override // android.support.v7.widget.RecyclerView.h
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.graphics.Rect r9, android.view.View r10, android.support.v7.widget.RecyclerView r11, android.support.v7.widget.RecyclerView.s r12) {
            /*
            // Method dump skipped, instructions count: 225
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.f.c.a(android.graphics.Rect, android.view.View, android.support.v7.widget.RecyclerView, android.support.v7.widget.RecyclerView$s):void");
        }

        private final void a(Rect rect, RecyclerView.v vVar) {
            AppMethodBeat.i(251332);
            int i2 = (int) (((float) this.tCv) / 2.0f);
            rect.top = this.tCv;
            View view = vVar.aus;
            p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                rect.left = this.tCv;
                rect.right = this.tCv;
                AppMethodBeat.o(251332);
            } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).kj() == 0) {
                rect.left = this.tCv;
                rect.right = i2;
                AppMethodBeat.o(251332);
            } else {
                rect.left = i2;
                rect.right = this.tCv;
                AppMethodBeat.o(251332);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.gte;
    }

    public static final /* synthetic */ int b(f fVar) {
        AppMethodBeat.i(166843);
        int gh = gh(fVar.vuC.dpA().size(), fVar.vuC.cYD().size());
        AppMethodBeat.o(166843);
        return gh;
    }
}
