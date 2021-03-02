package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b/\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\bH\u0007J\b\u0010\u001c\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u00020\bH\u0007J\b\u0010!\u001a\u00020\bH\u0007J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\bH\u0007J\b\u0010$\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010'\u001a\u00020\bH\u0007J\b\u0010(\u001a\u00020\bH\u0007J\b\u0010)\u001a\u00020\bH\u0007J\b\u0010*\u001a\u00020\bH\u0007J\b\u0010+\u001a\u00020\bH\u0007J\b\u0010,\u001a\u00020\bH\u0007J\b\u0010-\u001a\u00020\bH\u0007J\b\u0010.\u001a\u00020\bH\u0007J\b\u0010/\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020\bH\u0007J\b\u00101\u001a\u00020\bH\u0007J\b\u00102\u001a\u00020\bH\u0007J\b\u00103\u001a\u00020\bH\u0007J\b\u00104\u001a\u00020\bH\u0007J\b\u00105\u001a\u00020\bH\u0007J\b\u00106\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/audio/utils/recorder/VoiceMsgPCMRecorderIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAudioRecordHasBeenInit", "", "markAudioSourceSwitchMicFailed", "markAudioSourceSwitchMicSuccess", "markAudioSourceSwitchVCFailed", "markAudioSourceSwitchVCSuccess", "markAudioSourceUseMicFailed", "markAudioSourceUseVoiceCommunicationFailed", "markMicroPhonesMute", "markPCMAmplitudeHigh", "percent", "markPCMAmplitudeHighPercentAround0", "markPCMAmplitudeHighPercentAround100", "markPCMAmplitudeHighPercentAround20", "markPCMAmplitudeHighPercentAround40", "markPCMAmplitudeHighPercentAround60", "markPCMAmplitudeHighPercentAround80", "markPCMAmplitudeLow", "markPCMAmplitudeLowPercentAround0", "markPCMAmplitudeLowPercentAround100", "markPCMAmplitudeLowPercentAround20", "markPCMAmplitudeLowPercentAround40", "markPCMAmplitudeLowPercentAround60", "markPCMAmplitudeLowPercentAround80", "markPCMAmplitudeMiddle", "markPCMAmplitudeMiddlePercentAround0", "markPCMAmplitudeMiddlePercentAround100", "markPCMAmplitudeMiddlePercentAround20", "markPCMAmplitudeMiddlePercentAround40", "markPCMAmplitudeMiddlePercentAround60", "markPCMAmplitudeMiddlePercentAround80", "markPCMAmplitudeSilent", "markPCMAmplitudeSilentPercentAround0", "markPCMAmplitudeSilentPercentAround100", "markPCMAmplitudeSilentPercentAround20", "markPCMAmplitudeSilentPercentAround40", "markPCMAmplitudeSilentPercentAround60", "markPCMAmplitudeSilentPercentAround80", "markPCMRecorderAudioSourceFinalRequestMIC", "markPCMRecorderAudioSourceFinalRequestVC", "markRecordingHasMusicPlaying", "markZeroDataCauseMute", "markZeroDataCauseUseHeadsetPlugged", "markdoMinBufferSizeError", "markdoNewAudioRecordeError", "markdoRecordModeNullError", "markdoRecordReport", "markdoStartRecordError", "plugin-audiosdk_release"})
public final class c {
    public static final c dBe = new c();

    static {
        AppMethodBeat.i(130345);
        AppMethodBeat.o(130345);
    }

    private c() {
    }

    public static final void abx() {
        AppMethodBeat.i(130299);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceUseMicFailed");
        h.INSTANCE.n(1201, 0, 1);
        AppMethodBeat.o(130299);
    }

    public static final void aby() {
        AppMethodBeat.i(130300);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceUseVoiceCommunicationFailed");
        h.INSTANCE.n(1201, 1, 1);
        AppMethodBeat.o(130300);
    }

    public static final void abz() {
        AppMethodBeat.i(130301);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceSwitchVCSuccess");
        h.INSTANCE.n(1201, 2, 1);
        AppMethodBeat.o(130301);
    }

