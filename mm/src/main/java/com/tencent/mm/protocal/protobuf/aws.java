package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aws extends a {
    public int LHt;
    public LinkedList<FinderObject> LHu = new LinkedList<>();
    public String desc;
    public String hwd;
    public long hwe;
    public String hwg;
    public String key;
    public long liveId;
    public String sessionBuffer;
    public FinderObject tuO;

    public aws() {
        AppMethodBeat.i(209543);
        AppMethodBeat.o(209543);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209544);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            aVar.bb(2, this.liveId);
            if (this.hwg != null) {
                aVar.e(3, this.hwg);
            }
            aVar.bb(4, this.hwe);
            if (this.hwd != null) {
                aVar.e(5, this.hwd);
            }
            if (this.desc != null) {
                aVar.e(6, this.desc);
            }
            if (this.sessionBuffer != null) {
                aVar.e(7, this.sessionBuffer);
            }
            if (this.tuO != null) {
                aVar.ni(8, this.tuO.computeSize());
                this.tuO.writeFields(aVar);
            }
            aVar.aM(9, this.LHt);
            aVar.e(10, 8, this.LHu);
            AppMethodBeat.o(209544);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0) + g.a.a.b.b.a.r(2, this.liveId);
            if (this.hwg != null) {
                f2 += g.a.a.b.b.a.f(3, this.hwg);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.hwe);
            if (this.hwd != null) {
                r += g.a.a.b.b.a.f(5, this.hwd);
            }
            if (this.desc != null) {
                r += g.a.a.b.b.a.f(6, this.desc);
            }
            if (this.sessionBuffer != null) {
                r += g.a.a.b.b.a.f(7, this.sessionBuffer);
            }
            if (this.tuO != null) {
                r += g.a.a.a.nh(8, this.tuO.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.LHt) + g.a.a.a.c(10, 8, this.LHu);
            AppMethodBeat.o(209544);
            return bu;
        } else if (i2 == 2) {
            this.LHu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209544);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aws aws = (aws) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aws.key = aVar3.UbS.readString();
                    AppMethodBeat.o(209544);
                    return 0;
                case 2:
                    aws.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209544);
                    return 0;
                case 3:
                    aws.hwg = aVar3.UbS.readString();
                    AppMethodBeat.o(209544);
                    return 0;
                case 4:
                    aws.hwe = aVar3.UbS.zl();
                    AppMethodBeat.o(209544);
                    return 0;
                case 5:
                    aws.hwd = aVar3.UbS.readString();
                    AppMethodBeat.o(209544);
                    return 0;
                case 6:
                    aws.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(209544);
                    return 0;
                case 7:
                    aws.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209544);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        aws.tuO = finderObject;
                    }
                    AppMethodBeat.o(209544);
                    return 0;
                case 9:
                    aws.LHt = aVar3.UbS.zi();
                    AppMethodBeat.o(209544);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject2.populateBuilderWithField(aVar5, finderObject2, a.getNextFieldNumber(aVar5))) {
                        }
                        aws.LHu.add(finderObject2);
                    }
                    AppMethodBeat.o(209544);
                    return 0;
                default:
                    AppMethodBeat.o(209544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209544);
            return -1;
        }
    }
}
