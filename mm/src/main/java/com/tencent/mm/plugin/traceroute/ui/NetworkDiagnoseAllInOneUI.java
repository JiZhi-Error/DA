package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public class NetworkDiagnoseAllInOneUI extends MMActivity implements View.OnClickListener {
    private int GrC;
    private TextView GrD;
    private TextView GrE;
    private TextView GrF;
    private TextView GrG;
    private q GrH;
    private int GrI;
    private String GrJ;
    private IListener<nk> GrK;
    private boolean GrL;
    private boolean GrM;
    private boolean GrN;
    private MTimerHandler cve;
    private ImageView dKU;
    private b.a gmA;
    private Button hPX;
    private boolean uSu;
    private d yNv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        AppMethodBeat.i(29693);
        networkDiagnoseAllInOneUI.bpn();
        AppMethodBeat.o(29693);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29685);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.dq, R.anim.s);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.GrC = intent.getIntExtra("diagnose_state", 0);
        this.GrI = intent.getIntExtra("diagnose_percent", 1);
        this.GrJ = intent.getStringExtra("diagnose_kvInfo");
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", Integer.valueOf(this.GrC), Integer.valueOf(this.GrI), this.GrJ);
        if (this.GrC == 0) {
            this.GrC = 1;
            Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            bg.azz().a(new bu(new bu.a() {
                /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass4 */

                @Override // com.tencent.mm.model.bu.a
                public final void a(g gVar) {
                    AppMethodBeat.i(29682);
                    if (gVar == null) {
                        AppMethodBeat.o(29682);
                        return;
                    }
                    try {
                        gVar.aZk();
                        AppMethodBeat.o(29682);
                    } catch (Exception e2) {
                        AppMethodBeat.o(29682);
                    }
                }
            }), 0);
        }
        this.hPX = (Button) findViewById(R.id.bpv);
        this.GrD = (TextView) findViewById(R.id.bpt);
        this.GrE = (TextView) findViewById(R.id.bps);
        this.dKU = (ImageView) findViewById(R.id.bpx);
        this.GrF = (TextView) findViewById(R.id.bpy);
        this.GrG = (TextView) findViewById(R.id.bpu);
        this.GrD.setOnClickListener(this);
        this.hPX.setOnClickListener(this);
        this.GrE.setOnClickListener(this);
        bpn();
        this.GrK = new IListener<nk>() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass1 */

            {
                AppMethodBeat.i(161458);
                this.__eventId = nk.class.getName().hashCode();
                AppMethodBeat.o(161458);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(nk nkVar) {
                int i2;
                boolean z = true;
                AppMethodBeat.i(29677);
                nk nkVar2 = nkVar;
                Log.v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", Integer.valueOf(nkVar2.dTy.dTz), Integer.valueOf(nkVar2.dTy.status));
                if (nkVar2.dTy.dTz == 0) {
                    NetworkDiagnoseAllInOneUI.this.GrI = 33;
                    NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.GrL = z;
                } else if (nkVar2.dTy.dTz == 1) {
                    NetworkDiagnoseAllInOneUI.this.GrI = 66;
                    NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI2 = NetworkDiagnoseAllInOneUI.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI2.GrM = z;
                } else if (nkVar2.dTy.dTz == 2) {
                    NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI3 = NetworkDiagnoseAllInOneUI.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI3.GrN = z;
                }
                final int i3 = NetworkDiagnoseAllInOneUI.this.GrC;
                if (nkVar2.dTy.dTA) {
                    NetworkDiagnoseAllInOneUI.this.GrI = 100;
                    i2 = 1000;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(29675);
                            NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                            AppMethodBeat.o(29675);
                        }
                    });
                    NetworkDiagnoseAllInOneUI.this.GrJ = nkVar2.dTy.dTB;
                    if (NetworkDiagnoseAllInOneUI.this.GrL) {
                        i3 = 2;
                    } else if (NetworkDiagnoseAllInOneUI.this.GrM) {
                        i3 = 4;
                    } else if (NetworkDiagnoseAllInOneUI.this.GrN) {
                        i3 = 5;
                    } else {
                        i3 = 3;
                    }
                } else {
                    i2 = 0;
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(29676);
                        NetworkDiagnoseAllInOneUI.this.GrC = i3;
                        NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                        AppMethodBeat.o(29676);
                    }
                }, (long) i2);
                AppMethodBeat.o(29677);
                return false;
            }
        };
        EventCenter.instance.add(this.GrK);
        this.gmA = new b.a() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass2 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                String str;
                AppMethodBeat.i(29680);
                Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", Boolean.valueOf(z));
                if (NetworkDiagnoseAllInOneUI.this.yNv != null) {
                    NetworkDiagnoseAllInOneUI.this.yNv.c(NetworkDiagnoseAllInOneUI.this.gmA);
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(29678);
                        NetworkDiagnoseAllInOneUI.this.hPX.setEnabled(true);
                        if (NetworkDiagnoseAllInOneUI.this.GrH != null && NetworkDiagnoseAllInOneUI.this.GrH.isShowing()) {
                            NetworkDiagnoseAllInOneUI.this.GrH.dismiss();
                        }
                        NetworkDiagnoseAllInOneUI.this.GrC = 6;
                        NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                        AppMethodBeat.o(29678);
                    }
                });
                String unused = NetworkDiagnoseAllInOneUI.this.GrJ;
                if (z) {
                    str = (String.valueOf(f3) + "-" + String.valueOf(f2)) + "," + NetworkDiagnoseAllInOneUI.this.GrJ;
                } else {
                    if (!NetworkDiagnoseAllInOneUI.this.uSu && !d.bcc()) {
                        NetworkDiagnoseAllInOneUI.this.uSu = true;
                        h.a((Context) NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(R.string.dvi), NetworkDiagnoseAllInOneUI.this.getString(R.string.zb), NetworkDiagnoseAllInOneUI.this.getString(R.string.e_k), NetworkDiagnoseAllInOneUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass2.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(29679);
                                d.cZ(NetworkDiagnoseAllInOneUI.this);
                                AppMethodBeat.o(29679);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    }
                    Log.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
                    str = "," + NetworkDiagnoseAllInOneUI.this.GrJ;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14533, str);
                AppMethodBeat.o(29680);
                return false;
            }
        };
        this.cve = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(29681);
                NetworkDiagnoseAllInOneUI.this.GrI++;
                Log.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", Integer.valueOf(NetworkDiagnoseAllInOneUI.this.GrI));
                if (NetworkDiagnoseAllInOneUI.this.GrI > 99) {
                    AppMethodBeat.o(29681);
                    return false;
                }
                if (NetworkDiagnoseAllInOneUI.this.GrC == 1) {
                    NetworkDiagnoseAllInOneUI.this.GrF.setText(NetworkDiagnoseAllInOneUI.this.getString(R.string.bm8, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.this.GrI)}));
                }
                AppMethodBeat.o(29681);
                return true;
            }
        }, true);
        if (this.GrC == 0 || this.GrC == 1) {
            this.cve.startTimer(1000);
        }
        AppMethodBeat.o(29685);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(29686);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(29686);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bfo;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void bpn() {
        AppMethodBeat.i(29687);
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", Integer.valueOf(this.GrC));
        switch (this.GrC) {
            case 0:
            case 1:
                this.dKU.setImageResource(R.raw.network_diagnose_work);
                this.GrF.setText(getString(R.string.bm8, new Object[]{Integer.valueOf(this.GrI)}));
                this.GrG.setText(R.string.bm0);
                this.hPX.setVisibility(4);
                this.GrE.setVisibility(4);
                AppMethodBeat.o(29687);
                return;
            case 2:
                this.dKU.setImageResource(R.raw.network_diagnose_work);
                this.GrF.setText(R.string.bmb);
                this.GrG.setText(R.string.bm3);
                this.hPX.setVisibility(0);
                this.GrE.setVisibility(4);
                AppMethodBeat.o(29687);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", R.string.fbd);
                intent.putExtra("rawUrl", getString(R.string.fba));
                intent.putExtra("showShare", false);
                c.b(this, "webview", ".ui.tools.WebViewUI", intent);
                wz(false);
                finish();
                AppMethodBeat.o(29687);
                return;
            case 4:
                this.dKU.setImageResource(R.raw.network_diagnose_fail);
                this.GrF.setText(R.string.bma);
                this.GrG.setText(R.string.bm1);
                this.hPX.setVisibility(0);
                this.hPX.setText(R.string.blx);
                this.GrE.setVisibility(0);
                AppMethodBeat.o(29687);
                return;
            case 5:
                this.dKU.setImageResource(R.raw.network_diagnose_fail);
                this.GrF.setText(R.string.bm9);
                this.GrG.setText(R.string.bm1);
                this.hPX.setVisibility(0);
                this.hPX.setText(R.string.blx);
                this.GrE.setVisibility(0);
                AppMethodBeat.o(29687);
                return;
            case 6:
                this.dKU.setImageResource(R.raw.network_diagnose_feedback);
                this.GrF.setText(R.string.bm_);
                this.GrG.setText(R.string.bm2);
                this.hPX.setVisibility(0);
                this.hPX.setText(R.string.blw);
                this.GrE.setVisibility(4);
                break;
        }
        AppMethodBeat.o(29687);
    }

    private void cxh() {
        AppMethodBeat.i(29688);
        if (this.yNv == null) {
            this.yNv = d.bca();
        }
        this.yNv.a(this.gmA, true);
        AppMethodBeat.o(29688);
    }

    private void wz(boolean z) {
        AppMethodBeat.i(29689);
        if (Util.isNullOrNil(this.GrJ)) {
            AppMethodBeat.o(29689);
            return;
        }
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", Boolean.valueOf(z));
        if (z) {
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 71, "", "")) {
                getString(R.string.zb);
                this.GrH = h.a((Context) this, getString(R.string.bmd), true, (DialogInterface.OnCancelListener) null);
                this.hPX.setEnabled(false);
                cxh();
            }
            AppMethodBeat.o(29689);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14533, "," + this.GrJ);
        AppMethodBeat.o(29689);
    }

    public void onClick(View view) {
        AppMethodBeat.i(29690);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if ((this.GrC == 5 || this.GrC == 4) && view == this.hPX) {
            wz(true);
        } else {
            wz(false);
            finish();
        }
        a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29690);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29691);
        super.onDestroy();
        EventCenter.instance.removeListener(this.GrK);
        if (this.yNv != null) {
            this.yNv.c(this.gmA);
            this.yNv = null;
        }
        if (this.cve != null) {
            this.cve.stopTimer();
            this.cve = null;
        }
        AppMethodBeat.o(29691);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(29692);
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 71:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.fl1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29683);
                            NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            a.a(networkDiagnoseAllInOneUI, bl.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            networkDiagnoseAllInOneUI.startActivity((Intent) bl.pG(0));
                            a.a(networkDiagnoseAllInOneUI, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(29683);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29684);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(29684);
                        }
                    });
                    break;
                } else {
                    wz(true);
                    AppMethodBeat.o(29692);
                    return;
                }
        }
        AppMethodBeat.o(29692);
    }
}
