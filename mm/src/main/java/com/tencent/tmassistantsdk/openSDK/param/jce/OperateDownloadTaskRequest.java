package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class OperateDownloadTaskRequest extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public String actionFlag = "";
    public IPCBaseParam baseParam = null;
    public String opList = "";
    public int requestType = 0;
    public String verifyType = "";

    public OperateDownloadTaskRequest() {
    }

    public OperateDownloadTaskRequest(int i2, IPCBaseParam iPCBaseParam, String str, String str2, String str3) {
        this.requestType = i2;
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102248);
        jceOutputStream.write(this.requestType, 0);
        jceOutputStream.write((JceStruct) this.baseParam, 1);
        if (this.opList != null) {
            jceOutputStream.write(this.opList, 2);
        }
        if (this.actionFlag != null) {
            jceOutputStream.write(this.actionFlag, 3);
        }
        if (this.verifyType != null) {
            jceOutputStream.write(this.verifyType, 4);
        }
        AppMethodBeat.o(102248);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102249);
        this.requestType = jceInputStream.read(this.requestType, 0, true);
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_baseParam, 1, true);
        this.opList = jceInputStream.readString(2, false);
        this.actionFlag = jceInputStream.readString(3, false);
        this.verifyType = jceInputStream.readString(4, false);
        AppMethodBeat.o(102249);
    }
}
