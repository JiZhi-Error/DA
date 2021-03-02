package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class g extends j {
    private ImageView qOm;
    private int thumbWidth = 0;

    public g(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30860);
        this.dKU.setVisibility(0);
        this.kmg.setVisibility(8);
        this.qOs.setVisibility(8);
        this.dKU.setTag(this);
        this.dKU.setOnClickListener(this.qOH);
        this.qOm = (ImageView) view.findViewById(R.id.dwa);
        this.qOm.setVisibility(8);
        this.thumbWidth = k.mScreenWidth - ((int) k.be(20.0f));
        AppMethodBeat.o(30860);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        String str;
        AppMethodBeat.i(30861);
        String str2 = ((f) cVar).dUs;
        String str3 = ((f) cVar).qPL;
        if (s.YS(str2)) {
            str = str2;
        } else if (s.YS(str3)) {
            str = str3;
        } else {
            str = null;
        }
        if (this.JJu.JIH != 3) {
            str3 = str;
        } else if (!s.YS(str3)) {
            str3 = str;
        }
        Bitmap alI = Util.isNullOrNil(str3) ? null : com.tencent.mm.plugin.wenote.c.c.alI(str3);
        this.dKU.setImageBitmap(null);
        ViewGroup.LayoutParams layoutParams = this.dKU.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.dKU.setLayoutParams(layoutParams);
        if (alI != null) {
            this.dKU.setImageBitmap(alI);
        } else {
            this.dKU.setImageBitmap(null);
            ViewGroup.LayoutParams layoutParams2 = this.dKU.getLayoutParams();
            layoutParams2.width = this.thumbWidth;
            layoutParams2.height = this.thumbWidth;
            this.dKU.setLayoutParams(layoutParams2);
            this.dKU.setBackgroundColor(Color.parseColor("#f6f6f6"));
        }
        if (cVar.qPH) {
            this.qOm.setVisibility(0);
        } else {
            this.qOm.setVisibility(8);
        }
        super.a(cVar, i2, i3);
        AppMethodBeat.o(30861);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 2;
    }
}
