package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjj extends a {
    public FinderAuthInfo authInfo;
    public int index;
    public String kog;
    public String nickname;
    public int type;
    public String username;
    public long wal;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209728);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.kog != null) {
                aVar.e(2, this.kog);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.authInfo != null) {
                aVar.ni(4, this.authInfo.computeSize());
                this.authInfo.writeFields(aVar);
            }
            aVar.bb(5, this.wal);
            aVar.aM(6, this.type);
            aVar.aM(7, this.index);
            AppMethodBeat.o(209728);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.kog != null) {
                f2 += g.a.a.b.b.a.f(2, this.kog);
            }
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.authInfo != null) {
                f2 += g.a.a.a.nh(4, this.authInfo.computeSize());
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.wal) + g.a.a.b.b.a.bu(6, this.type) + g.a.a.b.b.a.bu(7, this.index);
            AppMethodBeat.o(209728);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209728);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjj cjj = (cjj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cjj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209728);
                    return 0;
                case 2:
                    cjj.kog = aVar3.UbS.readString();
                    AppMethodBeat.o(209728);
                    return 0;
                case 3:
                    cjj.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(209728);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderAuthInfo finderAuthInfo = new FinderAuthInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderAuthInfo.populateBuilderWithField(aVar4, finderAuthInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        cjj.authInfo = finderAuthInfo;
                    }
                    AppMethodBeat.o(209728);
                    return 0;
                case 5:
                    cjj.wal = aVar3.UbS.zl();
                    AppMethodBeat.o(209728);
                    return 0;
                case 6:
                    cjj.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209728);
                    return 0;
                case 7:
                    cjj.index = aVar3.UbS.zi();
                    AppMethodBeat.o(209728);
                    return 0;
                default:
                    AppMethodBeat.o(209728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209728);
            return -1;
        }
    }
}
