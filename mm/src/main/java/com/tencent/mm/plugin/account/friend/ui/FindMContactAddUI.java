package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private ProgressDialog gtM = null;
    private String gwF = null;
    private String kbO = "";
    private int kbP = 2;
    private String kbV;
    private ListView kde;
    private i kgn;
    private View kgo;
    private TextView kgp = null;
    private TextView kgq = null;
    private TextView kgr = null;
    private TextView kgs = null;
    private Button kgt = null;
    private List<String[]> kgu;
    private boolean kgv = true;
    private i.a kgw = new i.a() {
        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.account.friend.a.i.a
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(131181);
            if (FindMContactAddUI.this.kbP == 2 || FindMContactAddUI.this.kbP != 1) {
                FindMContactAddUI.this.kgt.setText(FindMContactAddUI.this.getString(R.string.cfd, new Object[]{Integer.valueOf(FindMContactAddUI.this.kgn.getCount())}));
            } else {
                FindMContactAddUI.this.kgt.setText(FindMContactAddUI.this.getString(R.string.cfe));
            }
            if (FindMContactAddUI.this.kgn.bnV()) {
                if (!(FindMContactAddUI.this.kbP == 1 || FindMContactAddUI.this.kgt.getVisibility() != 0 || FindMContactAddUI.this.kgs == null)) {
                    FindMContactAddUI.this.kgt.setVisibility(8);
                    FindMContactAddUI.this.kgs.setVisibility(0);
                }
            } else if (!(FindMContactAddUI.this.kbP == 1 || FindMContactAddUI.this.kgt.getVisibility() != 8 || FindMContactAddUI.this.kgs == null)) {
                FindMContactAddUI.this.kgt.setVisibility(0);
                FindMContactAddUI.this.kgs.setVisibility(8);
            }
            if (FindMContactAddUI.this.kgn.getSelectCount() <= 0 || FindMContactAddUI.this.kbP == 1) {
                FindMContactAddUI.this.kgp.setText(FindMContactAddUI.this.getResources().getQuantityString(R.plurals.f3142i, FindMContactAddUI.this.kgn.getCount(), Integer.valueOf(FindMContactAddUI.this.kgn.getCount())));
                AppMethodBeat.o(131181);
                return;
            }
            FindMContactAddUI.this.kgp.setText(FindMContactAddUI.this.getResources().getQuantityString(R.plurals.f3139f, FindMContactAddUI.this.kgn.getSelectCount(), Integer.valueOf(FindMContactAddUI.this.kgn.getSelectCount())));
            AppMethodBeat.o(131181);
        }
    };
    private int loginType;
    private com.tencent.mm.ak.i onSceneEndCallback = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FindMContactAddUI() {
        AppMethodBeat.i(131187);
        AppMethodBeat.o(131187);
    }

    static /* synthetic */ void n(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.i(131198);
        findMContactAddUI.bnm();
        AppMethodBeat.o(131198);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(131188);
        super.onCreate(bundle);
        setMMTitle(R.string.cfi);
        a.jRu.Xc();
        this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.loginType = getIntent().getIntExtra("login_type", 0);
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        AppMethodBeat.o(131188);
    }

    private void boH() {
        AppMethodBeat.i(131189);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.f1_), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass6 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(131178);
                if (FindMContactAddUI.this.gtM != null) {
                    FindMContactAddUI.this.gtM.dismiss();
                    FindMContactAddUI.this.gtM = null;
                }
                FindMContactAddUI.this.kgn.notifyDataSetChanged();
                AppMethodBeat.o(131178);
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(131179);
                try {
                    FindMContactAddUI.this.kgu = b.dO(FindMContactAddUI.this);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FindMContactAddUI", e2, "", new Object[0]);
                }
                FindMContactAddUI.this.kgn.kbT = FindMContactAddUI.this.kgu;
                FindMContactAddUI.this.kgn.s(((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
                AppMethodBeat.o(131179);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(131180);
                String str = super.toString() + "|listMFriendData";
                AppMethodBeat.o(131180);
                return str;
            }
        });
        AppMethodBeat.o(131189);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(131190);
        if (i2 == 4) {
            bnm();
            AppMethodBeat.o(131190);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(131190);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(131191);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        hideVKB();
        ala(1);
        AppMethodBeat.o(131191);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(131192);
        super.onResume();
        this.kgn.notifyDataSetChanged();
        if (this.loginType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R300_300_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R300_300_QQ");
        } else {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("R300_300_phone")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R300_300_phone");
        }
        if (this.kgv) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
            Log.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
            if (!a2) {
                AppMethodBeat.o(131192);
                return;
            }
            boH();
        }
        AppMethodBeat.o(131192);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(131193);
        super.onPause();
        if (this.loginType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_300_QQ")).append(",2").toString());
            AppMethodBeat.o(131193);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("R300_300_phone")).append(",2").toString());
        AppMethodBeat.o(131193);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(131194);
        if (this.onSceneEndCallback != null) {
            g.azz().b(30, this.onSceneEndCallback);
            this.onSceneEndCallback = null;
        }
        super.onDestroy();
        AppMethodBeat.o(131194);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a92;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(131195);
        this.emptyTipTv = (TextView) findViewById(R.id.fgq);
        this.emptyTipTv.setText(R.string.f18);
        this.kde = (ListView) findViewById(R.id.fgs);
        if (this.kbP == 2 || this.kbP != 1) {
            this.kgo = LayoutInflater.from(this).inflate(R.layout.a93, (ViewGroup) null);
            this.kgp = (TextView) this.kgo.findViewById(R.id.d4f);
            this.kgq = (TextView) this.kgo.findViewById(R.id.d4i);
            this.kgr = (TextView) this.kgo.findViewById(R.id.cj4);
            this.kgt = (Button) this.kgo.findViewById(R.id.cj3);
            this.kgq.setText(getString(R.string.cg_));
            this.kgr.setText(getString(R.string.cga));
            this.kgt.setText(getString(R.string.cfd, new Object[]{0}));
            this.kgs = (TextView) this.kgo.findViewById(R.id.fgl);
        } else {
            this.kgo = LayoutInflater.from(this).inflate(R.layout.a94, (ViewGroup) null);
            this.kgp = (TextView) this.kgo.findViewById(R.id.d4f);
            this.kgq = (TextView) this.kgo.findViewById(R.id.d4i);
            this.kgr = (TextView) this.kgo.findViewById(R.id.cj4);
            this.kgt = (Button) this.kgo.findViewById(R.id.cj3);
            this.kgq.setText(getString(R.string.cg_));
            this.kgr.setText(getString(R.string.cga));
            this.kgt.setText(getString(R.string.cfe));
        }
        this.kgn = new i(this, this.kgw, 1);
        this.kgt.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(131182);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
                g.aAf();
                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_300_AddAllButton")).append(",3").toString());
                if (FindMContactAddUI.this.kbP == 2) {
                    FindMContactAddUI.this.kgn.gk(true);
                    FindMContactAddUI.this.kgn.notifyDataSetChanged();
                    FindMContactAddUI.this.kgt.setVisibility(8);
                    if (FindMContactAddUI.this.kgs != null) {
                        FindMContactAddUI.this.kgs.setVisibility(0);
                    }
                } else if (FindMContactAddUI.this.kbP == 1) {
                    FindMContactAddUI.this.kgn.gk(true);
                    FindMContactAddUI.this.kgn.notifyDataSetChanged();
                    FindMContactAddUI.i(FindMContactAddUI.this);
                } else {
                    FindMContactAddUI.this.kgn.gk(true);
                    FindMContactAddUI.this.kgn.notifyDataSetChanged();
                    FindMContactAddUI.this.kgt.setVisibility(8);
                    if (FindMContactAddUI.this.kgs != null) {
                        FindMContactAddUI.this.kgs.setVisibility(0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131182);
            }
        });
        if (this.kgs != null) {
            this.kgs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131183);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FindMContactAddUI.this.kgt.setVisibility(0);
                    FindMContactAddUI.this.kgs.setVisibility(8);
                    FindMContactAddUI.this.kgn.gk(false);
                    FindMContactAddUI.this.kgn.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131183);
                }
            });
            this.kgs.setVisibility(8);
        }
        this.kde.addHeaderView(this.kgo);
        this.kde.setAdapter((ListAdapter) this.kgn);
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131184);
                FindMContactAddUI.i(FindMContactAddUI.this);
                AppMethodBeat.o(131184);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(131185);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(FindMContactAddUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131185);
            }
        });
        AppMethodBeat.o(131195);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(131196);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(131196);
            return;
        }
        Log.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    this.kgv = false;
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(131176);
                            FindMContactAddUI findMContactAddUI = FindMContactAddUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactAddUI, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            findMContactAddUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactAddUI, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FindMContactAddUI.this.kgv = true;
                            FindMContactAddUI.this.finish();
                            AppMethodBeat.o(131176);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(131177);
                            FindMContactAddUI.this.kgv = true;
                            FindMContactAddUI.this.finish();
                            AppMethodBeat.o(131177);
                        }
                    });
                    break;
                } else {
                    boH();
                    AppMethodBeat.o(131196);
                    return;
                }
        }
        AppMethodBeat.o(131196);
    }

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.i(131197);
        findMContactAddUI.hideVKB();
        if (findMContactAddUI.kgn.getSelectCount() == 0) {
            h.c(findMContactAddUI, findMContactAddUI.getString(R.string.cfz), "", findMContactAddUI.getString(R.string.cfb), findMContactAddUI.getString(R.string.cfc), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(131186);
                    if (FindMContactAddUI.this.kbO == null || !FindMContactAddUI.this.kbO.contains("2")) {
                        FindMContactAddUI.n(FindMContactAddUI.this);
                        AppMethodBeat.o(131186);
                        return;
                    }
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.gwF);
                    intent.putExtra("login_type", FindMContactAddUI.this.loginType);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.kbP);
                    MMWizardActivity.ay(FindMContactAddUI.this, intent);
                    AppMethodBeat.o(131186);
                }
            });
            AppMethodBeat.o(131197);
            return;
        }
        t azz = g.azz();
        AnonymousClass2 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass2 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(131175);
                if (FindMContactAddUI.this.gtM != null) {
                    FindMContactAddUI.this.gtM.dismiss();
                    FindMContactAddUI.this.gtM = null;
                }
                if (FindMContactAddUI.this.onSceneEndCallback != null) {
                    g.azz().b(30, FindMContactAddUI.this.onSceneEndCallback);
                    FindMContactAddUI.this.onSceneEndCallback = null;
                }
                if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(FindMContactAddUI.this.getContext(), str, 1).show();
                    AppMethodBeat.o(131175);
                } else if (FindMContactAddUI.this.kbO == null || !FindMContactAddUI.this.kbO.contains("2")) {
                    FindMContactAddUI.n(FindMContactAddUI.this);
                    AppMethodBeat.o(131175);
                } else {
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.gwF);
                    intent.putExtra("login_type", FindMContactAddUI.this.loginType);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.kbP);
                    MMWizardActivity.ay(FindMContactAddUI.this, intent);
                    AppMethodBeat.o(131175);
                }
            }
        };
        findMContactAddUI.onSceneEndCallback = r2;
        azz.a(30, r2);
        AppCompatActivity context = findMContactAddUI.getContext();
        findMContactAddUI.getString(R.string.zb);
        findMContactAddUI.gtM = h.a((Context) context, findMContactAddUI.getString(R.string.cfp), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        i iVar = findMContactAddUI.kgn;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < iVar.ket.size(); i2++) {
            if (iVar.pt[i2] == 1) {
                linkedList.add(iVar.ket.get(i2).UserName);
                linkedList2.add(52);
            }
        }
        new aa(iVar.context, null).z(linkedList, linkedList2);
        AppMethodBeat.o(131197);
    }
}
