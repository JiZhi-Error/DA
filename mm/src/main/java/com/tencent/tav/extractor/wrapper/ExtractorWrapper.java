package com.tencent.tav.extractor.wrapper;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.io.File;

public class ExtractorWrapper {
    private long duration;
    private long lastUpdateTime;
    private int preferRotation;
    private String videoPath;
    private CGSize videoSize;

    public ExtractorWrapper(String str) {
        this.videoPath = str;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public long getDuration() {
        return this.duration;
    }

    public CGSize getVideoSize() {
        return this.videoSize;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    /* access modifiers changed from: package-private */
    public void checkAndLoad(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218516);
        if (exit() && needReload()) {
            loadWith(assetExtractor);
        }
        AppMethodBeat.o(218516);
    }

    private void loadWith(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218517);
        this.duration = assetExtractor.getDuration();
        this.videoSize = assetExtractor.getSize();
        this.preferRotation = assetExtractor.getPreferRotation();
        this.lastUpdateTime = new File(this.videoPath).lastModified();
        AppMethodBeat.o(218517);
    }

    private boolean exit() {
        AppMethodBeat.i(218518);
        if (TextUtils.isEmpty(this.videoPath) || !new File(this.videoPath).exists()) {
            AppMethodBeat.o(218518);
            return false;
        }
        AppMethodBeat.o(218518);
        return true;
    }

    private boolean needReload() {
        AppMethodBeat.i(218519);
        if (this.lastUpdateTime != new File(this.videoPath).lastModified()) {
            AppMethodBeat.o(218519);
            return true;
        }
        AppMethodBeat.o(218519);
        return false;
    }
}
