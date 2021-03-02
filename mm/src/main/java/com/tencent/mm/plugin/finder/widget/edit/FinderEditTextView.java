package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "deleteChar", "", "getText", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "insertText", "text", "requestEditFocus", "setTextCursorDrawable", "resId", "setTextCursorVisible", "visible", "", "setTextGravity", "gravity", "setTextHint", "hint", "setTextInputType", "type", "setTextMaxLines", "maxLines", "plugin-finder_release"})
public final class FinderEditTextView extends FrameLayout {
    private String TAG = "Finder.FinderEditTextView";
    public MMEditText wkS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168588);
        init();
        AppMethodBeat.o(168588);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(168589);
        init();
        AppMethodBeat.o(168589);
    }

    private final void init() {
        AppMethodBeat.i(168579);
        this.wkS = new MMEditText(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        addView(mMEditText, layoutParams);
        MMEditText mMEditText2 = this.wkS;
        if (mMEditText2 == null) {
            p.btv("editText");
        }
        mMEditText2.setBackground(null);
        AppMethodBeat.o(168579);
    }

    public final void setTextMaxLines(int i2) {
        AppMethodBeat.i(168580);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.setMaxLines(i2);
        AppMethodBeat.o(168580);
    }

    public final void setTextGravity(int i2) {
        AppMethodBeat.i(168581);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.setGravity(i2);
        AppMethodBeat.o(168581);
    }

    public final void setTextInputType(int i2) {
        AppMethodBeat.i(168582);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.setInputType(i2);
        AppMethodBeat.o(168582);
    }

    public final void setTextCursorVisible(boolean z) {
        AppMethodBeat.i(168583);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.setCursorVisible(z);
        AppMethodBeat.o(168583);
    }

    public final void setTextCursorDrawable(int i2) {
        AppMethodBeat.i(168584);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            p.g(declaredField, "TextView::class.java.get…eld(\"mCursorDrawableRes\")");
            declaredField.setAccessible(true);
            MMEditText mMEditText = this.wkS;
            if (mMEditText == null) {
                p.btv("editText");
            }
            declaredField.set(mMEditText, Integer.valueOf(i2));
            AppMethodBeat.o(168584);
        } catch (Exception e2) {
            Log.e(this.TAG, "set cursor drawable error %s", e2.getMessage());
            AppMethodBeat.o(168584);
        }
    }

    public final void setTextHint(String str) {
        AppMethodBeat.i(168585);
        p.h(str, "hint");
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.setHint(str);
        AppMethodBeat.o(168585);
    }

    public final void awW(String str) {
        AppMethodBeat.i(168586);
        p.h(str, "text");
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.bol(str);
        AppMethodBeat.o(168586);
    }

    public final String getText() {
        AppMethodBeat.i(168587);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        String obj = mMEditText.getText().toString();
        AppMethodBeat.o(168587);
        return obj;
    }
}
