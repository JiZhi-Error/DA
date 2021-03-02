package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import java.util.Map;
import org.xwalk.core.XWalkFeature;

public final class zzdu extends zzhg {
    private final Map<String, Long> zzadf = new a();
    private final Map<String, Integer> zzadg = new a();
    private long zzadh;

    public zzdu(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1014);
        AppMethodBeat.o(1014);
    }

    private final void zza(long j2, zzie zzie) {
        AppMethodBeat.i(1019);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad exposure. No active activity");
            AppMethodBeat.o(1019);
        } else if (j2 < 1000) {
            zzge().zzit().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
            AppMethodBeat.o(1019);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j2);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xa", bundle);
            AppMethodBeat.o(1019);
        }
    }

    static /* synthetic */ void zza(zzdu zzdu, long j2) {
        AppMethodBeat.i(1044);
        zzdu.zzl(j2);
        AppMethodBeat.o(1044);
    }

    static /* synthetic */ void zza(zzdu zzdu, String str, long j2) {
        AppMethodBeat.i(1042);
        zzdu.zza(str, j2);
        AppMethodBeat.o(1042);
    }

    private final void zza(String str, long j2) {
        AppMethodBeat.i(HardCoderJNI.FUNC_GPU_HIGH_FREQ);
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzadg.isEmpty()) {
            this.zzadh = j2;
        }
        Integer num = this.zzadg.get(str);
        if (num != null) {
            this.zzadg.put(str, Integer.valueOf(num.intValue() + 1));
            AppMethodBeat.o(HardCoderJNI.FUNC_GPU_HIGH_FREQ);
        } else if (this.zzadg.size() >= 100) {
            zzge().zzip().log("Too many ads visible");
            AppMethodBeat.o(HardCoderJNI.FUNC_GPU_HIGH_FREQ);
        } else {
            this.zzadg.put(str, 1);
            this.zzadf.put(str, Long.valueOf(j2));
            AppMethodBeat.o(HardCoderJNI.FUNC_GPU_HIGH_FREQ);
        }
    }

    private final void zza(String str, long j2, zzie zzie) {
        AppMethodBeat.i(1020);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad unit exposure. No active activity");
            AppMethodBeat.o(1020);
        } else if (j2 < 1000) {
            zzge().zzit().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
            AppMethodBeat.o(1020);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j2);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xu", bundle);
            AppMethodBeat.o(1020);
        }
    }

    static /* synthetic */ void zzb(zzdu zzdu, String str, long j2) {
        AppMethodBeat.i(1043);
        zzdu.zzb(str, j2);
        AppMethodBeat.o(1043);
    }

    private final void zzb(String str, long j2) {
        AppMethodBeat.i(1018);
        zzab();
        Preconditions.checkNotEmpty(str);
        Integer num = this.zzadg.get(str);
        if (num != null) {
            zzie zzkc = zzfy().zzkc();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzadg.remove(str);
                Long l = this.zzadf.get(str);
                if (l == null) {
                    zzge().zzim().log("First ad unit exposure time was never set");
                } else {
                    this.zzadf.remove(str);
                    zza(str, j2 - l.longValue(), zzkc);
                }
                if (this.zzadg.isEmpty()) {
                    if (this.zzadh == 0) {
                        zzge().zzim().log("First ad exposure time was never set");
                        AppMethodBeat.o(1018);
                        return;
                    }
                    zza(j2 - this.zzadh, zzkc);
                    this.zzadh = 0;
                }
                AppMethodBeat.o(1018);
                return;
            }
            this.zzadg.put(str, Integer.valueOf(intValue));
            AppMethodBeat.o(1018);
            return;
        }
        zzge().zzim().zzg("Call to endAdUnitExposure for unknown ad unit id", str);
        AppMethodBeat.o(1018);
    }

    private final void zzl(long j2) {
        AppMethodBeat.i(1022);
        for (String str : this.zzadf.keySet()) {
            this.zzadf.put(str, Long.valueOf(j2));
        }
        if (!this.zzadf.isEmpty()) {
            this.zzadh = j2;
        }
        AppMethodBeat.o(1022);
    }

    public final void beginAdUnitExposure(String str) {
        AppMethodBeat.i(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.o(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK);
            return;
        }
        zzgd().zzc(new zzdv(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.o(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK);
    }

    public final void endAdUnitExposure(String str) {
        AppMethodBeat.i(HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.o(HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ);
            return;
        }
        zzgd().zzc(new zzdw(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.o(HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1033);
        Context context = super.getContext();
        AppMethodBeat.o(1033);
        return context;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(TXLiteAVCode.EVT_CAMERA_CLOSE);
        super.zzab();
        AppMethodBeat.o(TXLiteAVCode.EVT_CAMERA_CLOSE);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1032);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1032);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(TXLiteAVCode.EVT_CAMERA_REMOVED);
        super.zzfr();
        AppMethodBeat.o(TXLiteAVCode.EVT_CAMERA_REMOVED);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1024);
        super.zzfs();
        AppMethodBeat.o(1024);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(TXLiteAVCode.EVT_RTMP_PUSH_PUBLISH_START);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(TXLiteAVCode.EVT_RTMP_PUSH_PUBLISH_START);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(TXLiteAVCode.EVT_SW_ENCODER_START_SUCC);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(TXLiteAVCode.EVT_SW_ENCODER_START_SUCC);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(TXLiteAVCode.EVT_LOCAL_RECORD_RESULT);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(TXLiteAVCode.EVT_LOCAL_RECORD_RESULT);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1030);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1030);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1031);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1031);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1034);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1034);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1035);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1035);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1036);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1036);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1037);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1037);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1038);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1038);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1039);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1039);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(XWalkFeature.INTERFACE_SHOW_HIDE);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(XWalkFeature.INTERFACE_SHOW_HIDE);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1041);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1041);
        return zzgg;
    }

    public final void zzk(long j2) {
        AppMethodBeat.i(1021);
        zzie zzkc = zzfy().zzkc();
        for (String str : this.zzadf.keySet()) {
            zza(str, j2 - this.zzadf.get(str).longValue(), zzkc);
        }
        if (!this.zzadf.isEmpty()) {
            zza(j2 - this.zzadh, zzkc);
        }
        zzl(j2);
        AppMethodBeat.o(1021);
    }
}
