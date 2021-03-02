package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mk extends dpc {
    public int KEf;
    public int KEi;
    public SKBuiltinBuffer_t KHp;
    public SKBuiltinBuffer_t KLb;
    public SKBuiltinBuffer_t KLh;
    public SKBuiltinBuffer_t KQA;
    public int KQC;
    public String KQD;
    public String KQE;
    public dql KQo;
    public String KQw;
    public dqi KQz;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155397);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155397);
                throw bVar;
            } else if (this.KHp == null) {
                b bVar2 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(155397);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KQw != null) {
                    aVar.e(2, this.KQw);
                }
                if (this.KHp != null) {
                    aVar.ni(3, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                aVar.aM(4, this.KEi);
                aVar.aM(5, this.KQC);
                if (this.KQD != null) {
                    aVar.e(6, this.KQD);
                }
                aVar.aM(7, this.oTW);
                if (this.KQE != null) {
                    aVar.e(8, this.KQE);
                }
                if (this.KQz != null) {
                    aVar.ni(9, this.KQz.computeSize());
                    this.KQz.writeFields(aVar);
                }
                if (this.KLh != null) {
                    aVar.ni(10, this.KLh.computeSize());
                    this.KLh.writeFields(aVar);
                }
                if (this.KQA != null) {
                    aVar.ni(11, this.KQA.computeSize());
                    this.KQA.writeFields(aVar);
                }
                if (this.KQo != null) {
                    aVar.ni(12, this.KQo.computeSize());
                    this.KQo.writeFields(aVar);
                }
                aVar.aM(13, this.KEf);
                if (this.KLb != null) {
                    aVar.ni(14, this.KLb.computeSize());
                    this.KLb.writeFields(aVar);
                }
                AppMethodBeat.o(155397);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KQw != null) {
                nh += g.a.a.b.b.a.f(2, this.KQw);
            }
            if (this.KHp != null) {
                nh += g.a.a.a.nh(3, this.KHp.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KEi) + g.a.a.b.b.a.bu(5, this.KQC);
            if (this.KQD != null) {
                bu += g.a.a.b.b.a.f(6, this.KQD);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.oTW);
            if (this.KQE != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KQE);
            }
            if (this.KQz != null) {
                bu2 += g.a.a.a.nh(9, this.KQz.computeSize());
            }
            if (this.KLh != null) {
                bu2 += g.a.a.a.nh(10, this.KLh.computeSize());
            }
            if (this.KQA != null) {
                bu2 += g.a.a.a.nh(11, this.KQA.computeSize());
            }
            if (this.KQo != null) {
                bu2 += g.a.a.a.nh(12, this.KQo.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.KEf);
            if (this.KLb != null) {
                bu3 += g.a.a.a.nh(14, this.KLb.computeSize());
            }
            AppMethodBeat.o(155397);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155397);
                throw bVar3;
            } else if (this.KHp == null) {
                b bVar4 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(155397);
                throw bVar4;
            } else {
                AppMethodBeat.o(155397);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mk mkVar = (mk) objArr[1];
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
                        mkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 2:
                    mkVar.KQw = aVar3.UbS.readString();
                    AppMethodBeat.o(155397);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        mkVar.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 4:
                    mkVar.KEi = aVar3.UbS.zi();
                    AppMethodBeat.o(155397);
                    return 0;
                case 5:
                    mkVar.KQC = aVar3.UbS.zi();
                    AppMethodBeat.o(155397);
                    return 0;
                case 6:
                    mkVar.KQD = aVar3.UbS.readString();
                    AppMethodBeat.o(155397);
                    return 0;
                case 7:
                    mkVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(155397);
                    return 0;
                case 8:
                    mkVar.KQE = aVar3.UbS.readString();
                    AppMethodBeat.o(155397);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dpc.getNextFieldNumber(aVar6))) {
                        }
                        mkVar.KQz = dqi;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        mkVar.KLh = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar8, sKBuiltinBuffer_t3, dpc.getNextFieldNumber(aVar8))) {
                        }
                        mkVar.KQA = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dql dql = new dql();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dql.populateBuilderWithField(aVar9, dql, dpc.getNextFieldNumber(aVar9))) {
                        }
                        mkVar.KQo = dql;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                case 13:
                    mkVar.KEf = aVar3.UbS.zi();
                    AppMethodBeat.o(155397);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar10, sKBuiltinBuffer_t4, dpc.getNextFieldNumber(aVar10))) {
                        }
                        mkVar.KLb = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(155397);
                    return 0;
                default:
                    AppMethodBeat.o(155397);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155397);
            return -1;
        }
    }
}
