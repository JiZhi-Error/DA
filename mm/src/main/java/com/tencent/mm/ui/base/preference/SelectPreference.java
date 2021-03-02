package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SelectPreference extends Preference {
    private boolean enable = true;
    public boolean isSelected;
    private View mView;
    private WeImageView wDG;

    public SelectPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142670);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142670);
    }

    public SelectPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectPreference(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142671);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_q, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(142671);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        AppMethodBeat.i(142672);
        super.onBindView(view);
        alO(8);
        this.wDG = (WeImageView) view.findViewById(R.id.i4u);
        WeImageView weImageView = this.wDG;
        if (this.isSelected) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        weImageView.setVisibility(i2);
        AppMethodBeat.o(142672);
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean getSelected() {
        return this.isSelected;
    }
}
