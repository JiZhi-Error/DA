package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.api.o;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d extends com.tencent.mm.plugin.story.c.b<a> {
    public static final d Flc = new d();

    static {
        AppMethodBeat.i(118605);
        AppMethodBeat.o(118605);
    }

    private d() {
    }

    public static boolean aRK(String str) {
        AppMethodBeat.i(118602);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(118602);
            return false;
        } else if (ab.IG(str) || ab.IT(str) || ab.IJ(str) || ab.IP(str) || ab.IW(str) || ab.IX(str) || ab.Jx(str) || ab.JC(str) || ab.JE(str) || ab.Ji(str) || ab.Iy(str) || ab.Ix(str)) {
            AppMethodBeat.o(118602);
            return false;
        } else {
            AppMethodBeat.o(118602);
            return true;
        }
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        AppMethodBeat.i(118604);
        ((a) aLQ()).clear();
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118604);
            return;
        }
        ((a) aLQ()).add(b.CONTACT_PAGE);
        ((a) aLQ()).add(b.TIMELINE_LIKE);
        ((a) aLQ()).add(b.TIMELINE_DETAIL);
        ((a) aLQ()).add(b.TIMELINE_COMMENT);
        ((a) aLQ()).add(b.TIMELINE_USER_HEAD);
        ((a) aLQ()).add(b.MESSAGE_PAGE);
        ((a) aLQ()).add(b.CHATTING_ROOM);
        AppMethodBeat.o(118604);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
    public enum b {
        DEFAULT(-1),
        CONTACT_PAGE(0),
        TIMELINE_LIKE(1),
        TIMELINE_DETAIL(2),
        TIMELINE_COMMENT(3),
        TIMELINE_USER_HEAD(4),
        CHATTING_ROOM(5),
        MESSAGE_PAGE(6);
        
        public static final a Flm = new a((byte) 0);
        private static final Map<Integer, b> map;
        private final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(118601);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(118601);
            return bVar;
        }

        private b(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(118599);
            b[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.mZ(ae.atJ(values.length), 16));
            for (b bVar : values) {
                linkedHashMap.put(Integer.valueOf(bVar.value), bVar);
            }
            map = linkedHashMap;
            AppMethodBeat.o(118599);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "Lkotlin/collections/HashSet;", "()V", "plugin-story_release"})
    public static final class a extends HashSet<b> {
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(118596);
            if (!(obj instanceof b)) {
                AppMethodBeat.o(118596);
                return false;
            }
            boolean contains = super.contains((b) obj);
            AppMethodBeat.o(118596);
            return contains;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.i(118597);
            if (!(obj instanceof b)) {
                AppMethodBeat.o(118597);
                return false;
            }
            boolean remove = super.remove((b) obj);
            AppMethodBeat.o(118597);
            return remove;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(118598);
            int size = super.size();
            AppMethodBeat.o(118598);
            return size;
        }
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(118603);
        a aVar = new a();
        AppMethodBeat.o(118603);
        return aVar;
    }
}
