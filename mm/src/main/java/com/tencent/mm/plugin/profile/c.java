package com.tencent.mm.plugin.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cr;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class c {
    public static String br(Context context, String str) {
        AppMethodBeat.i(231798);
        if (WeChatBrands.AppInfo.current().isMainland()) {
            String string = context.getString(R.string.v1);
            AppMethodBeat.o(231798);
            return string;
        }
        if (TextUtils.isEmpty(str) ? false : str.equals(z.aTY())) {
            String string2 = context.getString(R.string.v1);
            AppMethodBeat.o(231798);
            return string2;
        }
        String string3 = context.getString(R.string.v2);
        AppMethodBeat.o(231798);
        return string3;
    }

    public static String ju(String str, String str2) {
        AppMethodBeat.i(231799);
        if (WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(231799);
            return str2;
        } else if (ab.Iv(str)) {
            String KN = cr.KN("OfficialAliasName");
            AppMethodBeat.o(231799);
            return KN;
        } else {
            AppMethodBeat.o(231799);
            return str2;
        }
    }
}
