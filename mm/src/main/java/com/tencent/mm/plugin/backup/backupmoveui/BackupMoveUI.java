package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class BackupMoveUI extends MMWizardActivity {
    public TextView hOu;
    private b.d oKF = new b.d() {
        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void Ba(int i2) {
            AppMethodBeat.i(21466);
            e ceM = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
            Log.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", Integer.valueOf(i2), Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe));
            switch (i2) {
                case -100:
                    BackupMoveUI.a(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case -23:
                    BackupMoveUI.this.oNm.setImageResource(R.raw.backup_move_error);
                    BackupMoveUI.this.oNk.setText(R.string.a5n);
                    BackupMoveUI.this.oNl.setVisibility(4);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    break;
                case -21:
                    BackupMoveUI.this.oNm.setImageResource(R.raw.backup_move_error);
                    BackupMoveUI.this.oNk.setText(R.string.a62);
                    BackupMoveUI.this.oNl.setVisibility(4);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case -11:
                    BackupMoveUI.this.oNm.setImageResource(R.raw.backup_move_qrcode_dark);
                    BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(R.string.a6_, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), "0M"}));
                    BackupMoveUI.this.oNl.setText(R.string.a5s);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.color.a5c));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case -4:
                    BackupMoveUI.this.oNm.setImageResource(R.raw.backup_move_qrcode_dark);
                    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.start();
                    BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(R.string.a6_, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), "0M"}));
                    BackupMoveUI.this.oNl.setText(R.string.a5u);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.color.a5c));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.d(BackupMoveUI.this);
                    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMi = c.oIO;
                    AppMethodBeat.o(21466);
                    return;
                case 1:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.byz);
                    BackupMoveUI.this.oNk.setText(R.string.a5c);
                    BackupMoveUI.this.oNl.setText(R.string.a69);
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 3:
                    BackupMoveUI.this.finish();
                    AppMethodBeat.o(21466);
                    return;
                case 4:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.byz);
                    TextView textView = BackupMoveUI.this.oNk;
                    BackupMoveUI backupMoveUI = BackupMoveUI.this;
                    com.tencent.mm.plugin.backup.d.b.cfv().cfx();
                    textView.setText(backupMoveUI.getString(R.string.a75, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), d.cfN()}));
                    BackupMoveUI.this.oNl.setText(R.string.a76);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.ex));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 12:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.byz);
                    BackupMoveUI.this.oNk.setText(R.string.a6f);
                    BackupMoveUI.this.oNl.setText(R.string.a69);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.ex));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 13:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.byz);
                    BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(R.string.a56, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe)}));
                    BackupMoveUI.this.oNl.setText(R.string.a69);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.ex));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 14:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.byz);
                    TextView textView2 = BackupMoveUI.this.oNk;
                    BackupMoveUI backupMoveUI2 = BackupMoveUI.this;
                    com.tencent.mm.plugin.backup.d.b.cfv().cfx();
                    textView2.setText(backupMoveUI2.getString(R.string.a75, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), d.cfN()}));
                    BackupMoveUI.this.oNl.setText(R.string.a69);
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.ex));
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 15:
                    BackupMoveUI.this.oNm.setImageResource(R.drawable.bz0);
                    BackupMoveUI.this.oNk.setText(R.string.a64);
                    BackupMoveUI.this.oNl.setText(BackupMoveUI.this.getString(R.string.a65, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe)}));
                    BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.ex));
                    BackupMoveUI.this.oNi.setText(R.string.a53);
                    BackupMoveUI.this.oNl.setVisibility(0);
                    BackupMoveUI.this.oNi.setVisibility(0);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(21465);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                            com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
                            com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
                            BackupMoveUI.c(BackupMoveUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(21465);
                        }
                    });
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
                case 51:
                    byte[] bArr = com.tencent.mm.plugin.backup.d.b.cfv().cfx().bitmapData;
                    BackupMoveUI.this.oNm.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveUI.this.oNk.setText(R.string.a6i);
                    BackupMoveUI.this.oNk.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.color.a2x));
                    BackupMoveUI.this.oNl.setVisibility(4);
                    BackupMoveUI.this.oNi.setVisibility(4);
                    BackupMoveUI.this.oNj.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(21466);
                    return;
            }
            AppMethodBeat.o(21466);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void ceL() {
        }
    };
    public TextView oNi;
    public TextView oNj;
    public TextView oNk;
    public TextView oNl;
    public ImageView oNm;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveUI() {
        AppMethodBeat.i(21470);
        AppMethodBeat.o(21470);
    }

    static /* synthetic */ void e(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21483);
        backupMoveUI.cfT();
        AppMethodBeat.o(21483);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21471);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21471);
            return;
        }
        Log.i("MicroMsg.BackupMoveUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.jRt.Xc();
        initView();
        try {
            com.tencent.mm.plugin.backup.d.b.cfv().cfx().oLH = ((Boolean) WifiManager.class.getMethod("isWifiApEnabled", new Class[0]).invoke((WifiManager) getSystemService("wifi"), new Object[0])).booleanValue();
            Log.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cfv().cfx().oLH));
            AppMethodBeat.o(21471);
        } catch (Exception e2) {
            Log.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", Util.getStack());
            AppMethodBeat.o(21471);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21472);
        this.hOu = (TextView) findViewById(R.id.ys);
        this.oNm = (ImageView) findViewById(R.id.yt);
        this.oNk = (TextView) findViewById(R.id.z2);
        this.oNl = (TextView) findViewById(R.id.z1);
        this.oNi = (TextView) findViewById(R.id.y_);
        this.oNj = (TextView) findViewById(R.id.y9);
        AppMethodBeat.o(21472);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ho;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(21473);
        super.onResume();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().oKF = this.oKF;
        this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
        AppMethodBeat.o(21473);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(21474);
        super.onPause();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().a(this.oKF);
        AppMethodBeat.o(21474);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21475);
        Log.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo != null) {
            com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(21475);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21476);
        if (i2 == 4) {
            cfT();
            AppMethodBeat.o(21476);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21476);
        return onKeyDown;
    }

    private void cfT() {
        AppMethodBeat.i(21477);
        int i2 = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
        Log.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", Integer.valueOf(i2));
        switch (i2) {
            case -23:
            case -21:
            case -11:
            case -4:
            case 1:
            case 4:
            case 12:
            case 13:
            case 14:
            case 51:
                h.a((Context) this, (int) R.string.a6h, (int) R.string.a6g, (int) R.string.a72, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21468);
                        Log.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 25, 1, false);
                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                        com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(false);
                        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
                        BackupMoveUI.f(BackupMoveUI.this);
                        AppMethodBeat.o(21468);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                AppMethodBeat.o(21477);
                return;
            case 15:
                Log.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                cfV();
                AppMethodBeat.o(21477);
                return;
            default:
                ala(1);
                AppMethodBeat.o(21477);
                return;
        }
    }

    private void cfV() {
        AppMethodBeat.i(21478);
        com.tencent.mm.plugin.backup.d.b.cfv().cfz().cancel();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
        ala(1);
        AppMethodBeat.o(21478);
    }

    static /* synthetic */ void a(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21479);
        backupMoveUI.ala(1);
        AppMethodBeat.o(21479);
    }

    static /* synthetic */ void b(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21480);
        backupMoveUI.hOu.setText(R.string.a52);
        backupMoveUI.hOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(21467);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BackupMoveUI.e(BackupMoveUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21467);
            }
        });
        AppMethodBeat.o(21480);
    }

    static /* synthetic */ void c(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21481);
        backupMoveUI.ala(1);
        AppMethodBeat.o(21481);
    }

    static /* synthetic */ void d(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21482);
        backupMoveUI.hOu.setText(R.string.a54);
        backupMoveUI.hOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(21469);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BackupMoveUI.g(BackupMoveUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21469);
            }
        });
        AppMethodBeat.o(21482);
    }

    static /* synthetic */ void f(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21484);
        backupMoveUI.ala(1);
        AppMethodBeat.o(21484);
    }

    static /* synthetic */ void g(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(21485);
        backupMoveUI.ala(1);
        AppMethodBeat.o(21485);
    }
}
