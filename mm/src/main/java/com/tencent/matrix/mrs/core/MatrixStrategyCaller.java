package com.tencent.matrix.mrs.core;

import android.os.Build;
import com.tencent.matrix.strategy.c;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.o;

public abstract class MatrixStrategyCaller implements MrsCallback {
    private static final int BYTE_DATA_REPORT_NEW_TYPE = 111;
    private static final int BYTE_DATA_REPORT_TYPE = 1;
    private static final int FILE_REPORT_TYPE = 19860829;
    private static final String TAG = "Matrix.MatrixStrategyCaller";

    @Override // com.tencent.matrix.mrs.core.MrsCallback
    public boolean onRequestGetMrsStrategy(byte[] bArr) {
        try {
            if (!g.aAc()) {
                Log.e(TAG, "onRequestGetMrsStrategy, account not ready");
                return false;
            }
            synchronized (this) {
                if (c.isRunning()) {
                    Log.i(TAG, "NetSceneGetMatrixStrategy is already running, just return");
                    return false;
                }
                Log.i(TAG, "onRequestGetMrsStrategy, try to request mrs strategy");
                g.aAg().hqi.a(new c(bArr, new c.a() {
                    /* class com.tencent.matrix.mrs.core.MatrixStrategyCaller.AnonymousClass1 */

                    @Override // com.tencent.matrix.strategy.c.a
                    public void onStrategyResp(int i2, int i3, byte[] bArr) {
                        MrsLogic.onStrategyResp(i2, i3, bArr);
                    }
                }), 0);
                return true;
            }
        } catch (Exception e2) {
            Log.e(TAG, "error: " + e2.getMessage());
            return false;
        }
    }

    @Override // com.tencent.matrix.mrs.core.MrsCallback
    public String getPublicSharePath() {
        try {
            o X = o.X(MMApplicationContext.getContext().getFilesDir());
            if (!X.exists()) {
                X.createNewFile();
            }
            String oVar = X.toString();
            com.tencent.matrix.g.c.i(TAG, "[TEST-PATH] getPublicSharePath, path: %s", oVar);
            return oVar + "/mrs/";
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
            return "";
        }
    }

    @Override // com.tencent.matrix.mrs.core.MrsCallback
    public String getHost(MatrixUploadDataSlice matrixUploadDataSlice) {
        return WeChatHosts.domainString(R.string.e2f);
    }

    @Override // com.tencent.matrix.mrs.core.MrsCallback
    public String getUrl(MatrixUploadDataSlice matrixUploadDataSlice) {
        StringBuilder append = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.KyO)).append("&devicetype=").append("android-" + Build.VERSION.SDK_INT).append("&filelength=").append(matrixUploadDataSlice.getDataSize()).append("&sum=").append(com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(d.KyO), Long.valueOf(matrixUploadDataSlice.getDataSize())).getBytes()).toLowerCase());
        String aTY = (!MMApplicationContext.isMMProcess() || !g.aAc()) ? null : z.aTY();
        if (!(aTY == null || aTY.length() == 0)) {
            append.append("&username=").append(aTY);
        }
        if (1 == matrixUploadDataSlice.getUploadIssue().getDataType()) {
            append.append("&reporttype=19860829&reportvalue=").append(new StringBuffer().append(matrixUploadDataSlice.getUploadIssue().getId() < 0 ? -1 * matrixUploadDataSlice.getUploadIssue().getId() : matrixUploadDataSlice.getUploadIssue().getId()).append('.').append(matrixUploadDataSlice.getPackageIndex()).append('.').append(matrixUploadDataSlice.getTotalPackage()).toString()).append("&rtxname=").append(matrixUploadDataSlice.getUploadIssue().getTag());
        } else {
            append.append("&reporttype=1&NewReportType=111");
        }
        return append.toString();
    }

    @Override // com.tencent.matrix.mrs.core.MrsCallback
    public String getCryptKey(MatrixUploadDataSlice matrixUploadDataSlice) {
        return com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(d.KyO), Long.valueOf(matrixUploadDataSlice.getDataSize())).getBytes()).toLowerCase();
    }
}
