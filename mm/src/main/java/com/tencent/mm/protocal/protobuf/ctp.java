package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ctp extends dpc {
    public String KCy;
    public String KEa;
    public int KEd;
    public String KEg;
    public String KEh;
    public int KEi;
    public String KEj;
    public int KEl;
    public ffh KEm;
    public ffe KEn;
    public String KLg;
    public dyh KLj;
    public int KLo;
    public int KLp;
    public tc KQK;
    public tc KQL;
    public tc KQM;
    public ccb KQj;
    public qy KQk;
    public ctb KQl;
    public String MbJ;
    public SKBuiltinBuffer_t MbL;
    public String MyK;
    public int MyL;
    public String MyM;
    public int MyN;
    public dby MyO;
    public int MyP;
    public String MyQ;
    public String MyR;
    public dta MyS;
    public String UserName;
    public int oTW;
    public int rBx;
    public String rBz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133185);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(133185);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.rBx);
            if (this.KCy != null) {
                aVar.e(3, this.KCy);
            }
            if (this.KEg != null) {
                aVar.e(4, this.KEg);
            }
            if (this.KEh != null) {
                aVar.e(5, this.KEh);
            }
            if (this.MyK != null) {
                aVar.e(6, this.MyK);
            }
            if (this.KEa != null) {
                aVar.e(7, this.KEa);
            }
            aVar.aM(8, this.KEi);
            aVar.aM(9, this.MyL);
            if (this.MyM != null) {
                aVar.e(10, this.MyM);
            }
            if (this.KQk != null) {
                aVar.ni(14, this.KQk.computeSize());
                this.KQk.writeFields(aVar);
            }
            if (this.KEj != null) {
                aVar.e(15, this.KEj);
            }
            if (this.UserName != null) {
                aVar.e(16, this.UserName);
            }
            aVar.aM(17, this.oTW);
            if (this.KQl != null) {
                aVar.ni(18, this.KQl.computeSize());
                this.KQl.writeFields(aVar);
            }
            aVar.aM(19, this.MyN);
            aVar.aM(20, this.KEd);
            if (this.KLg != null) {
                aVar.e(21, this.KLg);
            }
            if (this.MyO != null) {
                aVar.ni(22, this.MyO.computeSize());
                this.MyO.writeFields(aVar);
            }
            if (this.rBz != null) {
                aVar.e(23, this.rBz);
            }
            aVar.aM(24, this.MyP);
            if (this.KQj != null) {
                aVar.ni(25, this.KQj.computeSize());
                this.KQj.writeFields(aVar);
            }
            if (this.MyQ != null) {
                aVar.e(26, this.MyQ);
            }
            if (this.KQK != null) {
                aVar.ni(27, this.KQK.computeSize());
                this.KQK.writeFields(aVar);
            }
            if (this.MyR != null) {
                aVar.e(28, this.MyR);
            }
            if (this.MbJ != null) {
                aVar.e(29, this.MbJ);
            }
            if (this.MbL != null) {
                aVar.ni(30, this.MbL.computeSize());
                this.MbL.writeFields(aVar);
            }
            if (this.KLj != null) {
                aVar.ni(31, this.KLj.computeSize());
                this.KLj.writeFields(aVar);
            }
            if (this.KQL != null) {
                aVar.ni(32, this.KQL.computeSize());
                this.KQL.writeFields(aVar);
            }
            if (this.KQM != null) {
                aVar.ni(33, this.KQM.computeSize());
                this.KQM.writeFields(aVar);
            }
            if (this.MyS != null) {
                aVar.ni(34, this.MyS.computeSize());
                this.MyS.writeFields(aVar);
            }
            aVar.aM(35, this.KLo);
            aVar.aM(36, this.KLp);
            aVar.aM(37, this.KEl);
            if (this.KEm != null) {
                aVar.ni(38, this.KEm.computeSize());
                this.KEm.writeFields(aVar);
            }
            if (this.KEn != null) {
                aVar.ni(39, this.KEn.computeSize());
                this.KEn.writeFields(aVar);
            }
            AppMethodBeat.o(133185);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBx);
            if (this.KCy != null) {
                nh += g.a.a.b.b.a.f(3, this.KCy);
            }
            if (this.KEg != null) {
                nh += g.a.a.b.b.a.f(4, this.KEg);
            }
            if (this.KEh != null) {
                nh += g.a.a.b.b.a.f(5, this.KEh);
            }
            if (this.MyK != null) {
                nh += g.a.a.b.b.a.f(6, this.MyK);
            }
            if (this.KEa != null) {
                nh += g.a.a.b.b.a.f(7, this.KEa);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KEi) + g.a.a.b.b.a.bu(9, this.MyL);
            if (this.MyM != null) {
                bu += g.a.a.b.b.a.f(10, this.MyM);
            }
            if (this.KQk != null) {
                bu += g.a.a.a.nh(14, this.KQk.computeSize());
            }
            if (this.KEj != null) {
                bu += g.a.a.b.b.a.f(15, this.KEj);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(16, this.UserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(17, this.oTW);
            if (this.KQl != null) {
                bu2 += g.a.a.a.nh(18, this.KQl.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(19, this.MyN) + g.a.a.b.b.a.bu(20, this.KEd);
            if (this.KLg != null) {
                bu3 += g.a.a.b.b.a.f(21, this.KLg);
            }
            if (this.MyO != null) {
                bu3 += g.a.a.a.nh(22, this.MyO.computeSize());
            }
            if (this.rBz != null) {
                bu3 += g.a.a.b.b.a.f(23, this.rBz);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(24, this.MyP);
            if (this.KQj != null) {
                bu4 += g.a.a.a.nh(25, this.KQj.computeSize());
            }
            if (this.MyQ != null) {
                bu4 += g.a.a.b.b.a.f(26, this.MyQ);
            }
            if (this.KQK != null) {
                bu4 += g.a.a.a.nh(27, this.KQK.computeSize());
            }
            if (this.MyR != null) {
                bu4 += g.a.a.b.b.a.f(28, this.MyR);
            }
            if (this.MbJ != null) {
                bu4 += g.a.a.b.b.a.f(29, this.MbJ);
            }
            if (this.MbL != null) {
                bu4 += g.a.a.a.nh(30, this.MbL.computeSize());
            }
            if (this.KLj != null) {
                bu4 += g.a.a.a.nh(31, this.KLj.computeSize());
            }
            if (this.KQL != null) {
                bu4 += g.a.a.a.nh(32, this.KQL.computeSize());
            }
            if (this.KQM != null) {
                bu4 += g.a.a.a.nh(33, this.KQM.computeSize());
            }
            if (this.MyS != null) {
                bu4 += g.a.a.a.nh(34, this.MyS.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(35, this.KLo) + g.a.a.b.b.a.bu(36, this.KLp) + g.a.a.b.b.a.bu(37, this.KEl);
            if (this.KEm != null) {
                bu5 += g.a.a.a.nh(38, this.KEm.computeSize());
            }
            if (this.KEn != null) {
                bu5 += g.a.a.a.nh(39, this.KEn.computeSize());
            }
            AppMethodBeat.o(133185);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(133185);
                throw bVar2;
            }
            AppMethodBeat.o(133185);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctp ctp = (ctp) objArr[1];
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
                        ctp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 2:
                    ctp.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 3:
                    ctp.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 4:
                    ctp.KEg = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 5:
                    ctp.KEh = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 6:
                    ctp.MyK = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 7:
                    ctp.KEa = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 8:
                    ctp.KEi = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 9:
                    ctp.MyL = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 10:
                    ctp.MyM = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 11:
                case 12:
                case 13:
                default:
                    AppMethodBeat.o(133185);
                    return -1;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qy qyVar = new qy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qyVar.populateBuilderWithField(aVar5, qyVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ctp.KQk = qyVar;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 15:
                    ctp.KEj = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 16:
                    ctp.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 17:
                    ctp.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ctb ctb = new ctb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ctb.populateBuilderWithField(aVar6, ctb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ctp.KQl = ctb;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 19:
                    ctp.MyN = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 20:
                    ctp.KEd = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 21:
                    ctp.KLg = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dby dby = new dby();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dby.populateBuilderWithField(aVar7, dby, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ctp.MyO = dby;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 23:
                    ctp.rBz = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 24:
                    ctp.MyP = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ccb ccb = new ccb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ccb.populateBuilderWithField(aVar8, ccb, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ctp.KQj = ccb;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 26:
                    ctp.MyQ = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        tc tcVar = new tc();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = tcVar.populateBuilderWithField(aVar9, tcVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        ctp.KQK = tcVar;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 28:
                    ctp.MyR = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 29:
                    ctp.MbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(133185);
                    return 0;
                case 30:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t.populateBuilderWithField(aVar10, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar10))) {
                        }
                        ctp.MbL = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dyh dyh = new dyh();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dyh.populateBuilderWithField(aVar11, dyh, dpc.getNextFieldNumber(aVar11))) {
                        }
                        ctp.KLj = dyh;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        tc tcVar2 = new tc();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = tcVar2.populateBuilderWithField(aVar12, tcVar2, dpc.getNextFieldNumber(aVar12))) {
                        }
                        ctp.KQL = tcVar2;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        tc tcVar3 = new tc();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = tcVar3.populateBuilderWithField(aVar13, tcVar3, dpc.getNextFieldNumber(aVar13))) {
                        }
                        ctp.KQM = tcVar3;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 34:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        dta dta = new dta();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = dta.populateBuilderWithField(aVar14, dta, dpc.getNextFieldNumber(aVar14))) {
                        }
                        ctp.MyS = dta;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 35:
                    ctp.KLo = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 36:
                    ctp.KLp = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 37:
                    ctp.KEl = aVar3.UbS.zi();
                    AppMethodBeat.o(133185);
                    return 0;
                case 38:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        ffh ffh = new ffh();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = ffh.populateBuilderWithField(aVar15, ffh, dpc.getNextFieldNumber(aVar15))) {
                        }
                        ctp.KEm = ffh;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
                case 39:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        ffe ffe = new ffe();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = ffe.populateBuilderWithField(aVar16, ffe, dpc.getNextFieldNumber(aVar16))) {
                        }
                        ctp.KEn = ffe;
                    }
                    AppMethodBeat.o(133185);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133185);
            return -1;
        }
    }
}
