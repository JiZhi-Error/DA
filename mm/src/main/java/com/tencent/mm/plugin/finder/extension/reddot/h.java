package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001OB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004J*\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010@\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GJ$\u0010H\u001a\u00020?\"\u0004\b\u0000\u0010I*\b\u0012\u0004\u0012\u0002HI0\u00062\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0KJ,\u0010L\u001a\u00020?\"\u0004\b\u0000\u0010I*\b\u0012\u0004\u0012\u0002HI0\u00062\u0006\u0010M\u001a\u00020N2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0KR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\tR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\tR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\tR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\tR\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\tR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\tR\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tR\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\tR\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\t¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderCreateFinderEntrance", "getFinderCreateFinderEntrance", "finderCreatorEntrance", "getFinderCreatorEntrance", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderLiveEntrance", "getFinderLiveEntrance", "finderMessage", "getFinderMessage", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderProfileTop", "getFinderProfileTop", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlPostCamera", "getFinderTlPostCamera", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "nearbyEntrance", "getNearbyEntrance", "nearbyTabFeed", "getNearbyTabFeed", "nearbyTabLive", "getNearbyTabLive", "nearbyTabPeople", "getNearbyTabPeople", "checkPathAndNotify", "", "path", "notify", "isShow", "", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class h {
    private static final MutableLiveData<a> UIn = new MutableLiveData<>();
    private static final MutableLiveData<a> UIo = new MutableLiveData<>();
    private static final MutableLiveData<a> tKA = new MutableLiveData<>();
    private static final MutableLiveData<a> tKB = new MutableLiveData<>();
    private static final MutableLiveData<a> tKC = new MutableLiveData<>();
    private static final MutableLiveData<a> tKD = new MutableLiveData<>();
    private static final MutableLiveData<a> tKE = new MutableLiveData<>();
    private static final MutableLiveData<a> tKF = new MutableLiveData<>();
    private static final MutableLiveData<a> tKG = new MutableLiveData<>();
    private static final MutableLiveData<a> tKH = new MutableLiveData<>();
    private static final MutableLiveData<a> tKI = new MutableLiveData<>();
    private static final MutableLiveData<a> tKJ = new MutableLiveData<>();
    private static final MutableLiveData<a> tKK = new MutableLiveData<>();
    private static final MutableLiveData<a> tKN = new MutableLiveData<>();
    private static final MutableLiveData<a> tKO = new MutableLiveData<>();
    private static final MutableLiveData<a> tKP = new MutableLiveData<>();
    private static final MutableLiveData<a> tKQ = new MutableLiveData<>();
    public static final h tKR = new h();
    private static final MutableLiveData<a> tKq = new MutableLiveData<>();
    private static final MutableLiveData<a> tKr = new MutableLiveData<>();
    private static final MutableLiveData<a> tKs = new MutableLiveData<>();
    private static final MutableLiveData<a> tKt = new MutableLiveData<>();
    private static final MutableLiveData<a> tKu = new MutableLiveData<>();
    private static final MutableLiveData<a> tKv = new MutableLiveData<>();
    private static final MutableLiveData<a> tKw = new MutableLiveData<>();
    private static final MutableLiveData<a> tKx = new MutableLiveData<>();
    private static final MutableLiveData<a> tKy = new MutableLiveData<>();
    private static final MutableLiveData<a> tKz = new MutableLiveData<>();

    static {
        AppMethodBeat.i(178190);
        AppMethodBeat.o(178190);
    }

    private h() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000f¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a {
        public final boolean dEF;
        public bdo tKS;
        public final k tKT;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (kotlin.g.b.p.j(r3.tKT, r4.tKT) != false) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 178187(0x2b80b, float:2.49693E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.extension.reddot.h.a
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.finder.extension.reddot.h$a r4 = (com.tencent.mm.plugin.finder.extension.reddot.h.a) r4
                boolean r0 = r3.dEF
                boolean r1 = r4.dEF
                if (r0 != r1) goto L_0x002d
                com.tencent.mm.protocal.protobuf.bdo r0 = r3.tKS
                com.tencent.mm.protocal.protobuf.bdo r1 = r4.tKS
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.finder.extension.reddot.k r0 = r3.tKT
                com.tencent.mm.plugin.finder.extension.reddot.k r1 = r4.tKT
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.h.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(178186);
            boolean z = this.dEF;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            bdo bdo = this.tKS;
            int hashCode = ((bdo != null ? bdo.hashCode() : 0) + i6) * 31;
            k kVar = this.tKT;
            if (kVar != null) {
                i2 = kVar.hashCode();
            }
            int i7 = hashCode + i2;
            AppMethodBeat.o(178186);
            return i7;
        }

        public a(boolean z, bdo bdo, k kVar) {
            this.dEF = z;
            this.tKS = bdo;
            this.tKT = kVar;
        }

        public final String toString() {
            bbi bbi;
            String str = null;
            AppMethodBeat.i(178185);
            StringBuilder sb = new StringBuilder("tipId=");
            k kVar = this.tKT;
            StringBuilder append = sb.append(kVar != null ? kVar.field_tipsId : null).append(" type=");
            k kVar2 = this.tKT;
            StringBuilder append2 = append.append((kVar2 == null || (bbi = kVar2.field_ctrInfo) == null) ? null : Integer.valueOf(bbi.type)).append(" isShow=").append(this.dEF).append(" path=");
            bdo bdo = this.tKS;
            StringBuilder append3 = append2.append(bdo != null ? bdo.path : null).append(" showType=");
            bdo bdo2 = this.tKS;
            StringBuilder append4 = append3.append(bdo2 != null ? Integer.valueOf(bdo2.xGz) : null).append(" title=");
            bdo bdo3 = this.tKS;
            if (bdo3 != null) {
                str = bdo3.title;
            }
            String sb2 = append4.append(str).toString();
            AppMethodBeat.o(178185);
            return sb2;
        }
    }

    public static MutableLiveData<a> daJ() {
        return tKq;
    }

    public static MutableLiveData<a> daK() {
        return tKr;
    }

    public static MutableLiveData<a> daL() {
        return tKs;
    }

    public static MutableLiveData<a> daM() {
        return tKv;
    }

    public static MutableLiveData<a> daN() {
        return tKy;
    }

    public static MutableLiveData<a> daO() {
        return tKz;
    }

    public static MutableLiveData<a> daP() {
        return tKA;
    }

    public static MutableLiveData<a> daQ() {
        return tKB;
    }

    public static MutableLiveData<a> daR() {
        return tKC;
    }

    public static MutableLiveData<a> daS() {
        return tKD;
    }

    public static MutableLiveData<a> daT() {
        return tKE;
    }

    public static MutableLiveData<a> daU() {
        return tKF;
    }

    public static MutableLiveData<a> daV() {
        return tKG;
    }

    public static MutableLiveData<a> daW() {
        return tKH;
    }

    public static MutableLiveData<a> daX() {
        return tKI;
    }

    public static MutableLiveData<a> daY() {
        return tKJ;
    }

    public static MutableLiveData<a> daZ() {
        return tKK;
    }

    public static MutableLiveData<a> hSH() {
        return UIn;
    }

    public static MutableLiveData<a> hSI() {
        return UIo;
    }

    public static MutableLiveData<a> dbc() {
        return tKN;
    }

    public static MutableLiveData<a> dbd() {
        return tKO;
    }

    public static MutableLiveData<a> dbe() {
        return tKP;
    }

    public static MutableLiveData<a> dbf() {
        return tKQ;
    }

    public static <T> void a(MutableLiveData<T> mutableLiveData, LifecycleOwner lifecycleOwner, Observer<T> observer) {
        AppMethodBeat.i(178188);
        p.h(mutableLiveData, "$this$observeWithNotify");
        p.h(lifecycleOwner, "owner");
        p.h(observer, "observer");
        d.h(new c(mutableLiveData, lifecycleOwner, observer));
        AppMethodBeat.o(178188);
    }

    public static <T> void a(MutableLiveData<T> mutableLiveData, Observer<T> observer) {
        AppMethodBeat.i(243610);
        p.h(mutableLiveData, "$this$observeForeverWithNotify");
        p.h(observer, "observer");
        d.h(new b(mutableLiveData, observer));
        AppMethodBeat.o(243610);
    }

    public static void bxB(String str) {
        AppMethodBeat.i(260230);
        p.h(str, "path");
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        k asX = ((PluginFinder) ah).getRedDotManager().asX(str);
        if (asX != null) {
            bdo atl = asX.atl(str);
            if (atl != null) {
                a(true, str, atl, asX);
                AppMethodBeat.o(260230);
                return;
            }
            a(false, str, null, asX);
            AppMethodBeat.o(260230);
            return;
        }
        a(false, str, null, null);
        AppMethodBeat.o(260230);
    }

    public static void a(boolean z, String str, bdo bdo, k kVar) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(178189);
        p.h(str, "path");
        StringBuilder append = new StringBuilder("[notify] isShow=").append(z).append(" path=").append(str).append(" show_type=").append(bdo != null ? Integer.valueOf(bdo.xGz) : null).append(" count=").append(bdo != null ? Integer.valueOf(bdo.count) : null).append(' ').append("title=");
        if (bdo != null) {
            str2 = bdo.title;
        } else {
            str2 = null;
        }
        StringBuilder append2 = append.append(str2).append(" clear_type=").append(bdo != null ? Integer.valueOf(bdo.LNm) : null).append(" parent=").append(bdo != null ? bdo.Bvg : null).append(" icon=");
        if (bdo != null) {
            str3 = bdo.qGB;
        }
        Log.i("Finder.RedDotNotifier", append2.append(str3).toString());
        if (z) {
            com.tencent.mm.kernel.c.a af = g.af(ad.class);
            p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((ad) af).dxX() && (kVar == null || kVar.field_ctrInfo.type != 8)) {
                Log.i("Finder.RedDotManager", "[notify] 青少年模式且只看关注的模式下只notify关注的红点展示");
                AppMethodBeat.o(178189);
                return;
            }
        }
        a aVar = new a(z, bdo, kVar);
        switch (str.hashCode()) {
            case -2012091709:
                if (str.equals("TLWxPrivateMsgBubble")) {
                    tKI.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -1310893465:
                if (str.equals("AuthorProfileNotify")) {
                    tKx.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -1122322075:
                if (str.equals("TLWxBubble")) {
                    tKu.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -961813849:
                if (str.equals("NearbyPeopleTab")) {
                    tKP.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -318065288:
                if (str.equals("NearbyFeedTab")) {
                    tKN.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -293714827:
                if (str.equals("finder_wx_private_msg_entrance")) {
                    tKH.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -111863496:
                if (str.equals("CreateFinderEntrance")) {
                    UIn.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case -58348260:
                if (str.equals("FinderEntrance")) {
                    tKr.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 4283335:
                if (str.equals("OriginalEntrance")) {
                    tKz.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 345890211:
                if (str.equals("finder_tl_nearby_tab")) {
                    tKF.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 418234311:
                if (str.equals("Personal_Center_FavList_Entrance")) {
                    tKD.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 748937620:
                if (str.equals("FinderSelfLiveEntrance")) {
                    tKJ.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 842235754:
                if (str.equals("NearbyLiveTab")) {
                    tKO.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 885710185:
                if (str.equals("finder_private_msg_entrance")) {
                    tKG.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1109065661:
                if (str.equals("TLCamera")) {
                    tKs.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1122432629:
                if (str.equals("NearbyEntrance")) {
                    tKQ.postValue(aVar);
                    break;
                }
                break;
            case 1207859273:
                if (str.equals("TLFollow")) {
                    tKB.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1270511455:
                if (str.equals("ProfileEntrance")) {
                    tKv.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1379387998:
                if (str.equals("AuthorProfileFans")) {
                    tKw.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1397734293:
                if (str.equals("finder_tl_hot_tab")) {
                    tKE.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1449007057:
                if (str.equals("TLRecommendTab")) {
                    tKC.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1635977002:
                if (str.equals("FinderSetting")) {
                    tKA.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1740085121:
                if (str.equals("CreatorCenter")) {
                    tKK.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1882760592:
                if (str.equals("Discovery")) {
                    tKq.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1965523069:
                if (str.equals("TLPostCamera")) {
                    tKt.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 1990415181:
                if (str.equals("TLPersonalCenter")) {
                    tKy.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
            case 2101591951:
                if (str.equals("FinderProfileBanner")) {
                    UIo.postValue(aVar);
                    AppMethodBeat.o(178189);
                    return;
                }
                break;
        }
        AppMethodBeat.o(178189);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Observer tKV;
        final /* synthetic */ MutableLiveData tKX;
        final /* synthetic */ LifecycleOwner tKY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MutableLiveData mutableLiveData, LifecycleOwner lifecycleOwner, Observer observer) {
            super(0);
            this.tKX = mutableLiveData;
            this.tKY = lifecycleOwner;
            this.tKV = observer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(243609);
            this.tKX.observe(this.tKY, this.tKV);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.extension.reddot.h.c.AnonymousClass1 */
                final /* synthetic */ c tKZ;

                {
                    this.tKZ = r1;
                }

                public final void run() {
                    AppMethodBeat.i(243608);
                    Object value = this.tKZ.tKX.getValue();
                    if (value != null) {
                        StringBuilder append = new StringBuilder("value=").append(this.tKZ.tKX.getValue()).append(" observer=").append(this.tKZ.tKV.getClass().getSimpleName()).append(" currentState=");
                        Lifecycle lifecycle = this.tKZ.tKY.getLifecycle();
                        p.g(lifecycle, "owner.lifecycle");
                        Log.i("Finder.RedDotNotifier", append.append(lifecycle.getCurrentState()).toString());
                        Lifecycle lifecycle2 = this.tKZ.tKY.getLifecycle();
                        p.g(lifecycle2, "owner.lifecycle");
                        if (lifecycle2.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                            this.tKZ.tKV.onChanged(value);
                        }
                        AppMethodBeat.o(243608);
                        return;
                    }
                    AppMethodBeat.o(243608);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(243609);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MutableLiveData tKU;
        final /* synthetic */ Observer tKV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MutableLiveData mutableLiveData, Observer observer) {
            super(0);
            this.tKU = mutableLiveData;
            this.tKV = observer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(243607);
            this.tKU.observeForever(this.tKV);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.extension.reddot.h.b.AnonymousClass1 */
                final /* synthetic */ b tKW;

                {
                    this.tKW = r1;
                }

                public final void run() {
                    AppMethodBeat.i(243606);
                    Object value = this.tKW.tKU.getValue();
                    if (value != null) {
                        this.tKW.tKV.onChanged(value);
                        AppMethodBeat.o(243606);
                        return;
                    }
                    AppMethodBeat.o(243606);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(243607);
            return xVar;
        }
    }
}
