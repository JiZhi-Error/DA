package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bcj extends a {
    public String LLw;
    public String LLx;
    public int dJl;
    public String desc;
    public long localId;
    public LinkedList<bch> mediaList = new LinkedList<>();
    public String nickname;
    public String objectId;
    public String objectNonceId;
    public String uNR;
    public String username;
    public int vXJ;

    public bcj() {
        AppMethodBeat.i(164046);
        AppMethodBeat.o(164046);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(164047);
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
            aVar.aM(6, this.vXJ);
            aVar.aM(7, this.dJl);
            aVar.e(8, 8, this.mediaList);
            if (this.objectNonceId != null) {
                aVar.e(9, this.objectNonceId);
            }
            aVar.bb(10, this.localId);
            if (this.LLw != null) {
                aVar.e(11, this.LLw);
            }
            if (this.LLx != null) {
                aVar.e(12, this.LLx);
            }
            AppMethodBeat.o(164047);
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
            int bu = f2 + g.a.a.b.b.a.bu(6, this.vXJ) + g.a.a.b.b.a.bu(7, this.dJl) + g.a.a.a.c(8, 8, this.mediaList);
            if (this.objectNonceId != null) {
                bu += g.a.a.b.b.a.f(9, this.objectNonceId);
            }
            int r = bu + g.a.a.b.b.a.r(10, this.localId);
            if (this.LLw != null) {
                r += g.a.a.b.b.a.f(11, this.LLw);
            }
            if (this.LLx != null) {
                r += g.a.a.b.b.a.f(12, this.LLx);
            }
            AppMethodBeat.o(164047);
            return r;
        } else if (i2 == 2) {
            this.mediaList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(164047);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcj bcj = (bcj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcj.objectId = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 2:
                    bcj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 3:
                    bcj.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 4:
                    bcj.uNR = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 5:
                    bcj.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 6:
                    bcj.vXJ = aVar3.UbS.zi();
                    AppMethodBeat.o(164047);
                    return 0;
                case 7:
                    bcj.dJl = aVar3.UbS.zi();
                    AppMethodBeat.o(164047);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bch bch = new bch();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bch.populateBuilderWithField(aVar4, bch, a.getNextFieldNumber(aVar4))) {
                        }
                        bcj.mediaList.add(bch);
                    }
                    AppMethodBeat.o(164047);
                    return 0;
                case 9:
                    bcj.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 10:
                    bcj.localId = aVar3.UbS.zl();
                    AppMethodBeat.o(164047);
                    return 0;
                case 11:
                    bcj.LLw = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                case 12:
                    bcj.LLx = aVar3.UbS.readString();
                    AppMethodBeat.o(164047);
                    return 0;
                default:
                    AppMethodBeat.o(164047);
                    return -1;
            }
        } else {
            AppMethodBeat.o(164047);
            return -1;
        }
    }
}
