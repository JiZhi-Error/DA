package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.storage.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J*\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u000fJ\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J0\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", f.NAME, "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "newConv", "beforeConversationUpdate", "isConsumed", "", "checkInsertHolder", "checkInsertHolderInternal", "onConversationMsgEmpty", "sessionId", "", "updateFinderConversation", "pDigest", "Lcom/tencent/mm/pointers/PString;", "pDigestUser", "insertCount", "", "Companion", "plugin-finder_release"})
public final class i implements g {
    public static final a tyS = new a((byte) 0);
    private final kotlin.f nDW = kotlin.g.ah(d.tyV);
    private final kotlin.f tyR = kotlin.g.ah(c.tyU);

    static {
        AppMethodBeat.i(242759);
        AppMethodBeat.o(242759);
    }

    private final e cZz() {
        AppMethodBeat.i(242757);
        e eVar = (e) this.nDW.getValue();
        AppMethodBeat.o(242757);
        return eVar;
    }

    private final ag getSessionInfoStorage() {
        AppMethodBeat.i(242756);
        ag agVar = (ag) this.tyR.getValue();
        AppMethodBeat.o(242756);
        return agVar;
    }

    public i() {
        AppMethodBeat.i(242758);
        AppMethodBeat.o(242758);
    }

    public static final /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(242760);
        iVar.cZy();
        AppMethodBeat.o(242760);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void cZy() {
        AppMethodBeat.i(242753);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bw aST = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("findersessionholder");
        aST.bI(linkedList);
        c avq = cZz().avq("findersayhisessionholder");
        if (avq.systemRowid < 0) {
            c cVar = new c();
            cVar.field_sessionId = "findersayhisessionholder";
            cVar.field_talker = "findersayhisessionholder";
            cVar.field_placedFlag = 1000;
            cVar.field_type = 100;
            cVar.field_scene = 2;
            cVar.field_unReadCount = cZz().gk(2, 1);
            cZz().insert(cVar);
        }
        Log.i("Finder.ConversationUpdater", "[checkInsertHolder] " + com.tencent.mm.plugin.finder.storage.f.b(avq));
        AppMethodBeat.o(242753);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, i.c cVar, boolean[] zArr) {
        int i2;
        int i3;
        AppMethodBeat.i(242754);
        p.h(cVar, "notifyInfo");
        p.h(zArr, "isConsumed");
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bw aST = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST();
        if (as.avl(cVar.talker)) {
            if (caVar == null || caVar.ajL() != 0) {
                if (p.j(cVar.zqn, "insert")) {
                    i2 = cVar.tYD;
                } else {
                    i2 = 0;
                }
                if (caVar == null) {
                    p.hyc();
                }
                PString pString = new PString();
                PString pString2 = new PString();
                PInt pInt = new PInt();
                p.g(aST, "storage");
                aST.Xh().a(caVar, pString, pString2, pInt, false);
                String str = cVar.talker;
                p.g(str, "notifyInfo.talker");
                k avz = getSessionInfoStorage().avz(str);
                String str2 = avz.field_talker;
                int i4 = avz.field_type;
                int i5 = avz.field_actionPermission;
                int i6 = avz.field_rejectMsg;
                int i7 = avz.field_disableSendMsg;
                if (i4 == 1 && (caVar.ajN() == 1 || as.bjt(str2))) {
                    i4 = 2;
                    i5 = 1;
                    ag sessionInfoStorage = getSessionInfoStorage();
                    p.g(str2, "talker");
                    sessionInfoStorage.a(str, str2, 2, 1, ag.b.SELF_REPLY, i6, i7);
                    Log.i("Finder.ConversationUpdater", "[updateFinderConversation] change type to normal. sessionId=".concat(String.valueOf(str)));
                }
                c avq = cZz().avq(str);
                boolean z = avq.systemRowid <= 0;
                int i8 = avq.field_unReadCount;
                avq.field_digest = pString.value;
                avq.field_digestUser = pString2.value;
                avq.field_updateTime = caVar.getCreateTime();
                avq.field_digestType = String.valueOf(caVar.getType());
                avq.field_unReadCount += i2;
                avq.field_lastMsgID = caVar.ajL();
                avq.field_isSend = caVar.ajN();
                avq.field_status = caVar.getStatus();
                avq.field_talker = str2;
                avq.field_type = i4;
                avq.field_actionPermission = i5;
                if (as.bjt(str2)) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                avq.field_scene = i3;
                avq.field_readStatus = 0;
                if (z) {
                    cZz().insertNotify(avq, false);
                    cZz().doNotify(avq.field_sessionId, 2, avq);
                } else {
                    cZz().update(avq.systemRowid, avq, false);
                    cZz().doNotify(avq.field_sessionId, 1, avq);
                }
                switch (avq.field_scene) {
                    case 1:
                        if (i2 > 0) {
                            if (caVar.ajN() == 0) {
                                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                                p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                                com.tencent.mm.plugin.finder.extension.reddot.a aVar = ((PluginFinder) ah).getRedDotManager().tJB;
                                String str3 = avq.field_sessionId;
                                p.g(str3, "conv.field_sessionId");
                                p.h(str3, "<set-?>");
                                aVar.tJg = str3;
                            }
                            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                            com.tencent.mm.plugin.finder.extension.reddot.a aVar2 = ((PluginFinder) ah2).getRedDotManager().tJB;
                            aVar2.handler.removeMessages(3);
                            aVar2.handler.sendEmptyMessage(3);
                            break;
                        }
                        break;
                    case 2:
                        if (avq.field_type != 1) {
                            if (avq.field_type == 2 && i2 > 0) {
                                com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                                p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                                ((PluginFinder) ah3).getRedDotManager().tJB.dau();
                                break;
                            }
                        } else {
                            if (i2 > 0) {
                                com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                                p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
                                com.tencent.mm.plugin.finder.extension.reddot.a aVar3 = ((PluginFinder) ah4).getRedDotManager().tJB;
                                aVar3.handler.removeMessages(2);
                                aVar3.handler.sendEmptyMessage(2);
                            }
                            cZy();
                            c avq2 = cZz().avq("findersayhisessionholder");
                            avq2.field_digest = pString.value;
                            avq2.field_readStatus = 0;
                            avq2.field_unReadCount += i2;
                            avq2.field_updateTime = avq.field_updateTime;
                            cZz().update(avq2.systemRowid, avq2, false);
                            break;
                        }
                }
                Log.i("Finder.ConversationUpdater", "[updateFinderConversation] isNew=" + z + " beforeUnreadCount=" + i8 + " insertCount=" + i2 + ' ' + com.tencent.mm.plugin.finder.storage.f.b(avq));
            } else {
                String str4 = cVar.talker;
                p.g(str4, "notifyInfo.talker");
                c avq3 = cZz().avq(str4);
                Log.i("Finder.ConversationUpdater", "[onConversationMsgEmpty] " + avq3.systemRowid);
                if (avq3.systemRowid > 0) {
                    avq3.field_digest = "";
                    cZz().update(avq3.systemRowid, avq3, false);
                    cZz().doNotify(avq3.field_sessionId, 1, avq3);
                }
            }
            zArr[0] = true;
        }
        AppMethodBeat.o(242754);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
        AppMethodBeat.i(242755);
        p.h(azVar, "conversation");
        p.h(cVar, "notifyInfo");
        AppMethodBeat.o(242755);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i tyT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(i iVar) {
            super(0);
            this.tyT = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242748);
            i.a(this.tyT);
            x xVar = x.SXb;
            AppMethodBeat.o(242748);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<ag> {
        public static final c tyU = new c();

        static {
            AppMethodBeat.i(242750);
            AppMethodBeat.o(242750);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ag invoke() {
            AppMethodBeat.i(242749);
            ag sessionInfoStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage();
            AppMethodBeat.o(242749);
            return sessionInfoStorage;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<e> {
        public static final d tyV = new d();

        static {
            AppMethodBeat.i(242752);
            AppMethodBeat.o(242752);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            AppMethodBeat.i(242751);
            e conversationStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getConversationStorage();
            AppMethodBeat.o(242751);
            return conversationStorage;
        }
    }
}
