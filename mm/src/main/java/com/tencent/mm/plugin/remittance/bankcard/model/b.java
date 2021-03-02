package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Comparator;

public final class b implements Comparator<jg> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(jg jgVar, jg jgVar2) {
        char aLU;
        char aLU2;
        AppMethodBeat.i(67399);
        jg jgVar3 = jgVar;
        jg jgVar4 = jgVar2;
        if (Util.isNullOrNil(jgVar3.ynT) || Util.isNullOrNil(jgVar4.ynT)) {
            if (!Util.isNullOrNil(jgVar3.ynT) || !Util.isNullOrNil(jgVar4.ynT)) {
                if (Util.isNullOrNil(jgVar3.ynT)) {
                    AppMethodBeat.o(67399);
                    return 1;
                } else if (Util.isNullOrNil(jgVar4.ynT)) {
                    AppMethodBeat.o(67399);
                    return -1;
                }
            }
            AppMethodBeat.o(67399);
            return 0;
        }
        if (!Util.isNullOrNil(jgVar3.KNP)) {
            aLU = jgVar3.KNP.toUpperCase().charAt(0);
        } else {
            aLU = a.aLU(jgVar3.ynT);
        }
        if (!Util.isNullOrNil(jgVar4.KNP)) {
            aLU2 = jgVar4.KNP.toUpperCase().charAt(0);
        } else {
            aLU2 = a.aLU(jgVar4.ynT);
        }
        if (aLU < aLU2) {
            AppMethodBeat.o(67399);
            return -1;
        } else if (aLU > aLU2) {
            AppMethodBeat.o(67399);
            return 1;
        } else {
            AppMethodBeat.o(67399);
            return 0;
        }
    }
}
