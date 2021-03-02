package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csk extends a {
    public String BcW;
    public String LGs;
    public String MwX;
    public csi Mxr;
    public String Mxs;
    public String Mxt;
    public int Mxu;
    public long Mxv;
    public String Mxw;
    public int createtime;
    public long dFm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256725);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mxr != null) {
                aVar.ni(2, this.Mxr.computeSize());
                this.Mxr.writeFields(aVar);
            }
            if (this.Mxs != null) {
                aVar.e(3, this.Mxs);
            }
            if (this.Mxt != null) {
                aVar.e(4, this.Mxt);
            }
            aVar.bb(5, this.dFm);
            if (this.BcW != null) {
                aVar.e(6, this.BcW);
            }
            if (this.MwX != null) {
                aVar.e(7, this.MwX);
            }
            aVar.aM(9, this.createtime);
            aVar.aM(13, this.Mxu);
            aVar.bb(14, this.Mxv);
            if (this.LGs != null) {
                aVar.e(15, this.LGs);
            }
            if (this.Mxw != null) {
                aVar.e(16, this.Mxw);
            }
            AppMethodBeat.o(256725);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mxr != null ? g.a.a.a.nh(2, this.Mxr.computeSize()) + 0 : 0;
            if (this.Mxs != null) {
                nh += g.a.a.b.b.a.f(3, this.Mxs);
            }
            if (this.Mxt != null) {
                nh += g.a.a.b.b.a.f(4, this.Mxt);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.dFm);
            if (this.BcW != null) {
                r += g.a.a.b.b.a.f(6, this.BcW);
            }
            if (this.MwX != null) {
                r += g.a.a.b.b.a.f(7, this.MwX);
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.createtime) + g.a.a.b.b.a.bu(13, this.Mxu) + g.a.a.b.b.a.r(14, this.Mxv);
            if (this.LGs != null) {
                bu += g.a.a.b.b.a.f(15, this.LGs);
            }
            if (this.Mxw != null) {
                bu += g.a.a.b.b.a.f(16, this.Mxw);
            }
            AppMethodBeat.o(256725);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256725);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csk csk = (csk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csi csi = new csi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csi.populateBuilderWithField(aVar4, csi, a.getNextFieldNumber(aVar4))) {
                        }
                        csk.Mxr = csi;
                    }
                    AppMethodBeat.o(256725);
                    return 0;
                case 3:
                    csk.Mxs = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
                case 4:
                    csk.Mxt = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
                case 5:
                    csk.dFm = aVar3.UbS.zl();
                    AppMethodBeat.o(256725);
                    return 0;
                case 6:
                    csk.BcW = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
                case 7:
                    csk.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
                case 8:
                case 10:
                case 11:
                case 12:
                default:
                    AppMethodBeat.o(256725);
                    return -1;
                case 9:
                    csk.createtime = aVar3.UbS.zi();
                    AppMethodBeat.o(256725);
                    return 0;
                case 13:
                    csk.Mxu = aVar3.UbS.zi();
                    AppMethodBeat.o(256725);
                    return 0;
                case 14:
                    csk.Mxv = aVar3.UbS.zl();
                    AppMethodBeat.o(256725);
                    return 0;
                case 15:
                    csk.LGs = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
                case 16:
                    csk.Mxw = aVar3.UbS.readString();
                    AppMethodBeat.o(256725);
                    return 0;
            }
        } else {
            AppMethodBeat.o(256725);
            return -1;
        }
    }
}
