package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMBaseActivity extends HellActivity {
    private boolean mIsPaused;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public Resources getResources() {
        AppMethodBeat.i(141354);
        if (getAssets() == null || MMApplicationContext.getResources() == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(141354);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(141354);
        return resources2;
    }

    public final Resources getOriginalResources() {
        AppMethodBeat.i(175957);
        Resources resources = super.getResources();
        AppMethodBeat.o(175957);
        return resources;
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(141355);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.o(141355);
            return systemService;
        }
        LayoutInflater b2 = aa.b((LayoutInflater) systemService);
        AppMethodBeat.o(141355);
        return b2;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(141356);
        super.onDestroy();
        AppMethodBeat.o(141356);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(141357);
        this.mIsPaused = false;
        super.onResume();
        AppMethodBeat.o(141357);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(141358);
        this.mIsPaused = true;
        super.onPause();
        AppMethodBeat.o(141358);
    }

    public void setRequestedOrientation(int i2) {
        AppMethodBeat.i(141359);
        if (!AndroidOSafety.safety(this, i2)) {
            Log.e("MicroMsg.MMBaseActivity", "AndroidOSafety.safety false ignore setRequestedOrientation %s for activity %s", Integer.valueOf(i2), this);
            AppMethodBeat.o(141359);
            return;
        }
        Log.d("MicroMsg.MMBaseActivity", "setRequestedOrientation %s, %s", this, Integer.valueOf(i2));
        try {
            super.setRequestedOrientation(i2);
            AppMethodBeat.o(141359);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMBaseActivity", th, "AndroidOSafety.safety uncaught", new Object[0]);
            AppMethodBeat.o(141359);
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(141360);
        super.startActivityForResult(intent, i2);
        AppMethodBeat.o(141360);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(141361);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i2), bundle)) {
            AppMethodBeat.o(141361);
            return;
        }
        super.startActivityForResult(intent, i2, bundle);
        AppMethodBeat.o(141361);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(141362);
        super.startActivity(intent);
        AppMethodBeat.o(141362);
    }

    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.i(141363);
        super.startActivities(intentArr);
        AppMethodBeat.o(141363);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.i(141364);
        if (d.a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.o(141364);
            return;
        }
        super.startActivities(intentArr, bundle);
        AppMethodBeat.o(141364);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.i(141365);
        super.startActivity(intent, bundle);
        AppMethodBeat.o(141365);
    }

    public WindowManager getWindowManager() {
        AppMethodBeat.i(141366);
        if (!isDestroyed()) {
            WindowManager windowManager = super.getWindowManager();
            AppMethodBeat.o(141366);
            return windowManager;
        }
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 2 && stackTrace[1].getMethodName().equals("handleDestroyActivity")) {
                WindowManager a2 = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
                AppMethodBeat.o(141366);
                return a2;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.MMBaseActivity", th.getMessage());
        }
        WindowManager windowManager2 = super.getWindowManager();
        AppMethodBeat.o(141366);
        return windowManager2;
    }
}
