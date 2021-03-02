package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.api.c;

@e(c.class)
public interface f extends a {
    String Ur(String str);

    Pair<Integer, String> a(Context context, WXLaunchWxaRedirectingPage.Req req, String str, String str2, String str3);

    void a(Context context, String str, String str2, String str3, boolean z, String str4);

    void a(z zVar);

    <T extends Parcelable> void a(String str, T t);

    void b(z zVar);

    void bui();

    void buj();

    void buk();

    void c(z zVar);

    Pair<String, Integer> vN(int i2);
}
