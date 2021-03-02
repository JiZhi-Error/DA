package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "initActivityCloseAnimation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"})
@i
public final class AppBrandCollectionSortUI extends MMActivity {
    public static final a oaQ = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(51203);
        AppMethodBeat.o(51203);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229555);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229555);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229554);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229554);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        int i2;
        String str = null;
        AppMethodBeat.i(51200);
        super.onCreate(bundle);
        Intent intent = getIntent();
        ArrayList<? extends Parcelable> parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra("KEY_SORT_DATA_LIST") : null;
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            super.finish();
            AppMethodBeat.o(51200);
            return;
        }
        overridePendingTransition(R.anim.n, R.anim.s);
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        getContentView().setBackgroundColor(getActionbarColor());
        k beginTransaction = getSupportFragmentManager().beginTransaction();
        AppBrandCollectionVerticalSortList.a aVar = AppBrandCollectionVerticalSortList.oaT;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            i2 = intent2.getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);
        } else {
            i2 = 0;
        }
        Intent intent3 = getIntent();
        if (intent3 != null) {
            str = intent3.getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
        }
        p.h(parcelableArrayListExtra, "list");
        AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList = new AppBrandCollectionVerticalSortList();
        Bundle bundle2 = new Bundle(1);
        bundle2.putParcelableArrayList("KEY_SORT_DATA_LIST", parcelableArrayListExtra);
        bundle2.putInt("KEY_OPERATE_REPORT_SCENE", i2);
        bundle2.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
        appBrandCollectionVerticalSortList.setArguments(bundle2);
        beginTransaction.b(16908290, appBrandCollectionVerticalSortList).commit();
        AppMethodBeat.o(51200);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(51201);
        super.onResume();
        setMMTitle(R.string.qe);
        hideActionbarLine();
        AppMethodBeat.o(51201);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final void initActivityCloseAnimation() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(51202);
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.o);
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
        }
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.o);
        AppMethodBeat.o(51202);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI$Companion;", "", "()V", "KEY_OPERATE_REPORT_SCENE", "", "KEY_OPERATE_REPORT_SCENE_ID", "KEY_SORT_DATA_LIST", "startSortList", "", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
