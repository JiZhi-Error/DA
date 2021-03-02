package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cki extends a {
    public LinkedList<vk> LSL = new LinkedList<>();
    public String MpG;
    public boolean MpH;
    public iu MpI;
    public String MpJ;
    public boolean MpK;
    public int MpL;
    public String MpM;
    public int MpN;
    public ehw MpO;
    public acl MpP;
    public String MpQ;
    public String MpR;

    public cki() {
        AppMethodBeat.i(91533);
        AppMethodBeat.o(91533);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91534);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MpG != null) {
                aVar.e(1, this.MpG);
            }
            aVar.e(2, 8, this.LSL);
            aVar.cc(3, this.MpH);
            if (this.MpI != null) {
                aVar.ni(4, this.MpI.computeSize());
                this.MpI.writeFields(aVar);
            }
            if (this.MpJ != null) {
                aVar.e(5, this.MpJ);
            }
            aVar.cc(6, this.MpK);
            aVar.aM(7, this.MpL);
            if (this.MpM != null) {
                aVar.e(8, this.MpM);
            }
            aVar.aM(9, this.MpN);
            if (this.MpO != null) {
                aVar.ni(10, this.MpO.computeSize());
                this.MpO.writeFields(aVar);
            }
            if (this.MpP != null) {
                aVar.ni(11, this.MpP.computeSize());
                this.MpP.writeFields(aVar);
            }
            if (this.MpQ != null) {
                aVar.e(12, this.MpQ);
            }
            if (this.MpR != null) {
                aVar.e(13, this.MpR);
            }
            AppMethodBeat.o(91534);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MpG != null ? g.a.a.b.b.a.f(1, this.MpG) + 0 : 0) + g.a.a.a.c(2, 8, this.LSL) + g.a.a.b.b.a.fS(3) + 1;
            if (this.MpI != null) {
                f2 += g.a.a.a.nh(4, this.MpI.computeSize());
            }
            if (this.MpJ != null) {
                f2 += g.a.a.b.b.a.f(5, this.MpJ);
            }
            int fS = f2 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.bu(7, this.MpL);
            if (this.MpM != null) {
                fS += g.a.a.b.b.a.f(8, this.MpM);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.MpN);
            if (this.MpO != null) {
                bu += g.a.a.a.nh(10, this.MpO.computeSize());
            }
            if (this.MpP != null) {
                bu += g.a.a.a.nh(11, this.MpP.computeSize());
            }
            if (this.MpQ != null) {
                bu += g.a.a.b.b.a.f(12, this.MpQ);
            }
            if (this.MpR != null) {
                bu += g.a.a.b.b.a.f(13, this.MpR);
            }
            AppMethodBeat.o(91534);
            return bu;
        } else if (i2 == 2) {
            this.LSL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91534);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cki cki = (cki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cki.MpG = aVar3.UbS.readString();
                    AppMethodBeat.o(91534);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        vk vkVar = new vk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vkVar.populateBuilderWithField(aVar4, vkVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cki.LSL.add(vkVar);
                    }
                    AppMethodBeat.o(91534);
                    return 0;
                case 3:
                    cki.MpH = aVar3.UbS.yZ();
                    AppMethodBeat.o(91534);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        iu iuVar = new iu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iuVar.populateBuilderWithField(aVar5, iuVar, a.getNextFieldNumber(aVar5))) {
                        }
                        cki.MpI = iuVar;
                    }
                    AppMethodBeat.o(91534);
                    return 0;
                case 5:
                    cki.MpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91534);
                    return 0;
                case 6:
                    cki.MpK = aVar3.UbS.yZ();
                    AppMethodBeat.o(91534);
                    return 0;
                case 7:
                    cki.MpL = aVar3.UbS.zi();
                    AppMethodBeat.o(91534);
                    return 0;
                case 8:
                    cki.MpM = aVar3.UbS.readString();
                    AppMethodBeat.o(91534);
                    return 0;
                case 9:
                    cki.MpN = aVar3.UbS.zi();
                    AppMethodBeat.o(91534);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehw ehw = new ehw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehw.populateBuilderWithField(aVar6, ehw, a.getNextFieldNumber(aVar6))) {
                        }
                        cki.MpO = ehw;
                    }
                    AppMethodBeat.o(91534);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        acl acl = new acl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = acl.populateBuilderWithField(aVar7, acl, a.getNextFieldNumber(aVar7))) {
                        }
                        cki.MpP = acl;
                    }
                    AppMethodBeat.o(91534);
                    return 0;
                case 12:
                    cki.MpQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91534);
                    return 0;
                case 13:
                    cki.MpR = aVar3.UbS.readString();
                    AppMethodBeat.o(91534);
                    return 0;
                default:
                    AppMethodBeat.o(91534);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91534);
            return -1;
        }
    }
}
