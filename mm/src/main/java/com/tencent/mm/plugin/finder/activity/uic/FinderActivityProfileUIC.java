package com.tencent.mm.plugin.finder.activity.uic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "finderEventTopicId", "", "isStickyChanged", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "topic", "", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderActivityProfileUIC extends UIComponent {
    private String dST = "生活大爆炸";
    private av.a tqH;
    private av.b tqI;
    private FinderTopicFeedLoader tqJ;
    private long tqK;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityProfileUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(242114);
        AppMethodBeat.o(242114);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242113);
        super.onCreate(bundle);
        this.tqK = getIntent().getLongExtra("key_activity_id", 0);
        a aVar = a.PRN;
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242113);
            throw tVar;
        }
        FinderTopicFeedLoader finderTopicFeedLoader = new FinderTopicFeedLoader(7, this.dST, ((FinderReporterUIC) a.b((MMActivity) activity).get(FinderReporterUIC.class)).dIx());
        finderTopicFeedLoader.initFromCache(getIntent());
        finderTopicFeedLoader.tTG = finderTopicFeedLoader.tTG;
        finderTopicFeedLoader.twd = this.tqK;
        finderTopicFeedLoader.tXN = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0));
        this.tqJ = finderTopicFeedLoader;
        Fragment fragment2 = getFragment();
        if (fragment2 == null) {
            p.hyc();
        }
        FragmentActivity activity2 = fragment2.getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242113);
            throw tVar2;
        }
        MMActivity mMActivity = (MMActivity) activity2;
        FinderTopicFeedLoader finderTopicFeedLoader2 = this.tqJ;
        if (finderTopicFeedLoader2 == null) {
            p.btv("feedLoader");
        }
        av.a aVar2 = new av.a(mMActivity, finderTopicFeedLoader2);
        aVar2.atn(aVar2.dST);
        aVar2.type = 7;
        this.tqH = aVar2;
        Fragment fragment3 = getFragment();
        if (fragment3 == null) {
            p.hyc();
        }
        FragmentActivity activity3 = fragment3.getActivity();
        if (activity3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242113);
            throw tVar3;
        }
        av.b bVar = new av.b((MMActivity) activity3, 26, (byte) 0);
        bVar.atn(bVar.dST);
        bVar.type = 7;
        Fragment fragment4 = getFragment();
        if (fragment4 == null) {
            p.hyc();
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) fragment4.getView().findViewById(R.id.h7t);
        p.g(refreshLoadMoreLayout, "fragment!!.rl_layout");
        bVar.setRlLayout(refreshLoadMoreLayout);
        this.tqI = bVar;
        av.b bVar2 = this.tqI;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        av.a aVar3 = this.tqH;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        bVar2.a(aVar3);
        av.a aVar4 = this.tqH;
        if (aVar4 == null) {
            p.btv("presenter");
        }
        av.b bVar3 = this.tqI;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        aVar4.a(bVar3);
        AppMethodBeat.o(242113);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.akp;
    }
}
