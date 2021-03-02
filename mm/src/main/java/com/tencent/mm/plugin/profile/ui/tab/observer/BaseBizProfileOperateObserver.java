package com.tencent.mm.plugin.profile.ui.tab.observer;

import com.tencent.mm.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class BaseBizProfileOperateObserver implements IBizProfileOperateObserver {
    public c Bdk;
    public List<WxaAttributes.WxaEntryInfo> BeW;
    public aeq BeX;
    public String dhE;
    public List<c.a> dhu;
    public c.b dhv;
    public long enterTime;

    @Override // com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver
    public boolean a(f fVar, as asVar) {
        return false;
    }
}
