package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.z;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.a;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.h.b;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import java.util.Locale;

public final class WorkerProfile extends d implements i, z.a, n, aw, f.a, IKVReportNotify {
    public static final String dkO = (MMApplicationContext.getPackageName());
    private static WorkerProfile dni;
    private static int dny = -1;
    private final int ID = 2130706432;
    private final Shell dng = new Shell();
    private final a dnh = new a();
    private ax dnj;
    private bw.b dnk;
    private an dnl;
    public boolean dnm = false;
    @Deprecated
    public boolean dnn;
    public boolean dno;
    private final int dnp = 0;
    private final int dnq = 1;
    private int dnr;
    private StringBuilder dns = new StringBuilder();
    private g dnt;
    private boolean dnu = true;
    private b dnv;
    public final al dnw = new al();
    public final ak dnx = new ak();
    protected Locale locale;

    static {
        AppMethodBeat.i(19603);
        AppMethodBeat.o(19603);
    }

    public WorkerProfile() {
        AppMethodBeat.i(19592);
        dni = this;
        AppMethodBeat.o(19592);
    }

    public static WorkerProfile Xg() {
        return dni;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0713, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0714, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WorkerProfile", r0, "", new java.lang.Object[0]);
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0736, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x07f7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0809  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0625  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x065d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0735 A[ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException), Splitter:B:1:0x008d] */
    @Override // com.tencent.mm.compatible.loader.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate() {
        /*
        // Method dump skipped, instructions count: 2068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.WorkerProfile.onCreate():void");
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onTerminate() {
        AppMethodBeat.i(19594);
        super.onTerminate();
        b bVar = this.dnv;
        Log.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", bVar.gpc, Integer.valueOf(bVar.gpe.size()));
        EventCenter.instance.removeListener(bVar.gpf);
        bVar.gpc = null;
        bVar.gpd.clear();
        bVar.gpe.clear();
        this.dnv = null;
        AppMethodBeat.o(19594);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
        e aZh;
        AppMethodBeat.i(19595);
        if (LocaleUtil.LANGUAGE_DEFAULT.equals(LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext()))) {
            Log.i("MicroMsg.WorkerProfile", "config locale %s", LocaleUtil.transLocaleToLanguage(configuration.locale));
            Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext(), LocaleUtil.transLocaleToLanguage(configuration.locale));
            Log.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", this.locale, initLanguage);
            if (!(initLanguage == null || this.locale == null || initLanguage.equals(this.locale))) {
                if (bg.aAc()) {
                    try {
                        com.tencent.mm.network.g gVar = bg.azz().iMw;
                        if (!(gVar == null || (aZh = gVar.aZh()) == null)) {
                            bg.aVF();
                            aZh.a(new byte[0], new byte[0], new byte[0], c.getUin());
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WorkerProfile", e2, "", new Object[0]);
                        Log.printErrStackTrace("MicroMsg.WorkerProfile", e2, "what the f$!k", new Object[0]);
                    }
                }
                Log.w("MicroMsg.WorkerProfile", "language changed, restart process");
                com.tencent.mm.bv.a.iH(MMApplicationContext.getContext());
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
            }
        }
        AppMethodBeat.o(19595);
    }

    public final String toString() {
        return dkO;
    }

    @Override // com.tencent.mm.model.aw
    public final ax getNotification() {
        AppMethodBeat.i(19596);
        if (this.dnj == null) {
            this.dnj = new com.tencent.mm.booter.notification.c(this.app);
        }
        ax axVar = this.dnj;
        AppMethodBeat.o(19596);
        return axVar;
    }

    @Override // com.tencent.mm.model.aw
    public final bw.b Xh() {
        AppMethodBeat.i(19597);
        if (this.dnk == null) {
            this.dnk = new bw.b() {
                /* class com.tencent.mm.app.WorkerProfile.AnonymousClass27 */

                @Override // com.tencent.mm.storage.bw.b
                public final void a(ca caVar, PString pString, PString pString2, PInt pInt, boolean z) {
                    AppMethodBeat.i(19582);
                    h.b(caVar, pString, pString2, pInt, z);
                    AppMethodBeat.o(19582);
                }

