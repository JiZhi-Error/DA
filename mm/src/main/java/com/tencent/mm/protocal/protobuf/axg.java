package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class axg extends a {
    public int AZq;
    public int AZr;
    public det LHI;
    public int LHJ;
    public int LHK;
    public String LHL;
    public String LHM;
    public det LHN;
    public int LHO;
    public String dCu;
    public String dSJ;
    public int status;
    public String title;
    public String twt;
    public long uko;
    public String ukr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209558);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uko);
            if (this.LHI != null) {
                aVar.ni(2, this.LHI.computeSize());
                this.LHI.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.twt != null) {
                aVar.e(4, this.twt);
            }
            aVar.aM(5, this.LHJ);
            aVar.aM(6, this.AZr);
            aVar.aM(7, this.AZq);
            aVar.aM(8, this.LHK);
            if (this.LHL != null) {
                aVar.e(9, this.LHL);
            }
            if (this.LHM != null) {
                aVar.e(10, this.LHM);
            }
            aVar.aM(11, this.status);
            if (this.LHN != null) {
                aVar.ni(12, this.LHN.computeSize());
                this.LHN.writeFields(aVar);
            }
            aVar.aM(13, this.LHO);
            if (this.dSJ != null) {
                aVar.e(14, this.dSJ);
            }
            if (this.dCu != null) {
                aVar.e(15, this.dCu);
            }
            if (this.ukr != null) {
                aVar.e(16, this.ukr);
            }
            AppMethodBeat.o(209558);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uko) + 0;
            if (this.LHI != null) {
                r += g.a.a.a.nh(2, this.LHI.computeSize());
            }
            if (this.title != null) {
                r += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.twt != null) {
                r += g.a.a.b.b.a.f(4, this.twt);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.LHJ) + g.a.a.b.b.a.bu(6, this.AZr) + g.a.a.b.b.a.bu(7, this.AZq) + g.a.a.b.b.a.bu(8, this.LHK);
            if (this.LHL != null) {
                bu += g.a.a.b.b.a.f(9, this.LHL);
            }
            if (this.LHM != null) {
                bu += g.a.a.b.b.a.f(10, this.LHM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.status);
            if (this.LHN != null) {
                bu2 += g.a.a.a.nh(12, this.LHN.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.LHO);
            if (this.dSJ != null) {
                bu3 += g.a.a.b.b.a.f(14, this.dSJ);
            }
            if (this.dCu != null) {
                bu3 += g.a.a.b.b.a.f(15, this.dCu);
            }
            if (this.ukr != null) {
                bu3 += g.a.a.b.b.a.f(16, this.ukr);
            }
            AppMethodBeat.o(209558);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209558);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axg axg = (axg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axg.uko = aVar3.UbS.zl();
                    AppMethodBeat.o(209558);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        det det = new det();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = det.populateBuilderWithField(aVar4, det, a.getNextFieldNumber(aVar4))) {
                        }
                        axg.LHI = det;
                    }
                    AppMethodBeat.o(209558);
                    return 0;
                case 3:
                    axg.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 4:
                    axg.twt = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 5:
                    axg.LHJ = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 6:
                    axg.AZr = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 7:
                    axg.AZq = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 8:
                    axg.LHK = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 9:
                    axg.LHL = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 10:
                    axg.LHM = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 11:
                    axg.status = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        det det2 = new det();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = det2.populateBuilderWithField(aVar5, det2, a.getNextFieldNumber(aVar5))) {
                        }
                        axg.LHN = det2;
                    }
                    AppMethodBeat.o(209558);
                    return 0;
                case 13:
                    axg.LHO = aVar3.UbS.zi();
                    AppMethodBeat.o(209558);
                    return 0;
                case 14:
                    axg.dSJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 15:
                    axg.dCu = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                case 16:
                    axg.ukr = aVar3.UbS.readString();
                    AppMethodBeat.o(209558);
                    return 0;
                default:
                    AppMethodBeat.o(209558);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209558);
            return -1;
        }
    }
}
