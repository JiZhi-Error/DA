package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    public com.tencent.mm.plugin.sns.ad.landingpage.component.b.b Dto;
    public List<m> Dtp;
    public l Dtq;
    private int Dtr = 0;

    public b(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
        AppMethodBeat.i(201959);
        this.Dto = bVar;
        this.Dtp = new ArrayList();
        AppMethodBeat.o(201959);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final List<m> eWU() {
        AppMethodBeat.i(201960);
        if (this.Dtq != null) {
            ArrayList arrayList = new ArrayList(this.Dtq.fdY());
            AppMethodBeat.o(201960);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        AppMethodBeat.o(201960);
        return arrayList2;
    }

    public z eWV() {
        AppMethodBeat.i(201961);
        for (z zVar : this.Dto.aQz) {
            if (zVar.DZt) {
                AppMethodBeat.o(201961);
                return zVar;
            }
        }
        if (this.Dto.aQz.size() > 0) {
            z zVar2 = this.Dto.aQz.get(0);
            AppMethodBeat.o(201961);
            return zVar2;
        }
        AppMethodBeat.o(201961);
        return null;
    }

    public final Pair<Integer, Integer> eWW() {
        float f2;
        float f3;
        AppMethodBeat.i(201962);
        z eWV = eWV();
        if (eWV != null) {
            f3 = eWV.DZk;
            f2 = eWV.DZl;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        if (f3 <= 0.0f || f2 <= 0.0f) {
            Log.e("AdLandingEggCardComponent", "default card size is 0, w=" + f3 + ", h=" + f2);
        }
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf((int) f3), Integer.valueOf((int) f2));
        AppMethodBeat.o(201962);
        return pair;
    }

    public static View a(m mVar) {
        AppMethodBeat.i(201963);
        if (mVar.fdk().DZs) {
            View view = mVar.contentView;
            AppMethodBeat.o(201963);
            return view;
        }
        if (mVar instanceof a) {
            for (m mVar2 : ((a) mVar).eWU()) {
                View a2 = a(mVar2);
                if (a2 != null) {
                    AppMethodBeat.o(201963);
                    return a2;
                }
            }
        }
        AppMethodBeat.o(201963);
        return null;
    }

    public static b b(m mVar) {
        AppMethodBeat.i(201964);
        if (mVar instanceof b) {
            b bVar = (b) mVar;
            AppMethodBeat.o(201964);
            return bVar;
        }
        if (mVar instanceof a) {
            for (m mVar2 : ((a) mVar).eWU()) {
                b b2 = b(mVar2);
                if (b2 != null) {
                    AppMethodBeat.o(201964);
                    return b2;
                }
            }
        }
        AppMethodBeat.o(201964);
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(201965);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(201965);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(201966);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.o(201966);
        return frameLayout;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(201967);
        for (m mVar : this.Dtp) {
            if (mVar.fdm()) {
                mVar.eWZ();
            }
        }
        super.eWZ();
        AppMethodBeat.o(201967);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(201968);
        for (m mVar : this.Dtp) {
            mVar.eXa();
        }
        super.eXa();
        AppMethodBeat.o(201968);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXb() {
        AppMethodBeat.i(201969);
        for (m mVar : this.Dtp) {
            if (mVar.fdm()) {
                mVar.eXb();
            }
        }
        super.eXb();
        AppMethodBeat.o(201969);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final void eXc() {
        AppMethodBeat.i(201970);
        for (m mVar : this.Dtp) {
            if (mVar.fdm()) {
                mVar.eWZ();
                mVar.eXb();
            } else {
                mVar.eXa();
            }
        }
        AppMethodBeat.o(201970);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(201971);
        super.eXd();
        for (m mVar : this.Dtp) {
            mVar.eXd();
        }
        AppMethodBeat.o(201971);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void b(z zVar) {
        AppMethodBeat.i(201972);
        if (zVar instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.b) {
            this.Dto = (com.tencent.mm.plugin.sns.ad.landingpage.component.b.b) zVar;
        }
        super.b(zVar);
        AppMethodBeat.o(201972);
    }
}
