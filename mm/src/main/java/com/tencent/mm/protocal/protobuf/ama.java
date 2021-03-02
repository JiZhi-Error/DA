package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ama extends dop {
    public String KRB;
    public long LuJ;
    public String LuK;
    public String LuL;
    public int LuM;
    public float LuN;
    public int LuO;
    public String dNI;
    public int sPV;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104363);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.bb(3, this.LuJ);
            if (this.KRB != null) {
                aVar.e(4, this.KRB);
            }
            if (this.LuK != null) {
                aVar.e(5, this.LuK);
            }
            if (this.LuL != null) {
                aVar.e(6, this.LuL);
            }
            aVar.aM(7, this.source);
            aVar.aM(8, this.LuM);
            aVar.aM(9, this.sPV);
            aVar.E(10, this.LuN);
            aVar.aM(11, this.LuO);
            AppMethodBeat.o(104363);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.LuJ);
            if (this.KRB != null) {
                r += g.a.a.b.b.a.f(4, this.KRB);
            }
            if (this.LuK != null) {
                r += g.a.a.b.b.a.f(5, this.LuK);
            }
            if (this.LuL != null) {
                r += g.a.a.b.b.a.f(6, this.LuL);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.source) + g.a.a.b.b.a.bu(8, this.LuM) + g.a.a.b.b.a.bu(9, this.sPV) + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.bu(11, this.LuO);
            AppMethodBeat.o(104363);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104363);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ama ama = (ama) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ama.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104363);
                    return 0;
                case 2:
                    ama.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(104363);
                    return 0;
                case 3:
                    ama.LuJ = aVar3.UbS.zl();
                    AppMethodBeat.o(104363);
                    return 0;
                case 4:
                    ama.KRB = aVar3.UbS.readString();
                    AppMethodBeat.o(104363);
                    return 0;
                case 5:
                    ama.LuK = aVar3.UbS.readString();
                    AppMethodBeat.o(104363);
                    return 0;
                case 6:
                    ama.LuL = aVar3.UbS.readString();
                    AppMethodBeat.o(104363);
                    return 0;
                case 7:
                    ama.source = aVar3.UbS.zi();
                    AppMethodBeat.o(104363);
                    return 0;
                case 8:
                    ama.LuM = aVar3.UbS.zi();
                    AppMethodBeat.o(104363);
                    return 0;
                case 9:
                    ama.sPV = aVar3.UbS.zi();
                    AppMethodBeat.o(104363);
                    return 0;
                case 10:
                    ama.LuN = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(104363);
                    return 0;
                case 11:
                    ama.LuO = aVar3.UbS.zi();
                    AppMethodBeat.o(104363);
                    return 0;
                default:
                    AppMethodBeat.o(104363);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104363);
            return -1;
        }
    }
}
