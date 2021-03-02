package com.tencent.mm.ui.chatting.gallery.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0014J\u0010\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0012J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tJ\u0016\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tJ\u0010\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\tJ\u0006\u00101\u001a\u00020\u001dJ\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorViewPosition", "Landroid/graphics/Point;", "anchorViewSize", "bubbleMinWidth", "bubbleTextView", "Landroid/widget/TextView;", "bubbleTriangle", "Landroid/view/View;", "bubbleTriangleWidth", "bubbleViewContainer", "Landroid/view/ViewGroup;", "bubbleViewContainerRightMargin", "bubbleWidth", "mAnchor", "pendingShow", "", "viewWidth", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "anchorView", "setAnchorViewPosition", "x", "y", "setAnchorViewSize", "width", "height", "setBubbleClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBubbleText", "text", "", "setViewWidth", "show", "showByPosition", "showIfNeed", "Companion", "app_release"})
public final class SearchImageBubbleView extends LinearLayout {
    public static final a PDu = new a((byte) 0);
    private boolean CCL;
    private ViewGroup PDl;
    private TextView PDm;
    private View PDn;
    private Point PDo;
    private Point PDp;
    private int PDq;
    private int PDr;
    private int PDs;
    private int PDt;
    private View azy;
    private int gRD;

    static {
        AppMethodBeat.i(231321);
        AppMethodBeat.o(231321);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchImageBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(231319);
        AppMethodBeat.o(231319);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchImageBubbleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(231320);
        this.CCL = true;
        this.PDo = new Point(0, 0);
        this.PDp = new Point(0, 0);
        View inflate = LayoutInflater.from(context).inflate(R.layout.avq, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.he8);
        p.g(findViewById, "view.findViewById(R.id.s…h_image_bubble_container)");
        this.PDl = (ViewGroup) findViewById;
        View findViewById2 = inflate.findViewById(R.id.he9);
        p.g(findViewById2, "view.findViewById(R.id.search_image_bubble_tips)");
        this.PDm = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.aff);
        p.g(findViewById3, "view.findViewById(R.id.bubble_triangle)");
        this.PDn = findViewById3;
        this.PDs = getResources().getDimensionPixelSize(R.dimen.ww);
        this.PDr = getResources().getDimensionPixelSize(R.dimen.wt);
        AppMethodBeat.o(231320);
    }

    public final void setAnchorView(View view) {
        this.azy = view;
    }

    public final void lj(int i2, int i3) {
        this.PDo.x = i2;
        this.PDo.y = i3;
    }

    public final void setAnchorViewPosition$255f295(int i2) {
        this.PDp.x = i2;
        this.PDp.y = 0;
    }

    public final void setBubbleText(String str) {
        AppMethodBeat.i(231314);
        p.h(str, "text");
        TextView textView = this.PDm;
        if (textView == null) {
            p.btv("bubbleTextView");
        }
        textView.setText(str);
        AppMethodBeat.o(231314);
    }

    public final void setViewWidth(int i2) {
        this.gRD = i2;
    }

    public final void setBubbleClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(231315);
        TextView textView = this.PDm;
        if (textView == null) {
            p.btv("bubbleTextView");
        }
        textView.setOnClickListener(onClickListener);
        AppMethodBeat.o(231315);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(231316);
        super.onMeasure(i2, i3);
        if (this.azy != null) {
            Point point = this.PDp;
            View view = this.azy;
            if (view == null) {
                p.hyc();
            }
            point.x = (int) view.getX();
            Point point2 = this.PDp;
            View view2 = this.azy;
            if (view2 == null) {
                p.hyc();
            }
            point2.y = (int) view2.getY();
            Object[] objArr = new Object[3];
            objArr[0] = this.PDp;
            TextView textView = this.PDm;
            if (textView == null) {
                p.btv("bubbleTextView");
            }
            objArr[1] = Integer.valueOf(textView.getMeasuredWidth());
            objArr[2] = Integer.valueOf(getMeasuredWidth());
            Log.v("MicroMsg.SearchImageBubbleView", "alvinluo onMeasure anchorViewPos: %s, %d, %d", objArr);
            if (this.PDp.x > 0) {
                TextView textView2 = this.PDm;
                if (textView2 == null) {
                    p.btv("bubbleTextView");
                }
                if (textView2.getMeasuredWidth() >= 0 && getMeasuredWidth() > 0) {
                    this.gRD = getMeasuredWidth();
                    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showIfNeed pendingShow: %b", Boolean.valueOf(this.CCL));
                    if (this.CCL) {
                        this.CCL = false;
                        gTC();
                    }
                }
            }
        }
        AppMethodBeat.o(231316);
    }

    public final void show() {
        AppMethodBeat.i(231317);
        TextView textView = this.PDm;
        if (textView == null) {
            p.btv("bubbleTextView");
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        TextView textView2 = this.PDm;
        if (textView2 == null) {
            p.btv("bubbleTextView");
        }
        this.PDq = textView2.getMeasuredWidth();
        Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showBubbleView bubbleWidth: %d", Integer.valueOf(this.PDq));
        if (this.PDp.x > 0) {
            gTC();
            AppMethodBeat.o(231317);
            return;
        }
        setVisibility(4);
        this.CCL = true;
        AppMethodBeat.o(231317);
    }

    private final void gTC() {
        AppMethodBeat.i(231318);
        setVisibility(0);
        z.d dVar = new z.d();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            this.PDt = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showByPosition anchorViewPosition: %s, anchorViewSize: %s, bubbleWidth: %d, viewWidth: %d, bubbleRightMargin: %d", this.PDp, this.PDo, Integer.valueOf(this.PDq), Integer.valueOf(this.gRD), Integer.valueOf(this.PDt));
        TextView textView = this.PDm;
        if (textView == null) {
            p.btv("bubbleTextView");
        }
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            int i2 = this.PDp.x + (this.PDo.x / 2);
            if (this.PDq <= this.PDr || (this.PDq + i2) - (this.PDr / 2) <= this.gRD - this.PDt) {
                dVar.SYE = i2 - (this.PDq / 2);
            } else {
                dVar.SYE = (this.gRD - this.PDq) - this.PDt;
                dVar.SYE = (int) Math.max(((float) this.gRD) / 3.0f, (float) dVar.SYE);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin != dVar.SYE) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = dVar.SYE;
            }
        }
        View view = this.PDn;
        if (view == null) {
            p.btv("bubbleTriangle");
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                dVar.SYE = Math.max(0, (this.PDp.x + (this.PDo.x / 2)) - (this.PDs / 2));
                if (((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin != dVar.SYE) {
                    ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = dVar.SYE;
                }
            }
            AppMethodBeat.o(231318);
            return;
        }
        AppMethodBeat.o(231318);
    }
}
