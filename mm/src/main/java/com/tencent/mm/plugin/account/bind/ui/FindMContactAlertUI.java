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
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private int X = 0;
    private int Y = 0;
    private String dSf;
    private ProgressDialog gtM = null;
    private String gwF = null;
    private String jxR;
    private String kbO = "";
    private int kbP = 2;
    private String kbQ = null;
    private String kbR = null;
    private boolean kbS = false;
    private List<String[]> kbT = null;
    private aj kbU;
    private String kbV;
    private String kbW;
    private int kbX = 0;
    private final int kbY = 200;
    private int kbZ = 0;
    private int kca = 0;
    private int kcb = 0;
    private int kcc = 0;
    private i onSceneEndCallback = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View a(FindMContactAlertUI findMContactAlertUI, ViewGroup viewGroup) {
        AppMethodBeat.i(110016);
        View e2 = findMContactAlertUI.e(viewGroup);
        AppMethodBeat.o(110016);
        return e2;
    }

    static /* synthetic */ void d(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(110014);
        findMContactAlertUI.bnm();
        AppMethodBeat.o(110014);
    }

    static /* synthetic */ void e(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(110015);
        findMContactAlertUI.bns();
        AppMethodBeat.o(110015);
    }

    static /* synthetic */ void j(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(110019);
        findMContactAlertUI.bnq();
        AppMethodBeat.o(110019);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110000);
        super.onCreate(bundle);
        setMMTitle(R.string.cg0);
        a.jRu.Xc();
        this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.kbQ = getIntent().getStringExtra("alert_title");
        this.kbR = getIntent().getStringExtra("alert_message");
        this.kbS = l.bnZ() != l.a.SUCC;
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        Log.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.kbO, Integer.valueOf(this.kbP));
        if (isFinishing()) {
            AppMethodBeat.o(110000);
            return;
        }
        initView();
        bnq();
        AppMethodBeat.o(110000);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110001);
        Log.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.onSceneEndCallback != null) {
            g.azz().b(431, this.onSceneEndCallback);
            this.onSceneEndCallback = null;
        }
        super.onDestroy();
        AppMethodBeat.o(110001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110002);
        super.onResume();
        if (this.kbS) {
            com.tencent.mm.plugin.b.a.bxk("R300_100_QQ");
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R300_100_QQ")).append(",1").toString());
            AppMethodBeat.o(110002);
            return;
        }
        com.tencent.mm.plugin.b.a.bxk("R300_100_phone");
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("RE300_100")).append(",1").toString());
        AppMethodBeat.o(110002);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(110003);
        super.onPause();
        if (this.kbS) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_100_QQ")).append(",2").toString());
            AppMethodBeat.o(110003);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("RE300_100")).append(",2").toString());
        AppMethodBeat.o(110003);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110004);
        this.jxR = getString(R.string.cfk);
        this.kbW = getString(R.string.cfj);
        if (!Util.isNullOrNil(this.kbQ)) {
            this.jxR = this.kbQ;
        }
        if (!Util.isNullOrNil(this.kbR)) {
            this.kbW = this.kbR;
        }
        this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        }
        AppMethodBeat.o(110004);
    }

    private d a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(110005);
        d dVar = new d(this, (byte) 0);
        dVar.setTitle(str2);
        dVar.setMessage(str);
        dVar.a(R.string.cg7, onClickListener);
        dVar.b(R.string.cg2, onClickListener2);
        dVar.bT(-1, true);
        dVar.setCancelable(false);
        dVar.show();
        dVar.getWindow().clearFlags(2);
        addDialog(dVar);
        AppMethodBeat.o(110005);
        return dVar;
    }

    private void bnq() {
        AppMethodBeat.i(110006);
        if (this.kbS) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_200_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",1").toString());
            h.a((Context) this, false, getString(R.string.cfj), getString(R.string.zb), getString(R.string.x_), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109987);
                    l.gl(true);
                    com.tencent.mm.plugin.b.a.bxl("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.kbP);
                    a.jRt.a(FindMContactAlertUI.this, intent);
                    com.tencent.mm.plugin.b.a.bxl("R300_300_phone");
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",2").toString());
                    AppMethodBeat.o(109987);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109990);
                    l.gl(false);
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R300_200_phone")).append(",2").toString());
                    FindMContactAlertUI.d(FindMContactAlertUI.this);
                    AppMethodBeat.o(109990);
                }
            });
            AppMethodBeat.o(110006);
        } else if (l.bnY()) {
            a(a(this.kbW, this.jxR, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109991);
                    l.gl(true);
                    FindMContactAlertUI.e(FindMContactAlertUI.this);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(109991);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109992);
                    Intent intent = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.kbP);
                    MMWizardActivity.ay(FindMContactAlertUI.this, intent);
                    AppMethodBeat.o(109992);
                }
            }));
            AppMethodBeat.o(110006);
        } else {
            bns();
            AppMethodBeat.o(110006);
        }
    }

    private void a(final d dVar) {
        AppMethodBeat.i(110007);
        dVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass7 */

            public final void onGlobalLayout() {
                int i2;
                AppMethodBeat.i(109993);
                dVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredWidth = dVar.getWindow().getDecorView().getMeasuredWidth();
                int measuredHeight = dVar.getWindow().getDecorView().getMeasuredHeight();
                View a2 = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup) dVar.getWindow().getDecorView());
                if (a2 != null) {
                    i2 = a2.getMeasuredWidth() * 2;
                } else {
                    i2 = measuredWidth;
                }
                Log.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(i2), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.a(FindMContactAlertUI.this, i2, measuredHeight);
                AppMethodBeat.o(109993);
            }
        });
        final View findViewById = findViewById(R.id.y1);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass8 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(109994);
                findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredHeight = findViewById.getMeasuredHeight();
                int measuredWidth = findViewById.getMeasuredWidth();
                Log.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.b(FindMContactAlertUI.this, measuredWidth, measuredHeight);
                AppMethodBeat.o(109994);
            }
        });
        AppMethodBeat.o(110007);
    }

    private View e(ViewGroup viewGroup) {
        View e2;
        AppMethodBeat.i(110008);
        if (this.kbX >= 200) {
            AppMethodBeat.o(110008);
            return null;
        }
        this.kbX++;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof Button) {
                AppMethodBeat.o(110008);
                return childAt;
            } else if ((childAt instanceof ViewGroup) && (e2 = e((ViewGroup) childAt)) != null) {
                AppMethodBeat.o(110008);
                return e2;
            }
        }
        AppMethodBeat.o(110008);
        return null;
    }

    private void bnr() {
        AppMethodBeat.i(110009);
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.kcb - (getResources().getDimensionPixelSize(R.dimen.iy) + com.tencent.mm.cb.a.fromDPToPix((Context) this, 48));
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this, 20) + (((height / 2) + (this.kca / 2)) - (height - this.kcc));
        if (!(dimensionPixelSize == this.X && fromDPToPix == this.Y)) {
            this.X = dimensionPixelSize;
            this.Y = fromDPToPix;
            View findViewById = findViewById(R.id.d4e);
            findViewById.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            Log.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ai));
        }
        AppMethodBeat.o(110009);
    }

    private void bns() {
        AppMethodBeat.i(110010);
        boolean a2 = b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (!a2) {
            AppMethodBeat.o(110010);
            return;
        }
        View findViewById = findViewById(R.id.d4e);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        t azz = g.azz();
        AnonymousClass9 r2 = new i() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass9 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                boolean z;
                int i4;
                int i5;
                AppMethodBeat.i(109995);
                if (FindMContactAlertUI.this.gtM != null) {
                    FindMContactAlertUI.this.gtM.dismiss();
                    FindMContactAlertUI.this.gtM = null;
                }
                if (FindMContactAlertUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactAlertUI.this.onSceneEndCallback);
                    FindMContactAlertUI.this.onSceneEndCallback = null;
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
                    Log.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", objArr);
                    if (FindMContactAlertUI.this.kbO == null || !FindMContactAlertUI.this.kbO.contains("1") || !z) {
                        FindMContactAlertUI.d(FindMContactAlertUI.this);
                        AppMethodBeat.o(109995);
                        return;
                    }
                    com.tencent.mm.plugin.b.a.bxl("R300_300_phone");
                    Intent intent = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.gwF);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.kbO);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.kbP);
                    intent.putExtra("login_type", 0);
                    MMWizardActivity.ay(FindMContactAlertUI.this, intent);
                    AppMethodBeat.o(109995);
                    return;
                }
                Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(R.string.u5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                FindMContactAlertUI.d(FindMContactAlertUI.this);
                AppMethodBeat.o(109995);
            }
        };
        this.onSceneEndCallback = r2;
        azz.a(431, r2);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(109996);
                if (FindMContactAlertUI.this.onSceneEndCallback != null) {
                    g.azz().b(431, FindMContactAlertUI.this.onSceneEndCallback);
                    FindMContactAlertUI.this.onSceneEndCallback = null;
                    FindMContactAlertUI.j(FindMContactAlertUI.this);
                }
                AppMethodBeat.o(109996);
            }
        });
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass11 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(109997);
                if (FindMContactAlertUI.this.kbT == null || FindMContactAlertUI.this.kbT.size() == 0) {
                    if (FindMContactAlertUI.this.gtM != null) {
                        FindMContactAlertUI.this.gtM.dismiss();
                        FindMContactAlertUI.this.gtM = null;
                    }
                    FindMContactAlertUI.d(FindMContactAlertUI.this);
                } else {
                    FindMContactAlertUI.this.kbU = new aj(FindMContactAlertUI.this.gwF, FindMContactAlertUI.this.kbT);
                    g.azz().a(FindMContactAlertUI.this.kbU, 0);
                }
                AppMethodBeat.o(109997);
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(109998);
                try {
                    FindMContactAlertUI.this.kbT = com.tencent.mm.pluginsdk.b.dO(FindMContactAlertUI.this);
                    Log.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.this.kbT == null ? 0 : FindMContactAlertUI.this.kbT.size()));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FindMContactAlertUI", e2, "", new Object[0]);
                }
                AppMethodBeat.o(109998);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(109999);
                String str = super.toString() + "|doUpload";
                AppMethodBeat.o(109999);
                return str;
            }
        });
        ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11438, 1);
        Log.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", 11438, 1);
        AppMethodBeat.o(110010);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(110011);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(110011);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(110011);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(110012);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        hideVKB();
        ala(1);
        AppMethodBeat.o(110012);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.alg;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110013);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(110013);
            return;
        }
        Log.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(109988);
                            dialogInterface.dismiss();
                            FindMContactAlertUI findMContactAlertUI = FindMContactAlertUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactAlertUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/FindMContactAlertUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            findMContactAlertUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(findMContactAlertUI, "com/tencent/mm/plugin/account/bind/ui/FindMContactAlertUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(109988);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(109989);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(109989);
                        }
                    });
                    break;
                } else {
                    bns();
                    AppMethodBeat.o(110013);
                    return;
                }
        }
        AppMethodBeat.o(110013);
    }

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i2, int i3) {
        AppMethodBeat.i(110017);
        findMContactAlertUI.kbZ = i2;
        findMContactAlertUI.kca = i3;
        if (findMContactAlertUI.kcb > 0 && findMContactAlertUI.kcc > 0) {
            findMContactAlertUI.bnr();
        }
        AppMethodBeat.o(110017);
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i2, int i3) {
        AppMethodBeat.i(110018);
        findMContactAlertUI.kcb = i2;
        findMContactAlertUI.kcc = i3;
        if (findMContactAlertUI.kbZ > 0 && findMContactAlertUI.kca > 0) {
            findMContactAlertUI.bnr();
        }
        AppMethodBeat.o(110018);
    }
}
