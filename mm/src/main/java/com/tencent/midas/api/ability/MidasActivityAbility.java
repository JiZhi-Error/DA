package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility extends MidasBaseAbility {
    private static final String BUNDLE_PREFIX = "__midas_ability_activity__";
    public String action;
    public String area;
    public String partition;
    public String payItem;
    public String platId;
    public String roleId;
    public String roleName;
    public String sceneInfo;
    public AbsShare shareInfo;

    @Override // com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasBaseAbility
    public Bundle toBundle() {
        AppMethodBeat.i(192876);
        Bundle bundle = super.toBundle();
        bundle.putString("__midas_ability_activity__payItem", this.payItem);
        bundle.putString("__midas_ability_activity__area", this.area);
        bundle.putString("__midas_ability_activity__platId", this.platId);
        bundle.putString("__midas_ability_activity__partition", this.partition);
        bundle.putString("__midas_ability_activity__roleId", this.roleId);
        bundle.putString("__midas_ability_activity__roleName", this.roleName);
        bundle.putString("__midas_ability_activity__action", this.action);
        bundle.putString("__midas_ability_activity__sceneInfo", this.sceneInfo);
        if (this.shareInfo != null) {
            bundle.putBundle("__midas_ability_activity__shareInfo", this.shareInfo.toBundle());
        }
        AppMethodBeat.o(192876);
        return bundle;
    }

    @Override // com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasBaseAbility
    public void fromBundle(Bundle bundle) {
        AppMethodBeat.i(192877);
        super.fromBundle(bundle);
        this.payItem = bundle.getString("__midas_ability_activity__payItem");
        this.area = bundle.getString("__midas_ability_activity__area");
        this.platId = bundle.getString("__midas_ability_activity__platId");
        this.partition = bundle.getString("__midas_ability_activity__partition");
        this.roleId = bundle.getString("__midas_ability_activity__roleId");
        this.roleName = bundle.getString("__midas_ability_activity__roleName");
        this.action = bundle.getString("__midas_ability_activity__action");
        this.sceneInfo = bundle.getString("__midas_ability_activity__sceneInfo");
        Bundle bundle2 = bundle.getBundle("__midas_ability_activity__shareInfo");
        if (bundle2 != null) {
            this.shareInfo = AbsShare.createChild(bundle2);
        }
        AppMethodBeat.o(192877);
    }

    @Override // com.tencent.midas.api.ability.MidasBaseAbility
    public String toString() {
        AppMethodBeat.i(192878);
        String str = super.toString() + "|payItem=" + this.payItem + "|area=" + this.area + "|platId=" + this.platId + "|partition=" + this.partition + "|roleId=" + this.roleId + "|roleName=" + this.roleName + "|action=" + this.action + "|sceneInfo=" + this.sceneInfo + "|shareInfo=" + this.shareInfo;
        AppMethodBeat.o(192878);
        return str;
    }

    public static abstract class AbsShare implements IMidasAbility {
        protected static final String TYPE_KEY = "shareType";
        protected static final int TYPE_QQ_MINIPROGRAM = 2;
        protected static final int TYPE_QQ_WEB = 1;
        protected static final int TYPE_WX_MINIPROGRAM = 4;
        protected static final int TYPE_WX_WEB = 3;

        /* access modifiers changed from: package-private */
        public abstract int type();

        @Override // com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("__midas_ability_activity__shareType", type());
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
        }

        public static AbsShare createChild(Bundle bundle) {
            switch (bundle.getInt("__midas_ability_activity__shareType")) {
                case 1:
                    QQWebShare qQWebShare = new QQWebShare();
                    qQWebShare.fromBundle(bundle);
                    return qQWebShare;
                case 2:
                    QQMiniProgramShare qQMiniProgramShare = new QQMiniProgramShare();
                    qQMiniProgramShare.fromBundle(bundle);
                    return qQMiniProgramShare;
                case 3:
                    WXWebShare wXWebShare = new WXWebShare();
                    wXWebShare.fromBundle(bundle);
                    return wXWebShare;
                case 4:
                    WXMiniProgramShare wXMiniProgramShare = new WXMiniProgramShare();
                    wXMiniProgramShare.fromBundle(bundle);
                    return wXMiniProgramShare;
                default:
                    return null;
            }
        }

        public String toString() {
            return "shareType=" + type();
        }
    }

    public static abstract class AbsQQShare extends AbsShare {
        public String arkJson = "";
        public boolean hideQzone = false;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_hideQzone", this.hideQzone);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_arkJson", this.arkJson);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.hideQzone = bundle.getBoolean(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_hideQzone");
            this.arkJson = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_arkJson");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|hideQzone=" + this.hideQzone + "|arkJson=" + this.arkJson;
        }
    }

    public static class QQWebShare extends AbsQQShare {
        public String appName;
        public String imageUrl;
        public String summary;
        public String title;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public Bundle toBundle() {
            AppMethodBeat.i(192882);
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_summary", this.summary);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_appName", this.appName);
            AppMethodBeat.o(192882);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(192883);
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_title");
            this.summary = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_summary");
            this.imageUrl = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_imageUrl");
            this.appName = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_appName");
            AppMethodBeat.o(192883);
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public String toString() {
            AppMethodBeat.i(192884);
            String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|appName=" + this.appName;
            AppMethodBeat.o(192884);
            return str;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 1;
        }
    }

    public static class QQMiniProgramShare extends AbsQQShare {
        public String imageUrl;
        public String miniProgramType;
        public String summary;
        public String title;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public Bundle toBundle() {
            AppMethodBeat.i(192879);
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_summary", this.summary);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType", this.miniProgramType);
            AppMethodBeat.o(192879);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(192880);
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_title");
            this.summary = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_summary");
            this.imageUrl = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_imageUrl");
            this.miniProgramType = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType");
            AppMethodBeat.o(192880);
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
        public String toString() {
            AppMethodBeat.i(192881);
            String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|miniProgramType=" + this.miniProgramType;
            AppMethodBeat.o(192881);
            return str;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 2;
        }
    }

    public static abstract class AbsWXShare extends AbsShare {
        public String description = "";
        public int scene = 0;
        public byte[] thumbData = null;
        public String title = "";
        public String transaction = "";
        public String userOpenId = "";

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_description", this.description);
            bundle.putByteArray(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_thumbData", this.thumbData);
            bundle.putInt(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_scene", this.scene);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_transaction", this.transaction);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_userOpenId", this.userOpenId);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_title");
            this.description = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_description");
            this.thumbData = bundle.getByteArray(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_thumbData");
            this.scene = bundle.getInt(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_scene");
            this.transaction = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_transaction");
            this.userOpenId = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_userOpenId");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|title=" + this.title + "|description=" + this.description + "|thumbData=" + this.thumbData + "|scene=" + this.scene + "|transaction=" + this.transaction + "|userOpenId=" + this.userOpenId;
        }
    }

    public static class WXWebShare extends AbsWXShare {
        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            AppMethodBeat.i(192888);
            Bundle bundle = super.toBundle();
            AppMethodBeat.o(192888);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(192889);
            super.fromBundle(bundle);
            AppMethodBeat.o(192889);
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare
        public String toString() {
            AppMethodBeat.i(192890);
            String absWXShare = super.toString();
            AppMethodBeat.o(192890);
            return absWXShare;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 3;
        }
    }

    public static class WXMiniProgramShare extends AbsWXShare {
        public int miniprogramType;
        public boolean withShareTicket;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            AppMethodBeat.i(192885);
            Bundle bundle = super.toBundle();
            bundle.putBoolean(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket", this.withShareTicket);
            bundle.putInt(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType", this.miniprogramType);
            AppMethodBeat.o(192885);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(192886);
            super.fromBundle(bundle);
            this.withShareTicket = bundle.getBoolean(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket");
            this.miniprogramType = bundle.getInt(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType");
            AppMethodBeat.o(192886);
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare
        public String toString() {
            AppMethodBeat.i(192887);
            String str = super.toString() + "|withShareTicket=" + this.withShareTicket + "|miniprogramType=" + this.miniprogramType;
            AppMethodBeat.o(192887);
            return str;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 4;
        }
    }
}
