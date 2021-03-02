package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.UUID;

public final class f {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 436207665) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36854);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sm);
                view.setTag(new a().gM(view));
            }
            AppMethodBeat.o(36854);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:115:0x0423  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x0439  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x047d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0206  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x022e  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0249  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r12, int r13, com.tencent.mm.ui.chatting.e.a r14, com.tencent.mm.storage.ca r15, java.lang.String r16) {
            /*
            // Method dump skipped, instructions count: 1190
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.f.c.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233617);
            int i2 = ((bq) view.getTag()).position;
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
            }
            AppMethodBeat.o(233617);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36857);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = caVar.field_content;
                    k.b bVar = null;
                    if (str != null) {
                        bVar = k.b.aD(str, caVar.field_reserved);
                    }
                    if (bVar != null) {
                        final String str2 = caVar.field_talker;
                        final String str3 = bVar.iyk;
                        final String str4 = bVar.iyl;
                        final String str5 = bVar.iym;
                        final String str6 = bVar.iyn;
                        final String str7 = bVar.iyi;
                        final String str8 = bVar.iyp;
                        final String str9 = bVar.iyq;
                        h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.b1x), aVar.Pwc.getMMResources().getString(R.string.yd), aVar.Pwc.getMMResources().getString(R.string.b1y), aVar.Pwc.getMMResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.f.c.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(36853);
                                Intent intent = new Intent();
                                intent.putExtra("key_scene", 1);
                                intent.putExtra("key_receiver", str2);
                                intent.putExtra("key_receivertitle", str3);
                                intent.putExtra("key_sendertitle", str4);
                                intent.putExtra("key_sender_des", str5);
                                intent.putExtra("key_receiver_des", str6);
                                intent.putExtra("key_url", str7);
                                intent.putExtra("key_templateid", str8);
                                intent.putExtra("key_sceneid", str9);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                                AppMethodBeat.o(36853);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.f.c.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    AppMethodBeat.o(36857);
                    return true;
                case 144:
                    Intent intent = new Intent();
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                    AppMethodBeat.o(36857);
                    return true;
                default:
                    AppMethodBeat.o(36857);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b bVar;
            int i2;
            int i3 = 0;
            int i4 = 2;
            AppMethodBeat.i(36858);
            if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(view.getContext())) {
                AppMethodBeat.o(36858);
            } else {
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
                String str = caVar.field_content;
                if (str != null) {
                    bVar = k.b.aD(str, caVar.field_reserved);
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    String str2 = Util.isNullOrNil(bVar.iyi) ? bVar.url : bVar.iyi;
                    Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", Boolean.valueOf(Util.isNullOrNil(str2)), Boolean.valueOf(Util.isNullOrNil(bVar.iyz)));
                    if (!Util.isNullOrNil(bVar.iyr)) {
                        if (bVar.iyr.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                            Intent intent = new Intent();
                            intent.putExtra("key_way", 1);
                            intent.putExtra("key_native_url", bVar.iyr);
                            intent.putExtra("key_username", aVar.getTalkerUserName());
                            intent.putExtra("key_static_from_scene", TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                        } else if (bVar.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_way", aVar.gRM() ? 0 : 1);
                            intent2.putExtra("key_native_url", bVar.iyr);
                            intent2.putExtra("key_username", aVar.getTalkerUserName());
                            intent2.putExtra("scene_id", Integer.parseInt(bVar.iyq));
                            intent2.putExtra("key_invalidtime", bVar.ixR);
                            com.tencent.mm.ag.c cVar = (com.tencent.mm.ag.c) bVar.as(com.tencent.mm.ag.c.class);
                            com.tencent.mm.ag.g gVar = (com.tencent.mm.ag.g) bVar.as(com.tencent.mm.ag.g.class);
                            intent2.putExtra("key_exclusive_username", cVar.iwa);
                            intent2.putExtra("key_cropname", cVar.ivR);
                            intent2.putExtra("key_receive_envelope_url", cVar.ivW);
                            intent2.putExtra("key_receive_envelope_md5", cVar.ivX);
                            intent2.putExtra("key_detail_envelope_url", cVar.ivY);
                            intent2.putExtra("key_detail_envelope_md5", cVar.ivZ);
                            intent2.putExtra("key_about_url", gVar.iwt);
                            intent2.putExtra("key_packet_id", gVar.iwu);
                            intent2.putExtra("key_has_story", gVar.iwx);
                            intent2.putExtra("key_material_flag", gVar.iwy);
                            intent2.putExtra("key_msgid", caVar.field_msgId);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent2);
                            if (cVar.iwb.iwx) {
                                if (!Util.isNullOrNil(cVar.iwb.iwv)) {
                                    i2 = 2;
                                } else {
                                    i2 = 1;
                                }
                                String str3 = caVar.sessionId;
                                String str4 = cVar.ivR;
                                String talkerUserName = aVar.getTalkerUserName();
                                String str5 = cVar.iwb.iwu;
                                if (!cVar.iwb.iwx) {
                                    i4 = 1;
                                }
                                com.tencent.mm.plugin.luckymoney.a.c.a(str3, str4, talkerUserName, str5, i4, i2);
                                com.tencent.mm.plugin.luckymoney.a.c.bC(10, cVar.ivS);
                                caVar.sessionId = UUID.randomUUID().toString();
                            }
                        } else if (bVar.iyr.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")) {
                            Intent intent3 = new Intent();
                            if (!aVar.gRM()) {
                                i3 = 1;
                            }
                            intent3.putExtra("key_way", i3);
                            intent3.putExtra("key_native_url", bVar.iyr);
                            intent3.putExtra("key_hk_url", str2);
                            intent3.putExtra("key_username", aVar.getTalkerUserName());
                            intent3.putExtra("key_msgid", caVar.field_msgId);
                            intent3.putExtra("key_hk_scene", 1);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", intent3);
                        } else {
                            Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + bVar.iyr + ", go webview:" + str2);
                            if (!Util.isNullOrNil(str2)) {
                                Intent intent4 = new Intent();
                                intent4.putExtra("rawUrl", str2);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                            }
                        }
                    } else if (!Util.isNullOrNil(bVar.iyz)) {
                        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", bVar.iyz, Integer.valueOf(bVar.iyA), bVar.dRL);
                        if (bVar.iyA == 2 || bVar.iyA == 3 || bVar.iyA == 1 || bVar.iyA == 5) {
                            Intent intent5 = new Intent();
                            intent5.putExtra("bill_no", bVar.iyz);
                            intent5.putExtra("launcher_user_name", bVar.dRL);
                            intent5.putExtra("enter_scene", 1);
                            intent5.putExtra("chatroom", aVar.getTalkerUserName());
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "aa", ".ui.PaylistAAUI", intent5);
                            if (bVar.iyA == 2) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 1, 2);
                            } else if (bVar.iyA == 3) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 1, 3);
                            } else if (bVar.iyA == 5) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 1, 4);
                            }
                        } else if (!Util.isNullOrNil(str2)) {
                            Intent intent6 = new Intent();
                            intent6.putExtra("rawUrl", str2);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent6);
                        }
                    } else if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str2)) {
                        Intent intent7 = new Intent();
                        intent7.putExtra("rawUrl", str2);
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent7);
                    }
                }
                AppMethodBeat.o(36858);
            }
            return true;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 436207665) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36848);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r8);
                view.setTag(new a().gM(view));
            }
            AppMethodBeat.o(36848);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:115:0x0428  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x043e  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x0482  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0186  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01e8  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0233  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x024e  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r12, int r13, com.tencent.mm.ui.chatting.e.a r14, com.tencent.mm.storage.ca r15, java.lang.String r16) {
            /*
            // Method dump skipped, instructions count: 1195
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.f.b.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233616);
            int i2 = ((bq) view.getTag()).position;
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
            }
            AppMethodBeat.o(233616);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36851);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(36851);
                    return true;
                case 144:
                    Intent intent = new Intent();
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                    AppMethodBeat.o(36851);
                    return true;
                default:
                    AppMethodBeat.o(36851);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b bVar;
            int i2;
            int i3 = 0;
            int i4 = 2;
            AppMethodBeat.i(36852);
            if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(view.getContext())) {
                AppMethodBeat.o(36852);
            } else {
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
                String str = caVar.field_content;
                if (str != null) {
                    bVar = k.b.aD(str, caVar.field_reserved);
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    String str2 = Util.isNullOrNil(bVar.iyi) ? bVar.url : bVar.iyi;
                    Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", Boolean.valueOf(Util.isNullOrNil(str2)), Boolean.valueOf(Util.isNullOrNil(bVar.iyz)));
                    if (!Util.isNullOrNil(bVar.iyr)) {
                        if (bVar.iyr.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                            Intent intent = new Intent();
                            intent.putExtra("key_way", 1);
                            intent.putExtra("key_native_url", bVar.iyr);
                            intent.putExtra("key_username", aVar.getTalkerUserName());
                            intent.putExtra("key_static_from_scene", TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                        } else if (bVar.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_way", aVar.gRM() ? 0 : 1);
                            intent2.putExtra("key_native_url", bVar.iyr);
                            intent2.putExtra("key_username", aVar.getTalkerUserName());
                            intent2.putExtra("scene_id", Integer.parseInt(bVar.iyq));
                            intent2.putExtra("key_invalidtime", bVar.ixR);
                            com.tencent.mm.ag.c cVar = (com.tencent.mm.ag.c) bVar.as(com.tencent.mm.ag.c.class);
                            com.tencent.mm.ag.g gVar = (com.tencent.mm.ag.g) bVar.as(com.tencent.mm.ag.g.class);
                            intent2.putExtra("key_exclusive_username", cVar.iwa);
                            intent2.putExtra("key_cropname", cVar.ivR);
                            intent2.putExtra("key_receive_envelope_url", cVar.ivW);
                            intent2.putExtra("key_receive_envelope_md5", cVar.ivX);
                            intent2.putExtra("key_detail_envelope_url", cVar.ivY);
                            intent2.putExtra("key_detail_envelope_md5", cVar.ivZ);
                            intent2.putExtra("key_about_url", gVar.iwt);
                            intent2.putExtra("key_packet_id", gVar.iwu);
                            intent2.putExtra("key_has_story", gVar.iwx);
                            intent2.putExtra("key_material_flag", gVar.iwy);
                            intent2.putExtra("key_msgid", caVar.field_msgId);
                            intent2.putExtra("key_emoji_md5", ((d) bVar.as(d.class)).gWm.field_md5);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent2);
                            if (ab.IN(aVar.getTalkerUserName())) {
                                com.tencent.mm.plugin.luckymoney.a.d.xV(1);
                            }
                            if (cVar.iwb.iwx) {
                                if (!Util.isNullOrNil(cVar.iwb.iwv)) {
                                    i2 = 2;
                                } else {
                                    i2 = 1;
                                }
                                String str3 = caVar.sessionId;
                                String str4 = cVar.ivR;
                                String talkerUserName = aVar.getTalkerUserName();
                                String str5 = cVar.iwb.iwu;
                                if (!cVar.iwb.iwx) {
                                    i4 = 1;
                                }
                                com.tencent.mm.plugin.luckymoney.a.c.a(str3, str4, talkerUserName, str5, i4, i2);
                                com.tencent.mm.plugin.luckymoney.a.c.bC(10, cVar.ivS);
                                caVar.sessionId = UUID.randomUUID().toString();
                            }
                        } else if (bVar.iyr.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")) {
                            Intent intent3 = new Intent();
                            if (!aVar.gRM()) {
                                i3 = 1;
                            }
                            intent3.putExtra("key_way", i3);
                            intent3.putExtra("key_native_url", bVar.iyr);
                            intent3.putExtra("key_hk_url", str2);
                            intent3.putExtra("key_username", aVar.getTalkerUserName());
                            intent3.putExtra("key_msgid", caVar.field_msgId);
                            intent3.putExtra("key_hk_scene", 1);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", intent3);
                        } else {
                            Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + bVar.iyr + ", go webview:" + str2);
                            if (!Util.isNullOrNil(str2)) {
                                Intent intent4 = new Intent();
                                intent4.putExtra("rawUrl", str2);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                            }
                        }
                    } else if (!Util.isNullOrNil(bVar.iyz)) {
                        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", bVar.iyz, Integer.valueOf(bVar.iyA), bVar.dRL);
                        if (bVar.iyA == 2 || bVar.iyA == 3 || bVar.iyA == 1 || bVar.iyA == 5) {
                            Intent intent5 = new Intent();
                            intent5.putExtra("bill_no", bVar.iyz);
                            intent5.putExtra("launcher_user_name", bVar.dRL);
                            intent5.putExtra("enter_scene", 1);
                            intent5.putExtra("chatroom", aVar.getTalkerUserName());
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "aa", ".ui.PaylistAAUI", intent5);
                        } else if (!Util.isNullOrNil(str2)) {
                            Intent intent6 = new Intent();
                            intent6.putExtra("rawUrl", str2);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent6);
                        }
                        if (com.tencent.mm.ui.chatting.f.h(bVar).role == 2) {
                            if (bVar.iyA == 2) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 2, 2);
                            } else if (bVar.iyA == 3) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 2, 3);
                            } else if (bVar.iyA == 5) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 2, 4);
                            }
                        } else if (bVar.iyA == 2) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 3, 2);
                        } else if (bVar.iyA == 3) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 3, 3);
                        } else if (bVar.iyA == 5) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 3, 4);
                        }
                    } else if (!Util.isNullOrNil(str2)) {
                        Intent intent7 = new Intent();
                        intent7.putExtra("rawUrl", str2);
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent7);
                    }
                }
                AppMethodBeat.o(36852);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c.a {
        public boolean IBL;
        public TextView PJA;
        public TextView PJB;
        public ImageView PJC;
        public ImageView PJD;
        public int PJE = 0;
        public int PJF;
        public long PJG;
        public int PJa = 0;
        public ImageView PJw;
        public TextView PJx;
        public TextView PJy;
        public TextView PJz;
        public View jWr;
        public int maxSize = 0;
        public View qdl;
        public ImageView zhf;

        a() {
        }

        public final a gM(View view) {
            AppMethodBeat.i(36847);
            super.create(view);
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.checkBox = (CheckBox) this.convertView.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.qdl = this.convertView.findViewById(R.id.d8b);
            this.jWr = (ImageView) this.convertView.findViewById(R.id.brt);
            this.PJw = (ImageView) this.convertView.findViewById(R.id.tv);
            this.PJx = (TextView) this.convertView.findViewById(R.id.u1);
            this.PJy = (TextView) this.convertView.findViewById(R.id.tt);
            this.PJz = (TextView) this.convertView.findViewById(R.id.u5);
            this.clickArea = this.convertView.findViewById(R.id.auf);
            this.zhf = (ImageView) this.convertView.findViewById(R.id.aw2);
            this.PJB = (TextView) this.convertView.findViewById(R.id.u4);
            this.PJA = (TextView) this.convertView.findViewById(R.id.u2);
            this.PJC = (ImageView) this.convertView.findViewById(R.id.aw3);
            this.PJD = (ImageView) this.convertView.findViewById(R.id.u3);
            this.jWr = this.convertView.findViewById(R.id.tu);
            this.PJa = c.kl(MMApplicationContext.getContext());
            this.PJE = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.a_);
            this.maxSize = (int) (((float) com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a_)) * 1.45f);
            this.PJF = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
            AppMethodBeat.o(36847);
            return this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(final com.tencent.mm.ui.chatting.viewitems.f.a r7, final com.tencent.mm.ag.c r8, final boolean r9, int r10, java.lang.String r11, com.tencent.mm.storage.ca r12) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.f.a(com.tencent.mm.ui.chatting.viewitems.f$a, com.tencent.mm.ag.c, boolean, int, java.lang.String, com.tencent.mm.storage.ca):void");
    }
}
