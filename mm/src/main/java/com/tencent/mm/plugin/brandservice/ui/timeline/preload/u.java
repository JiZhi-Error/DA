package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u001a&\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0003\u001a\n\u0010,\u001a\u00020-*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\"\u0015\u0010\u0018\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f\"\u0015\u0010\u001f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b \u0010\u000f\"\u0015\u0010!\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u000f\"\u0015\u0010#\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000f\"\u0015\u0010%\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000f¨\u0006."}, hxF = {"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class u {
    private static final String TAG = TAG;
    private static final f pDv = g.ah(a.pDw);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Long> {
        public static final a pDw = new a();

        static {
            AppMethodBeat.i(6739);
            AppMethodBeat.o(6739);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(6738);
            AppMethodBeat.o(6738);
            return 1L;
        }
    }

    public static final long con() {
        AppMethodBeat.i(6741);
        long longValue = ((Number) pDv.getValue()).longValue();
        AppMethodBeat.o(6741);
        return longValue;
    }

    static {
        AppMethodBeat.i(6740);
        AppMethodBeat.o(6740);
    }

    public static final MultiProcessMMKV coo() {
        AppMethodBeat.i(6742);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("_webview_tmpl_info");
        p.g(mmkv, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
        AppMethodBeat.o(6742);
        return mmkv;
    }

    public static final o aim(String str) {
        AppMethodBeat.i(6743);
        p.h(str, "$this$toFile");
        o oVar = new o(str);
        AppMethodBeat.o(6743);
        return oVar;
    }

    public static final boolean ain(String str) {
        AppMethodBeat.i(6744);
        p.h(str, "$this$isFileExists");
        boolean exists = aim(str).exists();
        AppMethodBeat.o(6744);
        return exists;
    }

    public static final boolean a(eib eib) {
        AppMethodBeat.i(6745);
        p.h(eib, "$this$isValid");
        if (eib.Version != 0) {
            AppMethodBeat.o(6745);
            return true;
        }
        AppMethodBeat.o(6745);
        return false;
    }

    public static final String b(eib eib) {
        AppMethodBeat.i(6746);
        p.h(eib, "$this$basePath");
        int i2 = eib.oUv;
        String str = eib.LQx;
        p.g(str, "this.Uid");
        String u = t.u(i2, str, "");
        if (!ain(u)) {
            int i3 = eib.oUv;
            String str2 = eib.LQx;
            p.g(str2, "this.Uid");
            u = t.aF(i3, str2);
        }
        AppMethodBeat.o(6746);
        return u;
    }

    public static final String c(eib eib) {
        AppMethodBeat.i(6747);
        p.h(eib, "$this$indexPath");
        int i2 = eib.oUv;
        String str = eib.LQx;
        p.g(str, "this.Uid");
        String aG = t.aG(i2, str);
        if (!ain(aG)) {
            int i3 = eib.oUv;
            String str2 = eib.LQx;
            p.g(str2, "this.Uid");
            aG = t.aF(i3, str2);
        }
        AppMethodBeat.o(6747);
        return aG;
    }

    public static final boolean d(eib eib) {
        AppMethodBeat.i(6748);
        p.h(eib, "$this$isZip");
        String c2 = c(eib);
        int i2 = eib.oUv;
        String str = eib.LQx;
        p.g(str, "this.Uid");
        boolean j2 = p.j(c2, t.aG(i2, str));
        AppMethodBeat.o(6748);
        return j2;
    }

    public static final String Dx(int i2) {
        AppMethodBeat.i(6749);
        String concat = "_tmpl_info_latest_responsed_-".concat(String.valueOf(i2));
        AppMethodBeat.o(6749);
        return concat;
    }

    public static final String e(eib eib) {
        AppMethodBeat.i(6750);
        p.h(eib, "$this$keyStore");
        String str = "_tmpl_info_-" + eib.oUv + '-' + eib.LQx;
        AppMethodBeat.o(6750);
        return str;
    }

    public static final String f(eib eib) {
        AppMethodBeat.i(6751);
        p.h(eib, "$this$keyLatestVerified");
        String str = "_tmpl_info_latest_verified_-" + eib.oUv + '-' + eib.Nhq;
        AppMethodBeat.o(6751);
        return str;
    }

    public static final String g(eib eib) {
        AppMethodBeat.i(6752);
        p.h(eib, "$this$keyLatestVerifiedTime");
        String str = "_tmpl_info_latest_verified_time_-" + eib.oUv + '-' + eib.Nhq;
        AppMethodBeat.o(6752);
        return str;
    }

    public static final String h(eib eib) {
        AppMethodBeat.i(6753);
        p.h(eib, "$this$keyVersions");
        String str = "_tmpl_info_version_list_-" + eib.oUv + '-' + eib.Nhq;
        AppMethodBeat.o(6753);
        return str;
    }

    public static final boolean i(eib eib) {
        AppMethodBeat.i(6754);
        p.h(eib, "$this$isLatestVerifiedExpired");
        boolean isExpire = MMSlotKt.isExpire(coo().getLong(g(eib), 0), 3600000);
        AppMethodBeat.o(6754);
        return isExpire;
    }

    public static final int a(int i2, long j2, int i3, long j3) {
        AppMethodBeat.i(6755);
        int hashCode = new StringBuilder().append(i2).append('-').append(j2).toString().hashCode();
        if (coo().getInt("_tmpl_lastest_mm_open", 0) == hashCode) {
            int hashCode2 = new StringBuilder().append(i3).append('-').append(j3).toString().hashCode();
            if (coo().getInt("_tmpl_lastest_mp_open", 0) == hashCode2) {
                AppMethodBeat.o(6755);
                return 2;
            }
            coo().putInt("_tmpl_lastest_mp_open", hashCode2);
            AppMethodBeat.o(6755);
            return 1;
        }
        coo().putInt("_tmpl_lastest_mm_open", hashCode);
        AppMethodBeat.o(6755);
        return 0;
    }
}
