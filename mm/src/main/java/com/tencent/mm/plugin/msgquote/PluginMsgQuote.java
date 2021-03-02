package com.tencent.mm.plugin.msgquote;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.msgquote.model.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginMsgQuote extends f implements a, c, a {
    private static HashMap<Integer, h.b> baseDBFactories;
    private b zFG = null;
    private com.tencent.mm.plugin.msgquote.a.a zFH = null;

    static {
        AppMethodBeat.i(88793);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("MSGQUOTE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.msgquote.PluginMsgQuote.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.msgquote.a.a.SQL_CREATE;
            }
        });
        AppMethodBeat.o(88793);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public com.tencent.mm.plugin.msgquote.a.a getMsgQuoteStorage() {
        AppMethodBeat.i(88785);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.zFH == null) {
            com.tencent.mm.kernel.g.aAi();
            this.zFH = new com.tencent.mm.plugin.msgquote.a.a(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.msgquote.a.a aVar = this.zFH;
        AppMethodBeat.o(88785);
        return aVar;
    }

    public b getMsgReportManager() {
        AppMethodBeat.i(88786);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.zFG == null) {
            this.zFG = new b();
        }
        b bVar = this.zFG;
        AppMethodBeat.o(88786);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public void sendQuoteMsg(ca caVar, int i2, String str, CharSequence charSequence, String str2, int i3, HashMap<String, String> hashMap) {
        AppMethodBeat.i(88787);
        if (caVar != null) {
            k.b bVar = new k.b();
            bVar.title = str2;
            bVar.type = 57;
            bVar.izy = com.tencent.mm.plugin.msgquote.model.a.a(caVar, i2, charSequence, i3, hashMap);
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                Log.d("MicroMsg.msgquote.PluginMsgQuote", "content:%s MsgQuoteItem:%s", Util.secPrint(str2), bVar.izy);
            }
            Pair<Integer, Long> a2 = w.a.aSz().a(bVar, "", "", str, "", null);
            if (a2 != null) {
                com.tencent.mm.plugin.msgquote.a.b bVar2 = new com.tencent.mm.plugin.msgquote.a.b();
                bVar2.field_msgId = ((Long) a2.second).longValue();
                bVar2.field_quotedMsgId = caVar.field_msgId;
                bVar2.field_quotedMsgSvrId = caVar.field_msgSvrId;
                Log.i("MicroMsg.msgquote.PluginMsgQuote", "sendQuoteMsg result:%s msgId:%s result:%s", a2.first, a2.second, Boolean.valueOf(((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().b(bVar2)));
                AppMethodBeat.o(88787);
                return;
            }
            Log.e("MicroMsg.msgquote.PluginMsgQuote", "pair is null??");
        }
        AppMethodBeat.o(88787);
    }

    public void reSendQuoteMsg(ca caVar, int i2, String str, CharSequence charSequence, String str2, int i3, HashMap<String, String> hashMap) {
    }

    public void handleQuoteMsgClick(Context context, long j2, MsgQuoteItem msgQuoteItem) {
        AppMethodBeat.i(88788);
        if (msgQuoteItem == null) {
            Log.e("MicroMsg.msgquote.PluginMsgQuote", "msgQuoteItem is null!");
            AppMethodBeat.o(88788);
            return;
        }
        Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", Long.valueOf(j2), Long.valueOf(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2).field_msgSvrId), Integer.valueOf(msgQuoteItem.type), Long.valueOf(msgQuoteItem.zFI), Util.secPrint(msgQuoteItem.content));
        AppMethodBeat.o(88788);
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public void handleReceivedQuoteMsg(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(88789);
        com.tencent.mm.plugin.msgquote.a.b bVar = new com.tencent.mm.plugin.msgquote.a.b();
        bVar.field_msgId = j2;
        bVar.field_msgSvrId = j3;
        bVar.field_quotedMsgSvrId = j4;
        bVar.field_quotedMsgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(str, j4).field_msgId;
        Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleReceivedQuoteMsg() msgId:%s msgSvrid:%s talker:%s quotedMsgSvrid:%s result:%s", Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4), Boolean.valueOf(((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().b(bVar)));
        AppMethodBeat.o(88789);
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public void handleRevokeMsgBySelf(long j2) {
        AppMethodBeat.i(88790);
        com.tencent.mm.plugin.msgquote.a.b Hl = ((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().Hl(j2);
        if (Hl == null) {
            Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf msgId:%s, msgQuote is null", Long.valueOf(j2));
            AppMethodBeat.o(88790);
            return;
        }
        Hl.field_status = 1;
        Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgId:%s result:%s", Long.valueOf(j2), Boolean.valueOf(((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().a(Hl)));
        AppMethodBeat.o(88790);
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public void handleRevokeMsgBySvrId(long j2) {
        AppMethodBeat.i(88791);
        com.tencent.mm.plugin.msgquote.a.b Hk = ((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().Hk(j2);
        if (Hk == null) {
            Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s, msgQuote is null", Long.valueOf(j2));
            AppMethodBeat.o(88791);
        } else if (Hk.field_status == 1) {
            Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s revoked!!", Long.valueOf(j2));
            AppMethodBeat.o(88791);
        } else {
            Hk.field_status = 1;
            Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgSvrId:%s result:%s", Long.valueOf(j2), Boolean.valueOf(((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().a(Hk)));
            AppMethodBeat.o(88791);
        }
    }

    @Override // com.tencent.mm.plugin.msgquote.a
    public void handleQuoteMsgSendResuld(long j2, long j3) {
        AppMethodBeat.i(88792);
        com.tencent.mm.plugin.msgquote.a.b Hj = ((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().Hj(j2);
        if (Hj != null) {
            Hj.field_msgSvrId = j3;
            boolean a2 = ((a) com.tencent.mm.kernel.g.ah(a.class)).getMsgQuoteStorage().a(Hj);
            ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(Hj.field_quotedMsgId);
            if (Hb.getType() == 49 || Hb.getType() == 805306417 || Hb.getType() == 822083633) {
                k.b HD = k.b.HD(Hb.field_content);
                if (HD != null) {
                    b.b(2, Hj.field_quotedMsgSvrId, 49, (long) HD.type);
                }
            } else {
                b.b(2, Hj.field_quotedMsgSvrId, (long) Hb.getType(), 0);
            }
            Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s result:%s", Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(a2));
            AppMethodBeat.o(88792);
            return;
        }
        Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s, msgQuote is null", Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(88792);
    }
}
