package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract;", "", "()V", "CloseDrawerCallback", "NPresenter", "plugin-finder_release"})
public final class CommentDrawerContract {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
    public interface CloseDrawerCallback {
        void g(int i2, List<? extends s> list);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\u0004H&J\b\u0010\u0019\u001a\u00020\u0004H&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&Jl\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H&J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H&J\u0010\u00101\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0006H&J\u0018\u00102\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H&J\u0018\u00103\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00104\u001a\u00020\rH&J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H&J\u0018\u00106\u001a\u00020\u001b2\u0006\u0010.\u001a\u0002072\u0006\u00104\u001a\u00020\rH&J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\rH&¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "canExpand", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "useCache", "blinkRefComment", "commentClose", "oldVer", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"})
    public interface NPresenter extends a<b> {
        s EC(long j2);

        void IG(int i2);

        void a(View view, s sVar);

        void a(ImageView imageView, int i2);

        void a(s sVar, boolean z);

        void a(FinderCommentDrawer finderCommentDrawer, b bVar, FinderItem finderItem, CloseDrawerCallback closeDrawerCallback, int i2, boolean z, long j2, an anVar, boolean z2, boolean z3, boolean z4, boolean z5);

        void af(View view, int i2);

        boolean b(s sVar, boolean z);

        int dcA();

        FinderItem dcB();

        int dcE();

        int dcF();

        RecyclerView.h fi(Context context);

        WxRecyclerAdapter<?> fm(Context context);

        int getCommentScene();

        boolean isCommentClose();
    }
}
