package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class atw extends dop {
    public LinkedList<String> LEJ = new LinkedList<>();
    public LinkedList<String> LEK = new LinkedList<>();
    public aov uli;

    public atw() {
        AppMethodBeat.i(168993);
        AppMethodBeat.o(168993);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168994);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.LEJ);
            if (this.uli != null) {
                aVar.ni(3, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.e(4, 1, this.LEK);
            AppMethodBeat.o(168994);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.LEJ);
            if (this.uli != null) {
                nh += g.a.a.a.nh(3, this.uli.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 1, this.LEK);
            AppMethodBeat.o(168994);
            return c2;
        } else if (i2 == 2) {
            this.LEJ.clear();
            this.LEK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168994);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            atw atw = (atw) objArr[1];
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
                        atw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168994);
                    return 0;
                case 2:
                    atw.LEJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(168994);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        atw.uli = aov;
                    }
                    AppMethodBeat.o(168994);
                    return 0;
                case 4:
                    atw.LEK.add(aVar3.UbS.readString());
                    AppMethodBeat.o(168994);
                    return 0;
                default:
                    AppMethodBeat.o(168994);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168994);
            return -1;
        }
    }
}
