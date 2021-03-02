package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class sh extends a {
    public String HYG;
    public String IhY;
    public String KDV;
    public String KDW;
    public int KFC;
    public String icon;
    public String title;
    public int type;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91383);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.IhY != null) {
                aVar.e(2, this.IhY);
            }
            if (this.icon != null) {
                aVar.e(3, this.icon);
            }
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            if (this.HYG != null) {
                aVar.e(5, this.HYG);
            }
            if (this.url != null) {
                aVar.e(6, this.url);
            }
            if (this.KDV != null) {
                aVar.e(7, this.KDV);
            }
            if (this.KDW != null) {
                aVar.e(8, this.KDW);
            }
            aVar.aM(9, this.KFC);
            AppMethodBeat.o(91383);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.IhY != null) {
                bu += g.a.a.b.b.a.f(2, this.IhY);
            }
            if (this.icon != null) {
                bu += g.a.a.b.b.a.f(3, this.icon);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(4, this.title);
            }
            if (this.HYG != null) {
                bu += g.a.a.b.b.a.f(5, this.HYG);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(6, this.url);
            }
            if (this.KDV != null) {
                bu += g.a.a.b.b.a.f(7, this.KDV);
            }
            if (this.KDW != null) {
                bu += g.a.a.b.b.a.f(8, this.KDW);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.KFC);
            AppMethodBeat.o(91383);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91383);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sh shVar = (sh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    shVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91383);
                    return 0;
                case 2:
                    shVar.IhY = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 3:
                    shVar.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 4:
                    shVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 5:
                    shVar.HYG = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 6:
                    shVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 7:
                    shVar.KDV = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 8:
                    shVar.KDW = aVar3.UbS.readString();
                    AppMethodBeat.o(91383);
                    return 0;
                case 9:
                    shVar.KFC = aVar3.UbS.zi();
                    AppMethodBeat.o(91383);
                    return 0;
                default:
                    AppMethodBeat.o(91383);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91383);
            return -1;
        }
    }
}
