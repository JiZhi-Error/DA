package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J'\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R&\u0010\u0007\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u001a\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"¨\u0006:"}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "", "spanIndex", "", "width", "height", "(III)V", "foldedAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getFoldedAdapterRef", "()Ljava/lang/ref/WeakReference;", "setFoldedAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "foldedExpose", "", "getFoldedExpose", "()Z", "setFoldedExpose", "(Z)V", "foldedExposeReport", "getFoldedExposeReport", "setFoldedExposeReport", "foldedSessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getFoldedSessionExposeMap", "()Landroid/util/LongSparseArray;", "setFoldedSessionExposeMap", "(Landroid/util/LongSparseArray;)V", "foldedTop", "getFoldedTop", "()I", "setFoldedTop", "(I)V", "globalVisibleBottom", "getGlobalVisibleBottom", "setGlobalVisibleBottom", "globalVisibleTop", "getGlobalVisibleTop", "setGlobalVisibleTop", "getHeight", "setHeight", "getSpanIndex", "visibleTop", "getVisibleTop", "setVisibleTop", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "libmmui_release"})
public final class i {
    public int Rrb;
    public int Rrc;
    public int Rrd;
    public int Rre;
    public boolean Rrf;
    public boolean Rrg;
    public LongSparseArray<k> Rrh;
    public WeakReference<WxRecyclerAdapter<?>> Rri;
    public final int Rrj;
    public int height;
    public int width;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!(this.Rrj == iVar.Rrj && this.width == iVar.width && this.height == iVar.height)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.Rrj * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        AppMethodBeat.i(205048);
        String str = "WxItemShowInfo(spanIndex=" + this.Rrj + ", width=" + this.width + ", height=" + this.height + ")";
        AppMethodBeat.o(205048);
        return str;
    }

    private /* synthetic */ i() {
        this(0, 0, 0);
    }

    public i(int i2, int i3, int i4) {
        this.Rrj = i2;
        this.width = i3;
        this.height = i4;
    }
}
