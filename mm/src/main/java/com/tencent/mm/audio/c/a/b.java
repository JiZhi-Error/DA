package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b:\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\bH\u0007J\b\u0010\u001c\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u00020\bH\u0007J\b\u0010!\u001a\u00020\bH\u0007J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\bH\u0007J\b\u0010$\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010'\u001a\u00020\bH\u0007J\b\u0010(\u001a\u00020\bH\u0007J\b\u0010)\u001a\u00020\bH\u0007J\b\u0010*\u001a\u00020\bH\u0007J\b\u0010+\u001a\u00020\bH\u0007J\b\u0010,\u001a\u00020\bH\u0007J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010.\u001a\u00020\bH\u0007J\b\u0010/\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020\bH\u0007J\b\u00101\u001a\u00020\bH\u0007J\b\u00102\u001a\u00020\bH\u0007J\b\u00103\u001a\u00020\bH\u0007J\u0010\u00104\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u00105\u001a\u00020\bH\u0007J\b\u00106\u001a\u00020\bH\u0007J\b\u00107\u001a\u00020\bH\u0007J\b\u00108\u001a\u00020\bH\u0007J\b\u00109\u001a\u00020\bH\u0007J\b\u0010:\u001a\u00020\bH\u0007J\u0010\u0010;\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010<\u001a\u00020\bH\u0007J\b\u0010=\u001a\u00020\bH\u0007J\b\u0010>\u001a\u00020\bH\u0007J\b\u0010?\u001a\u00020\bH\u0007J\b\u0010@\u001a\u00020\bH\u0007J\b\u0010A\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/audio/utils/player/VOIPPCMPlayerIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markMsgPlayerReport", "", "markPCMAmplitudeHigh", "percent", "markPCMAmplitudeHighPercentAround0", "markPCMAmplitudeHighPercentAround100", "markPCMAmplitudeHighPercentAround20", "markPCMAmplitudeHighPercentAround40", "markPCMAmplitudeHighPercentAround60", "markPCMAmplitudeHighPercentAround80", "markPCMAmplitudeLow", "markPCMAmplitudeLowPercentAround0", "markPCMAmplitudeLowPercentAround100", "markPCMAmplitudeLowPercentAround20", "markPCMAmplitudeLowPercentAround40", "markPCMAmplitudeLowPercentAround60", "markPCMAmplitudeLowPercentAround80", "markPCMAmplitudeMiddle", "markPCMAmplitudeMiddlePercentAround0", "markPCMAmplitudeMiddlePercentAround100", "markPCMAmplitudeMiddlePercentAround20", "markPCMAmplitudeMiddlePercentAround40", "markPCMAmplitudeMiddlePercentAround60", "markPCMAmplitudeMiddlePercentAround80", "markPCMAmplitudeSilent", "markPCMAmplitudeSilentPercentAround0", "markPCMAmplitudeSilentPercentAround100", "markPCMAmplitudeSilentPercentAround20", "markPCMAmplitudeSilentPercentAround40", "markPCMAmplitudeSilentPercentAround60", "markPCMAmplitudeSilentPercentAround80", "markSystemVolumeHigh", "markSystemVolumeHighPercentAround0", "markSystemVolumeHighPercentAround100", "markSystemVolumeHighPercentAround20", "markSystemVolumeHighPercentAround40", "markSystemVolumeHighPercentAround60", "markSystemVolumeHighPercentAround80", "markSystemVolumeLow", "markSystemVolumeLowPercentAround0", "markSystemVolumeLowPercentAround100", "markSystemVolumeLowPercentAround20", "markSystemVolumeLowPercentAround40", "markSystemVolumeLowPercentAround60", "markSystemVolumeLowPercentAround80", "markSystemVolumeMiddle", "markSystemVolumeMiddlePercentAround0", "markSystemVolumeMiddlePercentAround100", "markSystemVolumeMiddlePercentAround20", "markSystemVolumeMiddlePercentAround40", "markSystemVolumeMiddlePercentAround60", "markSystemVolumeMiddlePercentAround80", "markSystemVolumeSilent", "markSystemVolumeSilentPercentAround0", "markSystemVolumeSilentPercentAround100", "markSystemVolumeSilentPercentAround20", "markSystemVolumeSilentPercentAround40", "markSystemVolumeSilentPercentAround60", "markSystemVolumeSilentPercentAround80", "plugin-audiosdk_release"})
public final class b {
    public static final b dAX = new b();

    static {
        AppMethodBeat.i(130175);
        AppMethodBeat.o(130175);
    }

    private b() {
    }

    public static final void aaA() {
        AppMethodBeat.i(130118);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markMsgPlayerReport");
        h.INSTANCE.n(1207, 0, 1);
        AppMethodBeat.o(130118);
    }

    public static final void aaB() {
        AppMethodBeat.i(130119);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround0");
        h.INSTANCE.n(1207, 1, 1);
        AppMethodBeat.o(130119);
    }

