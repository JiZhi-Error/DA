package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dyd extends dpc {
    public String MTK;
    public hr MVQ;
    public int MXG;
    public hq MXH;
    public LinkedList<hs> MXI = new LinkedList<>();
    public String MXJ;
    public String MXK;
    public ht MXL;
    public LinkedList<ht> MXM = new LinkedList<>();
    public eqk MXN;
    public boolean MXO;
    public String MXP;
    public hp MXQ;
    public String Mzt;
    public String dHx;
    public String ixZ;
    public String title;

    public dyd() {
        AppMethodBeat.i(123652);
        AppMethodBeat.o(123652);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123653);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123653);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MVQ != null) {
                aVar.ni(2, this.MVQ.computeSize());
                this.MVQ.writeFields(aVar);
            }
            aVar.aM(3, this.MXG);
            if (this.MXH != null) {
                aVar.ni(4, this.MXH.computeSize());
                this.MXH.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.Mzt != null) {
                aVar.e(6, this.Mzt);
            }
            if (this.ixZ != null) {
                aVar.e(7, this.ixZ);
            }
            if (this.MTK != null) {
                aVar.e(8, this.MTK);
            }
            aVar.e(9, 8, this.MXI);
            if (this.MXJ != null) {
                aVar.e(10, this.MXJ);
            }
            if (this.MXK != null) {
                aVar.e(11, this.MXK);
            }
            if (this.MXL != null) {
                aVar.ni(12, this.MXL.computeSize());
                this.MXL.writeFields(aVar);
            }
            aVar.e(13, 8, this.MXM);
            if (this.dHx != null) {
                aVar.e(14, this.dHx);
            }
            if (this.MXN != null) {
                aVar.ni(15, this.MXN.computeSize());
                this.MXN.writeFields(aVar);
            }
            aVar.cc(16, this.MXO);
            if (this.MXP != null) {
                aVar.e(17, this.MXP);
            }
            if (this.MXQ != null) {
                aVar.ni(19, this.MXQ.computeSize());
                this.MXQ.writeFields(aVar);
            }
            AppMethodBeat.o(123653);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MVQ != null) {
                nh += g.a.a.a.nh(2, this.MVQ.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MXG);
            if (this.MXH != null) {
                bu += g.a.a.a.nh(4, this.MXH.computeSize());
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(5, this.title);
            }
            if (this.Mzt != null) {
                bu += g.a.a.b.b.a.f(6, this.Mzt);
            }
            if (this.ixZ != null) {
                bu += g.a.a.b.b.a.f(7, this.ixZ);
            }
            if (this.MTK != null) {
                bu += g.a.a.b.b.a.f(8, this.MTK);
            }
            int c2 = bu + g.a.a.a.c(9, 8, this.MXI);
            if (this.MXJ != null) {
                c2 += g.a.a.b.b.a.f(10, this.MXJ);
            }
            if (this.MXK != null) {
                c2 += g.a.a.b.b.a.f(11, this.MXK);
            }
            if (this.MXL != null) {
                c2 += g.a.a.a.nh(12, this.MXL.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(13, 8, this.MXM);
            if (this.dHx != null) {
                c3 += g.a.a.b.b.a.f(14, this.dHx);
            }
            if (this.MXN != null) {
                c3 += g.a.a.a.nh(15, this.MXN.computeSize());
            }
            int fS = c3 + g.a.a.b.b.a.fS(16) + 1;
            if (this.MXP != null) {
                fS += g.a.a.b.b.a.f(17, this.MXP);
            }
            if (this.MXQ != null) {
                fS += g.a.a.a.nh(19, this.MXQ.computeSize());
            }
            AppMethodBeat.o(123653);
            return fS;
        } else if (i2 == 2) {
            this.MXI.clear();
            this.MXM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123653);
                throw bVar2;
            }
            AppMethodBeat.o(123653);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyd dyd = (dyd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        dyd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        hr hrVar = new hr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = hrVar.populateBuilderWithField(aVar5, hrVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dyd.MVQ = hrVar;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 3:
                    dyd.MXG = aVar3.UbS.zi();
                    AppMethodBeat.o(123653);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        hq hqVar = new hq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = hqVar.populateBuilderWithField(aVar6, hqVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dyd.MXH = hqVar;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 5:
                    dyd.title = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 6:
                    dyd.Mzt = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 7:
                    dyd.ixZ = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 8:
                    dyd.MTK = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        hs hsVar = new hs();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = hsVar.populateBuilderWithField(aVar7, hsVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dyd.MXI.add(hsVar);
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 10:
                    dyd.MXJ = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 11:
                    dyd.MXK = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ht htVar = new ht();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = htVar.populateBuilderWithField(aVar8, htVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dyd.MXL = htVar;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ht htVar2 = new ht();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = htVar2.populateBuilderWithField(aVar9, htVar2, dpc.getNextFieldNumber(aVar9))) {
                        }
                        dyd.MXM.add(htVar2);
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 14:
                    dyd.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        eqk eqk = new eqk();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = eqk.populateBuilderWithField(aVar10, eqk, dpc.getNextFieldNumber(aVar10))) {
                        }
                        dyd.MXN = eqk;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
                case 16:
                    dyd.MXO = aVar3.UbS.yZ();
                    AppMethodBeat.o(123653);
                    return 0;
                case 17:
                    dyd.MXP = aVar3.UbS.readString();
                    AppMethodBeat.o(123653);
                    return 0;
                case 18:
                default:
                    AppMethodBeat.o(123653);
                    return -1;
                case 19:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        hp hpVar = new hp();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = hpVar.populateBuilderWithField(aVar11, hpVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        dyd.MXQ = hpVar;
                    }
                    AppMethodBeat.o(123653);
                    return 0;
            }
        } else {
            AppMethodBeat.o(123653);
            return -1;
        }
    }
}
