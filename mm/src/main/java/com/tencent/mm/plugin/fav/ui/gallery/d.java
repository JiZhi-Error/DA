package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aml;

public final class d {
    public aml dLo;
    public g qNT;

    public d(g gVar, aml aml) {
        this.qNT = gVar;
        this.dLo = aml;
    }

    public final boolean cWJ() {
        return this.dLo.dataType == 4;
    }

    public final boolean cWK() {
        return (this.dLo.dataType != 4 || this.dLo.Lwh == null || this.dLo.Lwh.Lxi == null) ? false : true;
    }

    public final boolean cWL() {
        return this.dLo.dataType == 15;
    }
}
