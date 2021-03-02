package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.d.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BM\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB\r\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateLocalSubscribeStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class g extends a {
    public static final a jBl = new a((byte) 0);
    private com.tencent.mm.msgsubscription.api.a jAX;
    private boolean jBj;
    private boolean jBk;
    private List<SubscribeMsgTmpItem> jyV;
    private boolean jzb;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223398);
        AppMethodBeat.o(223398);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateLocalSubscribeStatus$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private g(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223396);
        this.jyV = new ArrayList();
        AppMethodBeat.o(223396);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private g(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3, com.tencent.mm.msgsubscription.d.a aVar) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        p.h(list, "toSaveList");
        AppMethodBeat.i(223397);
        this.jzv = aVar;
        this.jAX = null;
        this.jyV.addAll(list);
        this.jzb = z;
        this.jBj = z2;
        this.jBk = z3;
        AppMethodBeat.o(223397);
    }

    public /* synthetic */ g(String str, List list, boolean z, boolean z2, boolean z3, com.tencent.mm.msgsubscription.d.a aVar, byte b2) {
        this(str, list, z, z2, z3, aVar);
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        AppMethodBeat.i(223395);
        c cVar = new c(this);
        if (MMHandlerThread.isMainThread()) {
            cVar.invoke();
            AppMethodBeat.o(223395);
            return;
        }
        MMHandlerThread.postToMainThread(new b(cVar));
        AppMethodBeat.o(223395);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ kotlin.g.a.a jBm;

        b(kotlin.g.a.a aVar) {
            this.jBm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(223393);
            this.jBm.invoke();
            AppMethodBeat.o(223393);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g jBn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(0);
            this.jBn = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223394);
            com.tencent.mm.msgsubscription.d.a aVar = this.jBn.jzv;
            if (aVar != null) {
                aVar.b(this.jBn.dVu, this.jBn.jyV, this.jBn.jzb, this.jBn.jBj, this.jBn.jBk);
            }
            d dVar = d.jAR;
            d.a(this.jBn);
            x xVar = x.SXb;
            AppMethodBeat.o(223394);
            return xVar;
        }
    }
}
