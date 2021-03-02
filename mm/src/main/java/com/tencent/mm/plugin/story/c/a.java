package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant;", "", "ElementName", "ModuleName", "plugin-story_release"})
public interface a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "", "(Ljava/lang/String;I)V", "ELEMENT_CAMERA", "ELEMENT_ENCODER", "ELEMENT_PROCESS_TYPE", "ELEMENT_ENTRANCE", "ELEMENT_POST", "ELEMENT_BASIC", "ELEMENT_VISITOR", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a$a  reason: collision with other inner class name */
    public enum EnumC1743a {
        ELEMENT_CAMERA,
        ELEMENT_ENCODER,
        ELEMENT_PROCESS_TYPE,
        ELEMENT_ENTRANCE,
        ELEMENT_POST,
        ELEMENT_BASIC,
        ELEMENT_VISITOR;

        static {
            AppMethodBeat.i(118567);
            AppMethodBeat.o(118567);
        }

        public static EnumC1743a valueOf(String str) {
            AppMethodBeat.i(118569);
            EnumC1743a aVar = (EnumC1743a) Enum.valueOf(EnumC1743a.class, str);
            AppMethodBeat.o(118569);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ModuleName;", "", "(Ljava/lang/String;I)V", "MODEL_STORY", "plugin-story_release"})
    public enum b {
        MODEL_STORY;

        static {
            AppMethodBeat.i(118570);
            AppMethodBeat.o(118570);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(118572);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(118572);
            return bVar;
        }
    }
}
