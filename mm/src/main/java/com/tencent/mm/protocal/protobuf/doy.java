package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class doy extends a {
    public int FileSize;
    public String MD5;
    public int MSu;
    public int MSv;
    public LinkedList<dyk> MSw = new LinkedList<>();
    public b MSx;
    public String MSy;
    public String Url;

    public doy() {
        AppMethodBeat.i(152670);
        AppMethodBeat.o(152670);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152671);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MD5 == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: MD5");
                AppMethodBeat.o(152671);
                throw bVar;
            } else if (this.Url == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Url");
                AppMethodBeat.o(152671);
                throw bVar2;
            } else if (this.MSy == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.o(152671);
                throw bVar3;
            } else {
                if (this.MD5 != null) {
                    aVar.e(1, this.MD5);
                }
                aVar.aM(2, this.MSu);
                if (this.Url != null) {
                    aVar.e(3, this.Url);
                }
                aVar.aM(4, this.MSv);
                aVar.e(5, 8, this.MSw);
                if (this.MSx != null) {
                    aVar.c(6, this.MSx);
                }
                if (this.MSy != null) {
                    aVar.e(7, this.MSy);
                }
                aVar.aM(8, this.FileSize);
                AppMethodBeat.o(152671);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.MD5 != null ? g.a.a.b.b.a.f(1, this.MD5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MSu);
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(3, this.Url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MSv) + g.a.a.a.c(5, 8, this.MSw);
            if (this.MSx != null) {
                bu += g.a.a.b.b.a.b(6, this.MSx);
            }
            if (this.MSy != null) {
                bu += g.a.a.b.b.a.f(7, this.MSy);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.FileSize);
            AppMethodBeat.o(152671);
            return bu2;
        } else if (i2 == 2) {
            this.MSw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MD5 == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: MD5");
                AppMethodBeat.o(152671);
                throw bVar4;
            } else if (this.Url == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: Url");
                AppMethodBeat.o(152671);
                throw bVar5;
            } else if (this.MSy == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.o(152671);
                throw bVar6;
            } else {
                AppMethodBeat.o(152671);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doy doy = (doy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    doy.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(152671);
                    return 0;
                case 2:
                    doy.MSu = aVar3.UbS.zi();
                    AppMethodBeat.o(152671);
                    return 0;
                case 3:
                    doy.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(152671);
                    return 0;
                case 4:
                    doy.MSv = aVar3.UbS.zi();
                    AppMethodBeat.o(152671);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dyk dyk = new dyk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyk.populateBuilderWithField(aVar4, dyk, a.getNextFieldNumber(aVar4))) {
                        }
                        doy.MSw.add(dyk);
                    }
                    AppMethodBeat.o(152671);
                    return 0;
                case 6:
                    doy.MSx = aVar3.UbS.hPo();
                    AppMethodBeat.o(152671);
                    return 0;
                case 7:
                    doy.MSy = aVar3.UbS.readString();
                    AppMethodBeat.o(152671);
                    return 0;
                case 8:
                    doy.FileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(152671);
                    return 0;
                default:
                    AppMethodBeat.o(152671);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152671);
            return -1;
        }
    }
}
