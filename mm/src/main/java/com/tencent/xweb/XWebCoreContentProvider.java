package com.tencent.xweb;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.xweb.util.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class XWebCoreContentProvider extends ContentProvider {

    public static class b {
        public int key = -1;
        public String value = "";
    }

    public static class d {
        public String SAC = "";
        public String SAD = "";
        public int mVo = 0;
        public int opType = -1;
    }

    public static class c {
        public String SAA = "";
        public d SAB = new d();
        public int errCode = -1;

        public c() {
            AppMethodBeat.i(156925);
            AppMethodBeat.o(156925);
        }
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(156926);
        if (contentValues == null || contentValues.size() == 0) {
            Log.d("XWebCoreContentProvider", "insert values is null or empty");
            AppMethodBeat.o(156926);
        } else if (B(uri).opType != 3) {
            Log.d("XWebCoreContentProvider", "insert wrong opType");
            AppMethodBeat.o(156926);
        } else {
            Context context = getContext();
            if (context == null) {
                Log.e("XWebCoreContentProvider", "insert context is null");
                AppMethodBeat.o(156926);
            } else if (!"com.tencent.mm".equals(context.getPackageName())) {
                Log.e("XWebCoreContentProvider", "insert current not mm, return");
                AppMethodBeat.o(156926);
            } else {
                Log.d("XWebCoreContentProvider", "insert start report");
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    try {
                        int parseInt = Integer.parseInt(entry.getKey());
                        String str = (String) entry.getValue();
                        if (h.asU(parseInt) && str != null && !str.isEmpty()) {
                            if (h.eEa()) {
                                Log.d("XWebCoreContentProvider", "insert report " + parseInt + " " + str);
                                h.dz(parseInt, str);
                            } else {
                                Log.d("XWebCoreContentProvider", "insert reporter not init, cache " + parseInt + " " + str);
                                b bVar = new b();
                                bVar.key = parseInt;
                                bVar.value = str;
                                a.a(bVar);
                            }
                        }
                    } catch (Exception e2) {
                        Log.d("XWebCoreContentProvider", "insert parse error");
                    }
                }
                AppMethodBeat.o(156926);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        File file;
        AppMethodBeat.i(156927);
        d B = B(uri);
        c cVar = new c();
        cVar.errCode = -1;
        cVar.SAB = B;
        Context context = getContext();
        if (context == null) {
            Log.e("XWebCoreContentProvider", "openFile context is null");
            cVar.errCode = -2;
            a(null, cVar);
            AppMethodBeat.o(156927);
            return null;
        }
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid != null) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < packagesForUid.length; i2++) {
                    if (i2 != packagesForUid.length - 1) {
                        sb.append(packagesForUid[i2]).append("+");
                    } else {
                        sb.append(packagesForUid[i2]);
                    }
                }
                String sb2 = sb.toString();
                if (!sb2.isEmpty()) {
                    B.SAC = sb2;
                }
            }
        } catch (Exception e2) {
            Log.e("XWebCoreContentProvider", "tryRefillCallerName error " + e2.getMessage());
        }
        String packageName = context.getPackageName();
        cVar.SAA = packageName;
        Log.d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(packageName)));
        if (!XWalkEnvironment.isProvider(packageName)) {
            Log.e("XWebCoreContentProvider", "openFile current is not provider");
            cVar.errCode = -3;
            a(context, cVar);
            AppMethodBeat.o(156927);
            return null;
        }
        switch (B.opType) {
            case 1:
                Log.d("XWebCoreContentProvider", "openFile test msg from " + B.SAC);
                cVar.errCode = 2;
                a(context, cVar);
                AppMethodBeat.o(156927);
                return null;
            case 2:
                Log.d("XWebCoreContentProvider", "openFile request from " + B.SAC);
                File file2 = new File(XWalkEnvironment.getPatchFileListConfig(context, B.mVo));
                if (!file2.exists()) {
                    file2 = new File(XWalkEnvironment.getDownloadZipFileListConfig(context, B.mVo));
                    if (!file2.exists()) {
                        Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + B.mVo);
                        cVar.errCode = -4;
                        a(context, cVar);
                        AppMethodBeat.o(156927);
                        return null;
                    }
                }
                if (!B.SAD.equals(XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME)) {
                    Map<String, String> ai = ai(file2);
                    if (ai.size() == 0) {
                        Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
                        cVar.errCode = -5;
                        a(context, cVar);
                        AppMethodBeat.o(156927);
                        return null;
                    } else if (ai.containsKey(B.SAD)) {
                        if (B.SAD.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                            file = new File(XWalkEnvironment.getDownloadApkPath(context, B.mVo));
                        } else {
                            file = new File(XWalkEnvironment.getExtractedCoreFile(context, B.mVo, B.SAD));
                        }
                        if (file.exists()) {
                            Log.d("XWebCoreContentProvider", "openFile return file " + B.SAD);
                            cVar.errCode = 0;
                            a(context, cVar);
                            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                            AppMethodBeat.o(156927);
                            return open;
                        }
                        Log.d("XWebCoreContentProvider", "openFile file not exist " + B.SAD);
                        cVar.errCode = -6;
                        a(context, cVar);
                        AppMethodBeat.o(156927);
                        return null;
                    } else {
                        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + B.SAD);
                        cVar.errCode = -7;
                        a(context, cVar);
                        AppMethodBeat.o(156927);
                        return null;
                    }
                } else if (XWalkEnvironment.readAvailableVersionFromSP(context) == -1) {
                    Log.d("XWebCoreContentProvider", "openFile can not get current version");
                    cVar.errCode = -8;
                    a(context, cVar);
                    AppMethodBeat.o(156927);
                    return null;
                } else {
                    Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
                    cVar.errCode = 1;
                    a(context, cVar);
                    ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file2, 268435456);
                    AppMethodBeat.o(156927);
                    return open2;
                }
            default:
                Log.d("XWebCoreContentProvider", "openFile invalid uri");
                cVar.errCode = -1;
                a(context, cVar);
                AppMethodBeat.o(156927);
                return null;
        }
    }

    private static void a(Context context, c cVar) {
        String str;
        AppMethodBeat.i(156928);
        String substring = cVar.SAA.length() > 100 ? cVar.SAA.substring(0, 99) : cVar.SAA;
        String substring2 = cVar.SAB.SAC.length() > 100 ? cVar.SAB.SAC.substring(0, 99) : cVar.SAB.SAC;
        if (cVar.SAB.SAD.length() > 100) {
            str = cVar.SAB.SAD.substring(0, 99);
        } else {
            str = cVar.SAB.SAD;
        }
        String str2 = cVar.errCode + "," + substring + "," + cVar.SAB.opType + "," + substring2 + "," + cVar.SAB.mVo + "," + str;
        if (context != null && !"com.tencent.mm".equals(cVar.SAA)) {
            Log.d("XWebCoreContentProvider", "doReport need post to mm ".concat(String.valueOf(str2)));
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                Log.e("XWebCoreContentProvider", "doReport content resolver is null");
                AppMethodBeat.o(156928);
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("15625", str2);
                contentResolver.insert(d("com.tencent.mm", cVar.SAA, 3, 0, ""), contentValues);
                AppMethodBeat.o(156928);
            } catch (Exception e2) {
                Log.d("XWebCoreContentProvider", "doReport error post to mm");
                AppMethodBeat.o(156928);
            }
        } else if (h.eEa()) {
            Log.d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(str2)));
            h.dz(15625, str2);
            AppMethodBeat.o(156928);
        } else {
            Log.d("XWebCoreContentProvider", "doReport reporter not init, cache ".concat(String.valueOf(str2)));
            b bVar = new b();
            bVar.key = 15625;
            bVar.value = str2;
            a.a(bVar);
            AppMethodBeat.o(156928);
        }
    }

    private static Map<String, String> ai(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(156929);
        HashMap hashMap = new HashMap();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.isEmpty()) {
                        String[] split = readLine.split(":");
                        if (split.length == 2 && split[0] != null && !split[0].isEmpty() && split[1] != null && !split[1].isEmpty()) {
                            hashMap.put(split[0], split[1]);
                            Log.d("XWebCoreContentProvider", "readListConfigFile found " + split[0]);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        AppMethodBeat.o(156929);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        AppMethodBeat.o(156929);
                        throw th;
                    }
                }
            }
            com.tencent.xweb.util.c.tryClose(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            Log.e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
            com.tencent.xweb.util.c.tryClose(bufferedReader);
            AppMethodBeat.o(156929);
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            com.tencent.xweb.util.c.tryClose(bufferedReader);
            AppMethodBeat.o(156929);
            throw th;
        }
        AppMethodBeat.o(156929);
        return hashMap;
    }

    private static d B(Uri uri) {
        int i2;
        AppMethodBeat.i(156930);
        d dVar = new d();
        dVar.opType = -1;
        String uri2 = uri.toString();
        if (uri2.length() > 1000) {
            Log.d("XWebCoreContentProvider", "parseUri exceed max length");
            AppMethodBeat.o(156930);
            return dVar;
        }
        Log.d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(uri2)));
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() < 2) {
            Log.d("XWebCoreContentProvider", "parseUri strList invalid");
            AppMethodBeat.o(156930);
            return dVar;
        }
        String str = pathSegments.get(0);
        if (str == null || str.isEmpty()) {
            Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
            AppMethodBeat.o(156930);
            return dVar;
        }
        dVar.SAC = str;
        try {
            int parseInt = Integer.parseInt(pathSegments.get(1));
            switch (parseInt) {
                case 1:
                case 3:
                    if (pathSegments.size() == 2) {
                        dVar.opType = parseInt;
                        Log.d("XWebCoreContentProvider", "parseUri result: ".concat(String.valueOf(parseInt)));
                    } else {
                        Log.d("XWebCoreContentProvider", "parseUri wrong params on test or report");
                    }
                    AppMethodBeat.o(156930);
                    return dVar;
                case 2:
                    String str2 = null;
                    if (pathSegments.size() == 4) {
                        str2 = pathSegments.get(3);
                        try {
                            i2 = Integer.parseInt(pathSegments.get(2));
                        } catch (Exception e2) {
                            Log.d("XWebCoreContentProvider", "parseUri error parse targetVersion");
                            i2 = -1;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 == -1 || str2 == null || str2.isEmpty()) {
                        Log.d("XWebCoreContentProvider", "parseUri wrong params on get file");
                    } else {
                        dVar.opType = parseInt;
                        dVar.mVo = i2;
                        dVar.SAD = str2;
                        Log.d("XWebCoreContentProvider", "parseUri result: " + parseInt + " " + i2 + " " + str2);
                    }
                    AppMethodBeat.o(156930);
                    return dVar;
                default:
                    Log.d("XWebCoreContentProvider", "parseUri invalid opType");
                    AppMethodBeat.o(156930);
                    return dVar;
            }
        } catch (Exception e3) {
            Log.d("XWebCoreContentProvider", "parseUri error parse opType");
            AppMethodBeat.o(156930);
            return dVar;
        }
    }

    public static Uri d(String str, String str2, int i2, int i3, String str3) {
        AppMethodBeat.i(156931);
        if (str2.isEmpty()) {
            str2 = " ";
        }
        switch (i2) {
            case 2:
                Uri parse = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + FilePathGenerator.ANDROID_DIR_SEP + i2 + FilePathGenerator.ANDROID_DIR_SEP + i3 + FilePathGenerator.ANDROID_DIR_SEP + str3);
                AppMethodBeat.o(156931);
                return parse;
            default:
                Uri parse2 = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + FilePathGenerator.ANDROID_DIR_SEP + i2);
                AppMethodBeat.o(156931);
                return parse2;
        }
    }

    public static void htb() {
        AppMethodBeat.i(156932);
        a.htc();
        AppMethodBeat.o(156932);
    }

    public static class a {
        private static List<b> SAz = new ArrayList();
        private static final Object SyQ = new Object();

        static {
            AppMethodBeat.i(156924);
            AppMethodBeat.o(156924);
        }

        public static void a(b bVar) {
            AppMethodBeat.i(156922);
            synchronized (SyQ) {
                try {
                    SAz.add(bVar);
                } finally {
                    AppMethodBeat.o(156922);
                }
            }
        }

        public static void htc() {
            AppMethodBeat.i(156923);
            Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
            synchronized (SyQ) {
                try {
                    for (b bVar : SAz) {
                        h.dz(bVar.key, bVar.value);
                    }
                    SAz.clear();
                } finally {
                    AppMethodBeat.o(156923);
                }
            }
        }
    }
}
