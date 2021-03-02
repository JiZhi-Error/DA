package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bgh extends dop {
    public LinkedList<String> LPU = new LinkedList<>();
    public LinkedList<String> LQa = new LinkedList<>();
    public int LQb;
    public String keh;
    public String xLl;

    public bgh() {
        AppMethodBeat.i(42638);
        AppMethodBeat.o(42638);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42639);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.LQa);
            aVar.e(3, 1, this.LPU);
            if (this.xLl != null) {
                aVar.e(4, this.xLl);
            }
            if (this.keh != null) {
                aVar.e(5, this.keh);
            }
            aVar.aM(6, this.LQb);
            AppMethodBeat.o(42639);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.LQa) + g.a.a.a.c(3, 1, this.LPU);
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(4, this.xLl);
            }
            if (this.keh != null) {
                nh += g.a.a.b.b.a.f(5, this.keh);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LQb);
            AppMethodBeat.o(42639);
            return bu;
        } else if (i2 == 2) {
            this.LQa.clear();
            this.LPU.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42639);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgh bgh = (bgh) objArr[1];
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
                        bgh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(42639);
                    return 0;
                case 2:
                    bgh.LQa.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42639);
                    return 0;
                case 3:
                    bgh.LPU.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42639);
                    return 0;
                case 4:
                    bgh.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(42639);
                    return 0;
                case 5:
                    bgh.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(42639);
                    return 0;
                case 6:
                    bgh.LQb = aVar3.UbS.zi();
                    AppMethodBeat.o(42639);
                    return 0;
                default:
                    AppMethodBeat.o(42639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42639);
            return -1;
        }
    }
}
