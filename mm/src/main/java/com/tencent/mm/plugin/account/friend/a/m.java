package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public final class m {
    public static String boj() {
        AppMethodBeat.i(131043);
        Log.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
        AppMethodBeat.o(131043);
        return "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com";
    }

    public static String aY(List<NameValuePair> list) {
        AppMethodBeat.i(131044);
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            NameValuePair nameValuePair = list.get(i2);
            if (!TextUtils.isEmpty(nameValuePair.getName())) {
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(nameValuePair.getName(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                sb.append("=");
                if (!TextUtils.isEmpty(nameValuePair.getValue())) {
                    sb.append(URLEncoder.encode(nameValuePair.getValue(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(131044);
        return sb2;
    }

    public static boolean dB(Context context) {
        AppMethodBeat.i(131045);
        Intent intent = new Intent("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        if (context.getPackageManager().resolveActivity(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 0) == null || context.getPackageManager().resolveActivity(intent, 0) == null) {
            AppMethodBeat.o(131045);
            return false;
        } else if (Build.VERSION.SDK_INT < 8) {
            AppMethodBeat.o(131045);
            return false;
        } else if (context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("googleauth", false)) {
            AppMethodBeat.o(131045);
            return false;
        } else {
            AppMethodBeat.o(131045);
            return true;
        }
    }
}
