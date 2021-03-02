package com.tencent.mm.ui.chatting.d.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.af;

public interface u extends af {
    boolean aT(ca caVar);

    boolean au(as asVar);

    ChatFooter gPO();

    ChatFooterCustom gPP();

    String gPR();

    void gPS();

    void gPU();

    void gPW();

    void gPX();

    void gPY();

    void setVoiceInputShowCallback(ChatFooter.d dVar);
}
