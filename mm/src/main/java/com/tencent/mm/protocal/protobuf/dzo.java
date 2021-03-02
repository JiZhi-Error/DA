package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dzo extends a {
    public int CreateTime;
    public int DeleteFlag;
    public int IsNotRichText;
    public int MYS;
    public int MYT;
    public long MYU;
    public long MYV;
    public int MYX;
    public LinkedList<dzu> MYY = new LinkedList<>();
    public int MYZ;
    public String MZm;
    public String Nickname;
    public String Username;
    public String iAc;
    public int oUv;
    public int xub;

    public dzo() {
        AppMethodBeat.i(125778);
        AppMethodBeat.o(125778);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125779);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            if (this.Nickname != null) {
                aVar.e(2, this.Nickname);
            }
            aVar.aM(3, this.xub);
            aVar.aM(4, this.oUv);
            if (this.iAc != null) {
                aVar.e(5, this.iAc);
            }
            aVar.aM(6, this.CreateTime);
            aVar.aM(7, this.MYT);
            aVar.aM(8, this.MYS);
            if (this.MZm != null) {
                aVar.e(9, this.MZm);
            }
            aVar.aM(10, this.IsNotRichText);
            aVar.bb(11, this.MYU);
            aVar.bb(12, this.MYV);
            aVar.aM(13, this.DeleteFlag);
            aVar.aM(14, this.MYX);
            aVar.e(15, 8, this.MYY);
            aVar.aM(16, this.MYZ);
            AppMethodBeat.o(125779);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.Nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nickname);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.xub) + g.a.a.b.b.a.bu(4, this.oUv);
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(5, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.CreateTime) + g.a.a.b.b.a.bu(7, this.MYT) + g.a.a.b.b.a.bu(8, this.MYS);
            if (this.MZm != null) {
                bu2 += g.a.a.b.b.a.f(9, this.MZm);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.IsNotRichText) + g.a.a.b.b.a.r(11, this.MYU) + g.a.a.b.b.a.r(12, this.MYV) + g.a.a.b.b.a.bu(13, this.DeleteFlag) + g.a.a.b.b.a.bu(14, this.MYX) + g.a.a.a.c(15, 8, this.MYY) + g.a.a.b.b.a.bu(16, this.MYZ);
            AppMethodBeat.o(125779);
            return bu3;
        } else if (i2 == 2) {
            this.MYY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125779);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzo dzo = (dzo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzo.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(125779);
                    return 0;
                case 2:
                    dzo.Nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(125779);
                    return 0;
                case 3:
                    dzo.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 4:
                    dzo.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 5:
                    dzo.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(125779);
                    return 0;
                case 6:
                    dzo.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 7:
                    dzo.MYT = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 8:
                    dzo.MYS = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 9:
                    dzo.MZm = aVar3.UbS.readString();
                    AppMethodBeat.o(125779);
                    return 0;
                case 10:
                    dzo.IsNotRichText = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 11:
                    dzo.MYU = aVar3.UbS.zl();
                    AppMethodBeat.o(125779);
                    return 0;
                case 12:
                    dzo.MYV = aVar3.UbS.zl();
                    AppMethodBeat.o(125779);
                    return 0;
                case 13:
                    dzo.DeleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 14:
                    dzo.MYX = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzu dzu = new dzu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzu.populateBuilderWithField(aVar4, dzu, a.getNextFieldNumber(aVar4))) {
                        }
                        dzo.MYY.add(dzu);
                    }
                    AppMethodBeat.o(125779);
                    return 0;
                case 16:
                    dzo.MYZ = aVar3.UbS.zi();
                    AppMethodBeat.o(125779);
                    return 0;
                default:
                    AppMethodBeat.o(125779);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125779);
            return -1;
        }
    }
}
