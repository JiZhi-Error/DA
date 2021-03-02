package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.d.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetLocalSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class c extends a {
    public static final a jBb = new a((byte) 0);
    private com.tencent.mm.msgsubscription.api.a jAX;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223380);
        AppMethodBeat.o(223380);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetLocalSubscribeListTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223378);
        AppMethodBeat.o(223378);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, com.tencent.mm.msgsubscription.d.a aVar, com.tencent.mm.msgsubscription.api.a aVar2) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(223379);
        this.jzv = aVar;
        this.jAX = aVar2;
        AppMethodBeat.o(223379);
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        boolean z;
        List<SubscribeMsgTmpItem> list;
        AppMethodBeat.i(223377);
        com.tencent.mm.msgsubscription.d.a aVar = this.jzv;
        ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA = aVar != null ? aVar.RA(this.dVu) : null;
        ArrayList arrayList = new ArrayList();
        if (!(RA == null || (list = RA.jyV) == null)) {
            for (T t : list) {
                if (t.jyz == 3) {
                    arrayList.add(t);
                }
            }
        }
        com.tencent.mm.msgsubscription.api.a aVar2 = this.jAX;
        if (aVar2 != null) {
            String str = this.dVu;
            if (RA != null) {
                z = RA.jyW;
            } else {
                z = false;
            }
            aVar2.a(str, new SubscribeMsgRequestResult(arrayList, z));
        }
        d dVar = d.jAR;
        d.a(this);
        AppMethodBeat.o(223377);
    }
}
