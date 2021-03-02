package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cgr extends a {
    public String LtA;
    public String LtL;
    public LinkedList<String> LtM = new LinkedList<>();
    public boolean LtN;
    public int MlY;
    public cgm MlZ;

    public cgr() {
        AppMethodBeat.i(256415);
        AppMethodBeat.o(256415);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256416);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LtA == null) {
                b bVar = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(256416);
                throw bVar;
            }
            if (this.LtA != null) {
                aVar.e(1, this.LtA);
            }
            if (this.LtL != null) {
                aVar.e(2, this.LtL);
            }
            aVar.e(3, 1, this.LtM);
            aVar.cc(4, this.LtN);
            aVar.aM(5, this.MlY);
            if (this.MlZ != null) {
                aVar.ni(6, this.MlZ.computeSize());
                this.MlZ.writeFields(aVar);
            }
            AppMethodBeat.o(256416);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LtA != null ? g.a.a.b.b.a.f(1, this.LtA) + 0 : 0;
            if (this.LtL != null) {
                f2 += g.a.a.b.b.a.f(2, this.LtL);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.LtM) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.MlY);
            if (this.MlZ != null) {
                c2 += g.a.a.a.nh(6, this.MlZ.computeSize());
            }
            AppMethodBeat.o(256416);
            return c2;
        } else if (i2 == 2) {
            this.LtM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LtA == null) {
                b bVar2 = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(256416);
                throw bVar2;
            }
            AppMethodBeat.o(256416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgr cgr = (cgr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgr.LtA = aVar3.UbS.readString();
                    AppMethodBeat.o(256416);
                    return 0;
                case 2:
                    cgr.LtL = aVar3.UbS.readString();
                    AppMethodBeat.o(256416);
                    return 0;
                case 3:
                    cgr.LtM.add(aVar3.UbS.readString());
                    AppMethodBeat.o(256416);
                    return 0;
                case 4:
                    cgr.LtN = aVar3.UbS.yZ();
                    AppMethodBeat.o(256416);
                    return 0;
                case 5:
                    cgr.MlY = aVar3.UbS.zi();
                    AppMethodBeat.o(256416);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cgm cgm = new cgm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cgm.populateBuilderWithField(aVar4, cgm, a.getNextFieldNumber(aVar4))) {
                        }
                        cgr.MlZ = cgm;
                    }
                    AppMethodBeat.o(256416);
                    return 0;
                default:
                    AppMethodBeat.o(256416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256416);
            return -1;
        }
    }
}
