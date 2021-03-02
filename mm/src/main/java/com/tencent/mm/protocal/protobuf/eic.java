package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public class eic extends a {
    public long DPz;
    public String ISo;
    public String Nhr;
    public String Nhs;
    public String hFF;
    public String md5;
    public int pCV = -1;
    public String pkK;
    public int reportId;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224543);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ISo == null) {
                b bVar = new b("Not all required fields were included: initUrl");
                AppMethodBeat.o(224543);
                throw bVar;
            } else if (this.Nhr == null) {
                b bVar2 = new b("Not all required fields were included: initFilePath");
                AppMethodBeat.o(224543);
                throw bVar2;
            } else if (this.md5 == null) {
                b bVar3 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(224543);
                throw bVar3;
            } else if (this.hFF == null) {
                b bVar4 = new b("Not all required fields were included: uid");
                AppMethodBeat.o(224543);
                throw bVar4;
            } else if (this.Nhs == null) {
                b bVar5 = new b("Not all required fields were included: headers");
                AppMethodBeat.o(224543);
                throw bVar5;
            } else {
                aVar.aM(1, this.pCV);
                aVar.aM(2, this.version);
                if (this.ISo != null) {
                    aVar.e(3, this.ISo);
                }
                if (this.Nhr != null) {
                    aVar.e(4, this.Nhr);
                }
                if (this.md5 != null) {
                    aVar.e(5, this.md5);
                }
                if (this.hFF != null) {
                    aVar.e(6, this.hFF);
                }
                if (this.Nhs != null) {
                    aVar.e(7, this.Nhs);
                }
                aVar.bb(8, this.DPz);
                aVar.aM(9, this.reportId);
                if (this.pkK != null) {
                    aVar.e(10, this.pkK);
                }
                AppMethodBeat.o(224543);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.pCV) + 0 + g.a.a.b.b.a.bu(2, this.version);
            if (this.ISo != null) {
                bu += g.a.a.b.b.a.f(3, this.ISo);
            }
            if (this.Nhr != null) {
                bu += g.a.a.b.b.a.f(4, this.Nhr);
            }
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(5, this.md5);
            }
            if (this.hFF != null) {
                bu += g.a.a.b.b.a.f(6, this.hFF);
            }
            if (this.Nhs != null) {
                bu += g.a.a.b.b.a.f(7, this.Nhs);
            }
            int r = bu + g.a.a.b.b.a.r(8, this.DPz) + g.a.a.b.b.a.bu(9, this.reportId);
            if (this.pkK != null) {
                r += g.a.a.b.b.a.f(10, this.pkK);
            }
            AppMethodBeat.o(224543);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ISo == null) {
                b bVar6 = new b("Not all required fields were included: initUrl");
                AppMethodBeat.o(224543);
                throw bVar6;
            } else if (this.Nhr == null) {
                b bVar7 = new b("Not all required fields were included: initFilePath");
                AppMethodBeat.o(224543);
                throw bVar7;
            } else if (this.md5 == null) {
                b bVar8 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(224543);
                throw bVar8;
            } else if (this.hFF == null) {
                b bVar9 = new b("Not all required fields were included: uid");
                AppMethodBeat.o(224543);
                throw bVar9;
            } else if (this.Nhs == null) {
                b bVar10 = new b("Not all required fields were included: headers");
                AppMethodBeat.o(224543);
                throw bVar10;
            } else {
                AppMethodBeat.o(224543);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eic eic = (eic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eic.pCV = aVar3.UbS.zi();
                    AppMethodBeat.o(224543);
                    return 0;
                case 2:
                    eic.version = aVar3.UbS.zi();
                    AppMethodBeat.o(224543);
                    return 0;
                case 3:
                    eic.ISo = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                case 4:
                    eic.Nhr = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                case 5:
                    eic.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                case 6:
                    eic.hFF = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                case 7:
                    eic.Nhs = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                case 8:
                    eic.DPz = aVar3.UbS.zl();
                    AppMethodBeat.o(224543);
                    return 0;
                case 9:
                    eic.reportId = aVar3.UbS.zi();
                    AppMethodBeat.o(224543);
                    return 0;
                case 10:
                    eic.pkK = aVar3.UbS.readString();
                    AppMethodBeat.o(224543);
                    return 0;
                default:
                    AppMethodBeat.o(224543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224543);
            return -1;
        }
    }
}
