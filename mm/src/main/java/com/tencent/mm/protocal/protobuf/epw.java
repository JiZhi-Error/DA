package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class epw extends dop {
    public b LoA;
    public b Nnu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214325);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Nnu != null) {
                aVar.c(2, this.Nnu);
            }
            if (this.LoA != null) {
                aVar.c(3, this.LoA);
            }
            AppMethodBeat.o(214325);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Nnu != null) {
                nh += g.a.a.b.b.a.b(2, this.Nnu);
            }
            if (this.LoA != null) {
                nh += g.a.a.b.b.a.b(3, this.LoA);
            }
            AppMethodBeat.o(214325);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214325);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epw epw = (epw) objArr[1];
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
                        epw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214325);
                    return 0;
                case 2:
                    epw.Nnu = aVar3.UbS.hPo();
                    AppMethodBeat.o(214325);
                    return 0;
                case 3:
                    epw.LoA = aVar3.UbS.hPo();
                    AppMethodBeat.o(214325);
                    return 0;
                default:
                    AppMethodBeat.o(214325);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214325);
            return -1;
        }
    }
}
