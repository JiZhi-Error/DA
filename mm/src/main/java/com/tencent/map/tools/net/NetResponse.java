package com.tencent.map.tools.net;

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

    public NetResponse(Exception exc) {
        AppMethodBeat.i(172928);
        this.exception = exc;
        if (exc instanceof NetErrorException) {
            this.errorCode = ((NetErrorException) exc).errorCode;
            this.statusCode = ((NetErrorException) exc).statusCode;
        }
        AppMethodBeat.o(172928);
    }

    public boolean available() {
        return (this.errorCode == 0 && this.statusCode == 200) || (this.data != null && this.data.length > 0);
    }

    public void clone(NetResponse netResponse) {
        if (netResponse != null) {
            this.errorCode = netResponse.errorCode;
            this.statusCode = netResponse.statusCode;
            this.data = netResponse.data;
            this.charset = netResponse.charset;
            this.exception = netResponse.exception;
            this.errorData = netResponse.errorData;
        }
    }

    public String toString() {
        AppMethodBeat.i(172929);
        try {
            if (this.data != null) {
                String str = new String(this.data, this.charset);
                AppMethodBeat.o(172929);
                return str;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(172929);
        return "";
    }

    public String toHumanString() {
        AppMethodBeat.i(180922);
        if (this.data != null) {
            String str = "[DATA] " + new String(this.data);
            AppMethodBeat.o(180922);
            return str;
        } else if (this.errorData != null) {
            String str2 = "[ERROR] " + new String(this.errorData);
            AppMethodBeat.o(180922);
            return str2;
        } else {
            AppMethodBeat.o(180922);
            return "";
        }
    }
}
