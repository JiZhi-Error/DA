package com.tencent.tbs.one.impl.a;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f2353a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2354b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2355c;

    /* renamed from: d  reason: collision with root package name */
    private static String f2356d;

    public static String a() {
        String str;
        String str2;
        AppMethodBeat.i(173921);
        if (!TextUtils.isEmpty(f2356d)) {
            String str3 = f2356d;
            AppMethodBeat.o(173921);
            return str3;
        }
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        String str4 = Build.VERSION.RELEASE;
        try {
            str = new String(str4.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
        } catch (Exception e2) {
            str = str4;
        }
        if (TextUtils.isEmpty(str)) {
            str = "1.0";
        }
        sb.append(str);
        sb.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            sb.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country.toLowerCase());
            }
        } else {
            sb.append(LocaleUtil.ENGLISH);
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str5 = Build.MODEL;
            try {
                str2 = new String(str5.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
            } catch (Exception e3) {
                str2 = str5;
            }
            sb.append("; ");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
        }
        String replaceAll = Build.ID == null ? null : Build.ID.replaceAll("[一-龥]", "");
        sb.append(" Build/");
        if (TextUtils.isEmpty(replaceAll)) {
            replaceAll = "00";
        }
        sb.append(replaceAll);
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", sb);
        f2356d = format;
        AppMethodBeat.o(173921);
        return format;
    }

    public static String a(long j2) {
        AppMethodBeat.i(173923);
        String format = String.format(Locale.getDefault(), "%d(%s)", Long.valueOf(j2), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j2)));
        AppMethodBeat.o(173923);
        return format;
    }

    public static String a(byte[] bArr) {
        AppMethodBeat.i(173922);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(173922);
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            if ((b2 & 255) < 16) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(Long.toString((long) (b2 & 255), 16));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(173922);
        return sb2;
    }
}
