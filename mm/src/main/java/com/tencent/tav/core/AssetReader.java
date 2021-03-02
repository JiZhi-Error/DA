package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetReaderOutput;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetReader implements AssetReaderOutput.StatusListener {
    private Asset asset;
    private IContextCreate contextCreate;
    private String errMsg = "";
    private HashMap<AssetReaderOutput, AVAssetReaderStatus> outputStatusHashMap = new HashMap<>();
    private List<AssetReaderOutput> outputs = new ArrayList();
    private AVAssetReaderStatus status = AVAssetReaderStatus.AssetReaderStatusUnknown;
    private CMTimeRange timeRange;

    public enum AVAssetReaderStatus {
        AssetReaderStatusUnknown,
        AssetReaderStatusReading,
        AssetReaderStatusCompleted,
        AssetReaderStatusFailed,
        AssetReaderStatusCancelled;

        public static AVAssetReaderStatus valueOf(String str) {
            AppMethodBeat.i(217768);
            AVAssetReaderStatus aVAssetReaderStatus = (AVAssetReaderStatus) Enum.valueOf(AVAssetReaderStatus.class, str);
            AppMethodBeat.o(217768);
            return aVAssetReaderStatus;
        }

        static {
            AppMethodBeat.i(217769);
            AppMethodBeat.o(217769);
        }
    }

    public AssetReader(Asset asset2) {
        AppMethodBeat.i(217770);
        this.asset = asset2;
        AppMethodBeat.o(217770);
    }

    public Asset getAsset() {
        return this.asset;
    }

    public AVAssetReaderStatus getStatus() {
        return this.status;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public List<AssetReaderOutput> getOutputs() {
        return this.outputs;
    }

    public boolean canAddOutput(AssetReaderOutput assetReaderOutput) {
        AppMethodBeat.i(217771);
        if (assetReaderOutput == null || this.outputs.contains(assetReaderOutput)) {
            AppMethodBeat.o(217771);
            return false;
        }
        AppMethodBeat.o(217771);
        return true;
    }

    public void addOutput(AssetReaderOutput assetReaderOutput) {
        AppMethodBeat.i(217772);
        if (canAddOutput(assetReaderOutput)) {
            this.outputs.add(assetReaderOutput);
        }
        AppMethodBeat.o(217772);
    }

    public boolean startReading(IContextCreate iContextCreate) {
        AppMethodBeat.i(217773);
        this.contextCreate = iContextCreate;
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            this.outputStatusHashMap.put(assetReaderOutput, AVAssetReaderStatus.AssetReaderStatusReading);
            if (assetReaderOutput.mediaType == 1) {
                assetReaderOutput.start(iContextCreate, this);
            } else {
                assetReaderOutput.start(null, this);
            }
            assetReaderOutput.addStatusListener(this);
        }
        updateAssetStatus();
        if (this.outputs.size() > 0) {
            AppMethodBeat.o(217773);
            return true;
        }
        AppMethodBeat.o(217773);
        return false;
    }

    private void updateAssetStatus() {
        AppMethodBeat.i(217774);
        boolean z = true;
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            z = (this.outputStatusHashMap.get(assetReaderOutput) == AVAssetReaderStatus.AssetReaderStatusCompleted) & z;
        }
        if (z) {
            this.status = AVAssetReaderStatus.AssetReaderStatusCompleted;
            AppMethodBeat.o(217774);
            return;
        }
        boolean z2 = true;
        for (AssetReaderOutput assetReaderOutput2 : this.outputs) {
            z2 = (this.outputStatusHashMap.get(assetReaderOutput2) == AVAssetReaderStatus.AssetReaderStatusReading || this.outputStatusHashMap.get(assetReaderOutput2) == AVAssetReaderStatus.AssetReaderStatusCompleted) & z2;
        }
        if (z2) {
            this.status = AVAssetReaderStatus.AssetReaderStatusReading;
            AppMethodBeat.o(217774);
            return;
        }
        for (AssetReaderOutput assetReaderOutput3 : this.outputs) {
            if (this.outputStatusHashMap.get(assetReaderOutput3) == AVAssetReaderStatus.AssetReaderStatusFailed) {
                this.status = AVAssetReaderStatus.AssetReaderStatusFailed;
                AppMethodBeat.o(217774);
                return;
            }
        }
        for (AssetReaderOutput assetReaderOutput4 : this.outputs) {
            if (this.outputStatusHashMap.get(assetReaderOutput4) == AVAssetReaderStatus.AssetReaderStatusCancelled) {
                this.status = AVAssetReaderStatus.AssetReaderStatusCancelled;
                AppMethodBeat.o(217774);
                return;
            }
        }
        AppMethodBeat.o(217774);
    }

    public void cancelReading() {
        AppMethodBeat.i(217775);
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            this.outputStatusHashMap.put(assetReaderOutput, AVAssetReaderStatus.AssetReaderStatusCancelled);
            assetReaderOutput.release();
        }
        updateAssetStatus();
        AppMethodBeat.o(217775);
    }

    @Override // com.tencent.tav.core.AssetReaderOutput.StatusListener
    public void statusChanged(AssetReaderOutput assetReaderOutput, AVAssetReaderStatus aVAssetReaderStatus) {
        AppMethodBeat.i(217776);
        this.outputStatusHashMap.put(assetReaderOutput, aVAssetReaderStatus);
        updateAssetStatus();
        AppMethodBeat.o(217776);
    }
}
