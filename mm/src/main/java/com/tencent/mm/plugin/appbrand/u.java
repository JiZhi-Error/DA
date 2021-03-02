package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class u implements com.tencent.mm.modelappbrand.b.a {

    static class a {
        static u kEs = new u();

        static {
            AppMethodBeat.i(43959);
            AppMethodBeat.o(43959);
        }
    }

    public static u bth() {
        return a.kEs;
    }

    @Override // com.tencent.mm.modelappbrand.b.a
    public final Intent a(String str, int i2, String str2, String str3, String[] strArr, String str4, int i3, int i4) {
        AppMethodBeat.i(43960);
        boolean z = Build.VERSION.SDK_INT >= 26;
        String aG = c.aG(str2, z);
        if (Util.isNullOrNil(aG)) {
            AppMethodBeat.o(43960);
            return null;
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3;
        }
        StringBuilder sb = new StringBuilder();
        for (String str5 : strArr) {
            sb.append(str5);
        }
        String messageDigest = g.getMessageDigest((str2 + sb.toString()).getBytes());
        Intent intent = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent.putExtra("type", i4);
        intent.putExtra("id", aG);
        intent.putExtra("ext_info", c.aG(str4, z));
        intent.putExtra("token", c.eY(str4, String.valueOf(i3)));
        intent.putExtra("digest", messageDigest);
        intent.putExtra("ext_info_1", i2);
        intent.setPackage(str);
        intent.addFlags(67108864);
        AppMethodBeat.o(43960);
        return intent;
    }
}
