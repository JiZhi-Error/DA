package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aff extends dop {
    public String KGO;
    public LinkedList<afp> KGQ = new LinkedList<>();
    public int Scene;
    public int gsq;

    public aff() {
        AppMethodBeat.i(101801);
        AppMethodBeat.o(101801);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101802);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.gsq);
            aVar.e(3, 8, this.KGQ);
            if (this.KGO != null) {
                aVar.e(4, this.KGO);
            }
            aVar.aM(5, this.Scene);
            AppMethodBeat.o(101802);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.gsq) + g.a.a.a.c(3, 8, this.KGQ);
            if (this.KGO != null) {
                nh += g.a.a.b.b.a.f(4, this.KGO);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Scene);
            AppMethodBeat.o(101802);
            return bu;
        } else if (i2 == 2) {
            this.KGQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(101802);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aff aff = (aff) objArr[1];
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
                        aff.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(101802);
                    return 0;
                case 2:
                    aff.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(101802);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        afp afp = new afp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = afp.populateBuilderWithField(aVar5, afp, dop.getNextFieldNumber(aVar5))) {
                        }
                        aff.KGQ.add(afp);
                    }
                    AppMethodBeat.o(101802);
                    return 0;
                case 4:
                    aff.KGO = aVar3.UbS.readString();
                    AppMethodBeat.o(101802);
                    return 0;
                case 5:
                    aff.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(101802);
                    return 0;
                default:
                    AppMethodBeat.o(101802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101802);
            return -1;
        }
    }
}
