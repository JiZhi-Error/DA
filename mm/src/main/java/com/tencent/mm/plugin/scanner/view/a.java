package com.tencent.mm.plugin.scanner.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u000b\f\rJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView;", "", "dismissInfoView", "", "withAnimation", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "showInfoView", "viewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "ScanInfoViewParams", "ScanInfoViewParamsBuilder", "ScanInfoViewType", "scan-sdk_release"})
public interface a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "", "viewType", "", "showTips", "", "infoIconResId", "title", "", "tips", "showOpButton", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "(IZILjava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getInfoIconResId", "()I", "getOpButtonClickListener", "()Landroid/view/View$OnClickListener;", "getShowOpButton", "()Z", "getShowTips", "getTips", "()Ljava/lang/String;", "getTitle", "getViewType", "scan-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.view.a$a  reason: collision with other inner class name */
    public static final class C1682a {
        public final int CUX;
        public final boolean CUY;
        public final View.OnClickListener CUZ;
        public final boolean mVp;
        public final String pWf;
        private final int qcr;
        public final String title;

        public C1682a(int i2, boolean z, int i3, String str, String str2, boolean z2, View.OnClickListener onClickListener) {
            p.h(str, "title");
            p.h(str2, "tips");
            AppMethodBeat.i(194807);
            this.qcr = i2;
            this.mVp = z;
            this.CUX = i3;
            this.title = str;
            this.pWf = str2;
            this.CUY = z2;
            this.CUZ = onClickListener;
            AppMethodBeat.o(194807);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParamsBuilder;", "", "viewType", "", "(I)V", "infoIconResId", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "showOpButton", "", "showTips", "tips", "", "title", "build", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "setInfoIconResId", "iconResId", "setOpButton", "show", "clickListener", "setTips", "setTitle", "scan-sdk_release"})
    public static final class b {
        public int CUX = -1;
        public boolean CUY;
        public View.OnClickListener CUZ;
        public boolean mVp;
        public String pWf = "";
        public int qcr;
        public String title = "";

        public b(int i2) {
            this.qcr = i2;
        }

        public final b e(View.OnClickListener onClickListener) {
            this.CUY = true;
            this.CUZ = onClickListener;
            return this;
        }

        public final b aMW(String str) {
            AppMethodBeat.i(194808);
            p.h(str, "title");
            this.title = str;
            AppMethodBeat.o(194808);
            return this;
        }

        public final b aMX(String str) {
            AppMethodBeat.i(194809);
            p.h(str, "tips");
            this.pWf = str;
            AppMethodBeat.o(194809);
            return this;
        }
    }
}
