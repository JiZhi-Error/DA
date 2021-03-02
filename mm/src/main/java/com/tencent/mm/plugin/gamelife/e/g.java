package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConversationUpdate", "isConsumed", "", "checkMsgInfoForDigest", "msg", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "dealEmojiMd5", "", "md5", "interceptDigest", "onConversationMsgEmpty", "storage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conv", "Companion", "plugin-gamelife_release"})
public final class g implements com.tencent.mm.plugin.messenger.foundation.a.g {
    public static final a ycc = new a((byte) 0);

    static {
        AppMethodBeat.i(241379);
        AppMethodBeat.o(241379);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, i.c cVar, boolean[] zArr) {
        String str;
        a aVar;
        String str2;
        k.b HD;
        Map<String, String> map;
        AppMethodBeat.i(241377);
        p.h(cVar, "notifyInfo");
        p.h(zArr, "isConsumed");
        String str3 = cVar.talker;
        if (!as.bju(str3) || caVar == null) {
            AppMethodBeat.o(241377);
            return;
        }
        e conversationStorage = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
        com.tencent.mm.plugin.gamelife.j.a aBc = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getSessionInfoStorage().aBc(str3);
        String str4 = aBc.field_selfUserName;
        if (!(str4 == null || str4.length() == 0)) {
            String str5 = aBc.field_talker;
            if (!(str5 == null || str5.length() == 0)) {
                if (caVar.ajL() != 0) {
                    p.g(str3, "sessionId");
                    a aBa = conversationStorage.aBa(str3);
                    ArrayList<ca> arrayList = cVar.hIs;
                    if (arrayList != null) {
                        for (T t : arrayList) {
                            if (!(t == null || t.ajN() == 1 || !t.dOQ() || (HD = k.b.HD(t.getContent())) == null || (map = HD.iyY) == null)) {
                                aBa.field_digestPrefix = map.get(LocaleUtil.getApplicationLanguage());
                            }
                        }
                    }
                    long j2 = aBa.field_lastMsgID;
                    if (caVar != null && caVar.gDn() && caVar.ajP() != null) {
                        String ajP = caVar.ajP();
                        if (ajP == null || ajP.length() != 32) {
                            str2 = null;
                        } else {
                            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(d.class);
                            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                            str2 = ((d) ah).getEmojiMgr().amp(ajP);
                        }
                        str = !Util.isNullOrNil(str2) ? "[" + str2 + ']' : MMApplicationContext.getContext().getString(R.string.tu);
                    } else if (caVar == null || !caVar.dOQ()) {
                        str = null;
                    } else {
                        k.b aD = k.b.aD(caVar.getContent(), caVar.ajQ());
                        if (aD != null) {
                            switch (aD.type) {
                                case 66:
                                    str = aD.title;
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                        } else {
                            str = null;
                        }
                    }
                    if (str == null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                        bw aST = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST();
                        p.g(aST, "MMKernel.service(IMessen…ass.java).conversationStg");
                        aST.Xh().a(caVar, pString, pString2, pInt, false);
                        str = pString.value;
                        aVar = aBa;
                    } else {
                        aVar = aBa;
                    }
                    aVar.field_digest = str;
                    aBa.field_updateTime = caVar.getCreateTime();
                    aBa.field_unReadCount = (p.j(cVar.zqn, "insert") ? cVar.tYD : 0) + aBa.field_unReadCount;
                    aBa.field_lastMsgID = caVar.ajL();
                    aBa.field_talker = aBc.field_talker;
                    aBa.field_selfUserName = aBc.field_selfUserName;
                    boolean z = aBa.systemRowid <= 0;
                    if (z) {
                        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.listOf((Object[]) new String[]{aBa.field_talker, aBa.field_selfUserName}), b.ycd);
                        conversationStorage.insertNotify(aBa, false);
                        conversationStorage.doNotify(MStorageEventData.EventType.SINGLE, 2, aBa);
                    } else if (p.j(cVar.zqn, "delete")) {
                        Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] delete msg");
                        if (cVar.zqq == j2) {
                            conversationStorage.update(aBa.systemRowid, aBa, false);
                            conversationStorage.doNotify(MStorageEventData.EventType.SINGLE, 8, aBa);
                        }
                    } else {
                        conversationStorage.update(aBa.systemRowid, aBa, false);
                        conversationStorage.doNotify(MStorageEventData.EventType.SINGLE, 1, aBa);
                    }
                    Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] isNew=" + z + " notifyFunc:" + cVar.zqn + " delId:" + cVar.zqq + " conLastMsgId:" + j2 + " sessionId=" + str3 + " talker=" + aBa.field_talker + ' ' + f.a(aBa));
                } else {
                    p.g(str3, "sessionId");
                    a aBa2 = conversationStorage.aBa(str3);
                    Log.i("GameLife.ConversationUpdateCallback", "[onConversationMsgEmpty] " + aBa2.systemRowid);
                    if (aBa2.systemRowid > 0) {
                        aBa2.field_digest = "";
                        conversationStorage.update(aBa2.systemRowid, aBa2, false);
                        conversationStorage.doNotify(aBa2.field_talker, 8, aBa2);
                    }
                }
                zArr[0] = true;
                AppMethodBeat.o(241377);
                return;
            }
        }
        Log.e("GameLife.ConversationUpdateCallback", "getSessionInfo invalid: ".concat(String.valueOf(aBc)));
        AppMethodBeat.o(241377);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class b implements b.c {
        public static final b ycd = new b();

        static {
            AppMethodBeat.i(241376);
            AppMethodBeat.o(241376);
        }

        b() {
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.c
        public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
            AppMethodBeat.i(241375);
            Log.i("GameLife.ConversationUpdateCallback", "contact prefetch result: ".concat(String.valueOf(map)));
            AppMethodBeat.o(241375);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
        AppMethodBeat.i(241378);
        Log.i("GameLife.ConversationUpdateCallback", "msgInfo = " + caVar + ", conversation = " + azVar + ", newCon = " + z + ", notifyInfo = " + cVar);
        AppMethodBeat.o(241378);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
    }
}
