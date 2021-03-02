package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class alm extends dpc {
    public dju LgT;
    public cdh Lus;
    public int dDN;
    public int dGe;
    public int egZ;
    public int eha;
    public String qwn;
    public String yQE;
    public int yRL;
    public int yRN;
    public String yRO;
    public String yRP;
    public String yRQ;
    public int yRR;
    public String yRS;
    public String yRT;
    public String yVy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91453);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91453);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            aVar.aM(4, this.dGe);
            if (this.yQE != null) {
                aVar.e(5, this.yQE);
            }
            aVar.aM(6, this.egZ);
            aVar.aM(7, this.eha);
            if (this.yVy != null) {
                aVar.e(8, this.yVy);
            }
            aVar.aM(9, this.yRL);
            if (this.LgT != null) {
                aVar.ni(10, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            aVar.aM(11, this.yRN);
            if (this.yRO != null) {
                aVar.e(12, this.yRO);
            }
            if (this.yRP != null) {
                aVar.e(13, this.yRP);
            }
            if (this.yRQ != null) {
                aVar.e(14, this.yRQ);
            }
            aVar.aM(15, this.yRR);
            if (this.yRS != null) {
                aVar.e(16, this.yRS);
            }
            if (this.yRT != null) {
                aVar.e(17, this.yRT);
            }
            if (this.Lus != null) {
                aVar.ni(18, this.Lus.computeSize());
                this.Lus.writeFields(aVar);
            }
            AppMethodBeat.o(91453);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.dGe);
            if (this.yQE != null) {
                bu += g.a.a.b.b.a.f(5, this.yQE);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.egZ) + g.a.a.b.b.a.bu(7, this.eha);
            if (this.yVy != null) {
                bu2 += g.a.a.b.b.a.f(8, this.yVy);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.yRL);
            if (this.LgT != null) {
                bu3 += g.a.a.a.nh(10, this.LgT.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.yRN);
            if (this.yRO != null) {
                bu4 += g.a.a.b.b.a.f(12, this.yRO);
            }
            if (this.yRP != null) {
                bu4 += g.a.a.b.b.a.f(13, this.yRP);
            }
            if (this.yRQ != null) {
                bu4 += g.a.a.b.b.a.f(14, this.yRQ);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(15, this.yRR);
            if (this.yRS != null) {
                bu5 += g.a.a.b.b.a.f(16, this.yRS);
            }
            if (this.yRT != null) {
                bu5 += g.a.a.b.b.a.f(17, this.yRT);
            }
            if (this.Lus != null) {
                bu5 += g.a.a.a.nh(18, this.Lus.computeSize());
            }
            AppMethodBeat.o(91453);
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
                AppMethodBeat.o(91453);
                throw bVar2;
            }
            AppMethodBeat.o(91453);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alm alm = (alm) objArr[1];
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
                        alm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91453);
                    return 0;
                case 2:
                    alm.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 3:
                    alm.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 4:
                    alm.dGe = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 5:
                    alm.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 6:
                    alm.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 7:
                    alm.eha = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 8:
                    alm.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 9:
                    alm.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dju.populateBuilderWithField(aVar5, dju, dpc.getNextFieldNumber(aVar5))) {
                        }
                        alm.LgT = dju;
                    }
                    AppMethodBeat.o(91453);
                    return 0;
                case 11:
                    alm.yRN = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 12:
                    alm.yRO = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 13:
                    alm.yRP = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 14:
                    alm.yRQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 15:
                    alm.yRR = aVar3.UbS.zi();
                    AppMethodBeat.o(91453);
                    return 0;
                case 16:
                    alm.yRS = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 17:
                    alm.yRT = aVar3.UbS.readString();
                    AppMethodBeat.o(91453);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cdh cdh = new cdh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cdh.populateBuilderWithField(aVar6, cdh, dpc.getNextFieldNumber(aVar6))) {
                        }
                        alm.Lus = cdh;
                    }
                    AppMethodBeat.o(91453);
                    return 0;
                default:
                    AppMethodBeat.o(91453);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91453);
            return -1;
        }
    }
}
