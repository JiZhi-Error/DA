package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b/\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\bH\u0007J\b\u0010\u001c\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u00020\bH\u0007J\b\u0010!\u001a\u00020\bH\u0007J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\bH\u0007J\b\u0010$\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010'\u001a\u00020\bH\u0007J\b\u0010(\u001a\u00020\bH\u0007J\b\u0010)\u001a\u00020\bH\u0007J\b\u0010*\u001a\u00020\bH\u0007J\b\u0010+\u001a\u00020\bH\u0007J\b\u0010,\u001a\u00020\bH\u0007J\b\u0010-\u001a\u00020\bH\u0007J\b\u0010.\u001a\u00020\bH\u0007J\b\u0010/\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020\bH\u0007J\b\u00101\u001a\u00020\bH\u0007J\b\u00102\u001a\u00020\bH\u0007J\b\u00103\u001a\u00020\bH\u0007J\b\u00104\u001a\u00020\bH\u0007J\b\u00105\u001a\u00020\bH\u0007J\b\u00106\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/audio/utils/recorder/VOIPPCMRecorderIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAudioRecordHasBeenInit", "", "markAudioSourceSwitchMicFailed", "markAudioSourceSwitchMicSuccess", "markAudioSourceSwitchVCFailed", "markAudioSourceSwitchVCSuccess", "markAudioSourceUseMicFailed", "markAudioSourceUseVoiceCommunicationFailed", "markMicroPhonesMute", "markPCMAmplitudeHigh", "percent", "markPCMAmplitudeHighPercentAround0", "markPCMAmplitudeHighPercentAround100", "markPCMAmplitudeHighPercentAround20", "markPCMAmplitudeHighPercentAround40", "markPCMAmplitudeHighPercentAround60", "markPCMAmplitudeHighPercentAround80", "markPCMAmplitudeLow", "markPCMAmplitudeLowPercentAround0", "markPCMAmplitudeLowPercentAround100", "markPCMAmplitudeLowPercentAround20", "markPCMAmplitudeLowPercentAround40", "markPCMAmplitudeLowPercentAround60", "markPCMAmplitudeLowPercentAround80", "markPCMAmplitudeMiddle", "markPCMAmplitudeMiddlePercentAround0", "markPCMAmplitudeMiddlePercentAround100", "markPCMAmplitudeMiddlePercentAround20", "markPCMAmplitudeMiddlePercentAround40", "markPCMAmplitudeMiddlePercentAround60", "markPCMAmplitudeMiddlePercentAround80", "markPCMAmplitudeSilent", "markPCMAmplitudeSilentPercentAround0", "markPCMAmplitudeSilentPercentAround100", "markPCMAmplitudeSilentPercentAround20", "markPCMAmplitudeSilentPercentAround40", "markPCMAmplitudeSilentPercentAround60", "markPCMAmplitudeSilentPercentAround80", "markPCMRecorderAudioSourceFinalRequestMIC", "markPCMRecorderAudioSourceFinalRequestVC", "markRecordingHasMusicPlaying", "markZeroDataCauseMute", "markZeroDataCauseUseHeadsetPlugged", "markdoMinBufferSizeError", "markdoNewAudioRecordeError", "markdoRecordModeNullError", "markdoRecordReport", "markdoStartRecordError", "plugin-audiosdk_release"})
public final class b {
    public static final b dBd = new b();

    static {
        AppMethodBeat.i(130298);
        AppMethodBeat.o(130298);
    }

    private b() {
    }

    public static void abx() {
        AppMethodBeat.i(130252);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceUseMic");
        h.INSTANCE.n(1202, 0, 1);
        AppMethodBeat.o(130252);
    }

    public static void aby() {
        AppMethodBeat.i(130253);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceUseVoiceCommunicationFailed");
        h.INSTANCE.n(1202, 1, 1);
        AppMethodBeat.o(130253);
    }

    public static final void abz() {
        AppMethodBeat.i(130254);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceSwitchVCSuccess");
        h.INSTANCE.n(1202, 2, 1);
        AppMethodBeat.o(130254);
    }

