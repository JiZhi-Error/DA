package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqb extends dpc {
    public int KTQ;
    public awn LBR;
    public int LBS;
    public bbf LBT;
    public FinderObject LBU;
    public LinkedList<axk> LBV = new LinkedList<>();
    public axk LBW;
    public LinkedList<avh> LBX = new LinkedList<>();
    public int Vis;
    public int Vit;
    public int Viu;
    public int Viv;
    public awt live_notice_info;

    public aqb() {
        AppMethodBeat.i(209367);
        AppMethodBeat.o(209367);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209368);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LBR != null) {
                aVar.ni(2, this.LBR.computeSize());
                this.LBR.writeFields(aVar);
            }
            if (this.live_notice_info != null) {
                aVar.ni(3, this.live_notice_info.computeSize());
                this.live_notice_info.writeFields(aVar);
            }
            aVar.aM(4, this.KTQ);
            aVar.aM(5, this.LBS);
            if (this.LBT != null) {
                aVar.ni(6, this.LBT.computeSize());
                this.LBT.writeFields(aVar);
            }
            if (this.LBU != null) {
                aVar.ni(7, this.LBU.computeSize());
                this.LBU.writeFields(aVar);
            }
            aVar.e(8, 8, this.LBV);
            if (this.LBW != null) {
                aVar.ni(9, this.LBW.computeSize());
                this.LBW.writeFields(aVar);
            }
            aVar.e(10, 8, this.LBX);
            aVar.aM(11, this.Vis);
            aVar.aM(12, this.Vit);
            aVar.aM(13, this.Viu);
            aVar.aM(14, this.Viv);
            AppMethodBeat.o(209368);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LBR != null) {
                nh += g.a.a.a.nh(2, this.LBR.computeSize());
            }
            if (this.live_notice_info != null) {
                nh += g.a.a.a.nh(3, this.live_notice_info.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KTQ) + g.a.a.b.b.a.bu(5, this.LBS);
            if (this.LBT != null) {
                bu += g.a.a.a.nh(6, this.LBT.computeSize());
            }
            if (this.LBU != null) {
                bu += g.a.a.a.nh(7, this.LBU.computeSize());
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.LBV);
            if (this.LBW != null) {
                c2 += g.a.a.a.nh(9, this.LBW.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(10, 8, this.LBX) + g.a.a.b.b.a.bu(11, this.Vis) + g.a.a.b.b.a.bu(12, this.Vit) + g.a.a.b.b.a.bu(13, this.Viu) + g.a.a.b.b.a.bu(14, this.Viv);
            AppMethodBeat.o(209368);
            return c3;
        } else if (i2 == 2) {
            this.LBV.clear();
            this.LBX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209368);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqb aqb = (aqb) objArr[1];
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
                        aqb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        awn awn = new awn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = awn.populateBuilderWithField(aVar5, awn, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aqb.LBR = awn;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awt awt = new awt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awt.populateBuilderWithField(aVar6, awt, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aqb.live_notice_info = awt;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 4:
                    aqb.KTQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                case 5:
                    aqb.LBS = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bbf bbf = new bbf();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bbf.populateBuilderWithField(aVar7, bbf, dpc.getNextFieldNumber(aVar7))) {
                        }
                        aqb.LBT = bbf;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderObject.populateBuilderWithField(aVar8, finderObject, dpc.getNextFieldNumber(aVar8))) {
                        }
                        aqb.LBU = finderObject;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        axk axk = new axk();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = axk.populateBuilderWithField(aVar9, axk, dpc.getNextFieldNumber(aVar9))) {
                        }
                        aqb.LBV.add(axk);
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        axk axk2 = new axk();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = axk2.populateBuilderWithField(aVar10, axk2, dpc.getNextFieldNumber(aVar10))) {
                        }
                        aqb.LBW = axk2;
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        avh avh = new avh();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = avh.populateBuilderWithField(aVar11, avh, dpc.getNextFieldNumber(aVar11))) {
                        }
                        aqb.LBX.add(avh);
                    }
                    AppMethodBeat.o(209368);
                    return 0;
                case 11:
                    aqb.Vis = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                case 12:
                    aqb.Vit = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                case 13:
                    aqb.Viu = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                case 14:
                    aqb.Viv = aVar3.UbS.zi();
                    AppMethodBeat.o(209368);
                    return 0;
                default:
                    AppMethodBeat.o(209368);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209368);
            return -1;
        }
    }
}
