package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ahc extends a {
    public String LqM;
    public String deviceBrand;
    public String deviceModel;
    public String osName;
    public String osVersion;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32189);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.deviceModel != null) {
                aVar.e(1, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.e(2, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.e(3, this.osName);
            }
            if (this.osVersion != null) {
                aVar.e(4, this.osVersion);
            }
            if (this.LqM != null) {
                aVar.e(5, this.LqM);
            }
            AppMethodBeat.o(32189);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.deviceModel != null ? g.a.a.b.b.a.f(1, this.deviceModel) + 0 : 0;
            if (this.deviceBrand != null) {
                f2 += g.a.a.b.b.a.f(2, this.deviceBrand);
            }
            if (this.osName != null) {
                f2 += g.a.a.b.b.a.f(3, this.osName);
            }
            if (this.osVersion != null) {
                f2 += g.a.a.b.b.a.f(4, this.osVersion);
            }
            if (this.LqM != null) {
                f2 += g.a.a.b.b.a.f(5, this.LqM);
            }
            AppMethodBeat.o(32189);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32189);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahc ahc = (ahc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahc.deviceModel = aVar3.UbS.readString();
                    AppMethodBeat.o(32189);
                    return 0;
                case 2:
                    ahc.deviceBrand = aVar3.UbS.readString();
                    AppMethodBeat.o(32189);
                    return 0;
                case 3:
                    ahc.osName = aVar3.UbS.readString();
                    AppMethodBeat.o(32189);
                    return 0;
                case 4:
                    ahc.osVersion = aVar3.UbS.readString();
                    AppMethodBeat.o(32189);
                    return 0;
                case 5:
                    ahc.LqM = aVar3.UbS.readString();
                    AppMethodBeat.o(32189);
                    return 0;
                default:
                    AppMethodBeat.o(32189);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32189);
            return -1;
        }
    }
}
