package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

/* access modifiers changed from: package-private */
public final class zzwz extends zzws<Double> {
    zzwz(zzxc zzxc, String str, Double d2) {
        super(zzxc, str, d2, null);
    }

    private final Double zzfb(String str) {
        AppMethodBeat.i(TPCodecParamers.TP_PROFILE_H264_HIGH_444_INTRA);
        try {
            Double valueOf = Double.valueOf(Double.parseDouble(str));
            AppMethodBeat.o(TPCodecParamers.TP_PROFILE_H264_HIGH_444_INTRA);
            return valueOf;
        } catch (NumberFormatException e2) {
            String str2 = this.zzbnh;
            new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length()).append("Invalid double value for ").append(str2).append(": ").append(str);
            AppMethodBeat.o(TPCodecParamers.TP_PROFILE_H264_HIGH_444_INTRA);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzws
    public final /* synthetic */ Double zzey(String str) {
        AppMethodBeat.i(2293);
        Double zzfb = zzfb(str);
        AppMethodBeat.o(2293);
        return zzfb;
    }
}
