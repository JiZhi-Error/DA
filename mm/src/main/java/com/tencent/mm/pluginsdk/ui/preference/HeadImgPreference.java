package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private Bitmap Kpt;
    private int height;
    private ImageView kc;
    private View.OnClickListener zHh;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31853);
        this.height = -1;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(31853);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31854);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b98, viewGroup2);
        this.kc = (ImageView) onCreateView.findViewById(R.id.dvw);
        AppMethodBeat.o(31854);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31855);
        super.onBindView(view);
        if (this.kc == null) {
            this.kc = (ImageView) view.findViewById(R.id.dvw);
        }
        if (this.zHh != null) {
            this.kc.setOnClickListener(this.zHh);
        }
        if (this.Kpt != null) {
            this.kc.setImageBitmap(this.Kpt);
            this.Kpt = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fg1);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.o(31855);
    }
}
