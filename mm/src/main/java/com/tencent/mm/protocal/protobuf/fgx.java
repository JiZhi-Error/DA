package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fgx extends a {
    public String KDS;
    public avn LFI;
    public long LHk;
    public String Lmn;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259357);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KDS != null) {
                aVar.e(1, this.KDS);
            }
            aVar.bb(2, this.LHk);
            if (this.Lmn != null) {
                aVar.e(3, this.Lmn);
            }
            if (this.LFI != null) {
                aVar.ni(4, this.LFI.computeSize());
                this.LFI.writeFields(aVar);
            }
            aVar.aM(5, this.status);
            AppMethodBeat.o(259357);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KDS != null ? g.a.a.b.b.a.f(1, this.KDS) + 0 : 0) + g.a.a.b.b.a.r(2, this.LHk);
            if (this.Lmn != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lmn);
            }
            if (this.LFI != null) {
                f2 += g.a.a.a.nh(4, this.LFI.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.status);
            AppMethodBeat.o(259357);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259357);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgx fgx = (fgx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fgx.KDS = aVar3.UbS.readString();
                    AppMethodBeat.o(259357);
                    return 0;
                case 2:
                    fgx.LHk = aVar3.UbS.zl();
                    AppMethodBeat.o(259357);
                    return 0;
                case 3:
                    fgx.Lmn = aVar3.UbS.readString();
                    AppMethodBeat.o(259357);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        fgx.LFI = avn;
                    }
                    AppMethodBeat.o(259357);
                    return 0;
                case 5:
                    fgx.status = aVar3.UbS.zi();
                    AppMethodBeat.o(259357);
                    return 0;
                default:
                    AppMethodBeat.o(259357);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259357);
            return -1;
        }
    }
}