    public static final void aaC() {
        AppMethodBeat.i(130120);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround20");
        h.INSTANCE.n(1207, 2, 1);
        AppMethodBeat.o(130120);
    }

    public static final void aaD() {
        AppMethodBeat.i(130121);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround40");
        h.INSTANCE.n(1207, 3, 1);
        AppMethodBeat.o(130121);
    }

    public static final void aaE() {
        AppMethodBeat.i(130122);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround60");
        h.INSTANCE.n(1207, 4, 1);
        AppMethodBeat.o(130122);
    }

    public static final void aaF() {
        AppMethodBeat.i(130123);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround80");
        h.INSTANCE.n(1207, 5, 1);
        AppMethodBeat.o(130123);
    }

    public static final void aaG() {
        AppMethodBeat.i(130124);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilentPercentAround100");
        h.INSTANCE.n(1207, 6, 1);
        AppMethodBeat.o(130124);
    }

    public static final void bv(long j2) {
        AppMethodBeat.i(130125);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeSilent ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 7, j2);
        AppMethodBeat.o(130125);
    }

    public static final void aaH() {
        AppMethodBeat.i(130126);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround0");
        h.INSTANCE.n(1207, 8, 1);
        AppMethodBeat.o(130126);
    }

    public static final void aaI() {
        AppMethodBeat.i(130127);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround20");
        h.INSTANCE.n(1207, 9, 1);
        AppMethodBeat.o(130127);
    }

    public static final void aaJ() {
        AppMethodBeat.i(130128);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround40");
        h.INSTANCE.n(1207, 10, 1);
        AppMethodBeat.o(130128);
    }

    public static final void aaK() {
        AppMethodBeat.i(130129);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround60");
        h.INSTANCE.n(1207, 11, 1);
        AppMethodBeat.o(130129);
    }

    public static final void aaL() {
        AppMethodBeat.i(130130);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround80");
        h.INSTANCE.n(1207, 12, 1);
        AppMethodBeat.o(130130);
    }

    public static final void aaM() {
        AppMethodBeat.i(130131);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeLowPercentAround100");
        h.INSTANCE.n(1207, 13, 1);
        AppMethodBeat.o(130131);
    }

    public static final void bw(long j2) {
        AppMethodBeat.i(130132);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeInLow=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 14, j2);
        AppMethodBeat.o(130132);
    }

    public static final void aaN() {
        AppMethodBeat.i(130133);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround0");
        h.INSTANCE.n(1207, 15, 1);
        AppMethodBeat.o(130133);
    }

    public static final void aaO() {
        AppMethodBeat.i(130134);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround20");
        h.INSTANCE.n(1207, 16, 1);
        AppMethodBeat.o(130134);
    }

    public static final void aaP() {
        AppMethodBeat.i(130135);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround40");
        h.INSTANCE.n(1207, 17, 1);
        AppMethodBeat.o(130135);
    }

    public static final void aaQ() {
        AppMethodBeat.i(130136);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround60");
        h.INSTANCE.n(1207, 18, 1);
        AppMethodBeat.o(130136);
    }

    public static final void aaR() {
        AppMethodBeat.i(130137);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround80");
        h.INSTANCE.n(1207, 19, 1);
        AppMethodBeat.o(130137);
    }

    public static final void aaS() {
        AppMethodBeat.i(130138);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddlePercentAround100");
        h.INSTANCE.n(1207, 20, 1);
        AppMethodBeat.o(130138);
    }

    public static final void bx(long j2) {
        AppMethodBeat.i(130139);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeMiddle: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 21, j2);
        AppMethodBeat.o(130139);
    }

    public static final void aaT() {
        AppMethodBeat.i(130140);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround0");
        h.INSTANCE.n(1207, 22, 1);
        AppMethodBeat.o(130140);
    }

    public static final void aaU() {
        AppMethodBeat.i(130141);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround20");
        h.INSTANCE.n(1207, 23, 1);
        AppMethodBeat.o(130141);
    }

    public static final void aaV() {
        AppMethodBeat.i(130142);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround40");
        h.INSTANCE.n(1207, 24, 1);
        AppMethodBeat.o(130142);
    }

    public static final void aaW() {
        AppMethodBeat.i(130143);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround60");
        h.INSTANCE.n(1207, 25, 1);
        AppMethodBeat.o(130143);
    }

    public static final void aaX() {
        AppMethodBeat.i(130144);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround80");
        h.INSTANCE.n(1207, 26, 1);
        AppMethodBeat.o(130144);
    }

    public static final void aaY() {
        AppMethodBeat.i(130145);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHighPercentAround100");
        h.INSTANCE.n(1207, 27, 1);
        AppMethodBeat.o(130145);
    }

    public static final void by(long j2) {
        AppMethodBeat.i(130146);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markPCMAmplitudeHigh ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 28, j2);
        AppMethodBeat.o(130146);
    }

    public static final void aaZ() {
        AppMethodBeat.i(130147);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround0");
        h.INSTANCE.n(1207, 29, 1);
        AppMethodBeat.o(130147);
    }

    public static final void aba() {
        AppMethodBeat.i(130148);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround20");
        h.INSTANCE.n(1207, 30, 1);
        AppMethodBeat.o(130148);
    }

    public static final void abb() {
        AppMethodBeat.i(130149);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround40");
        h.INSTANCE.n(1207, 31, 1);
        AppMethodBeat.o(130149);
    }

    public static final void abc() {
        AppMethodBeat.i(130150);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround60");
        h.INSTANCE.n(1207, 32, 1);
        AppMethodBeat.o(130150);
    }

    public static final void abd() {
        AppMethodBeat.i(130151);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround80");
        h.INSTANCE.n(1207, 33, 1);
        AppMethodBeat.o(130151);
    }

    public static final void abe() {
        AppMethodBeat.i(130152);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilentPercentAround100");
        h.INSTANCE.n(1207, 34, 1);
        AppMethodBeat.o(130152);
    }

    public static final void bz(long j2) {
        AppMethodBeat.i(130153);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeSilent ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 35, j2);
        AppMethodBeat.o(130153);
    }

    public static final void abf() {
        AppMethodBeat.i(130154);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround0");
        h.INSTANCE.n(1207, 36, 1);
        AppMethodBeat.o(130154);
    }

    public static final void abg() {
        AppMethodBeat.i(130155);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround20");
        h.INSTANCE.n(1207, 37, 1);
        AppMethodBeat.o(130155);
    }

    public static final void abh() {
        AppMethodBeat.i(130156);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround40");
        h.INSTANCE.n(1207, 38, 1);
        AppMethodBeat.o(130156);
    }

    public static final void abi() {
        AppMethodBeat.i(130157);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround60");
        h.INSTANCE.n(1207, 39, 1);
        AppMethodBeat.o(130157);
    }

    public static final void abj() {
        AppMethodBeat.i(130158);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround80");
        h.INSTANCE.n(1207, 40, 1);
        AppMethodBeat.o(130158);
    }

    public static final void abk() {
        AppMethodBeat.i(130159);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLowPercentAround100");
        h.INSTANCE.n(1207, 41, 1);
        AppMethodBeat.o(130159);
    }

    public static final void bA(long j2) {
        AppMethodBeat.i(130160);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeLow=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 42, j2);
        AppMethodBeat.o(130160);
    }

    public static final void abl() {
        AppMethodBeat.i(130161);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround0");
        h.INSTANCE.n(1207, 43, 1);
        AppMethodBeat.o(130161);
    }

    public static final void abm() {
        AppMethodBeat.i(130162);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround20");
        h.INSTANCE.n(1207, 44, 1);
        AppMethodBeat.o(130162);
    }

    public static final void abn() {
        AppMethodBeat.i(130163);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround40");
        h.INSTANCE.n(1207, 45, 1);
        AppMethodBeat.o(130163);
    }

    public static final void abo() {
        AppMethodBeat.i(130164);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround60");
        h.INSTANCE.n(1207, 46, 1);
        AppMethodBeat.o(130164);
    }

    public static final void abp() {
        AppMethodBeat.i(130165);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround80");
        h.INSTANCE.n(1207, 47, 1);
        AppMethodBeat.o(130165);
    }

    public static final void abq() {
        AppMethodBeat.i(130166);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddlePercentAround100");
        h.INSTANCE.n(1207, 48, 1);
        AppMethodBeat.o(130166);
    }

    public static final void bB(long j2) {
        AppMethodBeat.i(130167);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeMiddle: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 49, j2);
        AppMethodBeat.o(130167);
    }

    public static final void abr() {
        AppMethodBeat.i(130168);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround0");
        h.INSTANCE.n(1207, 50, 1);
        AppMethodBeat.o(130168);
    }

    public static final void abs() {
        AppMethodBeat.i(130169);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround20");
        h.INSTANCE.n(1207, 51, 1);
        AppMethodBeat.o(130169);
    }

    public static final void abt() {
        AppMethodBeat.i(130170);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround40");
        h.INSTANCE.n(1207, 52, 1);
        AppMethodBeat.o(130170);
    }

    public static final void abu() {
        AppMethodBeat.i(130171);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround60");
        h.INSTANCE.n(1207, 53, 1);
        AppMethodBeat.o(130171);
    }

    public static final void abv() {
        AppMethodBeat.i(130172);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround80");
        h.INSTANCE.n(1207, 54, 1);
        AppMethodBeat.o(130172);
    }

    public static final void abw() {
        AppMethodBeat.i(130173);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHighPercentAround100");
        h.INSTANCE.n(1207, 55, 1);
        AppMethodBeat.o(130173);
    }

    public static final void bC(long j2) {
        AppMethodBeat.i(130174);
        Log.i("MicroMsg.VOIPPCMPlayerIDKeyStat", "markSystemVolumeHigh ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1207, 56, j2);
        AppMethodBeat.o(130174);
    }
}
