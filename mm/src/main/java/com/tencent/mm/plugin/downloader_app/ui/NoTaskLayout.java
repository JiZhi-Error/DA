package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.b;

public class NoTaskLayout extends RelativeLayout {
    private ImageView nSS;
    private BottomEntranceView qMz;

    public NoTaskLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(9019);
        super.onFinishInflate();
        this.nSS = (ImageView) findViewById(R.id.dx2);
        this.qMz = (BottomEntranceView) findViewById(R.id.aak);
        b.e(this.nSS, "download_non_task");
        AppMethodBeat.o(9019);
    }

    public void setData(f fVar) {
        AppMethodBeat.i(9020);
        this.qMz.setData(fVar);
        AppMethodBeat.o(9020);
    }
}
