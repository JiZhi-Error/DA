package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;

public interface d extends a {
    bf getEmojiDescMgr();

    com.tencent.mm.pluginsdk.a.d getEmojiMgr();

    bj getEmojiStorageMgr();

    e getProvider();

    void removeEmojiMgr();

    void setEmojiMgr();
}
