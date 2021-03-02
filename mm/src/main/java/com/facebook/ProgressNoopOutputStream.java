package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    ProgressNoopOutputStream(Handler handler) {
        AppMethodBeat.i(17268);
        this.callbackHandler = handler;
        AppMethodBeat.o(17268);
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        AppMethodBeat.i(17269);
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
        AppMethodBeat.o(17269);
    }

    /* access modifiers changed from: package-private */
    public int getMaxProgress() {
        return this.batchMax;
    }

    /* access modifiers changed from: package-private */
    public Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    /* access modifiers changed from: package-private */
    public void addProgress(long j2) {
        AppMethodBeat.i(17270);
        if (this.currentRequestProgress == null) {
            this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.progressMap.put(this.currentRequest, this.currentRequestProgress);
        }
        this.currentRequestProgress.addToMax(j2);
        this.batchMax = (int) (((long) this.batchMax) + j2);
        AppMethodBeat.o(17270);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        AppMethodBeat.i(17271);
        addProgress((long) bArr.length);
        AppMethodBeat.o(17271);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(17272);
        addProgress((long) i3);
        AppMethodBeat.o(17272);
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        AppMethodBeat.i(17273);
        addProgress(1);
        AppMethodBeat.o(17273);
    }
}
