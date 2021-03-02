package com.tenpay.android.wechat;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TenpayTTSUtil {
    private static boolean sEnabled = true;
    private static TextToSpeech sTts;

    public static void init(Context context) {
        AppMethodBeat.i(130959);
        if (sTts == null) {
            sTts = new TextToSpeech(context.getApplicationContext(), null);
        }
        AppMethodBeat.o(130959);
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static void speak(String str) {
        AppMethodBeat.i(130960);
        if (sEnabled && sTts != null && !TextUtils.isEmpty(str)) {
            sTts.speak(str, 1, null);
        }
        AppMethodBeat.o(130960);
    }

    public static void speak(CharSequence charSequence) {
        AppMethodBeat.i(130961);
        if (sEnabled && sTts != null && !TextUtils.isEmpty(charSequence)) {
            sTts.speak(charSequence.toString(), 1, null);
        }
        AppMethodBeat.o(130961);
    }

    public static void stop() {
        AppMethodBeat.i(130962);
        if (sTts != null) {
            sTts.stop();
        }
        AppMethodBeat.o(130962);
    }

    public static void destroy() {
        AppMethodBeat.i(130963);
        if (sTts != null) {
            sTts.stop();
            sTts.shutdown();
            sTts = null;
        }
        AppMethodBeat.o(130963);
    }
}
