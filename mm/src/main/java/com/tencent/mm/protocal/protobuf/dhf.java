package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhf extends dpc {
    public eig LUW;
    public sx LWE;
    public long LjE;
    public long LjF;
    public cbw LpE;
    public crf MLE;
    public dpp MhF;
    public LinkedList<czq> dkr = new LinkedList<>();
    public int pTZ;
    public String pUa;

    public dhf() {
        AppMethodBeat.i(72560);
        AppMethodBeat.o(72560);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72561);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72561);
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
            if (this.LpE != null) {
                aVar.ni(4, this.LpE.computeSize());
                this.LpE.writeFields(aVar);
            }
            aVar.e(5, 8, this.dkr);
            aVar.bb(6, this.LjE);
            aVar.bb(7, this.LjF);
            if (this.MhF != null) {
                aVar.ni(8, this.MhF.computeSize());
                this.MhF.writeFields(aVar);
            }
            if (this.LWE != null) {
                aVar.ni(9, this.LWE.computeSize());
                this.LWE.writeFields(aVar);
            }
            if (this.LUW != null) {
                aVar.ni(10, this.LUW.computeSize());
                this.LUW.writeFields(aVar);
            }
            if (this.MLE != null) {
                aVar.ni(11, this.MLE.computeSize());
                this.MLE.writeFields(aVar);
            }
            AppMethodBeat.o(72561);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.LpE != null) {
                nh += g.a.a.a.nh(4, this.LpE.computeSize());
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.dkr) + g.a.a.b.b.a.r(6, this.LjE) + g.a.a.b.b.a.r(7, this.LjF);
            if (this.MhF != null) {
                c2 += g.a.a.a.nh(8, this.MhF.computeSize());
            }
            if (this.LWE != null) {
                c2 += g.a.a.a.nh(9, this.LWE.computeSize());
            }
            if (this.LUW != null) {
                c2 += g.a.a.a.nh(10, this.LUW.computeSize());
            }
            if (this.MLE != null) {
                c2 += g.a.a.a.nh(11, this.MLE.computeSize());
            }
            AppMethodBeat.o(72561);
            return c2;
        } else if (i2 == 2) {
            this.dkr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72561);
                throw bVar2;
            }
            AppMethodBeat.o(72561);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhf dhf = (dhf) objArr[1];
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
                        dhf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 2:
                    dhf.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72561);
                    return 0;
                case 3:
                    dhf.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72561);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbw cbw = new cbw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbw.populateBuilderWithField(aVar5, cbw, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhf.LpE = cbw;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        czq czq = new czq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = czq.populateBuilderWithField(aVar6, czq, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhf.dkr.add(czq);
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 6:
                    dhf.LjE = aVar3.UbS.zl();
                    AppMethodBeat.o(72561);
                    return 0;
                case 7:
                    dhf.LjF = aVar3.UbS.zl();
                    AppMethodBeat.o(72561);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dpp dpp = new dpp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dpp.populateBuilderWithField(aVar7, dpp, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dhf.MhF = dpp;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        sx sxVar = new sx();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sxVar.populateBuilderWithField(aVar8, sxVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dhf.LWE = sxVar;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eig eig = new eig();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eig.populateBuilderWithField(aVar9, eig, dpc.getNextFieldNumber(aVar9))) {
                        }
                        dhf.LUW = eig;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        crf crf = new crf();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = crf.populateBuilderWithField(aVar10, crf, dpc.getNextFieldNumber(aVar10))) {
                        }
                        dhf.MLE = crf;
                    }
                    AppMethodBeat.o(72561);
                    return 0;
                default:
                    AppMethodBeat.o(72561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72561);
            return -1;
        }
    }
}