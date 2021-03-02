package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "updateTimestamp", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Companion", "plugin-comm_release"})
public final class b extends a {
    public static final a jAY = new a((byte) 0);
    private com.tencent.mm.msgsubscription.api.a jAX;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223375);
        AppMethodBeat.o(223375);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(String str) {
        super(str);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(223373);
        AppMethodBeat.o(223373);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeListTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, com.tencent.mm.msgsubscription.d.a aVar, com.tencent.mm.msgsubscription.api.a aVar2) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        p.h(aVar, "storageManager");
        AppMethodBeat.i(223374);
        this.jzv = aVar;
        this.jAX = aVar2;
        AppMethodBeat.o(223374);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/task/GetAllSubscribeListTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.e.b$b  reason: collision with other inner class name */
    public static final class C0472b implements b.c {
        final /* synthetic */ b jAZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0472b(b bVar) {
            this.jAZ = bVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            ArrayList<SubscribeMsgTmpItem> arrayList;
            AppMethodBeat.i(223371);
            p.h(str, "errMsg");
            Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getSubscribeMsgListByUsername end errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 0 && i3 == 0) {
                if (subscribeMsgRequestResult != null) {
                    arrayList = subscribeMsgRequestResult.jyk;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    b.aJ(subscribeMsgRequestResult.jyk);
                    com.tencent.mm.msgsubscription.d.a aVar = this.jAZ.jzv;
                    if (aVar != null) {
                        aVar.a(this.jAZ.dVu, subscribeMsgRequestResult.jyk, subscribeMsgRequestResult.jyo);
                    }
                }
            }
            MMHandlerThread.postToMainThread(new a(this, i2, i3, subscribeMsgRequestResult, str));
            AppMethodBeat.o(223371);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.msgsubscription.e.b$b$a */
        static final class a implements Runnable {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ C0472b jBa;

            a(C0472b bVar, int i2, int i3, SubscribeMsgRequestResult subscribeMsgRequestResult, String str) {
                this.jBa = bVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.jAc = subscribeMsgRequestResult;
                this.$errMsg = str;
            }

            public final void run() {
                AppMethodBeat.i(223370);
                if (this.$errType == 0 && this.$errCode == 0) {
                    com.tencent.mm.msgsubscription.api.a aVar = this.jBa.jAZ.jAX;
                    if (aVar != null) {
                        String str = this.jBa.jAZ.dVu;
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.jAc;
                        if (subscribeMsgRequestResult == null) {
                            p.hyc();
                        }
                        aVar.a(str, subscribeMsgRequestResult);
                        AppMethodBeat.o(223370);
                        return;
                    }
                    AppMethodBeat.o(223370);
                    return;
                }
                com.tencent.mm.msgsubscription.api.a aVar2 = this.jBa.jAZ.jAX;
                if (aVar2 != null) {
                    aVar2.i(this.$errType, this.$errCode, this.$errMsg);
                    AppMethodBeat.o(223370);
                    return;
                }
                AppMethodBeat.o(223370);
            }
        }
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        AppMethodBeat.i(223372);
        Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getAllSubscribeStatus run");
        b.a.C0462a aVar = b.a.jzu;
        d(b.a.C0462a.a(this.dVu, new C0472b(this)));
        AppMethodBeat.o(223372);
    }

    public static final /* synthetic */ void aJ(List list) {
        AppMethodBeat.i(223376);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((SubscribeMsgTmpItem) it.next()).jyC = currentTimeMillis;
        }
        AppMethodBeat.o(223376);
    }
}
