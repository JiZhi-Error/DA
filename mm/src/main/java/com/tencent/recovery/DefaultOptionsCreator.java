package com.tencent.recovery;

import android.content.Context;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.WXRecoveryVersion;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class DefaultOptionsCreator implements IOptionsCreator {
    private String clientVersion;

    @Override // com.tencent.recovery.option.IOptionsCreator
    public ProcessOptions createProcessOptions(String str, int i2) {
        return null;
    }

    @Override // com.tencent.recovery.option.IOptionsCreator
    public CommonOptions createCommonOptions(Context context) {
        CommonOptions.Builder builder = new CommonOptions.Builder();
        builder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
        builder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
        builder.setClientVersion(getClientVersion(context));
        builder.setConfigUrl(String.format(WXConstantsRecovery.RecoveryConfigURL, getClientVersion(context)));
        builder.setUUID(WXUtil.getWXUin(context));
        builder.setDebugMode(true);
        builder.setUploadInterval(600000);
        builder.setHandleRetryInterval(600000);
        return builder.build();
    }

    private String getClientVersion(Context context) {
        if (Util.isNullOrNil(this.clientVersion)) {
            File file = new File(WXConstantsRecovery.RecoverySDCardDir, WXConstantsRecovery.VersionInfoFile);
            if (file.exists()) {
                this.clientVersion = FileUtil.readStringFromFile(file);
            }
        }
        if (Util.isNullOrNil(this.clientVersion)) {
            this.clientVersion = WXRecoveryVersion.getBaseClientVersion(context);
        }
        return this.clientVersion;
    }

    public String toString() {
        return String.format("Creator: [ClientVersion=%s] ", getClientVersion(null));
    }
}
