package com.tencent.mm.plugin.finder.feed.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.h;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001?B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020#H\u0014J\u001e\u0010'\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0)2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020#H\u0014J\u0018\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0016J,\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0006\u0010:\u001a\u00020#J\u0006\u0010;\u001a\u00020#J\u0006\u0010<\u001a\u00020#J\u0006\u0010=\u001a\u00020#J\b\u0010>\u001a\u00020#H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI extends MMFinderUI implements i, ai<ayt> {
    private static final String TAG = TAG;
    public static final a ucS = new a((byte) 0);
    private HashMap _$_findViewCache;
    private long feedId;
    private int gAZ;
    private TextView hRM;
    private boolean hasMore;
    private com.tencent.mm.bw.b tsO;
    private MMProcessBar uaO;
    private TextView uaP;
    private bfp uaR;
    private boolean uaS;
    private final ArrayList<aul> uae = new ArrayList<>();
    private WxRecyclerView ucP;
    private h ucQ = new h();
    private View ucR;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245537);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245537);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245536);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245536);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderSelfFeedLikeListUI() {
        AppMethodBeat.i(245532);
        AppMethodBeat.o(245532);
    }

    public static final /* synthetic */ void b(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI) {
        AppMethodBeat.i(245534);
        finderSelfFeedLikeListUI.ddX();
        AppMethodBeat.o(245534);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayt ayt, apg apg) {
        AppMethodBeat.i(245527);
        p.h(ayt, "req");
        p.h(apg, "ret");
        AppMethodBeat.o(245527);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245533);
        AppMethodBeat.o(245533);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245524);
        super.onCreate(bundle);
        g.azz().a(3593, this);
        g.azz().a(3638, this);
        try {
            com.tencent.mm.bw.a parseFrom = new bfp().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
                AppMethodBeat.o(245524);
                throw tVar;
            }
            this.uaR = (bfp) parseFrom;
            this.feedId = getIntent().getLongExtra("FEED_ID", 0);
            if (this.feedId == 0) {
                finish();
                Log.w(TAG, "feedId is 0, invalid!");
                AppMethodBeat.o(245524);
                return;
            }
            this.gAZ = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
            this.uaS = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
            initView();
            ddX();
            AppMethodBeat.o(245524);
        } catch (Throwable th) {
            finish();
            Log.w(TAG, "actionInfo invalid!");
            AppMethodBeat.o(245524);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(245525);
        View findViewById = findViewById(R.id.hjl);
        p.g(findViewById, "findViewById(R.id.self_liked_recycler_view)");
        this.ucP = (WxRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ep_);
        p.g(findViewById3, "findViewById(R.id.loading_bar)");
        this.uaO = (MMProcessBar) findViewById3;
        View findViewById4 = findViewById(R.id.h5x);
        p.g(findViewById4, "findViewById(R.id.retry_tips)");
        this.uaP = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.c2u);
        p.g(findViewById5, "findViewById(R.id.empty_footer)");
        this.ucR = findViewById5;
        updateTitle();
        setBackBtn(new b(this));
        WxRecyclerView wxRecyclerView = this.ucP;
        if (wxRecyclerView == null) {
            p.btv("listView");
        }
        wxRecyclerView.setAdapter(this.ucQ);
        WxRecyclerView wxRecyclerView2 = this.ucP;
        if (wxRecyclerView2 == null) {
            p.btv("listView");
        }
        getContext();
        wxRecyclerView2.setLayoutManager(new GridLayoutManager(5));
        WxRecyclerView wxRecyclerView3 = this.ucP;
        if (wxRecyclerView3 == null) {
            p.btv("listView");
        }
        wxRecyclerView3.b(new c(this));
        WxRecyclerView wxRecyclerView4 = this.ucP;
        if (wxRecyclerView4 == null) {
            p.btv("listView");
        }
        wxRecyclerView4.setOnScrollListener(new d(this));
        TextView textView = this.uaP;
        if (textView == null) {
            p.btv("retryTips");
        }
        textView.setOnClickListener(new e(this));
        TextView textView2 = this.hRM;
        if (textView2 == null) {
            p.btv("emptyTip");
        }
        textView2.setVisibility(8);
        WxRecyclerView wxRecyclerView5 = this.ucP;
        if (wxRecyclerView5 == null) {
            p.btv("listView");
        }
        wxRecyclerView5.setVisibility(8);
        MMProcessBar mMProcessBar = this.uaO;
        if (mMProcessBar == null) {
            p.btv("loadingBar");
        }
        mMProcessBar.setVisibility(0);
        TextView textView3 = this.uaP;
        if (textView3 == null) {
            p.btv("retryTips");
        }
        textView3.setVisibility(8);
        View view = this.ucR;
        if (view == null) {
            p.btv("emptyFooter");
        }
        view.setVisibility(8);
        AppMethodBeat.o(245525);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelfFeedLikeListUI ucT;

        b(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI) {
            this.ucT = finderSelfFeedLikeListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245518);
            this.ucT.finish();
            AppMethodBeat.o(245518);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class c extends RecyclerView.h {
        final /* synthetic */ FinderSelfFeedLikeListUI ucT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI) {
            this.ucT = finderSelfFeedLikeListUI;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(245519);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            int bw = RecyclerView.bw(view);
            AppCompatActivity context = this.ucT.getContext();
            p.g(context, "context");
            int dimension = (int) context.getResources().getDimension(R.dimen.cb);
            AppCompatActivity context2 = this.ucT.getContext();
            p.g(context2, "context");
            int dimension2 = (int) context2.getResources().getDimension(R.dimen.cc);
            AppCompatActivity context3 = this.ucT.getContext();
            p.g(context3, "context");
            int dimension3 = (int) context3.getResources().getDimension(R.dimen.ce);
            AppCompatActivity context4 = this.ucT.getContext();
            p.g(context4, "context");
            int dimension4 = (int) context4.getResources().getDimension(R.dimen.ct);
            if (bw < 5) {
                rect.top = dimension;
            } else {
                rect.top = dimension2;
            }
            switch (bw % 5) {
                case 0:
                    rect.left = dimension3;
                    rect.right = dimension4;
                    AppMethodBeat.o(245519);
                    return;
                case 4:
                    rect.left = dimension4;
                    rect.right = dimension3;
                    AppMethodBeat.o(245519);
                    return;
                default:
                    rect.left = dimension4;
                    rect.right = dimension4;
                    AppMethodBeat.o(245519);
                    return;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class d extends RecyclerView.l {
        final /* synthetic */ FinderSelfFeedLikeListUI ucT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI) {
            this.ucT = finderSelfFeedLikeListUI;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245520);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && !recyclerView.canScrollVertically(1)) {
                if (this.ucT.hasMore) {
                    FinderSelfFeedLikeListUI.b(this.ucT);
                } else {
                    this.ucT.ddY();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245520);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245521);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245521);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ FinderSelfFeedLikeListUI ucT;

        e(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI) {
            this.ucT = finderSelfFeedLikeListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245522);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderSelfFeedLikeListUI.b(this.ucT);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245522);
        }
    }

    private final void updateTitle() {
        AppMethodBeat.i(245526);
        setMMTitle(getString(R.string.cpr, new Object[]{Integer.valueOf(this.gAZ)}));
        AppMethodBeat.o(245526);
    }

    private final void ddX() {
        AppMethodBeat.i(245528);
        g.azz().b(new bl(this.tsO, this.feedId, this.uaS));
        AppMethodBeat.o(245528);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245529);
        super.onDestroy();
        g.azz().b(3593, this);
        g.azz().b(3638, this);
        AppMethodBeat.o(245529);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajn;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(245530);
        if (qVar instanceof bl) {
            Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            if (i2 == 0 && i3 == 0) {
                if (qVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
                    AppMethodBeat.o(245530);
                    throw tVar;
                }
                if (!p.j(this.tsO, ((bl) qVar).cYn())) {
                    Log.i(TAG, "not my buf, ignore!");
                    AppMethodBeat.o(245530);
                    return;
                }
                if (this.tsO == null) {
                    z = true;
                }
                if (z) {
                    this.gAZ = ((bl) qVar).cYx().gAZ;
                    updateTitle();
                }
                this.hasMore = ((bl) qVar).cYp();
                this.tsO = ((bl) qVar).cYm();
                com.tencent.mm.ac.d.h(new f(this, qVar, z));
                AppMethodBeat.o(245530);
                return;
            } else if (this.tsO == null) {
                TextView textView = this.hRM;
                if (textView == null) {
                    p.btv("emptyTip");
                }
                textView.setVisibility(8);
                WxRecyclerView wxRecyclerView = this.ucP;
                if (wxRecyclerView == null) {
                    p.btv("listView");
                }
                wxRecyclerView.setVisibility(8);
                MMProcessBar mMProcessBar = this.uaO;
                if (mMProcessBar == null) {
                    p.btv("loadingBar");
                }
                mMProcessBar.setVisibility(8);
                TextView textView2 = this.uaP;
                if (textView2 == null) {
                    p.btv("retryTips");
                }
                textView2.setVisibility(0);
                View view = this.ucR;
                if (view == null) {
                    p.btv("emptyFooter");
                }
                view.setVisibility(8);
            }
        }
        AppMethodBeat.o(245530);
    }

    public final void ddY() {
        AppMethodBeat.i(245531);
        View view = this.ucR;
        if (view == null) {
            p.btv("emptyFooter");
        }
        view.setVisibility(0);
        TextView textView = this.hRM;
        if (textView == null) {
            p.btv("emptyTip");
        }
        textView.setVisibility(8);
        MMProcessBar mMProcessBar = this.uaO;
        if (mMProcessBar == null) {
            p.btv("loadingBar");
        }
        mMProcessBar.setVisibility(8);
        AppMethodBeat.o(245531);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q hvN;
        final /* synthetic */ boolean uaY;
        final /* synthetic */ FinderSelfFeedLikeListUI ucT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI, q qVar, boolean z) {
            super(0);
            this.ucT = finderSelfFeedLikeListUI;
            this.hvN = qVar;
            this.uaY = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245523);
            FinderSelfFeedLikeListUI.a(this.ucT, ((bl) this.hvN).cYw(), this.uaY);
            x xVar = x.SXb;
            AppMethodBeat.o(245523);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderSelfFeedLikeListUI finderSelfFeedLikeListUI, List list, boolean z) {
        AppMethodBeat.i(245535);
        Log.i(TAG, "friend list: " + list.size());
        if (!z || list.size() != 0) {
            TextView textView = finderSelfFeedLikeListUI.hRM;
            if (textView == null) {
                p.btv("emptyTip");
            }
            textView.setVisibility(8);
            WxRecyclerView wxRecyclerView = finderSelfFeedLikeListUI.ucP;
            if (wxRecyclerView == null) {
                p.btv("listView");
            }
            wxRecyclerView.setVisibility(0);
            MMProcessBar mMProcessBar = finderSelfFeedLikeListUI.uaO;
            if (mMProcessBar == null) {
                p.btv("loadingBar");
            }
            mMProcessBar.setVisibility(8);
            TextView textView2 = finderSelfFeedLikeListUI.uaP;
            if (textView2 == null) {
                p.btv("retryTips");
            }
            textView2.setVisibility(8);
            View view = finderSelfFeedLikeListUI.ucR;
            if (view == null) {
                p.btv("emptyFooter");
            }
            view.setVisibility(8);
            finderSelfFeedLikeListUI.uae.addAll(list);
            h hVar = finderSelfFeedLikeListUI.ucQ;
            ArrayList<aul> arrayList = finderSelfFeedLikeListUI.uae;
            p.h(arrayList, "datalist");
            hVar.vNT = arrayList;
            finderSelfFeedLikeListUI.ucQ.notifyDataSetChanged();
            if (!finderSelfFeedLikeListUI.hasMore) {
                finderSelfFeedLikeListUI.ddY();
            }
            AppMethodBeat.o(245535);
            return;
        }
        TextView textView3 = finderSelfFeedLikeListUI.hRM;
        if (textView3 == null) {
            p.btv("emptyTip");
        }
        textView3.setVisibility(0);
        WxRecyclerView wxRecyclerView2 = finderSelfFeedLikeListUI.ucP;
        if (wxRecyclerView2 == null) {
            p.btv("listView");
        }
        wxRecyclerView2.setVisibility(8);
        MMProcessBar mMProcessBar2 = finderSelfFeedLikeListUI.uaO;
        if (mMProcessBar2 == null) {
            p.btv("loadingBar");
        }
        mMProcessBar2.setVisibility(8);
        TextView textView4 = finderSelfFeedLikeListUI.uaP;
        if (textView4 == null) {
            p.btv("retryTips");
        }
        textView4.setVisibility(8);
        View view2 = finderSelfFeedLikeListUI.ucR;
        if (view2 == null) {
            p.btv("emptyFooter");
        }
        view2.setVisibility(8);
        AppMethodBeat.o(245535);
    }
}
