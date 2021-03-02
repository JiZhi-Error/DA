package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class m extends a {
    public String oTH;
    public String oTI;
    public String oTJ;
    public String oTK;
    public String oTL;
    public int oTM;
    public long oTN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22117);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oTH == null) {
                b bVar = new b("Not all required fields were included: DeviceID");
                AppMethodBeat.o(22117);
                throw bVar;
            } else if (this.oTI == null) {
                b bVar2 = new b("Not all required fields were included: DeviceName");
                AppMethodBeat.o(22117);
                throw bVar2;
            } else if (this.oTJ == null) {
                b bVar3 = new b("Not all required fields were included: Model");
                AppMethodBeat.o(22117);
                throw bVar3;
            } else if (this.oTK == null) {
                b bVar4 = new b("Not all required fields were included: SystemName");
                AppMethodBeat.o(22117);
                throw bVar4;
            } else if (this.oTL == null) {
                b bVar5 = new b("Not all required fields were included: SystemVersion");
                AppMethodBeat.o(22117);
                throw bVar5;
            } else {
                if (this.oTH != null) {
                    aVar.e(1, this.oTH);
                }
                if (this.oTI != null) {
                    aVar.e(2, this.oTI);
                }
                if (this.oTJ != null) {
                    aVar.e(3, this.oTJ);
                }
                if (this.oTK != null) {
                    aVar.e(4, this.oTK);
                }
                if (this.oTL != null) {
                    aVar.e(5, this.oTL);
                }
                aVar.aM(6, this.oTM);
                aVar.bb(7, this.oTN);
                AppMethodBeat.o(22117);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.oTH != null ? g.a.a.b.b.a.f(1, this.oTH) + 0 : 0;
            if (this.oTI != null) {
                f2 += g.a.a.b.b.a.f(2, this.oTI);
            }
            if (this.oTJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oTJ);
            }
            if (this.oTK != null) {
                f2 += g.a.a.b.b.a.f(4, this.oTK);
            }
            if (this.oTL != null) {
                f2 += g.a.a.b.b.a.f(5, this.oTL);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.oTM) + g.a.a.b.b.a.r(7, this.oTN);
            AppMethodBeat.o(22117);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTH == null) {
                b bVar6 = new b("Not all required fields were included: DeviceID");
                AppMethodBeat.o(22117);
                throw bVar6;
            } else if (this.oTI == null) {
                b bVar7 = new b("Not all required fields were included: DeviceName");
                AppMethodBeat.o(22117);
                throw bVar7;
            } else if (this.oTJ == null) {
                b bVar8 = new b("Not all required fields were included: Model");
                AppMethodBeat.o(22117);
                throw bVar8;
            } else if (this.oTK == null) {
                b bVar9 = new b("Not all required fields were included: SystemName");
                AppMethodBeat.o(22117);
                throw bVar9;
            } else if (this.oTL == null) {
                b bVar10 = new b("Not all required fields were included: SystemVersion");
                AppMethodBeat.o(22117);
                throw bVar10;
            } else {
                AppMethodBeat.o(22117);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.oTH = aVar3.UbS.readString();
                    AppMethodBeat.o(22117);
                    return 0;
                case 2:
                    mVar.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(22117);
                    return 0;
                case 3:
                    mVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(22117);
                    return 0;
                case 4:
                    mVar.oTK = aVar3.UbS.readString();
                    AppMethodBeat.o(22117);
                    return 0;
                case 5:
                    mVar.oTL = aVar3.UbS.readString();
                    AppMethodBeat.o(22117);
                    return 0;
                case 6:
                    mVar.oTM = aVar3.UbS.zi();
                    AppMethodBeat.o(22117);
                    return 0;
                case 7:
                    mVar.oTN = aVar3.UbS.zl();
                    AppMethodBeat.o(22117);
                    return 0;
                default:
                    AppMethodBeat.o(22117);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22117);
            return -1;
        }
    }
}
