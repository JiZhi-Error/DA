package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public final class s {
    private static final LinkedList<String> ogX = new LinkedList<>();

    public interface a {
        void du(String str);

        void onSuccess(String str);
    }

    public interface b extends a {
        void a(m.c cVar);
    }

    static {
        AppMethodBeat.i(135375);
        AppMethodBeat.o(135375);
    }

    public static void afK(String str) {
        AppMethodBeat.i(135370);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(135370);
            return;
        }
        synchronized (ogX) {
            try {
                ogX.add(str);
            } finally {
                AppMethodBeat.o(135370);
            }
        }
    }

    public static String bZs() {
        AppMethodBeat.i(135371);
        String format = String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", 11111);
        AppMethodBeat.o(135371);
        return format;
    }

    public static void a(i iVar, String str, a aVar) {
        AppMethodBeat.i(135372);
        a(iVar, (URL) null, str, aVar);
        AppMethodBeat.o(135372);
    }

    public static void a(i iVar, URL url, String str, final a aVar) {
        boolean z;
        AppMethodBeat.i(219592);
        if (Util.isNullOrNil(str)) {
            if (aVar != null) {
                aVar.du("isNullOrNil script");
            }
            AppMethodBeat.o(219592);
            return;
        }
        synchronized (ogX) {
            try {
                Iterator<String> it = ogX.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.startsWith(it.next())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(219592);
                throw th;
            }
        }
        if (z) {
            str = str + bZs();
        }
        AnonymousClass1 r0 = new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.utils.s.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(135366);
                String str2 = str;
                if (str2 == null || !str2.contains("11111")) {
                    if (aVar != null) {
                        aVar.du(str2);
                        AppMethodBeat.o(135366);
                        return;
                    }
                } else if (aVar != null) {
                    aVar.onSuccess(str2);
                }
                AppMethodBeat.o(135366);
            }
        };
        if (url == null) {
            iVar.evaluateJavascript(str, r0);
            AppMethodBeat.o(219592);
            return;
        }
        iVar.a(url, str, r0);
        AppMethodBeat.o(219592);
    }

    @SuppressLint({"DefaultLocale"})
    public static void a(i iVar, final String str, String str2, String str3, int i2, String str4, String str5, final a aVar) {
        AppMethodBeat.i(135373);
        Log.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", str);
        final long currentTimeMillis = System.currentTimeMillis();
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.JsValidationInjector", "hy: empty script!");
            if (aVar != null) {
                aVar.du("isNullOrNil script");
            }
            AppMethodBeat.o(135373);
            return;
        }
        String str6 = (str4 + String.format("\n;(function(){return %d;})();", 11111)) + Util.nullAsNil(str5);
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(str);
                }
            } catch (MalformedURLException e2) {
                Log.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
                aVar.du("MalformedURLException");
                AppMethodBeat.o(135373);
                return;
            }
        }
        v vVar = (v) iVar.R(v.class);
        if (vVar != null) {
            vVar.a(url, str2, str3, i2, str6, new m.b() {
                /* class com.tencent.mm.plugin.appbrand.utils.s.AnonymousClass2 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(135367);
                    s.a(str, aVar, str, currentTimeMillis);
                    if (aVar instanceof b) {
                        ((b) aVar).a(cVar);
                    }
                    AppMethodBeat.o(135367);
                }
            });
            AppMethodBeat.o(135373);
        } else if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            iVar.a(url, str6, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.utils.s.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(135368);
                    s.a(str, aVar, str, currentTimeMillis);
                    AppMethodBeat.o(135368);
                }
            });
            AppMethodBeat.o(135373);
        } else {
            iVar.a(url, str2, str3, i2, str6, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.utils.s.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(135369);
                    s.a(str, aVar, str, currentTimeMillis);
                    AppMethodBeat.o(135369);
                }
            });
            AppMethodBeat.o(135373);
        }
    }

    public static void a(i iVar, ArrayList<ScriptPartObject> arrayList, String str, String str2, String str3, final a aVar) {
        AnonymousClass5 r5;
        String str4;
        String str5;
        AppMethodBeat.i(176788);
        if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.JsValidationInjector", "empty script list, abort");
            AppMethodBeat.o(176788);
            return;
        }
        String str6 = null;
        final String str7 = null;
        String str8 = null;
        Iterator<ScriptPartObject> it = arrayList.iterator();
        while (it.hasNext()) {
            ScriptPartObject next = it.next();
            if (next.type == 2) {
                String str9 = next.wxaPkgPath;
                String str10 = next.wxaFileName;
                str4 = next.wxaPkgKeyFilePath;
                Log.i("MicroMsg.JsValidationInjector", " contain wxa pkg: %s, file: %s", str9, str10);
                str5 = str10;
                str6 = str9;
            } else {
                str4 = str8;
                str5 = str7;
            }
            str8 = str4;
            str7 = str5;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (Util.isNullOrNil(str6) || Util.isNullOrNil(str7) || Util.isNullOrNil(str8)) {
            Log.e("MicroMsg.JsValidationInjector", "empty wxa path or file path or key path!");
            if (aVar != null) {
                aVar.du("isNullOrNil empty path");
            }
            AppMethodBeat.o(176788);
            return;
        }
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(str);
                }
            } catch (MalformedURLException e2) {
                Log.e("MicroMsg.JsValidationInjector", "MalformedURLException");
                aVar.du("MalformedURLException");
                AppMethodBeat.o(176788);
                return;
            }
        }
        ScriptPartObject scriptPartObject = new ScriptPartObject();
        scriptPartObject.type = 1;
        scriptPartObject.content = String.format(Locale.US, "\n;(function(){return %d;})();", 11111);
        arrayList.add(scriptPartObject);
        v vVar = (v) iVar.R(v.class);
        if (vVar == null) {
            Assert.fail("Only addonV8 supports wxa script");
            AppMethodBeat.o(176788);
            return;
        }
        if (aVar == null) {
            r5 = null;
        } else {
            r5 = new m.b() {
                /* class com.tencent.mm.plugin.appbrand.utils.s.AnonymousClass5 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(176787);
                    s.a(str7, aVar, str, currentTimeMillis);
                    if (aVar instanceof b) {
                        ((b) aVar).a(cVar);
                    }
                    AppMethodBeat.o(176787);
                }
            };
        }
        vVar.a(arrayList, url, str2, str3, r5);
        AppMethodBeat.o(176788);
    }

    static /* synthetic */ void a(String str, a aVar, String str2, long j2) {
        AppMethodBeat.i(135374);
        if (str2 == null || !str2.contains("11111")) {
            if (aVar != null) {
                Log.e("MicroMsg.JsValidationInjector", "hy: file %s inject failed!", str);
                aVar.du(str2);
                AppMethodBeat.o(135374);
                return;
            }
        } else if (aVar != null) {
            Log.i("MicroMsg.JsValidationInjector", "hy: file %s inject success! cost:%d", str, Long.valueOf(System.currentTimeMillis() - j2));
            aVar.onSuccess(str2);
        }
        AppMethodBeat.o(135374);
    }
}
