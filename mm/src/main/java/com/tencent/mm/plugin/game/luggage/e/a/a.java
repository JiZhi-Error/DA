package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.ui.base.m;

public abstract class a {
    int id;

    public abstract void a(Context context, g gVar, coq coq);

    public a(int i2) {
        this.id = i2;
    }

    public void a(g gVar, m mVar, coq coq) {
        mVar.d(coq.KWb, coq.Title + "__" + coq.ThumbUrl);
    }
}
