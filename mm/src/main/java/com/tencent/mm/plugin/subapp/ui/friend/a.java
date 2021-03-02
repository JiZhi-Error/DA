package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class a implements AdapterView.OnItemClickListener {
    private b FKw;
    private Context context;
    private boolean iLQ = false;

    public a(Context context2, b bVar, boolean z) {
        this.context = context2;
        this.FKw = bVar;
        this.iLQ = z;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(29018);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (this.iLQ) {
            i2 -= 2;
        }
        bl blVar = (bl) this.FKw.getItem(i2);
        if (blVar == null) {
            Log.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i2)));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29018);
            return;
        }
        a(this.context, blVar, blVar.field_talker, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29018);
    }

    public static void i(Context context2, String str, boolean z) {
        AppMethodBeat.i(29019);
        a(context2, (bl) null, str, z);
        AppMethodBeat.o(29019);
    }

    private static void a(Context context2, bl blVar, String str, boolean z) {
        AppMethodBeat.i(29020);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            AppMethodBeat.o(29020);
            return;
        }
        Log.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(str)));
        d.bgN().bks(str);
        bn bkv = d.bgM().bkv(str);
        if (bkv == null) {
            Log.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(29020);
        } else if (bkv.field_type == 0) {
            a(context2, bkv);
            AppMethodBeat.o(29020);
        } else {
            a(context2, blVar, bkv, z);
            AppMethodBeat.o(29020);
        }
    }

    private static void a(Context context2, bn bnVar) {
        AppMethodBeat.i(29021);
        bg.aVF();
        ca.a aEK = c.aSQ().aEK(bnVar.field_msgContent);
        if (aEK == null) {
            AppMethodBeat.o(29021);
        } else if (aEK.dkU.length() <= 0) {
            AppMethodBeat.o(29021);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("Contact_ShowFMessageList", true);
            bundle.putInt("Contact_Source_FMessage", aEK.scene);
            bg.aVF();
            as Kn = c.aSN().Kn(aEK.dkU);
            if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                com.tencent.mm.plugin.subapp.b.jRu.a(context2, Kn, aEK, bundle, "");
                AppMethodBeat.o(29021);
            } else if (aEK.Bge > 0) {
                if (Util.isNullOrNil(aEK.kfV) && Util.isNullOrNil(aEK.kfS) && !Util.isNullOrNil(aEK.nickname)) {
                    bundle.putString("Contact_QQNick", aEK.nickname);
                }
                com.tencent.mm.plugin.subapp.b.jRu.a(context2, aEK, bundle);
                AppMethodBeat.o(29021);
            } else if (!Util.isNullOrNil(aEK.OqK) || !Util.isNullOrNil(aEK.OqL)) {
                com.tencent.mm.plugin.account.friend.a.a SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(aEK.OqK);
                if ((SU == null || SU.getMd5() == null || SU.getMd5().length() <= 0) && ((SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(aEK.OqL)) == null || SU.getMd5() == null || SU.getMd5().length() <= 0)) {
                    if (Kn == null || ((int) Kn.gMZ) <= 0) {
                        com.tencent.mm.plugin.subapp.b.jRu.a(context2, aEK, bundle);
                    } else {
                        com.tencent.mm.plugin.subapp.b.jRu.a(context2, Kn, aEK, bundle, "");
                    }
                    Log.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + aEK.OqK + " fullMD5:" + aEK.OqL);
                    AppMethodBeat.o(29021);
                    return;
                }
                if (SU.getUsername() == null || SU.getUsername().length() <= 0) {
                    SU.username = aEK.dkU;
                    SU.cSx = 128;
                    if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SU.getMd5(), SU) == -1) {
                        Log.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                        AppMethodBeat.o(29021);
                        return;
                    }
                }
                com.tencent.mm.plugin.subapp.b.jRu.a(context2, aEK, bundle);
                AppMethodBeat.o(29021);
            } else {
                com.tencent.mm.plugin.subapp.b.jRu.a(context2, aEK, bundle);
                AppMethodBeat.o(29021);
            }
        }
    }

    public static void b(Context context2, bn bnVar) {
        AppMethodBeat.i(29022);
        a(context2, (bl) null, bnVar, false);
        AppMethodBeat.o(29022);
    }

    private static void a(Context context2, bl blVar, bn bnVar, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(29023);
        String str = bnVar.field_msgContent;
        Log.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(29023);
            return;
        }
        bg.aVF();
        ca.d aEJ = c.aSQ().aEJ(str);
        if (aEJ != null && !Util.isNullOrNil(aEJ.dkU)) {
            Assert.assertTrue(aEJ.dkU.length() > 0);
            bg.aVF();
            as Kn = c.aSN().Kn(aEJ.dkU);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("Accept_NewFriend_FromOutside", true);
            }
            intent.putExtra("Contact_ShowUserName", false);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Scene", aEJ.scene);
            intent.putExtra("Verify_ticket", aEJ.wZz);
            intent.putExtra("Contact_Source_FMessage", aEJ.scene);
            if (Kn == null || ((int) Kn.gMZ) <= 0 || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                if (bnVar.field_type == 1 || bnVar.field_type == 2) {
                    intent.putExtra("User_Verify", true);
                }
                intent.putExtra("Contact_User", aEJ.dkU);
                intent.putExtra("Contact_Alias", aEJ.fMb);
                intent.putExtra("Contact_Nick", aEJ.nickname);
                intent.putExtra("Contact_QuanPin", aEJ.kfR);
                intent.putExtra("Contact_PyInitial", aEJ.kfQ);
                intent.putExtra("Contact_Sex", aEJ.fuA);
                intent.putExtra("Contact_Signature", aEJ.signature);
                intent.putExtra("Contact_FMessageCard", true);
                intent.putExtra("Contact_City", aEJ.getCity());
                intent.putExtra("Contact_Province", aEJ.getProvince());
                intent.putExtra("Contact_Mobile_MD5", aEJ.OqK);
                intent.putExtra("Contact_full_Mobile_MD5", aEJ.OqL);
                intent.putExtra("Contact_KSnsBgUrl", aEJ.OqY);
            } else {
                intent.putExtra("Contact_User", Kn.field_username);
                com.tencent.mm.plugin.subapp.b.jRu.a(intent, Kn.field_username);
            }
            String str2 = aEJ.content;
            if (Util.nullAsNil(str2).length() <= 0) {
                switch (aEJ.scene) {
                    case 18:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        str2 = context2.getString(R.string.ays);
                        break;
                    case 19:
                    case 20:
                    case 21:
                    default:
                        str2 = context2.getString(R.string.ayo);
                        break;
                }
            }
            intent.putExtra("Contact_Content", str2);
            if (aEJ.Ora == 1 && !Util.isNullOrNil(aEJ.Orc)) {
                intent.putExtra("Safety_Warning_Detail", aEJ.Orc);
            }
            intent.putExtra("Contact_verify_Scene", aEJ.scene);
            if ((aEJ.scene == 14 || aEJ.scene == 8) && !Util.isNullOrNil(aEJ.chatroomName)) {
                bg.aVF();
                ah Kd = c.aSX().Kd(aEJ.chatroomName);
                if (Kd != null) {
                    intent.putExtra("Contact_RoomNickname", Kd.getDisplayName(aEJ.dkU));
                }
            }
            intent.putExtra("Contact_Uin", aEJ.Bge);
            intent.putExtra("Contact_QQNick", aEJ.kfS);
            intent.putExtra("Contact_Mobile_MD5", aEJ.OqK);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            intent.putExtra("Contact_KSnsBgUrl", aEJ.OqY);
            intent.putExtra("verify_gmail", aEJ.kcp);
            intent.putExtra("source_from_user_name", aEJ.sourceUserName);
            intent.putExtra("source_from_nick_name", aEJ.sourceNickName);
            intent.putExtra("share_card_username", aEJ.Ord);
            intent.putExtra("share_card_nickname", aEJ.Ore);
            intent.putExtra("room_name", aEJ.chatroomName);
            if (blVar != null) {
                if (cl.aWz() - blVar.field_lastModifiedTime < 259200000) {
                    z2 = false;
                }
                intent.putExtra("isVerifyExpired", z2);
            }
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
            if (Kn == null || ((!as.bjp(Kn.field_username) && !as.bjq(Kn.field_username)) || WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(context2))) {
                com.tencent.mm.br.c.b(context2, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            } else {
                AppMethodBeat.o(29023);
                return;
            }
        }
        AppMethodBeat.o(29023);
    }
}
