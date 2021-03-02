package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract;", "", "Presenter", "ViewCallback", "plugin-finder_release"})
public interface h {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0002H&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u0004H&J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H&J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\nH&J$\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J(\u0010.\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u000202H&J\b\u00103\u001a\u00020\u0004H&J\b\u00104\u001a\u00020\u0004H&J\b\u00105\u001a\u00020\u0004H&J\b\u00106\u001a\u00020\u0004H&J\b\u00107\u001a\u00020\u0004H&J\b\u00108\u001a\u00020\u0004H&J\u0012\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u000202H&J\b\u0010;\u001a\u00020\u0004H&J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0014H&J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0014H&J$\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0?2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH&¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "bindMultiTaskInfo", "", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "info", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "isMultiTask", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getViewCallback", "loadInitData", "loadMoreData", "onAttach", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "likeAction", "", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isUpdate", "isFromMultiTask", "plugin-finder_release"})
    public interface a extends com.tencent.mm.plugin.finder.presenter.base.a<b> {
        void a(BaseMegaVideoLoader baseMegaVideoLoader, b bVar);

        void a(com.tencent.mm.plugin.finder.megavideo.multitask.a aVar, cnu cnu, boolean z);

        f dce();

        void dcp();

        b dko();

        void dkp();

        void nI(boolean z);

        boolean nJ(boolean z);

        void requestRefresh();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRootView", "Landroid/view/View;", "getViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public interface b extends c<a> {
        void ab(ArrayList<bo> arrayList);

        RecyclerView getRecyclerView();

        View getRootView();
    }
}
