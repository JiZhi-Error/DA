package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.s;

public final class l {
    public static void a(a aVar, ca caVar, Intent intent) {
        String str;
        int i2;
        Bundle bundle;
        AppMethodBeat.i(35189);
        if (aVar == null || caVar == null) {
            AppMethodBeat.o(35189);
            return;
        }
        String talkerUserName = aVar.getTalkerUserName();
        String a2 = a(aVar, caVar);
        Bundle bundle2 = new Bundle();
        if (aVar.gRL()) {
            str = "stat_scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (ab.IT(talkerUserName)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(caVar.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", a2);
        intent.putExtra("_stat_obj", bundle2);
        AppMethodBeat.o(35189);
    }

    public static boolean h(ca caVar, String str) {
        AppMethodBeat.i(35191);
        if (System.currentTimeMillis() - caVar.field_createTime <= 259200000 || (!Util.isNullOrNil(str) && s.YS(str))) {
            AppMethodBeat.o(35191);
            return false;
        }
        AppMethodBeat.o(35191);
        return true;
    }

    public static ViewStub a(MMFragment mMFragment, int i2) {
        AppMethodBeat.i(35193);
        ViewStub viewStub = (ViewStub) mMFragment.findViewById(i2);
        if (viewStub != null) {
            viewStub.inflate();
        }
        AppMethodBeat.o(35193);
        return viewStub;
    }

    public static boolean bmI(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(35194);
        if (ab.IS(str) || !u.HR(str) || z.Im(str)) {
            AppMethodBeat.o(35194);
            return false;
        }
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn != null) {
            i3 = Kn.field_type;
            bg.aVF();
            as Kn2 = c.aSN().Kn(Kn.field_encryptUsername);
            i2 = Kn2 != null ? Kn2.field_type : -1;
        } else {
            i2 = -1;
            i3 = -1;
        }
        Log.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(35194);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r0.length() > 0) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(com.tencent.mm.ui.chatting.e.a r4, com.tencent.mm.storage.ca r5) {
        /*
            r3 = 35190(0x8976, float:4.9312E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.storage.as r0 = r4.GUe
            java.lang.String r1 = r0.field_username
            java.lang.Class<com.tencent.mm.ui.chatting.d.b.d> r0 = com.tencent.mm.ui.chatting.d.b.d.class
            com.tencent.mm.ui.chatting.d.af r0 = r4.bh(r0)
            com.tencent.mm.ui.chatting.d.b.d r0 = (com.tencent.mm.ui.chatting.d.b.d) r0
            boolean r0 = r0.gOP()
            boolean r2 = r4.gRL()
            if (r2 != 0) goto L_0x0022
            if (r0 != 0) goto L_0x0022
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0021:
            return r1
        L_0x0022:
            boolean r0 = r4.gRL()
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r5.field_content
            java.lang.String r0 = com.tencent.mm.model.bp.Ks(r0)
            if (r1 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x0042
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0042
        L_0x0038:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r1 = r0
            goto L_0x0021
        L_0x003d:
            if (r5 == 0) goto L_0x0042
            java.lang.String r0 = r5.field_bizChatUserId
            goto L_0x0038
        L_0x0042:
            r0 = r1
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.l.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca):java.lang.String");
    }

    public static boolean at(as asVar) {
        AppMethodBeat.i(35192);
        if (!asVar.field_username.equals("medianote") || (z.aUc() & 16384) != 0) {
            AppMethodBeat.o(35192);
            return false;
        }
        AppMethodBeat.o(35192);
        return true;
    }
}
