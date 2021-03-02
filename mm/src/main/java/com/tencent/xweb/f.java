package com.tencent.xweb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;
import com.tencent.xweb.xwalk.a.m;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class f {
    public static final String[] SyR = {"ppt", "pptx", "xls", "xlsx", "doc", "docx", "pdf"};
    public static String SyS = "open_x5_from_scene";

    public enum a {
        NONE,
        XWEB,
        X5;

        public static a valueOf(String str) {
            AppMethodBeat.i(156733);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(156733);
            return aVar;
        }

        static {
            AppMethodBeat.i(156734);
            AppMethodBeat.o(156734);
        }
    }

    public enum c {
        none,
        yes,
        no;

        public static c valueOf(String str) {
            AppMethodBeat.i(219000);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(219000);
            return cVar;
        }

        static {
            AppMethodBeat.i(219001);
            AppMethodBeat.o(219001);
        }
    }

    public static a a(String str, a aVar, boolean z, Intent intent) {
        boolean z2;
        AppMethodBeat.i(156735);
        h(intent, 40);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "getReaderType fileExt is empty");
            AppMethodBeat.o(156735);
            return aVar;
        }
        String lowerCase = str.toLowerCase();
        if (aVar == a.NONE) {
            if (y.hsF() != null) {
                aVar = y.hsF().bsl(lowerCase);
                Log.i("XFilesReaderHelper", "getReaderType force type: " + aVar.toString());
                h(intent, 41);
            } else {
                Log.e("XFilesReaderHelper", "getReaderType WebDebugCfg is null, skip force");
            }
        }
        if (aVar == a.NONE) {
            aVar = b.brT(lowerCase);
            Log.i("XFilesReaderHelper", "getReaderType cmd type: " + aVar.toString());
            h(intent, 42);
        }
        if (aVar == a.X5 || aVar == a.NONE) {
            Log.i("XFilesReaderHelper", "getReaderType use x5");
            a aVar2 = a.X5;
            AppMethodBeat.o(156735);
            return aVar2;
        }
        if (y.hsF() != null) {
            z2 = y.hsF().hsH();
        } else {
            z2 = false;
        }
        if (z2 || !e.brV(lowerCase)) {
            g brX = brX(lowerCase);
            if (!(brX instanceof m)) {
                Log.i("XFilesReaderHelper", lowerCase + " is not supported, use x5");
                h(intent, 47);
                a aVar3 = a.X5;
                AppMethodBeat.o(156735);
                return aVar3;
            }
            m mVar = (m) brX;
            int hvk = mVar.hvk();
            int atb = mVar.atb(0);
            if (hvk <= 0 || hvk < atb) {
                if (ai.htj()) {
                    Log.i("XFilesReaderHelper", "getReaderType forbid download code, use x5");
                    h(intent, 44);
                    a aVar4 = a.X5;
                    AppMethodBeat.o(156735);
                    return aVar4;
                } else if (!b.hsm()) {
                    Log.i("XFilesReaderHelper", "getReaderType plugin version: " + hvk + ", require: " + atb + ", canDownloadWhenNotInstall: false, use x5");
                    h(intent, hvk <= 0 ? 45 : 46);
                    a aVar5 = a.X5;
                    AppMethodBeat.o(156735);
                    return aVar5;
                } else {
                    Log.i("XFilesReaderHelper", "getReaderType plugin version: " + hvk + ", require: " + atb + ", canDownloadWhenNotInstall: true, use xweb");
                    a aVar6 = a.XWEB;
                    AppMethodBeat.o(156735);
                    return aVar6;
                }
            } else if (mVar.dS(lowerCase, z)) {
                Log.i("XFilesReaderHelper", "getReaderType plugin support, use xweb");
                a aVar7 = a.XWEB;
                AppMethodBeat.o(156735);
                return aVar7;
            } else {
                Log.i("XFilesReaderHelper", "getReaderType plugin not support, use x5");
                h(intent, 47);
                a aVar8 = a.X5;
                AppMethodBeat.o(156735);
                return aVar8;
            }
        } else {
            Log.i("XFilesReaderHelper", "getReaderType recent crashed, use x5");
            h(intent, 43);
            a aVar9 = a.X5;
            AppMethodBeat.o(156735);
            return aVar9;
        }
    }

    private static boolean brW(String str) {
        AppMethodBeat.i(219002);
        c cVar = c.none;
        if (y.hsF() != null) {
            cVar = y.hsF().bsm(str);
            Log.i("XFilesReaderHelper", "getUseOfficeReader force = " + cVar.toString());
        } else {
            Log.e("XFilesReaderHelper", "getUseOfficeReader WebDebugCfg is null, skip force");
        }
        if (cVar == c.none) {
            cVar = b.brR(str);
            Log.i("XFilesReaderHelper", "getUseOfficeReader cmd = " + cVar.toString());
        }
        if (cVar == c.yes) {
            AppMethodBeat.o(219002);
            return true;
        }
        AppMethodBeat.o(219002);
        return false;
    }

    public static g brX(String str) {
        AppMethodBeat.i(156736);
        if (str == null) {
            AppMethodBeat.o(156736);
            return null;
        } else if (str.equalsIgnoreCase("ppt") || str.equalsIgnoreCase("pptx")) {
            if (brW(str)) {
                g brX = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE);
                AppMethodBeat.o(156736);
                return brX;
            }
            g brX2 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_PPT);
            AppMethodBeat.o(156736);
            return brX2;
        } else if (str.equalsIgnoreCase("pdf")) {
            g brX3 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_PDF);
            AppMethodBeat.o(156736);
            return brX3;
        } else if (str.equalsIgnoreCase("doc") || str.equalsIgnoreCase("docx")) {
            if (brW(str)) {
                g brX4 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE);
                AppMethodBeat.o(156736);
                return brX4;
            }
            g brX5 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_WORD);
            AppMethodBeat.o(156736);
            return brX5;
        } else if (!str.equalsIgnoreCase("xls") && !str.equalsIgnoreCase("xlsx")) {
            AppMethodBeat.o(156736);
            return null;
        } else if (brW(str)) {
            g brX6 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE);
            AppMethodBeat.o(156736);
            return brX6;
        } else {
            g brX7 = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL);
            AppMethodBeat.o(156736);
            return brX7;
        }
    }

    private static void h(Intent intent, int i2) {
        AppMethodBeat.i(156737);
        if (intent != null) {
            intent.putExtra(SyS, i2);
        }
        AppMethodBeat.o(156737);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        boolean SyX;
        int syl;

        public b(int i2, boolean z) {
            this.syl = i2;
            this.SyX = z;
        }
    }

    private static b brY(String str) {
        AppMethodBeat.i(156738);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "getReportTarget fileExt is null");
            AppMethodBeat.o(156738);
            return null;
        } else if (str.equalsIgnoreCase("ppt")) {
            b bVar = new b(1068, false);
            AppMethodBeat.o(156738);
            return bVar;
        } else if (str.equalsIgnoreCase("pptx")) {
            b bVar2 = new b(1068, true);
            AppMethodBeat.o(156738);
            return bVar2;
        } else if (str.equalsIgnoreCase("xls")) {
            b bVar3 = new b(1070, false);
            AppMethodBeat.o(156738);
            return bVar3;
        } else if (str.equalsIgnoreCase("xlsx")) {
            b bVar4 = new b(1070, true);
            AppMethodBeat.o(156738);
            return bVar4;
        } else if (str.equalsIgnoreCase("doc")) {
            b bVar5 = new b(1069, false);
            AppMethodBeat.o(156738);
            return bVar5;
        } else if (str.equalsIgnoreCase("docx")) {
            b bVar6 = new b(1069, true);
            AppMethodBeat.o(156738);
            return bVar6;
        } else if (str.equalsIgnoreCase("pdf")) {
            b bVar7 = new b(1071, false);
            AppMethodBeat.o(156738);
            return bVar7;
        } else {
            AppMethodBeat.o(156738);
            return null;
        }
    }

    public static void nX(String str, String str2) {
        int i2;
        AppMethodBeat.i(156739);
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportFileSize param is null");
            AppMethodBeat.o(156739);
            return;
        }
        String lowerCase = str2.toLowerCase();
        File file = new File(str);
        if (!file.exists()) {
            Log.e("XFilesReaderHelper", "reportFileSize file not exist");
            AppMethodBeat.o(156739);
            return;
        }
        long length = file.length() / 1048576;
        if (length == 0) {
            length++;
        }
        String str3 = (lowerCase.length() > 50 ? lowerCase.substring(0, 50) : lowerCase) + "," + length;
        Log.d("XFilesReaderHelper", "reportFileSize kv key:17562, val:".concat(String.valueOf(str3)));
        com.tencent.xweb.util.h.dz(17562, str3);
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportFileSize idkey skip ".concat(String.valueOf(lowerCase)));
            AppMethodBeat.o(156739);
            return;
        }
        if (length <= 10) {
            i2 = brY.SyX ? 24 : 20;
        } else if (length <= 20) {
            i2 = brY.SyX ? 25 : 21;
        } else if (length <= 50) {
            i2 = brY.SyX ? 26 : 22;
        } else {
            i2 = brY.SyX ? 27 : 23;
        }
        Log.d("XFilesReaderHelper", "reportFileSize idkey id:" + brY.syl + ", key:" + i2);
        com.tencent.xweb.util.h.s((long) brY.syl, (long) i2, 1);
        AppMethodBeat.o(156739);
    }

    public static void hM(String str, int i2) {
        AppMethodBeat.i(156740);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportReadByX5Scene param is null");
            AppMethodBeat.o(156740);
            return;
        }
        String lowerCase = str.toLowerCase();
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey skip ".concat(String.valueOf(lowerCase)));
            AppMethodBeat.o(156740);
            return;
        }
        String str2 = lowerCase + "," + i2;
        Log.d("XFilesReaderHelper", "reportReadByX5Scene kv key:17563, val:".concat(String.valueOf(str2)));
        com.tencent.xweb.util.h.dz(17563, str2);
        Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey id:" + brY.syl + ", key:" + i2);
        com.tencent.xweb.util.h.s((long) brY.syl, (long) i2, 1);
        AppMethodBeat.o(156740);
    }

    public static void nY(String str, String str2) {
        int i2;
        int i3;
        String str3;
        boolean z;
        int i4;
        boolean z2 = true;
        AppMethodBeat.i(156741);
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportPVUV param is null");
            AppMethodBeat.o(156741);
            return;
        }
        String lowerCase = str.toLowerCase();
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportPVUV skip " + lowerCase + ", " + str2);
            AppMethodBeat.o(156741);
            return;
        }
        if (a.XWEB.name().equalsIgnoreCase(str2)) {
            int i5 = brY.SyX ? 1 : 0;
            if (brY.SyX) {
                i4 = 3;
            } else {
                i4 = 2;
            }
            i2 = i4;
            i3 = i5;
        } else if (a.X5.name().equalsIgnoreCase(str2)) {
            int i6 = brY.SyX ? 5 : 4;
            i2 = brY.SyX ? 7 : 6;
            i3 = i6;
        } else if ("QQBROWSER".equalsIgnoreCase(str2)) {
            int i7 = brY.SyX ? 17 : 16;
            i2 = brY.SyX ? 19 : 18;
            i3 = i7;
        } else if ("THIRDAPP".equalsIgnoreCase(str2)) {
            int i8 = brY.SyX ? 9 : 8;
            i2 = brY.SyX ? 11 : 10;
            i3 = i8;
        } else {
            Log.e("XFilesReaderHelper", "reportPVUV unknown type, skip");
            AppMethodBeat.o(156741);
            return;
        }
        try {
            str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        } catch (Exception e2) {
            Log.e("XFilesReaderHelper", "reportPVUV get cur date error: " + e2.getMessage());
            str3 = "";
        }
        String str4 = lowerCase + "_" + str2 + "__report_uv_date";
        SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
        if (sharedPreferencesForFileReaderRecord != null) {
            if (sharedPreferencesForFileReaderRecord.getString(str4, "").equals(str3)) {
                z2 = false;
            }
            z = z2;
        } else {
            Log.e("XFilesReaderHelper", "reportPVUV sp is null, skip uv report");
            z = false;
        }
        Log.d("XFilesReaderHelper", "reportPV id:" + brY.syl + ", key:" + i3);
        com.tencent.xweb.util.h.s((long) brY.syl, (long) i3, 1);
        if (z) {
            Log.d("XFilesReaderHelper", "reportUV id:" + brY.syl + ", key:" + i2);
            com.tencent.xweb.util.h.s((long) brY.syl, (long) i2, 1);
            SharedPreferences.Editor edit = sharedPreferencesForFileReaderRecord.edit();
            if (edit != null) {
                edit.putString(str4, str3);
                edit.commit();
                AppMethodBeat.o(156741);
                return;
            }
            Log.e("XFilesReaderHelper", "reportPVUV editor is null, skip");
        }
        AppMethodBeat.o(156741);
    }

    private static void hN(String str, int i2) {
        AppMethodBeat.i(219003);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportIDKeyByFileExt param is null");
            AppMethodBeat.o(219003);
            return;
        }
        String lowerCase = str.toLowerCase();
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportIDKeyByFileExt skip ".concat(String.valueOf(lowerCase)));
            AppMethodBeat.o(219003);
            return;
        }
        Log.d("XFilesReaderHelper", "reportIDKeyByFileExt id:" + brY.syl + ", key:" + i2);
        com.tencent.xweb.util.h.s((long) brY.syl, (long) i2, 1);
        AppMethodBeat.o(219003);
    }

    public static void brZ(String str) {
        AppMethodBeat.i(219004);
        hN(str, 74);
        AppMethodBeat.o(219004);
    }

    public static void bsa(String str) {
        AppMethodBeat.i(219005);
        hN(str, 75);
        AppMethodBeat.o(219005);
    }

    public static void bsb(String str) {
        AppMethodBeat.i(219006);
        hN(str, 76);
        AppMethodBeat.o(219006);
    }

    public static void bsc(String str) {
        AppMethodBeat.i(219007);
        hN(str, 77);
        AppMethodBeat.o(219007);
    }

    public static void bsd(String str) {
        AppMethodBeat.i(219008);
        hN(str, 78);
        AppMethodBeat.o(219008);
    }

    public static void bse(String str) {
        AppMethodBeat.i(219009);
        hN(str, 80);
        AppMethodBeat.o(219009);
    }

    public static void hO(String str, int i2) {
        int i3;
        AppMethodBeat.i(219010);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportDownloadErrorCode param is null");
            AppMethodBeat.o(219010);
            return;
        }
        String lowerCase = str.toLowerCase();
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportDownloadErrorCode skip ".concat(String.valueOf(lowerCase)));
            AppMethodBeat.o(219010);
            return;
        }
        switch (i2) {
            case -9:
                i3 = 89;
                break;
            case -8:
                i3 = 88;
                break;
            case -7:
                i3 = 87;
                break;
            case -6:
                i3 = 86;
                break;
            case -5:
                i3 = 85;
                break;
            case -4:
                i3 = 84;
                break;
            case -3:
                i3 = 83;
                break;
            case -2:
                i3 = 82;
                break;
            case -1:
                i3 = 81;
                break;
            case 0:
                i3 = 79;
                break;
            default:
                Log.e("XFilesReaderHelper", "reportDownloadErrorCode idkey unknown ret: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(219010);
                return;
        }
        Log.d("XFilesReaderHelper", "reportDownloadErrorCode idkey id:" + brY.syl + ", key:" + i3);
        com.tencent.xweb.util.h.s((long) brY.syl, (long) i3, 1);
        AppMethodBeat.o(219010);
    }

    public static void b(String str, int i2, boolean z, int i3) {
        String str2;
        AppMethodBeat.i(156742);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportX5ErrorCode param is null");
            AppMethodBeat.o(156742);
            return;
        }
        String lowerCase = str.toLowerCase();
        b brY = brY(lowerCase);
        if (brY == null) {
            Log.d("XFilesReaderHelper", "reportX5ErrorCode skip ".concat(String.valueOf(lowerCase)));
            AppMethodBeat.o(156742);
            return;
        }
        if (i2 != 0) {
            if (z) {
                str2 = "-1," + lowerCase + "," + i2 + ",x5init";
            } else {
                str2 = "-1," + lowerCase + "," + i2 + ",x5";
            }
            Log.d("XFilesReaderHelper", "reportX5ErrorCode kv key:17566, val:".concat(String.valueOf(str2)));
            com.tencent.xweb.util.h.dz(17566, str2);
        }
        if (z || i2 == -102) {
            int i4 = brY.SyX ? 15 : 14;
            Log.d("XFilesReaderHelper", "reportX5ErrorCode idkey id:" + brY.syl + ", key:" + i4);
            com.tencent.xweb.util.h.s((long) brY.syl, (long) i4, 1);
            if (i3 == 49) {
                int i5 = brY.SyX ? 39 : 38;
                Log.d("XFilesReaderHelper", "reportX5ErrorCode XWeb and X5 All failed id:" + brY.syl + ", key:" + i5);
                com.tencent.xweb.util.h.s((long) brY.syl, (long) i5, 1);
            }
        }
        AppMethodBeat.o(156742);
    }

    public static void aZ(String str, int i2, int i3) {
        int i4;
        AppMethodBeat.i(156743);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportXWebErrorCode param is null");
            AppMethodBeat.o(156743);
        } else if (i3 == 0) {
            AppMethodBeat.o(156743);
        } else {
            String lowerCase = str.toLowerCase();
            b brY = brY(lowerCase);
            if (brY == null) {
                Log.d("XFilesReaderHelper", "reportXWebErrorCode skip ".concat(String.valueOf(lowerCase)));
                AppMethodBeat.o(156743);
                return;
            }
            String str2 = i2 + "," + lowerCase + "," + i3 + ",xweb";
            Log.d("XFilesReaderHelper", "reportXWebErrorCode kv key:17566, val:".concat(String.valueOf(str2)));
            com.tencent.xweb.util.h.dz(17566, str2);
            int i5 = brY.SyX ? 13 : 12;
            Log.d("XFilesReaderHelper", "reportXWebErrorCode first idkey id:" + brY.syl + ", key:" + i5);
            com.tencent.xweb.util.h.s((long) brY.syl, (long) i5, 1);
            switch (i3) {
                case -16:
                    i4 = 166;
                    break;
                case -15:
                    i4 = 165;
                    break;
                case -14:
                    i4 = 164;
                    break;
                case -13:
                    i4 = 163;
                    break;
                case -12:
                    i4 = 162;
                    break;
                case -11:
                    i4 = 161;
                    break;
                case -10:
                    i4 = 160;
                    break;
                case -9:
                    i4 = 159;
                    break;
                case -8:
                    i4 = 158;
                    break;
                case -7:
                    i4 = 157;
                    break;
                case -6:
                    i4 = 156;
                    break;
                case -5:
                    i4 = 155;
                    break;
                case -4:
                    i4 = 154;
                    break;
                case -3:
                    i4 = 153;
                    break;
                case -2:
                    i4 = 152;
                    break;
                case -1:
                    i4 = 151;
                    break;
                default:
                    Log.e("XFilesReaderHelper", "reportXWebErrorCode idkey unknown ret: ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(156743);
                    return;
            }
            Log.d("XFilesReaderHelper", "reportXWebErrorCode second idkey id:" + brY.syl + ", key:" + i4);
            com.tencent.xweb.util.h.s((long) brY.syl, (long) i4, 1);
            AppMethodBeat.o(156743);
        }
    }

    public static void a(String str, int i2, String str2, Exception exc) {
        AppMethodBeat.i(156744);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderHelper", "reportException wrong param");
            AppMethodBeat.o(156744);
            return;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2.isEmpty()) {
                stringWriter2 = "empty";
            }
            String replace = stringWriter2.substring(0, Math.min(stringWriter2.length(), 1000)).replace(',', ' ').replace(':', ' ');
            String str3 = str2 + " " + exc.getMessage();
            if (str3.isEmpty()) {
                str3 = "empty";
            }
            String str4 = i2 + "," + str + "," + replace + "," + str3.substring(0, Math.min(str3.length(), 1000)).replace(',', ' ').replace(':', ' ');
            Log.d("XFilesReaderHelper", "reportException kv key:17565, val:".concat(String.valueOf(str4)));
            com.tencent.xweb.util.h.dz(17565, str4);
            AppMethodBeat.o(156744);
        } catch (Exception e2) {
            Log.e("XFilesReaderHelper", "reportException error: ", e2);
            AppMethodBeat.o(156744);
        }
    }

    public static long lB(Context context) {
        AppMethodBeat.i(156745);
        if (context == null) {
            AppMethodBeat.o(156745);
            return 0;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            AppMethodBeat.o(156745);
            return 0;
        }
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            AppMethodBeat.o(156745);
            return 0;
        }
        long totalPrivateDirty = (long) ((processMemoryInfo[0].getTotalPrivateDirty() + processMemoryInfo[0].getTotalPrivateClean()) / 1024);
        Log.i("XFilesReaderHelper", "getCurrentProcessMemory ".concat(String.valueOf(totalPrivateDirty)));
        AppMethodBeat.o(156745);
        return totalPrivateDirty;
    }
}
