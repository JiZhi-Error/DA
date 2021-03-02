package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class og extends a {
    public int KTD;
    public int KTO;
    public int KTP;
    public int KTQ;
    public int KTR;
    public long KTS;
    public long KTT;
    public boolean KTU;
    public int KTV;
    public boolean KTW;
    public ji KTX;
    public boolean KTY;
    public xd KTZ;
    public String KTt;
    public LinkedList<ewv> KUa = new LinkedList<>();
    public boolean KUb;
    public LinkedList<String> KUc = new LinkedList<>();
    public String KUd;
    public String KUe;

    public og() {
        AppMethodBeat.i(212233);
        AppMethodBeat.o(212233);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124426);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTt == null) {
                b bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124426);
                throw bVar;
            }
            if (this.KTt != null) {
                aVar.e(1, this.KTt);
            }
            aVar.aM(2, this.KTO);
            aVar.aM(3, this.KTP);
            aVar.aM(4, this.KTQ);
            aVar.aM(5, this.KTR);
            aVar.bb(6, this.KTS);
            aVar.bb(7, this.KTT);
            aVar.aM(8, this.KTD);
            aVar.cc(9, this.KTU);
            aVar.aM(10, this.KTV);
            aVar.cc(11, this.KTW);
            if (this.KTX != null) {
                aVar.ni(12, this.KTX.computeSize());
                this.KTX.writeFields(aVar);
            }
            aVar.cc(13, this.KTY);
            if (this.KTZ != null) {
                aVar.ni(14, this.KTZ.computeSize());
                this.KTZ.writeFields(aVar);
            }
            aVar.e(15, 8, this.KUa);
            aVar.cc(16, this.KUb);
            aVar.e(17, 1, this.KUc);
            if (this.KUd != null) {
                aVar.e(18, this.KUd);
            }
            if (this.KUe != null) {
                aVar.e(19, this.KUe);
            }
            AppMethodBeat.o(124426);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KTt != null ? g.a.a.b.b.a.f(1, this.KTt) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KTO) + g.a.a.b.b.a.bu(3, this.KTP) + g.a.a.b.b.a.bu(4, this.KTQ) + g.a.a.b.b.a.bu(5, this.KTR) + g.a.a.b.b.a.r(6, this.KTS) + g.a.a.b.b.a.r(7, this.KTT) + g.a.a.b.b.a.bu(8, this.KTD) + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.bu(10, this.KTV) + g.a.a.b.b.a.fS(11) + 1;
            if (this.KTX != null) {
                f2 += g.a.a.a.nh(12, this.KTX.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(13) + 1;
            if (this.KTZ != null) {
                fS += g.a.a.a.nh(14, this.KTZ.computeSize());
            }
            int c2 = fS + g.a.a.a.c(15, 8, this.KUa) + g.a.a.b.b.a.fS(16) + 1 + g.a.a.a.c(17, 1, this.KUc);
            if (this.KUd != null) {
                c2 += g.a.a.b.b.a.f(18, this.KUd);
            }
            if (this.KUe != null) {
                c2 += g.a.a.b.b.a.f(19, this.KUe);
            }
            AppMethodBeat.o(124426);
            return c2;
        } else if (i2 == 2) {
            this.KUa.clear();
            this.KUc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KTt == null) {
                b bVar2 = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124426);
                throw bVar2;
            }
            AppMethodBeat.o(124426);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            og ogVar = (og) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ogVar.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124426);
                    return 0;
                case 2:
                    ogVar.KTO = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 3:
                    ogVar.KTP = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 4:
                    ogVar.KTQ = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 5:
                    ogVar.KTR = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 6:
                    ogVar.KTS = aVar3.UbS.zl();
                    AppMethodBeat.o(124426);
                    return 0;
                case 7:
                    ogVar.KTT = aVar3.UbS.zl();
                    AppMethodBeat.o(124426);
                    return 0;
                case 8:
                    ogVar.KTD = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 9:
                    ogVar.KTU = aVar3.UbS.yZ();
                    AppMethodBeat.o(124426);
                    return 0;
                case 10:
                    ogVar.KTV = aVar3.UbS.zi();
                    AppMethodBeat.o(124426);
                    return 0;
                case 11:
                    ogVar.KTW = aVar3.UbS.yZ();
                    AppMethodBeat.o(124426);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ji jiVar = new ji();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jiVar.populateBuilderWithField(aVar4, jiVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ogVar.KTX = jiVar;
                    }
                    AppMethodBeat.o(124426);
                    return 0;
                case 13:
                    ogVar.KTY = aVar3.UbS.yZ();
                    AppMethodBeat.o(124426);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        xd xdVar = new xd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = xdVar.populateBuilderWithField(aVar5, xdVar, a.getNextFieldNumber(aVar5))) {
                        }
                        ogVar.KTZ = xdVar;
                    }
                    AppMethodBeat.o(124426);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ewv ewv = new ewv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ewv.populateBuilderWithField(aVar6, ewv, a.getNextFieldNumber(aVar6))) {
                        }
                        ogVar.KUa.add(ewv);
                    }
                    AppMethodBeat.o(124426);
                    return 0;
                case 16:
                    ogVar.KUb = aVar3.UbS.yZ();
                    AppMethodBeat.o(124426);
                    return 0;
                case 17:
                    ogVar.KUc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124426);
                    return 0;
                case 18:
                    ogVar.KUd = aVar3.UbS.readString();
                    AppMethodBeat.o(124426);
                    return 0;
                case 19:
                    ogVar.KUe = aVar3.UbS.readString();
                    AppMethodBeat.o(124426);
                    return 0;
                default:
                    AppMethodBeat.o(124426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124426);
            return -1;
        }
    }
}
