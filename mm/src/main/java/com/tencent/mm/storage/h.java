package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import junit.framework.Assert;

public final class h extends e {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )"};

    public h(i iVar) {
        super(iVar);
        AppMethodBeat.i(32815);
        e(getDB(), "appbrandmessage");
        a(new i.b(256, "appbrandmessage", i.b.a(3000001, 3500000, 102000001, 105000000)));
        AppMethodBeat.o(32815);
    }

    @Override // com.tencent.mm.storage.e
    public final String avu(String str) {
        AppMethodBeat.i(32816);
        Assert.assertTrue(str != null && str.length() > 0);
        if (as.HF(str)) {
            AppMethodBeat.o(32816);
            return "appbrandmessage";
        }
        AppMethodBeat.o(32816);
        return null;
    }
}
