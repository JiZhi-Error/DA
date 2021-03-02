package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class c extends b {
    private String kcL;
    private b.a kcM;
    private b.AbstractC0520b kcN = new b.AbstractC0520b() {
        /* class com.tencent.mm.plugin.account.bind.ui.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.account.bind.ui.b.AbstractC0520b
        public final void e(int i2, String str, int i3) {
            AppMethodBeat.i(110123);
            Log.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
            final com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) c.this.getItem(i2);
            if (aVar == null) {
                Log.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.o(110123);
                return;
            }
            Log.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", aVar.toString());
            if (aVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(c.this.context, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.account.bind.ui.c.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(110120);
                        Log.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.plugin.account.friend.a.a SU = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(str2);
                        if (SU == null) {
                            Log.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                        } else if (z) {
                            SU.username = str;
                            SU.status = 2;
                            SU.iKU = 2;
                            Log.d("MicroMsg.MobileFriendAdapter", "f :%s", SU.toString());
                            ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(str2, SU);
                            c.this.anp();
                            cf.aWl().f(26, new Object[0]);
                            AppMethodBeat.o(110120);
                            return;
                        }
                        AppMethodBeat.o(110120);
                    }
                });
                aVar2.Kea = new a.b() {
                    /* class com.tencent.mm.plugin.account.bind.ui.c.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                    public final boolean aE(String str, int i2) {
                        AppMethodBeat.i(110121);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", aVar.getUsername());
                        intent.putExtra("Contact_Nick", aVar.getNickName());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(e.d.OyT, str);
                        intent.putExtra("sayhi_verify_add_errcode", i2);
                        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                        int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                        String str2 = ".ui.SayHiWithSnsPermissionUI";
                        if (!as.bjp(aVar.getUsername()) && a2 == 1) {
                            str2 = ".ui.SayHiWithSnsPermissionUI2";
                        } else if (!as.bjp(aVar.getUsername()) && a2 == 2 && ab.aVc() >= a3) {
                            str2 = ".ui.SayHiWithSnsPermissionUI3";
                        }
                        com.tencent.mm.br.c.b(c.this.context, Scopes.PROFILE, str2, intent, 1);
                        AppMethodBeat.o(110121);
                        return true;
                    }
                };
                if (c.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) c.this.context).mmSetOnActivityResultCallback(new MMActivity.a() {
                        /* class com.tencent.mm.plugin.account.bind.ui.c.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.MMActivity.a
                        public final void d(int i2, int i3, Intent intent) {
                            AppMethodBeat.i(110122);
                            if (i2 == 1 && i3 == -1) {
                                ((MobileFriendUI) c.this.context).b(aVar);
                            }
                            AppMethodBeat.o(110122);
                        }
                    });
                }
                aVar2.khI = aVar.getMd5();
                aVar2.Kee = false;
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(13);
                aVar2.b(aVar.getUsername(), linkedList, false);
            }
            AppMethodBeat.o(110123);
        }
    };
    private int[] pt;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.plugin.account.friend.a.a a(com.tencent.mm.plugin.account.friend.a.a aVar, Cursor cursor) {
        AppMethodBeat.i(110131);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = aVar;
        if (aVar2 == null) {
            aVar2 = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar2.convertFrom(cursor);
        AppMethodBeat.o(110131);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.b
    public final void a(b.a aVar) {
        this.kcM = aVar;
    }

    public c(Context context, s.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        AppMethodBeat.i(110126);
        super.a(aVar);
        this.context = context;
        AppMethodBeat.o(110126);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(110128);
        anp();
        AppMethodBeat.o(110128);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(110129);
        ebf();
        setCursor(((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SS(this.kcL));
        this.pt = new int[getCount()];
        if (!(this.kcM == null || this.kcL == null)) {
            this.kcM.ve(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(110129);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(110130);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i2);
        if (view == null) {
            view = View.inflate(this.context, R.layout.baw, null);
            aVar = new a(view);
            aVar.kcS = (TextView) view.findViewById(R.id.fgv);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kcR = i2;
        aVar.md5 = aVar2.getMd5();
        aVar.status = aVar2.status;
        aVar.kcS.setText(aVar2.bnK());
        switch (aVar2.status) {
            case 0:
                if (aVar2.iKU != 2) {
                    aVar.kcT.setClickable(true);
                    aVar.kcT.setBackgroundResource(R.drawable.k7);
                    aVar.gCd.setText(R.string.diz);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.afz));
                    break;
                } else {
                    aVar.kcT.setClickable(false);
                    aVar.kcT.setBackgroundDrawable(null);
                    aVar.gCd.setText(R.string.dj0);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.wx));
                    break;
                }
            case 1:
            case 2:
                Log.d("MicroMsg.MobileFriendAdapter", "username:%s", aVar2.getUsername());
                if (!((l) g.af(l.class)).aSN().bjG(aVar2.getUsername()) && !z.aTY().equals(aVar2.getUsername())) {
                    if (aVar2.iKU != 2) {
                        aVar.kcT.setClickable(true);
                        aVar.kcT.setBackgroundResource(R.drawable.k7);
                        aVar.gCd.setText(R.string.dix);
                        aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.afz));
                        break;
                    } else {
                        aVar.kcT.setClickable(false);
                        aVar.kcT.setBackgroundDrawable(null);
                        aVar.gCd.setText(R.string.dj3);
                        aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.wx));
                        break;
                    }
                } else {
                    aVar.kcT.setClickable(false);
                    aVar.kcT.setBackgroundDrawable(null);
                    aVar.gCd.setText(R.string.diy);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.wx));
                    break;
                }
                break;
        }
        switch (aVar2.iKU) {
            case 0:
            case 2:
                aVar.gCd.setVisibility(0);
                aVar.hRO.setVisibility(4);
                break;
            case 1:
                aVar.gCd.setVisibility(4);
                aVar.hRO.setVisibility(0);
                break;
        }
        AppMethodBeat.o(110130);
        return view;
    }

    class a {
        TextView gCd;
        ProgressBar hRO;
        int kcR;
        TextView kcS;
        View kcT;
        String md5;
        int status;

        public a(View view) {
            AppMethodBeat.i(110125);
            this.kcS = (TextView) view.findViewById(R.id.fgv);
            this.kcT = view.findViewById(R.id.fgn);
            this.gCd = (TextView) view.findViewById(R.id.fgy);
            this.hRO = (ProgressBar) view.findViewById(R.id.fgx);
            this.kcT.setOnClickListener(new View.OnClickListener(c.this) {
                /* class com.tencent.mm.plugin.account.bind.ui.c.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110124);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (c.this.kcN != null) {
                        c.this.kcN.e(a.this.kcR, a.this.md5, a.this.status);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110124);
                }
            });
            AppMethodBeat.o(110125);
        }
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.b
    public final void SM(String str) {
        AppMethodBeat.i(110127);
        this.kcL = Util.escapeSqlValue(str.trim());
        ebf();
        anp();
        AppMethodBeat.o(110127);
    }
}
