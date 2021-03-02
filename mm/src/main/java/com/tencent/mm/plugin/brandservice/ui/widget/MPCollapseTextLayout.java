package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\r\u0018\u0000 J2\u00020\u0001:\u0002IJB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\tH\u0002J\u0018\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020\tH\u0002J\"\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010*\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u0004\u0018\u00010\u000eJ\b\u00103\u001a\u0004\u0018\u00010\u0018J\u0012\u00104\u001a\u00020&2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0014J*\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020\fJ\u000e\u0010C\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010D\u001a\u00020&2\u0006\u0010=\u001a\u00020>J\u0016\u0010D\u001a\u00020&2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\fJ.\u0010D\u001a\u00020&2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0015J\u000e\u0010E\u001a\u00020&2\u0006\u0010@\u001a\u00020\fJ\u000e\u0010F\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0013J\u000e\u0010G\u001a\u00020&2\u0006\u0010'\u001a\u00020\tJ\b\u0010H\u001a\u00020&H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout extends RelativeLayout {
    public static final b pMS = new b((byte) 0);
    private int aYN;
    private String mContent = "";
    private Context mContext;
    private boolean pMC;
    private boolean pMD;
    private int pME = 5;
    private a pMF;
    private MMNeat7extView pMG;
    private TextView pMH;
    private int pMI;
    private int pMJ;
    private int pMK;
    private boolean pML;
    private boolean pMM;
    private int pMN;
    private String pMO = "";
    private String pMP = "";
    private boolean pMQ;
    private Runnable pMR;
    private TextView pyh;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "", "onCollapse", "", "showLines", "", "onExpand", "onMeasured", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "plugin-brandservice_release"})
    public interface a {
    }

    static {
        AppMethodBeat.i(7382);
        AppMethodBeat.o(7382);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPCollapseTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(7380);
        this.mContext = context;
        crl();
        AppMethodBeat.o(7380);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPCollapseTextLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(7381);
        this.mContext = context;
        crl();
        AppMethodBeat.o(7381);
    }

    private final void crl() {
        AppMethodBeat.i(7369);
        setClipChildren(false);
        setClipToPadding(false);
        View inflate = aa.jQ(this.mContext).inflate(R.layout.ayt, this);
        this.pMG = (MMNeat7extView) inflate.findViewById(R.id.bfe);
        this.pyh = (TextView) inflate.findViewById(R.id.b5p);
        this.pMH = (TextView) inflate.findViewById(R.id.bff);
        TextView textView = this.pyh;
        if (textView != null) {
            textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        this.pMJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 30);
        TextView textView2 = this.pyh;
        this.pMI = textView2 != null ? textView2.getMeasuredWidth() : this.pMJ;
        this.pMN = (int) (com.tencent.mm.cb.a.getDensity(this.mContext) * 2.5f);
        this.pMK = getResources().getDimensionPixelSize(R.dimen.kb);
        String string = this.mContext.getResources().getString(R.string.aia);
        p.g(string, "mContext.resources.getSt…_line_item_text_collapse)");
        this.pMO = string;
        String string2 = this.mContext.getResources().getString(R.string.aic);
        p.g(string2, "mContext.resources.getSt…time_line_item_text_more)");
        this.pMP = string2;
        AppMethodBeat.o(7369);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(7370);
        super.onMeasure(i2, i3);
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYN));
        if (this.aYN != getMeasuredWidth()) {
            this.aYN = getMeasuredWidth();
            if (this.pMQ) {
                Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
                this.pMQ = false;
                a(this.pMC, this.pMD, this.pMF);
            }
        }
        AppMethodBeat.o(7370);
    }

    public final void setMaxLines(int i2) {
        this.pME = i2;
    }

    public final void setCollapseButtonHideWhenExpanded(boolean z) {
        this.pML = z;
    }

    public final MMNeat7extView getContextTextView() {
        return this.pMG;
    }

    public final TextView getCollapseButton() {
        return this.pyh;
    }

    public final void setCollapseText(String str) {
        AppMethodBeat.i(7371);
        p.h(str, "collapseText");
        this.pMO = str;
        AppMethodBeat.o(7371);
    }

    public final void setExpandText(String str) {
        AppMethodBeat.i(7372);
        p.h(str, "expandText");
        this.pMP = str;
        AppMethodBeat.o(7372);
    }

    public final void setEnableExpand(boolean z) {
        this.pMD = z;
    }

    public final void setContent(CharSequence charSequence) {
        MMNeat7extView mMNeat7extView;
        AppMethodBeat.i(7373);
        p.h(charSequence, "content");
        p.h(charSequence, "content");
        p.h(charSequence, "content");
        if (!this.mContent.equals(charSequence) || this.pMC || this.pMD) {
            this.mContent = charSequence.toString();
            MMNeat7extView mMNeat7extView2 = this.pMG;
            if (mMNeat7extView2 != null) {
                mMNeat7extView2.setMaxLines(this.pME);
            }
            MMNeat7extView mMNeat7extView3 = this.pMG;
            if (mMNeat7extView3 != null) {
                mMNeat7extView3.aw(charSequence);
            }
            TextView textView = this.pMH;
            if (textView != null) {
                textView.setMaxLines(this.pME);
            }
            TextView textView2 = this.pMH;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
            MMNeat7extView mMNeat7extView4 = this.pMG;
            this.pMM = mMNeat7extView4 != null ? mMNeat7extView4.hiS() : false;
            this.pMC = false;
            this.pMD = false;
            this.pMF = null;
            if (!(this.pMR == null || (mMNeat7extView = this.pMG) == null)) {
                mMNeat7extView.removeCallbacks(this.pMR);
            }
            if (this.aYN != 0) {
                this.pMQ = false;
                a(false, false, (a) null);
                AppMethodBeat.o(7373);
                return;
            }
            this.pMQ = true;
            AppMethodBeat.o(7373);
            return;
        }
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", this.mContent, charSequence);
        AppMethodBeat.o(7373);
    }

    private final void a(boolean z, boolean z2, a aVar) {
        int i2;
        AppMethodBeat.i(7374);
        MMNeat7extView mMNeat7extView = this.pMG;
        com.tencent.neattextview.textview.layout.a mq = mMNeat7extView != null ? mMNeat7extView.mq(this.aYN, Integer.MAX_VALUE) : null;
        if (mq != null) {
            i2 = mq.hiG();
        } else {
            i2 = 0;
        }
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", Integer.valueOf(this.aYN), Integer.valueOf(i2), Boolean.valueOf(this.pMM), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(hashCode()));
        crm();
        if (i2 > this.pME) {
            if (!z) {
                DY(this.pME);
            }
            TextView textView = this.pyh;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (z) {
                a(mq, this.aYN, i2);
            } else {
                DX(this.aYN);
            }
            if (z2) {
                TextView textView2 = this.pyh;
                if (textView2 != null) {
                    textView2.setOnClickListener(new f(this, i2, aVar));
                    AppMethodBeat.o(7374);
                    return;
                }
                AppMethodBeat.o(7374);
                return;
            }
        } else {
            DY(Integer.MAX_VALUE);
            TextView textView3 = this.pyh;
            if (textView3 != null) {
                textView3.setVisibility(8);
                AppMethodBeat.o(7374);
                return;
            }
        }
        AppMethodBeat.o(7374);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ MPCollapseTextLayout pMT;
        final /* synthetic */ int pMU;
        final /* synthetic */ a pMV;

        f(MPCollapseTextLayout mPCollapseTextLayout, int i2, a aVar) {
            this.pMT = mPCollapseTextLayout;
            this.pMU = i2;
            this.pMV = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7368);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.pMT.pMC) {
                MPCollapseTextLayout.b(this.pMT);
            } else {
                MPCollapseTextLayout.c(this.pMT);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7368);
        }
    }

    private final void DX(int i2) {
        float f2;
        AppMethodBeat.i(7375);
        if (this.pMG == null) {
            AppMethodBeat.o(7375);
            return;
        }
        this.pMC = false;
        TextView textView = this.pyh;
        if (textView != null) {
            textView.setText(this.pMP);
        }
        boolean z = this.pMM;
        MMNeat7extView mMNeat7extView = this.pMG;
        com.tencent.neattextview.textview.layout.a mq = mMNeat7extView != null ? mMNeat7extView.mq(i2, Integer.MAX_VALUE) : null;
        if (mq != null) {
            f2 = mq.getLineRight(this.pME - 1);
        } else {
            f2 = 0.0f;
        }
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(this.pMI), this.mContent);
        if (a(f2, i2)) {
            if (!z) {
                MMNeat7extView mMNeat7extView2 = this.pMG;
                if (mMNeat7extView2 != null) {
                    mMNeat7extView2.a(TextUtils.TruncateAt.END, 0.0f);
                }
            } else {
                post(new c(this));
            }
        } else if (!z) {
            float max = (((float) this.pMI) + ((float) this.pMK)) - Math.max(((float) i2) - f2, 0.0f);
            MMNeat7extView mMNeat7extView3 = this.pMG;
            if (mMNeat7extView3 != null) {
                mMNeat7extView3.a(TextUtils.TruncateAt.END, max);
            }
            Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", Float.valueOf(max));
            post(new d(this));
        } else {
            post(new e(this));
            AppMethodBeat.o(7375);
            return;
        }
        TextView textView2 = this.pyh;
        ViewGroup.LayoutParams layoutParams = textView2 != null ? textView2.getLayoutParams() : null;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        }
        AppMethodBeat.o(7375);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ MPCollapseTextLayout pMT;

        c(MPCollapseTextLayout mPCollapseTextLayout) {
            this.pMT = mPCollapseTextLayout;
        }

        public final void run() {
            AppMethodBeat.i(7365);
            TextView textView = this.pMT.pMH;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.pMT.pMH;
            if (textView2 != null) {
                textView2.setText(this.pMT.mContent);
                AppMethodBeat.o(7365);
                return;
            }
            AppMethodBeat.o(7365);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ MPCollapseTextLayout pMT;

        d(MPCollapseTextLayout mPCollapseTextLayout) {
            this.pMT = mPCollapseTextLayout;
        }

        public final void run() {
            AppMethodBeat.i(7366);
            MMNeat7extView mMNeat7extView = this.pMT.pMG;
            if (mMNeat7extView != null) {
                mMNeat7extView.requestLayout();
                AppMethodBeat.o(7366);
                return;
            }
            AppMethodBeat.o(7366);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ MPCollapseTextLayout pMT;

        e(MPCollapseTextLayout mPCollapseTextLayout) {
            this.pMT = mPCollapseTextLayout;
        }

        public final void run() {
            AppMethodBeat.i(7367);
            MPCollapseTextLayout.g(this.pMT);
            AppMethodBeat.o(7367);
        }
    }

    private final void a(com.tencent.neattextview.textview.layout.a aVar, int i2, int i3) {
        int i4;
        AppMethodBeat.i(7376);
        if (this.pML) {
            TextView textView = this.pyh;
            if (textView != null) {
                textView.setVisibility(8);
                AppMethodBeat.o(7376);
                return;
            }
            AppMethodBeat.o(7376);
        } else if (aVar == null) {
            AppMethodBeat.o(7376);
        } else {
            this.pMC = true;
            TextView textView2 = this.pyh;
            if (textView2 != null) {
                textView2.setText(this.pMO);
            }
            TextView textView3 = this.pyh;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            float lineRight = aVar.getLineRight(i3 - 1);
            Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.pME), Float.valueOf(lineRight));
            TextView textView4 = this.pyh;
            ViewGroup.LayoutParams layoutParams = textView4 != null ? textView4.getLayoutParams() : null;
            if (!(layoutParams instanceof RelativeLayout.LayoutParams) || a(lineRight, i2)) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                }
                AppMethodBeat.o(7376);
                return;
            }
            Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.pMM) {
                i4 = R.id.bff;
            } else {
                i4 = R.id.bfe;
            }
            layoutParams2.addRule(3, i4);
            AppMethodBeat.o(7376);
        }
    }

    private final void DY(int i2) {
        AppMethodBeat.i(7377);
        if (!this.pMM) {
            MMNeat7extView mMNeat7extView = this.pMG;
            if (mMNeat7extView != null) {
                mMNeat7extView.setMaxLines(i2);
                AppMethodBeat.o(7377);
                return;
            }
            AppMethodBeat.o(7377);
            return;
        }
        TextView textView = this.pMH;
        if (textView != null) {
            textView.setMaxLines(i2);
            AppMethodBeat.o(7377);
            return;
        }
        AppMethodBeat.o(7377);
    }

    private final void crm() {
        AppMethodBeat.i(7378);
        if (!this.pMM) {
            MMNeat7extView mMNeat7extView = this.pMG;
            if (mMNeat7extView != null) {
                mMNeat7extView.setVisibility(0);
            }
            TextView textView = this.pMH;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.pyh;
            if (textView2 != null) {
                textView2.setPadding(0, 0, 0, this.pMN);
                AppMethodBeat.o(7378);
                return;
            }
            AppMethodBeat.o(7378);
            return;
        }
        MMNeat7extView mMNeat7extView2 = this.pMG;
        if (mMNeat7extView2 != null) {
            mMNeat7extView2.setVisibility(8);
        }
        TextView textView3 = this.pMH;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.pyh;
        if (textView4 != null) {
            textView4.setPadding(0, 0, 0, 0);
            AppMethodBeat.o(7378);
            return;
        }
        AppMethodBeat.o(7378);
    }

    private final boolean a(float f2, int i2) {
        AppMethodBeat.i(7379);
        TextView textView = this.pyh;
        this.pMI = textView != null ? textView.getMeasuredWidth() : this.pMJ;
        float f3 = (float) (i2 - this.pMI);
        if (this.pMM) {
            f3 = (((float) i2) * 3.0f) / 4.0f;
        }
        if (f2 < f3) {
            AppMethodBeat.o(7379);
            return true;
        }
        AppMethodBeat.o(7379);
        return false;
    }

    public static final /* synthetic */ void b(MPCollapseTextLayout mPCollapseTextLayout) {
        int i2;
        AppMethodBeat.i(7383);
        MMNeat7extView mMNeat7extView = mPCollapseTextLayout.pMG;
        if (mMNeat7extView != null) {
            mMNeat7extView.setMaxLines(Integer.MAX_VALUE);
        }
        TextView textView = mPCollapseTextLayout.pMH;
        if (textView != null) {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
        MMNeat7extView mMNeat7extView2 = mPCollapseTextLayout.pMG;
        com.tencent.neattextview.textview.layout.a mq = mMNeat7extView2 != null ? mMNeat7extView2.mq(mPCollapseTextLayout.aYN, Integer.MAX_VALUE) : null;
        int i3 = mPCollapseTextLayout.aYN;
        if (mq != null) {
            i2 = mq.hiG();
        } else {
            i2 = 0;
        }
        mPCollapseTextLayout.a(mq, i3, i2);
        AppMethodBeat.o(7383);
    }

    public static final /* synthetic */ void c(MPCollapseTextLayout mPCollapseTextLayout) {
        AppMethodBeat.i(7384);
        mPCollapseTextLayout.DY(mPCollapseTextLayout.pME);
        mPCollapseTextLayout.DX(mPCollapseTextLayout.aYN);
        AppMethodBeat.o(7384);
    }

    public static final /* synthetic */ void g(MPCollapseTextLayout mPCollapseTextLayout) {
        ViewParent parent;
        AppMethodBeat.i(7385);
        Log.d("MicroMsg.MPCollapseTextLayout", "alvinluo collapseSpeicalText");
        TextView textView = mPCollapseTextLayout.pMH;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = mPCollapseTextLayout.pMH;
        if (textView2 != null) {
            textView2.setMaxLines(mPCollapseTextLayout.pME);
        }
        TextView textView3 = mPCollapseTextLayout.pMH;
        if (textView3 != null) {
            textView3.setText(mPCollapseTextLayout.mContent);
        }
        TextView textView4 = mPCollapseTextLayout.pyh;
        if (textView4 != null) {
            textView4.setPadding(0, 0, 0, 0);
        }
        MMNeat7extView mMNeat7extView = mPCollapseTextLayout.pMG;
        if (mMNeat7extView != null) {
            mMNeat7extView.setVisibility(8);
        }
        TextView textView5 = mPCollapseTextLayout.pyh;
        ViewGroup.LayoutParams layoutParams = textView5 != null ? textView5.getLayoutParams() : null;
        if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
            ((RelativeLayout.LayoutParams) layoutParams).addRule(3, R.id.bff);
        }
        TextView textView6 = mPCollapseTextLayout.pyh;
        if (textView6 == null || (parent = textView6.getParent()) == null) {
            AppMethodBeat.o(7385);
            return;
        }
        parent.requestLayout();
        AppMethodBeat.o(7385);
    }
}
