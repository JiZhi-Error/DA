package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fgk extends a {
    public avn LFI;
    public String Lmn;
    public int scene;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259343);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(101, this.scene);
            aVar.bb(102, this.seq);
            if (this.LFI != null) {
                aVar.ni(103, this.LFI.computeSize());
                this.LFI.writeFields(aVar);
            }
            if (this.Lmn != null) {
                aVar.e(104, this.Lmn);
            }
            AppMethodBeat.o(259343);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(101, this.scene) + 0 + g.a.a.b.b.a.r(102, this.seq);
            if (this.LFI != null) {
                bu += g.a.a.a.nh(103, this.LFI.computeSize());
            }
            if (this.Lmn != null) {
                bu += g.a.a.b.b.a.f(104, this.Lmn);
            }
            AppMethodBeat.o(259343);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259343);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgk fgk = (fgk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 101:
                    fgk.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(259343);
                    return 0;
                case 102:
                    fgk.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(259343);
                    return 0;
                case 103:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        fgk.LFI = avn;
                    }
                    AppMethodBeat.o(259343);
                    return 0;
                case 104:
                    fgk.Lmn = aVar3.UbS.readString();
                    AppMethodBeat.o(259343);
                    return 0;
                default:
                    AppMethodBeat.o(259343);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259343);
            return -1;
        }
    }
}
