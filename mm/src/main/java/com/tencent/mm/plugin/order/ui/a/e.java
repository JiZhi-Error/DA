package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    public String AQz;
    public View.OnClickListener mOnClickListener = null;
    private View mView = null;

    public e(Context context) {
        super(context);
        AppMethodBeat.i(66811);
        setLayoutResource(R.layout.b5t);
        AppMethodBeat.o(66811);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66812);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66812);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66813);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.f7j);
        textView.setText(this.AQz);
        textView.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(66813);
    }
}
