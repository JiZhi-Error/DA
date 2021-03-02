package com.tencent.tav.core.compositing;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.ErrorMsg;
import java.util.ArrayList;
import java.util.List;

public class AsynchronousVideoCompositionRequest {
    private final AssetExtension assetExtension;
    private final Object authorComposition;
    private volatile CMSampleBuffer composedVideoFrame = null;
    private CMTime compositionTime;
    private volatile ErrorMsg error;
    private VideoCompositionRenderContext renderContext;
    private SparseArray<CMSampleBuffer> sampleBuffers = new SparseArray<>();
    private List<Integer> sourceTrackIDs = new ArrayList();
    @RequestStatus
    private volatile int status = Integer.MIN_VALUE;
    private IVideoCompositionInstruction videoCompositionInstruction;

    public @interface RequestStatus {
        public static final int Cancel = 1;
        public static final int Error = -1;
        public static final int Success = 0;
        public static final int UnKnow = Integer.MIN_VALUE;
    }

    public AsynchronousVideoCompositionRequest(Object obj, AssetExtension assetExtension2) {
        AppMethodBeat.i(218013);
        this.authorComposition = obj;
        this.assetExtension = assetExtension2;
        AppMethodBeat.o(218013);
    }

    public CMSampleBuffer sourceFrameByTrackID(int i2) {
        AppMethodBeat.i(218014);
        if (this.sampleBuffers != null) {
            CMSampleBuffer cMSampleBuffer = this.sampleBuffers.get(i2);
            AppMethodBeat.o(218014);
            return cMSampleBuffer;
        }
        AppMethodBeat.o(218014);
        return null;
    }

    public void finishWithComposedVideoFrame(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(218015);
        synchronized (this) {
            try {
                this.composedVideoFrame = cMSampleBuffer;
                this.status = 0;
            } catch (Throwable th) {
                AppMethodBeat.o(218015);
                throw th;
            }
        }
        notifyFinish();
        AppMethodBeat.o(218015);
    }

    public void finishWithError(ErrorMsg errorMsg) {
        AppMethodBeat.i(218016);
        synchronized (this) {
            try {
                this.error = errorMsg;
                this.status = -1;
            } catch (Throwable th) {
                AppMethodBeat.o(218016);
                throw th;
            }
        }
        notifyFinish();
        AppMethodBeat.o(218016);
    }

    public void finishCancelledRequest() {
        AppMethodBeat.i(218017);
        synchronized (this) {
            try {
                this.status = 1;
            } catch (Throwable th) {
                AppMethodBeat.o(218017);
                throw th;
            }
        }
        notifyFinish();
        AppMethodBeat.o(218017);
    }

    private void notifyFinish() {
        AppMethodBeat.i(218018);
        if (this.authorComposition != null) {
            synchronized (this.authorComposition) {
                try {
                    this.authorComposition.notifyAll();
                } finally {
                    AppMethodBeat.o(218018);
                }
            }
            return;
        }
        AppMethodBeat.o(218018);
    }

    public void setRenderContext(VideoCompositionRenderContext videoCompositionRenderContext) {
        this.renderContext = videoCompositionRenderContext;
    }

    public void setCompositionTime(CMTime cMTime) {
        this.compositionTime = cMTime;
    }

    public void setVideoCompositionInstruction(IVideoCompositionInstruction iVideoCompositionInstruction) {
        this.videoCompositionInstruction = iVideoCompositionInstruction;
    }

    public void appendCMSampleBuffer(CMSampleBuffer cMSampleBuffer, int i2) {
        AppMethodBeat.i(218019);
        this.sampleBuffers.put(i2, cMSampleBuffer);
        this.sourceTrackIDs.add(Integer.valueOf(i2));
        AppMethodBeat.o(218019);
    }

    public synchronized CMSampleBuffer getComposedSampleBuffer() {
        return this.composedVideoFrame;
    }

    @RequestStatus
    public synchronized int getStatus() {
        return this.status;
    }

    public VideoCompositionRenderContext getRenderContext() {
        return this.renderContext;
    }

    public CMTime getCompositionTime() {
        return this.compositionTime;
    }

    public List<Integer> getSourceTrackIDs() {
        return this.sourceTrackIDs;
    }

    public IVideoCompositionInstruction getVideoCompositionInstruction() {
        return this.videoCompositionInstruction;
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    public String toString() {
        AppMethodBeat.i(218020);
        String str = "AsynchronousVideoCompositionRequest{renderContext=" + this.renderContext + ", compositionTime=" + this.compositionTime + ", videoCompositionInstruction=" + this.videoCompositionInstruction + ", sampleBuffers=" + this.sampleBuffers + '}';
        AppMethodBeat.o(218020);
        return str;
    }
}
