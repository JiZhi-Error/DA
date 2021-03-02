package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dsb extends a {
    public int Height;
    public int MUI;
    public String ThumbUrl;
    public String Url;
    public int Width;
    public int xuT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187883);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xuT);
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            aVar.aM(3, this.Width);
            aVar.aM(4, this.Height);
            if (this.ThumbUrl != null) {
                aVar.e(5, this.ThumbUrl);
            }
            aVar.aM(6, this.MUI);
            AppMethodBeat.o(187883);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xuT) + 0;
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(2, this.Url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height);
            if (this.ThumbUrl != null) {
                bu2 += g.a.a.b.b.a.f(5, this.ThumbUrl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.MUI);
            AppMethodBeat.o(187883);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187883);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsb dsb = (dsb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsb.xuT = aVar3.UbS.zi();
                    AppMethodBeat.o(187883);
                    return 0;
                case 2:
                    dsb.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(187883);
                    return 0;
                case 3:
                    dsb.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(187883);
                    return 0;
                case 4:
                    dsb.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(187883);
                    return 0;
                case 5:
                    dsb.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(187883);
                    return 0;
                case 6:
                    dsb.MUI = aVar3.UbS.zi();
                    AppMethodBeat.o(187883);
                    return 0;
                default:
                    AppMethodBeat.o(187883);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187883);
            return -1;
        }
    }
}
