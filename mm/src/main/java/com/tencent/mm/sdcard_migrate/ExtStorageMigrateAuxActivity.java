package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdcard_migrate.a;
import com.tencent.mm.sdcard_migrate.a.c;
import com.tencent.mm.sdcard_migrate.e;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(7)
public class ExtStorageMigrateAuxActivity extends HellActivity {
    private static final Random NGk = new Random();
    private static final Set<Integer> NGl = new HashSet(5);
    private static WeakReference<ExtStorageMigrateAuxActivity> NGm = null;
    private static Context ckW = null;
    private final Map<Integer, c> NGn = new HashMap();
    private final Map<Integer, b> NGo = new HashMap();
    private com.tencent.mm.sdcard_migrate.a.c NGp = null;
    private boolean NGq = false;
    private a NGr = new a(this, false);
    private AuxMigrateResultCallback NGs = new AuxMigrateResultCallback(this);
    private boolean NGt = false;

    /* access modifiers changed from: package-private */
    public interface b {
        void gwF();
    }

    /* access modifiers changed from: package-private */
    public interface c {
        void blu();

        void dg(String str, boolean z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExtStorageMigrateAuxActivity() {
        AppMethodBeat.i(176049);
        AppMethodBeat.o(176049);
    }

    static /* synthetic */ void b(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity) {
        AppMethodBeat.i(204575);
        extStorageMigrateAuxActivity.AB(false);
        AppMethodBeat.o(204575);
    }

    static {
        AppMethodBeat.i(176060);
        AppMethodBeat.o(176060);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity;
        AppMethodBeat.i(176050);
        super.onCreate(bundle);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", this);
        ckW = getApplicationContext();
        LocaleUtil.initLanguage(this);
        setContentView(R.layout.b76);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        if (NGm != null) {
            extStorageMigrateAuxActivity = NGm.get();
        } else {
            extStorageMigrateAuxActivity = null;
        }
        if (extStorageMigrateAuxActivity == null || extStorageMigrateAuxActivity.isFinishing() || extStorageMigrateAuxActivity.isDestroyed()) {
            NGm = new WeakReference<>(this);
        } else if (extStorageMigrateAuxActivity != this) {
            ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", this, extStorageMigrateAuxActivity);
            finish();
            AppMethodBeat.o(176050);
            return;
        }
        NGl.clear();
        this.NGn.clear();
        this.NGo.clear();
        if (this.NGp != null) {
            this.NGp.dismiss();
            this.NGp = null;
        }
        this.NGq = false;
        this.NGt = false;
        AppMethodBeat.o(176050);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(176051);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", this);
        super.onNewIntent(intent);
        setIntent(intent);
        AppMethodBeat.o(176051);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(176052);
        super.onResume();
        if (!this.NGq) {
            this.NGq = true;
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    char c2 = 65535;
                    switch (action.hashCode()) {
                        case -1134382594:
                            if (action.equals("auxui_action_do_migrate_routine")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (!ExtStorageMigrateRoutine.needsToDoMigrate(this)) {
                                ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
                                ExtStorageMigrateRoutine.startWeChat(this);
                                finish();
                                AppMethodBeat.o(176052);
                                return;
                            } else if (b.gwZ()) {
                                ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
                                ExtStorageMigrateRoutine.startWeChat(this);
                                finish();
                                AppMethodBeat.o(176052);
                                return;
                            } else if (intent.getBooleanExtra("auxui_param_is_migration_end", false)) {
                                ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
                                ExtStorageMigrateRoutine.startWeChat(this);
                                finish();
                                AppMethodBeat.o(176052);
                                return;
                            } else {
                                b.gxc();
                                ExtStorageMigrateRoutine.startupMigrationService(this);
                                this.NGt = ExtStorageMigrateRoutine.bindMigrationService(this, this.NGr);
                                if (!this.NGt) {
                                    ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
                                    AB(true);
                                }
                                AppMethodBeat.o(176052);
                                return;
                            }
                        default:
                            ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(action)), new Object[0]);
                            finish();
                            break;
                    }
                } else {
                    ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
                    finish();
                    AppMethodBeat.o(176052);
                    return;
                }
            } else {
                ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
                finish();
                AppMethodBeat.o(176052);
                return;
            }
        }
        AppMethodBeat.o(176052);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(176053);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", this);
        super.onDestroy();
        if (this.NGp != null) {
            this.NGp.dismiss();
            this.NGp = null;
        }
        AB(false);
        this.NGo.clear();
        this.NGn.clear();
        ExtStorageMigrateMonitor.gwN();
        AppMethodBeat.o(176053);
    }

    private void AB(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(204572);
        if (this.NGp != null && this.NGp.isShowing()) {
            this.NGp.dismiss();
        }
        e eVar = this.NGr.NGG;
        if (eVar != null && eVar.asBinder().isBinderAlive()) {
            try {
                eVar.gwW();
                z2 = true;
            } catch (Throwable th) {
            }
        }
        try {
            unbindService(this.NGr);
        } catch (Throwable th2) {
        }
        if (!z2) {
            ExtStorageMigrateRoutine.cancelMigration(ckW);
        }
        b.gxd();
        if (z) {
            ExtStorageMigrateRoutine.startWeChat(this);
            finish();
        }
        AppMethodBeat.o(204572);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements ServiceConnection {
        private final WeakReference<ExtStorageMigrateAuxActivity> NGB;
        private final boolean NGF;
        private e NGG = null;

        a(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity, boolean z) {
            AppMethodBeat.i(204568);
            this.NGB = new WeakReference<>(extStorageMigrateAuxActivity);
            this.NGF = z;
            AppMethodBeat.o(204568);
        }

        @SuppressLint({"NewApi"})
        private ExtStorageMigrateAuxActivity gwG() {
            AppMethodBeat.i(204569);
            ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity = this.NGB.get();
            if (extStorageMigrateAuxActivity == null || extStorageMigrateAuxActivity.isFinishing() || extStorageMigrateAuxActivity.isDestroyed()) {
                AppMethodBeat.o(204569);
                return null;
            }
            AppMethodBeat.o(204569);
            return extStorageMigrateAuxActivity;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(204570);
            ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG != null) {
                gwG.NGt = true;
                this.NGG = e.a.N(iBinder);
                if (this.NGF) {
                    ExtStorageMigrateAuxActivity.a(gwG, this.NGG, false);
                    AppMethodBeat.o(204570);
                    return;
                }
                ExtStorageMigrateAuxActivity.a(gwG, this.NGG);
                AppMethodBeat.o(204570);
                return;
            }
            ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
            AppMethodBeat.o(204570);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(204571);
            ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", componentName);
            ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG != null) {
                gwG.NGt = false;
            }
            AppMethodBeat.o(204571);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class AuxMigrateResultCallback extends MigrateResultCallbackAdapter {
        private final WeakReference<ExtStorageMigrateAuxActivity> NGB;
        private int NGC = 0;

        AuxMigrateResultCallback(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity) {
            AppMethodBeat.i(204560);
            this.NGB = new WeakReference<>(extStorageMigrateAuxActivity);
            AppMethodBeat.o(204560);
        }

        @SuppressLint({"NewApi"})
        private ExtStorageMigrateAuxActivity gwG() {
            AppMethodBeat.i(204561);
            ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity = this.NGB.get();
            if (extStorageMigrateAuxActivity == null || extStorageMigrateAuxActivity.isFinishing() || extStorageMigrateAuxActivity.isDestroyed()) {
                AppMethodBeat.o(204561);
                return null;
            }
            AppMethodBeat.o(204561);
            return extStorageMigrateAuxActivity;
        }

        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void kI(int i2, int i3) {
            AppMethodBeat.i(204562);
            ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(204562);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void gwH() {
            com.tencent.mm.sdcard_migrate.a.c gxm;
            AppMethodBeat.i(204563);
            final ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG == null) {
                AppMethodBeat.o(204563);
                return;
            }
            if (gwG.NGp != null && gwG.NGp.isShowing()) {
                gwG.NGp.dismiss();
            }
            String ajB = ExtStorageMigrateAuxActivity.ajB(R.string.c3q);
            String ajB2 = ExtStorageMigrateAuxActivity.ajB(R.string.sz);
            AnonymousClass1 r5 = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AuxMigrateResultCallback.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(204556);
                    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
                    ExtStorageMigrateAuxActivity.b(gwG);
                    AppMethodBeat.o(204556);
                }
            };
            if (!(gwG instanceof Activity) || !gwG.isFinishing()) {
                c.a aVar = new c.a(gwG);
                aVar.bhS(null);
                aVar.bhT(ajB);
                aVar.bhU(ajB2).a(r5);
                aVar.AI(false);
                gxm = aVar.gxm();
                gxm.show();
                com.tencent.mm.sdcard_migrate.a.b.a(gwG, gxm);
            } else {
                gxm = null;
            }
            gwG.NGp = gxm;
            AppMethodBeat.o(204563);
        }

        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void ajC(int i2) {
            AppMethodBeat.i(204564);
            if (i2 == 3 || i2 == 2) {
                ExtStorageMigrateMonitor.ME(108);
            }
            final ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG == null) {
                AppMethodBeat.o(204564);
                return;
            }
            if (gwG.NGp != null && gwG.NGp.isShowing()) {
                gwG.NGp.dismiss();
            }
            gwG.NGp = com.tencent.mm.sdcard_migrate.a.b.b(gwG, ExtStorageMigrateAuxActivity.ajB(R.string.c3l), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AuxMigrateResultCallback.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(204557);
                    dialogInterface.dismiss();
                    ExtStorageMigrateRoutine.startWeChat(gwG);
                    ExtStorageMigrateAuxActivity.c(gwG);
                    gwG.finish();
                    AppMethodBeat.o(204557);
                }
            });
            AppMethodBeat.o(204564);
        }

        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void ajD(int i2) {
            AppMethodBeat.i(204565);
            ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG == null) {
                AppMethodBeat.o(204565);
                return;
            }
            if (gwG.NGp != null && gwG.NGp.isShowing()) {
                String format = String.format(ExtStorageMigrateAuxActivity.ajB(R.string.c3p), i2 + "%");
                CharSequence charSequence = null;
                switch (this.NGC) {
                    case 0:
                        charSequence = "—";
                        this.NGC = 1;
                        break;
                    case 1:
                        charSequence = "\\";
                        this.NGC = 2;
                        break;
                    case 2:
                        charSequence = "|";
                        this.NGC = 3;
                        break;
                    case 3:
                        charSequence = FilePathGenerator.ANDROID_DIR_SEP;
                        this.NGC = 0;
                        break;
                }
                gwG.NGp.setMessage(format);
                com.tencent.mm.sdcard_migrate.a.c cVar = gwG.NGp;
                cVar.NIK.setVisibility(0);
                cVar.NID.setVisibility(0);
                if (cVar.NIU != null) {
                    c.a.AbstractC2051c cVar2 = cVar.NIU;
                    cVar.NIC.getContext();
                    charSequence.toString();
                    cVar.NID.getTextSize();
                    charSequence = cVar2.gxn();
                }
                cVar.NID.setText(charSequence);
            }
            AppMethodBeat.o(204565);
        }

        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void a(int i2, ExtStorageMigrateException extStorageMigrateException) {
            String ajB;
            AppMethodBeat.i(204566);
            switch (i2) {
                case 4:
                    ExtStorageMigrateMonitor.ME(109);
                    break;
                case 5:
                    ExtStorageMigrateMonitor.ME(113);
                    break;
                case 6:
                    ExtStorageMigrateMonitor.ME(110);
                    break;
                case 7:
                    ExtStorageMigrateMonitor.ME(111);
                    break;
                case 8:
                    ExtStorageMigrateMonitor.ME(112);
                    break;
            }
            final ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG == null) {
                AppMethodBeat.o(204566);
                return;
            }
            if (gwG.NGp != null && gwG.NGp.isShowing()) {
                gwG.NGp.dismiss();
            }
            if (i2 == 6) {
                ajB = ExtStorageMigrateAuxActivity.ajB(R.string.c3o);
            } else {
                ajB = ExtStorageMigrateAuxActivity.ajB(R.string.c3m);
            }
            gwG.NGp = com.tencent.mm.sdcard_migrate.a.b.b(gwG, ajB, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AuxMigrateResultCallback.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(204558);
                    dialogInterface.dismiss();
                    ExtStorageMigrateRoutine.startWeChat(gwG);
                    ExtStorageMigrateAuxActivity.c(gwG);
                    gwG.finish();
                    AppMethodBeat.o(204558);
                }
            });
            AppMethodBeat.o(204566);
        }

        @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
        public final void gwI() {
            AppMethodBeat.i(204567);
            ExtStorageMigrateMonitor.ME(107);
            b.gxf();
            final ExtStorageMigrateAuxActivity gwG = gwG();
            if (gwG == null) {
                AppMethodBeat.o(204567);
                return;
            }
            if (gwG.NGp != null && gwG.NGp.isShowing()) {
                gwG.NGp.dismiss();
            }
            gwG.NGp = com.tencent.mm.sdcard_migrate.a.b.b(gwG, ExtStorageMigrateAuxActivity.ajB(R.string.c3u), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AuxMigrateResultCallback.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(204559);
                    dialogInterface.dismiss();
                    ExtStorageMigrateRoutine.startWeChat(gwG);
                    ExtStorageMigrateAuxActivity.c(gwG);
                    gwG.finish();
                    AppMethodBeat.o(204559);
                }
            });
            AppMethodBeat.o(204567);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z = true;
        AppMethodBeat.i(176056);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        c cVar = this.NGn.get(Integer.valueOf(i2));
        if (cVar == null) {
            ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", Integer.valueOf(i2));
            finish();
            AppMethodBeat.o(176056);
            return;
        }
        ajA(i2);
        if (strArr.length == 0) {
            ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
            ajA(i2);
            AppMethodBeat.o(176056);
            return;
        }
        String str = strArr[0];
        if (iArr[0] == 0) {
            cVar.blu();
            AppMethodBeat.o(176056);
            return;
        }
        if (android.support.v4.app.a.a(this, str)) {
            z = false;
        }
        cVar.dg(str, z);
        AppMethodBeat.o(176056);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(176057);
        super.onActivityResult(i2, i3, intent);
        b bVar = this.NGo.get(Integer.valueOf(i2));
        if (bVar == null) {
            ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", Integer.valueOf(i2));
            AppMethodBeat.o(176057);
            return;
        }
        bVar.gwF();
        NGl.remove(Integer.valueOf(i2));
        this.NGo.remove(Integer.valueOf(i2));
        AppMethodBeat.o(176057);
    }

    private static int gwD() {
        AppMethodBeat.i(176054);
        while (true) {
            int nextInt = (int) (((long) NGk.nextInt()) + (System.nanoTime() & Util.MAX_32BIT_VALUE));
            if (nextInt < 0) {
                nextInt = -nextInt;
            }
            if (nextInt != 0 && !NGl.contains(Integer.valueOf(nextInt))) {
                NGl.add(Integer.valueOf(nextInt));
                AppMethodBeat.o(176054);
                return nextInt;
            }
        }
    }

    private void ajA(int i2) {
        AppMethodBeat.i(176055);
        NGl.remove(Integer.valueOf(i2));
        this.NGn.remove(Integer.valueOf(i2));
        AppMethodBeat.o(176055);
    }

    static /* synthetic */ void a(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity, e eVar, boolean z) {
        AppMethodBeat.i(204573);
        try {
            eVar.a(extStorageMigrateAuxActivity.NGs);
            eVar.a(ExtStorageMigrateRoutine.DEFAULT_CONFIG);
            AppMethodBeat.o(204573);
        } catch (RemoteException e2) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateAuxActivity", e2, "[-] Exception occurred, try to rebind.", new Object[0]);
            if (z) {
                ExtStorageMigrateRoutine.startupMigrationService(ckW);
                extStorageMigrateAuxActivity.NGr = new a(extStorageMigrateAuxActivity, true);
                ExtStorageMigrateRoutine.bindMigrationService(ckW, extStorageMigrateAuxActivity.NGr);
                AppMethodBeat.o(204573);
                return;
            }
            try {
                extStorageMigrateAuxActivity.NGs.b(5, new ExtStorageMigrateException(e2));
                AppMethodBeat.o(204573);
            } catch (RemoteException e3) {
                AppMethodBeat.o(204573);
            }
        }
    }

    static /* synthetic */ String ajB(int i2) {
        AppMethodBeat.i(204574);
        String string = MMApplicationContext.getResources().getString(i2);
        AppMethodBeat.o(204574);
        return string;
    }

    static /* synthetic */ void a(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity, b bVar) {
        AppMethodBeat.i(204576);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", extStorageMigrateAuxActivity.getPackageName(), null));
        int gwD = gwD();
        extStorageMigrateAuxActivity.NGo.put(Integer.valueOf(gwD), bVar);
        extStorageMigrateAuxActivity.startActivityForResult(intent, gwD);
        AppMethodBeat.o(204576);
    }

    static /* synthetic */ void a(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity, String str, c cVar) {
        AppMethodBeat.i(204577);
        if (android.support.v4.app.a.checkSelfPermission(ckW, str) == 0) {
            cVar.blu();
            AppMethodBeat.o(204577);
            return;
        }
        int gwD = gwD();
        extStorageMigrateAuxActivity.NGn.put(Integer.valueOf(gwD), cVar);
        android.support.v4.app.a.a(extStorageMigrateAuxActivity, new String[]{str}, gwD);
        AppMethodBeat.o(204577);
    }

    static /* synthetic */ void a(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity, final e eVar) {
        AppMethodBeat.i(204578);
        try {
            eVar.a(extStorageMigrateAuxActivity.NGs);
            if (eVar.gwS()) {
                AppMethodBeat.o(204578);
                return;
            }
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateAuxActivity", th, "[-] Exception occurred, do questionnaire.", new Object[0]);
        }
        new a(new a.b() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass3 */

            @Override // com.tencent.mm.sdcard_migrate.a.b
            public final void a(final a.C2049a aVar) {
                AppMethodBeat.i(176036);
                if (ExtStorageMigrateAuxActivity.this.NGp != null && ExtStorageMigrateAuxActivity.this.NGp.isShowing()) {
                    ExtStorageMigrateAuxActivity.this.NGp.dismiss();
                }
                ExtStorageMigrateAuxActivity.this.NGp = com.tencent.mm.sdcard_migrate.a.b.a(ExtStorageMigrateAuxActivity.this, ExtStorageMigrateAuxActivity.ajB(R.string.c3r), ExtStorageMigrateAuxActivity.ajB(R.string.c3s), ExtStorageMigrateAuxActivity.ajB(R.string.c3k), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(176034);
                        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click yes on step 1.", new Object[0]);
                        ExtStorageMigrateMonitor.ME(104);
                        aVar.gwC();
                        AppMethodBeat.o(176034);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass3.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(176035);
                        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click no on step 1.", new Object[0]);
                        ExtStorageMigrateMonitor.ME(103);
                        ExtStorageMigrateAuxActivity.b(ExtStorageMigrateAuxActivity.this);
                        AppMethodBeat.o(176035);
                    }
                });
                AppMethodBeat.o(176036);
            }
        }).a(new a.b() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass2 */

            @Override // com.tencent.mm.sdcard_migrate.a.b
            public final void a(final a.C2049a aVar) {
                AppMethodBeat.i(176033);
                ExtStorageMigrateAuxActivity.a(ExtStorageMigrateAuxActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE", new c() {
                    /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.c
                    public final void blu() {
                        AppMethodBeat.i(176031);
                        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click yes on permission dlg.", new Object[0]);
                        aVar.gwC();
                        AppMethodBeat.o(176031);
                    }

                    @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.c
                    public final void dg(final String str, boolean z) {
                        AppMethodBeat.i(176032);
                        if (z) {
                            ExtStorageMigrateMonitor.ME(106);
                            if (ExtStorageMigrateAuxActivity.this.NGp != null && ExtStorageMigrateAuxActivity.this.NGp.isShowing()) {
                                ExtStorageMigrateAuxActivity.this.NGp.dismiss();
                            }
                            ExtStorageMigrateAuxActivity.this.NGp = com.tencent.mm.sdcard_migrate.a.b.a(ExtStorageMigrateAuxActivity.this, ExtStorageMigrateAuxActivity.ajB(R.string.c3v), ExtStorageMigrateAuxActivity.ajB(R.string.c3n), ExtStorageMigrateAuxActivity.ajB(R.string.c3k), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(176029);
                                    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click yes on ask jump dlg.", new Object[0]);
                                    ExtStorageMigrateAuxActivity.a(ExtStorageMigrateAuxActivity.this, new b() {
                                        /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.b
                                        public final void gwF() {
                                            AppMethodBeat.i(176028);
                                            if (com.tencent.mm.pluginsdk.permission.b.e(ExtStorageMigrateAuxActivity.ckW, str)) {
                                                ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] Back from settings, storage permission was granted.", new Object[0]);
                                                aVar.gwC();
                                                AppMethodBeat.o(176028);
                                                return;
                                            }
                                            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] Back from settings, storage permission was denied.", new Object[0]);
                                            ExtStorageMigrateMonitor.ME(105);
                                            ExtStorageMigrateAuxActivity.b(ExtStorageMigrateAuxActivity.this);
                                            AppMethodBeat.o(176028);
                                        }
                                    });
                                    AppMethodBeat.o(176029);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass2.AnonymousClass1.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(176030);
                                    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click no on ask jump dlg.", new Object[0]);
                                    ExtStorageMigrateMonitor.ME(105);
                                    ExtStorageMigrateAuxActivity.b(ExtStorageMigrateAuxActivity.this);
                                    AppMethodBeat.o(176030);
                                }
                            });
                            AppMethodBeat.o(176032);
                            return;
                        }
                        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click no on permission dlg.", new Object[0]);
                        ExtStorageMigrateMonitor.ME(105);
                        ExtStorageMigrateAuxActivity.b(ExtStorageMigrateAuxActivity.this);
                        AppMethodBeat.o(176032);
                    }
                });
                AppMethodBeat.o(176033);
            }
        }).a(new a.b() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity.AnonymousClass1 */

            @Override // com.tencent.mm.sdcard_migrate.a.b
            public final void a(a.C2049a aVar) {
                AppMethodBeat.i(176027);
                ExtStorageMigrateAuxActivity.a(ExtStorageMigrateAuxActivity.this, eVar, true);
                AppMethodBeat.o(176027);
            }
        }).NGi.gwC();
        AppMethodBeat.o(204578);
    }

    static /* synthetic */ void c(ExtStorageMigrateAuxActivity extStorageMigrateAuxActivity) {
        AppMethodBeat.i(204579);
        ((NotificationManager) extStorageMigrateAuxActivity.getSystemService("notification")).cancel(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC);
        AppMethodBeat.o(204579);
    }
}
