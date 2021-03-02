package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingHttpRequest extends PostHttpRequest {
    protected static final String TAG = "GetSettingHttpRequest";
    protected IGetSettingHttpListener mListener = null;

    public void setGetSettingHttpListener(IGetSettingHttpListener iGetSettingHttpListener) {
        this.mListener = iGetSettingHttpListener;
    }

    public void sendSettingRequest() {
        AppMethodBeat.i(102082);
        super.sendRequest(new GetSettingsRequest());
        AppMethodBeat.o(102082);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.network.PostHttpRequest
    public void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i2) {
        AppMethodBeat.i(102083);
        if (jceStruct2 == null) {
            TMLog.i(TAG, "response is null!");
            AppMethodBeat.o(102083);
            return;
        }
        if (this.mListener != null && i2 == 0 && (jceStruct2 instanceof GetSettingsResponse)) {
            GetSettingsResponse getSettingsResponse = (GetSettingsResponse) jceStruct2;
            if (getSettingsResponse.ret == 0) {
                this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, true);
                AppMethodBeat.o(102083);
                return;
            }
            this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, false);
        }
        AppMethodBeat.o(102083);
    }
}
