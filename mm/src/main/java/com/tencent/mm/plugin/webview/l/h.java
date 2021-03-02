package com.tencent.mm.plugin.webview.l;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, hxF = {"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"})
public final class h {
    static final MultiProcessMMKV cdi() {
        AppMethodBeat.i(82933);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webcompt_command");
        p.g(mmkv, "MultiProcessMMKV.getMMKV(\"__webcompt_command\")");
        AppMethodBeat.o(82933);
        return mmkv;
    }

    static final void showToast(String str) {
        AppMethodBeat.i(82934);
        if (fZP()) {
            MMHandlerThread.postToMainThread(new a(str));
        }
        Log.i("WebComptCommand", str);
        AppMethodBeat.o(82934);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ String grJ;

        a(String str) {
            this.grJ = str;
        }

        public final void run() {
            AppMethodBeat.i(82932);
            Toast.makeText(MMApplicationContext.getContext(), this.grJ, 0).show();
            AppMethodBeat.o(82932);
        }
    }

    static final boolean fZP() {
        AppMethodBeat.i(82935);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || (Log.getLogLevel() == 0 && WeChatEnvironment.hasDebugger())) {
            AppMethodBeat.o(82935);
            return true;
        }
        AppMethodBeat.o(82935);
        return false;
    }
}
