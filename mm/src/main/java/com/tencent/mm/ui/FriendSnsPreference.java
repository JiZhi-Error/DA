package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.base.preference.IconPreference;

public final class FriendSnsPreference extends IconPreference {
    private String OBW;
    private Bitmap OBX;
    private long OBY;
    private Context context;

    public FriendSnsPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public FriendSnsPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        this.OBW = null;
        this.OBX = null;
        this.context = context2;
    }

    public final void blM(String str) {
        AppMethodBeat.i(33138);
        this.OBX = null;
        this.OxP = -1;
        this.OBW = str;
        this.OBY = 0;
        if (this.zkw != null) {
            a.b.c(this.zkw, str);
        }
        AppMethodBeat.o(33138);
    }

    public final void No(long j2) {
        AppMethodBeat.i(33139);
        this.OBW = null;
        this.OBX = null;
        this.OxP = -1;
        this.OBY = j2;
        if (!(this.OBY == 0 || this.zkw == null)) {
            ((n) g.af(n.class)).a(this.OBY, this.zkw, this.mContext.hashCode());
        }
        AppMethodBeat.o(33139);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(33140);
        super.onBindView(view);
        if (this.OBW != null && g.aAc()) {
            a.b.c(this.zkw, this.OBW);
        }
        if (!(this.OBY == 0 || this.zkw == null)) {
            ((n) g.af(n.class)).a(this.OBY, this.zkw, this.mContext.hashCode());
        }
        AppMethodBeat.o(33140);
    }
}
