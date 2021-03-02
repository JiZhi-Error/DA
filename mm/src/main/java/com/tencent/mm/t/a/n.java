package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class n extends dop {
    public long gTC;
    public String gTk;
    public String gTl;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194686);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.gTk != null) {
                aVar.e(2, this.gTk);
            }
            aVar.aM(3, this.source);
            aVar.bb(4, this.gTC);
            if (this.gTl != null) {
                aVar.e(5, this.gTl);
            }
            AppMethodBeat.o(194686);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.gTk != null) {
                nh += g.a.a.b.b.a.f(2, this.gTk);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.r(4, this.gTC);
            if (this.gTl != null) {
                bu += g.a.a.b.b.a.f(5, this.gTl);
            }
            AppMethodBeat.o(194686);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194686);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
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
                        nVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(194686);
                    return 0;
                case 2:
                    nVar.gTk = aVar3.UbS.readString();
                    AppMethodBeat.o(194686);
                    return 0;
                case 3:
                    nVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(194686);
                    return 0;
                case 4:
                    nVar.gTC = aVar3.UbS.zl();
                    AppMethodBeat.o(194686);
                    return 0;
                case 5:
                    nVar.gTl = aVar3.UbS.readString();
                    AppMethodBeat.o(194686);
                    return 0;
                default:
                    AppMethodBeat.o(194686);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194686);
            return -1;
        }
    }
}
