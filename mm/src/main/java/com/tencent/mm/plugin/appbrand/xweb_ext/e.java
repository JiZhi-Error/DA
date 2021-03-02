package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e implements s.a {
    public static final e oGK = new e();

    static {
        AppMethodBeat.i(229708);
        AppMethodBeat.o(229708);
    }

    private e() {
    }

    @Override // com.tencent.xweb.s.a
    public final void cdG() {
    }

    @Override // com.tencent.xweb.s.a
    public final void AN(int i2) {
        AppMethodBeat.i(229707);
        if (i2 == 0) {
            boolean z = a.bqV() == 0 && k.isEmpty();
            boolean isMMProcessExist = MMApplicationContext.isMMProcessExist();
            Log.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + z + ", mmProcessAlive:" + isMMProcessExist);
            Log.appenderFlushSync();
            if (z) {
                if (isMMProcessExist) {
                    AppBrandProcessSuicideLogic.buq();
                    AppMethodBeat.o(229707);
                    return;
                }
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
                RuntimeException runtimeException = new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                AppMethodBeat.o(229707);
                throw runtimeException;
            }
        }
        AppMethodBeat.o(229707);
    }

    @Override // com.tencent.xweb.s.a
    public final void AO(int i2) {
    }

    @Override // com.tencent.xweb.s.a
    public final void cdH() {
    }

    @Override // com.tencent.xweb.s.a
    public final void cdI() {
    }
}
