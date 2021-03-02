package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.ui.MMActivity;

public class RecentsFolderActivityContext extends FolderActivityContextWithLifecycle {
    private int lvW = 0;
    private int odL;
    private String odM;

    public RecentsFolderActivityContext(MMActivity mMActivity) {
        super(mMActivity);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.a
    public final void iI(boolean z) {
        Class cls;
        AppBrandLauncherUI.Fragment eJ;
        AppMethodBeat.i(49228);
        if (z) {
            cls = AppBrandLauncherRecentsList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        Fragment findFragmentById = ((MMActivity) getBaseContext()).getSupportFragmentManager().findFragmentById(16908290);
        if (findFragmentById != null && cls.isInstance(findFragmentById)) {
            AppMethodBeat.o(49228);
        } else if (((MMActivity) getBaseContext()).isFinishing() || ((MMActivity) getBaseContext()).activityHasDestroyed() || ((MMActivity) getBaseContext()).isStopped()) {
            AppMethodBeat.o(49228);
        } else {
            k beginTransaction = ((MMActivity) getBaseContext()).getSupportFragmentManager().beginTransaction();
            if (z) {
                eJ = new AppBrandLauncherRecentsList(((MMActivity) getBaseContext()) instanceof AppBrandLauncherUI);
            } else {
                eJ = AppBrandLauncherBlankPage.eJ(getString(R.string.ko), getString(R.string.n8));
            }
            eJ.setScene(this.odL);
            eJ.nTU = this.odM;
            beginTransaction.b(16908290, eJ);
            beginTransaction.commit();
            AppMethodBeat.o(49228);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
    public final void S(Intent intent) {
        AppMethodBeat.i(49229);
        this.odL = intent.getIntExtra("extra_enter_scene", 1);
        this.odM = intent.getStringExtra("extra_enter_scene_note");
        AppMethodBeat.o(49229);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDidResume() {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext.onActivityDidResume():void");
    }
}
