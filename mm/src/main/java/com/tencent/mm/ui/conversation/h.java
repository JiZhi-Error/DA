package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.im;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.HashMap;

public final class h implements MStorageEx.IOnStorageChange {
    public static h Qdi = new h();
    private static HashMap<String, Integer> Qdj = new HashMap<>();
    private volatile boolean JYf;
    private IListener<db> JYh = new IListener<db>() {
        /* class com.tencent.mm.ui.conversation.h.AnonymousClass1 */

        {
            AppMethodBeat.i(234142);
            this.__eventId = db.class.getName().hashCode();
            AppMethodBeat.o(234142);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(db dbVar) {
            AppMethodBeat.i(234143);
            db dbVar2 = dbVar;
            if (dbVar2.dGl.action == 1) {
                Log.i("MicroMsg.ConversationUnreadHelper", "do init start");
                h.this.JYf = true;
            } else if (dbVar2.dGl.action == 2) {
                Log.i("MicroMsg.ConversationUnreadHelper", "do init end");
                h.this.JYf = false;
                h.gVC();
            }
            AppMethodBeat.o(234143);
            return false;
        }
    };
    private IListener<im> Qdk = new IListener<im>() {
        /* class com.tencent.mm.ui.conversation.h.AnonymousClass2 */

        {
            AppMethodBeat.i(234144);
            this.__eventId = im.class.getName().hashCode();
            AppMethodBeat.o(234144);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(im imVar) {
            AppMethodBeat.i(234145);
            Log.i("MicroMsg.ConversationUnreadHelper", "force refreshAll");
            if (!h.this.JYf) {
                h.gVC();
            }
            AppMethodBeat.o(234145);
            return true;
        }
    };

    static {
        AppMethodBeat.i(234150);
        AppMethodBeat.o(234150);
    }

    private h() {
        AppMethodBeat.i(234146);
        this.JYh.alive();
        this.Qdk.alive();
        AppMethodBeat.o(234146);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        int i3;
        int i4;
        AppMethodBeat.i(234147);
        if (!(obj instanceof String)) {
            Log.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(234147);
            return;
        }
        String str = (String) obj;
        Log.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange %s", str);
        if (mStorageEx instanceof bw) {
            if (!ac.aVd().contains(str)) {
                if (i2 == 5) {
                    synchronized (Qdj) {
                        try {
                            Qdj.clear();
                        } finally {
                            AppMethodBeat.o(234147);
                        }
                    }
                    return;
                }
                long currentTicks = Util.currentTicks();
                synchronized (Qdj) {
                    try {
                        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
                        if (!Qdj.isEmpty()) {
                            if (Qdj.containsKey(str)) {
                                i3 = Qdj.get(str).intValue();
                            } else {
                                i3 = 0;
                            }
                            Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", str);
                            if (!ac.JS(str)) {
                                i4 = ac.aI(str, ab.iCF);
                            } else {
                                i4 = 0;
                            }
                            Qdj.put(str, Integer.valueOf(i4));
                            Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", str, Integer.valueOf(i3), Integer.valueOf(i4));
                            Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                            AppMethodBeat.o(234147);
                            return;
                        }
                        return;
                    } finally {
                        AppMethodBeat.o(234147);
                    }
                }
            }
        } else if (mStorageEx instanceof bv) {
            if (!Util.isNullOrNil(str)) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                if (Kn == null || ((int) Kn.gMZ) <= 0 || ab.IR(str)) {
                    AppMethodBeat.o(234147);
                    return;
                } else {
                    Log.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", Boolean.valueOf(Kn.Zx()), Integer.valueOf(Kn.fuH));
                }
            }
            if (i2 == 5 || i2 == 2 || this.JYf) {
                AppMethodBeat.o(234147);
                return;
            }
            synchronized (Qdj) {
                try {
                    Qdj.clear();
                } finally {
                    AppMethodBeat.o(234147);
                }
            }
            return;
        }
        AppMethodBeat.o(234147);
    }

    public static int gVB() {
        int i2;
        AppMethodBeat.i(234148);
        Log.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", Util.getStack());
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 25);
        synchronized (Qdj) {
            try {
                if (Qdj.isEmpty()) {
                    HashMap<String, az> JQ = ac.JQ(ab.iCF);
                    for (String str : JQ.keySet()) {
                        Qdj.put(str, Integer.valueOf(JQ.get(str).field_unReadCount));
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 26);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 27);
                }
                i2 = 0;
                for (String str2 : Qdj.keySet()) {
                    i2 = Qdj.get(str2).intValue() + i2;
                }
            } finally {
                AppMethodBeat.o(234148);
            }
        }
        return i2;
    }

    static /* synthetic */ void gVC() {
        AppMethodBeat.i(234149);
        long currentTicks = Util.currentTicks();
        synchronized (Qdj) {
            try {
                Qdj.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(234149);
                throw th;
            }
        }
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshAll cost %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(234149);
    }
}
