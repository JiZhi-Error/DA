package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class SnsServiceBean {
    private int mChannel;
    private Context mContext;
    private PayInfo mPayInfo;
    private int mPayScene;
    private String mReceiverName = "";
    private String mReqKey;
    private String mTrueName = "";

    SnsServiceBean(Context context, PayInfo payInfo) {
        AppMethodBeat.i(18717);
        this.mPayInfo = payInfo;
        this.mContext = context;
        this.mReqKey = payInfo.dDL;
        this.mChannel = payInfo.channel;
        this.mPayScene = payInfo.dVv;
        if (payInfo.iqp != null) {
            this.mReceiverName = payInfo.iqp.getString("extinfo_key_1");
            this.mTrueName = payInfo.iqp.getString("extinfo_key_2");
        }
        AppMethodBeat.o(18717);
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public PayInfo getPayInfo() {
        return this.mPayInfo;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.mPayInfo = payInfo;
    }

    public String getReqKey() {
        return this.mReqKey;
    }

    public void setReqKey(String str) {
        this.mReqKey = str;
    }

    public int getPayScene() {
        return this.mPayScene;
    }

    public void setPayScene(int i2) {
        this.mPayScene = i2;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public void setChannel(int i2) {
        this.mChannel = i2;
    }

    public String getReceiverName() {
        return this.mReceiverName;
    }

    public void setReceiverName(String str) {
        this.mReceiverName = str;
    }

    public String getTrueName() {
        return this.mTrueName;
    }

    public void setTrueName(String str) {
        this.mTrueName = str;
    }
}
