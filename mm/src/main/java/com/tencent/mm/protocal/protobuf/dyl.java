package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dyl extends a {
    public String AesKey;
    public int KZk;
    public int MYb;
    public String MYc;
    public int MaY;
    public String Mba;
    public String Mbb;
    public int Mbn;
    public String Md5;
    public chl MlQ;
    public aah MlR;
    public int Scene;
    public String SessionId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117925);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            aVar.aM(2, this.KZk);
            aVar.aM(3, this.Scene);
            if (this.Mbb != null) {
                aVar.e(4, this.Mbb);
            }
            if (this.SessionId != null) {
                aVar.e(5, this.SessionId);
            }
            aVar.aM(6, this.MaY);
            if (this.MlQ != null) {
                aVar.ni(7, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.aM(8, this.MYb);
            if (this.Mba != null) {
                aVar.e(9, this.Mba);
            }
            aVar.aM(10, this.Mbn);
            if (this.MYc != null) {
                aVar.e(11, this.MYc);
            }
            if (this.AesKey != null) {
                aVar.e(12, this.AesKey);
            }
            if (this.MlR != null) {
                aVar.ni(13, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            AppMethodBeat.o(117925);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.Mbb != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mbb);
            }
            if (this.SessionId != null) {
                f2 += g.a.a.b.b.a.f(5, this.SessionId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.MaY);
            if (this.MlQ != null) {
                bu += g.a.a.a.nh(7, this.MlQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MYb);
            if (this.Mba != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Mba);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.Mbn);
            if (this.MYc != null) {
                bu3 += g.a.a.b.b.a.f(11, this.MYc);
            }
            if (this.AesKey != null) {
                bu3 += g.a.a.b.b.a.f(12, this.AesKey);
            }
            if (this.MlR != null) {
                bu3 += g.a.a.a.nh(13, this.MlR.computeSize());
            }
            AppMethodBeat.o(117925);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117925);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyl dyl = (dyl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dyl.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 2:
                    dyl.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117925);
                    return 0;
                case 3:
                    dyl.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117925);
                    return 0;
                case 4:
                    dyl.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 5:
                    dyl.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 6:
                    dyl.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117925);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        dyl.MlQ = chl;
                    }
                    AppMethodBeat.o(117925);
                    return 0;
                case 8:
                    dyl.MYb = aVar3.UbS.zi();
                    AppMethodBeat.o(117925);
                    return 0;
                case 9:
                    dyl.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 10:
                    dyl.Mbn = aVar3.UbS.zi();
                    AppMethodBeat.o(117925);
                    return 0;
                case 11:
                    dyl.MYc = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 12:
                    dyl.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(117925);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aah.populateBuilderWithField(aVar5, aah, a.getNextFieldNumber(aVar5))) {
                        }
                        dyl.MlR = aah;
                    }
                    AppMethodBeat.o(117925);
                    return 0;
                default:
                    AppMethodBeat.o(117925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117925);
            return -1;
        }
    }
}
