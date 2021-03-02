package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dqi;
import java.util.LinkedList;

public final class b {
    public String AAG;
    public float AAH;
    public int AAI;
    public LinkedList<Integer> AAJ = new LinkedList<>();
    public int AAK;
    public LinkedList<dqi> AAL = new LinkedList<>();
    public float AAM;
    public String AAN;
    public SKBuiltinBuffer_t AAO;
    public chj AAP;
    public String Title;
    public String dPI;
    public int oUv;
    public int showFlag;
    public String yMY;

    public b(String str, chj chj) {
        AppMethodBeat.i(26547);
        this.yMY = str;
        this.AAG = chj.AAG;
        this.Title = chj.Title;
        this.AAH = chj.AAH;
        this.AAI = chj.AAI;
        this.AAJ = chj.AAJ;
        this.AAK = chj.AAK;
        this.AAL = chj.AAL;
        this.AAM = chj.AAM;
        this.AAN = chj.AAN;
        this.oUv = chj.oUv;
        this.AAO = chj.AAO;
        this.showFlag = chj.MmW;
        this.AAP = chj;
        AppMethodBeat.o(26547);
    }
}
