package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import java.util.Comparator;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "kotlin.jvm.PlatformType", "o2", "compare"})
public final class FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1<T> implements Comparator<a> {
    public static final FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1 uYY = new FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1();

    static {
        AppMethodBeat.i(249915);
        AppMethodBeat.o(249915);
    }

    FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
        AppMethodBeat.i(249914);
        a aVar3 = aVar;
        a aVar4 = aVar2;
        if (aVar3.uNF.field_createTime == aVar4.uNF.field_createTime) {
            int i2 = (aVar4.uNF.field_id > aVar3.uNF.field_id ? 1 : (aVar4.uNF.field_id == aVar3.uNF.field_id ? 0 : -1));
            AppMethodBeat.o(249914);
            return i2;
        }
        int compare = p.compare(aVar4.uNF.field_createTime, aVar3.uNF.field_createTime);
        AppMethodBeat.o(249914);
        return compare;
    }
}
