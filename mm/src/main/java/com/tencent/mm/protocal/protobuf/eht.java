package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eht extends a {
    public String Nhj;
    public String Nhk;
    public int Nhl;
    public String cri;
    public String msg;
    public int nJK;
    public String patchMd5;
    public String pkK;
    public String title;
    public int versionCode;
    public String xWM;
    public String ynv;
    public String ynw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123719);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.cri == null) {
                b bVar = new b("Not all required fields were included: patchId");
                AppMethodBeat.o(123719);
                throw bVar;
            } else if (this.ynv == null) {
                b bVar2 = new b("Not all required fields were included: newApkMd5");
                AppMethodBeat.o(123719);
                throw bVar2;
            } else if (this.ynw == null) {
                b bVar3 = new b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.o(123719);
                throw bVar3;
            } else if (this.title == null) {
                b bVar4 = new b("Not all required fields were included: title");
                AppMethodBeat.o(123719);
                throw bVar4;
            } else if (this.Nhk == null) {
                b bVar5 = new b("Not all required fields were included: okBtn");
                AppMethodBeat.o(123719);
                throw bVar5;
            } else if (this.xWM == null) {
                b bVar6 = new b("Not all required fields were included: cancelBtn");
                AppMethodBeat.o(123719);
                throw bVar6;
            } else if (this.patchMd5 == null) {
                b bVar7 = new b("Not all required fields were included: patchMd5");
                AppMethodBeat.o(123719);
                throw bVar7;
            } else {
                if (this.cri != null) {
                    aVar.e(1, this.cri);
                }
                if (this.Nhj != null) {
                    aVar.e(2, this.Nhj);
                }
                aVar.aM(3, this.nJK);
                if (this.ynv != null) {
                    aVar.e(4, this.ynv);
                }
                if (this.ynw != null) {
                    aVar.e(5, this.ynw);
                }
                if (this.title != null) {
                    aVar.e(6, this.title);
                }
                if (this.msg != null) {
                    aVar.e(7, this.msg);
                }
                if (this.Nhk != null) {
                    aVar.e(8, this.Nhk);
                }
                if (this.xWM != null) {
                    aVar.e(9, this.xWM);
                }
                if (this.pkK != null) {
                    aVar.e(10, this.pkK);
                }
                if (this.patchMd5 != null) {
                    aVar.e(11, this.patchMd5);
                }
                aVar.aM(12, this.versionCode);
                aVar.aM(13, this.Nhl);
                AppMethodBeat.o(123719);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.cri != null ? g.a.a.b.b.a.f(1, this.cri) + 0 : 0;
            if (this.Nhj != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nhj);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.nJK);
            if (this.ynv != null) {
                bu += g.a.a.b.b.a.f(4, this.ynv);
            }
            if (this.ynw != null) {
                bu += g.a.a.b.b.a.f(5, this.ynw);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(6, this.title);
            }
            if (this.msg != null) {
                bu += g.a.a.b.b.a.f(7, this.msg);
            }
            if (this.Nhk != null) {
                bu += g.a.a.b.b.a.f(8, this.Nhk);
            }
            if (this.xWM != null) {
                bu += g.a.a.b.b.a.f(9, this.xWM);
            }
            if (this.pkK != null) {
                bu += g.a.a.b.b.a.f(10, this.pkK);
            }
            if (this.patchMd5 != null) {
                bu += g.a.a.b.b.a.f(11, this.patchMd5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.versionCode) + g.a.a.b.b.a.bu(13, this.Nhl);
            AppMethodBeat.o(123719);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.cri == null) {
                b bVar8 = new b("Not all required fields were included: patchId");
                AppMethodBeat.o(123719);
                throw bVar8;
            } else if (this.ynv == null) {
                b bVar9 = new b("Not all required fields were included: newApkMd5");
                AppMethodBeat.o(123719);
                throw bVar9;
            } else if (this.ynw == null) {
                b bVar10 = new b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.o(123719);
                throw bVar10;
            } else if (this.title == null) {
                b bVar11 = new b("Not all required fields were included: title");
                AppMethodBeat.o(123719);
                throw bVar11;
            } else if (this.Nhk == null) {
                b bVar12 = new b("Not all required fields were included: okBtn");
                AppMethodBeat.o(123719);
                throw bVar12;
            } else if (this.xWM == null) {
                b bVar13 = new b("Not all required fields were included: cancelBtn");
                AppMethodBeat.o(123719);
                throw bVar13;
            } else if (this.patchMd5 == null) {
                b bVar14 = new b("Not all required fields were included: patchMd5");
                AppMethodBeat.o(123719);
                throw bVar14;
            } else {
                AppMethodBeat.o(123719);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eht eht = (eht) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eht.cri = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 2:
                    eht.Nhj = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 3:
                    eht.nJK = aVar3.UbS.zi();
                    AppMethodBeat.o(123719);
                    return 0;
                case 4:
                    eht.ynv = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 5:
                    eht.ynw = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 6:
                    eht.title = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 7:
                    eht.msg = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 8:
                    eht.Nhk = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 9:
                    eht.xWM = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 10:
                    eht.pkK = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 11:
                    eht.patchMd5 = aVar3.UbS.readString();
                    AppMethodBeat.o(123719);
                    return 0;
                case 12:
                    eht.versionCode = aVar3.UbS.zi();
                    AppMethodBeat.o(123719);
                    return 0;
                case 13:
                    eht.Nhl = aVar3.UbS.zi();
                    AppMethodBeat.o(123719);
                    return 0;
                default:
                    AppMethodBeat.o(123719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123719);
            return -1;
        }
    }
}
