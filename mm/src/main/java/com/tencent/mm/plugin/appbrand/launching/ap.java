package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ee;
import com.tencent.mm.plugin.appbrand.ac.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap extends ee {
    static final IAutoDBItem.MAutoDBInfo kLR;
    public transient boolean mWd;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }

    public final void b(che che) {
        this.field_launchAction = che.Mmz;
        this.field_jsapiInfo = che.MmA;
        this.field_hostInfo = che.MmB;
        this.field_actionsheetInfo = che.MmD;
        this.field_operationInfo = che.MmE;
    }

    public final void b(AppBrandSysConfigWC appBrandSysConfigWC) {
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(47282);
        appBrandSysConfigWC.leH = this.field_actionsheetInfo != null && this.field_actionsheetInfo.KEI;
        if (this.field_actionsheetInfo == null || !this.field_actionsheetInfo.KEJ) {
            z = false;
        } else {
            z = true;
        }
        appBrandSysConfigWC.leI = z;
        if (this.field_actionsheetInfo == null || !this.field_actionsheetInfo.KEL) {
            z2 = false;
        } else {
            z2 = true;
        }
        appBrandSysConfigWC.leJ = z2;
        if (this.field_actionsheetInfo != null) {
            i2 = this.field_actionsheetInfo.KEK;
        } else {
            i2 = 0;
        }
        appBrandSysConfigWC.leK = i2;
        if (this.field_actionsheetInfo == null || this.field_actionsheetInfo.KEM == null) {
            Log.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, control bytes is null");
            appBrandSysConfigWC.leL = null;
        } else {
            appBrandSysConfigWC.leL = this.field_actionsheetInfo.KEM.zy;
            Log.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
        }
        appBrandSysConfigWC.cyG = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
        if (this.field_operationInfo != null && !Util.isNullOrNil(this.field_operationInfo.MBR)) {
            appBrandSysConfigWC.cyI = this.field_operationInfo.MBR;
            try {
                JSONObject jSONObject = new JSONObject(appBrandSysConfigWC.cyI).getJSONObject(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
                if (jSONObject.getInt("banLocationIfEmptyDesc") == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                appBrandSysConfigWC.leA = z3;
                if (jSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
                    z4 = false;
                }
                appBrandSysConfigWC.leB = z4;
            } catch (JSONException e2) {
                appBrandSysConfigWC.leA = false;
                appBrandSysConfigWC.leB = false;
            }
            u.a(appBrandSysConfigWC, appBrandSysConfigWC.cyI);
        }
        AppMethodBeat.o(47282);
    }

    public final boolean acg(String str) {
        AppMethodBeat.i(47283);
        if (this.field_operationInfo != null && !Util.isNullOrNil(this.field_operationInfo.MBR)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_operationInfo.MBR);
                if (!jSONObject.has("jumpWeAppFromLongPressCodeBanInfo")) {
                    AppMethodBeat.o(47283);
                    return false;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("jumpWeAppFromLongPressCodeBanInfo");
                if (!jSONObject2.has(str)) {
                    AppMethodBeat.o(47283);
                    return false;
                } else if (jSONObject2.optInt(str, 0) == 1) {
                    AppMethodBeat.o(47283);
                    return true;
                } else {
                    AppMethodBeat.o(47283);
                    return false;
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", e2);
            }
        }
        AppMethodBeat.o(47283);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(47284);
        if (obj instanceof ap) {
            ap apVar = (ap) obj;
            if (!this.field_appId.equals(apVar.field_appId) || this.field_launchAction == null || !j.a(this.field_launchAction, apVar.field_launchAction) || this.field_jsapiInfo == null || !j.a(this.field_jsapiInfo, apVar.field_jsapiInfo) || this.field_hostInfo == null || !j.a(this.field_hostInfo, apVar.field_hostInfo) || this.field_actionsheetInfo == null || !j.a(this.field_actionsheetInfo, apVar.field_actionsheetInfo) || this.field_operationInfo == null || !j.a(this.field_operationInfo, apVar.field_operationInfo)) {
                AppMethodBeat.o(47284);
                return false;
            }
            AppMethodBeat.o(47284);
            return true;
        }
        AppMethodBeat.o(47284);
        return false;
    }

    static {
        AppMethodBeat.i(47285);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appIdHash";
        mAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
        sb.append(" appIdHash INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appIdHash";
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "launchAction";
        mAutoDBInfo.colsMap.put("launchAction", "BLOB");
        sb.append(" launchAction BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "jsapiInfo";
        mAutoDBInfo.colsMap.put("jsapiInfo", "BLOB");
        sb.append(" jsapiInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "hostInfo";
        mAutoDBInfo.colsMap.put("hostInfo", "BLOB");
        sb.append(" hostInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "actionsheetInfo";
        mAutoDBInfo.colsMap.put("actionsheetInfo", "BLOB");
        sb.append(" actionsheetInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "operationInfo";
        mAutoDBInfo.colsMap.put("operationInfo", "BLOB");
        sb.append(" operationInfo BLOB");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kLR = mAutoDBInfo;
        AppMethodBeat.o(47285);
    }
}
