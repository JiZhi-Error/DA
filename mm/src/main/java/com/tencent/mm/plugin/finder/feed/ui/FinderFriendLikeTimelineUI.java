package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.q;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.e;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "presenter", "scene", "targetNickname", "targetWxUsername", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "jumpFinderHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMoreClick", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI extends FinderLoaderFeedUI<FinderFriendLikeLoader, q.b, q.a> {
    private final String TAG = "Finder.FinderFriendLikeTimelineUI";
    private HashMap _$_findViewCache;
    private final int scene = 2;
    private int tCE = 79;
    private String uaD = "";
    private q.a uaG;
    private q.b uaH;
    private FinderFriendLikeLoader uaI;
    private String uaJ = "";

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245261);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245261);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245260);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245260);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            super(1);
            this.uaK = finderFriendLikeTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            View findViewById2;
            AppMethodBeat.i(245241);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            View findViewById3 = this.uaK.findViewById(R.id.epl);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            List<bo> incrementList = iResponse2.getIncrementList();
            if (incrementList != null && incrementList.isEmpty()) {
                FinderFriendLikeTimelineUI.a(this.uaK).tLS.setVisibility(8);
                View emptyView = FinderFriendLikeTimelineUI.a(this.uaK).getEmptyView();
                if (emptyView != null) {
                    emptyView.setVisibility(0);
                }
                View emptyView2 = FinderFriendLikeTimelineUI.a(this.uaK).getEmptyView();
                if (!(emptyView2 == null || (findViewById2 = emptyView2.findViewById(R.id.c2o)) == null)) {
                    findViewById2.setOnClickListener(new View.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.b.AnonymousClass1 */
                        final /* synthetic */ b uaL;

                        {
                            this.uaL = r1;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(245239);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            FinderFriendLikeTimelineUI.b(this.uaL.uaK);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(245239);
                        }
                    });
                }
                View emptyView3 = FinderFriendLikeTimelineUI.a(this.uaK).getEmptyView();
                if (!(emptyView3 == null || (findViewById = emptyView3.findViewById(R.id.c2n)) == null)) {
                    findViewById.setOnClickListener(new View.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.b.AnonymousClass2 */
                        final /* synthetic */ b uaL;

                        {
                            this.uaL = r1;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(245240);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            FinderFriendLikeTimelineUI.b(this.uaL.uaK);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(245240);
                        }
                    });
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245241);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            super(1);
            this.uaK = finderFriendLikeTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            View findViewById2;
            View findViewById3;
            View findViewById4;
            View findViewById5;
            View findViewById6;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245246);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.uaK.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById6 = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById6.setVisibility(8);
            }
            View loadMoreFooter5 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter5 == null || (findViewById5 = loadMoreFooter5.findViewById(R.id.e5r)) == null)) {
                findViewById5.setVisibility(8);
            }
            if (iResponse2.getIncrementList() != null) {
                List<bo> incrementList = iResponse2.getIncrementList();
                Integer valueOf = incrementList != null ? Integer.valueOf(incrementList.size()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                if (valueOf.intValue() > 0) {
                    View loadMoreFooter6 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById2 = loadMoreFooter6.findViewById(R.id.e5r)) == null)) {
                        findViewById2.setVisibility(0);
                        com.tencent.mm.view.f.a(findViewById2, new e.b(this) {
                            /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.c.AnonymousClass1 */
                            final /* synthetic */ c uaM;

                            {
                                this.uaM = r1;
                            }

                            @Override // com.tencent.mm.view.e.b
                            public final void p(View view, boolean z) {
                                AppMethodBeat.i(245242);
                                p.h(view, "view");
                                h.INSTANCE.a(22010, this.uaM.uaK.uaJ, 1);
                                AppMethodBeat.o(245242);
                            }
                        });
                        y yVar = y.vXH;
                        if (y.isOtherEnableFullScreenEnjoy()) {
                            View loadMoreFooter7 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
                            if (loadMoreFooter7 != null) {
                                loadMoreFooter7.setOnClickListener(new View.OnClickListener(this) {
                                    /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.c.AnonymousClass2 */
                                    final /* synthetic */ c uaM;

                                    {
                                        this.uaM = r1;
                                    }

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(245243);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        FinderFriendLikeTimelineUI.b(this.uaM.uaK);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(245243);
                                    }
                                });
                            }
                        } else {
                            View loadMoreFooter8 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
                            if (!(loadMoreFooter8 == null || (findViewById4 = loadMoreFooter8.findViewById(R.id.b3r)) == null)) {
                                findViewById4.setOnClickListener(new View.OnClickListener(this) {
                                    /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.c.AnonymousClass3 */
                                    final /* synthetic */ c uaM;

                                    {
                                        this.uaM = r1;
                                    }

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(245244);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        FinderFriendLikeTimelineUI.b(this.uaM.uaK);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(245244);
                                    }
                                });
                            }
                            View loadMoreFooter9 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
                            if (!(loadMoreFooter9 == null || (findViewById3 = loadMoreFooter9.findViewById(R.id.b3q)) == null)) {
                                findViewById3.setOnClickListener(new View.OnClickListener(this) {
                                    /* class com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.c.AnonymousClass4 */
                                    final /* synthetic */ c uaM;

                                    {
                                        this.uaM = r1;
                                    }

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(245245);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        FinderFriendLikeTimelineUI.b(this.uaM.uaK);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$$inlined$apply$lambda$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(245245);
                                    }
                                });
                            }
                        }
                    }
                    FinderFriendLikeTimelineUI.a(this.uaK).tLS.setHasBottomMore(false);
                    x xVar = x.SXb;
                    AppMethodBeat.o(245246);
                    return xVar;
                }
            }
            View loadMoreFooter10 = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter10 == null || (findViewById = loadMoreFooter10.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            FinderFriendLikeTimelineUI.a(this.uaK).tLS.setHasBottomMore(false);
            x xVar2 = x.SXb;
            AppMethodBeat.o(245246);
            return xVar2;
        }
    }

    public static final /* synthetic */ q.b a(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
        AppMethodBeat.i(245257);
        q.b bVar = finderFriendLikeTimelineUI.uaH;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245257);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245252);
        this.tCE = getIntent().getIntExtra("KEY_COMMENT_SCENE", 79);
        super.onCreate(bundle);
        AppMethodBeat.o(245252);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245253);
        String stringExtra = getIntent().getStringExtra("KEY_USERNAME");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.uaJ = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("KEY_NICKNAME");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.uaD = stringExtra2;
        y yVar = y.vXH;
        this.uaD = y.hf(this.uaJ, this.uaD);
        setMMTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), getContext().getString(R.string.d7w, new Object[]{this.uaD})));
        this.uaG = new q.a(this, this.scene);
        FinderFriendLikeTimelineUI finderFriendLikeTimelineUI = this;
        q.a aVar = this.uaG;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.uaH = new q.b(finderFriendLikeTimelineUI, aVar, this.scene, this.tCE);
        String str = this.uaJ;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx();
        dIx.tCE = this.tCE;
        FinderFriendLikeLoader finderFriendLikeLoader = new FinderFriendLikeLoader(str, dIx);
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderFriendLikeLoader.initFromCache(intent);
        finderFriendLikeLoader.setInitDone(new a(finderFriendLikeLoader, this));
        finderFriendLikeLoader.tVz = new b(this);
        finderFriendLikeLoader.fetchEndCallback = new c(this);
        this.uaI = finderFriendLikeLoader;
        if (p.j(this.uaJ, z.aTY())) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new d(this));
            View findViewById = findViewById(R.id.fjz);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = findViewById(R.id.fjz);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new e(this));
                AppMethodBeat.o(245253);
                return;
            }
        }
        AppMethodBeat.o(245253);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderFriendLikeLoader uaE;
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        a(FinderFriendLikeLoader finderFriendLikeLoader, FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            this.uaE = finderFriendLikeLoader;
            this.uaK = finderFriendLikeTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            View findViewById;
            AppMethodBeat.i(245238);
            RecyclerView.LayoutManager layoutManager = FinderFriendLikeTimelineUI.a(this.uaK).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager != null) {
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(245238);
                    throw tVar;
                }
                ((FinderLinearLayoutManager) layoutManager).ah(this.uaE.getInitPos(), 0);
            }
            if (i2 <= 0 || (findViewById = this.uaK.findViewById(R.id.epl)) == null) {
                AppMethodBeat.o(245238);
                return;
            }
            findViewById.setVisibility(8);
            AppMethodBeat.o(245238);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        d(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            this.uaK = finderFriendLikeTimelineUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245247);
            FinderFriendLikeTimelineUI.d(this.uaK);
            AppMethodBeat.o(245247);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        e(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            this.uaK = finderFriendLikeTimelineUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245248);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderFriendLikeTimelineUI.d(this.uaK);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245248);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        public static final f uaN = new f();

        static {
            AppMethodBeat.i(245250);
            AppMethodBeat.o(245250);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(245249);
            mVar.kV(0, R.string.d7y);
            AppMethodBeat.o(245249);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ FinderFriendLikeTimelineUI uaK;

        g(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
            this.uaK = finderFriendLikeTimelineUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(245251);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 0:
                    com.tencent.mm.br.c.b(this.uaK, "setting", ".ui.setting.SettingsPrivacyUI", this.uaK.getIntent());
                    break;
            }
            AppMethodBeat.o(245251);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.abt;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return this.tCE;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ q.a ddK() {
        AppMethodBeat.i(245254);
        q.a aVar = this.uaG;
        if (aVar == null) {
            p.btv("presenter");
        }
        q.a aVar2 = aVar;
        AppMethodBeat.o(245254);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ q.b ddL() {
        AppMethodBeat.i(245255);
        q.b bVar = this.uaH;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        q.b bVar2 = bVar;
        AppMethodBeat.o(245255);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFriendLikeLoader ddM() {
        AppMethodBeat.i(245256);
        FinderFriendLikeLoader finderFriendLikeLoader = this.uaI;
        if (finderFriendLikeLoader == null) {
            p.btv("feedLoader");
        }
        FinderFriendLikeLoader finderFriendLikeLoader2 = finderFriendLikeLoader;
        AppMethodBeat.o(245256);
        return finderFriendLikeLoader2;
    }

    public static final /* synthetic */ void b(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
        AppMethodBeat.i(245258);
        h.INSTANCE.a(22010, finderFriendLikeTimelineUI.uaJ, 2);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 0, 1, false);
        Intent intent = new Intent();
        String fillContextIdToIntent = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(14, 10, 18, intent);
        intent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", true);
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderTimelineUI(finderFriendLikeTimelineUI.getContext(), intent);
        k kVar = k.vfA;
        p.g(fillContextIdToIntent, "contextId");
        k.gS(fillContextIdToIntent, "Enter");
        AppMethodBeat.o(245258);
    }

    public static final /* synthetic */ void d(FinderFriendLikeTimelineUI finderFriendLikeTimelineUI) {
        AppMethodBeat.i(245259);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderFriendLikeTimelineUI, 1, false);
        eVar.a(f.uaN);
        eVar.a(new g(finderFriendLikeTimelineUI));
        eVar.dGm();
        AppMethodBeat.o(245259);
    }
}
