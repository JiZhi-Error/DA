package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.b;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i implements o {
    public static i CyW = new i();
    public static final long CyX = (TimeUnit.MILLISECONDS.convert(b.Tw().cPm, TimeUnit.NANOSECONDS) + 1);
    private boolean CyY = false;
    private long CyZ;
    private long Cza;
    public int Czb;
    public long Czc;
    private int[] Czd;
    public long[] Cze;
    public com.tencent.matrix.trace.e.b Czf;
    private long Czg;
    private long Czh;
    private int[] Czi;
    private com.tencent.matrix.trace.e.b Czj;
    public c daF;
    public MMHandler mainHandler;

    static /* synthetic */ void l(i iVar) {
        AppMethodBeat.i(143919);
        iVar.eOJ();
        AppMethodBeat.o(143919);
    }

    static {
        AppMethodBeat.i(143920);
        AppMethodBeat.o(143920);
    }

    private i() {
        c cVar;
        a aVar;
        AppMethodBeat.i(143913);
        if (!com.tencent.matrix.b.isInstalled() || (aVar = (a) com.tencent.matrix.b.RG().Y(a.class)) == null || !aVar.isPluginStarted()) {
            cVar = null;
        } else {
            cVar = aVar.daF;
        }
        this.daF = cVar;
        this.mainHandler = new MMHandler(Looper.getMainLooper());
        this.CyZ = 0;
        this.Cza = 0;
        this.Czb = 0;
        this.Czc = 0;
        this.Czd = new int[c.b.values().length];
        this.Cze = new long[21];
        this.Czf = new com.tencent.matrix.trace.e.b() {
            /* class com.tencent.mm.plugin.report.service.i.AnonymousClass1 */

            @Override // com.tencent.matrix.trace.e.b
            public final void a(String str, long j2, long j3, int i2, boolean z) {
                AppMethodBeat.i(143909);
                super.a(str, j2, j3, i2, z);
                i.this.CyZ += ((long) (i2 + 1)) * i.CyX;
                i.this.Cza++;
                if (i2 >= 42) {
                    int[] iArr = i.this.Czd;
                    int i3 = c.b.DROPPED_FROZEN.index;
                    iArr[i3] = iArr[i3] + 1;
                    AppMethodBeat.o(143909);
                } else if (i2 >= 24) {
                    int[] iArr2 = i.this.Czd;
                    int i4 = c.b.DROPPED_HIGH.index;
                    iArr2[i4] = iArr2[i4] + 1;
                    AppMethodBeat.o(143909);
                } else if (i2 >= 9) {
                    int[] iArr3 = i.this.Czd;
                    int i5 = c.b.DROPPED_MIDDLE.index;
                    iArr3[i5] = iArr3[i5] + 1;
                    AppMethodBeat.o(143909);
                } else if (i2 >= 3) {
                    int[] iArr4 = i.this.Czd;
                    int i6 = c.b.DROPPED_NORMAL.index;
                    iArr4[i6] = iArr4[i6] + 1;
                    AppMethodBeat.o(143909);
                } else {
                    int[] iArr5 = i.this.Czd;
                    int i7 = c.b.DROPPED_BEST.index;
                    iArr5[i7] = iArr5[i7] + 1;
                    AppMethodBeat.o(143909);
                }
            }
        };
        this.Czg = 0;
        this.Czh = 0;
        this.Czi = new int[c.b.values().length];
        this.Czj = new com.tencent.matrix.trace.e.b() {
            /* class com.tencent.mm.plugin.report.service.i.AnonymousClass3 */

            @Override // com.tencent.matrix.trace.e.b
            public final void a(String str, long j2, long j3, int i2, boolean z) {
                AppMethodBeat.i(143911);
                super.a(str, j2, j3, i2, z);
                i.this.Czg += ((long) (i2 + 1)) * i.CyX;
                i.this.Czh++;
                if (i2 >= 42) {
                    int[] iArr = i.this.Czi;
                    int i3 = c.b.DROPPED_FROZEN.index;
                    iArr[i3] = iArr[i3] + 1;
                    AppMethodBeat.o(143911);
                } else if (i2 >= 24) {
                    int[] iArr2 = i.this.Czi;
                    int i4 = c.b.DROPPED_HIGH.index;
                    iArr2[i4] = iArr2[i4] + 1;
                    AppMethodBeat.o(143911);
                } else if (i2 >= 9) {
                    int[] iArr3 = i.this.Czi;
                    int i5 = c.b.DROPPED_MIDDLE.index;
                    iArr3[i5] = iArr3[i5] + 1;
                    AppMethodBeat.o(143911);
                } else if (i2 >= 3) {
                    int[] iArr4 = i.this.Czi;
                    int i6 = c.b.DROPPED_NORMAL.index;
                    iArr4[i6] = iArr4[i6] + 1;
                    AppMethodBeat.o(143911);
                } else {
                    int[] iArr5 = i.this.Czi;
                    int i7 = c.b.DROPPED_BEST.index;
                    iArr5[i7] = iArr5[i7] + 1;
                    AppMethodBeat.o(143911);
                }
            }
        };
        AppForegroundDelegate.INSTANCE.a(this);
        AppMethodBeat.o(143913);
    }

    public final void tN(boolean z) {
        AppMethodBeat.i(143914);
        Log.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(z)));
        this.CyY = z;
        if (!this.CyY) {
            if (this.daF == null) {
                AppMethodBeat.o(143914);
                return;
            } else {
                this.daF.b(this.Czj);
                eOJ();
            }
        }
        AppMethodBeat.o(143914);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        AppMethodBeat.i(143915);
        if (this.CyY) {
            if (this.daF == null) {
                AppMethodBeat.o(143915);
                return;
            } else {
                this.daF.a(this.Czj);
                this.mainHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.report.service.i.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(143912);
                        i.this.daF.b(i.this.Czj);
                        i.l(i.this);
                        AppMethodBeat.o(143912);
                    }
                }, 5000);
            }
        }
        AppMethodBeat.o(143915);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(143916);
        if (this.daF == null) {
            AppMethodBeat.o(143916);
            return;
        }
        this.daF.b(this.Czj);
        AppMethodBeat.o(143916);
    }

    private void eOJ() {
        AppMethodBeat.i(143917);
        float min = this.Czg > 0 ? Math.min(60.0f, (1000.0f * ((float) this.Czh)) / ((float) this.Czg)) : 0.0f;
        if (min <= 0.0f) {
            AppMethodBeat.o(143917);
            return;
        }
        Log.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + min + " mainUIFrameCost=" + this.Czg + LocaleUtil.MALAY);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(1232);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(1232);
        iDKey2.SetKey(1);
        iDKey2.SetValue((long) min);
        if (iDKey2.GetValue() > 0) {
            arrayList.add(iDKey2);
        }
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(1232);
        iDKey3.SetKey(10);
        iDKey3.SetValue((long) this.Czi[c.b.DROPPED_BEST.index]);
        if (iDKey3.GetValue() > 0) {
            arrayList.add(iDKey3);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(1232);
            iDKey4.SetKey(11);
            iDKey4.SetValue(1);
            arrayList.add(iDKey4);
        }
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(1232);
        iDKey5.SetKey(12);
        iDKey5.SetValue((long) this.Czi[c.b.DROPPED_NORMAL.index]);
        if (iDKey5.GetValue() > 0) {
            arrayList.add(iDKey5);
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(1232);
            iDKey6.SetKey(13);
            iDKey6.SetValue(1);
            arrayList.add(iDKey6);
        }
        IDKey iDKey7 = new IDKey();
        iDKey7.SetID(1232);
        iDKey7.SetKey(14);
        iDKey7.SetValue((long) this.Czi[c.b.DROPPED_MIDDLE.index]);
        if (iDKey7.GetValue() > 0) {
            arrayList.add(iDKey7);
            IDKey iDKey8 = new IDKey();
            iDKey8.SetID(1232);
            iDKey8.SetKey(15);
            iDKey8.SetValue(1);
            arrayList.add(iDKey8);
        }
        IDKey iDKey9 = new IDKey();
        iDKey9.SetID(1232);
        iDKey9.SetKey(16);
        iDKey9.SetValue((long) this.Czi[c.b.DROPPED_HIGH.index]);
        if (iDKey9.GetValue() > 0) {
            arrayList.add(iDKey9);
            IDKey iDKey10 = new IDKey();
            iDKey10.SetID(1232);
            iDKey10.SetKey(17);
            iDKey10.SetValue(1);
            arrayList.add(iDKey10);
        }
        IDKey iDKey11 = new IDKey();
        iDKey11.SetID(1232);
        iDKey11.SetKey(18);
        iDKey11.SetValue((long) this.Czi[c.b.DROPPED_FROZEN.index]);
        if (iDKey11.GetValue() > 0) {
            arrayList.add(iDKey11);
            IDKey iDKey12 = new IDKey();
            iDKey12.SetID(1232);
            iDKey12.SetKey(19);
            iDKey12.SetValue(1);
            arrayList.add(iDKey12);
        }
        e.INSTANCE.b(arrayList, false);
        this.Czi = new int[c.b.values().length];
        this.Czg = 0;
        this.Czh = 0;
        AppMethodBeat.o(143917);
    }

    static /* synthetic */ void g(i iVar) {
        AppMethodBeat.i(143918);
        float min = iVar.CyZ <= 0 ? 0.0f : Math.min(60.0f, (1000.0f * ((float) iVar.Cza)) / ((float) iVar.CyZ));
        long j2 = iVar.Cze[20] / 20;
        Log.i("MicroMsg.SceneFpsReportService", "[reportChatting] last 20 times FPS=" + min + " average duration=" + j2 + LocaleUtil.MALAY);
        if (min > 0.0f) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(1231);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(1231);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) min);
            if (iDKey2.GetValue() > 0) {
                arrayList.add(iDKey2);
            }
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(1231);
            iDKey3.SetKey(2);
            iDKey3.SetValue(j2);
            if (iDKey3.GetValue() > 0) {
                arrayList.add(iDKey3);
            }
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(1231);
            iDKey4.SetKey(10);
            iDKey4.SetValue((long) iVar.Czd[c.b.DROPPED_BEST.index]);
            if (iDKey4.GetValue() > 0) {
                arrayList.add(iDKey4);
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(1231);
                iDKey5.SetKey(11);
                iDKey5.SetValue(1);
                arrayList.add(iDKey5);
            }
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(1231);
            iDKey6.SetKey(12);
            iDKey6.SetValue((long) iVar.Czd[c.b.DROPPED_NORMAL.index]);
            if (iDKey6.GetValue() > 0) {
                arrayList.add(iDKey6);
                IDKey iDKey7 = new IDKey();
                iDKey7.SetID(1231);
                iDKey7.SetKey(13);
                iDKey7.SetValue(1);
                arrayList.add(iDKey7);
            }
            IDKey iDKey8 = new IDKey();
            iDKey8.SetID(1231);
            iDKey8.SetKey(14);
            iDKey8.SetValue((long) iVar.Czd[c.b.DROPPED_MIDDLE.index]);
            if (iDKey8.GetValue() > 0) {
                arrayList.add(iDKey8);
                IDKey iDKey9 = new IDKey();
                iDKey9.SetID(1231);
                iDKey9.SetKey(15);
                iDKey9.SetValue(1);
                arrayList.add(iDKey9);
            }
            IDKey iDKey10 = new IDKey();
            iDKey10.SetID(1231);
            iDKey10.SetKey(16);
            iDKey10.SetValue((long) iVar.Czd[c.b.DROPPED_HIGH.index]);
            if (iDKey10.GetValue() > 0) {
                arrayList.add(iDKey10);
                IDKey iDKey11 = new IDKey();
                iDKey11.SetID(1231);
                iDKey11.SetKey(17);
                iDKey11.SetValue(1);
                arrayList.add(iDKey11);
            }
            IDKey iDKey12 = new IDKey();
            iDKey12.SetID(1231);
            iDKey12.SetKey(18);
            iDKey12.SetValue((long) iVar.Czd[c.b.DROPPED_FROZEN.index]);
            if (iDKey12.GetValue() > 0) {
                arrayList.add(iDKey12);
                IDKey iDKey13 = new IDKey();
                iDKey13.SetID(1231);
                iDKey13.SetKey(19);
                iDKey13.SetValue(1);
                arrayList.add(iDKey13);
            }
            e.INSTANCE.b(arrayList, false);
            iVar.Czd = new int[c.b.values().length];
            iVar.Cze = new long[21];
            iVar.CyZ = 0;
            iVar.Cza = 0;
        }
        AppMethodBeat.o(143918);
    }
}
