package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final List<coq> JrL = new LinkedList();

    static {
        AppMethodBeat.i(80956);
        coq coq = new coq();
        coq.Title = MMApplicationContext.getResources().getString(R.string.dqs);
        coq.ThumbUrl = "game_menu_icon_share_to_friend";
        coq.MuP = 1;
        coq.MuO = 1;
        coq.KWb = c.a.HVGAME_MENU_ACTION_SHARE_TO_FRIEND.code;
        JrL.add(coq);
        coq coq2 = new coq();
        coq2.Title = MMApplicationContext.getResources().getString(R.string.dqq);
        coq2.ThumbUrl = "game_menu_icon_exit";
        coq2.MuP = 2;
        coq2.MuO = 2;
        coq2.KWb = c.a.HVGAME_MENU_ACTION_EXIT.code;
        JrL.add(coq2);
        coq coq3 = new coq();
        coq3.Title = MMApplicationContext.getResources().getString(R.string.dqr);
        coq3.ThumbUrl = "game_menu_icon_refresh";
        coq3.MuP = 4;
        coq3.MuO = 5;
        coq3.KWb = c.a.HVGAME_MENU_ACTION_REFRESH.code;
        JrL.add(coq3);
        coq coq4 = new coq();
        coq4.Title = MMApplicationContext.getResources().getString(R.string.dqo);
        coq4.ThumbUrl = "game_menu_icon_collect";
        coq4.MuP = 3;
        coq4.MuO = 6;
        coq4.KWb = c.a.HVGAME_MENU_ACTION_COLLECT.code;
        JrL.add(coq4);
        coq coq5 = new coq();
        coq5.Title = MMApplicationContext.getResources().getString(R.string.dqp);
        coq5.ThumbUrl = "game_menu_icon_complaint";
        coq5.MuP = 6;
        coq5.MuO = 7;
        coq5.KWb = c.a.HVGAME_MENU_ACTION_COMPLAINT.code;
        JrL.add(coq5);
        coq coq6 = new coq();
        coq6.Title = MMApplicationContext.getResources().getString(R.string.dqn);
        coq6.ThumbUrl = "game_menu_icon_add_to_desktop";
        coq6.MuP = 5;
        coq6.MuO = 8;
        coq6.KWb = c.a.HVGAME_MENU_ACTION_ADD_TO_DESKTOP.code;
        JrL.add(coq6);
        AppMethodBeat.o(80956);
    }
}
