package com.tencent.mm.plugin.appbrand.page.a;

import android.content.res.Configuration;

public interface b {
    void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar);

    void onBackground();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onForeground();
}
