package com.tencent.mm.msgsubscription.e;

import com.tencent.f.h;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeStatusTimestamp;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "templateList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class i extends a {
    public static final a jBu = new a((byte) 0);
    private com.tencent.mm.msgsubscription.api.a jAX;
    private List<SubscribeMsgTmpItem> jyV;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223413);
        AppMethodBeat.o(223413);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeStatusTimestamp$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private i(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223411);
        this.jyV = new ArrayList();
        AppMethodBeat.o(223411);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private i(String str, List<SubscribeMsgTmpItem> list, com.tencent.mm.msgsubscription.d.a aVar) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        p.h(list, "templateList");
        AppMethodBeat.i(223412);
        this.jzv = aVar;
        this.jyV.addAll(list);
        this.jAX = null;
        AppMethodBeat.o(223412);
    }

    public /* synthetic */ i(String str, List list, com.tencent.mm.msgsubscription.d.a aVar, byte b2) {
        this(str, list, aVar);
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        AppMethodBeat.i(223410);
        c cVar = new c(this);
        if (MMHandlerThread.isMainThread()) {
            cVar.invoke();
            AppMethodBeat.o(223410);
            return;
        }
        h.RTc.aV(new b(cVar));
        AppMethodBeat.o(223410);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ kotlin.g.a.a jBm;

        b(kotlin.g.a.a aVar) {
            this.jBm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(223408);
            this.jBm.invoke();
            AppMethodBeat.o(223408);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i jBv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar) {
            super(0);
            this.jBv = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223409);
            com.tencent.mm.msgsubscription.d.a aVar = this.jBv.jzv;
            if (aVar != null) {
                aVar.d(this.jBv.dVu, this.jBv.jyV);
            }
            d dVar = d.jAR;
            d.a(this.jBv);
            x xVar = x.SXb;
            AppMethodBeat.o(223409);
            return xVar;
        }
    }
}
