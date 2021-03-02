package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {
    public static final C1496a zVj = C1496a.zVk;

    public enum c {
        START_PROJECTOR,
        STOP_PROJECTOR,
        SHOW_DOODLE_LAYOUT,
        HIDE_DOODLE_LAYOUT,
        SET_MIC_MUTE_STATUS,
        CLEAR_SCREEN,
        STOP_PROJECTOR_SEND,
        AVATAR_READY,
        AVATAR_HIDE,
        THUMB_VIEW_PAGE_FLIP,
        SCREEN_ON_CLICK,
        SLIDE_CONTENT_LEFT,
        SLIDE_CONTENT_RIGHT,
        REQUEST_THUMB_REFRESH,
        ON_EDITOR_LAYOUT_CHANGE,
        SCREEN_READY_UI_FINISH,
        SAVE_TO_PICTURE,
        SAVE_TO_FAV,
        SEND_TO_FRIEND,
        SCALE_SCREEN;

        static {
            AppMethodBeat.i(239894);
            AppMethodBeat.o(239894);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(239896);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(239896);
            return cVar;
        }
    }

    void a(c cVar, Bundle bundle);

    int epf();

    boolean epg();

    boolean eph();

    int epi();

    boolean getCurrentStatus();

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.projector.a$a */
    public static final class C1496a {
        static final /* synthetic */ C1496a zVk = new C1496a();

        static {
            AppMethodBeat.i(239892);
            AppMethodBeat.o(239892);
        }

        private C1496a() {
        }
    }

    public static final class b {
        public static /* synthetic */ void a(a aVar, c cVar) {
            AppMethodBeat.i(239893);
            aVar.a(cVar, null);
            AppMethodBeat.o(239893);
        }
    }
}
