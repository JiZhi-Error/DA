package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpe extends dpc {
    public int KZh;
    public String KZj;
    public SKBuiltinBuffer_t LXm;
    public int LXr;
    public LinkedList<dqi> LXs = new LinkedList<>();
    public int LXt;
    public LinkedList<chj> LXu = new LinkedList<>();
    public String LXv;
    public int LXw;
    public int LXx;
    public chk LXy;
    public String LXz;
    public String kea;

    public bpe() {
        AppMethodBeat.i(32251);
        AppMethodBeat.o(32251);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32252);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32252);
                throw bVar;
            } else if (this.LXm == null) {
                b bVar2 = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(32252);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LXm != null) {
                    aVar.ni(2, this.LXm.computeSize());
                    this.LXm.writeFields(aVar);
                }
                aVar.aM(3, this.LXr);
                aVar.e(4, 8, this.LXs);
                aVar.aM(5, this.LXt);
                aVar.e(6, 8, this.LXu);
                aVar.aM(7, this.KZh);
                if (this.LXv != null) {
                    aVar.e(8, this.LXv);
                }
                if (this.KZj != null) {
                    aVar.e(9, this.KZj);
                }
                aVar.aM(10, this.LXw);
                if (this.kea != null) {
                    aVar.e(11, this.kea);
                }
                aVar.aM(12, this.LXx);
                if (this.LXy != null) {
                    aVar.ni(13, this.LXy.computeSize());
                    this.LXy.writeFields(aVar);
                }
                if (this.LXz != null) {
                    aVar.e(14, this.LXz);
                }
                AppMethodBeat.o(32252);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LXm != null) {
                nh += g.a.a.a.nh(2, this.LXm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LXr) + g.a.a.a.c(4, 8, this.LXs) + g.a.a.b.b.a.bu(5, this.LXt) + g.a.a.a.c(6, 8, this.LXu) + g.a.a.b.b.a.bu(7, this.KZh);
            if (this.LXv != null) {
                bu += g.a.a.b.b.a.f(8, this.LXv);
            }
            if (this.KZj != null) {
                bu += g.a.a.b.b.a.f(9, this.KZj);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.LXw);
            if (this.kea != null) {
                bu2 += g.a.a.b.b.a.f(11, this.kea);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.LXx);
            if (this.LXy != null) {
                bu3 += g.a.a.a.nh(13, this.LXy.computeSize());
            }
            if (this.LXz != null) {
                bu3 += g.a.a.b.b.a.f(14, this.LXz);
            }
            AppMethodBeat.o(32252);
            return bu3;
        } else if (i2 == 2) {
            this.LXs.clear();
            this.LXu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32252);
                throw bVar3;
            } else if (this.LXm == null) {
                b bVar4 = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(32252);
                throw bVar4;
            } else {
                AppMethodBeat.o(32252);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpe bpe = (bpe) objArr[1];
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
                        bpe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32252);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bpe.LXm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32252);
                    return 0;
                case 3:
                    bpe.LXr = aVar3.UbS.zi();
                    AppMethodBeat.o(32252);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bpe.LXs.add(dqi);
                    }
                    AppMethodBeat.o(32252);
                    return 0;
                case 5:
                    bpe.LXt = aVar3.UbS.zi();
                    AppMethodBeat.o(32252);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        chj chj = new chj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = chj.populateBuilderWithField(aVar7, chj, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bpe.LXu.add(chj);
                    }
                    AppMethodBeat.o(32252);
                    return 0;
                case 7:
                    bpe.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(32252);
                    return 0;
                case 8:
                    bpe.LXv = aVar3.UbS.readString();
                    AppMethodBeat.o(32252);
                    return 0;
                case 9:
                    bpe.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(32252);
                    return 0;
                case 10:
                    bpe.LXw = aVar3.UbS.zi();
                    AppMethodBeat.o(32252);
                    return 0;
                case 11:
                    bpe.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(32252);
                    return 0;
                case 12:
                    bpe.LXx = aVar3.UbS.zi();
                    AppMethodBeat.o(32252);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        chk chk = new chk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = chk.populateBuilderWithField(aVar8, chk, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bpe.LXy = chk;
                    }
                    AppMethodBeat.o(32252);
                    return 0;
                case 14:
                    bpe.LXz = aVar3.UbS.readString();
                    AppMethodBeat.o(32252);
                    return 0;
                default:
                    AppMethodBeat.o(32252);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32252);
            return -1;
        }
    }
}
