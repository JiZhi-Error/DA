package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fct extends dop {
    public acc KOF;
    public b KSW;
    public String Mmu;
    public String Mmv;
    public String NyI;
    public int NyJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123696);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Mmv != null) {
                aVar.e(2, this.Mmv);
            }
            if (this.KSW != null) {
                aVar.c(3, this.KSW);
            }
            if (this.NyI != null) {
                aVar.e(4, this.NyI);
            }
            if (this.Mmu != null) {
                aVar.e(5, this.Mmu);
            }
            aVar.aM(6, this.NyJ);
            if (this.KOF != null) {
                aVar.ni(7, this.KOF.computeSize());
                this.KOF.writeFields(aVar);
            }
            AppMethodBeat.o(123696);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Mmv != null) {
                nh += g.a.a.b.b.a.f(2, this.Mmv);
            }
            if (this.KSW != null) {
                nh += g.a.a.b.b.a.b(3, this.KSW);
            }
            if (this.NyI != null) {
                nh += g.a.a.b.b.a.f(4, this.NyI);
            }
            if (this.Mmu != null) {
                nh += g.a.a.b.b.a.f(5, this.Mmu);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NyJ);
            if (this.KOF != null) {
                bu += g.a.a.a.nh(7, this.KOF.computeSize());
            }
            AppMethodBeat.o(123696);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123696);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fct fct = (fct) objArr[1];
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
                        fct.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123696);
                    return 0;
                case 2:
                    fct.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(123696);
                    return 0;
                case 3:
                    fct.KSW = aVar3.UbS.hPo();
                    AppMethodBeat.o(123696);
                    return 0;
                case 4:
                    fct.NyI = aVar3.UbS.readString();
                    AppMethodBeat.o(123696);
                    return 0;
                case 5:
                    fct.Mmu = aVar3.UbS.readString();
                    AppMethodBeat.o(123696);
                    return 0;
                case 6:
                    fct.NyJ = aVar3.UbS.zi();
                    AppMethodBeat.o(123696);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        acc acc = new acc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = acc.populateBuilderWithField(aVar5, acc, dop.getNextFieldNumber(aVar5))) {
                        }
                        fct.KOF = acc;
                    }
                    AppMethodBeat.o(123696);
                    return 0;
                default:
                    AppMethodBeat.o(123696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123696);
            return -1;
        }
    }
}
