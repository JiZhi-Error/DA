package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afc;

public final class b implements x {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.x
    public final void a(abn abn, byte[] bArr, boolean z, aa aaVar) {
        AppMethodBeat.i(116875);
        switch (abn.Lms) {
            case 7:
                ((l) g.af(l.class)).aST().bjW(z.a(((afc) new afc().parseFrom(bArr)).Lqk));
                break;
        }
        AppMethodBeat.o(116875);
    }
}
