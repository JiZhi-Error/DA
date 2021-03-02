package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class hk extends a {
    public String KEj;
    public aif KKX;
    public SKBuiltinBuffer_t KKY;
    public SKBuiltinBuffer_t KKZ;
    public int KLa;
    public SKBuiltinBuffer_t KLb;
    public ews KLc;
    public fcb KLd;
    public SKBuiltinBuffer_t KLe;
    public SKBuiltinBuffer_t KLf;
    public String KLg;
    public SKBuiltinBuffer_t KLh;
    public String KLi;
    public dyh KLj;
    public String KLk;
    public int KLl;
    public int KLm;
    public int KLn;
    public int KLo;
    public int KLp;
    public SKBuiltinBuffer_t KLq;
    public SKBuiltinBuffer_t KLr;
    public int KLs;
    public int rBx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133145);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKX == null) {
                b bVar = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(133145);
                throw bVar;
            } else if (this.KKY == null) {
                b bVar2 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(133145);
                throw bVar2;
            } else if (this.KKZ == null) {
                b bVar3 = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133145);
                throw bVar3;
            } else if (this.KLq == null) {
                b bVar4 = new b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.o(133145);
                throw bVar4;
            } else if (this.KLr == null) {
                b bVar5 = new b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.o(133145);
                throw bVar5;
            } else {
                aVar.aM(1, this.rBx);
                if (this.KKX != null) {
                    aVar.ni(2, this.KKX.computeSize());
                    this.KKX.writeFields(aVar);
                }
                if (this.KKY != null) {
                    aVar.ni(3, this.KKY.computeSize());
                    this.KKY.writeFields(aVar);
                }
                if (this.KKZ != null) {
                    aVar.ni(4, this.KKZ.computeSize());
                    this.KKZ.writeFields(aVar);
                }
                aVar.aM(5, this.KLa);
                if (this.KLb != null) {
                    aVar.ni(6, this.KLb.computeSize());
                    this.KLb.writeFields(aVar);
                }
                if (this.KLc != null) {
                    aVar.ni(7, this.KLc.computeSize());
                    this.KLc.writeFields(aVar);
                }
                if (this.KLd != null) {
                    aVar.ni(8, this.KLd.computeSize());
                    this.KLd.writeFields(aVar);
                }
                if (this.KLe != null) {
                    aVar.ni(9, this.KLe.computeSize());
                    this.KLe.writeFields(aVar);
                }
                if (this.KLf != null) {
                    aVar.ni(10, this.KLf.computeSize());
                    this.KLf.writeFields(aVar);
                }
                if (this.KLg != null) {
                    aVar.e(11, this.KLg);
                }
                if (this.KLh != null) {
                    aVar.ni(12, this.KLh.computeSize());
                    this.KLh.writeFields(aVar);
                }
                if (this.KLi != null) {
                    aVar.e(14, this.KLi);
                }
                if (this.KLj != null) {
                    aVar.ni(15, this.KLj.computeSize());
                    this.KLj.writeFields(aVar);
                }
                if (this.KLk != null) {
                    aVar.e(16, this.KLk);
                }
                aVar.aM(17, this.KLl);
                aVar.aM(18, this.KLm);
                aVar.aM(19, this.KLn);
                if (this.KEj != null) {
                    aVar.e(20, this.KEj);
                }
                aVar.aM(21, this.KLo);
                aVar.aM(22, this.KLp);
                if (this.KLq != null) {
                    aVar.ni(23, this.KLq.computeSize());
                    this.KLq.writeFields(aVar);
                }
                if (this.KLr != null) {
                    aVar.ni(24, this.KLr.computeSize());
                    this.KLr.writeFields(aVar);
                }
                aVar.aM(25, this.KLs);
                AppMethodBeat.o(133145);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.rBx) + 0;
            if (this.KKX != null) {
                bu += g.a.a.a.nh(2, this.KKX.computeSize());
            }
            if (this.KKY != null) {
                bu += g.a.a.a.nh(3, this.KKY.computeSize());
            }
            if (this.KKZ != null) {
                bu += g.a.a.a.nh(4, this.KKZ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KLa);
            if (this.KLb != null) {
                bu2 += g.a.a.a.nh(6, this.KLb.computeSize());
            }
            if (this.KLc != null) {
                bu2 += g.a.a.a.nh(7, this.KLc.computeSize());
            }
            if (this.KLd != null) {
                bu2 += g.a.a.a.nh(8, this.KLd.computeSize());
            }
            if (this.KLe != null) {
                bu2 += g.a.a.a.nh(9, this.KLe.computeSize());
            }
            if (this.KLf != null) {
                bu2 += g.a.a.a.nh(10, this.KLf.computeSize());
            }
            if (this.KLg != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KLg);
            }
            if (this.KLh != null) {
                bu2 += g.a.a.a.nh(12, this.KLh.computeSize());
            }
            if (this.KLi != null) {
                bu2 += g.a.a.b.b.a.f(14, this.KLi);
            }
            if (this.KLj != null) {
                bu2 += g.a.a.a.nh(15, this.KLj.computeSize());
            }
            if (this.KLk != null) {
                bu2 += g.a.a.b.b.a.f(16, this.KLk);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.KLl) + g.a.a.b.b.a.bu(18, this.KLm) + g.a.a.b.b.a.bu(19, this.KLn);
            if (this.KEj != null) {
                bu3 += g.a.a.b.b.a.f(20, this.KEj);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(21, this.KLo) + g.a.a.b.b.a.bu(22, this.KLp);
            if (this.KLq != null) {
                bu4 += g.a.a.a.nh(23, this.KLq.computeSize());
            }
            if (this.KLr != null) {
                bu4 += g.a.a.a.nh(24, this.KLr.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(25, this.KLs);
            AppMethodBeat.o(133145);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKX == null) {
                b bVar6 = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(133145);
                throw bVar6;
            } else if (this.KKY == null) {
                b bVar7 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(133145);
                throw bVar7;
            } else if (this.KKZ == null) {
                b bVar8 = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133145);
                throw bVar8;
            } else if (this.KLq == null) {
                b bVar9 = new b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.o(133145);
                throw bVar9;
            } else if (this.KLr == null) {
                b bVar10 = new b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.o(133145);
                throw bVar10;
            } else {
                AppMethodBeat.o(133145);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hk hkVar = (hk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hkVar.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aif aif = new aif();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aif.populateBuilderWithField(aVar4, aif, a.getNextFieldNumber(aVar4))) {
                        }
                        hkVar.KKX = aif;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        hkVar.KKY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar6))) {
                        }
                        hkVar.KKZ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 5:
                    hkVar.KLa = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar7))) {
                        }
                        hkVar.KLb = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ews ews = new ews();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ews.populateBuilderWithField(aVar8, ews, a.getNextFieldNumber(aVar8))) {
                        }
                        hkVar.KLc = ews;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        fcb fcb = new fcb();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fcb.populateBuilderWithField(aVar9, fcb, a.getNextFieldNumber(aVar9))) {
                        }
                        hkVar.KLd = fcb;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar10, sKBuiltinBuffer_t4, a.getNextFieldNumber(aVar10))) {
                        }
                        hkVar.KLe = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t5 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t5.populateBuilderWithField(aVar11, sKBuiltinBuffer_t5, a.getNextFieldNumber(aVar11))) {
                        }
                        hkVar.KLf = sKBuiltinBuffer_t5;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 11:
                    hkVar.KLg = aVar3.UbS.readString();
                    AppMethodBeat.o(133145);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t6 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = sKBuiltinBuffer_t6.populateBuilderWithField(aVar12, sKBuiltinBuffer_t6, a.getNextFieldNumber(aVar12))) {
                        }
                        hkVar.KLh = sKBuiltinBuffer_t6;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 13:
                default:
                    AppMethodBeat.o(133145);
                    return -1;
                case 14:
                    hkVar.KLi = aVar3.UbS.readString();
                    AppMethodBeat.o(133145);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        dyh dyh = new dyh();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = dyh.populateBuilderWithField(aVar13, dyh, a.getNextFieldNumber(aVar13))) {
                        }
                        hkVar.KLj = dyh;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 16:
                    hkVar.KLk = aVar3.UbS.readString();
                    AppMethodBeat.o(133145);
                    return 0;
                case 17:
                    hkVar.KLl = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 18:
                    hkVar.KLm = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 19:
                    hkVar.KLn = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 20:
                    hkVar.KEj = aVar3.UbS.readString();
                    AppMethodBeat.o(133145);
                    return 0;
                case 21:
                    hkVar.KLo = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 22:
                    hkVar.KLp = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t7 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = sKBuiltinBuffer_t7.populateBuilderWithField(aVar14, sKBuiltinBuffer_t7, a.getNextFieldNumber(aVar14))) {
                        }
                        hkVar.KLq = sKBuiltinBuffer_t7;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t8 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = sKBuiltinBuffer_t8.populateBuilderWithField(aVar15, sKBuiltinBuffer_t8, a.getNextFieldNumber(aVar15))) {
                        }
                        hkVar.KLr = sKBuiltinBuffer_t8;
                    }
                    AppMethodBeat.o(133145);
                    return 0;
                case 25:
                    hkVar.KLs = aVar3.UbS.zi();
                    AppMethodBeat.o(133145);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133145);
            return -1;
        }
    }
}
