package com.tencent.mm.plugin.profile.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;

public final class b implements MenuItem.OnMenuItemClickListener, a.AbstractC2017a, o.f, o.g {
    private boolean BcL = this.qdG.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    private boolean isDeleteCancel;
    private int kgm = this.qdG.getIntent().getIntExtra("Contact_Scene", 9);
    public MMActivity qdG;
    public as rjX;

    static /* synthetic */ aq a(b bVar) {
        AppMethodBeat.i(231823);
        aq eDR = bVar.eDR();
        AppMethodBeat.o(231823);
        return eDR;
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(231827);
        bVar.XA(str);
        AppMethodBeat.o(231827);
    }

    public b(MMActivity mMActivity, as asVar) {
        AppMethodBeat.i(26882);
        this.qdG = mMActivity;
        this.rjX = asVar;
        AppMethodBeat.o(26882);
    }

    public final void eeh() {
        AppMethodBeat.i(26883);
        this.qdG.addIconOptionMenu(0, R.raw.icons_outlined_more, this);
        AppMethodBeat.o(26883);
    }

    public final void destroy() {
        AppMethodBeat.i(26884);
        ((a) g.af(a.class)).b(this);
        AppMethodBeat.o(26884);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(26885);
        if (((int) this.rjX.gMZ) <= 0) {
            bg.aVF();
            c.aSN().d(this.rjX, true);
        }
        Intent intent = new Intent(this.qdG.getIntent());
        intent.putExtra("Contact_User", this.rjX.field_username);
        intent.setClass(this.qdG, ProfileSettingUI.class);
        intent.setFlags(32768);
        this.qdG.startActivityForResult(intent, 32767);
        h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 7, 1, this.rjX.field_username);
        AppMethodBeat.o(26885);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        if ("3552365301".equals(r8.rjX.field_openImAppid) != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00db, code lost:
        if (com.tencent.mm.contact.c.oR(r8.rjX.field_type) != false) goto L_0x00dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a0  */
    @Override // com.tencent.mm.ui.base.o.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m r9) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.a.b.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(26887);
        Lc(menuItem.getItemId());
        AppMethodBeat.o(26887);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void Lc(int i2) {
        AppMethodBeat.i(231817);
        switch (i2) {
            case 1:
                eDV();
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 8, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 2:
                if (this.rjX.arA()) {
                    ab.y(this.rjX);
                    com.tencent.mm.ui.base.h.cD(this.qdG, this.qdG.getString(R.string.bhf));
                } else {
                    ab.x(this.rjX);
                    com.tencent.mm.ui.base.h.cD(this.qdG, this.qdG.getString(R.string.bb0));
                }
                bg.aVF();
                this.rjX = c.aSN().Kn(this.rjX.field_username);
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 10, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 3:
                eDQ();
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 11, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 4:
                eDU();
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 9, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 5:
                sE(true);
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 14, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 6:
                ((a) g.af(a.class)).a(this);
                eDT();
                AppMethodBeat.o(231817);
                return;
            case 7:
                eDW();
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.qdG.getIntent())), 15, 1, this.rjX.field_username);
                AppMethodBeat.o(231817);
                return;
            case 9:
                eDX();
                break;
        }
        AppMethodBeat.o(231817);
    }

    public final void eDQ() {
        AppMethodBeat.i(26888);
        Intent intent = new Intent(this.qdG, ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 0) == 0 ? PermissionSettingUI.class : PermissionSettingUI2.class);
        intent.putExtra("sns_permission_userName", this.rjX.field_username);
        intent.putExtra("CONTACT_INFO_UI_SOURCE", this.qdG.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
        intent.putExtra("sns_permission_anim", true);
        intent.putExtra("sns_permission_block_scene", 1);
        MMActivity mMActivity = this.qdG;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26888);
    }

    public final void sE(boolean z) {
        AppMethodBeat.i(26889);
        if (this.rjX.ary()) {
            eDS();
            AppMethodBeat.o(26889);
            return;
        }
        View inflate = View.inflate(this.qdG, R.layout.b7f, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.ffg);
        textView.setPadding(0, 0, 0, 0);
        textView.setText(as.bjp(this.rjX.field_username) ? R.string.bd8 : R.string.bd7);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
        checkBox.setChecked(false);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fff);
        textView2.setText(R.string.bd9);
        if (this.rjX.getSource() == 18) {
            checkBox.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView2.setVisibility(8);
        }
        if (z) {
            com.tencent.mm.ui.base.h.a((Context) this.qdG, false, this.qdG.getString(R.string.bd6), inflate, this.qdG.getString(R.string.x_), this.qdG.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26873);
                    aq a2 = b.a(b.this);
                    if (a2 == null) {
                        Log.e("MicroMsg.ProfileMenuManager", "dealSetBlack iContactCallbackFactory is null????");
                        AppMethodBeat.o(26873);
                        return;
                    }
                    a2.a(new com.tencent.mm.contact.a.b() {
                        /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, com.tencent.mm.model.t] */
                        @Override // com.tencent.mm.model.t
                        public final /* bridge */ /* synthetic */ void a(int i2, String str, com.tencent.mm.contact.a.b bVar) {
                            AppMethodBeat.i(231805);
                            b.a(b.this, checkBox);
                            AppMethodBeat.o(231805);
                        }
                    });
                    AppMethodBeat.o(26873);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26874);
                    b.b(b.this);
                    AppMethodBeat.o(26874);
                }
            });
            AppMethodBeat.o(26889);
            return;
        }
        eDR();
        AppMethodBeat.o(26889);
    }

    private aq eDR() {
        AppMethodBeat.i(231818);
        aq h2 = com.tencent.mm.contact.a.a.h(this.rjX);
        if (h2 != null) {
            h2.b(new com.tencent.mm.contact.a.b() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, com.tencent.mm.model.t] */
                @Override // com.tencent.mm.model.t
                public final /* synthetic */ void a(int i2, String str, com.tencent.mm.contact.a.b bVar) {
                    AppMethodBeat.i(231810);
                    com.tencent.mm.contact.a.b bVar2 = bVar;
                    Object[] objArr = new Object[4];
                    objArr[0] = 0;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Util.nullAs(str, "");
                    objArr[3] = bVar2 != null ? Integer.valueOf(bVar2.ret) : BuildConfig.COMMAND;
                    Log.i("MicroMsg.ProfileMenuManager", "moveInBlackList errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                    if (this.ret == 0) {
                        b.this.rjX.aqS();
                        com.tencent.mm.contact.a.a.l(b.this.rjX);
                        u.makeText(b.this.qdG, (int) R.string.fpl, 1).show();
                        AppMethodBeat.o(231810);
                        return;
                    }
                    b.this.rjX.aqT();
                    com.tencent.mm.contact.a.a.m(b.this.rjX);
                    String str2 = "";
                    if (!Util.isNullOrNil(this.title)) {
                        str2 = this.title;
                    }
                    if (!Util.isNullOrNil(this.content)) {
                        str = this.content;
                    } else if (Util.isNullOrNil(str)) {
                        str = b.this.qdG.getString(R.string.fpk);
                    }
                    com.tencent.mm.ui.base.h.a(b.this.qdG, str, str2, b.this.qdG.getString(R.string.j34), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(231809);
                            Log.i("Micromsg.ContactOpLogResult", "moveInBlackList click i know");
                            AppMethodBeat.o(231809);
                        }
                    });
                    b.b(b.this);
                    AppMethodBeat.o(231810);
                }
            }).i(this.qdG, this.qdG.getString(R.string.zb), this.qdG.getString(R.string.a06));
        }
        AppMethodBeat.o(231818);
        return h2;
    }

    private void eDS() {
        AppMethodBeat.i(26891);
        aq i2 = com.tencent.mm.contact.a.a.i(this.rjX);
        if (i2 != null) {
            i2.b(new com.tencent.mm.contact.a.b() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, com.tencent.mm.model.t] */
                @Override // com.tencent.mm.model.t
                public final /* synthetic */ void a(int i2, String str, com.tencent.mm.contact.a.b bVar) {
                    AppMethodBeat.i(231812);
                    com.tencent.mm.contact.a.b bVar2 = bVar;
                    Object[] objArr = new Object[4];
                    objArr[0] = 0;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Util.nullAs(str, "");
                    objArr[3] = bVar2 != null ? Integer.valueOf(bVar2.ret) : BuildConfig.COMMAND;
                    Log.i("MicroMsg.ProfileMenuManager", "moveInBlackList errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                    if (this.ret == 0) {
                        b.this.rjX.aqT();
                        com.tencent.mm.contact.a.a.m(b.this.rjX);
                        u.makeText(b.this.qdG, (int) R.string.fpn, 1).show();
                        AppMethodBeat.o(231812);
                        return;
                    }
                    b.this.rjX.aqS();
                    com.tencent.mm.contact.a.a.l(b.this.rjX);
                    String str2 = "";
                    if (!Util.isNullOrNil(this.title)) {
                        str2 = this.title;
                    }
                    if (!Util.isNullOrNil(this.content)) {
                        str = this.content;
                    } else if (Util.isNullOrNil(str)) {
                        str = b.this.qdG.getString(R.string.fpm);
                    }
                    com.tencent.mm.ui.base.h.a(b.this.qdG, str, str2, b.this.qdG.getString(R.string.j34), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass6.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(231811);
                            Log.i("Micromsg.ContactOpLogResult", "moveOutBlackList click i know");
                            AppMethodBeat.o(231811);
                        }
                    });
                    b.b(b.this);
                    AppMethodBeat.o(231812);
                }
            }).i(this.qdG, this.qdG.getString(R.string.zb), this.qdG.getString(R.string.a06));
        }
        AppMethodBeat.o(26891);
    }

    public final void eDT() {
        String string;
        AppMethodBeat.i(26892);
        View inflate = View.inflate(this.qdG, R.layout.b7f, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.ffg);
        textView.setPadding(0, 0, 0, 0);
        if (ab.IQ(this.rjX.field_username)) {
            string = this.qdG.getString(R.string.bl4, new Object[]{this.rjX.arJ()});
        } else {
            string = this.qdG.getString(R.string.bl2, new Object[]{this.rjX.arJ()});
        }
        textView.setText(string);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
        checkBox.setChecked(false);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fff);
        textView2.setText(R.string.bd9);
        if (this.rjX.getSource() == 18) {
            checkBox.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView2.setVisibility(8);
        }
        com.tencent.mm.ui.base.h.a((Context) this.qdG, true, this.qdG.getString(R.string.bad), inflate, this.qdG.getString(R.string.tf), this.qdG.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(26877);
                b.e(b.this);
                if (b.this.rjX.getSource() == 18) {
                    b.this.kgm = 9;
                    if (checkBox.isChecked()) {
                        b.this.eDX();
                    }
                }
                AppMethodBeat.o(26877);
            }
        }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        AppMethodBeat.o(26892);
    }

    @Override // com.tencent.mm.pluginsdk.h.a.AbstractC2017a
    public final void a(String str, int i2, cxl cxl) {
        AppMethodBeat.i(26893);
        if (i2 == 0) {
            if (!str.equals(this.rjX.field_username)) {
                Log.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", this.rjX.field_username, str);
                AppMethodBeat.o(26893);
                return;
            }
            switch (this.kgm) {
                case 10:
                    t.R(this.qdG, str);
                    break;
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str);
                    if (SR != null && !Util.isNullOrNil(SR.kdX)) {
                        SR.status = 1;
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SR.getMd5(), SR);
                    }
                    t.R(this.qdG, str);
                    break;
            }
            if (this.kgm == 9) {
                Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.rjX.getSource());
                switch (this.rjX.getSource()) {
                    case 10:
                    case 13:
                        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
                        t.R(this.qdG, str);
                        break;
                }
            }
            if (this.qdG.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.b.jRt.o(intent, this.qdG);
                AppMethodBeat.o(26893);
                return;
            }
            this.qdG.setResult(-1, this.qdG.getIntent().putExtra("_delete_ok_", true));
            this.qdG.finish();
            AppMethodBeat.o(26893);
        } else if (!Util.isNullOrNil(cxl.iAc)) {
            com.tencent.mm.ui.base.h.c(this.qdG, cxl.iAc, cxl.Title, true);
            AppMethodBeat.o(26893);
        } else {
            com.tencent.mm.ui.base.h.c(this.qdG, this.qdG.getString(R.string.tg), "", true);
            AppMethodBeat.o(26893);
        }
    }

    private void XA(String str) {
        AppMethodBeat.i(26894);
        this.rjX.aqR();
        if (as.bjp(str)) {
            this.rjX.setSource(0);
            ((r) g.af(r.class)).EG(str);
            bp.a(str, new bp.a() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass11 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(231816);
                    boolean z = b.this.isDeleteCancel;
                    AppMethodBeat.o(231816);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                }
            });
            bg.aVF();
            c.aSN().c(str, this.rjX);
            bg.aVF();
            c.aST().bjW(str);
            com.tencent.mm.bj.c.f(0, str);
            com.tencent.mm.bj.c.f(0, this.rjX.field_encryptUsername);
            switch (this.kgm) {
                case 10:
                    t.R(this.qdG, str);
                    break;
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str);
                    if (SR != null && !Util.isNullOrNil(SR.kdX)) {
                        SR.status = 1;
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SR.getMd5(), SR);
                    }
                    t.R(this.qdG, str);
                    break;
            }
            if (this.kgm == 9) {
                Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.rjX.getSource());
                switch (this.rjX.getSource()) {
                    case 10:
                    case 13:
                        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
                        t.R(this.qdG, str);
                        break;
                }
            }
            if (this.qdG.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.b.jRt.o(intent, this.qdG);
                AppMethodBeat.o(26894);
                return;
            }
            this.qdG.setResult(-1, this.qdG.getIntent().putExtra("_delete_ok_", true));
            this.qdG.finish();
            AppMethodBeat.o(26894);
            return;
        }
        ((a) g.af(a.class)).XA(str);
        AppMethodBeat.o(26894);
    }

    public final void eDU() {
        AppMethodBeat.i(26895);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", this.rjX.field_username);
        intent.putExtra("Select_block_List", this.rjX.field_username);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.jRt.a(intent, new MMActivity.a() {
            /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass2 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(231806);
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.eir().s(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.r(b.this.qdG, b.this.qdG.getString(R.string.dc_));
                }
                AppMethodBeat.o(231806);
            }
        }, this.qdG);
        AppMethodBeat.o(26895);
    }

    private void eDV() {
        AppMethodBeat.i(231819);
        if (!com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
            aKk(this.rjX.field_username);
            AppMethodBeat.o(231819);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.kgm);
        intent.putExtra("Contact_User", this.rjX.field_username);
        intent.putExtra("Contact_RoomNickname", this.qdG.getIntent().getStringExtra("Contact_RoomNickname"));
        intent.putExtra("contact_phone_number_list", this.rjX.fuX);
        String str = "";
        if (!this.rjX.arF()) {
            com.tencent.mm.plugin.account.friend.a.a aVar = null;
            String stringExtra = this.qdG.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.qdG.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                if ((!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) && ((aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra)) == null || Util.isNullOrNil(aVar.getMd5()))) {
                    aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra2);
                }
            } else if (!Util.isNullOrNil(this.rjX.field_username)) {
                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.rjX.field_username);
            }
            if (aVar != null && !Util.isNullOrNil(aVar.getMd5())) {
                str = Util.nullAsNil(aVar.bnP()).replace(" ", "");
            }
        }
        intent.putExtra("contact_phone_number_by_md5", str);
        com.tencent.mm.plugin.profile.b.jRt.l(intent, this.qdG);
        AppMethodBeat.o(231819);
    }

    private void aKk(String str) {
        AppMethodBeat.i(231820);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
            AppMethodBeat.o(231820);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.kgm);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.rjX.field_username);
        intent.putExtra("Contact_Nick", this.rjX.field_nickname);
        intent.putExtra("Contact_RemarkName", this.rjX.field_conRemark);
        com.tencent.mm.plugin.profile.b.jRt.m(intent, this.qdG);
        AppMethodBeat.o(231820);
    }

    private void eDW() {
        AppMethodBeat.i(231821);
        Log.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.rjX.field_username);
        com.tencent.mm.plugin.base.model.c.a(this.qdG, new c.b() {
            /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.base.model.c.b
            public final void cjO() {
                AppMethodBeat.i(231807);
                com.tencent.mm.plugin.base.model.b.ai(b.this.qdG, b.this.rjX.field_username);
                AppMethodBeat.o(231807);
            }

            @Override // com.tencent.mm.plugin.base.model.c.b
            public final void cjP() {
                AppMethodBeat.i(231808);
                com.tencent.mm.plugin.base.model.b.ah(b.this.qdG, b.this.rjX.field_username);
                AppMethodBeat.o(231808);
            }
        });
        AppMethodBeat.o(231821);
    }

    public final void eDX() {
        String str;
        int i2 = 7;
        AppMethodBeat.i(231822);
        Intent intent = new Intent();
        switch (this.kgm) {
            case 1:
            case 2:
            case 3:
            case 12:
            case 13:
            case 58:
            case bv.CTRL_INDEX:
            case 60:
                intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(45, this.rjX.field_username));
                i2 = 45;
                break;
            case 9:
            case 14:
                i2 = 35;
                break;
            case 18:
                if (this.BcL) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qb(this.rjX.field_username));
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                i2 = this.BcL ? 4 : 3;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qc(this.rjX.field_username));
                break;
            case 25:
                i2 = this.BcL ? 6 : 5;
                if (!this.BcL) {
                    if (!Util.isNullOrNil(this.rjX.Ooy)) {
                        str = this.rjX.Ooy;
                    } else {
                        str = this.rjX.field_username;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qd(str));
                    break;
                } else {
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(i2, this.rjX.field_username));
                    break;
                }
            case 30:
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(7, this.rjX.field_username));
                break;
            default:
                i2 = 35;
                break;
        }
        intent.putExtra("k_username", this.rjX.field_username);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format(e.C2115e.OyU, Integer.valueOf(i2)));
        com.tencent.mm.br.c.b(this.qdG, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(231822);
    }

    public static void a(Activity activity, as asVar) {
        AppMethodBeat.i(26897);
        Intent intent = new Intent();
        intent.setClass(activity, ContactMoreInfoUI.class);
        intent.putExtra("Is_RoomOwner", activity.getIntent().getBooleanExtra("Is_RoomOwner", false));
        intent.putExtra("Contact_User", asVar.field_username);
        String stringExtra = activity.getIntent().getStringExtra("room_name");
        if (stringExtra == null) {
            stringExtra = activity.getIntent().getStringExtra("Contact_ChatRoomId");
        }
        intent.putExtra("Contact_ChatRoomId", stringExtra);
        String nullAs = Util.nullAs(activity.getIntent().getStringExtra("verify_gmail"), "");
        String nullAs2 = Util.nullAs(activity.getIntent().getStringExtra("profileName"), Util.subStringEmail(nullAs));
        intent.putExtra("verify_gmail", nullAs);
        intent.putExtra("profileName", nullAs2);
        long longExtra = activity.getIntent().getLongExtra("Contact_Uin", 0);
        String stringExtra2 = activity.getIntent().getStringExtra("Contact_QQNick");
        intent.putExtra("Contact_Uin", longExtra);
        intent.putExtra("Contact_QQNick", stringExtra2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26897);
    }

    static /* synthetic */ void a(b bVar, CheckBox checkBox) {
        AppMethodBeat.i(231824);
        if (bVar.rjX.getSource() == 18) {
            bVar.kgm = 9;
            if (checkBox != null && checkBox.isChecked()) {
                bVar.eDX();
            }
        }
        AppMethodBeat.o(231824);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(231825);
        if (bVar.qdG instanceof MStorageEx.IOnStorageChange) {
            ((MStorageEx.IOnStorageChange) bVar.qdG).onNotifyChange(0, null, bVar.rjX.field_username);
        }
        AppMethodBeat.o(231825);
    }

    static /* synthetic */ void e(b bVar) {
        String str;
        AppMethodBeat.i(231826);
        h.INSTANCE.a(14553, 2, 2, bVar.rjX.field_username);
        final String str2 = bVar.rjX.field_username;
        bVar.rjX.BD("");
        if (ab.IQ(str2)) {
            bVar.rjX.aqR();
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.d(str2));
            bg.aVF();
            com.tencent.mm.model.c.aSN().aNa(str2);
            bg.aVF();
            com.tencent.mm.model.c.aSX().Kj(str2);
            AppMethodBeat.o(231826);
            return;
        }
        bVar.isDeleteCancel = false;
        MMActivity mMActivity = bVar.qdG;
        bVar.qdG.getString(R.string.zb);
        final q a2 = com.tencent.mm.ui.base.h.a((Context) mMActivity, bVar.qdG.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(231813);
                b.this.isDeleteCancel = true;
                AppMethodBeat.o(231813);
            }
        });
        if (!bVar.isDeleteCancel) {
            str = com.tencent.mm.pluginsdk.wallet.d.bfO(bVar.rjX.field_username);
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            a2.dismiss();
            com.tencent.mm.ui.base.h.a(bVar.qdG, false, bVar.qdG.getString(R.string.ibz, new Object[]{str}), null, bVar.qdG.getString(R.string.dvh), bVar.qdG.getString(R.string.blh), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(231814);
                    h.INSTANCE.a(14553, 2, 4, b.this.rjX.field_username);
                    b.this.isDeleteCancel = true;
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", b.this.rjX.field_username);
                    intent.addFlags(67108864);
                    com.tencent.mm.br.c.f(b.this.qdG, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(231814);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.b.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(231815);
                    h.INSTANCE.a(14553, 2, 3, b.this.rjX.field_username);
                    a2.show();
                    b.this.isDeleteCancel = false;
                    b.a(b.this, str2);
                    AppMethodBeat.o(231815);
                }
            }, -1, R.color.cd);
            AppMethodBeat.o(231826);
            return;
        }
        bVar.XA(str2);
        AppMethodBeat.o(231826);
    }
}
