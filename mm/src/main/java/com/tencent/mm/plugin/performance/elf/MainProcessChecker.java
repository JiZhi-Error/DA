package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker extends AbstractProcessChecker {
    private static final long[] AUC = {0, Util.MILLSECONDS_OF_DAY};
    private static String AUJ = "";
    private float AUA = (((float) this.AUz) * 0.01f);
    private boolean AUB = false;
    private long AUD;
    private int AUE = 1;
    private long AUF;
    private StringBuilder AUG = new StringBuilder();
    private boolean AUH = false;
    private long AUI = 0;
    private long AUt = 1048576;
    private long AUu = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private long AUv = 734003200;
    private long AUw = this.AUv;
    private int AUx = 92;
    private float AUy = (((float) this.AUx) * 0.01f);
    private int AUz = 85;
    private boolean ded = false;
    private boolean isHardMode = true;
    private long wxMobileRx;
    private long wxMobileTx;
    private long wxWifiRx;
    private long wxWifiTx;

    public MainProcessChecker() {
        AppMethodBeat.i(124985);
        AppMethodBeat.o(124985);
    }

    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final void start() {
        AppMethodBeat.i(124986);
        super.start();
        try {
            if (g.af(b.class) == null) {
                Log.w("MicroMsg.MainProcessChecker", "IExptService is null!");
                AppMethodBeat.o(124986);
                return;
            }
            this.AUH = q.is64BitRuntime();
            this.AUw = ((b) g.af(b.class)).a(b.a.clicfg_android_process_native, this.AUv);
            this.AUy = ((float) ((b) g.af(b.class)).a(b.a.clicfg_android_process_vm, this.AUx)) * 0.01f;
            this.AUA = ((float) ((b) g.af(b.class)).a(b.a.clicfg_android_process_java, this.AUz)) * 0.01f;
            AUC[0] = (long) ((b) g.af(b.class)).a(b.a.clicfg_android_process_work_begin, 0);
            AUC[1] = ((b) g.af(b.class)).a(b.a.clicfg_android_process_work_end, Util.MILLSECONDS_OF_DAY);
            this.AUt = ((b) g.af(b.class)).a(b.a.clicfg_android_process_traffic_per_min, 1048576L);
            this.AUu = ((b) g.af(b.class)).a(b.a.clicfg_android_process_jiffy_per_min, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
            this.isHardMode = ((b) g.af(b.class)).a(b.a.clicfg_android_process_is_hard_mode, true);
            this.AUB = ((b) g.af(b.class)).a(b.a.clicfg_android_process_is_check_launcher_ui, false);
            this.AUF = ((b) g.af(b.class)).a(b.a.clicfg_android_process_check_time, 1200000L);
            this.AUG.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.AUH).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(AUC[0]).append("-").append(AUC[1]).append("ms\n| NATIVE_SIZE:").append(this.AUw).append("B\n| MEMORY_VM_TOP:").append(this.AUy).append("%\n| MEMORY_JAVA_TOP:").append(this.AUA).append("%\n| TRAFFIC_PER_MIN:").append(this.AUt).append("B\n| JIFFIES_PER_MIN:").append(this.AUu).append("jiffy\n| CHECK_TIME:").append(this.AUF).append("ms\n************************************************\n");
            Log.i("MicroMsg.MainProcessChecker", this.AUG.toString());
            AppMethodBeat.o(124986);
        } catch (Exception e2) {
            Log.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", e2);
            AppMethodBeat.o(124986);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final String eCq() {
        AppMethodBeat.i(124987);
        StringBuilder sb = new StringBuilder(this.AUG);
        sb.append(super.eCq());
        HashMap hashMap = new HashMap();
        int aD = aD(hashMap);
        if (aD >= 300) {
            sb.append("threadCount:").append(aD).append("\n");
            sb.append(hashMap.toString()).append("\n");
            e.INSTANCE.idkeyStat(959, 8, 1, true);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(124987);
        return sb2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public String getTag() {
        return "MicroMsg.MainProcessChecker";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final void onScreenOff() {
        AppMethodBeat.i(124988);
        Log.i(getTag(), "onScreenOff enable:%s", Boolean.valueOf(this.ded));
        if (!this.ded) {
            AppMethodBeat.o(124988);
            return;
        }
        if (b.DEBUG || (!this.AUH && ((double) TN()) >= 3.99431958528E9d)) {
            this.AUE |= 256;
            hd(true);
            eCp();
        }
        AppMethodBeat.o(124988);
    }

    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final boolean af(long j2, long j3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(124989);
        this.ded = true;
        Log.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(this.cQp));
        boolean z6 = false;
        try {
            if (!this.ded) {
                this.AUE |= 0;
                eCu();
                hd(false);
                this.AUE = 1;
                AppMethodBeat.o(124989);
                return false;
            } else if (Util.isNullOrNil(this.AUh.AUk)) {
                Log.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
                this.AUE |= 2;
                eCu();
                hd(false);
                this.AUE = 1;
                AppMethodBeat.o(124989);
                return false;
            } else if (this.cQp) {
                Log.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
                this.AUE |= 4;
                eCu();
                hd(false);
                this.AUE = 1;
                AppMethodBeat.o(124989);
                return false;
            } else {
                if (SystemClock.uptimeMillis() - this.AUI >= j3) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Log.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", Long.valueOf(j3));
                    this.AUE |= 4;
                    eCu();
                    hd(false);
                    this.AUE = 1;
                    AppMethodBeat.o(124989);
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Calendar instance = Calendar.getInstance();
                instance.set(11, 0);
                instance.set(13, 0);
                instance.set(12, 0);
                instance.set(14, 0);
                long timeInMillis = currentTimeMillis - instance.getTimeInMillis();
                if (b.DEBUG || (AUC[0] <= timeInMillis && timeInMillis <= AUC[1])) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    Log.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", Long.valueOf(AUC[0]), Long.valueOf(AUC[1]));
                    this.AUE |= 8;
                    eCu();
                    hd(false);
                    this.AUE = 1;
                    AppMethodBeat.o(124989);
                    return false;
                }
                if (this.AUB) {
                    if (this.cQp || !AUJ.equalsIgnoreCase(this.AUh.AUk)) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z5) {
                        Log.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                        this.AUE |= 16;
                        eCu();
                        hd(false);
                        this.AUE = 1;
                        AppMethodBeat.o(124989);
                        return false;
                    }
                }
                if (eCt()) {
                    this.AUE |= 32;
                    eCu();
                    hd(false);
                    this.AUE = 1;
                    AppMethodBeat.o(124989);
                    return false;
                }
                if (this.isHardMode) {
                    long wxMobileTx2 = TrafficStats.getWxMobileTx(this.wxMobileTx) + TrafficStats.getWxMobileRx(this.wxMobileRx) + TrafficStats.getWxWifiTx(this.wxWifiTx) + TrafficStats.getWxMobileRx(this.wxWifiRx);
                    Log.i(getTag(), "[isTraffic] diff:%s byte", Long.valueOf(wxMobileTx2));
                    if (((float) wxMobileTx2) > ((1.0f * ((float) j3)) / 60000.0f) * ((float) this.AUt)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        this.AUE |= 512;
                        Log.i(getTag(), "is over Traffic, just return");
                        eCu();
                        hd(false);
                        this.AUE = 1;
                        AppMethodBeat.o(124989);
                        return false;
                    }
                }
                if (this.isHardMode) {
                    long Sr = Sr() - this.AUD;
                    Log.i(getTag(), "[isCpuBusy] diff:%s Jiffies", Long.valueOf(Sr));
                    if (((float) Sr) >= ((1.0f * ((float) j3)) / 60000.0f) * ((float) this.AUu)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        this.AUE |= 1024;
                        Log.i(getTag(), "is cpu busy, just return");
                        eCu();
                        hd(false);
                        this.AUE = 1;
                        AppMethodBeat.o(124989);
                        return false;
                    }
                }
                long maxMemory = Runtime.getRuntime().maxMemory();
                long j4 = Runtime.getRuntime().totalMemory();
                boolean z7 = false;
                Log.i(getTag(), "[isOverMemory] java[%s:%s]", Float.valueOf((1.0f * ((float) j4)) / ((float) maxMemory)), Float.valueOf(this.AUA));
                if ((1.0f * ((float) j4)) / ((float) maxMemory) >= this.AUA) {
                    this.AUE |= 64;
                    z7 = true;
                }
                if (!this.AUH) {
                    long TN = TN();
                    Log.i(getTag(), "[isOverMemory] vm[%s:%s]", Float.valueOf((1.0f * ((float) TN)) / 4.2949673E9f), Float.valueOf(this.AUy));
                    if ((1.0f * ((float) TN)) / 4.2949673E9f >= this.AUy) {
                        this.AUE |= 256;
                        z7 = true;
                    }
                }
                long nativeHeapSize = Debug.getNativeHeapSize();
                Log.w(getTag(), "[isOverMemory] native[%s:%s]", Long.valueOf(nativeHeapSize), Long.valueOf(this.AUw));
                if (nativeHeapSize > this.AUw) {
                    this.AUE |= 128;
                    z7 = true;
                }
                return z6;
            }
        } finally {
            eCu();
            hd(z6);
            this.AUE = 1;
            AppMethodBeat.o(124989);
        }
    }

    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final void cy(boolean z) {
        AppMethodBeat.i(124990);
        super.cy(z);
        Log.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", Boolean.valueOf(z));
        if (!z) {
            this.AUI = SystemClock.uptimeMillis();
        }
        AppMethodBeat.o(124990);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final boolean isEnable() {
        return this.ded;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final long eCr() {
        return this.AUF;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final void hJ(int i2, int i3) {
        AppMethodBeat.i(124991);
        super.hJ(i2, i3);
        Log.w(getTag(), "[onCallUp] %s -> %s", Integer.valueOf(i3), Integer.valueOf(i2));
        if (MMApplicationContext.isMMProcess()) {
            e.INSTANCE.idkeyStat(959, 1, 1, true);
            getWorkerHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.performance.elf.MainProcessChecker.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(124984);
                    if (MainProcessChecker.this.AUh.AUl) {
                        Log.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
                        e.INSTANCE.idkeyStat(959, 7, 1, true);
                        AppMethodBeat.o(124984);
                        return;
                    }
                    Log.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
                    AppMethodBeat.o(124984);
                }
            }, 30000);
        }
        AppMethodBeat.o(124991);
    }

    private void hd(boolean z) {
        AppMethodBeat.i(124992);
        if (!MMApplicationContext.isMMProcess() || !this.ded) {
            AppMethodBeat.o(124992);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        if (z) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(959);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(959);
            iDKey2.SetKey(2);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
            if (hK(this.AUE, 64)) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(959);
                iDKey3.SetKey(3);
                iDKey3.SetValue(1);
                arrayList.add(iDKey3);
            }
            if (hK(this.AUE, 256)) {
                IDKey iDKey4 = new IDKey();
                iDKey4.SetID(959);
                iDKey4.SetKey(4);
                iDKey4.SetValue(1);
                arrayList.add(iDKey4);
            }
            if (hK(this.AUE, 128)) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(959);
                iDKey5.SetKey(5);
                iDKey5.SetValue(1);
                arrayList.add(iDKey5);
            }
        } else {
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(959);
            iDKey6.SetValue(1);
            arrayList.add(iDKey6);
            if (hK(this.AUE, 8)) {
                iDKey6.SetKey(100);
            } else if (hK(this.AUE, 16)) {
                iDKey6.SetKey(101);
            } else if (hK(this.AUE, 32)) {
                iDKey6.SetKey(102);
            } else if (hK(this.AUE, 512)) {
                iDKey6.SetKey(103);
            } else if (hK(this.AUE, 1024)) {
                iDKey6.SetKey(104);
            } else if (hK(this.AUE, 64) || hK(this.AUE, 128) || hK(this.AUE, 256)) {
                iDKey6.SetKey(105);
            } else {
                arrayList.remove(iDKey6);
            }
        }
        IDKey iDKey7 = new IDKey();
        iDKey7.SetID(959);
        iDKey7.SetValue(1);
        arrayList.add(iDKey7);
        if (hK(this.AUE, 4)) {
            iDKey7.SetKey(106);
        } else {
            iDKey7.SetKey(107);
        }
        e.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(124992);
    }

    private static boolean hK(int i2, int i3) {
        return (i2 & i3) > 0;
    }

    private void eCu() {
        AppMethodBeat.i(124993);
        this.wxMobileTx = TrafficStats.getWxMobileTx(0);
        this.wxMobileRx = TrafficStats.getWxMobileRx(0);
        this.wxWifiTx = TrafficStats.getWxWifiTx(0);
        this.wxWifiRx = TrafficStats.getWxWifiRx(0);
        this.AUD = Sr();
        AppMethodBeat.o(124993);
    }

    public static void aJX(String str) {
        AUJ = str;
    }
}
