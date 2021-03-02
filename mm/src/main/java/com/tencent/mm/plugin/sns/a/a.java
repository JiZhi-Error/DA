package com.tencent.mm.plugin.sns.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    /* renamed from: com.tencent.mm.plugin.sns.a.a$a  reason: collision with other inner class name */
    public static class C1700a {
        public static String by(Context context, String str) {
            AppMethodBeat.i(202551);
            if (context == null || TextUtils.isEmpty(str)) {
                AppMethodBeat.o(202551);
                return "";
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
                if (applicationLabel != null) {
                    String charSequence = applicationLabel.toString();
                    AppMethodBeat.o(202551);
                    return charSequence;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(202551);
            return "";
        }
    }
}
