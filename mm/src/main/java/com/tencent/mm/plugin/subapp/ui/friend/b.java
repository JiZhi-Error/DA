package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class b extends s<bl> {
    private View.OnClickListener FKx = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(29026);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                Log.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
                final com.tencent.mm.pluginsdk.ui.preference.b bVar2 = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                if (bVar2 == null || Util.isNullOrNil(bVar2.username)) {
                    Log.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29026);
                    return;
                }
                final as a2 = com.tencent.mm.pluginsdk.ui.preference.b.a(d.bgM().bkv(bVar2.username));
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(b.this.context, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(29025);
                        if (z) {
                            if (Util.isNullOrNil(str)) {
                                Log.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                                h.INSTANCE.dN(931, 21);
                            }
                            bg.aVF();
                            as Kn = c.aSN().Kn(bVar2.username);
                            if (((int) Kn.gMZ) == 0) {
                                Kn = a2;
                                if (!Util.isNullOrNil(str)) {
                                    Kn.setUsername(str);
                                }
                                bg.aVF();
                                if (!c.aSN().ap(Kn)) {
                                    Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    AppMethodBeat.o(29025);
                                    return;
                                }
                            }
                            ab.B(Kn);
                            d.bgN().gP(bVar2.username, 1);
                            com.tencent.mm.ui.base.h.cD(b.this.context, b.this.context.getString(R.string.h9));
                            b.a(b.this, bVar2.username);
                        } else if (z2) {
                            d.bgN().gP(bVar2.username, 2);
                        } else {
                            Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + bVar2.username);
                            AppMethodBeat.o(29025);
                            return;
                        }
                        b.this.notifyDataSetChanged();
                        AppMethodBeat.o(29025);
                    }
                });
                Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar2.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(Integer.valueOf(bVar2.Dkc));
                aVar.beC(a2.fuY);
                aVar.b(bVar2.username, linkedList, true);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29026);
        }
    };
    private View.OnClickListener FKy = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(29028);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                Log.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                com.tencent.mm.pluginsdk.ui.preference.b bVar2 = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                final bn bkv = d.bgM().bkv(bVar2.username);
                if (bkv == null || bkv.field_msgContent == null) {
                    Log.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar2.username);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29028);
                    return;
                }
                ca.d bkD = ca.d.bkD(bkv.field_msgContent);
                Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar2.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (bkD.Ora == 1) {
                    com.tencent.mm.ui.base.h.a(b.this.context, bkD.Orb, (String) null, b.this.context.getString(R.string.ddn), b.this.context.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29027);
                            a.b(b.this.context, bkv);
                            AppMethodBeat.o(29027);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29028);
                    return;
                }
                bg.aVF();
                cn aEZ = c.aSO().aEZ(bVar2.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bVar2.username);
                intent.putExtra("Contact_Nick", bVar2.nickname);
                if (aEZ != null) {
                    intent.putExtra("Contact_RemarkName", aEZ.field_conRemark);
                }
                if (!Util.isNullOrNil(bkD.chatroomName)) {
                    bg.aVF();
                    ah Kd = c.aSX().Kd(bkD.chatroomName);
                    if (Kd != null) {
                        intent.putExtra("Contact_RoomNickname", Kd.getDisplayName(bkD.dkU));
                        intent.putExtra("room_name", bkD.chatroomName);
                    }
                }
                intent.putExtra("Contact_Scene", bkD.scene);
                intent.putExtra("Verify_ticket", bkD.wZz);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                String str = ".ui.SayHiWithSnsPermissionUI";
                if (!as.bjp(bVar2.username) && a2 == 1) {
                    str = ".ui.SayHiWithSnsPermissionUI2";
                } else if (!as.bjp(bVar2.username) && a2 == 2 && ab.aVc() >= a3) {
                    str = ".ui.SayHiWithSnsPermissionUI3";
                }
                if ((as.bjp(bVar2.username) || as.bjq(bVar2.username)) && !WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(b.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29028);
                    return;
                }
                com.tencent.mm.br.c.b(b.this.context, Scopes.PROFILE, str, intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
        }
    };
    private Context context;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ bl a(bl blVar, Cursor cursor) {
        AppMethodBeat.i(29034);
        bl blVar2 = blVar;
        if (blVar2 == null) {
            blVar2 = new bl();
        }
        blVar2.convertFrom(cursor);
        AppMethodBeat.o(29034);
        return blVar2;
    }

    static /* synthetic */ void a(b bVar, Cursor cursor) {
        AppMethodBeat.i(29035);
        bVar.setCursor(cursor);
        AppMethodBeat.o(29035);
    }

    public b(Context context2) {
        super(context2, new bl());
        AppMethodBeat.i(29030);
        this.context = context2;
        AppMethodBeat.o(29030);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x022f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r18, android.view.View r19, android.view.ViewGroup r20) {
        /*
        // Method dump skipped, instructions count: 1072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.ui.friend.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(29032);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(d.bgN().getAll());
            notifyDataSetChanged();
            AppMethodBeat.o(29032);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(29024);
                b.a(b.this, d.bgN().getAll());
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(29024);
            }
        });
        AppMethodBeat.o(29032);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(29033);
        ebf();
        anp();
        AppMethodBeat.o(29033);
    }

    static class a {
        public MaskLayout FKF;
        public Button FKG;
        public TextView FKH;
        public TextView FKI;
        public TextView FKJ;
        public TextView FKK;
        public TextView jUO;
        public TextView kib;
        public Button kid;

        a() {
        }
    }

    static /* synthetic */ void a(b bVar, final String str) {
        AppMethodBeat.i(29036);
        if (bVar.context instanceof FMessageConversationUI) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.subapp.ui.friend.b.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(29029);
                    a.i(b.this.context, str, false);
                    AppMethodBeat.o(29029);
                }
            }, 200);
        }
        AppMethodBeat.o(29036);
    }
}
