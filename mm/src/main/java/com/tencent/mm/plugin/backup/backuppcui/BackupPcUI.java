package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean jZU = false;
    private TextView hOu;
    private TextView oNi;
    private TextView oNj;
    private TextView oNk;
    private TextView oNl;
    private ImageView oNm;
    public b.c oOY = new b.c() {
        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.backup.b.b.c
        public final void ceK() {
            AppMethodBeat.i(21671);
            int i2 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
            Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", Integer.valueOf(i2));
            switch (i2) {
                case 1:
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 11;
                    Ba(11);
                    AppMethodBeat.o(21671);
                    return;
                case 2:
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 21;
                    Ba(21);
                    AppMethodBeat.o(21671);
                    return;
                case 3:
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                    Ba(12);
                    AppMethodBeat.o(21671);
                    return;
                case 4:
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 22;
                    Ba(22);
                    break;
            }
            AppMethodBeat.o(21671);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void Ba(int i2) {
            AppMethodBeat.i(21672);
            while (true) {
                int i3 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
                Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                e ceM = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM();
                switch (i2) {
                    case -100:
                        BackupPcUI.a(BackupPcUI.this);
                        AppMethodBeat.o(21672);
                        return;
                    case -23:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a7u);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        break;
                    case -22:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a7x);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case -21:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a85);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case -13:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a82);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case -5:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a7t);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case -4:
                        if (1 == i3 || 3 == i3) {
                            BackupPcUI.this.oNm.setImageResource(R.drawable.bz1);
                            BackupPcUI.this.oNk.setText(BackupPcUI.this.getString(R.string.a93, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), "0M"}));
                            BackupPcUI.this.oNl.setText(R.string.a7y);
                            BackupPcUI.this.oNj.setText(R.string.a8z);
                            BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass3 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21654);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    h.a((Context) BackupPcUI.this, (int) R.string.a7n, (int) R.string.a7m, (int) R.string.a8z, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass3.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(21653);
                                            Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 10, 1, false);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bk(4);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                                            BackupPcUI.l(BackupPcUI.this);
                                            AppMethodBeat.o(21653);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21654);
                                }
                            });
                        } else if (2 == i3 || 4 == i3) {
                            BackupPcUI.this.oNm.setImageResource(R.drawable.bz4);
                            BackupPcUI.this.oNk.setText(BackupPcUI.this.getString(R.string.a8o, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), "0M"}));
                            BackupPcUI.this.oNl.setText(R.string.a86);
                            BackupPcUI.this.oNj.setText(R.string.a91);
                            BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass4 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21656);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    h.a((Context) BackupPcUI.this, (int) R.string.a7p, (int) R.string.a7o, (int) R.string.a90, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass4.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(21655);
                                            Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 18, 1, false);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().Bk(4);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                                            AppMethodBeat.o(21655);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21656);
                                }
                            });
                        }
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ew));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(0);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case -3:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a7s);
                        BackupPcUI.this.oNj.setText(R.string.a88);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(0);
                        BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass6 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21658);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                BackupPcUI.m(BackupPcUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21658);
                            }
                        });
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case -2:
                    case -1:
                        Bl(i3);
                        BackupPcUI.this.oNk.setText(R.string.a83);
                        String eE = g.eE(BackupPcUI.this);
                        if (eE == null || eE.equals("")) {
                            BackupPcUI.this.oNl.setText(BackupPcUI.this.getString(R.string.a84, new Object[]{com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, "移动网络"}));
                        } else {
                            BackupPcUI.this.oNl.setText(BackupPcUI.this.getString(R.string.a84, new Object[]{com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, eE}));
                        }
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ew));
                        BackupPcUI.this.oNj.setText(R.string.a88);
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(0);
                        BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass5 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21657);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                BackupPcUI.m(BackupPcUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21657);
                            }
                        });
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 1:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                        BackupPcUI.this.oNk.setText(R.string.a7j);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 4:
                        switch (i3) {
                            case 1:
                            case 3:
                                BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                                TextView textView = BackupPcUI.this.oNk;
                                BackupPcUI backupPcUI = BackupPcUI.this;
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                                textView.setText(backupPcUI.getString(R.string.a93, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                                TextView textView2 = BackupPcUI.this.oNk;
                                BackupPcUI backupPcUI2 = BackupPcUI.this;
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                                textView2.setText(backupPcUI2.getString(R.string.a8o, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                                break;
                        }
                        BackupPcUI.this.oNl.setText(R.string.a95);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ew));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 5:
                        switch (i3) {
                            case 1:
                            case 3:
                                BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                                TextView textView3 = BackupPcUI.this.oNk;
                                BackupPcUI backupPcUI3 = BackupPcUI.this;
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                                textView3.setText(backupPcUI3.getString(R.string.a93, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                                BackupPcUI.this.oNj.setText(R.string.a8z);
                                BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass16 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(21670);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        h.a((Context) BackupPcUI.this, (int) R.string.a7n, (int) R.string.a7m, (int) R.string.a8z, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass16.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(21669);
                                                Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 52, 1, false);
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bk(4);
                                                BackupPcUI.k(BackupPcUI.this);
                                                AppMethodBeat.o(21669);
                                            }
                                        }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(21670);
                                    }
                                });
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                                TextView textView4 = BackupPcUI.this.oNk;
                                BackupPcUI backupPcUI4 = BackupPcUI.this;
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                                textView4.setText(backupPcUI4.getString(R.string.a8o, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                                BackupPcUI.this.oNj.setText(R.string.a91);
                                BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass2 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(21652);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        h.a((Context) BackupPcUI.this, (int) R.string.a7p, (int) R.string.a7o, (int) R.string.a90, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(21651);
                                                Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 52, 1, false);
                                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().Bk(4);
                                                AppMethodBeat.o(21651);
                                            }
                                        }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(21652);
                                    }
                                });
                                break;
                        }
                        BackupPcUI.this.oNl.setText(R.string.a94);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ew));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(0);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 11:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                        BackupPcUI.this.oNk.setText(R.string.a8y);
                        BackupPcUI.this.oNl.setText(R.string.a8x);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNi.setText(R.string.a8v);
                        BackupPcUI.this.oNj.setText(R.string.a8w);
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(0);
                        BackupPcUI.this.oNj.setVisibility(0);
                        cgo();
                        BackupPcUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21650);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                bg.aVF();
                                boolean booleanValue = ((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue();
                                Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", Boolean.valueOf(booleanValue));
                                if (booleanValue) {
                                    h.a((Context) BackupPcUI.this, (int) R.string.a8_, 0, (int) R.string.a9l, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(21649);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                                            AnonymousClass3.this.Ba(12);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(true);
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 7, 1, false);
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 9, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                                            AppMethodBeat.o(21649);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
                                } else {
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                                    AnonymousClass3.this.Ba(12);
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(true);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 7, 1, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 9, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21650);
                            }
                        });
                        BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass9 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21661);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                MMWizardActivity.ay(BackupPcUI.this, new Intent(BackupPcUI.this, BackupPcChooseUI.class));
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21661);
                            }
                        });
                        AppMethodBeat.o(21672);
                        return;
                    case 12:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                        BackupPcUI.this.oNk.setText(R.string.a8d);
                        BackupPcUI.this.oNl.setText(R.string.a8e);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 14:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz3);
                        TextView textView5 = BackupPcUI.this.oNk;
                        BackupPcUI backupPcUI5 = BackupPcUI.this;
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                        textView5.setText(backupPcUI5.getString(R.string.a93, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                        BackupPcUI.this.oNl.setText(R.string.a8e);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 15:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz2);
                        BackupPcUI.this.oNk.setText(R.string.a7a);
                        BackupPcUI.this.oNl.setText(BackupPcUI.this.getString(R.string.a7b, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe)}));
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNi.setText(R.string.a53);
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(0);
                        BackupPcUI.this.oNj.setVisibility(4);
                        BackupPcUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass10 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21662);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                                BackupPcUI.g(BackupPcUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21662);
                            }
                        });
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 21:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                        BackupPcUI.this.oNk.setText(R.string.a8m);
                        BackupPcUI.this.oNi.setText(R.string.a8l);
                        BackupPcUI.this.oNl.setVisibility(4);
                        BackupPcUI.this.oNi.setVisibility(0);
                        BackupPcUI.this.oNj.setVisibility(4);
                        BackupPcUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass11 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21663);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 23, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(4);
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 22;
                                AnonymousClass3.this.Ba(22);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 16, 1, false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21663);
                            }
                        });
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 22:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                        BackupPcUI.this.oNk.setText(R.string.a8d);
                        BackupPcUI.this.oNl.setText(R.string.a8e);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 23:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                        TextView textView6 = BackupPcUI.this.oNk;
                        BackupPcUI backupPcUI6 = BackupPcUI.this;
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                        textView6.setText(backupPcUI6.getString(R.string.a8o, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()}));
                        BackupPcUI.this.oNl.setText(R.string.a8e);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgp();
                        AppMethodBeat.o(21672);
                        return;
                    case 24:
                        if (BackupPcUI.jZU) {
                            BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                            BackupPcUI.this.oNk.setText(R.string.a8p);
                            BackupPcUI.this.oNl.setText(R.string.a8r);
                            BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                            BackupPcUI.this.oNi.setText(R.string.a8k);
                            BackupPcUI.this.oNj.setText(R.string.a8n);
                            BackupPcUI.this.hOu.setText(R.string.a97);
                            BackupPcUI.this.oNl.setVisibility(0);
                            BackupPcUI.this.oNi.setVisibility(0);
                            BackupPcUI.this.oNj.setVisibility(0);
                            BackupPcUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass12 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21664);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
                                    if (!d.cfA()) {
                                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
                                        if (!d.cfA()) {
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -22;
                                            AnonymousClass3.this.Ba(-22);
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 64, 1, false);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(21664);
                                            return;
                                        }
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 27, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().cgk();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21664);
                                }
                            });
                            BackupPcUI.this.oNj.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass13 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21666);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    h.a((Context) BackupPcUI.this, (int) R.string.a7p, (int) R.string.a7o, (int) R.string.a90, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass13.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(21665);
                                            Log.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 26, 1, false);
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                                            AppMethodBeat.o(21665);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21666);
                                }
                            });
                            BackupPcUI.this.hOu.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass14 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(21667);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 25;
                                    BackupPcUI.i(BackupPcUI.this);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(21667);
                                }
                            });
                            AppMethodBeat.o(21672);
                            return;
                        } else if (Util.isTopActivity(BackupPcUI.this)) {
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
                            if (!d.cfA()) {
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -22;
                                Ba(-22);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 64, 1, false);
                                AppMethodBeat.o(21672);
                                return;
                            }
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().cgk();
                            AppMethodBeat.o(21672);
                            return;
                        }
                        break;
                    case 25:
                        if (!Util.isTopActivity(BackupPcUI.this)) {
                            break;
                        } else {
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 24;
                            i2 = 24;
                        }
                    case 26:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz6);
                        BackupPcUI.this.oNk.setText(BackupPcUI.this.getString(R.string.a8j, new Object[]{Integer.valueOf(ceM.oJf)}));
                        BackupPcUI.this.oNl.setText(R.string.a8i);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.hOu.setText(R.string.a8n);
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 27:
                        BackupPcUI.this.oNm.setImageResource(R.drawable.bz5);
                        BackupPcUI.this.oNk.setText(R.string.a8g);
                        BackupPcUI.this.oNl.setText(BackupPcUI.this.getString(R.string.a8h, new Object[]{Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe)}));
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNi.setText(R.string.a53);
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(0);
                        BackupPcUI.this.oNj.setVisibility(4);
                        BackupPcUI.this.oNi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass15 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(21668);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                                BackupPcUI.j(BackupPcUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(21668);
                            }
                        });
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                    case 30:
                        BackupPcUI.this.oNm.setImageResource(R.raw.backup_move_recover);
                        BackupPcUI.this.oNk.setText(R.string.a96);
                        BackupPcUI.this.oNl.setText(R.string.a6m);
                        BackupPcUI.this.oNl.setTextColor(BackupPcUI.this.getResources().getColor(R.color.ex));
                        BackupPcUI.this.oNl.setVisibility(0);
                        BackupPcUI.this.oNi.setVisibility(4);
                        BackupPcUI.this.oNj.setVisibility(4);
                        cgo();
                        AppMethodBeat.o(21672);
                        return;
                }
            }
            AppMethodBeat.o(21672);
        }

        private void Bl(int i2) {
            AppMethodBeat.i(21673);
            if (2 == i2 || 4 == i2) {
                BackupPcUI.this.oNm.setImageResource(R.drawable.bz4);
                AppMethodBeat.o(21673);
                return;
            }
            BackupPcUI.this.oNm.setImageResource(R.drawable.bz1);
            AppMethodBeat.o(21673);
        }

        private void cgo() {
            AppMethodBeat.i(21674);
            BackupPcUI.this.hOu.setText(R.string.a52);
            BackupPcUI.this.hOu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21659);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BackupPcUI.n(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21659);
                }
            });
            AppMethodBeat.o(21674);
        }

        private void cgp() {
            AppMethodBeat.i(21675);
            BackupPcUI.this.hOu.setText(R.string.a54);
            BackupPcUI.this.hOu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass3.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21660);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BackupPcUI.o(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21660);
                }
            });
            AppMethodBeat.o(21675);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.d
        public final void ceL() {
        }
    };

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupPcUI() {
        AppMethodBeat.i(21676);
        AppMethodBeat.o(21676);
    }

    static /* synthetic */ void n(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21693);
        backupPcUI.cfT();
        AppMethodBeat.o(21693);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21677);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21677);
            return;
        }
        Log.i("MicroMsg.BackupPcUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.jRt.Xc();
        initView();
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOr) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOr = false;
            final int cfc = g.cfc();
            if (cfc < 50) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 4, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13736, 4, com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, g.eE(this), 0, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                h.a((Context) this, (int) R.string.a7w, (int) R.string.a7v, (int) R.string.a9l, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21647);
                        Log.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", Integer.valueOf(cfc));
                        AppMethodBeat.o(21647);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
            }
        }
        if (((l) com.tencent.mm.kernel.g.af(l.class)).aTq().eiC()) {
            bp.aVQ();
        }
        AppMethodBeat.o(21677);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21678);
        super.onStart();
        Log.i("MicroMsg.BackupPcUI", "onStart.");
        jZU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        AppMethodBeat.o(21678);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(21679);
        super.onPause();
        Log.i("MicroMsg.BackupPcUI", "onPause.");
        com.tencent.mm.plugin.backup.backuppcmodel.e cgc = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
        b.c cVar = this.oOY;
        synchronized (cgc.oOw) {
            try {
                cgc.oOw.remove(cVar);
            } finally {
                AppMethodBeat.o(21679);
            }
        }
        d cgd = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
        b.c cVar2 = this.oOY;
        synchronized (cgd.oOw) {
            try {
                cgd.oOw.remove(cVar2);
            } finally {
                AppMethodBeat.o(21679);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(21680);
        super.onResume();
        Log.i("MicroMsg.BackupPcUI", "onResume.");
        com.tencent.mm.plugin.backup.backuppcmodel.e cgc = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
        b.c cVar = this.oOY;
        synchronized (cgc.oOw) {
            try {
                cgc.oOw.add(cVar);
            } finally {
                AppMethodBeat.o(21680);
            }
        }
        d cgd = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
        b.c cVar2 = this.oOY;
        synchronized (cgd.oOw) {
            try {
                cgd.oOw.add(cVar2);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.oOY.Ba(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc);
        AppMethodBeat.o(21680);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21681);
        this.hOu = (TextView) findViewById(R.id.ys);
        this.oNm = (ImageView) findViewById(R.id.yt);
        this.oNk = (TextView) findViewById(R.id.z2);
        this.oNl = (TextView) findViewById(R.id.z1);
        this.oNi = (TextView) findViewById(R.id.y_);
        this.oNj = (TextView) findViewById(R.id.y9);
        AppMethodBeat.o(21681);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ho;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21682);
        Log.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", Util.getStack());
        super.onDestroy();
        AppMethodBeat.o(21682);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21683);
        if (i2 == 4) {
            cfT();
            AppMethodBeat.o(21683);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21683);
        return onKeyDown;
    }

    private void cfT() {
        AppMethodBeat.i(21684);
        int i2 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc;
        int i3 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
        Log.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case -22:
            case -21:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
            case 11:
            case 21:
                if (1 != i3 && 3 != i3) {
                    if (2 != i3 && 4 != i3) {
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                        break;
                    } else {
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(false, false, -100);
                        AppMethodBeat.o(21684);
                        return;
                    }
                } else {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(false);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                    break;
                }
                break;
            case 15:
                Log.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                cgm();
                AppMethodBeat.o(21684);
                return;
            case 24:
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 25;
                break;
            case 26:
            case 30:
                h.a((Context) this, (int) R.string.a7p, (int) R.string.a7o, (int) R.string.a90, (int) R.string.a4x, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21648);
                        Log.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 26, 1, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                        AppMethodBeat.o(21648);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.ew);
                AppMethodBeat.o(21684);
                return;
            case 27:
                Log.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                cgm();
                AppMethodBeat.o(21684);
                return;
        }
        ala(1);
        AppMethodBeat.o(21684);
    }

    private void cgm() {
        AppMethodBeat.i(21685);
        Log.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
            ala(1);
            AppMethodBeat.o(21685);
            return;
        }
        if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
        }
        AppMethodBeat.o(21685);
    }

    static /* synthetic */ void a(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21686);
        backupPcUI.ala(1);
        AppMethodBeat.o(21686);
    }

    static /* synthetic */ void g(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21687);
        backupPcUI.ala(1);
        AppMethodBeat.o(21687);
    }

    static /* synthetic */ void i(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21688);
        backupPcUI.ala(1);
        AppMethodBeat.o(21688);
    }

    static /* synthetic */ void j(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21689);
        backupPcUI.ala(1);
        AppMethodBeat.o(21689);
    }

    static /* synthetic */ void k(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21690);
        backupPcUI.ala(1);
        AppMethodBeat.o(21690);
    }

    static /* synthetic */ void l(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21691);
        backupPcUI.ala(1);
        AppMethodBeat.o(21691);
    }

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21692);
        Log.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.string.a8b));
        intent.putExtra("rawUrl", backupPcUI.getString(R.string.a8a, new Object[]{LocaleUtil.getApplicationLanguage()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.br.c.b(backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(21692);
    }

    static /* synthetic */ void o(BackupPcUI backupPcUI) {
        AppMethodBeat.i(21694);
        backupPcUI.ala(1);
        AppMethodBeat.o(21694);
    }
}
