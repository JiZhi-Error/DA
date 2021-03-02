package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.lite.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginLiteApp extends f implements a, c, b {
    private g yDY = null;
    private IListener yDZ = null;
    private com.tencent.mm.plugin.lite.b.a yEa = new com.tencent.mm.plugin.lite.b.a();
    private com.tencent.mm.plugin.lite.b.b yEb = new com.tencent.mm.plugin.lite.b.b();

    public PluginLiteApp() {
        AppMethodBeat.i(198808);
        AppMethodBeat.o(198808);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(198809);
        Log.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", gVar.mProcessName);
        if (MMApplicationContext.isLiteProcess()) {
            h.a(MainProcessIPCService.dkO, new Bundle(), com.tencent.mm.plugin.lite.c.a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.lite.PluginLiteApp.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(198807);
                    Bundle bundle2 = bundle;
                    if ((bundle2 != null && bundle2.getBoolean("result")) || WeChatEnvironment.hasDebugger()) {
                        Log.i("MicroMsg.AppLite.PluginLiteApp", "start preload lite process.");
                        com.tencent.f.h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.lite.PluginLiteApp.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(198806);
                                a.yDP.Pv(2);
                                AppMethodBeat.o(198806);
                            }
                        });
                    }
                    AppMethodBeat.o(198807);
                }
            });
        }
        AppMethodBeat.o(198809);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-liteapp";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(146365);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new b());
        AppMethodBeat.o(146365);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(146366);
        Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
        if (MMApplicationContext.isMainProcess()) {
            if (this.yDY == null) {
                this.yDY = new g();
            }
            if (this.yDZ == null) {
                this.yDZ = new com.tencent.mm.plugin.lite.b.d();
                EventCenter.instance.add(this.yDZ);
            }
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.yDY);
            this.yEa.alive();
            this.yEb.alive();
        }
        AppMethodBeat.o(146366);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(146367);
        Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
        if (MMApplicationContext.isMainProcess()) {
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.yDY);
            this.yEa.dead();
            this.yEb.dead();
        }
        AppMethodBeat.o(146367);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(198810);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.lite.PluginLiteApp.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.lite.storage.f.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("LiteAppAuthInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.lite.PluginLiteApp.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.lite.storage.d.SQL_CREATE;
            }
        });
        AppMethodBeat.o(198810);
        return hashMap;
    }
}
