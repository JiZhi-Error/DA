package com.tencent.mm.sdk.plugin;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginProviderConstants {
    public static final String AUTHORITY = "com.tencent.mm.sdk.plugin.provider";
    public static final String PLUGIN_PACKAGE_PATTERN = "com.tencent.mm.plugin";
    public static final int TYPE_BOOLEAN = 4;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 1;
    public static final int TYPE_LONG = 2;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;

    public static class PluginIntent {
        public static final String ACCESS_TOKEN = "com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN";
        public static final String ACTION_QRCODE_SCANNED = "com.tencent.mm.sdk.plugin.Intent.ACTION_QRCODE_SCANNED";
        public static final String ACTION_REQUEST_TOKEN = "com.tencent.mm.sdk.plugin.Intent.ACTION_REQUEST_TOKEN";
        public static final String ACTION_RESPONSE = "com.tencent.mm.sdk.plugin.Intent.ACTION_RESPONSE";
        public static final String APP_PACKAGE_PATTERN = "com.tencent.mm";
        public static final String AUTH_KEY = "com.tencent.mm.sdk.plugin.Intent.AUTHKEY";
        public static final String NAME = "com.tencent.mm.sdk.plugin.Intent.NAME";
        public static final String PACKAGE = "com.tencent.mm.sdk.plugin.Intent.PACKAGE";
        public static final String PERMISSIONS = "com.tencent.mm.sdk.plugin.Intent.PERMISSIONS";
        public static final String PLUGIN_PACKAGE_PATTERN = "com.tencent.mm.plugin";
        public static final String REQUEST_TOKEN = "com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN";
    }

    public static final class Resolver {
        private static final String TAG = "MicroMsg.SDK.PluginProvider.Resolver";

        private Resolver() {
        }

        public static int getType(Object obj) {
            AppMethodBeat.i(230439);
            if (obj == null) {
                Log.e(TAG, "unresolve failed, null value");
                AppMethodBeat.o(230439);
                return 0;
            } else if (obj instanceof Integer) {
                AppMethodBeat.o(230439);
                return 1;
            } else if (obj instanceof Long) {
                AppMethodBeat.o(230439);
                return 2;
            } else if (obj instanceof String) {
                AppMethodBeat.o(230439);
                return 3;
            } else if (obj instanceof Boolean) {
                AppMethodBeat.o(230439);
                return 4;
            } else if (obj instanceof Float) {
                AppMethodBeat.o(230439);
                return 5;
            } else if (obj instanceof Double) {
                AppMethodBeat.o(230439);
                return 6;
            } else {
                Log.e(TAG, "unresolve failed, unknown type=" + obj.getClass().toString());
                AppMethodBeat.o(230439);
                return 0;
            }
        }

        public static boolean unresolveObj(ContentValues contentValues, Object obj) {
            AppMethodBeat.i(230440);
            int type = getType(obj);
            if (type == 0) {
                AppMethodBeat.o(230440);
                return false;
            }
            contentValues.put("type", Integer.valueOf(type));
            contentValues.put("value", obj.toString());
            AppMethodBeat.o(230440);
            return true;
        }

        public static Object resolveObj(int i2, String str) {
            AppMethodBeat.i(230441);
            switch (i2) {
                case 1:
                    Integer valueOf = Integer.valueOf(str);
                    AppMethodBeat.o(230441);
                    return valueOf;
                case 2:
                    Long valueOf2 = Long.valueOf(str);
                    AppMethodBeat.o(230441);
                    return valueOf2;
                case 3:
                    AppMethodBeat.o(230441);
                    return str;
                case 4:
                    Boolean valueOf3 = Boolean.valueOf(str);
                    AppMethodBeat.o(230441);
                    return valueOf3;
                case 5:
                    Float valueOf4 = Float.valueOf(str);
                    AppMethodBeat.o(230441);
                    return valueOf4;
                case 6:
                    Double valueOf5 = Double.valueOf(str);
                    AppMethodBeat.o(230441);
                    return valueOf5;
                default:
                    try {
                        Log.e(TAG, "unknown type");
                    } catch (Exception e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(230441);
                    return null;
            }
        }
    }

    public static final class SharedPref implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
        public static final String KEY = "key";
        public static final String TYPE = "type";
        public static final String VALUE = "value";

        private SharedPref() {
        }

        static {
            AppMethodBeat.i(230442);
            AppMethodBeat.o(230442);
        }
    }
}
