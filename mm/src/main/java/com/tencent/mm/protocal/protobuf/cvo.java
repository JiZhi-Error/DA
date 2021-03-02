package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cvo extends dop {
    public String HQc;
    public String KPu;
    public String KPv;
    public boolean MAR;
    public String MAS;
    public String MAT;
    public int MAU;
    public String MAV;
    public String dDj;
    public int dUS;
    public int eaQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72530);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KPu != null) {
                aVar.e(2, this.KPu);
            }
            if (this.KPv != null) {
                aVar.e(3, this.KPv);
            }
            if (this.MAS != null) {
                aVar.e(4, this.MAS);
            }
            if (this.MAT != null) {
                aVar.e(5, this.MAT);
            }
            if (this.HQc != null) {
                aVar.e(6, this.HQc);
            }
            if (this.dDj != null) {
                aVar.e(7, this.dDj);
            }
            aVar.aM(8, this.dUS);
            aVar.aM(9, this.MAU);
            aVar.cc(10, this.MAR);
            aVar.aM(11, this.eaQ);
            if (this.MAV != null) {
                aVar.e(12, this.MAV);
            }
            AppMethodBeat.o(72530);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPu != null) {
                nh += g.a.a.b.b.a.f(2, this.KPu);
            }
            if (this.KPv != null) {
                nh += g.a.a.b.b.a.f(3, this.KPv);
            }
            if (this.MAS != null) {
                nh += g.a.a.b.b.a.f(4, this.MAS);
            }
            if (this.MAT != null) {
                nh += g.a.a.b.b.a.f(5, this.MAT);
            }
            if (this.HQc != null) {
                nh += g.a.a.b.b.a.f(6, this.HQc);
            }
            if (this.dDj != null) {
                nh += g.a.a.b.b.a.f(7, this.dDj);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.dUS) + g.a.a.b.b.a.bu(9, this.MAU) + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.bu(11, this.eaQ);
            if (this.MAV != null) {
                bu += g.a.a.b.b.a.f(12, this.MAV);
            }
            AppMethodBeat.o(72530);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72530);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvo cvo = (cvo) objArr[1];
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
                        cvo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72530);
                    return 0;
                case 2:
                    cvo.KPu = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 3:
                    cvo.KPv = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 4:
                    cvo.MAS = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 5:
                    cvo.MAT = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 6:
                    cvo.HQc = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 7:
                    cvo.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                case 8:
                    cvo.dUS = aVar3.UbS.zi();
                    AppMethodBeat.o(72530);
                    return 0;
                case 9:
                    cvo.MAU = aVar3.UbS.zi();
                    AppMethodBeat.o(72530);
                    return 0;
                case 10:
                    cvo.MAR = aVar3.UbS.yZ();
                    AppMethodBeat.o(72530);
                    return 0;
                case 11:
                    cvo.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(72530);
                    return 0;
                case 12:
                    cvo.MAV = aVar3.UbS.readString();
                    AppMethodBeat.o(72530);
                    return 0;
                default:
                    AppMethodBeat.o(72530);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72530);
            return -1;
        }
    }
}
