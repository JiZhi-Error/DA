package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

public class NetworkDiagnoseUI extends MMActivity {
    private final int Gsd = 100;
    private int Gse = 0;
    private a Gsf;
    private MMProgressBar Gsg;
    private MTimerHandler Gsh = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29706);
            NetworkDiagnoseUI.this.Gse = NetworkDiagnoseUI.this.zAY + 1;
            NetworkDiagnoseUI.this.zAY = NetworkDiagnoseUI.this.Gse;
            if (NetworkDiagnoseUI.this.Gse < 100) {
                NetworkDiagnoseUI.this.Gsg.setProgress(NetworkDiagnoseUI.this.Gse);
                AppMethodBeat.o(29706);
                return true;
            }
            NetworkDiagnoseUI.this.Gsg.setProgress(100);
            AppMethodBeat.o(29706);
            return false;
        }
    }, true);
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass2 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29707);
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                    if (NetworkDiagnoseUI.this.Gse < 95) {
                        NetworkDiagnoseUI.this.Gsg.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.Gsf.fAb();
                    AppMethodBeat.o(29707);
                    return;
                case 2:
                    if (NetworkDiagnoseUI.this.Gse < 95) {
                        NetworkDiagnoseUI.this.Gsg.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.Gsf.fAb();
                    AppMethodBeat.o(29707);
                    return;
                case 3:
                    NetworkDiagnoseUI.this.Gsg.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, false);
                    AppMethodBeat.o(29707);
                    return;
                case 4:
                    NetworkDiagnoseUI.this.Gsg.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, true);
                    break;
            }
            AppMethodBeat.o(29707);
        }
    };
    private TextView tjP;
    private int zAY = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NetworkDiagnoseUI() {
        AppMethodBeat.i(29717);
        AppMethodBeat.o(29717);
    }

    static /* synthetic */ void g(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(29726);
        networkDiagnoseUI.fAg();
        AppMethodBeat.o(29726);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29718);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29718);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29719);
        this.tjP = (TextView) findViewById(R.id.h3f);
        this.Gsg = (MMProgressBar) findViewById(R.id.bpw);
        this.Gsg.setOnProgressChangedListener(new MMProgressBar.a() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMProgressBar.a
            public final void acg(int i2) {
                AppMethodBeat.i(29708);
                if (i2 < 5) {
                    NetworkDiagnoseUI.this.tjP.setText(NetworkDiagnoseUI.this.getString(R.string.b9m));
                    AppMethodBeat.o(29708);
                } else if (i2 < 5 || i2 >= 95) {
                    NetworkDiagnoseUI.this.tjP.setText(NetworkDiagnoseUI.this.getString(R.string.hti));
                    AppMethodBeat.o(29708);
                } else {
                    NetworkDiagnoseUI.this.tjP.setText(NetworkDiagnoseUI.this.getString(R.string.dvc));
                    AppMethodBeat.o(29708);
                }
            }
        });
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29709);
                NetworkDiagnoseUI.g(NetworkDiagnoseUI.this);
                AppMethodBeat.o(29709);
                return true;
            }
        });
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(29710);
                NetworkDiagnoseUI.h(NetworkDiagnoseUI.this);
                AppMethodBeat.o(29710);
            }
        }, 200);
        AppMethodBeat.o(29719);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bfr;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29720);
        this.Gsg.setAutoProgress(false);
        super.onPause();
        AppMethodBeat.o(29720);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29721);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            u.g(this, null);
            AppMethodBeat.o(29721);
            return;
        }
        this.Gsg.setAutoProgress(true);
        super.onResume();
        AppMethodBeat.o(29721);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(29722);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            fAg();
            AppMethodBeat.o(29722);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(29722);
        return onKeyDown;
    }

    private void fAg() {
        AppMethodBeat.i(29723);
        h.a(this, (int) R.string.b90, (int) R.string.bly, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(29716);
                NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                NetworkDiagnoseUI.this.finish();
                AppMethodBeat.o(29716);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(29723);
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(29724);
        networkDiagnoseUI.Gsh.stopTimer();
        if (networkDiagnoseUI.Gsf != null) {
            networkDiagnoseUI.Gsf.stop();
        }
        AppMethodBeat.o(29724);
    }

    static /* synthetic */ void a(NetworkDiagnoseUI networkDiagnoseUI, boolean z) {
        AppMethodBeat.i(29725);
        Intent intent = new Intent(networkDiagnoseUI, NetworkDiagnoseReportUI.class);
        intent.putExtra("diagnose_result", z);
        if (!z) {
            intent.putExtra("diagnose_log_file_path", a.Grg);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(networkDiagnoseUI, bl.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseUI", "redirectToReportUI", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        networkDiagnoseUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(networkDiagnoseUI, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseUI", "redirectToReportUI", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        networkDiagnoseUI.finish();
        AppMethodBeat.o(29725);
    }

    static /* synthetic */ void h(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(29727);
        bg.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass6 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(29715);
                if (gVar == null) {
                    AppMethodBeat.o(29715);
                    return;
                }
                String aTY = z.aTY();
                NetworkDiagnoseUI.this.Gsf = new a(aTY);
                NetworkDiagnoseUI.this.Gsf.c(gVar.getIPsString(true), true);
                NetworkDiagnoseUI.this.Gsf.c(gVar.getIPsString(false), false);
                NetworkDiagnoseUI.this.Gsf.Grn = new a.d() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass6.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.traceroute.b.a.d
                    public final void onFinished() {
                        AppMethodBeat.i(29711);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(2, 500);
                        AppMethodBeat.o(29711);
                    }
                };
                NetworkDiagnoseUI.this.Gsf.Grm = new a.e() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass6.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.traceroute.b.a.e
                    public final void fAf() {
                        AppMethodBeat.i(29712);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(1, 500);
                        AppMethodBeat.o(29712);
                    }
                };
                NetworkDiagnoseUI.this.Gsf.Grp = new a.b() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass6.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.traceroute.b.a.b
                    public final void fAd() {
                        AppMethodBeat.i(29713);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessage(3);
                        AppMethodBeat.o(29713);
                    }
                };
                NetworkDiagnoseUI.this.Gsf.Gro = new a.c() {
                    /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.AnonymousClass6.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.traceroute.b.a.c
                    public final void fAe() {
                        AppMethodBeat.i(29714);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessage(4);
                        AppMethodBeat.o(29714);
                    }
                };
                a aVar = NetworkDiagnoseUI.this.Gsf;
                if (aVar.Grl == null || aVar.Grl.size() == 0) {
                    Log.e("MicroMsg.MMTraceRoute", "no iplist");
                } else {
                    if (a.Grh == null) {
                        a.Grh = new com.tencent.mm.plugin.traceroute.b.c();
                    }
                    ThreadPool.post(new a.j(aVar, (byte) 0), "MMTraceRoute_start");
                }
                NetworkDiagnoseUI.this.Gsh.startTimer(1200);
                AppMethodBeat.o(29715);
            }
        }), 0);
        AppMethodBeat.o(29727);
    }
}
