package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoEffectProxy implements TAVVideoEffect {
    private boolean autoCheckEffectRemove = true;
    private CopyOnWriteArrayList<TAVVideoEffect> effects = new CopyOnWriteArrayList<>();
    private final List<FilterProxy> filterProxies = new ArrayList();

    public VideoEffectProxy() {
        AppMethodBeat.i(197449);
        AppMethodBeat.o(197449);
    }

    public synchronized List<TAVVideoEffect> getEffects() {
        return this.effects;
    }

    public synchronized void setEffects(CopyOnWriteArrayList<TAVVideoEffect> copyOnWriteArrayList) {
        this.effects = copyOnWriteArrayList;
    }

    public boolean isAutoCheckEffectRemove() {
        return this.autoCheckEffectRemove;
    }

    public void setAutoCheckEffectRemove(boolean z) {
        this.autoCheckEffectRemove = z;
    }

    public void notifyOnEffectRemove() {
        AppMethodBeat.i(197450);
        for (FilterProxy filterProxy : this.filterProxies) {
            filterProxy.notifyOnEffectRemove();
        }
        AppMethodBeat.o(197450);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public String effectId() {
        AppMethodBeat.i(197451);
        String str = "VideoEffectProxy" + Integer.toHexString(hashCode());
        AppMethodBeat.o(197451);
        return str;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        AppMethodBeat.i(197452);
        FilterProxy filterProxy = new FilterProxy();
        this.filterProxies.add(filterProxy);
        AppMethodBeat.o(197452);
        return filterProxy;
    }

    static class FilterProxy implements TAVVideoEffect.Filter, IReportable {
        private final HashMap<String, TAVVideoEffect.Filter> filterMap;
        private boolean onEffectRemove;
        private final FilterChainReportSession reportSession;

        private FilterProxy() {
            AppMethodBeat.i(197443);
            this.filterMap = new HashMap<>();
            this.reportSession = new FilterChainReportSession();
            AppMethodBeat.o(197443);
        }

        public void notifyOnEffectRemove() {
            this.onEffectRemove = true;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            AppMethodBeat.i(197444);
            String appendReportKey = MemoryReportHelper.appendReportKey(this.filterMap.values());
            AppMethodBeat.o(197444);
            return appendReportKey;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            AppMethodBeat.i(197445);
            if (!(tAVVideoEffect instanceof VideoEffectProxy)) {
                AppMethodBeat.o(197445);
            } else {
                List<TAVVideoEffect> effects = ((VideoEffectProxy) tAVVideoEffect).getEffects();
                if (((VideoEffectProxy) tAVVideoEffect).isAutoCheckEffectRemove() || this.onEffectRemove) {
                    checkRuntimeRelease(effects);
                }
                for (TAVVideoEffect tAVVideoEffect2 : effects) {
                    TAVVideoEffect.Filter cacheFilter = getCacheFilter(tAVVideoEffect2);
                    if (cacheFilter != null) {
                        String str = null;
                        long nanoTime = System.nanoTime();
                        if (cacheFilter instanceof IReportable) {
                            str = ((IReportable) cacheFilter).getReportKey();
                        }
                        cIImage = cacheFilter.apply(tAVVideoEffect2, cIImage, renderInfo);
                        if (!TextUtils.isEmpty(str)) {
                            this.reportSession.tick(str, System.nanoTime() - nanoTime);
                        }
                    }
                }
                AppMethodBeat.o(197445);
            }
            return cIImage;
        }

        private void checkRuntimeRelease(List<TAVVideoEffect> list) {
            AppMethodBeat.i(197446);
            this.onEffectRemove = false;
            ArrayList arrayList = new ArrayList();
            for (TAVVideoEffect tAVVideoEffect : list) {
                if (!TextUtils.isEmpty(tAVVideoEffect.effectId())) {
                    arrayList.add(tAVVideoEffect.effectId());
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
            AppMethodBeat.o(197446);
        }

        private TAVVideoEffect.Filter getCacheFilter(TAVVideoEffect tAVVideoEffect) {
            TAVVideoEffect.Filter createFilter;
            AppMethodBeat.i(197447);
            if (tAVVideoEffect == null || TextUtils.isEmpty(tAVVideoEffect.effectId())) {
                AppMethodBeat.o(197447);
                return null;
            }
            String effectId = tAVVideoEffect.effectId();
            if (this.filterMap.containsKey(effectId)) {
                createFilter = this.filterMap.get(effectId);
            } else {
                createFilter = tAVVideoEffect.createFilter();
                this.filterMap.put(effectId, createFilter);
            }
            AppMethodBeat.o(197447);
            return createFilter;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public synchronized void release() {
            AppMethodBeat.i(197448);
            for (TAVVideoEffect.Filter filter : this.filterMap.values()) {
                filter.release();
            }
            this.filterMap.clear();
            this.reportSession.commit();
            AppMethodBeat.o(197448);
        }
    }
}
