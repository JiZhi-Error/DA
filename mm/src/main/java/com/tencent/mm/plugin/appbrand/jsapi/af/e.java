package com.tencent.mm.plugin.appbrand.jsapi.af;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e {

    public interface a {
        void cleanup();

        int getBinderID();

        void onBackground();

        void onForeground();

        void s(boolean z, int i2);

        void setCurrentUrl(String str);
    }

    public interface b {
        void H(ArrayList<IDKey> arrayList);

        void xK(int i2);
    }

    public interface c {
        boolean NA();

        void a(String str, WebResourceRequest webResourceRequest);

        void abB(String str);

        void abC(String str);

        void abD(String str);

        void ah(JSONObject jSONObject);

        boolean bLr();

        void bLs();

        boolean bLu();

        void cW(String str);

        String getAppId();

        String[] getJsApiReportArgs();

        ac getPageView();

        b getReporter();

        MMWebView getWebView();

        boolean post(Runnable runnable);

        void runOnUiThread(Runnable runnable);

        void z(String str, int i2, String str2);
    }
}
