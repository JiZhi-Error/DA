package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(151425);
        if (strArr.length <= 1) {
            AppMethodBeat.o(151425);
            return false;
        }
        Log.i("MicroMsg.AvatarCommand", "processCommand: %s", TextUtils.join(" ", strArr));
        if (strArr[1].equals("pull")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(151425);
                return false;
            }
            String str2 = strArr[2];
            String str3 = ((l) g.af(l.class)).aSN().bjH(str2).field_username;
            String str4 = b.aKJ() + "/tencent/MicroMsg/avatar/";
            s.boN(str4);
            p.aYn();
            String M = e.M(str3, false);
            s.nw(M, str4 + str2 + "-s." + s.akC(M));
            p.aYn();
            String M2 = e.M(str3, true);
            s.nw(M2, str4 + str2 + "-b." + s.akC(M2));
            Toast.makeText(MMApplicationContext.getContext(), "pull to ".concat(String.valueOf(str4)), 0).show();
            AppMethodBeat.o(151425);
            return true;
        } else if (strArr[1].equals("dump")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(151425);
                return false;
            }
            i Mx = p.aYB().Mx(((l) g.af(l.class)).aSN().bjH(strArr[2]).field_username);
            Log.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", Mx.aYt(), Mx.aYu(), Integer.valueOf(Mx.iKV), Integer.valueOf(Mx.fuz));
            AppMethodBeat.o(151425);
            return true;
        } else if (strArr[1].equals("clean")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(151425);
                return false;
            }
            String str5 = ((l) g.af(l.class)).aSN().bjH(strArr[2]).field_username;
            p.aYn();
            e.N(str5, false);
            p.aYn();
            e.N(str5, true);
            AppMethodBeat.o(151425);
            return true;
        } else if (strArr[1].equals("cleanAll")) {
            s.dy("wcf://avatar/", true);
            AppMethodBeat.o(151425);
            return true;
        } else if (!strArr[1].equals("decrypt")) {
            AppMethodBeat.o(151425);
            return false;
        } else if (strArr.length <= 2) {
            AppMethodBeat.o(151425);
            return false;
        } else {
            String str6 = strArr[2];
            byte[] DecryptAvatar = UtilsJni.DecryptAvatar(s.aW(str6, 0, -1));
            if (DecryptAvatar == null) {
                Toast.makeText(MMApplicationContext.getContext(), "error", 0).show();
            } else {
                s.f(str6 + ".d", DecryptAvatar, DecryptAvatar.length);
            }
            AppMethodBeat.o(151425);
            return true;
        }
    }
}
