package com.tencent.mm.pluginsdk.ui.span;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene;", "", "()V", "Companion", "SCENE", "plugin-comm_release"})
public final class t {
    public static final a Kse = new a((byte) 0);

    static {
        AppMethodBeat.i(223477);
        AppMethodBeat.o(223477);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "", "sceneValue", "", "preSceneValue", "(Ljava/lang/String;III)V", "getPreSceneValue", "()I", "setPreSceneValue", "(I)V", "getSceneValue", "makeData", "Landroid/os/Bundle;", "", FFmpegMetadataRetriever.METADATA_KEY_DATE, "SINGLE_CHATTING", "GROUP_CHATTING", "FAVORITE", "TIME_LINE", "FINDER", "CHATTING_RECORD_FROM_FAV", "CHATTING_RECORD_FROM_SINGLE_CHAT", "CHATTING_RECORD_FROM_GROUP_CHAT", "NOTE_FROM_FAV", "NOTE_FROM_SINGLE_CHAT", "NOTE_FROM_GROUP_CHAT", "NOTE_FROM_TIMELINE", "plugin-comm_release"})
    public enum b {
        SINGLE_CHATTING(1007, 0),
        GROUP_CHATTING(1008, 0),
        FAVORITE(1010, 0),
        TIME_LINE(1155, 0),
        FINDER(1184, 0),
        CHATTING_RECORD_FROM_FAV(1096, 5),
        CHATTING_RECORD_FROM_SINGLE_CHAT(1096, 1),
        CHATTING_RECORD_FROM_GROUP_CHAT(1096, 2),
        NOTE_FROM_FAV(1186, 5),
        NOTE_FROM_SINGLE_CHAT(1186, 1),
        NOTE_FROM_GROUP_CHAT(1186, 2),
        NOTE_FROM_TIMELINE(1186, 3);
        
        public final int Kss;
        public int Kst;

        public static b valueOf(String str) {
            AppMethodBeat.i(223476);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(223476);
            return bVar;
        }

        private b(int i2, int i3) {
            this.Kss = i2;
            this.Kst = i3;
        }

        static {
            AppMethodBeat.i(223472);
            AppMethodBeat.o(223472);
        }

        public final Bundle grZ() {
            AppMethodBeat.i(223473);
            Bundle bundle = new Bundle();
            bundle.putString("key_wxa_short_link_launch_scene", name());
            AppMethodBeat.o(223473);
            return bundle;
        }

        public final void br(Bundle bundle) {
            AppMethodBeat.i(223474);
            p.h(bundle, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            bundle.putString("key_wxa_short_link_launch_scene", name());
            AppMethodBeat.o(223474);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$Companion;", "", "()V", "KEY_WXA_SHORT_LINK_LAUNCH_SCENE", "", "makeDataForChatting", "Landroid/os/Bundle;", "isGroupChat", "", "makeDataForFavorite", "makeDataForTimeLine", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final Bundle Ao(boolean z) {
        AppMethodBeat.i(223478);
        if (z) {
            Bundle grZ = b.GROUP_CHATTING.grZ();
            AppMethodBeat.o(223478);
            return grZ;
        }
        Bundle grZ2 = b.SINGLE_CHATTING.grZ();
        AppMethodBeat.o(223478);
        return grZ2;
    }

    public static final Bundle grX() {
        AppMethodBeat.i(223479);
        Bundle bundle = new Bundle();
        bundle.putString("key_wxa_short_link_launch_scene", b.FAVORITE.name());
        AppMethodBeat.o(223479);
        return bundle;
    }

    public static final Bundle grY() {
        AppMethodBeat.i(223480);
        Bundle bundle = new Bundle();
        bundle.putString("key_wxa_short_link_launch_scene", b.TIME_LINE.name());
        AppMethodBeat.o(223480);
        return bundle;
    }
}
