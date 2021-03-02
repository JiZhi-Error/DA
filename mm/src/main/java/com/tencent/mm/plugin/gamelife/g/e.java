package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-gamelife_release"})
public final class e extends com.tencent.mm.plugin.byp.a.a {
    public static final a ycm = new a((byte) 0);
    private final b ycl = new b();

    static {
        AppMethodBeat.i(241407);
        AppMethodBeat.o(241407);
    }

    public e() {
        AppMethodBeat.i(241406);
        AppMethodBeat.o(241406);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-gamelife_release"})
    public static final class b implements aa {
        b() {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void a(ca caVar, de deVar) {
            AppMethodBeat.i(241403);
            Log.i("GameLife.MsgSyncHandler", "[notifyNewMsg] msg=" + caVar + " addMsg=" + deVar);
            AppMethodBeat.o(241403);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void dkt() {
            AppMethodBeat.i(241404);
            Log.i("GameLife.MsgSyncHandler", "flushNotifyAllMsg");
            AppMethodBeat.o(241404);
        }
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final int crS() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final int crR() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final aa crT() {
        return this.ycl;
    }

    @Override // com.tencent.mm.plugin.byp.a.a
    public final boolean a(cp cpVar) {
        String str;
        AppMethodBeat.i(241405);
        p.h(cpVar, "rawBypMsg");
        de deVar = cpVar.KGK;
        boolean z = cpVar.KGN;
        String str2 = cpVar.KGL;
        String a2 = z.a(deVar.KHm);
        String a3 = z.a(deVar.KHl);
        String str3 = z ? a2 : a3;
        if (z) {
            str = a3;
        } else {
            str = a2;
        }
        c cVar = new c();
        com.tencent.mm.bw.b bVar = cpVar.KGM;
        p.g(bVar, "rawBypMsg.extinfo");
        com.tencent.mm.bw.a parseFrom = cVar.parseFrom(bVar.zy);
        if (parseFrom == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.autogen.GameLifeMsgExtInfo");
            AppMethodBeat.o(241405);
            throw tVar;
        }
        c cVar2 = (c) parseFrom;
        if (!(cVar2.ybd == null || cVar2.ybd.ybn == null)) {
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_GAME_LIFE_LAST_SAVED_MSG_TYPE_INT, Integer.valueOf(cVar2.ybd.ybm));
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_GAME_LIFE_LAST_SAVED_EXTERN_INFO_STRING, cVar2.ybd.ybn);
        }
        com.tencent.mm.plugin.gamelife.j.c sessionInfoStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getSessionInfoStorage();
        p.g(str2, "sessionId");
        p.g(str, "selfUsername");
        p.g(str3, "talker");
        sessionInfoStorage.a(str2, str, str3, cVar2);
        Log.i("GameLife.MsgSyncHandler", "[beforeProcessAddMsg] svrMsgId=" + cpVar.KGK.Brn + " isSender=" + z + " msgType=" + cpVar.KGK.xKb + ' ' + "createTime=" + cpVar.KGK.CreateTime + " fromUser=" + a3 + " toUser=" + a2 + " sessionId=" + cpVar.KGL + ' ');
        AppMethodBeat.o(241405);
        return true;
    }
}
