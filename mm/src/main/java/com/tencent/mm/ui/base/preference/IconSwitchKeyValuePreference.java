package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.ui.tools.u;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView BfZ;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.status = 0;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(142566);
        super.onBindView(view);
        this.BfZ = (TextView) view.findViewById(16908304);
        updateView();
        AppMethodBeat.o(142566);
    }

    public final void alK(int i2) {
        AppMethodBeat.i(142567);
        this.status = i2;
        updateView();
        AppMethodBeat.o(142567);
    }

    private void updateView() {
        AppMethodBeat.i(142568);
        if (this.BfZ == null) {
            AppMethodBeat.o(142568);
            return;
        }
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0f);
        this.BfZ.setTextColor(u.kG(this.mContext));
        if (this.status == 0) {
            this.BfZ.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountunkey, 0, 0, 0);
            this.BfZ.setCompoundDrawablePadding(fromDPToPix);
            AppMethodBeat.o(142568);
        } else if (this.status == 1) {
            this.BfZ.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountkey, 0, 0, 0);
            this.BfZ.setCompoundDrawablePadding(fromDPToPix);
            AppMethodBeat.o(142568);
        } else if (this.status == 2) {
            this.BfZ.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountkey_off, 0, 0, 0);
            this.BfZ.setCompoundDrawablePadding(fromDPToPix);
            AppMethodBeat.o(142568);
        } else {
            this.BfZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(142568);
        }
    }
}
