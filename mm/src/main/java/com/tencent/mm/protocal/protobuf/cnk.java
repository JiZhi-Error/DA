package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cnk extends a {
    public String LBe;
    public int LBf;
    public LinkedList<cno> LBg = new LinkedList<>();
    public LinkedList<cnv> LBi = new LinkedList<>();
    public LinkedList<String> MtQ = new LinkedList<>();
    public String deviceBrand;
    public String deviceModel;
    public int netType;
    public String osName;
    public String osVersion;

    public cnk() {
        AppMethodBeat.i(209736);
        AppMethodBeat.o(209736);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209737);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.netType);
            if (this.LBe != null) {
                aVar.e(2, this.LBe);
            }
            aVar.aM(3, this.LBf);
            aVar.e(4, 8, this.LBg);
            if (this.deviceModel != null) {
                aVar.e(5, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.e(6, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.e(7, this.osName);
            }
            if (this.osVersion != null) {
                aVar.e(8, this.osVersion);
            }
            aVar.e(9, 1, this.MtQ);
            aVar.e(10, 8, this.LBi);
            AppMethodBeat.o(209737);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.netType) + 0;
            if (this.LBe != null) {
                bu += g.a.a.b.b.a.f(2, this.LBe);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LBf) + g.a.a.a.c(4, 8, this.LBg);
            if (this.deviceModel != null) {
                bu2 += g.a.a.b.b.a.f(5, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                bu2 += g.a.a.b.b.a.f(6, this.deviceBrand);
            }
            if (this.osName != null) {
                bu2 += g.a.a.b.b.a.f(7, this.osName);
            }
            if (this.osVersion != null) {
                bu2 += g.a.a.b.b.a.f(8, this.osVersion);
            }
            int c2 = bu2 + g.a.a.a.c(9, 1, this.MtQ) + g.a.a.a.c(10, 8, this.LBi);
            AppMethodBeat.o(209737);
            return c2;
        } else if (i2 == 2) {
            this.LBg.clear();
            this.MtQ.clear();
            this.LBi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209737);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnk cnk = (cnk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnk.netType = aVar3.UbS.zi();
                    AppMethodBeat.o(209737);
                    return 0;
                case 2:
                    cnk.LBe = aVar3.UbS.readString();
                    AppMethodBeat.o(209737);
                    return 0;
                case 3:
                    cnk.LBf = aVar3.UbS.zi();
                    AppMethodBeat.o(209737);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cno cno = new cno();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cno.populateBuilderWithField(aVar4, cno, a.getNextFieldNumber(aVar4))) {
                        }
                        cnk.LBg.add(cno);
                    }
                    AppMethodBeat.o(209737);
                    return 0;
                case 5:
                    cnk.deviceModel = aVar3.UbS.readString();
                    AppMethodBeat.o(209737);
                    return 0;
                case 6:
                    cnk.deviceBrand = aVar3.UbS.readString();
                    AppMethodBeat.o(209737);
                    return 0;
                case 7:
                    cnk.osName = aVar3.UbS.readString();
                    AppMethodBeat.o(209737);
                    return 0;
                case 8:
                    cnk.osVersion = aVar3.UbS.readString();
                    AppMethodBeat.o(209737);
                    return 0;
                case 9:
                    cnk.MtQ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209737);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cnv cnv = new cnv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cnv.populateBuilderWithField(aVar5, cnv, a.getNextFieldNumber(aVar5))) {
                        }
                        cnk.LBi.add(cnv);
                    }
                    AppMethodBeat.o(209737);
                    return 0;
                default:
                    AppMethodBeat.o(209737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209737);
            return -1;
        }
    }
}
