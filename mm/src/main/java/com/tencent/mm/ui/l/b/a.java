package com.tencent.mm.ui.l.b;

import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.l.a.g;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<Pair<Long, c.a>> a(com.tencent.mm.ui.chatting.e.a aVar, boolean z) {
        ca amt;
        AppMethodBeat.i(259056);
        if (aVar == null) {
            Log.e("MicroMsg.MagicEmojiUtils", "hy: chatting context lost");
            AppMethodBeat.o(259056);
            return null;
        }
        BaseChattingUIFragment baseChattingUIFragment = aVar.Pwc;
        if (!(baseChattingUIFragment instanceof ChattingUIFragment)) {
            AppMethodBeat.o(259056);
            return null;
        }
        ChattingUIFragment chattingUIFragment = (ChattingUIFragment) baseChattingUIFragment;
        com.tencent.mm.ui.chatting.a.a aVar2 = chattingUIFragment.Pjp;
        if (aVar2 == null) {
            AppMethodBeat.o(259056);
            return null;
        }
        int firstVisiblePosition = chattingUIFragment.Pjq.getFirstVisiblePosition();
        int lastVisiblePosition = chattingUIFragment.getListView().getLastVisiblePosition();
        if (lastVisiblePosition <= firstVisiblePosition) {
            AppMethodBeat.o(259056);
            return null;
        }
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 <= lastVisiblePosition - firstVisiblePosition; i2++) {
            View childAt = chattingUIFragment.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                Object tag = childAt.getTag();
                if ((tag instanceof c.a) && (amt = aVar2.amt(i2)) != null) {
                    c.a aVar3 = (c.a) tag;
                    if (aVar3.getMainContainerView() != null) {
                        arrayList.add(new Pair(Long.valueOf(amt.field_msgId), aVar3));
                        if (z) {
                            d((ViewGroup) childAt, aVar3.getMainContainerView());
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(259056);
        return arrayList;
    }

    private static void d(ViewGroup viewGroup, View view) {
        AppMethodBeat.i(234454);
        ((ViewGroup) viewGroup.getParent()).setClipToPadding(false);
        ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
        View view2 = view;
        while (view2 != viewGroup) {
            view2 = (View) view2.getParent();
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).setClipChildren(false);
                ((ViewGroup) view2).setClipToPadding(false);
            }
        }
        AppMethodBeat.o(234454);
    }

    public static int[] g(g gVar) {
        AppMethodBeat.i(234455);
        if (!h(gVar)) {
            int[] iArr = new int[2];
            AppMethodBeat.o(234455);
            return iArr;
        }
        Point gWE = gVar.QlN.QlV.gWE();
        int[] iArr2 = {gWE.x, gWE.y};
        AppMethodBeat.o(234455);
        return iArr2;
    }

    private static boolean h(g gVar) {
        AppMethodBeat.i(234456);
        if (gVar == null) {
            Log.e("MicroMsg.MagicEmojiUtils", "hy: service is prepared");
            AppMethodBeat.o(234456);
            return false;
        } else if (gVar.QlN == null) {
            Log.e("MicroMsg.MagicEmojiUtils", "hy: runtime not prepared");
            AppMethodBeat.o(234456);
            return false;
        } else if (gVar.QlN.QlV == null) {
            Log.e("MicroMsg.MagicEmojiUtils", "hy: magic emoji page not valid");
            AppMethodBeat.o(234456);
            return false;
        } else {
            AppMethodBeat.o(234456);
            return true;
        }
    }

    public static int[] hl(View view) {
        AppMethodBeat.i(234457);
        int[] iArr = new int[2];
        if (view == null) {
            iArr[1] = 0;
            iArr[0] = 0;
        } else {
            view.getLocationInWindow(iArr);
        }
        AppMethodBeat.o(234457);
        return iArr;
    }

    public static float cx(float f2) {
        AppMethodBeat.i(234458);
        float ceil = (float) Math.ceil((double) (f2 / com.tencent.mm.plugin.appbrand.ac.g.bZk()));
        AppMethodBeat.o(234458);
        return ceil;
    }

    public static void bnK(final String str) {
        AppMethodBeat.i(234459);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.ui.l.b.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(234453);
                    Toast.makeText(MMApplicationContext.getContext(), "debug me err msg: " + str, 0).show();
                    AppMethodBeat.o(234453);
                }
            });
            AppMethodBeat.o(234459);
            return;
        }
        Log.e("MicroMsg.MagicEmojiUtils", "hy: error in magic emoji: %s", str);
        AppMethodBeat.o(234459);
    }
}
