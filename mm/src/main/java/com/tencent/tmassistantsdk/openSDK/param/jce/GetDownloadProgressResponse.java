package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GetDownloadProgressResponse extends JceStruct {
    static IPCBaseParam cache_requestParam;
    public long allTaskTotalLength = 0;
    public long allTaskTotalProgress = 0;
    public long receivedLen = 0;
    public IPCBaseParam requestParam = null;
    public long totalLen = 0;

    public GetDownloadProgressResponse() {
    }

    public GetDownloadProgressResponse(IPCBaseParam iPCBaseParam, long j2, long j3, long j4, long j5) {
        this.requestParam = iPCBaseParam;
        this.receivedLen = j2;
        this.totalLen = j3;
        this.allTaskTotalProgress = j4;
        this.allTaskTotalLength = j5;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102228);
        jceOutputStream.write((JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.receivedLen, 1);
        jceOutputStream.write(this.totalLen, 2);
        jceOutputStream.write(this.allTaskTotalProgress, 3);
        jceOutputStream.write(this.allTaskTotalLength, 4);
        AppMethodBeat.o(102228);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102229);
        if (cache_requestParam == null) {
            cache_requestParam = new IPCBaseParam();
        }
        this.requestParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_requestParam, 0, true);
        this.receivedLen = jceInputStream.read(this.receivedLen, 1, false);
        this.totalLen = jceInputStream.read(this.totalLen, 2, false);
        this.allTaskTotalProgress = jceInputStream.read(this.allTaskTotalProgress, 3, false);
        this.allTaskTotalLength = jceInputStream.read(this.allTaskTotalLength, 4, false);
        AppMethodBeat.o(102229);
    }
}
