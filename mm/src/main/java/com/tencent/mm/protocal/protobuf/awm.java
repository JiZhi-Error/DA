package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awm extends a {
    public String KDS;
    public int LFG;
    public avn LFI;
    public long LHk;
    public String Lmn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209536);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFI != null) {
                aVar.ni(1, this.LFI.computeSize());
                this.LFI.writeFields(aVar);
            }
            aVar.aM(2, this.LFG);
            if (this.Lmn != null) {
                aVar.e(3, this.Lmn);
            }
            if (this.KDS != null) {
                aVar.e(4, this.KDS);
            }
            aVar.bb(5, this.LHk);
            AppMethodBeat.o(209536);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LFI != null ? g.a.a.a.nh(1, this.LFI.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LFG);
            if (this.Lmn != null) {
                nh += g.a.a.b.b.a.f(3, this.Lmn);
            }
            if (this.KDS != null) {
                nh += g.a.a.b.b.a.f(4, this.KDS);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.LHk);
            AppMethodBeat.o(209536);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209536);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awm awm = (awm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        awm.LFI = avn;
                    }
                    AppMethodBeat.o(209536);
                    return 0;
                case 2:
                    awm.LFG = aVar3.UbS.zi();
                    AppMethodBeat.o(209536);
                    return 0;
                case 3:
                    awm.Lmn = aVar3.UbS.readString();
                    AppMethodBeat.o(209536);
                    return 0;
                case 4:
                    awm.KDS = aVar3.UbS.readString();
                    AppMethodBeat.o(209536);
                    return 0;
                case 5:
                    awm.LHk = aVar3.UbS.zl();
                    AppMethodBeat.o(209536);
                    return 0;
                default:
                    AppMethodBeat.o(209536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209536);
            return -1;
        }
    }
}
