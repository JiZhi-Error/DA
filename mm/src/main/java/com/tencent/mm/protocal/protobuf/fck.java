package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fck extends a {
    public LinkedList<dbv> Nyn = new LinkedList<>();
    public LinkedList<cfn> Nyo = new LinkedList<>();

    public fck() {
        AppMethodBeat.i(123687);
        AppMethodBeat.o(123687);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123688);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Nyn);
            aVar.e(2, 8, this.Nyo);
            AppMethodBeat.o(123688);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Nyn) + 0 + g.a.a.a.c(2, 8, this.Nyo);
            AppMethodBeat.o(123688);
            return c2;
        } else if (i2 == 2) {
            this.Nyn.clear();
            this.Nyo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123688);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fck fck = (fck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbv dbv = new dbv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbv.populateBuilderWithField(aVar4, dbv, a.getNextFieldNumber(aVar4))) {
                        }
                        fck.Nyn.add(dbv);
                    }
                    AppMethodBeat.o(123688);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfn cfn = new cfn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfn.populateBuilderWithField(aVar5, cfn, a.getNextFieldNumber(aVar5))) {
                        }
                        fck.Nyo.add(cfn);
                    }
                    AppMethodBeat.o(123688);
                    return 0;
                default:
                    AppMethodBeat.o(123688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123688);
            return -1;
        }
    }
}
