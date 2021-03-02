package com.tencent.mm.plugin.finder.feed.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u00020\u0015H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"})
public final class FinderSnsGridFeedUI extends FinderBaseGridFeedUI<af.b, af.a> {
    private HashMap _$_findViewCache;
    private BaseFinderFeedLoader tFM;
    private af.a ucU;
    private af.b ucV;
    public boolean ucW;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245549);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245549);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245548);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245548);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$2$1"})
    static final class a extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderProfileFeedLoader ucX;
        final /* synthetic */ FinderSnsGridFeedUI ucY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderProfileFeedLoader finderProfileFeedLoader, FinderSnsGridFeedUI finderSnsGridFeedUI) {
            super(1);
            this.ucX = finderProfileFeedLoader;
            this.ucY = finderSnsGridFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            AppMethodBeat.i(245538);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (!((FinderProfileFeedLoader.ProfileResponse) iResponse2).getHasMore() && this.ucX.getDataListJustForAdapter().size() != 0) {
                View loadMoreFooter = FinderSnsGridFeedUI.a(this.ucY).tLS.getLoadMoreFooter();
                if (loadMoreFooter != null) {
                    loadMoreFooter.setVisibility(0);
                }
                View loadMoreFooter2 = FinderSnsGridFeedUI.a(this.ucY).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter3 = FinderSnsGridFeedUI.a(this.ucY).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (findViewById = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                    int argb = Color.argb(13, 255, 255, 255);
                    View findViewById2 = findViewById.findViewById(R.id.aq8);
                    p.g(findViewById2, "findViewById<View>(R.id.center_icon)");
                    findViewById2.setBackground(this.ucY.getDrawable(R.drawable.z2));
                    findViewById.findViewById(R.id.ea_).setBackgroundColor(argb);
                    findViewById.findViewById(R.id.h76).setBackgroundColor(argb);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245538);
            return xVar;
        }
    }

    public static final /* synthetic */ af.b a(FinderSnsGridFeedUI finderSnsGridFeedUI) {
        AppMethodBeat.i(245547);
        af.b bVar = finderSnsGridFeedUI.ucV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245547);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ak5;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245541);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.w));
        hideTitleView();
        findViewById(R.id.c9).setOnClickListener(new c(this));
        e eVar = e.FEED_PROFILE;
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderProfileFeedLoader finderProfileFeedLoader = new FinderProfileFeedLoader(eVar, aUg, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        finderProfileFeedLoader.setNeedToFilterLiveData(true);
        finderProfileFeedLoader.setFetchEndCallback(new a(finderProfileFeedLoader, this));
        this.tFM = finderProfileFeedLoader;
        FinderSnsGridFeedUI finderSnsGridFeedUI = this;
        BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
        if (baseFinderFeedLoader == null) {
            p.btv("feedLoader");
        }
        this.ucU = new af.a(finderSnsGridFeedUI, baseFinderFeedLoader);
        this.ucV = new af.b(this);
        af.b bVar = this.ucV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        af.a aVar2 = this.ucU;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        if (Util.isNullOrNil(z.aUg())) {
            af.b bVar2 = this.ucV;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            View emptyView = bVar2.getEmptyView();
            if (emptyView != null) {
                View findViewById = emptyView.findViewById(R.id.c2x);
                p.g(findViewById, "findViewById<View>(R.id.empty_layout)");
                findViewById.setVisibility(0);
                View findViewById2 = emptyView.findViewById(R.id.c3_);
                p.g(findViewById2, "findViewById<TextView>(R.id.empty_tips1)");
                ((TextView) findViewById2).setText(emptyView.getContext().getString(R.string.d_9));
                View findViewById3 = emptyView.findViewById(R.id.c3a);
                p.g(findViewById3, "findViewById<TextView>(R.id.empty_tips2)");
                ((TextView) findViewById3).setText(emptyView.getContext().getString(R.string.d__));
                emptyView.findViewById(R.id.c2m).setOnClickListener(new b(this));
                View findViewById4 = findViewById(R.id.cb);
                p.g(findViewById4, "this@FinderSnsGridFeedUI….action_bar_middle_title)");
                findViewById4.setVisibility(8);
                AppMethodBeat.o(245541);
                return;
            }
        }
        AppMethodBeat.o(245541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderSnsGridFeedUI ucY;

        c(FinderSnsGridFeedUI finderSnsGridFeedUI) {
            this.ucY = finderSnsGridFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245540);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ucY.nd(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245540);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$3$1"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderSnsGridFeedUI ucY;

        b(FinderSnsGridFeedUI finderSnsGridFeedUI) {
            this.ucY = finderSnsGridFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245539);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ucY.nd(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245539);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245542);
        super.onResume();
        if (this.ucW) {
            finish();
        }
        AppMethodBeat.o(245542);
    }

    public final void nd(boolean z) {
        AppMethodBeat.i(245545);
        boolean isNullOrNil = Util.isNullOrNil(z.aUg());
        int i2 = isNullOrNil ? R.string.d__ : R.string.d_b;
        if (z) {
            int i3 = isNullOrNil ? 5 : 7;
            com.tencent.mm.plugin.finder.report.q qVar = com.tencent.mm.plugin.finder.report.q.vgE;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            String str = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).sessionId;
            if (str == null) {
                str = "";
            }
            String string = getContext().getString(i2);
            p.g(string, "context.getString(strId)");
            com.tencent.mm.plugin.finder.report.q.a(str, i3, string, isNullOrNil, false, 0, 32);
        } else {
            af.b bVar = this.ucV;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            View emptyView = bVar.getEmptyView();
            if (emptyView == null || emptyView.getVisibility() != 0) {
                com.tencent.mm.plugin.finder.report.q qVar2 = com.tencent.mm.plugin.finder.report.q.vgE;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                String str2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).sessionId;
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.report.q.a(str2, 4, null, false, false, 0, 60);
            } else {
                int i4 = isNullOrNil ? 6 : 8;
                com.tencent.mm.plugin.finder.report.q qVar3 = com.tencent.mm.plugin.finder.report.q.vgE;
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                String str3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).sessionId;
                if (str3 == null) {
                    str3 = "";
                }
                String string2 = getContext().getString(i2);
                p.g(string2, "context.getString(strId)");
                com.tencent.mm.plugin.finder.report.q.a(str3, i4, string2, isNullOrNil, false, 0, 32);
            }
        }
        finish();
        AppMethodBeat.o(245545);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(245546);
        nd(false);
        AppMethodBeat.o(245546);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ af.a dcq() {
        AppMethodBeat.i(245543);
        af.a aVar = this.ucU;
        if (aVar == null) {
            p.btv("presenter");
        }
        af.a aVar2 = aVar;
        AppMethodBeat.o(245543);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ af.b ddS() {
        AppMethodBeat.i(245544);
        af.b bVar = this.ucV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        af.b bVar2 = bVar;
        AppMethodBeat.o(245544);
        return bVar2;
    }
}
