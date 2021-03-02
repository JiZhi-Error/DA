package com.tencent.mm.booter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LogDecryptor;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class d {
    private static d glr;
    private final String[] columns = {"_id", "key", "type", "value"};
    private Context ctx;
    public int glq = -1;
    private final HashMap<String, Object> values = new HashMap<>();

    public static d cg(Context context) {
        AppMethodBeat.i(131870);
        if (glr == null) {
            glr = new d(context);
        }
        d dVar = glr;
        AppMethodBeat.o(131870);
        return dVar;
    }

    private d(Context context) {
        Cursor cursor;
        AppMethodBeat.i(131871);
        this.ctx = context;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://" + context.getPackageName() + ".coolassist.debugprovider/config"), this.columns, null, null, null);
        } catch (Exception e2) {
            cursor = null;
        }
        if (cursor == null) {
            AppMethodBeat.o(131871);
        } else if (cursor.getCount() <= 0) {
            cursor.close();
            AppMethodBeat.o(131871);
        } else if (!"18c867f0717aa67b2ab7347505ba07ed".equals(Util.getSignaturesMd5("com.tencent.mm.coolassist", context))) {
            cursor.close();
            AppMethodBeat.o(131871);
        } else {
            CrashReportFactory.setHasDebuger(true);
            int columnIndex = cursor.getColumnIndex("key");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("value");
            while (cursor.moveToNext()) {
                this.values.put(cursor.getString(columnIndex), a.resolveObj(cursor.getInt(columnIndex2), cursor.getString(columnIndex3)));
            }
            cursor.close();
            AppMethodBeat.o(131871);
        }
    }

    public final void CN(String str) {
        boolean z;
        boolean z2;
        String string;
        boolean z3 = false;
        AppMethodBeat.i(131872);
        Integer integer = getInteger(".com.tencent.mm.debug.log.level");
        boolean nullAs = Util.nullAs(CO(".com.tencent.mm.debug.log.append_mode"), true);
        boolean z4 = Util.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog")) && Util.nullAs(CO(".com.tencent.mm.debug.test.uploadLog"), false);
        if (z4 && (string = getString(".com.tencent.mm.debug.log.tag.skey")) != null && string.length() > 0) {
            Xlog.logDecryptor = new LogDecryptor(string);
        }
        boolean z5 = this.ctx.getSharedPreferences("system_config_prefs", g.aps()).getBoolean("first_launch_weixin", true);
        if (!"MM".equalsIgnoreCase(str)) {
            z5 = false;
        }
        XLogSetup.keep_setupXLog(!z5, ar.NSf, b.aKQ(), integer, Boolean.valueOf(nullAs), Boolean.valueOf(z4), str);
        Log.setLevel(Log.getLogLevel(), true);
        if (Util.getInt(Util.nullAs(getString(".com.tencent.mm.debug.monkeyEnv"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        WeChatEnvironment.setMonkeyEnv(z);
        WeChatEnvironment.isMonkeyEnv();
        if (getInteger(".com.tencent.mm.debug.log.level") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        WeChatEnvironment.setCoolassistEnv(z2);
        if (WeChatEnvironment.isMonkeyEnv() || Util.nullAs(CO(".com.tencent.mm.debug.blockReleasedPatch"), false)) {
            z3 = true;
        }
        CrashReportFactory.setOnlinePatchBlocked(z3);
        AppMethodBeat.o(131872);
    }

    public final String getString(String str) {
        AppMethodBeat.i(131873);
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            Log.d("MicroMsg.Debugger", "getString(): key=" + str + ", value=" + obj.toString());
            String str2 = (String) obj;
            AppMethodBeat.o(131873);
            return str2;
        }
        AppMethodBeat.o(131873);
        return null;
    }

    public final Integer getInteger(String str) {
        AppMethodBeat.i(131874);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            Log.d("MicroMsg.Debugger", "getInteger(): key=" + str + ", value=" + obj.toString());
            Integer num = (Integer) obj;
            AppMethodBeat.o(131874);
            return num;
        }
        AppMethodBeat.o(131874);
        return null;
    }

    public final Boolean CO(String str) {
        AppMethodBeat.i(131875);
        Object obj = this.values.get(str);
        if (obj == null) {
            AppMethodBeat.o(131875);
            return null;
        } else if (obj instanceof Boolean) {
            Log.d("MicroMsg.Debugger", "getBoolean(): key=" + str + ", value=" + obj.toString());
            Boolean bool = (Boolean) obj;
            AppMethodBeat.o(131875);
            return bool;
        } else {
            AppMethodBeat.o(131875);
            return null;
        }
    }

    public static final class a {
        public static Object resolveObj(int i2, String str) {
            AppMethodBeat.i(131869);
            switch (i2) {
                case 1:
                    Integer valueOf = Integer.valueOf(str);
                    AppMethodBeat.o(131869);
                    return valueOf;
                case 2:
                    Long valueOf2 = Long.valueOf(str);
                    AppMethodBeat.o(131869);
                    return valueOf2;
                case 3:
                    AppMethodBeat.o(131869);
                    return str;
                case 4:
                    Boolean valueOf3 = Boolean.valueOf(str);
                    AppMethodBeat.o(131869);
                    return valueOf3;
                case 5:
                    Float valueOf4 = Float.valueOf(str);
                    AppMethodBeat.o(131869);
                    return valueOf4;
                case 6:
                    Double valueOf5 = Double.valueOf(str);
                    AppMethodBeat.o(131869);
                    return valueOf5;
                default:
                    try {
                        Log.e("MicroMsg.Debugger.Resolver", "unknown type");
                    } catch (Exception e2) {
                    }
                    AppMethodBeat.o(131869);
                    return null;
            }
        }
    }
}
