package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class y extends t {
    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean in(Context context) {
        AppMethodBeat.i(109480);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i2);
                if (resolveInfo != null && resolveInfo.activityInfo != null && "com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    AppMethodBeat.o(109480);
                    return true;
                }
            }
        }
        AppMethodBeat.o(109480);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean bdn(String str) {
        AppMethodBeat.i(109481);
        if (str == null || !"com.tencent.map".equals(str)) {
            AppMethodBeat.o(109481);
            return false;
        }
        AppMethodBeat.o(109481);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String blB() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String gmq() {
        return "TencentMap.apk";
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final u.a gmr() {
        AppMethodBeat.i(109482);
        u.a aVar = new u.a();
        aVar.JVB = R.string.hms;
        String value = h.aqJ().getValue("QQMapDownloadTips");
        if (!Util.isNullOrNil(value)) {
            aVar.JVC = value;
        }
        aVar.JVD = R.string.hmx;
        aVar.JVA = R.drawable.icon_tencent_map;
        AppMethodBeat.o(109482);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String c(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(109483);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            AppMethodBeat.o(109483);
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel != null) {
            Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
            if (matcher.find()) {
                String replaceAll = matcher.replaceAll("");
                AppMethodBeat.o(109483);
                return replaceAll;
            }
            String charSequence = loadLabel.toString();
            AppMethodBeat.o(109483);
            return charSequence;
        }
        AppMethodBeat.o(109483);
        return null;
    }
}
