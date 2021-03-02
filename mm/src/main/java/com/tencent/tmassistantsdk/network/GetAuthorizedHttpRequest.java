package com.tencent.tmassistantsdk.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAuthorizedHttpRequest extends GetHttpRequest {
    protected static final String TAG = "GetAuthorizedHttpRequest";
    protected IGetAuthorizedHttpRequestListenner mGetAuthorizedListener = null;

    public void setListenner(IGetAuthorizedHttpRequestListenner iGetAuthorizedHttpRequestListenner) {
        this.mGetAuthorizedListener = iGetAuthorizedHttpRequestListenner;
    }

    public void sendRequest(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(102077);
        if (tMOpenSDKAuthorizedInfo != null) {
            super.sendData(authorizedInfoToString(tMOpenSDKAuthorizedInfo));
        }
        AppMethodBeat.o(102077);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.network.GetHttpRequest
    public void onFinished(JSONObject jSONObject, int i2) {
        AppMethodBeat.i(102078);
        if (this.mGetAuthorizedListener == null) {
            TMLog.i(TAG, "mGetAuthorizedListener is null !");
            AppMethodBeat.o(102078);
            return;
        }
        if (i2 != 0 || jSONObject == null) {
            this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, i2);
        } else {
            try {
                AuthorizedResult jsonObjectToRespData = jsonObjectToRespData(jSONObject);
                if (jsonObjectToRespData != null) {
                    this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(jsonObjectToRespData, 0);
                    AppMethodBeat.o(102078);
                    return;
                }
            } catch (JSONException e2) {
                this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, 704);
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(102078);
                return;
            }
        }
        AppMethodBeat.o(102078);
    }

    private String authorizedInfoToString(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(102079);
        String str = ((((((((((("" + "?appId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.appId)) + "&userId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.userId)) + "&userIdType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.userIdType)) + "&identityInfo=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.identityInfo)) + "&identityType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.identityType)) + "&gamePackageName=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gamePackageName)) + "&gameVersionCode=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gameVersionCode)) + "&gameChannelId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gameChannelId)) + "&actionFlag=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.actionFlag)) + "&verifyType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.verifyType)) + "&via=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.via)) + "&actionType=" + tMOpenSDKAuthorizedInfo.actionType;
        AppMethodBeat.o(102079);
        return str;
    }

    private AuthorizedResult jsonObjectToRespData(JSONObject jSONObject) {
        AppMethodBeat.i(102080);
        AuthorizedResult authorizedResult = new AuthorizedResult();
        authorizedResult.hasAuthoried = jSONObject.getInt("hasAuthoried");
        authorizedResult.errorCode = jSONObject.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
        authorizedResult.downloadUrl = jSONObject.getString("downloadUrl");
        authorizedResult.versionCode = jSONObject.getInt(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE);
        JSONObject jSONObject2 = jSONObject.getJSONObject("tipsInfo");
        TipsInfo tipsInfo = null;
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            TipsInfo tipsInfo2 = new TipsInfo();
            tipsInfo2.title = jSONObject2.getString("title");
            tipsInfo2.content = jSONObject2.getString("content");
            JSONArray jSONArray = jSONObject2.getJSONArray("actionButton");
            ArrayList<ActionButton> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    ActionButton actionButton = new ActionButton();
                    actionButton.textInstalled = jSONArray.getJSONObject(i2).getString("textInstalled");
                    actionButton.textUninstalled = jSONArray.getJSONObject(i2).getString("textUninstalled");
                    actionButton.jumpType = jSONArray.getJSONObject(i2).getInt("jumpType");
                    actionButton.jumpUrl = jSONArray.getJSONObject(i2).getString("jumpUrl");
                    arrayList.add(actionButton);
                }
            }
            tipsInfo2.actionButton = arrayList;
            tipsInfo = tipsInfo2;
        }
        authorizedResult.tipsInfo = tipsInfo;
        TMLog.i(TAG, "dataInfo :" + authorizedResult.toString());
        AppMethodBeat.o(102080);
        return authorizedResult;
    }
}
