package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
public final class CollectionFolderActivityContext extends FolderActivityContextWithLifecycle implements MStorage.IOnStorageChange {
    private final String TAG = "CollectionFolderActivityContext";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionFolderActivityContext(MMActivity mMActivity) {
        super(mMActivity);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(51263);
        AppMethodBeat.o(51263);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(51258);
        com.tencent.mm.kernel.c.a af = g.af(ag.class);
        p.g(af, "MMKernel.service(IAppBra…ctionStorage::class.java)");
        if (((ag) af).getCount() > 0) {
            getActivity().runOnUiThread(new a(this));
        }
        AppMethodBeat.o(51258);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ CollectionFolderActivityContext oaY;

        a(CollectionFolderActivityContext collectionFolderActivityContext) {
            this.oaY = collectionFolderActivityContext;
        }

        public final void run() {
            AppMethodBeat.i(51257);
            this.oaY.iI(true);
            AppMethodBeat.o(51257);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.a
    public final void iI(boolean z) {
        Class cls;
        AppBrandLauncherBlankPage eJ;
        String str;
        Intent intent;
        Intent intent2;
        AppMethodBeat.i(51259);
        MMActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activity.isFinishing()) {
            AppMethodBeat.o(51259);
            return;
        }
        if (z) {
            cls = AppBrandCollectionDisplayVerticalList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        MMActivity activity2 = getActivity();
        p.g(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (cls.isInstance(activity2.getSupportFragmentManager().findFragmentById(16908290))) {
            AppMethodBeat.o(51259);
            return;
        }
        getActivity().removeAllOptionMenu();
        if (z) {
            getActivity().showActionbarLine();
        } else {
            getActivity().hideActionbarLine();
        }
        MMActivity activity3 = getActivity();
        p.g(activity3, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        k beginTransaction = activity3.getSupportFragmentManager().beginTransaction();
        if (z) {
            eJ = new AppBrandCollectionDisplayVerticalList();
        } else {
            eJ = AppBrandLauncherBlankPage.eJ(getActivity().getString(R.string.qe), getActivity().getString(R.string.jl));
        }
        beginTransaction.b(16908290, eJ).commitAllowingStateLoss();
        ag agVar = (ag) g.af(ag.class);
        MMActivity activity4 = getActivity();
        if (activity4 == null || (intent2 = activity4.getIntent()) == null || (str = intent2.getStringExtra("extra_enter_scene_note")) == null) {
            str = "";
        }
        MMActivity activity5 = getActivity();
        if (!(activity5 == null || (intent = activity5.getIntent()) == null)) {
            int intExtra = intent.getIntExtra("extra_enter_scene", -1);
            Log.i(this.TAG, "EnterScene = ".concat(String.valueOf(intExtra)));
            switch (intExtra) {
                case 1:
                case 3:
                case 4:
                    i.as(intExtra, str);
                    break;
            }
        }
        if (!z) {
            agVar.add(this.TAG + ".WORKER", this);
        } else {
            agVar.remove(this);
        }
        if (z) {
            h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, z.APPBRAND_LAUNCHER);
            h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, z.APPBRAND_LAUNCHER);
        }
        AppMethodBeat.o(51259);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
    public final void S(Intent intent) {
        AppMethodBeat.i(51260);
        View findViewById = getActivity().findViewById(16908290);
        if (findViewById != null) {
            findViewById.setBackgroundColor(-855310);
        }
        iI(true);
        if (intent != null) {
            int intExtra = intent.getIntExtra("extra_get_usage_reason", 7);
            int intExtra2 = intent.getIntExtra("extra_get_usage_prescene", 0);
            af.a aVar = af.kVR;
            af.a.a(intExtra, intExtra2, null, 4);
            AppMethodBeat.o(51260);
            return;
        }
        AppMethodBeat.o(51260);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
    public final void onActivityDidResume() {
        AppMethodBeat.i(51261);
        getActivity().setMMTitle(R.string.qe);
        AppMethodBeat.o(51261);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
    public final void onActivityWillDestroy() {
        AppMethodBeat.i(51262);
        super.onActivityWillDestroy();
        ((ag) g.af(ag.class)).remove(this);
        AppMethodBeat.o(51262);
    }
}
