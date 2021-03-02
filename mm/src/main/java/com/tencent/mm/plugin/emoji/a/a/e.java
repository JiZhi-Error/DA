package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class e {
    public static boolean a(EmotionSummary emotionSummary) {
        AppMethodBeat.i(108373);
        if (emotionSummary == null) {
            AppMethodBeat.o(108373);
            return false;
        }
        boolean fA = fA(emotionSummary.PackFlag, 1);
        AppMethodBeat.o(108373);
        return fA;
    }

    public static boolean b(EmotionSummary emotionSummary) {
        AppMethodBeat.i(108374);
        if (c(emotionSummary) || d(emotionSummary)) {
            AppMethodBeat.o(108374);
            return true;
        }
        AppMethodBeat.o(108374);
        return false;
    }

    private static boolean c(EmotionSummary emotionSummary) {
        AppMethodBeat.i(108376);
        if (emotionSummary == null) {
            AppMethodBeat.o(108376);
            return false;
        }
        boolean fA = fA(emotionSummary.PackType, 4);
        AppMethodBeat.o(108376);
        return fA;
    }

    private static boolean d(EmotionSummary emotionSummary) {
        AppMethodBeat.i(108377);
        if (emotionSummary == null) {
            AppMethodBeat.o(108377);
            return false;
        }
        boolean fA = fA(emotionSummary.PackType, 8);
        AppMethodBeat.o(108377);
        return fA;
    }

    public static boolean e(EmotionSummary emotionSummary) {
        AppMethodBeat.i(108378);
        if (emotionSummary == null) {
            AppMethodBeat.o(108378);
            return false;
        }
        boolean fA = fA(emotionSummary.PackFlag, 8);
        AppMethodBeat.o(108378);
        return fA;
    }

    public static boolean fA(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static boolean FT(int i2) {
        AppMethodBeat.i(108375);
        if (fA(i2, 4) || fA(i2, 8)) {
            AppMethodBeat.o(108375);
            return true;
        }
        AppMethodBeat.o(108375);
        return false;
    }
}
