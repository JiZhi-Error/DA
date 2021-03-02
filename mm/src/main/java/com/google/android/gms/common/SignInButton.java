package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzbw;
    private View.OnClickListener zzbx;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(10955);
        this.zzbx = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(0, 0);
            this.mColor = obtainStyledAttributes.getInt(1, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.mSize, this.mColor);
            AppMethodBeat.o(10955);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(10955);
            throw th;
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(10963);
        if (this.zzbx != null && view == this.zzbw) {
            this.zzbx.onClick(this);
        }
        AppMethodBeat.o(10963);
    }

    public final void setColorScheme(int i2) {
        AppMethodBeat.i(10957);
        setStyle(this.mSize, i2);
        AppMethodBeat.o(10957);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.i(10962);
        super.setEnabled(z);
        this.zzbw.setEnabled(z);
        AppMethodBeat.o(10962);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(10961);
        this.zzbx = onClickListener;
        if (this.zzbw != null) {
            this.zzbw.setOnClickListener(this);
        }
        AppMethodBeat.o(10961);
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        AppMethodBeat.i(10958);
        setStyle(this.mSize, this.mColor);
        AppMethodBeat.o(10958);
    }

    public final void setSize(int i2) {
        AppMethodBeat.i(10956);
        setStyle(i2, this.mColor);
        AppMethodBeat.o(10956);
    }

    public final void setStyle(int i2, int i3) {
        AppMethodBeat.i(10959);
        this.mSize = i2;
        this.mColor = i3;
        Context context = getContext();
        if (this.zzbw != null) {
            removeView(this.zzbw);
        }
        try {
            this.zzbw = SignInButtonCreator.createView(context, this.mSize, this.mColor);
        } catch (RemoteCreator.RemoteCreatorException e2) {
            int i4 = this.mSize;
            int i5 = this.mColor;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.configure(context.getResources(), i4, i5);
            this.zzbw = signInButtonImpl;
        }
        addView(this.zzbw);
        this.zzbw.setEnabled(isEnabled());
        this.zzbw.setOnClickListener(this);
        AppMethodBeat.o(10959);
    }

    @Deprecated
    public final void setStyle(int i2, int i3, Scope[] scopeArr) {
        AppMethodBeat.i(10960);
        setStyle(i2, i3);
        AppMethodBeat.o(10960);
    }
}
