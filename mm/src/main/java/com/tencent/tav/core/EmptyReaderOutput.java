package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public class EmptyReaderOutput extends AssetReaderOutput {
    @Override // com.tencent.tav.core.AssetReaderOutput
    public CMSampleBuffer nextSampleBuffer() {
        AppMethodBeat.i(217873);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1));
        AppMethodBeat.o(217873);
        return cMSampleBuffer;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(IContextCreate iContextCreate, AssetReader assetReader) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void release() {
    }
}
