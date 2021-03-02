package com.tencent.kinda.framework.module.pay;

import com.tencent.kinda.framework.module.impl.TenpayCgiImpl;
import com.tencent.kinda.framework.widget.base.MMMoneyInputText;
import com.tencent.kinda.modularize.KindaModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaPayServiceModule extends KindaModule {
    @Override // com.tencent.kinda.modularize.KindaModule
    public void configModule() {
        AppMethodBeat.i(18706);
        registerView("kMoneyInputText", MMMoneyInputText.class);
        registerNativeModule("TenpayCgi", TenpayCgiImpl.class);
        AppMethodBeat.o(18706);
    }

    @Override // com.tencent.kinda.modularize.KindaModule
    public void onAppCreate() {
    }
}
