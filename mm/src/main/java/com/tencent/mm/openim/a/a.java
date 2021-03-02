package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;

public interface a extends i, com.tencent.mm.kernel.c.a {
    Bitmap RY(String str);

    int RZ(String str);

    CharSequence a(Context context, CharSequence charSequence);

    CharSequence a(Context context, String str, String str2, float f2);

    String a(String str, String str2, EnumC0497a aVar);

    void a(Context context, TextView textView, CharSequence charSequence);

    void a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i2);

    String b(String str, String str2, EnumC0497a aVar);

    void bM(String str, String str2);

    String bN(String str, String str2);

    void bkB();

    String c(String str, String str2, EnumC0497a aVar);

    SpannableString e(Context context, String str, int i2);

    TextAppearanceSpan f(Context context, String str, int i2);

    void s(String str, String str2, String str3);

    /* renamed from: com.tencent.mm.openim.a.a$a  reason: collision with other inner class name */
    public enum EnumC0497a {
        TYPE_WORDING,
        TYPE_URL;

        public static EnumC0497a valueOf(String str) {
            AppMethodBeat.i(120684);
            EnumC0497a aVar = (EnumC0497a) Enum.valueOf(EnumC0497a.class, str);
            AppMethodBeat.o(120684);
            return aVar;
        }

        static {
            AppMethodBeat.i(120685);
            AppMethodBeat.o(120685);
        }
    }
}
