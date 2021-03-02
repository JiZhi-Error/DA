package com.tencent.mm.plugin.msgquote;

import com.tencent.mm.storage.ca;
import java.util.HashMap;

public interface a extends com.tencent.mm.kernel.b.a {
    com.tencent.mm.plugin.msgquote.a.a getMsgQuoteStorage();

    void handleQuoteMsgSendResuld(long j2, long j3);

    void handleReceivedQuoteMsg(long j2, long j3, String str, long j4);

    void handleRevokeMsgBySelf(long j2);

    void handleRevokeMsgBySvrId(long j2);

    void sendQuoteMsg(ca caVar, int i2, String str, CharSequence charSequence, String str2, int i3, HashMap<String, String> hashMap);
}
