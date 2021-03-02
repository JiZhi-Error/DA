package com.tencent.mm.plugin.sport.model;

import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ck;
import java.util.Calendar;

public final class a {
    public c FiX;
    public IListener<wp> FiY = new IListener<wp>() {
        /* class com.tencent.mm.plugin.sport.model.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161589);
            this.__eventId = wp.class.getName().hashCode();
            AppMethodBeat.o(161589);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wp wpVar) {
            AppMethodBeat.i(149271);
            final wp wpVar2 = wpVar;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.sport.model.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    boolean z;
                    boolean z2;
                    AppMethodBeat.i(199374);
                    switch (wpVar2.ecH.action) {
                        case 1:
                        case 2:
                        case 3:
                            g.fmx();
                            if (a.fmn()) {
                                a.this.FiX.fmp();
                                long fml = a.fml();
                                if (wpVar2.ecH.action == 1) {
                                    z2 = a.this.Ka(fml);
                                } else if (k.as(a.this.fmk(), fml)) {
                                    z2 = a.this.Ka(fml);
                                } else {
                                    z2 = false;
                                }
                                Log.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", Integer.valueOf(wpVar2.ecH.action), Long.valueOf(fml), Boolean.valueOf(z2));
                                AppMethodBeat.o(199374);
                                return;
                            }
                            break;
                        case 4:
                        case 5:
                            g.fmx();
                            if (a.fmn()) {
                                long fml2 = a.fml();
                                a aVar = a.this;
                                if (aVar.Fjb == 0) {
                                    aVar.Fjb = j.aJ(3, 0);
                                }
                                boolean ar = k.ar(aVar.Fjb, System.currentTimeMillis());
                                boolean as = k.as(a.this.fmk(), fml2);
                                if (as || ar) {
                                    z = a.this.Ka(fml2);
                                } else {
                                    z = false;
                                }
                                Log.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", Integer.valueOf(wpVar2.ecH.action), Long.valueOf(fml2), Boolean.valueOf(z), Boolean.valueOf(ar), Boolean.valueOf(as));
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(199374);
                }
            }, "UploadSportStepEventHandle");
            AppMethodBeat.o(149271);
            return false;
        }
    };
    public e FiZ;
    private long Fja;
    long Fjb;

    public a() {
        AppMethodBeat.i(149274);
        this.FiY.alive();
        this.FiX = new c();
        AppMethodBeat.o(149274);
    }

    public final void fmj() {
        AppMethodBeat.i(149275);
        long fml = fml();
        Log.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", Long.valueOf(fml));
        Ka(fml);
        AppMethodBeat.o(149275);
    }

    /* access modifiers changed from: package-private */
    public final boolean Ka(long j2) {
        AppMethodBeat.i(149276);
        if (this.FiZ != null) {
            g.azz().a(this.FiZ);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", k.AF(currentTimeMillis), Long.valueOf(j2));
        this.FiZ = new e("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (currentTimeMillis / 1000), (int) j2, ck.getFingerprint(), 1);
        g.azz().a(this.FiZ, 0);
        Kc(System.currentTimeMillis());
        Kb(j2);
        AppMethodBeat.o(149276);
        return true;
    }

    public final long fmk() {
        AppMethodBeat.i(149277);
        if (this.Fja == 0) {
            this.Fja = j.aJ(4, 0);
        }
        long j2 = this.Fja;
        AppMethodBeat.o(149277);
        return j2;
    }

    private void Kb(long j2) {
        AppMethodBeat.i(149278);
        this.Fja = j2;
        j.aK(4, this.Fja);
        AppMethodBeat.o(149278);
    }

    private void Kc(long j2) {
        AppMethodBeat.i(149279);
        this.Fjb = j2;
        j.aK(3, j2);
        AppMethodBeat.o(149279);
    }

    public static long fml() {
        boolean z;
        AppMethodBeat.i(149280);
        long fmm = fmm();
        if (MIUI.ifMIUI()) {
            try {
                z = ((b) g.af(b.class)).a(b.a.clicfg_weixin_sport_brand_api_flag, true);
            } catch (Exception e2) {
                z = true;
            }
            if (z) {
                long fmL = (long) k.fmL();
                if (fmL > fmm) {
                    Log.i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", Long.valueOf(fmL), Long.valueOf(fmm));
                    AppMethodBeat.o(149280);
                    return fmL;
                }
            }
        }
        AppMethodBeat.o(149280);
        return fmm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064 A[SYNTHETIC, Splitter:B:12:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long fmm() {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sport.model.a.fmm():long");
    }

    public final void aRC(final String str) {
        AppMethodBeat.i(149282);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.sport.model.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(149272);
                try {
                    Uri parse = Uri.parse("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_SPORT());
                    MMApplicationContext.getContext().getContentResolver().query(parse, null, "updateConfig", new String[]{str}, null);
                    AppMethodBeat.o(149272);
                } catch (Exception e2) {
                    AppMethodBeat.o(149272);
                }
            }
        }, "Sport.updateConfigToPush");
        AppMethodBeat.o(149282);
    }

    static /* synthetic */ boolean fmn() {
        AppMethodBeat.i(149283);
        if (!k.hg(MMApplicationContext.getContext()) || !k.fmg()) {
            AppMethodBeat.o(149283);
            return false;
        }
        AppMethodBeat.o(149283);
        return true;
    }
}
