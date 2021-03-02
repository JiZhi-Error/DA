package com.tencent.mm.plugin.appbrand.ui.collection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.h.c;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ac;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI;
import com.tencent.mm.plugin.appbrand.ui.collection.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\"\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\t2\u0010\b\u0002\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\"\u00106\u001a\u00020\u001d*\u0004\u0018\u00010\u00172\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d08H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mHadEnterWxa", "", "mList", "Landroid/support/v7/widget/RecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "mRefreshOnResume", "mWxaAttrsStorageListener", "sceneFor13801", "", "getSceneFor13801", "()I", "sceneFor13801$delegate", "Lkotlin/Lazy;", "sceneIdFor13801", "", "getSceneIdFor13801", "()Ljava/lang/String;", "sceneIdFor13801$delegate", "getLayoutId", "hideLoading", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnter", "onResume", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "queryDataList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "refreshDataList", "replace", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "setupStorageListeners", "showAddCollectionInputAlert", "showLoading", "updateDataListUsingDiffs", "runIfNotEmpty", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionDisplayVerticalList extends AppBrandLauncherUI.Fragment implements h.a {
    private HashMap _$_findViewCache;
    private f oaA;
    private boolean oaB;
    private MMHandler oaC;
    private boolean oaD;
    private final kotlin.f oaE = kotlin.g.ah(new h(this));
    private final kotlin.f oaF = kotlin.g.ah(new i(this));
    private final MStorage.IOnStorageChange oaG = new a(this);
    private final MStorage.IOnStorageChange oaH = new b(this);
    private RecyclerView oaz;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a {
        public static final f oaK = new f();

        static {
            AppMethodBeat.i(51177);
            AppMethodBeat.o(51177);
        }

        f() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Object invoke() {
            return null;
        }
    }

    public AppBrandCollectionDisplayVerticalList() {
        AppMethodBeat.i(51194);
        AppMethodBeat.o(51194);
    }

    public static final /* synthetic */ List bYh() {
        AppMethodBeat.i(51195);
        List<LocalUsageInfo> bYg = bYg();
        AppMethodBeat.o(51195);
        return bYg;
    }

    public static final /* synthetic */ void bYi() {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final int getLayoutId() {
        return -1;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class a implements MStorage.IOnStorageChange {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(51172);
            if (p.j(MStorageEventData.EventType.BATCH, str) && 3 == mStorageEventData.eventId && (mStorageEventData.obj instanceof Long)) {
                AppBrandCollectionDisplayVerticalList.a(this.oaI);
                AppMethodBeat.o(51172);
                return;
            }
            AppBrandCollectionDisplayVerticalList.h(this.oaI);
            AppMethodBeat.o(51172);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class b implements MStorage.IOnStorageChange {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        b(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(51173);
            AppBrandCollectionDisplayVerticalList.h(this.oaI);
            AppMethodBeat.o(51173);
        }
    }

    private static List<LocalUsageInfo> bYg() {
        AppMethodBeat.i(51185);
        v a2 = ((ag) com.tencent.mm.kernel.g.af(ag.class)).a(Integer.MAX_VALUE, ag.a.DESC);
        if (a2 == null) {
            a2 = v.SXr;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(51185);
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        l(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        public final void run() {
            AppMethodBeat.i(51183);
            FragmentActivity activity = this.oaI.getActivity();
            if (!(activity instanceof com.tencent.mm.plugin.appbrand.ui.launcher.a)) {
                activity = null;
            }
            com.tencent.mm.plugin.appbrand.ui.launcher.a aVar = (com.tencent.mm.plugin.appbrand.ui.launcher.a) activity;
            if (aVar != null) {
                aVar.iI(false);
                AppMethodBeat.o(51183);
                return;
            }
            AppMethodBeat.o(51183);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$updateDataListUsingDiffs$2$1"})
    public static final class k implements Runnable {
        final /* synthetic */ c.b gYX;
        final /* synthetic */ List kUf;
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        k(c.b bVar, AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, List list) {
            this.gYX = bVar;
            this.oaI = appBrandCollectionDisplayVerticalList;
            this.kUf = list;
        }

        public final void run() {
            AppMethodBeat.i(51182);
            f fVar = this.oaI.oaA;
            if (fVar != null) {
                fVar.bT(this.kUf);
                this.gYX.a(fVar);
                AppMethodBeat.o(51182);
                return;
            }
            AppMethodBeat.o(51182);
        }
    }

    static /* synthetic */ void a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(51187);
        appBrandCollectionDisplayVerticalList.a(true, (kotlin.g.a.a<? extends Runnable>) f.oaK);
        AppMethodBeat.o(51187);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;
        final /* synthetic */ boolean oaL;
        final /* synthetic */ kotlin.g.a.a oaM;

        g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, boolean z, kotlin.g.a.a aVar) {
            this.oaI = appBrandCollectionDisplayVerticalList;
            this.oaL = z;
            this.oaM = aVar;
        }

        public final void run() {
            AppMethodBeat.i(51179);
            this.oaI.runOnUiThread(new a(AppBrandCollectionDisplayVerticalList.bYh(), this));
            AppMethodBeat.o(51179);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$refreshDataList$workerRunner$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ List oaN;
            final /* synthetic */ g oaO;

            a(List list, g gVar) {
                this.oaN = list;
                this.oaO = gVar;
            }

            public final void run() {
                AppMethodBeat.i(51178);
                if (this.oaN.isEmpty()) {
                    FragmentActivity activity = this.oaO.oaI.getActivity();
                    if (!(activity instanceof com.tencent.mm.plugin.appbrand.ui.launcher.a)) {
                        activity = null;
                    }
                    com.tencent.mm.plugin.appbrand.ui.launcher.a aVar = (com.tencent.mm.plugin.appbrand.ui.launcher.a) activity;
                    if (aVar != null) {
                        aVar.iI(false);
                    }
                } else {
                    f fVar = this.oaO.oaI.oaA;
                    if (fVar == null) {
                        p.hyc();
                    }
                    fVar.bT(this.oaN);
                    if (this.oaO.oaL) {
                        f fVar2 = this.oaO.oaI.oaA;
                        if (fVar2 == null) {
                            p.hyc();
                        }
                        fVar2.aq(0, this.oaN.size());
                    } else {
                        f fVar3 = this.oaO.oaI.oaA;
                        if (fVar3 == null) {
                            p.hyc();
                        }
                        fVar3.as(0, this.oaN.size());
                    }
                }
                Runnable runnable = (Runnable) this.oaO.oaM.invoke();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.o(51178);
                    return;
                }
                AppMethodBeat.o(51178);
            }
        }
    }

    private final void a(boolean z, kotlin.g.a.a<? extends Runnable> aVar) {
        AppMethodBeat.i(51186);
        g gVar = new g(this, z, aVar);
        MMHandler mMHandler = this.oaC;
        if (mMHandler == null) {
            p.hyc();
        }
        if (p.j(mMHandler.getSerialTag(), com.tencent.f.j.a.hmF())) {
            gVar.run();
            AppMethodBeat.o(51186);
            return;
        }
        MMHandler mMHandler2 = this.oaC;
        if (mMHandler2 == null) {
            p.hyc();
        }
        mMHandler2.postToWorker(gVar);
        AppMethodBeat.o(51186);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(51188);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.addTextOptionMenu(0, getString(R.string.ru), new c(this), new d(this), t.b.BLACK);
            AppMethodBeat.o(51188);
            return;
        }
        AppMethodBeat.o(51188);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i2;
            AppMethodBeat.i(51174);
            if (this.oaI.getActivity() == null) {
                AppMethodBeat.o(51174);
            } else {
                AppBrandCollectionSortUI.a aVar = AppBrandCollectionSortUI.oaQ;
                FragmentActivity activity = this.oaI.getActivity();
                if (activity == null) {
                    p.hyc();
                }
                p.g(activity, "activity!!");
                FragmentActivity fragmentActivity = activity;
                f fVar = this.oaI.oaA;
                if (fVar == null) {
                    p.hyc();
                }
                ArrayList<LocalUsageInfo> arrayList = fVar.kgc;
                int c2 = AppBrandCollectionDisplayVerticalList.c(this.oaI);
                String d2 = AppBrandCollectionDisplayVerticalList.d(this.oaI);
                p.h(fragmentActivity, "context");
                p.h(arrayList, "dataList");
                p.h(d2, "operateReportSceneId");
                Intent intent = new Intent(fragmentActivity, AppBrandCollectionSortUI.class);
                intent.putExtra("KEY_SORT_DATA_LIST", arrayList);
                intent.putExtra("KEY_OPERATE_REPORT_SCENE", c2);
                intent.putExtra("KEY_OPERATE_REPORT_SCENE_ID", d2);
                if (fragmentActivity instanceof Activity) {
                    i2 = 0;
                } else {
                    i2 = 268435456;
                }
                intent.addFlags(i2);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(fragmentActivity, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI$Companion", "startSortList", "(Landroid/content/Context;Ljava/util/ArrayList;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                fragmentActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(fragmentActivity, "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI$Companion", "startSortList", "(Landroid/content/Context;Ljava/util/ArrayList;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (!(fragmentActivity instanceof Activity)) {
                    fragmentActivity = null;
                }
                FragmentActivity fragmentActivity2 = fragmentActivity;
                if (fragmentActivity2 != null) {
                    fragmentActivity2.overridePendingTransition(R.anim.n, R.anim.s);
                }
                this.oaI.oaB = true;
                AppMethodBeat.o(51174);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onFinish"})
    public static final class j implements h.b {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        j(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        @Override // com.tencent.mm.ui.base.h.b
        public final boolean onFinish(CharSequence charSequence) {
            String obj;
            AppMethodBeat.i(175223);
            if (!(charSequence == null || (obj = charSequence.toString()) == null)) {
                AppBrandCollectionDisplayVerticalList.f(obj, AnonymousClass1.oaP);
            }
            AppMethodBeat.o(175223);
            return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(51189);
        super.onResume();
        if (this.oaB) {
            a(this);
            this.oaB = false;
        }
        if (this.oaD) {
            com.tencent.mm.plugin.appbrand.report.i.bUt();
            this.oaD = false;
        }
        AppMethodBeat.o(51189);
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(51190);
        p.h(view, "view");
        super.onViewCreated(view, bundle);
        this.oaC = new MMHandler("AppBrandLauncherCollectionList");
        a(false, (kotlin.g.a.a<? extends Runnable>) new e(this));
        AppMethodBeat.o(51190);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void initView() {
        AppMethodBeat.i(51191);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            p.hyc();
        }
        RecyclerView recyclerView = new RecyclerView(activity);
        getActivity();
        recyclerView.setLayoutManager(new AppBrandCollectionDisplayVerticalList$initView$$inlined$apply$lambda$1(this));
        f fVar = new f(new ArrayList(), this);
        this.oaA = fVar;
        recyclerView.setAdapter(fVar);
        Context context = recyclerView.getContext();
        p.g(context, "context");
        recyclerView.setBackgroundColor(context.getResources().getColor(R.color.kz));
        recyclerView.b(new g());
        recyclerView.setItemAnimator(null);
        this.oaz = recyclerView;
        View contentView = getContentView();
        if (contentView == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(51191);
            throw tVar;
        }
        FrameLayout frameLayout = (FrameLayout) contentView;
        RecyclerView recyclerView2 = this.oaz;
        if (recyclerView2 == null) {
            p.hyc();
        }
        frameLayout.addView(recyclerView2, new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(51191);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void bXb() {
        AppMethodBeat.i(51192);
        RecyclerView recyclerView = this.oaz;
        if (recyclerView != null) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(51192);
            return;
        }
        AppMethodBeat.o(51192);
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroyView() {
        AppMethodBeat.i(51193);
        super.onDestroyView();
        ((u) n.W(u.class)).remove(this.oaG);
        n.buC().remove(this.oaH);
        MMHandler mMHandler = this.oaC;
        if (mMHandler != null) {
            mMHandler.quit();
        }
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(51193);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.collection.h.a
    public final void onEnter() {
        this.oaD = true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d implements View.OnLongClickListener {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        public final boolean onLongClick(View view) {
            boolean z;
            AppMethodBeat.i(175220);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$onActivityCreated$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (a.bYj()) {
                AppBrandCollectionDisplayVerticalList.f(this.oaI);
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$onActivityCreated$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(175220);
            return z;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            super(0);
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            Intent intent;
            int i2 = 8;
            AppMethodBeat.i(51180);
            FragmentActivity activity = this.oaI.getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                int intExtra = intent.getIntExtra("extra_get_usage_reason", 8);
                int intExtra2 = intent.getIntExtra("extra_get_usage_prescene", 0);
                switch (intExtra) {
                    case 7:
                        break;
                    case 8:
                        if (intExtra2 != 2) {
                            i2 = 3;
                            break;
                        } else {
                            i2 = 6;
                            break;
                        }
                    default:
                        i2 = 3;
                        break;
                }
            } else {
                i2 = 3;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(51180);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            super(0);
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            String bUw;
            AppMethodBeat.i(51181);
            switch (AppBrandCollectionDisplayVerticalList.c(this.oaI)) {
                case 6:
                case 7:
                case 8:
                    bUw = com.tencent.mm.plugin.appbrand.report.l.bUw();
                    if (bUw == null) {
                        p.hyc();
                        AppMethodBeat.o(51181);
                        break;
                    }
                    AppMethodBeat.o(51181);
                    break;
                default:
                    bUw = com.tencent.mm.plugin.appbrand.report.l.bUv();
                    AppMethodBeat.o(51181);
                    break;
            }
            return bUw;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Runnable> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            super(0);
            this.oaI = appBrandCollectionDisplayVerticalList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Runnable invoke() {
            AppMethodBeat.i(51176);
            AnonymousClass1 r0 = new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.e.AnonymousClass1 */
                final /* synthetic */ e oaJ;

                {
                    this.oaJ = r1;
                }

                public final void run() {
                    AppMethodBeat.i(51175);
                    AppBrandCollectionDisplayVerticalList.bYi();
                    if (this.oaJ.oaI.isAdded()) {
                        AppBrandCollectionDisplayVerticalList.g(this.oaJ.oaI);
                    }
                    HashSet hashSet = new HashSet();
                    f fVar = this.oaJ.oaI.oaA;
                    if (fVar == null) {
                        p.hyc();
                    }
                    Iterator<T> it = fVar.kgc.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().username);
                    }
                    aa.b(kotlin.a.j.p(hashSet), o.a.STAR_LIST);
                    AppMethodBeat.o(51175);
                }
            };
            AppMethodBeat.o(51176);
            return r0;
        }
    }

    public static final /* synthetic */ int c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(51196);
        int intValue = ((Number) appBrandCollectionDisplayVerticalList.oaE.getValue()).intValue();
        AppMethodBeat.o(51196);
        return intValue;
    }

    public static final /* synthetic */ String d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(51197);
        String str = (String) appBrandCollectionDisplayVerticalList.oaF.getValue();
        AppMethodBeat.o(51197);
        return str;
    }

    public static final /* synthetic */ void f(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(175224);
        if (appBrandCollectionDisplayVerticalList.getContext() == null) {
            AppMethodBeat.o(175224);
            return;
        }
        com.tencent.mm.ui.base.h.a(appBrandCollectionDisplayVerticalList.getContext(), "!TEST!\n输入小程序username添加到「我的小程序」", "", "", Integer.MAX_VALUE, new j(appBrandCollectionDisplayVerticalList));
        AppMethodBeat.o(175224);
    }

    public static final /* synthetic */ void f(String str, kotlin.g.a.b bVar) {
        AppMethodBeat.i(175225);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            bVar.invoke(str);
        }
        AppMethodBeat.o(175225);
    }

    public static final /* synthetic */ void g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(51198);
        u uVar = (u) n.W(u.class);
        MMHandler mMHandler = appBrandCollectionDisplayVerticalList.oaC;
        if (mMHandler == null) {
            p.hyc();
        }
        uVar.add(mMHandler.getSerial(), appBrandCollectionDisplayVerticalList.oaG);
        z buC = n.buC();
        MMHandler mMHandler2 = appBrandCollectionDisplayVerticalList.oaC;
        if (mMHandler2 == null) {
            p.hyc();
        }
        buC.add(mMHandler2.getSerial(), appBrandCollectionDisplayVerticalList.oaH);
        AppMethodBeat.o(51198);
    }

    public static final /* synthetic */ void h(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(51199);
        if (appBrandCollectionDisplayVerticalList.oaA != null) {
            f fVar = appBrandCollectionDisplayVerticalList.oaA;
            if (fVar == null) {
                p.hyc();
            }
            ArrayList<LocalUsageInfo> bYm = fVar.bYm();
            List<LocalUsageInfo> bYg = bYg();
            if (bYg.isEmpty()) {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new l(appBrandCollectionDisplayVerticalList));
                AppMethodBeat.o(51199);
                return;
            }
            try {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new k(android.support.v7.h.c.a(new ac(bYm, bYg), true), appBrandCollectionDisplayVerticalList, bYg));
                AppMethodBeat.o(51199);
                return;
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandCollectionDisplayVerticalList", e2, "calculateDiff, oldList.size=" + bYm.size() + ", newList.size=" + bYg.size(), new Object[0]);
                if (WeChatEnvironment.hasDebugger()) {
                    NullPointerException nullPointerException = e2;
                    AppMethodBeat.o(51199);
                    throw nullPointerException;
                }
            }
        }
        AppMethodBeat.o(51199);
    }
}
