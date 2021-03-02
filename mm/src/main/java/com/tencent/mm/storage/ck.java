package com.tencent.mm.storage;

import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.vfs.s;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class ck extends MStorage {
    private ao OrC = null;

    public ck(ao aoVar) {
        this.OrC = aoVar;
    }

    public final void gEr() {
        AppMethodBeat.i(133299);
        Log.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(gEt()));
        AppMethodBeat.o(133299);
    }

    private boolean gEs() {
        AppMethodBeat.i(133300);
        String str = (String) this.OrC.get(77825, (Object) null);
        Log.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml ".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str)) {
            super.doNotify(str);
        }
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(133300);
            return true;
        }
        AppMethodBeat.o(133300);
        return false;
    }

    private int gEt() {
        AppMethodBeat.i(133301);
        if (!gEs()) {
            String str = ar.NSe + "deviceconfig.cfg";
            if (!s.YS(str)) {
                AppMethodBeat.o(133301);
                return -1;
            }
            byte[] aW = s.aW(str, 0, -1);
            if (Util.isNullOrNil(aW)) {
                AppMethodBeat.o(133301);
                return -2;
            }
            String str2 = new String(aW, Charset.defaultCharset());
            if (Util.isNullOrNil(str2)) {
                AppMethodBeat.o(133301);
                return -3;
            }
            Log.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str2);
            bkT(str2);
            AppMethodBeat.o(133301);
            return 0;
        }
        Log.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
        AppMethodBeat.o(133301);
        return 0;
    }

    public final String gEu() {
        AppMethodBeat.i(133302);
        String str = (String) this.OrC.get(77825, (Object) null);
        Log.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        AppMethodBeat.o(133302);
        return str;
    }

    public final int bkT(String str) {
        AppMethodBeat.i(133303);
        Log.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.OrC.set(77825, str);
        bkV(str);
        super.doNotify(str);
        AppMethodBeat.o(133303);
        return 0;
    }

    public static String gEv() {
        AppMethodBeat.i(133304);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = Build.FINGERPRINT;
        if (str != null) {
            str = str.replace(FilePathGenerator.ANDROID_DIR_SEP, ":");
        }
        linkedHashMap.put(FingerprintManagerProxy.FINGERPRINT_SERVICE, str);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", Build.VERSION.RELEASE);
        linkedHashMap.put("codename", Build.VERSION.CODENAME);
        linkedHashMap.put("incremental", Build.VERSION.INCREMENTAL);
        linkedHashMap.put(ServerProtocol.DIALOG_PARAM_DISPLAY, Build.DISPLAY);
        String mapToXml = Util.mapToXml("key", linkedHashMap);
        Log.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  ".concat(String.valueOf(mapToXml)));
        AppMethodBeat.o(133304);
        return mapToXml;
    }

    public static String getFingerprint() {
        AppMethodBeat.i(133305);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(Build.VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(Build.VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        Log.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(133305);
        return stringBuffer2;
    }

    public static boolean bkU(String str) {
        AppMethodBeat.i(133306);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133306);
            return false;
        }
        try {
            if (XmlParser.parseXml(str, "deviceinfoconfig", null) == null) {
                AppMethodBeat.o(133306);
                return false;
            } else if (!g.aAc()) {
                AppMethodBeat.o(133306);
                return false;
            } else {
                g.aAi();
                g.aAh().azR().bkT(str);
                AppMethodBeat.o(133306);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(133306);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094 A[SYNTHETIC, Splitter:B:22:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b0 A[SYNTHETIC, Splitter:B:29:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean bkV(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ck.bkV(java.lang.String):boolean");
    }

    public static String gEw() {
        AppMethodBeat.i(197180);
        String str = ar.NSe + "deviceconfig.cfg";
        Log.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str, Boolean.valueOf(s.YS(str)));
        if (!s.YS(str)) {
            AppMethodBeat.o(197180);
            return null;
        }
        byte[] aW = s.aW(str, 0, -1);
        if (Util.isNullOrNil(aW)) {
            AppMethodBeat.o(197180);
            return null;
        }
        String str2 = new String(aW, Charset.defaultCharset());
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(197180);
            return null;
        }
        AppMethodBeat.o(197180);
        return str2;
    }
}
