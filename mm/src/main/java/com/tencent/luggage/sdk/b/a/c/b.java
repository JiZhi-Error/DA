package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<SERVICE extends s> implements d, w.b {
    protected final SERVICE cAJ;
    private final t cAK;
    private final g cAL;

    /* access modifiers changed from: protected */
    public abstract String MK();

    /* access modifiers changed from: protected */
    public abstract int a(SERVICE service);

    /* access modifiers changed from: protected */
    public abstract String b(SERVICE service);

    protected b(SERVICE service, t tVar) {
        this.cAJ = service;
        this.cAK = tVar;
        this.cAL = tVar.bME();
    }

    @JavascriptInterface
    public final int allocEmpty() {
        JSONObject Or;
        final g MI = MI();
        if (MI == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", this.cAJ.getAppId());
            return -2;
        }
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", Integer.valueOf(MI.bMC()));
        MI.setJsExceptionHandler(new h() {
            /* class com.tencent.luggage.sdk.b.a.c.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(146788);
                Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", str, str2);
                cy.a(MI, "onError", String.format("{'message':'%s', 'stack': '%s'}", r.afJ(str), r.afJ(str2)));
                com.tencent.mm.plugin.appbrand.aa.b unused = b.a.nOf;
                com.tencent.mm.plugin.appbrand.aa.b.N(KSProcessWeAppLaunch.NAME, str, str2);
                AppMethodBeat.o(146788);
            }
        });
        this.cAL.b(MI, "WeixinJSContext");
        if (this.cAJ.getRuntime() == null) {
            Or = this.cAJ.bte();
        } else {
            Or = this.cAJ.Or();
        }
        MI.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", Or.toString()), null);
        return MI.bMC();
    }

    @JavascriptInterface
    public final int alloc() {
        int allocEmpty = allocEmpty();
        if (allocEmpty <= 0) {
            return allocEmpty;
        }
        g hQ = hQ(allocEmpty);
        try {
            try {
                a(hQ, MK(), b(this.cAJ));
                return hQ.bMC();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e2, "alloc::injectSdkScript::" + MK(), new Object[0]);
                throw e2;
            }
        } catch (aq e3) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "= getSubContextSDKScript %s", e3.getMessage());
            return 0;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e4, "getSubContextSDKScript", new Object[0]);
            throw e4;
        }
    }

    @JavascriptInterface
    public void loadLibFiles(int i2, String str) {
        g hQ = hQ(i2);
        if (hQ == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL context by id[%d], appId[%s]", Integer.valueOf(i2), this.cAJ.getAppId());
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ICommLibReader bqZ = this.cAJ.bqZ();
            if (bqZ == null) {
                Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL LibReader, id[%d], appId[%s]", Integer.valueOf(i2), this.cAJ.getAppId());
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (TextUtils.isEmpty(optString)) {
                    Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY name by index[%d] id[%d] appId[%s]", Integer.valueOf(i3), Integer.valueOf(i2), this.cAJ.getAppId());
                } else {
                    String UM = bqZ.UM(optString);
                    if (TextUtils.isEmpty(UM)) {
                        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY script by name[%s] id[%d] appId[%s]", optString, Integer.valueOf(i2), this.cAJ.getAppId());
                    } else {
                        try {
                            a(hQ, (String) Objects.requireNonNull(optString), (String) Objects.requireNonNull(UM));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e2, "loadLibFiles::injectSdkScript::".concat(String.valueOf(optString)), new Object[0]);
                            throw e2;
                        }
                    }
                }
            }
        } catch (JSONException e3) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles parse paths failed, id[%d] appId[%s] e=%s", Integer.valueOf(i2), this.cAJ.getAppId(), e3);
        }
    }

    @JavascriptInterface
    public final int create(String str) {
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", this.cAJ.getAppId(), str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", this.cAJ.getAppId());
            return -1;
        }
        int alloc = alloc();
        if (alloc <= 0) {
            return alloc;
        }
        g xX = this.cAK.xX(alloc);
        int evaluateScriptFile = evaluateScriptFile(alloc, str);
        if (evaluateScriptFile != 1) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", this.cAJ.getAppId(), str, Integer.valueOf(evaluateScriptFile));
            return -1;
        }
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", this.cAJ.getAppId(), str, Integer.valueOf(xX.bMC()));
        return xX.bMC();
    }

    @JavascriptInterface
    public final int evaluateScriptFile(int i2, String str) {
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", this.cAJ.getAppId(), Integer.valueOf(i2), str);
        g xX = this.cAK.xX(i2);
        if (xX == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", this.cAJ.getAppId(), Integer.valueOf(i2), str);
            return -1;
        } else if (xX.bMB()) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", this.cAJ.getAppId(), str);
            return -1;
        } else {
            a(this.cAJ, xX);
            if (this.cAJ.getJsRuntime().R(v.class) == null) {
                Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", this.cAJ.getAppId(), Integer.valueOf(i2), str);
                try {
                    String a2 = a(this.cAJ, str);
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        final PBool pBool = new PBool();
                        final i iVar = new i();
                        AppBrandRuntime runtime = this.cAJ.getRuntime();
                        String str2 = str.replace('/', '_') + "_" + this.cAJ.getAppId();
                        String str3 = this.cAJ.getRuntime().OT().leE.md5;
                        t.a aVar = t.a.USR;
                        AnonymousClass3 r10 = new s.b() {
                            /* class com.tencent.luggage.sdk.b.a.c.b.AnonymousClass3 */

                            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.appbrand.v8.m$c */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.tencent.mm.plugin.appbrand.utils.s.b
                            public final void a(m.c cVar) {
                                iVar.value = cVar;
                            }

                            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                            public final void onSuccess(String str) {
                                pBool.value = true;
                            }

                            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                            public final void du(String str) {
                                pBool.value = false;
                            }
                        };
                        if (runtime == null || runtime.NY() == null) {
                            Log.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
                        } else {
                            String a3 = bc.a(runtime, str, com.tencent.mm.plugin.appbrand.utils.t.a(runtime.NY(), aVar));
                            if (!Util.isNullOrNil(a3)) {
                                com.tencent.mm.plugin.appbrand.utils.s.a(xX, a3, null);
                            }
                            com.tencent.mm.plugin.appbrand.utils.t.a(runtime.NY(), xX, str, str2, str3, 0, a2, aVar, r10);
                        }
                        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", this.cAJ.getAppId(), Integer.valueOf(xX.bMC()), str, Boolean.valueOf(pBool.value));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        d.a aVar2 = new d.a();
                        aVar2.scriptName = str;
                        aVar2.czz = a2;
                        aVar2.czA = Util.nullAsNil(a2).length();
                        a(aVar2, pBool.value, currentTimeMillis, currentTimeMillis2, iVar.value);
                        return 1;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e2, "evaluateScriptFile::injectAppScript::".concat(String.valueOf(str)), new Object[0]);
                        throw e2;
                    }
                } catch (aq e3) {
                    Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", this.cAJ.getAppId(), Integer.valueOf(i2), str, e3.getMessage());
                    return 0;
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e4, "getSubContextAppScript", new Object[0]);
                    throw e4;
                }
            } else {
                try {
                    return a(xX, str) > 0 ? 1 : 0;
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", e5, "evaluateScriptFile::injectWxaScript::".concat(String.valueOf(str)), new Object[0]);
                    throw e5;
                }
            }
        }
    }

    @JavascriptInterface
    public void loadJsFilesWithOptions(final int i2, final String str, final String str2) {
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] paths[%s] options[%s]", this.cAJ.getAppId(), Integer.valueOf(i2), str, str2);
        g xX = this.cAK.xX(i2);
        if (xX == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] get NULL context", this.cAJ.getAppId(), Integer.valueOf(i2));
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject = new JSONObject(str2);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse options appId[%s] contextId[%d] options[%s] e=%s", this.cAJ.getAppId(), Integer.valueOf(i2), str2, e2);
                jSONObject = null;
            }
            Util.nowMilliSecond();
            try {
                w.a(this.cAJ.getRuntime(), jSONArray, xX, this.cAJ.bqY(), jSONObject == null ? null : jSONObject.optString("key"), new w.b() {
                    /* class com.tencent.luggage.sdk.b.a.c.b.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.w.b
                    public final void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3) {
                        AppMethodBeat.i(229850);
                        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s] results[%s]", b.this.cAJ.getAppId(), Integer.valueOf(i2), str, str2, Arrays.toString(zArr));
                        b.this.a(str, aVarArr, zArr, objArr, j2, j3);
                        AppMethodBeat.o(229850);
                    }
                });
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s], get exception %s", this.cAJ.getAppId(), Integer.valueOf(i2), str, str2, th);
            }
        } catch (JSONException e3) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse json appId[%s] context[%d] e=%s", this.cAJ.getAppId(), Integer.valueOf(i2), e3);
        }
    }

    @JavascriptInterface
    public final void destroy(int i2) {
        this.cAK.xY(i2);
    }

    /* access modifiers changed from: protected */
    public void MJ() {
        this.cAK.bMD().b(this.cAL, "WeixinJSContext");
    }

    /* access modifiers changed from: protected */
    public g MI() {
        return this.cAK.bME();
    }

    /* access modifiers changed from: protected */
    public int Mz() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int a(g gVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        final PBool pBool = new PBool();
        final PInt pInt = new PInt();
        com.tencent.mm.plugin.appbrand.appcache.r M = bg.M(this.cAJ.getRuntime());
        if (M == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", this.cAJ.getAppId(), str);
            return 0;
        }
        q.a UV = M.UV(str);
        if (UV == null) {
            Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", this.cAJ.getAppId(), str);
            return 0;
        }
        final i iVar = new i();
        com.tencent.mm.plugin.appbrand.utils.t.a(this.cAJ.getRuntime(), gVar, str, UV, new s.b() {
            /* class com.tencent.luggage.sdk.b.a.c.b.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                pBool.value = true;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                pBool.value = false;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.appbrand.v8.m$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.plugin.appbrand.utils.s.b
            public final void a(m.c cVar) {
                iVar.value = cVar;
                pInt.value = cVar.sourceLength;
            }
        });
        Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b), entry(%s)", this.cAJ.getAppId(), Integer.valueOf(gVar.bMC()), str, Boolean.valueOf(pBool.value), String.format(Locale.ENGLISH, "FileEntry{providerId:%s, appVersion:%d, appVersionStr:%s, fileName:%s, fileOffset:%d, fileLength:%d}", UV.kKF, Integer.valueOf(UV.appVersion), UV.kKG, UV.fileName, Integer.valueOf(UV.kKJ), Integer.valueOf(UV.kKK)));
        long currentTimeMillis2 = System.currentTimeMillis();
        d.a aVar = new d.a();
        aVar.scriptName = str;
        aVar.czz = null;
        aVar.czA = pInt.value;
        aVar.kKF = UV.kKF;
        aVar.appVersion = UV.appVersion;
        a(aVar, pBool.value, currentTimeMillis, currentTimeMillis2, iVar.value);
        return pInt.value;
    }

    private void a(g gVar, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        final PBool pBool = new PBool();
        final i iVar = new i();
        com.tencent.mm.plugin.appbrand.utils.t.a(this.cAJ, gVar, str, str, "v" + a(this.cAJ), Mz(), str2, t.a.LIB, new s.b() {
            /* class com.tencent.luggage.sdk.b.a.c.b.AnonymousClass5 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.appbrand.v8.m$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.plugin.appbrand.utils.s.b
            public final void a(m.c cVar) {
                iVar.value = cVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                pBool.value = true;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                pBool.value = false;
            }
        });
        long currentTimeMillis2 = System.currentTimeMillis();
        d.a aVar = new d.a();
        aVar.scriptName = str;
        aVar.czz = str2;
        aVar.czA = str2.length();
        a(aVar, pBool.value, currentTimeMillis, currentTimeMillis2, iVar.value);
    }

    /* access modifiers changed from: protected */
    public final SERVICE NY() {
        return this.cAJ;
    }

    private g hQ(int i2) {
        return this.cAK.xX(i2);
    }

    /* access modifiers changed from: protected */
    public void a(SERVICE service, g gVar) {
    }

    /* access modifiers changed from: protected */
    public String a(SERVICE service, String str) {
        String d2 = bg.d(service.getRuntime(), str);
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        throw new aq(str);
    }

    public void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.w.b
    public void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3) {
    }
}
