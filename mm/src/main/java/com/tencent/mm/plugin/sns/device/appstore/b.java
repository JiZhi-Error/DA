package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class b {
    private final String DET;
    private final String DEU;
    private final String DEW;
    private final String DEX;

    static b B(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202640);
        b bVar = new b(str, str2, str3, str4);
        AppMethodBeat.o(202640);
        return bVar;
    }

    private b(String str, String str2, String str3, String str4) {
        this.DET = str;
        this.DEU = str2;
        this.DEW = str3;
        this.DEX = str4;
    }

    private static Uri kc(String str, String str2) {
        Uri uri;
        String queryParameter;
        AppMethodBeat.i(202642);
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(str2)) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.isEmpty() || !queryParameterNames.contains("id")) {
                uri = parse.buildUpon().appendQueryParameter("id", str2).build();
                AppMethodBeat.o(202642);
                return uri;
            } else if (!str2.equals(parse.getQueryParameter("id"))) {
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                for (String str3 : queryParameterNames) {
                    if ("id".equals(str3)) {
                        clearQuery.appendQueryParameter("id", str2);
                    } else if (!(str3 == null || (queryParameter = parse.getQueryParameter(str3)) == null)) {
                        clearQuery.appendQueryParameter(str3, queryParameter);
                    }
                }
                uri = clearQuery.build();
                AppMethodBeat.o(202642);
                return uri;
            }
        }
        uri = parse;
        AppMethodBeat.o(202642);
        return uri;
    }

    /* access modifiers changed from: package-private */
    public final Intent eZB() {
        Uri parse;
        AppMethodBeat.i(202641);
        try {
            String str = this.DET;
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent();
                String str2 = this.DEW;
                if (!TextUtils.isEmpty(str2)) {
                    parse = kc(str, str2);
                } else {
                    parse = Uri.parse(str);
                    str2 = parse.getQueryParameter("id");
                    if (TextUtils.isEmpty(str2)) {
                        AppMethodBeat.o(202641);
                        return null;
                    }
                }
                intent.putExtra("target_app_id", str2);
                intent.setAction("android.intent.action.VIEW");
                intent.setData(parse);
                if (!TextUtils.isEmpty(this.DEU)) {
                    intent.setPackage(this.DEU);
                }
                if (!TextUtils.isEmpty(this.DEX)) {
                    intent.putExtra("market_app_name", this.DEX);
                }
                AppMethodBeat.o(202641);
                return intent;
            }
            AppMethodBeat.o(202641);
            return null;
        } catch (Throwable th) {
            Log.e("MicroMsg.AdAppMarketIntentNode", "there is something wrong in toIntent");
            AppMethodBeat.o(202641);
            return null;
        }
    }
}
