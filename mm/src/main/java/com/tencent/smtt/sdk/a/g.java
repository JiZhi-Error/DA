package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1985a;

    /* renamed from: b  reason: collision with root package name */
    private static f f1986b;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            AppMethodBeat.i(188273);
            if (f1985a == null) {
                f1985a = new g();
            }
            gVar = f1985a;
            AppMethodBeat.o(188273);
        }
        return gVar;
    }

    public static String[] a(String str) {
        AppMethodBeat.i(188274);
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            AppMethodBeat.o(188274);
            return split;
        }
        AppMethodBeat.o(188274);
        return null;
    }

    public static String a(String[] strArr) {
        AppMethodBeat.i(188275);
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            if (strArr.length > 1) {
                for (int i2 = 0; i2 < strArr.length - 1; i2++) {
                    sb.append(strArr[i2]).append(",");
                }
            }
            sb.append(strArr[strArr.length - 1]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(188275);
        return sb2;
    }

    private synchronized SharedPreferences b(Context context) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(188276);
        sharedPreferences = context.getSharedPreferences("tbs_emergence", 4);
        AppMethodBeat.o(188276);
        return sharedPreferences;
    }

    public void a(Context context, String str, String str2) {
        AppMethodBeat.i(188277);
        List<String> a2 = a(context, str);
        a2.add(str2);
        a(context, str, a2);
        AppMethodBeat.o(188277);
    }

    public void a(Context context) {
        AppMethodBeat.i(188278);
        f1986b = f.a(new File(context.getFilesDir(), "prefs.lock"));
        AppMethodBeat.o(188278);
    }

    public boolean b() {
        return f1986b != null;
    }

    public void c() {
        AppMethodBeat.i(188279);
        if (f1986b != null) {
            f1986b.b();
            f1986b = null;
        }
        AppMethodBeat.o(188279);
    }

    public void a(Context context, String str, List<String> list) {
        AppMethodBeat.i(188280);
        SharedPreferences.Editor edit = b(context).edit();
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                for (int i2 = 0; i2 < list.size() - 1; i2++) {
                    sb.append(list.get(i2));
                    sb.append(";");
                }
            }
            sb.append(list.get(list.size() - 1));
        }
        edit.putString(str, sb.toString());
        edit.apply();
        edit.commit();
        AppMethodBeat.o(188280);
    }

    public List<String> a(Context context, String str) {
        AppMethodBeat.i(188281);
        String string = b(context).getString(str, "");
        ArrayList arrayList = new ArrayList();
        String[] split = string.split(";");
        if (split.length > 0) {
            arrayList.addAll(Arrays.asList(split));
        }
        AppMethodBeat.o(188281);
        return arrayList;
    }

    public long b(Context context, String str) {
        AppMethodBeat.i(188282);
        long j2 = b(context).getLong(str, -1);
        AppMethodBeat.o(188282);
        return j2;
    }

    public void a(Context context, String str, long j2) {
        AppMethodBeat.i(188283);
        SharedPreferences.Editor edit = b(context).edit();
        edit.putLong(str, j2);
        edit.apply();
        edit.commit();
        AppMethodBeat.o(188283);
    }
}
