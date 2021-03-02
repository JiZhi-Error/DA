package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;

public final class PluginTextPreference extends Preference {
    private ImageView Bga;
    public int OZn;
    private TextView gyt;
    private String text;
    private int textColor;
    public int visibility;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142627);
        this.Bga = null;
        this.gyt = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.PluginTextPreference);
        setLayoutResource(obtainStyledAttributes.getResourceId(1, R.layout.b9j));
        this.OZn = obtainStyledAttributes.getResourceId(0, 0);
        this.text = obtainStyledAttributes.getString(2);
        this.textColor = obtainStyledAttributes.getColor(3, -7039852);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(142627);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142629);
        super.onBindView(view);
        this.Bga = (ImageView) view.findViewById(R.id.dvz);
        this.Bga.setImageResource(this.OZn);
        this.Bga.setVisibility(this.visibility);
        this.gyt = (TextView) view.findViewById(R.id.ikp);
        this.gyt.setText(this.text);
        this.gyt.setTextColor(this.textColor);
        AppMethodBeat.o(142629);
    }

    public final void alN(int i2) {
        AppMethodBeat.i(142628);
        this.text = this.mContext.getString(i2);
        AppMethodBeat.o(142628);
    }
}
