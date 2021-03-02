package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ajp extends dop {
    public String KSV;
    public b Lqr;
    public b Lte;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124485);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KSV != null) {
                aVar.e(2, this.KSV);
            }
            aVar.aM(3, this.xub);
            if (this.Lte != null) {
                aVar.c(4, this.Lte);
            }
            if (this.Lqr != null) {
                aVar.c(5, this.Lqr);
            }
            AppMethodBeat.o(124485);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KSV != null) {
                nh += g.a.a.b.b.a.f(2, this.KSV);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.xub);
            if (this.Lte != null) {
                bu += g.a.a.b.b.a.b(4, this.Lte);
            }
            if (this.Lqr != null) {
                bu += g.a.a.b.b.a.b(5, this.Lqr);
            }
            AppMethodBeat.o(124485);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124485);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajp ajp = (ajp) objArr[1];
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
                        ajp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124485);
                    return 0;
                case 2:
                    ajp.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(124485);
                    return 0;
                case 3:
                    ajp.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(124485);
                    return 0;
                case 4:
                    ajp.Lte = aVar3.UbS.hPo();
                    AppMethodBeat.o(124485);
                    return 0;
                case 5:
                    ajp.Lqr = aVar3.UbS.hPo();
                    AppMethodBeat.o(124485);
                    return 0;
                default:
                    AppMethodBeat.o(124485);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124485);
            return -1;
        }
    }
}
