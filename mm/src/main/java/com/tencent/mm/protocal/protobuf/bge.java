package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bge extends dop {
    public String LPT;
    public LinkedList<String> LPU = new LinkedList<>();
    public String xLl;

    public bge() {
        AppMethodBeat.i(42633);
        AppMethodBeat.o(42633);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42634);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LPT != null) {
                aVar.e(2, this.LPT);
            }
            aVar.e(3, 1, this.LPU);
            if (this.xLl != null) {
                aVar.e(4, this.xLl);
            }
            AppMethodBeat.o(42634);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LPT != null) {
                nh += g.a.a.b.b.a.f(2, this.LPT);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.LPU);
            if (this.xLl != null) {
                c2 += g.a.a.b.b.a.f(4, this.xLl);
            }
            AppMethodBeat.o(42634);
            return c2;
        } else if (i2 == 2) {
            this.LPU.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bge bge = (bge) objArr[1];
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
                        bge.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(42634);
                    return 0;
                case 2:
                    bge.LPT = aVar3.UbS.readString();
                    AppMethodBeat.o(42634);
                    return 0;
                case 3:
                    bge.LPU.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42634);
                    return 0;
                case 4:
                    bge.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(42634);
                    return 0;
                default:
                    AppMethodBeat.o(42634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42634);
            return -1;
        }
    }
}
