package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class efe extends dpc {
    public b Buffer;
    public int NeZ;
    public int NfA;
    public String Nfi;
    public efh Nfj;
    public String Nfk;
    public String Nfl;
    public int Nfm;
    public int Nfn;
    public int Nfo;
    public boolean Nfp;
    public String Nfq;
    public int Nfr;
    public int Nfs;
    public int Nft;
    public String Nfu;
    public boolean Nfv;
    public String Nfw;
    public String Nfx;
    public int Nfy;
    public eff Nfz;
    public LinkedList<efc> xJg = new LinkedList<>();

    public efe() {
        AppMethodBeat.i(152706);
        AppMethodBeat.o(152706);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152707);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152707);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.xJg);
            if (this.Nfj != null) {
                aVar.ni(3, this.Nfj.computeSize());
                this.Nfj.writeFields(aVar);
            }
            if (this.Nfk != null) {
                aVar.e(4, this.Nfk);
            }
            if (this.Nfl != null) {
                aVar.e(5, this.Nfl);
            }
            aVar.aM(6, this.Nfm);
            aVar.aM(9, this.Nfn);
            aVar.aM(10, this.Nfo);
            aVar.aM(11, this.NeZ);
            aVar.cc(12, this.Nfp);
            if (this.Nfq != null) {
                aVar.e(13, this.Nfq);
            }
            aVar.aM(14, this.Nfr);
            aVar.aM(15, this.Nfs);
            if (this.Buffer != null) {
                aVar.c(16, this.Buffer);
            }
            aVar.aM(17, this.Nft);
            if (this.Nfu != null) {
                aVar.e(18, this.Nfu);
            }
            aVar.cc(19, this.Nfv);
            if (this.Nfw != null) {
                aVar.e(20, this.Nfw);
            }
            if (this.Nfx != null) {
                aVar.e(21, this.Nfx);
            }
            aVar.aM(22, this.Nfy);
            if (this.Nfz != null) {
                aVar.ni(23, this.Nfz.computeSize());
                this.Nfz.writeFields(aVar);
            }
            aVar.aM(24, this.NfA);
            if (this.Nfi != null) {
                aVar.e(25, this.Nfi);
            }
            AppMethodBeat.o(152707);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.xJg);
            if (this.Nfj != null) {
                nh += g.a.a.a.nh(3, this.Nfj.computeSize());
            }
            if (this.Nfk != null) {
                nh += g.a.a.b.b.a.f(4, this.Nfk);
            }
            if (this.Nfl != null) {
                nh += g.a.a.b.b.a.f(5, this.Nfl);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Nfm) + g.a.a.b.b.a.bu(9, this.Nfn) + g.a.a.b.b.a.bu(10, this.Nfo) + g.a.a.b.b.a.bu(11, this.NeZ) + g.a.a.b.b.a.fS(12) + 1;
            if (this.Nfq != null) {
                bu += g.a.a.b.b.a.f(13, this.Nfq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.Nfr) + g.a.a.b.b.a.bu(15, this.Nfs);
            if (this.Buffer != null) {
                bu2 += g.a.a.b.b.a.b(16, this.Buffer);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.Nft);
            if (this.Nfu != null) {
                bu3 += g.a.a.b.b.a.f(18, this.Nfu);
            }
            int fS = bu3 + g.a.a.b.b.a.fS(19) + 1;
            if (this.Nfw != null) {
                fS += g.a.a.b.b.a.f(20, this.Nfw);
            }
            if (this.Nfx != null) {
                fS += g.a.a.b.b.a.f(21, this.Nfx);
            }
            int bu4 = fS + g.a.a.b.b.a.bu(22, this.Nfy);
            if (this.Nfz != null) {
                bu4 += g.a.a.a.nh(23, this.Nfz.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(24, this.NfA);
            if (this.Nfi != null) {
                bu5 += g.a.a.b.b.a.f(25, this.Nfi);
            }
            AppMethodBeat.o(152707);
            return bu5;
        } else if (i2 == 2) {
            this.xJg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152707);
                throw bVar2;
            }
            AppMethodBeat.o(152707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efe efe = (efe) objArr[1];
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
                        efe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152707);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efc efc = new efc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efc.populateBuilderWithField(aVar5, efc, dpc.getNextFieldNumber(aVar5))) {
                        }
                        efe.xJg.add(efc);
                    }
                    AppMethodBeat.o(152707);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        efh efh = new efh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = efh.populateBuilderWithField(aVar6, efh, dpc.getNextFieldNumber(aVar6))) {
                        }
                        efe.Nfj = efh;
                    }
                    AppMethodBeat.o(152707);
                    return 0;
                case 4:
                    efe.Nfk = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 5:
                    efe.Nfl = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 6:
                    efe.Nfm = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(152707);
                    return -1;
                case 9:
                    efe.Nfn = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 10:
                    efe.Nfo = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 11:
                    efe.NeZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 12:
                    efe.Nfp = aVar3.UbS.yZ();
                    AppMethodBeat.o(152707);
                    return 0;
                case 13:
                    efe.Nfq = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 14:
                    efe.Nfr = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 15:
                    efe.Nfs = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 16:
                    efe.Buffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(152707);
                    return 0;
                case 17:
                    efe.Nft = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 18:
                    efe.Nfu = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 19:
                    efe.Nfv = aVar3.UbS.yZ();
                    AppMethodBeat.o(152707);
                    return 0;
                case 20:
                    efe.Nfw = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 21:
                    efe.Nfx = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
                case 22:
                    efe.Nfy = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eff eff = new eff();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eff.populateBuilderWithField(aVar7, eff, dpc.getNextFieldNumber(aVar7))) {
                        }
                        efe.Nfz = eff;
                    }
                    AppMethodBeat.o(152707);
                    return 0;
                case 24:
                    efe.NfA = aVar3.UbS.zi();
                    AppMethodBeat.o(152707);
                    return 0;
                case 25:
                    efe.Nfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152707);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152707);
            return -1;
        }
    }
}
