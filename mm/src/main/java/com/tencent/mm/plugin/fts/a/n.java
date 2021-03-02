package com.tencent.mm.plugin.fts.a;

import android.content.Context;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.d.e;
import java.util.HashSet;
import java.util.LinkedList;

public interface n extends a {
    void addSOSHistory(String str, String str2);

    void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar);

    e createFTSUIUnit(int i2, Context context, e.b bVar, int i3);

    LinkedList<e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, e.b bVar, int i2);

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    c getFTSImageLoader();

    h getFTSIndexDB();

    i getFTSIndexStorage(int i2);

    j getFTSMainDB();

    m getFTSTaskDaemon();

    b getItemClickHandler(int i2);

    boolean isFTSContextReady();

    void registerFTSUILogic(d dVar);

    void registerIndexStorage(i iVar);

    void registerItemClickHandler(int i2, b bVar);

    void registerNativeLogic(int i2, k kVar);

    com.tencent.mm.plugin.fts.a.a.a search(int i2, j jVar);

    int stringCompareUtfBinary(String str, String str2);

    void unregisterFTSUILogic(int i2);

    void unregisterIndexStorage(int i2);

    void unregisterItemClickHandler(int i2);

    void unregisterNativeLogic(int i2);

    void updateTopHitsRank(String str, m mVar, int i2);
}
