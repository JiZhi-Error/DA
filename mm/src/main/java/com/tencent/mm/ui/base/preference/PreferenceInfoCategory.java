package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceInfoCategory extends Preference {
    public View.OnClickListener OZL;
    public View.OnClickListener OZM;
    public int Oyf;

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142661);
        this.OZL = null;
        this.OZM = null;
        this.Oyf = 0;
        setLayoutResource(R.layout.b_b);
        AppMethodBeat.o(142661);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142662);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.o(142662);
            return;
        }
        if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            textView.setOnClickListener(this.OZM);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.gu);
        imageView.setOnClickListener(this.OZL);
        if (this.Oyf > 0) {
            imageView.setImageResource(this.Oyf);
        }
        AppMethodBeat.o(142662);
    }
}
