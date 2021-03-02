package com.tencent.matrix.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.g.c;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h;
import com.tencent.matrix.resource.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;
import java.util.Properties;

public final class d implements h.c {
    @Override // com.tencent.matrix.report.h.c
    public final void a(h.d dVar) {
        if (!"memory".equals(dVar.tag)) {
            return;
        }
        if (dVar.cWe != null) {
            String optString = dVar.cWe.optString("resultZipPath");
            if (optString != null && optString.length() != 0) {
                Properties properties = new Properties();
                properties.put("Uin", com.tencent.mm.loader.j.d.icC.aA(WXUtil.LAST_LOGIN_UIN, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                properties.put("ClientVersion", String.valueOf(com.tencent.mm.protocal.d.KyO));
                properties.put("Revision", BuildInfo.REV);
                properties.put("ReportTime", String.valueOf(System.currentTimeMillis()));
                properties.put("process", dVar.cWe.optString("process"));
                MrsLogic.PhoneInfo phoneInfo = MrsLogic.getPhoneInfo();
                properties.put("DeviceModel", phoneInfo.deviceModel);
                properties.put("OSName", phoneInfo.osName);
                properties.put("OSVersion", phoneInfo.osVersion);
                if (a.a(new File(s.k(s.k(optString, true), true)), properties)) {
                    dVar.filePath = optString;
                } else {
                    c.e("Matrix.MemoryReportListener", "HprofBufferShrinker.addExtraInfo fail, tag:memory", new Object[0]);
                }
            }
        } else {
            c.e("Matrix.MemoryReportListener", "issue content is null, tag:memory", new Object[0]);
        }
    }
}
