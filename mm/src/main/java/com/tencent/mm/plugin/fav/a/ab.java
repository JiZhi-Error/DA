package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y;

public interface ab extends a {
    int a(k.b bVar, WXMediaMessage wXMediaMessage, String str);

    int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3);

    void a(Context context, String str, g gVar, boolean z, y.a aVar);

    int asd(String str);

    void b(Activity activity, String str, String str2);

    void c(Activity activity, int i2, int i3, Intent intent);
}
