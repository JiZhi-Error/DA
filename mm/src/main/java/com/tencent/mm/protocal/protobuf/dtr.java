package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtr extends dop {
    public int MVE;
    public LinkedList<Integer> MVF = new LinkedList<>();

    public dtr() {
        AppMethodBeat.i(155456);
        AppMethodBeat.o(155456);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155457);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MVE);
            aVar.f(3, 2, this.MVF);
            AppMethodBeat.o(155457);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MVE) + g.a.a.a.d(3, 2, this.MVF);
            AppMethodBeat.o(155457);
            return nh;
        } else if (i2 == 2) {
            this.MVF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155457);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtr dtr = (dtr) objArr[1];
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
                        dtr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155457);
                    return 0;
                case 2:
                    dtr.MVE = aVar3.UbS.zi();
                    AppMethodBeat.o(155457);
                    return 0;
                case 3:
                    dtr.MVF = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(155457);
                    return 0;
                default:
                    AppMethodBeat.o(155457);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155457);
            return -1;
        }
    }
}
