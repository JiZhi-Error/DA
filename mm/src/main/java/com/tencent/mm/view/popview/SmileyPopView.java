package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.b;
import com.tencent.mm.ce.e;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/view/popview/SmileyPopView;", "Lcom/tencent/mm/view/popview/AbstractPopView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "descView", "Landroid/widget/TextView;", "popBottomWidth", "popLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "preview", "Landroid/widget/ImageView;", "previewFrame", "Landroid/view/View;", "getWindowLayoutParams", "setSmileyItem", "", "item", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "updateWindowLayoutParams", "anchor", "Companion", "plugin-emojisdk_release"})
public final class SmileyPopView extends AbstractPopView {
    public static final a Rqy = new a((byte) 0);
    private final WindowManager.LayoutParams Rqm;
    private View Rqv;
    private ImageView Rqw;
    private int Rqx;
    private h gVb;
    private TextView xVY;

    static {
        AppMethodBeat.i(200105);
        AppMethodBeat.o(200105);
    }

    public SmileyPopView(Context context) {
        this(context, null, 6, (byte) 0);
    }

    public SmileyPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ SmileyPopView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(200104);
        AppMethodBeat.o(200104);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmileyPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(105305);
        AbstractPopView.inflate(context, R.layout.a2f, this);
        this.Rqv = findViewById(R.id.htk);
        this.Rqw = (ImageView) findViewById(R.id.c13);
        this.xVY = (TextView) findViewById(R.id.c12);
        this.Rqm = new WindowManager.LayoutParams(2, 264, 1);
        this.Rqx = getResources().getDimensionPixelOffset(R.dimen.ajq);
        this.Rqm.width = context.getResources().getDimensionPixelSize(R.dimen.ajp);
        this.Rqm.height = context.getResources().getDimensionPixelSize(R.dimen.ajn);
        this.Rqm.gravity = 49;
        AppMethodBeat.o(105305);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/popview/SmileyPopView$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setSmileyItem(com.tencent.mm.emoji.b.p pVar) {
        T t;
        String sb;
        AppMethodBeat.i(105306);
        p.h(pVar, "item");
        String bie = e.gxR().bie(pVar.key);
        String bib = b.gxI().bib(bie);
        Log.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", pVar.key, bie, bib);
        p.g(bib, "desc");
        int a2 = n.a((CharSequence) bib, "[", 0, false, 6);
        int a3 = n.a((CharSequence) bib, "]", 0, false, 6);
        if (a3 == -1) {
            a3 = bib.length();
        }
        String substring = bib.substring(a2 + 1, a3);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        TextView textView = this.xVY;
        if (textView != null) {
            textView.setText(substring);
        }
        f.a aVar = f.gVz;
        Iterator<T> it = f.gVy.gUV.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.key, pVar.key)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            sb = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            com.tencent.mm.emoji.e.a aVar2 = com.tencent.mm.emoji.e.a.hdT;
            sb = sb2.append(com.tencent.mm.emoji.e.a.aww()).append(t2.gUW).toString();
        }
        h hVar = this.gVb;
        if (hVar != null) {
            hVar.recycle();
        }
        this.gVb = null;
        if (s.YS(sb)) {
            try {
                this.gVb = new h(s.aW(sb, 0, -1));
            } catch (Exception e2) {
                if (e2 instanceof MMGIFException) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(711, 22);
                }
            }
            ImageView imageView = this.Rqw;
            if (imageView != null) {
                imageView.setImageDrawable(this.gVb);
            }
            h hVar2 = this.gVb;
            if (hVar2 != null) {
                hVar2.resume();
                AppMethodBeat.o(105306);
                return;
            }
            AppMethodBeat.o(105306);
            return;
        }
        ImageView imageView2 = this.Rqw;
        if (imageView2 != null) {
            e.gxR();
            imageView2.setImageDrawable(e.bid(pVar.key));
        }
        StringBuilder append = new StringBuilder("setSmileyItem: ").append(pVar.key).append(", ");
        f.a aVar3 = f.gVz;
        Log.i("MicroMsg.SmileyPopView", append.append(f.gVy.gUV.size()).toString());
        if (t2 != null) {
            f.a aVar4 = f.gVz;
            f.a.auz();
        }
        AppMethodBeat.o(105306);
    }

    @Override // com.tencent.mm.view.popview.AbstractPopView
    public final WindowManager.LayoutParams getWindowLayoutParams() {
        return this.Rqm;
    }

    @Override // com.tencent.mm.view.popview.AbstractPopView
    public final void hI(View view) {
        AppMethodBeat.i(105307);
        p.h(view, "anchor");
        kO(view.getContext());
        view.setPressed(false);
        view.setSelected(false);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Resources resources = getResources();
        p.g(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        int measuredWidth = iArr[0] + (view.getMeasuredWidth() / 2);
        int i3 = (this.Rqm.width - this.Rqx) / 2;
        this.Rqm.y = ((iArr[1] - this.Rqm.height) + view.getMeasuredHeight()) - this.Rqa;
        if (measuredWidth < this.Rqm.width / 2) {
            View view2 = this.Rqv;
            if (view2 == null) {
                p.hyc();
            }
            view2.setBackground(at.aN(getContext(), R.attr.kn));
            this.Rqm.x = (measuredWidth + i3) - (i2 / 2);
            AppMethodBeat.o(105307);
        } else if ((this.Rqm.width / 2) + measuredWidth > i2) {
            View view3 = this.Rqv;
            if (view3 == null) {
                p.hyc();
            }
            view3.setBackground(at.aN(getContext(), R.attr.ko));
            this.Rqm.x = (measuredWidth - i3) - (i2 / 2);
            AppMethodBeat.o(105307);
        } else {
            View view4 = this.Rqv;
            if (view4 == null) {
                p.hyc();
            }
            view4.setBackground(at.aN(getContext(), R.attr.km));
            this.Rqm.x = measuredWidth - (i2 / 2);
            AppMethodBeat.o(105307);
        }
    }
}
