package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

/* access modifiers changed from: package-private */
public class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    private final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j2) {
        super(outputStream);
        AppMethodBeat.i(17275);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j2;
        AppMethodBeat.o(17275);
    }

    private void addProgress(long j2) {
        AppMethodBeat.i(17276);
        if (this.currentRequestProgress != null) {
            this.currentRequestProgress.addProgress(j2);
        }
        this.batchProgress += j2;
        if (this.batchProgress >= this.lastReportedProgress + this.threshold || this.batchProgress >= this.maxProgress) {
            reportBatchProgress();
        }
        AppMethodBeat.o(17276);
    }

    private void reportBatchProgress() {
        AppMethodBeat.i(17277);
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() {
                            /* class com.facebook.ProgressOutputStream.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(17274);
                                onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                                AppMethodBeat.o(17274);
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
        AppMethodBeat.o(17277);
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        AppMethodBeat.i(17278);
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
        AppMethodBeat.o(17278);
    }

    /* access modifiers changed from: package-private */
    public long getBatchProgress() {
        return this.batchProgress;
    }

    /* access modifiers changed from: package-private */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr) {
        AppMethodBeat.i(17279);
        this.out.write(bArr);
        addProgress((long) bArr.length);
        AppMethodBeat.o(17279);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(17280);
        this.out.write(bArr, i2, i3);
        addProgress((long) i3);
        AppMethodBeat.o(17280);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(int i2) {
        AppMethodBeat.i(17281);
        this.out.write(i2);
        addProgress(1);
        AppMethodBeat.o(17281);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(17282);
        super.close();
        for (RequestProgress requestProgress : this.progressMap.values()) {
            requestProgress.reportProgress();
        }
        reportBatchProgress();
        AppMethodBeat.o(17282);
    }
}
