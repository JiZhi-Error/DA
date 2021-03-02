package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;

public final class e {
    public f lqg;
    public ScreenShotUtil.ScreenShotCallback ogG = new ScreenShotUtil.ScreenShotCallback() {
        /* class com.tencent.mm.plugin.appbrand.utils.e.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
        public final void onScreenShot(String str, long j2) {
            AppMethodBeat.i(219590);
            Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            f fVar = e.this.lqg;
            Log.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", fVar.getAppId());
            new w().g(fVar).bEo();
            AppMethodBeat.o(219590);
        }
    };

    public e() {
        AppMethodBeat.i(135348);
        AppMethodBeat.o(135348);
    }
}
