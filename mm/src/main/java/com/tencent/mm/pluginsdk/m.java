package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.widget.a.d;

@Deprecated
public interface m {
    void Xc();

    void a(Activity activity, Intent intent, int i2);

    void a(Activity activity, Intent intent, Intent intent2, String str, int i2, a.AbstractC2129a aVar);

    void a(Activity activity, String str, WXMediaMessage wXMediaMessage, String str2, String str3);

    void a(Context context, Intent intent, Intent intent2);

    void a(Context context, String str, String str2, boolean z, y.a aVar);

    void a(Intent intent, int i2, MMActivity.a aVar, MMActivity mMActivity);

    void a(Intent intent, int i2, MMActivity mMActivity);

    void a(Intent intent, int i2, MMActivity mMActivity, Intent intent2);

    void a(Intent intent, Activity activity);

    void a(Intent intent, Activity activity, int i2);

    void a(Intent intent, Context context);

    void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity);

    void a(MMWizardActivity mMWizardActivity, Intent intent);

    void a(boolean z, boolean z2, Context context, String str, int i2, int i3);

    boolean a(Context context, String str, Object... objArr);

    void b(Intent intent, Activity activity);

    void b(Intent intent, Context context);

    boolean b(Context context, String str, Bundle bundle);

    void bX(Context context);

    d bY(Context context);

    Intent bZ(Context context);

    void c(Intent intent, Context context);

    void ca(Context context);

    void cancelNotification(String str);

    void cb(Context context);

    void d(Context context, Intent intent);

    void d(Intent intent, Context context);

    void e(Context context, Intent intent);

    void e(Intent intent, Context context);

    void f(Context context, Intent intent);

    void f(Intent intent, Context context);

    void g(Context context, Intent intent);

    void g(Intent intent, Context context);

    void h(Context context, Intent intent);

    void h(Intent intent, Context context);

    void i(Intent intent, Context context);

    void j(Intent intent, Context context);

    void k(Intent intent, Context context);

    void l(Intent intent, Context context);

    void m(Intent intent, Context context);

    void n(Intent intent, Context context);

    void o(Intent intent, Context context);

    void p(Intent intent, Context context);

    void q(Intent intent, Context context);

    void r(Intent intent, Context context);

    void s(Intent intent, Context context);

    void t(Context context, String str);

    void t(Intent intent, Context context);
}
