package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kl;
import com.tencent.mm.g.b.a.km;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003#$%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0007J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u001f\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010 \u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\f\u0010\"\u001a\u00020\b*\u00020\u0016H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", ch.COL_USERNAME, "appId", "checkLaunchTimeoutStrategy", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "", "markLaunchFailedByUpdateWxaAttrs", "markLaunchSucceed", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"})
public final class an {
    private static final ConcurrentHashMap<a, WxaAttributes> mVT = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<a, Long> mVU = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<a, Long> mVV = new ConcurrentHashMap<>();
    public static final an mVW = new an();

    static {
        AppMethodBeat.i(228724);
        AppMethodBeat.o(228724);
    }

    private an() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0007J \u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportFallbackSceneStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "FallbackActionReportStructStore", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "setFallbackScene", "scene", "FallbackScene", "plugin-appbrand-integration_release"})
    public static final class b {
        private static final ConcurrentHashMap<String, km> mVX = new ConcurrentHashMap<>();
        private static final ConcurrentHashMap<String, Integer> mVY = new ConcurrentHashMap<>();
        public static final b mVZ = new b();

        static {
            AppMethodBeat.i(228709);
            AppMethodBeat.o(228709);
        }

        private b() {
        }

        public static final void a(String str, km kmVar) {
            AppMethodBeat.i(228706);
            p.h(str, "instanceId");
            p.h(kmVar, "reportStruct");
            mVX.put(str, kmVar);
            AppMethodBeat.o(228706);
        }

        public static final void bV(String str, int i2) {
            AppMethodBeat.i(228707);
            p.h(str, "instanceId");
            mVY.put(str, Integer.valueOf(i2));
            AppMethodBeat.o(228707);
        }

        public static final void b(String str, boolean z, long j2) {
            AppMethodBeat.i(228708);
            p.h(str, "instanceId");
            km remove = mVX.remove(str);
            if (remove == null) {
                AppMethodBeat.o(228708);
                return;
            }
            p.g(remove, "FallbackActionReportStru…ove(instanceId) ?: return");
            kl klVar = new kl();
            klVar.xK(remove.getAppid());
            klVar.xL(remove.getUsername());
            klVar.xM(remove.aiv());
            klVar.tC(remove.aip());
            klVar.tD(remove.aiq());
            klVar.tE(remove.air());
            klVar.tF((long) (z ? 1 : 0));
            klVar.tG(j2);
            klVar.tH(remove.ais());
            klVar.xN(remove.ait());
            klVar.tI(remove.aiu());
            Integer remove2 = mVY.remove(str);
            if (remove2 == null) {
                remove2 = 10000;
            }
            klVar.tJ((long) remove2.intValue());
            klVar.bfK();
            AppMethodBeat.o(228708);
        }
    }

    public static final void h(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(228712);
        p.h(wxaAttributes, "wxaAttributes");
        String str = wxaAttributes.field_username;
        p.g(str, "wxaAttributes.field_username");
        mVT.put(new a.b(str), wxaAttributes);
        String str2 = wxaAttributes.field_appId;
        p.g(str2, "wxaAttributes.field_appId");
        mVT.put(new a.C0733a(str2), wxaAttributes);
        AppMethodBeat.o(228712);
    }

    public static final void ee(String str, String str2) {
        boolean z;
        AppMethodBeat.i(228713);
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            mVT.remove(new a.b(str));
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            mVT.remove(new a.C0733a(str2));
        }
        AppMethodBeat.o(228713);
    }

    public static final WxaAttributes ace(String str) {
        AppMethodBeat.i(228714);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228714);
            return null;
        }
        WxaAttributes wxaAttributes = mVT.get(new a.b(str));
        AppMethodBeat.o(228714);
        return wxaAttributes;
    }

    private static WxaAttributes.c.a a(a aVar, String str, boolean z) {
        WxaAttributes.c.a aVar2;
        z buC;
        WxaAttributes e2;
        WxaAttributes.c bAo;
        WxaAttributes.c bAo2;
        AppMethodBeat.i(228715);
        WxaAttributes wxaAttributes = mVT.get(aVar);
        if (wxaAttributes == null || (bAo2 = wxaAttributes.bAo()) == null || (aVar2 = bAo2.lgD) == null) {
            if (z && (buC = n.buC()) != null) {
                if (aVar instanceof a.b) {
                    e2 = buC.d(((a.b) aVar).value, "dynamicInfo");
                } else if (aVar instanceof a.C0733a) {
                    e2 = buC.e(((a.C0733a) aVar).value, "dynamicInfo");
                } else {
                    m mVar = new m();
                    AppMethodBeat.o(228715);
                    throw mVar;
                }
                if (!(e2 == null || (bAo = e2.bAo()) == null)) {
                    aVar2 = bAo.lgD;
                }
            }
            aVar2 = null;
        }
        if (aVar2 != null) {
            Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "getDynamicSettings with key:" + aVar + ", reason:" + str + ", get settings:" + a(aVar2));
            AppMethodBeat.o(228715);
            return aVar2;
        }
        AppMethodBeat.o(228715);
        return null;
    }

    private static String a(WxaAttributes.c.a aVar) {
        AppMethodBeat.i(228716);
        String str = "{OpenWxaWaitUpdateMaxMicSec:" + aVar.lgK + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + aVar.lgL + ", NextTryOpenWxaDisMicSec:" + aVar.lgN + '}';
        AppMethodBeat.o(228716);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"})
    public static abstract class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
        public static final class b extends a {
            final String value;

            public final String toString() {
                AppMethodBeat.i(228705);
                String str = "USERNAME(value=" + this.value + ")";
                AppMethodBeat.o(228705);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super((byte) 0);
                p.h(str, "value");
                AppMethodBeat.i(228704);
                this.value = str;
                AppMethodBeat.o(228704);
            }

            public final int hashCode() {
                AppMethodBeat.i(228702);
                int hashCode = this.value.hashCode();
                AppMethodBeat.o(228702);
                return hashCode;
            }

            public final boolean equals(Object obj) {
                AppMethodBeat.i(228703);
                if (this == obj) {
                    AppMethodBeat.o(228703);
                    return true;
                }
                if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
                    AppMethodBeat.o(228703);
                    return false;
                } else if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
                    AppMethodBeat.o(228703);
                    throw tVar;
                } else if (!p.j(this.value, ((b) obj).value)) {
                    AppMethodBeat.o(228703);
                    return false;
                } else {
                    AppMethodBeat.o(228703);
                    return true;
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.an$a$a  reason: collision with other inner class name */
        public static final class C0733a extends a {
            final String value;

            public final String toString() {
                AppMethodBeat.i(228701);
                String str = "APPID(value=" + this.value + ")";
                AppMethodBeat.o(228701);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0733a(String str) {
                super((byte) 0);
                p.h(str, "value");
                AppMethodBeat.i(228700);
                this.value = str;
                AppMethodBeat.o(228700);
            }

            public final int hashCode() {
                AppMethodBeat.i(228698);
                int hashCode = this.value.hashCode();
                AppMethodBeat.o(228698);
                return hashCode;
            }

            public final boolean equals(Object obj) {
                AppMethodBeat.i(228699);
                if (this == obj) {
                    AppMethodBeat.o(228699);
                    return true;
                }
                if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
                    AppMethodBeat.o(228699);
                    return false;
                } else if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
                    AppMethodBeat.o(228699);
                    throw tVar;
                } else if (!p.j(this.value, ((C0733a) obj).value)) {
                    AppMethodBeat.o(228699);
                    return false;
                } else {
                    AppMethodBeat.o(228699);
                    return true;
                }
            }
        }
    }

    public static final boolean bNJ() {
        AppMethodBeat.i(228717);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_launch_fallback_by_backup_wxaattr, false);
        AppMethodBeat.o(228717);
        return a2;
    }

    public static final c acf(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(228718);
        if (!bNJ()) {
            c.b bVar = c.b.mWb;
            AppMethodBeat.o(228718);
            return bVar;
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c.b bVar2 = c.b.mWb;
            AppMethodBeat.o(228718);
            return bVar2;
        }
        if (((v) n.W(v.class)).e(str, "nickname") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkLaunchTimeoutStrategy appId:" + str + " isBackupExisted:" + z2);
        if (!z2) {
            c.b bVar3 = c.b.mWb;
            AppMethodBeat.o(228718);
            return bVar3;
        }
        WxaAttributes.c.a a2 = a(new a.C0733a(str), "checkLaunchTimeoutStrategy", false);
        if (a2 == null) {
            c.b bVar4 = c.b.mWb;
            AppMethodBeat.o(228718);
            return bVar4;
        }
        long j2 = a2.lgK;
        if (j2 <= 0) {
            c.b bVar5 = c.b.mWb;
            AppMethodBeat.o(228718);
            return bVar5;
        }
        c.a aVar = new c.a(j2);
        AppMethodBeat.o(228718);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"})
    public static abstract class c {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"})
        public static final class b extends c {
            public static final b mWb = new b();

            static {
                AppMethodBeat.i(228711);
                AppMethodBeat.o(228711);
            }

            private b() {
                super((byte) 0);
            }

            public final String toString() {
                return "NoFallback";
            }
        }

        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
        public static final class a extends c {
            public final long mWa;

            public final boolean equals(Object obj) {
                return this == obj || ((obj instanceof a) && this.mWa == ((a) obj).mWa);
            }

            public final int hashCode() {
                long j2 = this.mWa;
                return (int) (j2 ^ (j2 >>> 32));
            }

            public a(long j2) {
                super((byte) 0);
                this.mWa = j2;
            }

            public final String toString() {
                AppMethodBeat.i(228710);
                String str = "FallbackIfTimeout[" + this.mWa + "ms]";
                AppMethodBeat.o(228710);
                return str;
            }
        }
    }

    public static final void ef(String str, String str2) {
        boolean z;
        AppMethodBeat.i(228719);
        long nowMilliSecond = Util.nowMilliSecond();
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            mVU.put(new a.b(str), Long.valueOf(nowMilliSecond));
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            mVU.put(new a.C0733a(str2), Long.valueOf(nowMilliSecond));
        }
        AppMethodBeat.o(228719);
    }

    public static final void eg(String str, String str2) {
        boolean z;
        AppMethodBeat.i(228720);
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            mVU.remove(new a.b(str));
            mVV.remove(new a.b(str));
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            mVU.remove(new a.C0733a(str2));
            mVV.remove(new a.C0733a(str2));
        }
        AppMethodBeat.o(228720);
    }

    public static final void eh(String str, String str2) {
        boolean z;
        AppMethodBeat.i(228721);
        Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + str + " appId:" + str2);
        long nowMilliSecond = Util.nowMilliSecond();
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            mVV.put(new a.b(str), Long.valueOf(nowMilliSecond));
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            mVV.put(new a.C0733a(str2), Long.valueOf(nowMilliSecond));
        }
        AppMethodBeat.o(228721);
    }

    public static final c i(WxaAttributes wxaAttributes) {
        WxaAttributes.c bAo;
        AppMethodBeat.i(228722);
        if (!bNJ()) {
            c.b bVar = c.b.mWb;
            AppMethodBeat.o(228722);
            return bVar;
        }
        WxaAttributes.c.a aVar = (wxaAttributes == null || (bAo = wxaAttributes.bAo()) == null) ? null : bAo.lgD;
        if (aVar != null) {
            StringBuilder sb = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
            if (wxaAttributes == null) {
                p.hyc();
            }
            Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", sb.append(wxaAttributes.field_username).append(", appId:").append(wxaAttributes.field_appId).append(", settings:").append(a(aVar)).toString());
            if (aVar != null) {
                long j2 = aVar.lgK;
                if (j2 <= 0) {
                    c.b bVar2 = c.b.mWb;
                    AppMethodBeat.o(228722);
                    return bVar2;
                }
                c.a aVar2 = new c.a(j2);
                AppMethodBeat.o(228722);
                return aVar2;
            }
        }
        c.b bVar3 = c.b.mWb;
        AppMethodBeat.o(228722);
        return bVar3;
    }

    public static final boolean ei(String str, String str2) {
        a bVar;
        AppMethodBeat.i(228723);
        if (!bNJ()) {
            AppMethodBeat.o(228723);
            return false;
        }
        String str3 = str2;
        if (!(str3 == null || str3.length() == 0)) {
            bVar = new a.C0733a(str2);
        } else {
            String str4 = str;
            if (!(str4 == null || str4.length() == 0)) {
                bVar = new a.b(str);
            } else {
                AppMethodBeat.o(228723);
                return false;
            }
        }
        if (mVV.contains(bVar)) {
            WxaAttributes.c.a a2 = a(bVar, "[UpdateNewWxaAttrsFailure]", true);
            if (a2 == null) {
                AppMethodBeat.o(228723);
                return false;
            }
            long j2 = a2.lgN;
            Long remove = mVV.remove(bVar);
            if (remove == null) {
                remove = 0L;
            }
            p.g(remove, "UpdateNewWxaAttrsFailure…stampMap.remove(key) ?: 0");
            long longValue = remove.longValue();
            if (Util.nowMilliSecond() - longValue <= j2) {
                Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + j2 + "ms] lastFailureTimestamp[" + longValue + "] key[" + bVar + ']');
                AppMethodBeat.o(228723);
                return true;
            }
        }
        WxaAttributes.c.a a3 = a(bVar, "[MissedAppPkgFailure]", false);
        if (a3 == null) {
            AppMethodBeat.o(228723);
            return false;
        }
        long j3 = a3.lgN;
        Long remove2 = mVU.remove(bVar);
        if (remove2 == null) {
            remove2 = 0L;
        }
        p.g(remove2, "MissedAppPkgFailureTimestampsMap.remove(key) ?: 0");
        long longValue2 = remove2.longValue();
        Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + j3 + "ms] lastFailureTimestamp[" + longValue2 + "] key[" + bVar + ']');
        if (Util.nowMilliSecond() - longValue2 <= j3) {
            AppMethodBeat.o(228723);
            return true;
        }
        AppMethodBeat.o(228723);
        return false;
    }
}
