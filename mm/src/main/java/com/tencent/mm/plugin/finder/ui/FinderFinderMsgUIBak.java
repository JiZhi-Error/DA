package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUIBak extends MMFinderUI implements FinderMsgContract.MsgViewCallback.UICallbackListener {
    private static final int vJY = 1;
    public static final a vJZ = new a((byte) 0);
    private final String TAG = "Finder.FinderFinderMsgUI";
    private HashMap _$_findViewCache;
    private FinderMsgContract.MsgViewCallback uYo;
    private final FinderMsgContract.MsgPresenter vJX = new FinderMsgContract.MsgPresenter(1, new int[]{1, 2, 3, 5, 10});

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252357);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252357);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252356);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252356);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderFinderMsgUIBak() {
        AppMethodBeat.i(252354);
        AppMethodBeat.o(252354);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak$Companion;", "", "()V", "MENU_ID_AT_TIMELINE", "", "getMENU_ID_AT_TIMELINE", "()I", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252355);
        AppMethodBeat.o(252355);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252347);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(252347);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFinderMsgUIBak vKa;

        b(FinderFinderMsgUIBak finderFinderMsgUIBak) {
            this.vKa = finderFinderMsgUIBak;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252342);
            this.vKa.finish();
            AppMethodBeat.o(252342);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(252348);
        setMMTitle(getString(R.string.d2e));
        setBackBtn(new b(this));
        View contentView = getContentView();
        p.g(contentView, "contentView");
        FinderMsgContract.MsgViewCallback msgViewCallback = new FinderMsgContract.MsgViewCallback(this, contentView, this.vJX, this);
        this.vJX.a(msgViewCallback);
        msgViewCallback.initView();
        this.uYo = msgViewCallback;
        addIconOptionMenu(0, R.drawable.aii, new c(this));
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_MSG_NORMAL_INT_SYNC, (Object) 0);
        AppMethodBeat.o(252348);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFinderMsgUIBak vKa;

        c(FinderFinderMsgUIBak finderFinderMsgUIBak) {
            this.vKa = finderFinderMsgUIBak;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252346);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.vKa, 1, false);
            eVar.a(AnonymousClass1.vKb);
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.finder.ui.FinderFinderMsgUIBak.c.AnonymousClass2 */
                final /* synthetic */ c vKc;

                {
                    this.vKc = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(252345);
                    p.g(menuItem, "menuItem");
                    int itemId = menuItem.getItemId();
                    a aVar = FinderFinderMsgUIBak.vJZ;
                    if (itemId == FinderFinderMsgUIBak.vJY) {
                        Intent intent = new Intent();
                        intent.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
                        intent.putExtra("KEY_FROM_SCENE", 2);
                        intent.putExtra("KEY_USERNAME", z.aUg());
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC.a.a(this.vKc.vKa, intent, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.ab(this.vKc.vKa, intent);
                    }
                    AppMethodBeat.o(252345);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(252346);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ala;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter;
        AppMethodBeat.i(252349);
        super.onResume();
        this.vJX.uYq = System.currentTimeMillis();
        FinderMsgContract.MsgViewCallback msgViewCallback = this.uYo;
        if (msgViewCallback == null || (wxRecyclerAdapter = msgViewCallback.tFp) == null) {
            AppMethodBeat.o(252349);
            return;
        }
        wxRecyclerAdapter.onResume();
        AppMethodBeat.o(252349);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter;
        AppMethodBeat.i(252350);
        super.onPause();
        FinderMsgContract.MsgViewCallback msgViewCallback = this.uYo;
        if (msgViewCallback == null || (wxRecyclerAdapter = msgViewCallback.tFp) == null) {
            AppMethodBeat.o(252350);
            return;
        }
        wxRecyclerAdapter.onPause();
        AppMethodBeat.o(252350);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252351);
        super.onDestroy();
        this.vJX.onDetach();
        AppMethodBeat.o(252351);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(252352);
        super.onStop();
        this.vJX.onStop();
        AppMethodBeat.o(252352);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener
    public final void a(ao aoVar) {
        AppMethodBeat.i(252353);
        p.h(aoVar, "mention");
        AppMethodBeat.o(252353);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 7;
    }
}
