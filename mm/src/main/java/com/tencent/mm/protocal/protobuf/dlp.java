package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dlp extends a {
    public String LXh;
    public ehf Lov;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91664);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.LXh != null) {
                aVar.e(2, this.LXh);
            }
            if (this.Lov != null) {
                aVar.ni(3, this.Lov.computeSize());
                this.Lov.writeFields(aVar);
            }
            AppMethodBeat.o(91664);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.LXh != null) {
                bu += g.a.a.b.b.a.f(2, this.LXh);
            }
            if (this.Lov != null) {
                bu += g.a.a.a.nh(3, this.Lov.computeSize());
            }
            AppMethodBeat.o(91664);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91664);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlp dlp = (dlp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dlp.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91664);
                    return 0;
                case 2:
                    dlp.LXh = aVar3.UbS.readString();
                    AppMethodBeat.o(91664);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        dlp.Lov = ehf;
                    }
                    AppMethodBeat.o(91664);
                    return 0;
                default:
                    AppMethodBeat.o(91664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91664);
            return -1;
        }
    }
}
