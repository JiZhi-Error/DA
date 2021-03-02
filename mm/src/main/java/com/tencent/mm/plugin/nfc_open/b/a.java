package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements i {
    public ctt AEn;

    public a() {
        AppMethodBeat.i(26689);
        init();
        AppMethodBeat.o(26689);
    }

    private void init() {
        AppMethodBeat.i(26690);
        this.AEn = new ctt();
        bg.aVF();
        String valueOf = String.valueOf(c.azQ().get(ar.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, (Object) null));
        if (Util.isNullOrNil(valueOf)) {
            this.AEn.Lps = new LinkedList<>();
            this.AEn.lastUpdateTime = 0;
            this.AEn.Lpt = LocalCache.TIME_DAY;
            this.AEn.version = 0;
            AppMethodBeat.o(26690);
            return;
        }
        try {
            this.AEn.parseFrom(valueOf.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
            Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", Integer.valueOf(this.AEn.version));
            AppMethodBeat.o(26690);
        } catch (Exception e2) {
            Log.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e2.getLocalizedMessage());
            this.AEn.Lps = new LinkedList<>();
            this.AEn.lastUpdateTime = 0;
            this.AEn.Lpt = LocalCache.TIME_DAY;
            this.AEn.version = 0;
            AppMethodBeat.o(26690);
        }
    }

    private void a(ctt ctt) {
        AppMethodBeat.i(26691);
        if (!bg.aAc()) {
            Log.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
            AppMethodBeat.o(26691);
            return;
        }
        if (ctt != null) {
            Log.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.AEn = ctt;
            try {
                String str = new String(this.AEn.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
                AppMethodBeat.o(26691);
                return;
            } catch (UnsupportedEncodingException e2) {
                Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
                AppMethodBeat.o(26691);
                return;
            } catch (IOException e3) {
                Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e3.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(26691);
    }

    private ctt exz() {
        AppMethodBeat.i(26692);
        if (this.AEn == null) {
            init();
        }
        ctt ctt = this.AEn;
        AppMethodBeat.o(26692);
        return ctt;
    }

    public final boolean dZt() {
        int i2 = 1800;
        AppMethodBeat.i(26693);
        try {
            if (NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext()) == null) {
                Log.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
                AppMethodBeat.o(26693);
                return false;
            }
            if (this.AEn != null) {
                int i3 = this.AEn.Lpt;
                if (i3 >= 1800) {
                    if (i3 > 604800) {
                        i2 = 604800;
                    } else {
                        i2 = i3;
                    }
                }
                Log.i("MicroMsg.CpuCardConfigManager", "now=" + Util.nowSecond() + ", lastUpdateTime=" + this.AEn.lastUpdateTime + ", updateFreq=" + i2 + ", configUpdateFreq=" + this.AEn.Lpt);
                if (Util.nowSecond() - this.AEn.lastUpdateTime > ((long) i2)) {
                    AppMethodBeat.o(26693);
                    return true;
                }
            }
            AppMethodBeat.o(26693);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CpuCardConfigManager", e2, "", new Object[0]);
            AppMethodBeat.o(26693);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        ady ady;
        AppMethodBeat.i(26694);
        bg.azz().b(1561, this);
        if (qVar instanceof b) {
            ctt exz = exz();
            exz.lastUpdateTime = Util.nowSecond();
            if (i2 == 0 && i3 == 0 && (ady = (ady) ((b) qVar).rr.iLL.iLR) != null) {
                exz.Lpt = ady.Lpt;
                exz.Lpu = ady.Lpu;
                bg.aVF();
                if (((Integer) c.azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 0)).intValue() == 0) {
                    if (ady.Lpu == 1) {
                        MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                    } else {
                        MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                    }
                }
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(ady.Lpu));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, ady.HQv);
                if (exz.version == ady.version) {
                    Log.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + ady.version);
                    a(exz);
                    AppMethodBeat.o(26694);
                    return;
                }
                exz.version = ady.version;
                Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", Integer.valueOf(ady.version));
                if (ady.Lps == null || ady.Lps.isEmpty()) {
                    exz.Lps.clear();
                } else {
                    if (exz.Lps == null) {
                        exz.Lps = new LinkedList<>();
                    } else {
                        exz.Lps.clear();
                    }
                    for (int i4 = 0; i4 < ady.Lps.size(); i4++) {
                        tx txVar = new tx();
                        txVar.KBH = ady.Lps.get(i4).KBH;
                        txVar.Lci = ady.Lps.get(i4).Lci;
                        Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + Util.nullAsNil(Integer.valueOf(txVar.Lci)) + ", url=" + Util.nullAsNil(txVar.KBH));
                        if (txVar.Lch == null) {
                            txVar.Lch = new LinkedList<>();
                        } else {
                            txVar.Lch.clear();
                        }
                        for (int i5 = 0; i5 < ady.Lps.get(i4).Lch.size(); i5++) {
                            adz adz = new adz();
                            if (adz.Lpv == null) {
                                adz.Lpv = new LinkedList<>();
                            } else {
                                adz.Lpv.clear();
                            }
                            for (int i6 = 0; i6 < ady.Lps.get(i4).Lch.get(i5).Lpv.size(); i6++) {
                                abl abl = new abl();
                                abl.Lmp = ady.Lps.get(i4).Lch.get(i5).Lpv.get(i6).Lmp;
                                abl.yWF = ady.Lps.get(i4).Lch.get(i5).Lpv.get(i6).yWF;
                                Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + Util.nullAsNil(abl.Lmp) + ", answer=" + Util.nullAsNil(abl.yWF));
                                adz.Lpv.add(abl);
                            }
                            txVar.Lch.add(adz);
                        }
                        exz.Lps.add(txVar);
                    }
                }
            }
            a(exz);
        }
        AppMethodBeat.o(26694);
    }
}
