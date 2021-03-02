package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cj;

public interface s extends a {
    b getBizTimeLineCallback();

    cj getSysCmdMsgExtension();

    boolean ifAddTicketByActionFlag(String str);

    void setBizTimeLineCallback(b bVar);

    void setEnSendMsgActionFlag(int i2);

    void setIDataTransferFactoryDelegate(at atVar);
}
