package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f {
    public static final f FqO = new f();

    static {
        AppMethodBeat.i(119139);
        AppMethodBeat.o(119139);
    }

    private f() {
    }

    public static void a(j jVar, int i2, String str, a<x> aVar) {
        AppMethodBeat.i(119138);
        p.h(jVar, "storyInfo");
        p.h(str, "errMsg");
        p.h(aVar, "block");
        Log.i("MicroMsg.StoryPostTask", "processError localId " + ((int) jVar.systemRowid) + " processError " + i2 + " errMsg: " + str);
        Log.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(i2)));
        jVar.setItemDie();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().a((int) jVar.systemRowid, jVar);
        a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
        if (i2 == com.tencent.mm.plugin.story.i.a.Fvh) {
            Log.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
        } else {
            a.C1768a aVar3 = com.tencent.mm.plugin.story.i.a.FvD;
            if (i2 == com.tencent.mm.plugin.story.i.a.Fvi) {
                Log.e("MicroMsg.StoryPostTask", "parser protobuf error");
            } else {
                a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                if (i2 == com.tencent.mm.plugin.story.i.a.Fvj) {
                    Log.e("MicroMsg.StoryPostTask", "local id is not in db");
                } else {
                    a.C1768a aVar5 = com.tencent.mm.plugin.story.i.a.FvD;
                    if (i2 == com.tencent.mm.plugin.story.i.a.Fvk) {
                        Log.e("MicroMsg.StoryPostTask", "arg is error");
                    } else {
                        a.C1768a aVar6 = com.tencent.mm.plugin.story.i.a.FvD;
                        if (i2 == com.tencent.mm.plugin.story.i.a.Fvl) {
                            Log.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
                        } else {
                            a.C1768a aVar7 = com.tencent.mm.plugin.story.i.a.FvD;
                            if (i2 == com.tencent.mm.plugin.story.i.a.Fvm) {
                                Log.e("MicroMsg.StoryPostTask", "errtle  error");
                            }
                        }
                    }
                }
            }
        }
        aVar.invoke();
        AppMethodBeat.o(119138);
    }
}
