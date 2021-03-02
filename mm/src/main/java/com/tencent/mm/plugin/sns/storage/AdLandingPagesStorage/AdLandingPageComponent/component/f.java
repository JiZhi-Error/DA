package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    private l Dtq;
    private y Ecu;
    private List<m> aQz = new ArrayList();

    public f(Context context, y yVar, ViewGroup viewGroup) {
        super(context, yVar, viewGroup);
        AppMethodBeat.i(96438);
        this.Ecu = yVar;
        AppMethodBeat.o(96438);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96439);
        if (this.Dtq == null) {
            this.Dtq = new l(this.Ecu.aQz, this.context, (FrameLayout) this.contentView);
            this.Dtq.layout();
            this.aQz = eWU();
        } else {
            this.Dtq.gV(this.Ecu.aQz);
        }
        ap.a(this.contentView, this.Ecu.DZh);
        AppMethodBeat.o(96439);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96440);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96440);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(96441);
        FrameLayout frameLayout = new FrameLayout(this.context);
        if (this.Ecu.hH > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.backgroundColor);
            gradientDrawable.setCornerRadius((float) this.Ecu.hH);
            frameLayout.setBackground(gradientDrawable);
            frameLayout.setClipToOutline(true);
        }
        AppMethodBeat.o(96441);
        return frameLayout;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96442);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eWZ();
            }
        }
        super.eWZ();
        AppMethodBeat.o(96442);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96443);
        for (m mVar : this.aQz) {
            mVar.eXa();
        }
        super.eXa();
        AppMethodBeat.o(96443);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXb() {
        AppMethodBeat.i(96444);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eXb();
            }
        }
        super.eXb();
        AppMethodBeat.o(96444);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final void eXc() {
        AppMethodBeat.i(96445);
        for (m mVar : this.aQz) {
            if (mVar.fdm()) {
                mVar.eWZ();
                mVar.eXb();
            } else {
                mVar.eXa();
            }
        }
        AppMethodBeat.o(96445);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96446);
        super.eXd();
        for (m mVar : this.aQz) {
            mVar.eXd();
        }
        AppMethodBeat.o(96446);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final List<m> eWU() {
        AppMethodBeat.i(96447);
        ArrayList arrayList = new ArrayList(this.Dtq.fdY());
        AppMethodBeat.o(96447);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void b(z zVar) {
        AppMethodBeat.i(96448);
        if (zVar instanceof y) {
            this.Ecu = (y) zVar;
        }
        super.b(zVar);
        AppMethodBeat.o(96448);
    }
}
