package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.protobuf.bp;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aj extends q implements m {
    public static i gNh = new i() {
        /* class com.tencent.mm.plugin.game.model.aj.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(41581);
            g.azz().b(2641, this);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
                final bq dVX = ((aj) qVar).dVX();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.game.model.aj.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(41580);
                        aj.a(dVX);
                        AppMethodBeat.o(41580);
                    }
                });
                AppMethodBeat.o(41581);
                return;
            }
            Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
            AppMethodBeat.o(41581);
        }
    };
    public static final String xHL = (b.c(b.a.PERMANENT) + "tabnav/");
    private i callback;
    private final d hhm;

    /* access modifiers changed from: package-private */
    public interface a {
        void onComplete();
    }

    static /* synthetic */ void b(List list, a aVar) {
        AppMethodBeat.i(41590);
        a(list, aVar);
        AppMethodBeat.o(41590);
    }

    static {
        AppMethodBeat.i(41591);
        AppMethodBeat.o(41591);
    }

    public aj() {
        AppMethodBeat.i(41584);
        d.a aVar = new d.a();
        aVar.iLN = new bp();
        aVar.iLO = new bq();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        AppMethodBeat.o(41584);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41585);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41585);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2641;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(41586);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41586);
        return dispatch;
    }

    public final bq dVX() {
        return (bq) this.hhm.iLL.iLR;
    }

    public static void updateData() {
        AppMethodBeat.i(41587);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
        g.azz().a(2641, gNh);
        g.azz().a(new aj(), 0);
        AppMethodBeat.o(41587);
    }

    public static void a(final bq bqVar) {
        AppMethodBeat.i(41588);
        if (bqVar == null) {
            AppMethodBeat.o(41588);
        } else if (Util.isNullOrNil(bqVar.xKD)) {
            Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
            AppMethodBeat.o(41588);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<aw> it = bqVar.xKD.iterator();
            while (it.hasNext()) {
                aw next = it.next();
                if (next != null) {
                    arrayList.add(next.xKP);
                    arrayList.add(next.xKQ);
                }
            }
            a(arrayList, new a() {
                /* class com.tencent.mm.plugin.game.model.aj.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.game.model.aj.a
                public final void onComplete() {
                    AppMethodBeat.i(41582);
                    Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
                    ((f) g.af(f.class)).dSL().b("game_index4_tab_nav", bqVar);
                    AppMethodBeat.o(41582);
                }
            });
            AppMethodBeat.o(41588);
        }
    }

    private static void a(final List<String> list, final a aVar) {
        AppMethodBeat.i(41589);
        while (!Util.isNullOrNil(list)) {
            final String remove = list.remove(0);
            if (Util.isNullOrNil(remove)) {
                Log.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
            } else {
                c.a aVar2 = new c.a();
                aVar2.jbf = true;
                aVar2.fullPath = xHL + com.tencent.mm.b.g.getMessageDigest(remove.getBytes());
                com.tencent.mm.av.q.bcV().a(remove, aVar2.bdv(), new com.tencent.mm.av.a.c.d() {
                    /* class com.tencent.mm.plugin.game.model.aj.AnonymousClass3 */

                    @Override // com.tencent.mm.av.a.c.d
                    public final void a(boolean z, Object... objArr) {
                        AppMethodBeat.i(204179);
                        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", Boolean.valueOf(z), remove);
                        aj.b(list, aVar);
                        AppMethodBeat.o(204179);
                    }
                });
                AppMethodBeat.o(41589);
                return;
            }
        }
        if (aVar != null) {
            aVar.onComplete();
        }
        AppMethodBeat.o(41589);
    }
}
