package com.tencent.mm.plugin.finder.activity.uic;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\f\u0011\u0018\u0000 42\u00020\u0001:\u0003456B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020\u001eH\u0002J\u0006\u0010'\u001a\u00020\u001eJ\b\u0010(\u001a\u00020\u001eH\u0016J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020*H\u0002J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u00020*H\u0016J\b\u00103\u001a\u00020*H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "emptyView", "Landroid/widget/FrameLayout;", "encryptedEventTopicId", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "feedStickyListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1;", "finderEventTopicId", "", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "retryView", "Landroid/widget/TextView;", "tabType", "", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "convertInnerTabType", "getCommentScene", "getLayoutId", "handleStickyEvent", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "initLoader", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "FinderHottestFeedLoader", "FinderNewestLoader", "plugin-finder_release"})
public final class FinderActivityContentUIC extends UIComponent {
    public static final d UGX = new d((byte) 0);
    private int dLS;
    private String dST = "生活大爆炸";
    private ProgressBar progressBar;
    public av.a tqH;
    private av.b tqI;
    private FinderTopicFeedLoader tqJ;
    private long tqK;
    private String tqL;
    private TextView tqM;
    private final b tqN = new b(this);
    private final a tqO = new a(this);
    private FrameLayout tqq;

    static {
        AppMethodBeat.i(260090);
        AppMethodBeat.o(260090);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityContentUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(260089);
        AppMethodBeat.o(260089);
    }

    public static final /* synthetic */ av.b c(FinderActivityContentUIC finderActivityContentUIC) {
        AppMethodBeat.i(242051);
        av.b bVar = finderActivityContentUIC.tqI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(242051);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$Companion;", "", "()V", "HOTTEST", "", "LATEST", "plugin-finder_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0138  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 628
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC.onCreate(android.os.Bundle):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderActivityContentUIC tqP;

        c(FinderActivityContentUIC finderActivityContentUIC) {
            this.tqP = finderActivityContentUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242047);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("SimpleUIComponent", "progressBar FinderActivityContentUIC visible");
            FrameLayout frameLayout = this.tqP.tqq;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ProgressBar progressBar = this.tqP.progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            FinderActivityContentUIC.c(this.tqP).dbY();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242047);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.cep;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(260087);
        super.onResume();
        Log.i("SimpleUIComponent", "onResume");
        FinderTopicFeedLoader finderTopicFeedLoader = this.tqJ;
        if (finderTopicFeedLoader == null) {
            p.btv("feedLoader");
        }
        finderTopicFeedLoader.UIB = -1;
        AppMethodBeat.o(260087);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(260088);
        super.onPause();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int dIM = ((FinderActivityTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityTabUIC.class)).dIM();
        if (this.dLS - 1 == dIM) {
            FinderTopicFeedLoader finderTopicFeedLoader = this.tqJ;
            if (finderTopicFeedLoader == null) {
                p.btv("feedLoader");
            }
            finderTopicFeedLoader.UIB = this.dLS;
        }
        Log.i("SimpleUIComponent", "onPause activeIndex :".concat(String.valueOf(dIM)));
        AppMethodBeat.o(260088);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242049);
        av.a aVar = this.tqH;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        super.onDestroy();
        this.tqN.dead();
        this.tqO.dead();
        AppMethodBeat.o(242049);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<ih> {
        final /* synthetic */ FinderActivityContentUIC tqP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderActivityContentUIC finderActivityContentUIC) {
            this.tqP = finderActivityContentUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            TextView textView;
            ih.a aVar;
            AppMethodBeat.i(242046);
            ih ihVar2 = ihVar;
            int i2 = (ihVar2 == null || (aVar = ihVar2.dMT) == null) ? -1 : aVar.responseCode;
            Log.i("SimpleUIComponent", "FinderTopicEvent : ".concat(String.valueOf(i2)));
            if (!(i2 == 0 || i2 == -4056 || i2 == -4058 || i2 == -4063 || (textView = this.tqP.tqM) == null)) {
                textView.setVisibility(0);
            }
            AppMethodBeat.o(242046);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hm> {
        final /* synthetic */ FinderActivityContentUIC tqP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderActivityContentUIC finderActivityContentUIC) {
            this.tqP = finderActivityContentUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hm hmVar) {
            AppMethodBeat.i(242045);
            hm hmVar2 = hmVar;
            if (hmVar2 == null || hmVar2.dLV.type != 1001) {
                AppMethodBeat.o(242045);
            } else {
                FinderActivityContentUIC.a(this.tqP, hmVar2);
                AppMethodBeat.o(242045);
            }
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderNewestLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTopicType", "()I", "onPostStart", "", ch.COL_LOCALID, "", "plugin-finder_release"})
    public final class FinderNewestLoader extends FinderTopicFeedLoader {
        private final String UGY;
        final /* synthetic */ FinderActivityContentUIC tqP;
        private final int tvC = 7;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderNewestLoader(FinderActivityContentUIC finderActivityContentUIC, int i2, bbn bbn) {
            super(7, i2, bbn);
            p.h(i2, "topicContent");
            this.tqP = finderActivityContentUIC;
            AppMethodBeat.i(260086);
            this.UGY = i2;
            AppMethodBeat.o(260086);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q, com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
        public final void onPostStart(long j2) {
            AppMethodBeat.i(260085);
            super.onPostStart(j2);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderTabUIC.a((FinderActivityTabUIC) com.tencent.mm.ui.component.a.b(this.tqP.getActivity()).get(FinderActivityTabUIC.class), 1);
            AppMethodBeat.o(260085);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderHottestFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTopicType", "()I", "interceptPostStart", "", "plugin-finder_release"})
    public final class FinderHottestFeedLoader extends FinderTopicFeedLoader {
        private final String UGY;
        final /* synthetic */ FinderActivityContentUIC tqP;
        private final int tvC = 7;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderHottestFeedLoader(FinderActivityContentUIC finderActivityContentUIC, int i2, bbn bbn) {
            super(7, i2, bbn);
            p.h(i2, "topicContent");
            this.tqP = finderActivityContentUIC;
            AppMethodBeat.i(260084);
            this.UGY = i2;
            AppMethodBeat.o(260084);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
        public final boolean interceptPostStart() {
            return true;
        }
    }

    public static final /* synthetic */ void a(FinderActivityContentUIC finderActivityContentUIC, hm hmVar) {
        AppMethodBeat.i(242052);
        if (hmVar != null) {
            if (hmVar.dLV.type == 1001 && finderActivityContentUIC.dLS == 1) {
                av.a aVar = finderActivityContentUIC.tqH;
                if (aVar == null) {
                    p.btv("presenter");
                }
                aVar.requestRefresh();
            }
            AppMethodBeat.o(242052);
            return;
        }
        AppMethodBeat.o(242052);
    }
}
