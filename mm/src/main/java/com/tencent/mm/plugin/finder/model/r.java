package com.tencent.mm.plugin.finder.model;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Landroid/support/v7/app/AppCompatActivity;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "favMegaVideo", "plugin-finder_release"})
public final class r {
    private static final String TAG = TAG;
    public static final r uNW = new r();

    static {
        AppMethodBeat.i(248731);
        AppMethodBeat.o(248731);
    }

    private r() {
    }

    public static void a(AppCompatActivity appCompatActivity, FinderItem finderItem, boolean z) {
        int i2;
        String str;
        String str2;
        AppMethodBeat.i(248730);
        p.h(appCompatActivity, "context");
        p.h(finderItem, ch.COL_FINDEROBJECT);
        Log.i(TAG, "favFeed, id:" + finderItem.getId() + ", pf:" + finderItem.getFeedObject().permissionFlag);
        a aVar = a.PRN;
        bbn dIx = ((FinderReporterUIC) a.b(appCompatActivity).get(FinderReporterUIC.class)).dIx();
        if (z) {
            a aVar2 = a.PRN;
            com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) a.b(appCompatActivity).get(FinderReporterUIC.class));
            if (b2 != null) {
                b2.cZR().Er(finderItem.getId());
            }
        } else {
            a aVar3 = a.PRN;
            com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b((FinderReporterUIC) a.b(appCompatActivity).get(FinderReporterUIC.class));
            if (b3 != null) {
                b3.cZR().Es(finderItem.getId());
            }
        }
        k kVar = k.vfA;
        long id = finderItem.getId();
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        p.h(dIx, "contextObj");
        FinderItem Fc = k.Fc(id);
        if (Fc != null) {
            bm bmVar = new bm();
            bmVar.jt(dIx.sessionId);
            bmVar.ju("");
            bmVar.jv(k.Fg(id));
            bmVar.jw(Fc.getUserName());
            bmVar.dU(5);
            bmVar.dV((long) i2);
            bmVar.dW(0);
            bmVar.jx("");
            bmVar.dX(2);
            bmVar.dY((long) Fc.getLikeCount());
            bmVar.dZ((long) Fc.getCommentCount());
            bmVar.ea((long) Fc.getFriendLikeCount());
            bmVar.eb((long) Fc.getMediaType());
            w wVar = w.vXp;
            bmVar.jy(n.j(w.z(Fc), ",", ";", false));
            bmVar.jz("");
            bmVar.ec((long) dIx.tCE);
            bmVar.ed(p.j(Fc.getUserName(), z.aUg()) ? 1 : 0);
            String str3 = dIx.sGQ;
            if (str3 == null) {
                str3 = "";
            }
            bmVar.jA(str3);
            String str4 = dIx.sGE;
            if (str4 == null) {
                str4 = "";
            }
            bmVar.jB(str4);
            bmVar.jC(k.G(id, dIx.tCE));
            String str5 = dIx.extraInfo;
            if (str5 == null || (str = n.j(str5, ",", ";", false)) == null) {
                str = "";
            }
            bmVar.jD(str);
            String str6 = dIx.sGH;
            if (str6 == null || (str2 = n.j(str6, ",", ";", false)) == null) {
                str2 = "";
            }
            bmVar.jE(str2);
            bmVar.bfK();
            k.a(bmVar);
        }
        c.a aVar4 = c.vUa;
        c.a(c.vTZ, finderItem, z, dIx);
        hn hnVar = new hn();
        hnVar.dLW.id = finderItem.getId();
        hnVar.dLW.dLX = z ? 1 : 2;
        hnVar.dLW.type = 5;
        EventCenter.instance.publish(hnVar);
        AppMethodBeat.o(248730);
    }
}
