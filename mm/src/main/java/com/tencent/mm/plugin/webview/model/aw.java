package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class aw {
    public static aw IZA = new aw();
    public f ISw = null;
    public boolean hasInit;

    static {
        AppMethodBeat.i(79045);
        AppMethodBeat.o(79045);
    }

    private aw() {
    }

    public static aw gcU() {
        return IZA;
    }

    public final void setNetWorkState(int i2) {
        AppMethodBeat.i(79044);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(this.ISw == null);
        Log.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", objArr);
        if (this.ISw != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i2);
            try {
                this.ISw.j(5005, bundle);
                AppMethodBeat.o(79044);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(79044);
    }
}
