package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView Bgk;
    private int Bgl;
    private Bitmap Bgm;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27256);
        this.Bgk = null;
        this.Bgl = -1;
        this.Bgm = null;
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(0);
        AppMethodBeat.o(27256);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27257);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.ba3, viewGroup2);
        AppMethodBeat.o(27257);
        return onCreateView;
    }

    public final void al(Bitmap bitmap) {
        AppMethodBeat.i(27258);
        this.Bgm = bitmap;
        if (this.Bgk != null) {
            this.Bgk.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(27258);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27259);
        super.onBindView(view);
        this.Bgk = (ImageView) view.findViewById(R.id.gg1);
        if (this.Bgk != null) {
            this.Bgk.setVisibility(8);
            if (this.Bgl != -1) {
                this.Bgk.setImageResource(this.Bgl);
                this.Bgk.setVisibility(0);
                AppMethodBeat.o(27259);
                return;
            } else if (this.Bgm != null) {
                this.Bgk.setImageBitmap(this.Bgm);
                this.Bgk.setVisibility(0);
            }
        }
        AppMethodBeat.o(27259);
    }
}
