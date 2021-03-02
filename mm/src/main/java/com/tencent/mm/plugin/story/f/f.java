package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.f.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class f {
    public static final a FlW = new a((byte) 0);

    static {
        AppMethodBeat.i(118653);
        AppMethodBeat.o(118653);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean isStoryUnread(String str) {
            AppMethodBeat.i(118652);
            if (str == null) {
                AppMethodBeat.o(118652);
                return false;
            } else if (!o.isShowStoryCheck()) {
                AppMethodBeat.o(118652);
                return false;
            } else {
                j.b bVar = j.Fmy;
                com.tencent.mm.plugin.story.i.f aRS = j.b.fod().aRS(str);
                if (!aRS.isValid() || !aRS.frA()) {
                    AppMethodBeat.o(118652);
                    return false;
                }
                AppMethodBeat.o(118652);
                return true;
            }
        }
    }
}
