package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ame extends dop {
    public String Bri;
    public float LbC;
    public float LbD;
    public String LuS;
    public int LuT;
    public String LuU;
    public String LuV;
    public int LuW;
    public int OpCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32207);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            if (this.LuS != null) {
                aVar.e(3, this.LuS);
            }
            aVar.E(4, this.LbC);
            aVar.E(5, this.LbD);
            aVar.aM(6, this.LuT);
            if (this.LuU != null) {
                aVar.e(7, this.LuU);
            }
            if (this.LuV != null) {
                aVar.e(8, this.LuV);
            }
            aVar.aM(9, this.LuW);
            if (this.Bri != null) {
                aVar.e(10, this.Bri);
            }
            AppMethodBeat.o(32207);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode);
            if (this.LuS != null) {
                nh += g.a.a.b.b.a.f(3, this.LuS);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.bu(6, this.LuT);
            if (this.LuU != null) {
                fS += g.a.a.b.b.a.f(7, this.LuU);
            }
            if (this.LuV != null) {
                fS += g.a.a.b.b.a.f(8, this.LuV);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.LuW);
            if (this.Bri != null) {
                bu += g.a.a.b.b.a.f(10, this.Bri);
            }
            AppMethodBeat.o(32207);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32207);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ame ame = (ame) objArr[1];
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
                        ame.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32207);
                    return 0;
                case 2:
                    ame.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(32207);
                    return 0;
                case 3:
                    ame.LuS = aVar3.UbS.readString();
                    AppMethodBeat.o(32207);
                    return 0;
                case 4:
                    ame.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32207);
                    return 0;
                case 5:
                    ame.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32207);
                    return 0;
                case 6:
                    ame.LuT = aVar3.UbS.zi();
                    AppMethodBeat.o(32207);
                    return 0;
                case 7:
                    ame.LuU = aVar3.UbS.readString();
                    AppMethodBeat.o(32207);
                    return 0;
                case 8:
                    ame.LuV = aVar3.UbS.readString();
                    AppMethodBeat.o(32207);
                    return 0;
                case 9:
                    ame.LuW = aVar3.UbS.zi();
                    AppMethodBeat.o(32207);
                    return 0;
                case 10:
                    ame.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(32207);
                    return 0;
                default:
                    AppMethodBeat.o(32207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32207);
            return -1;
        }
    }
}
