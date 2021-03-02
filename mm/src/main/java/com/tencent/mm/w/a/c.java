package com.tencent.mm.w.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class c extends b {
    public com.tencent.mm.plugin.account.friend.a.a hhc;
    public boolean hhd;
    private a hhe = new a();

    public class a extends b.AbstractC1382b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(196835);
            c cVar = (c) aVar;
            if (cVar.hhc == null) {
                AppMethodBeat.o(196835);
            } else if (cVar.hhc.status == 1 || cVar.hhc.status == 2) {
                Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                Intent intent = new Intent();
                intent.putExtra("Contact_User", c.this.hhc.getUsername());
                intent.putExtra("Contact_Nick", c.this.hhc.getNickName());
                intent.putExtra("Contact_Mobile_MD5", c.this.hhc.getMd5());
                intent.putExtra("Contact_Alias", c.this.hhc.ked);
                intent.putExtra("Contact_Sex", c.this.hhc.kdY);
                intent.putExtra("Contact_Signature", c.this.hhc.keb);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(c.this.hhc.keh, c.this.hhc.kdZ, c.this.hhc.kea));
                intent.putExtra("Contact_Scene", 13);
                intent.putExtra("Contact_ShowUserName", false);
                if (c.this.hhd) {
                    intent.putExtra("add_more_friend_search_scene", 1);
                }
                com.tencent.mm.plugin.account.a.a.jRt.c(intent, context);
                AppMethodBeat.o(196835);
            } else if (c.this.hhc.status == 0) {
                Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                Intent intent2 = new Intent(context, InviteFriendUI.class);
                intent2.putExtra("friend_type", 1);
                intent2.putExtra("friend_user_name", c.this.hhc.getUsername());
                intent2.putExtra("friend_num", c.this.hhc.bnP());
                intent2.putExtra("friend_nick", c.this.hhc.bnK());
                intent2.putExtra("friend_weixin_nick", c.this.hhc.getNickName());
                intent2.putExtra("friend_scene", 13);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/fts/ui/FTSMobileContactDataItem$FTSMobileContactViewItem", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(196835);
            } else {
                Log.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                AppMethodBeat.o(196835);
            }
            return true;
        }
    }

    public c(int i2) {
        super(i2);
        AppMethodBeat.i(127653);
        AppMethodBeat.o(127653);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2;
        String nickName;
        boolean z3;
        boolean z4;
        String string;
        AppMethodBeat.i(127654);
        this.username = this.lqW.wVX;
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.username);
        int i2 = (int) this.lqW.wXe;
        com.tencent.mm.plugin.account.friend.a.a aVar2 = new com.tencent.mm.plugin.account.friend.a.a();
        Cursor rawQuery = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + i2 + ';', null, 2);
        if (rawQuery.moveToFirst()) {
            aVar2.convertFrom(rawQuery);
        }
        rawQuery.close();
        this.hhc = aVar2;
        String bnK = this.hhc.bnK();
        switch (this.lqW.wVW) {
            case 5:
                z = false;
                z2 = false;
                nickName = this.hhc.getNickName();
                z3 = true;
                z4 = false;
                string = context.getString(R.string.gg_);
                break;
            case 6:
                z = false;
                z2 = true;
                nickName = this.hhc.getNickName();
                z3 = true;
                z4 = false;
                string = context.getString(R.string.gg_);
                break;
            case 7:
                z = true;
                z2 = true;
                nickName = this.hhc.getNickName();
                z3 = true;
                z4 = false;
                string = context.getString(R.string.gg_);
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 15:
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                nickName = null;
                string = null;
                break;
            case 12:
                z = false;
                z2 = false;
                nickName = this.hhc.bnP();
                z3 = false;
                z4 = true;
                string = context.getString(R.string.gg3);
                break;
            case 13:
                z = false;
                z2 = true;
                nickName = this.hhc.bnP();
                z3 = false;
                z4 = true;
                string = context.getString(R.string.gg3);
                break;
            case 14:
                z = true;
                z2 = true;
                nickName = this.hhc.bnP();
                z3 = false;
                z4 = true;
                string = context.getString(R.string.gg3);
                break;
            case 16:
                nickName = this.hhc.bnP();
                z = false;
                z2 = false;
                z3 = true;
                z4 = false;
                string = context.getString(R.string.gg3);
                break;
        }
        if (z4) {
            this.pqB = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) bnK, com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.pqB = f.a(e.a(this.pqB, this.wWd, z2, z)).wWu;
        } else {
            this.pqB = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) bnK, com.tencent.mm.cb.a.aG(context, R.dimen.is));
        }
        if (z3) {
            this.pqC = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) nickName, com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.pqC = f.a(e.a(this.pqC, this.wWd, z2, z)).wWu;
            this.pqC = TextUtils.concat(string, this.pqC);
        }
        AppMethodBeat.o(127654);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.hhe;
    }
}
