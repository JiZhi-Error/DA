package com.tencent.thumbplayer.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public final class d implements ITPAssetResourceLoadingRequest {
    private int RZY = 0;
    TPAssetResourceLoadingContentInformationRequest Saa;
    c San;
    private boolean Sao = false;
    private boolean rEt = false;

    public d(long j2, long j3, int i2, boolean z) {
        AppMethodBeat.i(189266);
        this.RZY = i2;
        this.San = new c(j2, j3, z);
        this.San.RZY = i2;
        AppMethodBeat.o(189266);
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public final TPAssetResourceLoadingContentInformationRequest getContentInformation() {
        return this.Saa;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public final synchronized boolean isCancelled() {
        return this.Sao;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public final synchronized boolean isFinished() {
        return this.rEt;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public final synchronized void finishLoading() {
        this.rEt = true;
    }

    public final synchronized void hnD() {
        this.Sao = true;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public final /* bridge */ /* synthetic */ ITPAssetResourceLoadingDataRequest getLoadingDataRequest() {
        return this.San;
    }
}
