package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class v extends a {
    public g GaU;
    public LinkedList<String> GaV = new LinkedList<>();
    public boolean GaW;
    public String GaX;
    public int GaY;
    public int GaZ;
    public long Gba;
    public boolean Gbb;
    public String VdX;
    public String errMsg;
    public String thumbPath;

    public v() {
        AppMethodBeat.i(216012);
        AppMethodBeat.o(216012);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(216013);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.GaU != null) {
                aVar.ni(1, this.GaU.computeSize());
                this.GaU.writeFields(aVar);
            }
            aVar.e(2, 1, this.GaV);
            aVar.cc(3, this.GaW);
            if (this.GaX != null) {
                aVar.e(4, this.GaX);
            }
            if (this.thumbPath != null) {
                aVar.e(5, this.thumbPath);
            }
            aVar.aM(6, this.GaY);
            aVar.aM(7, this.GaZ);
            aVar.bb(8, this.Gba);
            aVar.cc(9, this.Gbb);
            if (this.errMsg != null) {
                aVar.e(10, this.errMsg);
            }
            if (this.VdX != null) {
                aVar.e(11, this.VdX);
            }
            AppMethodBeat.o(216013);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.GaU != null ? g.a.a.a.nh(1, this.GaU.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.GaV) + g.a.a.b.b.a.fS(3) + 1;
            if (this.GaX != null) {
                nh += g.a.a.b.b.a.f(4, this.GaX);
            }
            if (this.thumbPath != null) {
                nh += g.a.a.b.b.a.f(5, this.thumbPath);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.GaY) + g.a.a.b.b.a.bu(7, this.GaZ) + g.a.a.b.b.a.r(8, this.Gba) + g.a.a.b.b.a.fS(9) + 1;
            if (this.errMsg != null) {
                bu += g.a.a.b.b.a.f(10, this.errMsg);
            }
            if (this.VdX != null) {
                bu += g.a.a.b.b.a.f(11, this.VdX);
            }
            AppMethodBeat.o(216013);
            return bu;
        } else if (i2 == 2) {
            this.GaV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(216013);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        vVar.GaU = gVar;
                    }
                    AppMethodBeat.o(216013);
                    return 0;
                case 2:
                    vVar.GaV.add(aVar3.UbS.readString());
                    AppMethodBeat.o(216013);
                    return 0;
                case 3:
                    vVar.GaW = aVar3.UbS.yZ();
                    AppMethodBeat.o(216013);
                    return 0;
                case 4:
                    vVar.GaX = aVar3.UbS.readString();
                    AppMethodBeat.o(216013);
                    return 0;
                case 5:
                    vVar.thumbPath = aVar3.UbS.readString();
                    AppMethodBeat.o(216013);
                    return 0;
                case 6:
                    vVar.GaY = aVar3.UbS.zi();
                    AppMethodBeat.o(216013);
                    return 0;
                case 7:
                    vVar.GaZ = aVar3.UbS.zi();
                    AppMethodBeat.o(216013);
                    return 0;
                case 8:
                    vVar.Gba = aVar3.UbS.zl();
                    AppMethodBeat.o(216013);
                    return 0;
                case 9:
                    vVar.Gbb = aVar3.UbS.yZ();
                    AppMethodBeat.o(216013);
                    return 0;
                case 10:
                    vVar.errMsg = aVar3.UbS.readString();
                    AppMethodBeat.o(216013);
                    return 0;
                case 11:
                    vVar.VdX = aVar3.UbS.readString();
                    AppMethodBeat.o(216013);
                    return 0;
                default:
                    AppMethodBeat.o(216013);
                    return -1;
            }
        } else {
            AppMethodBeat.o(216013);
            return -1;
        }
    }
}
