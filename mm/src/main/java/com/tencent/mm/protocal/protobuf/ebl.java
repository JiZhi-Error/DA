package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebl extends dpc {
    public LinkedList<SnsObject> KOH = new LinkedList<>();
    public int MZF;
    public LinkedList<ebo> MZG = new LinkedList<>();
    public String MZg;
    public int MZk;
    public eat MZl;
    public ebj MmQ;
    public int MvM;
    public int NaG;
    public int Nbf;
    public long Nbg;
    public long Nbh;
    public String Nbi;
    public boolean Nbj;

    public ebl() {
        AppMethodBeat.i(125836);
        AppMethodBeat.o(125836);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125837);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125837);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            aVar.aM(3, this.MvM);
            aVar.e(4, 8, this.KOH);
            aVar.aM(5, this.Nbf);
            if (this.MmQ != null) {
                aVar.ni(6, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            aVar.aM(7, this.NaG);
            aVar.aM(8, this.MZk);
            if (this.MZl != null) {
                aVar.ni(9, this.MZl.computeSize());
                this.MZl.writeFields(aVar);
            }
            aVar.bb(10, this.Nbg);
            aVar.bb(11, this.Nbh);
            if (this.Nbi != null) {
                aVar.e(12, this.Nbi);
            }
            aVar.aM(13, this.MZF);
            aVar.e(14, 8, this.MZG);
            aVar.cc(15, this.Nbj);
            AppMethodBeat.o(125837);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.Nbf);
            if (this.MmQ != null) {
                bu += g.a.a.a.nh(6, this.MmQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.NaG) + g.a.a.b.b.a.bu(8, this.MZk);
            if (this.MZl != null) {
                bu2 += g.a.a.a.nh(9, this.MZl.computeSize());
            }
            int r = bu2 + g.a.a.b.b.a.r(10, this.Nbg) + g.a.a.b.b.a.r(11, this.Nbh);
            if (this.Nbi != null) {
                r += g.a.a.b.b.a.f(12, this.Nbi);
            }
            int bu3 = r + g.a.a.b.b.a.bu(13, this.MZF) + g.a.a.a.c(14, 8, this.MZG) + g.a.a.b.b.a.fS(15) + 1;
            AppMethodBeat.o(125837);
            return bu3;
        } else if (i2 == 2) {
            this.KOH.clear();
            this.MZG.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125837);
                throw bVar2;
            }
            AppMethodBeat.o(125837);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebl ebl = (ebl) objArr[1];
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
                        ebl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125837);
                    return 0;
                case 2:
                    ebl.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(125837);
                    return 0;
                case 3:
                    ebl.MvM = aVar3.UbS.zi();
                    AppMethodBeat.o(125837);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SnsObject snsObject = new SnsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = snsObject.populateBuilderWithField(aVar5, snsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ebl.KOH.add(snsObject);
                    }
                    AppMethodBeat.o(125837);
                    return 0;
                case 5:
                    ebl.Nbf = aVar3.UbS.zi();
                    AppMethodBeat.o(125837);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ebj.populateBuilderWithField(aVar6, ebj, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ebl.MmQ = ebj;
                    }
                    AppMethodBeat.o(125837);
                    return 0;
                case 7:
                    ebl.NaG = aVar3.UbS.zi();
                    AppMethodBeat.o(125837);
                    return 0;
                case 8:
                    ebl.MZk = aVar3.UbS.zi();
                    AppMethodBeat.o(125837);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eat eat = new eat();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eat.populateBuilderWithField(aVar7, eat, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ebl.MZl = eat;
                    }
                    AppMethodBeat.o(125837);
                    return 0;
                case 10:
                    ebl.Nbg = aVar3.UbS.zl();
                    AppMethodBeat.o(125837);
                    return 0;
                case 11:
                    ebl.Nbh = aVar3.UbS.zl();
                    AppMethodBeat.o(125837);
                    return 0;
                case 12:
                    ebl.Nbi = aVar3.UbS.readString();
                    AppMethodBeat.o(125837);
                    return 0;
                case 13:
                    ebl.MZF = aVar3.UbS.zi();
                    AppMethodBeat.o(125837);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ebo ebo = new ebo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ebo.populateBuilderWithField(aVar8, ebo, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ebl.MZG.add(ebo);
                    }
                    AppMethodBeat.o(125837);
                    return 0;
                case 15:
                    ebl.Nbj = aVar3.UbS.yZ();
                    AppMethodBeat.o(125837);
                    return 0;
                default:
                    AppMethodBeat.o(125837);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125837);
            return -1;
        }
    }
}
