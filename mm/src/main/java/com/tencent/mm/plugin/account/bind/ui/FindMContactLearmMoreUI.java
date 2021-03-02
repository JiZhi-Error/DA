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
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String dSf;
    private ProgressDialog gtM = null;
    private String gwF = null;
    private String kbO = "";
    private int kbP = 2;
    private List<String[]> kbT = null;
    private aj kbU;
    private Button kcl;
    private TextView kcm;
    private i onSceneEndCallback = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.i(110064);
        findMContactLearmMoreUI.bns();
        AppMethodBeat.o(110064);
    }

    static /* synthetic */ void b(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.i(110065);
        findMContactLearmMoreUI.bnm();
        AppMethodBeat.o(110065);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110055);
        super.onCreate(bundle);
        this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
        AppMethodBeat.o(110055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110056);
        if (this.onSceneEndCallback != null) {
            g.azz().b(431, this.onSceneEndCallback);
            this.onSceneEndCallback = null;
        }
        super.onDestroy();
        AppMethodBeat.o(110056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110057);
        super.onResume();
        a.bxk("R300_100_phone");
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.aAf();
        a.j(true, append.append(com.tencent.mm.kernel.a.FN("RE300_600")).append(",1").toString());
        AppMethodBeat.o(110057);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(110058);
        super.onPause();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.aAf();
        a.j(false, append.append(com.tencent.mm.kernel.a.FN("RE300_600")).append(",2").toString());
        AppMethodBeat.o(110058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110059);
        setMMTitle(R.string.cg9);
        this.kcl = (Button) findViewById(R.id.g3k);
        this.kcm = (TextView) findViewById(R.id.aib);
        this.kcl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(110046);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.gl(true);
                ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
                FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110046);
            }
        });
        this.kcm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(110047);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.gl(false);
                ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
                FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110047);
            }
        });
        g.aAh().azQ().set(12323, Boolean.TRUE);
        this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        }
        AppMethodBeat.o(110059);
    }

    private void bns() {
        AppMethodBeat.i(110060);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (!a2) {
            AppMethodBeat.o(110060);
            return;
        }
        t azz = g.azz();
        AnonymousClass3 r2 = new i() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass3 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                boolean z;
                int i4;
                int i5;
                AppMethodBeat.i(110048);
                if (FindMContactLearmMoreUI.this.gtM != null) {
                    FindMContactLearmMoreUI.this.gtM.dismiss();
                    FindMContactLearmMoreUI.this.gtM = null;
                }
                if (FindMContactLearmMoreUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactLearmMoreUI.this.onSceneEndCallback);
                    FindMContactLearmMoreUI.this.onSceneEndCallback = null;
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
                    Log.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", objArr);
                    if (FindMContactLearmMoreUI.this.kbO == null || !FindMContactLearmMoreUI.this.kbO.contains("1") || !z) {
                        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                        AppMethodBeat.o(110048);
                        return;
                    }
                    a.bxl("R300_300_phone");
                    Intent intent = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.this.kbP);
                    intent.putExtra("login_type", 0);
                    MMWizardActivity.ay(FindMContactLearmMoreUI.this, intent);
                    AppMethodBeat.o(110048);
                    return;
                }
                Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(R.string.u5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                AppMethodBeat.o(110048);
            }
        };
        this.onSceneEndCallback = r2;
        azz.a(431, r2);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(110049);
                if (FindMContactLearmMoreUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactLearmMoreUI.this.onSceneEndCallback);
                    FindMContactLearmMoreUI.this.onSceneEndCallback = null;
                }
                AppMethodBeat.o(110049);
            }
        });
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(110050);
                if (FindMContactLearmMoreUI.this.kbT == null || FindMContactLearmMoreUI.this.kbT.size() == 0) {
                    if (FindMContactLearmMoreUI.this.gtM != null) {
                        FindMContactLearmMoreUI.this.gtM.dismiss();
                        FindMContactLearmMoreUI.this.gtM = null;
                    }
                    FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                } else {
                    FindMContactLearmMoreUI.this.kbU = new aj(FindMContactLearmMoreUI.this.gwF, FindMContactLearmMoreUI.this.kbT);
                    g.azz().a(FindMContactLearmMoreUI.this.kbU, 0);
                }
                AppMethodBeat.o(110050);
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(110051);
                try {
                    FindMContactLearmMoreUI.this.kbT = com.tencent.mm.pluginsdk.b.dO(FindMContactLearmMoreUI.this);
                    Log.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.this.kbT == null ? 0 : FindMContactLearmMoreUI.this.kbT.size()));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e2, "", new Object[0]);
                }
                AppMethodBeat.o(110051);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(110052);
                String str = super.toString() + "|doUpload";
                AppMethodBeat.o(110052);
                return str;
            }
        });
        ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        AppMethodBeat.o(110060);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(110061);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(110061);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(110061);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(110062);
        hideVKB();
        ala(1);
        AppMethodBeat.o(110062);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.alf;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110063);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(110063);
            return;
        }
        Log.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110053);
                            dialogInterface.dismiss();
                            FindMContactLearmMoreUI findMContactLearmMoreUI = FindMContactLearmMoreUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactLearmMoreUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            findMContactLearmMoreUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactLearmMoreUI, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(110053);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(110054);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(110054);
                        }
                    });
                    break;
                } else {
                    bns();
                    AppMethodBeat.o(110063);
                    return;
                }
        }
        AppMethodBeat.o(110063);
    }
}
