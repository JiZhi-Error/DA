package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class i {
    public static final a FuI = new a((byte) 0);

    static {
        AppMethodBeat.i(119467);
        AppMethodBeat.o(119467);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int aSq(String str) {
            AppMethodBeat.i(119465);
            p.h(str, "userName");
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(119465);
                return 0;
            }
            j.b bVar = j.Fmy;
            if (p.j(j.b.fau(), str)) {
                AppMethodBeat.o(119465);
                return 1;
            }
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
            p.g(Kn, UserDataStore.CITY);
            if (Kn.arA()) {
                AppMethodBeat.o(119465);
                return 3;
            } else if (Kn.arv()) {
                AppMethodBeat.o(119465);
                return 4;
            } else {
                AppMethodBeat.o(119465);
                return 5;
            }
        }

        public static long aaX(int i2) {
            AppMethodBeat.i(119466);
            switch (i2) {
                case 0:
                    AppMethodBeat.o(119466);
                    return 7;
                case 1:
                case 2:
                case 3:
                default:
                    AppMethodBeat.o(119466);
                    return 0;
                case 4:
                    AppMethodBeat.o(119466);
                    return 8;
                case 5:
                    h hVar = h.FuH;
                    long ahw = h.fqi().ahw();
                    AppMethodBeat.o(119466);
                    return ahw;
                case 6:
                    AppMethodBeat.o(119466);
                    return 9;
            }
        }
    }
}
