package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.b;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.w;
import java.util.ArrayList;
import java.util.HashMap;

public final class bj {
    public static boolean Oqc = false;
    private static ArrayList<EmojiGroupInfo> Oqd = new ArrayList<>();
    private static HashMap<String, ArrayList<EmojiInfo>> Oqe = new HashMap<>();
    private static bj Oqh;
    public static int eii = -1;
    public f OpN;
    public c OpO;
    public e OpP;
    public s OpQ;
    public m OpR;
    public o OpS;
    public k OpT;
    public q OpU;
    public t OpV;
    public u OpW;
    public i OpX;
    public w OpY;
    private b OpZ;
    private g Oqa;
    public j Oqb;
    public final MStorage.IOnStorageChange Oqf = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.storage.bj.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(104966);
            if (!Util.isNullOrNil(str) && str.equals("event_update_group")) {
                Log.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", (String) mStorageEventData.obj);
                if (!com.tencent.mm.kernel.g.aAf().azp()) {
                    AppMethodBeat.o(104966);
                    return;
                }
                ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiDescMgr().gCG();
            }
            if (!Util.isNullOrNil(str) && (str.equals("event_update_group") || str.equalsIgnoreCase("productID"))) {
                Log.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                bj.Oqc = true;
                bj.this.Oqb.dX(true);
            }
            AppMethodBeat.o(104966);
        }
    };
    public final MStorage.IOnStorageChange Oqg = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.storage.bj.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(104967);
            ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiDescMgr().gCG();
            AppMethodBeat.o(104967);
        }
    };
    public final MStorage.IOnStorageChange wKf = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.storage.bj.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(104968);
            if (str == null) {
                AppMethodBeat.o(104968);
                return;
            }
            bj.this.Oqb.dV(true);
            bj.this.Oqb.dW(true);
            bj.this.Oqb.dY(true);
            AppMethodBeat.o(104968);
        }
    };
    public final IListener wKg = new IListener<rj>() {
        /* class com.tencent.mm.storage.bj.AnonymousClass4 */

        {
            AppMethodBeat.i(161803);
            this.__eventId = rj.class.getName().hashCode();
            AppMethodBeat.o(161803);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rj rjVar) {
            AppMethodBeat.i(104969);
            Log.i("MicroMsg.emoji.EmojiStorageMgr", "REFRESH_PANEL_EVENT");
            bj.this.Oqb.dV(true);
            bj.this.Oqb.dW(true);
            bj.this.Oqb.dY(true);
            AppMethodBeat.o(104969);
            return false;
        }
    };

    static {
        AppMethodBeat.i(104977);
        AppMethodBeat.o(104977);
    }

    public static synchronized bj gCJ() {
        bj bjVar;
        synchronized (bj.class) {
            AppMethodBeat.i(104970);
            if (Oqh == null) {
                bj bjVar2 = new bj();
                Oqh = bjVar2;
                Log.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
                if (bjVar2.OpN == null) {
                    bjVar2.gCK();
                }
            }
            bjVar = Oqh;
            AppMethodBeat.o(104970);
        }
        return bjVar;
    }

    private bj() {
        AppMethodBeat.i(104971);
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", Util.getStack());
        AppMethodBeat.o(104971);
    }

    public final void gCK() {
        AppMethodBeat.i(104972);
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
        if (com.tencent.mm.kernel.g.aAh().hqK == null || !com.tencent.mm.kernel.g.aAh().hqK.isOpen()) {
            Log.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", com.tencent.mm.kernel.g.aAh().hqK);
        }
        this.OpN = new f(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpO = new c(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpP = new e(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpR = new m(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpS = new o(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpT = new k(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpQ = new s(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpU = new q(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpV = new t(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpW = new u(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpX = new i(com.tencent.mm.kernel.g.aAh().hqK);
        this.OpY = new w();
        this.OpZ = new b(com.tencent.mm.kernel.g.aAh().hqK);
        this.Oqa = new g(com.tencent.mm.kernel.g.aAh().hqK);
        this.Oqb = j.auL();
        AppMethodBeat.o(104972);
    }

    public final f cgN() {
        return this.OpN;
    }

    public final m gCL() {
        return this.OpR;
    }

    public final s gCM() {
        return this.OpQ;
    }

    public final b gCN() {
        return this.OpZ;
    }

    public final g gCO() {
        return this.Oqa;
    }
}
