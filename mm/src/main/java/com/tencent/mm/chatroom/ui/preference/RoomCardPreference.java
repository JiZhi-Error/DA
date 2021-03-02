package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean dEF = false;
    private TextView gCe;
    public CharSequence gCf;
    public CharSequence gCg;
    private LinearLayout gCh;
    private View mView;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(13010);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(13010);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(13011);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.b_o, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(13011);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(13012);
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.be9).findViewById(R.id.iqp);
        if (this.gCh == null) {
            this.gCh = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.gCe == null) {
            this.gCe = (TextView) viewGroup.findViewById(R.id.h88);
        }
        if (this.dEF) {
            this.gCh.setVisibility(0);
            this.gCe.setVisibility(0);
        } else {
            this.gCh.setVisibility(8);
            this.gCe.setVisibility(8);
        }
        if (this.gCg != null) {
            this.gCe.setText(this.gCg);
        }
        AppMethodBeat.o(13012);
    }
}
