package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference extends Preference {
    private MaskLayout gyq;
    private ImageView gyr;
    private String gys;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(12728);
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(R.layout.b_6);
        AppMethodBeat.o(12728);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(12729);
        View onCreateView = super.onCreateView(viewGroup);
        this.gyq = (MaskLayout) onCreateView.findViewById(R.id.dwa);
        this.gyr = (ImageView) onCreateView.findViewById(R.id.dup);
        AppMethodBeat.o(12729);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(12730);
        super.onBindView(view);
        if (this.gyr != null && !Util.isNullOrNil(this.gys)) {
            a.b.c(this.gyr, this.gys);
        }
        AppMethodBeat.o(12730);
    }
}
