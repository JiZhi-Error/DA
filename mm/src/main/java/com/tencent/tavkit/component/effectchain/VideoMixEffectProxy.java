package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoMixEffectProxy implements TAVVideoMixEffect {
    private boolean autoCheckEffectRemove = true;
    private CopyOnWriteArrayList<TAVVideoMixEffect> effects = new CopyOnWriteArrayList<>();
    private final List<FilterProxy> filterProxies = new ArrayList();

    public VideoMixEffectProxy() {
        AppMethodBeat.i(197460);
        AppMethodBeat.o(197460);
    }

    public List<TAVVideoMixEffect> getEffects() {
        return this.effects;
    }

    public void setEffects(CopyOnWriteArrayList<TAVVideoMixEffect> copyOnWriteArrayList) {
        this.effects = copyOnWriteArrayList;
    }

    public boolean isAutoCheckEffectRemove() {
        return this.autoCheckEffectRemove;
    }

    public void setAutoCheckEffectRemove(boolean z) {
        this.autoCheckEffectRemove = z;
    }

    public void notifyOnEffectRemove() {
        AppMethodBeat.i(197461);
        for (FilterProxy filterProxy : this.filterProxies) {
            FilterProxy.access$000(filterProxy);
        }
        AppMethodBeat.o(197461);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public String effectId() {
        AppMethodBeat.i(197462);
        String str = "VideoMixEffectProxy" + Integer.toHexString(hashCode());
        AppMethodBeat.o(197462);
        return str;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public TAVVideoMixEffect.Filter createFilter() {
        AppMethodBeat.i(197463);
        FilterProxy filterProxy = new FilterProxy();
        this.filterProxies.add(filterProxy);
        AppMethodBeat.o(197463);
        return filterProxy;
    }

    static class FilterProxy implements TAVVideoMixEffect.Filter, IReportable {
        private final HashMap<String, TAVVideoMixEffect.Filter> filterMap;
        private boolean onEffectRemove;
        private final FilterChainReportSession reportSession;

        private FilterProxy() {
            AppMethodBeat.i(197453);
            this.filterMap = new HashMap<>();
            this.reportSession = new FilterChainReportSession();
            AppMethodBeat.o(197453);
        }

        static /* synthetic */ void access$000(FilterProxy filterProxy) {
            AppMethodBeat.i(197459);
            filterProxy.notifyOnEffectRemove();
            AppMethodBeat.o(197459);
        }

        private void notifyOnEffectRemove() {
            this.onEffectRemove = true;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            AppMethodBeat.i(197454);
            String appendReportKey = MemoryReportHelper.appendReportKey(this.filterMap.values());
            AppMethodBeat.o(197454);
            return appendReportKey;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
            AppMethodBeat.i(197455);
            if (!(tAVVideoMixEffect instanceof VideoMixEffectProxy)) {
                AppMethodBeat.o(197455);
                return null;
            }
            List<TAVVideoMixEffect> effects = ((VideoMixEffectProxy) tAVVideoMixEffect).getEffects();
            if (((VideoMixEffectProxy) tAVVideoMixEffect).isAutoCheckEffectRemove() || this.onEffectRemove) {
                checkRuntimeRelease(effects);
            }
            CIImage cIImage = null;
            for (TAVVideoMixEffect tAVVideoMixEffect2 : effects) {
                TAVVideoMixEffect.Filter cacheFilter = getCacheFilter(tAVVideoMixEffect2);
                if (cacheFilter != null) {
                    long nanoTime = System.nanoTime();
                    String reportKey = cacheFilter instanceof IReportable ? ((IReportable) cacheFilter).getReportKey() : null;
                    CIImage apply = cacheFilter.apply(tAVVideoMixEffect2, imageCollection, renderInfo);
                    if (!TextUtils.isEmpty(reportKey)) {
                        this.reportSession.tick(reportKey, System.nanoTime() - nanoTime);
                    }
                    cIImage = apply;
                }
            }
            AppMethodBeat.o(197455);
            return cIImage;
        }

        private void checkRuntimeRelease(List<TAVVideoMixEffect> list) {
            AppMethodBeat.i(197456);
            if (!this.onEffectRemove) {
                AppMethodBeat.o(197456);
                return;
            }
            this.onEffectRemove = false;
            ArrayList arrayList = new ArrayList();
            for (TAVVideoMixEffect tAVVideoMixEffect : list) {
                if (!TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
                    arrayList.add(tAVVideoMixEffect.effectId());
                }
            }
            Iterator it = new HashSet(this.filterMap.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!arrayList.contains(str)) {
                    this.filterMap.get(str).release();
                    this.filterMap.remove(str);
                }
            }
            AppMethodBeat.o(197456);
        }

        private TAVVideoMixEffect.Filter getCacheFilter(TAVVideoMixEffect tAVVideoMixEffect) {
            TAVVideoMixEffect.Filter createFilter;
            AppMethodBeat.i(197457);
            if (tAVVideoMixEffect == null || TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
                AppMethodBeat.o(197457);
                return null;
            }
            String effectId = tAVVideoMixEffect.effectId();
            if (this.filterMap.containsKey(effectId)) {
                createFilter = this.filterMap.get(effectId);
            } else {
                createFilter = tAVVideoMixEffect.createFilter();
                this.filterMap.put(effectId, createFilter);
            }
            AppMethodBeat.o(197457);
            return createFilter;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        public synchronized void release() {
            AppMethodBeat.i(197458);
            for (TAVVideoMixEffect.Filter filter : this.filterMap.values()) {
                filter.release();
            }
            this.filterMap.clear();
            this.reportSession.commit();
            AppMethodBeat.o(197458);
        }
    }
}
