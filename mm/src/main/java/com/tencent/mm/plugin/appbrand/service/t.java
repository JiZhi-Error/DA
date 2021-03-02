package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

public interface t extends a {
    void K(Context context, int i2);

    void L(Context context, int i2);

    void O(Context context, int i2);

    void a(Context context, String str, String str2, List<WxaAttributes.WxaEntryInfo> list);

    boolean dG(Context context);
}
