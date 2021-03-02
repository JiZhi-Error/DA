package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.a;
import com.tencent.mm.bi.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r implements a {
    private MMHandler handler;
    private List<c> listeners = new LinkedList();
    private final String path;
    private b yGW;

    public r() {
        AppMethodBeat.i(55772);
        o oVar = new o(n.ecU());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        this.path = n.ecU() + "trackroominfolist.info";
        this.handler = new MMHandler(Looper.getMainLooper());
        if (this.yGW == null) {
            if (!s.YS(this.path)) {
                this.yGW = new b();
                AppMethodBeat.o(55772);
                return;
            }
            try {
                this.yGW = (b) new b().parseFrom(s.aW(this.path, 0, -1));
                AppMethodBeat.o(55772);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TrackRoomListMgr", e2, "", new Object[0]);
                this.yGW = new b();
            }
        }
        AppMethodBeat.o(55772);
    }

    @Override // com.tencent.mm.bi.a
    public final synchronized void a(c cVar) {
        AppMethodBeat.i(55773);
        this.listeners.add(cVar);
        AppMethodBeat.o(55773);
    }

    @Override // com.tencent.mm.bi.a
    public final synchronized void b(c cVar) {
        AppMethodBeat.i(55774);
        this.listeners.remove(cVar);
        AppMethodBeat.o(55774);
    }

    @Override // com.tencent.mm.bi.a
    public final synchronized LinkedList<String> PY(String str) {
        LinkedList<String> linkedList;
        AppMethodBeat.i(55775);
        Iterator<com.tencent.mm.plugin.location.a.a> it = this.yGW.yFr.iterator();
        while (true) {
            if (!it.hasNext()) {
                linkedList = new LinkedList<>();
                AppMethodBeat.o(55775);
                break;
            }
            com.tencent.mm.plugin.location.a.a next = it.next();
            if (next.username.equals(str)) {
                linkedList = (LinkedList) next.dTe.clone();
                AppMethodBeat.o(55775);
                break;
            }
        }
        return linkedList;
    }

    public final synchronized com.tencent.mm.plugin.location.a.a aCZ(String str) {
        com.tencent.mm.plugin.location.a.a aVar;
        AppMethodBeat.i(55776);
        Iterator<com.tencent.mm.plugin.location.a.a> it = this.yGW.yFr.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                AppMethodBeat.o(55776);
                break;
            }
            aVar = it.next();
            if (aVar.username.equals(str)) {
                AppMethodBeat.o(55776);
                break;
            }
        }
        return aVar;
    }

    @Override // com.tencent.mm.bi.a
    public final synchronized void a(String str, LinkedList<String> linkedList, double d2, double d3, String str2, String str3, String str4) {
        AppMethodBeat.i(55777);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        Log.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", str, Integer.valueOf(linkedList.size()), Double.valueOf(d2), Double.valueOf(d3));
        LinkedList<String> linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator<com.tencent.mm.plugin.location.a.a> it = this.yGW.yFr.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.mm.plugin.location.a.a next = it.next();
                if (next.username.equals(str)) {
                    if (isEmpty) {
                        this.yGW.yFr.remove(next);
                    } else {
                        next.dTe = linkedList2;
                        next.yFq = str2;
                        next.latitude = d2;
                        next.longitude = d3;
                    }
                    a(this.yGW);
                    ax(str, str3, str4);
                    AppMethodBeat.o(55777);
                }
            } else {
                if (!isEmpty) {
                    com.tencent.mm.plugin.location.a.a aVar = new com.tencent.mm.plugin.location.a.a();
                    aVar.username = str;
                    aVar.dTe = linkedList2;
                    aVar.yFq = str2;
                    aVar.latitude = d2;
                    aVar.longitude = d3;
                    this.yGW.yFr.add(aVar);
                }
                a(this.yGW);
                ax(str, str3, str4);
                AppMethodBeat.o(55777);
            }
        }
    }

    private void ax(final String str, final String str2, final String str3) {
        AppMethodBeat.i(55778);
        for (final c cVar : this.listeners) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.location.model.r.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(55771);
                    cVar.Qa(str);
                    AppMethodBeat.o(55771);
                }
            });
        }
        AppMethodBeat.o(55778);
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(182049);
        Log.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", Integer.valueOf(bVar.yFr.size()));
        if (bVar.yFr.isEmpty()) {
            s.deleteFile(this.path);
            AppMethodBeat.o(182049);
            return true;
        }
        try {
            byte[] byteArray = bVar.toByteArray();
            s.f(this.path, byteArray, byteArray.length);
            AppMethodBeat.o(182049);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TrackRoomListMgr", e2, "", new Object[0]);
            AppMethodBeat.o(182049);
            return false;
        }
    }

    @Override // com.tencent.mm.bi.a
    public final boolean PZ(String str) {
        AppMethodBeat.i(55780);
        if (PY(str).size() > 0) {
            AppMethodBeat.o(55780);
            return true;
        }
        AppMethodBeat.o(55780);
        return false;
    }

    @Override // com.tencent.mm.bi.a
    public final boolean bgJ() {
        AppMethodBeat.i(55781);
        Iterator<com.tencent.mm.plugin.location.a.a> it = this.yGW.yFr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.location.a.a next = it.next();
            Log.d("MicroMsg.TrackRoomListMgr", "info :" + next.dTe.size());
            Iterator<String> it2 = next.dTe.iterator();
            while (true) {
                if (it2.hasNext()) {
                    String next2 = it2.next();
                    Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(next2)));
                    if (next2.equals(z.aTY())) {
                        Log.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                        AppMethodBeat.o(55781);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(55781);
        return false;
    }

    @Override // com.tencent.mm.bi.a
    public final boolean bB(String str, String str2) {
        AppMethodBeat.i(55782);
        boolean contains = PY(str).contains(str2);
        AppMethodBeat.o(55782);
        return contains;
    }

    @Override // com.tencent.mm.bi.a
    public final String bgK() {
        if (this.yGW != null) {
            return this.yGW.yFs;
        }
        return "";
    }

    public final void aDa(String str) {
        AppMethodBeat.i(55783);
        if (this.yGW != null) {
            this.yGW.yFs = str;
        }
        a(this.yGW);
        AppMethodBeat.o(55783);
    }

    @Override // com.tencent.mm.bi.a
    public final synchronized void bgs() {
        boolean z;
        AppMethodBeat.i(55784);
        LinkedList<com.tencent.mm.plugin.location.a.a> linkedList = new LinkedList<>();
        if (this.yGW.yFr != null && !this.yGW.yFr.isEmpty()) {
            com.tencent.mm.plugin.location.a.a[] aVarArr = (com.tencent.mm.plugin.location.a.a[]) this.yGW.yFr.toArray(new com.tencent.mm.plugin.location.a.a[0]);
            for (com.tencent.mm.plugin.location.a.a aVar : aVarArr) {
                if (!Util.isNullOrNil(aVar.dTe)) {
                    boolean z2 = true;
                    Iterator<String> it = aVar.dTe.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(next)));
                        if (next.equals(z.aTY())) {
                            Log.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
                            z = false;
                        } else {
                            z = z2;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        linkedList.add(aVar);
                    }
                }
            }
        }
        b bVar = new b();
        bVar.yFr = linkedList;
        bVar.yFs = this.yGW.yFs;
        a(bVar);
        AppMethodBeat.o(55784);
    }
}