                @Override // com.tencent.mm.storage.bw.b
                public final String a(int i2, String str, String str2, int i3, Context context) {
                    AppMethodBeat.i(19583);
                    String a2 = h.a(i2, str, str2, i3, context);
                    AppMethodBeat.o(19583);
                    return a2;
                }
            };
        }
        bw.b bVar = this.dnk;
        AppMethodBeat.o(19597);
        return bVar;
    }

    @Override // com.tencent.mm.model.aw
    public final an Xi() {
        AppMethodBeat.i(19598);
        if (this.dnl == null) {
            this.dnl = com.tencent.mm.booter.a.akp();
        }
        an anVar = this.dnl;
        AppMethodBeat.o(19598);
        return anVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(19599);
        Log.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            Log.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", Util.getStack(), Long.valueOf(Thread.currentThread().getId()));
        }
        if (i2 == 4 && i3 == -3002) {
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                AppMethodBeat.o(19599);
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            Log.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", str);
            ar arVar = new ar();
            arVar.dDD.type = 4;
            arVar.dDD.event = str;
            EventCenter.instance.publish(arVar);
            AppMethodBeat.o(19599);
        } else if (!bg.aAc() || i2 != 4 || (!(i3 == -6 || i3 == -310 || i3 == -311) || str == null || !str.startsWith("autoauth_errmsg_"))) {
            if (qVar.getType() == 701 || qVar.getType() == 702 || qVar.getType() == 126 || qVar.getType() == 252 || qVar.getType() == 763 || qVar.getType() == 138) {
                if (i2 == 4 && i3 == -213) {
                    ma maVar = new ma();
                    maVar.dRA.status = 0;
                    maVar.dRA.bDZ = 3;
                    EventCenter.instance.publish(maVar);
                    if (AccountDeletedAlphaAlertUI.gXm() != null) {
                        AppMethodBeat.o(19599);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(MMApplicationContext.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
                    intent.putExtra("errmsg", str);
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(19599);
                    return;
                } else if (i2 == 4 && (i3 == -100 || i3 == -2023)) {
                    ma maVar2 = new ma();
                    maVar2.dRA.status = 0;
                    maVar2.dRA.bDZ = 1;
                    EventCenter.instance.publish(maVar2);
                }
            }
            AppMethodBeat.o(19599);
        } else if (NewTaskUI.gXN() != null) {
            AppMethodBeat.o(19599);
        } else {
            Intent intent2 = new Intent();
            intent2.setClass(MMApplicationContext.getContext(), NewTaskUI.class).addFlags(268435456);
            Context context2 = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19599);
        }
    }

    @Override // com.tencent.mm.app.n
    public final void Wq() {
        this.dnu = true;
    }

    @Override // com.tencent.mm.app.n
    public final void Wr() {
        this.dnu = false;
    }

    @Override // com.tencent.mm.plugin.report.service.IKVReportNotify
    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i2) {
        AppMethodBeat.i(19600);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.app.WorkerProfile.AnonymousClass28 */

            public final void run() {
                AppMethodBeat.i(19584);
                if (bg.aVy()) {
                    AppMethodBeat.o(19584);
                    return;
                }
                Log.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + i2);
                bg.azz().a(new com.tencent.mm.plugin.report.b.e(bArr2, i2), 0);
                AppMethodBeat.o(19584);
            }
        });
        AppMethodBeat.o(19600);
    }

    @Override // com.tencent.mm.ak.z.a
    public final void gs(String str) {
        AppMethodBeat.i(19601);
        Log.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", str);
        ar arVar = new ar();
        arVar.dDD.type = 4;
        arVar.dDD.event = str;
        EventCenter.instance.publish(arVar);
        AppMethodBeat.o(19601);
    }

    @Override // com.tencent.mm.model.f.a
    public final void gt(String str) {
        AppMethodBeat.i(19602);
        Log.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", str);
        ar arVar = new ar();
        arVar.dDD.type = 1;
        arVar.dDD.event = str;
        EventCenter.instance.publish(arVar);
        AppMethodBeat.o(19602);
    }
}
