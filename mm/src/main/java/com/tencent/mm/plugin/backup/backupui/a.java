package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public final class a extends b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private View oQL = null;
    private View oQM;
    private int oQN = 100;
    private int oQO = 100;
    private b.a oQP = new C0835a(this);
    private TextView titleTv = null;

    static /* synthetic */ void a(a aVar, boolean z) {
        AppMethodBeat.i(21777);
        aVar.jF(z);
        AppMethodBeat.o(21777);
    }

    static /* synthetic */ void b(a aVar, boolean z) {
        AppMethodBeat.i(21778);
        aVar.jG(z);
        AppMethodBeat.o(21778);
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupui.a$a  reason: collision with other inner class name */
    static class C0835a implements b.a {
        private final WeakReference<a> oQR;

        C0835a(a aVar) {
            AppMethodBeat.i(21768);
            this.oQR = new WeakReference<>(aVar);
            AppMethodBeat.o(21768);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.a
        public final void AZ(int i2) {
            AppMethodBeat.i(21769);
            a aVar = this.oQR.get();
            if (aVar != null) {
                a.a(aVar, i2);
                AppMethodBeat.o(21769);
                return;
            }
            Log.e(a.TAG, "BackupChatBanner WeakReference is null!");
            AppMethodBeat.o(21769);
        }
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(21770);
        Log.i(TAG, "new BackupChatBanner.");
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
        Log.i(TAG, "initialize");
        this.titleTv = (TextView) this.view.findViewById(R.id.zl);
        this.oQL = this.view.findViewById(R.id.zj);
        this.oQM = this.view.findViewById(R.id.a29);
        if (this.view != null) {
            this.oQL = this.view.findViewById(R.id.zj);
            this.oQL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backupui.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21767);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int ceP = d.ceP();
                    Log.i(a.TAG, "backupbanner onclick, backupMode[%d]", Integer.valueOf(ceP));
                    switch (ceP) {
                        case 1:
                            int i2 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc;
                            Log.i(a.TAG, "backupbanner onclick, backupPcState[%d]", Integer.valueOf(i2));
                            switch (i2) {
                                case -4:
                                case 4:
                                case 5:
                                case 12:
                                case 14:
                                case 15:
                                case 22:
                                case 23:
                                case 28:
                                    Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc));
                                    a.a(a.this, false);
                                    break;
                                case 24:
                                case 25:
                                    Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc));
                                    a.a(a.this, true);
                                    break;
                                default:
                                    Log.i(a.TAG, "click backup banner, BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc));
                                    break;
                            }
                        case 22:
                            int i3 = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
                            Log.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", Integer.valueOf(i3));
                            switch (i3) {
                                case -4:
                                case 4:
                                case 5:
                                case 12:
                                case 22:
                                case 23:
                                case 28:
                                case 52:
                                    Log.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(i3));
                                    a.b(a.this, false);
                                    break;
                                case 24:
                                case 25:
                                    Log.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(i3));
                                    a.b(a.this, true);
                                    break;
                                default:
                                    Log.i(a.TAG, "click backup banner,backupMoveState[%d]", Integer.valueOf(i3));
                                    break;
                            }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21767);
                }
            });
        }
        bYa();
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOx = this.oQP;
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().oOx = this.oQP;
        com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLA = this.oQP;
        AppMethodBeat.o(21770);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.i2;
    }

    private void jF(boolean z) {
        AppMethodBeat.i(21771);
        Log.i(TAG, "jumpToBackupPcUI");
        if (Util.isTopActivity((Context) this.Kgr.get())) {
            Intent className = new Intent().setClassName((Context) this.Kgr.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.ay((Context) this.Kgr.get(), className);
        }
        AppMethodBeat.o(21771);
    }

    private void jG(boolean z) {
        AppMethodBeat.i(21772);
        Log.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", Boolean.valueOf(z));
        if (Util.isTopActivity((Context) this.Kgr.get())) {
            Intent className = new Intent().setClassName((Context) this.Kgr.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.ay((Context) this.Kgr.get(), className);
        }
        AppMethodBeat.o(21772);
    }

    private boolean Br(int i2) {
        AppMethodBeat.i(21774);
        if (!(i2 == -100 && i2 == this.oQN)) {
            Log.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", Integer.valueOf(d.ceP()), Integer.valueOf(i2));
            this.oQN = i2;
        }
        e ceM = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM();
        switch (i2) {
            case -4:
            case 28:
                this.oQL.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                    ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a7q));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                    ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a7r));
                }
                AppMethodBeat.o(21774);
                return true;
            case 4:
            case 5:
                this.oQL.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                    ((TextView) this.view.findViewById(R.id.zl)).setText(context.getString(R.string.a93, Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                    Context context2 = MMApplicationContext.getContext();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                    ((TextView) this.view.findViewById(R.id.zl)).setText(context2.getString(R.string.a8o, Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()));
                }
                AppMethodBeat.o(21774);
                return true;
            case 12:
            case 22:
                this.oQL.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) {
                    ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                }
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a8d));
                AppMethodBeat.o(21774);
                return true;
            case 14:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                Context context3 = MMApplicationContext.getContext();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                ((TextView) this.view.findViewById(R.id.zl)).setText(context3.getString(R.string.a93, Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()));
                AppMethodBeat.o(21774);
                return true;
            case 15:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a7a));
                AppMethodBeat.o(21774);
                return true;
            case 23:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                Context context4 = MMApplicationContext.getContext();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                ((TextView) this.view.findViewById(R.id.zl)).setText(context4.getString(R.string.a8o, Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), c.cgg()));
                AppMethodBeat.o(21774);
                return true;
            case 24:
                jF(true);
                AppMethodBeat.o(21774);
                return true;
            case 25:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_display_mobile, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a8q));
                AppMethodBeat.o(21774);
                return true;
            case 26:
            case 27:
                this.oQL.setVisibility(8);
                if (Util.isTopActivity((Context) this.Kgr.get())) {
                    jF(true);
                }
                AppMethodBeat.o(21774);
                return true;
            default:
                this.oQL.setVisibility(8);
                AppMethodBeat.o(21774);
                return false;
        }
    }

    private boolean Bs(int i2) {
        AppMethodBeat.i(21775);
        if (!(i2 == -100 && i2 == this.oQO)) {
            Log.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", Integer.valueOf(d.ceP()), Integer.valueOf(i2));
            this.oQO = i2;
        }
        e ceM = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
        switch (i2) {
            case -4:
            case 28:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a5i));
                AppMethodBeat.o(21775);
                return true;
            case 4:
            case 5:
            case 23:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                Context context = MMApplicationContext.getContext();
                com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                ((TextView) this.view.findViewById(R.id.zl)).setText(context.getString(R.string.a6t, Integer.valueOf(ceM.oJd), Integer.valueOf(ceM.oJe), com.tencent.mm.plugin.backup.d.c.cfE()));
                AppMethodBeat.o(21775);
                return true;
            case 22:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a6o));
                AppMethodBeat.o(21775);
                return true;
            case 24:
            case 52:
                if (Util.isTopActivity((Context) this.Kgr.get())) {
                    jG(true);
                }
                AppMethodBeat.o(21775);
                return true;
            case 25:
                this.oQL.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.zk)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50)));
                ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a6v));
                AppMethodBeat.o(21775);
                return true;
            case 26:
            case 27:
                this.oQL.setVisibility(8);
                if (Util.isTopActivity((Context) this.Kgr.get())) {
                    jG(true);
                }
                AppMethodBeat.o(21775);
                return true;
            default:
                this.oQL.setVisibility(8);
                AppMethodBeat.o(21775);
                return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 3;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(21773);
        if (this.isFirst && this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.azq);
            this.oQL.setBackground(null);
            this.titleTv.setBackground(null);
        } else if (this.isFirst) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.cao);
            this.titleTv.setBackgroundResource(R.drawable.b9w);
        } else if (this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.b9w);
            this.titleTv.setBackground(null);
        } else {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackground(null);
            this.titleTv.setBackgroundResource(R.drawable.b9w);
        }
        switch (d.ceP()) {
            case 1:
                boolean Br = Br(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc);
                AppMethodBeat.o(21773);
                return Br;
            case 22:
                boolean Bs = Bs(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
                AppMethodBeat.o(21773);
                return Bs;
            default:
                this.oQL.setVisibility(8);
                AppMethodBeat.o(21773);
                return false;
        }
    }

    static /* synthetic */ boolean a(a aVar, int i2) {
        AppMethodBeat.i(21776);
        switch (d.ceP()) {
            case 1:
                boolean Br = aVar.Br(i2);
                AppMethodBeat.o(21776);
                return Br;
            case 22:
                boolean Bs = aVar.Bs(i2);
                AppMethodBeat.o(21776);
                return Bs;
            default:
                aVar.oQL.setVisibility(8);
                AppMethodBeat.o(21776);
                return false;
        }
    }
}
