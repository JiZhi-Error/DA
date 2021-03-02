package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class o {
    public static boolean isShowStoryCheck() {
        AppMethodBeat.i(118420);
        boolean isShowStoryCheck = ((e) g.ah(e.class)).isShowStoryCheck();
        AppMethodBeat.o(118420);
        return isShowStoryCheck;
    }

    public static boolean fnq() {
        boolean z;
        AppMethodBeat.i(118421);
        if (((a) g.af(a.class)).aqJ().getInt("StoryOpenRoomSync", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        Log.i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (!z) {
            AppMethodBeat.o(118421);
            return true;
        }
        AppMethodBeat.o(118421);
        return false;
    }

    public static boolean fnr() {
        boolean z;
        AppMethodBeat.i(118422);
        if (((a) g.af(a.class)).aqJ().getInt("StoryOpenStrangerUserPage", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        Log.i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (!z) {
            AppMethodBeat.o(118422);
            return true;
        }
        AppMethodBeat.o(118422);
        return false;
    }

    public static void bB(Context context, String str) {
        AppMethodBeat.i(118423);
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra(ch.COL_USERNAME, str);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(118423);
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("LaunchStory", e2, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.o(118423);
        }
    }

    public static void a(Context context, List<String> list, String str, String str2) {
        AppMethodBeat.i(118427);
        try {
            ArrayList arrayList = new ArrayList(list);
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra("user_list", arrayList);
            intent.putExtra("delete_when_first_empty", false);
            intent.putExtra("gallery_chat_room", str);
            intent.putExtra("gallery_session_id", str2);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(118427);
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("LaunchStory", e2, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.o(118427);
        }
    }
}
