package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqc extends dop {
    public aov LAI;
    public String LBY;
    public b LBZ;
    public LinkedList<bdu> LCa = new LinkedList<>();
    public axk LCb;
    public int LCc;
    public LinkedList<String> LCd = new LinkedList<>();
    public LinkedList<String> Viw = new LinkedList<>();
    public LinkedList<String> Vix = new LinkedList<>();
    public LinkedList<String> Viy = new LinkedList<>();
    public int businessType;
    public String clientId;
    public String finderUsername;
    public FinderObjectDesc objectDesc;
    public int scene;

    public aqc() {
        AppMethodBeat.i(209369);
        AppMethodBeat.o(209369);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209370);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LAI != null) {
                aVar.ni(2, this.LAI.computeSize());
                this.LAI.writeFields(aVar);
            }
            if (this.finderUsername != null) {
                aVar.e(3, this.finderUsername);
            }
            if (this.objectDesc != null) {
                aVar.ni(4, this.objectDesc.computeSize());
                this.objectDesc.writeFields(aVar);
            }
            if (this.clientId != null) {
                aVar.e(5, this.clientId);
            }
            if (this.LBY != null) {
                aVar.e(6, this.LBY);
            }
            aVar.aM(7, this.businessType);
            aVar.aM(8, this.scene);
            if (this.LBZ != null) {
                aVar.c(9, this.LBZ);
            }
            aVar.e(10, 8, this.LCa);
            if (this.LCb != null) {
                aVar.ni(11, this.LCb.computeSize());
                this.LCb.writeFields(aVar);
            }
            aVar.aM(12, this.LCc);
            aVar.e(13, 1, this.LCd);
            aVar.e(14, 1, this.Viw);
            aVar.e(15, 1, this.Vix);
            aVar.e(16, 1, this.Viy);
            AppMethodBeat.o(209370);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(3, this.finderUsername);
            }
            if (this.objectDesc != null) {
                nh += g.a.a.a.nh(4, this.objectDesc.computeSize());
            }
            if (this.clientId != null) {
                nh += g.a.a.b.b.a.f(5, this.clientId);
            }
            if (this.LBY != null) {
                nh += g.a.a.b.b.a.f(6, this.LBY);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.businessType) + g.a.a.b.b.a.bu(8, this.scene);
            if (this.LBZ != null) {
                bu += g.a.a.b.b.a.b(9, this.LBZ);
            }
            int c2 = bu + g.a.a.a.c(10, 8, this.LCa);
            if (this.LCb != null) {
                c2 += g.a.a.a.nh(11, this.LCb.computeSize());
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(12, this.LCc) + g.a.a.a.c(13, 1, this.LCd) + g.a.a.a.c(14, 1, this.Viw) + g.a.a.a.c(15, 1, this.Vix) + g.a.a.a.c(16, 1, this.Viy);
            AppMethodBeat.o(209370);
            return bu2;
        } else if (i2 == 2) {
            this.LCa.clear();
            this.LCd.clear();
            this.Viw.clear();
            this.Vix.clear();
            this.Viy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209370);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqc aqc = (aqc) objArr[1];
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
                        aqc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209370);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aqc.LAI = aov;
                    }
                    AppMethodBeat.o(209370);
                    return 0;
                case 3:
                    aqc.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209370);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObjectDesc.populateBuilderWithField(aVar6, finderObjectDesc, dop.getNextFieldNumber(aVar6))) {
                        }
                        aqc.objectDesc = finderObjectDesc;
                    }
                    AppMethodBeat.o(209370);
                    return 0;
                case 5:
                    aqc.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(209370);
                    return 0;
                case 6:
                    aqc.LBY = aVar3.UbS.readString();
                    AppMethodBeat.o(209370);
                    return 0;
                case 7:
                    aqc.businessType = aVar3.UbS.zi();
                    AppMethodBeat.o(209370);
                    return 0;
                case 8:
                    aqc.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209370);
                    return 0;
                case 9:
                    aqc.LBZ = aVar3.UbS.hPo();
                    AppMethodBeat.o(209370);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bdu bdu = new bdu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bdu.populateBuilderWithField(aVar7, bdu, dop.getNextFieldNumber(aVar7))) {
                        }
                        aqc.LCa.add(bdu);
                    }
                    AppMethodBeat.o(209370);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        axk axk = new axk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = axk.populateBuilderWithField(aVar8, axk, dop.getNextFieldNumber(aVar8))) {
                        }
                        aqc.LCb = axk;
                    }
                    AppMethodBeat.o(209370);
                    return 0;
                case 12:
                    aqc.LCc = aVar3.UbS.zi();
                    AppMethodBeat.o(209370);
                    return 0;
                case 13:
                    aqc.LCd.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209370);
                    return 0;
                case 14:
                    aqc.Viw.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209370);
                    return 0;
                case 15:
                    aqc.Vix.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209370);
                    return 0;
                case 16:
                    aqc.Viy.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209370);
                    return 0;
                default:
                    AppMethodBeat.o(209370);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209370);
            return -1;
        }
    }
}
