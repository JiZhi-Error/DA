package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.GetSettingHttpRequest;
import com.tencent.tmassistantsdk.network.IGetSettingHttpListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.protocol.jce.SettingsCfg;
import com.tencent.tmassistantsdk.protocol.jce.StatCfg;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingEngine implements IGetSettingHttpListener {
    protected static final String TAG = "GetSettingEngine";
    protected static GetSettingEngine mInstance = null;
    protected GetSettingHttpRequest httpRequest = null;

    protected GetSettingEngine() {
    }

    public static synchronized GetSettingEngine getInstance() {
        GetSettingEngine getSettingEngine;
        synchronized (GetSettingEngine.class) {
            AppMethodBeat.i(102057);
            if (mInstance == null) {
                mInstance = new GetSettingEngine();
            }
            getSettingEngine = mInstance;
            AppMethodBeat.o(102057);
        }
        return getSettingEngine;
    }

    public synchronized void cancleRequest() {
        AppMethodBeat.i(102058);
        if (this.httpRequest != null) {
            this.httpRequest.cancleRequest();
            this.httpRequest = null;
        }
        AppMethodBeat.o(102058);
    }

    public void sendRequest() {
        AppMethodBeat.i(102059);
        if (this.httpRequest != null) {
            AppMethodBeat.o(102059);
            return;
        }
        this.httpRequest = new GetSettingHttpRequest();
        this.httpRequest.setGetSettingHttpListener(this);
        this.httpRequest.sendSettingRequest();
        AppMethodBeat.o(102059);
    }

    @Override // com.tencent.tmassistantsdk.network.IGetSettingHttpListener
    public void onSettingHttpRequestFinish(GetSettingsRequest getSettingsRequest, GetSettingsResponse getSettingsResponse, boolean z) {
        SettingsCfg settingsCfg;
        AppMethodBeat.i(102060);
        this.httpRequest = null;
        if (z) {
            if (!(getSettingsResponse.settings == null || getSettingsResponse.settings.size() <= 0 || (settingsCfg = getSettingsResponse.settings.get(0)) == null || settingsCfg.cfg == null)) {
                StatCfg statCfg = (StatCfg) ProtocolPackage.bytes2JceObj(settingsCfg.cfg, StatCfg.class);
                if (statCfg != null) {
                    GlobalUtil.getInstance().setNetTypeValue(statCfg.netType);
                } else {
                    TMLog.i(TAG, "response  StatCfg is null !");
                }
            }
            TMLog.i(TAG, "response.settings is null !");
            AppMethodBeat.o(102060);
            return;
        }
        TMLog.i(TAG, "get settings failed!");
        AppMethodBeat.o(102060);
    }
}
