package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ank extends a {
    public boolean Lvh = false;
    public boolean Lvi = false;
    public boolean LxX = false;
    public boolean LxY = false;
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;

    public final ank bho(String str) {
        this.title = str;
        this.Lvh = true;
        return this;
    }

    public final ank bhp(String str) {
        this.desc = str;
        this.Lvi = true;
        return this;
    }

    public final ank bhq(String str) {
        this.thumbUrl = str;
        this.LxX = true;
        return this;
    }

    public final ank bhr(String str) {
        this.info = str;
        this.LxY = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127484);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.e(3, this.thumbUrl);
            }
            if (this.info != null) {
                aVar.e(4, this.info);
            }
            AppMethodBeat.o(127484);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.thumbUrl);
            }
            if (this.info != null) {
                f2 += g.a.a.b.b.a.f(4, this.info);
            }
            AppMethodBeat.o(127484);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127484);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ank ank = (ank) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ank.title = aVar3.UbS.readString();
                    ank.Lvh = true;
                    AppMethodBeat.o(127484);
                    return 0;
                case 2:
                    ank.desc = aVar3.UbS.readString();
                    ank.Lvi = true;
                    AppMethodBeat.o(127484);
                    return 0;
                case 3:
                    ank.thumbUrl = aVar3.UbS.readString();
                    ank.LxX = true;
                    AppMethodBeat.o(127484);
                    return 0;
                case 4:
                    ank.info = aVar3.UbS.readString();
                    ank.LxY = true;
                    AppMethodBeat.o(127484);
                    return 0;
                default:
                    AppMethodBeat.o(127484);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127484);
            return -1;
        }
    }
}
