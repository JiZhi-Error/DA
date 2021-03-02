package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;

public class RenderInfo {
    private final CIContext ciContext;
    private final CGSize renderSize;
    private final CMTime time;
    private final List<TAVVideoCompositionTrack> tracks = new ArrayList();

    public RenderInfo(CMTime cMTime, CGSize cGSize, CIContext cIContext) {
        AppMethodBeat.i(197608);
        this.time = cMTime;
        this.renderSize = cGSize;
        this.ciContext = cIContext;
        AppMethodBeat.o(197608);
    }

    public CIContext getCiContext() {
        return this.ciContext;
    }

    public CMTime getTime() {
        return this.time;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public int getRenderWidth() {
        return (int) this.renderSize.width;
    }

    public int getRenderHeight() {
        return (int) this.renderSize.height;
    }

    public void putParam(String str, Object obj) {
        AppMethodBeat.i(197609);
        RenderContextParams params = this.ciContext.getRenderContext().getParams();
        if (params != null) {
            params.putParam(str, obj);
        }
        AppMethodBeat.o(197609);
    }

    public Object getParam(String str) {
        AppMethodBeat.i(197610);
        RenderContextParams params = this.ciContext.getRenderContext().getParams();
        if (params != null) {
            Object param = params.getParam(str);
            AppMethodBeat.o(197610);
            return param;
        }
        AppMethodBeat.o(197610);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void addTrack(TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        AppMethodBeat.i(197611);
        if (!this.tracks.contains(tAVVideoCompositionTrack)) {
            this.tracks.add(tAVVideoCompositionTrack);
        }
        AppMethodBeat.o(197611);
    }

    public List<TAVVideoCompositionTrack> getTracks() {
        return this.tracks;
    }

    public Object getTrackExtraInfo(String str) {
        AppMethodBeat.i(197612);
        for (TAVVideoCompositionTrack tAVVideoCompositionTrack : this.tracks) {
            Object extraTrackInfo = tAVVideoCompositionTrack.getExtraTrackInfo(str);
            if (extraTrackInfo != null) {
                AppMethodBeat.o(197612);
                return extraTrackInfo;
            }
        }
        AppMethodBeat.o(197612);
        return null;
    }
}
