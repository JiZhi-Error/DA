package com.tencent.mm.plugin.finder.feed.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.o;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI extends FinderBaseGridFeedUI<o.b, o.a> {
    private final String TAG = "Finder.FinderFriendLikeFeedUI";
    private HashMap _$_findViewCache;
    public BaseFinderFeedLoader tFM;
    public String tvp;
    private o.a uaB;
    private o.b uaC;
    public String uaD;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245237);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245237);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245236);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245236);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$initOnCreate$1$1"})
    static final class a extends q implements b<IResponse<bo>, x> {
        final /* synthetic */ FinderFriendLikeLoader uaE;
        final /* synthetic */ FinderFriendLikeFeedUI uaF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderFriendLikeLoader finderFriendLikeLoader, FinderFriendLikeFeedUI finderFriendLikeFeedUI) {
            super(1);
            this.uaE = finderFriendLikeLoader;
            this.uaF = finderFriendLikeFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245230);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (!((FinderFriendLikeLoader.c) iResponse2).getHasMore() && this.uaE.getDataListJustForAdapter().size() != 0) {
                View loadMoreFooter = FinderFriendLikeFeedUI.a(this.uaF).tLS.getLoadMoreFooter();
                if (loadMoreFooter != null) {
                    loadMoreFooter.setVisibility(0);
                }
                View loadMoreFooter2 = FinderFriendLikeFeedUI.a(this.uaF).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                View loadMoreFooter3 = FinderFriendLikeFeedUI.a(this.uaF).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.uaF.getResources().getColor(R.color.FG_2));
                }
                View loadMoreFooter4 = FinderFriendLikeFeedUI.a(this.uaF).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter4 == null || (textView = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter5 = FinderFriendLikeFeedUI.a(this.uaF).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter5 == null || (findViewById = loadMoreFooter5.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245230);
            return xVar;
        }
    }

    public static final /* synthetic */ o.b a(FinderFriendLikeFeedUI finderFriendLikeFeedUI) {
        AppMethodBeat.i(245235);
        o.b bVar = finderFriendLikeFeedUI.uaC;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245235);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.abs;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final void initOnCreate() {
        boolean z;
        AppMethodBeat.i(245231);
        String stringExtra = getIntent().getStringExtra("KEY_USERNAME");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.tvp = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("KEY_NICKNAME");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.uaD = stringExtra2;
        y yVar = y.vXH;
        String str = this.tvp;
        if (str == null) {
            p.btv("targetUsername");
        }
        String str2 = this.uaD;
        if (str2 == null) {
            p.btv("targetNickname");
        }
        this.uaD = y.hf(str, str2);
        String str3 = this.TAG;
        StringBuilder sb = new StringBuilder("initOnCreate ");
        String str4 = this.tvp;
        if (str4 == null) {
            p.btv("targetUsername");
        }
        StringBuilder append = sb.append(str4).append(", ");
        String str5 = this.uaD;
        if (str5 == null) {
            p.btv("targetNickname");
        }
        Log.i(str3, append.append(str5).toString());
        String str6 = this.tvp;
        if (str6 == null) {
            p.btv("targetUsername");
        }
        if (str6.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            if (af == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
                AppMethodBeat.o(245231);
                throw tVar;
            }
            bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
            String str7 = this.tvp;
            if (str7 == null) {
                p.btv("targetUsername");
            }
            as Kn = aSN.Kn(str7);
            AppCompatActivity context = getContext();
            p.g(context, "context");
            String string = context.getResources().getString(R.string.cpa);
            p.g(string, "context.resources.getString(R.string.finder_he)");
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            String string2 = context2.getResources().getString(R.string.d9s);
            p.g(string2, "context.resources.getString(R.string.finder_she)");
            if (Kn != null) {
                AppCompatActivity context3 = getContext();
                Object[] objArr = new Object[1];
                if (Kn.ajE() != 1) {
                    string = string2;
                }
                objArr[0] = string;
                setMMTitle(com.tencent.mm.pluginsdk.ui.span.l.c(context3, getString(R.string.cn0, objArr)));
            } else {
                setMMTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), getString(R.string.cn0, new Object[]{string})));
            }
        }
        String str8 = this.tvp;
        if (str8 == null) {
            p.btv("targetUsername");
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderFriendLikeLoader finderFriendLikeLoader = new FinderFriendLikeLoader(str8, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        finderFriendLikeLoader.fetchEndCallback = new a(finderFriendLikeLoader, this);
        this.tFM = finderFriendLikeLoader;
        FinderFriendLikeFeedUI finderFriendLikeFeedUI = this;
        BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
        if (baseFinderFeedLoader == null) {
            p.btv("feedLoader");
        }
        this.uaB = new o.a(finderFriendLikeFeedUI, baseFinderFeedLoader);
        this.uaC = new o.b(this);
        o.b bVar = this.uaC;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        o.a aVar2 = this.uaB;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        String str9 = this.tvp;
        if (str9 == null) {
            p.btv("targetUsername");
        }
        if (Util.isNullOrNil(str9)) {
            finish();
        }
        AppMethodBeat.o(245231);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(245234);
        finish();
        AppMethodBeat.o(245234);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ o.a dcq() {
        AppMethodBeat.i(245232);
        o.a aVar = this.uaB;
        if (aVar == null) {
            p.btv("presenter");
        }
        o.a aVar2 = aVar;
        AppMethodBeat.o(245232);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ o.b ddS() {
        AppMethodBeat.i(245233);
        o.b bVar = this.uaC;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        o.b bVar2 = bVar;
        AppMethodBeat.o(245233);
        return bVar2;
    }
}
