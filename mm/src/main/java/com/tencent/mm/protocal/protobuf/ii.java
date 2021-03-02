package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ii extends a {
    public int KMw;
    public ddx KMx;
    public String dNI;
    public String token;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153260);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aM(2, this.KMw);
            if (this.KMx != null) {
                aVar.ni(3, this.KMx.computeSize());
                this.KMx.writeFields(aVar);
            }
            if (this.token != null) {
                aVar.e(4, this.token);
            }
            if (this.dNI != null) {
                aVar.e(5, this.dNI);
            }
            AppMethodBeat.o(153260);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KMw);
            if (this.KMx != null) {
                f2 += g.a.a.a.nh(3, this.KMx.computeSize());
            }
            if (this.token != null) {
                f2 += g.a.a.b.b.a.f(4, this.token);
            }
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(5, this.dNI);
            }
            AppMethodBeat.o(153260);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153260);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ii iiVar = (ii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iiVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(153260);
                    return 0;
                case 2:
                    iiVar.KMw = aVar3.UbS.zi();
                    AppMethodBeat.o(153260);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ddx ddx = new ddx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ddx.populateBuilderWithField(aVar4, ddx, a.getNextFieldNumber(aVar4))) {
                        }
                        iiVar.KMx = ddx;
                    }
                    AppMethodBeat.o(153260);
                    return 0;
                case 4:
                    iiVar.token = aVar3.UbS.readString();
                    AppMethodBeat.o(153260);
                    return 0;
                case 5:
                    iiVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(153260);
                    return 0;
                default:
                    AppMethodBeat.o(153260);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153260);
            return -1;
        }
    }
}
