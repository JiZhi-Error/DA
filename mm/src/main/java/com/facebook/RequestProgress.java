package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        AppMethodBeat.i(17284);
        this.request = graphRequest;
        this.callbackHandler = handler;
        AppMethodBeat.o(17284);
    }

    /* access modifiers changed from: package-private */
    public long getProgress() {
        return this.progress;
    }

    /* access modifiers changed from: package-private */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    /* access modifiers changed from: package-private */
    public void addProgress(long j2) {
        AppMethodBeat.i(17285);
        this.progress += j2;
        if (this.progress >= this.lastReportedProgress + this.threshold || this.progress >= this.maxProgress) {
            reportProgress();
        }
        AppMethodBeat.o(17285);
    }

    /* access modifiers changed from: package-private */
    public void addToMax(long j2) {
        this.maxProgress += j2;
    }

    /* access modifiers changed from: package-private */
    public void reportProgress() {
        AppMethodBeat.i(17286);
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            if (this.maxProgress > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                final long j2 = this.progress;
                final long j3 = this.maxProgress;
                final GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                if (this.callbackHandler == null) {
                    onProgressCallback.onProgress(j2, j3);
                } else {
                    this.callbackHandler.post(new Runnable() {
                        /* class com.facebook.RequestProgress.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(17283);
                            onProgressCallback.onProgress(j2, j3);
                            AppMethodBeat.o(17283);
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
        AppMethodBeat.o(17286);
    }
}
