package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class czb extends a {
    public czd MEl;
    public czc MEm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117886);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEl != null) {
                aVar.ni(1, this.MEl.computeSize());
                this.MEl.writeFields(aVar);
            }
            if (this.MEm != null) {
                aVar.ni(2, this.MEm.computeSize());
                this.MEm.writeFields(aVar);
            }
            AppMethodBeat.o(117886);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MEl != null ? g.a.a.a.nh(1, this.MEl.computeSize()) + 0 : 0;
            if (this.MEm != null) {
                nh += g.a.a.a.nh(2, this.MEm.computeSize());
            }
            AppMethodBeat.o(117886);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czb czb = (czb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        czd czd = new czd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = czd.populateBuilderWithField(aVar4, czd, a.getNextFieldNumber(aVar4))) {
                        }
                        czb.MEl = czd;
                    }
                    AppMethodBeat.o(117886);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        czc czc = new czc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = czc.populateBuilderWithField(aVar5, czc, a.getNextFieldNumber(aVar5))) {
                        }
                        czb.MEm = czc;
                    }
                    AppMethodBeat.o(117886);
                    return 0;
                default:
                    AppMethodBeat.o(117886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117886);
            return -1;
        }
    }
}
