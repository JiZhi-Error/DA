package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.d;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.s;
import com.tencent.smtt.sdk.TbsListener;

public class QQFriendUI extends MMActivity implements i {
    private int adT;
    private ProgressDialog gtM = null;
    private s gzP;
    private ListView kde;
    String kdi;
    private TextView kdj = null;
    d khq;
    private boolean khr = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(131280);
        super.onCreate(bundle);
        g.azz().a(TbsListener.ErrorCode.NEEDDOWNLOAD_4, this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.adT = getIntent().getIntExtra("qqgroup_id", -1);
        int i2 = this.adT;
        Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i2)));
        ((at) ((a) g.ah(a.class)).getQQListStg()).iFy.execSQL("qqlist", "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i2)));
        if (l.vh(this.adT)) {
            final af afVar = new af(this.adT);
            g.azz().a(afVar, 0);
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.fr3), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131274);
                    g.azz().a(afVar);
                    AppMethodBeat.o(131274);
                }
            });
        }
        setMMTitle(stringExtra);
        initView();
        AppMethodBeat.o(131280);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(131281);
        super.onResume();
        p.aYn().d(this.khq);
        this.khq.notifyDataSetChanged();
        AppMethodBeat.o(131281);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(131282);
        f.KW("2");
        ((at) ((a) g.ah(a.class)).getQQListStg()).remove(this.khq);
        g.azz().b(TbsListener.ErrorCode.NEEDDOWNLOAD_4, this);
        this.khq.ebf();
        p.aYD().cancel();
        super.onDestroy();
        AppMethodBeat.o(131282);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(131283);
        p.aYn().e(this.khq);
        super.onPause();
        AppMethodBeat.o(131283);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bju;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(131284);
        Log.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(131284);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(131285);
        this.kde = (ListView) findViewById(R.id.gmn);
        this.kdj = (TextView) findViewById(R.id.c32);
        this.kdj.setText(R.string.fre);
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(131275);
                QQFriendUI.this.kdi = Util.escapeSqlValue(str);
                QQFriendUI.this.khr = true;
                QQFriendUI qQFriendUI = QQFriendUI.this;
                if (qQFriendUI.khq != null) {
                    qQFriendUI.khq.SM(qQFriendUI.kdi);
                }
                AppMethodBeat.o(131275);
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
        addSearchMenu(true, this.gzP);
        if (com.tencent.mm.model.a.g.aWT().KR("2") != null) {
            String str = com.tencent.mm.model.a.g.aWT().KR("2").value;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.KV("2");
        } else {
            z = true;
        }
        if (!z) {
            this.khq = new e(this, this.adT);
        } else {
            this.khq = new f(this, this.adT);
        }
        this.khq.a(new d.a() {
            /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.account.friend.ui.d.a
            public final void ve(int i2) {
                AppMethodBeat.i(131276);
                if (QQFriendUI.this.khr) {
                    if (i2 > 0) {
                        QQFriendUI.this.kdj.setVisibility(8);
                    } else {
                        QQFriendUI.this.kdj.setVisibility(0);
                    }
                }
                QQFriendUI.this.khr = false;
                AppMethodBeat.o(131276);
            }
        });
        this.kde.setAdapter((ListAdapter) this.khq);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                j jVar;
                AppMethodBeat.i(131277);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < QQFriendUI.this.kde.getHeaderViewsCount()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(131277);
                    return;
                }
                int headerViewsCount = i2 - QQFriendUI.this.kde.getHeaderViewsCount();
                Log.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", Integer.valueOf(headerViewsCount), Integer.valueOf(QQFriendUI.this.kde.getHeaderViewsCount()));
                as asVar = (as) QQFriendUI.this.khq.getItem(headerViewsCount);
                if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                    qc qcVar = new qc();
                    qcVar.dWm.opType = 0;
                    qcVar.dWm.dWo = asVar.kfN + "@qqim";
                    qcVar.dWm.dWp = asVar.getDisplayName();
                    EventCenter.instance.publish(qcVar);
                    if (qcVar.dWn.dFE) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", asVar.kfN + "@qqim");
                        intent.putExtra("key_need_send_video", false);
                        com.tencent.mm.plugin.account.a.a.jRt.d(intent, QQFriendUI.this);
                    }
                } else if (asVar.kfO == 1 || asVar.kfO == 2) {
                    com.tencent.mm.storage.as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(asVar.getUsername());
                    if (Kn != null && Kn.gBM()) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, asVar.getUsername() + ",12");
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", asVar.getUsername());
                    intent2.putExtra("Contact_Nick", asVar.getNickname());
                    intent2.putExtra("Contact_Uin", asVar.kfN);
                    intent2.putExtra("Contact_QQNick", asVar.getDisplayName());
                    intent2.putExtra("Contact_Scene", 12);
                    intent2.putExtra("Contact_RemarkName", asVar.boz());
                    Cursor rawQuery = ((k) ((a) g.ah(a.class)).getFrdExtStg()).iFy.rawQuery("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + Util.escapeSqlValue(String.valueOf(asVar.getUsername())) + "\"", null, 2);
                    if (rawQuery == null) {
                        jVar = null;
                    } else {
                        jVar = null;
                        if (rawQuery.moveToFirst()) {
                            jVar = new j();
                            jVar.username = rawQuery.getString(0);
                            jVar.fuA = rawQuery.getInt(1);
                            jVar.fuI = rawQuery.getInt(2);
                            jVar.fuJ = rawQuery.getString(3);
                            jVar.fuK = rawQuery.getString(4);
                            jVar.signature = rawQuery.getString(5);
                        }
                        rawQuery.close();
                    }
                    if (jVar != null) {
                        intent2.putExtra("Contact_Sex", jVar.fuA);
                    }
                    intent2.putExtra("Contact_ShowUserName", false);
                    if (Util.isNullOrNil(asVar.getUsername())) {
                        Log.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", asVar.toString());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(131277);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.a.jRt.c(intent2, QQFriendUI.this);
                } else if (asVar.kfO == 0) {
                    Intent intent3 = new Intent(QQFriendUI.this, InviteFriendUI.class);
                    intent3.putExtra("friend_type", 0);
                    intent3.putExtra("friend_user_name", asVar.getUsername());
                    intent3.putExtra("friend_num", new StringBuilder().append(asVar.kfN).toString());
                    intent3.putExtra("friend_nick", asVar.getDisplayName());
                    intent3.putExtra("friend_weixin_nick", asVar.getNickname());
                    intent3.putExtra("friend_scene", 12);
                    QQFriendUI qQFriendUI = QQFriendUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(qQFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    qQFriendUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(qQFriendUI, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(131277);
            }
        });
        ((at) ((a) g.ah(a.class)).getQQListStg()).add(this.khq);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131278);
                QQFriendUI.this.hideVKB();
                QQFriendUI.this.finish();
                AppMethodBeat.o(131278);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.QQFriendUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(131279);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(QQFriendUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131279);
            }
        });
        AppMethodBeat.o(131285);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(131286);
        Log.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(131286);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(131287);
        Log.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (((bte) ((af) qVar).rr.iLK.iLR).him != 1) {
            AppMethodBeat.o(131287);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0) {
            this.khq.anp();
            AppMethodBeat.o(131287);
            return;
        }
        Toast.makeText(this, (int) R.string.fr2, 0).show();
        AppMethodBeat.o(131287);
    }
}
