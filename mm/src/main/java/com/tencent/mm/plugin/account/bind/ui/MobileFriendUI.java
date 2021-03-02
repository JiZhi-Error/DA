package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.bind.ui.b;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.s;
import java.util.List;

public class MobileFriendUI extends MMActivity implements i {
    private TextView emptyTipTv = null;
    private ProgressDialog gtM = null;
    private ListView kde;
    b kdf;
    private View kdg;
    private ao kdh;
    String kdi;
    private TextView kdj = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void h(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.i(110171);
        mobileFriendUI.getData();
        AppMethodBeat.o(110171);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110160);
        super.onCreate(bundle);
        setMMTitle(R.string.f1b);
        ((b) ((a) g.ah(a.class)).getAddrUploadStg()).iFy.execSQL("qqlist", "update addr_upload2 set reserved4=0");
        g.azz().a(32, this);
        g.azz().a(133, this);
        initView();
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", Boolean.valueOf(a2));
        if (!a2) {
            AppMethodBeat.o(110160);
            return;
        }
        bnD();
        AppMethodBeat.o(110160);
    }

    private void bnD() {
        AppMethodBeat.i(110161);
        if (d.oD(26)) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, (String) null, (String) null);
            Log.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", Boolean.valueOf(a2));
            if (!a2) {
                AppMethodBeat.o(110161);
                return;
            }
        }
        getData();
        AppMethodBeat.o(110161);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110162);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(110162);
            return;
        }
        Log.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110145);
                            MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(mobileFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mobileFriendUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(mobileFriendUI, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            MobileFriendUI.this.finish();
                            AppMethodBeat.o(110145);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110152);
                            MobileFriendUI.this.finish();
                            AppMethodBeat.o(110152);
                        }
                    });
                    break;
                } else {
                    bnD();
                    AppMethodBeat.o(110162);
                    return;
                }
        }
        AppMethodBeat.o(110162);
    }

    private void getData() {
        AppMethodBeat.i(110163);
        if (!l.bnY()) {
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.f1_), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass9 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(110153);
                    if (MobileFriendUI.this.kdh != null) {
                        g.azz().a(MobileFriendUI.this.kdh);
                    }
                    AppMethodBeat.o(110153);
                }
            });
            if (this.kdf.getCount() == 0) {
                if (!((a) g.ah(a.class)).syncAddrBook(new com.tencent.mm.plugin.account.a.a.b() {
                    /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass10 */

                    @Override // com.tencent.mm.plugin.account.a.a.b
                    public final void fG(boolean z) {
                        AppMethodBeat.i(110154);
                        Log.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
                        if (!z) {
                            if (MobileFriendUI.this.gtM != null) {
                                MobileFriendUI.this.gtM.dismiss();
                                MobileFriendUI.this.gtM = null;
                            }
                            AppMethodBeat.o(110154);
                            return;
                        }
                        System.currentTimeMillis();
                        l.boe();
                        g.azz().a(new ao(l.boi(), l.boh()), 0);
                        AppMethodBeat.o(110154);
                    }
                }) && this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                AppMethodBeat.o(110163);
                return;
            }
            List<String> boi = l.boi();
            List<String> boh = l.boh();
            if (boi.size() == 0 && boh.size() == 0) {
                g.azz().a(new ad(), 0);
            } else {
                this.kdh = new ao(l.boi(), l.boh());
                g.azz().a(this.kdh, 0);
                AppMethodBeat.o(110163);
                return;
            }
        }
        AppMethodBeat.o(110163);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110164);
        super.onResume();
        this.kdf.notifyDataSetChanged();
        AppMethodBeat.o(110164);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(110165);
        super.onPause();
        AppMethodBeat.o(110165);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110166);
        f.KW("2");
        g.azz().b(32, this);
        g.azz().b(133, this);
        this.kdf.ebf();
        super.onDestroy();
        AppMethodBeat.o(110166);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bav;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(110167);
        this.emptyTipTv = (TextView) findViewById(R.id.fgq);
        this.emptyTipTv.setText(R.string.f18);
        this.kdj = (TextView) findViewById(R.id.c2z);
        this.kdj.setText(R.string.f2h);
        this.kdg = findViewById(R.id.fgt);
        this.kde = (ListView) findViewById(R.id.fgs);
        s sVar = new s((byte) 0);
        sVar.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(110155);
                MobileFriendUI.this.kdi = Util.escapeSqlValue(str);
                MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                if (mobileFriendUI.kdf != null) {
                    mobileFriendUI.kdf.SM(mobileFriendUI.kdi);
                }
                AppMethodBeat.o(110155);
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
        Log.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (!z) {
            this.kdf = new c(this, new s.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass12 */

                @Override // com.tencent.mm.ui.s.a
                public final void bnE() {
                    AppMethodBeat.i(110156);
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.kdf.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                    AppMethodBeat.o(110156);
                }
            });
        } else {
            this.kdf = new d(this, new s.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass13 */

                @Override // com.tencent.mm.ui.s.a
                public final void bnE() {
                    AppMethodBeat.i(110157);
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.kdf.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                    AppMethodBeat.o(110157);
                }
            });
        }
        this.kde.setAdapter((ListAdapter) this.kdf);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass14 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(110158);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < MobileFriendUI.this.kde.getHeaderViewsCount()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(110158);
                    return;
                }
                com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) MobileFriendUI.this.kdf.getItem(i2 - MobileFriendUI.this.kde.getHeaderViewsCount());
                if (aVar.status == 1 || aVar.status == 2) {
                    MobileFriendUI.this.b(aVar);
                }
                if (aVar.status == 0) {
                    Intent intent = new Intent(MobileFriendUI.this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", aVar.getUsername());
                    intent.putExtra("friend_num", aVar.bnP());
                    intent.putExtra("friend_nick", aVar.bnK());
                    intent.putExtra("friend_weixin_nick", aVar.getNickName());
                    intent.putExtra("friend_scene", 13);
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mobileFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mobileFriendUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mobileFriendUI, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(110158);
            }
        });
        this.kdf.a(new b.a() {
            /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.account.bind.ui.b.a
            public final void ve(int i2) {
                AppMethodBeat.i(110159);
                if (i2 > 0) {
                    MobileFriendUI.this.kdj.setVisibility(8);
                    AppMethodBeat.o(110159);
                    return;
                }
                MobileFriendUI.this.kdj.setVisibility(0);
                AppMethodBeat.o(110159);
            }
        });
        if (!(l.bnZ() == l.a.SUCC || l.bnZ() == l.a.SUCC_UNLOAD)) {
            this.kdg = findViewById(R.id.fgt);
            this.kdg.setVisibility(0);
            this.kdg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110146);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(MobileFriendUI.this.getContext(), BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.ay(MobileFriendUI.this, intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110146);
                }
            });
            this.kde.setVisibility(8);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110147);
                MobileFriendUI.this.hideVKB();
                MobileFriendUI.this.finish();
                AppMethodBeat.o(110147);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(110148);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(MobileFriendUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110148);
            }
        });
        if (!z.aUI() || l.bnY()) {
            h.a(this, (int) R.string.add, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110149);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11438, 6);
                    Log.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", 11438, 6);
                    l.gl(true);
                    ((a) g.ah(a.class)).syncUploadMContactStatus(true, true);
                    MobileFriendUI.h(MobileFriendUI.this);
                    AppMethodBeat.o(110149);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110150);
                    l.gl(false);
                    ((a) g.ah(a.class)).syncUploadMContactStatus(false, true);
                    MobileFriendUI.this.finish();
                    AppMethodBeat.o(110150);
                }
            });
        }
        AppMethodBeat.o(110167);
    }

    public final void b(com.tencent.mm.plugin.account.friend.a.a aVar) {
        AppMethodBeat.i(110168);
        if (Util.isNullOrNil(aVar.getUsername())) {
            Log.e("MicroMsg.MobileFriendUI", "username is null");
            AppMethodBeat.o(110168);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", aVar.getUsername());
        intent.putExtra("Contact_Nick", aVar.getNickName());
        intent.putExtra("Contact_Mobile_MD5", aVar.getMd5());
        intent.putExtra("Contact_Alias", aVar.ked);
        intent.putExtra("Contact_Sex", aVar.kdY);
        intent.putExtra("Contact_Signature", aVar.keb);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(aVar.keh, aVar.kdZ, aVar.kea));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.account.a.a.jRt.c(intent, this);
        AppMethodBeat.o(110168);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(110169);
        Log.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() == 32 && this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!(i2 == 0 && i3 == 0)) {
            Log.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i2 + ", errCode = " + i3);
        }
        if (qVar.getType() == 133) {
            g.azz().a(new ad(), 0);
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 32) {
                ((a) g.ah(a.class)).updateAllContact();
            }
            this.kdf.onNotifyChange(null, null);
            AppMethodBeat.o(110169);
            return;
        }
        if (qVar.getType() == 32) {
            Toast.makeText(this, (int) R.string.f19, 0).show();
        }
        AppMethodBeat.o(110169);
    }

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.i(110170);
        if (l.bnZ() != l.a.SUCC && l.bnZ() != l.a.SUCC_UNLOAD) {
            mobileFriendUI.kdg.setVisibility(0);
            mobileFriendUI.kdg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110151);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MMWizardActivity.ay(MobileFriendUI.this, new Intent(MobileFriendUI.this, BindMContactIntroUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110151);
                }
            });
            mobileFriendUI.kde.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
            AppMethodBeat.o(110170);
        } else if (mobileFriendUI.kdf.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.kde.setVisibility(8);
            mobileFriendUI.kdg.setVisibility(8);
            AppMethodBeat.o(110170);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.kde.setVisibility(0);
            mobileFriendUI.kdg.setVisibility(8);
            AppMethodBeat.o(110170);
        }
    }
}
