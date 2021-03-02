package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ai extends aj {
    public int mCount = 0;
    public ImageView ptG;
    public MMNeat7extView ptR;
    public ImageView ptS;
    public LinearLayout ptT;
    public LinearLayout ptU;
    public MMNeat7extView ptV;
    public MMNeat7extView ptW;
    public View ptX;
    public TextView ptY;
    public TextView pxA;
    public boolean pxB = false;
    public int pxC = 0;
    public int pxD = 0;
    public View pxz;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public void a(View view, b bVar) {
        AppMethodBeat.i(6008);
        super.a(view, bVar);
        AppMethodBeat.o(6008);
    }

    public final void cmH() {
        AppMethodBeat.i(6009);
        if (this.puO == null) {
            AppMethodBeat.o(6009);
            return;
        }
        this.ptX = this.puO.findViewById(R.id.i4r);
        this.ptY = (TextView) this.puO.findViewById(R.id.daz);
        AppMethodBeat.o(6009);
    }

    public final int cnf() {
        AppMethodBeat.i(194970);
        int jn = a.jn(this.mContext) - b.prw;
        AppMethodBeat.o(194970);
        return jn;
    }

    public void a(int i2, v vVar, z zVar, int i3, u uVar, int i4) {
        this.mCount = i2;
        this.pxB = false;
        this.pxC = 0;
        this.pxD = i4;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public void a(z zVar, v vVar, View view, TextView textView, int i2) {
        AppMethodBeat.i(6010);
        super.a(zVar, vVar, view, textView, i2);
        this.pxC = i2;
        if (this.ptT == null) {
            AppMethodBeat.o(6010);
        } else if (!this.pxB || (this.pxC <= 0 && a(this.mCount, vVar))) {
            this.ptT.setBackgroundResource(R.drawable.aij);
            AppMethodBeat.o(6010);
        } else {
            this.ptT.setBackgroundResource(b(vVar) ? R.drawable.im : R.drawable.in);
            AppMethodBeat.o(6010);
        }
    }

    public final boolean b(v vVar) {
        AppMethodBeat.i(6011);
        if (this.mCount > 1) {
            AppMethodBeat.o(6011);
            return false;
        } else if (this.mCount != 1 || a(this.mCount, vVar)) {
            AppMethodBeat.o(6011);
            return false;
        } else {
            AppMethodBeat.o(6011);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r11, com.tencent.mm.ag.v r12, com.tencent.mm.storage.z r13) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.ai.a(int, com.tencent.mm.ag.v, com.tencent.mm.storage.z):void");
    }

    public static boolean a(int i2, v vVar) {
        AppMethodBeat.i(6013);
        if (vVar.type == 0 || vVar.type == 1) {
            if (i2 != 1 || !com.tencent.mm.plugin.brandservice.ui.b.a.crf()) {
                AppMethodBeat.o(6013);
                return false;
            }
            AppMethodBeat.o(6013);
            return true;
        } else if (i2 == 1) {
            AppMethodBeat.o(6013);
            return true;
        } else {
            AppMethodBeat.o(6013);
            return false;
        }
    }

    private void a(MMNeat7extView mMNeat7extView, v vVar, boolean z, boolean z2) {
        AppMethodBeat.i(162406);
        mMNeat7extView.setMaxLines(2);
        int i2 = z2 ? 0 : 11;
        if (!Util.isNullOrNil(vVar.title)) {
            com.tencent.mm.plugin.brandservice.b.a.pmT.a(vVar.title, mMNeat7extView, vVar, i2);
        } else {
            com.tencent.mm.plugin.brandservice.b.a.pmT.a(this.mContext.getString(R.string.ai1), mMNeat7extView, vVar, i2);
        }
        if (z) {
            d dVar = d.pMy;
            d.c(mMNeat7extView);
        }
        AppMethodBeat.o(162406);
    }
}
