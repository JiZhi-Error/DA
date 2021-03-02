package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zza(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(11877);
        switch (i2) {
            case 0:
                AppMethodBeat.o(11877);
                return i3;
            case 1:
                AppMethodBeat.o(11877);
                return i4;
            case 2:
                AppMethodBeat.o(11877);
                return i5;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(i2).toString());
                AppMethodBeat.o(11877);
                throw illegalStateException;
        }
    }

    public final void configure(Resources resources, int i2, int i3) {
        AppMethodBeat.i(11876);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f2 = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f2 * 48.0f) + 0.5f));
        setMinWidth((int) ((f2 * 48.0f) + 0.5f));
        int zza = zza(i3, R.drawable.qf, R.drawable.qj, R.drawable.qj);
        int zza2 = zza(i3, R.drawable.qm, R.drawable.qq, R.drawable.qq);
        switch (i2) {
            case 0:
            case 1:
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i2).toString());
                AppMethodBeat.o(11876);
                throw illegalStateException;
            case 2:
                zza2 = zza;
                break;
        }
        Drawable i4 = a.i(resources.getDrawable(zza2));
        a.a(i4, resources.getColorStateList(R.color.ki));
        a.a(i4, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(i4);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zza(i3, R.color.k9, R.color.kd, R.color.kd))));
        switch (i2) {
            case 0:
                setText(resources.getString(R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i2).toString());
                AppMethodBeat.o(11876);
                throw illegalStateException2;
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
        AppMethodBeat.o(11876);
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        AppMethodBeat.i(11875);
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
        AppMethodBeat.o(11875);
    }
}
