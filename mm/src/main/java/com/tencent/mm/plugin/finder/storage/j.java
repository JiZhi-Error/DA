package com.tencent.mm.plugin.finder.storage;

import android.os.Build;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "", "jsonStr", "", "(Ljava/lang/String;)V", "configList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "getConfigList", "()Ljava/util/List;", "Companion", "Config", "plugin-finder_release"})
public final class j {
    private static final String TAG = TAG;
    private static boolean vDC;
    public static final a vDD = new a((byte) 0);
    final List<b> vDB = new ArrayList();

    public j(String str) {
        p.h(str, "jsonStr");
        AppMethodBeat.i(166964);
        try {
            f FI = new i(str).FI("configs");
            if (FI != null) {
                int length = FI.length();
                for (int i2 = 0; i2 < length; i2++) {
                    i pZ = FI.pZ(i2);
                    String optString = pZ.optString("brands");
                    String optString2 = pZ.optString("models");
                    int optInt = pZ.optInt("maxSize", 0);
                    if (optInt > 0) {
                        List<b> list = this.vDB;
                        p.g(optString, "brands");
                        p.g(optString2, "models");
                        list.add(new b(optString, optString2, optInt));
                    }
                }
                AppMethodBeat.o(166964);
                return;
            }
            AppMethodBeat.o(166964);
        } catch (Throwable th) {
            AppMethodBeat.o(166964);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugEnable", "", "getDebugEnable", "()Z", "setDebugEnable", "(Z)V", "getConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "hitConfig", "videoSize", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean KY(int i2) {
            AppMethodBeat.i(166959);
            String str = Build.BRAND;
            p.g(str, "Build.BRAND");
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(166959);
                throw tVar;
            }
            String lowerCase = str.toLowerCase();
            p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            String str2 = Build.MODEL;
            p.g(str2, "Build.MODEL");
            if (str2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(166959);
                throw tVar2;
            }
            String lowerCase2 = str2.toLowerCase();
            p.g(lowerCase2, "(this as java.lang.String).toLowerCase()");
            c cVar = c.vCb;
            String drK = c.drK();
            p.g(drK, "FinderConfig.FAKE_VIDEO_CONFIG_JSON");
            for (T t : new j(drK).vDB) {
                if ((n.a((CharSequence) t.vDE, (CharSequence) lowerCase, false) || n.a((CharSequence) t.vDF, (CharSequence) lowerCase2, false) || Util.isNullOrNil(t.vDE)) && i2 > t.maxSize && t.maxSize > 0) {
                    a aVar = j.vDD;
                    Log.i(j.TAG, "hitConfig brand:" + lowerCase + ", model:" + lowerCase2 + ", videoSize:" + i2 + "; config brands:" + t.vDE + ", models:" + t.vDF + ", maxSize:" + t.maxSize);
                    AppMethodBeat.o(166959);
                    return true;
                }
            }
            if (Log.getLogLevel() <= 1) {
                boolean z = j.vDC;
                AppMethodBeat.o(166959);
                return z;
            }
            AppMethodBeat.o(166959);
            return false;
        }
    }

    static {
        AppMethodBeat.i(166965);
        AppMethodBeat.o(166965);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "", "brands", "", "models", "maxSize", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBrands", "()Ljava/lang/String;", "getMaxSize", "()I", "getModels", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class b {
        final int maxSize;
        final String vDE;
        final String vDF;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.maxSize == r4.maxSize) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 166963(0x28c33, float:2.33965E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.storage.j.b
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.finder.storage.j$b r4 = (com.tencent.mm.plugin.finder.storage.j.b) r4
                java.lang.String r0 = r3.vDE
                java.lang.String r1 = r4.vDE
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.vDF
                java.lang.String r1 = r4.vDF
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                int r0 = r3.maxSize
                int r1 = r4.maxSize
                if (r0 != r1) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.j.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(166962);
            String str = this.vDE;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.vDF;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = ((hashCode + i2) * 31) + this.maxSize;
            AppMethodBeat.o(166962);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(166961);
            String str = "Config(brands=" + this.vDE + ", models=" + this.vDF + ", maxSize=" + this.maxSize + ")";
            AppMethodBeat.o(166961);
            return str;
        }

        public b(String str, String str2, int i2) {
            p.h(str, "brands");
            p.h(str2, "models");
            AppMethodBeat.i(166960);
            this.vDE = str;
            this.vDF = str2;
            this.maxSize = i2;
            AppMethodBeat.o(166960);
        }
    }
}
