package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static Map<String, Integer> DsE = new HashMap();

    static {
        AppMethodBeat.i(201905);
        AppMethodBeat.o(201905);
    }

    private static synchronized boolean aNF(String str) {
        boolean z;
        synchronized (d.class) {
            AppMethodBeat.i(201903);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(201903);
                z = false;
            } else if (!DsE.containsKey(str)) {
                AppMethodBeat.o(201903);
                z = false;
            } else if (DsE.get(str).intValue() == 1) {
                AppMethodBeat.o(201903);
                z = true;
            } else {
                AppMethodBeat.o(201903);
                z = false;
            }
        }
        return z;
    }

    public static void f(String str, final View view) {
        AppMethodBeat.i(201904);
        view.setTag(str);
        if (TextUtils.isEmpty(str)) {
            Log.e("AdWeAppHelper", "refreshWeAppAuthIcon, weAppUserName==null");
            AppMethodBeat.o(201904);
            return;
        }
        if (aNF(str)) {
            view.setVisibility(0);
        } else if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
        ((q) g.af(q.class)).a(str, new q.a() {
            /* class com.tencent.mm.plugin.sns.ad.e.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.service.q.a
            public final void b(WxaAttributes wxaAttributes) {
                int i2;
                final boolean z = false;
                AppMethodBeat.i(201902);
                if (wxaAttributes == null) {
                    Log.e("AdWeAppHelper", "onGetWeAppInfo, info==null");
                    AppMethodBeat.o(201902);
                    return;
                }
                try {
                    i2 = wxaAttributes.bAo().lgD.leb;
                } catch (Exception e2) {
                    Log.e("AdWeAppHelper", "onGetWeAppInfo, exp=" + e2.toString());
                    i2 = 0;
                }
                if (!TextUtils.isEmpty(wxaAttributes.field_username)) {
                    synchronized (d.class) {
                        try {
                            d.DsE.put(wxaAttributes.field_username, Integer.valueOf(i2));
                        } catch (Throwable th) {
                            AppMethodBeat.o(201902);
                            throw th;
                        }
                    }
                }
                Object tag = view.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    if (str.equals(wxaAttributes.field_username)) {
                        Log.i("AdWeAppHelper", "onGetWeAppInfo, weAppName=" + str + ", flag=" + i2);
                        if (i2 == 1) {
                            z = true;
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ad.e.d.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(201901);
                                if (z) {
                                    view.setVisibility(0);
                                    AppMethodBeat.o(201901);
                                    return;
                                }
                                if (view.getVisibility() == 0) {
                                    view.setVisibility(4);
                                }
                                AppMethodBeat.o(201901);
                            }
                        });
                        AppMethodBeat.o(201902);
                        return;
                    }
                    Log.w("AdWeAppHelper", "onGetWeAppInfo, View reuse, view.name=" + str + ", info.name=" + (wxaAttributes == null ? "" : wxaAttributes.field_username));
                    AppMethodBeat.o(201902);
                    return;
                }
                Log.w("AdWeAppHelper", "onGetWeAppInfo, View reuse, view.name=null, info.name=" + (wxaAttributes == null ? "" : wxaAttributes.field_username));
                AppMethodBeat.o(201902);
            }
        });
        AppMethodBeat.o(201904);
    }
}
