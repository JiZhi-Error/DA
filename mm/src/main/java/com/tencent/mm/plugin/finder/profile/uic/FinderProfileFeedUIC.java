package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.FinderTopicFilterView;
import com.tencent.mm.plugin.finder.profile.FlowLayoutManager;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0015\u001f\u0018\u0000 @2\u00020\u0001:\u0002@AB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00103\u001a\u00020\u0006H\u0016J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u0002052\u0006\u00107\u001a\u0002082\u0006\u00106\u001a\u00020\u0006H\u0002J\u0012\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u000205H\u0016J\b\u0010>\u001a\u000205H\u0016J\b\u0010?\u001a\u000205H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u00060\nR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R#\u0010(\u001a\n **\u0004\u0018\u00010)0)8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "FILTER_VIEW_TYPE", "", "getFILTER_VIEW_TYPE", "()I", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "feedProgressListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1;", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1;", "mainFlowLayout", "Landroid/widget/FrameLayout;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "stateLayout", "getLayoutId", "jumpProfileTimeline", "", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileFeedUIC extends FinderProfileFragmentUIC {
    public static final a vba = new a((byte) 0);
    private final kotlin.f tPy = kotlin.g.ah(new d(this));
    private final kotlin.f tSX;
    private FrameLayout vaG;
    private FrameLayout vaH;
    private com.tencent.mm.plugin.finder.profile.b vaW;
    private final int vaX;
    private final e vaY;
    private final g vaZ;
    private final kotlin.f vas = kotlin.g.ah(new f(this));
    private final kotlin.f vau;
    private final kotlin.f vaw;

    static {
        AppMethodBeat.i(250240);
        AppMethodBeat.o(250240);
    }

    private final b getActionCallback() {
        AppMethodBeat.i(250231);
        b bVar = (b) this.vaw.getValue();
        AppMethodBeat.o(250231);
        return bVar;
    }

    private final FinderProfileFeedLoader getFeedLoader() {
        AppMethodBeat.i(250227);
        FinderProfileFeedLoader finderProfileFeedLoader = (FinderProfileFeedLoader) this.tPy.getValue();
        AppMethodBeat.o(250227);
        return finderProfileFeedLoader;
    }

    private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig() {
        AppMethodBeat.i(250228);
        com.tencent.mm.plugin.finder.profile.a aVar = (com.tencent.mm.plugin.finder.profile.a) this.vas.getValue();
        AppMethodBeat.o(250228);
        return aVar;
    }

    private final RecyclerView getRecyclerView() {
        AppMethodBeat.i(250230);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(250230);
        return recyclerView;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(250229);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(250229);
        return refreshLoadMoreLayout;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.m<bds, Boolean, x> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(2);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(bds bds, Boolean bool) {
            AppMethodBeat.i(250220);
            bds bds2 = bds;
            boolean booleanValue = bool.booleanValue();
            kotlin.g.b.p.h(bds2, "item");
            if (booleanValue) {
                FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).switchToTopic(bds2.twp);
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21570, this.vbb.getUsername() + ",2," + com.tencent.mm.ac.d.zs(bds2.twp));
            } else {
                FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).switchToTopic(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250220);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(1);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(250223);
            kotlin.g.b.p.h(iResponse, "resp");
            Log.i("Finder.ProfileFeedUIC", "[fetchEndCallback] totalSize=" + FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).getSize());
            View loadMoreFooter = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).getLoadMoreFooter();
            if (loadMoreFooter != null) {
                TextView textView = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView != null) {
                    textView.setText(R.string.d0m);
                }
                TextView textView2 = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView2 != null) {
                    textView2.setTextColor(this.vbb.getActivity().getResources().getColor(R.color.FG_2));
                }
                TextView textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                View findViewById = loadMoreFooter.findViewById(R.id.ep0);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
            }
            FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).setHasBottomMore(false);
            x xVar = x.SXb;
            AppMethodBeat.o(250223);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.b<hm, x> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(1);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(hm hmVar) {
            AppMethodBeat.i(250224);
            kotlin.g.b.p.h(hmVar, "event");
            if (!FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).RlV) {
                View loadMoreFooter = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).getLoadMoreFooter();
                if (loadMoreFooter != null) {
                    TextView textView = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                    if (textView != null) {
                        textView.setText(R.string.wc);
                    }
                    TextView textView2 = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    View findViewById = loadMoreFooter.findViewById(R.id.ep0);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).setHasBottomMore(true);
            }
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).clearStoreCache();
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).requestRefresh();
            x xVar = x.SXb;
            AppMethodBeat.o(250224);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileFeedUIC(Fragment fragment) {
        super(fragment);
        kotlin.g.b.p.h(fragment, "fragment");
        AppMethodBeat.i(250239);
        this.tSX = kotlin.g.ah(new q(fragment));
        this.vau = kotlin.g.ah(new p(this));
        this.vaw = kotlin.g.ah(new c(this));
        this.vaX = 10000001;
        this.vaY = new e(this);
        this.vaZ = new g();
        AppMethodBeat.o(250239);
    }

    public static final /* synthetic */ b access$getActionCallback$p(FinderProfileFeedUIC finderProfileFeedUIC) {
        AppMethodBeat.i(250247);
        b actionCallback = finderProfileFeedUIC.getActionCallback();
        AppMethodBeat.o(250247);
        return actionCallback;
    }

    public static final /* synthetic */ FinderProfileFeedLoader access$getFeedLoader$p(FinderProfileFeedUIC finderProfileFeedUIC) {
        AppMethodBeat.i(250241);
        FinderProfileFeedLoader feedLoader = finderProfileFeedUIC.getFeedLoader();
        AppMethodBeat.o(250241);
        return feedLoader;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.profile.b access$getFilterContract$p(FinderProfileFeedUIC finderProfileFeedUIC) {
        AppMethodBeat.i(250243);
        com.tencent.mm.plugin.finder.profile.b bVar = finderProfileFeedUIC.vaW;
        if (bVar == null) {
            kotlin.g.b.p.btv("filterContract");
        }
        AppMethodBeat.o(250243);
        return bVar;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(FinderProfileFeedUIC finderProfileFeedUIC) {
        AppMethodBeat.i(250244);
        RecyclerView recyclerView = finderProfileFeedUIC.getRecyclerView();
        AppMethodBeat.o(250244);
        return recyclerView;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout access$getRlLayout$p(FinderProfileFeedUIC finderProfileFeedUIC) {
        AppMethodBeat.i(250242);
        RefreshLoadMoreLayout rlLayout = finderProfileFeedUIC.getRlLayout();
        AppMethodBeat.o(250242);
        return rlLayout;
    }

    public static final /* synthetic */ void access$jumpProfileTimeline(FinderProfileFeedUIC finderProfileFeedUIC, int i2, BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(250246);
        finderProfileFeedUIC.jumpProfileTimeline(i2, baseFinderFeed);
        AppMethodBeat.o(250246);
    }

    public static final /* synthetic */ void access$jumpToLive(FinderProfileFeedUIC finderProfileFeedUIC, BaseFinderFeed baseFinderFeed, int i2) {
        AppMethodBeat.i(250245);
        finderProfileFeedUIC.jumpToLive(baseFinderFeed, i2);
        AppMethodBeat.o(250245);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getFILTER_VIEW_TYPE() {
        return this.vaX;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class e extends IListener<hk> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProfileFeedUIC finderProfileFeedUIC) {
            this.vbb = finderProfileFeedUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hk hkVar) {
            AppMethodBeat.i(250209);
            hk hkVar2 = hkVar;
            kotlin.g.b.p.h(hkVar2, "event");
            Log.i("Finder.ProfileFeedUIC", "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).updateProgressByLocalId(hkVar2.dLT.localId);
            AppMethodBeat.o(250209);
            return true;
        }
    }

    public final FinderProfileFeedLoader.State getState() {
        AppMethodBeat.i(250232);
        FinderProfileFeedLoader.State state = getFeedLoader().getState();
        AppMethodBeat.o(250232);
        return state;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ais;
    }

    @Override // com.tencent.mm.plugin.finder.profile.uic.FinderProfileFragmentUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        FrameLayout frameLayout;
        AppMethodBeat.i(250233);
        super.onCreate(bundle);
        this.vaY.alive();
        getFeedLoader().setReadFeedId(Long.valueOf(getIntent().getLongExtra("finder_read_feed_id", -1)));
        getFeedLoader().register(getActionCallback());
        Fragment fragment = getFragment();
        this.vaH = fragment != null ? (FrameLayout) fragment.getView().findViewById(R.id.gjf) : null;
        Fragment fragment2 = getFragment();
        if (fragment2 != null) {
            frameLayout = (FrameLayout) fragment2.getView().findViewById(R.id.f69);
        } else {
            frameLayout = null;
        }
        this.vaG = frameLayout;
        getRlLayout().setEnableRefresh(false);
        getRlLayout().setSuperNestedScroll(true);
        getRlLayout().setActionCallback(new i(this));
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        View inflate = aa.jQ(getActivity()).inflate(R.layout.b21, (ViewGroup) null);
        kotlin.g.b.p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        rlLayout.setLoadMoreFooter(inflate);
        ArrayList<bds> topicFilterList = getFeedLoader().getTopicFilterList();
        String username = getUsername();
        kotlin.g.b.p.g(username, ch.COL_USERNAME);
        this.vaW = new com.tencent.mm.plugin.finder.profile.b(getActivity(), topicFilterList, username);
        getRecyclerView().setLayoutManager(getLayoutConfig().eS(getActivity()));
        getRecyclerView().b(getLayoutConfig().getItemDecoration());
        RecyclerView recyclerView = getRecyclerView();
        com.tencent.mm.plugin.finder.profile.a layoutConfig = getLayoutConfig();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(250233);
            throw tVar;
        }
        recyclerView.setRecycledViewPool(layoutConfig.f((MMActivity) activity));
        RecyclerView recyclerView2 = getRecyclerView();
        j jVar = new j(this, getLayoutConfig().dcK(), getFeedLoader().getDataList());
        jVar.RqP = new h(jVar, this);
        com.tencent.mm.plugin.finder.profile.b bVar = this.vaW;
        if (bVar == null) {
            kotlin.g.b.p.btv("filterContract");
        }
        bVar.kgc.clear();
        ArrayList<bl> arrayList = bVar.kgc;
        ArrayList<bds> arrayList2 = bVar.uZp;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(new bl(it.next()));
        }
        arrayList.addAll(arrayList3);
        FinderTopicFilterView finderTopicFilterView = new FinderTopicFilterView(bVar.dKq);
        kotlin.g.b.p.h(bVar, "presenter");
        finderTopicFilterView.uZq = bVar;
        LayoutInflater.from(finderTopicFilterView.getContext()).inflate(R.layout.aj5, (ViewGroup) finderTopicFilterView, true);
        finderTopicFilterView.ufR = (WxRecyclerView) finderTopicFilterView.findViewById(R.id.cis);
        WxRecyclerView wxRecyclerView = finderTopicFilterView.ufR;
        if (wxRecyclerView != null) {
            wxRecyclerView.b(finderTopicFilterView.getItemDecoration());
        }
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        WxRecyclerView wxRecyclerView2 = finderTopicFilterView.ufR;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setLayoutManager(flowLayoutManager);
        }
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new FinderTopicFilterView.a(finderTopicFilterView), bVar.kgc, false);
        wxRecyclerAdapter.RqP = new FinderTopicFilterView.c(wxRecyclerAdapter, finderTopicFilterView, bVar);
        WxRecyclerView wxRecyclerView3 = finderTopicFilterView.ufR;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.setAdapter(wxRecyclerAdapter);
        }
        finderTopicFilterView.refresh();
        if (bVar.kgc.isEmpty()) {
            FinderTopicFilterView finderTopicFilterView2 = bVar.uZn;
            if (finderTopicFilterView2 != null) {
                finderTopicFilterView2.setVisibility(8);
            }
        } else {
            FinderTopicFilterView finderTopicFilterView3 = bVar.uZn;
            if (finderTopicFilterView3 != null) {
                finderTopicFilterView3.setVisibility(0);
            }
        }
        bVar.uZn = finderTopicFilterView;
        g.b unused = jVar.f(finderTopicFilterView, this.vaX, true);
        recyclerView2.setAdapter(jVar);
        com.tencent.mm.plugin.finder.profile.b bVar2 = this.vaW;
        if (bVar2 == null) {
            kotlin.g.b.p.btv("filterContract");
        }
        bVar2.uZo = new k(this);
        getFeedLoader().setOnFilterDataChanged(new l(this));
        FrameLayout frameLayout2 = this.vaH;
        if (frameLayout2 != null) {
            frameLayout2.setBackgroundResource(R.drawable.a3_);
        }
        getFeedLoader().setInitDone(new m(this));
        getFeedLoader().setFetchEndCallback(new n(this));
        getFeedLoader().setHandleStickyEvent(new o(this));
        BaseFeedLoader.requestInit$default(getFeedLoader(), false, 1, null);
        getFeedLoader().requestRefresh();
        getRecyclerView().a(this.vaZ);
        AppMethodBeat.o(250233);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
    public static final class i extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(250217);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250217);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderProfileFeedUIC finderProfileFeedUIC) {
            this.vbb = finderProfileFeedUIC;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(250214);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(250214);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(250215);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            RecyclerView recyclerView = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).getRecyclerView();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250215);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(250216);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).requestLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(250216);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class j extends WxRecyclerAdapter<bo> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileFeedUIC finderProfileFeedUIC, com.tencent.mm.view.recyclerview.f fVar, ArrayList arrayList) {
            super(fVar, arrayList);
            this.vbb = finderProfileFeedUIC;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(250219);
            n((com.tencent.mm.view.recyclerview.h) vVar);
            AppMethodBeat.o(250219);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(250218);
            kotlin.g.b.p.h(hVar, "holder");
            super.n(hVar);
            View view = hVar.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(hVar.lU() == this.vbb.getFILTER_VIEW_TYPE());
            }
            AppMethodBeat.o(250218);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"})
    public static final class h implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ FinderProfileFeedUIC vbb;
        final /* synthetic */ j vbe;

        h(j jVar, FinderProfileFeedUIC finderProfileFeedUIC) {
            this.vbe = jVar;
            this.vbb = finderProfileFeedUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(250213);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            kotlin.g.b.p.h(aVar, "adapter");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(hVar2, "holder");
            FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).clearMarkRead();
            bo boVar = (bo) hVar2.hgv();
            if (boVar instanceof BaseFinderFeed) {
                int size = i2 - this.vbe.RqM.size();
                Log.i("Finder.ProfileFeedUIC", "onItemClick position:".concat(String.valueOf(size)));
                y yVar = y.vXH;
                if (y.w((BaseFinderFeed) boVar)) {
                    FinderProfileFeedUIC.access$jumpToLive(this.vbb, (BaseFinderFeed) boVar, size);
                    AppMethodBeat.o(250213);
                    return;
                }
                FinderProfileFeedUIC.access$jumpProfileTimeline(this.vbb, size, (BaseFinderFeed) boVar);
            }
            AppMethodBeat.o(250213);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$6", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class m implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(FinderProfileFeedUIC finderProfileFeedUIC) {
            this.vbb = finderProfileFeedUIC;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(250222);
            FinderProfileFeedUIC.access$getActionCallback$p(this.vbb).dmp();
            AppMethodBeat.o(250222);
        }
    }

    private final void jumpProfileTimeline(int i2, BaseFinderFeed baseFinderFeed) {
        String str;
        FragmentActivity activity;
        AppMethodBeat.i(250234);
        Intent intent = new Intent();
        BaseFeedLoader.saveCache$default(getFeedLoader(), intent, i2, null, 4, null);
        intent.putExtra("KEY_FROM_TOPIC_ID", getFeedLoader().getCurTopicId());
        intent.putExtra("finder_username", getUsername());
        intent.putExtra("KEY_FINDER_SELF_FLAG", isSelfFlag());
        Fragment fragment = getFragment();
        if (fragment == null || (activity = fragment.getActivity()) == null) {
            str = null;
        } else {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            kotlin.g.b.p.g(activity, LocaleUtil.ITALIAN);
            str = ((FinderReporterUIC) com.tencent.mm.ui.component.a.ko(activity).get(FinderReporterUIC.class)).sGE;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
            intent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.report.d.dlA());
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(getActivity(), intent, 0, 0, false, 124);
        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.y(getActivity(), intent);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.J(baseFinderFeed.lT(), 1);
        AppMethodBeat.o(250234);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250236);
        super.onDestroy();
        getFeedLoader().unregister(getActionCallback());
        this.vaY.dead();
        getRecyclerView().b(this.vaZ);
        AppMethodBeat.o(250236);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "updateState", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.view.b {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderProfileFeedUIC finderProfileFeedUIC, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(refreshLoadMoreLayout);
            kotlin.g.b.p.h(refreshLoadMoreLayout, "rlLayout");
            this.vbb = finderProfileFeedUIC;
            AppMethodBeat.i(250206);
            AppMethodBeat.o(250206);
        }

        @Override // com.tencent.mm.view.b
        public final void dmp() {
            AppMethodBeat.i(250204);
            com.tencent.mm.ac.d.a(0, new a(this));
            AppMethodBeat.o(250204);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b vbc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.vbc = bVar;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$4$1"})
            /* renamed from: com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC$b$a$a  reason: collision with other inner class name */
            static final class View$OnClickListenerC1263a implements View.OnClickListener {
                final /* synthetic */ a vbd;

                View$OnClickListenerC1263a(a aVar) {
                    this.vbd = aVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(250202);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RefreshLoadMoreLayout.d(FinderProfileFeedUIC.access$getRlLayout$p(this.vbd.vbc.vbb));
                    this.vbd.vbc.dmp();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(250202);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                FinderTopicFilterView finderTopicFilterView;
                int i2;
                AppMethodBeat.i(250203);
                Log.i("Finder.ProfileFeedUIC", "[updateState] state=" + FinderProfileFeedUIC.access$getFeedLoader$p(this.vbc.vbb).getState() + " cachedState=" + FinderProfileFeedUIC.access$getFeedLoader$p(this.vbc.vbb).getCachedState());
                FrameLayout frameLayout = this.vbc.vbb.vaH;
                if (frameLayout != null) {
                    frameLayout.setOnClickListener(null);
                    frameLayout.setVisibility(8);
                }
                FinderProfileFeedUIC.access$getRlLayout$p(this.vbc.vbb).setBackgroundResource(R.color.f3043a);
                FrameLayout frameLayout2 = this.vbc.vbb.vaG;
                if (frameLayout2 != null) {
                    frameLayout2.setBackgroundResource(R.color.f3043a);
                }
                if (FinderProfileFeedUIC.access$getFeedLoader$p(this.vbc.vbb).getCachedState() == FinderProfileFeedLoader.CacheState.NO_CACHE) {
                    FinderProfileFeedUIC.access$getRlLayout$p(this.vbc.vbb).setSuperNestedScroll(false);
                    switch (b.$EnumSwitchMapping$0[FinderProfileFeedUIC.access$getFeedLoader$p(this.vbc.vbb).getState().ordinal()]) {
                        case 1:
                            FrameLayout frameLayout3 = this.vbc.vbb.vaH;
                            if (frameLayout3 != null) {
                                frameLayout3.setVisibility(0);
                                TextView textView = (TextView) frameLayout3.findViewById(R.id.ipb);
                                kotlin.g.b.p.g(textView, "it.tips_no_content");
                                textView.setVisibility(8);
                                LinearLayout linearLayout = (LinearLayout) frameLayout3.findViewById(R.id.d91);
                                kotlin.g.b.p.g(linearLayout, "it.forbidden_tips");
                                linearLayout.setVisibility(8);
                                TextView textView2 = (TextView) frameLayout3.findViewById(R.id.ipc);
                                kotlin.g.b.p.g(textView2, "it.tips_retry");
                                textView2.setVisibility(8);
                                ProgressBar progressBar = (ProgressBar) frameLayout3.findViewById(R.id.ip_);
                                kotlin.g.b.p.g(progressBar, "it.tips_loading");
                                progressBar.setVisibility(0);
                                break;
                            }
                            break;
                        case 2:
                            FrameLayout frameLayout4 = this.vbc.vbb.vaH;
                            if (frameLayout4 != null) {
                                frameLayout4.setVisibility(0);
                                TextView textView3 = (TextView) frameLayout4.findViewById(R.id.ipb);
                                kotlin.g.b.p.g(textView3, "it.tips_no_content");
                                textView3.setVisibility(0);
                                LinearLayout linearLayout2 = (LinearLayout) frameLayout4.findViewById(R.id.d91);
                                kotlin.g.b.p.g(linearLayout2, "it.forbidden_tips");
                                linearLayout2.setVisibility(8);
                                TextView textView4 = (TextView) frameLayout4.findViewById(R.id.ipc);
                                kotlin.g.b.p.g(textView4, "it.tips_retry");
                                textView4.setVisibility(8);
                                ProgressBar progressBar2 = (ProgressBar) frameLayout4.findViewById(R.id.ip_);
                                kotlin.g.b.p.g(progressBar2, "it.tips_loading");
                                progressBar2.setVisibility(8);
                                break;
                            }
                            break;
                        case 3:
                            FrameLayout frameLayout5 = this.vbc.vbb.vaH;
                            if (frameLayout5 != null) {
                                frameLayout5.setVisibility(0);
                                TextView textView5 = (TextView) frameLayout5.findViewById(R.id.ipb);
                                kotlin.g.b.p.g(textView5, "it.tips_no_content");
                                textView5.setVisibility(8);
                                LinearLayout linearLayout3 = (LinearLayout) frameLayout5.findViewById(R.id.d91);
                                kotlin.g.b.p.g(linearLayout3, "it.forbidden_tips");
                                linearLayout3.setVisibility(8);
                                TextView textView6 = (TextView) frameLayout5.findViewById(R.id.ipc);
                                kotlin.g.b.p.g(textView6, "it.tips_retry");
                                textView6.setVisibility(0);
                                ProgressBar progressBar3 = (ProgressBar) frameLayout5.findViewById(R.id.ip_);
                                kotlin.g.b.p.g(progressBar3, "it.tips_loading");
                                progressBar3.setVisibility(8);
                                frameLayout5.setOnClickListener(new View$OnClickListenerC1263a(this));
                                break;
                            }
                            break;
                    }
                    FinderProfileFeedUIC.access$getRlLayout$p(this.vbc.vbb).setBackgroundResource(R.color.f3045c);
                    FrameLayout frameLayout6 = this.vbc.vbb.vaG;
                    if (frameLayout6 != null) {
                        frameLayout6.setBackgroundResource(R.color.f3045c);
                    }
                } else {
                    FinderProfileFeedUIC.access$getRlLayout$p(this.vbc.vbb).setSuperNestedScroll(true);
                }
                switch (b.haE[FinderProfileFeedUIC.access$getFeedLoader$p(this.vbc.vbb).getState().ordinal()]) {
                    case 1:
                        FrameLayout frameLayout7 = this.vbc.vbb.vaH;
                        if (frameLayout7 != null) {
                            frameLayout7.setVisibility(0);
                            TextView textView7 = (TextView) frameLayout7.findViewById(R.id.ipb);
                            kotlin.g.b.p.g(textView7, "it.tips_no_content");
                            textView7.setVisibility(8);
                            LinearLayout linearLayout4 = (LinearLayout) frameLayout7.findViewById(R.id.d91);
                            kotlin.g.b.p.g(linearLayout4, "it.forbidden_tips");
                            linearLayout4.setVisibility(0);
                            TextView textView8 = (TextView) frameLayout7.findViewById(R.id.ipc);
                            kotlin.g.b.p.g(textView8, "it.tips_retry");
                            textView8.setVisibility(8);
                            ProgressBar progressBar4 = (ProgressBar) frameLayout7.findViewById(R.id.ip_);
                            kotlin.g.b.p.g(progressBar4, "it.tips_loading");
                            progressBar4.setVisibility(8);
                        }
                        FinderProfileFeedUIC.access$getRlLayout$p(this.vbc.vbb).setBackgroundResource(R.color.f3045c);
                        FrameLayout frameLayout8 = this.vbc.vbb.vaG;
                        if (frameLayout8 != null) {
                            frameLayout8.setBackgroundResource(R.color.f3045c);
                            break;
                        }
                        break;
                }
                FrameLayout frameLayout9 = this.vbc.vbb.vaH;
                if (frameLayout9 != null && frameLayout9.getVisibility() == 0 && (finderTopicFilterView = FinderProfileFeedUIC.access$getFilterContract$p(this.vbc.vbb).uZn) != null && finderTopicFilterView.getVisibility() == 0) {
                    FrameLayout frameLayout10 = this.vbc.vbb.vaH;
                    ViewGroup.LayoutParams layoutParams = frameLayout10 != null ? frameLayout10.getLayoutParams() : null;
                    if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (layoutParams2 != null) {
                        FinderTopicFilterView finderTopicFilterView2 = FinderProfileFeedUIC.access$getFilterContract$p(this.vbc.vbb).uZn;
                        if (finderTopicFilterView2 != null) {
                            i2 = finderTopicFilterView2.getHeight();
                        } else {
                            i2 = 0;
                        }
                        layoutParams2.topMargin = i2;
                        FrameLayout frameLayout11 = this.vbc.vbb.vaH;
                        if (frameLayout11 != null) {
                            frameLayout11.setLayoutParams(layoutParams2);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(250203);
                return xVar;
            }
        }

        @Override // com.tencent.mm.view.b
        public final int getHeaderCount() {
            AppMethodBeat.i(250205);
            RecyclerView.a adapter = FinderProfileFeedUIC.access$getRecyclerView$p(this.vbb).getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                int size = wxRecyclerAdapter.RqM.size();
                AppMethodBeat.o(250205);
                return size;
            }
            AppMethodBeat.o(250205);
            return 0;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(250237);
        super.onResume();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(getRlLayout().getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_PROFILE_PAGE.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(250237);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(250238);
        super.onPause();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(getRlLayout().getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_PROFILE_PAGE.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(250238);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class g extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(250212);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(250212);
        }

        g() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(250211);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_PROFILE_PAGE.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(250211);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<FinderProfileFeedLoader> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(0);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderProfileFeedLoader invoke() {
            AppMethodBeat.i(250208);
            com.tencent.mm.plugin.finder.feed.model.internal.e eVar = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_PROFILE;
            String username = this.vbb.getUsername();
            kotlin.g.b.p.g(username, ch.COL_USERNAME);
            FinderProfileFeedLoader finderProfileFeedLoader = new FinderProfileFeedLoader(eVar, username, this.vbb.getContextObj());
            AppMethodBeat.o(250208);
            return finderProfileFeedLoader;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(0);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.profile.a invoke() {
            AppMethodBeat.i(250210);
            com.tencent.mm.plugin.finder.profile.a aVar = new com.tencent.mm.plugin.finder.profile.a(this.vbb.getActivity(), this.vbb.isSelfFlag());
            AppMethodBeat.o(250210);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(250226);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.uRC.getView().findViewById(R.id.h7t);
            AppMethodBeat.o(250226);
            return refreshLoadMoreLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(0);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(250225);
            RecyclerView recyclerView = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).getRecyclerView();
            AppMethodBeat.o(250225);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<b> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(0);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(250207);
            FinderProfileFeedUIC finderProfileFeedUIC = this.vbb;
            RefreshLoadMoreLayout access$getRlLayout$p = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb);
            kotlin.g.b.p.g(access$getRlLayout$p, "rlLayout");
            b bVar = new b(finderProfileFeedUIC, access$getRlLayout$p);
            AppMethodBeat.o(250207);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileFeedUIC vbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderProfileFeedUIC finderProfileFeedUIC) {
            super(0);
            this.vbb = finderProfileFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250221);
            com.tencent.mm.plugin.finder.profile.b access$getFilterContract$p = FinderProfileFeedUIC.access$getFilterContract$p(this.vbb);
            boolean isEmpty = access$getFilterContract$p.kgc.isEmpty();
            access$getFilterContract$p.kgc.clear();
            ArrayList<bl> arrayList = access$getFilterContract$p.kgc;
            ArrayList<bds> arrayList2 = access$getFilterContract$p.uZp;
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new bl(it.next()));
            }
            arrayList.addAll(arrayList3);
            if (access$getFilterContract$p.kgc.isEmpty()) {
                FinderTopicFilterView finderTopicFilterView = access$getFilterContract$p.uZn;
                if (finderTopicFilterView != null) {
                    finderTopicFilterView.setVisibility(8);
                }
            } else {
                FinderTopicFilterView finderTopicFilterView2 = access$getFilterContract$p.uZn;
                if (finderTopicFilterView2 != null) {
                    finderTopicFilterView2.setVisibility(0);
                }
            }
            FinderTopicFilterView finderTopicFilterView3 = access$getFilterContract$p.uZn;
            if (finderTopicFilterView3 != null) {
                finderTopicFilterView3.refresh();
            }
            Log.i(access$getFilterContract$p.TAG, "refresh, dataList size:" + access$getFilterContract$p.kgc.size());
            if (isEmpty && !access$getFilterContract$p.kgc.isEmpty()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21570, access$getFilterContract$p.username + ",1,");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250221);
            return xVar;
        }
    }

    private final void jumpToLive(BaseFinderFeed baseFinderFeed, int i2) {
        long j2;
        AppMethodBeat.i(250235);
        if (Util.isEqual(baseFinderFeed.feedObject.getFeedObject().username, z.aUg())) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            AppCompatActivity activity = getActivity();
            long j3 = baseFinderFeed.feedObject.getFeedObject().id;
            String str = baseFinderFeed.feedObject.getFeedObject().objectNonceId;
            if (str == null) {
                str = "";
            }
            awe awe = baseFinderFeed.feedObject.getFeedObject().liveInfo;
            if (awe == null) {
                awe = new awe();
            }
            com.tencent.mm.plugin.finder.utils.a.a(activity, j3, str, awe, false, null, null, null, null, null, baseFinderFeed.getSessionBuffer(), null, null, 14320);
            AppMethodBeat.o(250235);
            return;
        }
        com.tencent.mm.plugin.finder.report.live.k.vkd.a(baseFinderFeed, (long) i2, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, s.j.COMMENT_SCENE_PROFILE_PAGE.scene);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        AppCompatActivity activity2 = getActivity();
        long j4 = baseFinderFeed.feedObject.getFeedObject().id;
        awe awe2 = baseFinderFeed.feedObject.getFeedObject().liveInfo;
        if (awe2 != null) {
            j2 = awe2.liveId;
        } else {
            j2 = 0;
        }
        String str2 = baseFinderFeed.feedObject.getFeedObject().username;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = baseFinderFeed.feedObject.getFeedObject().objectNonceId;
        if (str3 == null) {
            str3 = "";
        }
        awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
        com.tencent.mm.plugin.finder.utils.a.a(aVar2, activity2, j4, j2, str2, str3, "", "", liveInfo != null ? liveInfo.LGU : 0, baseFinderFeed.getSessionBuffer());
        AppMethodBeat.o(250235);
    }
}
