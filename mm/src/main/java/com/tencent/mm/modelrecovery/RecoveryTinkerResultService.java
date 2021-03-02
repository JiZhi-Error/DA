package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        AppMethodBeat.i(20589);
        super.onCreate();
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
        AppMethodBeat.o(20589);
    }

    public void onDestroy() {
        AppMethodBeat.i(20590);
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(20590);
    }

    @Override // com.tencent.tinker.lib.service.AbstractResultService
    public final void a(a aVar) {
        AppMethodBeat.i(20591);
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", aVar);
        CommonOptions commonOptions = OptionFactory.getCommonOptions(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.uuid = commonOptions.getUUID();
        recoveryHandleItem.clientVersion = commonOptions.getClientVersion();
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.key = WXConstantsRecovery.HandleReportKeys.KeyPatchResultTotalCount;
        if (aVar.isSuccess) {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.key = WXConstantsRecovery.HandleReportKeys.KeyPatchResultSuccessCount;
        } else {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (aVar.f2950e != null) {
                RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", aVar.f2950e.getMessage());
                recoveryHandleItem.key = String.format("%s[%s]", WXConstantsRecovery.HandleReportKeys.KeyPatchResultFailCount, aVar.f2950e.getMessage());
            } else {
                recoveryHandleItem.key = WXConstantsRecovery.HandleReportKeys.KeyPatchResultFailCount;
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.startReportService(this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
        AppMethodBeat.o(20591);
    }
}
