package com.tencent.mm.plugin.wallet.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class q extends a {
    public String HER;
    public String HES;
    public String HET = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String HEU = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public int HEV = 0;
    public int HEW;
    public String HEX;
    public String HEm;
    public String desc;
    public String id;
    public String name;
    public int status;
    public int type;
    public String url;
    public String weappPath;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91303);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.aM(4, this.status);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.aM(6, this.type);
            if (this.HER != null) {
                aVar.e(7, this.HER);
            }
            if (this.HES != null) {
                aVar.e(8, this.HES);
            }
            if (this.HET != null) {
                aVar.e(9, this.HET);
            }
            if (this.HEU != null) {
                aVar.e(10, this.HEU);
            }
            aVar.aM(11, this.HEV);
            if (this.HEm != null) {
                aVar.e(12, this.HEm);
            }
            if (this.weappPath != null) {
                aVar.e(13, this.weappPath);
            }
            aVar.aM(14, this.HEW);
            if (this.HEX != null) {
                aVar.e(15, this.HEX);
            }
            AppMethodBeat.o(91303);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.status);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(5, this.url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.type);
            if (this.HER != null) {
                bu2 += g.a.a.b.b.a.f(7, this.HER);
            }
            if (this.HES != null) {
                bu2 += g.a.a.b.b.a.f(8, this.HES);
            }
            if (this.HET != null) {
                bu2 += g.a.a.b.b.a.f(9, this.HET);
            }
            if (this.HEU != null) {
                bu2 += g.a.a.b.b.a.f(10, this.HEU);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.HEV);
            if (this.HEm != null) {
                bu3 += g.a.a.b.b.a.f(12, this.HEm);
            }
            if (this.weappPath != null) {
                bu3 += g.a.a.b.b.a.f(13, this.weappPath);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.HEW);
            if (this.HEX != null) {
                bu4 += g.a.a.b.b.a.f(15, this.HEX);
            }
            AppMethodBeat.o(91303);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91303);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.id = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 2:
                    qVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 3:
                    qVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 4:
                    qVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(91303);
                    return 0;
                case 5:
                    qVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 6:
                    qVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91303);
                    return 0;
                case 7:
                    qVar.HER = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 8:
                    qVar.HES = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 9:
                    qVar.HET = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 10:
                    qVar.HEU = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 11:
                    qVar.HEV = aVar3.UbS.zi();
                    AppMethodBeat.o(91303);
                    return 0;
                case 12:
                    qVar.HEm = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 13:
                    qVar.weappPath = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                case 14:
                    qVar.HEW = aVar3.UbS.zi();
                    AppMethodBeat.o(91303);
                    return 0;
                case 15:
                    qVar.HEX = aVar3.UbS.readString();
                    AppMethodBeat.o(91303);
                    return 0;
                default:
                    AppMethodBeat.o(91303);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91303);
            return -1;
        }
    }
}
