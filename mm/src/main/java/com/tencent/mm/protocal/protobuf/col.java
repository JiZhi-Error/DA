package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class col extends a {
    public String MuF;
    public int dJl;
    public String desc;
    public String finderObjectNonceId;
    public LinkedList<cok> mediaList = new LinkedList<>();
    public String nickname;
    public String objectId;
    public String objectNonceId;
    public String uNR;
    public String username;

    public col() {
        AppMethodBeat.i(196098);
        AppMethodBeat.o(196098);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196099);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.objectId != null) {
                aVar.e(1, this.objectId);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.uNR != null) {
                aVar.e(4, this.uNR);
            }
            if (this.desc != null) {
                aVar.e(5, this.desc);
            }
            aVar.aM(6, this.dJl);
            aVar.e(7, 8, this.mediaList);
            if (this.objectNonceId != null) {
                aVar.e(8, this.objectNonceId);
            }
            if (this.MuF != null) {
                aVar.e(9, this.MuF);
            }
            if (this.finderObjectNonceId != null) {
                aVar.e(10, this.finderObjectNonceId);
            }
            AppMethodBeat.o(196099);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.objectId != null ? g.a.a.b.b.a.f(1, this.objectId) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.uNR != null) {
                f2 += g.a.a.b.b.a.f(4, this.uNR);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(5, this.desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.dJl) + g.a.a.a.c(7, 8, this.mediaList);
            if (this.objectNonceId != null) {
                bu += g.a.a.b.b.a.f(8, this.objectNonceId);
            }
            if (this.MuF != null) {
                bu += g.a.a.b.b.a.f(9, this.MuF);
            }
            if (this.finderObjectNonceId != null) {
                bu += g.a.a.b.b.a.f(10, this.finderObjectNonceId);
            }
            AppMethodBeat.o(196099);
            return bu;
        } else if (i2 == 2) {
            this.mediaList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196099);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            col col = (col) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    col.objectId = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 2:
                    col.username = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 3:
                    col.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 4:
                    col.uNR = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 5:
                    col.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 6:
                    col.dJl = aVar3.UbS.zi();
                    AppMethodBeat.o(196099);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cok cok = new cok();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cok.populateBuilderWithField(aVar4, cok, a.getNextFieldNumber(aVar4))) {
                        }
                        col.mediaList.add(cok);
                    }
                    AppMethodBeat.o(196099);
                    return 0;
                case 8:
                    col.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 9:
                    col.MuF = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                case 10:
                    col.finderObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(196099);
                    return 0;
                default:
                    AppMethodBeat.o(196099);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196099);
            return -1;
        }
    }
}
