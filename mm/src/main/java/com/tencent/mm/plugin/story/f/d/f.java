package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, hxF = {"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"})
public final class f {
    public static final List<String> a(p pVar) {
        AppMethodBeat.i(118915);
        kotlin.g.b.p.h(pVar, "dataSeed");
        if (pVar instanceof b) {
            List<String> list = ((b) pVar).iPH;
            AppMethodBeat.o(118915);
            return list;
        } else if (pVar instanceof a) {
            List<String> list2 = ((a) pVar).iPH;
            AppMethodBeat.o(118915);
            return list2;
        } else if (pVar instanceof c) {
            List<String> list3 = ((c) pVar).FoJ;
            AppMethodBeat.o(118915);
            return list3;
        } else if (pVar instanceof d) {
            List<String> list4 = ((d) pVar).iPH;
            AppMethodBeat.o(118915);
            return list4;
        } else {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(118915);
            return arrayList;
        }
    }
}
