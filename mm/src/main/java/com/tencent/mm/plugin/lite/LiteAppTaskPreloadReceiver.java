package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "Companion", "luggage-lite-app_release"})
public final class LiteAppTaskPreloadReceiver extends BroadcastReceiver {
    public static final a yDT = new a((byte) 0);

    static {
        AppMethodBeat.i(198967);
        AppMethodBeat.o(198967);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "kAppIdKey", "kPathKey", "kPreLoginTask", "kTaskKey", "kUpdateBaseLibPathTask", "luggage-lite-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(198966);
        if (intent == null) {
            Log.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
            AppMethodBeat.o(198966);
            return;
        }
        if (intent.hasExtra("task") && intent.hasExtra("appId") && p.j(intent.getStringExtra("task"), "prelogin")) {
            String stringExtra = intent.getStringExtra("appId");
            f.ecC();
            WxaLiteAppInfo aCT = f.aCT(stringExtra);
            if (aCT == null) {
                Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", stringExtra + " is not existed");
            } else {
                p.h(aCT, "liteAppInfo");
                com.tencent.mm.plugin.lite.jsapi.a.INSTANCE.a(LiteAppCenter.getAuthUrl(aCT.path, aCT.appId, aCT.crh), new b(aCT));
            }
        }
        if (intent.hasExtra("task") && p.j(intent.getStringExtra("task"), "updateBaseLibPath")) {
            Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive set baselib path");
            a.C1457a aVar = a.yDP;
            a.C1457a.ecv();
        }
        AppMethodBeat.o(198966);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006R\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key;", "luggage-lite-app_release"})
    public static final class b implements a.b {
        final /* synthetic */ WxaLiteAppInfo yDU;

        b(WxaLiteAppInfo wxaLiteAppInfo) {
            this.yDU = wxaLiteAppInfo;
        }

        @Override // com.tencent.mm.plugin.lite.jsapi.a.b
        public final void onError() {
            AppMethodBeat.i(198964);
            Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.yDU.appId);
            AppMethodBeat.o(198964);
        }

        @Override // com.tencent.mm.plugin.lite.jsapi.a.b
        public final void a(a.C1460a aVar) {
            AppMethodBeat.i(198965);
            p.h(aVar, "info");
            Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.yDU.appId);
            LiteAppCenter.setAuthInfo(this.yDU.appId, aVar.yEk, aVar.mHeaders, aVar.yEl);
            AppMethodBeat.o(198965);
        }
    }
}
