package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class az extends a {
    public long Bto;
    public long uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198644);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uin);
            aVar.bb(2, this.Bto);
            AppMethodBeat.o(198644);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uin) + 0 + g.a.a.b.b.a.r(2, this.Bto);
            AppMethodBeat.o(198644);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198644);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azVar.uin = aVar3.UbS.zl();
                    AppMethodBeat.o(198644);
                    return 0;
                case 2:
                    azVar.Bto = aVar3.UbS.zl();
                    AppMethodBeat.o(198644);
                    return 0;
                default:
                    AppMethodBeat.o(198644);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198644);
            return -1;
        }
    }
}
