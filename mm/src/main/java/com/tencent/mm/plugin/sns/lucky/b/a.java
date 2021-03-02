package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class a {
    public static void c(int i2, SnsInfo snsInfo) {
        AppMethodBeat.i(95196);
        if (snsInfo != null) {
            snsInfo.getTimeLine();
            if (i2 == 2) {
                m.w(snsInfo);
            }
            m.y(snsInfo);
            System.currentTimeMillis();
        }
        AppMethodBeat.o(95196);
    }
}
