package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.List;

public final class x extends a {
    private l Dtq;
    LinearLayout EeN;

    public x(Context context, aa aaVar, ViewGroup viewGroup) {
        super(context, aaVar, viewGroup);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96616);
        for (m mVar : this.Dtq.fdY()) {
            if (mVar.fdm()) {
                mVar.eWZ();
            }
        }
        super.eWZ();
        AppMethodBeat.o(96616);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXb() {
        AppMethodBeat.i(96617);
        for (m mVar : this.Dtq.fdY()) {
            if (mVar.fdm()) {
                mVar.eXb();
            }
        }
        super.eXb();
        AppMethodBeat.o(96617);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final void eXc() {
        AppMethodBeat.i(96618);
        for (m mVar : this.Dtq.fdY()) {
            if (mVar.fdm()) {
                mVar.eWZ();
                mVar.eXb();
            } else {
                mVar.eXa();
            }
        }
        AppMethodBeat.o(96618);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96619);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96619);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96620);
        for (m mVar : this.Dtq.fdY()) {
            mVar.eXa();
        }
        super.eXa();
        AppMethodBeat.o(96620);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96621);
        super.eXd();
        for (m mVar : this.Dtq.fdY()) {
            mVar.eXd();
        }
        AppMethodBeat.o(96621);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96623);
        this.EeN = (LinearLayout) this.contentView.findViewById(R.id.hvs);
        AppMethodBeat.o(96623);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buj;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final List<m> eWU() {
        AppMethodBeat.i(96624);
        ArrayList arrayList = new ArrayList(this.Dtq.fdY());
        AppMethodBeat.o(96624);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96622);
        if (((aa) this.EcX).DZx == 0) {
            this.EeN.setOrientation(1);
        } else if (((aa) this.EcX).DZx == 1) {
            this.EeN.setOrientation(0);
        }
        if (this.Dtq == null) {
            this.Dtq = new l(((aa) this.EcX).DZw, this.context, this.EeN);
            this.Dtq.layout();
        } else {
            this.Dtq.gV(((aa) this.EcX).DZw);
        }
        ap.a(this.contentView, ((aa) this.EcX).DZh);
        AppMethodBeat.o(96622);
    }
}
