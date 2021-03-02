package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.a;
import com.tencent.mm.bh.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements b {
    private com.tencent.mm.plugin.talkroom.a.b FPK;
    private MMHandler handler;
    private HashSet<a> listeners = new HashSet<>();
    private final String path;

    public e() {
        AppMethodBeat.i(29461);
        o oVar = new o(b.ftP());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        this.path = b.ftP() + "talkroomMemberList.info";
        this.handler = new MMHandler(Looper.getMainLooper());
        if (this.FPK == null) {
            if (!s.YS(this.path)) {
                this.FPK = new com.tencent.mm.plugin.talkroom.a.b();
                AppMethodBeat.o(29461);
                return;
            }
            try {
                this.FPK = (com.tencent.mm.plugin.talkroom.a.b) new com.tencent.mm.plugin.talkroom.a.b().parseFrom(s.aW(this.path, 0, -1));
                AppMethodBeat.o(29461);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e2, "", new Object[0]);
                this.FPK = new com.tencent.mm.plugin.talkroom.a.b();
            }
        }
        AppMethodBeat.o(29461);
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized void a(a aVar) {
        AppMethodBeat.i(29462);
        this.listeners.add(aVar);
        AppMethodBeat.o(29462);
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized void b(a aVar) {
        AppMethodBeat.i(29463);
        this.listeners.remove(aVar);
        AppMethodBeat.o(29463);
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized boolean PW(String str) {
        boolean z;
        AppMethodBeat.i(29464);
        Iterator<com.tencent.mm.plugin.talkroom.a.a> it = this.FPK.FPy.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                AppMethodBeat.o(29464);
                break;
            }
            com.tencent.mm.plugin.talkroom.a.a next = it.next();
            if (next.username.equals(str) && next.sceneType == 0) {
                z = true;
                AppMethodBeat.o(29464);
                break;
            }
        }
        return z;
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized boolean bgr() {
        boolean z;
        AppMethodBeat.i(29465);
        Iterator<com.tencent.mm.plugin.talkroom.a.a> it = this.FPK.FPy.iterator();
        loop0:
        while (true) {
            if (!it.hasNext()) {
                z = false;
                AppMethodBeat.o(29465);
                break;
            }
            com.tencent.mm.plugin.talkroom.a.a next = it.next();
            if (next.sceneType == 0) {
                Iterator<egs> it2 = next.dTe.iterator();
                while (it2.hasNext()) {
                    if (z.aTY().equals(it2.next().UserName)) {
                        z = true;
                        AppMethodBeat.o(29465);
                        break loop0;
                    }
                }
                continue;
            }
        }
        return z;
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized void bgs() {
        boolean z;
        AppMethodBeat.i(179740);
        LinkedList<com.tencent.mm.plugin.talkroom.a.a> linkedList = new LinkedList<>();
        if (this.FPK.FPy != null && !this.FPK.FPy.isEmpty()) {
            com.tencent.mm.plugin.talkroom.a.a[] aVarArr = (com.tencent.mm.plugin.talkroom.a.a[]) this.FPK.FPy.toArray(new com.tencent.mm.plugin.talkroom.a.a[0]);
            for (com.tencent.mm.plugin.talkroom.a.a aVar : aVarArr) {
                if (!Util.isNullOrNil(aVar.dTe)) {
                    boolean z2 = true;
                    Iterator<egs> it = aVar.dTe.iterator();
                    while (it.hasNext()) {
                        egs next = it.next();
                        Log.d("MicroMsg.TalkRoomInfoListMgr", "member :".concat(String.valueOf(next)));
                        if (next.UserName.equals(z.aTY())) {
                            Log.i("MicroMsg.TalkRoomInfoListMgr", "reset list info and remove self location info");
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
        com.tencent.mm.plugin.talkroom.a.b bVar = new com.tencent.mm.plugin.talkroom.a.b();
        bVar.FPy = linkedList;
        a(bVar);
        AppMethodBeat.o(179740);
    }

    public final synchronized LinkedList<egs> aSV(String str) {
        LinkedList<egs> linkedList;
        AppMethodBeat.i(29466);
        Iterator<com.tencent.mm.plugin.talkroom.a.a> it = this.FPK.FPy.iterator();
        while (true) {
            if (!it.hasNext()) {
                linkedList = new LinkedList<>();
                AppMethodBeat.o(29466);
                break;
            }
            com.tencent.mm.plugin.talkroom.a.a next = it.next();
            if (next.username.equals(str)) {
                linkedList = (LinkedList) next.dTe.clone();
                AppMethodBeat.o(29466);
                break;
            }
        }
        return linkedList;
    }

    @Override // com.tencent.mm.bh.b
    public final synchronized void a(String str, LinkedList<egs> linkedList, String str2, String str3, int i2) {
        AppMethodBeat.i(29467);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        Log.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", str, Integer.valueOf(linkedList.size()));
        LinkedList<egs> linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator<com.tencent.mm.plugin.talkroom.a.a> it = this.FPK.FPy.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.mm.plugin.talkroom.a.a next = it.next();
                if (next.username.equals(str)) {
                    if (isEmpty) {
                        this.FPK.FPy.remove(next);
                    } else {
                        next.dTe = linkedList2;
                        next.sceneType = i2;
                    }
                    a(this.FPK);
                    ax(str, str2, str3);
                    AppMethodBeat.o(29467);
                }
            } else {
                if (!isEmpty) {
                    com.tencent.mm.plugin.talkroom.a.a aVar = new com.tencent.mm.plugin.talkroom.a.a();
                    aVar.username = str;
                    aVar.dTe = linkedList2;
                    aVar.sceneType = i2;
                    this.FPK.FPy.add(aVar);
                }
                a(this.FPK);
                ax(str, str2, str3);
                AppMethodBeat.o(29467);
            }
        }
    }

    private void ax(final String str, final String str2, final String str3) {
        AppMethodBeat.i(29468);
        Iterator<a> it = this.listeners.iterator();
        while (it.hasNext()) {
            final a next = it.next();
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.talkroom.model.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29460);
                    next.h(str, str2, str3);
                    AppMethodBeat.o(29460);
                }
            });
        }
        AppMethodBeat.o(29468);
    }

    private boolean a(com.tencent.mm.plugin.talkroom.a.b bVar) {
        AppMethodBeat.i(179741);
        if (bVar.FPy.isEmpty()) {
            s.deleteFile(this.path);
            AppMethodBeat.o(179741);
            return true;
        }
        try {
            byte[] byteArray = bVar.toByteArray();
            s.f(this.path, byteArray, byteArray.length);
            AppMethodBeat.o(179741);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e2, "", new Object[0]);
            AppMethodBeat.o(179741);
            return false;
        }
    }
}
