package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.by;
import com.tencent.mm.model.n;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.o.c;
import com.tencent.mm.ui.chatting.o.d;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@a(gRF = ah.class)
public class ap extends a implements b.AbstractC1472b, ah {
    private c PsA;
    private com.tencent.mm.plugin.selectrecord.e.b PsB;
    private com.tencent.mm.ui.chatting.o.a Psw;
    private com.tencent.mm.ui.chatting.o.b Psx;
    private d Psy;
    private com.tencent.mm.plugin.messenger.c.a Psz;
    private l contextMenuHelper;

    static /* synthetic */ void a(ap apVar, View view, com.tencent.mm.ui.chatting.j.a aVar) {
        AppMethodBeat.i(35522);
        apVar.a(view, aVar);
        AppMethodBeat.o(35522);
    }

    @Override // com.tencent.mm.az.a.b
    public final void a(final View view, ca caVar, final com.tencent.mm.az.a aVar, int i2) {
        boolean z;
        AppMethodBeat.i(35513);
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            String nullAsNil = Util.nullAsNil(eVar.jfH);
            Log.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", nullAsNil, Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()));
            if (eVar.jfV == null) {
                Log.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
                AppMethodBeat.o(35513);
                return;
            }
            if (!(((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ() || this.dom.gRL())) {
                Log.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
                AppMethodBeat.o(35513);
            } else if (nullAsNil.equals("invite")) {
                c(-1, eVar.jfV, 0);
                AppMethodBeat.o(35513);
            } else if (nullAsNil.equals("qrcode")) {
                a(view, eVar.jfV, eVar.dTx);
                AppMethodBeat.o(35513);
            } else {
                if (nullAsNil.equals("webview") && !Util.isNullOrNil(eVar.url)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", eVar.url);
                    intent.putExtra("geta8key_username", z.aTY());
                    com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(35513);
            }
        } else if (aVar instanceof com.tencent.mm.az.d) {
            com.tencent.mm.az.d dVar = (com.tencent.mm.az.d) aVar;
            if (i2 == 0) {
                a(dVar.jfS, "", "", dVar.jfT, dVar.jfM, dVar.dHx, dVar.jfN, dVar.jfQ, new LinkedList<>(), new LinkedList<>(), dVar.jfR, caVar);
            }
            AppMethodBeat.o(35513);
        } else if (aVar instanceof com.tencent.mm.az.b) {
            com.tencent.mm.az.b bVar = (com.tencent.mm.az.b) aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVar.jfN);
            ((f) this.dom.bh(f.class)).a(arrayList, bVar.dHx, caVar);
            AppMethodBeat.o(35513);
        } else if (aVar instanceof com.tencent.mm.ui.chatting.j.a) {
            bg.aVF();
            if (((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.e5p), this.dom.Pwc.getMMResources().getString(R.string.hoz), this.dom.Pwc.getMMResources().getString(R.string.e2u), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.ap.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(35507);
                        ap.a(ap.this, view, (com.tencent.mm.ui.chatting.j.a) aVar);
                        AppMethodBeat.o(35507);
                    }
                });
                AppMethodBeat.o(35513);
                return;
            }
            a(view, (com.tencent.mm.ui.chatting.j.a) aVar);
            AppMethodBeat.o(35513);
        } else if (aVar instanceof com.tencent.mm.az.c) {
            Log.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
            if (this.dom.gRL() && this.dom.Pwc.getContext() != null) {
                if (this.dom.GUe.fuH == 0) {
                    z = true;
                } else {
                    z = false;
                }
                ((com.tencent.mm.plugin.expt.roomexpt.d) g.af(com.tencent.mm.plugin.expt.roomexpt.d.class)).mr(z);
                Intent intent2 = new Intent();
                intent2.putExtra("Chat_User", this.dom.GUe.field_username);
                intent2.putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
                intent2.putExtra("Is_Chatroom", this.dom.gRL());
                intent2.putExtra("fromChatting", true);
                intent2.putExtra("isShowSetMuteAnimation", true);
                intent2.setClass(this.dom.Pwc.getContext(), ChatroomInfoUI.class);
                Activity context = this.dom.Pwc.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(35513);
        } else if (aVar instanceof by) {
            ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOW();
            AppMethodBeat.o(35513);
        } else if (aVar instanceof n) {
            ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOX();
            AppMethodBeat.o(35513);
        } else {
            if (aVar instanceof com.tencent.mm.openim.c.a.b) {
                com.tencent.mm.openim.c.a.b bVar2 = (com.tencent.mm.openim.c.a.b) aVar;
                if (i2 == 0) {
                    a(bVar2.jfS, bVar2.jHt, bVar2.jHu, bVar2.jfT, bVar2.jfM, bVar2.dHx, bVar2.jfN, bVar2.jfQ, bVar2.jHr, bVar2.jHs, bVar2.jfR, caVar);
                }
            }
            AppMethodBeat.o(35513);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final android.view.View r12, com.tencent.mm.ui.chatting.j.a r13) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ap.a(android.view.View, com.tencent.mm.ui.chatting.j.a):void");
    }

