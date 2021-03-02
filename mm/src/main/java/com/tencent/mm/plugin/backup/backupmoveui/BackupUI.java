package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI extends MMWizardActivity {
    private static boolean oNA = false;
    private MTimerHandler oMw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(21489);
            if (Util.isNullOrNil(g.eE(BackupUI.this))) {
                if (BackupUI.oNA) {
                    BackupUI.this.oNl.setText(R.string.a9i);
                    BackupUI.this.oNl.setTextColor(BackupUI.this.getResources().getColor(R.color.ew));
                    BackupUI.this.oNz.setEnabled(false);
                    boolean unused = BackupUI.oNA = false;
                    h.INSTANCE.a(11788, 2);
                }
            } else if (!BackupUI.oNA) {
                BackupUI.this.oNl.setText(R.string.a9j);
                BackupUI.this.oNl.setTextColor(BackupUI.this.getResources().getColor(R.color.ex));
                BackupUI.this.oNz.setEnabled(true);
                boolean unused2 = BackupUI.oNA = true;
            }
            AppMethodBeat.o(21489);
            return true;
        }
    }, true);
    private TextView oNl;
    private Button oNz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupUI() {
        AppMethodBeat.i(21490);
        AppMethodBeat.o(21490);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21491);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21491);
            return;
        }
        setMMTitle(R.string.a55);
        h.INSTANCE.a(11788, 1);
        b.cgx();
        this.oNl = (TextView) findViewById(R.id.yy);
        this.oNz = (Button) findViewById(R.id.yu);
        com.tencent.mm.plugin.backup.d.b.cfv();
        SharedPreferences.Editor edit = com.tencent.mm.plugin.backup.d.b.ceR().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        edit.commit();
        if (!com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi) {
            a cfz = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
            d.cgP().cgS();
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.backup.d.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(21275);
                    if (a.this.oLc != null) {
                        a.this.oLc.cancel();
                    }
                    a.this.oLc = new com.tencent.mm.plugin.backup.c.b();
                    if (a.this.cfq() == null || a.this.cfq().size() == 0) {
                        Log.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
                        a.this.oLc.a(a.this);
                    }
                    AppMethodBeat.o(21275);
                }
            }, "BakMoveChooseServer.calculateToChoose");
        } else {
            com.tencent.mm.plugin.backup.d.b.cfv().cfz().cft();
        }
        if (Util.isNullOrNil(g.eE(this))) {
            this.oNl.setText(R.string.a9i);
            this.oNl.setTextColor(getResources().getColor(R.color.ew));
            this.oNz.setEnabled(false);
            oNA = false;
            h.INSTANCE.a(11788, 2);
        } else {
            this.oNl.setText(R.string.a9j);
            this.oNl.setTextColor(getResources().getColor(R.color.ex));
            this.oNz.setEnabled(true);
            oNA = true;
        }
        this.oNz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupUI.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0084, code lost:
                if (((java.lang.Boolean) com.tencent.mm.model.c.azQ().get(com.tencent.mm.storage.ar.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() != false) goto L_0x0086;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r14) {
                /*
                // Method dump skipped, instructions count: 528
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backupmoveui.BackupUI.AnonymousClass1.onClick(android.view.View):void");
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21488);
                BackupUI.this.finish();
                AppMethodBeat.o(21488);
                return true;
            }
        });
        AppMethodBeat.o(21491);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21492);
        super.onStart();
        this.oMw.startTimer(5000);
        AppMethodBeat.o(21492);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(21493);
        super.onStop();
        this.oMw.stopTimer();
        AppMethodBeat.o(21493);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hq;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21494);
        Log.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
        super.onDestroy();
        com.tencent.mm.plugin.backup.d.b.cfv().cfz().cancel();
        a cfz = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
        Log.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
        cfz.oLf = null;
        cfz.oLh = null;
        cfz.oLg = null;
        cfz.oLj = false;
        cfz.oLi = false;
        AppMethodBeat.o(21494);
    }
}
