package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    TextView gyt = null;
    String num = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(12731);
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(R.layout.b_t);
        AppMethodBeat.o(12731);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(12732);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b9o, viewGroup2);
        AppMethodBeat.o(12732);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(12733);
        if (this.gyt == null) {
            this.gyt = (TextView) view.findViewById(R.id.bfe);
        }
        this.gyt.setText(this.num);
        super.onBindView(view);
        AppMethodBeat.o(12733);
    }
}
