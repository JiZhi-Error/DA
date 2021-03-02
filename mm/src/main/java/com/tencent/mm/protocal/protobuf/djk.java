package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class djk extends a {
    public dqi MNA;
    public dqi MNB;
    public dqi MNC;
    public dqi MND;
    public dqi MNE;
    public dqi MNw;
    public dqi MNx;
    public dqi MNy;
    public dqi MNz;
    public int id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32402);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MNx == null) {
                b bVar = new b("Not all required fields were included: province");
                AppMethodBeat.o(32402);
                throw bVar;
            } else if (this.MNy == null) {
                b bVar2 = new b("Not all required fields were included: city");
                AppMethodBeat.o(32402);
                throw bVar2;
            } else if (this.MNz == null) {
                b bVar3 = new b("Not all required fields were included: district");
                AppMethodBeat.o(32402);
                throw bVar3;
            } else if (this.MNA == null) {
                b bVar4 = new b("Not all required fields were included: zipcode");
                AppMethodBeat.o(32402);
                throw bVar4;
            } else if (this.MNB == null) {
                b bVar5 = new b("Not all required fields were included: detail");
                AppMethodBeat.o(32402);
                throw bVar5;
            } else if (this.MNC == null) {
                b bVar6 = new b("Not all required fields were included: name");
                AppMethodBeat.o(32402);
                throw bVar6;
            } else if (this.MND == null) {
                b bVar7 = new b("Not all required fields were included: phone");
                AppMethodBeat.o(32402);
                throw bVar7;
            } else {
                aVar.aM(1, this.id);
                if (this.MNw != null) {
                    aVar.ni(2, this.MNw.computeSize());
                    this.MNw.writeFields(aVar);
                }
                if (this.MNx != null) {
                    aVar.ni(3, this.MNx.computeSize());
                    this.MNx.writeFields(aVar);
                }
                if (this.MNy != null) {
                    aVar.ni(4, this.MNy.computeSize());
                    this.MNy.writeFields(aVar);
                }
                if (this.MNz != null) {
                    aVar.ni(5, this.MNz.computeSize());
                    this.MNz.writeFields(aVar);
                }
                if (this.MNA != null) {
                    aVar.ni(6, this.MNA.computeSize());
                    this.MNA.writeFields(aVar);
                }
                if (this.MNB != null) {
                    aVar.ni(7, this.MNB.computeSize());
                    this.MNB.writeFields(aVar);
                }
                if (this.MNC != null) {
                    aVar.ni(8, this.MNC.computeSize());
                    this.MNC.writeFields(aVar);
                }
                if (this.MND != null) {
                    aVar.ni(9, this.MND.computeSize());
                    this.MND.writeFields(aVar);
                }
                if (this.MNE != null) {
                    aVar.ni(10, this.MNE.computeSize());
                    this.MNE.writeFields(aVar);
                }
                AppMethodBeat.o(32402);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.MNw != null) {
                bu += g.a.a.a.nh(2, this.MNw.computeSize());
            }
            if (this.MNx != null) {
                bu += g.a.a.a.nh(3, this.MNx.computeSize());
            }
            if (this.MNy != null) {
                bu += g.a.a.a.nh(4, this.MNy.computeSize());
            }
            if (this.MNz != null) {
                bu += g.a.a.a.nh(5, this.MNz.computeSize());
            }
            if (this.MNA != null) {
                bu += g.a.a.a.nh(6, this.MNA.computeSize());
            }
            if (this.MNB != null) {
                bu += g.a.a.a.nh(7, this.MNB.computeSize());
            }
            if (this.MNC != null) {
                bu += g.a.a.a.nh(8, this.MNC.computeSize());
            }
            if (this.MND != null) {
                bu += g.a.a.a.nh(9, this.MND.computeSize());
            }
            if (this.MNE != null) {
                bu += g.a.a.a.nh(10, this.MNE.computeSize());
            }
            AppMethodBeat.o(32402);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MNx == null) {
                b bVar8 = new b("Not all required fields were included: province");
                AppMethodBeat.o(32402);
                throw bVar8;
            } else if (this.MNy == null) {
                b bVar9 = new b("Not all required fields were included: city");
                AppMethodBeat.o(32402);
                throw bVar9;
            } else if (this.MNz == null) {
                b bVar10 = new b("Not all required fields were included: district");
                AppMethodBeat.o(32402);
                throw bVar10;
            } else if (this.MNA == null) {
                b bVar11 = new b("Not all required fields were included: zipcode");
                AppMethodBeat.o(32402);
                throw bVar11;
            } else if (this.MNB == null) {
                b bVar12 = new b("Not all required fields were included: detail");
                AppMethodBeat.o(32402);
                throw bVar12;
            } else if (this.MNC == null) {
                b bVar13 = new b("Not all required fields were included: name");
                AppMethodBeat.o(32402);
                throw bVar13;
            } else if (this.MND == null) {
                b bVar14 = new b("Not all required fields were included: phone");
                AppMethodBeat.o(32402);
                throw bVar14;
            } else {
                AppMethodBeat.o(32402);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djk djk = (djk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    djk.id = aVar3.UbS.zi();
                    AppMethodBeat.o(32402);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        djk.MNw = dqi;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        djk.MNx = dqi2;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        djk.MNy = dqi3;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        djk.MNz = dqi4;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi5 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi5.populateBuilderWithField(aVar8, dqi5, a.getNextFieldNumber(aVar8))) {
                        }
                        djk.MNA = dqi5;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi6 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi6.populateBuilderWithField(aVar9, dqi6, a.getNextFieldNumber(aVar9))) {
                        }
                        djk.MNB = dqi6;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi7 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi7.populateBuilderWithField(aVar10, dqi7, a.getNextFieldNumber(aVar10))) {
                        }
                        djk.MNC = dqi7;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dqi dqi8 = new dqi();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dqi8.populateBuilderWithField(aVar11, dqi8, a.getNextFieldNumber(aVar11))) {
                        }
                        djk.MND = dqi8;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dqi dqi9 = new dqi();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dqi9.populateBuilderWithField(aVar12, dqi9, a.getNextFieldNumber(aVar12))) {
                        }
                        djk.MNE = dqi9;
                    }
                    AppMethodBeat.o(32402);
                    return 0;
                default:
                    AppMethodBeat.o(32402);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32402);
            return -1;
        }
    }
}
