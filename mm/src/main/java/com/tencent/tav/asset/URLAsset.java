package com.tencent.tav.asset;

import com.tencent.tav.asset.AsynchronousKeyValueLoading;
import java.net.URL;
import java.util.List;

public final class URLAsset extends Asset {
    public String audiovisualMIMETypes;
    public String audiovisualTypes;

    public URLAsset(String str) {
        super(str);
    }

    public URLAsset(URL url) {
        super(url);
    }

    public final String getAudiovisualTypes() {
        return this.audiovisualTypes;
    }

    public final String getAudiovisualMIMETypes() {
        return this.audiovisualMIMETypes;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public final int statusOfValueForKey(String str) {
        return 1;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public final void loadValuesAsynchronouslyForKeys(List<String> list, AsynchronousKeyValueLoading.loadCallback loadcallback) {
    }
}
