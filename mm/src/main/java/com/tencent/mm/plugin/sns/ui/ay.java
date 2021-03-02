package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.e;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class ay {
    public static m a(Context context, z zVar, ViewGroup viewGroup, int i2) {
        m yVar;
        m sVar;
        AppMethodBeat.i(98308);
        m mVar = null;
        if (zVar != null) {
            switch (zVar.type) {
                case 21:
                    if (zVar.subType == 2) {
                        b bVar = (b) zVar;
                        if (bVar == null || bVar.DXQ <= 0 || !a.aV(bVar.DXR)) {
                            sVar = new s(context, bVar, viewGroup);
                        } else {
                            sVar = new l(context, bVar, viewGroup);
                        }
                        AppMethodBeat.o(98308);
                        return sVar;
                    } else if (zVar.subType == 6) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z zVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(context, (q) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return zVar2;
                    } else if (zVar.subType == 7) {
                        aa aaVar = new aa(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return aaVar;
                    } else if (zVar.subType == 13) {
                        ai aiVar = new ai(context, (o) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return aiVar;
                    } else if (zVar.subType == 14) {
                        u uVar = new u(context, (g) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return uVar;
                    } else if (zVar.subType == 15) {
                        af afVar = new af(context, (ab) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return afVar;
                    } else if (zVar.subType == 17) {
                        mVar = new k(context, (w) zVar, viewGroup);
                        break;
                    } else if (zVar.subType == 18) {
                        ac acVar = new ac(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return acVar;
                    } else if (zVar.subType == 19) {
                        com.tencent.mm.plugin.sns.ad.landingpage.component.a.a aVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.a(context, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.a) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return aVar;
                    } else if (zVar.subType == 20) {
                        c cVar = new c(context, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.c) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return cVar;
                    } else if (zVar.subType == 21) {
                        e eVar = new e(context, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.e) zVar, viewGroup);
                        AppMethodBeat.o(98308);
                        return eVar;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    switch (zVar.subType) {
                        case 0:
                            mVar = new ae(context, (t) zVar, viewGroup);
                            break;
                        case 1:
                            mVar = new r(context, (t) zVar, viewGroup);
                            break;
                    }
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                    mVar = new j(context, zVar, viewGroup);
                    break;
                case 101:
                    mVar = new v(context, (ak) zVar, viewGroup);
                    break;
                case 102:
                    mVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r) zVar, viewGroup);
                    break;
                case 103:
                    mVar = new x(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa) zVar, viewGroup);
                    break;
                case 104:
                    mVar = new f(context, (y) zVar, viewGroup);
                    break;
                case 105:
                    mVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x) zVar, viewGroup);
                    break;
                case 132:
                    mVar = new an(context, (ao) zVar, viewGroup);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX:
                    mVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.b(context, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.b) zVar, viewGroup);
                    break;
                default:
                    Log.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + zVar.type);
                    break;
            }
        }
        if (mVar != null) {
            AppMethodBeat.o(98308);
            return mVar;
        } else if (zVar instanceof ag) {
            am amVar = new am(context, (ag) zVar, viewGroup);
            amVar.setBackgroundColor(i2);
            AppMethodBeat.o(98308);
            return amVar;
        } else if (zVar instanceof q) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q qVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(context, (q) zVar, viewGroup);
            qVar.setBackgroundColor(i2);
            AppMethodBeat.o(98308);
            return qVar;
        } else if (zVar instanceof t) {
            ae aeVar = new ae(context, (t) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return aeVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab abVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return abVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) {
            ah ahVar = new ah(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return ahVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am amVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am) zVar;
            if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
                Log.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
                yVar = new al(context, amVar2, viewGroup);
            } else {
                yVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(context, amVar2, viewGroup);
            }
            AppMethodBeat.o(98308);
            return yVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w wVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return wVar;
        } else if (zVar instanceof i) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(context, (i) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return iVar;
        } else if (zVar instanceof d) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c cVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c(context, (d) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return cVar2;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae) {
            ad adVar = new ad(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return adVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) {
            aj ajVar = new aj(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return ajVar;
        } else if (zVar instanceof p) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o oVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(context, (p) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return oVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e eVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return eVar2;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.d) {
            com.tencent.mm.plugin.sns.ad.landingpage.component.a.d dVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.d(context, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.d) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return dVar;
        } else if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag agVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af) zVar, viewGroup);
            AppMethodBeat.o(98308);
            return agVar;
        } else {
            m mVar2 = new m(context, zVar, viewGroup);
            AppMethodBeat.o(98308);
            return mVar2;
        }
    }
}
