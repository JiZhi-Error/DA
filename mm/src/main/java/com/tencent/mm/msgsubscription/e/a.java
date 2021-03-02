package com.tencent.mm.msgsubscription.e;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.d.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/task/ISubscribeMsgTask;", "bizUsername", "", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "getCancelled", "setCancelled", "replaced", "getReplaced", "setReplaced", "cancel", "", "getKey", "isAsync", "isCanReplacedByKey", "isCancelled", "runNetScene", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "plugin-comm_release"})
public abstract class a implements f {
    public boolean cancelled;
    String dVu;
    public boolean jzf;
    public boolean jzg;

    public a(String str) {
        p.h(str, "bizUsername");
        this.dVu = str;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public String getKey() {
        return String.valueOf(hashCode());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask$runNetScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.e.a$a  reason: collision with other inner class name */
    public static final class C0471a implements b.c {
        final /* synthetic */ a jAV;
        final /* synthetic */ b.c jAW;

        C0471a(a aVar, b.c cVar) {
            this.jAV = aVar;
            this.jAW = cVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(149663);
            p.h(str, "errMsg");
            d dVar = d.jAR;
            d.a(this.jAV);
            b.c cVar = this.jAW;
            if (cVar != null) {
                cVar.a(i2, i3, str, subscribeMsgRequestResult);
                AppMethodBeat.o(149663);
                return;
            }
            AppMethodBeat.o(149663);
        }
    }

    public final void d(b bVar) {
        p.h(bVar, "netScene");
        bVar.jzo = new C0471a(this, bVar.jzo);
        bVar.a(com.tencent.mm.msgsubscription.a.a.jzi);
    }
}
