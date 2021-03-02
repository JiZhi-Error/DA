package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI extends MMWizardActivity {
    private String dSf;
    private ProgressDialog gtM = null;
    private String gwF = null;
    private String kbO = "";
    private int kbP = 2;
    private boolean kbS = false;
    private List<String[]> kbT = null;
    private aj kbU;
    private String kbV;
    private Button kcg;
    private TextView kch;
    private TextView kci;
    private i onSceneEndCallback = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(110044);
        findMContactIntroUI.bnm();
        AppMethodBeat.o(110044);
    }

    static /* synthetic */ void f(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(110045);
        findMContactIntroUI.bns();
        AppMethodBeat.o(110045);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(110034);
        super.onCreate(bundle);
        setMMTitle(R.string.cg0);
        a.jRu.Xc();
        this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (l.bnZ() != l.a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.kbS = z;
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        Log.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.kbO, Integer.valueOf(this.kbP));
        AppMethodBeat.o(110034);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110035);
        if (this.onSceneEndCallback != null) {
            g.azz().b(431, this.onSceneEndCallback);
            this.onSceneEndCallback = null;
        }
        super.onDestroy();
        AppMethodBeat.o(110035);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110036);
        super.onResume();
        initView();
        if (this.kbS) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R300_100_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R300_100_QQ");
            AppMethodBeat.o(110036);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("R300_100_phone")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("R300_100_phone");
        AppMethodBeat.o(110036);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(110037);
        super.onPause();
        com.tencent.mm.plugin.b.a.bxl("RE900_100");
        if (this.kbS) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_100_QQ")).append(",4").toString());
            AppMethodBeat.o(110037);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("R300_100_phone")).append(",4").toString());
        AppMethodBeat.o(110037);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110038);
        this.kcg = (Button) findViewById(R.id.hlv);
        this.kci = (TextView) findViewById(R.id.d4h);
        this.kch = (TextView) findViewById(R.id.d4g);
        if (this.kbO == null || !this.kbO.contains("2")) {
            this.kch.setText(getString(R.string.cfh));
        } else {
            this.kch.setText(getString(R.string.cfg));
        }
        this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        }
        this.kcg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(110020);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FindMContactIntroUI.a(FindMContactIntroUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110020);
            }
        });
        this.kci.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(110024);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.c(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.string.cfx), null, FindMContactIntroUI.this.getString(R.string.cfy), FindMContactIntroUI.this.getString(R.string.cfw), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass4.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(110023);
                        FindMContactIntroUI.b(FindMContactIntroUI.this);
                        AppMethodBeat.o(110023);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass4.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110024);
            }
        });
        AppMethodBeat.o(110038);
    }

    private void bns() {
        AppMethodBeat.i(110039);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (!a2) {
            AppMethodBeat.o(110039);
            return;
        }
        t azz = g.azz();
        AnonymousClass9 r2 = new i() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass9 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                boolean z;
                int i4;
                int i5;
                AppMethodBeat.i(110029);
                if (FindMContactIntroUI.this.gtM != null) {
                    FindMContactIntroUI.this.gtM.dismiss();
                    FindMContactIntroUI.this.gtM = null;
                }
                if (FindMContactIntroUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactIntroUI.this.onSceneEndCallback);
                    FindMContactIntroUI.this.onSceneEndCallback = null;
                }
                if (i2 == 0 && i3 == 0) {
                    LinkedList<cik> bor = ((aj) qVar).bor();
                    ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(bor);
                    if (bor == null || bor.size() <= 0) {
                        z = false;
                        i4 = 0;
                    } else {
                        Iterator<cik> it = bor.iterator();
                        i4 = 0;
                        while (it.hasNext()) {
                            cik next = it.next();
                            if (next != null) {
                                if (next.oTW == 1) {
                                    i5 = i4 + 1;
                                } else {
                                    i5 = i4;
                                }
                                i4 = i5;
                            }
                        }
                        z = i4 > 0;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(bor == null ? 0 : bor.size());
                    objArr[1] = Integer.valueOf(i4);
                    Log.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", objArr);
                    if (FindMContactIntroUI.this.kbO == null || !FindMContactIntroUI.this.kbO.contains("1") || !z) {
                        FindMContactIntroUI.b(FindMContactIntroUI.this);
                        AppMethodBeat.o(110029);
                        return;
                    }
                    com.tencent.mm.plugin.b.a.bxl("R300_300_phone");
                    Intent intent = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.kbP);
                    intent.putExtra("login_type", 0);
                    MMWizardActivity.ay(FindMContactIntroUI.this, intent);
                    AppMethodBeat.o(110029);
                    return;
                }
                Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.string.u5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                AppMethodBeat.o(110029);
            }
        };
        this.onSceneEndCallback = r2;
        azz.a(431, r2);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(110030);
                if (FindMContactIntroUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactIntroUI.this.onSceneEndCallback);
                    FindMContactIntroUI.this.onSceneEndCallback = null;
                }
                AppMethodBeat.o(110030);
            }
        });
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass11 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(110031);
                if (FindMContactIntroUI.this.kbT == null || FindMContactIntroUI.this.kbT.size() == 0) {
                    if (FindMContactIntroUI.this.gtM != null) {
                        FindMContactIntroUI.this.gtM.dismiss();
                        FindMContactIntroUI.this.gtM = null;
                    }
                    FindMContactIntroUI.b(FindMContactIntroUI.this);
                } else {
                    FindMContactIntroUI.this.kbU = new aj(FindMContactIntroUI.this.gwF, FindMContactIntroUI.this.kbT);
                    g.azz().a(FindMContactIntroUI.this.kbU, 0);
                }
                AppMethodBeat.o(110031);
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(110032);
                try {
                    FindMContactIntroUI.this.kbT = com.tencent.mm.pluginsdk.b.dO(FindMContactIntroUI.this);
                    Log.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.this.kbT == null ? 0 : FindMContactIntroUI.this.kbT.size()));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FindMContactIntroUI", e2, "", new Object[0]);
                }
                AppMethodBeat.o(110032);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(110033);
                String str = super.toString() + "|doUpload";
                AppMethodBeat.o(110033);
                return str;
            }
        });
        AppMethodBeat.o(110039);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(110040);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(110040);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(110040);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(110041);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        hideVKB();
        ala(1);
        AppMethodBeat.o(110041);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ale;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110042);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(110042);
            return;
        }
        Log.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110021);
                            dialogInterface.dismiss();
                            FindMContactIntroUI findMContactIntroUI = FindMContactIntroUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactIntroUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            findMContactIntroUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactIntroUI, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(110021);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110022);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(110022);
                        }
                    });
                    break;
                } else {
                    bns();
                    AppMethodBeat.o(110042);
                    return;
                }
        }
        AppMethodBeat.o(110042);
    }

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(110043);
        if (findMContactIntroUI.kbS) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",1").toString());
            h.a(findMContactIntroUI, (int) R.string.cfj, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110025);
                    l.gl(true);
                    com.tencent.mm.plugin.b.a.bxl("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.kbP);
                    a.jRt.a(FindMContactIntroUI.this, intent);
                    com.tencent.mm.plugin.b.a.bxl("R300_300_phone");
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactIntroUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",2").toString());
                    AppMethodBeat.o(110025);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110026);
                    l.gl(false);
                    AppMethodBeat.o(110026);
                }
            });
            AppMethodBeat.o(110043);
        } else if (l.bnY()) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append2.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",1").toString());
            h.a(findMContactIntroUI, (int) R.string.cfj, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110027);
                    l.gl(true);
                    FindMContactIntroUI.f(FindMContactIntroUI.this);
                    AppMethodBeat.o(110027);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110028);
                    l.gl(false);
                    AppMethodBeat.o(110028);
                }
            });
            AppMethodBeat.o(110043);
        } else {
            findMContactIntroUI.bns();
            AppMethodBeat.o(110043);
        }
    }
}
