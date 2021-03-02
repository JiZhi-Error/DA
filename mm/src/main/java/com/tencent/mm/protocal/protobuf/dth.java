package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dth extends dop {
    public int KKA;
    public int LbL;
    public int LbM;
    public String LbN;
    public int LsF;
    public fd MVu;
    public String MVv;
    public String MVw;
    public int MVx;
    public int MVy;
    public String Md5;
    public String keb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32426);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MVu == null) {
                b bVar = new b("Not all required fields were included: Msg");
                AppMethodBeat.o(32426);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MVu != null) {
                aVar.ni(2, this.MVu.computeSize());
                this.MVu.writeFields(aVar);
            }
            if (this.MVv != null) {
                aVar.e(3, this.MVv);
            }
            aVar.aM(4, this.LsF);
            if (this.Md5 != null) {
                aVar.e(5, this.Md5);
            }
            aVar.aM(6, this.KKA);
            if (this.keb != null) {
                aVar.e(7, this.keb);
            }
            if (this.MVw != null) {
                aVar.e(8, this.MVw);
            }
            aVar.aM(9, this.MVx);
            aVar.aM(10, this.LbL);
            aVar.aM(11, this.LbM);
            aVar.aM(12, this.MVy);
            if (this.LbN != null) {
                aVar.e(13, this.LbN);
            }
            AppMethodBeat.o(32426);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MVu != null) {
                nh += g.a.a.a.nh(2, this.MVu.computeSize());
            }
            if (this.MVv != null) {
                nh += g.a.a.b.b.a.f(3, this.MVv);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LsF);
            if (this.Md5 != null) {
                bu += g.a.a.b.b.a.f(5, this.Md5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KKA);
            if (this.keb != null) {
                bu2 += g.a.a.b.b.a.f(7, this.keb);
            }
            if (this.MVw != null) {
                bu2 += g.a.a.b.b.a.f(8, this.MVw);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.MVx) + g.a.a.b.b.a.bu(10, this.LbL) + g.a.a.b.b.a.bu(11, this.LbM) + g.a.a.b.b.a.bu(12, this.MVy);
            if (this.LbN != null) {
                bu3 += g.a.a.b.b.a.f(13, this.LbN);
            }
            AppMethodBeat.o(32426);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MVu == null) {
                b bVar2 = new b("Not all required fields were included: Msg");
                AppMethodBeat.o(32426);
                throw bVar2;
            }
            AppMethodBeat.o(32426);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dth dth = (dth) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        dth.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32426);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fd fdVar = new fd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdVar.populateBuilderWithField(aVar5, fdVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        dth.MVu = fdVar;
                    }
                    AppMethodBeat.o(32426);
                    return 0;
                case 3:
                    dth.MVv = aVar3.UbS.readString();
                    AppMethodBeat.o(32426);
                    return 0;
                case 4:
                    dth.LsF = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 5:
                    dth.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32426);
                    return 0;
                case 6:
                    dth.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 7:
                    dth.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(32426);
                    return 0;
                case 8:
                    dth.MVw = aVar3.UbS.readString();
                    AppMethodBeat.o(32426);
                    return 0;
                case 9:
                    dth.MVx = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 10:
                    dth.LbL = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 11:
                    dth.LbM = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 12:
                    dth.MVy = aVar3.UbS.zi();
                    AppMethodBeat.o(32426);
                    return 0;
                case 13:
                    dth.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(32426);
                    return 0;
                default:
                    AppMethodBeat.o(32426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32426);
            return -1;
        }
    }
}
