package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l {
    private LinkedHashMap<String, m> Eih;
    private List<z> ElV;
    private int bgColor = 0;
    private Context context;
    private ViewGroup ulG;

    public l(List<z> list, Context context2, ViewGroup viewGroup) {
        this.ElV = list;
        this.context = context2;
        this.ulG = viewGroup;
    }

    public final void gV(List<z> list) {
        AppMethodBeat.i(97394);
        if (list != null && !list.equals(this.ElV)) {
            this.ElV = list;
            layout();
        }
        AppMethodBeat.o(97394);
    }

    public final void layout() {
        AppMethodBeat.i(97395);
        if (this.ElV == null || this.ElV.isEmpty()) {
            AppMethodBeat.o(97395);
            return;
        }
        if (this.Eih == null) {
            this.Eih = new LinkedHashMap<>();
        }
        for (int i2 = 0; i2 < this.ElV.size(); i2++) {
            z zVar = this.ElV.get(i2);
            m mVar = this.Eih.get(zVar.DZi);
            if (mVar != null) {
                mVar.b(zVar);
            } else {
                mVar = ay.a(this.context, zVar, this.ulG, this.bgColor);
                if (mVar != null) {
                    this.Eih.put(zVar.DZi, mVar);
                }
            }
            try {
                if (this.ulG != mVar.getView().getParent()) {
                    if (this.ulG.getChildCount() > i2) {
                        this.ulG.addView(mVar.getView(), i2);
                        mVar.fdp();
                    } else {
                        this.ulG.addView(mVar.getView());
                        mVar.fdp();
                    }
                }
            } catch (Exception e2) {
                Log.e("CompRenderer", "component may have same id %s,%s", zVar.DZi, Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(97395);
    }

    public final Collection<m> fdY() {
        AppMethodBeat.i(97396);
        if (this.Eih == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(97396);
            return list;
        }
        Collection<m> values = this.Eih.values();
        AppMethodBeat.o(97396);
        return values;
    }
}
