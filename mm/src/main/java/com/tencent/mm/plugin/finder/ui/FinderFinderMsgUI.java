package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderMsgNotifyTabUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getActivityContentView", "getCommentScene", "", "getPresenter", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI extends MMFinderUI {
    private static final String TAG = TAG;
    private static final ArrayList<int[]> uYR = j.ac(new int[]{2}, new int[]{3, 5}, new int[]{1, 10});
    public static final a vJV = new a((byte) 0);
    private HashMap _$_findViewCache;
    public final FinderNotifyContract.NotifyPresenter uZa = new FinderNotifyContract.NotifyPresenter(new int[]{3, 4, 5}, uYR, (byte) 0);

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252341);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252341);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252340);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252340);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderFinderMsgUI() {
        AppMethodBeat.i(252338);
        AppMethodBeat.o(252338);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMsgTypes", "()Ljava/util/ArrayList;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252339);
        AppMethodBeat.o(252339);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252329);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderMsgNotifyTabUIC.class);
        AppMethodBeat.o(252329);
        return of;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252330);
        super.onCreate(bundle);
        initView();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int dHU = ((FinderTabStateCacheVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderMsgNotifyTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderMsgNotifyTabUIC.class)).aw(dHU, false);
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZa;
        EventCenter.instance.add(notifyPresenter.uYP);
        g.azz().a(978, notifyPresenter);
        if (notifyPresenter.scene == 1) {
            dc dcVar = notifyPresenter.uYr;
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            dcVar.ok(cMD);
            notifyPresenter.uYr.afb();
        }
        AppMethodBeat.o(252330);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(252331);
        super.onNewIntent(intent);
        AppMethodBeat.o(252331);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252332);
        super.onResume();
        this.uZa.uYq = System.currentTimeMillis();
        h.hkS();
        AppMethodBeat.o(252332);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(252333);
        super.onPause();
        h.hkS();
        AppMethodBeat.o(252333);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(252334);
        super.onStop();
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZa;
        notifyPresenter.uYr.iX(System.currentTimeMillis() - notifyPresenter.uYq);
        AppMethodBeat.o(252334);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252335);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int dIM = ((FinderMsgNotifyTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderMsgNotifyTabUIC.class)).dIM();
        super.onDestroy();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderTabStateCacheVM finderTabStateCacheVM = (FinderTabStateCacheVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class);
        Log.i("Finder.FinderTagCacheVm", "type=1 tabIndex=" + dIM + ' ');
        finderTabStateCacheVM.wtV.put(1, Integer.valueOf(dIM));
        finderTabStateCacheVM.wuI = -1;
        this.uZa.onActivityDestroy();
        AppMethodBeat.o(252335);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFinderMsgUI vJW;

        b(FinderFinderMsgUI finderFinderMsgUI) {
            this.vJW = finderFinderMsgUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252328);
            this.vJW.finish();
            AppMethodBeat.o(252328);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(252336);
        setMMTitle(R.string.ck2);
        setBackBtn(new b(this));
        AppMethodBeat.o(252336);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 7;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void dealContentView(View view) {
        AppMethodBeat.i(252337);
        super.dealContentView(view);
        AppMethodBeat.o(252337);
    }
}
