package com.tencent.mm.plugin.appbrand.game.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigNativeBufferType;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getConfigDefaultValue", "onProcessConfig", "input", "plugin-appbrand-integration_release"})
public final class h extends v<String> {
    public static final h lrE = new h();

    static {
        AppMethodBeat.i(50373);
        AppMethodBeat.o(50373);
    }

    private h() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* bridge */ /* synthetic */ String YH(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final String bCY() {
        return "nativebuffertype";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final b.a bCZ() {
        return b.a.clicfg_android_appbrand_native_buffer_use_native;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* bridge */ /* synthetic */ String bDb() {
        return AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }
}