    public static final void abA() {
        AppMethodBeat.i(130255);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceSwitchVCFailed");
        h.INSTANCE.n(1202, 3, 1);
        AppMethodBeat.o(130255);
    }

    public static final void abB() {
        AppMethodBeat.i(130256);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceSwitchMicSuccess");
        h.INSTANCE.n(1202, 4, 1);
        AppMethodBeat.o(130256);
    }

    public static final void abC() {
        AppMethodBeat.i(130257);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioSourceSwitchMicFailed");
        h.INSTANCE.n(1202, 5, 1);
        AppMethodBeat.o(130257);
    }

    public static final void aaB() {
        AppMethodBeat.i(130258);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround0");
        h.INSTANCE.n(1202, 6, 1);
        AppMethodBeat.o(130258);
    }

    public static final void aaC() {
        AppMethodBeat.i(130259);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround20");
        h.INSTANCE.n(1202, 7, 1);
        AppMethodBeat.o(130259);
    }

    public static final void aaD() {
        AppMethodBeat.i(130260);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround40");
        h.INSTANCE.n(1202, 8, 1);
        AppMethodBeat.o(130260);
    }

    public static final void aaE() {
        AppMethodBeat.i(130261);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround60");
        h.INSTANCE.n(1202, 9, 1);
        AppMethodBeat.o(130261);
    }

    public static final void aaF() {
        AppMethodBeat.i(130262);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround80");
        h.INSTANCE.n(1202, 10, 1);
        AppMethodBeat.o(130262);
    }

    public static final void aaG() {
        AppMethodBeat.i(130263);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround100");
        h.INSTANCE.n(1202, 11, 1);
        AppMethodBeat.o(130263);
    }

