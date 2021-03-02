package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eiq extends a {
    public int IEj;
    public int IFn;
    public int IFo;
    public int IFp;
    public long NhO;
    public int NhP;
    public long NhQ;
    public String extInfo;
    public String icon;
    public int jlm;
    public long jmW;
    public String msgId;
    public int priority;
    public int showFlag;
    public String text;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153002);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.msgId != null) {
                aVar.e(1, this.msgId);
            }
            aVar.aM(2, this.IFn);
            aVar.aM(3, this.IFo);
            aVar.bb(4, this.jmW);
            aVar.aM(5, this.IEj);
            aVar.aM(6, this.type);
            if (this.text != null) {
                aVar.e(7, this.text);
            }
            if (this.icon != null) {
                aVar.e(8, this.icon);
            }
            aVar.bb(9, this.NhO);
            aVar.aM(10, this.IFp);
            aVar.aM(11, this.NhP);
            aVar.bb(12, this.NhQ);
            aVar.aM(13, this.showFlag);
            aVar.aM(14, this.jlm);
            if (this.extInfo != null) {
                aVar.e(15, this.extInfo);
            }
            aVar.aM(16, this.priority);
            AppMethodBeat.o(153002);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.msgId != null ? g.a.a.b.b.a.f(1, this.msgId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.IFn) + g.a.a.b.b.a.bu(3, this.IFo) + g.a.a.b.b.a.r(4, this.jmW) + g.a.a.b.b.a.bu(5, this.IEj) + g.a.a.b.b.a.bu(6, this.type);
            if (this.text != null) {
                f2 += g.a.a.b.b.a.f(7, this.text);
            }
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(8, this.icon);
            }
            int r = f2 + g.a.a.b.b.a.r(9, this.NhO) + g.a.a.b.b.a.bu(10, this.IFp) + g.a.a.b.b.a.bu(11, this.NhP) + g.a.a.b.b.a.r(12, this.NhQ) + g.a.a.b.b.a.bu(13, this.showFlag) + g.a.a.b.b.a.bu(14, this.jlm);
            if (this.extInfo != null) {
                r += g.a.a.b.b.a.f(15, this.extInfo);
            }
            int bu = r + g.a.a.b.b.a.bu(16, this.priority);
            AppMethodBeat.o(153002);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153002);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eiq eiq = (eiq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eiq.msgId = aVar3.UbS.readString();
                    AppMethodBeat.o(153002);
                    return 0;
                case 2:
                    eiq.IFn = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 3:
                    eiq.IFo = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 4:
                    eiq.jmW = aVar3.UbS.zl();
                    AppMethodBeat.o(153002);
                    return 0;
                case 5:
                    eiq.IEj = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 6:
                    eiq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 7:
                    eiq.text = aVar3.UbS.readString();
                    AppMethodBeat.o(153002);
                    return 0;
                case 8:
                    eiq.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(153002);
                    return 0;
                case 9:
                    eiq.NhO = aVar3.UbS.zl();
                    AppMethodBeat.o(153002);
                    return 0;
                case 10:
                    eiq.IFp = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 11:
                    eiq.NhP = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 12:
                    eiq.NhQ = aVar3.UbS.zl();
                    AppMethodBeat.o(153002);
                    return 0;
                case 13:
                    eiq.showFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 14:
                    eiq.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                case 15:
                    eiq.extInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(153002);
                    return 0;
                case 16:
                    eiq.priority = aVar3.UbS.zi();
                    AppMethodBeat.o(153002);
                    return 0;
                default:
                    AppMethodBeat.o(153002);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153002);
            return -1;
        }
    }
}
