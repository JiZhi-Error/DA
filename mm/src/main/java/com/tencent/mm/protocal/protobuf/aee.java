package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aee extends dpc {
    public LinkedList<coo> KGQ = new LinkedList<>();
    public dqi KGR;
    public SKBuiltinBuffer_t KHp;
    public String Lir;
    public String Lis;
    public dqi LpA;
    public dqi LpB;
    public dqi Lpx;
    public int gsq;

    public aee() {
        AppMethodBeat.i(101799);
        AppMethodBeat.o(101799);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101800);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101800);
                throw bVar;
            } else if (this.Lpx == null) {
                b bVar2 = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(101800);
                throw bVar2;
            } else if (this.LpA == null) {
                b bVar3 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101800);
                throw bVar3;
            } else if (this.LpB == null) {
                b bVar4 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101800);
                throw bVar4;
            } else if (this.KGR == null) {
                b bVar5 = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101800);
                throw bVar5;
            } else if (this.KHp == null) {
                b bVar6 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(101800);
                throw bVar6;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Lpx != null) {
                    aVar.ni(2, this.Lpx.computeSize());
                    this.Lpx.writeFields(aVar);
                }
                if (this.LpA != null) {
                    aVar.ni(3, this.LpA.computeSize());
                    this.LpA.writeFields(aVar);
                }
                if (this.LpB != null) {
                    aVar.ni(4, this.LpB.computeSize());
                    this.LpB.writeFields(aVar);
                }
                aVar.aM(5, this.gsq);
                aVar.e(6, 8, this.KGQ);
                if (this.KGR != null) {
                    aVar.ni(7, this.KGR.computeSize());
                    this.KGR.writeFields(aVar);
                }
                if (this.KHp != null) {
                    aVar.ni(8, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                if (this.Lir != null) {
                    aVar.e(9, this.Lir);
                }
                if (this.Lis != null) {
                    aVar.e(10, this.Lis);
                }
                AppMethodBeat.o(101800);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Lpx != null) {
                nh += g.a.a.a.nh(2, this.Lpx.computeSize());
            }
            if (this.LpA != null) {
                nh += g.a.a.a.nh(3, this.LpA.computeSize());
            }
            if (this.LpB != null) {
                nh += g.a.a.a.nh(4, this.LpB.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.gsq) + g.a.a.a.c(6, 8, this.KGQ);
            if (this.KGR != null) {
                bu += g.a.a.a.nh(7, this.KGR.computeSize());
            }
            if (this.KHp != null) {
                bu += g.a.a.a.nh(8, this.KHp.computeSize());
            }
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(9, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(10, this.Lis);
            }
            AppMethodBeat.o(101800);
            return bu;
        } else if (i2 == 2) {
            this.KGQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar7 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101800);
                throw bVar7;
            } else if (this.Lpx == null) {
                b bVar8 = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(101800);
                throw bVar8;
            } else if (this.LpA == null) {
                b bVar9 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101800);
                throw bVar9;
            } else if (this.LpB == null) {
                b bVar10 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101800);
                throw bVar10;
            } else if (this.KGR == null) {
                b bVar11 = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101800);
                throw bVar11;
            } else if (this.KHp == null) {
                b bVar12 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(101800);
                throw bVar12;
            } else {
                AppMethodBeat.o(101800);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aee aee = (aee) objArr[1];
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
                        aee.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aee.Lpx = dqi;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aee.LpA = dqi2;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        aee.LpB = dqi3;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 5:
                    aee.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(101800);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        coo coo = new coo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = coo.populateBuilderWithField(aVar8, coo, dpc.getNextFieldNumber(aVar8))) {
                        }
                        aee.KGQ.add(coo);
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi4.populateBuilderWithField(aVar9, dqi4, dpc.getNextFieldNumber(aVar9))) {
                        }
                        aee.KGR = dqi4;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t.populateBuilderWithField(aVar10, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar10))) {
                        }
                        aee.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(101800);
                    return 0;
                case 9:
                    aee.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(101800);
                    return 0;
                case 10:
                    aee.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(101800);
                    return 0;
                default:
                    AppMethodBeat.o(101800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101800);
            return -1;
        }
    }
}
