package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class nj extends dop {
    public LinkedList<gg> KSM = new LinkedList<>();
    public int Scene;

    public nj() {
        AppMethodBeat.i(124402);
        AppMethodBeat.o(124402);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124403);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KSM);
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(124403);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KSM) + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(124403);
            return nh;
        } else if (i2 == 2) {
            this.KSM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124403);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nj njVar = (nj) objArr[1];
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
                        njVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124403);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gg ggVar = new gg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ggVar.populateBuilderWithField(aVar5, ggVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        njVar.KSM.add(ggVar);
                    }
                    AppMethodBeat.o(124403);
                    return 0;
                case 3:
                    njVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124403);
                    return 0;
                default:
                    AppMethodBeat.o(124403);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124403);
            return -1;
        }
    }
}