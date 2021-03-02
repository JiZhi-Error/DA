package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderAuthInfo extends a {
    public String appName;
    public FinderContact authGenerator;
    public int authIconType;
    public String authIconUrl;
    public String authProfession;
    public String detailLink;
    public String realName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168936);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.realName != null) {
                aVar.e(1, this.realName);
            }
            aVar.aM(2, this.authIconType);
            if (this.authProfession != null) {
                aVar.e(3, this.authProfession);
            }
            if (this.authGenerator != null) {
                aVar.ni(4, this.authGenerator.computeSize());
                this.authGenerator.writeFields(aVar);
            }
            if (this.detailLink != null) {
                aVar.e(5, this.detailLink);
            }
            if (this.appName != null) {
                aVar.e(6, this.appName);
            }
            if (this.authIconUrl != null) {
                aVar.e(7, this.authIconUrl);
            }
            AppMethodBeat.o(168936);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.realName != null ? g.a.a.b.b.a.f(1, this.realName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.authIconType);
            if (this.authProfession != null) {
                f2 += g.a.a.b.b.a.f(3, this.authProfession);
            }
            if (this.authGenerator != null) {
                f2 += g.a.a.a.nh(4, this.authGenerator.computeSize());
            }
            if (this.detailLink != null) {
                f2 += g.a.a.b.b.a.f(5, this.detailLink);
            }
            if (this.appName != null) {
                f2 += g.a.a.b.b.a.f(6, this.appName);
            }
            if (this.authIconUrl != null) {
                f2 += g.a.a.b.b.a.f(7, this.authIconUrl);
            }
            AppMethodBeat.o(168936);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168936);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderAuthInfo finderAuthInfo = (FinderAuthInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderAuthInfo.realName = aVar3.UbS.readString();
                    AppMethodBeat.o(168936);
                    return 0;
                case 2:
                    finderAuthInfo.authIconType = aVar3.UbS.zi();
                    AppMethodBeat.o(168936);
                    return 0;
                case 3:
                    finderAuthInfo.authProfession = aVar3.UbS.readString();
                    AppMethodBeat.o(168936);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        finderAuthInfo.authGenerator = finderContact;
                    }
                    AppMethodBeat.o(168936);
                    return 0;
                case 5:
                    finderAuthInfo.detailLink = aVar3.UbS.readString();
                    AppMethodBeat.o(168936);
                    return 0;
                case 6:
                    finderAuthInfo.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(168936);
                    return 0;
                case 7:
                    finderAuthInfo.authIconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(168936);
                    return 0;
                default:
                    AppMethodBeat.o(168936);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168936);
            return -1;
        }
    }
}
