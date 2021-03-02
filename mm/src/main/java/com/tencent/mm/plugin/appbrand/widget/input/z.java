package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class z implements View.OnFocusChangeListener {
    final MMHandler kAn;
    boolean ouS = false;
    public b ouT;
    final Runnable ouU = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.z.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(136567);
            if (z.this.ouT != null) {
                z.this.ouT.ML();
            }
            AppMethodBeat.o(136567);
        }
    };

    public z(EditText editText) {
        AppMethodBeat.i(136572);
        this.ouS = editText.isFocused();
        editText.setOnFocusChangeListener(this);
        this.kAn = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(136572);
    }

    public final Editable c(Editable editable) {
        AppMethodBeat.i(136573);
        editable.setSpan(new SpanWatcher() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.z.AnonymousClass2 */

            public final void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
                AppMethodBeat.i(136568);
                if (aj.cX(obj)) {
                    Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", spannable, obj.getClass().getSimpleName());
                }
                AppMethodBeat.o(136568);
            }

            public final void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
                AppMethodBeat.i(136569);
                if (aj.cX(obj)) {
                    Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", spannable, obj.getClass().getSimpleName());
                    z.this.kAn.removeCallbacks(z.this.ouU);
                    z.this.kAn.postDelayed(z.this.ouU, 100);
                }
                AppMethodBeat.o(136569);
            }

            public final void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(136570);
                if (aj.cX(obj)) {
                    Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", spannable, obj.getClass().getSimpleName());
                }
                AppMethodBeat.o(136570);
            }
        }, 0, editable.length(), 18);
        editable.setSpan(new TextWatcher() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.z.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(136571);
                z.this.kAn.removeCallbacks(z.this.ouU);
                AppMethodBeat.o(136571);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        }, 0, editable.length(), 18);
        AppMethodBeat.o(136573);
        return editable;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(136574);
        this.ouS = z;
        if (!z) {
            this.kAn.removeCallbacks(this.ouU);
        }
        AppMethodBeat.o(136574);
    }
}
