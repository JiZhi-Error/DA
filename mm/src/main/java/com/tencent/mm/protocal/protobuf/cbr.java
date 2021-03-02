package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbr extends a {
    public String aeskey;
    public String fileid;
    public String filemd5;
    public int guR;
    public int guS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194544);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.fileid != null) {
                aVar.e(1, this.fileid);
            }
            if (this.aeskey != null) {
                aVar.e(2, this.aeskey);
            }
            if (this.filemd5 != null) {
                aVar.e(3, this.filemd5);
            }
            aVar.aM(4, this.guR);
            aVar.aM(5, this.guS);
            AppMethodBeat.o(194544);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.fileid != null ? g.a.a.b.b.a.f(1, this.fileid) + 0 : 0;
            if (this.aeskey != null) {
                f2 += g.a.a.b.b.a.f(2, this.aeskey);
            }
            if (this.filemd5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.filemd5);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.guR) + g.a.a.b.b.a.bu(5, this.guS);
            AppMethodBeat.o(194544);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194544);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbr cbr = (cbr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbr.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(194544);
                    return 0;
                case 2:
                    cbr.aeskey = aVar3.UbS.readString();
                    AppMethodBeat.o(194544);
                    return 0;
                case 3:
                    cbr.filemd5 = aVar3.UbS.readString();
                    AppMethodBeat.o(194544);
                    return 0;
                case 4:
                    cbr.guR = aVar3.UbS.zi();
                    AppMethodBeat.o(194544);
                    return 0;
                case 5:
                    cbr.guS = aVar3.UbS.zi();
                    AppMethodBeat.o(194544);
                    return 0;
                default:
                    AppMethodBeat.o(194544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194544);
            return -1;
        }
    }
}
