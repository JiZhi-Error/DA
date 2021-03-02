package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ana extends a {
    public boolean Lvh = false;
    public boolean Lvi = false;
    public boolean LxX = false;
    public boolean LxY = false;
    public boolean LxZ = false;
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public int type;

    public final ana bgY(String str) {
        this.title = str;
        this.Lvh = true;
        return this;
    }

    public final ana bgZ(String str) {
        this.desc = str;
        this.Lvi = true;
        return this;
    }

    public final ana bha(String str) {
        this.thumbUrl = str;
        this.LxX = true;
        return this;
    }

    public final ana bhb(String str) {
        this.info = str;
        this.LxY = true;
        return this;
    }

    public final ana ajj(int i2) {
        this.type = i2;
        this.LxZ = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127472);
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
            if (this.LxZ) {
                aVar.aM(5, this.type);
            }
            AppMethodBeat.o(127472);
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
            if (this.LxZ) {
                f2 += g.a.a.b.b.a.bu(5, this.type);
            }
            AppMethodBeat.o(127472);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127472);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ana ana = (ana) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ana.title = aVar3.UbS.readString();
                    ana.Lvh = true;
                    AppMethodBeat.o(127472);
                    return 0;
                case 2:
                    ana.desc = aVar3.UbS.readString();
                    ana.Lvi = true;
                    AppMethodBeat.o(127472);
                    return 0;
                case 3:
                    ana.thumbUrl = aVar3.UbS.readString();
                    ana.LxX = true;
                    AppMethodBeat.o(127472);
                    return 0;
                case 4:
                    ana.info = aVar3.UbS.readString();
                    ana.LxY = true;
                    AppMethodBeat.o(127472);
                    return 0;
                case 5:
                    ana.type = aVar3.UbS.zi();
                    ana.LxZ = true;
                    AppMethodBeat.o(127472);
                    return 0;
                default:
                    AppMethodBeat.o(127472);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127472);
            return -1;
        }
    }
}
