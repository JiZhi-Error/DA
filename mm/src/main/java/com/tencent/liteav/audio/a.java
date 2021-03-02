package com.tencent.liteav.audio;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f158a;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.audio.a$a  reason: collision with other inner class name */
    public static class C0154a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f159a = new a();

        static {
            AppMethodBeat.i(221787);
            AppMethodBeat.o(221787);
        }
    }

    public static a a() {
        AppMethodBeat.i(221862);
        a aVar = C0154a.f159a;
        AppMethodBeat.o(221862);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(221863);
        this.f158a = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
        AppMethodBeat.o(221863);
    }

    public void a(String str, long j2) {
        AppMethodBeat.i(221864);
        a(str, Long.valueOf(j2));
        AppMethodBeat.o(221864);
    }

    public long b(String str, long j2) {
        AppMethodBeat.i(221865);
        long longValue = ((Long) b(str, Long.valueOf(j2))).longValue();
        AppMethodBeat.o(221865);
        return longValue;
    }

    @SuppressLint({"ApplySharedPref"})
    private void a(String str, Object obj) {
        AppMethodBeat.i(221866);
        SharedPreferences.Editor edit = this.f158a.edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, obj.toString());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
        }
        edit.commit();
        AppMethodBeat.o(221866);
    }

    private Object b(String str, Object obj) {
        AppMethodBeat.i(221867);
        try {
            if (obj instanceof String) {
                String string = this.f158a.getString(str, obj.toString());
                AppMethodBeat.o(221867);
                return string;
            } else if (obj instanceof Integer) {
                Integer valueOf = Integer.valueOf(this.f158a.getInt(str, ((Integer) obj).intValue()));
                AppMethodBeat.o(221867);
                return valueOf;
            } else if (obj instanceof Boolean) {
                Boolean valueOf2 = Boolean.valueOf(this.f158a.getBoolean(str, ((Boolean) obj).booleanValue()));
                AppMethodBeat.o(221867);
                return valueOf2;
            } else if (obj instanceof Long) {
                Long valueOf3 = Long.valueOf(this.f158a.getLong(str, ((Long) obj).longValue()));
                AppMethodBeat.o(221867);
                return valueOf3;
            } else if (obj instanceof Float) {
                Float valueOf4 = Float.valueOf(this.f158a.getFloat(str, ((Float) obj).floatValue()));
                AppMethodBeat.o(221867);
                return valueOf4;
            } else if (obj instanceof Double) {
                Double valueOf5 = Double.valueOf(Double.longBitsToDouble(this.f158a.getLong(str, Double.doubleToLongBits(((Double) obj).doubleValue()))));
                AppMethodBeat.o(221867);
                return valueOf5;
            } else {
                AppMethodBeat.o(221867);
                return obj;
            }
        } catch (Exception e2) {
            TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", str, e2);
            AppMethodBeat.o(221867);
            return obj;
        }
    }
}
