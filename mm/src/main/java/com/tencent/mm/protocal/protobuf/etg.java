package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etg extends dop {
    public long Lta;
    public long NeG;
    public LinkedList<etf> NqH = new LinkedList<>();

    public etg() {
        AppMethodBeat.i(125506);
        AppMethodBeat.o(125506);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125507);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.NeG);
            aVar.bb(3, this.Lta);
            aVar.e(4, 8, this.NqH);
            AppMethodBeat.o(125507);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.NeG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.a.c(4, 8, this.NqH);
            AppMethodBeat.o(125507);
            return nh;
        } else if (i2 == 2) {
            this.NqH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125507);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etg etg = (etg) objArr[1];
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
                        etg.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125507);
                    return 0;
                case 2:
                    etg.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(125507);
                    return 0;
                case 3:
                    etg.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(125507);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        etf etf = new etf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = etf.populateBuilderWithField(aVar5, etf, dop.getNextFieldNumber(aVar5))) {
                        }
                        etg.NqH.add(etf);
                    }
                    AppMethodBeat.o(125507);
                    return 0;
                default:
                    AppMethodBeat.o(125507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125507);
            return -1;
        }
    }
}
