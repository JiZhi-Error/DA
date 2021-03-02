package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.model.a;
import com.tencent.mm.plugin.ipcall.model.h.b;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.s;

public class IPCallContactUI extends MMActivity {
    private s gzP = new s((byte) 0);
    private MMHandler hAk = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25688);
            if (message.what == 1) {
                if (IPCallContactUI.this.yuB != null) {
                    IPCallContactUI.this.yuB.dismiss();
                }
                IPCallContactUI.this.yuD.setVisibility(0);
                c unused = IPCallContactUI.this.yuC;
                c.ysD = b.eaW();
                IPCallContactUI.this.yuC.anp();
                IPCallContactUI.this.yuC.notifyDataSetChanged();
                IPCallContactUI.this.yum.invalidateViews();
                IPCallContactUI.this.yuF.setAddressCount(IPCallContactUI.this.yuC.getCount());
                a.dZG().cmK();
                AppMethodBeat.o(25688);
                return;
            }
            if (message.what == 2) {
                if (IPCallContactUI.this.yuC.getCount() == 0) {
                    IPCallContactUI.this.yuH.setVisibility(0);
                } else {
                    IPCallContactUI.this.yuH.setVisibility(8);
                }
                if (IPCallContactUI.this.yuC.getCount() != 0 && IPCallContactUI.this.yuM) {
                    IPCallContactUI.this.yuC.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(25688);
        }
    };
    private String kdi;
    private ProgressDialog yuB = null;
    private c yuC;
    private RelativeLayout yuD;
    private LinearLayout yuE;
    private IPCallAddressCountView yuF = null;
    private VerticalScrollBar yuG;
    private LinearLayout yuH;
    private int yuI = -1;
    private int yuJ = -1;
    private a.AbstractC1439a yuK = new a.AbstractC1439a() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.ipcall.model.a.AbstractC1439a
        public final void eac() {
            AppMethodBeat.i(25697);
            IPCallContactUI.this.hAk.sendEmptyMessage(1);
            AppMethodBeat.o(25697);
        }
    };
    private Runnable yuL = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(25700);
            if (!(IPCallContactUI.this.yuC == null || IPCallContactUI.this.yum == null || IPCallContactUI.this.yuC.poG)) {
                IPCallContactUI.this.yuC.SM(IPCallContactUI.this.kdi);
                IPCallContactUI.this.hAk.sendEmptyMessage(2);
                IPCallContactUI.this.yum.invalidateViews();
            }
            AppMethodBeat.o(25700);
        }
    };
    private boolean yuM = true;
    private ListView yum;
    private Runnable yut = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(25698);
            com.tencent.mm.plugin.ipcall.model.a.eab().a(IPCallContactUI.this.yuK, false);
            AppMethodBeat.o(25698);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallContactUI() {
        AppMethodBeat.i(25704);
        AppMethodBeat.o(25704);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25705);
        super.onCreate(bundle);
        setMMTitle(R.string.e5x);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25687);
                IPCallContactUI.this.finish();
                AppMethodBeat.o(25687);
                return true;
            }
        });
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (a2) {
            this.yuD = (RelativeLayout) findViewById(R.id.e95);
            this.yuE = (LinearLayout) findViewById(R.id.ht);
            this.yum = (ListView) findViewById(R.id.h1);
            this.yuG = (VerticalScrollBar) findViewById(R.id.hl);
            this.yuH = (LinearLayout) findViewById(R.id.hs);
            this.gzP.Qwi = new s.b() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnz() {
                    AppMethodBeat.i(25691);
                    Log.d("MicroMsg.IPCallContactUI", "onEnterSearch");
                    h.INSTANCE.a(12767, 1);
                    IPCallContactUI.this.yuE.setVisibility(0);
                    IPCallContactUI.this.yum.setVisibility(8);
                    IPCallContactUI.this.yuF.setVisibility(8);
                    IPCallContactUI.this.qz(false);
                    AppMethodBeat.o(25691);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bny() {
                    AppMethodBeat.i(25692);
                    Log.d("MicroMsg.IPCallContactUI", "onQuitSearch");
                    IPCallContactUI.this.SM("");
                    IPCallContactUI.this.qz(true);
                    IPCallContactUI.this.yuE.setVisibility(8);
                    IPCallContactUI.this.yum.setVisibility(0);
                    IPCallContactUI.this.yuF.setVisibility(0);
                    AppMethodBeat.o(25692);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void SO(String str) {
                    AppMethodBeat.i(25693);
                    Log.d("MicroMsg.IPCallContactUI", "onSearchChange");
                    IPCallContactUI.this.SM(str);
                    if (!Util.isNullOrNil(str)) {
                        IPCallContactUI.this.yuE.setVisibility(8);
                        IPCallContactUI.this.yum.setVisibility(0);
                        IPCallContactUI.this.yuF.setVisibility(8);
                    }
                    AppMethodBeat.o(25693);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final boolean SN(String str) {
                    AppMethodBeat.i(25694);
                    Log.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
                    AppMethodBeat.o(25694);
                    return false;
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnA() {
                    AppMethodBeat.i(25695);
                    IPCallContactUI.this.yuE.setVisibility(0);
                    IPCallContactUI.this.yum.setVisibility(8);
                    IPCallContactUI.this.yuF.setVisibility(8);
                    AppMethodBeat.o(25695);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnB() {
                }
            };
            this.gzP.Qwn = R.string.yn;
            addSearchMenu(true, this.gzP);
            this.yuC = new c(getContext());
            c.ysD = b.eaW();
            this.yuF = new IPCallAddressCountView(getContext(), this.yuC.ebe());
            this.yum.addFooterView(this.yuF, null, false);
            this.yum.setAdapter((ListAdapter) this.yuC);
            this.yum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass6 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(25696);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (IPCallContactUI.this.yuC.Ox(i2)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(25696);
                        return;
                    }
                    c Pg = IPCallContactUI.this.yuC.Pg(i2);
                    if (Pg != null) {
                        if (!IPCallContactUI.this.yuM) {
                            h.INSTANCE.a(12767, 2);
                        }
                        Intent intent = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
                        intent.putExtra("IPCallProfileUI_contactid", Pg.field_contactId);
                        intent.putExtra("IPCallProfileUI_systemUsername", Pg.field_systemAddressBookUsername);
                        intent.putExtra("IPCallProfileUI_wechatUsername", Pg.field_wechatUsername);
                        AppCompatActivity context = IPCallContactUI.this.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(25696);
                }
            });
            this.yuG.setVisibility(0);
            this.yum.setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass11 */
                private int vp = 0;

                public final void onScrollStateChanged(AbsListView absListView, int i2) {
                    AppMethodBeat.i(25701);
                    this.vp = i2;
                    IPCallContactUI.this.hideVKB();
                    AppMethodBeat.o(25701);
                }

                @TargetApi(11)
                public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                    AppMethodBeat.i(25702);
                    if (IPCallContactUI.this.yuI == -1) {
                        IPCallContactUI.this.yuI = i2;
                        AppMethodBeat.o(25702);
                        return;
                    }
                    if (IPCallContactUI.this.yuJ == -1) {
                        IPCallContactUI.this.yuJ = i2;
                    }
                    AppMethodBeat.o(25702);
                }
            });
            this.yuG.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass12 */

                @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
                public final void DP(String str) {
                    int i2;
                    AppMethodBeat.i(25703);
                    if ("↑".equals(str)) {
                        IPCallContactUI.this.yum.setSelection(0);
                        AppMethodBeat.o(25703);
                        return;
                    }
                    c cVar = IPCallContactUI.this.yuC;
                    if (cVar.gAI.containsKey(str)) {
                        i2 = cVar.gAI.get(str).intValue();
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        IPCallContactUI.this.yum.setSelection(i2);
                    }
                    AppMethodBeat.o(25703);
                }
            });
            if (this.yuC.ebe() <= 0) {
                this.yuD.setVisibility(8);
                AppCompatActivity context = getContext();
                getContext().getString(R.string.zb);
                this.yuB = com.tencent.mm.ui.base.h.a((Context) context, getContext().getString(R.string.e6h), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass9 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(25699);
                        IPCallContactUI.this.finish();
                        AppMethodBeat.o(25699);
                    }
                });
                ThreadPool.post(this.yut, "IPCall_LoadSystemAddressBook");
                AppMethodBeat.o(25705);
                return;
            }
            com.tencent.mm.plugin.ipcall.a.dZG().cmK();
        }
        AppMethodBeat.o(25705);
    }

    public final void SM(String str) {
        AppMethodBeat.i(25706);
        this.kdi = str;
        this.hAk.removeCallbacks(this.yuL);
        this.hAk.postDelayed(this.yuL, 200);
        AppMethodBeat.o(25706);
    }

    public final void qz(boolean z) {
        AppMethodBeat.i(25707);
        this.yuM = z;
        if (this.yuM) {
            this.yuC.notifyDataSetChanged();
        }
        AppMethodBeat.o(25707);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awi;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25708);
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.model.a eab = com.tencent.mm.plugin.ipcall.model.a.eab();
        a.AbstractC1439a aVar = this.yuK;
        if (eab.yos.contains(aVar)) {
            eab.yos.remove(aVar);
        }
        this.hAk.removeMessages(1);
        AppMethodBeat.o(25708);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25709);
        super.onResume();
        supportInvalidateOptionsMenu();
        AppMethodBeat.o(25709);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(25710);
        Log.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(25710);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(25711);
        super.onBackPressed();
        AppMethodBeat.o(25711);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25712);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25712);
            return;
        }
        Log.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25689);
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                            IPCallContactUI iPCallContactUI = IPCallContactUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallContactUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            iPCallContactUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallContactUI, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(25689);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25690);
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                            AppMethodBeat.o(25690);
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(25712);
    }
}
