package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;

/* access modifiers changed from: package-private */
public final class bg {
    String DPl;
    String dHp;
    cnb ebR;
    int gqU;
    int gqW;
    int iXu;
    String jpT;

    bg() {
    }

    public final String toString() {
        AppMethodBeat.i(96062);
        String str = "cdnMediaId " + this.jpT + " isPlayMode " + this.gqU + " createTime " + this.iXu + " snsLocalId " + this.dHp + " postName " + this.DPl + " url " + this.ebR.Url;
        AppMethodBeat.o(96062);
        return str;
    }
}
