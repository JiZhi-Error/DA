package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.protobuf.eze;
import com.tencent.mm.storage.as;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30089);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11011);
        arrayList.add(11010);
        AppMethodBeat.o(30089);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        String str;
        AppMethodBeat.i(30090);
        switch (i2) {
            case 11010:
                eze eze = new eze();
                try {
                    eze.parseFrom(bArr);
                } catch (IOException e2) {
                }
                a.fVK().gc(eze.MRZ, eze.MWA);
                AppMethodBeat.o(30090);
                break;
            case 11011:
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e3) {
                    str = "";
                }
                bg.aVF();
                as Kn = c.aSN().Kn(str);
                if (ab.Eq(str)) {
                    bg.aVF();
                    as Kn2 = c.aSN().Kn(str);
                    Kn2.nm(0);
                    bg.aVF();
                    c.aSN().c(str, Kn2);
                    bg.aVF();
                    c.aSM().d(new com.tencent.mm.chatroom.f.a(str, 0));
                } else {
                    ab.z(Kn);
                }
                com.tencent.mm.plugin.wear.model.c.a.jZ(4, 0);
            default:
                AppMethodBeat.o(30090);
                break;
        }
        return null;
    }
}
