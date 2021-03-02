package com.tencent.mm.plugin.hld;

import com.google.android.gms.common.Scopes;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/hld/PluginHld;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-hld_release"})
public final class PluginHld extends f implements c, d {
    public static final a yjr = new a((byte) 0);

    static {
        AppMethodBeat.i(192240);
        AppMethodBeat.o(192240);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/hld/PluginHld$Companion;", "", "()V", "CLASS", "", "TAG", "plugin-hld_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(192236);
        Log.i("WxIme.WxImePlugin", "execute");
        if (gVar != null) {
            if (gVar.aBb()) {
                com.tencent.mm.plugin.hld.a.a aVar = com.tencent.mm.plugin.hld.a.a.UXi;
                if (!com.tencent.mm.plugin.hld.a.a.hVR()) {
                    com.tencent.mm.plugin.hld.b.a aVar2 = com.tencent.mm.plugin.hld.b.a.UXp;
                    MultiProcessMMKV kv = com.tencent.mm.plugin.hld.b.a.getKV();
                    if (kv == null || !kv.getBoolean("ime_if_report_client_environment", false)) {
                        h.RTc.aX(a.RunnableC1435a.UXj);
                    } else {
                        AppMethodBeat.o(192236);
                        return;
                    }
                }
            }
            AppMethodBeat.o(192236);
            return;
        }
        AppMethodBeat.o(192236);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-hld";
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(192237);
        Log.d("WxIme.WxImePlugin", "configure");
        AppMethodBeat.o(192237);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(192238);
        Log.d("WxIme.WxImePlugin", "onAccountInitialized");
        AppMethodBeat.o(192238);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(192239);
        Log.d("WxIme.WxImePlugin", "onAccountRelease");
        AppMethodBeat.o(192239);
    }
}
