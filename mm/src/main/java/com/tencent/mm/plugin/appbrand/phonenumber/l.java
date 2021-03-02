package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "", "getView", "Landroid/view/View;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "sendSms", "mobile", "", "uninit", "verifyCode", "isCheck", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "luggage-wechat-full-sdk_release"})
public interface l {
    void aes(String str);

    void b(boolean z, String str, String str2);

    View getView();

    void init();

    void uninit();
}
