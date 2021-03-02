package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.SpannableString;

public interface f {
    boolean M(CharSequence charSequence);

    boolean N(CharSequence charSequence);

    SpannableString b(Context context, CharSequence charSequence, int i2);

    public static class a {
        protected static f KqF;

        public static final void a(f fVar) {
            KqF = fVar;
        }
    }
}
