package com.tencent.map.tools.net.http;

import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HttpCanceler {
    private Callback<Boolean> mCancelCallback;
    private boolean mCanceled;
    private NetAdapter mConnection;

    public void setHttpAccessRequest(NetAdapter netAdapter, Callback<Boolean> callback) {
        this.mConnection = netAdapter;
        this.mCancelCallback = callback;
    }

    public void cancel() {
        AppMethodBeat.i(172938);
        if (this.mConnection != null && this.mConnection.cancel()) {
            this.mCanceled = true;
        }
        if (this.mCancelCallback != null) {
            this.mCancelCallback.callback(Boolean.valueOf(this.mCanceled));
        }
        AppMethodBeat.o(172938);
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }
}
