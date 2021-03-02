package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class nx extends a {
    public oa KTw;
    public String KTx;
    public String KTy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124421);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTw != null) {
                aVar.ni(1, this.KTw.computeSize());
                this.KTw.writeFields(aVar);
            }
            if (this.KTx != null) {
                aVar.e(2, this.KTx);
            }
            if (this.KTy != null) {
                aVar.e(3, this.KTy);
            }
            AppMethodBeat.o(124421);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KTw != null ? g.a.a.a.nh(1, this.KTw.computeSize()) + 0 : 0;
            if (this.KTx != null) {
                nh += g.a.a.b.b.a.f(2, this.KTx);
            }
            if (this.KTy != null) {
                nh += g.a.a.b.b.a.f(3, this.KTy);
            }
            AppMethodBeat.o(124421);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124421);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nx nxVar = (nx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        oa oaVar = new oa();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oaVar.populateBuilderWithField(aVar4, oaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nxVar.KTw = oaVar;
                    }
                    AppMethodBeat.o(124421);
                    return 0;
                case 2:
                    nxVar.KTx = aVar3.UbS.readString();
                    AppMethodBeat.o(124421);
                    return 0;
                case 3:
                    nxVar.KTy = aVar3.UbS.readString();
                    AppMethodBeat.o(124421);
                    return 0;
                default:
                    AppMethodBeat.o(124421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124421);
            return -1;
        }
    }
}
