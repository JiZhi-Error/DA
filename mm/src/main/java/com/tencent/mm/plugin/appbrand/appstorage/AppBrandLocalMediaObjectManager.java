package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ah;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.a.d;

@Deprecated
public final class AppBrandLocalMediaObjectManager {
    private static String AqF;
    private static final Collection<a> AsX;
    private static final AppBrandLocalMediaObject Atv = new AppBrandLocalMediaObject() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        com.tencent.mm.vending.j.a C(String str, String str2, String str3);

        AppBrandLocalMediaObject cD(String str, String str2);
    }

    static /* synthetic */ String access$300(String str) {
        AppMethodBeat.i(175564);
        String VR = VR(str);
        AppMethodBeat.o(175564);
        return VR;
    }

    private AppBrandLocalMediaObjectManager() {
    }

    public static void LH(String str) {
        AppMethodBeat.i(175562);
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        AqF = str + "wxafiles/";
        AppMethodBeat.o(175562);
    }

    public static String cbh() {
        return AqF;
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        AppMethodBeat.i(134308);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(134308);
            return null;
        }
        String str3 = VR(str) + str2;
        AppMethodBeat.o(134308);
        return str3;
    }

    public static void clear(String str) {
        AppMethodBeat.i(196154);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(196154);
            return;
        }
        s.dy(VQ(str), true);
        AppMethodBeat.o(196154);
    }

    public static AppBrandLocalVideoObject O(String str, String str2) {
        AppMethodBeat.i(134311);
        AppBrandLocalVideoObject appBrandLocalVideoObject = (AppBrandLocalVideoObject) a(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
        AppMethodBeat.o(134311);
        return appBrandLocalVideoObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T extends com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject> T a(java.lang.String r11, java.lang.String r12, java.lang.Class<T> r13, java.lang.String r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.a(java.lang.String, java.lang.String, java.lang.Class, java.lang.String, boolean):com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject");
    }

    public static AppBrandLocalMediaObject h(String str, String str2, boolean z) {
        AppMethodBeat.i(134313);
        AppBrandLocalMediaObject b2 = b(str, str2, null, z);
        AppMethodBeat.o(134313);
        return b2;
    }

    public static AppBrandLocalMediaObject b(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(134314);
        AppBrandLocalMediaObject a2 = a(str, str2, AppBrandLocalMediaObject.class, str3, z);
        AppMethodBeat.o(134314);
        return a2;
    }

    private static String VQ(String str) {
        AppMethodBeat.i(196155);
        String str2 = AqF + str + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(196155);
        return str2;
    }

    private static String VR(String str) {
        AppMethodBeat.i(134315);
        String VQ = VQ(str);
        FilePathGenerator.checkMkdir(VQ);
        try {
            new o(VQ, FilePathGenerator.NO_MEDIA_FILENAME).createNewFile();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(134315);
        return VQ;
    }

    @Deprecated
    public static AppBrandLocalMediaObject av(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject;
        AppMethodBeat.i(134316);
        if (Util.isNullOrNil(str2) || !str2.startsWith("wxfile://") || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", str2, str);
            AppMethodBeat.o(134316);
            return null;
        }
        String substring = str2.substring(9);
        Iterator<a> it = AsX.iterator();
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        while (true) {
            if (!it.hasNext()) {
                appBrandLocalMediaObject = appBrandLocalMediaObject2;
                break;
            }
            a next = it.next();
            appBrandLocalMediaObject = next.cD(str, substring);
            if (appBrandLocalMediaObject != null) {
                Log.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", next.toString(), appBrandLocalMediaObject);
                break;
            }
            appBrandLocalMediaObject2 = appBrandLocalMediaObject;
        }
        if (Atv == appBrandLocalMediaObject) {
            AppMethodBeat.o(134316);
            return null;
        }
        AppMethodBeat.o(134316);
        return appBrandLocalMediaObject;
    }

    static final class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.a
        public final AppBrandLocalMediaObject cD(String str, String str2) {
            String str3 = null;
            AppMethodBeat.i(134306);
            if (str2.startsWith("store_") || str2.startsWith("tmp_")) {
                String extension = d.getExtension(str2);
                String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!Util.isNullOrNil(extension)) {
                    replaceFirst = replaceFirst.replaceFirst(".".concat(String.valueOf(extension)), "");
                }
                if (Util.isNullOrNil(replaceFirst)) {
                    AppBrandLocalMediaObject appBrandLocalMediaObject = AppBrandLocalMediaObjectManager.Atv;
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject;
                }
                try {
                    str3 = AppBrandLocalMediaObjectManager.cB(replaceFirst, str);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (Util.isNullOrNil(str3)) {
                    Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    AppBrandLocalMediaObject appBrandLocalMediaObject2 = AppBrandLocalMediaObjectManager.Atv;
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject2;
                }
                String[] split = str3.split("\\|");
                if (split == null || split.length != 2) {
                    AppBrandLocalMediaObject appBrandLocalMediaObject3 = AppBrandLocalMediaObjectManager.Atv;
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject3;
                }
                String str4 = str2.startsWith("store_") ? "store_" : "tmp_";
                String str5 = AppBrandLocalMediaObjectManager.access$300(str) + str4 + replaceFirst;
                long j2 = Util.getLong(split[0], 0);
                String str6 = split[1];
                if (!str6.equalsIgnoreCase(extension)) {
                    AppBrandLocalMediaObject appBrandLocalMediaObject4 = AppBrandLocalMediaObjectManager.Atv;
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject4;
                }
                try {
                    long bxp = AppBrandLocalMediaObjectManager.bxp(str5);
                    if (j2 != bxp) {
                        Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", Long.valueOf(bxp), Long.valueOf(j2), str2, str);
                        AppBrandLocalMediaObject appBrandLocalMediaObject5 = AppBrandLocalMediaObjectManager.Atv;
                        AppMethodBeat.o(134306);
                        return appBrandLocalMediaObject5;
                    }
                    AppBrandLocalMediaObject appBrandLocalMediaObject6 = new AppBrandLocalMediaObject();
                    appBrandLocalMediaObject6.dJX = "wxfile://".concat(String.valueOf(str2));
                    appBrandLocalMediaObject6.iGf = str5;
                    appBrandLocalMediaObject6.mimeType = MimeTypeUtil.getMimeTypeByFileExt(str6);
                    appBrandLocalMediaObject6.kSa = str4.equalsIgnoreCase("store_");
                    o oVar = new o(appBrandLocalMediaObject6.iGf);
                    appBrandLocalMediaObject6.kSb = oVar.lastModified();
                    appBrandLocalMediaObject6.jPY = oVar.length();
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject6;
                } catch (IOException e3) {
                    Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", Util.stackTraceToString(e3));
                    AppBrandLocalMediaObject appBrandLocalMediaObject7 = AppBrandLocalMediaObjectManager.Atv;
                    AppMethodBeat.o(134306);
                    return appBrandLocalMediaObject7;
                }
            } else {
                AppMethodBeat.o(134306);
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.a
        public final com.tencent.mm.vending.j.a C(String str, String str2, String str3) {
            String str4;
            AppMethodBeat.i(134307);
            if (Util.isNullOrNil(str3)) {
                str3 = AppBrandLocalMediaObjectManager.access$500();
            }
            try {
                try {
                    str4 = AppBrandLocalMediaObjectManager.cz(String.format(Locale.US, "%d|%s", Long.valueOf(AppBrandLocalMediaObjectManager.bxp(str2)), str3), str);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "attachMediaObject, enc exp = ", new Object[0]);
                    str4 = null;
                }
                if (Util.isNullOrNil(str4)) {
                    AppMethodBeat.o(134307);
                    return null;
                }
                String concat = "tmp_".concat(String.valueOf(str4));
                String str5 = AppBrandLocalMediaObjectManager.access$300(str) + concat;
                String str6 = "wxfile://" + concat + (Util.isNullOrNil(str3) ? "" : ".".concat(String.valueOf(str3)));
                Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", str6, str5);
                com.tencent.mm.vending.j.d i2 = com.tencent.mm.vending.j.a.i(str6, str5, str3);
                AppMethodBeat.o(134307);
                return i2;
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", Util.stackTraceToString(e3));
                AppMethodBeat.o(134307);
                return null;
            }
        }
    }

    public static long bxn(String str) {
        long j2 = 0;
        AppMethodBeat.i(134309);
        o oVar = new o(VR(str));
        o[] a2 = (!oVar.exists() || !oVar.isDirectory()) ? null : oVar.a(new q() {
            /* class com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.AnonymousClass2 */

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(175561);
                if (!oVar.exists() || oVar.isDirectory() || Util.isNullOrNil(oVar.getName()) || !oVar.getName().startsWith("tmp_")) {
                    AppMethodBeat.o(175561);
                    return false;
                }
                AppMethodBeat.o(175561);
                return true;
            }
        });
        if (a2 == null || a2.length <= 0) {
            AppMethodBeat.o(134309);
        } else {
            for (o oVar2 : a2) {
                j2 += oVar2.length();
            }
            AppMethodBeat.o(134309);
        }
        return j2;
    }

    public static long bxo(String str) {
        long j2 = 0;
        AppMethodBeat.i(134310);
        o oVar = new o(VR(str));
        o[] a2 = (!oVar.exists() || !oVar.isDirectory()) ? null : oVar.a(new q() {
            /* class com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.AnonymousClass1 */

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(175560);
                if (!oVar.exists() || oVar.isDirectory() || Util.isNullOrNil(oVar.getName()) || !oVar.getName().startsWith("store_")) {
                    AppMethodBeat.o(175560);
                    return false;
                }
                AppMethodBeat.o(175560);
                return true;
            }
        });
        if (a2 == null || a2.length <= 0) {
            AppMethodBeat.o(134310);
        } else {
            for (o oVar2 : a2) {
                j2 += oVar2.length();
            }
            AppMethodBeat.o(134310);
        }
        return j2;
    }

    static /* synthetic */ String cB(String str, String str2) {
        AppMethodBeat.i(175563);
        byte[] decrypt = new ah().decrypt(Util.decodeHexString(str), str2.getBytes());
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(175563);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.o(175563);
        return str3;
    }

    static /* synthetic */ long bxp(String str) {
        AppMethodBeat.i(175565);
        InputStream openRead = s.openRead(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(openRead, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        Util.qualityClose(checkedInputStream);
        Util.qualityClose(openRead);
        AppMethodBeat.o(175565);
        return value;
    }

    static /* synthetic */ String access$500() {
        return "unknown";
    }

    static /* synthetic */ String cz(String str, String str2) {
        AppMethodBeat.i(175566);
        String encodeHexString = Util.encodeHexString(new ah().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.o(175566);
        return encodeHexString;
    }

    static {
        AppMethodBeat.i(134321);
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
        }
        AqF = aKJ + "wxafiles/";
        o X = o.X(MMApplicationContext.getContext().getExternalCacheDir());
        if (X == null) {
            X = o.X(MMApplicationContext.getContext().getCacheDir());
        }
        LH(aa.z(X.her()));
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b((byte) 0));
        AsX = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(134321);
    }
}
