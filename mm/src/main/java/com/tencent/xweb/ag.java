package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ag {
    private JSONStringer SAE = new JSONStringer();
    private int SAF = 0;
    private String SAG;
    private String SAH;
    private String SAI;
    private String SAJ;
    private String SAK;
    private int SAL = 0;
    private long SAM;
    private WebView SAN;
    private final String TAG = "XWebScript";
    private int bufferSize;
    public String cacheKey;

    public ag(int i2, int i3, WebView webView) {
        AppMethodBeat.i(156933);
        this.SAF = i2;
        this.SAL = i3;
        this.SAN = webView;
        AppMethodBeat.o(156933);
    }

    public final void bso(String str) {
        AppMethodBeat.i(261884);
        oc(str, "path");
        AppMethodBeat.o(261884);
    }

    public final void ob(String str, String str2) {
        AppMethodBeat.i(156934);
        oc(str, "path");
        this.SAI = str2;
        AppMethodBeat.o(156934);
    }

    public final void bsp(String str) {
        AppMethodBeat.i(156935);
        oc(str, "string");
        AppMethodBeat.o(156935);
    }

    public final void oc(String str, String str2) {
        this.SAH = str;
        this.SAG = str2;
    }

    public final void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public final void bsq(String str) {
        this.SAK = str;
    }

    public final void bsr(String str) {
        this.SAJ = str;
    }

    public final String toString() {
        boolean z = false;
        AppMethodBeat.i(156936);
        if (this.SAN != null && this.SAN.supportFeature(2002)) {
            if (TextUtils.isEmpty(this.SAH)) {
                Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.SAH);
            } else if (TextUtils.isEmpty(this.SAG)) {
                Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.SAG);
            } else if (this.SAF < 0) {
                Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.SAF);
            } else if (this.SAM != 0 && this.bufferSize <= 0) {
                Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
            } else if (this.bufferSize != 0 && this.SAM == 0) {
                Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.SAM);
            } else if (TextUtils.isEmpty(this.SAK) || this.SAN.supportFeature(2008)) {
                z = true;
            } else {
                Log.e("XWebScript", "not support jsparam as file path , apk ver = " + XWalkEnvironment.getAvailableVersion());
            }
        }
        if (!z) {
            AppMethodBeat.o(156936);
            return "";
        }
        StringBuilder sb = new StringBuilder("//XWEB_SCRIPT:");
        try {
            JSONStringer value = new JSONStringer().object().key("compile_mode").value((long) this.SAF).key("cache_option").value((long) this.SAL).key("js_src_kind").value(this.SAG).key("js_src").value(this.SAH);
            if (!TextUtils.isEmpty(this.cacheKey)) {
                value = value.key("cache_key").value(this.cacheKey);
            }
            if (!TextUtils.isEmpty(this.SAI)) {
                value = value.key("append_script").value(this.SAI);
            }
            if (!TextUtils.isEmpty(this.SAK)) {
                value = value.key("js_param_kind").value("path").key("js_param").value(this.SAK);
            } else if (!(this.SAM == 0 || this.bufferSize == 0)) {
                value = value.key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.SAM)).key("js_param_length").value((long) this.bufferSize);
            }
            value.endObject();
            sb.append(value.toString());
            if (this.SAN != null && this.SAN.supportFeature(2004)) {
                sb.append("XWEB_SCRIPT_END\n\r" + this.SAJ);
            }
        } catch (Exception e2) {
            Log.e("XWebScript", "xweb script create failed " + e2.getMessage());
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(156936);
        return sb2;
    }
}
