package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpc extends dpc {
    public boolean DhA;
    public int Dhu;
    public String Dhv;
    public String Dhw;
    public String Dhx;
    public String Dhz;
    public String HHX;
    public boolean LXf;
    public boolean LXg;
    public String LXh;
    public String LXi;
    public int LXj;
    public String LXk;
    public int LXl;
    public String eaP;
    public String gTG;
    public String iwv;
    public String ixw;
    public String pRX;
    public String pRY;
    public String pRZ;
    public int pSb;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32248);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32248);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.cc(2, this.LXf);
            aVar.cc(3, this.LXg);
            if (this.LXh != null) {
                aVar.e(4, this.LXh);
            }
            if (this.LXi != null) {
                aVar.e(5, this.LXi);
            }
            aVar.aM(6, this.LXj);
            if (this.LXk != null) {
                aVar.e(7, this.LXk);
            }
            aVar.aM(8, this.LXl);
            if (this.pRX != null) {
                aVar.e(9, this.pRX);
            }
            if (this.eaP != null) {
                aVar.e(10, this.eaP);
            }
            if (this.title != null) {
                aVar.e(11, this.title);
            }
            if (this.pRY != null) {
                aVar.e(12, this.pRY);
            }
            if (this.pRZ != null) {
                aVar.e(13, this.pRZ);
            }
            if (this.gTG != null) {
                aVar.e(14, this.gTG);
            }
            if (this.iwv != null) {
                aVar.e(15, this.iwv);
            }
            if (this.ixw != null) {
                aVar.e(16, this.ixw);
            }
            aVar.aM(17, this.Dhu);
            if (this.Dhv != null) {
                aVar.e(18, this.Dhv);
            }
            if (this.Dhw != null) {
                aVar.e(19, this.Dhw);
            }
            if (this.Dhx != null) {
                aVar.e(20, this.Dhx);
            }
            aVar.aM(21, this.pSb);
            if (this.Dhz != null) {
                aVar.e(22, this.Dhz);
            }
            if (this.HHX != null) {
                aVar.e(23, this.HHX);
            }
            aVar.cc(24, this.DhA);
            AppMethodBeat.o(32248);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1;
            if (this.LXh != null) {
                nh += g.a.a.b.b.a.f(4, this.LXh);
            }
            if (this.LXi != null) {
                nh += g.a.a.b.b.a.f(5, this.LXi);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LXj);
            if (this.LXk != null) {
                bu += g.a.a.b.b.a.f(7, this.LXk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LXl);
            if (this.pRX != null) {
                bu2 += g.a.a.b.b.a.f(9, this.pRX);
            }
            if (this.eaP != null) {
                bu2 += g.a.a.b.b.a.f(10, this.eaP);
            }
            if (this.title != null) {
                bu2 += g.a.a.b.b.a.f(11, this.title);
            }
            if (this.pRY != null) {
                bu2 += g.a.a.b.b.a.f(12, this.pRY);
            }
            if (this.pRZ != null) {
                bu2 += g.a.a.b.b.a.f(13, this.pRZ);
            }
            if (this.gTG != null) {
                bu2 += g.a.a.b.b.a.f(14, this.gTG);
            }
            if (this.iwv != null) {
                bu2 += g.a.a.b.b.a.f(15, this.iwv);
            }
            if (this.ixw != null) {
                bu2 += g.a.a.b.b.a.f(16, this.ixw);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.Dhu);
            if (this.Dhv != null) {
                bu3 += g.a.a.b.b.a.f(18, this.Dhv);
            }
            if (this.Dhw != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Dhw);
            }
            if (this.Dhx != null) {
                bu3 += g.a.a.b.b.a.f(20, this.Dhx);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(21, this.pSb);
            if (this.Dhz != null) {
                bu4 += g.a.a.b.b.a.f(22, this.Dhz);
            }
            if (this.HHX != null) {
                bu4 += g.a.a.b.b.a.f(23, this.HHX);
            }
            int fS = bu4 + g.a.a.b.b.a.fS(24) + 1;
            AppMethodBeat.o(32248);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32248);
                throw bVar2;
            }
            AppMethodBeat.o(32248);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpc bpc = (bpc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bpc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32248);
                    return 0;
                case 2:
                    bpc.LXf = aVar3.UbS.yZ();
                    AppMethodBeat.o(32248);
                    return 0;
                case 3:
                    bpc.LXg = aVar3.UbS.yZ();
                    AppMethodBeat.o(32248);
                    return 0;
                case 4:
                    bpc.LXh = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 5:
                    bpc.LXi = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 6:
                    bpc.LXj = aVar3.UbS.zi();
                    AppMethodBeat.o(32248);
                    return 0;
                case 7:
                    bpc.LXk = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 8:
                    bpc.LXl = aVar3.UbS.zi();
                    AppMethodBeat.o(32248);
                    return 0;
                case 9:
                    bpc.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 10:
                    bpc.eaP = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 11:
                    bpc.title = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 12:
                    bpc.pRY = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 13:
                    bpc.pRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 14:
                    bpc.gTG = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 15:
                    bpc.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 16:
                    bpc.ixw = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 17:
                    bpc.Dhu = aVar3.UbS.zi();
                    AppMethodBeat.o(32248);
                    return 0;
                case 18:
                    bpc.Dhv = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 19:
                    bpc.Dhw = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 20:
                    bpc.Dhx = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 21:
                    bpc.pSb = aVar3.UbS.zi();
                    AppMethodBeat.o(32248);
                    return 0;
                case 22:
                    bpc.Dhz = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 23:
                    bpc.HHX = aVar3.UbS.readString();
                    AppMethodBeat.o(32248);
                    return 0;
                case 24:
                    bpc.DhA = aVar3.UbS.yZ();
                    AppMethodBeat.o(32248);
                    return 0;
                default:
                    AppMethodBeat.o(32248);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32248);
            return -1;
        }
    }
}
