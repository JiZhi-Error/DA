package com.tencent.mm.plugin.finder.feed.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI extends FinderLoaderFeedUI<FinderRetransmitSourceContract.Loader, FinderRetransmitSourceContract.c, FinderRetransmitSourceContract.a> {
    private HashMap _$_findViewCache;
    private long refObjectId;
    private String refObjectNonceId = "";
    private String tvp;
    private String uaD;
    private FinderRetransmitSourceContract.a ucM;
    private FinderRetransmitSourceContract.c ucN;
    private FinderRetransmitSourceContract.Loader ucO;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245517);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245517);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245516);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245516);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(166232);
        String stringExtra = getIntent().getStringExtra("KEY_TARGET_USERNAME");
        p.g(stringExtra, "intent.getStringExtra(Co…ceUI.KEY_TARGET_USERNAME)");
        this.tvp = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
        p.g(stringExtra2, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
        this.uaD = stringExtra2;
        this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0);
        String stringExtra3 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
        p.g(stringExtra3, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
        this.refObjectNonceId = stringExtra3;
        String str = this.tvp;
        if (str == null) {
            p.btv("targetUsername");
        }
        if (Util.isNullOrNil(str) || this.refObjectId == 0) {
            finish();
        }
        this.ucM = new FinderRetransmitSourceContract.a(this);
        FinderRetransmitSourceUI finderRetransmitSourceUI = this;
        FinderRetransmitSourceContract.a aVar = this.ucM;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.ucN = new FinderRetransmitSourceContract.c(finderRetransmitSourceUI, aVar);
        String str2 = this.tvp;
        if (str2 == null) {
            p.btv("targetUsername");
        }
        long j2 = this.refObjectId;
        String str3 = this.refObjectNonceId;
        e eVar = e.FEED_RETRANSMIT_SOURCE;
        a aVar2 = a.PRN;
        this.ucO = new FinderRetransmitSourceContract.Loader(str2, j2, str3, eVar, ((FinderReporterUIC) a.b(this).get(FinderReporterUIC.class)).dIx());
        AppCompatActivity context = getContext();
        String str4 = this.uaD;
        if (str4 == null) {
            p.btv("targetNickname");
        }
        setMMTitle(com.tencent.mm.pluginsdk.ui.span.l.c(context, str4));
        AppMethodBeat.o(166232);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajd;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderRetransmitSourceContract.a ddK() {
        AppMethodBeat.i(166233);
        FinderRetransmitSourceContract.a aVar = this.ucM;
        if (aVar == null) {
            p.btv("presenter");
        }
        FinderRetransmitSourceContract.a aVar2 = aVar;
        AppMethodBeat.o(166233);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderRetransmitSourceContract.c ddL() {
        AppMethodBeat.i(166234);
        FinderRetransmitSourceContract.c cVar = this.ucN;
        if (cVar == null) {
            p.btv("viewCallback");
        }
        FinderRetransmitSourceContract.c cVar2 = cVar;
        AppMethodBeat.o(166234);
        return cVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderRetransmitSourceContract.Loader ddM() {
        AppMethodBeat.i(166235);
        FinderRetransmitSourceContract.Loader loader = this.ucO;
        if (loader == null) {
            p.btv("feedLoader");
        }
        FinderRetransmitSourceContract.Loader loader2 = loader;
        AppMethodBeat.o(166235);
        return loader2;
    }
}
