package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cpg extends a {
    public SKBuiltinBuffer_t KHp;
    public String Lir;
    public String Lis;
    public int LoM;
    public dqi LpA;
    public dqi LpB;
    public dqi Lqk;
    public String MbK;
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public ebj MmQ;
    public aeq MmR;
    public dqi MuI;
    public dqi MuJ;
    public dqi MuK;
    public int Mvd;
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

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101824);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(101824);
                throw bVar;
            } else if (this.Mjj == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(101824);
                throw bVar2;
            } else if (this.LpA == null) {
                b bVar3 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101824);
                throw bVar3;
            } else if (this.LpB == null) {
                b bVar4 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101824);
                throw bVar4;
            } else if (this.KHp == null) {
                b bVar5 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(101824);
                throw bVar5;
            } else if (this.MuI == null) {
                b bVar6 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(101824);
                throw bVar6;
            } else if (this.MuJ == null) {
                b bVar7 = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(101824);
                throw bVar7;
            } else if (this.MuK == null) {
                b bVar8 = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(101824);
                throw bVar8;
            } else {
                if (this.Lqk != null) {
                    aVar.ni(1, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mjj != null) {
                    aVar.ni(2, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                if (this.LpA != null) {
                    aVar.ni(3, this.LpA.computeSize());
                    this.LpA.writeFields(aVar);
                }
                if (this.LpB != null) {
                    aVar.ni(4, this.LpB.computeSize());
                    this.LpB.writeFields(aVar);
                }
                aVar.aM(5, this.kdY);
                if (this.KHp != null) {
                    aVar.ni(6, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                aVar.aM(7, this.Mvd);
                if (this.MuI != null) {
                    aVar.ni(8, this.MuI.computeSize());
                    this.MuI.writeFields(aVar);
                }
                if (this.MuJ != null) {
                    aVar.ni(9, this.MuJ.computeSize());
                    this.MuJ.writeFields(aVar);
                }
                if (this.MuK != null) {
                    aVar.ni(10, this.MuK.computeSize());
                    this.MuK.writeFields(aVar);
                }
                aVar.aM(11, this.LoM);
                if (this.kdZ != null) {
                    aVar.e(12, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(13, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(14, this.keb);
                }
                aVar.aM(15, this.kec);
                aVar.aM(16, this.MmK);
                if (this.MmL != null) {
                    aVar.e(17, this.MmL);
                }
                if (this.MmM != null) {
                    aVar.e(18, this.MmM);
                }
                if (this.MbK != null) {
                    aVar.e(19, this.MbK);
                }
                if (this.MmN != null) {
                    aVar.e(20, this.MmN);
                }
                aVar.aM(21, this.MmO);
                aVar.aM(22, this.kef);
                aVar.aM(23, this.kee);
                if (this.keg != null) {
                    aVar.e(24, this.keg);
                }
                if (this.ked != null) {
                    aVar.e(25, this.ked);
                }
                if (this.MmQ != null) {
                    aVar.ni(26, this.MmQ.computeSize());
                    this.MmQ.writeFields(aVar);
                }
                if (this.keh != null) {
                    aVar.e(27, this.keh);
                }
                if (this.Lir != null) {
                    aVar.e(28, this.Lir);
                }
                if (this.Lis != null) {
                    aVar.e(29, this.Lis);
                }
                if (this.kei != null) {
                    aVar.e(30, this.kei);
                }
                if (this.MmR != null) {
                    aVar.ni(31, this.MmR.computeSize());
                    this.MmR.writeFields(aVar);
                }
                AppMethodBeat.o(101824);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.Lqk != null ? g.a.a.a.nh(1, this.Lqk.computeSize()) + 0 : 0;
            if (this.Mjj != null) {
                nh += g.a.a.a.nh(2, this.Mjj.computeSize());
            }
            if (this.LpA != null) {
                nh += g.a.a.a.nh(3, this.LpA.computeSize());
            }
            if (this.LpB != null) {
                nh += g.a.a.a.nh(4, this.LpB.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.kdY);
            if (this.KHp != null) {
                bu += g.a.a.a.nh(6, this.KHp.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Mvd);
            if (this.MuI != null) {
                bu2 += g.a.a.a.nh(8, this.MuI.computeSize());
            }
            if (this.MuJ != null) {
                bu2 += g.a.a.a.nh(9, this.MuJ.computeSize());
            }
            if (this.MuK != null) {
                bu2 += g.a.a.a.nh(10, this.MuK.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.LoM);
            if (this.kdZ != null) {
                bu3 += g.a.a.b.b.a.f(12, this.kdZ);
            }
            if (this.kea != null) {
                bu3 += g.a.a.b.b.a.f(13, this.kea);
            }
            if (this.keb != null) {
                bu3 += g.a.a.b.b.a.f(14, this.keb);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.kec) + g.a.a.b.b.a.bu(16, this.MmK);
            if (this.MmL != null) {
                bu4 += g.a.a.b.b.a.f(17, this.MmL);
            }
            if (this.MmM != null) {
                bu4 += g.a.a.b.b.a.f(18, this.MmM);
            }
            if (this.MbK != null) {
                bu4 += g.a.a.b.b.a.f(19, this.MbK);
            }
            if (this.MmN != null) {
                bu4 += g.a.a.b.b.a.f(20, this.MmN);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(21, this.MmO) + g.a.a.b.b.a.bu(22, this.kef) + g.a.a.b.b.a.bu(23, this.kee);
            if (this.keg != null) {
                bu5 += g.a.a.b.b.a.f(24, this.keg);
            }
            if (this.ked != null) {
                bu5 += g.a.a.b.b.a.f(25, this.ked);
            }
            if (this.MmQ != null) {
                bu5 += g.a.a.a.nh(26, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu5 += g.a.a.b.b.a.f(27, this.keh);
            }
            if (this.Lir != null) {
                bu5 += g.a.a.b.b.a.f(28, this.Lir);
            }
            if (this.Lis != null) {
                bu5 += g.a.a.b.b.a.f(29, this.Lis);
            }
            if (this.kei != null) {
                bu5 += g.a.a.b.b.a.f(30, this.kei);
            }
            if (this.MmR != null) {
                bu5 += g.a.a.a.nh(31, this.MmR.computeSize());
            }
            AppMethodBeat.o(101824);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar9 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(101824);
                throw bVar9;
            } else if (this.Mjj == null) {
                b bVar10 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(101824);
                throw bVar10;
            } else if (this.LpA == null) {
                b bVar11 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101824);
                throw bVar11;
            } else if (this.LpB == null) {
                b bVar12 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101824);
                throw bVar12;
            } else if (this.KHp == null) {
                b bVar13 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(101824);
                throw bVar13;
            } else if (this.MuI == null) {
                b bVar14 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(101824);
                throw bVar14;
            } else if (this.MuJ == null) {
                b bVar15 = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(101824);
                throw bVar15;
            } else if (this.MuK == null) {
                b bVar16 = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(101824);
                throw bVar16;
            } else {
                AppMethodBeat.o(101824);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpg cpg = (cpg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cpg.Lqk = dqi;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        cpg.Mjj = dqi2;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        cpg.LpA = dqi3;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        cpg.LpB = dqi4;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 5:
                    cpg.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar8))) {
                        }
                        cpg.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 7:
                    cpg.Mvd = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi5 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi5.populateBuilderWithField(aVar9, dqi5, a.getNextFieldNumber(aVar9))) {
                        }
                        cpg.MuI = dqi5;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi6 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi6.populateBuilderWithField(aVar10, dqi6, a.getNextFieldNumber(aVar10))) {
                        }
                        cpg.MuJ = dqi6;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dqi dqi7 = new dqi();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dqi7.populateBuilderWithField(aVar11, dqi7, a.getNextFieldNumber(aVar11))) {
                        }
                        cpg.MuK = dqi7;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 11:
                    cpg.LoM = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 12:
                    cpg.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 13:
                    cpg.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 14:
                    cpg.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 15:
                    cpg.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 16:
                    cpg.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 17:
                    cpg.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 18:
                    cpg.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 19:
                    cpg.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 20:
                    cpg.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 21:
                    cpg.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 22:
                    cpg.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 23:
                    cpg.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(101824);
                    return 0;
                case 24:
                    cpg.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 25:
                    cpg.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ebj.populateBuilderWithField(aVar12, ebj, a.getNextFieldNumber(aVar12))) {
                        }
                        cpg.MmQ = ebj;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                case 27:
                    cpg.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 28:
                    cpg.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 29:
                    cpg.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 30:
                    cpg.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(101824);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = aeq.populateBuilderWithField(aVar13, aeq, a.getNextFieldNumber(aVar13))) {
                        }
                        cpg.MmR = aeq;
                    }
                    AppMethodBeat.o(101824);
                    return 0;
                default:
                    AppMethodBeat.o(101824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101824);
            return -1;
        }
    }
}
