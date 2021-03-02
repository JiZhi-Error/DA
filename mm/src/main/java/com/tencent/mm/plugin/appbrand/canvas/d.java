package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Stack;

public final class d implements a {
    public f czm;
    public final ad.b hpn = new ad.b();
    public a kZl;
    public a kZm;
    private Stack<a> kZn;
    private Stack<a> kZo;
    public Paint kZp = new Paint();
    public Paint kZq;
    public e kZr;
    private a kZs;
    boolean kZt = true;

    public d(a aVar) {
        a aVar2;
        AppMethodBeat.i(144848);
        this.kZs = aVar;
        if (this.kZt) {
            aVar2 = i.bzt().bzl();
        } else {
            aVar2 = new a();
        }
        this.kZl = aVar2;
        this.kZm = this.kZt ? e.bzp().bzl() : new a();
        this.kZl.setStyle(Paint.Style.STROKE);
        this.kZm.setStyle(Paint.Style.FILL);
        this.kZl.setAntiAlias(true);
        this.kZm.setAntiAlias(true);
        this.kZl.setStrokeWidth((float) g.zD(1));
        this.kZm.setStrokeWidth((float) g.zD(1));
        this.kZn = new Stack<>();
        this.kZo = new Stack<>();
        this.kZp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        AppMethodBeat.o(144848);
    }

    public final void reset() {
        AppMethodBeat.i(144849);
        this.kZn.clear();
        this.kZo.clear();
        this.kZl.reset();
        this.kZm.reset();
        this.kZl.setStyle(Paint.Style.STROKE);
        this.kZm.setStyle(Paint.Style.FILL);
        this.kZl.setAntiAlias(true);
        this.kZm.setAntiAlias(true);
        this.kZl.setStrokeWidth((float) g.zD(1));
        this.kZm.setStrokeWidth((float) g.zD(1));
        AppMethodBeat.o(144849);
    }

    public final void save() {
        AppMethodBeat.i(144850);
        a aVar = this.kZl;
        this.kZn.push(this.kZl);
        if (this.kZt) {
            this.kZl = i.bzt().bzl();
            aVar.b(this.kZl);
        } else {
            this.kZl = aVar.bzu();
        }
        if (this.kZl == null) {
            this.kZl = aVar;
        }
        a aVar2 = this.kZm;
        this.kZo.push(this.kZm);
        if (this.kZt) {
            this.kZm = e.bzp().bzl();
        } else {
            this.kZm = aVar2.bzu();
        }
        aVar2.b(this.kZm);
        if (this.kZm == null) {
            this.kZm = aVar2;
        }
        AppMethodBeat.o(144850);
    }

    public final void restore() {
        AppMethodBeat.i(144851);
        if (this.kZn.isEmpty()) {
            AppMethodBeat.o(144851);
            return;
        }
        a aVar = this.kZl;
        a aVar2 = this.kZm;
        this.kZl = this.kZn.pop();
        this.kZm = this.kZo.pop();
        if (this.kZt) {
            if (this.kZl != aVar) {
                i.bzt().a(aVar);
            }
            if (this.kZm != aVar2) {
                e.bzp().a(aVar2);
            }
        }
        AppMethodBeat.o(144851);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.a
    public final void invalidate() {
        AppMethodBeat.i(144852);
        this.kZs.invalidate();
        AppMethodBeat.o(144852);
    }
}