    public static final void abA() {
        AppMethodBeat.i(130302);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceSwitchVCFailed");
        h.INSTANCE.n(1201, 3, 1);
        AppMethodBeat.o(130302);
    }

    public static final void abB() {
        AppMethodBeat.i(130303);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceSwitchMicSuccess");
        h.INSTANCE.n(1201, 4, 1);
        AppMethodBeat.o(130303);
    }

    public static final void abC() {
        AppMethodBeat.i(130304);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioSourceSwitchMicFailed");
        h.INSTANCE.n(1201, 5, 1);
        AppMethodBeat.o(130304);
    }

    public static final void aaB() {
        AppMethodBeat.i(130305);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround0");
        h.INSTANCE.n(1201, 6, 1);
        AppMethodBeat.o(130305);
    }

    public static final void aaC() {
        AppMethodBeat.i(130306);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround20");
        h.INSTANCE.n(1201, 7, 1);
        AppMethodBeat.o(130306);
    }

    public static final void aaD() {
        AppMethodBeat.i(130307);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround40");
        h.INSTANCE.n(1201, 8, 1);
        AppMethodBeat.o(130307);
    }

    public static final void aaE() {
        AppMethodBeat.i(130308);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround60");
        h.INSTANCE.n(1201, 9, 1);
        AppMethodBeat.o(130308);
    }

    public static final void aaF() {
        AppMethodBeat.i(130309);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround80");
        h.INSTANCE.n(1201, 10, 1);
        AppMethodBeat.o(130309);
    }

    public static final void aaG() {
        AppMethodBeat.i(130310);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilentPercentAround100");
        h.INSTANCE.n(1201, 11, 1);
        AppMethodBeat.o(130310);
    }

