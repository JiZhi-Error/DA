package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import junit.framework.Assert;

public final class i extends e {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS appbrandnotifymessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSvrIdIndex ON appbrandnotifymessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerIndex ON appbrandnotifymessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalerStatusIndex ON appbrandnotifymessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTimeIndex ON appbrandnotifymessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTaklerTimeIndex ON appbrandnotifymessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSendCreateTimeIndex ON appbrandnotifymessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerTypeIndex ON appbrandnotifymessage ( talker,type )"};

    public i(com.tencent.mm.plugin.messenger.foundation.a.a.i iVar) {
        super(iVar);
        AppMethodBeat.i(232416);
        e(getDB(), "appbrandnotifymessage");
        a(new i.b(32, "appbrandnotifymessage", i.b.a(3500001, 4000000, 105000001, 108000000)));
        AppMethodBeat.o(232416);
    }

    @Override // com.tencent.mm.storage.e
    public final String avu(String str) {
        AppMethodBeat.i(232417);
        Assert.assertTrue(str != null && str.length() > 0);
        if (ab.JC(str)) {
            AppMethodBeat.o(232417);
            return "appbrandnotifymessage";
        }
        AppMethodBeat.o(232417);
        return null;
    }
}
