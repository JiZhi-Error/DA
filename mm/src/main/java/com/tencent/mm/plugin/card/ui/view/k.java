package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.agy;

public final class k extends i {
    private View qjY;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113679);
        if (this.qjY == null) {
            this.qjY = ((ViewStub) findViewById(R.id.am0)).inflate();
        }
        this.qjY.setOnClickListener(this.qjX.cvu());
        agy agy = this.qjX.cvq().csQ().LeS;
        if (!TextUtils.isEmpty(agy.detail)) {
            ((TextView) findViewById(R.id.alu)).setText(agy.detail);
            findViewById(R.id.alv).setVisibility(0);
        } else {
            findViewById(R.id.alv).setVisibility(8);
        }
        ImageView imageView = (ImageView) findViewById(R.id.alz);
        if (agy.LqB == null || agy.LqB.size() <= 0 || TextUtils.isEmpty(agy.LqB.get(0))) {
            imageView.setVisibility(8);
            AppMethodBeat.o(113679);
            return;
        }
        String str = agy.LqB.get(0);
        imageView.setVisibility(0);
        c.a aVar = new c.a();
        aVar.prefixPath = b.aKJ();
        q.bcW();
        aVar.jbw = null;
        aVar.fullPath = m.ajp(str);
        aVar.jbf = true;
        aVar.iaT = false;
        aVar.jbd = true;
        q.bcV().a(str, imageView, aVar.bdv());
        AppMethodBeat.o(113679);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113680);
        if (this.qjY != null) {
            this.qjY.setVisibility(8);
        }
        AppMethodBeat.o(113680);
    }
}
