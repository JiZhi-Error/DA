package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;

public interface j extends a {
    void G(String str, String str2, String str3, String str4);

    p a(t tVar, String str, String str2, String str3, String str4, String str5, y.a aVar);

    d a(Context context, String str, View view, String str2, y.a aVar);

    void a(Context context, String str, String str2, String str3, y.a aVar);

    void a(Context context, String str, String str2, String str3, String str4, String str5, y.a aVar);

    void a(t tVar, String str, String str2, String str3, y.a aVar);

    d b(t tVar, String str, String str2, String str3, String str4, String str5, y.a aVar);

    void b(Context context, String str, String str2, String str3, y.a aVar);

    void b(Context context, String str, String str2, String str3, String str4, String str5, y.a aVar);

    void c(Context context, String str, String str2, String str3, y.a aVar);
}
