package com.tencent.liteav.basic.license;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenceCheck {

    /* renamed from: d  reason: collision with root package name */
    private static LicenceCheck f380d;

    /* renamed from: a  reason: collision with root package name */
    private Context f381a;

    /* renamed from: b  reason: collision with root package name */
    private String f382b = "YTFaceSDK.licence";

    /* renamed from: c  reason: collision with root package name */
    private String f383c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";

    /* renamed from: e  reason: collision with root package name */
    private a f384e = new a("TXUgcSDK.licence");

    /* renamed from: f  reason: collision with root package name */
    private a f385f = new a("TXLiveSDK.licence");

    private native byte[] nativeIvParameterSpec(byte[] bArr);

    static /* synthetic */ String a(LicenceCheck licenceCheck, a aVar) {
        AppMethodBeat.i(222170);
        String h2 = licenceCheck.h(aVar);
        AppMethodBeat.o(222170);
        return h2;
    }

    static /* synthetic */ void a(LicenceCheck licenceCheck, a aVar, String str) {
        AppMethodBeat.i(222169);
        licenceCheck.b(aVar, str);
        AppMethodBeat.o(222169);
    }

    static /* synthetic */ int b(LicenceCheck licenceCheck, a aVar, String str) {
        AppMethodBeat.i(222171);
        int d2 = licenceCheck.d(aVar, str);
        AppMethodBeat.o(222171);
        return d2;
    }

    static /* synthetic */ void b(LicenceCheck licenceCheck, a aVar) {
        AppMethodBeat.i(222172);
        licenceCheck.f(aVar);
        AppMethodBeat.o(222172);
    }

    /* access modifiers changed from: package-private */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f388a;

        /* renamed from: b  reason: collision with root package name */
        String f389b;

        /* renamed from: c  reason: collision with root package name */
        String f390c = "";

        /* renamed from: d  reason: collision with root package name */
        String f391d = "";

        /* renamed from: e  reason: collision with root package name */
        String f392e = "";

        /* renamed from: f  reason: collision with root package name */
        boolean f393f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f394g = false;

        /* renamed from: h  reason: collision with root package name */
        int f395h = -1;

        /* renamed from: i  reason: collision with root package name */
        String f396i = "";

        public a(String str) {
            AppMethodBeat.i(222175);
            this.f388a = str;
            this.f389b = str + ".tmp";
            AppMethodBeat.o(222175);
        }
    }

    public static LicenceCheck a() {
        AppMethodBeat.i(222138);
        if (f380d == null) {
            f380d = new LicenceCheck();
        }
        LicenceCheck licenceCheck = f380d;
        AppMethodBeat.o(222138);
        return licenceCheck;
    }

    private LicenceCheck() {
        AppMethodBeat.i(222139);
        AppMethodBeat.o(222139);
    }

    public void a(Context context, String str, String str2) {
        AppMethodBeat.i(222140);
        a(this.f385f, context, str, str2);
        AppMethodBeat.o(222140);
    }

    private void a(a aVar, Context context, String str, String str2) {
        AppMethodBeat.i(222141);
        if (context != null) {
            this.f381a = context.getApplicationContext();
            TXCCommonUtil.setAppContext(context);
        }
        aVar.f391d = str2;
        aVar.f392e = str;
        if (this.f381a != null && c()) {
            File externalFilesDir = this.f381a.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                aVar.f390c = externalFilesDir.getAbsolutePath();
            }
            if (!b(aVar.f390c + File.separator + aVar.f388a)) {
                TXCLog.i("LicenceCheck", "setLicense, sdcard file not exist, to download");
                b(aVar, "");
            }
            a(aVar);
        }
        AppMethodBeat.o(222141);
    }

    public void a(final a aVar) {
        AppMethodBeat.i(222142);
        if (TextUtils.isEmpty(aVar.f392e)) {
            TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
            AppMethodBeat.o(222142);
        } else if (aVar.f393f) {
            TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
            AppMethodBeat.o(222142);
        } else {
            AnonymousClass1 r5 = new b() {
                /* class com.tencent.liteav.basic.license.LicenceCheck.AnonymousClass1 */

                @Override // com.tencent.liteav.basic.license.b
                public void a(File file, String str) {
                    AppMethodBeat.i(222134);
                    if (file == null) {
                        TXCLog.i("LicenceCheck", "downloadLicense, license not modified");
                        AppMethodBeat.o(222134);
                        return;
                    }
                    LicenceCheck.a(LicenceCheck.this, aVar, str);
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
                    String a2 = LicenceCheck.a(LicenceCheck.this, aVar);
                    if (TextUtils.isEmpty(a2)) {
                        TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
                        aVar.f393f = false;
                        AppMethodBeat.o(222134);
                        return;
                    }
                    if (LicenceCheck.b(LicenceCheck.this, aVar, a2) == 0) {
                        LicenceCheck.b(LicenceCheck.this, aVar);
                    }
                    AppMethodBeat.o(222134);
                }

                @Override // com.tencent.liteav.basic.license.b
                public void a(File file, Exception exc) {
                    AppMethodBeat.i(222135);
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
                    AppMethodBeat.o(222135);
                }

                @Override // com.tencent.liteav.basic.license.b
                public void a(int i2) {
                    AppMethodBeat.i(222136);
                    TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
                    AppMethodBeat.o(222136);
                }

                @Override // com.tencent.liteav.basic.license.b
                public void a() {
                    AppMethodBeat.i(222137);
                    TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
                    aVar.f393f = false;
                    AppMethodBeat.o(222137);
                }
            };
            if (this.f381a == null) {
                TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
                AppMethodBeat.o(222142);
                return;
            }
            File externalFilesDir = this.f381a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
                AppMethodBeat.o(222142);
                return;
            }
            String b2 = b(aVar);
            aVar.f390c = externalFilesDir.getAbsolutePath();
            new Thread(new c(this.f381a, aVar.f392e, aVar.f390c, aVar.f389b, r5, false, b2)).start();
            aVar.f393f = true;
            AppMethodBeat.o(222142);
        }
    }

    public int a(f fVar, Context context) {
        AppMethodBeat.i(222143);
        int a2 = a(this.f385f, fVar, context);
        AppMethodBeat.o(222143);
        return a2;
    }

    private String b(a aVar) {
        AppMethodBeat.i(222144);
        if (this.f381a == null) {
            AppMethodBeat.o(222144);
            return null;
        }
        String string = this.f381a.getSharedPreferences("LicenceCheck.lastModified", 0).getString(aVar.f388a + ".lastModified", null);
        AppMethodBeat.o(222144);
        return string;
    }

    private void b(a aVar, String str) {
        AppMethodBeat.i(222145);
        if (this.f381a == null) {
            AppMethodBeat.o(222145);
            return;
        }
        SharedPreferences.Editor edit = this.f381a.getSharedPreferences("LicenceCheck.lastModified", 0).edit();
        edit.putString(aVar.f388a + ".lastModified", str);
        edit.commit();
        AppMethodBeat.o(222145);
    }

    private int a(a aVar, f fVar, Context context) {
        AppMethodBeat.i(222146);
        int a2 = a(aVar, context);
        if (a2 != 0) {
            a(aVar);
        }
        if (fVar != null) {
            fVar.f408a = aVar.f396i;
        }
        AppMethodBeat.o(222146);
        return a2;
    }

    private int a(a aVar, Context context) {
        AppMethodBeat.i(222147);
        if (aVar.f394g) {
            AppMethodBeat.o(222147);
            return 0;
        }
        if (this.f381a == null) {
            this.f381a = context;
        }
        if (d(aVar) == 0) {
            aVar.f394g = true;
            AppMethodBeat.o(222147);
            return 0;
        }
        int c2 = c(aVar);
        if (c2 == 0) {
            aVar.f394g = true;
            AppMethodBeat.o(222147);
            return 0;
        }
        AppMethodBeat.o(222147);
        return c2;
    }

    private int c(a aVar) {
        AppMethodBeat.i(222148);
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            AppMethodBeat.o(222148);
            return -10;
        }
        File externalFilesDir = this.f381a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            AppMethodBeat.o(222148);
            return -10;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + aVar.f388a;
        if (!b(str)) {
            AppMethodBeat.o(222148);
            return -7;
        }
        String b2 = c.b(str);
        if (TextUtils.isEmpty(b2)) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
            AppMethodBeat.o(222148);
            return -8;
        }
        int a2 = a(aVar, b2);
        AppMethodBeat.o(222148);
        return a2;
    }

    private int d(a aVar) {
        AppMethodBeat.i(222149);
        if (!e(aVar)) {
            AppMethodBeat.o(222149);
            return -6;
        }
        String b2 = c.b(this.f381a, aVar.f388a);
        if (TextUtils.isEmpty(b2)) {
            TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
            AppMethodBeat.o(222149);
            return -8;
        }
        int a2 = a(aVar, b2);
        AppMethodBeat.o(222149);
        return a2;
    }

    public int a(a aVar, String str) {
        AppMethodBeat.i(222150);
        try {
            new JSONObject(str);
            int d2 = d(aVar, str);
            AppMethodBeat.o(222150);
            return d2;
        } catch (JSONException e2) {
            if (aVar == this.f385f) {
                AppMethodBeat.o(222150);
                return -1;
            }
            int e3 = e(aVar, str);
            AppMethodBeat.o(222150);
            return e3;
        }
    }

    private boolean c() {
        AppMethodBeat.i(222151);
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            AppMethodBeat.o(222151);
            return false;
        } else if (this.f381a.getExternalFilesDir(null) == null) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            AppMethodBeat.o(222151);
            return false;
        } else {
            AppMethodBeat.o(222151);
            return true;
        }
    }

    private boolean e(a aVar) {
        AppMethodBeat.i(222152);
        boolean a2 = c.a(this.f381a, aVar.f388a);
        AppMethodBeat.o(222152);
        return a2;
    }

    private boolean b(String str) {
        AppMethodBeat.i(222153);
        boolean a2 = c.a(str);
        AppMethodBeat.o(222153);
        return a2;
    }

    private void f(a aVar) {
        AppMethodBeat.i(222154);
        File externalFilesDir = this.f381a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            TXCLog.i("LicenceCheck", "saveTempLocal sdcardDir is null");
            AppMethodBeat.o(222154);
            return;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + File.separator + aVar.f388a);
        if (file.exists()) {
            TXCLog.i("LicenceCheck", "delete dst file:".concat(String.valueOf(file.delete())));
        }
        File file2 = new File(aVar.f390c + File.separator + aVar.f389b);
        if (file2.exists()) {
            TXCLog.i("LicenceCheck", "rename file:".concat(String.valueOf(file2.renameTo(file))));
        }
        aVar.f394g = true;
        AppMethodBeat.o(222154);
    }

    private static long c(String str) {
        AppMethodBeat.i(222155);
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
            AppMethodBeat.o(222155);
            return time;
        } catch (Exception e2) {
            TXCLog.e("LicenceCheck", "time str to millsecond failed.", e2);
            AppMethodBeat.o(222155);
            return -1;
        }
    }

    public PublicKey a(String str) {
        AppMethodBeat.i(222156);
        PublicKey generatePublic = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        AppMethodBeat.o(222156);
        return generatePublic;
    }

    private String c(a aVar, String str) {
        String str2;
        AppMethodBeat.i(222157);
        if (TextUtils.isEmpty(aVar.f391d)) {
            TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
            AppMethodBeat.o(222157);
            return "";
        }
        byte[] bytes = aVar.f391d.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(nativeIvParameterSpec(bytes));
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            str2 = new String(instance.doFinal(decode), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            TXCLog.i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(str2)));
        } catch (Exception e2) {
            str2 = null;
        }
        AppMethodBeat.o(222157);
        return str2;
    }

    private int d(a aVar, String str) {
        AppMethodBeat.i(222158);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("appId");
            String string = jSONObject.getString("encryptedLicense");
            String string2 = jSONObject.getString("signature");
            TXCLog.i("LicenceCheck", "appid:".concat(String.valueOf(optInt)));
            TXCLog.i("LicenceCheck", "encryptedLicense:".concat(String.valueOf(string)));
            TXCLog.i("LicenceCheck", "signature:".concat(String.valueOf(string2)));
            int a2 = a(aVar, string, string2);
            AppMethodBeat.o(222158);
            return a2;
        } catch (JSONException e2) {
            a(-1);
            AppMethodBeat.o(222158);
            return -1;
        }
    }

    private int a(a aVar, String str, String str2) {
        boolean z;
        AppMethodBeat.i(222159);
        try {
            z = a(Base64.decode(str, 0), Base64.decode(str2, 0), a(this.f383c));
        } catch (Exception e2) {
            TXCLog.e("LicenceCheck", "verifyLicence, exception is : ".concat(String.valueOf(e2)));
            z = false;
        }
        if (!z) {
            a(-2);
            TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
            AppMethodBeat.o(222159);
            return -2;
        }
        String c2 = c(aVar, str);
        if (TextUtils.isEmpty(c2)) {
            a(-3);
            TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
            AppMethodBeat.o(222159);
            return -3;
        }
        aVar.f396i = c2;
        try {
            JSONObject jSONObject = new JSONObject(c2);
            String string = jSONObject.getString("pituLicense");
            JSONArray optJSONArray = jSONObject.optJSONArray("appData");
            if (optJSONArray == null) {
                TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
                a(-1);
                AppMethodBeat.o(222159);
                return -1;
            }
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                String optString = jSONObject2.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                TXCLog.i("LicenceCheck", "verifyLicence, packageName:".concat(String.valueOf(optString)));
                if (!optString.equals(this.f381a.getPackageName())) {
                    TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
                } else {
                    z2 = true;
                    if (!d(jSONObject2.optString("endDate"))) {
                        z3 = true;
                        z4 = a(aVar, jSONObject2, string);
                        if (z4) {
                            z4 = true;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i2++;
            }
            if (!z2) {
                a(-4);
                AppMethodBeat.o(222159);
                return -4;
            } else if (!z3) {
                a(-5);
                AppMethodBeat.o(222159);
                return -5;
            } else if (!z4) {
                a(-11);
                AppMethodBeat.o(222159);
                return -11;
            } else {
                if (!TextUtils.isEmpty(string)) {
                    try {
                        byte[] decode = Base64.decode(string, 0);
                        File externalFilesDir = this.f381a.getExternalFilesDir(null);
                        if (externalFilesDir == null) {
                            AppMethodBeat.o(222159);
                            return -10;
                        }
                        File file = new File(externalFilesDir.getAbsolutePath() + File.separator + this.f382b);
                        c.a(file.getAbsolutePath(), decode);
                        TXCCommonUtil.setPituLicencePath(file.getAbsolutePath());
                    } catch (Exception e3) {
                        TXCLog.e("LicenceCheck", "decode pitu license error:".concat(String.valueOf(e3)));
                    }
                }
                TXCDRApi.txReportDAU(this.f381a, com.tencent.liteav.basic.datareport.a.aI);
                AppMethodBeat.o(222159);
                return 0;
            }
        } catch (JSONException e4) {
            TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(e4)));
            a(-1);
            AppMethodBeat.o(222159);
            return -1;
        }
    }

    private boolean a(a aVar, JSONObject jSONObject, String str) {
        boolean z = true;
        AppMethodBeat.i(222160);
        int optInt = jSONObject.optInt("feature");
        if (aVar == this.f385f) {
            int i2 = (optInt >> 4) & 15;
            if (i2 > 0) {
                aVar.f395h = i2;
            } else {
                z = false;
            }
            TXCLog.i("LicenceCheck", "live parseVersionType, mLicenceVersionType = " + aVar.f395h);
        } else if (aVar == this.f384e) {
            int i3 = optInt & 15;
            if (i3 > 1) {
                aVar.f395h = i3;
            } else if (i3 != 1 && optInt != 0) {
                z = false;
            } else if (!TextUtils.isEmpty(str)) {
                aVar.f395h = 5;
            } else {
                aVar.f395h = 3;
            }
            TXCLog.i("LicenceCheck", "ugc parseVersionType, mLicenceVersionType = " + aVar.f395h);
        } else {
            z = false;
        }
        AppMethodBeat.o(222160);
        return z;
    }

    public int b() {
        AppMethodBeat.i(222161);
        int g2 = g(this.f385f);
        AppMethodBeat.o(222161);
        return g2;
    }

    private int g(a aVar) {
        return aVar.f395h;
    }

    private void a(int i2) {
        AppMethodBeat.i(222162);
        TXCDRApi.txReportDAU(this.f381a, com.tencent.liteav.basic.datareport.a.aJ, i2, "");
        AppMethodBeat.o(222162);
    }

    private boolean d(String str) {
        AppMethodBeat.i(222163);
        long c2 = c(str);
        if (c2 < 0) {
            TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
            AppMethodBeat.o(222163);
            return true;
        } else if (c2 < System.currentTimeMillis()) {
            TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
            AppMethodBeat.o(222163);
            return true;
        } else {
            AppMethodBeat.o(222163);
            return false;
        }
    }

    private int e(a aVar, String str) {
        AppMethodBeat.i(222164);
        String e2 = e(str);
        if (TextUtils.isEmpty(e2)) {
            TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
            AppMethodBeat.o(222164);
            return -3;
        }
        aVar.f396i = e2;
        try {
            JSONObject jSONObject = new JSONObject(e2);
            if (!jSONObject.getString("packagename").equals(a(this.f381a))) {
                TXCLog.e("LicenceCheck", "packagename not match!");
                a(-4);
                AppMethodBeat.o(222164);
                return -4;
            } else if (d(jSONObject.getString("enddate"))) {
                AppMethodBeat.o(222164);
                return -5;
            } else {
                aVar.f395h = 5;
                TXCDRApi.txReportDAU(this.f381a, com.tencent.liteav.basic.datareport.a.aI);
                AppMethodBeat.o(222164);
                return 0;
            }
        } catch (JSONException e3) {
            TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
            a(-1);
            AppMethodBeat.o(222164);
            return -1;
        }
    }

    private static String a(Context context) {
        AppMethodBeat.i(222165);
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                String str = runningAppProcessInfo.processName;
                AppMethodBeat.o(222165);
                return str;
            }
        }
        AppMethodBeat.o(222165);
        return "";
    }

    private String e(String str) {
        String str2;
        AppMethodBeat.i(222166);
        try {
            str2 = new String(h.b(Base64.decode(str, 0), Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0)));
        } catch (Exception e2) {
            TXCLog.e("LicenceCheck", "decryptLicenceStr, exception is : ".concat(String.valueOf(e2)));
            str2 = null;
        }
        AppMethodBeat.o(222166);
        return str2;
    }

    private String h(a aVar) {
        AppMethodBeat.i(222167);
        String b2 = c.b(new File(aVar.f390c + File.separator + aVar.f389b).getAbsolutePath());
        AppMethodBeat.o(222167);
        return b2;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) {
        AppMethodBeat.i(222168);
        Signature instance = Signature.getInstance("SHA256WithRSA");
        instance.initVerify(publicKey);
        instance.update(bArr);
        boolean verify = instance.verify(bArr2);
        AppMethodBeat.o(222168);
        return verify;
    }
}
