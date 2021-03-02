package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

@a(3)
public class BackupMoveRecoverUI extends MMWizardActivity {
    private static boolean jZU = false;
    private static boolean oNo = false;
    public TextView hOu;
    private b.d oKF = new b.d() {
        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void Ba(final int i2) {
            AppMethodBeat.i(21443);
            while (true) {
                e ceM = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
                Log.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", Integer.valueOf(i2), Boolean.valueOf(BackupMoveRecoverUI.oNo), Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), Integer.valueOf(ceM.oJf));
                switch (i2) {
                    case -100:
                        BackupMoveRecoverUI.a(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -22:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5r);
                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                        BackupMoveRecoverUI.this.oNl.setVisibility(4);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        break;
                    case -21:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a62);
                        BackupMoveRecoverUI.this.oNl.setVisibility(4);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -14:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5m);
                        BackupMoveRecoverUI.this.oNl.setVisibility(4);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -13:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5v);
                        BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(R.string.a5w, new Object[]{Util.getSizeKB(com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLV)}));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -12:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5c);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a69);
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5t, 0, (int) R.string.a9l, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass14 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(21434);
                                Log.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                                BackupMoveRecoverUI.h(BackupMoveRecoverUI.this);
                                AppMethodBeat.o(21434);
                            }
                        }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
                        AppMethodBeat.o(21443);
                        return;
                    case -5:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5l);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a6p);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a6s);
                        BackupMoveRecoverUI.this.oNl.setVisibility(4);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass11 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21430);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11788, 9);
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", intent);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21430);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass13 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21433);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5h, (int) R.string.a5g, (int) R.string.a6s, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass13.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(21432);
                                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i2));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 44, 1, false);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                                        AppMethodBeat.o(21432);
                                    }
                                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21433);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -4:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(BackupMoveRecoverUI.this.getString(R.string.a6_, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), "0M"}));
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a5u);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a6p);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a6s);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass7 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21424);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(7);
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", intent);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21424);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass8 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21426);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5h, (int) R.string.a5g, (int) R.string.a6s, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass8.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(21425);
                                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i2));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 44, 1, false);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(6);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                                        AppMethodBeat.o(21425);
                                    }
                                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21426);
                            }
                        });
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ew));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -3:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5j);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a5k);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a6n);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a6s);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ew));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass9 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21427);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Intent intent = new Intent();
                                intent.putExtra("title", BackupMoveRecoverUI.this.getString(R.string.a6b));
                                intent.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(R.string.a6a, new Object[]{LocaleUtil.getApplicationLanguage()}));
                                intent.putExtra("showShare", false);
                                intent.putExtra("neverGetA8Key", true);
                                c.b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21427);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass10 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21429);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5h, (int) R.string.a5g, (int) R.string.a6s, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass10.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(21428);
                                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i2));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 44, 1, false);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                                        AppMethodBeat.o(21428);
                                    }
                                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21429);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case -2:
                    case -1:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5x);
                        String eE = g.eE(BackupMoveRecoverUI.this);
                        String str = com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLO;
                        if (Util.isNullOrNil(eE)) {
                            eE = "移动网络";
                        }
                        if (Util.isNullOrNil(str)) {
                            str = "移动网络";
                        }
                        if (!eE.equals("wifi") && !str.equals("wifi")) {
                            BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(R.string.a5y, new Object[]{eE, str}));
                        }
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ew));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 1:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a5c);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a69);
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 3:
                        BackupMoveRecoverUI.this.finish();
                        AppMethodBeat.o(21443);
                        return;
                    case 4:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        TextView textView = BackupMoveRecoverUI.this.oNk;
                        BackupMoveRecoverUI backupMoveRecoverUI = BackupMoveRecoverUI.this;
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                        textView.setText(backupMoveRecoverUI.getString(R.string.a6t, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), com.tencent.mm.plugin.backup.d.c.cfE()}));
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a76);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(8);
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setProgress(ceM.ceV());
                        BackupMoveRecoverUI.this.oNn.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass5 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21422);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().cfD();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21422);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a77);
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass6 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21423);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                try {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                                    BackupMoveRecoverUI backupMoveRecoverUI = BackupMoveRecoverUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(backupMoveRecoverUI, bl.axQ(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    backupMoveRecoverUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(backupMoveRecoverUI, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
                                    BackupMoveRecoverUI backupMoveRecoverUI2 = BackupMoveRecoverUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    com.tencent.mm.hellhoundlib.a.a.a(backupMoveRecoverUI2, bl2.axQ(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    backupMoveRecoverUI2.startActivity((Intent) bl2.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(backupMoveRecoverUI2, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21423);
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 22:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a6o);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a69);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 23:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        TextView textView2 = BackupMoveRecoverUI.this.oNk;
                        BackupMoveRecoverUI backupMoveRecoverUI2 = BackupMoveRecoverUI.this;
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                        textView2.setText(backupMoveRecoverUI2.getString(R.string.a6t, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), com.tencent.mm.plugin.backup.d.c.cfE()}));
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a69);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(8);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setProgress(ceM.ceV());
                        BackupMoveRecoverUI.this.oNn.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass15 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21435);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().cfD();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21435);
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 24:
                        Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", Boolean.valueOf(BackupMoveRecoverUI.jZU));
                        if (BackupMoveRecoverUI.jZU) {
                            BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                            BackupMoveRecoverUI.this.oNk.setText(R.string.a6u);
                            BackupMoveRecoverUI.this.oNl.setText(R.string.a6w);
                            BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                            BackupMoveRecoverUI.this.oNi.setText(R.string.a6q);
                            BackupMoveRecoverUI.this.oNj.setText(R.string.a6r);
                            BackupMoveRecoverUI.this.hOu.setText(R.string.a97);
                            BackupMoveRecoverUI.this.oNl.setVisibility(0);
                            BackupMoveRecoverUI.this.oNi.setVisibility(0);
                            BackupMoveRecoverUI.this.oNj.setVisibility(0);
                            BackupMoveRecoverUI.this.oNn.setVisibility(8);
                            BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass21 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21442);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                                    com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                                    if (!com.tencent.mm.plugin.backup.d.c.cfA()) {
                                        Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                                        AnonymousClass1.this.Ba(-22);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 6, 1, false);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(21442);
                                        return;
                                    }
                                    com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21442);
                                }
                            });
                            BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass2 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21419);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                                    h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5f, (int) R.string.a5e, (int) R.string.a6r, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(21418);
                                            Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i2));
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 48, 1, false);
                                            com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                            com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                                            AppMethodBeat.o(21418);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21419);
                                }
                            });
                            BackupMoveRecoverUI.this.hOu.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass3 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21420);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
                                    BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21420);
                                }
                            });
                            AppMethodBeat.o(21443);
                            return;
                        } else if (BackupMoveRecoverUI.oNo) {
                            com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                            if (!com.tencent.mm.plugin.backup.d.c.cfA()) {
                                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                                Ba(-22);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 6, 1, false);
                                AppMethodBeat.o(21443);
                                return;
                            }
                            com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
                            AppMethodBeat.o(21443);
                            return;
                        }
                        break;
                    case 25:
                        if (!BackupMoveRecoverUI.oNo) {
                            break;
                        } else {
                            com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 24;
                            i2 = 24;
                        }
                    case 26:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_recover);
                        BackupMoveRecoverUI.this.oNk.setText(BackupMoveRecoverUI.this.getString(R.string.a6l, new Object[]{Integer.valueOf(ceM.oJf)}));
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a6m);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 27:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_recover_finish);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a6j);
                        BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(R.string.a6k, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe)}));
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a53);
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21421);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
                                BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21421);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 28:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a6c);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a6e);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a6d);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass16 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21436);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", intent);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21436);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a6s);
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass17 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21437);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
                                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 29;
                                AnonymousClass1.this.Ba(29);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21437);
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 29:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a71);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a73);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a70);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass18 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21438);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                                if (!com.tencent.mm.plugin.backup.d.c.cfA()) {
                                    Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                                    AnonymousClass1.this.Ba(-22);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 6, 1, false);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21438);
                                    return;
                                }
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21438);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a5d);
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass19 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21440);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
                                h.a((Context) BackupMoveRecoverUI.this, (int) R.string.a5f, (int) R.string.a5e, (int) R.string.a6r, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass19.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(21439);
                                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i2));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 48, 1, false);
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                                        AppMethodBeat.o(21439);
                                    }
                                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21440);
                            }
                        });
                        BackupMoveRecoverUI.this.hOu.setText(R.string.a97);
                        BackupMoveRecoverUI.this.hOu.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass20 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21441);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
                                BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21441);
                            }
                        });
                        AppMethodBeat.o(21443);
                        return;
                    case 30:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.raw.backup_move_recover);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a96);
                        BackupMoveRecoverUI.this.oNl.setText(R.string.a6m);
                        BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.ex));
                        BackupMoveRecoverUI.this.oNl.setVisibility(0);
                        BackupMoveRecoverUI.this.oNi.setVisibility(4);
                        BackupMoveRecoverUI.this.oNj.setVisibility(4);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                    case 52:
                        BackupMoveRecoverUI.this.oNm.setImageResource(R.drawable.byz);
                        BackupMoveRecoverUI.this.oNk.setText(R.string.a66);
                        BackupMoveRecoverUI.this.oNi.setText(R.string.a68);
                        BackupMoveRecoverUI.this.oNj.setText(R.string.a67);
                        BackupMoveRecoverUI.this.oNl.setVisibility(4);
                        BackupMoveRecoverUI.this.oNi.setVisibility(0);
                        BackupMoveRecoverUI.this.oNj.setVisibility(0);
                        BackupMoveRecoverUI.this.oNn.setVisibility(8);
                        BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21417);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().jA(false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21417);
                            }
                        });
                        BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass1.AnonymousClass12 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21431);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.d.b.cfv().cfy().jA(true);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21431);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(21443);
                        return;
                }
            }
            AppMethodBeat.o(21443);
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
    private RoundProgressBtn oNn;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveRecoverUI() {
        AppMethodBeat.i(21448);
        AppMethodBeat.o(21448);
    }

    static /* synthetic */ void i(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21463);
        backupMoveRecoverUI.cfT();
        AppMethodBeat.o(21463);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21449);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21449);
            return;
        }
        Log.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.jRt.Xc();
        initView();
        try {
            com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLH = ((Boolean) WifiManager.class.getMethod("isWifiApEnabled", new Class[0]).invoke((WifiManager) getSystemService("wifi"), new Object[0])).booleanValue();
            Log.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLH));
            AppMethodBeat.o(21449);
        } catch (Exception e2) {
            Log.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", Util.getStack());
            AppMethodBeat.o(21449);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21450);
        this.hOu = (TextView) findViewById(R.id.ys);
        this.oNm = (ImageView) findViewById(R.id.yt);
        this.oNk = (TextView) findViewById(R.id.z2);
        this.oNl = (TextView) findViewById(R.id.z1);
        this.oNi = (TextView) findViewById(R.id.y_);
        this.oNj = (TextView) findViewById(R.id.y9);
        this.oNn = (RoundProgressBtn) findViewById(R.id.z0);
        AppMethodBeat.o(21450);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(21451);
        super.onResume();
        Log.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        oNo = true;
        com.tencent.mm.plugin.backup.d.b.cfv().cfy().oKF = this.oKF;
        jZU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
        AppMethodBeat.o(21451);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(21452);
        super.onPause();
        Log.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        oNo = false;
        AppMethodBeat.o(21452);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21453);
        Log.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
        AppMethodBeat.o(21453);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21454);
        if (i2 == 4) {
            cfT();
            AppMethodBeat.o(21454);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21454);
        return onKeyDown;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void cfT() {
        AppMethodBeat.i(21455);
        final int i2 = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
        Log.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", Integer.valueOf(i2), Integer.valueOf(i2));
        switch (i2) {
            case -22:
            case -21:
            case -14:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
                com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(false, false, -100);
                AppMethodBeat.o(21455);
                return;
            case 24:
                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
                break;
            case 26:
            case 30:
                h.a((Context) this, (int) R.string.a7p, (int) R.string.a7o, (int) R.string.a90, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21446);
                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", Integer.valueOf(i2));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 48, 1, false);
                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                        AppMethodBeat.o(21446);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                AppMethodBeat.o(21455);
                return;
            case 27:
                Log.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", Integer.valueOf(i2));
                com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, false, -100);
                com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                AppMethodBeat.o(21455);
                return;
            case 52:
                h.a((Context) this, (int) R.string.a5h, (int) R.string.a5g, (int) R.string.a6s, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21445);
                        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", Integer.valueOf(i2));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(485, 44, 1, false);
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
                        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                        AppMethodBeat.o(21445);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                AppMethodBeat.o(21455);
                return;
        }
        ala(1);
        AppMethodBeat.o(21455);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ho;
    }

    static /* synthetic */ void a(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21456);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21456);
    }

    static /* synthetic */ void c(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21457);
        backupMoveRecoverUI.hOu.setText(R.string.a52);
        backupMoveRecoverUI.hOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(21444);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BackupMoveRecoverUI.i(BackupMoveRecoverUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21444);
            }
        });
        AppMethodBeat.o(21457);
    }

    static /* synthetic */ void d(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21458);
        backupMoveRecoverUI.hOu.setText(R.string.a54);
        backupMoveRecoverUI.hOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(21447);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.BackupMoveRecoverUI", "minimize BackupMoveRecoverUI");
                BackupMoveRecoverUI.j(BackupMoveRecoverUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21447);
            }
        });
        AppMethodBeat.o(21458);
    }

    static /* synthetic */ void e(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21459);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21459);
    }

    static /* synthetic */ void f(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21460);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21460);
    }

    static /* synthetic */ void g(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21461);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21461);
    }

    static /* synthetic */ void h(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21462);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21462);
    }

    static /* synthetic */ void j(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(21464);
        backupMoveRecoverUI.ala(1);
        AppMethodBeat.o(21464);
    }
}
