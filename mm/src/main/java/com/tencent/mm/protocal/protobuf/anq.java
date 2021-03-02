package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class anq extends a {
    public boolean Lvh = false;
    public boolean Lvi = false;
    public boolean Lws = false;
    public boolean LxX = false;
    public String LyC;
    public boolean LyD = false;
    public int LyE;
    public boolean LyF = false;
    public boolean LyG = false;
    public String LyH;
    public boolean LyI = false;
    public String canvasPageXml;
    public int contentattr;
    public String desc;
    public String thumbUrl;
    public String title;

    public final anq bhs(String str) {
        this.title = str;
        this.Lvh = true;
        return this;
    }

    public final anq bht(String str) {
        this.desc = str;
        this.Lvi = true;
        return this;
    }

    public final anq bhu(String str) {
        this.LyC = str;
        this.LyD = true;
        return this;
    }

    public final anq bhv(String str) {
        this.thumbUrl = str;
        this.LxX = true;
        return this;
    }

    public final anq ajn(int i2) {
        this.LyE = i2;
        this.LyF = true;
        return this;
    }

    public final anq ajo(int i2) {
        this.contentattr = i2;
        this.LyG = true;
        return this;
    }

    public final anq bhw(String str) {
        this.canvasPageXml = str;
        this.Lws = true;
        return this;
    }

    public final anq bhx(String str) {
        this.LyH = str;
        this.LyI = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127493);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.LyC != null) {
                aVar.e(3, this.LyC);
            }
            if (this.thumbUrl != null) {
                aVar.e(4, this.thumbUrl);
            }
            if (this.LyF) {
                aVar.aM(5, this.LyE);
            }
            if (this.LyG) {
                aVar.aM(6, this.contentattr);
            }
            if (this.canvasPageXml != null) {
                aVar.e(7, this.canvasPageXml);
            }
            if (this.LyH != null) {
                aVar.e(8, this.LyH);
            }
            AppMethodBeat.o(127493);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.LyC != null) {
                f2 += g.a.a.b.b.a.f(3, this.LyC);
            }
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.thumbUrl);
            }
            if (this.LyF) {
                f2 += g.a.a.b.b.a.bu(5, this.LyE);
            }
            if (this.LyG) {
                f2 += g.a.a.b.b.a.bu(6, this.contentattr);
            }
            if (this.canvasPageXml != null) {
                f2 += g.a.a.b.b.a.f(7, this.canvasPageXml);
            }
            if (this.LyH != null) {
                f2 += g.a.a.b.b.a.f(8, this.LyH);
            }
            AppMethodBeat.o(127493);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127493);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anq anq = (anq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anq.title = aVar3.UbS.readString();
                    anq.Lvh = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 2:
                    anq.desc = aVar3.UbS.readString();
                    anq.Lvi = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 3:
                    anq.LyC = aVar3.UbS.readString();
                    anq.LyD = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 4:
                    anq.thumbUrl = aVar3.UbS.readString();
                    anq.LxX = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 5:
                    anq.LyE = aVar3.UbS.zi();
                    anq.LyF = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 6:
                    anq.contentattr = aVar3.UbS.zi();
                    anq.LyG = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 7:
                    anq.canvasPageXml = aVar3.UbS.readString();
                    anq.Lws = true;
                    AppMethodBeat.o(127493);
                    return 0;
                case 8:
                    anq.LyH = aVar3.UbS.readString();
                    anq.LyI = true;
                    AppMethodBeat.o(127493);
                    return 0;
                default:
                    AppMethodBeat.o(127493);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127493);
            return -1;
        }
    }
}
