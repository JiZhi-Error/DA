package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;

public final class bf extends d {
    public static bf iDu = new bf(d.icC);
    public static final String iDv = (b.aKB() + "last_avatar_dir");

    static {
        AppMethodBeat.i(132238);
        AppMethodBeat.o(132238);
    }

    private bf(d dVar) {
        super(dVar.aLJ());
        AppMethodBeat.i(132233);
        AppMethodBeat.o(132233);
    }

    public final void aO(String str, String str2) {
        AppMethodBeat.i(132234);
        Log.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.sp.edit().putString(str, str2).commit();
        if (str.equals(WXUtil.LAST_LOGIN_WEXIN_USERNAME)) {
            MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.aps()).edit().putString(WXUtil.LAST_LOGIN_WEXIN_USERNAME, str2).commit();
        }
        AppMethodBeat.o(132234);
    }

    public final void k(String str, int i2, String str2) {
        AppMethodBeat.i(132235);
        int i3 = 0;
        if (i2 != 0) {
            i3 = 1;
            aO("last_login_bind_qq", String.valueOf(i2));
        }
        if (!Util.isNullOrNil(str2)) {
            i3 |= 2;
            aO("last_login_bind_email", String.valueOf(str2));
        }
        if (!Util.isNullOrNil(str)) {
            i3 |= 4;
            aO("last_login_bind_mobile", str);
        }
        aO("last_bind_info", String.valueOf(i3));
        AppMethodBeat.o(132235);
    }

    public final String aVx() {
        AppMethodBeat.i(132236);
        String aA = aA("last_avatar_path", "");
        AppMethodBeat.o(132236);
        return aA;
    }

    public final void Km(String str) {
        AppMethodBeat.i(132237);
        Log.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(132237);
            return;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (Util.isNullOrNil(substring)) {
            AppMethodBeat.o(132237);
            return;
        }
        String str2 = iDv + FilePathGenerator.ANDROID_DIR_SEP + substring;
        s.boN(iDv);
        Log.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", str2, Boolean.valueOf(s.deleteFile(str2)));
        s.nw(str, str2);
        aO("last_avatar_path", str2);
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, str2);
        }
        AppMethodBeat.o(132237);
    }
}
