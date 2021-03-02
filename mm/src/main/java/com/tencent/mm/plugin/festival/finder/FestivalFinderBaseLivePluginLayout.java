package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.core.f;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-festival_release"})
public abstract class FestivalFinderBaseLivePluginLayout extends FinderBaseLivePluginLayout {
    @Deprecated
    public static final a UrX = new a((byte) 0);
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePluginLayout$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalFinderBaseLivePluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public s getFinderLiveAssistant() {
        at atVar = at.Uuv;
        return at.getFinderLiveAssistant();
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public void statusChange(b.c cVar, Bundle bundle) {
        p.h(cVar, "status");
        d.h(new b(this, cVar, bundle));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FestivalFinderBaseLivePluginLayout UrY;
        final /* synthetic */ b.c uxB;
        final /* synthetic */ Bundle uxC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FestivalFinderBaseLivePluginLayout festivalFinderBaseLivePluginLayout, b.c cVar, Bundle bundle) {
            super(0);
            this.UrY = festivalFinderBaseLivePluginLayout;
            this.uxB = cVar;
            this.uxC = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            String str;
            awe awe;
            awe awe2;
            AppMethodBeat.i(262177);
            a unused = FestivalFinderBaseLivePluginLayout.UrX;
            Log.d("FestivalFinderBaseLivePluginLayout", "this:" + this.UrY + " isDestroy:" + this.UrY.isDestroyed() + " lastUIState:" + this.UrY.getLastUIState());
            if (!this.UrY.isDestroyed()) {
                for (com.tencent.mm.live.c.a aVar : this.UrY.getPluginList()) {
                    aVar.statusChange(this.uxB, this.uxC);
                }
                at atVar = at.Uuv;
                at.a(this.uxB, this.uxC, this.UrY.getLiveData().liveInfo.liveId);
                if (this.UrY.getLastLiveState() == this.UrY.getLiveData().uEg && this.UrY.getLastUIState() == this.UrY.getLiveData().uEf) {
                    z = false;
                } else {
                    this.UrY.setLastUIState(this.UrY.getLiveData().uEf);
                    this.UrY.setLastLiveState(this.UrY.getLiveData().uEg);
                    this.UrY.applyState(this.UrY.getLiveData().uEg, this.UrY.getLiveData().uEf, this.uxC);
                    z = true;
                }
                if (z) {
                    a unused2 = FestivalFinderBaseLivePluginLayout.UrX;
                    StringBuilder append = new StringBuilder("statusChange lastLiveState:").append(this.UrY.getLastLiveState()).append(",lastUIState:").append(this.UrY.getLastUIState()).append(",set status:").append(this.uxB.name()).append(",liveId:");
                    g liveData = this.UrY.getLiveData();
                    StringBuilder append2 = append.append(((liveData == null || (awe2 = liveData.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).longValue()).append(",service liveId:");
                    o oVar = o.ujN;
                    g dfZ = o.dfZ();
                    Log.i("FestivalFinderBaseLivePluginLayout", append2.append((dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
                }
                if (this.uxB == b.c.hMp) {
                    af afVar = af.waa;
                    StringBuilder sb = new StringBuilder();
                    af afVar2 = af.waa;
                    String sb2 = sb.append(af.dEm()).append(this.UrY.getData().uCr.getLiveId()).toString();
                    ad.a aVar2 = ad.vZu;
                    af.a(afVar, sb2, ad.vYS.name, null, false, true, 12);
                }
                if (this.uxB == b.c.hNp) {
                    g liveData2 = this.UrY.getLiveData();
                    Bundle bundle = this.uxC;
                    if (bundle != null) {
                        e.j jVar = e.j.hyq;
                        str = bundle.getString(e.j.aDj());
                    } else {
                        str = null;
                    }
                    liveData2.uEs = str;
                    a unused3 = FestivalFinderBaseLivePluginLayout.UrX;
                    Log.i("FestivalFinderBaseLivePluginLayout", "printStatistics:" + this.UrY.getLiveData().uEs);
                    f.hys.w(this.uxC);
                    this.UrY.showStatistics(f.hys.aDl());
                }
                if (this.uxB == b.c.hNJ) {
                    Bundle bundle2 = this.uxC;
                    String string = bundle2 != null ? bundle2.getString("PARAM_FINDER_LIVE_ALERT_DIALOG_TITLE", "") : null;
                    Bundle bundle3 = this.uxC;
                    String string2 = bundle3 != null ? bundle3.getString("PARAM_FINDER_LIVE_ALERT_DIALOG_CONTENT", "") : null;
                    Context context = this.UrY.getContext();
                    if (!(context instanceof MMActivity)) {
                        context = null;
                    }
                    MMActivity mMActivity = (MMActivity) context;
                    if (mMActivity != null) {
                        this.UrY.showAlertDialog(mMActivity, string, string2, "");
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262177);
            return xVar;
        }
    }
}
