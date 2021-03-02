package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.sdk.event.EventCenter;

public class KindaResultImpl implements IKindaResult {
    @Override // com.tencent.kinda.gen.IKindaResult
    public void apppayEnd(int i2, String str) {
        AppMethodBeat.i(18646);
        aaa aaa = new aaa();
        if (i2 == 0) {
            aaa.egJ.result = -1;
        } else {
            aaa.egJ.result = 0;
        }
        aaa.egJ.dDL = str;
        EventCenter.instance.publish(aaa);
        AppMethodBeat.o(18646);
    }
}
