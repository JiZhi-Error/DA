package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import com.tencent.mm.d.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.MMEditText;

public final class m {
    private static LruCache<String, Integer> KdG = new LruCache<>(50);
    private SpannableString KdA;
    private SpannableStringBuilder KdB = new SpannableStringBuilder();
    private CharacterStyle KdC = new ForegroundColorSpan(-5066062);
    private int KdD;
    private int KdE;
    public int KdF = 3;
    private StringBuilder Kdy;
    private SpannableStringBuilder Kdz = new SpannableStringBuilder();
    private Context mContext;

    public m(Context context) {
        AppMethodBeat.i(31274);
        this.mContext = context;
        AppMethodBeat.o(31274);
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        int length;
        int i2;
        AppMethodBeat.i(31275);
        if (mMEditText == null) {
            AppMethodBeat.o(31275);
        } else if (this.Kdy == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should saveHistory before setText");
            AppMethodBeat.o(31275);
            throw illegalStateException;
        } else {
            int length2 = this.KdD + str.length();
            this.Kdz.clear();
            this.KdB.clear();
            if (z) {
                this.KdA = g.gxZ().a(this.mContext, this.Kdy.subSequence(0, this.KdD), mMEditText.getTextSize());
                SpannableStringBuilder append = this.Kdz.append((CharSequence) this.KdA);
                SpannableStringBuilder spannableStringBuilder2 = this.KdB;
                if (spannableStringBuilder2 == null || str == null || str.length() == 0) {
                    spannableStringBuilder = spannableStringBuilder2;
                } else {
                    if (str.length() < this.KdF) {
                        length = str.length();
                        i2 = 0;
                    } else {
                        length = str.length();
                        i2 = length - this.KdF;
                    }
                    spannableStringBuilder2.append((CharSequence) str).setSpan(this.KdC, i2, length, 33);
                    spannableStringBuilder = spannableStringBuilder2;
                }
                append.append((CharSequence) spannableStringBuilder).append(this.Kdy.subSequence(this.KdE, this.Kdy.length()));
            } else {
                this.KdA = g.gxZ().a(this.mContext, str, mMEditText.getTextSize());
                this.Kdz.append((CharSequence) this.KdA);
            }
            Log.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.KdD), Integer.valueOf(this.KdE), Integer.valueOf(length2), Integer.valueOf(this.Kdz.length()), str, this.Kdz);
            mMEditText.setText(this.Kdz);
            if (length2 <= this.Kdz.length()) {
                if (length2 == 0) {
                    mMEditText.setSelection(this.Kdz.length());
                    AppMethodBeat.o(31275);
                    return;
                }
                mMEditText.setSelection(length2);
            }
            AppMethodBeat.o(31275);
        }
    }

    public final void d(MMEditText mMEditText) {
        AppMethodBeat.i(31276);
        if (mMEditText == null) {
            AppMethodBeat.o(31276);
            return;
        }
        this.KdF = 0;
        this.KdA = g.gxZ().a(this.mContext, mMEditText.getText().toString(), mMEditText.getTextSize());
        Log.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.KdA);
        mMEditText.setText(this.KdA);
        mMEditText.setSelection(this.KdA.length());
        AppMethodBeat.o(31276);
    }

    public final void e(MMEditText mMEditText) {
        AppMethodBeat.i(31277);
        if (mMEditText == null) {
            AppMethodBeat.o(31277);
            return;
        }
        this.KdD = mMEditText.getSelectionStart();
        this.KdE = mMEditText.getSelectionEnd();
        this.Kdy = new StringBuilder(mMEditText.getText());
        Log.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.KdD), Integer.valueOf(this.KdE), this.Kdy);
        if (mMEditText.getText().toString().equalsIgnoreCase("")) {
            this.Kdz.clear();
        }
        if (this.KdD < 0) {
            this.KdD = 0;
        }
        if (this.KdE < 0) {
            this.KdE = 0;
        }
        AppMethodBeat.o(31277);
    }

    static {
        AppMethodBeat.i(31280);
        AppMethodBeat.o(31280);
    }

    public final synchronized int beA(String str) {
        int i2;
        AppMethodBeat.i(31278);
        if (KdG.size() == 0) {
            try {
                for (String str2 : ((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, "")).split(";")) {
                    String[] split = str2.split(":");
                    if (split.length == 2) {
                        KdG.put(split[0], Integer.valueOf(j.cL(split[1])));
                    }
                }
            } catch (Error e2) {
            }
        }
        if (KdG.check(str)) {
            i2 = KdG.get(str).intValue();
            AppMethodBeat.o(31278);
        } else {
            AppMethodBeat.o(31278);
            i2 = 0;
        }
        return i2;
    }

    public final synchronized void gH(String str, int i2) {
        AppMethodBeat.i(31279);
        KdG.put(str, Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder();
        Object[] array = KdG.keySet().toArray();
        Object[] array2 = KdG.values().toArray();
        for (int i3 = 0; i3 < array.length; i3++) {
            sb.append(array[i3]).append(":").append(array2[i3]).append(";");
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, sb.toString());
        AppMethodBeat.o(31279);
    }
}
