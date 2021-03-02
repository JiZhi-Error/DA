package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int gwi = Color.argb(0, 0, 0, 0);
    private final ArrayList<b> gwj = new ArrayList<>();
    private ak gwk;
    private a gwl;
    private int gwm;
    private boolean gwn;
    private int gwo = -1;
    private int gwp = -1;
    private ImageButton gwq;
    private final Paint mPaint = new Paint();

    public interface a {
    }

    static {
        AppMethodBeat.i(12655);
        AppMethodBeat.o(12655);
    }

    static class b {
        public int color;
        public Rect rect;

        public b(Rect rect2, int i2) {
            this.rect = rect2;
            this.color = i2;
        }
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(12650);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.gwk = new ak(this);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.gwm = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.layout.ua, this);
        AppMethodBeat.o(12650);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(12651);
        super.onFinishInflate();
        this.gwq = (ImageButton) findViewById(R.id.af5);
        this.gwq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(12649);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LargeTouchableAreasItemView.this.setItemViewSelected(!LargeTouchableAreasItemView.this.gwn);
                if (LargeTouchableAreasItemView.this.gwl != null) {
                    a unused = LargeTouchableAreasItemView.this.gwl;
                    boolean unused2 = LargeTouchableAreasItemView.this.gwn;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12649);
            }
        });
        AppMethodBeat.o(12651);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(12652);
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (!(i6 == this.gwo && i7 == this.gwp)) {
            this.gwo = i6;
            this.gwp = i7;
            ak akVar = this.gwk;
            if (akVar.OLC != null) {
                akVar.OLC.clear();
            }
            akVar.OLD = null;
            Rect rect = new Rect((i6 - this.gwq.getWidth()) - this.gwm, 0, i6, i7);
            int i8 = gwi;
            this.gwk.a(new al(rect, this.gwq));
            this.gwj.add(new b(rect, i8));
            setTouchDelegate(this.gwk);
        }
        AppMethodBeat.o(12652);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(12653);
        Iterator<b> it = this.gwj.iterator();
        while (it.hasNext()) {
            b next = it.next();
            this.mPaint.setColor(next.color);
            canvas.drawRect(next.rect, this.mPaint);
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.o(12653);
    }

    public void setItemViewSelected(boolean z) {
        AppMethodBeat.i(12654);
        if (this.gwn != z) {
            this.gwn = z;
            this.gwq.setImageResource(this.gwn ? R.raw.checkbox_selected : R.drawable.p5);
        }
        AppMethodBeat.o(12654);
    }

    public boolean getSelected() {
        return this.gwn;
    }

    public void setOnLargeTouchableAreasListener(a aVar) {
        this.gwl = aVar;
    }
}
