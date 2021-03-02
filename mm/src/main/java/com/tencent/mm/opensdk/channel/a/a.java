package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    public static class C0500a {

        /* renamed from: a  reason: collision with root package name */
        public String f1457a;

        /* renamed from: b  reason: collision with root package name */
        public String f1458b;

        /* renamed from: c  reason: collision with root package name */
        public String f1459c;

        /* renamed from: d  reason: collision with root package name */
        public long f1460d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f1461e;
    }

    public static Object a(int i2, String str) {
        AppMethodBeat.i(190382);
        switch (i2) {
            case 1:
                Integer valueOf = Integer.valueOf(str);
                AppMethodBeat.o(190382);
                return valueOf;
            case 2:
                Long valueOf2 = Long.valueOf(str);
                AppMethodBeat.o(190382);
                return valueOf2;
            case 3:
                AppMethodBeat.o(190382);
                return str;
            case 4:
                Boolean valueOf3 = Boolean.valueOf(str);
                AppMethodBeat.o(190382);
                return valueOf3;
            case 5:
                Float valueOf4 = Float.valueOf(str);
                AppMethodBeat.o(190382);
                return valueOf4;
            case 6:
                Double valueOf5 = Double.valueOf(str);
                AppMethodBeat.o(190382);
                return valueOf5;
            default:
                try {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e2.getMessage());
                }
                AppMethodBeat.o(190382);
                return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.i(190381);
        if (bundle == null) {
            AppMethodBeat.o(190381);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e2) {
                Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e2.getMessage());
            }
            AppMethodBeat.o(190381);
        }
        return str2;
    }

    public static boolean a(Context context, C0500a aVar) {
        AppMethodBeat.i(3827);
        if (context == null || aVar == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            AppMethodBeat.o(3827);
            return false;
        } else if (b.b(aVar.f1458b)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            AppMethodBeat.o(3827);
            return false;
        } else {
            String str = null;
            if (!b.b(aVar.f1457a)) {
                str = aVar.f1457a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.f1458b);
            Bundle bundle = aVar.f1461e;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.f1459c);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.f1460d);
            intent.putExtra(ConstantsAPI.CHECK_SUM, a(aVar.f1459c, Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            AppMethodBeat.o(3827);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A[SYNTHETIC, Splitter:B:17:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[SYNTHETIC, Splitter:B:33:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069 A[SYNTHETIC, Splitter:B:36:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006e A[SYNTHETIC, Splitter:B:39:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094 A[SYNTHETIC, Splitter:B:46:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0099 A[SYNTHETIC, Splitter:B:49:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e A[SYNTHETIC, Splitter:B:52:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c4 A[SYNTHETIC, Splitter:B:59:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c9 A[SYNTHETIC, Splitter:B:62:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ce A[SYNTHETIC, Splitter:B:65:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r9, int r10) {
        /*
        // Method dump skipped, instructions count: 430
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.channel.a.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i2, String str2) {
        String str3;
        AppMethodBeat.i(190379);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                byte b2 = digest[i3];
                int i5 = i4 + 1;
                cArr2[i4] = cArr[(b2 >>> 4) & 15];
                cArr2[i5] = cArr[b2 & 15];
                i3++;
                i4 = i5 + 1;
            }
            str3 = new String(cArr2);
        } catch (Exception e2) {
            str3 = null;
        }
        byte[] bytes2 = str3.getBytes();
        AppMethodBeat.o(190379);
        return bytes2;
    }
}
