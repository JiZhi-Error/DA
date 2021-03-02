package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\r\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetSubscribeStatusTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "templateIds", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "templateIdList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class e extends a {
    public static final a jBg = new a((byte) 0);
    private com.tencent.mm.msgsubscription.api.a jAX;
    private List<String> jBf;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223392);
        AppMethodBeat.o(223392);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetSubscribeStatusTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private e(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223390);
        this.jBf = new ArrayList();
        AppMethodBeat.o(223390);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(String str, List<String> list, com.tencent.mm.msgsubscription.d.a aVar, com.tencent.mm.msgsubscription.api.a aVar2) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        p.h(list, "templateIds");
        AppMethodBeat.i(223391);
        this.jzv = aVar;
        this.jAX = aVar2;
        this.jBf.addAll(list);
        AppMethodBeat.o(223391);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/task/GetSubscribeStatusTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class b implements b.c {
        final /* synthetic */ e jBh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(e eVar) {
            this.jBh = eVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223388);
            p.h(str, "errMsg");
            Log.i("MicroMsg.GetSubscribeMsgUIStatusTask", "alvinluo getSubscribeStatus end errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            MMHandlerThread.postToMainThread(new a(this, i2, i3, subscribeMsgRequestResult, str));
            AppMethodBeat.o(223388);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ b jBi;

            a(b bVar, int i2, int i3, SubscribeMsgRequestResult subscribeMsgRequestResult, String str) {
                this.jBi = bVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.jAc = subscribeMsgRequestResult;
                this.$errMsg = str;
            }

            public final void run() {
                AppMethodBeat.i(223387);
                if (this.$errType == 0 && this.$errCode == 0) {
                    com.tencent.mm.msgsubscription.api.a aVar = this.jBi.jBh.jAX;
                    if (aVar != null) {
                        String str = this.jBi.jBh.dVu;
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.jAc;
                        if (subscribeMsgRequestResult == null) {
                            p.hyc();
                        }
                        aVar.a(str, subscribeMsgRequestResult);
                        AppMethodBeat.o(223387);
                        return;
                    }
                    AppMethodBeat.o(223387);
                    return;
                }
                com.tencent.mm.msgsubscription.api.a aVar2 = this.jBi.jBh.jAX;
                if (aVar2 != null) {
                    aVar2.i(this.$errType, this.$errCode, this.$errMsg);
                    AppMethodBeat.o(223387);
                    return;
                }
                AppMethodBeat.o(223387);
            }
        }
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        AppMethodBeat.i(223389);
        b.a.C0462a aVar = b.a.jzu;
        String str = this.dVu;
        List<String> list = this.jBf;
        p.h(str, ch.COL_USERNAME);
        p.h(list, "templateIds");
        com.tencent.mm.msgsubscription.a.b bVar = new com.tencent.mm.msgsubscription.a.b(str, 5);
        bVar.jzo = new b(this);
        for (String str2 : list) {
            List list2 = bVar.jzm;
            efc efc = new efc();
            efc.KSV = str;
            efc.Mqy = str2;
            list2.add(efc);
        }
        d(bVar);
        AppMethodBeat.o(223389);
    }
}
