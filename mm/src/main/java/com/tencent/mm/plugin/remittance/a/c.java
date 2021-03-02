package com.tencent.mm.plugin.remittance.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.remittance.b.a;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.widget.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c implements o, bd, i.a, g {
    private static HashMap<Integer, h.b> baseDBFactories;
    private ac CiA = null;
    public b CiB = null;
    private d CiC = null;
    public CharSequence CiD;
    private IListener<qu> CiE = new IListener<qu>() {
        /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass6 */

        {
            AppMethodBeat.i(160833);
            this.__eventId = qu.class.getName().hashCode();
            AppMethodBeat.o(160833);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qu quVar) {
            AppMethodBeat.i(67340);
            qu quVar2 = quVar;
            Log.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", Long.valueOf(quVar2.dXl.msgId), quVar2.dXl.dQp);
            if (quVar2.dXl.dXm != null) {
                if (quVar2.dXl.dXm.ixN == 5) {
                    a aVar = new a();
                    aVar.field_msgId = quVar2.dXl.msgId;
                    aVar.field_transferId = quVar2.dXl.dQp;
                    c.eMU();
                    c.eMV().insert(aVar);
                }
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(quVar2.dXl.msgId);
                com.tencent.mm.plugin.remittance.b.c aLW = c.eMW().aLW(quVar2.dXl.dQp);
                if (aLW != null) {
                    aLW.field_receiveStatus = quVar2.dXl.dXm.ixN;
                    c.eMW().a(aLW);
                    if (!Hb.field_talker.equals(z.aTY())) {
                        c.aLT(Hb.field_talker);
                    }
                } else if (!Hb.field_talker.equals(z.aTY())) {
                    com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                    cVar.field_locaMsgId = quVar2.dXl.msgId;
                    cVar.field_transferId = quVar2.dXl.dXm.ixQ;
                    cVar.field_receiveStatus = quVar2.dXl.dXm.ixN;
                    cVar.field_isSend = false;
                    cVar.field_talker = Hb.field_talker;
                    cVar.field_invalidtime = (long) quVar2.dXl.dXm.ixR;
                    c.eMW().a(cVar);
                    c.aLT(Hb.field_talker);
                }
            }
            AppMethodBeat.o(67340);
            return false;
        }
    };
    private IListener<aag> CiF = new IListener<aag>() {
        /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass7 */

        {
            AppMethodBeat.i(160834);
            this.__eventId = aag.class.getName().hashCode();
            AppMethodBeat.o(160834);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aag aag) {
            AppMethodBeat.i(67341);
            aag aag2 = aag;
            com.tencent.mm.plugin.remittance.b.c aLX = c.eMW().aLX(aag2.ehb.dQp);
            if (aLX != null) {
                aag2.ehc.status = aLX.field_receiveStatus;
                aag2.ehc.ehd = aLX.field_isSend;
            } else {
                aag2.ehc.status = -2;
                aag2.ehc.ehd = false;
            }
            AppMethodBeat.o(67341);
            return false;
        }
    };
    private IListener<ld> CiG = new IListener<ld>() {
        /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass8 */

        {
            AppMethodBeat.i(160835);
            this.__eventId = ld.class.getName().hashCode();
            AppMethodBeat.o(160835);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ld ldVar) {
            Context context;
            Long l;
            ca caVar;
            k.b aD;
            AppMethodBeat.i(67342);
            ld ldVar2 = ldVar;
            if (Util.isNullOrNil(ldVar2.dQo.username) || Util.isNullOrNil(ldVar2.dQo.dQp)) {
                AppMethodBeat.o(67342);
                return false;
            }
            boolean IS = ab.IS(ldVar2.dQo.username);
            Log.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, isContact: %s, createTime: %s", Boolean.valueOf(IS), ldVar2.dQo.dQq);
            Context context2 = ldVar2.dQo.context;
            if (context2 == null) {
                context = MMApplicationContext.getContext();
            } else {
                context = context2;
            }
            if (!IS) {
                c.tH(true);
            } else {
                Long l2 = ldVar2.dQo.dQq;
                if (ldVar2.dQo.dQq.longValue() < 10000000000L) {
                    l = Long.valueOf((ldVar2.dQo.dQq.longValue() * 1000) - 1000);
                } else {
                    l = l2;
                }
                Cursor aY = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aY(ldVar2.dQo.username, l.longValue());
                int i2 = 0;
                while (true) {
                    if (aY.moveToNext() && i2 < 50) {
                        i2++;
                        ca caVar2 = new ca();
                        caVar2.convertFrom(aY);
                        String processXml = Util.processXml(caVar2.field_content);
                        if (processXml != null && (aD = k.b.aD(processXml, caVar2.field_reserved)) != null && ldVar2.dQo.dQp.equals(aD.ixQ)) {
                            Log.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, found local msg, createTime: %s", ldVar2.dQo.dQq);
                            caVar = caVar2;
                            break;
                        }
                    } else {
                        caVar = null;
                    }
                }
                aY.close();
                if (caVar == null || caVar.field_msgId <= 0) {
                    Log.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, cannot find local msg");
                    c.tH(false);
                } else {
                    Log.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, localMsgId: %s, createTime: %s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_createTime));
                    com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", ldVar2.dQo.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", caVar.field_msgId).putExtra("need_hight_item", true));
                }
            }
            AppMethodBeat.o(67342);
            return false;
        }
    };
    private MStorage.IOnStorageChange iHr = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            int i2;
            AppMethodBeat.i(67338);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100324");
                if (!Fu.isValid() || !"1".equals(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN))) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                ao azQ = com.tencent.mm.kernel.g.aAh().azQ();
                azQ.set(ar.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i2));
                int intValue = ((Integer) azQ.get(ar.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", Integer.valueOf(i2), Integer.valueOf(intValue));
                if (intValue == 0) {
                    com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    azQ.set(ar.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, (Object) 1);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
            }
            AppMethodBeat.o(67338);
        }
    };
    private cj.a rBq = new cj.a() {
        /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass5 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            String aaz;
            AppMethodBeat.i(67339);
            Log.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            de deVar = aVar.heO;
            if (deVar == null) {
                Log.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                AppMethodBeat.o(67339);
                return;
            }
            String a2 = com.tencent.mm.platformtools.z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                AppMethodBeat.o(67339);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                AppMethodBeat.o(67339);
                return;
            }
            String str = parseXml.get(".sysmsg.paymsg.PayMsgType");
            if ("15".equals(str)) {
                String decode = URLDecoder.decode(parseXml.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    Log.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    AppMethodBeat.o(67339);
                    return;
                }
                Map<String, String> parseXml2 = XmlParser.parseXml(decode, "msg", null);
                if (parseXml2 == null) {
                    Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    AppMethodBeat.o(67339);
                    return;
                }
                String str2 = parseXml2.get(".msg.appmsg.wcpayinfo.transferid");
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                    AppMethodBeat.o(67339);
                } else if (c.this.eMX().aMd(str2)) {
                    Log.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                    AppMethodBeat.o(67339);
                } else {
                    String str3 = parseXml.get(".sysmsg.paymsg.tousername");
                    if (Util.isNullOrNil(decode) || Util.isNullOrNil(str3)) {
                        Log.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                        AppMethodBeat.o(67339);
                        return;
                    }
                    c.this.eMX().aF(str2, decode, str3);
                    AppMethodBeat.o(67339);
                }
            } else if ("22".equals(str)) {
                String str4 = parseXml.get(".sysmsg.paymsg.tousername");
                String str5 = parseXml.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode(parseXml.get(".sysmsg.paymsg.appmsgcontent"), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    if (Util.isNullOrNil(decode2)) {
                        Log.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        AppMethodBeat.o(67339);
                        return;
                    }
                    Map<String, String> parseXml3 = XmlParser.parseXml(decode2, "msg", null);
                    if (parseXml3 == null) {
                        Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        AppMethodBeat.o(67339);
                        return;
                    }
                    String str6 = parseXml3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i2 = Util.getInt(parseXml3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    Log.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", str5, str4, str6, Integer.valueOf(i2));
                    a aVar2 = null;
                    try {
                        c.eMU();
                        aVar2 = c.eMV().aLV(str6);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                    }
                    if (aVar2 == null) {
                        Log.i("MicroMsg.SubCoreRemittance", "empty record");
                        AppMethodBeat.o(67339);
                        return;
                    }
                    ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(aVar2.field_msgId);
                    if (Hb.field_msgId <= 0) {
                        Log.i("MicroMsg.SubCoreRemittance", "has delete msg");
                        c.eMU();
                        c.eMV().delete(aVar2, new String[0]);
                        AppMethodBeat.o(67339);
                        return;
                    }
                    Log.i("MicroMsg.SubCoreRemittance", "update msg: %s", Long.valueOf(Hb.field_msgId));
                    Hb.setContent(decode2);
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                    com.tencent.mm.plugin.remittance.b.c aLW = c.eMW().aLW(str6);
                    if (aLW != null) {
                        aLW.field_receiveStatus = i2;
                        c.eMW().a(aLW);
                    } else if (!Hb.field_talker.equals(z.aTY())) {
                        com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                        cVar.field_locaMsgId = Hb.field_msgId;
                        cVar.field_transferId = str6;
                        cVar.field_receiveStatus = i2;
                        cVar.field_isSend = false;
                        cVar.field_talker = Hb.field_talker;
                        c.eMW().a(cVar);
                    }
                    c.aLT(Hb.field_talker);
                    AppMethodBeat.o(67339);
                } catch (UnsupportedEncodingException e3) {
                    Log.printErrStackTrace("MicroMsg.SubCoreRemittance", e3, "", new Object[0]);
                    AppMethodBeat.o(67339);
                }
            } else if ("25".equals(str)) {
                Log.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
                String nullAsNil = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.transferid"));
                String nullAsNil2 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.fromusername"));
                com.tencent.mm.plugin.remittance.b.c aLX = c.eMW().aLX(nullAsNil);
                if (aLX != null) {
                    aLX.field_receiveStatus = 2;
                    c.eMW().a(aLX);
                    if (!nullAsNil2.equals(z.aTY())) {
                        c.aLT(nullAsNil2);
                    }
                }
                AppMethodBeat.o(67339);
            } else if ("33".equals(str)) {
                int i3 = Util.getInt(parseXml.get(".sysmsg.paymsg.opentransferbankcard"), 0);
                ao azQ = com.tencent.mm.kernel.g.aAh().azQ();
                azQ.set(ar.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i3));
                int intValue = ((Integer) azQ.get(ar.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", Integer.valueOf(i3), Integer.valueOf(intValue));
                if (intValue == 0) {
                    com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    azQ.set(ar.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, (Object) 1);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
                AppMethodBeat.o(67339);
            } else if (!"45".equals(str)) {
                if ("46".equals(str)) {
                    String nullAsNil3 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.pos_id"));
                    String nullAsNil4 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.version"));
                    String nullAsNil5 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.url"));
                    String nullAsNil6 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.md5"));
                    Log.i("MicroMsg.SubCoreRemittance", "parse voice update msg，pos_id：%s,version ：%s, resourceUrl:%s, md5:%s", nullAsNil3, nullAsNil4, nullAsNil5, nullAsNil6);
                    if (Util.isNullOrNil(nullAsNil3) || Util.isNullOrNil(nullAsNil4)) {
                        Log.i("MicroMsg.SubCoreRemittance", "pos_id is null || version is null");
                        AppMethodBeat.o(67339);
                        return;
                    }
                    if (Util.isEqual(nullAsNil3, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        com.tencent.mm.plugin.collect.model.voice.a.czG();
                        aaz = com.tencent.mm.plugin.collect.model.voice.a.aaz("0-1");
                    } else {
                        com.tencent.mm.plugin.collect.model.voice.a.czG();
                        aaz = com.tencent.mm.plugin.collect.model.voice.a.aaz(nullAsNil3);
                    }
                    if (Util.isNullOrNil(aaz)) {
                        Log.i("MicroMsg.SubCoreRemittance", "need insert new config");
                        com.tencent.mm.plugin.collect.model.voice.a.czG();
                        com.tencent.mm.plugin.collect.model.voice.a.l(nullAsNil3, nullAsNil5, nullAsNil4, nullAsNil6);
                        AppMethodBeat.o(67339);
                        return;
                    }
                    double parseDouble = Double.parseDouble(nullAsNil4);
                    double parseDouble2 = Double.parseDouble(aaz);
                    Log.i("MicroMsg.SubCoreRemittance", "voice resource file - version： %s ，versionLocal:%s", nullAsNil4, aaz);
                    if (parseDouble <= parseDouble2) {
                        Log.i("MicroMsg.SubCoreRemittance", "version < versionLocal,do not update voice resource");
                    } else if (Util.isNullOrNil(nullAsNil5)) {
                        Log.i("MicroMsg.SubCoreRemittance", "resourceUrl is null");
                        AppMethodBeat.o(67339);
                        return;
                    } else {
                        Log.i("MicroMsg.SubCoreRemittance", "need update voice resource config");
                        com.tencent.mm.plugin.collect.model.voice.a.czG();
                        com.tencent.mm.plugin.collect.model.voice.a.l(nullAsNil3, nullAsNil5, nullAsNil4, nullAsNil6);
                        AppMethodBeat.o(67339);
                        return;
                    }
                }
                AppMethodBeat.o(67339);
            } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remittance_remind_msg_switch, 1) == 0) {
                Log.i("MicroMsg.SubCoreRemittance", "needOpenSwitch is close ");
                AppMethodBeat.o(67339);
            } else {
                String nullAsNil7 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.transferid"));
                String nullAsNil8 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.fromusername"));
                String nullAsNil9 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.content"));
                String nullAsNil10 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.transfer_msg_type"));
                Log.i("MicroMsg.SubCoreRemittance", "parse transfer remind receive msg：transferid：%s,msgType ：%s", nullAsNil7, nullAsNil10);
                com.tencent.mm.plugin.remittance.b.c aLX2 = c.eMW().aLX(nullAsNil7);
                if (aLX2 == null) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20467, "transfer_to_change", "dont show message", "", "", "", "", 2, nullAsNil7, nullAsNil10);
                    Log.i("MicroMsg.SubCoreRemittance", "remittanceRecord is null, dont insert remind msg");
                    AppMethodBeat.o(67339);
                } else if (((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(aLX2.field_locaMsgId).field_msgId <= 0) {
                    Log.i("MicroMsg.SubCoreRemittance", " msg has delete，dont insert remind msg");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20467, "transfer_to_change", "dont show message", "", "", "", "", 2, nullAsNil7, nullAsNil10);
                    AppMethodBeat.o(67339);
                } else {
                    Log.i("MicroMsg.SubCoreRemittance", "insert new remind msg");
                    ca caVar = new ca();
                    caVar.nv(0);
                    caVar.Cy(nullAsNil8);
                    caVar.setContent(nullAsNil9);
                    caVar.setCreateTime(bp.C(nullAsNil8, (long) deVar.CreateTime));
                    caVar.setType(10000);
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20467, "transfer_to_change", "show message", "", "", "", "", 1, nullAsNil7, nullAsNil10);
                    AppMethodBeat.o(67339);
                }
            }
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public c() {
        AppMethodBeat.i(67343);
        AppMethodBeat.o(67343);
    }

    static {
        AppMethodBeat.i(67351);
        com.tencent.mm.wallet_core.a.j("RemittanceProcess", a.class);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.remittance.b.b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        AppMethodBeat.o(67351);
    }

    public static c eMU() {
        AppMethodBeat.i(67344);
        c cVar = (c) y.at(c.class);
        AppMethodBeat.o(67344);
        return cVar;
    }

    public static com.tencent.mm.plugin.remittance.b.b eMV() {
        AppMethodBeat.i(67345);
        if (eMU().CiB == null) {
            c eMU = eMU();
            com.tencent.mm.kernel.g.aAi();
            eMU.CiB = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.remittance.b.b bVar = eMU().CiB;
        AppMethodBeat.o(67345);
        return bVar;
    }

    public static d eMW() {
        AppMethodBeat.i(67346);
        if (eMU().CiC == null) {
            c eMU = eMU();
            com.tencent.mm.kernel.g.aAi();
            eMU.CiC = new d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        d dVar = eMU().CiC;
        AppMethodBeat.o(67346);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(67347);
        if (this.CiA != null) {
            ac acVar = this.CiA;
            synchronized (acVar.lock) {
                try {
                    acVar.Cqp.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(67347);
                    throw th;
                }
            }
        }
        com.tencent.mm.model.c.d.aXu().add(this.iHr);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.rBq, true);
        EventCenter.instance.add(this.CiE);
        EventCenter.instance.add(this.CiF);
        EventCenter.instance.add(this.CiG);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(this);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this, (Looper) null);
        AppForegroundDelegate.INSTANCE.a(this);
        AppMethodBeat.o(67347);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(67348);
        com.tencent.mm.model.c.d.aXu().remove(this.iHr);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.rBq, true);
        EventCenter.instance.removeListener(this.CiE);
        EventCenter.instance.removeListener(this.CiF);
        EventCenter.instance.removeListener(this.CiG);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().b(this);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this);
        AppForegroundDelegate.INSTANCE.b(this);
        AppMethodBeat.o(67348);
    }

    public final ac eMX() {
        AppMethodBeat.i(67349);
        if (this.CiA == null) {
            this.CiA = new ac();
        }
        ac acVar = this.CiA;
        AppMethodBeat.o(67349);
        return acVar;
    }

    private static boolean aLS(String str) {
        boolean z;
        AppMethodBeat.i(213696);
        List<com.tencent.mm.plugin.remittance.b.c> aLY = eMW().aLY(str);
        if (aLY != null && !aLY.isEmpty()) {
            Iterator<com.tencent.mm.plugin.remittance.b.c> it = aLY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mm.plugin.remittance.b.c next = it.next();
                long aWA = (next.field_invalidtime * 1000) - cl.aWA();
                Log.i("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", Integer.valueOf(next.field_receiveStatus), Long.valueOf(next.field_locaMsgId), next.field_talker);
                if (aWA >= 0 || (next.field_receiveStatus != 1 && next.field_receiveStatus != 7)) {
                    if (aWA >= 0 && ((next.field_receiveStatus == 1 || next.field_receiveStatus == 7) && ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(next.field_locaMsgId).field_msgId > 0)) {
                        z = true;
                        break;
                    }
                } else {
                    Log.i("MicroMsg.SubCoreRemittance", "timeout, change status");
                    next.field_receiveStatus = 2;
                    eMW().a(next);
                }
            }
        }
        z = false;
        AppMethodBeat.o(213696);
        return z;
    }

    public static void aLT(String str) {
        AppMethodBeat.i(213697);
        boolean aLS = aLS(str);
        az bjY = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjY(str);
        if (bjY != null && !ab.Eq(str)) {
            Log.i("MicroMsg.SubCoreRemittance", "update red flag: %s, %s", str, Boolean.valueOf(aLS));
            if (aLS) {
                ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(str, 268435456, true, bjY.field_attrflag);
                AppMethodBeat.o(213697);
                return;
            }
            ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(str, 268435456, false, bjY.field_attrflag);
        }
        AppMethodBeat.o(213697);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, i.c cVar, boolean[] zArr) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
        AppMethodBeat.i(213698);
        if (z && !ab.Eq(azVar.field_username)) {
            boolean aLS = aLS(azVar.field_username);
            Log.i("MicroMsg.SubCoreRemittance", "try mark red flag when new conv: %s", Boolean.valueOf(aLS));
            if (aLS) {
                azVar.oT(268435456);
            }
        }
        AppMethodBeat.o(213698);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(i iVar, i.c cVar) {
        AppMethodBeat.i(213699);
        if (cVar.zqn.equals("delete")) {
            Log.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", cVar.talker);
            aLT(cVar.talker);
        }
        AppMethodBeat.o(213699);
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
        AppMethodBeat.i(213700);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(213695);
                c.a(c.this);
                AppMethodBeat.o(213695);
            }
        });
        AppMethodBeat.o(213700);
    }

    static /* synthetic */ void tH(boolean z) {
        AppMethodBeat.i(67350);
        new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(z ? R.string.g3f : R.string.g3e)).apb(MMApplicationContext.getContext().getResources().getColor(R.color.afp)).apa(R.string.e2u).b(new f.c() {
            /* class com.tencent.mm.plugin.remittance.a.c.AnonymousClass9 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }).show();
        AppMethodBeat.o(67350);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(213701);
        if (cl.aWA() - ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_REMITTANCE_RED_FLAG_CHECK_LONG_SYNC, (Object) 0L)).longValue() > 43200000) {
            List<com.tencent.mm.plugin.remittance.b.c> eNl = eMW().eNl();
            HashSet hashSet = new HashSet();
            for (com.tencent.mm.plugin.remittance.b.c cVar2 : eNl) {
                Log.d("MicroMsg.SubCoreRemittance", "status: %s", Integer.valueOf(cVar2.field_receiveStatus));
                if (!hashSet.contains(cVar2.field_talker)) {
                    aLT(cVar2.field_talker);
                    hashSet.add(cVar2.field_talker);
                }
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_REMITTANCE_RED_FLAG_CHECK_LONG_SYNC, Long.valueOf(cl.aWA()));
            AppMethodBeat.o(213701);
            return;
        }
        Log.i("MicroMsg.SubCoreRemittance", "not time");
        AppMethodBeat.o(213701);
    }
}
