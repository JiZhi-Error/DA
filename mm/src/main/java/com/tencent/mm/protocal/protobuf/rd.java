package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class rd extends dop {
    public int Coi;
    public String Coj;
    public String Cok;
    public String CpG;
    public String CpJ;
    public String KYc;
    public int KYd;
    public int channel;
    public String jTz;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91370);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.yRL);
            aVar.aM(3, this.channel);
            aVar.aM(4, this.Coi);
            if (this.KYc != null) {
                aVar.e(5, this.KYc);
            }
            if (this.CpG != null) {
                aVar.e(6, this.CpG);
            }
            if (this.Coj != null) {
                aVar.e(7, this.Coj);
            }
            if (this.CpJ != null) {
                aVar.e(8, this.CpJ);
            }
            if (this.jTz != null) {
                aVar.e(9, this.jTz);
            }
            if (this.Cok != null) {
                aVar.e(10, this.Cok);
            }
            aVar.aM(11, this.KYd);
            AppMethodBeat.o(91370);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.yRL) + g.a.a.b.b.a.bu(3, this.channel) + g.a.a.b.b.a.bu(4, this.Coi);
            if (this.KYc != null) {
                nh += g.a.a.b.b.a.f(5, this.KYc);
            }
            if (this.CpG != null) {
                nh += g.a.a.b.b.a.f(6, this.CpG);
            }
            if (this.Coj != null) {
                nh += g.a.a.b.b.a.f(7, this.Coj);
            }
            if (this.CpJ != null) {
                nh += g.a.a.b.b.a.f(8, this.CpJ);
            }
            if (this.jTz != null) {
                nh += g.a.a.b.b.a.f(9, this.jTz);
            }
            if (this.Cok != null) {
                nh += g.a.a.b.b.a.f(10, this.Cok);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.KYd);
            AppMethodBeat.o(91370);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91370);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rd rdVar = (rd) objArr[1];
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
                        rdVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91370);
                    return 0;
                case 2:
                    rdVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91370);
                    return 0;
                case 3:
                    rdVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(91370);
                    return 0;
                case 4:
                    rdVar.Coi = aVar3.UbS.zi();
                    AppMethodBeat.o(91370);
                    return 0;
                case 5:
                    rdVar.KYc = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 6:
                    rdVar.CpG = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 7:
                    rdVar.Coj = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 8:
                    rdVar.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 9:
                    rdVar.jTz = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 10:
                    rdVar.Cok = aVar3.UbS.readString();
                    AppMethodBeat.o(91370);
                    return 0;
                case 11:
                    rdVar.KYd = aVar3.UbS.zi();
                    AppMethodBeat.o(91370);
                    return 0;
                default:
                    AppMethodBeat.o(91370);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91370);
            return -1;
        }
    }
}
