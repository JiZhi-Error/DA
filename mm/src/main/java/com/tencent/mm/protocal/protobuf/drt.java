package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drt extends dpc {
    public SKBuiltinBuffer_t KHp;
    public String LRO;
    public int LUB;
    public LinkedList<drr> LUC = new LinkedList<>();
    public String Lir;
    public String Lis;
    public dqi LpA;
    public dqi LpB;
    public dqi Lqk;
    public int MUk;
    public SKBuiltinBuffer_t MUm;
    public String MUn;
    public String MUo;
    public int MUp;
    public LinkedList<dsk> MUq = new LinkedList<>();
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public ebj MmQ;
    public aeq MmR;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String ked;
    public int kee;
    public int kef;
    public String keg;
    public String keh;
    public String kei;

    public drt() {
        AppMethodBeat.i(152683);
        AppMethodBeat.o(152683);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152684);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152684);
                throw bVar;
            } else if (this.Lqk == null) {
                b bVar2 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(152684);
                throw bVar2;
            } else if (this.Mjj == null) {
                b bVar3 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(152684);
                throw bVar3;
            } else if (this.LpA == null) {
                b bVar4 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(152684);
                throw bVar4;
            } else if (this.LpB == null) {
                b bVar5 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(152684);
                throw bVar5;
            } else if (this.KHp == null) {
                b bVar6 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(152684);
                throw bVar6;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Lqk != null) {
                    aVar.ni(2, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mjj != null) {
                    aVar.ni(3, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                if (this.LpA != null) {
                    aVar.ni(4, this.LpA.computeSize());
                    this.LpA.writeFields(aVar);
                }
                if (this.LpB != null) {
                    aVar.ni(5, this.LpB.computeSize());
                    this.LpB.writeFields(aVar);
                }
                aVar.aM(6, this.kdY);
                if (this.KHp != null) {
                    aVar.ni(7, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                if (this.kdZ != null) {
                    aVar.e(8, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(9, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(10, this.keb);
                }
                aVar.aM(11, this.kec);
                aVar.aM(12, this.MmK);
                if (this.MmL != null) {
                    aVar.e(13, this.MmL);
                }
                if (this.MmM != null) {
                    aVar.e(14, this.MmM);
                }
                if (this.ked != null) {
                    aVar.e(15, this.ked);
                }
                if (this.MmN != null) {
                    aVar.e(16, this.MmN);
                }
                aVar.aM(17, this.MmO);
                aVar.aM(18, this.kef);
                aVar.aM(19, this.kee);
                if (this.keg != null) {
                    aVar.e(20, this.keg);
                }
                if (this.MmQ != null) {
                    aVar.ni(21, this.MmQ.computeSize());
                    this.MmQ.writeFields(aVar);
                }
                if (this.keh != null) {
                    aVar.e(22, this.keh);
                }
                if (this.kei != null) {
                    aVar.e(23, this.kei);
                }
                if (this.MmR != null) {
                    aVar.ni(24, this.MmR.computeSize());
                    this.MmR.writeFields(aVar);
                }
                aVar.aM(25, this.LUB);
                aVar.e(26, 8, this.LUC);
                if (this.Lir != null) {
                    aVar.e(27, this.Lir);
                }
                if (this.Lis != null) {
                    aVar.e(28, this.Lis);
                }
                if (this.MUm != null) {
                    aVar.ni(29, this.MUm.computeSize());
                    this.MUm.writeFields(aVar);
                }
                if (this.LRO != null) {
                    aVar.e(30, this.LRO);
                }
                if (this.MUn != null) {
                    aVar.e(31, this.MUn);
                }
                aVar.aM(32, this.MUk);
                if (this.MUo != null) {
                    aVar.e(33, this.MUo);
                }
                aVar.aM(34, this.MUp);
                aVar.e(35, 8, this.MUq);
                AppMethodBeat.o(152684);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Lqk != null) {
                nh += g.a.a.a.nh(2, this.Lqk.computeSize());
            }
            if (this.Mjj != null) {
                nh += g.a.a.a.nh(3, this.Mjj.computeSize());
            }
            if (this.LpA != null) {
                nh += g.a.a.a.nh(4, this.LpA.computeSize());
            }
            if (this.LpB != null) {
                nh += g.a.a.a.nh(5, this.LpB.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.kdY);
            if (this.KHp != null) {
                bu += g.a.a.a.nh(7, this.KHp.computeSize());
            }
            if (this.kdZ != null) {
                bu += g.a.a.b.b.a.f(8, this.kdZ);
            }
            if (this.kea != null) {
                bu += g.a.a.b.b.a.f(9, this.kea);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(10, this.keb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.kec) + g.a.a.b.b.a.bu(12, this.MmK);
            if (this.MmL != null) {
                bu2 += g.a.a.b.b.a.f(13, this.MmL);
            }
            if (this.MmM != null) {
                bu2 += g.a.a.b.b.a.f(14, this.MmM);
            }
            if (this.ked != null) {
                bu2 += g.a.a.b.b.a.f(15, this.ked);
            }
            if (this.MmN != null) {
                bu2 += g.a.a.b.b.a.f(16, this.MmN);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.MmO) + g.a.a.b.b.a.bu(18, this.kef) + g.a.a.b.b.a.bu(19, this.kee);
            if (this.keg != null) {
                bu3 += g.a.a.b.b.a.f(20, this.keg);
            }
            if (this.MmQ != null) {
                bu3 += g.a.a.a.nh(21, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu3 += g.a.a.b.b.a.f(22, this.keh);
            }
            if (this.kei != null) {
                bu3 += g.a.a.b.b.a.f(23, this.kei);
            }
            if (this.MmR != null) {
                bu3 += g.a.a.a.nh(24, this.MmR.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(25, this.LUB) + g.a.a.a.c(26, 8, this.LUC);
            if (this.Lir != null) {
                bu4 += g.a.a.b.b.a.f(27, this.Lir);
            }
            if (this.Lis != null) {
                bu4 += g.a.a.b.b.a.f(28, this.Lis);
            }
            if (this.MUm != null) {
                bu4 += g.a.a.a.nh(29, this.MUm.computeSize());
            }
            if (this.LRO != null) {
                bu4 += g.a.a.b.b.a.f(30, this.LRO);
            }
            if (this.MUn != null) {
                bu4 += g.a.a.b.b.a.f(31, this.MUn);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(32, this.MUk);
            if (this.MUo != null) {
                bu5 += g.a.a.b.b.a.f(33, this.MUo);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(34, this.MUp) + g.a.a.a.c(35, 8, this.MUq);
            AppMethodBeat.o(152684);
            return bu6;
        } else if (i2 == 2) {
            this.LUC.clear();
            this.MUq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar7 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152684);
                throw bVar7;
            } else if (this.Lqk == null) {
                b bVar8 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(152684);
                throw bVar8;
            } else if (this.Mjj == null) {
                b bVar9 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(152684);
                throw bVar9;
            } else if (this.LpA == null) {
                b bVar10 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(152684);
                throw bVar10;
            } else if (this.LpB == null) {
                b bVar11 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(152684);
                throw bVar11;
            } else if (this.KHp == null) {
                b bVar12 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(152684);
                throw bVar12;
            } else {
                AppMethodBeat.o(152684);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drt drt = (drt) objArr[1];
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
                        drt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        drt.Lqk = dqi;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        drt.Mjj = dqi2;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        drt.LpA = dqi3;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi4.populateBuilderWithField(aVar8, dqi4, dpc.getNextFieldNumber(aVar8))) {
                        }
                        drt.LpB = dqi4;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 6:
                    drt.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t.populateBuilderWithField(aVar9, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar9))) {
                        }
                        drt.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 8:
                    drt.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 9:
                    drt.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 10:
                    drt.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 11:
                    drt.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 12:
                    drt.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 13:
                    drt.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 14:
                    drt.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 15:
                    drt.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 16:
                    drt.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 17:
                    drt.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 18:
                    drt.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 19:
                    drt.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 20:
                    drt.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ebj.populateBuilderWithField(aVar10, ebj, dpc.getNextFieldNumber(aVar10))) {
                        }
                        drt.MmQ = ebj;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 22:
                    drt.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 23:
                    drt.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = aeq.populateBuilderWithField(aVar11, aeq, dpc.getNextFieldNumber(aVar11))) {
                        }
                        drt.MmR = aeq;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 25:
                    drt.LUB = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        drr drr = new drr();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = drr.populateBuilderWithField(aVar12, drr, dpc.getNextFieldNumber(aVar12))) {
                        }
                        drt.LUC.add(drr);
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 27:
                    drt.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 28:
                    drt.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 29:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar13, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar13))) {
                        }
                        drt.MUm = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                case 30:
                    drt.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 31:
                    drt.MUn = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 32:
                    drt.MUk = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 33:
                    drt.MUo = aVar3.UbS.readString();
                    AppMethodBeat.o(152684);
                    return 0;
                case 34:
                    drt.MUp = aVar3.UbS.zi();
                    AppMethodBeat.o(152684);
                    return 0;
                case 35:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        dsk dsk = new dsk();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = dsk.populateBuilderWithField(aVar14, dsk, dpc.getNextFieldNumber(aVar14))) {
                        }
                        drt.MUq.add(dsk);
                    }
                    AppMethodBeat.o(152684);
                    return 0;
                default:
                    AppMethodBeat.o(152684);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152684);
            return -1;
        }
    }
}
