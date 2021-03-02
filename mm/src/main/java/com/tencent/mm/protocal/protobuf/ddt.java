package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ddt extends dpc {
    public String Htl;
    public int Htr;
    public LinkedList<vk> LSL = new LinkedList<>();
    public cda MII;
    public dfd MIJ;
    public String MIK;
    public int MIL;
    public long MIM;
    public String MIN;
    public String MIO;
    public String MIP;
    public String MIQ;
    public LinkedList<dlf> MIR = new LinkedList<>();
    public String MpG;
    public boolean MpH = true;
    public int pTZ;
    public String pUa;

    public ddt() {
        AppMethodBeat.i(91622);
        AppMethodBeat.o(91622);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91623);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91623);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            if (this.MII != null) {
                aVar.ni(4, this.MII.computeSize());
                this.MII.writeFields(aVar);
            }
            if (this.MIJ != null) {
                aVar.ni(5, this.MIJ.computeSize());
                this.MIJ.writeFields(aVar);
            }
            if (this.MpG != null) {
                aVar.e(6, this.MpG);
            }
            aVar.e(7, 8, this.LSL);
            aVar.cc(8, this.MpH);
            aVar.aM(9, this.Htr);
            if (this.MIK != null) {
                aVar.e(10, this.MIK);
            }
            aVar.aM(11, this.MIL);
            aVar.bb(12, this.MIM);
            if (this.Htl != null) {
                aVar.e(13, this.Htl);
            }
            if (this.MIN != null) {
                aVar.e(14, this.MIN);
            }
            if (this.MIO != null) {
                aVar.e(15, this.MIO);
            }
            if (this.MIP != null) {
                aVar.e(16, this.MIP);
            }
            if (this.MIQ != null) {
                aVar.e(17, this.MIQ);
            }
            aVar.e(18, 8, this.MIR);
            AppMethodBeat.o(91623);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MII != null) {
                nh += g.a.a.a.nh(4, this.MII.computeSize());
            }
            if (this.MIJ != null) {
                nh += g.a.a.a.nh(5, this.MIJ.computeSize());
            }
            if (this.MpG != null) {
                nh += g.a.a.b.b.a.f(6, this.MpG);
            }
            int c2 = nh + g.a.a.a.c(7, 8, this.LSL) + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.bu(9, this.Htr);
            if (this.MIK != null) {
                c2 += g.a.a.b.b.a.f(10, this.MIK);
            }
            int bu = c2 + g.a.a.b.b.a.bu(11, this.MIL) + g.a.a.b.b.a.r(12, this.MIM);
            if (this.Htl != null) {
                bu += g.a.a.b.b.a.f(13, this.Htl);
            }
            if (this.MIN != null) {
                bu += g.a.a.b.b.a.f(14, this.MIN);
            }
            if (this.MIO != null) {
                bu += g.a.a.b.b.a.f(15, this.MIO);
            }
            if (this.MIP != null) {
                bu += g.a.a.b.b.a.f(16, this.MIP);
            }
            if (this.MIQ != null) {
                bu += g.a.a.b.b.a.f(17, this.MIQ);
            }
            int c3 = bu + g.a.a.a.c(18, 8, this.MIR);
            AppMethodBeat.o(91623);
            return c3;
        } else if (i2 == 2) {
            this.LSL.clear();
            this.MIR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91623);
                throw bVar2;
            }
            AppMethodBeat.o(91623);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddt ddt = (ddt) objArr[1];
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
                        ddt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91623);
                    return 0;
                case 2:
                    ddt.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91623);
                    return 0;
                case 3:
                    ddt.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cda cda = new cda();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cda.populateBuilderWithField(aVar5, cda, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ddt.MII = cda;
                    }
                    AppMethodBeat.o(91623);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dfd dfd = new dfd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dfd.populateBuilderWithField(aVar6, dfd, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ddt.MIJ = dfd;
                    }
                    AppMethodBeat.o(91623);
                    return 0;
                case 6:
                    ddt.MpG = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        vk vkVar = new vk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = vkVar.populateBuilderWithField(aVar7, vkVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ddt.LSL.add(vkVar);
                    }
                    AppMethodBeat.o(91623);
                    return 0;
                case 8:
                    ddt.MpH = aVar3.UbS.yZ();
                    AppMethodBeat.o(91623);
                    return 0;
                case 9:
                    ddt.Htr = aVar3.UbS.zi();
                    AppMethodBeat.o(91623);
                    return 0;
                case 10:
                    ddt.MIK = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 11:
                    ddt.MIL = aVar3.UbS.zi();
                    AppMethodBeat.o(91623);
                    return 0;
                case 12:
                    ddt.MIM = aVar3.UbS.zl();
                    AppMethodBeat.o(91623);
                    return 0;
                case 13:
                    ddt.Htl = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 14:
                    ddt.MIN = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 15:
                    ddt.MIO = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 16:
                    ddt.MIP = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 17:
                    ddt.MIQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91623);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dlf dlf = new dlf();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dlf.populateBuilderWithField(aVar8, dlf, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ddt.MIR.add(dlf);
                    }
                    AppMethodBeat.o(91623);
                    return 0;
                default:
                    AppMethodBeat.o(91623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91623);
            return -1;
        }
    }
}
