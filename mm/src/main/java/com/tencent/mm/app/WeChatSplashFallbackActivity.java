package com.tencent.mm.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.splash.SplashFallbackActivity;

public class WeChatSplashFallbackActivity extends SplashFallbackActivity {
    @Override // com.tencent.mm.splash.SplashFallbackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.splash.SplashFallbackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(160094);
        super.onCreate(bundle);
        setContentView(R.layout.cc2);
        AppMethodBeat.o(160094);
    }
}
