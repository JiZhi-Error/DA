package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlaySound {
    private static final String TAG = "MicroMsg.PlaySound";

    public interface OnPlayCompletionListener {
        void onCompletion();
    }

    public enum SPEAKERON {
        NOTSET,
        ON,
        OFF;

        public static SPEAKERON valueOf(String str) {
            AppMethodBeat.i(157784);
            SPEAKERON speakeron = (SPEAKERON) Enum.valueOf(SPEAKERON.class, str);
            AppMethodBeat.o(157784);
            return speakeron;
        }

        static {
            AppMethodBeat.i(157785);
            AppMethodBeat.o(157785);
        }
    }

    public static MediaPlayer playRoot(Context context, int i2, SPEAKERON speakeron, boolean z, OnPlayCompletionListener onPlayCompletionListener) {
        AppMethodBeat.i(230368);
        MediaPlayer playRoot = playRoot(context, i2, speakeron, -1, z, onPlayCompletionListener);
        AppMethodBeat.o(230368);
        return playRoot;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013e A[SYNTHETIC, Splitter:B:40:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015c A[SYNTHETIC, Splitter:B:48:0x015c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.media.MediaPlayer playRoot(android.content.Context r8, final int r9, com.tencent.mm.sdk.platformtools.PlaySound.SPEAKERON r10, int r11, boolean r12, final com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener r13) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.PlaySound.playRoot(android.content.Context, int, com.tencent.mm.sdk.platformtools.PlaySound$SPEAKERON, int, boolean, com.tencent.mm.sdk.platformtools.PlaySound$OnPlayCompletionListener):android.media.MediaPlayer");
    }

    public static MediaPlayer playReturn(Context context, int i2, boolean z, OnPlayCompletionListener onPlayCompletionListener) {
        AppMethodBeat.i(230369);
        MediaPlayer playRoot = playRoot(context, i2, z ? SPEAKERON.ON : SPEAKERON.OFF, false, onPlayCompletionListener);
        AppMethodBeat.o(230369);
        return playRoot;
    }

    public static void play(Context context, int i2, boolean z, boolean z2, OnPlayCompletionListener onPlayCompletionListener) {
        AppMethodBeat.i(230370);
        playRoot(context, i2, z ? SPEAKERON.ON : SPEAKERON.OFF, z2, onPlayCompletionListener);
        AppMethodBeat.o(230370);
    }

    public static void play(Context context, int i2, boolean z, OnPlayCompletionListener onPlayCompletionListener) {
        AppMethodBeat.i(230371);
        playRoot(context, i2, z ? SPEAKERON.ON : SPEAKERON.OFF, false, onPlayCompletionListener);
        AppMethodBeat.o(230371);
    }

    public static void play(Context context, int i2, OnPlayCompletionListener onPlayCompletionListener) {
        AppMethodBeat.i(157789);
        playRoot(context, i2, SPEAKERON.NOTSET, false, onPlayCompletionListener);
        AppMethodBeat.o(157789);
    }

    public static void play(Context context, int i2) {
        AppMethodBeat.i(157790);
        playRoot(context, i2, SPEAKERON.NOTSET, false, null);
        AppMethodBeat.o(157790);
    }

    public static void play(Context context, int i2, int i3) {
        AppMethodBeat.i(230372);
        playRoot(context, i2, SPEAKERON.NOTSET, i3, false, null);
        AppMethodBeat.o(230372);
    }

    public static void playLoop(Context context, int i2, int i3) {
        AppMethodBeat.i(230373);
        playRoot(context, i2, SPEAKERON.NOTSET, i3, true, null);
        AppMethodBeat.o(230373);
    }
}
