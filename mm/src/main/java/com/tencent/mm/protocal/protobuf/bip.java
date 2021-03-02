package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bip extends dop {
    public String KCy;
    public int KCz;
    public ei LSI;
    public String appId;
    public String dmc;
    public String extend;
    public String sign;
    public String wPN;
    public String wPO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32219);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            if (this.wPN != null) {
                aVar.e(3, this.wPN);
            }
            if (this.wPO != null) {
                aVar.e(4, this.wPO);
            }
            if (this.extend != null) {
                aVar.e(5, this.extend);
            }
            if (this.dmc != null) {
                aVar.e(6, this.dmc);
            }
            if (this.sign != null) {
                aVar.e(7, this.sign);
            }
            if (this.LSI != null) {
                aVar.ni(8, this.LSI.computeSize());
                this.LSI.writeFields(aVar);
            }
            if (this.KCy != null) {
                aVar.e(9, this.KCy);
            }
            aVar.aM(10, this.KCz);
            AppMethodBeat.o(32219);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.appId != null) {
                nh += g.a.a.b.b.a.f(2, this.appId);
            }
            if (this.wPN != null) {
                nh += g.a.a.b.b.a.f(3, this.wPN);
            }
            if (this.wPO != null) {
                nh += g.a.a.b.b.a.f(4, this.wPO);
            }
            if (this.extend != null) {
                nh += g.a.a.b.b.a.f(5, this.extend);
            }
            if (this.dmc != null) {
                nh += g.a.a.b.b.a.f(6, this.dmc);
            }
            if (this.sign != null) {
                nh += g.a.a.b.b.a.f(7, this.sign);
            }
            if (this.LSI != null) {
                nh += g.a.a.a.nh(8, this.LSI.computeSize());
            }
            if (this.KCy != null) {
                nh += g.a.a.b.b.a.f(9, this.KCy);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.KCz);
            AppMethodBeat.o(32219);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32219);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bip bip = (bip) objArr[1];
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
                        bip.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32219);
                    return 0;
                case 2:
                    bip.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 3:
                    bip.wPN = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 4:
                    bip.wPO = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 5:
                    bip.extend = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 6:
                    bip.dmc = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 7:
                    bip.sign = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ei eiVar = new ei();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eiVar.populateBuilderWithField(aVar5, eiVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bip.LSI = eiVar;
                    }
                    AppMethodBeat.o(32219);
                    return 0;
                case 9:
                    bip.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(32219);
                    return 0;
                case 10:
                    bip.KCz = aVar3.UbS.zi();
                    AppMethodBeat.o(32219);
                    return 0;
                default:
                    AppMethodBeat.o(32219);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32219);
            return -1;
        }
    }
}
