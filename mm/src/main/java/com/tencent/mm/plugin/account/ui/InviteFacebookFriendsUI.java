package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.e;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;

public class InviteFacebookFriendsUI extends MMActivity implements i {
    private ProgressDialog gtM = null;
    private ListView kde;
    private View kdg;
    String kdi;
    a klh;
    private final int recommendType = 5;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128045);
        super.onCreate(bundle);
        setMMTitle(R.string.c7n);
        g.azz().a(32, this);
        initView();
        AppMethodBeat.o(128045);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128046);
        g.azz().b(32, this);
        this.klh.ebf();
        super.onDestroy();
        AppMethodBeat.o(128046);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128047);
        this.kde = (ListView) findViewById(R.id.fgs);
        final TextView textView = (TextView) findViewById(R.id.c30);
        textView.setText(R.string.c7g);
        s sVar = new s((byte) 0);
        sVar.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(128021);
                InviteFacebookFriendsUI.this.kdi = Util.escapeSqlValue(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = InviteFacebookFriendsUI.this;
                if (inviteFacebookFriendsUI.klh != null) {
                    a aVar = inviteFacebookFriendsUI.klh;
                    aVar.kcL = Util.escapeSqlValue(inviteFacebookFriendsUI.kdi.trim());
                    aVar.ebf();
                    aVar.anp();
                }
                AppMethodBeat.o(128021);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }
        };
        addSearchMenu(true, sVar);
        this.klh = new a(this, new s.a() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(128023);
                if (z.aUF()) {
                    if (InviteFacebookFriendsUI.this.klh.getCount() == 0) {
                        textView.setVisibility(0);
                        AppMethodBeat.o(128023);
                        return;
                    }
                    textView.setVisibility(8);
                }
                AppMethodBeat.o(128023);
            }
        });
        this.kde.setAdapter((ListAdapter) this.klh);
        this.kdg = findViewById(R.id.fgt);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(128024);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (InviteFacebookFriendsUI.this.klh.bpe().length >= 50) {
                    h.n(InviteFacebookFriendsUI.this, R.string.c7m, R.string.zb);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(128024);
                    return;
                }
                InviteFacebookFriendsUI.this.klh.vl(i2 - InviteFacebookFriendsUI.this.kde.getHeaderViewsCount());
                if (InviteFacebookFriendsUI.this.klh.bpe().length > 0) {
                    InviteFacebookFriendsUI.this.showOptionMenu(true);
                } else {
                    InviteFacebookFriendsUI.this.showOptionMenu(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(128024);
            }
        });
        Log.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + z.aUF());
        if (z.aUF()) {
            this.kde.setVisibility(0);
            this.kdg.setVisibility(8);
            long nullAsNil = Util.nullAsNil((Long) g.aAh().azQ().get(65831, (Object) null));
            String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(65830, (Object) null));
            if (Util.milliSecondsToNow(nullAsNil) > Util.MILLSECONDS_OF_DAY && nullAsNil2.length() > 0) {
                c cVar = new c(getString(R.string.c71));
                cVar.bnE(nullAsNil2);
                new k(cVar, new l() {
                    /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                    public final void E(Bundle bundle) {
                        AppMethodBeat.i(128025);
                        super.E(bundle);
                        AppMethodBeat.o(128025);
                    }

                    @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                    public final void onError(int i2, String str) {
                        AppMethodBeat.i(128026);
                        super.onError(i2, str);
                        if (i2 == 3) {
                            InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
                        }
                        AppMethodBeat.o(128026);
                    }
                }).bnw();
            }
            final ad adVar = new ad();
            adVar.bon();
            final MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(128027);
                    g.aAh().azQ().set(65829, (Object) 1);
                    g.azz().a(adVar, 0);
                    AppMethodBeat.o(128027);
                    return false;
                }
            }, false);
            if (Util.nullAsNil((Integer) g.aAh().azQ().get(65829, (Object) null)) > 0) {
                g.aAh().azQ().set(65829, (Object) 1);
                g.azz().a(adVar, 0);
            } else {
                mTimerHandler.startTimer(5000);
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.fr3), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128028);
                    mTimerHandler.stopTimer();
                    g.azz().a(adVar);
                    AppMethodBeat.o(128028);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128029);
                InviteFacebookFriendsUI.this.hideVKB();
                InviteFacebookFriendsUI.this.finish();
                AppMethodBeat.o(128029);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(128030);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(InviteFacebookFriendsUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128030);
            }
        });
        addTextOptionMenu(0, getString(R.string.c7k), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128037);
                c cVar = new c(InviteFacebookFriendsUI.this.getString(R.string.c71));
                Bundle bundle = new Bundle();
                bundle.putString("message", InviteFacebookFriendsUI.this.getString(R.string.c7j));
                final long[] bpe = InviteFacebookFriendsUI.this.klh.bpe();
                String l = Long.toString(bpe[0]);
                for (int i2 = 1; i2 < bpe.length; i2++) {
                    l = (l + ",") + Long.toString(bpe[i2]);
                }
                bundle.putString("to", l);
                cVar.a(InviteFacebookFriendsUI.this, "apprequests", bundle, new c.a() {
                    /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass10.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void a(e eVar) {
                        AppMethodBeat.i(128033);
                        Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                        AppMethodBeat.o(128033);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void a(com.tencent.mm.ui.h.a.b bVar) {
                        AppMethodBeat.i(128034);
                        Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                        AppMethodBeat.o(128034);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void E(Bundle bundle) {
                        AppMethodBeat.i(128035);
                        Log.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new i.a(33, Integer.toString(bpe.length)));
                        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.i(arrayList));
                        long[] jArr = bpe;
                        for (long j2 : jArr) {
                            p pVar = new p();
                            pVar.username = Long.toString(j2);
                            pVar.keQ = 5;
                            pVar.dii = (int) Util.nowSecond();
                            com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(pVar);
                        }
                        h.a(InviteFacebookFriendsUI.this, (int) R.string.c7l, (int) R.string.zb, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128031);
                                InviteFacebookFriendsUI.this.klh.anp();
                                AppMethodBeat.o(128031);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass10.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128032);
                                InviteFacebookFriendsUI.this.finish();
                                AppMethodBeat.o(128032);
                            }
                        });
                        AppMethodBeat.o(128035);
                    }

                    @Override // com.tencent.mm.ui.h.a.c.a
                    public final void onCancel() {
                        AppMethodBeat.i(128036);
                        Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                        AppMethodBeat.o(128036);
                    }
                });
                AppMethodBeat.o(128037);
                return true;
            }
        });
        showOptionMenu(false);
        AppMethodBeat.o(128047);
    }

    private void cb(String str, String str2) {
        AppMethodBeat.i(128048);
        h.a(this, str2, str, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128022);
                Intent intent = new Intent(InviteFacebookFriendsUI.this.getContext(), FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                AppCompatActivity context = InviteFacebookFriendsUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                InviteFacebookFriendsUI.this.finish();
                AppMethodBeat.o(128022);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(128048);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8g;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128049);
        Log.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 32) {
            AppMethodBeat.o(128049);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 4 && i3 == -68) {
            if (Util.isNullOrNil(str)) {
                str = "error";
            }
            cb(getString(R.string.zb), str);
            AppMethodBeat.o(128049);
        } else if (i2 == 0 && i3 == 0) {
            this.klh.onNotifyChange(null, null);
            AppMethodBeat.o(128049);
        } else {
            Toast.makeText(this, (int) R.string.f19, 0).show();
            AppMethodBeat.o(128049);
        }
    }

    public static class a extends com.tencent.mm.ui.s<com.tencent.mm.plugin.account.friend.a.g> {
        String kcL;
        private boolean[] kgD;
        private int[] pt;

        /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$a$a  reason: collision with other inner class name */
        public static class C0523a {
            ImageView gyr;
            TextView kcS;
            TextView kgG;
            CheckBox kgH;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ com.tencent.mm.plugin.account.friend.a.g a(com.tencent.mm.plugin.account.friend.a.g gVar, Cursor cursor) {
            AppMethodBeat.i(128044);
            com.tencent.mm.plugin.account.friend.a.g gVar2 = gVar;
            if (gVar2 == null) {
                gVar2 = new com.tencent.mm.plugin.account.friend.a.g();
            }
            gVar2.convertFrom(cursor);
            AppMethodBeat.o(128044);
            return gVar2;
        }

        public a(Context context, s.a aVar) {
            super(context, new com.tencent.mm.plugin.account.friend.a.g());
            AppMethodBeat.i(128038);
            super.a(aVar);
            AppMethodBeat.o(128038);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0523a aVar;
            AppMethodBeat.i(128039);
            com.tencent.mm.plugin.account.friend.a.g gVar = (com.tencent.mm.plugin.account.friend.a.g) getItem(i2);
            if (view == null) {
                C0523a aVar2 = new C0523a();
                view = View.inflate(this.context, R.layout.a6n, null);
                aVar2.gyr = (ImageView) view.findViewById(R.id.bdp);
                aVar2.kcS = (TextView) view.findViewById(R.id.gmo);
                aVar2.kgG = (TextView) view.findViewById(R.id.dzw);
                aVar2.kgH = (CheckBox) view.findViewById(R.id.e0_);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0523a) view.getTag();
            }
            aVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, gVar.bnT(), aVar.kcS.getTextSize()));
            Bitmap LY = com.tencent.mm.aj.c.LY(new StringBuilder().append(gVar.fuC).toString());
            if (LY == null) {
                aVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.default_avatar));
            } else {
                aVar.gyr.setImageBitmap(LY);
            }
            aVar.kgH.setChecked(this.kgD[i2]);
            if (com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().Tf(Long.toString(gVar.fuC))) {
                aVar.kgG.setVisibility(0);
            } else {
                aVar.kgG.setVisibility(8);
            }
            AppMethodBeat.o(128039);
            return view;
        }

        public final long[] bpe() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(128040);
            int i4 = 0;
            for (boolean z : this.kgD) {
                if (z) {
                    i4++;
                }
            }
            long[] jArr = new long[i4];
            int i5 = 0;
            while (i3 < getCount()) {
                if (this.kgD[i3]) {
                    jArr[i5] = ((com.tencent.mm.plugin.account.friend.a.g) getItem(i3)).fuC;
                    i2 = i5 + 1;
                } else {
                    i2 = i5;
                }
                i3++;
                i5 = i2;
            }
            AppMethodBeat.o(128040);
            return jArr;
        }

        public final void vl(int i2) {
            AppMethodBeat.i(128041);
            if (i2 < 0 || i2 >= this.kgD.length) {
                AppMethodBeat.o(128041);
                return;
            }
            boolean[] zArr = this.kgD;
            zArr[i2] = !zArr[i2];
            super.notifyDataSetChanged();
            AppMethodBeat.o(128041);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(128042);
            com.tencent.mm.plugin.account.friend.a.h facebookFrdStg = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
            String str = this.kcL;
            StringBuilder sb = new StringBuilder();
            sb.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                sb.append(" and ( ");
                sb.append("facebookfriend.fbname like '%" + str + "%' or ");
                sb.append("facebookfriend.nickname like '%" + str + "%' or ");
                sb.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(facebookFrdStg.iFy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + sb.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
            this.pt = new int[getCount()];
            this.kgD = new boolean[getCount()];
            super.notifyDataSetChanged();
            AppMethodBeat.o(128042);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(128043);
            anp();
            AppMethodBeat.o(128043);
        }
    }

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        AppMethodBeat.i(128050);
        Log.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.cb(inviteFacebookFriendsUI.getString(R.string.zb), inviteFacebookFriendsUI.getString(R.string.c7h));
        AppMethodBeat.o(128050);
    }
}
