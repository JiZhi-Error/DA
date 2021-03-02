package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dma extends dop {
    public String Ltk;
    public eox MPD;
    public ejg MPE;
    public int hil;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56259);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MPD == null) {
                b bVar = new b("Not all required fields were included: UserPosition");
                AppMethodBeat.o(56259);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Ltk != null) {
                aVar.e(2, this.Ltk);
            }
            aVar.aM(3, this.oUv);
            if (this.MPD != null) {
                aVar.ni(4, this.MPD.computeSize());
                this.MPD.writeFields(aVar);
            }
            aVar.aM(5, this.hil);
            if (this.MPE != null) {
                aVar.ni(6, this.MPE.computeSize());
                this.MPE.writeFields(aVar);
            }
            AppMethodBeat.o(56259);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Ltk != null) {
                nh += g.a.a.b.b.a.f(2, this.Ltk);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oUv);
            if (this.MPD != null) {
                bu += g.a.a.a.nh(4, this.MPD.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.hil);
            if (this.MPE != null) {
                bu2 += g.a.a.a.nh(6, this.MPE.computeSize());
            }
            AppMethodBeat.o(56259);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MPD == null) {
                b bVar2 = new b("Not all required fields were included: UserPosition");
                AppMethodBeat.o(56259);
                throw bVar2;
            }
            AppMethodBeat.o(56259);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dma dma = (dma) objArr[1];
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
                        dma.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(56259);
                    return 0;
                case 2:
                    dma.Ltk = aVar3.UbS.readString();
                    AppMethodBeat.o(56259);
                    return 0;
                case 3:
                    dma.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(56259);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eox eox = new eox();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eox.populateBuilderWithField(aVar5, eox, dop.getNextFieldNumber(aVar5))) {
                        }
                        dma.MPD = eox;
                    }
                    AppMethodBeat.o(56259);
                    return 0;
                case 5:
                    dma.hil = aVar3.UbS.zi();
                    AppMethodBeat.o(56259);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ejg ejg = new ejg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ejg.populateBuilderWithField(aVar6, ejg, dop.getNextFieldNumber(aVar6))) {
                        }
                        dma.MPE = ejg;
                    }
                    AppMethodBeat.o(56259);
                    return 0;
                default:
                    AppMethodBeat.o(56259);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56259);
            return -1;
        }
    }
}
