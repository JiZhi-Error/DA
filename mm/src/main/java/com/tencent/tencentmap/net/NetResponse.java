package com.tencent.tencentmap.net;

import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetResponse {
    public String charset = "GBK";
    public byte[] data;
    public int errorCode = -1;
    public byte[] errorData;
    public Exception exception;
    public int statusCode;

    public NetResponse() {
    }

    public NetResponse(com.tencent.map.tools.net.NetResponse netResponse) {
        AppMethodBeat.i(181112);
        if (netResponse != null) {
            this.errorCode = netResponse.errorCode;
            this.statusCode = netResponse.statusCode;
            this.data = netResponse.data;
            this.charset = netResponse.charset;
            this.exception = netResponse.exception;
            this.errorData = netResponse.errorData;
        }
        AppMethodBeat.o(181112);
    }

    public NetResponse(Exception exc) {
        AppMethodBeat.i(181113);
        this.exception = exc;
        if (exc instanceof NetErrorException) {
            this.errorCode = ((NetErrorException) exc).errorCode;
            this.statusCode = ((NetErrorException) exc).statusCode;
        }
        AppMethodBeat.o(181113);
    }

    public boolean available() {
        return (this.errorCode == 0 && this.statusCode == 200) || (this.data != null && this.data.length > 0);
    }

    public String toString() {
        AppMethodBeat.i(181114);
        try {
            if (this.data != null) {
                String str = new String(this.data, this.charset);
                AppMethodBeat.o(181114);
                return str;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(181114);
        return "";
    }
}
