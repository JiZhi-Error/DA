package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public interface ae extends c {
    bf Nc();

    void Nd();

    void Ne();

    void Ng();

    <T> T S(Class<T> cls);

    View a(LayoutInflater layoutInflater);

    void a(Map<String, Object> map, bx bxVar);

    void b(b bVar);

    void cb(View view);

    RelativeLayout.LayoutParams cc(View view);

    void dispatchConfigurationChanged(Configuration configuration);

    void dispatchDestroy();

    void dispatchStart();

    boolean dy(String str);

    ao getCustomViewContainer();
}
