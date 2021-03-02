package com.tencent.mm.view.recyclerview;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0013\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000b¨\u0006."}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstExposeList", "getFirstExposeList", "setFirstExposeList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "libmmui_release"})
public final class j {
    public LinkedList<k> Rrk = new LinkedList<>();
    public LinkedList<k> Rrl = new LinkedList<>();
    LinkedList<k> Rrm = new LinkedList<>();
    public LinkedList<k> Rrn = new LinkedList<>();
    public LinkedList<k> Rro = new LinkedList<>();
    public int ptb = -1;
    public int ptc = -1;
    public final int state;
    public int tIA = -1;
    public int tIy = -1;

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof j) && this.state == ((j) obj).state);
    }

    public final int hashCode() {
        return this.state;
    }

    public final String toString() {
        AppMethodBeat.i(205050);
        String str = "WxRVData(state=" + this.state + ")";
        AppMethodBeat.o(205050);
        return str;
    }

    public j(int i2) {
        AppMethodBeat.i(205049);
        this.state = i2;
        AppMethodBeat.o(205049);
    }
}
