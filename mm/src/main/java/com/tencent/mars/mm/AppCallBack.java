package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic;
import com.tencent.mm.network.af;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppCallBack implements AppLogic.ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    AppLogic.DeviceInfo info = new AppLogic.DeviceInfo(d.DEVICE_NAME, d.ics);

    private static String exception2String(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public AppCallBack(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mars.app.AppLogic.ICallBack
    public String getAppFilePath() {
        if (this.context == null) {
            Assert.assertTrue(false);
            return null;
        }
        try {
            o X = o.X(this.context.getFilesDir());
            if (!X.exists()) {
                X.createNewFile();
            }
            return X.toString();
        } catch (Exception e2) {
            Log.e(TAG, exception2String(e2));
            Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
            return "";
        }
    }

    @Override // com.tencent.mars.app.AppLogic.ICallBack
    public AppLogic.AccountInfo getAccountInfo() {
        AppLogic.AccountInfo accountInfo = new AppLogic.AccountInfo();
        if (!(af.bkl() == null || af.bkl().jEj == null)) {
            try {
                accountInfo.uin = (long) af.bkl().jEj.getUin();
                accountInfo.userName = af.bkl().jEj.aZd();
                if (Util.isNullOrNil(accountInfo.userName)) {
                    accountInfo.userName = af.bkl().jEj.getUsername();
                }
            } catch (Exception e2) {
            }
        }
        return accountInfo;
    }

    @Override // com.tencent.mars.app.AppLogic.ICallBack
    public int getClientVersion() {
        return d.KyO;
    }

    @Override // com.tencent.mars.app.AppLogic.ICallBack
    public AppLogic.DeviceInfo getDeviceType() {
        return this.info;
    }

    @Override // com.tencent.mars.app.AppLogic.ICallBack
    public String getCurLanguage() {
        return LocaleUtil.getApplicationLanguage();
    }
}
