package com.tencent.mm.msgsubscription.d;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.msgsubscription.e.g;
import com.tencent.mm.msgsubscription.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ8\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ8\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ8\u0010\u001a\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fJ\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "", "subscribeStorageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "getLocalSubscribeList", "", ch.COL_USERNAME, "", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "bizUsername", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", IssueStorage.COLUMN_EXT_INFO, "getSubscribeListByUsername", "getSubscribeStatus", "", "updateLocalSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", AppMeasurement.Param.TIMESTAMP, "", "updateLocalSubscribeSwitchOpened", "isOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "plugin-comm_release"})
public final class b {
    public static final a jAC = new a((byte) 0);
    public final a jAB;

    static {
        AppMethodBeat.i(149650);
        AppMethodBeat.o(149650);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$Companion;", "", "()V", "SCENE_FROM_PROFILE", "", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(a aVar) {
        AppMethodBeat.i(149649);
        this.jAB = aVar;
        AppMethodBeat.o(149649);
    }

    public final void a(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(223339);
        p.h(str, "bizUsername");
        p.h(list, "toSaveList");
        if (this.jAB == null) {
            AppMethodBeat.o(223339);
            return;
        }
        d dVar = d.jAR;
        d.a(this.jAB, new g(str, list, z, z2, z3, this.jAB, (byte) 0));
        AppMethodBeat.o(223339);
    }

    public final void a(String str, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223340);
        p.h(str, ch.COL_USERNAME);
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", str);
        if (this.jAB == null) {
            AppMethodBeat.o(223340);
            return;
        }
        d dVar = d.jAR;
        d.a(this.jAB, new com.tencent.mm.msgsubscription.e.b(str, this.jAB, aVar));
        AppMethodBeat.o(223340);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(223341);
        p.h(cVar, "updateRequest");
        if (this.jAB == null) {
            AppMethodBeat.o(223341);
            return;
        }
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateSubscribeList username: " + cVar.username + ", appId: " + cVar.appId + ", size: " + cVar.jyV.size());
        d dVar = d.jAR;
        a aVar = this.jAB;
        h hVar = new h(cVar, this.jAB);
        hVar.jzf = cVar.jzf;
        hVar.jzg = cVar.jzg;
        d.a(aVar, hVar);
        AppMethodBeat.o(223341);
    }
}
