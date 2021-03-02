package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public class f extends d {
    private k.b qnG;
    public String qnQ;
    private String qnR;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.plugin.choosemsgfile.b.b.a] */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.d
    public final /* bridge */ /* synthetic */ void a(m mVar, int i2, a aVar) {
        AppMethodBeat.i(162328);
        a(mVar, i2, aVar);
        AppMethodBeat.o(162328);
    }

    private k.b cyz() {
        AppMethodBeat.i(123267);
        if (this.qnG == null) {
            this.qnG = k.b.HD(this.qnv.field_content);
        }
        k.b bVar = this.qnG;
        AppMethodBeat.o(123267);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public String getFileExt() {
        AppMethodBeat.i(123268);
        if (cyz() != null) {
            String str = cyz().iwJ;
            AppMethodBeat.o(123268);
            return str;
        }
        AppMethodBeat.o(123268);
        return "";
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public String getFileName() {
        AppMethodBeat.i(123269);
        if (cyz() != null) {
            String str = cyz().title;
            AppMethodBeat.o(123269);
            return str;
        }
        AppMethodBeat.o(123269);
        return "";
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public int cyt() {
        AppMethodBeat.i(123270);
        if (cyz() != null) {
            int i2 = cyz().iwI;
            AppMethodBeat.o(123270);
            return i2;
        }
        AppMethodBeat.o(123270);
        return 0;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.d
    public final void a(m mVar, int i2, a aVar) {
        AppMethodBeat.i(162327);
        super.a(mVar, i2, aVar);
        mVar.qod.setVisibility(0);
        mVar.qod.setText(getFileName());
        mVar.qoe.setVisibility(0);
        mVar.qoe.setText(Util.getSizeKB((long) cyt()));
        ImageView imageView = mVar.puw;
        if (this.qnR == null) {
            this.qnR = c.akB(getFileExt());
        }
        imageView.setBackgroundColor(Color.parseColor(this.qnR));
        AppMethodBeat.o(162327);
    }

    public f(g gVar, ca caVar, String str) {
        super(gVar, caVar);
        this.qnQ = str;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public void a(View view, a aVar) {
        AppMethodBeat.i(123272);
        if (!cys().Cb(this.qnv.field_msgId) && !isInvalid()) {
            if (isEnable()) {
                c.g(getContext(), this.qnv.field_msgId);
                AppMethodBeat.o(123272);
                return;
            }
            c.V(getContext(), cys().mMaxCount);
        }
        AppMethodBeat.o(123272);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public int getType() {
        return 1;
    }
}
