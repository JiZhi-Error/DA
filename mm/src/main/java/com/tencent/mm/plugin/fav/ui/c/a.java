package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;

public final class a extends IListener<gw> {
    private o tdg;
    private LruCache<Long, g> tlb = new LruCache<>(10);

    public a() {
        AppMethodBeat.i(107443);
        this.__eventId = gw.class.getName().hashCode();
        AppMethodBeat.o(107443);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gw gwVar) {
        AppMethodBeat.i(107445);
        boolean a2 = a(gwVar);
        AppMethodBeat.o(107445);
        return a2;
    }

    private boolean a(gw gwVar) {
        g gVar;
        boolean z;
        AppMethodBeat.i(107444);
        if (gwVar.dKR.dFW == 0) {
            gVar = null;
        } else if (gwVar.dKR.dKY) {
            gVar = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gwVar.dKR.dFW);
            if (gVar != null) {
                this.tlb.put(Long.valueOf(gwVar.dKR.dFW), gVar);
            }
        } else {
            g gVar2 = this.tlb.get(Long.valueOf(gwVar.dKR.dFW));
            Object[] objArr = new Object[1];
            if (gVar2 == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", objArr);
            if (gVar2 == null) {
                gVar = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gwVar.dKR.dFW);
                if (gVar != null) {
                    this.tlb.put(Long.valueOf(gwVar.dKR.dFW), gVar);
                }
            } else {
                gVar = gVar2;
            }
        }
        Log.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", Integer.valueOf(gwVar.dKR.opType), Long.valueOf(gwVar.dKR.dFW));
        if (gVar != null || gwVar.dKR.opType == 3 || gwVar.dKR.opType == 4) {
            switch (gwVar.dKR.opType) {
                case 0:
                    gwVar.dKS.dKZ = o.a(gwVar.dKR.dKT, gVar);
                    break;
                case 1:
                    if (this.tdg != null) {
                        this.tdg.b(gwVar.dKR.dKU, gwVar.dKR.dKT, gVar, gwVar.dKR.dKV, gwVar.dKR.width, gwVar.dKR.height);
                        break;
                    } else {
                        Log.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                        break;
                    }
                case 2:
                    Log.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", Boolean.valueOf(gwVar.dKR.dKW));
                    if (!gwVar.dKR.dKW) {
                        gwVar.dKS.dKZ = o.b(gwVar.dKR.dKT, gVar, gwVar.dKR.maxWidth);
                        break;
                    } else {
                        gwVar.dKS.dKZ = o.l(gwVar.dKR.dKT);
                        break;
                    }
                case 3:
                    Log.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.tdg != null) {
                        this.tdg.destory();
                    }
                    this.tdg = new o(gwVar.dKR.context, 16);
                    break;
                case 4:
                    Log.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.tdg != null) {
                        this.tdg.destory();
                        this.tdg = null;
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(107444);
        } else {
            AppMethodBeat.o(107444);
        }
        return false;
    }
}
