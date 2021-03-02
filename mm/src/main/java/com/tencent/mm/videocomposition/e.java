package com.tencent.mm.videocomposition;

import android.util.Pair;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052J\b\u0002\u0010\u0006\u001aD\u00128\u00126\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\bj\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n`\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "", "getVideoLabel", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "isEnable", "", "video_composition_release"})
public interface e {
    void a(n nVar, b<? super HashMap<String, Pair<Integer, Long>>, x> bVar);

    boolean isEnable();
}
