package com.tencent.mm.msgsubscription.d;

import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H'J.\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\tH&J8\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH'J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H&¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "", com.tencent.mm.plugin.appbrand.jsapi.storage.a.NAME, "", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "bizUsername", "", "getSubscribeSwitchOpened", "", "getSubscribeTmpByTemplateId", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "saveSubscribeMsgList", "scene", "", "subscribeMsgList", "", "subscribeSwitchOpened", "updateSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitchOpen", "needUpdateTimestamp", "updateSubscribeStatusTimestamp", "plugin-comm_release"})
public interface a {
    ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA(String str);

    boolean Rz(String str);

    void a(String str, List<SubscribeMsgTmpItem> list, boolean z);

    void b(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3);

    SubscribeMsgTmpItem bI(String str, String str2);

    void biY();

    void d(String str, List<SubscribeMsgTmpItem> list);
}
