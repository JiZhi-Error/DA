package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.TenpayCgi;
import com.tencent.kinda.gen.TenpayCgiCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import java.util.HashMap;

public class TenpayCgiImpl implements TenpayCgi {
    private static final String TAG = "WXP";

    @Override // com.tencent.kinda.gen.TenpayCgi
    public void request(int i2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, TenpayCgiCallback tenpayCgiCallback) {
        AppMethodBeat.i(18681);
        String.format("requestTenpay: cgiId:%d", Integer.valueOf(i2));
        NetSceneTenpay netSceneTenpay = new NetSceneTenpay(i2, hashMap, hashMap2, tenpayCgiCallback);
        g.aAi();
        g.aAg().hqi.a(netSceneTenpay, 0);
        String.format("MMCore.getNetSceneQueue().doScene %s", netSceneTenpay);
        AppMethodBeat.o(18681);
    }
}
