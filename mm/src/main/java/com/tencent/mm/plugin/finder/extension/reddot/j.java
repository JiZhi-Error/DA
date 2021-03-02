package com.tencent.mm.plugin.finder.extension.reddot;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addNearbyFootRedDot", "", "addNearbyNewRedDot", "addNearbyUnreadRedDot", "unreadCount", "", "addPostRedDot", "addWelcomeNewRedDot", "checkPostRedDot", "getLocalRedDotDefault", "handleOldRedDot", "isShowPostRedDot", "", "isShowRedDot", ImagesContract.LOCAL, "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class j {
    public static final a tLj = new a((byte) 0);
    final f tJh;

    static {
        AppMethodBeat.i(178193);
        AppMethodBeat.o(178193);
    }

    public j(f fVar) {
        p.h(fVar, "manager");
        AppMethodBeat.i(178192);
        this.tJh = fVar;
        AppMethodBeat.o(178192);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void dbq() {
        AppMethodBeat.i(243625);
        if (dbu()) {
            dbr();
            dbw();
            Log.i("Finder.RedDotTransform", "[transformPostRedDot] done");
        }
        c cVar = c.vCb;
        if (c.dtX().value().intValue() != 0) {
            this.tJh.Iy(-1);
            Log.i("Finder.RedDotTransform", "[checkPostRedDot] clear TIMELINE_CAMERA");
        }
        AppMethodBeat.o(243625);
    }

    /* access modifiers changed from: package-private */
    public final void dbr() {
        AppMethodBeat.i(243626);
        c cVar = c.vCb;
        if (c.dtX().value().intValue() == 0) {
            bbi bbi = new bbi();
            bbi.LKM = String.valueOf(cl.aWA());
            bbi.priority = 100000;
            bbi.type = 1002;
            bdo bdo = new bdo();
            bdo.xGz = 1;
            bdo.LNm = 1;
            bdo.path = "FinderEntrance";
            bbi.GaM.add(bdo);
            bdo bdo2 = new bdo();
            bdo2.xGz = 1;
            bdo2.LNm = 1;
            bdo2.path = "TLPersonalCenter";
            bdo2.Bvg = "FinderEntrance";
            bbi.GaM.add(bdo2);
            bdo bdo3 = new bdo();
            bdo3.xGz = 1;
            bdo3.LNm = 1;
            bdo3.path = "TLCamera";
            bdo3.Bvg = "TLPersonalCenter";
            bbi.GaM.add(bdo3);
            f.a(this.tJh, bbi, "checkPostRedDot", null, true, null, 20);
        }
        AppMethodBeat.o(243626);
    }

    public final void dbs() {
        AppMethodBeat.i(243627);
        if (this.tJh.asX("NearbyPeopleFooterprintClear") != null) {
            Log.i("Finder.RedDotTransform", "addNearbyFootRedDot: duplicate red dot");
            AppMethodBeat.o(243627);
            return;
        }
        bbi bbi = new bbi();
        bbi.LKM = String.valueOf(cl.aWA());
        bbi.priority = 300000;
        bbi.type = 1014;
        bdo bdo = new bdo();
        bdo.xGz = 101;
        bdo.LNm = 2;
        bdo.path = "NearbyEntrance";
        bbi.GaM.add(bdo);
        bdo bdo2 = new bdo();
        bdo2.xGz = 101;
        bdo2.LNm = 2;
        bdo2.Bvg = "NearbyEntrance";
        bdo2.path = "NearbyPeopleTab";
        bbi.GaM.add(bdo2);
        bdo bdo3 = new bdo();
        bdo3.xGz = 101;
        bdo3.LNm = 1;
        bdo3.Bvg = "NearbyPeopleTab";
        bdo3.path = "NearbyPeopleFooterprintClear";
        bbi.GaM.add(bdo3);
        this.tJh.a(bbi, "addNearByFootRedDot");
        AppMethodBeat.o(243627);
    }

    public final void IB(int i2) {
        AppMethodBeat.i(243628);
        bbi bbi = new bbi();
        bbi.LKM = String.valueOf(cl.aWA());
        bbi.priority = 10021000;
        bbi.type = 1013;
        bdo bdo = new bdo();
        bdo.xGz = 2;
        bdo.LNm = 2;
        bdo.count = i2;
        bdo.path = "NearbyEntrance";
        bbi.GaM.add(bdo);
        bdo bdo2 = new bdo();
        bdo2.xGz = 2;
        bdo2.LNm = 2;
        bdo2.count = i2;
        bdo2.path = "NearbyPeopleTab";
        bdo2.Bvg = "NearbyEntrance";
        bbi.GaM.add(bdo2);
        bdo bdo3 = new bdo();
        bdo3.xGz = 2;
        bdo3.LNm = 1;
        bdo2.count = i2;
        bdo3.Bvg = "NearbyPeopleTab";
        bdo3.path = "NearbyPeopleBubble";
        bbi.GaM.add(bdo3);
        this.tJh.a(bbi, "addNearByUnreadRedDot");
        AppMethodBeat.o(243628);
    }

    public final void dbt() {
        AppMethodBeat.i(243629);
        bbi bbi = new bbi();
        bbi.LKM = String.valueOf(cl.aWA());
        bbi.priority = 100000;
        bbi.type = 1011;
        bdo bdo = new bdo();
        bdo.xGz = 6;
        bdo.LNm = 1;
        bdo.path = "NearbyEntrance";
        bbi.GaM.add(bdo);
        this.tJh.a(bbi, "addNearbyNewRedDot");
        AppMethodBeat.o(243629);
    }

    private static boolean IC(int i2) {
        return (i2 & 2) > 0;
    }

    private static boolean dbu() {
        boolean z = true;
        AppMethodBeat.i(243630);
        boolean z2 = !Util.isNullOrNil(z.aUg());
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LOCAL_RED_DOT_INT_SYNC, dbv());
        if (!((PluginFinder) g.ah(PluginFinder.class)).showPostEntry() || !IC(i2) || z2) {
            z = false;
        }
        Log.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + z + " local=" + i2 + " hasCreatedIdentity=" + z2);
        AppMethodBeat.o(243630);
        return z;
    }

    private static int dbv() {
        AppMethodBeat.i(178191);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LOCAL_RED_DOT_INT_SYNC, -1);
        if (i2 == -1) {
            boolean showPostEntry = ((PluginFinder) g.ah(PluginFinder.class)).showPostEntry();
            boolean z = !Util.isNullOrNil(z.aUg());
            if (!showPostEntry || z) {
                i2 = 0;
            } else {
                i2 = 2;
            }
        }
        AppMethodBeat.o(178191);
        return i2;
    }

    private static void dbw() {
        AppMethodBeat.i(243631);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LOCAL_RED_DOT_INT_SYNC, dbv());
        int i3 = i2 & -3;
        if (i3 != i2) {
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_LOCAL_RED_DOT_INT_SYNC, Integer.valueOf(i3));
        }
        Log.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + i3 + " local=" + i2);
        AppMethodBeat.o(243631);
    }
}
