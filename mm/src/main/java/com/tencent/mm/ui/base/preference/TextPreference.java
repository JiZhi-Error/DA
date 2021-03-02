package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TextPreference extends Preference {
    protected int Ku;
    protected TextView Ws;
    private Context context;
    protected CharSequence mText;

    public TextPreference(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(142681);
        this.context = context2;
        setLayoutResource(R.layout.b_7);
        AppMethodBeat.o(142681);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142682);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(142682);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142683);
        super.onBindView(view);
        this.Ws = (TextView) view.findViewById(16908310);
        updateView();
        AppMethodBeat.o(142683);
    }

    private void updateView() {
        AppMethodBeat.i(142684);
        if (this.Ws == null) {
            AppMethodBeat.o(142684);
            return;
        }
        this.Ws.setText(this.mText);
        this.Ws.setGravity(this.Ku);
        AppMethodBeat.o(142684);
    }

    public final void ar(CharSequence charSequence) {
        AppMethodBeat.i(142685);
        this.mText = charSequence;
        this.Ku = 17;
        updateView();
        AppMethodBeat.o(142685);
    }
}
