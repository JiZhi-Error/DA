package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class azz extends a {
    public long object_id;
    public String object_nonce_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209625);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.object_id);
            if (this.object_nonce_id != null) {
                aVar.e(2, this.object_nonce_id);
            }
            AppMethodBeat.o(209625);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.object_id) + 0;
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(2, this.object_nonce_id);
            }
            AppMethodBeat.o(209625);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209625);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azz azz = (azz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azz.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209625);
                    return 0;
                case 2:
                    azz.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209625);
                    return 0;
                default:
                    AppMethodBeat.o(209625);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209625);
            return -1;
        }
    }
}
