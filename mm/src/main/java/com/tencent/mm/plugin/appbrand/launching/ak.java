package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

public interface ak {
    long bNF();

    long bNG();

    long bNH();

    Pair<WxaAttributes, Boolean> bNI();

    String name();
}
