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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private ProgressDialog gtM = null;
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
        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.account.friend.a.i.a
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(131204);
            if (FindMContactInviteUI.this.kbP == 2 || FindMContactInviteUI.this.kbP != 1) {
                FindMContactInviteUI.this.kgt.setText(FindMContactInviteUI.this.getString(R.string.cfm, new Object[]{Integer.valueOf(FindMContactInviteUI.this.kgn.getCount())}));
            } else {
                FindMContactInviteUI.this.kgt.setText(FindMContactInviteUI.this.getString(R.string.cfn));
            }
            if (FindMContactInviteUI.this.kgn.bnV()) {
                if (!(FindMContactInviteUI.this.kbP == 1 || FindMContactInviteUI.this.kgt.getVisibility() != 0 || FindMContactInviteUI.this.kgs == null)) {
                    FindMContactInviteUI.this.kgt.setVisibility(8);
                    FindMContactInviteUI.this.kgs.setVisibility(0);
                }
            } else if (!(FindMContactInviteUI.this.kbP == 1 || FindMContactInviteUI.this.kgt.getVisibility() != 8 || FindMContactInviteUI.this.kgs == null)) {
                FindMContactInviteUI.this.kgt.setVisibility(0);
                FindMContactInviteUI.this.kgs.setVisibility(8);
            }
            if (FindMContactInviteUI.this.kgn.getSelectCount() <= 0 || FindMContactInviteUI.this.kbP == 1) {
                FindMContactInviteUI.this.kgp.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.plurals.f3141h, FindMContactInviteUI.this.kgn.getCount(), Integer.valueOf(FindMContactInviteUI.this.kgn.getCount())));
                AppMethodBeat.o(131204);
                return;
            }
            FindMContactInviteUI.this.kgp.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.plurals.f3140g, FindMContactInviteUI.this.kgn.getSelectCount(), Integer.valueOf(FindMContactInviteUI.this.kgn.getSelectCount())));
            AppMethodBeat.o(131204);
        }
    };
    private String kgy = null;
    private int loginType;
    private com.tencent.mm.ak.i onSceneEndCallback = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FindMContactInviteUI() {
        AppMethodBeat.i(131212);
        AppMethodBeat.o(131212);
    }

    static /* synthetic */ void l(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.i(131223);
        findMContactInviteUI.bnm();
        AppMethodBeat.o(131223);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(131213);
        super.onCreate(bundle);
        setMMTitle(R.string.cfq);
        a.jRu.Xc();
        this.kgy = getIntent().getStringExtra("regsetinfo_ticket");
        this.loginType = getIntent().getIntExtra("login_type", 0);
        this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        AppMethodBeat.o(131213);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(131214);
        if (i2 == 4) {
            bnm();
            AppMethodBeat.o(131214);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(131214);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(131215);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        hideVKB();
        ala(1);
        AppMethodBeat.o(131215);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(131216);
        super.onResume();
        this.kgn.notifyDataSetChanged();
        if (this.loginType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R300_400_QQ")).append(",1").toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("R300_400_phone")).append(",1").toString());
        }
        if (this.kgv) {
            boolean a2 = b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
            Log.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
            if (!a2) {
                AppMethodBeat.o(131216);
                return;
            }
            boH();
        }
        AppMethodBeat.o(131216);
    }

    private void boH() {
        AppMethodBeat.i(131217);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.f1_), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(131201);
                if (FindMContactInviteUI.this.gtM != null) {
                    FindMContactInviteUI.this.gtM.dismiss();
                    FindMContactInviteUI.this.gtM = null;
                }
                FindMContactInviteUI.this.kgn.notifyDataSetChanged();
                AppMethodBeat.o(131201);
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(131202);
                try {
                    FindMContactInviteUI.this.kgu = com.tencent.mm.pluginsdk.b.dO(FindMContactInviteUI.this);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FindMContactInviteUI", e2, "", new Object[0]);
                }
                FindMContactInviteUI.this.kgn.kbT = FindMContactInviteUI.this.kgu;
                FindMContactInviteUI.this.kgn.s(((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
                AppMethodBeat.o(131202);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(131203);
                String str = super.toString() + "|listMFriendData";
                AppMethodBeat.o(131203);
                return str;
            }
        });
        AppMethodBeat.o(131217);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(131218);
        super.onPause();
        if (this.loginType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_400_QQ")).append(",2").toString());
            AppMethodBeat.o(131218);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("R300_400_phone")).append(",2").toString());
        AppMethodBeat.o(131218);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(131219);
        if (this.onSceneEndCallback != null) {
            g.azz().b(v2helper.EMethodSetSendToNetworkOn, this.onSceneEndCallback);
            this.onSceneEndCallback = null;
        }
        if (this.kgn != null) {
            i iVar = this.kgn;
            if (iVar.kex != null) {
                iVar.kex.detach();
                iVar.kex = null;
            }
        }
        ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
        super.onDestroy();
        AppMethodBeat.o(131219);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a92;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(131220);
        this.emptyTipTv = (TextView) findViewById(R.id.fgq);
        this.emptyTipTv.setText(R.string.f18);
        this.kde = (ListView) findViewById(R.id.fgs);
        if (this.kbP == 2 || this.kbP != 1) {
            this.kgo = LayoutInflater.from(this).inflate(R.layout.a93, (ViewGroup) null);
            this.kgp = (TextView) this.kgo.findViewById(R.id.d4f);
            this.kgq = (TextView) this.kgo.findViewById(R.id.d4i);
            this.kgr = (TextView) this.kgo.findViewById(R.id.cj4);
            this.kgt = (Button) this.kgo.findViewById(R.id.cj3);
            this.kgq.setText(getString(R.string.cfr));
            this.kgr.setText(getString(R.string.cfo));
            this.kgt.setText(getString(R.string.cfm, new Object[]{0}));
            this.kgs = (TextView) this.kgo.findViewById(R.id.fgl);
        } else {
            this.kgo = LayoutInflater.from(this).inflate(R.layout.a94, (ViewGroup) null);
            this.kgp = (TextView) this.kgo.findViewById(R.id.d4f);
            this.kgq = (TextView) this.kgo.findViewById(R.id.d4i);
            this.kgr = (TextView) this.kgo.findViewById(R.id.cj4);
            this.kgt = (Button) this.kgo.findViewById(R.id.cj3);
            this.kgq.setText(getString(R.string.cfo));
            this.kgr.setText(getString(R.string.cfo));
            this.kgt.setText(getString(R.string.cfn));
        }
        this.kgn = new i(this, this.kgw, 2);
        this.kgt.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(131205);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
                g.aAf();
                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_300_AddAllButton")).append(",3").toString());
                if (FindMContactInviteUI.this.kbP == 2) {
                    FindMContactInviteUI.this.kgn.gk(true);
                    FindMContactInviteUI.this.kgn.notifyDataSetChanged();
                    FindMContactInviteUI.this.kgt.setVisibility(8);
                    if (FindMContactInviteUI.this.kgs != null) {
                        FindMContactInviteUI.this.kgs.setVisibility(0);
                    }
                } else if (FindMContactInviteUI.this.kbP == 1) {
                    FindMContactInviteUI.this.kgn.gk(true);
                    FindMContactInviteUI.this.kgn.notifyDataSetChanged();
                    FindMContactInviteUI.h(FindMContactInviteUI.this);
                } else {
                    FindMContactInviteUI.this.kgn.gk(true);
                    FindMContactInviteUI.this.kgn.notifyDataSetChanged();
                    FindMContactInviteUI.this.kgt.setVisibility(8);
                    if (FindMContactInviteUI.this.kgs != null) {
                        FindMContactInviteUI.this.kgs.setVisibility(0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131205);
            }
        });
        if (this.kgs != null) {
            this.kgs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131206);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FindMContactInviteUI.this.kgt.setVisibility(0);
                    FindMContactInviteUI.this.kgs.setVisibility(8);
                    FindMContactInviteUI.this.kgn.gk(false);
                    FindMContactInviteUI.this.kgn.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131206);
                }
            });
            this.kgs.setVisibility(8);
        }
        this.kde.addHeaderView(this.kgo);
        this.kde.setAdapter((ListAdapter) this.kgn);
        this.kde.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.kde.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass9 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(131207);
                if (FindMContactInviteUI.this.kgn != null) {
                    i iVar = FindMContactInviteUI.this.kgn;
                    if (iVar.kex != null) {
                        iVar.kex.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(131207);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131208);
                FindMContactInviteUI.h(FindMContactInviteUI.this);
                AppMethodBeat.o(131208);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(131209);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(FindMContactInviteUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131209);
            }
        });
        AppMethodBeat.o(131220);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(131221);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(131221);
            return;
        }
        Log.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    this.kgv = false;
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(131199);
                            FindMContactInviteUI findMContactInviteUI = FindMContactInviteUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactInviteUI, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            findMContactInviteUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactInviteUI, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FindMContactInviteUI.this.kgv = true;
                            FindMContactInviteUI.this.finish();
                            AppMethodBeat.o(131199);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(131200);
                            FindMContactInviteUI.this.kgv = true;
                            FindMContactInviteUI.this.finish();
                            AppMethodBeat.o(131200);
                        }
                    });
                    break;
                } else {
                    boH();
                    AppMethodBeat.o(131221);
                    return;
                }
        }
        AppMethodBeat.o(131221);
    }

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.i(131222);
        findMContactInviteUI.hideVKB();
        if (findMContactInviteUI.kgn.getSelectCount() == 0) {
            findMContactInviteUI.bnm();
            AppMethodBeat.o(131222);
            return;
        }
        h.a(findMContactInviteUI, findMContactInviteUI.getString(R.string.cfl), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(131211);
                if (FindMContactInviteUI.this.loginType == 1) {
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_500_QQ")).append(",3").toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    g.aAf();
                    StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_500_phone,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.DX(append2.append(com.tencent.mm.kernel.a.FN("R300_500_phone")).append(",3").toString());
                }
                g.azz().a(v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.onSceneEndCallback = new com.tencent.mm.ak.i() {
                    /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass12.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(131210);
                        if (FindMContactInviteUI.this.gtM != null) {
                            FindMContactInviteUI.this.gtM.dismiss();
                            FindMContactInviteUI.this.gtM = null;
                        }
                        if (FindMContactInviteUI.this.onSceneEndCallback != null) {
                            g.azz().b(v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.onSceneEndCallback);
                            FindMContactInviteUI.this.onSceneEndCallback = null;
                        }
                        FindMContactInviteUI.l(FindMContactInviteUI.this);
                        AppMethodBeat.o(131210);
                    }
                });
                FindMContactInviteUI findMContactInviteUI = FindMContactInviteUI.this;
                AppCompatActivity context = FindMContactInviteUI.this.getContext();
                FindMContactInviteUI.this.getString(R.string.zb);
                findMContactInviteUI.gtM = h.a((Context) context, FindMContactInviteUI.this.getString(R.string.cfp), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass12.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                FindMContactInviteUI.this.kgn.SZ(FindMContactInviteUI.this.kgy);
                AppMethodBeat.o(131211);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(131222);
    }
}