    public static final void bv(long j2) {
        AppMethodBeat.i(130311);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeSilent ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1201, 12, j2);
        AppMethodBeat.o(130311);
    }

    public static final void aaH() {
        AppMethodBeat.i(130312);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround0");
        h.INSTANCE.n(1201, 13, 1);
        AppMethodBeat.o(130312);
    }

    public static final void aaI() {
        AppMethodBeat.i(130313);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround20");
        h.INSTANCE.n(1201, 14, 1);
        AppMethodBeat.o(130313);
    }

    public static final void aaJ() {
        AppMethodBeat.i(130314);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround40");
        h.INSTANCE.n(1201, 15, 1);
        AppMethodBeat.o(130314);
    }

    public static final void aaK() {
        AppMethodBeat.i(130315);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround60");
        h.INSTANCE.n(1201, 16, 1);
        AppMethodBeat.o(130315);
    }

    public static final void aaL() {
        AppMethodBeat.i(130316);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround80");
        h.INSTANCE.n(1201, 17, 1);
        AppMethodBeat.o(130316);
    }

    public static final void aaM() {
        AppMethodBeat.i(130317);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeLowPercentAround100");
        h.INSTANCE.n(1201, 18, 1);
        AppMethodBeat.o(130317);
    }

    public static final void bw(long j2) {
        AppMethodBeat.i(130318);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeInLow=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1201, 19, j2);
        AppMethodBeat.o(130318);
    }

    public static final void aaN() {
        AppMethodBeat.i(130319);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround0");
        h.INSTANCE.n(1201, 20, 1);
        AppMethodBeat.o(130319);
    }

    public static final void aaO() {
        AppMethodBeat.i(130320);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround20");
        h.INSTANCE.n(1201, 21, 1);
        AppMethodBeat.o(130320);
    }

    public static final void aaP() {
        AppMethodBeat.i(130321);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround40");
        h.INSTANCE.n(1201, 22, 1);
        AppMethodBeat.o(130321);
    }

    public static final void aaQ() {
        AppMethodBeat.i(130322);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround60");
        h.INSTANCE.n(1201, 23, 1);
        AppMethodBeat.o(130322);
    }

    public static final void aaR() {
        AppMethodBeat.i(130323);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround80");
        h.INSTANCE.n(1201, 24, 1);
        AppMethodBeat.o(130323);
    }

    public static final void aaS() {
        AppMethodBeat.i(130324);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddlePercentAround100");
        h.INSTANCE.n(1201, 25, 1);
        AppMethodBeat.o(130324);
    }

    public static final void bx(long j2) {
        AppMethodBeat.i(130325);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeMiddle: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1201, 26, j2);
        AppMethodBeat.o(130325);
    }

    public static final void aaT() {
        AppMethodBeat.i(130326);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround0");
        h.INSTANCE.n(1201, 27, 1);
        AppMethodBeat.o(130326);
    }

    public static final void aaU() {
        AppMethodBeat.i(130327);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround20");
        h.INSTANCE.n(1201, 28, 1);
        AppMethodBeat.o(130327);
    }

    public static final void aaV() {
        AppMethodBeat.i(130328);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround40");
        h.INSTANCE.n(1201, 29, 1);
        AppMethodBeat.o(130328);
    }

    public static final void aaW() {
        AppMethodBeat.i(130329);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround60");
        h.INSTANCE.n(1201, 30, 1);
        AppMethodBeat.o(130329);
    }

    public static final void aaX() {
        AppMethodBeat.i(130330);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround80");
        h.INSTANCE.n(1201, 31, 1);
        AppMethodBeat.o(130330);
    }

    public static final void aaY() {
        AppMethodBeat.i(130331);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHighPercentAround100");
        h.INSTANCE.n(1201, 32, 1);
        AppMethodBeat.o(130331);
    }

    public static final void by(long j2) {
        AppMethodBeat.i(130332);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMAmplitudeHigh ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1201, 33, j2);
        AppMethodBeat.o(130332);
    }

    public static final void abD() {
        AppMethodBeat.i(130333);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMRecorderAudioSourceFinalRequestMIC");
        h.INSTANCE.n(1201, 34, 1);
        AppMethodBeat.o(130333);
    }

    public static final void abE() {
        AppMethodBeat.i(130334);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markPCMRecorderAudioSourceFinalRequestVC");
        h.INSTANCE.n(1201, 35, 1);
        AppMethodBeat.o(130334);
    }

    public static final void abF() {
        AppMethodBeat.i(130335);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markMicroPhonesMute");
        h.INSTANCE.n(1201, 36, 1);
        AppMethodBeat.o(130335);
    }

    public static final void abG() {
        AppMethodBeat.i(130336);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markAudioRecordHasBeenInit");
        h.INSTANCE.n(1201, 37, 1);
        AppMethodBeat.o(130336);
    }

    public static final void abH() {
        AppMethodBeat.i(130337);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markdoMinBufferSizeError");
        h.INSTANCE.n(1201, 38, 1);
        AppMethodBeat.o(130337);
    }

    public static final void abI() {
        AppMethodBeat.i(130338);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markdoNewAudioRecordeError");
        h.INSTANCE.n(1201, 39, 1);
        AppMethodBeat.o(130338);
    }

    public static final void abJ() {
        AppMethodBeat.i(130339);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markdoStartRecordError");
        h.INSTANCE.n(1201, 40, 1);
        AppMethodBeat.o(130339);
    }

    public static final void abK() {
        AppMethodBeat.i(130340);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markdoRecordModeNullError");
        h.INSTANCE.n(1201, 41, 1);
        AppMethodBeat.o(130340);
    }

    public static final void abL() {
        AppMethodBeat.i(130341);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markdoRecordReport");
        h.INSTANCE.n(1201, 42, 1);
        AppMethodBeat.o(130341);
    }

    public static final void abM() {
        AppMethodBeat.i(130342);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markZeroDataCauseMute");
        h.INSTANCE.n(1201, 47, 1);
        AppMethodBeat.o(130342);
    }

    public static final void abN() {
        AppMethodBeat.i(130343);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markZeroDataCauseUseHeadsetPlugged");
        h.INSTANCE.n(1201, 48, 1);
        AppMethodBeat.o(130343);
    }

    public static final void abO() {
        AppMethodBeat.i(130344);
        Log.i("MicroMsg.VoiceMsgPCMRecorderIDKeyStat", "markRecordingHasMusicPlaying");
        h.INSTANCE.n(1201, 49, 1);
        AppMethodBeat.o(130344);
    }
}
