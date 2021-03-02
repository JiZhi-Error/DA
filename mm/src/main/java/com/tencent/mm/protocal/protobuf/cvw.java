package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cvw extends a {
    public String KHz;
    public String MBe;
    public String MBf;
    public String MBp;
    public String MBr;
    public String MBs;
    public String MBt;
    public String MBu;
    public cvx MBv;
    public String app_id;
    public int fuA;
    public String jGZ;
    public String nickname;
    public String remark;
    public int source;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152638);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jGZ != null) {
                aVar.e(1, this.jGZ);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            aVar.aM(3, this.type);
            if (this.remark != null) {
                aVar.e(4, this.remark);
            }
            if (this.MBe != null) {
                aVar.e(5, this.MBe);
            }
            if (this.MBf != null) {
                aVar.e(6, this.MBf);
            }
            aVar.aM(7, this.source);
            if (this.MBr != null) {
                aVar.e(8, this.MBr);
            }
            if (this.MBs != null) {
                aVar.e(9, this.MBs);
            }
            if (this.MBt != null) {
                aVar.e(10, this.MBt);
            }
            if (this.MBu != null) {
                aVar.e(11, this.MBu);
            }
            if (this.MBv != null) {
                aVar.ni(12, this.MBv.computeSize());
                this.MBv.writeFields(aVar);
            }
            if (this.KHz != null) {
                aVar.e(13, this.KHz);
            }
            if (this.app_id != null) {
                aVar.e(14, this.app_id);
            }
            aVar.aM(15, this.fuA);
            if (this.MBp != null) {
                aVar.e(16, this.MBp);
            }
            AppMethodBeat.o(152638);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jGZ != null ? g.a.a.b.b.a.f(1, this.jGZ) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.type);
            if (this.remark != null) {
                bu += g.a.a.b.b.a.f(4, this.remark);
            }
            if (this.MBe != null) {
                bu += g.a.a.b.b.a.f(5, this.MBe);
            }
            if (this.MBf != null) {
                bu += g.a.a.b.b.a.f(6, this.MBf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.source);
            if (this.MBr != null) {
                bu2 += g.a.a.b.b.a.f(8, this.MBr);
            }
            if (this.MBs != null) {
                bu2 += g.a.a.b.b.a.f(9, this.MBs);
            }
            if (this.MBt != null) {
                bu2 += g.a.a.b.b.a.f(10, this.MBt);
            }
            if (this.MBu != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MBu);
            }
            if (this.MBv != null) {
                bu2 += g.a.a.a.nh(12, this.MBv.computeSize());
            }
            if (this.KHz != null) {
                bu2 += g.a.a.b.b.a.f(13, this.KHz);
            }
            if (this.app_id != null) {
                bu2 += g.a.a.b.b.a.f(14, this.app_id);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(15, this.fuA);
            if (this.MBp != null) {
                bu3 += g.a.a.b.b.a.f(16, this.MBp);
            }
            AppMethodBeat.o(152638);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152638);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvw cvw = (cvw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvw.jGZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 2:
                    cvw.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 3:
                    cvw.type = aVar3.UbS.zi();
                    AppMethodBeat.o(152638);
                    return 0;
                case 4:
                    cvw.remark = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 5:
                    cvw.MBe = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 6:
                    cvw.MBf = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 7:
                    cvw.source = aVar3.UbS.zi();
                    AppMethodBeat.o(152638);
                    return 0;
                case 8:
                    cvw.MBr = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 9:
                    cvw.MBs = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 10:
                    cvw.MBt = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 11:
                    cvw.MBu = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvx cvx = new cvx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvx.populateBuilderWithField(aVar4, cvx, a.getNextFieldNumber(aVar4))) {
                        }
                        cvw.MBv = cvx;
                    }
                    AppMethodBeat.o(152638);
                    return 0;
                case 13:
                    cvw.KHz = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 14:
                    cvw.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                case 15:
                    cvw.fuA = aVar3.UbS.zi();
                    AppMethodBeat.o(152638);
                    return 0;
                case 16:
                    cvw.MBp = aVar3.UbS.readString();
                    AppMethodBeat.o(152638);
                    return 0;
                default:
                    AppMethodBeat.o(152638);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152638);
            return -1;
        }
    }
}
