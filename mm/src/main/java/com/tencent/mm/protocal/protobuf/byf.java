package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class byf extends dpc {
    public String Desc;
    public String MdG;
    public String MdH;
    public String MdI;
    public String MdJ;
    public String MdK;
    public String MdL;
    public ewp MdM;
    public String MdN;
    public String MdO;
    public String MdP;
    public String MdQ;
    public String MdR;
    public int Mdq;
    public LinkedList<ewj> Mdr = new LinkedList<>();
    public String Title;
    public String xJH;

    public byf() {
        AppMethodBeat.i(32308);
        AppMethodBeat.o(32308);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32309);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32309);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MdG != null) {
                aVar.e(2, this.MdG);
            }
            if (this.xJH != null) {
                aVar.e(3, this.xJH);
            }
            if (this.Title != null) {
                aVar.e(4, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(5, this.Desc);
            }
            if (this.MdH != null) {
                aVar.e(6, this.MdH);
            }
            if (this.MdI != null) {
                aVar.e(7, this.MdI);
            }
            if (this.MdJ != null) {
                aVar.e(8, this.MdJ);
            }
            if (this.MdK != null) {
                aVar.e(9, this.MdK);
            }
            if (this.MdL != null) {
                aVar.e(10, this.MdL);
            }
            if (this.MdM != null) {
                aVar.ni(11, this.MdM.computeSize());
                this.MdM.writeFields(aVar);
            }
            if (this.MdN != null) {
                aVar.e(12, this.MdN);
            }
            if (this.MdO != null) {
                aVar.e(13, this.MdO);
            }
            if (this.MdP != null) {
                aVar.e(14, this.MdP);
            }
            if (this.MdQ != null) {
                aVar.e(15, this.MdQ);
            }
            if (this.MdR != null) {
                aVar.e(16, this.MdR);
            }
            aVar.aM(17, this.Mdq);
            aVar.e(18, 8, this.Mdr);
            AppMethodBeat.o(32309);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MdG != null) {
                nh += g.a.a.b.b.a.f(2, this.MdG);
            }
            if (this.xJH != null) {
                nh += g.a.a.b.b.a.f(3, this.xJH);
            }
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(4, this.Title);
            }
            if (this.Desc != null) {
                nh += g.a.a.b.b.a.f(5, this.Desc);
            }
            if (this.MdH != null) {
                nh += g.a.a.b.b.a.f(6, this.MdH);
            }
            if (this.MdI != null) {
                nh += g.a.a.b.b.a.f(7, this.MdI);
            }
            if (this.MdJ != null) {
                nh += g.a.a.b.b.a.f(8, this.MdJ);
            }
            if (this.MdK != null) {
                nh += g.a.a.b.b.a.f(9, this.MdK);
            }
            if (this.MdL != null) {
                nh += g.a.a.b.b.a.f(10, this.MdL);
            }
            if (this.MdM != null) {
                nh += g.a.a.a.nh(11, this.MdM.computeSize());
            }
            if (this.MdN != null) {
                nh += g.a.a.b.b.a.f(12, this.MdN);
            }
            if (this.MdO != null) {
                nh += g.a.a.b.b.a.f(13, this.MdO);
            }
            if (this.MdP != null) {
                nh += g.a.a.b.b.a.f(14, this.MdP);
            }
            if (this.MdQ != null) {
                nh += g.a.a.b.b.a.f(15, this.MdQ);
            }
            if (this.MdR != null) {
                nh += g.a.a.b.b.a.f(16, this.MdR);
            }
            int bu = nh + g.a.a.b.b.a.bu(17, this.Mdq) + g.a.a.a.c(18, 8, this.Mdr);
            AppMethodBeat.o(32309);
            return bu;
        } else if (i2 == 2) {
            this.Mdr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32309);
                throw bVar2;
            }
            AppMethodBeat.o(32309);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            byf byf = (byf) objArr[1];
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
                        byf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32309);
                    return 0;
                case 2:
                    byf.MdG = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 3:
                    byf.xJH = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 4:
                    byf.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 5:
                    byf.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 6:
                    byf.MdH = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 7:
                    byf.MdI = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 8:
                    byf.MdJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 9:
                    byf.MdK = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 10:
                    byf.MdL = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ewp ewp = new ewp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ewp.populateBuilderWithField(aVar5, ewp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        byf.MdM = ewp;
                    }
                    AppMethodBeat.o(32309);
                    return 0;
                case 12:
                    byf.MdN = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 13:
                    byf.MdO = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 14:
                    byf.MdP = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 15:
                    byf.MdQ = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 16:
                    byf.MdR = aVar3.UbS.readString();
                    AppMethodBeat.o(32309);
                    return 0;
                case 17:
                    byf.Mdq = aVar3.UbS.zi();
                    AppMethodBeat.o(32309);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ewj ewj = new ewj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ewj.populateBuilderWithField(aVar6, ewj, dpc.getNextFieldNumber(aVar6))) {
                        }
                        byf.Mdr.add(ewj);
                    }
                    AppMethodBeat.o(32309);
                    return 0;
                default:
                    AppMethodBeat.o(32309);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32309);
            return -1;
        }
    }
}
