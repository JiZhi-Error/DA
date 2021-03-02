package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0006\u0010$\u001a\u00020\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/ui/widget/PrefixEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "hintSpan", "Landroid/text/SpannableString;", "isHintVisible", "", "prefixText", "", "textWatcher", "Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "dismissHint", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "text", "hint", "hintColor", "onSelectionChanged", "selStart", "selEnd", "setSelection", FirebaseAnalytics.b.INDEX, "start", "stop", "setTextSpanWithNoTextWatcher", "setTextWithNoTextWatcher", "showHint", "Companion", "PrefixTextWatcher", "libmmui_release"})
public final class PrefixEditText extends MMEditText {
    public static final a QEk = new a((byte) 0);
    private String QEi = "";
    private b QEj;

    static {
        AppMethodBeat.i(204884);
        AppMethodBeat.o(204884);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/widget/PrefixEditText$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public PrefixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrefixEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private final void setTextWithNoTextWatcher(String str) {
        AppMethodBeat.i(204879);
        b bVar = this.QEj;
        if (bVar != null) {
            removeTextChangedListener(bVar);
            setText(str);
            addTextChangedListener(bVar);
            AppMethodBeat.o(204879);
            return;
        }
        AppMethodBeat.o(204879);
    }

    private final void setTextSpanWithNoTextWatcher(SpannableString spannableString) {
        AppMethodBeat.i(204880);
        b bVar = this.QEj;
        if (bVar != null) {
            removeTextChangedListener(bVar);
            setText(spannableString);
            addTextChangedListener(bVar);
            AppMethodBeat.o(204880);
            return;
        }
        AppMethodBeat.o(204880);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.MMEditText
    public final void setSelection(int i2) {
        AppMethodBeat.i(204881);
        try {
            super.setSelection(i2);
            AppMethodBeat.o(204881);
        } catch (IndexOutOfBoundsException e2) {
            AppMethodBeat.o(204881);
        }
    }

    @Override // com.tencent.mm.ui.widget.MMEditText
    public final void setSelection(int i2, int i3) {
        AppMethodBeat.i(204882);
        try {
            super.setSelection(i2, i3);
            AppMethodBeat.o(204882);
        } catch (IndexOutOfBoundsException e2) {
            AppMethodBeat.o(204882);
        }
    }

    /* access modifiers changed from: protected */
    public final void onSelectionChanged(int i2, int i3) {
        int i4;
        AppMethodBeat.i(204883);
        if (!Util.isNullOrNil(this.QEi)) {
            int length = this.QEi.length();
            if (i2 < length) {
                i4 = length;
            } else {
                i4 = i2;
            }
            if (i3 >= length) {
                length = i3;
            }
            if (!(i2 == i4 && i3 == length)) {
                Log.i("Finder.PrefixEditText", "onSelectionChanged : " + i2 + "--" + i3 + " pos:" + i4 + "--" + length);
                setSelection(i4, length);
            }
        }
        super.onSelectionChanged(i2, i3);
        AppMethodBeat.o(204883);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J*\u0010\u001b\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "prefix", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "beforeText", "isRevert", "", "()Z", "setRevert", "(Z)V", "getPrefix", "()Ljava/lang/String;", "prefixSize", "", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "beforeTextCs", "", "start", "count", "after", "onTextChanged", "before", "libmmui_release"})
    public static final class b implements TextWatcher {
        private String GeX;
        private boolean QEl;
        private int QEm;
        private final EditText vy;

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(204877);
            if (this.QEl) {
                EditText editText = this.vy;
                editText.removeTextChangedListener(this);
                String str = this.GeX;
                editText.setText(str != null ? str : "");
                editText.addTextChangedListener(this);
                editText.setSelection(this.QEm);
                this.QEl = false;
            }
            AppMethodBeat.o(204877);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String str;
            String str2;
            AppMethodBeat.i(204878);
            if (i2 == this.QEm - 1) {
                if (i3 > 0) {
                    this.QEl = true;
                    if (charSequence == null || (str2 = charSequence.toString()) == null) {
                        str2 = "";
                    }
                    this.GeX = str2;
                    AppMethodBeat.o(204878);
                    return;
                }
            } else if (i2 < this.QEm - 1) {
                this.QEl = true;
                if (charSequence == null || (str = charSequence.toString()) == null) {
                    str = "";
                }
                this.GeX = str;
            }
            AppMethodBeat.o(204878);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }
}
