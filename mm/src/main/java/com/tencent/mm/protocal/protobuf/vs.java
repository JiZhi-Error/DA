package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class vs extends dop {
    public int Coi;
    public String CpC;
    public String CpD;
    public String KHM;
    public String KHN;
    public String LgK;
    public String LgL;
    public int channel;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91403);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KHM != null) {
                aVar.e(2, this.KHM);
            }
            if (this.KHN != null) {
                aVar.e(3, this.KHN);
            }
            aVar.aM(4, this.yRL);
            if (this.CpD != null) {
                aVar.e(5, this.CpD);
            }
            if (this.CpC != null) {
                aVar.e(6, this.CpC);
            }
            aVar.aM(7, this.channel);
            aVar.aM(8, this.Coi);
            if (this.LgK != null) {
                aVar.e(9, this.LgK);
            }
            if (this.LgL != null) {
                aVar.e(10, this.LgL);
            }
            AppMethodBeat.o(91403);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KHM != null) {
                nh += g.a.a.b.b.a.f(2, this.KHM);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(3, this.KHN);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.yRL);
            if (this.CpD != null) {
                bu += g.a.a.b.b.a.f(5, this.CpD);
            }
            if (this.CpC != null) {
                bu += g.a.a.b.b.a.f(6, this.CpC);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.channel) + g.a.a.b.b.a.bu(8, this.Coi);
            if (this.LgK != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LgK);
            }
            if (this.LgL != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LgL);
            }
            AppMethodBeat.o(91403);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91403);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vs vsVar = (vs) objArr[1];
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
                        vsVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91403);
                    return 0;
                case 2:
                    vsVar.KHM = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                case 3:
                    vsVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                case 4:
                    vsVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91403);
                    return 0;
                case 5:
                    vsVar.CpD = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                case 6:
                    vsVar.CpC = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                case 7:
                    vsVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(91403);
                    return 0;
                case 8:
                    vsVar.Coi = aVar3.UbS.zi();
                    AppMethodBeat.o(91403);
                    return 0;
                case 9:
                    vsVar.LgK = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                case 10:
                    vsVar.LgL = aVar3.UbS.readString();
                    AppMethodBeat.o(91403);
                    return 0;
                default:
                    AppMethodBeat.o(91403);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91403);
            return -1;
        }
    }
}
