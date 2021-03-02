package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class awq extends a {
    public avn LHp;
    public String LHq;
    public avn Vjm;
    public String content;
    public String fQY;
    public String headUrl;
    public String nickname;
    public long seq;
    public int type;
    public String username;
    public int wBG;
    public b ybi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209541);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.nickname != null) {
                aVar.e(1, this.nickname);
            }
            if (this.headUrl != null) {
                aVar.e(2, this.headUrl);
            }
            if (this.content != null) {
                aVar.e(3, this.content);
            }
            aVar.aM(4, this.type);
            if (this.username != null) {
                aVar.e(5, this.username);
            }
            aVar.bb(6, this.seq);
            if (this.fQY != null) {
                aVar.e(7, this.fQY);
            }
            aVar.aM(8, this.wBG);
            if (this.LHp != null) {
                aVar.ni(9, this.LHp.computeSize());
                this.LHp.writeFields(aVar);
            }
            if (this.LHq != null) {
                aVar.e(10, this.LHq);
            }
            if (this.ybi != null) {
                aVar.c(11, this.ybi);
            }
            if (this.Vjm != null) {
                aVar.ni(12, this.Vjm.computeSize());
                this.Vjm.writeFields(aVar);
            }
            AppMethodBeat.o(209541);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.nickname != null ? g.a.a.b.b.a.f(1, this.nickname) + 0 : 0;
            if (this.headUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.headUrl);
            }
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(3, this.content);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.type);
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(5, this.username);
            }
            int r = bu + g.a.a.b.b.a.r(6, this.seq);
            if (this.fQY != null) {
                r += g.a.a.b.b.a.f(7, this.fQY);
            }
            int bu2 = r + g.a.a.b.b.a.bu(8, this.wBG);
            if (this.LHp != null) {
                bu2 += g.a.a.a.nh(9, this.LHp.computeSize());
            }
            if (this.LHq != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LHq);
            }
            if (this.ybi != null) {
                bu2 += g.a.a.b.b.a.b(11, this.ybi);
            }
            if (this.Vjm != null) {
                bu2 += g.a.a.a.nh(12, this.Vjm.computeSize());
            }
            AppMethodBeat.o(209541);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209541);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awq awq = (awq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awq.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 2:
                    awq.headUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 3:
                    awq.content = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 4:
                    awq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209541);
                    return 0;
                case 5:
                    awq.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 6:
                    awq.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(209541);
                    return 0;
                case 7:
                    awq.fQY = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 8:
                    awq.wBG = aVar3.UbS.zi();
                    AppMethodBeat.o(209541);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        awq.LHp = avn;
                    }
                    AppMethodBeat.o(209541);
                    return 0;
                case 10:
                    awq.LHq = aVar3.UbS.readString();
                    AppMethodBeat.o(209541);
                    return 0;
                case 11:
                    awq.ybi = aVar3.UbS.hPo();
                    AppMethodBeat.o(209541);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        avn avn2 = new avn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avn2.populateBuilderWithField(aVar5, avn2, a.getNextFieldNumber(aVar5))) {
                        }
                        awq.Vjm = avn2;
                    }
                    AppMethodBeat.o(209541);
                    return 0;
                default:
                    AppMethodBeat.o(209541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209541);
            return -1;
        }
    }
}
