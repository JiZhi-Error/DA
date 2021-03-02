package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.midas.api.request.APMidasBaseRequest;

public abstract class MidasBaseAbility extends APMidasBaseRequest implements IMidasAbility {
    public static final String BUNDLE_PREFIX = "__midas_ability_baseReq__";
    public String configs;
    public String offerId;
    public String openId;
    public String openKey;
    public String others;
    public String pf;
    public String pfKey;
    public String postBack;
    public String sessionId;
    public String sessionType;

    @Override // com.tencent.midas.api.ability.IMidasAbility
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("__midas_ability_baseReq__ClassSimpleName", getClass().getSimpleName());
        bundle.putString("__midas_ability_baseReq__offerId", this.offerId);
        bundle.putString("__midas_ability_baseReq__openId", this.openId);
        bundle.putString("__midas_ability_baseReq__openKey", this.openKey);
        bundle.putString("__midas_ability_baseReq__sessionId", this.sessionId);
        bundle.putString("__midas_ability_baseReq__sessionType", this.sessionType);
        bundle.putString("__midas_ability_baseReq__pf", this.pf);
        bundle.putString("__midas_ability_baseReq__pfKey", this.pfKey);
        bundle.putString("__midas_ability_baseReq__configs", this.configs);
        bundle.putString("__midas_ability_baseReq__postBack", this.postBack);
        bundle.putString("__midas_ability_baseReq__others", this.others);
        return bundle;
    }

    @Override // com.tencent.midas.api.ability.IMidasAbility
    public void fromBundle(Bundle bundle) {
        this.offerId = bundle.getString("__midas_ability_baseReq__offerId");
        this.openId = bundle.getString("__midas_ability_baseReq__openId");
        this.openKey = bundle.getString("__midas_ability_baseReq__openKey");
        this.sessionId = bundle.getString("__midas_ability_baseReq__sessionId");
        this.sessionType = bundle.getString("__midas_ability_baseReq__sessionType");
        this.pf = bundle.getString("__midas_ability_baseReq__pf");
        this.pfKey = bundle.getString("__midas_ability_baseReq__pfKey");
        this.configs = bundle.getString("__midas_ability_baseReq__configs");
        this.postBack = bundle.getString("__midas_ability_baseReq__postBack");
        this.others = bundle.getString("__midas_ability_baseReq__others");
    }

    public String toString() {
        return "offerId=" + this.offerId + "|openKey=******|openKey=" + this.openKey + "|sessionId=" + this.sessionId + "|sessionType=" + this.sessionType + "|pf=" + this.pf + "|pfKey=" + this.pfKey + "|configs=" + this.configs + "|postBack=" + this.postBack + "|others=" + this.others;
    }
}
