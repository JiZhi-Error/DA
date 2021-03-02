package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class anh extends a {
    public String LxA;
    public boolean LxB = false;
    public boolean LxC = false;
    public boolean LxD = false;
    public boolean LxE = false;
    public boolean LxF = false;
    public String LxG;
    public boolean LxH = false;
    public boolean LxI = false;
    public boolean Lxw = false;
    public boolean Lxx = false;
    public boolean Lxy = false;
    public String Lyi;
    public boolean Lyj = false;
    public String appId;
    public long createTime;
    public String dCl;
    public String dRL;
    public String edD;
    public boolean iXH = false;
    public String link;
    public String msgId;
    public int sourceType;
    public String toUser;

    public final anh ajm(int i2) {
        this.sourceType = i2;
        this.Lxw = true;
        return this;
    }

    public final anh bhf(String str) {
        this.dRL = str;
        this.Lxx = true;
        return this;
    }

    public final anh bhg(String str) {
        this.toUser = str;
        this.Lxy = true;
        return this;
    }

    public final anh bhh(String str) {
        this.Lyi = str;
        this.Lyj = true;
        return this;
    }

    public final anh bhi(String str) {
        this.LxA = str;
        this.LxB = true;
        return this;
    }

    public final anh MA(long j2) {
        this.createTime = j2;
        this.iXH = true;
        return this;
    }

    public final anh bhj(String str) {
        this.msgId = str;
        this.LxC = true;
        return this;
    }

    public final anh bhk(String str) {
        this.edD = str;
        this.LxD = true;
        return this;
    }

    public final anh bhl(String str) {
        this.appId = str;
        this.LxE = true;
        return this;
    }

    public final anh bhm(String str) {
        this.link = str;
        this.LxF = true;
        return this;
    }

    public final anh bhn(String str) {
        this.dCl = str;
        this.LxI = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127481);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (!this.Lxw) {
                b bVar = new b("Not all required fields were included: sourceType");
                AppMethodBeat.o(127481);
                throw bVar;
            }
            if (this.Lxw) {
                aVar.aM(1, this.sourceType);
            }
            if (this.dRL != null) {
                aVar.e(2, this.dRL);
            }
            if (this.toUser != null) {
                aVar.e(3, this.toUser);
            }
            if (this.Lyi != null) {
                aVar.e(4, this.Lyi);
            }
            if (this.LxA != null) {
                aVar.e(5, this.LxA);
            }
            if (this.iXH) {
                aVar.bb(6, this.createTime);
            }
            if (this.msgId != null) {
                aVar.e(7, this.msgId);
            }
            if (this.edD != null) {
                aVar.e(8, this.edD);
            }
            if (this.appId != null) {
                aVar.e(9, this.appId);
            }
            if (this.link != null) {
                aVar.e(10, this.link);
            }
            if (this.LxG != null) {
                aVar.e(11, this.LxG);
            }
            if (this.dCl != null) {
                aVar.e(12, this.dCl);
            }
            AppMethodBeat.o(127481);
            return 0;
        } else if (i2 == 1) {
            int bu = this.Lxw ? g.a.a.b.b.a.bu(1, this.sourceType) + 0 : 0;
            if (this.dRL != null) {
                bu += g.a.a.b.b.a.f(2, this.dRL);
            }
            if (this.toUser != null) {
                bu += g.a.a.b.b.a.f(3, this.toUser);
            }
            if (this.Lyi != null) {
                bu += g.a.a.b.b.a.f(4, this.Lyi);
            }
            if (this.LxA != null) {
                bu += g.a.a.b.b.a.f(5, this.LxA);
            }
            if (this.iXH) {
                bu += g.a.a.b.b.a.r(6, this.createTime);
            }
            if (this.msgId != null) {
                bu += g.a.a.b.b.a.f(7, this.msgId);
            }
            if (this.edD != null) {
                bu += g.a.a.b.b.a.f(8, this.edD);
            }
            if (this.appId != null) {
                bu += g.a.a.b.b.a.f(9, this.appId);
            }
            if (this.link != null) {
                bu += g.a.a.b.b.a.f(10, this.link);
            }
            if (this.LxG != null) {
                bu += g.a.a.b.b.a.f(11, this.LxG);
            }
            if (this.dCl != null) {
                bu += g.a.a.b.b.a.f(12, this.dCl);
            }
            AppMethodBeat.o(127481);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (!this.Lxw) {
                b bVar2 = new b("Not all required fields were included: sourceType");
                AppMethodBeat.o(127481);
                throw bVar2;
            }
            AppMethodBeat.o(127481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anh anh = (anh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anh.sourceType = aVar3.UbS.zi();
                    anh.Lxw = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 2:
                    anh.dRL = aVar3.UbS.readString();
                    anh.Lxx = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 3:
                    anh.toUser = aVar3.UbS.readString();
                    anh.Lxy = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 4:
                    anh.Lyi = aVar3.UbS.readString();
                    anh.Lyj = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 5:
                    anh.LxA = aVar3.UbS.readString();
                    anh.LxB = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 6:
                    anh.createTime = aVar3.UbS.zl();
                    anh.iXH = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 7:
                    anh.msgId = aVar3.UbS.readString();
                    anh.LxC = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 8:
                    anh.edD = aVar3.UbS.readString();
                    anh.LxD = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 9:
                    anh.appId = aVar3.UbS.readString();
                    anh.LxE = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 10:
                    anh.link = aVar3.UbS.readString();
                    anh.LxF = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 11:
                    anh.LxG = aVar3.UbS.readString();
                    anh.LxH = true;
                    AppMethodBeat.o(127481);
                    return 0;
                case 12:
                    anh.dCl = aVar3.UbS.readString();
                    anh.LxI = true;
                    AppMethodBeat.o(127481);
                    return 0;
                default:
                    AppMethodBeat.o(127481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127481);
            return -1;
        }
    }
}
