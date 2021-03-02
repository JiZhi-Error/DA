package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import java.util.ArrayList;
import java.util.List;

public interface a {
    int commitStory(String str, String str2, dlg dlg, acg acg, eds eds, int i2, List<String> list, List<String> list2, List<String> list3);

    int commitStory(String str, String str2, String str3, dlg dlg, boolean z, eds eds, int i2, int i3, List<String> list, List<String> list2, List<String> list3);

    /* renamed from: com.tencent.mm.plugin.story.proxy.a$a */
    public static final class C1769a {
        public static /* synthetic */ int a(a aVar, String str, String str2, String str3, dlg dlg, boolean z, eds eds, int i2, List list, List list2, List list3, int i3) {
            int i4;
            ArrayList arrayList;
            ArrayList arrayList2;
            AppMethodBeat.i(222913);
            if ((i3 & 64) != 0) {
                i4 = 0;
            } else {
                i4 = i2;
            }
            if ((i3 & 256) != 0) {
                arrayList = new ArrayList();
            } else {
                arrayList = list;
            }
            if ((i3 & 512) != 0) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = list2;
            }
            int commitStory = aVar.commitStory(str, str2, str3, dlg, z, eds, i4, 0, arrayList, arrayList2, (i3 & 1024) != 0 ? new ArrayList() : list3);
            AppMethodBeat.o(222913);
            return commitStory;
        }
    }
}
