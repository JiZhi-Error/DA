package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eki extends dpc {
    public String KBM;
    public String KHN;
    public dmq NjA;
    public String NjB;
    public dmp Nja;
    public String Nje;
    public String Njt;
    public String Njv;
    public int Njw;
    public int Njx;
    public dmp Njy;
    public aae Njz;
    public String dNQ;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72608);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.Njw);
            if (this.Nja != null) {
                aVar.ni(5, this.Nja.computeSize());
                this.Nja.writeFields(aVar);
            }
            aVar.aM(6, this.Njx);
            if (this.Njy != null) {
                aVar.ni(7, this.Njy.computeSize());
                this.Njy.writeFields(aVar);
            }
            if (this.Njz != null) {
                aVar.ni(8, this.Njz.computeSize());
                this.Njz.writeFields(aVar);
            }
            if (this.NjA != null) {
                aVar.ni(9, this.NjA.computeSize());
                this.NjA.writeFields(aVar);
            }
            if (this.dNQ != null) {
                aVar.e(10, this.dNQ);
            }
            if (this.KBM != null) {
                aVar.e(11, this.KBM);
            }
            if (this.KHN != null) {
                aVar.e(12, this.KHN);
            }
            if (this.Njt != null) {
                aVar.e(13, this.Njt);
            }
            if (this.NjB != null) {
                aVar.e(14, this.NjB);
            }
            if (this.Njv != null) {
                aVar.e(15, this.Njv);
            }
            if (this.Nje != null) {
                aVar.e(16, this.Nje);
            }
            AppMethodBeat.o(72608);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Njw);
            if (this.Nja != null) {
                bu += g.a.a.a.nh(5, this.Nja.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Njx);
            if (this.Njy != null) {
                bu2 += g.a.a.a.nh(7, this.Njy.computeSize());
            }
            if (this.Njz != null) {
                bu2 += g.a.a.a.nh(8, this.Njz.computeSize());
            }
            if (this.NjA != null) {
                bu2 += g.a.a.a.nh(9, this.NjA.computeSize());
            }
            if (this.dNQ != null) {
                bu2 += g.a.a.b.b.a.f(10, this.dNQ);
            }
            if (this.KBM != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KBM);
            }
            if (this.KHN != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KHN);
            }
            if (this.Njt != null) {
                bu2 += g.a.a.b.b.a.f(13, this.Njt);
            }
            if (this.NjB != null) {
                bu2 += g.a.a.b.b.a.f(14, this.NjB);
            }
            if (this.Njv != null) {
                bu2 += g.a.a.b.b.a.f(15, this.Njv);
            }
            if (this.Nje != null) {
                bu2 += g.a.a.b.b.a.f(16, this.Nje);
            }
            AppMethodBeat.o(72608);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72608);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eki eki = (eki) objArr[1];
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
                        eki.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72608);
                    return 0;
                case 2:
                    eki.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72608);
                    return 0;
                case 3:
                    eki.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 4:
                    eki.Njw = aVar3.UbS.zi();
                    AppMethodBeat.o(72608);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dmp dmp = new dmp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dmp.populateBuilderWithField(aVar5, dmp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        eki.Nja = dmp;
                    }
                    AppMethodBeat.o(72608);
                    return 0;
                case 6:
                    eki.Njx = aVar3.UbS.zi();
                    AppMethodBeat.o(72608);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmp dmp2 = new dmp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmp2.populateBuilderWithField(aVar6, dmp2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        eki.Njy = dmp2;
                    }
                    AppMethodBeat.o(72608);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aae aae = new aae();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aae.populateBuilderWithField(aVar7, aae, dpc.getNextFieldNumber(aVar7))) {
                        }
                        eki.Njz = aae;
                    }
                    AppMethodBeat.o(72608);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dmq dmq = new dmq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dmq.populateBuilderWithField(aVar8, dmq, dpc.getNextFieldNumber(aVar8))) {
                        }
                        eki.NjA = dmq;
                    }
                    AppMethodBeat.o(72608);
                    return 0;
                case 10:
                    eki.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 11:
                    eki.KBM = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 12:
                    eki.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 13:
                    eki.Njt = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 14:
                    eki.NjB = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 15:
                    eki.Njv = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                case 16:
                    eki.Nje = aVar3.UbS.readString();
                    AppMethodBeat.o(72608);
                    return 0;
                default:
                    AppMethodBeat.o(72608);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72608);
            return -1;
        }
    }
}
