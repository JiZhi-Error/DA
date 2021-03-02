package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class SignaturePreference extends Preference {
    public SignaturePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SignaturePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(13016);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(13016);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(13017);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.layout.b9q, viewGroup2);
        AppMethodBeat.o(13017);
        return onCreateView;
    }
}
