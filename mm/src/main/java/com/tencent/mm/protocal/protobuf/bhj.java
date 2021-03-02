package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhj extends dpc {
    public int KCD;
    public String KCt;
    public SKBuiltinBuffer_t LRE;
    public String LRH;
    public String LRI;
    public cee LRJ;
    public bgt LRK;
    public String LRL;
    public int LRM;
    public LinkedList<px> LRN = new LinkedList<>();
    public String LRO;
    public aey LRP;
    public SKBuiltinBuffer_t LRQ;
    public int LRR;
    public SKBuiltinBuffer_t LRS;
    public SKBuiltinBuffer_t LRT;
    public String LRk;
    public String LRl;
    public LinkedList<ccc> LRq = new LinkedList<>();
    public String SSID;
    public String Title;
    public String UserName;
    public String iAc;
    public String xJH;

    public bhj() {
        AppMethodBeat.i(152553);
        AppMethodBeat.o(152553);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152554);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152554);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LRH != null) {
                aVar.e(2, this.LRH);
            }
            if (this.LRI != null) {
                aVar.e(3, this.LRI);
            }
            aVar.aM(4, this.KCD);
            if (this.Title != null) {
                aVar.e(5, this.Title);
            }
            if (this.iAc != null) {
                aVar.e(6, this.iAc);
            }
            if (this.LRJ != null) {
                aVar.ni(7, this.LRJ.computeSize());
                this.LRJ.writeFields(aVar);
            }
            if (this.LRK != null) {
                aVar.ni(8, this.LRK.computeSize());
                this.LRK.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(9, this.UserName);
            }
            if (this.LRL != null) {
                aVar.e(15, this.LRL);
            }
            aVar.aM(16, this.LRM);
            aVar.e(17, 8, this.LRN);
            if (this.LRO != null) {
                aVar.e(18, this.LRO);
            }
            if (this.SSID != null) {
                aVar.e(20, this.SSID);
            }
            if (this.KCt != null) {
                aVar.e(21, this.KCt);
            }
            if (this.LRP != null) {
                aVar.ni(22, this.LRP.computeSize());
                this.LRP.writeFields(aVar);
            }
            if (this.LRQ != null) {
                aVar.ni(23, this.LRQ.computeSize());
                this.LRQ.writeFields(aVar);
            }
            aVar.aM(24, this.LRR);
            aVar.e(25, 8, this.LRq);
            if (this.xJH != null) {
                aVar.e(26, this.xJH);
            }
            if (this.LRk != null) {
                aVar.e(27, this.LRk);
            }
            if (this.LRE != null) {
                aVar.ni(28, this.LRE.computeSize());
                this.LRE.writeFields(aVar);
            }
            if (this.LRl != null) {
                aVar.e(29, this.LRl);
            }
            if (this.LRS != null) {
                aVar.ni(30, this.LRS.computeSize());
                this.LRS.writeFields(aVar);
            }
            if (this.LRT != null) {
                aVar.ni(31, this.LRT.computeSize());
                this.LRT.writeFields(aVar);
            }
            AppMethodBeat.o(152554);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LRH != null) {
                nh += g.a.a.b.b.a.f(2, this.LRH);
            }
            if (this.LRI != null) {
                nh += g.a.a.b.b.a.f(3, this.LRI);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KCD);
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(5, this.Title);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(6, this.iAc);
            }
            if (this.LRJ != null) {
                bu += g.a.a.a.nh(7, this.LRJ.computeSize());
            }
            if (this.LRK != null) {
                bu += g.a.a.a.nh(8, this.LRK.computeSize());
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(9, this.UserName);
            }
            if (this.LRL != null) {
                bu += g.a.a.b.b.a.f(15, this.LRL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(16, this.LRM) + g.a.a.a.c(17, 8, this.LRN);
            if (this.LRO != null) {
                bu2 += g.a.a.b.b.a.f(18, this.LRO);
            }
            if (this.SSID != null) {
                bu2 += g.a.a.b.b.a.f(20, this.SSID);
            }
            if (this.KCt != null) {
                bu2 += g.a.a.b.b.a.f(21, this.KCt);
            }
            if (this.LRP != null) {
                bu2 += g.a.a.a.nh(22, this.LRP.computeSize());
            }
            if (this.LRQ != null) {
                bu2 += g.a.a.a.nh(23, this.LRQ.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(24, this.LRR) + g.a.a.a.c(25, 8, this.LRq);
            if (this.xJH != null) {
                bu3 += g.a.a.b.b.a.f(26, this.xJH);
            }
            if (this.LRk != null) {
                bu3 += g.a.a.b.b.a.f(27, this.LRk);
            }
            if (this.LRE != null) {
                bu3 += g.a.a.a.nh(28, this.LRE.computeSize());
            }
            if (this.LRl != null) {
                bu3 += g.a.a.b.b.a.f(29, this.LRl);
            }
            if (this.LRS != null) {
                bu3 += g.a.a.a.nh(30, this.LRS.computeSize());
            }
            if (this.LRT != null) {
                bu3 += g.a.a.a.nh(31, this.LRT.computeSize());
            }
            AppMethodBeat.o(152554);
            return bu3;
        } else if (i2 == 2) {
            this.LRN.clear();
            this.LRq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152554);
                throw bVar2;
            }
            AppMethodBeat.o(152554);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhj bhj = (bhj) objArr[1];
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
                        bhj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 2:
                    bhj.LRH = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 3:
                    bhj.LRI = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 4:
                    bhj.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(152554);
                    return 0;
                case 5:
                    bhj.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 6:
                    bhj.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cee cee = new cee();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cee.populateBuilderWithField(aVar5, cee, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bhj.LRJ = cee;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bgt bgt = new bgt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bgt.populateBuilderWithField(aVar6, bgt, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bhj.LRK = bgt;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 9:
                    bhj.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 19:
                default:
                    AppMethodBeat.o(152554);
                    return -1;
                case 15:
                    bhj.LRL = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 16:
                    bhj.LRM = aVar3.UbS.zi();
                    AppMethodBeat.o(152554);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        px pxVar = new px();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = pxVar.populateBuilderWithField(aVar7, pxVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bhj.LRN.add(pxVar);
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 18:
                    bhj.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 20:
                    bhj.SSID = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 21:
                    bhj.KCt = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        aey aey = new aey();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = aey.populateBuilderWithField(aVar8, aey, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bhj.LRP = aey;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t.populateBuilderWithField(aVar9, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bhj.LRQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 24:
                    bhj.LRR = aVar3.UbS.zi();
                    AppMethodBeat.o(152554);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ccc ccc = new ccc();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ccc.populateBuilderWithField(aVar10, ccc, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bhj.LRq.add(ccc);
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 26:
                    bhj.xJH = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 27:
                    bhj.LRk = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar11, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bhj.LRE = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 29:
                    bhj.LRl = aVar3.UbS.readString();
                    AppMethodBeat.o(152554);
                    return 0;
                case 30:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar12, sKBuiltinBuffer_t3, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bhj.LRS = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar13, sKBuiltinBuffer_t4, dpc.getNextFieldNumber(aVar13))) {
                        }
                        bhj.LRT = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(152554);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152554);
            return -1;
        }
    }
}
