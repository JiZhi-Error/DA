package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class abx extends dop {
    public LinkedList<caa> LmA = new LinkedList<>();
    public int Lmz;

    public abx() {
        AppMethodBeat.i(101794);
        AppMethodBeat.o(101794);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101795);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.Lmz);
            aVar.e(3, 8, this.LmA);
            AppMethodBeat.o(101795);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Lmz) + g.a.a.a.c(3, 8, this.LmA);
            AppMethodBeat.o(101795);
            return nh;
        } else if (i2 == 2) {
            this.LmA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(101795);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abx abx = (abx) objArr[1];
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
                        abx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(101795);
                    return 0;
                case 2:
                    abx.Lmz = aVar3.UbS.zi();
                    AppMethodBeat.o(101795);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        caa caa = new caa();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = caa.populateBuilderWithField(aVar5, caa, dop.getNextFieldNumber(aVar5))) {
                        }
                        abx.LmA.add(caa);
                    }
                    AppMethodBeat.o(101795);
                    return 0;
                default:
                    AppMethodBeat.o(101795);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101795);
            return -1;
        }
    }
}