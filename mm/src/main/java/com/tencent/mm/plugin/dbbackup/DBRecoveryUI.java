package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBRecoveryUI extends MMActivity implements a.b {
    private static final int[] qDw = {0, 5, 60, 75, 95, 100, 100};
    private ProgressBar krF;
    private View mQo;
    private int mScene;
    private a qDp;
    private View qDq;
    private TextView qDr;
    private View qDs;
    private int qDt;
    private boolean qDu;
    private DialogInterface.OnClickListener qDv = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass1 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(23052);
            if (DBRecoveryUI.this.mScene != 0) {
                DBRecoveryUI.this.qDq.setVisibility(0);
                DBRecoveryUI.this.mQo.setVisibility(8);
                AppMethodBeat.o(23052);
                return;
            }
            d.cAZ();
            AppMethodBeat.o(23052);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public DBRecoveryUI() {
        AppMethodBeat.i(23063);
        AppMethodBeat.o(23063);
    }

    static /* synthetic */ void d(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.i(23074);
        dBRecoveryUI.cAQ();
        AppMethodBeat.o(23074);
    }

    static /* synthetic */ void e(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.i(23075);
        dBRecoveryUI.cAR();
        AppMethodBeat.o(23075);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23064);
        super.onCreate(bundle);
        this.mScene = getIntent().getIntExtra("scene", 2);
        this.qDu = false;
        setMMTitle(R.string.bkb);
        this.qDq = findViewById(R.id.i4p);
        this.mQo = findViewById(R.id.bst);
        this.krF = (ProgressBar) findViewById(R.id.gl_);
        this.qDr = (TextView) findViewById(R.id.glo);
        findViewById(R.id.i4e).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(23054);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (g.aAh().azL() == null) {
                    h.n(DBRecoveryUI.this, R.string.bkg, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23054);
                    return;
                }
                if (DBRecoveryUI.this.mScene != 0) {
                    h.a((Context) DBRecoveryUI.this, (int) R.string.bk_, 0, (int) R.string.bkk, (int) R.string.bkc, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(23053);
                            e.INSTANCE.idkeyStat(873, 25, 1, false);
                            DBRecoveryUI.d(DBRecoveryUI.this);
                            AppMethodBeat.o(23053);
                        }
                    }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
                } else {
                    DBRecoveryUI.d(DBRecoveryUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(23054);
            }
        });
        this.qDs = findViewById(R.id.aib);
        this.qDs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(23055);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                DBRecoveryUI.e(DBRecoveryUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(23055);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23056);
                if (DBRecoveryUI.this.qDu) {
                    DBRecoveryUI.e(DBRecoveryUI.this);
                } else {
                    DBRecoveryUI.this.finish();
                }
                AppMethodBeat.o(23056);
                return true;
            }
        });
        if (this.mScene == 0) {
            cAQ();
        }
        e.INSTANCE.idkeyStat(181, (long) (this.mScene + 51), 1, true);
        e.INSTANCE.idkeyStat(873, 14, 1, false);
        if (this.mScene == 2) {
            e.INSTANCE.idkeyStat(873, 15, 1, false);
        }
        AppMethodBeat.o(23064);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(23065);
        if (this.qDu) {
            cAR();
            AppMethodBeat.o(23065);
            return;
        }
        finish();
        AppMethodBeat.o(23065);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.z0;
    }

    private void cAQ() {
        boolean z;
        AppMethodBeat.i(23066);
        if (this.qDp != null) {
            Log.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            AppMethodBeat.o(23066);
            return;
        }
        this.qDq.setVisibility(8);
        this.mQo.setVisibility(0);
        this.qDs.setEnabled(true);
        StringBuilder append = new StringBuilder().append(q.dr(true));
        g.aAf();
        byte[] bytes = com.tencent.mm.b.g.getMessageDigest(append.append(com.tencent.mm.kernel.a.getUin()).toString().getBytes()).substring(0, 7).getBytes();
        String azL = g.aAh().azL();
        String path = g.aAh().hqK.getPath();
        this.qDt = 0;
        String str = g.aAh().hqG + "dbback/";
        a.C0942a aVar = new a.C0942a();
        aVar.qED = this;
        a.C0942a bm = aVar.bl(bytes).bm(bytes);
        bm.qEB = new a.d() {
            /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass5 */
            private int qDA = com.tencent.mm.kernel.a.getUin();
            private Collection<String> qDz;

            {
                AppMethodBeat.i(23057);
                g.aAf();
                AppMethodBeat.o(23057);
            }

            private void cAT() {
                AppMethodBeat.i(23058);
                if (this.qDz == null) {
                    this.qDz = com.tencent.mm.plugin.dbbackup.a.b.cBj();
                }
                AppMethodBeat.o(23058);
            }

            @Override // com.tencent.mm.plugin.dbbackup.a.a.d
            public final Collection<byte[]> cAU() {
                AppMethodBeat.i(23059);
                cAT();
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = this.qDz.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.mm.b.g.Q((it.next() + this.qDA).getBytes()));
                }
                AppMethodBeat.o(23059);
                return arrayList;
            }

            @Override // com.tencent.mm.plugin.dbbackup.a.a.d
            public final Collection<byte[]> cAV() {
                AppMethodBeat.i(23060);
                cAT();
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = this.qDz.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.mm.b.g.getMessageDigest((it.next() + this.qDA).getBytes()).substring(0, 7).getBytes());
                }
                AppMethodBeat.o(23060);
                return arrayList;
            }
        };
        bm.qEt = azL;
        bm.qEs = path;
        bm.qEr = path + "-recovery";
        bm.qEu = g.aAh().cachePath + "heavyDetailInfo";
        if (this.mScene == 0) {
            z = true;
        } else {
            z = false;
        }
        bm.qEC = z;
        this.qDp = bm.akU(azL + ".sm").akV(azL + ".bak").akU(str + "corrupted/EnMicroMsg.db.sm").akV(str + "corrupted/EnMicroMsg.db.bak").akU(str + "EnMicroMsg.db.sm").akV(str + "EnMicroMsg.db.bak").cBi();
        this.qDp.execute(new Void[0]);
        this.qDu = true;
        AppMethodBeat.o(23066);
    }

    private void cAR() {
        AppMethodBeat.i(23067);
        this.qDs.setEnabled(false);
        if (this.qDp != null) {
            this.qDp.cancel();
            this.qDp = null;
            AppMethodBeat.o(23067);
            return;
        }
        Log.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
        AppMethodBeat.o(23067);
    }

    @Override // com.tencent.mm.plugin.dbbackup.a.a.b
    public final void X(int i2, int i3, int i4) {
        float f2 = 1.0f;
        AppMethodBeat.i(23068);
        if (i2 <= 0 || i2 > 6) {
            AppMethodBeat.o(23068);
            return;
        }
        if (i4 > 0) {
            int i5 = qDw[i2 - 1];
            int i6 = qDw[i2] - i5;
            float f3 = ((float) i3) / ((float) i4);
            if (f3 <= 1.0f) {
                f2 = f3;
            }
            ProgressBar progressBar = this.krF;
            progressBar.setProgress((int) ((f2 * ((float) i6)) + ((float) i5)));
        } else if (this.qDt != i2) {
            this.krF.setProgress(qDw[i2 - 1]);
        }
        this.qDt = i2;
        String str = getResources().getStringArray(R.array.f3021f)[i2 - 1];
        this.qDr.setText(String.format(str, Integer.valueOf(i3)));
        AppMethodBeat.o(23068);
    }

    @Override // com.tencent.mm.plugin.dbbackup.a.a.b
    public final void M(long j2, long j3) {
        AppMethodBeat.i(23069);
        this.qDu = false;
        this.qDp = null;
        cAS();
        h.a((Context) this, getString(R.string.bki, new Object[]{Long.valueOf((j3 / 1024) / 1024), Long.valueOf((j2 / 1024) / 1024)}), (String) null, false, this.qDv);
        AppMethodBeat.o(23069);
    }

    @Override // com.tencent.mm.plugin.dbbackup.a.a.b
    public final void onSuccess() {
        AppMethodBeat.i(23070);
        this.qDu = false;
        this.qDp = null;
        Log.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
        final d a2 = h.a((Context) this, (int) R.string.bkj, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(23061);
                DBRecoveryUI.this.finish();
                d.cAZ();
                AppMethodBeat.o(23061);
            }
        });
        if (a2 != null) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.dbbackup.DBRecoveryUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(23062);
                    a2.dismiss();
                    DBRecoveryUI.this.finish();
                    d.cAZ();
                    AppMethodBeat.o(23062);
                }
            }, 5000);
        }
        AppMethodBeat.o(23070);
    }

    @Override // com.tencent.mm.plugin.dbbackup.a.a.b
    public final void onCanceled() {
        AppMethodBeat.i(23071);
        this.qDu = false;
        this.qDp = null;
        Log.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
        cAS();
        h.a((Context) this, (int) R.string.bke, 0, false, this.qDv);
        AppMethodBeat.o(23071);
    }

    @Override // com.tencent.mm.plugin.dbbackup.a.a.b
    public final void onFailure() {
        AppMethodBeat.i(23072);
        this.qDu = false;
        this.qDp = null;
        Log.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
        cAS();
        h.a((Context) this, (int) R.string.bkf, 0, false, this.qDv);
        AppMethodBeat.o(23072);
    }

    private static void cAS() {
        AppMethodBeat.i(23073);
        ao azQ = g.aAh().azQ();
        azQ.set(89, (Object) 2);
        azQ.gBI();
        AppMethodBeat.o(23073);
    }
}
