package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class d extends b {
    private String kcL;
    private b.a kcM;
    private b.AbstractC0520b kcN = new b.AbstractC0520b() {
        /* class com.tencent.mm.plugin.account.bind.ui.d.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.account.bind.ui.b.AbstractC0520b
        public final void e(int i2, String str, int i3) {
            AppMethodBeat.i(110135);
            Log.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
            final com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) d.this.getItem(i2);
            if (aVar == null) {
                Log.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.o(110135);
                return;
            }
            Log.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", aVar.toString());
            if (aVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(d.this.context, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.account.bind.ui.d.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(110132);
                        Log.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.plugin.account.friend.a.a SU = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(str2);
                        if (SU == null) {
                            Log.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", str2);
                        } else if (z) {
                            SU.username = str;
                            SU.status = 2;
                            SU.iKU = 2;
                            Log.d("MicroMsg.MobileFriendAdapter", "f :%s", SU.toString());
                            ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(str2, SU);
                            d.this.anp();
                            cf.aWl().f(26, new Object[0]);
                            AppMethodBeat.o(110132);
                            return;
                        }
                        AppMethodBeat.o(110132);
                    }
                });
                aVar2.Kea = new a.b() {
                    /* class com.tencent.mm.plugin.account.bind.ui.d.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                    public final boolean aE(String str, int i2) {
                        AppMethodBeat.i(110133);
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
                        c.b(d.this.context, Scopes.PROFILE, str2, intent, 1);
                        AppMethodBeat.o(110133);
                        return true;
                    }
                };
                if (d.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) d.this.context).mmSetOnActivityResultCallback(new MMActivity.a() {
                        /* class com.tencent.mm.plugin.account.bind.ui.d.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.MMActivity.a
                        public final void d(int i2, int i3, Intent intent) {
                            AppMethodBeat.i(110134);
                            if (i2 == 1 && i3 == -1) {
                                ((MobileFriendUI) d.this.context).b(aVar);
                            }
                            AppMethodBeat.o(110134);
                        }
                    });
                }
                aVar2.khI = aVar.getMd5();
                aVar2.Kee = false;
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(13);
                aVar2.b(aVar.getUsername(), linkedList, false);
            }
            AppMethodBeat.o(110135);
        }
    };
    private int[] pt;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.plugin.account.friend.a.a a(com.tencent.mm.plugin.account.friend.a.a aVar, Cursor cursor) {
        AppMethodBeat.i(110144);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = aVar;
        if (aVar2 == null) {
            aVar2 = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar2.convertFrom(cursor);
        AppMethodBeat.o(110144);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.b
    public final void a(b.a aVar) {
        this.kcM = aVar;
    }

    public d(Context context, s.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        AppMethodBeat.i(110138);
        super.a(aVar);
        this.context = context;
        Bh(true);
        AppMethodBeat.o(110138);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(110140);
        anp();
        AppMethodBeat.o(110140);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(110141);
        ebf();
        setCursor(((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ST(this.kcL));
        this.pt = new int[getCount()];
        if (!(this.kcM == null || this.kcL == null)) {
            this.kcM.ve(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(110141);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        int i3;
        boolean z;
        AppMethodBeat.i(110142);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i2);
        if (view == null) {
            view = View.inflate(this.context, R.layout.amt, null);
            a aVar3 = new a(view);
            view.setTag(aVar3);
            aVar = aVar3;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kcR = i2;
        aVar.account = aVar2.getMd5();
        aVar.status = aVar2.status;
        aVar.kcZ.setText(aVar2.bnK());
        aVar.kda.setText(this.context.getString(R.string.dj4) + aVar2.getNickName());
        a.b.c(aVar.gyr, aVar2.getUsername());
        switch (aVar2.status) {
            case 0:
                if (aVar2.iKU != 2) {
                    aVar.kcT.setClickable(true);
                    aVar.kcT.setBackgroundResource(R.drawable.k7);
                    aVar.gCd.setText(R.string.diz);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.ag2));
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
                if (!((l) g.af(l.class)).aSN().bjG(aVar2.getUsername()) && !z.aTY().equals(aVar2.getUsername())) {
                    if (aVar2.iKU != 2) {
                        aVar.kcT.setClickable(true);
                        aVar.kcT.setBackgroundResource(R.drawable.k7);
                        aVar.gCd.setText(R.string.dix);
                        aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.ag2));
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
                aVar.kdb.setVisibility(4);
                break;
            case 1:
                aVar.gCd.setVisibility(4);
                aVar.kdb.setVisibility(0);
                break;
        }
        com.tencent.mm.plugin.account.friend.a.a aVar4 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i2 - 1);
        if (aVar4 == null) {
            i3 = -1;
        } else {
            i3 = aVar4.kdW;
        }
        if (i2 == 0) {
            String a2 = a(aVar2);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", aVar2.getUsername(), Integer.valueOf(i2));
                aVar.kcY.setVisibility(8);
            } else {
                aVar.kcY.setVisibility(0);
                aVar.kcY.setText(a2);
                aVar.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            if (aVar2.kdW != i3) {
                z = true;
            } else {
                z = false;
            }
            String a3 = a(aVar2);
            if (Util.isNullOrNil(a3) || !z) {
                Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", aVar2.getUsername(), Integer.valueOf(i2));
                aVar.kcY.setVisibility(8);
            } else {
                aVar.kcY.setVisibility(0);
                aVar.kcY.setText(a3);
                aVar.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.o(110142);
        return view;
    }

    class a {
        String account;
        TextView gCd;
        ImageView gyr;
        int kcR;
        View kcT;
        TextView kcY;
        TextView kcZ;
        TextView kda;
        ProgressBar kdb;
        int status;

        public a(View view) {
            AppMethodBeat.i(110137);
            this.kcY = (TextView) view.findViewById(R.id.dan);
            this.gyr = (ImageView) view.findViewById(R.id.dam);
            this.kcZ = (TextView) view.findViewById(R.id.dao);
            this.kda = (TextView) view.findViewById(R.id.dar);
            this.kcT = view.findViewById(R.id.dal);
            this.gCd = (TextView) view.findViewById(R.id.daq);
            this.kdb = (ProgressBar) view.findViewById(R.id.dap);
            this.kcT.setOnClickListener(new View.OnClickListener(d.this) {
                /* class com.tencent.mm.plugin.account.bind.ui.d.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110136);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (d.this.kcN != null) {
                        d.this.kcN.e(a.this.kcR, a.this.account, a.this.status);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110136);
                }
            });
            AppMethodBeat.o(110137);
        }
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.b
    public final void SM(String str) {
        AppMethodBeat.i(110139);
        this.kcL = Util.escapeSqlValue(str.trim());
        ebf();
        anp();
        AppMethodBeat.o(110139);
    }

    private static String a(com.tencent.mm.plugin.account.friend.a.a aVar) {
        AppMethodBeat.i(110143);
        if (aVar.kdW == 123) {
            AppMethodBeat.o(110143);
            return "#";
        }
        String valueOf = String.valueOf((char) aVar.kdW);
        AppMethodBeat.o(110143);
        return valueOf;
    }
}
