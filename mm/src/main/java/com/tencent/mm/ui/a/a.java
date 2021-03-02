package com.tencent.mm.ui.a;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
    TextToSpeech OLT = null;
    private boolean OLU;
    private long OLV;
    private AccessibilityManager asr;
    public Context mAppContext;
    private Vibrator paT;

    public a(Context context) {
        AppMethodBeat.i(141494);
        this.mAppContext = context;
        this.asr = (AccessibilityManager) this.mAppContext.getSystemService("accessibility");
        AppMethodBeat.o(141494);
    }

    /* renamed from: com.tencent.mm.ui.a.a$a */
    public static class C2075a {
        private static final a OLX = new a(MMApplicationContext.getContext());

        static {
            AppMethodBeat.i(141493);
            AppMethodBeat.o(141493);
        }
    }

    public final boolean gKc() {
        AppMethodBeat.i(141495);
        if (SystemClock.uptimeMillis() - this.OLV > 2000) {
            this.OLU = this.asr.isEnabled() && this.asr.isTouchExplorationEnabled();
            this.OLV = SystemClock.uptimeMillis();
        }
        boolean z = this.OLU;
        AppMethodBeat.o(141495);
        return z;
    }

    public final boolean gKd() {
        AppMethodBeat.i(205152);
        AudioManager audioManager = (AudioManager) this.mAppContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!gKc() || (Settings.Secure.getInt(this.mAppContext.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            AppMethodBeat.o(205152);
            return false;
        }
        AppMethodBeat.o(205152);
        return true;
    }

    public final void g(View view, final String str) {
        AppMethodBeat.i(205153);
        if (this.OLT == null) {
            this.OLT = new TextToSpeech(this.mAppContext, new TextToSpeech.OnInitListener() {
                /* class com.tencent.mm.ui.a.a.AnonymousClass1 */

                public final void onInit(int i2) {
                    AppMethodBeat.i(141492);
                    if (a.this.OLT != null) {
                        a.this.OLT.setLanguage(LocaleUtil.isChineseAppLang() ? Locale.CHINESE : Locale.ENGLISH);
                        a.this.OLT.speak(str, 0, null);
                    }
                    AppMethodBeat.o(141492);
                }
            });
        } else {
            this.OLT.setLanguage(LocaleUtil.isChineseAppLang() ? Locale.CHINESE : Locale.ENGLISH);
            this.OLT.speak(str, 0, null);
        }
        gs(view);
        AppMethodBeat.o(205153);
    }

    public final void gs(View view) {
        AppMethodBeat.i(205154);
        if (view == null) {
            AppMethodBeat.o(205154);
            return;
        }
        try {
            Method method = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
            method.setAccessible(true);
            method.invoke(view, new Object[0]);
            Method method2 = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
            method2.setAccessible(true);
            method2.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e2, "", new Object[0]);
        }
        if (this.paT != null) {
            this.paT = (Vibrator) MMApplicationContext.getContext().getSystemService("vibrator");
        }
        if (this.paT != null) {
            this.paT.vibrate(50);
        }
        AppMethodBeat.o(205154);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 > 0) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.a.a.a(android.view.View, java.lang.String, java.lang.String, int):void");
    }

    public final void a(View view, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(141497);
        if (!gKc()) {
            AppMethodBeat.o(141497);
        } else if (this.mAppContext == null || view == null) {
            AppMethodBeat.o(141497);
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(141497);
        } else {
            b bVar = new b();
            bVar.blW(str);
            if (i2 > 0) {
                bVar.blW(this.mAppContext.getResources().getQuantityString(R.plurals.f3138e, 1, Integer.valueOf(i2)));
            }
            bVar.blW(str2).blW(str3);
            bVar.gt(view);
            AppMethodBeat.o(141497);
        }
    }

    public final void aF(View view, int i2) {
        AppMethodBeat.i(141498);
        if (!gKc()) {
            AppMethodBeat.o(141498);
        } else if (this.mAppContext == null || view == null) {
            AppMethodBeat.o(141498);
        } else {
            int max = Math.max(i2, 1);
            b bVar = new b();
            bVar.blW(this.mAppContext.getResources().getQuantityString(R.plurals.f3137d, max, Integer.valueOf(max)));
            bVar.gt(view);
            AppMethodBeat.o(141498);
        }
    }

    public final void p(Activity activity, String str) {
        AppMethodBeat.i(141499);
        if (gKc()) {
            AppMethodBeat.o(141499);
        } else if (Util.isNullOrNil(str) || activity == null) {
            AppMethodBeat.o(141499);
        } else {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(R.string.b8u) + str);
            AppMethodBeat.o(141499);
        }
    }
}
