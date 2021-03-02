package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\r*\u0002H\r2\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\u000e\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000eH\u0007J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006*\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0019J%\u0010\u001a\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils;", "", "()V", "TAG", "", "moduleAliases", "", "getModuleAliases", "(Ljava/lang/Object;)[Ljava/lang/String;", "moduleName", "getModuleName", "(Ljava/lang/Object;)Ljava/lang/String;", "findModule", "M", "", "pathOrModule", "message", SharePatchInfo.FINGER_PRINT, "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "matchModule", "pathOrModuleName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Z", "sortModuleList", "splitPathPartsArray", "(Ljava/lang/String;)[Ljava/lang/String;", "startsWith", "prefixArr", "([Ljava/lang/String;[Ljava/lang/String;)Z", "WxaPkgModuleListMatcherIMPL", "luggage-wechat-full-sdk_release"})
public final class h {
    public static final h nhn = new h();

    static {
        AppMethodBeat.i(230118);
        AppMethodBeat.o(230118);
    }

    private h() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils$WxaPkgModuleListMatcherIMPL;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo$WxaPkgModuleListMatcher;", "()V", "findModule", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "moduleList", "", "pathOrModuleName", "", "message", "luggage-wechat-full-sdk_release"})
    public static final class a implements WxaPkgWrappingInfo.a {
        public static final a nho = new a();

        static {
            AppMethodBeat.i(230110);
            AppMethodBeat.o(230110);
        }

        private a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.a
        public final ModulePkgInfo b(List<? extends ModulePkgInfo> list, String str, String str2) {
            AppMethodBeat.i(230109);
            p.h(list, "moduleList");
            p.h(str, "pathOrModuleName");
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) h.d(list, str, str2);
            AppMethodBeat.o(230109);
            return modulePkgInfo;
        }
    }

    private static String cK(Object obj) {
        AppMethodBeat.i(230112);
        if (obj instanceof WxaAttributes.WxaVersionModuleInfo) {
            String str = ((WxaAttributes.WxaVersionModuleInfo) obj).name;
            AppMethodBeat.o(230112);
            return str;
        } else if (obj instanceof ModulePkgInfo) {
            String str2 = ((ModulePkgInfo) obj).name;
            AppMethodBeat.o(230112);
            return str2;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
            AppMethodBeat.o(230112);
            throw illegalStateException;
        }
    }

    public static final <M> boolean a(M m, String str, String str2) {
        AppMethodBeat.i(230113);
        p.h(str, "pathOrModuleName");
        boolean j2 = p.j(c(j.listOf(m), str, str2), m);
        AppMethodBeat.o(230113);
        return j2;
    }

    public static /* synthetic */ Object d(List list, String str, String str2) {
        AppMethodBeat.i(230115);
        Object c2 = c(list, str, str2);
        AppMethodBeat.o(230115);
        return c2;
    }

    private static <M> M c(List<? extends M> list, String str, String str2) {
        String[] strArr;
        boolean z;
        String[] strArr2;
        String cK;
        AppMethodBeat.i(230114);
        p.h(list, "$this$findModule");
        p.h(str, "pathOrModule");
        String[] acP = acP(str);
        p.h(list, "$this$sortModuleList");
        for (M m : j.a((Iterable) list, (Comparator) new b())) {
            if (m == null || (cK = cK(m)) == null || (strArr = acP(cK)) == null) {
                strArr = new String[0];
            }
            if (acP.length >= strArr.length) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (!p.j(acP[i2], strArr[i2])) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module by name:" + (m != null ? cK(m) : null) + ", path:" + str + ", message[ " + str2 + " ]");
                if (m == null) {
                    p.hyc();
                }
                AppMethodBeat.o(230114);
                return m;
            } else if (m != null) {
                if (m instanceof WxaAttributes.WxaVersionModuleInfo) {
                    strArr2 = m.aliases;
                } else if (m instanceof ModulePkgInfo) {
                    strArr2 = m.aliases;
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
                    AppMethodBeat.o(230114);
                    throw illegalStateException;
                }
                if (strArr2 != null) {
                    for (String str3 : strArr2) {
                        String str4 = str3;
                        if (!(str4 == null || str4.length() == 0) && n.J(str, str3, false)) {
                            Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module by alias:" + str3 + ", path:" + str + ", message[ " + str2 + " ]");
                            AppMethodBeat.o(230114);
                            return m;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, return null with path:" + str + ", message[ " + str2 + " ]");
        AppMethodBeat.o(230114);
        return null;
    }

    private static String[] acP(String str) {
        AppMethodBeat.i(230117);
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = 0;
                break;
            } else if (str.charAt(i2) != '/') {
                break;
            } else {
                i2++;
            }
        }
        int length2 = str.length();
        int length3 = str.length() - 1;
        while (length3 >= 0 && str.charAt(length3) == '/') {
            length2--;
            length3--;
        }
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(230117);
            throw tVar;
        }
        String substring = str.substring(i2, length2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Object[] array = n.a(substring, new String[]{FilePathGenerator.ANDROID_DIR_SEP}).toArray(new String[0]);
        if (array == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(230117);
            throw tVar2;
        }
        String[] strArr = (String[]) array;
        AppMethodBeat.o(230117);
        return strArr;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int length;
            int length2;
            AppMethodBeat.i(230111);
            if (t2 instanceof WxaAttributes.WxaVersionModuleInfo) {
                length = t2.name.length();
            } else if (t2 instanceof ModulePkgInfo) {
                length = t2.name.length();
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
                AppMethodBeat.o(230111);
                throw illegalStateException;
            }
            Integer valueOf = Integer.valueOf(length);
            if (t instanceof WxaAttributes.WxaVersionModuleInfo) {
                length2 = t.name.length();
            } else if (t instanceof ModulePkgInfo) {
                length2 = t.name.length();
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
                AppMethodBeat.o(230111);
                throw illegalStateException2;
            }
            int a2 = kotlin.b.a.a(valueOf, Integer.valueOf(length2));
            AppMethodBeat.o(230111);
            return a2;
        }
    }

    public static final <M> M e(List<? extends M> list, String str, String str2) {
        AppMethodBeat.i(230116);
        M m = (M) c(list, str, str2);
        AppMethodBeat.o(230116);
        return m;
    }
}
