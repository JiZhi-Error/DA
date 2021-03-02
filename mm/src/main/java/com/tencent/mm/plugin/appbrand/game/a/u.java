package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0007J\r\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class u extends v<Boolean> {
    public static final u lrV = new u();

    static {
        AppMethodBeat.i(50387);
        AppMethodBeat.o(50387);
    }

    private u() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final String bCY() {
        return "wxbct";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final b.a bCZ() {
        return b.a.clicfg_magicbrush_wxbct;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final boolean bDa() {
        return true;
    }

    public static final boolean bDe() {
        AppMethodBeat.i(50386);
        if (!((Boolean) super.aLT()).booleanValue()) {
            Log.i("WAGameConfigWxbct", "getActuallyConfig self == false");
            AppMethodBeat.o(50386);
            return false;
        }
        int intValue = ((Number) a.a(b.a.clicfg_magicbrush_gcfactor, 0)).intValue();
        if (intValue == 0) {
            Log.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
            AppMethodBeat.o(50386);
            return false;
        }
        Log.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + intValue + "], enable wxbct");
        AppMethodBeat.o(50386);
        return true;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Boolean YH(String str) {
        AppMethodBeat.i(50384);
        Boolean YJ = YJ(str);
        AppMethodBeat.o(50384);
        return YJ;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* bridge */ /* synthetic */ Boolean bDb() {
        return Boolean.FALSE;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Boolean aLT() {
        AppMethodBeat.i(50385);
        IllegalStateException illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.o(50385);
        throw illegalStateException;
    }
}
