package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class egj extends a {
    public LinkedList<aca> IDO = new LinkedList<>();
    public int Ngq;
    public String dDv;
    public String dPI;
    public String hes;
    public int scene;
    public String sessionId;
    public String talker;
    public String title;
    public String url;
    public int vkj;

    public egj() {
        AppMethodBeat.i(190312);
        AppMethodBeat.o(190312);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(190313);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hes != null) {
                aVar.e(1, this.hes);
            }
            if (this.sessionId != null) {
                aVar.e(2, this.sessionId);
            }
            aVar.aM(3, this.scene);
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.dPI != null) {
                aVar.e(5, this.dPI);
            }
            if (this.dDv != null) {
                aVar.e(6, this.dDv);
            }
            aVar.e(7, 8, this.IDO);
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            if (this.talker != null) {
                aVar.e(9, this.talker);
            }
            aVar.aM(10, this.vkj);
            aVar.aM(11, this.Ngq);
            AppMethodBeat.o(190313);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hes != null ? g.a.a.b.b.a.f(1, this.hes) + 0 : 0;
            if (this.sessionId != null) {
                f2 += g.a.a.b.b.a.f(2, this.sessionId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.scene);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(4, this.url);
            }
            if (this.dPI != null) {
                bu += g.a.a.b.b.a.f(5, this.dPI);
            }
            if (this.dDv != null) {
                bu += g.a.a.b.b.a.f(6, this.dDv);
            }
            int c2 = bu + g.a.a.a.c(7, 8, this.IDO);
            if (this.title != null) {
                c2 += g.a.a.b.b.a.f(8, this.title);
            }
            if (this.talker != null) {
                c2 += g.a.a.b.b.a.f(9, this.talker);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(10, this.vkj) + g.a.a.b.b.a.bu(11, this.Ngq);
            AppMethodBeat.o(190313);
            return bu2;
        } else if (i2 == 2) {
            this.IDO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(190313);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egj egj = (egj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    egj.hes = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 2:
                    egj.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 3:
                    egj.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(190313);
                    return 0;
                case 4:
                    egj.url = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 5:
                    egj.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 6:
                    egj.dDv = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aca.populateBuilderWithField(aVar4, aca, a.getNextFieldNumber(aVar4))) {
                        }
                        egj.IDO.add(aca);
                    }
                    AppMethodBeat.o(190313);
                    return 0;
                case 8:
                    egj.title = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 9:
                    egj.talker = aVar3.UbS.readString();
                    AppMethodBeat.o(190313);
                    return 0;
                case 10:
                    egj.vkj = aVar3.UbS.zi();
                    AppMethodBeat.o(190313);
                    return 0;
                case 11:
                    egj.Ngq = aVar3.UbS.zi();
                    AppMethodBeat.o(190313);
                    return 0;
                default:
                    AppMethodBeat.o(190313);
                    return -1;
            }
        } else {
            AppMethodBeat.o(190313);
            return -1;
        }
    }
}
