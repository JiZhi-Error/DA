package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.b.a.kf;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;

@a(3)
public class RemittanceDetailUI extends WalletBaseUI {
    private String AOG;
    private String AOz;
    protected ImageView Cnb = null;
    private LinearLayout Cre;
    private String Crp = null;
    private int Crq;
    protected String Crw = null;
    protected TextView CuH = null;
    protected TextView CuI = null;
    protected TextView CuJ = null;
    protected TextView CuK = null;
    protected Button CuL = null;
    protected LinearLayout CuM;
    private LinearLayout CuN;
    private LinearLayout CuO;
    private LinearLayout CuP;
    private TextView CuQ;
    private TextView CuR;
    private TextView CuS;
    private TextView CuT;
    private TextView CuU;
    protected ViewGroup CuV;
    protected ImageView CuW;
    protected TextView CuX;
    protected TextView CuY;
    protected ImageView CuZ;
    private int CvA;
    private v CvB;
    private LinearLayout CvC;
    private LinearLayout CvD;
    private LinearLayout CvE;
    private LinearLayout CvF;
    private IListener<rp> CvG = new IListener<rp>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160846);
            this.__eventId = rp.class.getName().hashCode();
            AppMethodBeat.o(160846);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rp rpVar) {
            AppMethodBeat.i(68122);
            final rp rpVar2 = rpVar;
            if (!Util.isNullOrNil(rpVar2.dYf.dDM) && !Util.isNullOrNil(rpVar2.dYf.dQp)) {
                h.c(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(R.string.g2o, new Object[]{RemittanceDetailUI.bZ(RemittanceDetailUI.this.AOG, false)}), "", RemittanceDetailUI.this.getString(R.string.g2t), RemittanceDetailUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68121);
                        v vVar = new v(rpVar2.dYf.dDM, rpVar2.dYf.dQp, rpVar2.dYf.dYg, "refuse", rpVar2.dYf.dYh, rpVar2.dYf.dYi);
                        vVar.setProcessName("RemittanceProcess");
                        RemittanceDetailUI.this.doSceneProgress(vVar);
                        AppMethodBeat.o(68121);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(68122);
            return false;
        }
    };
    private IListener<ro> CvH = new IListener<ro>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass12 */

        {
            AppMethodBeat.i(160847);
            this.__eventId = ro.class.getName().hashCode();
            AppMethodBeat.o(160847);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ro roVar) {
            AppMethodBeat.i(68137);
            Log.i("MicroMsg.RemittanceDetailUI", "RemittanceDetailUIFinishEvent");
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass12.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(68136);
                    RemittanceDetailUI.this.finish();
                    AppMethodBeat.o(68136);
                }
            }, 500);
            AppMethodBeat.o(68137);
            return false;
        }
    };
    private int CvI = 0;
    protected Button Cva;
    protected TextView Cvb;
    protected TextView Cvc;
    protected View Cvd;
    protected View Cve;
    protected View Cvf;
    protected Button Cvg = null;
    protected TextView Cvh = null;
    protected LinearLayout Cvi;
    private LinearLayout Cvj;
    private LinearLayout Cvk;
    private LinearLayout Cvl;
    private LinearLayout Cvm;
    private TextView Cvn;
    private TextView Cvo;
    private TextView Cvp;
    private TextView Cvq;
    private TextView Cvr;
    protected int Cvs;
    protected int Cvt;
    public String Cvu = null;
    public String Cvv = null;
    protected String Cvw = null;
    protected int Cvx = 3;
    protected boolean Cvy = false;
    protected int Cvz;
    private int ppd;
    private int ppe;
    private com.tencent.mm.ui.widget.b.a pqr = null;
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass13 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(213801);
            String str = "";
            if (Util.isEqual(RemittanceDetailUI.this.CvI, (int) R.id.h16)) {
                str = RemittanceDetailUI.this.CuR.getText().toString().trim();
            } else if (Util.isEqual(RemittanceDetailUI.this.CvI, (int) R.id.h0f)) {
                StringBuilder sb = new StringBuilder();
                sb.append(RemittanceDetailUI.this.CuS.getText().toString().trim() + " ");
                String trim = RemittanceDetailUI.this.CuU.getText().toString().trim();
                if (trim.endsWith(RemittanceDetailUI.this.getString(R.string.g2_))) {
                    sb.append(trim.substring(0, trim.length() - 4));
                } else {
                    sb.append(trim);
                }
                str = sb.toString();
            } else if (Util.isEqual(RemittanceDetailUI.this.CvI, (int) R.id.h15)) {
                str = RemittanceDetailUI.this.Cvo.getText().toString().trim();
            } else if (Util.isEqual(RemittanceDetailUI.this.CvI, (int) R.id.h0g)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RemittanceDetailUI.this.Cvp.getText().toString().trim() + " ");
                String trim2 = RemittanceDetailUI.this.Cvr.getText().toString().trim();
                if (trim2.endsWith(RemittanceDetailUI.this.getString(R.string.g2_))) {
                    sb2.append(trim2.substring(0, trim2.length() - 4));
                } else {
                    sb2.append(trim2);
                }
                str = sb2.toString();
            }
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
            h.cD(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(R.string.ta));
            AppMethodBeat.o(213801);
        }
    };
    private View.OnTouchListener tia = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass14 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(213802);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceDetailUI.this.ppd = (int) motionEvent.getRawX();
                    RemittanceDetailUI.this.ppe = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(213802);
            return false;
        }
    };
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass15 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(213803);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$22", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.RemittanceDetailUI", "onLongClick");
            if (RemittanceDetailUI.this.pqr == null) {
                RemittanceDetailUI.this.pqr = new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext());
            }
            RemittanceDetailUI.this.pqr.a(view, RemittanceDetailUI.this, RemittanceDetailUI.this.rJj, RemittanceDetailUI.this.ppd, RemittanceDetailUI.this.ppe);
            RemittanceDetailUI.this.CvI = view.getId();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$22", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(213803);
            return true;
        }
    };
    protected TextView zcv = null;
    private c zdH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceDetailUI() {
        AppMethodBeat.i(68156);
        AppMethodBeat.o(68156);
    }

    static /* synthetic */ void a(RemittanceDetailUI remittanceDetailUI, Dialog dialog) {
        AppMethodBeat.i(213819);
        remittanceDetailUI.b(dialog);
        AppMethodBeat.o(213819);
    }

    static /* synthetic */ void a(RemittanceDetailUI remittanceDetailUI, v vVar) {
        AppMethodBeat.i(213821);
        remittanceDetailUI.a(vVar);
        AppMethodBeat.o(213821);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(213815);
        if (i2 != 4) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213815);
            return onKeyUp;
        } else if (this.CvB == null) {
            boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213815);
            return onKeyUp2;
        } else if (this.CvB.zdG == null) {
            boolean onKeyUp3 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213815);
            return onKeyUp3;
        } else if (!c.a(this.CvB.zdG)) {
            boolean onKeyUp4 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213815);
            return onKeyUp4;
        } else {
            this.zdH.a(this.CvB.zdG, new c.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass21 */

                @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
                public final void a(cfl cfl) {
                    AppMethodBeat.i(213808);
                    if (cfl.action == 1) {
                        RemittanceDetailUI.this.finish();
                        AppMethodBeat.o(213808);
                        return;
                    }
                    AppMethodBeat.o(213808);
                }
            });
            this.CvB.zdG = null;
            AppMethodBeat.o(213815);
            return true;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68157);
        super.onCreate(bundle);
        this.zdH = new c(this);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass22 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213810);
                if (RemittanceDetailUI.this.CvB == null) {
                    RemittanceDetailUI.this.finish();
                    AppMethodBeat.o(213810);
                } else if (RemittanceDetailUI.this.CvB.zdG == null) {
                    RemittanceDetailUI.this.finish();
                    AppMethodBeat.o(213810);
                } else if (!c.a(RemittanceDetailUI.this.CvB.zdG)) {
                    RemittanceDetailUI.this.finish();
                    AppMethodBeat.o(213810);
                } else {
                    RemittanceDetailUI.this.zdH.a(RemittanceDetailUI.this.CvB.zdG, new c.a() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass22.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
                        public final void a(cfl cfl) {
                            AppMethodBeat.i(213809);
                            if (cfl.action == 1) {
                                RemittanceDetailUI.this.finish();
                                AppMethodBeat.o(213809);
                                return;
                            }
                            AppMethodBeat.o(213809);
                        }
                    });
                    RemittanceDetailUI.this.CvB.zdG = null;
                    AppMethodBeat.o(213810);
                }
                return false;
            }
        });
        this.Cvs = getIntent().getIntExtra("invalid_time", 0);
        this.Cvt = getIntent().getIntExtra("appmsg_type", 0);
        this.Cvu = getIntent().getStringExtra(FirebaseAnalytics.b.TRANSACTION_ID);
        this.Cvw = getIntent().getStringExtra("bill_id");
        this.Crw = getIntent().getStringExtra("transfer_id");
        this.Cvv = getIntent().getStringExtra("sender_name");
        this.Cvx = getIntent().getIntExtra("effective_date", 3);
        this.Cvy = getIntent().getBooleanExtra("is_sender", false);
        this.Cvz = getIntent().getIntExtra("total_fee", 0);
        initView();
        Wg(0);
        getIntent();
        EventCenter.instance.addListener(this.CvG);
        this.CvH.alive();
        AppMethodBeat.o(68157);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68158);
        EventCenter.instance.removeListener(this.CvG);
        if (this.CvH != null) {
            this.CvH.dead();
        }
        super.onDestroy();
        AppMethodBeat.o(68158);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68159);
        Log.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2) {
            Wg(0);
        }
        AppMethodBeat.o(68159);
    }

    /* access modifiers changed from: protected */
    public void Wg(int i2) {
        AppMethodBeat.i(68160);
        doSceneProgress(new y(i2, this.Cvu, this.Crw, this.Cvs), true);
        AppMethodBeat.o(68160);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68161);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.Cnb = (ImageView) findViewById(R.id.h1f);
        this.CuH = (TextView) findViewById(R.id.h1p);
        this.CuI = (TextView) findViewById(R.id.h1j);
        this.CuL = (Button) findViewById(R.id.h1a);
        this.zcv = (TextView) findViewById(R.id.h1k);
        this.CuM = (LinearLayout) findViewById(R.id.h1c);
        this.CuN = (LinearLayout) findViewById(R.id.h23);
        this.CuO = (LinearLayout) findViewById(R.id.h14);
        this.Cre = (LinearLayout) findViewById(R.id.h0d);
        this.CuP = (LinearLayout) findViewById(R.id.h0f);
        this.CuQ = (TextView) findViewById(R.id.h19);
        this.CuR = (TextView) findViewById(R.id.h16);
        this.CuS = (TextView) findViewById(R.id.fth);
        this.CuT = (TextView) findViewById(R.id.ha);
        this.CuU = (TextView) findViewById(R.id.h_);
        this.CuV = (ViewGroup) findViewById(R.id.h2d);
        this.CuW = (ImageView) findViewById(R.id.h2f);
        this.CuX = (TextView) findViewById(R.id.h2h);
        this.CuY = (TextView) findViewById(R.id.h2i);
        this.CuZ = (ImageView) findViewById(R.id.h2c);
        this.Cva = (Button) findViewById(R.id.fz0);
        this.Cvb = (TextView) findViewById(R.id.h11);
        this.Cvc = (TextView) findViewById(R.id.h2b);
        this.Cvd = findViewById(R.id.h2g);
        this.Cve = findViewById(R.id.h24);
        this.Cvf = findViewById(R.id.h25);
        this.Cvg = (Button) findViewById(R.id.h1b);
        this.Cvh = (TextView) findViewById(R.id.h1l);
        this.Cvi = (LinearLayout) findViewById(R.id.h1m);
        this.Cvj = (LinearLayout) findViewById(R.id.h26);
        this.Cvk = (LinearLayout) findViewById(R.id.h17);
        this.Cvl = (LinearLayout) findViewById(R.id.h0h);
        this.Cvm = (LinearLayout) findViewById(R.id.h0g);
        this.Cvn = (TextView) findViewById(R.id.h18);
        this.Cvo = (TextView) findViewById(R.id.h15);
        this.Cvp = (TextView) findViewById(R.id.ftg);
        this.Cvq = (TextView) findViewById(R.id.h8);
        this.Cvr = (TextView) findViewById(R.id.h9);
        this.CuJ = (TextView) findViewById(R.id.h1r);
        this.CuK = (TextView) findViewById(R.id.h1s);
        this.CvC = (LinearLayout) findViewById(R.id.h1g);
        this.CvD = (LinearLayout) findViewById(R.id.h1d);
        this.CvE = (LinearLayout) findViewById(R.id.h1n);
        this.CvF = (LinearLayout) findViewById(R.id.h1o);
        AppMethodBeat.o(68161);
    }

    /* access modifiers changed from: protected */
    public void Wh(int i2) {
        com.tencent.mm.plugin.order.model.h hVar;
        AppMethodBeat.i(68162);
        if (!getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new com.tencent.mm.plugin.order.model.h(this.Crw, this.Cvw, i2);
        } else {
            hVar = new com.tencent.mm.plugin.order.model.h(this.Cvu, this.Cvw, i2);
        }
        hVar.setProcessName("RemittanceProcess");
        doSceneProgress(hVar);
        AppMethodBeat.o(68162);
    }

    /* access modifiers changed from: protected */
    public void aQ(Intent intent) {
        AppMethodBeat.i(68163);
        com.tencent.mm.br.c.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
        AppMethodBeat.o(68163);
    }

    /* access modifiers changed from: protected */
    public void eOg() {
        AppMethodBeat.i(68164);
        aMm("");
        AppMethodBeat.o(68164);
    }

    /* access modifiers changed from: protected */
    public final void aMm(String str) {
        AppMethodBeat.i(213816);
        v vVar = new v(this.Cvu, this.Crw, this.Cvz, "confirm", this.Cvv, this.Cvs, str);
        vVar.setProcessName("RemittanceProcess");
        doSceneProgress(vVar);
        AppMethodBeat.o(213816);
    }

    /* access modifiers changed from: protected */
    public void eOh() {
        AppMethodBeat.i(68165);
        v vVar = new v(this.Cvu, this.Crw, this.Cvz, "refuse", this.Cvv, this.Cvs);
        vVar.setProcessName("RemittanceProcess");
        doSceneProgress(vVar);
        AppMethodBeat.o(68165);
    }

    private void a(boolean z, boolean z2, final y yVar) {
        AppMethodBeat.i(68166);
        if (z) {
            this.CuM.setVisibility(8);
            this.CvE.setVisibility(8);
            this.Cvi.setVisibility(0);
            this.CvF.setVisibility(0);
            p.a((Context) this, (ScrollView) findViewById(R.id.h9a), findViewById(R.id.g8q), findViewById(R.id.h1_), findViewById(R.id.h1o), 72);
            if (!Util.isNullOrNil(yVar.CpY.Cqg)) {
                this.Cvj.setVisibility(0);
                if (!Util.isNullOrNil(yVar.desc)) {
                    this.Cvk.setVisibility(0);
                    this.Cvo.setText(yVar.desc);
                    this.Cvo.setOnLongClickListener(this.tib);
                    this.Cvo.setOnTouchListener(this.tia);
                } else {
                    this.Cvk.setVisibility(8);
                }
                if (!Util.isNullOrNil(yVar.CpY.Cqg)) {
                    this.Cvl.setVisibility(0);
                    this.Cvp.setText(yVar.CpY.Cqg + "  " + yVar.CpY.kik);
                    this.Cvn.post(new Runnable() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(213792);
                            int m = RemittanceResultNewUI.m(RemittanceDetailUI.this, yVar.CpY.iUO, RemittanceDetailUI.this.Cvn.getWidth());
                            if (!Util.isEqual(m, yVar.CpY.iUO.length())) {
                                String string = RemittanceDetailUI.this.getString(R.string.g2a);
                                String str = yVar.CpY.iUO.substring(0, m) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                com.tencent.mm.plugin.order.c.a aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213790);
                                        RemittanceDetailUI.this.Cvq.setVisibility(8);
                                        RemittanceDetailUI.this.Cvr.setVisibility(0);
                                        p.a((Context) RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.h9a), RemittanceDetailUI.this.findViewById(R.id.g8q), RemittanceDetailUI.this.findViewById(R.id.h1_), RemittanceDetailUI.this.findViewById(R.id.h1q), 72);
                                        AppMethodBeat.o(213790);
                                    }
                                };
                                spannableString.setSpan(aVar, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.Cvq.setOnTouchListener(a.eNB());
                                RemittanceDetailUI.this.Cvq.setText(spannableString);
                                String string2 = RemittanceDetailUI.this.getString(R.string.g2_);
                                String str2 = yVar.CpY.iUO + "  ";
                                SpannableString spannableString2 = new SpannableString(str2 + string2);
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar2.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass3.AnonymousClass2 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213791);
                                        RemittanceDetailUI.this.Cvq.setVisibility(0);
                                        RemittanceDetailUI.this.Cvr.setVisibility(8);
                                        p.a((Context) RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.h9a), RemittanceDetailUI.this.findViewById(R.id.g8q), RemittanceDetailUI.this.findViewById(R.id.h1_), RemittanceDetailUI.this.findViewById(R.id.h1q), 72);
                                        AppMethodBeat.o(213791);
                                    }
                                };
                                spannableString2.setSpan(aVar2, str2.length(), string2.length() + str2.length(), 33);
                                RemittanceDetailUI.this.Cvr.setOnTouchListener(a.eNB());
                                RemittanceDetailUI.this.Cvr.setText(spannableString2);
                            } else {
                                RemittanceDetailUI.this.Cvq.setText(yVar.CpY.iUO);
                                RemittanceDetailUI.this.Cvr.setText(yVar.CpY.iUO);
                            }
                            RemittanceDetailUI.this.Cvq.setVisibility(0);
                            RemittanceDetailUI.this.Cvr.setVisibility(8);
                            RemittanceDetailUI.this.Cvm.setOnLongClickListener(RemittanceDetailUI.this.tib);
                            RemittanceDetailUI.this.Cvm.setOnTouchListener(RemittanceDetailUI.this.tia);
                            AppMethodBeat.o(213792);
                        }
                    });
                } else {
                    this.Cvl.setVisibility(8);
                }
            } else {
                this.Cvj.setVisibility(8);
            }
        } else {
            this.CuM.setVisibility(0);
            this.CvE.setVisibility(0);
            this.Cvi.setVisibility(8);
            this.CvF.setVisibility(8);
            if (!Util.isNullOrNil(yVar.CpY.Cqg)) {
                this.CuN.setVisibility(0);
                if (!Util.isNullOrNil(yVar.desc)) {
                    this.CuO.setVisibility(0);
                    this.CuR.setText(yVar.desc);
                    this.CuR.setOnLongClickListener(this.tib);
                    this.CuR.setOnTouchListener(this.tia);
                } else {
                    this.CuO.setVisibility(8);
                }
                if (!Util.isNullOrNil(yVar.CpY.Cqg)) {
                    this.Cre.setVisibility(0);
                    this.CuS.setText(yVar.CpY.Cqg + "  " + yVar.CpY.kik);
                    this.CuQ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(213795);
                            int m = RemittanceResultNewUI.m(RemittanceDetailUI.this, yVar.CpY.iUO, RemittanceDetailUI.this.CuQ.getWidth());
                            if (!Util.isEqual(m, yVar.CpY.iUO.length())) {
                                String string = RemittanceDetailUI.this.getString(R.string.g2a);
                                String str = yVar.CpY.iUO.substring(0, m) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                com.tencent.mm.plugin.order.c.a aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass4.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213793);
                                        RemittanceDetailUI.this.CuT.setVisibility(8);
                                        RemittanceDetailUI.this.CuU.setVisibility(0);
                                        p.a((Context) RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.h9a), RemittanceDetailUI.this.findViewById(R.id.g8q), RemittanceDetailUI.this.findViewById(R.id.h1_), RemittanceDetailUI.this.findViewById(R.id.h1q), 72);
                                        AppMethodBeat.o(213793);
                                    }
                                };
                                spannableString.setSpan(aVar, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.CuT.setOnTouchListener(a.eNB());
                                RemittanceDetailUI.this.CuT.setText(spannableString);
                                String string2 = RemittanceDetailUI.this.getString(R.string.g2_);
                                String str2 = yVar.CpY.iUO + "  ";
                                SpannableString spannableString2 = new SpannableString(str2 + string2);
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar2.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass4.AnonymousClass2 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213794);
                                        RemittanceDetailUI.this.CuT.setVisibility(0);
                                        RemittanceDetailUI.this.CuU.setVisibility(8);
                                        p.a((Context) RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.h9a), RemittanceDetailUI.this.findViewById(R.id.g8q), RemittanceDetailUI.this.findViewById(R.id.h1_), RemittanceDetailUI.this.findViewById(R.id.h1q), 72);
                                        AppMethodBeat.o(213794);
                                    }
                                };
                                spannableString2.setSpan(aVar2, str2.length(), string2.length() + str2.length(), 33);
                                RemittanceDetailUI.this.CuU.setOnTouchListener(a.eNB());
                                RemittanceDetailUI.this.CuU.setText(spannableString2);
                            } else {
                                RemittanceDetailUI.this.CuT.setText(yVar.CpY.iUO);
                                RemittanceDetailUI.this.CuU.setText(yVar.CpY.iUO);
                            }
                            RemittanceDetailUI.this.CuT.setVisibility(0);
                            RemittanceDetailUI.this.CuU.setVisibility(8);
                            RemittanceDetailUI.this.CuP.setOnLongClickListener(RemittanceDetailUI.this.tib);
                            RemittanceDetailUI.this.CuP.setOnTouchListener(RemittanceDetailUI.this.tia);
                            AppMethodBeat.o(213795);
                        }
                    });
                } else {
                    this.Cre.setVisibility(8);
                }
            } else {
                this.Cve.setVisibility(8);
                this.CuO.setVisibility(8);
                this.Cre.setVisibility(8);
                this.Cvf.setVisibility(8);
                this.CuN.setVisibility(8);
            }
        }
        if (!z2 || Util.isNullOrNil(yVar.CpZ.icon)) {
            this.Cvf.setVisibility(8);
            this.CuV.setVisibility(8);
            this.Cvd.setVisibility(8);
        } else {
            this.CuM.setVisibility(0);
            this.CvE.setVisibility(0);
            this.CuN.setVisibility(0);
            this.Cvf.setVisibility(0);
            this.CuV.setVisibility(0);
            this.Cvd.setVisibility(0);
            com.tencent.mm.av.a.a.bdb().loadImage(yVar.CpZ.icon, this.CuW);
            this.CuX.setText(yVar.CpZ.name);
            this.CuY.setText(yVar.CpZ.dQx);
            if (yVar.CpZ.Cqh > 0) {
                this.Cva.setText(yVar.CpZ.Cqi);
                this.CuZ.setVisibility(8);
                this.Cva.setVisibility(0);
                this.Cva.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68128);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        RemittanceDetailUI.a(RemittanceDetailUI.this, yVar.CpZ.Cqj, yVar, 11);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68128);
                    }
                });
                f.aZ(this.Cva, 200);
            } else {
                this.CuZ.setVisibility(0);
                this.Cva.setVisibility(8);
                this.CuZ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68129);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        RemittanceDetailUI.a(RemittanceDetailUI.this, yVar.CpZ.Cqj, yVar, 11);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68129);
                    }
                });
                this.CuV.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68130);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        RemittanceDetailUI.a(RemittanceDetailUI.this, yVar.CpZ.Cqj, yVar, 11);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68130);
                    }
                });
            }
        }
        if (Util.isNullOrNil(yVar.Cqa.dQx)) {
            this.Cvb.setVisibility(8);
        } else {
            this.Cvb.setText(yVar.Cqa.dQx);
            this.Cvb.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213796);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RemittanceDetailUI.a(RemittanceDetailUI.this, yVar.Cqa.Cqj, yVar, 12);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213796);
                }
            });
            this.Cvb.setVisibility(0);
        }
        this.Cvc.setVisibility(8);
        a(yVar);
        p.a((Context) this, (ScrollView) findViewById(R.id.h9a), findViewById(R.id.g8q), findViewById(R.id.h1_), findViewById(R.id.h1q), 72);
        AppMethodBeat.o(68166);
    }

    private void b(Dialog dialog) {
        AppMethodBeat.i(68167);
        if (dialog != null) {
            dialog.dismiss();
        }
        Intent intent = new Intent(this, WalletLqtDetailUI.class);
        intent.putExtra("key_account_type", 0);
        startActivityForResult(intent, 2);
        AppMethodBeat.o(68167);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(68168);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.t_));
        AppMethodBeat.o(68168);
    }

    private void eNL() {
        AppMethodBeat.i(68169);
        if (this.CvA == 0 || this.Crq != 1 || Util.isNullOrNil(this.Crp)) {
            Log.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", Integer.valueOf(this.CvA), Boolean.valueOf(Util.isNullOrNil(this.Crp)));
            removeAllOptionMenu();
            AppMethodBeat.o(68169);
            return;
        }
        addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass16 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213804);
                f.p(RemittanceDetailUI.this.getContext(), RemittanceDetailUI.this.Crp, false);
                AppMethodBeat.o(213804);
                return false;
            }
        });
        AppMethodBeat.o(68169);
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0868  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0898  */
    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
        /*
        // Method dump skipped, instructions count: 2804
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):boolean");
    }

    private void a(v vVar) {
        AppMethodBeat.i(68171);
        if ("confirm".equals(vVar.CoU)) {
            Wg(1);
            AppMethodBeat.o(68171);
            return;
        }
        bY(0, getResources().getString(R.string.g2j));
        AppMethodBeat.o(68171);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmq;
    }

    /* access modifiers changed from: protected */
    public final void bY(int i2, String str) {
        AppMethodBeat.i(68172);
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(68172);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(68173);
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.CvB == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, (q) this.CvB, bundle, true, 1008)) {
            super.finish();
            AppMethodBeat.o(68173);
            return;
        }
        this.CvB = null;
        AppMethodBeat.o(68173);
    }

    public static String bZ(String str, boolean z) {
        AppMethodBeat.i(68174);
        String displayName = f.getDisplayName(str);
        if (displayName == null) {
            AppMethodBeat.o(68174);
            return "";
        }
        if (displayName.length() > 10 && z) {
            displayName = displayName.substring(0, 8) + "...";
        }
        AppMethodBeat.o(68174);
        return displayName;
    }

    private void a(y yVar) {
        AppMethodBeat.i(213817);
        ArrayList<y.b> arrayList = yVar.Cqd;
        if (arrayList == null || arrayList.size() == 0) {
            this.CvD.setVisibility(8);
            Log.i("MicroMsg.RemittanceDetailUI", "mDescItemList == null || mDescItemList.size() ==0");
            AppMethodBeat.o(213817);
            return;
        }
        this.CvC.removeAllViews();
        this.CvD.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.CvD.getLayoutParams();
        if (!Util.isNullOrNil(this.zcv.getText())) {
            this.zcv.setVisibility(0);
        } else {
            this.zcv.setVisibility(8);
        }
        if (this.zcv.getVisibility() == 0) {
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 32);
            this.CvD.setLayoutParams(layoutParams);
        } else {
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 48);
            this.CvD.setLayoutParams(layoutParams);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            y.b bVar = arrayList.get(i2);
            if (bVar != null) {
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.bmp, (ViewGroup) this.CvC, false);
                ((TextView) linearLayout.findViewById(R.id.h1i)).setText(bVar.title);
                ((TextView) linearLayout.findViewById(R.id.h1e)).setText(bVar.content);
                this.CvC.addView(linearLayout);
            }
        }
        AppMethodBeat.o(213817);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(RemittanceDetailUI remittanceDetailUI, y.d dVar, y yVar, int i2) {
        AppMethodBeat.i(213818);
        Log.i("MicroMsg.RemittanceDetailUI", "jump() jumpInfo=%s", dVar.toString());
        kf kfVar = new kf();
        kfVar.erW = 31;
        kfVar.ejA = (long) i2;
        kfVar.ete = (long) yVar.status;
        kfVar.eUe = kfVar.x("TransferId", yVar.CpQ, true);
        kfVar.bfK();
        switch (dVar.type) {
            case 1:
                com.tencent.mm.plugin.account.a.b.a.b(remittanceDetailUI, dVar.url, 0, true);
                AppMethodBeat.o(213818);
                return;
            case 2:
                wq wqVar = new wq();
                wqVar.ecI.userName = dVar.username;
                wqVar.ecI.ecK = dVar.Cqk;
                wqVar.ecI.scene = 1034;
                wqVar.ecI.ecL = 0;
                EventCenter.instance.publish(wqVar);
                AppMethodBeat.o(213818);
                return;
            case 3:
                final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(remittanceDetailUI, false, null);
                if (!Util.isNullOrNil(dVar.url) && (dVar.url.startsWith("weixin://wcpay/lqt/detail") || dVar.url.equals("qryusrfunddetail"))) {
                    ag.parseUrl(dVar.url);
                    s.fOg();
                    if (s.fOh().Hwc == null) {
                        Log.i("MicroMsg.RemittanceDetailUI", "publish WalletGetUserInfoEvent");
                        zv zvVar = new zv();
                        zvVar.efR.scene = 1;
                        zvVar.efR.efT = true;
                        zvVar.efR.efU = true;
                        zvVar.efS.efJ = new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass9 */
                            boolean iMQ = false;

                            public final void run() {
                                AppMethodBeat.i(213797);
                                Log.i("MicroMsg.RemittanceDetailUI", "WalletGetUserInfoEvent callback() hasCallback:%s", Boolean.valueOf(this.iMQ));
                                if (!this.iMQ) {
                                    RemittanceDetailUI.a(RemittanceDetailUI.this, c2);
                                }
                                this.iMQ = true;
                                AppMethodBeat.o(213797);
                            }
                        };
                        EventCenter.instance.asyncPublish(zvVar, Looper.myLooper());
                        AppMethodBeat.o(213818);
                        return;
                    }
                    remittanceDetailUI.b(c2);
                    AppMethodBeat.o(213818);
                    return;
                } else if (Util.isNullOrNil(dVar.url) || (!dVar.url.startsWith("weixin://wcpay/lqt/save") && !dVar.url.equals("purchasefund"))) {
                    if (c2 != null) {
                        c2.dismiss();
                        break;
                    }
                } else {
                    ag.parseUrl(dVar.url);
                    final String aUI = ag.aUI(dVar.url);
                    final w wVar = (w) new com.tencent.mm.vending.app.c().a(remittanceDetailUI, w.class);
                    if (wVar == null || wVar.HtU == null) {
                        Log.i("MicroMsg.RemittanceDetailUI", "fetchDetail() interactorGlueApi == null || interactorGlueApi.fetchLqtDetail == null");
                        AppMethodBeat.o(213818);
                        return;
                    }
                    wVar.HtU.bmq().f(new com.tencent.mm.vending.c.a<Void, dhn>() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass11 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(dhn dhn) {
                            AppMethodBeat.i(213800);
                            final dhn dhn2 = dhn;
                            if (dhn2 != null) {
                                Log.i("MicroMsg.RemittanceDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(dhn2.yba), Boolean.valueOf(dhn2.MMe));
                                wVar.HtX.jP(dhn2.yba, 2);
                                s.fOg();
                                if (s.fOh().Hwc == null) {
                                    Log.i("MicroMsg.RemittanceDetailUI", "publish WalletGetUserInfoEvent");
                                    zv zvVar = new zv();
                                    zvVar.efR.scene = 1;
                                    zvVar.efR.efT = true;
                                    zvVar.efR.efU = true;
                                    zvVar.efS.efJ = new Runnable() {
                                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass11.AnonymousClass1 */
                                        boolean iMQ = false;

                                        public final void run() {
                                            AppMethodBeat.i(213799);
                                            Log.i("MicroMsg.RemittanceDetailUI", "WalletGetUserInfoEvent callback() hasCallback:%s", Boolean.valueOf(this.iMQ));
                                            if (!this.iMQ) {
                                                RemittanceDetailUI.a(RemittanceDetailUI.this, dhn2, c2, aUI);
                                            }
                                            this.iMQ = true;
                                            AppMethodBeat.o(213799);
                                        }
                                    };
                                    EventCenter.instance.asyncPublish(zvVar, Looper.myLooper());
                                } else {
                                    RemittanceDetailUI.a(RemittanceDetailUI.this, dhn2, c2, aUI);
                                }
                            } else {
                                Log.i("MicroMsg.RemittanceDetailUI", "fetch detail failed");
                            }
                            Void r0 = QZL;
                            AppMethodBeat.o(213800);
                            return r0;
                        }
                    }).a(new d.a() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.AnonymousClass10 */

                        @Override // com.tencent.mm.vending.g.d.a
                        public final void cn(Object obj) {
                            String string;
                            AppMethodBeat.i(213798);
                            if (c2 != null) {
                                c2.dismiss();
                            }
                            Log.i("MicroMsg.RemittanceDetailUI", "fetch detail failed: %s", obj);
                            if (obj != null) {
                                if (obj instanceof String) {
                                    string = obj.toString();
                                } else {
                                    string = RemittanceDetailUI.this.getString(R.string.ih4);
                                }
                                Toast.makeText(RemittanceDetailUI.this, string, 1).show();
                            }
                            AppMethodBeat.o(213798);
                        }
                    });
                    AppMethodBeat.o(213818);
                    return;
                }
                break;
        }
        AppMethodBeat.o(213818);
    }

    static /* synthetic */ void a(RemittanceDetailUI remittanceDetailUI, dhn dhn, Dialog dialog, String str) {
        boolean z = true;
        AppMethodBeat.i(213820);
        Log.i("MicroMsg.RemittanceDetailUI", "goWalletLqtSaveFetchUI()");
        if (dialog != null) {
            dialog.dismiss();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (dhn.MLV != null && dhn.MLV.size() > 0) {
            Iterator<ahq> it = dhn.MLV.iterator();
            while (it.hasNext()) {
                ahq next = it.next();
                if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                    arrayList.add(String.format("%s||%s", next.title, next.yUB));
                }
            }
        }
        Intent intent = new Intent(remittanceDetailUI, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fund_code", dhn.Mnl);
        intent.putExtra("lqt_account_type", dhn.yba);
        intent.putExtra("lqt_fund_spid", dhn.Mnk);
        intent.putExtra("lqt_save_fetch_mode", 1);
        intent.putExtra("lqt_is_show_protocol", dhn.egj == 1);
        if (dhn.MLU != 1) {
            z = false;
        }
        intent.putExtra("lqt_is_agree_protocol", z);
        intent.putExtra("operate_id", str);
        intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
        intent.putExtra("lqt_profile_wording", dhn.MLJ);
        remittanceDetailUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(213820);
    }
}
