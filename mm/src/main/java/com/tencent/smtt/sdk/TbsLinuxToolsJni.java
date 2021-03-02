package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* access modifiers changed from: package-private */
public class TbsLinuxToolsJni {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1810a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1811b = false;

    private native int ChmodInner(String str, String str2);

    public int a(String str, String str2) {
        AppMethodBeat.i(54092);
        if (!f1810a) {
            TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
            AppMethodBeat.o(54092);
            return -1;
        }
        int ChmodInner = ChmodInner(str, str2);
        AppMethodBeat.o(54092);
        return ChmodInner;
    }

    public TbsLinuxToolsJni(Context context) {
        AppMethodBeat.i(54093);
        a(context);
        AppMethodBeat.o(54093);
    }

    private void a(Context context) {
        File r;
        String str;
        AppMethodBeat.i(54094);
        synchronized (TbsLinuxToolsJni.class) {
            try {
                TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + f1811b);
                if (!f1811b) {
                    f1811b = true;
                    try {
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            String a2 = TbsShareManager.a();
                            if (a2 == null) {
                                str = TbsShareManager.c(context);
                            } else {
                                str = a2;
                            }
                            r = new File(str);
                        } else {
                            r = q.a().r(context);
                        }
                        if (r != null) {
                            if (!new File(r.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() && !TbsShareManager.isThirdPartyApp(context)) {
                                r = q.a().q(context);
                            }
                            if (r != null) {
                                TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + r.getAbsolutePath());
                                System.load(r.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                                f1810a = true;
                            }
                        }
                        ChmodInner("/checkChmodeExists", "700");
                    } catch (Throwable th) {
                        f1810a = false;
                        TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + th.getMessage() + " ## " + th.getCause());
                    }
                    AppMethodBeat.o(54094);
                }
            } finally {
                AppMethodBeat.o(54094);
            }
        }
    }
}
