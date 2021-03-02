package com.tencent.mm.plugin.appbrand.platform.window;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a implements d {
    protected c kEb;
    private final d.b nDZ = new d.b() {
        /* class com.tencent.mm.plugin.appbrand.platform.window.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.platform.window.d.b
        public final ViewGroup cB(View view) {
            AppMethodBeat.i(219571);
            Activity activity = null;
            if (a.this.kEb instanceof o) {
                activity = AndroidContextUtil.castActivityOrNull(((o) a.this.kEb).mContext);
            }
            if (activity == null) {
                ViewGroup viewGroup = (ViewGroup) view.getRootView();
                AppMethodBeat.o(219571);
                return viewGroup;
            }
            ViewGroup viewGroup2 = (ViewGroup) activity.getWindow().getDecorView();
            AppMethodBeat.o(219571);
            return viewGroup2;
        }
    };
    private d.b nEa;
    private View nEb;
    private WebChromeClient.CustomViewCallback nEc;
    private int nEd;
    private ViewGroup.LayoutParams nEe;
    private ViewGroup nEf;
    private final Set<b> nEg = Collections.newSetFromMap(new ConcurrentHashMap());
    protected View nEh;
    protected boolean nEi = false;

    public a(c cVar, d.b bVar) {
        this.nEa = bVar;
        this.kEb = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public void release() {
        btC();
        this.nEg.clear();
        this.nEc = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final boolean bTK() {
        return this.nEi;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void N(View view, int i2) {
        d.b bVar;
        this.nEi = true;
        d.b bVar2 = this.nEa;
        if (bVar2 == null) {
            bVar = this.nDZ;
        } else {
            bVar = bVar2;
        }
        this.nEh = this.nEb;
        this.nEb = view;
        if (this.nEh == null) {
            if (view.getParent() instanceof ViewGroup) {
                this.nEf = (ViewGroup) view.getParent();
                this.nEd = this.nEf.indexOfChild(view);
                this.nEe = view.getLayoutParams();
                this.nEf.removeView(view);
            } else {
                this.nEd = 0;
                this.nEf = null;
                this.nEe = null;
            }
            ViewGroup cB = bVar.cB(view);
            cB.addView(view, new ViewGroup.LayoutParams(-1, -1));
            cB.bringChildToFront(view);
            view.setX(0.0f);
            view.setY(0.0f);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public boolean btC() {
        if (this.nEb == null) {
            return false;
        }
        if (this.nEc != null) {
            this.nEc.onCustomViewHidden();
        }
        if (this.nEb.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.nEb.getParent()).removeView(this.nEb);
        }
        if (this.nEf != null) {
            this.nEf.addView(this.nEb, this.nEd, this.nEe);
        }
        this.nEb = null;
        this.nEc = null;
        this.nEi = false;
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final void a(WebChromeClient.CustomViewCallback customViewCallback) {
        this.nEc = customViewCallback;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final void a(b bVar) {
        if (bVar != null) {
            this.nEg.add(bVar);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final void b(b bVar) {
        this.nEg.remove(bVar);
    }

    /* access modifiers changed from: protected */
    public final void bTL() {
        for (b bVar : this.nEg) {
            bVar.bDq();
        }
    }

    /* access modifiers changed from: protected */
    public final void bTM() {
        for (b bVar : this.nEg) {
            bVar.Na();
        }
    }
}
