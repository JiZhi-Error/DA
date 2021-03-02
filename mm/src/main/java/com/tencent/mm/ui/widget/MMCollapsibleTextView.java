package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010j\u001a\u00020M2\u0006\u0010b\u001a\u00020cH\u0002J\u0010\u0010k\u001a\u00020M2\u0006\u0010l\u001a\u00020mH\u0002J\u001e\u0010n\u001a\u00020M2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0003J\b\u0010o\u001a\u00020MH\u0002J\u0018\u0010p\u001a\u00020M2\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\tH\u0014J\b\u0010s\u001a\u00020MH\u0002J\u000e\u0010t\u001a\u00020M2\u0006\u0010b\u001a\u00020\tJ\u0010\u0010u\u001a\u00020M2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010v\u001a\u00020M2\u0006\u0010H\u001a\u00020\tH\u0002J\u0010\u0010w\u001a\u00020M2\b\u0010x\u001a\u0004\u0018\u00010yJ\u000e\u0010z\u001a\u00020M2\u0006\u0010b\u001a\u00020cJ\u0018\u0010z\u001a\u00020M2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010{\u001a\u000201J\u0016\u0010|\u001a\u00020M2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u0018J\b\u0010\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002J\t\u0010\u0001\u001a\u00020MH\u0002R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001a\u0010\u000fR#\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R#\u0010\"\u001a\n \r*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\n \r*\u0004\u0018\u00010(0(8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u00106\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b7\u0010*R#\u00108\u001a\n \r*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b9\u0010%R\u000e\u0010;\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u0014\u0010>\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010-R\u0014\u0010@\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R#\u0010D\u001a\n \r*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u0011\u001a\u0004\bE\u0010%R\u000e\u0010G\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\"\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u000e\u0010U\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R#\u0010V\u001a\n \r*\u0004\u0018\u00010W0W8BX\u0002¢\u0006\f\n\u0004\bZ\u0010\u0011\u001a\u0004\bX\u0010YR#\u0010[\u001a\n \r*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\b]\u0010\u0011\u001a\u0004\b\\\u0010%R\u000e\u0010^\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R#\u0010_\u001a\n \r*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\ba\u0010\u0011\u001a\u0004\b`\u0010%R\u000e\u0010b\u001a\u00020cX.¢\u0006\u0002\n\u0000R\u0011\u0010d\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\be\u0010BR\u000e\u0010f\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010g\u001a\u00020\u0018*\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapseButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_collapseButton", "()Landroid/widget/TextView;", "_collapseButton$delegate", "Lkotlin/Lazy;", "_collapseImage", "Landroid/widget/ImageView;", "get_collapseImage", "()Landroid/widget/ImageView;", "_collapseImage$delegate", "_collapseLastRight", "", "_contentBackupText", "get_contentBackupText", "_contentBackupText$delegate", "_contentText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "get_contentText", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "_contentText$delegate", "_expandLastRight", "centerContentPlaceHolder", "Landroid/support/constraint/Placeholder;", "getCenterContentPlaceHolder", "()Landroid/support/constraint/Placeholder;", "centerContentPlaceHolder$delegate", "collapseButton", "Landroid/view/View;", "getCollapseButton", "()Landroid/view/View;", "collapseButtonExpendText", "getCollapseButtonExpendText", "()I", "setCollapseButtonExpendText", "(I)V", "collapsed", "", "getCollapsed", "()Z", "setCollapsed", "(Z)V", com.tencent.mm.util.d.QYD, "getContentText", "fullContentPlaceHolder", "getFullContentPlaceHolder", "fullContentPlaceHolder$delegate", "imageCollapse", "isSpecialText", "setSpecialText", "lastLineHeight", "getLastLineHeight", "lastLineRight", "getLastLineRight", "()F", "layoutId", "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder", "leftBottomCollapsePlaceHolder$delegate", "mContext", "maxLines", "needCollapse", "noCollapseCenter", "onCollapse", "Lkotlin/Function0;", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function0;", "setOnCollapse", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "preMeasureWidth", "resource", "Landroid/content/res/Resources;", "getResource", "()Landroid/content/res/Resources;", "resource$delegate", "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder", "rightBottomCollapsePlaceHolder$delegate", "rightCollapse", "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder", "rightCollapsePlaceHolder$delegate", "text", "", "textSize", "getTextSize", "textUpdated", "dpToPixel", "getDpToPixel", "(F)F", "_setText", "calcRightOffset", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "measureTruncate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetRightOffset", "setCollapseButtonText", "setCollapseStatus", "setMaxLines", "setOnTextTouchListener", "l", "Landroid/view/View$OnTouchListener;", "setText", "isRequestLayout", "setTextSize", "unit", "size", "setupCollapseButton", "setupRightCollapsePosition", "switch", "libmmui_release"})
public final class MMCollapsibleTextView extends ConstraintLayout {
    private final int Inc = R.layout.b7y;
    private final kotlin.f QCe = kotlin.g.ah(new i(this));
    private boolean QCf;
    private boolean QCg;
    private boolean QCh;
    private boolean QCi;
    private final kotlin.f QCj = kotlin.g.ah(new d(this));
    private final kotlin.f QCk = kotlin.g.ah(new c(this));
    private final kotlin.f QCl = kotlin.g.ah(new a(this));
    private final kotlin.f QCm = kotlin.g.ah(new b(this));
    private final kotlin.f QCn = kotlin.g.ah(new f(this));
    private final kotlin.f QCo = kotlin.g.ah(new e(this));
    private final kotlin.f QCp = kotlin.g.ah(new g(this));
    private final kotlin.f QCq = kotlin.g.ah(new j(this));
    private final kotlin.f QCr = kotlin.g.ah(new k(this));
    private boolean QCs = true;
    private kotlin.g.a.a<x> QCt;
    private kotlin.g.a.a<x> QCu;
    private int QCv = -1;
    private float QCw = -1.0f;
    private float QCx = -1.0f;
    private int QCy = R.string.c2u;
    private Context mContext;
    private int maxLines = Integer.MAX_VALUE;
    private boolean pMM;
    private CharSequence text;
    private boolean wXG;

    private final Placeholder getCenterContentPlaceHolder() {
        AppMethodBeat.i(140964);
        Placeholder placeholder = (Placeholder) this.QCo.getValue();
        AppMethodBeat.o(140964);
        return placeholder;
    }

    private final Placeholder getFullContentPlaceHolder() {
        AppMethodBeat.i(140963);
        Placeholder placeholder = (Placeholder) this.QCn.getValue();
        AppMethodBeat.o(140963);
        return placeholder;
    }

    private final Placeholder getLeftBottomCollapsePlaceHolder() {
        AppMethodBeat.i(140965);
        Placeholder placeholder = (Placeholder) this.QCp.getValue();
        AppMethodBeat.o(140965);
        return placeholder;
    }

    private final Resources getResource() {
        AppMethodBeat.i(140958);
        Resources resources = (Resources) this.QCe.getValue();
        AppMethodBeat.o(140958);
        return resources;
    }

    private final Placeholder getRightBottomCollapsePlaceHolder() {
        AppMethodBeat.i(140966);
        Placeholder placeholder = (Placeholder) this.QCq.getValue();
        AppMethodBeat.o(140966);
        return placeholder;
    }

    private final Placeholder getRightCollapsePlaceHolder() {
        AppMethodBeat.i(140967);
        Placeholder placeholder = (Placeholder) this.QCr.getValue();
        AppMethodBeat.o(140967);
        return placeholder;
    }

    private final ImageView get_collapseImage() {
        AppMethodBeat.i(140962);
        ImageView imageView = (ImageView) this.QCm.getValue();
        AppMethodBeat.o(140962);
        return imageView;
    }

    public final TextView get_collapseButton() {
        AppMethodBeat.i(140961);
        TextView textView = (TextView) this.QCl.getValue();
        AppMethodBeat.o(140961);
        return textView;
    }

    public final TextView get_contentBackupText() {
        AppMethodBeat.i(140960);
        TextView textView = (TextView) this.QCk.getValue();
        AppMethodBeat.o(140960);
        return textView;
    }

    public final MMNeat7extView get_contentText() {
        AppMethodBeat.i(140959);
        MMNeat7extView mMNeat7extView = (MMNeat7extView) this.QCj.getValue();
        AppMethodBeat.o(140959);
        return mMNeat7extView;
    }

    public static final /* synthetic */ ImageView a(MMCollapsibleTextView mMCollapsibleTextView) {
        AppMethodBeat.i(140981);
        ImageView imageView = mMCollapsibleTextView.get_collapseImage();
        AppMethodBeat.o(140981);
        return imageView;
    }

    public final void setSpecialText(boolean z) {
        this.pMM = z;
    }

    public final boolean getCollapsed() {
        return this.QCs;
    }

    public final void setCollapsed(boolean z) {
        this.QCs = z;
    }

    public final kotlin.g.a.a<x> getOnCollapse() {
        return this.QCt;
    }

    public final void setOnCollapse(kotlin.g.a.a<x> aVar) {
        this.QCt = aVar;
    }

    public final kotlin.g.a.a<x> getOnExpand() {
        return this.QCu;
    }

    public final void setOnExpand(kotlin.g.a.a<x> aVar) {
        this.QCu = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(140979);
        this.mContext = context;
        init(attributeSet, 0);
        AppMethodBeat.o(140979);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMCollapsibleTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(140980);
        this.mContext = context;
        init(attributeSet, i2);
        AppMethodBeat.o(140980);
    }

    @SuppressLint({"Recycle", "CustomViewStyleable"})
    private final void init(AttributeSet attributeSet, int i2) {
        int i3;
        AppMethodBeat.i(140968);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.C0244a.MMCollapsibleTextView, i2, 0);
            p.g(obtainStyledAttributes, "tArray");
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i8 = 0;
            while (i8 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == 4) {
                    this.maxLines = obtainStyledAttributes.getInt(index, Integer.MAX_VALUE);
                    i3 = i7;
                } else if (index == 0) {
                    i4 = obtainStyledAttributes.getDimensionPixelSize(index, i4);
                    i3 = i7;
                } else if (index == 1) {
                    i5 = obtainStyledAttributes.getColor(index, i5);
                    i3 = i7;
                } else if (index == 2) {
                    i6 = obtainStyledAttributes.getColor(index, i6);
                    i3 = i7;
                } else if (index == 5) {
                    i3 = obtainStyledAttributes.getDimensionPixelSize(index, i7);
                } else if (index == 6) {
                    this.QCh = obtainStyledAttributes.getInt(index, 0) != 0;
                    i3 = i7;
                } else if (index == 8) {
                    this.QCg = obtainStyledAttributes.getBoolean(index, this.QCg);
                    i3 = i7;
                } else {
                    if (index == 7) {
                        this.QCi = obtainStyledAttributes.getInt(index, 0) != 0;
                    }
                    i3 = i7;
                }
                i8++;
                i7 = i3;
            }
        }
        aa.jQ(this.mContext).inflate(this.Inc, this);
        if (i6 != -1) {
            get_collapseButton().setTextColor(i6);
        }
        if (i5 != -1) {
            get_contentText().setTextColor(i5);
            get_contentBackupText().setTextColor(i5);
        }
        if (i4 != -1) {
            get_collapseButton().setTextSize(0, (float) i4);
            get_contentText().setTextSize(0, (float) i4);
            get_contentBackupText().setTextSize(0, (float) i4);
        }
        if (i7 != -1) {
            get_contentText().setSpacingAdd(i7);
            get_contentBackupText().setLineSpacing((float) i7, 1.0f);
        }
        Placeholder fullContentPlaceHolder = getFullContentPlaceHolder();
        p.g(fullContentPlaceHolder, "fullContentPlaceHolder");
        fullContentPlaceHolder.setEmptyVisibility(8);
        Placeholder centerContentPlaceHolder = getCenterContentPlaceHolder();
        p.g(centerContentPlaceHolder, "centerContentPlaceHolder");
        centerContentPlaceHolder.setEmptyVisibility(8);
        Placeholder leftBottomCollapsePlaceHolder = getLeftBottomCollapsePlaceHolder();
        p.g(leftBottomCollapsePlaceHolder, "leftBottomCollapsePlaceHolder");
        leftBottomCollapsePlaceHolder.setEmptyVisibility(8);
        Placeholder rightBottomCollapsePlaceHolder = getRightBottomCollapsePlaceHolder();
        p.g(rightBottomCollapsePlaceHolder, "rightBottomCollapsePlaceHolder");
        rightBottomCollapsePlaceHolder.setEmptyVisibility(8);
        Placeholder rightCollapsePlaceHolder = getRightCollapsePlaceHolder();
        p.g(rightCollapsePlaceHolder, "rightCollapsePlaceHolder");
        rightCollapsePlaceHolder.setEmptyVisibility(8);
        AppMethodBeat.o(140968);
    }

    public final float getTextSize() {
        AppMethodBeat.i(140969);
        MMNeat7extView mMNeat7extView = get_contentText();
        p.g(mMNeat7extView, "_contentText");
        float textSize = mMNeat7extView.getTextSize();
        AppMethodBeat.o(140969);
        return textSize;
    }

    public final void setCollapseButtonText(int i2) {
        this.QCy = i2;
    }

    private final void setMaxLines(int i2) {
        AppMethodBeat.i(140970);
        if (this.pMM) {
            TextView textView = get_contentBackupText();
            p.g(textView, "_contentBackupText");
            textView.setMaxLines(i2);
            AppMethodBeat.o(140970);
            return;
        }
        get_contentText().setMaxLines(i2);
        AppMethodBeat.o(140970);
    }

    public final View getContentText() {
        AppMethodBeat.i(140971);
        if (this.pMM) {
            TextView textView = get_contentBackupText();
            p.g(textView, "_contentBackupText");
            TextView textView2 = textView;
            AppMethodBeat.o(140971);
            return textView2;
        }
        MMNeat7extView mMNeat7extView = get_contentText();
        p.g(mMNeat7extView, "_contentText");
        MMNeat7extView mMNeat7extView2 = mMNeat7extView;
        AppMethodBeat.o(140971);
        return mMNeat7extView2;
    }

    private final View getCollapseButton() {
        AppMethodBeat.i(140972);
        if (this.QCi) {
            ImageView imageView = get_collapseImage();
            AppMethodBeat.o(140972);
            return imageView;
        }
        TextView textView = get_collapseButton();
        AppMethodBeat.o(140972);
        return textView;
    }

    public final void setOnTextTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(140973);
        get_contentBackupText().setOnTouchListener(onTouchListener);
        get_contentText().setOnTouchListener(onTouchListener);
        AppMethodBeat.o(140973);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/ui/widget/MMCollapsibleTextView$measureTruncate$2$1"})
    static final class h implements Runnable {
        final /* synthetic */ int QCA;
        final /* synthetic */ MMCollapsibleTextView QCz;
        final /* synthetic */ View tCl;

        h(View view, MMCollapsibleTextView mMCollapsibleTextView, int i2) {
            this.tCl = view;
            this.QCz = mMCollapsibleTextView;
            this.QCA = i2;
        }

        public final void run() {
            AppMethodBeat.i(140952);
            Rect rect = new Rect();
            int i2 = (int) (((float) this.QCA) * 1.5f);
            MMCollapsibleTextView.a(this.QCz).getHitRect(rect);
            rect.top -= i2;
            rect.left -= i2;
            rect.bottom += i2;
            rect.right = i2 + rect.right;
            this.tCl.setTouchDelegate(new TouchDelegate(rect, MMCollapsibleTextView.a(this.QCz)));
            AppMethodBeat.o(140952);
        }
    }

    private final float getLastLineRight() {
        return this.QCs ? this.QCw : this.QCx;
    }

    private final int getLastLineHeight() {
        AppMethodBeat.i(140974);
        if (this.pMM) {
            TextView textView = get_contentBackupText();
            p.g(textView, "_contentBackupText");
            int lineHeight = textView.getLineHeight();
            AppMethodBeat.o(140974);
            return lineHeight;
        }
        MMNeat7extView mMNeat7extView = get_contentText();
        p.g(mMNeat7extView, "_contentText");
        int lineHeight2 = mMNeat7extView.getLineHeight();
        AppMethodBeat.o(140974);
        return lineHeight2;
    }

    @Override // android.support.constraint.ConstraintLayout
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(140975);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        if (this.QCf || size != this.QCv) {
            this.QCw = -1.0f;
            this.QCx = -1.0f;
            this.QCf = false;
            this.QCv = size;
            get_contentText().setMaxLines(Integer.MAX_VALUE);
            MMNeat7extView mMNeat7extView = get_contentText();
            CharSequence charSequence = this.text;
            if (charSequence == null) {
                p.btv("text");
            }
            mMNeat7extView.aw(charSequence);
            MMNeat7extView mMNeat7extView2 = get_contentText();
            p.g(mMNeat7extView2, "_contentText");
            this.pMM = mMNeat7extView2.hiS();
            com.tencent.neattextview.textview.layout.a mq = get_contentText().mq(size, Integer.MAX_VALUE);
            this.wXG = (mq != null ? mq.hiG() : 0) > this.maxLines;
            if (!this.QCg || this.wXG) {
                getFullContentPlaceHolder().setContentId(getContentText().getId());
            } else {
                getCenterContentPlaceHolder().setContentId(getContentText().getId());
            }
            if (this.wXG) {
                getCollapseButton().setOnClickListener(new l(this));
                View collapseButton = getCollapseButton();
                p.g(collapseButton, "collapseButton");
                collapseButton.setVisibility(0);
                if (!this.QCh) {
                    Placeholder leftBottomCollapsePlaceHolder = getLeftBottomCollapsePlaceHolder();
                    View collapseButton2 = getCollapseButton();
                    p.g(collapseButton2, "collapseButton");
                    leftBottomCollapsePlaceHolder.setContentId(collapseButton2.getId());
                }
                setCollapseStatus(this.QCs);
                if (this.QCh) {
                    if (this.QCi) {
                        int lastLineHeight = (int) (((float) getLastLineHeight()) * 0.8f);
                        ImageView imageView = get_collapseImage();
                        p.g(imageView, "_collapseImage");
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        layoutParams.height = lastLineHeight;
                        ImageView imageView2 = get_collapseImage();
                        p.g(imageView2, "_collapseImage");
                        imageView2.setLayoutParams(layoutParams);
                        get_collapseImage().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(lastLineHeight, 1073741824));
                        ImageView imageView3 = get_collapseImage();
                        p.g(imageView3, "_collapseImage");
                        ViewParent parent = imageView3.getParent();
                        if (!(parent instanceof View)) {
                            parent = null;
                        }
                        View view = (View) parent;
                        if (view != null) {
                            view.post(new h(view, this, lastLineHeight));
                        }
                    } else {
                        get_collapseButton().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    }
                    Resources resource = getResource();
                    p.g(resource, "resource");
                    View collapseButton3 = getCollapseButton();
                    p.g(collapseButton3, "collapseButton");
                    get_contentText().a(TextUtils.TruncateAt.END, (resource.getDisplayMetrics().density * 1.0f) + 0.5f + ((float) collapseButton3.getMeasuredWidth()));
                    if (mq != null) {
                        int i4 = this.maxLines - 1;
                        int hiG = mq.hiG() - 1;
                        this.QCw = this.pMM ? mq.getLineRight(i4) : 0.0f;
                        this.QCx = mq.getLineRight(hiG);
                    }
                    gYC();
                }
            }
            CharSequence charSequence2 = this.text;
            if (charSequence2 == null) {
                p.btv("text");
            }
            if (this.pMM) {
                TextView textView = get_contentBackupText();
                p.g(textView, "_contentBackupText");
                textView.setVisibility(0);
                MMNeat7extView mMNeat7extView3 = get_contentText();
                p.g(mMNeat7extView3, "_contentText");
                mMNeat7extView3.setVisibility(8);
                TextView textView2 = get_contentBackupText();
                p.g(textView2, "_contentBackupText");
                textView2.setText(charSequence2);
            } else {
                MMNeat7extView mMNeat7extView4 = get_contentText();
                p.g(mMNeat7extView4, "_contentText");
                mMNeat7extView4.setVisibility(0);
                TextView textView3 = get_contentBackupText();
                p.g(textView3, "_contentBackupText");
                textView3.setVisibility(8);
                get_contentText().aw(charSequence2);
            }
        }
        super.onMeasure(i2, i3);
        if (!this.wXG) {
            View collapseButton4 = getCollapseButton();
            p.g(collapseButton4, "collapseButton");
            if (collapseButton4.getVisibility() != 8) {
                View collapseButton5 = getCollapseButton();
                p.g(collapseButton5, "collapseButton");
                collapseButton5.setVisibility(8);
            }
        }
        AppMethodBeat.o(140975);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ MMCollapsibleTextView QCz;

        l(MMCollapsibleTextView mMCollapsibleTextView) {
            this.QCz = mMCollapsibleTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(140956);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MMCollapsibleTextView.b(this.QCz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(140956);
        }
    }

    public final int getCollapseButtonExpendText() {
        return this.QCy;
    }

    public final void setCollapseButtonExpendText(int i2) {
        this.QCy = i2;
    }

    private final void setCollapseStatus(boolean z) {
        AppMethodBeat.i(140976);
        if (this.QCi) {
            get_collapseImage().setImageResource(z ? R.raw.expend : R.raw.collapse);
        } else {
            get_collapseButton().setText(z ? this.QCy : R.string.b60);
        }
        setMaxLines(z ? this.maxLines : Integer.MAX_VALUE);
        AppMethodBeat.o(140976);
    }

    private final void gYC() {
        float measuredWidth;
        AppMethodBeat.i(140977);
        if (this.pMM) {
            measuredWidth = (((float) this.QCv) * 3.0f) / 4.0f;
        } else {
            int i2 = this.QCv;
            View collapseButton = getCollapseButton();
            p.g(collapseButton, "collapseButton");
            measuredWidth = (float) (i2 - collapseButton.getMeasuredWidth());
        }
        if (getLastLineRight() < measuredWidth) {
            Placeholder rightCollapsePlaceHolder = getRightCollapsePlaceHolder();
            p.g(rightCollapsePlaceHolder, "rightCollapsePlaceHolder");
            ViewGroup.LayoutParams layoutParams = rightCollapsePlaceHolder.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(140977);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int lastLineHeight = getLastLineHeight();
            View collapseButton2 = getCollapseButton();
            p.g(collapseButton2, "collapseButton");
            marginLayoutParams.bottomMargin = (Math.max(0, lastLineHeight - collapseButton2.getMeasuredHeight()) / 2) + 1;
            Placeholder rightCollapsePlaceHolder2 = getRightCollapsePlaceHolder();
            p.g(rightCollapsePlaceHolder2, "rightCollapsePlaceHolder");
            rightCollapsePlaceHolder2.setLayoutParams(marginLayoutParams);
            getRightBottomCollapsePlaceHolder().setContentId(-1);
            Placeholder rightCollapsePlaceHolder3 = getRightCollapsePlaceHolder();
            View collapseButton3 = getCollapseButton();
            p.g(collapseButton3, "collapseButton");
            rightCollapsePlaceHolder3.setContentId(collapseButton3.getId());
            getRightCollapsePlaceHolder().updatePreLayout(this);
            AppMethodBeat.o(140977);
            return;
        }
        getRightCollapsePlaceHolder().setContentId(-1);
        Placeholder rightBottomCollapsePlaceHolder = getRightBottomCollapsePlaceHolder();
        View collapseButton4 = getCollapseButton();
        p.g(collapseButton4, "collapseButton");
        rightBottomCollapsePlaceHolder.setContentId(collapseButton4.getId());
        getRightBottomCollapsePlaceHolder().updatePreLayout(this);
        AppMethodBeat.o(140977);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(140978);
        p.h(charSequence, "text");
        p.h(charSequence, "text");
        this.text = charSequence;
        this.QCf = true;
        AppMethodBeat.o(140978);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<Resources> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Resources invoke() {
            AppMethodBeat.i(140953);
            Context context = this.QCz.getContext();
            p.g(context, "context");
            Resources resources = context.getResources();
            AppMethodBeat.o(140953);
            return resources;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<MMNeat7extView> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMNeat7extView invoke() {
            AppMethodBeat.i(140948);
            MMNeat7extView mMNeat7extView = (MMNeat7extView) this.QCz.findViewById(R.id.bfe);
            AppMethodBeat.o(140948);
            return mMNeat7extView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(140947);
            TextView textView = (TextView) this.QCz.findViewById(R.id.bek);
            AppMethodBeat.o(140947);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(140945);
            TextView textView = (TextView) this.QCz.findViewById(R.id.b5p);
            AppMethodBeat.o(140945);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(140946);
            ImageView imageView = (ImageView) this.QCz.findViewById(R.id.b5o);
            AppMethodBeat.o(140946);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Placeholder> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Placeholder invoke() {
            AppMethodBeat.i(140950);
            Placeholder placeholder = (Placeholder) this.QCz.findViewById(R.id.gc9);
            AppMethodBeat.o(140950);
            return placeholder;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Placeholder> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Placeholder invoke() {
            AppMethodBeat.i(140949);
            Placeholder placeholder = (Placeholder) this.QCz.findViewById(R.id.gc8);
            AppMethodBeat.o(140949);
            return placeholder;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Placeholder> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Placeholder invoke() {
            AppMethodBeat.i(140951);
            Placeholder placeholder = (Placeholder) this.QCz.findViewById(R.id.gc5);
            AppMethodBeat.o(140951);
            return placeholder;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends q implements kotlin.g.a.a<Placeholder> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Placeholder invoke() {
            AppMethodBeat.i(140954);
            Placeholder placeholder = (Placeholder) this.QCz.findViewById(R.id.gc7);
            AppMethodBeat.o(140954);
            return placeholder;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends q implements kotlin.g.a.a<Placeholder> {
        final /* synthetic */ MMCollapsibleTextView QCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MMCollapsibleTextView mMCollapsibleTextView) {
            super(0);
            this.QCz = mMCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Placeholder invoke() {
            AppMethodBeat.i(140955);
            Placeholder placeholder = (Placeholder) this.QCz.findViewById(R.id.gc6);
            AppMethodBeat.o(140955);
            return placeholder;
        }
    }

    public static final /* synthetic */ void b(MMCollapsibleTextView mMCollapsibleTextView) {
        AppMethodBeat.i(140982);
        mMCollapsibleTextView.QCs = !mMCollapsibleTextView.QCs;
        if (mMCollapsibleTextView.QCs) {
            kotlin.g.a.a<x> aVar = mMCollapsibleTextView.QCt;
            if (aVar != null) {
                aVar.invoke();
            }
        } else {
            kotlin.g.a.a<x> aVar2 = mMCollapsibleTextView.QCu;
            if (aVar2 != null) {
                aVar2.invoke();
            }
        }
        mMCollapsibleTextView.setCollapseStatus(mMCollapsibleTextView.QCs);
        if (mMCollapsibleTextView.wXG && mMCollapsibleTextView.QCh) {
            mMCollapsibleTextView.gYC();
        }
        AppMethodBeat.o(140982);
    }
}
