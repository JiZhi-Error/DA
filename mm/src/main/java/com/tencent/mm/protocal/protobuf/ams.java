package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ams extends a {
    public boolean LxN = false;
    public boolean LxO = false;
    public boolean LxP = false;
    public boolean LxQ = false;
    public boolean LxR = false;
    public int dRt;
    public String dWi;
    public String label;
    public double lat;
    public double lng;

    public final ams B(double d2) {
        this.lng = d2;
        this.LxN = true;
        return this;
    }

    public final ams C(double d2) {
        this.lat = d2;
        this.LxO = true;
        return this;
    }

    public final ams aji(int i2) {
        this.dRt = i2;
        this.LxP = true;
        return this;
    }

    public final ams bgW(String str) {
        this.label = str;
        this.LxQ = true;
        return this;
    }

    public final ams bgX(String str) {
        this.dWi = str;
        this.LxR = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127466);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LxN) {
                aVar.e(1, this.lng);
            }
            if (this.LxO) {
                aVar.e(2, this.lat);
            }
            if (this.LxP) {
                aVar.aM(3, this.dRt);
            }
            if (this.label != null) {
                aVar.e(4, this.label);
            }
            if (this.dWi != null) {
                aVar.e(5, this.dWi);
            }
            AppMethodBeat.o(127466);
            return 0;
        } else if (i2 == 1) {
            int fS = this.LxN ? g.a.a.b.b.a.fS(1) + 8 + 0 : 0;
            if (this.LxO) {
                fS += g.a.a.b.b.a.fS(2) + 8;
            }
            if (this.LxP) {
                fS += g.a.a.b.b.a.bu(3, this.dRt);
            }
            if (this.label != null) {
                fS += g.a.a.b.b.a.f(4, this.label);
            }
            if (this.dWi != null) {
                fS += g.a.a.b.b.a.f(5, this.dWi);
            }
            AppMethodBeat.o(127466);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127466);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ams ams = (ams) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ams.lng = Double.longBitsToDouble(aVar3.UbS.zn());
                    ams.LxN = true;
                    AppMethodBeat.o(127466);
                    return 0;
                case 2:
                    ams.lat = Double.longBitsToDouble(aVar3.UbS.zn());
                    ams.LxO = true;
                    AppMethodBeat.o(127466);
                    return 0;
                case 3:
                    ams.dRt = aVar3.UbS.zi();
                    ams.LxP = true;
                    AppMethodBeat.o(127466);
                    return 0;
                case 4:
                    ams.label = aVar3.UbS.readString();
                    ams.LxQ = true;
                    AppMethodBeat.o(127466);
                    return 0;
                case 5:
                    ams.dWi = aVar3.UbS.readString();
                    ams.LxR = true;
                    AppMethodBeat.o(127466);
                    return 0;
                default:
                    AppMethodBeat.o(127466);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127466);
            return -1;
        }
    }
}
