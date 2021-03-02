package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.c.a.a;
import com.tencent.tbs.c.a.b;

class t {

    /* renamed from: e  reason: collision with root package name */
    private static t f2127e = null;

    /* renamed from: a  reason: collision with root package name */
    v f2128a = null;

    /* renamed from: b  reason: collision with root package name */
    Context f2129b;

    /* renamed from: c  reason: collision with root package name */
    b f2130c;

    /* renamed from: d  reason: collision with root package name */
    a f2131d;

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            AppMethodBeat.i(188201);
            if (f2127e == null) {
                f2127e = new t(context);
            }
            tVar = f2127e;
            AppMethodBeat.o(188201);
        }
        return tVar;
    }

    private t(Context context) {
        AppMethodBeat.i(55196);
        this.f2129b = context.getApplicationContext();
        this.f2128a = new v(this.f2129b);
        AppMethodBeat.o(55196);
    }

    public boolean a(String str, Bundle bundle, b bVar) {
        AppMethodBeat.i(188202);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (bVar != null) {
            this.f2128a.a();
            if (!this.f2128a.b()) {
                AppMethodBeat.o(188202);
                return false;
            }
            this.f2130c = bVar;
            this.f2131d = new a() {
                /* class com.tencent.smtt.sdk.t.AnonymousClass1 */

                public void onUserStateChanged() {
                    AppMethodBeat.i(188318);
                    t.this.f2128a.c();
                    AppMethodBeat.o(188318);
                }
            };
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        v vVar = this.f2128a;
        if (bVar == null) {
            this = null;
        }
        vVar.a(bundle, this);
        AppMethodBeat.o(188202);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, int i2) {
        AppMethodBeat.i(55201);
        this.f2128a.a(activity, i2);
        AppMethodBeat.o(55201);
    }

    public boolean a() {
        AppMethodBeat.i(188203);
        this.f2128a.a();
        boolean b2 = this.f2128a.b();
        AppMethodBeat.o(188203);
        return b2;
    }

    public void a(int i2, int i3, Intent intent) {
    }
}
