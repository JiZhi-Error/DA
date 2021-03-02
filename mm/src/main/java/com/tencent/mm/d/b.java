package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public String apkMd5;
    public int autoAddAccount;
    public int channelId;
    public String dji;
    public String djj;
    public boolean djk;
    public boolean djl;
    public String profileDeviceType;
    public int updateMode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(944);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: apkMd5");
                AppMethodBeat.o(944);
                throw bVar;
            }
            if (this.apkMd5 != null) {
                aVar.e(1, this.apkMd5);
            }
            aVar.aM(2, this.channelId);
            if (this.profileDeviceType != null) {
                aVar.e(3, this.profileDeviceType);
            }
            aVar.aM(4, this.updateMode);
            if (this.dji != null) {
                aVar.e(5, this.dji);
            }
            if (this.djj != null) {
                aVar.e(6, this.djj);
            }
            aVar.cc(7, this.djk);
            aVar.aM(8, this.autoAddAccount);
            aVar.cc(9, this.djl);
            AppMethodBeat.o(944);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.apkMd5 != null ? g.a.a.b.b.a.f(1, this.apkMd5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.channelId);
            if (this.profileDeviceType != null) {
                f2 += g.a.a.b.b.a.f(3, this.profileDeviceType);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.updateMode);
            if (this.dji != null) {
                bu += g.a.a.b.b.a.f(5, this.dji);
            }
            if (this.djj != null) {
                bu += g.a.a.b.b.a.f(6, this.djj);
            }
            int fS = bu + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.bu(8, this.autoAddAccount) + g.a.a.b.b.a.fS(9) + 1;
            AppMethodBeat.o(944);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.apkMd5 == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: apkMd5");
                AppMethodBeat.o(944);
                throw bVar2;
            }
            AppMethodBeat.o(944);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar3 = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar3.apkMd5 = aVar3.UbS.readString();
                    AppMethodBeat.o(944);
                    return 0;
                case 2:
                    bVar3.channelId = aVar3.UbS.zi();
                    AppMethodBeat.o(944);
                    return 0;
                case 3:
                    bVar3.profileDeviceType = aVar3.UbS.readString();
                    AppMethodBeat.o(944);
                    return 0;
                case 4:
                    bVar3.updateMode = aVar3.UbS.zi();
                    AppMethodBeat.o(944);
                    return 0;
                case 5:
                    bVar3.dji = aVar3.UbS.readString();
                    AppMethodBeat.o(944);
                    return 0;
                case 6:
                    bVar3.djj = aVar3.UbS.readString();
                    AppMethodBeat.o(944);
                    return 0;
                case 7:
                    bVar3.djk = aVar3.UbS.yZ();
                    AppMethodBeat.o(944);
                    return 0;
                case 8:
                    bVar3.autoAddAccount = aVar3.UbS.zi();
                    AppMethodBeat.o(944);
                    return 0;
                case 9:
                    bVar3.djl = aVar3.UbS.yZ();
                    AppMethodBeat.o(944);
                    return 0;
                default:
                    AppMethodBeat.o(944);
                    return -1;
            }
        } else {
            AppMethodBeat.o(944);
            return -1;
        }
    }
}
