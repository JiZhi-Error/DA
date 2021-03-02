package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI extends MMWizardActivity {
    private b.d oKF = new b.d() {
        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void Ba(int i2) {
            AppMethodBeat.i(21403);
            Log.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", Integer.valueOf(i2));
            if (BackupMoveQRCodeUI.this.oNf) {
                AppMethodBeat.o(21403);
                return;
            }
            switch (i2) {
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                    BackupMoveQRCodeUI.this.oNf = true;
                    h.a((Context) BackupMoveQRCodeUI.this, (int) R.string.a5z, 0, (int) R.string.a4w, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21401);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.oNf = false;
                            com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
                            AppMethodBeat.o(21401);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21402);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(21402);
                        }
                    }, (int) R.color.ev);
                    break;
                case APPluginConstants.ERROR_IO_NoHttpResponseException:
                    BackupMoveQRCodeUI.this.oNf = true;
                    h.a((Context) BackupMoveQRCodeUI.this, (int) R.string.a60, 0, (int) R.string.a4v, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21398);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
                            BackupMoveQRCodeUI.this.oNf = false;
                            com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
                            AppMethodBeat.o(21398);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21399);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(21399);
                        }
                    }, (int) R.color.ev);
                    AppMethodBeat.o(21403);
                    return;
                case APPluginConstants.ERROR_IO_MalformedChunkCodingException:
                    BackupMoveQRCodeUI.this.oNf = true;
                    h.a((Context) BackupMoveQRCodeUI.this, (int) R.string.a61, 0, (int) R.string.a4w, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21396);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.oNf = false;
                            com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
                            AppMethodBeat.o(21396);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21397);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(21397);
                        }
                    }, (int) R.color.ev);
                    AppMethodBeat.o(21403);
                    return;
                case -12:
                    h.a((Context) BackupMoveQRCodeUI.this, (int) R.string.a63, 0, (int) R.string.a9l, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass1.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21400);
                            Log.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                            AppMethodBeat.o(21400);
                        }
                    }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
                    AppMethodBeat.o(21403);
                    return;
                case -11:
                case -4:
                    BackupMoveQRCodeUI.this.oNd.setText(R.string.a5s);
                    BackupMoveQRCodeUI.this.oNd.setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.color.a5c));
                    BackupMoveQRCodeUI.this.oNc.setImageResource(R.raw.backup_move_qrcode_light);
                    BackupMoveQRCodeUI.this.oNe.setVisibility(4);
                    AppMethodBeat.o(21403);
                    return;
                case 2:
                    Log.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 12;
                    MMWizardActivity.ay(BackupMoveQRCodeUI.this, new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class));
                    AppMethodBeat.o(21403);
                    return;
                case 51:
                    byte[] bArr = com.tencent.mm.plugin.backup.d.b.cfv().cfx().bitmapData;
                    BackupMoveQRCodeUI.this.oNc.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveQRCodeUI.this.oNd.setText(R.string.a6i);
                    BackupMoveQRCodeUI.this.oNd.setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.color.a2x));
                    BackupMoveQRCodeUI.this.oNe.setVisibility(4);
                    AppMethodBeat.o(21403);
                    return;
            }
            AppMethodBeat.o(21403);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void ceL() {
        }
    };
    private ImageView oNc;
    private TextView oNd;
    private TextView oNe;
    private boolean oNf = false;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveQRCodeUI() {
        AppMethodBeat.i(21406);
        AppMethodBeat.o(21406);
    }

    static /* synthetic */ void f(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(21415);
        backupMoveQRCodeUI.cfS();
        AppMethodBeat.o(21415);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21407);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(21407);
        } else if (!bg.aAc()) {
            finish();
            AppMethodBeat.o(21407);
        } else {
            initView();
            com.tencent.mm.plugin.backup.g.b.clear();
            d cfx = com.tencent.mm.plugin.backup.d.b.cfv().cfx();
            com.tencent.mm.plugin.backup.g.b.a(cfx.oLY);
            com.tencent.mm.plugin.backup.b.d.Bb(21);
            com.tencent.mm.plugin.backup.g.b.a(cfx.oLX);
            com.tencent.mm.plugin.backup.d.b.cfv().ceN();
            com.tencent.mm.plugin.backup.g.b.a(cfx.oMn);
            com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.cfv().cfw());
            com.tencent.mm.plugin.backup.g.b.Bb(2);
            com.tencent.mm.plugin.backup.d.b.cfv().oIX = null;
            cfx.oMh = false;
            cfx.oMe = new c(com.tencent.mm.plugin.backup.d.b.cfv(), 2, cfx.oJO);
            com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIN;
            com.tencent.mm.plugin.backup.b.d.ceS();
            AppMethodBeat.o(21407);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21408);
        super.onStart();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().oKF = this.oKF;
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.start();
        AppMethodBeat.o(21408);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(21409);
        super.onResume();
        this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
        AppMethodBeat.o(21409);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21410);
        setMMTitle(R.string.a55);
        this.oNc = (ImageView) findViewById(R.id.yv);
        this.oNd = (TextView) findViewById(R.id.yx);
        this.oNe = (TextView) findViewById(R.id.yw);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21404);
                BackupMoveQRCodeUI.f(BackupMoveQRCodeUI.this);
                AppMethodBeat.o(21404);
                return true;
            }
        });
        AppMethodBeat.o(21410);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21411);
        if (i2 == 4) {
            cfS();
            AppMethodBeat.o(21411);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21411);
        return onKeyDown;
    }

    private void cfS() {
        AppMethodBeat.i(21412);
        if (bg.azj()) {
            h.a((Context) this, (int) R.string.a6h, (int) R.string.a6g, (int) R.string.a72, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(21405);
                    Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
                    com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                    com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
                    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
                    BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
                    AppMethodBeat.o(21405);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
            AppMethodBeat.o(21412);
            return;
        }
        Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
        ala(1);
        AppMethodBeat.o(21412);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(21413);
        Log.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().a(this.oKF);
        if (com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo != null) {
            com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.stop();
        }
        super.onStop();
        AppMethodBeat.o(21413);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hn;
    }

    static /* synthetic */ void e(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(21414);
        backupMoveQRCodeUI.oNf = false;
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(false);
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(false);
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
        backupMoveQRCodeUI.ala(1);
        AppMethodBeat.o(21414);
    }

    static /* synthetic */ void g(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(21416);
        backupMoveQRCodeUI.ala(1);
        AppMethodBeat.o(21416);
    }
}
