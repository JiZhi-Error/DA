package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public class WeChatSplashActivity extends SplashActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.splash.SplashActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.splash.SplashActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(160108);
        super.onCreate(bundle);
        MMActivity.initLanguage(getBaseContext());
        AppMethodBeat.o(160108);
    }

    public Resources getResources() {
        AppMethodBeat.i(160109);
        Resources resources = super.getResources();
        AppMethodBeat.o(160109);
        return resources;
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(160110);
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            LayoutInflater b2 = aa.b((LayoutInflater) systemService);
            AppMethodBeat.o(160110);
            return b2;
        }
        AppMethodBeat.o(160110);
        return systemService;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.splash.SplashActivity
    public void onPause() {
        AppMethodBeat.i(160111);
        t.glY();
        super.onPause();
        AppMethodBeat.o(160111);
    }
}
