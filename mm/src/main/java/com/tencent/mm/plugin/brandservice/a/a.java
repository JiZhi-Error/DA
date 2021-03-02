package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public interface a extends com.tencent.mm.kernel.c.a {
    void a(int i2, Context context, String str, String str2, long j2, long j3);

    void a(long j2, int i2, Context context, Activity activity, ca caVar);

    void a(View view, long j2, String str, String str2, int i2);

    void a(View view, String str, String str2, String str3, String str4, String str5);

    void a(v vVar, z zVar, int i2, u uVar, View view, boolean z, int i3, h hVar);

    void a(ca caVar, Activity activity);

    void a(ca caVar, Context context);

    void b(c cVar, Activity activity, as asVar);

    void bCm();

    long dq(View view);
}
