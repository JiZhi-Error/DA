package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhd extends dpc {
    public String KBN;
    public eig LUW;
    public long LpD;
    public dpp MhF;
    public long MhJ;
    public String icon;
    public int nHh;
    public int pTZ;
    public String pTn;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72558);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72558);
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
            if (this.KBN != null) {
                aVar.e(4, this.KBN);
            }
            aVar.bb(5, this.MhJ);
            aVar.bb(6, this.LpD);
            if (this.MhF != null) {
                aVar.ni(7, this.MhF.computeSize());
                this.MhF.writeFields(aVar);
            }
            if (this.LUW != null) {
                aVar.ni(8, this.LUW.computeSize());
                this.LUW.writeFields(aVar);
            }
            if (this.pTn != null) {
                aVar.e(9, this.pTn);
            }
            aVar.aM(10, this.nHh);
            if (this.icon != null) {
                aVar.e(11, this.icon);
            }
            AppMethodBeat.o(72558);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.KBN != null) {
                nh += g.a.a.b.b.a.f(4, this.KBN);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.MhJ) + g.a.a.b.b.a.r(6, this.LpD);
            if (this.MhF != null) {
                r += g.a.a.a.nh(7, this.MhF.computeSize());
            }
            if (this.LUW != null) {
                r += g.a.a.a.nh(8, this.LUW.computeSize());
            }
            if (this.pTn != null) {
                r += g.a.a.b.b.a.f(9, this.pTn);
            }
            int bu = r + g.a.a.b.b.a.bu(10, this.nHh);
            if (this.icon != null) {
                bu += g.a.a.b.b.a.f(11, this.icon);
            }
            AppMethodBeat.o(72558);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72558);
                throw bVar2;
            }
            AppMethodBeat.o(72558);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhd dhd = (dhd) objArr[1];
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
                        dhd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72558);
                    return 0;
                case 2:
                    dhd.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72558);
                    return 0;
                case 3:
                    dhd.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72558);
                    return 0;
                case 4:
                    dhd.KBN = aVar3.UbS.readString();
                    AppMethodBeat.o(72558);
                    return 0;
                case 5:
                    dhd.MhJ = aVar3.UbS.zl();
                    AppMethodBeat.o(72558);
                    return 0;
                case 6:
                    dhd.LpD = aVar3.UbS.zl();
                    AppMethodBeat.o(72558);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpp dpp = new dpp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpp.populateBuilderWithField(aVar5, dpp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhd.MhF = dpp;
                    }
                    AppMethodBeat.o(72558);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eig eig = new eig();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eig.populateBuilderWithField(aVar6, eig, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhd.LUW = eig;
                    }
                    AppMethodBeat.o(72558);
                    return 0;
                case 9:
                    dhd.pTn = aVar3.UbS.readString();
                    AppMethodBeat.o(72558);
                    return 0;
                case 10:
                    dhd.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(72558);
                    return 0;
                case 11:
                    dhd.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(72558);
                    return 0;
                default:
                    AppMethodBeat.o(72558);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72558);
            return -1;
        }
    }
}
