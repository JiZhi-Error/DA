package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;

@Deprecated
public interface l {
    String R(String str, String str2);

    void WZ();

    void Xb();

    void Xc();

    Intent Xd();

    void Xe();

    boolean Xf();

    q a(j jVar);

    void a(Context context, as asVar, ca.a aVar, Bundle bundle, String str);

    void a(Context context, ca.a aVar, Bundle bundle);

    void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5);

    void a(Intent intent, String str);

    void a(cpl cpl, String str, int i2);

    void a(String str, String str2, int i2, String str3, long j2);

    boolean a(Context context, int i2, int i3, String str);

    boolean a(as asVar);

    Bitmap b(Activity activity, int i2, int i3, Intent intent);

    boolean b(Context context, int i2, int i3, String str);

    void bU(Context context);

    q cR(boolean z);

    String e(Context context, String str, String str2);

    String go(String str);

    boolean gp(String str);

    boolean gq(String str);

    void gr(String str);

    void iO(int i2);

    String r(Context context, String str);

    boolean s(Activity activity);

    boolean s(Context context, String str);

    void t(Activity activity);

    String w(String str, int i2);
}
