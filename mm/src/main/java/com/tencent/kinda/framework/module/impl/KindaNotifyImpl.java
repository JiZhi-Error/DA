package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaNotify;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class KindaNotifyImpl implements KindaNotify {
    public static final String TAG = "MicroMsg.KindaNotifyImpl";

    @Override // com.tencent.kinda.gen.KindaNotify
    public void notify(String str, HashMap<String, String> hashMap) {
        AppMethodBeat.i(18645);
        Log.i(TAG, "key:%s, value:%s", str, hashMap.toString());
        lm lmVar = new lm();
        lmVar.dQO.key = str;
        lmVar.dQO.dQP = hashMap;
        EventCenter.instance.publish(lmVar);
        AppMethodBeat.o(18645);
    }
}
