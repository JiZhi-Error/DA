package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wo extends dop {
    public String CpD;
    public String LhF;
    public String LhG;
    public int LhH;
    public String LhI;
    public String LhJ;
    public String LhK;
    public String LhL;
    public int LhM;
    public String Lhz;
    public int channel;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72437);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LhF == null) {
                b bVar = new b("Not all required fields were included: receiver_name");
                AppMethodBeat.o(72437);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LhF != null) {
                aVar.e(2, this.LhF);
            }
            aVar.aM(3, this.yRL);
            if (this.LhG != null) {
                aVar.e(4, this.LhG);
            }
            if (this.CpD != null) {
                aVar.e(5, this.CpD);
            }
            aVar.aM(6, this.LhH);
            aVar.aM(7, this.channel);
            if (this.LhI != null) {
                aVar.e(8, this.LhI);
            }
            if (this.Lhz != null) {
                aVar.e(9, this.Lhz);
            }
            if (this.LhJ != null) {
                aVar.e(10, this.LhJ);
            }
            if (this.LhK != null) {
                aVar.e(11, this.LhK);
            }
            if (this.LhL != null) {
                aVar.e(12, this.LhL);
            }
            aVar.aM(13, this.LhM);
            AppMethodBeat.o(72437);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LhF != null) {
                nh += g.a.a.b.b.a.f(2, this.LhF);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.yRL);
            if (this.LhG != null) {
                bu += g.a.a.b.b.a.f(4, this.LhG);
            }
            if (this.CpD != null) {
                bu += g.a.a.b.b.a.f(5, this.CpD);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LhH) + g.a.a.b.b.a.bu(7, this.channel);
            if (this.LhI != null) {
                bu2 += g.a.a.b.b.a.f(8, this.LhI);
            }
            if (this.Lhz != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Lhz);
            }
            if (this.LhJ != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LhJ);
            }
            if (this.LhK != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LhK);
            }
            if (this.LhL != null) {
                bu2 += g.a.a.b.b.a.f(12, this.LhL);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.LhM);
            AppMethodBeat.o(72437);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LhF == null) {
                b bVar2 = new b("Not all required fields were included: receiver_name");
                AppMethodBeat.o(72437);
                throw bVar2;
            }
            AppMethodBeat.o(72437);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wo woVar = (wo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        woVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72437);
                    return 0;
                case 2:
                    woVar.LhF = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 3:
                    woVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72437);
                    return 0;
                case 4:
                    woVar.LhG = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 5:
                    woVar.CpD = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 6:
                    woVar.LhH = aVar3.UbS.zi();
                    AppMethodBeat.o(72437);
                    return 0;
                case 7:
                    woVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(72437);
                    return 0;
                case 8:
                    woVar.LhI = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 9:
                    woVar.Lhz = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 10:
                    woVar.LhJ = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 11:
                    woVar.LhK = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 12:
                    woVar.LhL = aVar3.UbS.readString();
                    AppMethodBeat.o(72437);
                    return 0;
                case 13:
                    woVar.LhM = aVar3.UbS.zi();
                    AppMethodBeat.o(72437);
                    return 0;
                default:
                    AppMethodBeat.o(72437);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72437);
            return -1;
        }
    }
}
