package com.tencent.mm.msgsubscription.e;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BM\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", ch.COL_USERNAME, "", "appId", "subscribeUrl", "templateIdList", "", IssueStorage.COLUMN_EXT_INFO, "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class d extends a {
    public static final a jBc = new a((byte) 0);
    private String appId;
    private String extInfo;
    private com.tencent.mm.msgsubscription.api.a jAX;
    private ArrayList<String> jzS;
    private String jzp;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223386);
        AppMethodBeat.o(223386);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223384);
        this.jzp = "";
        this.appId = "";
        this.jzS = new ArrayList<>();
        this.extInfo = "";
        AppMethodBeat.o(223384);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, String str3, List<String> list, String str4, com.tencent.mm.msgsubscription.d.a aVar, com.tencent.mm.msgsubscription.api.a aVar2) {
        this(str);
        boolean z;
        d dVar;
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "appId");
        p.h(str3, "subscribeUrl");
        p.h(list, "templateIdList");
        p.h(str4, IssueStorage.COLUMN_EXT_INFO);
        AppMethodBeat.i(223385);
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar = this;
        } else {
            if (str2.length() > 0) {
                str = str2;
                dVar = this;
            } else {
                str = "";
                dVar = this;
            }
        }
        p.h(str, "<set-?>");
        dVar.dVu = str;
        this.appId = str2;
        this.jzv = aVar;
        this.jAX = aVar2;
        this.jzp = str3;
        this.jzS.addAll(list);
        this.extInfo = str4;
        AppMethodBeat.o(223385);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask$run$callback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class b implements b.c {
        final /* synthetic */ d jBd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.jBd = dVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223382);
            p.h(str, "errMsg");
            Log.i("MicroMsg.GetSubscribeMsgListForDialogTask", "alvinluo getSubscribeMsgListForDialogTask end errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            h.RTc.aV(new a(this, i2, i3, subscribeMsgRequestResult, str));
            AppMethodBeat.o(223382);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ b jBe;

            a(b bVar, int i2, int i3, SubscribeMsgRequestResult subscribeMsgRequestResult, String str) {
                this.jBe = bVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.jAc = subscribeMsgRequestResult;
                this.$errMsg = str;
            }

            public final void run() {
                AppMethodBeat.i(223381);
                if (this.$errType == 0 && this.$errCode == 0) {
                    com.tencent.mm.msgsubscription.api.a aVar = this.jBe.jBd.jAX;
                    if (aVar != null) {
                        String str = this.jBe.jBd.dVu;
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.jAc;
                        if (subscribeMsgRequestResult == null) {
                            p.hyc();
                        }
                        aVar.a(str, subscribeMsgRequestResult);
                        AppMethodBeat.o(223381);
                        return;
                    }
                    AppMethodBeat.o(223381);
                    return;
                }
                com.tencent.mm.msgsubscription.api.a aVar2 = this.jBe.jBd.jAX;
                if (aVar2 != null) {
                    aVar2.i(this.$errType, this.$errCode, this.$errMsg);
                    AppMethodBeat.o(223381);
                    return;
                }
                AppMethodBeat.o(223381);
            }
        }
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        com.tencent.mm.msgsubscription.a.b a2;
        AppMethodBeat.i(223383);
        b bVar = new b(this);
        if (this.appId.length() > 0) {
            b.a.C0462a aVar = b.a.jzu;
            a2 = b.a.C0462a.a("", this.appId, this.jzp, this.jzS, this.extInfo, bVar);
        } else {
            b.a.C0462a aVar2 = b.a.jzu;
            a2 = b.a.C0462a.a(this.dVu, "", this.jzp, this.jzS, this.extInfo, bVar);
        }
        d(a2);
        AppMethodBeat.o(223383);
    }
}
