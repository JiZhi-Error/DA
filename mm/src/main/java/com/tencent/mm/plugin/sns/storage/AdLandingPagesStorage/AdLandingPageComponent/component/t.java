package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.List;

public final class t extends a {
    private l Dtq;
    private x Eei;
    private CustomScrollView Eej;
    List<m> aQz = new ArrayList();

    public t(Context context, x xVar, ViewGroup viewGroup) {
        super(context, xVar, viewGroup);
        AppMethodBeat.i(96563);
        this.Eei = xVar;
        AppMethodBeat.o(96563);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96564);
        if (this.Dtq == null) {
            this.Dtq = new l(this.Eei.aQz, this.context, this.Eej);
            this.Dtq.layout();
            this.aQz = eWU();
        } else {
            this.Dtq.gV(this.Eei.aQz);
        }
        if (getGravity() == 0) {
            ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
            }
            this.contentView.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(96564);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(96565);
        RoundedCornerFrameLayout roundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
        this.Eej = new CustomScrollView(this.context);
        this.Eej.setOverScrollMode(2);
        this.Eej.setHorizontalScrollBarEnabled(false);
        this.Eej.setVerticalScrollBarEnabled(false);
        this.Eej.setOnScrollChangeListener(new CustomScrollView.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.CustomScrollView.a
            public final void a(ScrollView scrollView, int i2, int i3) {
                AppMethodBeat.i(96562);
                for (m mVar : t.this.aQz) {
                    if (mVar.fdm()) {
                        mVar.eWZ();
                        mVar.eXb();
                    } else {
                        mVar.eXa();
                    }
                }
                AppMethodBeat.o(96562);
            }
        });
        roundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
        roundedCornerFrameLayout.addView(this.Eej);
        roundedCornerFrameLayout.setRadius((float) this.Eei.hH);
        AppMethodBeat.o(96565);
        return roundedCornerFrameLayout;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96566);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eWZ();
            }
        }
        super.eWZ();
        AppMethodBeat.o(96566);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96567);
        for (m mVar : this.aQz) {
            mVar.eXa();
        }
        super.eXa();
        AppMethodBeat.o(96567);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXb() {
        AppMethodBeat.i(96568);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eXb();
            }
        }
        super.eXb();
        AppMethodBeat.o(96568);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final void eXc() {
        AppMethodBeat.i(96569);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eWZ();
                mVar.eXb();
            } else {
                mVar.eXa();
            }
        }
        AppMethodBeat.o(96569);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96570);
        super.eXd();
        for (m mVar : this.aQz) {
            mVar.eXd();
        }
        AppMethodBeat.o(96570);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final List<m> eWU() {
        AppMethodBeat.i(96571);
        ArrayList arrayList = new ArrayList(this.Dtq.fdY());
        AppMethodBeat.o(96571);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void b(z zVar) {
        AppMethodBeat.i(96572);
        if (zVar instanceof x) {
            this.Eei = (x) zVar;
        }
        super.b(zVar);
        AppMethodBeat.o(96572);
    }
}
