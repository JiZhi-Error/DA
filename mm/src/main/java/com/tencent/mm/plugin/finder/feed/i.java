package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0014H&J \u0010\u001d\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H&J0\u0010!\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014H&J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0017H&J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH&¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "", "preIsPrivate", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public interface i {
    o.f a(BaseFinderFeed baseFinderFeed, e eVar);

    void a(BaseFinderFeed baseFinderFeed, boolean z, boolean z2, int i2, boolean z3);

    void a(FinderItem finderItem);

    void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo);

    void a(FinderItem finderItem, boolean z, h hVar);

    void b(BaseFinderFeed baseFinderFeed, boolean z);

    boolean dbZ();

    RecyclerView.m dcf();

    com.tencent.mm.plugin.finder.view.e dcg();

    MMActivity getActivity();

    k getVideoCore();

    o.f i(BaseFinderFeed baseFinderFeed);

    o.g j(BaseFinderFeed baseFinderFeed);

    void k(BaseFinderFeed baseFinderFeed);
}
