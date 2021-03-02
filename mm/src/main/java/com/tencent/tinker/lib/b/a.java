package com.tencent.tinker.lib.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchForeService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    ServiceConnection Sjz;
    protected final Context context;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.tinker.lib.b.b
    public final int bqH(String str) {
        int ij = ij(str, SharePatchFileUtil.getMD5(new File(str)));
        if (ij == 0) {
            try {
                this.Sjz = new ServiceConnection() {
                    /* class com.tencent.tinker.lib.b.a.AnonymousClass1 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        if (a.this.context != null && a.this.Sjz != null) {
                            try {
                                a.this.context.unbindService(a.this.Sjz);
                            } catch (Throwable th) {
                            }
                        }
                    }

                    public final void onBindingDied(ComponentName componentName) {
                    }
                };
                this.context.bindService(new Intent(this.context, TinkerPatchForeService.class), this.Sjz, 1);
            } catch (Throwable th) {
            }
            TinkerPatchService.cX(this.context, str);
        } else {
            com.tencent.tinker.lib.e.a.lk(this.context).SjU.d(new File(str), ij);
        }
        return ij;
    }

    /* access modifiers changed from: protected */
    public int ij(String str, String str2) {
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(this.context);
        if (!ShareTinkerInternals.isTinkerEnabled(lk.tinkerFlags) || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(this.context)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2) || !SharePatchFileUtil.isLegalFile(new File(str))) {
            return -2;
        }
        if (lk.SjY) {
            return -4;
        }
        if (b.lm(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.isVmJit()) {
            return -5;
        }
        d dVar = lk.SjZ;
        if (!(lk.FgY && dVar != null && dVar.useInterpretMode)) {
            if (lk.Ska && dVar != null && str2.equals(dVar.Ske)) {
                return -6;
            }
            String absolutePath = lk.SjS.getAbsolutePath();
            try {
                SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(SharePatchFileUtil.getPatchInfoFile(absolutePath), SharePatchFileUtil.getPatchInfoLockFile(absolutePath));
                if (readAndCheckPropertyWithLock != null && !ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) && !readAndCheckPropertyWithLock.isRemoveNewVersion && str2.equals(readAndCheckPropertyWithLock.newVersion)) {
                    return -6;
                }
            } catch (Throwable th) {
            }
        }
        if (!c.lp(this.context).bqK(str2)) {
            return -7;
        }
        return 0;
    }
}
