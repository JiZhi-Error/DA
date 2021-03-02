package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class azk extends a {
    public String LJh;
    public String LJi;
    public String albumName;
    public String artist;
    public String name;
    public String wWb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209612);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.wWb != null) {
                aVar.e(1, this.wWb);
            }
            if (this.LJh != null) {
                aVar.e(2, this.LJh);
            }
            if (this.name != null) {
                aVar.e(3, this.name);
            }
            if (this.artist != null) {
                aVar.e(4, this.artist);
            }
            if (this.albumName != null) {
                aVar.e(5, this.albumName);
            }
            if (this.LJi != null) {
                aVar.e(6, this.LJi);
            }
            AppMethodBeat.o(209612);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.wWb != null ? g.a.a.b.b.a.f(1, this.wWb) + 0 : 0;
            if (this.LJh != null) {
                f2 += g.a.a.b.b.a.f(2, this.LJh);
            }
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(3, this.name);
            }
            if (this.artist != null) {
                f2 += g.a.a.b.b.a.f(4, this.artist);
            }
            if (this.albumName != null) {
                f2 += g.a.a.b.b.a.f(5, this.albumName);
            }
            if (this.LJi != null) {
                f2 += g.a.a.b.b.a.f(6, this.LJi);
            }
            AppMethodBeat.o(209612);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209612);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azk azk = (azk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azk.wWb = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                case 2:
                    azk.LJh = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                case 3:
                    azk.name = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                case 4:
                    azk.artist = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                case 5:
                    azk.albumName = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                case 6:
                    azk.LJi = aVar3.UbS.readString();
                    AppMethodBeat.o(209612);
                    return 0;
                default:
                    AppMethodBeat.o(209612);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209612);
            return -1;
        }
    }
}
