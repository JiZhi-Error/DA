package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class BatchDownloadActionResponse extends JceStruct {
    static ArrayList<IPCQueryDownloadInfo> cache_batchData;
    public ArrayList<IPCQueryDownloadInfo> batchData = null;
    public int batchRequestType = 0;

    public BatchDownloadActionResponse() {
    }

    public BatchDownloadActionResponse(int i2, ArrayList<IPCQueryDownloadInfo> arrayList) {
        this.batchRequestType = i2;
        this.batchData = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102226);
        jceOutputStream.write(this.batchRequestType, 0);
        if (this.batchData != null) {
            jceOutputStream.write((Collection) this.batchData, 1);
        }
        AppMethodBeat.o(102226);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102227);
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (cache_batchData == null) {
            cache_batchData = new ArrayList<>();
            cache_batchData.add(new IPCQueryDownloadInfo());
        }
        this.batchData = (ArrayList) jceInputStream.read((Object) cache_batchData, 1, false);
        AppMethodBeat.o(102227);
    }
}
