package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ku extends dop {
    public int KOL;
    public int Scene;
    public LinkedList<bwr> xKD = new LinkedList<>();

    public ku() {
        AppMethodBeat.i(152503);
        AppMethodBeat.o(152503);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152504);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KOL);
            aVar.e(3, 8, this.xKD);
            aVar.aM(4, this.Scene);
            AppMethodBeat.o(152504);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KOL) + g.a.a.a.c(3, 8, this.xKD) + g.a.a.b.b.a.bu(4, this.Scene);
            AppMethodBeat.o(152504);
            return nh;
        } else if (i2 == 2) {
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152504);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ku kuVar = (ku) objArr[1];
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
                        kuVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152504);
                    return 0;
                case 2:
                    kuVar.KOL = aVar3.UbS.zi();
                    AppMethodBeat.o(152504);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bwr bwr = new bwr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bwr.populateBuilderWithField(aVar5, bwr, dop.getNextFieldNumber(aVar5))) {
                        }
                        kuVar.xKD.add(bwr);
                    }
                    AppMethodBeat.o(152504);
                    return 0;
                case 4:
                    kuVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152504);
                    return 0;
                default:
                    AppMethodBeat.o(152504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152504);
            return -1;
        }
    }
}