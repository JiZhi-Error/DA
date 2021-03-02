package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.smtt.sdk.TbsConfig;

public final class a {
    public static final boolean hV(Context context) {
        AppMethodBeat.i(79246);
        try {
            PackageInfo packageInfo = z.getPackageInfo(context, TbsConfig.APP_QQ);
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(packageInfo != null);
            Log.d("MicroMsg.ConstantsWebViewStub", "isQQSupportShare(%s).", objArr);
            if (packageInfo != null) {
                AppMethodBeat.o(79246);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", e2.getMessage());
        }
        AppMethodBeat.o(79246);
        return false;
    }

    public static final boolean bW(Context context, String str) {
        boolean z;
        AppMethodBeat.i(79247);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79247);
            return false;
        }
        try {
            PackageInfo packageInfo = z.getPackageInfo(context, "com.tencent.weread");
            Object[] objArr = new Object[1];
            if (packageInfo != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.d("MicroMsg.ConstantsWebViewStub", "isWeReadSupportShare(%s).", objArr);
            if (packageInfo == null) {
                AppMethodBeat.o(79247);
                return false;
            } else if (!Uri.parse(str).getHost().startsWith(WeChatHosts.domainString(R.string.e20))) {
                AppMethodBeat.o(79247);
                return false;
            } else {
                if (packageInfo.versionCode > 2000812) {
                    AppMethodBeat.o(79247);
                    return true;
                }
                AppMethodBeat.o(79247);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", e2.getMessage());
        }
    }
}
