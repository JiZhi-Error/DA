package com.tencent.mm.plugin.webview.fts.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String IPH;
    public String IPI;
    public String IPJ;
    private String IPK;
    private String IPL;
    private String IPM;
    private boolean IPN;
    public String dNI;

    public a(String str) {
        boolean z = true;
        AppMethodBeat.i(77988);
        String str2 = new String(Util.readFromFile(str));
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                this.dNI = jSONObject.optString("appid");
                this.IPH = jSONObject.optString("versionType");
                try {
                    this.IPI = jSONObject.optJSONObject("queryIntent").toString();
                } catch (Exception e2) {
                    Log.printErrStackTrace("WidgetUiTestInfo", e2, "", new Object[0]);
                }
                this.IPJ = jSONObject.optString("realQuery");
                try {
                    this.IPK = jSONObject.optJSONObject("testData").toString();
                } catch (Exception e3) {
                    Log.printErrStackTrace("WidgetUiTestInfo", e3, "", new Object[0]);
                }
                this.IPL = jSONObject.optString("domResultPath");
                this.IPM = jSONObject.optString("widgetPicDir");
                this.IPN = jSONObject.optInt("onlyPic") != 1 ? false : z;
                AppMethodBeat.o(77988);
            } catch (JSONException e4) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e4);
                AppMethodBeat.o(77988);
                throw illegalArgumentException;
            }
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("there is no test data");
            AppMethodBeat.o(77988);
            throw illegalArgumentException2;
        }
    }
}
