package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.l;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class s {
    public static void gA(View view) {
        b bVar;
        boolean z;
        int i2;
        ca caVar;
        AppMethodBeat.i(34580);
        if (view.getTag() instanceof e.g) {
            if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
                AppMethodBeat.o(34580);
                return;
            }
            e.g gVar = (e.g) view.getTag();
            long j2 = gVar.msgId;
            if (gVar.PJr != null) {
                e.h hVar = gVar.PJr;
                String format = String.format("%s_msg", hVar.JwO);
                if (aMJ(format)) {
                    a.bea();
                    AppMethodBeat.o(34580);
                    return;
                }
                String str = hVar.coverUrl;
                String str2 = hVar.title;
                String str3 = hVar.iAA;
                String str4 = hVar.url;
                String str5 = hVar.playUrl;
                String str6 = hVar.playUrl;
                String str7 = hVar.JwO;
                bg.aVF();
                a.c(i.a(0, str, str2, str3, str4, str5, str6, str7, c.getAccPath(), hVar.coverUrl, "", "", h.a(format, gVar.jfy)));
                AppMethodBeat.o(34580);
                return;
            } else if (gVar.PJs == -1) {
                bg.aVF();
                ca Hb = c.aSQ().Hb(gVar.msgId);
                String format2 = String.format("%d_msg", Long.valueOf(j2));
                if (aMJ(format2)) {
                    if (gVar.ixW != 0) {
                        ol olVar = new ol();
                        olVar.aWS(gVar.MxJ);
                        olVar.enl = 2;
                        olVar.erW = 2;
                        aq.a(olVar);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10231, "1");
                    a.bea();
                    if (Hb.field_msgId == j2) {
                        bVar = b.jmd;
                        z = false;
                        i2 = l.t(Hb);
                        caVar = Hb;
                    }
                    AppMethodBeat.o(34580);
                    return;
                }
                k.b HD = k.b.HD(gVar.xml);
                if (HD != null) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10090, "0,1");
                    String str8 = gVar.dRr;
                    bg.aVF();
                    a.c(i.a(HD, format2, str8, c.getAccPath(), gVar.dRr, h.a(format2, gVar.jfy)));
                }
                if (gVar.ixW != 0) {
                    ol olVar2 = new ol();
                    olVar2.aWS(gVar.MxJ);
                    olVar2.enl = 1;
                    olVar2.erW = 2;
                    aq.a(olVar2);
                }
                if (Hb.field_msgId == j2) {
                    bVar = b.jmd;
                    z = true;
                    if (HD != null) {
                        i2 = HD.type;
                        caVar = Hb;
                    } else {
                        i2 = 0;
                        caVar = Hb;
                    }
                }
                AppMethodBeat.o(34580);
                return;
                bVar.a(caVar, z, i2);
                AppMethodBeat.o(34580);
                return;
            } else {
                String str9 = gVar.msgId + "_" + gVar.PJs + "_msg";
                bg.aVF();
                ca Hb2 = c.aSQ().Hb(gVar.msgId);
                u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(gVar.msgId, gVar.xml);
                if (aMJ(str9)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10231, "1");
                    a.bea();
                    if (Hb2.field_msgId == j2) {
                        b.jmd.a(Hb2, false, l.t(Hb2));
                    }
                    if (!(a2 == null || a2.iAd == null || a2.iAd.size() <= gVar.PJs)) {
                        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(((v) a2.iAd.get(gVar.PJs)).type == 6 ? 1 : 0);
                        objArr[1] = 1;
                        hVar2.a(14972, objArr);
                        AppMethodBeat.o(34580);
                        return;
                    }
                } else {
                    if (!(a2 == null || a2.iAd == null || a2.iAd.size() <= gVar.PJs)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10090, "0,1");
                        v vVar = (v) a2.iAd.get(gVar.PJs);
                        String str10 = gVar.dRr;
                        String str11 = vVar.title;
                        String str12 = vVar.iAA;
                        String str13 = vVar.url;
                        String str14 = vVar.iAz;
                        String str15 = vVar.iAz;
                        bg.aVF();
                        a.c(i.a(0, str10, str11, str12, str13, str14, str15, str9, c.getAccPath(), gVar.dRr, "", "", h.a(str9, gVar.jfy)));
                        com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Integer.valueOf(vVar.type == 6 ? 1 : 0);
                        objArr2[1] = 0;
                        hVar3.a(14972, objArr2);
                    }
                    if (Hb2.field_msgId == j2) {
                        b.jmd.a(Hb2, true, l.t(Hb2));
                    }
                }
            }
        }
        AppMethodBeat.o(34580);
    }

    public static boolean aMJ(String str) {
        AppMethodBeat.i(34581);
        f bef = a.bef();
        if (bef != null && bef.jeV != null && bef.jeT == 0 && a.bec()) {
            try {
                if (Util.isEqual(bef.jeV, str)) {
                    AppMethodBeat.o(34581);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(34581);
                return false;
            }
        }
        AppMethodBeat.o(34581);
        return false;
    }

    public static void a(View view, Context context, String str) {
        AppMethodBeat.i(34582);
        bq bqVar = (bq) view.getTag();
        String str2 = bqVar.productId;
        if (TextUtils.isEmpty(str2)) {
            str2 = ((d) g.ah(d.class)).getEmojiMgr().ams(bqVar.fQR);
        }
        if (TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", str);
            intent.putExtra("rawUrl", bqVar.fQR);
            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(34582);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", str2);
        intent2.putExtra("extra_name", bqVar.title);
        if (bqVar.PQD) {
            intent2.putExtra("download_entrance_scene", 20);
            intent2.putExtra("preceding_scence", 3);
            intent2.putExtra("reward_tip", true);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12953, 1, str2);
        } else if (bqVar.PQE) {
            intent2.putExtra("download_entrance_scene", 25);
            intent2.putExtra("preceding_scence", 9);
            intent2.putExtra("reward_tip", true);
        } else {
            intent2.putExtra("download_entrance_scene", 22);
            intent2.putExtra("preceding_scence", 122);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10993, 2, str2);
        }
        com.tencent.mm.br.c.b(context, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        AppMethodBeat.o(34582);
    }

    public static void a(final v vVar, View view, final String str) {
        AppMethodBeat.i(34583);
        if (view == null || vVar == null) {
            AppMethodBeat.o(34583);
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.s.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(34578);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bq bqVar = (bq) view.getTag();
                Log.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", vVar.iAt);
                wq wqVar = new wq();
                wqVar.ecI.userName = vVar.iAt;
                wqVar.ecI.ecK = vVar.weappPath;
                wqVar.ecI.ecL = vVar.iAu;
                wqVar.ecI.appVersion = vVar.weappVersion;
                wqVar.ecI.ecP = true;
                wqVar.ecI.scene = 1076;
                wqVar.ecI.dCw = str + ":" + bqVar.dTX.field_msgSvrId + ":" + bqVar.IZD;
                EventCenter.instance.publish(wqVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34578);
            }
        });
        AppMethodBeat.o(34583);
    }

    public static void a(int i2, Context context, String str, String str2, long j2, long j3) {
        AppMethodBeat.i(34584);
        u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(j2, str);
        if (a2 == null) {
            Log.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
            AppMethodBeat.o(34584);
            return;
        }
        if (i2 >= 0 && i2 < a2.iAd.size()) {
            v vVar = (v) a2.iAd.get(i2);
            String a3 = k.b.a(m.a(str2, vVar), null, null);
            if (Util.isNullOrNil(a3)) {
                AppMethodBeat.o(34584);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("desc", vVar.iAq);
            hashMap.put("type", 2);
            hashMap.put("title", vVar.title);
            hashMap.put("app_id", vVar.iAv);
            hashMap.put("pkg_type", Integer.valueOf(vVar.iAu));
            hashMap.put("pkg_version", Integer.valueOf(vVar.weappVersion));
            hashMap.put("img_url", vVar.iAw);
            hashMap.put("is_dynamic", Boolean.FALSE);
            hashMap.put("cache_key", "");
            hashMap.put("path", vVar.weappPath);
            Intent intent = new Intent(context, MsgRetransmitUI.class);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_content", a3);
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", i2);
            intent.putExtra("Retr_Msg_Id", j2);
            intent.putExtra("Retr_MsgFromScene", 3);
            String JX = ad.JX(String.valueOf(j3));
            intent.putExtra("reportSessionId", JX);
            ad.b G = ad.aVe().G(JX, true);
            G.l("prePublishId", "msg_".concat(String.valueOf(j3)));
            G.l("preUsername", str2);
            G.l("preChatName", str2);
            G.l("preMsgIndex", Integer.valueOf(i2));
            G.l("sendAppMsgScene", 1);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(34584);
    }

    public static void a(ca caVar, Context context, com.tencent.mm.ui.chatting.e.a aVar) {
        com.tencent.mm.av.g gVar;
        int i2;
        AppMethodBeat.i(34586);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.u.g(context, aVar.Pwc.getContentView());
            AppMethodBeat.o(34586);
            return;
        }
        com.tencent.mm.av.g gVar2 = null;
        if (caVar.field_msgId > 0) {
            gVar2 = q.bcR().H(caVar.field_talker, caVar.field_msgId);
        }
        if ((gVar2 == null || gVar2.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        } else {
            gVar = gVar2;
        }
        if (gVar == null) {
            AppMethodBeat.o(34586);
            return;
        }
        if (caVar.field_isSend == 1) {
            if (gVar.bcv()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else if (!gVar.bcv()) {
            i2 = 0;
        } else {
            if (!com.tencent.mm.vfs.s.YS(q.bcR().o(com.tencent.mm.av.h.a(gVar).iXm, "", ""))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
        }
        if (caVar.gDB()) {
            Log.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
            com.tencent.mm.ui.base.h.d(context, context.getString(R.string.e32), context.getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.s.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(34586);
        } else if (com.tencent.mm.ui.chatting.d.l.h(caVar, q.bcR().o(com.tencent.mm.av.h.c(gVar), "", ""))) {
            Log.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
            Log.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
            Intent intent = new Intent(context, ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", caVar.field_msgId);
            intent.putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId);
            intent.putExtra("img_gallery_talker", caVar.field_talker);
            intent.putExtra("img_gallery_chatroom_name", caVar.field_talker);
            intent.putExtra("img_gallery_is_restransmit_after_download", true);
            intent.putExtra("Retr_show_success_tips", true);
            if (aVar != null) {
                com.tencent.mm.ui.chatting.d.l.a(aVar, caVar, intent);
            } else {
                a(caVar, intent);
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34586);
        } else if (gVar.offset < gVar.iKP || gVar.iKP == 0) {
            Intent intent2 = new Intent(context, MsgRetransmitUI.class);
            intent2.putExtra("Retr_File_Name", q.bcR().R(caVar.field_imgPath, true));
            intent2.putExtra("Retr_Msg_Id", caVar.field_msgId);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.putExtra("Retr_show_success_tips", true);
            intent2.putExtra("Retr_Compress_Type", i2);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34586);
        } else {
            Intent intent3 = new Intent(context, MsgRetransmitUI.class);
            intent3.putExtra("Retr_File_Name", q.bcR().o(com.tencent.mm.av.h.c(gVar), "", ""));
            intent3.putExtra("Retr_Msg_Id", caVar.field_msgId);
            intent3.putExtra("Retr_Msg_Type", 0);
            intent3.putExtra("Retr_show_success_tips", true);
            intent3.putExtra("Retr_Compress_Type", i2);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34586);
        }
    }

    private static void a(ca caVar, Intent intent) {
        AppMethodBeat.i(34587);
        if (caVar == null) {
            AppMethodBeat.o(34587);
            return;
        }
        String str = caVar.field_talker;
        String str2 = caVar.field_talker;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", ab.IT(str) ? 7 : 1);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(caVar.field_msgSvrId));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        intent.putExtra("_stat_obj", bundle);
        AppMethodBeat.o(34587);
    }

    public static void a(final com.tencent.mm.ui.chatting.e.a aVar, long j2, int i2) {
        AppMethodBeat.i(34588);
        Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", Long.valueOf(j2), Integer.valueOf(i2));
        ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(j2);
        Intent intent = new Intent();
        intent.putExtra("key_group_solitatire_create", false);
        intent.putExtra("key_group_solitatire_key", Hb.fRd);
        intent.putExtra("key_group_solitatire_chatroom_username", Hb.field_talker);
        intent.putExtra("key_group_solitatire_scene", i2);
        com.tencent.mm.br.c.a(aVar.Pwa, "groupsolitaire", ".ui.GroupSolitatireEditUI", intent, 3001, new c.a() {
            /* class com.tencent.mm.ui.chatting.s.AnonymousClass3 */

            @Override // com.tencent.mm.br.c.a
            public final void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(34579);
                if (i2 == 3001) {
                    Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", Integer.valueOf(i3));
                    if (-1 == i3 && intent != null) {
                        ((com.tencent.mm.ui.chatting.d.b.aq) aVar.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).aBt(intent.getStringExtra("key_group_solitatire_content"));
                    }
                }
                AppMethodBeat.o(34579);
            }
        });
        AppMethodBeat.o(34588);
    }

    public static void a(long j2, int i2, Context context, Fragment fragment, Activity activity, ca caVar) {
        AppMethodBeat.i(34585);
        String str = caVar.field_talker;
        String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
        ad.b G = ad.aVe().G(JX, true);
        G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
        G.l("preUsername", str);
        G.l("preChatName", str);
        G.l("preMsgIndex", Integer.valueOf(i2));
        G.l("sendAppMsgScene", 1);
        cz czVar = new cz();
        czVar.dFZ.dGd = i2;
        czVar.dFZ.sessionId = JX;
        czVar.dFZ.fragment = fragment;
        czVar.dFZ.activity = activity;
        czVar.dFZ.dGf = 40;
        com.tencent.mm.pluginsdk.model.h.d(czVar, caVar);
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0) {
            k.b HD = k.b.HD(m.a(context, i2, caVar.field_content, caVar.field_talker, caVar.field_msgId));
            if (caVar.dOQ()) {
                b.jmd.c(caVar, HD != null ? HD.type : 0);
            } else {
                b.jmd.ac(caVar);
            }
            if (!(HD == null || HD.type != 5 || HD.url == null)) {
                Log.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD.url, Long.valueOf(j2), 1, 2, 1);
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(HD.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.ChattingItemHelper", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str2, Long.valueOf(j2), 1, 2, 1);
            }
        }
        AppMethodBeat.o(34585);
    }
}
