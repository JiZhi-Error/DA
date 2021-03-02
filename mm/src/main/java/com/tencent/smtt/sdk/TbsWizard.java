package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

public class TbsWizard {
    public static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";

    /* renamed from: a  reason: collision with root package name */
    private Context f1892a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1893b;

    /* renamed from: c  reason: collision with root package name */
    private String f1894c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f1895d;

    /* renamed from: e  reason: collision with root package name */
    private DexLoader f1896e;

    /* renamed from: f  reason: collision with root package name */
    private String f1897f;

    public TbsWizard(Context context) {
        AppMethodBeat.i(54635);
        this.f1892a = null;
        this.f1893b = null;
        this.f1894c = null;
        this.f1895d = null;
        this.f1896e = null;
        this.f1897f = null;
        this.f1896e = TbsOneGreyInfoHelper.getDexloader();
        libwebp.loadWepLibraryIfNeed(context, this.f1894c);
        a();
        b(context);
        AppMethodBeat.o(54635);
    }

    public TbsWizard(Context context, Context context2, String str, String str2, String[] strArr, String str3, p pVar) {
        AppMethodBeat.i(188068);
        this.f1892a = null;
        this.f1893b = null;
        this.f1894c = null;
        this.f1895d = null;
        this.f1896e = null;
        this.f1897f = null;
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            Exception exc = new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
            AppMethodBeat.o(188068);
            throw exc;
        }
        this.f1892a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.f1893b = context2.getApplicationContext();
        } else {
            this.f1893b = context2;
        }
        this.f1894c = str;
        this.f1895d = strArr;
        if (pVar != null) {
            pVar.a("load_tbs_dex", (byte) 1);
        }
        for (int i2 = 0; i2 < this.f1895d.length; i2++) {
            TbsLog.i("TbsWizard", "#2 mDexFileList[" + i2 + "]: " + this.f1895d[i2]);
        }
        TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f1892a + " dexOutPutDir is " + str2);
        this.f1896e = new DexLoader(str3, this.f1892a, this.f1895d, str2, QbSdk.mSettings);
        TbsOneGreyInfoHelper.init(this.f1896e, context, context2, str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        a(context);
        new StringBuilder("checkTbsValidityIfNecessary ").append(System.currentTimeMillis() - currentTimeMillis);
        if (pVar != null) {
            pVar.a("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.f1894c);
        a();
        if (pVar != null) {
            pVar.a("init_tbs", (byte) 1);
        }
        int b2 = b(context);
        if (pVar != null) {
            pVar.a("init_tbs", (byte) 2);
        }
        if (b2 < 0) {
            Exception exc2 = new Exception("TbsWizard init error: " + b2 + "; msg: " + this.f1897f);
            AppMethodBeat.o(188068);
            throw exc2;
        }
        TbsLog.i("TbsWizard", "construction end...");
        AppMethodBeat.o(188068);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r5) {
        /*
            r4 = this;
            r3 = 54637(0xd56d, float:7.6563E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r1 = 1
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.tencent.smtt.sdk.QbSdk.mSettings
            if (r0 == 0) goto L_0x0025
            java.lang.String r2 = "check_tbs_validity"
            java.lang.Object r0 = r0.get(r2)
            boolean r2 = r0 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x0025
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            com.tencent.smtt.utils.m.b(r5)
        L_0x0021:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x0025:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsWizard.a(android.content.Context):void");
    }

    private void a() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(54638);
        if (QbSdk.mSettings != null) {
            try {
                z = TbsPVConfig.getInstance(this.f1892a).getTbsCoreSandboxModeEnable();
            } catch (Throwable th) {
                z = false;
            }
            try {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(String.valueOf(QbSdk.mSettings.get(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)))) {
                    z2 = true;
                    Map<String, Object> map = QbSdk.mSettings;
                    if (!z || !z2) {
                        z3 = false;
                    }
                    map.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z3));
                    TbsOneGreyInfoHelper.getCoreEntry().initSettings(QbSdk.mSettings);
                }
            } catch (Throwable th2) {
            }
            z2 = false;
            Map<String, Object> map2 = QbSdk.mSettings;
            z3 = false;
            map2.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z3));
            TbsOneGreyInfoHelper.getCoreEntry().initSettings(QbSdk.mSettings);
        }
        AppMethodBeat.o(54638);
    }

    private int b(Context context) {
        AppMethodBeat.i(54639);
        TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionCode(TbsConfig.TBS_SDK_VERSIONCODE);
        TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionName(TbsConfig.TBS_SDK_VERSIONNAME);
        TbsOneGreyInfoHelper.getCoreEntry().initRuntimeEnvironment();
        AppMethodBeat.o(54639);
        return 0;
    }

    public String getCrashExtraMessage() {
        AppMethodBeat.i(54640);
        try {
            String crashExtraMessage = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getCrashExtraMessage();
            AppMethodBeat.o(54640);
            return crashExtraMessage;
        } catch (Exception e2) {
            AppMethodBeat.o(54640);
            return "";
        }
    }

    public DexLoader dexLoader() {
        return this.f1896e;
    }
}
