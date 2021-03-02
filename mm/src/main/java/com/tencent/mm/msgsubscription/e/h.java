package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "bizUsername", "", "(Ljava/lang/String;)V", "appId", "buffer", "", IssueStorage.COLUMN_EXT_INFO, "isForRequestDialog", "", "isOpened", "mCallback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "cancel", "", "getKey", "getType", "", "run", "Companion", "plugin-comm_release"})
public final class h extends a {
    public static final a jBq = new a((byte) 0);
    private String appId;
    private byte[] buffer;
    private String extInfo;
    private com.tencent.mm.msgsubscription.api.a jAX;
    private boolean jBo;
    private com.tencent.mm.msgsubscription.a.b jBp;
    private List<SubscribeMsgTmpItem> jyV;
    private boolean jyo;
    private SubscribeMsgRequestDialogUiData jzc;
    private com.tencent.mm.msgsubscription.d.a jzv;

    static {
        AppMethodBeat.i(223407);
        AppMethodBeat.o(223407);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeListTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(String str) {
        super(str);
        p.h(str, "bizUsername");
        AppMethodBeat.i(223405);
        this.jyV = new ArrayList();
        this.appId = "";
        this.buffer = new byte[]{0};
        this.extInfo = "";
        AppMethodBeat.o(223405);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/task/UpdateSubscribeListTask$run$netSceneEndCallback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class b implements b.c {
        final /* synthetic */ h jBr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(h hVar) {
            this.jBr = hVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            boolean z;
            String str2;
            boolean z2;
            ArrayList<SubscribeMsgTmpItem> arrayList;
            ArrayList<SubscribeMsgTmpItem> arrayList2;
            AppMethodBeat.i(223401);
            p.h(str, "errMsg");
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(this.jBr.hashCode());
            objArr[4] = (subscribeMsgRequestResult == null || (arrayList2 = subscribeMsgRequestResult.jyk) == null) ? null : Integer.valueOf(arrayList2.size());
            Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end errType: %d, errCode: %d, errMsg: %s, hashCode: %s, tmpSize: %s", objArr);
            z.a aVar = new z.a();
            aVar.SYB = false;
            if (this.jBr.dVu.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str2 = this.jBr.dVu;
            } else {
                str2 = this.jBr.appId;
            }
            if (i2 == 0 && i3 == 0 && !this.jBr.jBo) {
                if (!this.jBr.jyV.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!(!z2 || subscribeMsgRequestResult == null || (arrayList = subscribeMsgRequestResult.jyk) == null)) {
                    if (!arrayList.isEmpty()) {
                        Log.d("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end and save to local");
                        aVar.SYB = true;
                    }
                }
                com.tencent.f.h.RTc.aV(new a(this, aVar, str2, subscribeMsgRequestResult));
            }
            com.tencent.f.h.RTc.aV(new RunnableC0473b(this, i2, i3, str2, subscribeMsgRequestResult, str));
            AppMethodBeat.o(223401);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ String hLl;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ b jBs;
            final /* synthetic */ z.a jBt;

            a(b bVar, z.a aVar, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                this.jBs = bVar;
                this.jBt = aVar;
                this.hLl = str;
                this.jAc = subscribeMsgRequestResult;
            }

            public final void run() {
                boolean z;
                ArrayList<SubscribeMsgTmpItem> arrayList = null;
                AppMethodBeat.i(223399);
                if (this.jBt.SYB) {
                    com.tencent.mm.msgsubscription.d.a aVar = this.jBs.jBr.jzv;
                    if (aVar != null) {
                        String str = this.hLl;
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.jAc;
                        if (subscribeMsgRequestResult != null) {
                            arrayList = subscribeMsgRequestResult.jyk;
                        }
                        if (arrayList == null) {
                            p.hyc();
                        }
                        aVar.b(str, arrayList, this.jAc.jyo, true, false);
                        AppMethodBeat.o(223399);
                        return;
                    }
                    AppMethodBeat.o(223399);
                    return;
                }
                com.tencent.mm.msgsubscription.d.a aVar2 = this.jBs.jBr.jzv;
                if (aVar2 != null) {
                    String str2 = this.hLl;
                    SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.jAc;
                    if (subscribeMsgRequestResult2 != null) {
                        z = subscribeMsgRequestResult2.jyo;
                    } else {
                        z = false;
                    }
                    aVar2.b(str2, null, z, true, false);
                    AppMethodBeat.o(223399);
                    return;
                }
                AppMethodBeat.o(223399);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.msgsubscription.e.h$b$b  reason: collision with other inner class name */
        static final class RunnableC0473b implements Runnable {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ String hLl;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ b jBs;

            RunnableC0473b(b bVar, int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult, String str2) {
                this.jBs = bVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.hLl = str;
                this.jAc = subscribeMsgRequestResult;
                this.$errMsg = str2;
            }

            public final void run() {
                AppMethodBeat.i(223400);
                if (this.$errType == 0 && this.$errCode == 0) {
                    com.tencent.mm.msgsubscription.api.a aVar = this.jBs.jBr.jAX;
                    if (aVar != null) {
                        String str = this.hLl;
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.jAc;
                        if (subscribeMsgRequestResult == null) {
                            p.hyc();
                        }
                        aVar.a(str, subscribeMsgRequestResult);
                        AppMethodBeat.o(223400);
                        return;
                    }
                    AppMethodBeat.o(223400);
                    return;
                }
                Log.e("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList failed");
                com.tencent.mm.msgsubscription.api.a aVar2 = this.jBs.jBr.jAX;
                if (aVar2 != null) {
                    aVar2.i(this.$errType, this.$errCode, this.$errMsg);
                    AppMethodBeat.o(223400);
                    return;
                }
                AppMethodBeat.o(223400);
            }
        }
    }

    @Override // com.tencent.mm.msgsubscription.e.f
    public final void run() {
        com.tencent.mm.msgsubscription.a.b a2;
        AppMethodBeat.i(223402);
        Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList %s, isOpened: %b", this.dVu, Boolean.valueOf(this.jyo));
        b bVar = new b(this);
        if (this.jBo) {
            b.a.C0462a aVar = b.a.jzu;
            a2 = b.a.C0462a.a(this.dVu, this.appId, this.jyV, this.extInfo, bVar, this.jyo, this.buffer, this.jzc);
        } else {
            b.a.C0462a aVar2 = b.a.jzu;
            String str = this.dVu;
            String str2 = this.appId;
            List<SubscribeMsgTmpItem> list = this.jyV;
            boolean z = this.jyo;
            p.h(str, ch.COL_USERNAME);
            p.h(str2, "appId");
            p.h(list, "templates");
            a2 = b.a.C0462a.a(str, str2, z, bVar, list, new byte[0]);
        }
        this.jBp = a2;
        com.tencent.mm.msgsubscription.a.b bVar2 = this.jBp;
        if (bVar2 == null) {
            p.hyc();
        }
        d(bVar2);
        AppMethodBeat.o(223402);
    }

    @Override // com.tencent.mm.msgsubscription.e.a
    public final void cancel() {
        AppMethodBeat.i(223403);
        super.cancel();
        Object[] objArr = new Object[1];
        com.tencent.mm.msgsubscription.a.b bVar = this.jBp;
        objArr[0] = bVar != null ? Integer.valueOf(bVar.hashCode()) : null;
        Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList cancel task: %s", objArr);
        com.tencent.mm.msgsubscription.a.a aVar = com.tencent.mm.msgsubscription.a.a.jzi;
        com.tencent.mm.msgsubscription.a.a.a(this.jBp);
        AppMethodBeat.o(223403);
    }

    @Override // com.tencent.mm.msgsubscription.e.a
    public final String getKey() {
        boolean z;
        String str;
        AppMethodBeat.i(223404);
        if (this.dVu.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = this.dVu;
        } else {
            str = this.appId;
        }
        String str2 = str + ",1";
        AppMethodBeat.o(223404);
        return str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(c cVar, com.tencent.mm.msgsubscription.d.a aVar) {
        this(cVar.username);
        p.h(cVar, "updateRequest");
        AppMethodBeat.i(223406);
        this.jzv = aVar;
        this.appId = cVar.appId;
        this.jyV.addAll(cVar.jyV);
        this.jAX = cVar.jze;
        this.jyo = cVar.jzb;
        this.buffer = cVar.buffer;
        this.jzc = cVar.jzc;
        this.extInfo = cVar.extInfo;
        this.jBo = cVar.jzd;
        AppMethodBeat.o(223406);
    }
}