    public static final void bv(long j2) {
        AppMethodBeat.i(130264);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeSilent ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1202, 12, j2);
        AppMethodBeat.o(130264);
    }

    public static final void aaH() {
        AppMethodBeat.i(130265);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround0");
        h.INSTANCE.n(1202, 13, 1);
        AppMethodBeat.o(130265);
    }

    public static final void aaI() {
        AppMethodBeat.i(130266);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround20");
        h.INSTANCE.n(1202, 14, 1);
        AppMethodBeat.o(130266);
    }

    public static final void aaJ() {
        AppMethodBeat.i(130267);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround40");
        h.INSTANCE.n(1202, 15, 1);
        AppMethodBeat.o(130267);
    }

    public static final void aaK() {
        AppMethodBeat.i(130268);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround60");
        h.INSTANCE.n(1202, 16, 1);
        AppMethodBeat.o(130268);
    }

    public static final void aaL() {
        AppMethodBeat.i(130269);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround80");
        h.INSTANCE.n(1202, 17, 1);
        AppMethodBeat.o(130269);
    }

    public static final void aaM() {
        AppMethodBeat.i(130270);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround100");
        h.INSTANCE.n(1202, 18, 1);
        AppMethodBeat.o(130270);
    }

    public static final void bw(long j2) {
        AppMethodBeat.i(130271);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeInLow=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1202, 19, j2);
        AppMethodBeat.o(130271);
    }

    public static final void aaN() {
        AppMethodBeat.i(130272);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround0");
        h.INSTANCE.n(1202, 20, 1);
        AppMethodBeat.o(130272);
    }

    public static final void aaO() {
        AppMethodBeat.i(130273);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround20");
        h.INSTANCE.n(1202, 21, 1);
        AppMethodBeat.o(130273);
    }

    public static final void aaP() {
        AppMethodBeat.i(130274);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround40");
        h.INSTANCE.n(1202, 22, 1);
        AppMethodBeat.o(130274);
    }

    public static final void aaQ() {
        AppMethodBeat.i(130275);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround60");
        h.INSTANCE.n(1202, 23, 1);
        AppMethodBeat.o(130275);
    }

    public static final void aaR() {
        AppMethodBeat.i(130276);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround80");
        h.INSTANCE.n(1202, 24, 1);
        AppMethodBeat.o(130276);
    }

    public static final void aaS() {
        AppMethodBeat.i(130277);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround100");
        h.INSTANCE.n(1202, 25, 1);
        AppMethodBeat.o(130277);
    }

    public static final void bx(long j2) {
        AppMethodBeat.i(130278);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeMiddle: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1202, 26, j2);
        AppMethodBeat.o(130278);
    }

    public static final void aaT() {
        AppMethodBeat.i(130279);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround0");
        h.INSTANCE.n(1202, 27, 1);
        AppMethodBeat.o(130279);
    }

    public static final void aaU() {
        AppMethodBeat.i(130280);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround20");
        h.INSTANCE.n(1202, 28, 1);
        AppMethodBeat.o(130280);
    }

    public static final void aaV() {
        AppMethodBeat.i(130281);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround40");
        h.INSTANCE.n(1202, 29, 1);
        AppMethodBeat.o(130281);
    }

    public static final void aaW() {
        AppMethodBeat.i(130282);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround60");
        h.INSTANCE.n(1202, 30, 1);
        AppMethodBeat.o(130282);
    }

    public static final void aaX() {
        AppMethodBeat.i(130283);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround80");
        h.INSTANCE.n(1202, 31, 1);
        AppMethodBeat.o(130283);
    }

    public static final void aaY() {
        AppMethodBeat.i(130284);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround100");
        h.INSTANCE.n(1202, 32, 1);
        AppMethodBeat.o(130284);
    }

    public static final void by(long j2) {
        AppMethodBeat.i(130285);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMAmplitudeHigh ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1202, 33, j2);
        AppMethodBeat.o(130285);
    }

    public static final void abD() {
        AppMethodBeat.i(130286);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMRecorderAudioSourceFinalRequestMIC");
        h.INSTANCE.n(1202, 34, 1);
        AppMethodBeat.o(130286);
    }

    public static final void abE() {
        AppMethodBeat.i(130287);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markPCMRecorderAudioSourceFinalRequestVC");
        h.INSTANCE.n(1202, 35, 1);
        AppMethodBeat.o(130287);
    }

    public static final void abF() {
        AppMethodBeat.i(130288);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markMicroPhonesMute");
        h.INSTANCE.n(1202, 36, 1);
        AppMethodBeat.o(130288);
    }

    public static final void abG() {
        AppMethodBeat.i(130289);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markAudioRecordHasBeenInit");
        h.INSTANCE.n(1202, 37, 1);
        AppMethodBeat.o(130289);
    }

    public static final void abH() {
        AppMethodBeat.i(130290);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markdoMinBufferSizeError");
        h.INSTANCE.n(1202, 38, 1);
        AppMethodBeat.o(130290);
    }

    public static final void abI() {
        AppMethodBeat.i(130291);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markdoNewAudioRecordeError");
        h.INSTANCE.n(1202, 39, 1);
        AppMethodBeat.o(130291);
    }

    public static final void abJ() {
        AppMethodBeat.i(130292);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markdoStartRecordError");
        h.INSTANCE.n(1202, 40, 1);
        AppMethodBeat.o(130292);
    }

    public static final void abK() {
        AppMethodBeat.i(130293);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markdoRecordModeNullError");
        h.INSTANCE.n(1202, 41, 1);
        AppMethodBeat.o(130293);
    }

    public static final void abL() {
        AppMethodBeat.i(130294);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markdoRecordReport");
        h.INSTANCE.n(1202, 42, 1);
        AppMethodBeat.o(130294);
    }

    public static final void abM() {
        AppMethodBeat.i(130295);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markZeroDataCauseMute");
        h.INSTANCE.n(1202, 47, 1);
        AppMethodBeat.o(130295);
    }

    public static final void abN() {
        AppMethodBeat.i(130296);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markZeroDataCauseUseHeadsetPlugged");
        h.INSTANCE.n(1202, 48, 1);
        AppMethodBeat.o(130296);
    }

    public static final void abO() {
        AppMethodBeat.i(130297);
        Log.i("MicroMsg.VOIPPCMRecorderIDKeyStat", "markRecordingHasMusicPlaying");
        h.INSTANCE.n(1202, 49, 1);
        AppMethodBeat.o(130297);
    }
}
