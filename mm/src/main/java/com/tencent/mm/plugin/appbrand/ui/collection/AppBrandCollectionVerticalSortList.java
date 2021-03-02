package com.tencent.mm.plugin.appbrand.ui.collection;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.aa;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList extends AppBrandLauncherUI.Fragment {
    public static final a oaT = new a((byte) 0);
    private HashMap _$_findViewCache;
    private DragSortListView oaR;
    private b oaS;

    static {
        AppMethodBeat.i(51213);
        AppMethodBeat.o(51213);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final int getLayoutId() {
        return R.layout.dh;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void initView() {
        AppMethodBeat.i(51211);
        this.oaR = (DragSortListView) bXc();
        DragSortListView dragSortListView = this.oaR;
        if (dragSortListView != null) {
            dragSortListView.setDropListener(new b(this));
        }
        DragSortListView dragSortListView2 = this.oaR;
        if (dragSortListView2 != null) {
            dragSortListView2.setRemoveListener(new c(this));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            p.hyc();
        }
        p.g(activity, "activity!!");
        FragmentActivity fragmentActivity = activity;
        Bundle arguments = getArguments();
        if (arguments == null) {
            p.hyc();
        }
        ArrayList parcelableArrayList = arguments.getParcelableArrayList("KEY_SORT_DATA_LIST");
        if (parcelableArrayList == null) {
            p.hyc();
        }
        this.oaS = new b(fragmentActivity, parcelableArrayList);
        b bVar = this.oaS;
        if (bVar == null) {
            p.hyc();
        }
        DragSortListView dragSortListView3 = this.oaR;
        if (dragSortListView3 == null) {
            p.hyc();
        }
        p.h(dragSortListView3, "list");
        bVar.oaR = dragSortListView3;
        DragSortListView dragSortListView4 = bVar.oaR;
        if (dragSortListView4 == null) {
            p.hyc();
        }
        dragSortListView4.setAdapter((ListAdapter) bVar);
        AppMethodBeat.o(51211);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "from", "", "to", "drop"})
    static final class b implements DragSortListView.h {
        final /* synthetic */ AppBrandCollectionVerticalSortList oaU;

        b(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.oaU = appBrandCollectionVerticalSortList;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.h
        public final void ey(int i2, int i3) {
            LocalUsageInfo zt;
            AppMethodBeat.i(51204);
            b bVar = this.oaU.oaS;
            if (bVar == null || (zt = bVar.zt(i2)) == null) {
                AppMethodBeat.o(51204);
                return;
            }
            b bVar2 = this.oaU.oaS;
            if (bVar2 != null) {
                bVar2.insert(zt, i3);
                AppMethodBeat.o(51204);
                return;
            }
            AppMethodBeat.o(51204);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "which", "", "remove"})
    static final class c implements DragSortListView.l {
        final /* synthetic */ AppBrandCollectionVerticalSortList oaU;

        c(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.oaU = appBrandCollectionVerticalSortList;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.l
        public final void remove(int i2) {
            AppMethodBeat.i(51205);
            b bVar = this.oaU.oaS;
            if (bVar != null) {
                bVar.zt(i2);
                AppMethodBeat.o(51205);
                return;
            }
            AppMethodBeat.o(51205);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(51212);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.addTextOptionMenu(0, getString(R.string.rt), new d(this), null, t.b.BLACK);
        }
        FragmentActivity activity2 = getActivity();
        if (!(activity2 instanceof MMActivity)) {
            activity2 = null;
        }
        MMActivity mMActivity2 = (MMActivity) activity2;
        if (mMActivity2 != null) {
            mMActivity2.setBackBtn(new e(this), R.raw.actionbar_icon_dark_close);
            AppMethodBeat.o(51212);
            return;
        }
        AppMethodBeat.o(51212);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList oaU;

        d(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.oaU = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(51209);
            f.a aVar = f.kUn;
            f fVar = f.kUm;
            if (fVar == null) {
                p.hyc();
            }
            b bVar = this.oaU.oaS;
            if (bVar == null) {
                p.hyc();
            }
            fVar.a(bVar.kgc, new f.b(this) {
                /* class com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.d.AnonymousClass1 */
                final /* synthetic */ d oaV;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.oaV = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.appusage.f.b, com.tencent.mm.plugin.appbrand.appusage.c.b
                public final void b(LocalUsageInfo localUsageInfo) {
                    AppMethodBeat.i(51206);
                    p.h(localUsageInfo, "info");
                    Bundle arguments = this.oaV.oaU.getArguments();
                    int i2 = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                    Bundle arguments2 = this.oaV.oaU.getArguments();
                    com.tencent.mm.plugin.appbrand.report.l.a(localUsageInfo, 6, i2, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                    AppMethodBeat.o(51206);
                }

                @Override // com.tencent.mm.plugin.appbrand.appusage.f.b, com.tencent.mm.plugin.appbrand.appusage.c.b
                public final void d(LocalUsageInfo localUsageInfo) {
                    AppMethodBeat.i(51207);
                    p.h(localUsageInfo, "info");
                    Bundle arguments = this.oaV.oaU.getArguments();
                    int i2 = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                    Bundle arguments2 = this.oaV.oaU.getArguments();
                    com.tencent.mm.plugin.appbrand.report.l.a(localUsageInfo, 7, i2, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                    AppMethodBeat.o(51207);
                }

                @Override // com.tencent.mm.plugin.appbrand.appusage.f.b
                public final void bxJ() {
                    AppMethodBeat.i(51208);
                    Log.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
                    ((com.tencent.mm.plugin.appbrand.appusage.c) g.af(com.tencent.mm.plugin.appbrand.appusage.c.class)).a(aa.b.CloseCollectionList);
                    FragmentActivity activity = this.oaV.oaU.getActivity();
                    if (activity != null) {
                        activity.finish();
                        AppMethodBeat.o(51208);
                        return;
                    }
                    AppMethodBeat.o(51208);
                }
            });
            AppMethodBeat.o(51209);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList oaU;

        e(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.oaU = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(51210);
            FragmentActivity activity = this.oaU.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(51210);
            return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(180692);
        super.onDestroyView();
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(180692);
    }
}
