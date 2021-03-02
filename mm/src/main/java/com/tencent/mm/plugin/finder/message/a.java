package com.tencent.mm.plugin.finder.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-finder_release"})
public final class a extends com.tencent.mm.plugin.byp.a.a {
    public static final C1234a uNE = new C1234a((byte) 0);
    private final b uND = new b();

    static {
        AppMethodBeat.i(248688);
        AppMethodBeat.o(248688);
    }

    public a() {
        AppMethodBeat.i(248687);
        AppMethodBeat.o(248687);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.message.a$a  reason: collision with other inner class name */
    public static final class C1234a {
        private C1234a() {
        }

        public /* synthetic */ C1234a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-finder_release"})
    public static final class b implements aa {
        b() {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void a(ca caVar, de deVar) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void dkt() {
        }
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final int crS() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final int crR() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final aa crT() {
        return this.uND;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final boolean a(cp cpVar) {
        int i2;
        int i3;
        String str;
        AppMethodBeat.i(248686);
        p.h(cpVar, "rawBypMsg");
        String a2 = z.a(cpVar.KGK.KHl);
        String a3 = z.a(cpVar.KGK.KHm);
        boolean z = cpVar.KGN;
        String str2 = cpVar.KGL;
        baf baf = new baf();
        com.tencent.mm.bw.b bVar = cpVar.KGM;
        if (bVar == null || baf.parseFrom(bVar.toByteArray()) == null) {
            Log.e("Finder.BysSyncHandler", "extInfo is null! fromUser=" + a2 + " toUser=" + a3 + " sessionId=" + cpVar.KGL);
            x xVar = x.SXb;
        }
        ag sessionInfoStorage = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage();
        k avz = sessionInfoStorage.avz(str2);
        boolean z2 = avz.systemRowid > 0;
        boolean z3 = (baf.action & 1) > 0;
        if (z3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = avz.field_rejectMsg;
        if ((baf.action & 2) > 0) {
            i3 = 2;
        } else if (!z2) {
            i3 = 1;
        } else {
            Log.e("Finder.BysSyncHandler", "this sessionId[" + str2 + "] has exist, but it will be move to hi holder. just return");
            h.INSTANCE.a(20492, 4L, 1L, str2);
            h.INSTANCE.n(1473, 4, 1);
            i3 = avz.field_type;
        }
        int i5 = (baf.action & 4) > 0 ? 1 : 0;
        if (z) {
            str = a3;
        } else {
            str = a2;
        }
        if (as.bjs(str) || as.bjt(str)) {
            boolean z4 = (avz.field_type == i3 && i2 == avz.field_actionPermission && i5 == avz.field_disableSendMsg && !(p.j(str, avz.field_talker) ^ true)) ? false : true;
            if (z4) {
                String str3 = cpVar.KGL;
                p.g(str3, "rawBypMsg.msg_session_id");
                p.g(str, "talker");
                sessionInfoStorage.a(str3, str, i3, i2, ag.b.RECEIVE, i4, i5);
            }
            Log.i("Finder.BysSyncHandler", "[beforeProcessAddMsg] isNeedReplaceSession=" + z4 + " svrMsgId=" + cpVar.KGK.Brn + " isSender=" + z + " msgType=" + cpVar.KGK.xKb + ' ' + "createTime=" + cpVar.KGK.CreateTime + " isExitSessionInfo=" + z2 + " isSupportSendMedia=" + z3 + " convType=" + i3 + ' ' + "fromUser=" + a2 + " toUser=" + a3 + " sessionId=" + cpVar.KGL + " actionPermission=" + i2 + " extInfo=" + baf.action);
            AppMethodBeat.o(248686);
            return true;
        }
        Log.e("Finder.BysSyncHandler", "[beforeProcessAddMsg] talker[" + str + "] is invalid.");
        h.INSTANCE.a(20492, 3L, 1L, str);
        h.INSTANCE.n(1473, 3, 1);
        AppMethodBeat.o(248686);
        return false;
    }
}
