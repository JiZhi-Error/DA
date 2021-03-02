package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c {
    static HashMap<String, Long> SDD = new HashMap<>();

    public static synchronized boolean cl(String str, long j2) {
        boolean z = false;
        synchronized (c.class) {
            AppMethodBeat.i(156968);
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(a.brJ("dis_".concat(String.valueOf(str))))) {
                AppMethodBeat.o(156968);
            } else {
                SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER");
                long j3 = mMKVSharedPreferences.getLong(str, 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - j3) < j2) {
                    AppMethodBeat.o(156968);
                } else {
                    mMKVSharedPreferences.edit().putLong(str, currentTimeMillis).commit();
                    z = true;
                    AppMethodBeat.o(156968);
                }
            }
        }
        return z;
    }

    public static synchronized void bsw(String str) {
        synchronized (c.class) {
            AppMethodBeat.i(219068);
            XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER").edit().putLong(str, 0).commit();
            AppMethodBeat.o(219068);
        }
    }

    static {
        AppMethodBeat.i(219070);
        AppMethodBeat.o(219070);
    }

    public static synchronized boolean bsx(String str) {
        boolean z = false;
        synchronized (c.class) {
            AppMethodBeat.i(175641);
            SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            if (format.equals(mMKVSharedTransportOld.getString(str, ""))) {
                AppMethodBeat.o(175641);
            } else if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(b.brJ("dis_".concat(String.valueOf(str))))) {
                AppMethodBeat.o(175641);
            } else {
                mMKVSharedTransportOld.edit().putString(str, format).commit();
                z = true;
                AppMethodBeat.o(175641);
            }
        }
        return z;
    }

    public static synchronized boolean of(String str, String str2) {
        boolean z;
        synchronized (c.class) {
            AppMethodBeat.i(219069);
            SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_value_changed");
            String string = mMKVSharedPreferences.getString(str, "");
            if (string == null) {
                string = "";
            }
            if (string.equals(str2)) {
                z = false;
                AppMethodBeat.o(219069);
            } else {
                mMKVSharedPreferences.edit().putString(str, str2).commit();
                z = true;
                AppMethodBeat.o(219069);
            }
        }
        return z;
    }
}
