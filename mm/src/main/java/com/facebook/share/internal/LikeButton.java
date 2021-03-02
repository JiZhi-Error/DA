package com.facebook.share.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        AppMethodBeat.i(8108);
        setSelected(z);
        AppMethodBeat.o(8108);
    }

    @Deprecated
    public void setSelected(boolean z) {
        AppMethodBeat.i(8109);
        super.setSelected(z);
        updateForLikeStatus();
        AppMethodBeat.o(8109);
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        AppMethodBeat.i(8110);
        super.configureButton(context, attributeSet, i2, i3);
        updateForLikeStatus();
        AppMethodBeat.o(8110);
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return 0;
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.a5g;
    }

    private void updateForLikeStatus() {
        AppMethodBeat.i(8111);
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.b8j, 0, 0, 0);
            setText(getResources().getString(R.string.b82));
            AppMethodBeat.o(8111);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.q4, 0, 0, 0);
        setText(getResources().getString(R.string.b83));
        AppMethodBeat.o(8111);
    }
}
