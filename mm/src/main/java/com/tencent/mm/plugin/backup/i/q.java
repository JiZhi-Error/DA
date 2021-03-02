package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class q extends a {
    public String Version;
    public String oTJ;
    public String oUd;
    public String oUe;
    public String oUf;
    public String oUg;
    public long oUh;
    public long oUi;
    public String oUj;
    public b oUk;
    public b oUl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22121);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUd == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.o(22121);
                throw bVar;
            } else if (this.oUe == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.o(22121);
                throw bVar2;
            } else if (this.oUf == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.o(22121);
                throw bVar3;
            } else if (this.oUg == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.o(22121);
                throw bVar4;
            } else if (this.oUj == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: Manufacturer");
                AppMethodBeat.o(22121);
                throw bVar5;
            } else if (this.oTJ == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: Model");
                AppMethodBeat.o(22121);
                throw bVar6;
            } else if (this.Version == null) {
                g.a.a.b bVar7 = new g.a.a.b("Not all required fields were included: Version");
                AppMethodBeat.o(22121);
                throw bVar7;
            } else {
                if (this.oUd != null) {
                    aVar.e(1, this.oUd);
                }
                if (this.oUe != null) {
                    aVar.e(2, this.oUe);
                }
                if (this.oUf != null) {
                    aVar.e(3, this.oUf);
                }
                if (this.oUg != null) {
                    aVar.e(4, this.oUg);
                }
                aVar.bb(5, this.oUh);
                aVar.bb(6, this.oUi);
                if (this.oUj != null) {
                    aVar.e(7, this.oUj);
                }
                if (this.oTJ != null) {
                    aVar.e(8, this.oTJ);
                }
                if (this.Version != null) {
                    aVar.e(9, this.Version);
                }
                if (this.oUk != null) {
                    aVar.c(10, this.oUk);
                }
                if (this.oUl != null) {
                    aVar.c(11, this.oUl);
                }
                AppMethodBeat.o(22121);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.oUd != null ? g.a.a.b.b.a.f(1, this.oUd) + 0 : 0;
            if (this.oUe != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUe);
            }
            if (this.oUf != null) {
                f2 += g.a.a.b.b.a.f(3, this.oUf);
            }
            if (this.oUg != null) {
                f2 += g.a.a.b.b.a.f(4, this.oUg);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.oUh) + g.a.a.b.b.a.r(6, this.oUi);
            if (this.oUj != null) {
                r += g.a.a.b.b.a.f(7, this.oUj);
            }
            if (this.oTJ != null) {
                r += g.a.a.b.b.a.f(8, this.oTJ);
            }
            if (this.Version != null) {
                r += g.a.a.b.b.a.f(9, this.Version);
            }
            if (this.oUk != null) {
                r += g.a.a.b.b.a.b(10, this.oUk);
            }
            if (this.oUl != null) {
                r += g.a.a.b.b.a.b(11, this.oUl);
            }
            AppMethodBeat.o(22121);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oUd == null) {
                g.a.a.b bVar8 = new g.a.a.b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.o(22121);
                throw bVar8;
            } else if (this.oUe == null) {
                g.a.a.b bVar9 = new g.a.a.b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.o(22121);
                throw bVar9;
            } else if (this.oUf == null) {
                g.a.a.b bVar10 = new g.a.a.b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.o(22121);
                throw bVar10;
            } else if (this.oUg == null) {
                g.a.a.b bVar11 = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.o(22121);
                throw bVar11;
            } else if (this.oUj == null) {
                g.a.a.b bVar12 = new g.a.a.b("Not all required fields were included: Manufacturer");
                AppMethodBeat.o(22121);
                throw bVar12;
            } else if (this.oTJ == null) {
                g.a.a.b bVar13 = new g.a.a.b("Not all required fields were included: Model");
                AppMethodBeat.o(22121);
                throw bVar13;
            } else if (this.Version == null) {
                g.a.a.b bVar14 = new g.a.a.b("Not all required fields were included: Version");
                AppMethodBeat.o(22121);
                throw bVar14;
            } else {
                AppMethodBeat.o(22121);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.oUd = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 2:
                    qVar.oUe = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 3:
                    qVar.oUf = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 4:
                    qVar.oUg = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 5:
                    qVar.oUh = aVar3.UbS.zl();
                    AppMethodBeat.o(22121);
                    return 0;
                case 6:
                    qVar.oUi = aVar3.UbS.zl();
                    AppMethodBeat.o(22121);
                    return 0;
                case 7:
                    qVar.oUj = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 8:
                    qVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 9:
                    qVar.Version = aVar3.UbS.readString();
                    AppMethodBeat.o(22121);
                    return 0;
                case 10:
                    qVar.oUk = aVar3.UbS.hPo();
                    AppMethodBeat.o(22121);
                    return 0;
                case 11:
                    qVar.oUl = aVar3.UbS.hPo();
                    AppMethodBeat.o(22121);
                    return 0;
                default:
                    AppMethodBeat.o(22121);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22121);
            return -1;
        }
    }
}
