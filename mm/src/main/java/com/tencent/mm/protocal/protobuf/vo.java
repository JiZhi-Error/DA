package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class vo extends dop {
    public String CpJ;
    public String CpM;
    public String Cpg;
    public String Cpr;
    public String Cps;
    public String LgC;
    public String nickname;
    public String pWm;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91400);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.yRL);
            if (this.pWm != null) {
                aVar.e(3, this.pWm);
            }
            if (this.CpJ != null) {
                aVar.e(4, this.CpJ);
            }
            if (this.LgC != null) {
                aVar.e(5, this.LgC);
            }
            if (this.Cpr != null) {
                aVar.e(6, this.Cpr);
            }
            if (this.Cps != null) {
                aVar.e(7, this.Cps);
            }
            if (this.CpM != null) {
                aVar.e(8, this.CpM);
            }
            if (this.nickname != null) {
                aVar.e(9, this.nickname);
            }
            if (this.Cpg != null) {
                aVar.e(10, this.Cpg);
            }
            AppMethodBeat.o(91400);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.yRL);
            if (this.pWm != null) {
                nh += g.a.a.b.b.a.f(3, this.pWm);
            }
            if (this.CpJ != null) {
                nh += g.a.a.b.b.a.f(4, this.CpJ);
            }
            if (this.LgC != null) {
                nh += g.a.a.b.b.a.f(5, this.LgC);
            }
            if (this.Cpr != null) {
                nh += g.a.a.b.b.a.f(6, this.Cpr);
            }
            if (this.Cps != null) {
                nh += g.a.a.b.b.a.f(7, this.Cps);
            }
            if (this.CpM != null) {
                nh += g.a.a.b.b.a.f(8, this.CpM);
            }
            if (this.nickname != null) {
                nh += g.a.a.b.b.a.f(9, this.nickname);
            }
            if (this.Cpg != null) {
                nh += g.a.a.b.b.a.f(10, this.Cpg);
            }
            AppMethodBeat.o(91400);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91400);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vo voVar = (vo) objArr[1];
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
                        voVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91400);
                    return 0;
                case 2:
                    voVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91400);
                    return 0;
                case 3:
                    voVar.pWm = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 4:
                    voVar.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 5:
                    voVar.LgC = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 6:
                    voVar.Cpr = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 7:
                    voVar.Cps = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 8:
                    voVar.CpM = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 9:
                    voVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                case 10:
                    voVar.Cpg = aVar3.UbS.readString();
                    AppMethodBeat.o(91400);
                    return 0;
                default:
                    AppMethodBeat.o(91400);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91400);
            return -1;
        }
    }
}
