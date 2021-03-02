package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.search.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "()V", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getCommentScene", "", "getLayoutId", "initPopularList", "", "initSearchView", "jumpToFeedList", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "jumpToMixSearchUI", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSwipeBack", "reportStartSearch", "plugin-finder_release"})
public final class FinderLongVideoPreviewUI extends MMFinderUI implements a.b {
    private HashMap _$_findViewCache;
    private com.tencent.mm.ui.search.a ubO;
    private g ubP;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245428);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245428);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245427);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245427);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<bby, x> {
        final /* synthetic */ FinderLongVideoPreviewUI ubQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderLongVideoPreviewUI finderLongVideoPreviewUI) {
            super(1);
            this.ubQ = finderLongVideoPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(bby bby) {
            AppMethodBeat.i(245417);
            bby bby2 = bby;
            p.h(bby2, "hotWord");
            FinderLongVideoPreviewUI.a(this.ubQ, bby2);
            x xVar = x.SXb;
            AppMethodBeat.o(245417);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cb, code lost:
        if ((r0 - com.tencent.mm.plugin.finder.search.g.c.dpQ()) > 240) goto L_0x00cd;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245421);
        super.onResume();
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.post(new c(this));
        g gVar = this.ubP;
        if (gVar != null) {
            gVar.dpI();
            AppMethodBeat.o(245421);
            return;
        }
        AppMethodBeat.o(245421);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FinderLongVideoPreviewUI ubQ;

        c(FinderLongVideoPreviewUI finderLongVideoPreviewUI) {
            this.ubQ = finderLongVideoPreviewUI;
        }

        public final void run() {
            AppMethodBeat.i(245419);
            g gVar = this.ubQ.ubP;
            if (gVar != null) {
                gVar.cnl();
                AppMethodBeat.o(245419);
                return;
            }
            AppMethodBeat.o(245419);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245422);
        super.onDestroy();
        g gVar = this.ubP;
        if (gVar != null) {
            gVar.onDestroy();
        }
        k kVar = k.vfA;
        k.auJ("");
        AppMethodBeat.o(245422);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(245423);
        super.onSwipeBack();
        hideVKB();
        AppMethodBeat.o(245423);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 6;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderLongVideoPreviewUI ubQ;

        b(FinderLongVideoPreviewUI finderLongVideoPreviewUI) {
            this.ubQ = finderLongVideoPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245418);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI$initSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderLongVideoPreviewUI.b(this.ubQ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI$initSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245418);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ai4;
    }

    public final void onClickCancelBtn(View view) {
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(245424);
        hideVKB();
        if (!isFinishing()) {
            finish();
        }
        AppMethodBeat.o(245424);
    }

    public static final /* synthetic */ void b(FinderLongVideoPreviewUI finderLongVideoPreviewUI) {
        AppMethodBeat.i(245425);
        Intent intent = new Intent();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Intent intent2 = finderLongVideoPreviewUI.getIntent();
        p.g(intent2, "intent");
        FinderReporterUIC.a.a(finderLongVideoPreviewUI, intent2, 0, 0, false, 124);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        AppCompatActivity context = finderLongVideoPreviewUI.getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.finder.utils.a.C(context, intent);
        AppMethodBeat.o(245425);
    }

    public static final /* synthetic */ void a(FinderLongVideoPreviewUI finderLongVideoPreviewUI, bby bby) {
        byte[] bArr;
        com.tencent.mm.bw.b bVar;
        AppMethodBeat.i(245426);
        Intent intent = new Intent();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Intent intent2 = finderLongVideoPreviewUI.getIntent();
        p.g(intent2, "intent");
        FinderReporterUIC.a.a(finderLongVideoPreviewUI, intent2, 0, 0, false, 124);
        String str = bby != null ? bby.LLa : null;
        if (!Util.isNullOrNil(str)) {
            if (str == null) {
                str = "";
            }
            intent.putExtra("key_search_query", str);
            if (bby == null || (bVar = bby.LLb) == null) {
                bArr = null;
            } else {
                bArr = bVar.toByteArray();
            }
            intent.putExtra("key_search_session_buffer", bArr);
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        AppCompatActivity context = finderLongVideoPreviewUI.getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.finder.utils.a.b(context, (aqw) null, intent);
        AppMethodBeat.o(245426);
    }
}
