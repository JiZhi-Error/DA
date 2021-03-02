package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public Options() {
            AppMethodBeat.i(190399);
            AppMethodBeat.o(190399);
        }

        public void fromBundle(Bundle bundle) {
            int i2 = -1;
            AppMethodBeat.i(3846);
            this.callbackClassName = a.a(bundle, "_wxapi_payoptions_callback_classname");
            if (bundle != null) {
                try {
                    i2 = bundle.getInt("_wxapi_payoptions_callback_flags", -1);
                } catch (Exception e2) {
                    Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e2.getMessage());
                }
            }
            this.callbackFlags = i2;
            AppMethodBeat.o(3846);
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3845);
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
            AppMethodBeat.o(3845);
        }
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public boolean checkArgs() {
        AppMethodBeat.i(3847);
        String str = this.appId;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid appId");
            AppMethodBeat.o(3847);
            return false;
        }
        String str2 = this.partnerId;
        if (str2 == null || str2.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid partnerId");
            AppMethodBeat.o(3847);
            return false;
        }
        String str3 = this.prepayId;
        if (str3 == null || str3.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid prepayId");
            AppMethodBeat.o(3847);
            return false;
        }
        String str4 = this.nonceStr;
        if (str4 == null || str4.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid nonceStr");
            AppMethodBeat.o(3847);
            return false;
        }
        String str5 = this.timeStamp;
        if (str5 == null || str5.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid timeStamp");
            AppMethodBeat.o(3847);
            return false;
        }
        String str6 = this.packageValue;
        if (str6 == null || str6.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid packageValue");
            AppMethodBeat.o(3847);
            return false;
        }
        String str7 = this.sign;
        if (str7 == null || str7.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid sign");
            AppMethodBeat.o(3847);
            return false;
        }
        String str8 = this.extData;
        if (str8 == null || str8.length() <= 1024) {
            AppMethodBeat.o(3847);
            return true;
        }
        Log.e(TAG, "checkArgs fail, extData length too long");
        AppMethodBeat.o(3847);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void fromBundle(Bundle bundle) {
        AppMethodBeat.i(3849);
        super.fromBundle(bundle);
        this.appId = a.a(bundle, "_wxapi_payreq_appid");
        this.partnerId = a.a(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = a.a(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = a.a(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = a.a(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = a.a(bundle, "_wxapi_payreq_packagevalue");
        this.sign = a.a(bundle, "_wxapi_payreq_sign");
        this.extData = a.a(bundle, "_wxapi_payreq_extdata");
        this.signType = a.a(bundle, "_wxapi_payreq_sign_type");
        Options options2 = new Options();
        this.options = options2;
        options2.fromBundle(bundle);
        AppMethodBeat.o(3849);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(3848);
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        Options options2 = this.options;
        if (options2 != null) {
            options2.toBundle(bundle);
        }
        AppMethodBeat.o(3848);
    }
}
