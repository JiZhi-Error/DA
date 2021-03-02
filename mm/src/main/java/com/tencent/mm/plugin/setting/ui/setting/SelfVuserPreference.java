package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference extends Preference {
    private String CZJ;
    Drawable drawable;
    String text;

    public SelfVuserPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelfVuserPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(73979);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(73979);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(73980);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_r, viewGroup2);
        AppMethodBeat.o(73980);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(73981);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dvz);
        if (imageView != null) {
            imageView.setImageDrawable(this.drawable);
            Log.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
            if (!Util.isNullOrNil(this.CZJ)) {
                imageView.setContentDescription(this.CZJ);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.ikp);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(this.text);
        }
        AppMethodBeat.o(73981);
    }
}
