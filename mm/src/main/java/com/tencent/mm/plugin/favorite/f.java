package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements bd {
    private IListener tnp = new IListener<gx>() {
        /* class com.tencent.mm.plugin.favorite.f.AnonymousClass1 */

        {
            AppMethodBeat.i(161367);
            this.__eventId = gx.class.getName().hashCode();
            AppMethodBeat.o(161367);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gx gxVar) {
            AppMethodBeat.i(24612);
            boolean a2 = a(gxVar);
            AppMethodBeat.o(24612);
            return a2;
        }

        private static boolean a(gx gxVar) {
            g gVar;
            g gVar2;
            int i2;
            AppMethodBeat.i(24611);
            if (gxVar.dLa.dLd != null && (gxVar.dLa.dLd instanceof o.a) && gxVar.dLa.dDg != null && (gxVar.dLa.dDg instanceof Context)) {
                g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gxVar.dLa.dFW);
                String str = gxVar.dLa.dLb;
                if (!Util.isNullOrNil(str) && (DY.field_type == 18 || DY.field_type == 14)) {
                    try {
                        LinkedList<aml> linkedList = DY.field_favProto.ppH;
                        if (DY.field_type == 18) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        while (true) {
                            if (i2 >= linkedList.size()) {
                                gVar = DY;
                                break;
                            }
                            aml aml = linkedList.get(i2);
                            if (str.startsWith(aml.dLl)) {
                                g cUC = DY.cUC();
                                cUC.field_type = gxVar.dLa.dLc;
                                cUC.tad = true;
                                cUC.tae = DY;
                                cUC.dLb = DY.field_localId + "_" + aml.dLl;
                                cUC.field_favProto = c.c(DY.field_favProto);
                                cUC.field_favProto.ppH = new LinkedList<>();
                                cUC.field_favProto.ppH.add(aml);
                                cUC.field_favProto.bhd(aml.title);
                                if (aml.Lwh != null) {
                                    if (gxVar.dLa.dLc == 6) {
                                        cUC.field_favProto.d(aml.Lwh.LwQ);
                                    } else if (gxVar.dLa.dLc == 5) {
                                        cUC.field_favProto.b(aml.Lwh.LwS);
                                    }
                                }
                                gVar = cUC;
                            } else {
                                i2++;
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    }
                    if (gVar == null || Util.isNullOrNil(gxVar.dLa.dLe)) {
                        gVar2 = gVar;
                    } else {
                        gVar2 = b.arO(gxVar.dLa.dLe);
                    }
                    o.a aVar = (o.a) gxVar.dLa.dLd;
                    Context context = (Context) gxVar.dLa.dDg;
                    d.a(aVar, context, gVar2);
                    d.b(aVar, context, gVar2);
                }
                gVar = DY;
                if (gVar == null) {
                }
                gVar2 = gVar;
                o.a aVar2 = (o.a) gxVar.dLa.dLd;
                Context context2 = (Context) gxVar.dLa.dDg;
                d.a(aVar2, context2, gVar2);
                d.b(aVar2, context2, gVar2);
            }
            gxVar.dLa.dFW = 0;
            gxVar.dLa.dLb = "";
            gxVar.dLa.dLd = null;
            gxVar.dLa.dDg = null;
            AppMethodBeat.o(24611);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(24613);
        AppMethodBeat.o(24613);
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(24614);
        Log.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", Boolean.valueOf(z));
        EventCenter.instance.add(this.tnp);
        com.tencent.mm.kernel.g.b(y.class, new c());
        com.tencent.mm.kernel.g.b(ab.class, new e());
        AppMethodBeat.o(24614);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(24615);
        EventCenter.instance.removeListener(this.tnp);
        ((n) com.tencent.mm.kernel.g.ah(n.class)).unregisterFTSUILogic(128);
        ((n) com.tencent.mm.kernel.g.ah(n.class)).unregisterFTSUILogic(4192);
        AppMethodBeat.o(24615);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }
}
