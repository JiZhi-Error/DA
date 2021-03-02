package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\r\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigUseHardDecode;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class p extends v<Boolean> {
    public static final p lrQ = new p();

    static {
        AppMethodBeat.i(228209);
        AppMethodBeat.o(228209);
    }

    private p() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final String bCY() {
        return "hw-decode";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final b.a bCZ() {
        return b.a.clicfg_android_wxa_use_hard_decode;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final boolean bDa() {
        return true;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Boolean YH(String str) {
        AppMethodBeat.i(228208);
        Boolean YJ = YJ(str);
        AppMethodBeat.o(228208);
        return YJ;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* bridge */ /* synthetic */ Boolean bDb() {
        return Boolean.TRUE;
    }
}
