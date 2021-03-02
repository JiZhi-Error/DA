package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMTextView;

public final class c {
    TextView yDA;
    LinearLayout yDB;
    MMTextView yDz;

    public c(View view) {
        AppMethodBeat.i(26323);
        this.yDz = (MMTextView) view.findViewById(R.id.e73);
        this.yDA = (TextView) view.findViewById(R.id.e72);
        this.yDB = (LinearLayout) view.findViewById(R.id.e71);
        AppMethodBeat.o(26323);
    }
}
