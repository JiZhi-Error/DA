package com.tencent.mm.chatroom.e;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        boolean z;
        AppMethodBeat.i(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
        de deVar = aVar.heO;
        if (deVar.xKb == 10002) {
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
                return;
            }
            String a3 = z.a(deVar.KHl);
            ca aJ = ((l) g.af(l.class)).eiy().aJ(a3, deVar.Brn);
            if (aJ.field_msgId > 0) {
                z = true;
            } else {
                z = false;
            }
            aJ.yF(deVar.Brn);
            aJ.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
            aJ.setType(10002);
            aJ.setContent(a2);
            aJ.nv(0);
            aJ.Cy(a3);
            aJ.BB(deVar.KHq);
            aJ.gDN();
            bp.a(aJ, aVar);
            if (!z) {
                bp.x(aJ);
                AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
                return;
            }
            ((l) g.af(l.class)).eiy().b(deVar.Brn, aJ);
            AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
            return;
        }
        Log.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(deVar.xKb));
        AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
    }
}
