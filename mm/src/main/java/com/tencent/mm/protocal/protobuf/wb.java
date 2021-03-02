package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wb extends dpc {
    public String Cog;
    public String HTZ;
    public dju LgT;
    public boolean Lhk;
    public String Lhl;
    public int Lhm;
    public LinkedList<Integer> Lhn = new LinkedList<>();
    public String Lho;
    public int Lhp;
    public int Lhq;
    public int dDN;
    public String desc;
    public String pTK;
    public String pqv;
    public String qwn;

    public wb() {
        AppMethodBeat.i(72433);
        AppMethodBeat.o(72433);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72434);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72434);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            aVar.cc(4, this.Lhk);
            if (this.Cog != null) {
                aVar.e(5, this.Cog);
            }
            if (this.Lhl != null) {
                aVar.e(6, this.Lhl);
            }
            if (this.pqv != null) {
                aVar.e(7, this.pqv);
            }
            aVar.aM(8, this.Lhm);
            if (this.desc != null) {
                aVar.e(9, this.desc);
            }
            if (this.HTZ != null) {
                aVar.e(10, this.HTZ);
            }
            aVar.e(11, 2, this.Lhn);
            if (this.Lho != null) {
                aVar.e(12, this.Lho);
            }
            if (this.pTK != null) {
                aVar.e(13, this.pTK);
            }
            aVar.aM(14, this.Lhp);
            aVar.aM(15, this.Lhq);
            if (this.LgT != null) {
                aVar.ni(16, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            AppMethodBeat.o(72434);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1;
            if (this.Cog != null) {
                fS += g.a.a.b.b.a.f(5, this.Cog);
            }
            if (this.Lhl != null) {
                fS += g.a.a.b.b.a.f(6, this.Lhl);
            }
            if (this.pqv != null) {
                fS += g.a.a.b.b.a.f(7, this.pqv);
            }
            int bu = fS + g.a.a.b.b.a.bu(8, this.Lhm);
            if (this.desc != null) {
                bu += g.a.a.b.b.a.f(9, this.desc);
            }
            if (this.HTZ != null) {
                bu += g.a.a.b.b.a.f(10, this.HTZ);
            }
            int c2 = bu + g.a.a.a.c(11, 2, this.Lhn);
            if (this.Lho != null) {
                c2 += g.a.a.b.b.a.f(12, this.Lho);
            }
            if (this.pTK != null) {
                c2 += g.a.a.b.b.a.f(13, this.pTK);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(14, this.Lhp) + g.a.a.b.b.a.bu(15, this.Lhq);
            if (this.LgT != null) {
                bu2 += g.a.a.a.nh(16, this.LgT.computeSize());
            }
            AppMethodBeat.o(72434);
            return bu2;
        } else if (i2 == 2) {
            this.Lhn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72434);
                throw bVar2;
            }
            AppMethodBeat.o(72434);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wb wbVar = (wb) objArr[1];
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
                        wbVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72434);
                    return 0;
                case 2:
                    wbVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72434);
                    return 0;
                case 3:
                    wbVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 4:
                    wbVar.Lhk = aVar3.UbS.yZ();
                    AppMethodBeat.o(72434);
                    return 0;
                case 5:
                    wbVar.Cog = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 6:
                    wbVar.Lhl = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 7:
                    wbVar.pqv = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 8:
                    wbVar.Lhm = aVar3.UbS.zi();
                    AppMethodBeat.o(72434);
                    return 0;
                case 9:
                    wbVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 10:
                    wbVar.HTZ = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 11:
                    wbVar.Lhn.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(72434);
                    return 0;
                case 12:
                    wbVar.Lho = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 13:
                    wbVar.pTK = aVar3.UbS.readString();
                    AppMethodBeat.o(72434);
                    return 0;
                case 14:
                    wbVar.Lhp = aVar3.UbS.zi();
                    AppMethodBeat.o(72434);
                    return 0;
                case 15:
                    wbVar.Lhq = aVar3.UbS.zi();
                    AppMethodBeat.o(72434);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dju.populateBuilderWithField(aVar5, dju, dpc.getNextFieldNumber(aVar5))) {
                        }
                        wbVar.LgT = dju;
                    }
                    AppMethodBeat.o(72434);
                    return 0;
                default:
                    AppMethodBeat.o(72434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72434);
            return -1;
        }
    }
}
