package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;

public final class ImagePreference extends Preference {
    private ImageView Bga;
    private e OYt;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142569);
        this.Bga = null;
        this.OYt = new e();
        setLayoutResource(R.layout.b_5);
        setWidgetLayoutResource(R.layout.b_t);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.ImagePreference);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            e eVar = this.OYt;
            eVar.resId = resourceId;
            eVar.bitmap = null;
            this.OYt.p(this.Bga);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(142569);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142570);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.bf0);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_5, viewGroup2);
        AppMethodBeat.o(142570);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142571);
        super.onBindView(view);
        this.Bga = (ImageView) view.findViewById(R.id.dvz);
        this.OYt.p(this.Bga);
        AppMethodBeat.o(142571);
    }
}
