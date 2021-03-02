package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.view.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.ao;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;
import kotlin.x;

public final class t {

    public interface n {
        void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar);
    }

    public static class b implements View.OnClickListener {
        private com.tencent.mm.ui.chatting.e.a PhN;

        public b(com.tencent.mm.ui.chatting.e.a aVar) {
            this.PhN = aVar;
        }

        public void onClick(View view) {
            boolean z;
            boolean z2 = false;
            AppMethodBeat.i(34590);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34590);
                return;
            }
            String str = bqVar.userName;
            if (str == null || str.equals("")) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34590);
            } else if (((ac) this.PhN.bh(ac.class)).gQH()) {
                Activity context = this.PhN.Pwc.getContext();
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_IsLbsChattingProfile", true);
                com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34590);
            } else {
                if (((com.tencent.mm.ui.chatting.d.b.h) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) {
                    String str2 = "";
                    if (((com.tencent.mm.ui.chatting.d.b.h) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bjt(str)) {
                        str2 = str;
                    } else if (as.avl(str)) {
                        str2 = ((aa) com.tencent.mm.kernel.g.af(aa.class)).avi(str);
                    }
                    com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                    com.tencent.mm.plugin.finder.report.d.dnJ().vdH++;
                    if (((com.tencent.mm.ui.chatting.d.b.h) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bjt(str2)) {
                        if (str.equals(z.aUg())) {
                            str2 = str;
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("finder_username", str2);
                        intent2.putExtra("key_enter_profile_type", 10);
                        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                        FinderReporterUIC.a.a(this.PhN.Pwc.getContext(), intent2, 0, 10, false);
                        intent2.putExtra("KEY_FINDER_SELF_FLAG", str.equals(z.aUg()));
                        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(this.PhN.Pwc.getContext(), intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(34590);
                        return;
                    } else if (((com.tencent.mm.ui.chatting.d.b.h) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bmH(str2)) {
                        ((aa) com.tencent.mm.kernel.g.af(aa.class)).avj(str2);
                        Intent intent3 = new Intent();
                        ah avb = ((com.tencent.mm.plugin.i.a.m) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.m.class)).avb(str2);
                        n.a aVar2 = com.tencent.mm.plugin.finder.view.n.wpY;
                        n.a.a(avb, intent3);
                        intent3.putExtra("IsPoster", true);
                        n.a aVar3 = com.tencent.mm.plugin.finder.view.n.wpY;
                        n.a.a(this.PhN.Pwc.getContext(), intent3, (kotlin.g.a.b<? super String, x>) null);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(34590);
                        return;
                    }
                }
                if (((com.tencent.mm.ui.chatting.d.b.i) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()) {
                    ((com.tencent.mm.plugin.gamelife.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.PhN.Pwc.getContext(), str, com.tencent.mm.plugin.gamelife.a.xZY);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(34590);
                    return;
                }
                com.tencent.mm.ui.chatting.d.b.d dVar2 = (com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class);
                if (dVar2.gOP()) {
                    com.tencent.mm.al.a.k NC = dVar2.gON().NC(str);
                    if (NC != null) {
                        if (NC == null || Util.isNullOrNil(NC.field_profileUrl)) {
                            Object[] objArr = new Object[1];
                            if (NC == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[0] = Boolean.valueOf(z);
                            Log.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", objArr);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(34590);
                            return;
                        }
                        Log.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", NC.field_profileUrl);
                        ag.baq().bm(NC.field_userId, NC.field_brandUserName);
                        Intent intent4 = new Intent();
                        intent4.putExtra("rawUrl", NC.field_profileUrl);
                        intent4.putExtra("useJs", true);
                        com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(34590);
                    return;
                }
                Intent intent5 = new Intent();
                intent5.putExtra("Contact_User", str);
                a(intent5, bqVar);
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    com.tencent.mm.ui.contact.e.a(intent5, str);
                }
                if (ab.Eq(this.PhN.getTalkerUserName())) {
                    bg.aVF();
                    com.tencent.mm.storage.ah Ke = com.tencent.mm.model.c.aSX().Ke(this.PhN.getTalkerUserName());
                    intent5.putExtra("Contact_RoomNickname", Ke.getDisplayName(str));
                    intent5.putExtra("Contact_Scene", 14);
                    intent5.putExtra("Contact_ChatRoomId", this.PhN.getTalkerUserName());
                    intent5.putExtra("room_name", this.PhN.getTalkerUserName());
                    if (Ke.field_roomowner != null) {
                        z2 = Ke.field_roomowner.equals(z.aTY());
                    }
                    intent5.putExtra("Is_RoomOwner", z2);
                }
                if (bqVar.dTX != null) {
                    switch (bqVar.dTX.getType()) {
                        case 55:
                        case com.tencent.mm.plugin.appbrand.jsapi.pay.n.CTRL_INDEX:
                            intent5.putExtra("Contact_Scene", 34);
                            intent5.putExtra("Contact_IsLBSFriend", true);
                            break;
                    }
                }
                if (dVar2.a(this.PhN, bqVar)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(34590);
                    return;
                }
                intent5.putExtra("CONTACT_INFO_UI_SOURCE", this.PhN.gRM() ? 3 : 2);
                com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent5, 213);
                if (this.PhN.gRM() && ((com.tencent.mm.ui.chatting.d.b.f) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.f.class)).gPh()) {
                    ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(str, 5);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34590);
            }
        }

        public void a(Intent intent, bq bqVar) {
        }
    }

    public static class a extends b {
        public a(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.b
        public final void a(Intent intent, bq bqVar) {
            AppMethodBeat.i(34589);
            if (!Util.isNullOrNil(bqVar.PQF)) {
                intent.putExtra("Contact_BIZ_KF_WORKER_ID", bqVar.PQF);
            }
            AppMethodBeat.o(34589);
        }
    }

    public static class d implements View.OnLongClickListener {
        private com.tencent.mm.ui.chatting.e.a PhN;

        public d(com.tencent.mm.ui.chatting.e.a aVar) {
            this.PhN = aVar;
        }

        public final boolean onLongClick(View view) {
            int i2;
            CharSequence a2;
            CharSequence Iq;
            AppMethodBeat.i(34594);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (((u) this.PhN.bh(u.class)).gPO().gqI()) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(34594);
                return true;
            } else if (((com.tencent.mm.ui.chatting.d.b.h) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(34594);
                return false;
            } else if (((com.tencent.mm.ui.chatting.d.b.i) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(34594);
                return false;
            } else {
                bq bqVar = (bq) view.getTag();
                u uVar = (u) this.PhN.bh(u.class);
                String lastText = uVar.gPO().getLastText();
                int selectionStart = uVar.gPO().getSelectionStart();
                if (selectionStart < 0) {
                    i2 = 0;
                } else if (selectionStart > lastText.length()) {
                    i2 = lastText.length();
                } else {
                    i2 = selectionStart;
                }
                if ((bqVar != null && z.aTY().equals(bqVar.userName)) || bqVar.userName.equals("notifymessage") || bqVar.userName.equals("appbrand_notify_message")) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(34594);
                    return true;
                } else if (((u) this.PhN.bh(u.class)).gPO().getIsVoiceInputPanleShow()) {
                    Log.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(34594);
                    return true;
                } else {
                    com.tencent.mm.ui.chatting.d.b.d dVar = (com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class);
                    if (ab.Eq(this.PhN.getTalkerUserName()) || dVar.gOQ()) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10976, 0, 1, 0);
                        bg.aVF();
                        com.tencent.mm.storage.ah Kd = com.tencent.mm.model.c.aSX().Kd(bqVar.chatroomName);
                        if (dVar.gOQ()) {
                            a2 = ((com.tencent.mm.ui.chatting.d.b.f) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(bqVar.userName);
                        } else {
                            a2 = AtSomeoneUI.a(Kd, bqVar.userName);
                            if (Util.isNullOrNil(a2)) {
                                a2 = com.tencent.mm.model.aa.Iq(bqVar.userName);
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer(lastText);
                        stringBuffer.insert(i2, "@" + ((Object) a2) + (char) 8197);
                        uVar.gPO().z(stringBuffer.toString(), i2 + a2.length() + 2, true);
                        uVar.gPO().bj(bqVar.chatroomName, bqVar.userName, a2 == null ? null : a2.toString());
                        uVar.gPO().setMode(1);
                        view.postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.t.d.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(34592);
                                AppMethodBeat.o(34592);
                            }
                        }, 2000);
                    } else if (ab.IS(this.PhN.getTalkerUserName()) && !this.PhN.getTalkerUserName().contains("@")) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10976, 0, 1, 1);
                        if (!dVar.gOP() || dVar.gOQ()) {
                            Iq = com.tencent.mm.model.aa.Iq(bqVar.userName);
                        } else {
                            Iq = ((com.tencent.mm.ui.chatting.d.b.f) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(bqVar.userName);
                        }
                        StringBuffer stringBuffer2 = new StringBuffer(lastText);
                        stringBuffer2.insert(i2, Iq);
                        uVar.gPO().z(stringBuffer2.toString(), Iq.length() + i2, true);
                        uVar.gPO().setMode(1);
                        view.postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.t.d.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(34593);
                                AppMethodBeat.o(34593);
                            }
                        }, 2000);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(34594);
                    return true;
                }
            }
        }
    }

    public static class c implements c.a {
        private com.tencent.mm.ui.chatting.e.a PhN;

        public c(com.tencent.mm.ui.chatting.e.a aVar) {
            this.PhN = aVar;
        }

        @Override // com.tencent.mm.plugin.patmsg.a.c.a
        public final boolean eF(View view) {
            AppMethodBeat.i(34591);
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                Log.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
                AppMethodBeat.o(34591);
                return true;
            }
            String str = bqVar.userName;
            Log.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", str);
            if (!((PluginPatMsg) com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).isPatEnable() || !((com.tencent.mm.plugin.patmsg.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).J(1, this.PhN.getTalkerUserName(), str)) {
                AppMethodBeat.o(34591);
                return true;
            }
            AppMethodBeat.o(34591);
            return false;
        }
    }

    public static class p extends e {
        public p(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            int i2;
            long j2;
            Exception e2;
            UnsupportedOperationException e3;
            Map<String, String> parseXml;
            AppMethodBeat.i(34608);
            bq bqVar = (bq) view.getTag();
            int i3 = 0;
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (int) (currentTimeMillis / 1000);
            Log.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", Integer.valueOf(i4));
            if (e.a(bqVar.egX, aVar.Pwc.getContext(), null, aVar.getTalkerUserName())) {
                AppMethodBeat.o(34608);
                return;
            }
            String str = bqVar.userName;
            String str2 = bqVar.Nwj;
            if (str == null || str.equals("")) {
                AppMethodBeat.o(34608);
                return;
            }
            String d2 = com.tencent.mm.ag.m.d(str, 0, aVar.Pwc.getIntExtra("KOpenArticleSceneFromScene", 10000), i4);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d2);
            intent.putExtra("shortUrl", d2);
            intent.putExtra("webpageTitle", str2);
            Bundle bundle = new Bundle();
            if (caVar != null) {
                if (caVar.gDj() && (parseXml = XmlParser.parseXml(caVar.field_content, "msg", null)) != null) {
                    ao.b ci = ao.b.ci(parseXml);
                    if (!Util.isNullOrNil(ci.ixM)) {
                        intent.putExtra("KTemplateId", ci.ixM);
                        Log.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", ci.ixM, bqVar.eag);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11608, ci.ixM, bqVar.eag, 0);
                    }
                }
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(caVar.field_talker);
                if (Kn != null && Kn.gBM()) {
                    i3 = 4;
                    Log.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", Kn.field_username);
                    intent.putExtra("geta8key_scene", 7);
                }
                i2 = i3;
                intent.putExtra("msg_id", caVar.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
                intent.putExtra("pre_username", caVar.field_talker);
                intent.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
                intent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(caVar, bqVar.Pdm, ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()));
                intent.putExtra("preChatName", aVar.getTalkerUserName());
                intent.putExtra("preMsgIndex", bqVar.IZD);
                Bundle bundle2 = bqVar.PQH;
                if (bundle2 != null) {
                    intent.putExtras(bundle2);
                }
            } else {
                i2 = 0;
            }
            bundle.putInt("snsWebSource", i2);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            if (!Util.isNullOrNil(bqVar.eag)) {
                intent.putExtra("srcUsername", bqVar.eag);
                intent.putExtra("srcDisplayname", bqVar.eah);
                intent.putExtra("mode", 1);
            }
            intent.putExtra("message_id", bqVar.IZC);
            intent.putExtra("message_index", bqVar.IZD);
            intent.putExtra("from_scence", 1);
            intent.putExtra("start_activity_time", currentTimeMillis);
            intent.putExtra(e.p.OzA, bqVar.PQJ);
            com.tencent.mm.ui.chatting.viewitems.c.r(intent, aVar.getTalkerUserName());
            intent.addFlags(536870912);
            int intExtra = aVar.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
            if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(2) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.Pwc.getContext(), d2, bqVar.PQJ, 0, intExtra, intent)) {
                intent.putExtra("rawUrl", d2);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            } else {
                Log.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
            }
            if (!Util.isNullOrNil(aVar.getTalkerUserName())) {
                bg.aVF();
                if (com.tencent.mm.model.c.aSN().Kn(aVar.getTalkerUserName()).fuQ == 1) {
                    bg.aVF();
                    com.tencent.mm.model.c.aST().bkd(aVar.getTalkerUserName());
                }
            }
            if (caVar != null && caVar.gAt()) {
                com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
                if (a2 == null || a2.iAd == null || a2.iAd.size() <= bqVar.IZD) {
                    AppMethodBeat.o(34608);
                    return;
                }
                int i5 = 0;
                v vVar = (v) a2.iAd.get(bqVar.IZD);
                if (!Util.isNullOrNil(vVar.url)) {
                    try {
                        Uri parse = Uri.parse(vVar.url);
                        j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                        try {
                            i5 = Util.getInt(parse.getQueryParameter("idx"), 0);
                        } catch (UnsupportedOperationException e4) {
                            e3 = e4;
                            Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e3.getMessage());
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16243, caVar.field_talker, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(aVar.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()), 2, Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.ag.m.ape()));
                            com.tencent.mm.ui.chatting.viewitems.c.c(aVar, caVar);
                            AppMethodBeat.o(34608);
                        } catch (Exception e5) {
                            e2 = e5;
                            Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16243, caVar.field_talker, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(aVar.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()), 2, Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.ag.m.ape()));
                            com.tencent.mm.ui.chatting.viewitems.c.c(aVar, caVar);
                            AppMethodBeat.o(34608);
                        }
                    } catch (UnsupportedOperationException e6) {
                        e3 = e6;
                        j2 = 0;
                        Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e3.getMessage());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16243, caVar.field_talker, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(aVar.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()), 2, Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.ag.m.ape()));
                        com.tencent.mm.ui.chatting.viewitems.c.c(aVar, caVar);
                        AppMethodBeat.o(34608);
                    } catch (Exception e7) {
                        e2 = e7;
                        j2 = 0;
                        Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16243, caVar.field_talker, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(aVar.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()), 2, Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.ag.m.ape()));
                        com.tencent.mm.ui.chatting.viewitems.c.c(aVar, caVar);
                        AppMethodBeat.o(34608);
                    }
                } else {
                    j2 = 0;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16243, caVar.field_talker, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(aVar.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()), 2, Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.ag.m.ape()));
                com.tencent.mm.ui.chatting.viewitems.c.c(aVar, caVar);
            }
            AppMethodBeat.o(34608);
        }
    }

    public static class h extends e {
        public h(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34600);
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            intent.putExtra("rawUrl", ((bq) view.getTag()).fQR);
            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(34600);
        }
    }

    public static class k extends e {
        public k(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34603);
            s.a(view, aVar.Pwc.getContext(), aVar.getTalkerUserName());
            AppMethodBeat.o(34603);
        }
    }

    public static class i extends e {
        public i(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34601);
            bq bqVar = (bq) view.getTag();
            int i2 = bqVar.designerUIN;
            String str = bqVar.designerName;
            String str2 = bqVar.designerRediretctUrl;
            if (i2 != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", bqVar.fQR);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i2);
                intent.putExtra("name", str);
                intent.putExtra("rediret_url", str2);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
            }
            AppMethodBeat.o(34601);
        }
    }

    public static class m extends e {
        public m(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34607);
            com.tencent.mm.ui.base.h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.brw), "", aVar.Pwc.getMMResources().getString(R.string.bry), aVar.Pwc.getMMResources().getString(R.string.brv), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.t.m.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34605);
                    dk dkVar = new dk();
                    dkVar.dGv.enable = true;
                    EventCenter.instance.publish(dkVar);
                    AppMethodBeat.o(34605);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.t.m.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34606);
                    dk dkVar = new dk();
                    dkVar.dGv.enable = false;
                    EventCenter.instance.publish(dkVar);
                    AppMethodBeat.o(34606);
                }
            });
            AppMethodBeat.o(34607);
        }
    }

    public static class l extends e {
        public l(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34604);
            bq bqVar = (bq) view.getTag();
            int i2 = bqVar.tid;
            String str = bqVar.iyW;
            String str2 = bqVar.desc;
            String str3 = bqVar.iconUrl;
            String str4 = bqVar.secondUrl;
            if (i2 != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", bqVar.fQR);
                intent.putExtra("topic_id", i2);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_desc", str2);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                AppMethodBeat.o(34604);
                return;
            }
            Log.i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.o(34604);
        }
    }

    public static class j extends e {
        public j(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(34602);
            bq bqVar = (bq) view.getTag();
            int i2 = bqVar.tid;
            String str = bqVar.iyW;
            String str2 = bqVar.desc;
            String str3 = bqVar.iconUrl;
            String str4 = bqVar.secondUrl;
            int i3 = bqVar.pageType;
            if (i2 != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", bqVar.fQR);
                intent.putExtra("set_id", i2);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.putExtra("headurl", str4);
                intent.putExtra("pageType", i3);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                AppMethodBeat.o(34602);
                return;
            }
            Log.i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.o(34602);
        }
    }

    public static abstract class e implements View.OnClickListener {
        public com.tencent.mm.ui.chatting.e.a PhN;

        public abstract void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar);

        public e(com.tencent.mm.ui.chatting.e.a aVar) {
            this.PhN = aVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ca caVar = ((bq) view.getTag()).dTX;
            if (caVar == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                return;
            }
            a(view, this.PhN, caVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        }
    }

    public static class g implements View.OnTouchListener {
        private int[] PhV = new int[2];

        public g() {
            AppMethodBeat.i(34598);
            AppMethodBeat.o(34598);
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(34599);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, bVar.axR());
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.PhV[0] = (int) motionEvent.getRawX();
                    this.PhV[1] = (int) motionEvent.getRawY();
                    view.setTag(R.id.iu_, this.PhV);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(34599);
            return false;
        }
    }

    public static class f implements MMTextView.b {
        private long BAN = 0;
        boolean CJo = false;
        private boolean FNV = false;
        private com.tencent.mm.ui.chatting.e.a PhN = null;
        private MMTextView PhP = null;
        private TextView PhQ = null;
        private final int PhR = 3;
        private int PhS = 0;
        private int PhT = 0;
        MMHandler handler = new MMHandler() {
            /* class com.tencent.mm.ui.chatting.t.f.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(34595);
                View view = (View) message.obj;
                if (f.this.wqz != view.getScrollY()) {
                    f.this.CJo = true;
                    f.this.handler.sendMessageDelayed(f.this.handler.obtainMessage(0, view), 5);
                    f.this.wqz = view.getScrollY();
                    AppMethodBeat.o(34595);
                    return;
                }
                f.this.CJo = false;
                AppMethodBeat.o(34595);
            }
        };
        private View.OnTouchListener kjS = null;
        private com.tencent.mm.ui.base.p kuK = null;
        private ScrollView lTw = null;
        int wqz = 0;

        public f(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(34596);
            this.PhN = aVar;
            AppMethodBeat.o(34596);
        }

        @Override // com.tencent.mm.ui.widget.MMTextView.b
        public final boolean gB(View view) {
            CharSequence charSequence;
            AppMethodBeat.i(34597);
            if (view.getTag() instanceof bq) {
                bq bqVar = (bq) view.getTag();
                if (!(!(view instanceof TextView) || bqVar.dTX == null || this.PhN == null)) {
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    } else {
                        charSequence = "";
                    }
                    Activity context = this.PhN.Pwc.getContext();
                    ca caVar = bqVar.dTX;
                    boolean gRM = this.PhN.gRM();
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    intent.putExtra("is_group_chat", gRM);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListDoubleClickListener", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/storage/MsgInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.kc(context);
                    AppMethodBeat.o(34597);
                    return true;
                }
            }
            AppMethodBeat.o(34597);
            return false;
        }
    }

    public static class o {
        ca dTX;
        String dkU;
        String ixM;

        public o(String str, ca caVar, String str2) {
            this.ixM = str;
            this.dTX = caVar;
            this.dkU = str2;
        }
    }
}
