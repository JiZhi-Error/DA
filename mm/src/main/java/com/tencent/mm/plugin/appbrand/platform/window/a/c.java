package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.content.res.Configuration;
import com.tencent.mm.plugin.appbrand.platform.window.e;

public interface c extends e {
    void onConfigurationChanged(Configuration configuration);

    void onPause();

    void onResume();

    void release();
}