    private static void a(com.tencent.mm.ui.chatting.j.a aVar, ca caVar, ChatFooter chatFooter) {
        String str;
        String[] split;
        AppMethodBeat.i(233145);
        if (aVar == null || caVar == null || chatFooter == null) {
            AppMethodBeat.o(233145);
            return;
        }
        String str2 = aVar.PEd;
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(233145);
            return;
        }
        try {
            str = new String(Base64.decode(str2, 0));
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.NewXmlSysMsgComponent", th, "parse msgSourceStr err", new Object[0]);
            str = str2;
        }
        if (!Util.isNullOrNil(str)) {
            Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
            if (parseXml == null) {
                AppMethodBeat.o(233145);
                return;
            }
            String str3 = parseXml.get(".msgsource.atuserlist");
            if (!Util.isNullOrNil(str3) && (split = str3.split(",")) != null && split.length > 0) {
                bg.aVF();
                com.tencent.mm.storage.ah Kd = com.tencent.mm.model.c.aSX().Kd(caVar.field_talker);
                for (String str4 : split) {
                    if (!TextUtils.isEmpty(str4)) {
                        String a2 = AtSomeoneUI.a(Kd, str4);
                        if (Util.isNullOrNil(a2)) {
                            bg.aVF();
                            as bjJ = com.tencent.mm.model.c.aSN().bjJ(str4);
                            if (bjJ != null) {
                                a2 = bjJ.arI();
                            }
                        }
                        if (!TextUtils.isEmpty(a2)) {
                            chatFooter.bj(caVar.field_talker, str4, a2);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(233145);
    }

    private void a(View view, final LinkedList<String> linkedList, final String str) {
        AppMethodBeat.i(35515);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(this.dom.Pwc.getContext());
        }
        this.contextMenuHelper.b(view, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.ui.chatting.d.ap.AnonymousClass3 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(35510);
                contextMenu.add(0, 0, 0, view.getContext().getString(R.string.g72));
                contextMenu.add(0, 1, 1, view.getContext().getString(R.string.g6t));
                AppMethodBeat.o(35510);
            }
        }, new o.g() {
            /* class com.tencent.mm.ui.chatting.d.ap.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(35512);
                switch (menuItem.getItemId()) {
                    case 0:
                        ((f) ap.this.dom.bh(f.class)).b(-1, linkedList, 0);
                        AppMethodBeat.o(35512);
                        return;
                    case 1:
                        final com.tencent.mm.roomsdk.a.c.a Z = com.tencent.mm.roomsdk.a.b.bhF(ap.this.dom.GUe.field_username).Z(str, ap.this.dom.GUe.field_username);
                        Z.a(ap.this.dom.Pwc.getContext(), ap.this.dom.Pwc.getMMResources().getString(R.string.zb), ap.this.dom.Pwc.getMMResources().getString(R.string.g6w), true, true, new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.chatting.d.ap.AnonymousClass4.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(35511);
                                Z.cancel();
                                AppMethodBeat.o(35511);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(35512);
            }
        });
        AppMethodBeat.o(35515);
    }

    private void c(long j2, LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(233146);
        if (((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
            ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).bL(linkedList);
            AppMethodBeat.o(233146);
            return;
        }
        ((f) this.dom.bh(f.class)).b(j2, linkedList, i2);
        AppMethodBeat.o(233146);
    }

    @SuppressLint({"StringFormatMatches"})
    private void a(String str, String str2, String str3, String str4, String str5, String str6, LinkedList<String> linkedList, LinkedList<String> linkedList2, LinkedList<String> linkedList3, LinkedList<String> linkedList4, LinkedList<String> linkedList5, ca caVar) {
        AppMethodBeat.i(35517);
        Intent intent = new Intent(this.dom.Pwc.getContext(), SeeAccessVerifyInfoUI.class);
        intent.putExtra("msgLocalId", caVar.field_msgId);
        intent.putExtra("msgSvrId", caVar.field_msgSvrId);
        intent.putExtra("invitertitle", this.dom.Pwc.getMMResources().getString(R.string.ch, Integer.valueOf(linkedList.size())));
        intent.putExtra("inviterusername", str);
        intent.putExtra("chatroom", str5);
        intent.putExtra("inviterappid", str2);
        intent.putExtra("inviterdescid", str3);
        intent.putExtra("invitationreason", str4);
        intent.putExtra("ticket", str6);
        intent.putExtra(ch.COL_USERNAME, Util.listToString(linkedList, ","));
        intent.putExtra("nickname", Util.listToString(linkedList2, ","));
        intent.putExtra("descid", Util.listToString(linkedList3, ","));
        intent.putExtra("appid", Util.listToString(linkedList4, ","));
        intent.putExtra("headimgurl", Util.listToString(linkedList5, ","));
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aVar.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35517);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b.AbstractC1472b
    public final void a(long j2, LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(233147);
        if (linkedList != null && linkedList.size() > 0) {
            c(j2, linkedList, i2);
        }
        AppMethodBeat.o(233147);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b.AbstractC1472b
    public final void a(View view, b.a aVar) {
        AppMethodBeat.i(233148);
        if (!(view == null || aVar == null)) {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(aVar.username);
            a(view, linkedList, aVar.link);
        }
        AppMethodBeat.o(233148);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35520);
        super.gIl();
        this.Psy = new d(this);
        this.Psx = new com.tencent.mm.ui.chatting.o.b(this);
        this.Psw = new com.tencent.mm.ui.chatting.o.a(this);
        this.Psz = new com.tencent.mm.plugin.messenger.c.a(this);
        this.PsA = new c(this);
        this.PsB = new com.tencent.mm.plugin.selectrecord.e.b(this);
        AppMethodBeat.o(35520);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35521);
        if (this.Psw != null) {
            this.Psw.release();
            this.Psw = null;
        }
        if (this.Psx != null) {
            this.Psx.release();
            this.Psx = null;
        }
        if (this.Psy != null) {
            this.Psy.release();
            this.Psy = null;
        }
        if (this.Psz != null) {
            this.Psz.release();
            this.Psz = null;
        }
        if (this.PsA != null) {
            this.PsA.release();
            this.PsA = null;
        }
        if (this.PsB != null) {
            this.PsB.release();
            this.PsB = null;
        }
        AppMethodBeat.o(35521);
    }
}
