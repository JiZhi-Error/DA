package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class QueryDownloadTaskRequest extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public IPCBaseParam baseParam = null;

    public QueryDownloadTaskRequest() {
    }

    public QueryDownloadTaskRequest(IPCBaseParam iPCBaseParam) {
        this.baseParam = iPCBaseParam;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102250);
        jceOutputStream.write((JceStruct) this.baseParam, 0);
        AppMethodBeat.o(102250);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102251);
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_baseParam, 0, true);
        AppMethodBeat.o(102251);
    }
}
