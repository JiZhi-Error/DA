package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class z extends dop {
    public String KCg;
    public int KCh;
    public int KCi;
    public String KCj;
    public int limit;
    public int offset;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91336);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.limit);
            aVar.aM(3, this.offset);
            aVar.aM(4, this.type);
            if (this.KCg != null) {
                aVar.e(5, this.KCg);
            }
            aVar.aM(6, this.KCh);
            aVar.aM(7, this.KCi);
            if (this.KCj != null) {
                aVar.e(8, this.KCj);
            }
            AppMethodBeat.o(91336);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.limit) + g.a.a.b.b.a.bu(3, this.offset) + g.a.a.b.b.a.bu(4, this.type);
            if (this.KCg != null) {
                nh += g.a.a.b.b.a.f(5, this.KCg);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KCh) + g.a.a.b.b.a.bu(7, this.KCi);
            if (this.KCj != null) {
                bu += g.a.a.b.b.a.f(8, this.KCj);
            }
            AppMethodBeat.o(91336);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91336);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
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
                        zVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91336);
                    return 0;
                case 2:
                    zVar.limit = aVar3.UbS.zi();
                    AppMethodBeat.o(91336);
                    return 0;
                case 3:
                    zVar.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(91336);
                    return 0;
                case 4:
                    zVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91336);
                    return 0;
                case 5:
                    zVar.KCg = aVar3.UbS.readString();
                    AppMethodBeat.o(91336);
                    return 0;
                case 6:
                    zVar.KCh = aVar3.UbS.zi();
                    AppMethodBeat.o(91336);
                    return 0;
                case 7:
                    zVar.KCi = aVar3.UbS.zi();
                    AppMethodBeat.o(91336);
                    return 0;
                case 8:
                    zVar.KCj = aVar3.UbS.readString();
                    AppMethodBeat.o(91336);
                    return 0;
                default:
                    AppMethodBeat.o(91336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91336);
            return -1;
        }
    }
}