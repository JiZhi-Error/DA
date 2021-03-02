package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class ag {

    public static class c {
        public final int jPQ;
        public final String jPR;
        public final String pkgName;

        public c(String str, int i2, String str2) {
            this.pkgName = str;
            this.jPQ = i2;
            this.jPR = str2;
        }
    }

    public static boolean a(Context context, ArrayList<c> arrayList, boolean z) {
        String m;
        int U;
        String str;
        AppMethodBeat.i(20754);
        if (arrayList.size() == 0) {
            AppMethodBeat.o(20754);
            return false;
        }
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!TextUtils.isEmpty(next.pkgName)) {
                String str2 = next.pkgName;
                ArrayList<String> arrayList2 = new ArrayList();
                String packageResourcePath = context.getPackageResourcePath();
                if (Build.VERSION.SDK_INT >= 21) {
                    String[] split = packageResourcePath.split(FilePathGenerator.ANDROID_DIR_SEP);
                    if (split != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= split.length) {
                                str = "";
                                break;
                            } else if (split[i2].contains(context.getPackageName())) {
                                str = split[i2];
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            String replace = packageResourcePath.replace(str, str2 + "-1");
                            if (new o(replace).exists()) {
                                arrayList2.add(replace);
                            }
                            String replace2 = packageResourcePath.replace(str, str2 + "-2");
                            if (new o(replace2).exists()) {
                                arrayList2.add(replace2);
                            }
                        }
                    }
                } else {
                    String[] split2 = packageResourcePath.split(FilePathGenerator.ANDROID_DIR_SEP);
                    if (split2 != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < split2.length; i3++) {
                            if (i3 != split2.length - 1) {
                                sb.append(split2[i3]);
                                sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                            }
                        }
                        String sb2 = sb.toString();
                        String str3 = sb2 + str2 + "-1.apk";
                        if (new o(str3).exists()) {
                            arrayList2.add(str3);
                        }
                        String str4 = sb2 + str2 + "-2.apk";
                        if (new o(str4).exists()) {
                            arrayList2.add(str4);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (String str5 : arrayList2) {
                        o oVar = new o(str5);
                        if (oVar.exists()) {
                            String str6 = "";
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (z) {
                                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(next.pkgName, 64);
                                    if (packageInfo.signatures.length > 0) {
                                        str6 = MD5Util.getMD5String(packageInfo.signatures[packageInfo.signatures.length - 1].toCharsString());
                                    }
                                    m = str6;
                                } else {
                                    m = b.m(oVar.hes());
                                }
                                Object[] objArr = new Object[6];
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = next.pkgName;
                                objArr[2] = next.jPR;
                                objArr[3] = m;
                                objArr[4] = Boolean.valueOf(!TextUtils.isEmpty(m) && m.equalsIgnoreCase(next.jPR));
                                objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", objArr);
                                if (!TextUtils.isEmpty(m) && m.equalsIgnoreCase(next.jPR)) {
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (z) {
                                        U = context.getPackageManager().getPackageInfo(next.pkgName, 0).versionCode;
                                    } else {
                                        U = a.U(context, next.pkgName);
                                    }
                                    Object[] objArr2 = new Object[6];
                                    objArr2[0] = Boolean.valueOf(z);
                                    objArr2[1] = next.pkgName;
                                    objArr2[2] = Integer.valueOf(next.jPQ);
                                    objArr2[3] = Integer.valueOf(U);
                                    objArr2[4] = Boolean.valueOf(U <= next.jPQ);
                                    objArr2[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis2);
                                    Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", objArr2);
                                    if (U <= next.jPQ) {
                                        AppMethodBeat.o(20754);
                                        return true;
                                    }
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e2, "", new Object[0]);
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.o(20754);
        return false;
    }

    public static class a {
        public static int U(Context context, String str) {
            Context context2;
            int i2;
            XmlResourceParser xmlResourceParser = null;
            int i3 = 0;
            AppMethodBeat.i(20750);
            try {
                context2 = context.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e2, "", new Object[0]);
                context2 = null;
            }
            if (context2 == null) {
                AppMethodBeat.o(20750);
            } else {
                AssetManager assets = context2.getAssets();
                Resources resources = new Resources(assets, context.getResources().getDisplayMetrics(), null);
                try {
                    XmlResourceParser a2 = a(context2, assets);
                    if (a2 == null) {
                        if (a2 != null) {
                            a2.close();
                        }
                        AppMethodBeat.o(20750);
                    } else {
                        try {
                            i2 = a2.getEventType();
                        } catch (XmlPullParserException e3) {
                            Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e3, "", new Object[0]);
                            i2 = 0;
                        }
                        while (i2 != 1) {
                            switch (i2) {
                                case 2:
                                    String name = a2.getName();
                                    if (!TextUtils.isEmpty(name) && name.equals("manifest")) {
                                        String a3 = a(a2.getAttributeValue("http://schemas.android.com/apk/res/android", AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE), resources);
                                        if (!TextUtils.isEmpty(a3)) {
                                            i3 = Util.getInt(a3, 0);
                                            if (a2 != null) {
                                                a2.close();
                                            }
                                            AppMethodBeat.o(20750);
                                            break;
                                        } else {
                                            if (a2 != null) {
                                                a2.close();
                                            }
                                            AppMethodBeat.o(20750);
                                            break;
                                        }
                                    }
                            }
                            try {
                                i2 = a2.nextToken();
                            } catch (XmlPullParserException e4) {
                                Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e4, "", new Object[0]);
                            } catch (IOException e5) {
                                Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e5, "", new Object[0]);
                            }
                        }
                        if (a2 != null) {
                            a2.close();
                        }
                        AppMethodBeat.o(20750);
                    }
                } catch (IOException e6) {
                    Log.printErrStackTrace("MicroMsg.YYBMarketVerify", e6, "", new Object[0]);
                    if (0 != 0) {
                        xmlResourceParser.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        xmlResourceParser.close();
                    }
                    AppMethodBeat.o(20750);
                    throw th;
                }
            }
            return i3;
        }

        private static XmlResourceParser a(Context context, AssetManager assetManager) {
            AppMethodBeat.i(20751);
            try {
                String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
                Method method = AssetManager.class.getMethod("getCookieName", Integer.TYPE);
                if (str == null && context.getPackageName().equals("android")) {
                    str = "/system/framework/framework-res.apk";
                }
                for (int i2 = 1; i2 < 20; i2++) {
                    if (str != null) {
                        if (str.equals(method.invoke(assetManager, Integer.valueOf(i2)))) {
                            XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(i2, ShareConstants.RES_MANIFEST);
                            AppMethodBeat.o(20751);
                            return openXmlResourceParser;
                        }
                    }
                }
            } catch (Exception e2) {
            }
            XmlResourceParser openXmlResourceParser2 = assetManager.openXmlResourceParser(ShareConstants.RES_MANIFEST);
            AppMethodBeat.o(20751);
            return openXmlResourceParser2;
        }

        private static String a(String str, Resources resources) {
            AppMethodBeat.i(20752);
            if (str == null || !str.startsWith("@")) {
                AppMethodBeat.o(20752);
            } else {
                try {
                    str = resources.getString(Integer.parseInt(str.substring(1)));
                    AppMethodBeat.o(20752);
                } catch (NumberFormatException e2) {
                    AppMethodBeat.o(20752);
                } catch (Resources.NotFoundException e3) {
                    AppMethodBeat.o(20752);
                }
            }
            return str;
        }
    }

    public static class b {
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
            throw r1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00e4 A[SYNTHETIC, Splitter:B:40:0x00e4] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9 A[SYNTHETIC, Splitter:B:43:0x00e9] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String m(com.tencent.mm.vfs.o r14) {
            /*
            // Method dump skipped, instructions count: 407
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.ag.b.m(com.tencent.mm.vfs.o):java.lang.String");
        }

        private static char[] aD(byte[] bArr) {
            int length = bArr.length;
            char[] cArr = new char[(length * 2)];
            for (int i2 = 0; i2 < length; i2++) {
                byte b2 = bArr[i2];
                int i3 = (b2 >> 4) & 15;
                cArr[i2 * 2] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
                int i4 = b2 & 15;
                cArr[(i2 * 2) + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
            }
            return cArr;
        }
    }
}
