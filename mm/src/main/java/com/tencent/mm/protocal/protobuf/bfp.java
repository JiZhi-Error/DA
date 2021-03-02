package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfp extends a {
    public long feedId;
    public String objectNonceId;
    public int scene;
    public String sessionBuffer;
    public bbn ttO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209719);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.feedId);
            if (this.objectNonceId != null) {
                aVar.e(2, this.objectNonceId);
            }
            aVar.aM(3, this.scene);
            if (this.ttO != null) {
                aVar.ni(4, this.ttO.computeSize());
                this.ttO.writeFields(aVar);
            }
            if (this.sessionBuffer != null) {
                aVar.e(5, this.sessionBuffer);
            }
            AppMethodBeat.o(209719);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.feedId) + 0;
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(2, this.objectNonceId);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.scene);
            if (this.ttO != null) {
                bu += g.a.a.a.nh(4, this.ttO.computeSize());
            }
            if (this.sessionBuffer != null) {
                bu += g.a.a.b.b.a.f(5, this.sessionBuffer);
            }
            AppMethodBeat.o(209719);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209719);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfp bfp = (bfp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bfp.feedId = aVar3.UbS.zl();
                    AppMethodBeat.o(209719);
                    return 0;
                case 2:
                    bfp.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209719);
                    return 0;
                case 3:
                    bfp.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209719);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bbn bbn = new bbn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bbn.populateBuilderWithField(aVar4, bbn, a.getNextFieldNumber(aVar4))) {
                        }
                        bfp.ttO = bbn;
                    }
                    AppMethodBeat.o(209719);
                    return 0;
                case 5:
                    bfp.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209719);
                    return 0;
                default:
                    AppMethodBeat.o(209719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209719);
            return -1;
        }
    }
}
