package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ffl extends a {
    public int Lqb;
    public int NAI;
    public int NAJ;
    public ecf NAK;
    public int score;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32570);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(32570);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aM(2, this.score);
            aVar.aM(3, this.NAI);
            aVar.aM(4, this.Lqb);
            aVar.aM(5, this.NAJ);
            if (this.NAK != null) {
                aVar.ni(6, this.NAK.computeSize());
                this.NAK.writeFields(aVar);
            }
            AppMethodBeat.o(32570);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.score) + g.a.a.b.b.a.bu(3, this.NAI) + g.a.a.b.b.a.bu(4, this.Lqb) + g.a.a.b.b.a.bu(5, this.NAJ);
            if (this.NAK != null) {
                f2 += g.a.a.a.nh(6, this.NAK.computeSize());
            }
            AppMethodBeat.o(32570);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar2 = new b("Not all required fields were included: username");
                AppMethodBeat.o(32570);
                throw bVar2;
            }
            AppMethodBeat.o(32570);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffl ffl = (ffl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ffl.username = aVar3.UbS.readString();
                    AppMethodBeat.o(32570);
                    return 0;
                case 2:
                    ffl.score = aVar3.UbS.zi();
                    AppMethodBeat.o(32570);
                    return 0;
                case 3:
                    ffl.NAI = aVar3.UbS.zi();
                    AppMethodBeat.o(32570);
                    return 0;
                case 4:
                    ffl.Lqb = aVar3.UbS.zi();
                    AppMethodBeat.o(32570);
                    return 0;
                case 5:
                    ffl.NAJ = aVar3.UbS.zi();
                    AppMethodBeat.o(32570);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ecf ecf = new ecf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecf.populateBuilderWithField(aVar4, ecf, a.getNextFieldNumber(aVar4))) {
                        }
                        ffl.NAK = ecf;
                    }
                    AppMethodBeat.o(32570);
                    return 0;
                default:
                    AppMethodBeat.o(32570);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32570);
            return -1;
        }
    }
}
