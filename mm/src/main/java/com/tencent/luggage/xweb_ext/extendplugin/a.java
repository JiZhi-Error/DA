package com.tencent.luggage.xweb_ext.extendplugin;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Map;
import org.json.JSONObject;

public interface a {

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.a$a  reason: collision with other inner class name */
    public interface AbstractC0188a {
        void hU(int i2);

        void onDestroy();

        void onForeground();
    }

    f NN();

    boolean Pr();

    JSONObject Ps();

    String Pt();

    void Pu();

    void a(AbstractC0188a aVar);

    void b(AbstractC0188a aVar);

    String dP(String str);

    String f(String str, Map<String, ? extends Object> map);

    String getAppId();

    Context getContext();
}
