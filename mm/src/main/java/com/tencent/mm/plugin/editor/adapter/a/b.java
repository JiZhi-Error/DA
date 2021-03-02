package com.tencent.mm.plugin.editor.adapter.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b extends d {
    private ImageView qOm;
    private int thumbWidth = 0;

    public b(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181644);
        this.dKU.setVisibility(0);
        this.kmg.setVisibility(8);
        this.qOs.setVisibility(8);
        this.dKU.setTag(this);
        this.dKU.setOnClickListener(this.qOH);
        this.qOm = (ImageView) view.findViewById(R.id.dwa);
        this.qOm.setVisibility(8);
        this.thumbWidth = j.mScreenWidth - ((int) j.be(20.0f));
        AppMethodBeat.o(181644);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.d, com.tencent.mm.plugin.editor.adapter.a.a
    public final void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(181645);
        String str = ((h) aVar).dUs;
        String str2 = ((h) aVar).qPL;
        if (s.YS(str)) {
            str2 = str;
        } else if (!s.YS(str2)) {
            str2 = null;
        }
        Bitmap alI = Util.isNullOrNil(str2) ? null : com.tencent.mm.plugin.editor.b.alI(str2);
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
        if (aVar.qPH) {
            this.qOm.setVisibility(0);
        } else {
            this.qOm.setVisibility(8);
        }
        super.a(aVar, i2, i3);
        AppMethodBeat.o(181645);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return 2;
    }
}
