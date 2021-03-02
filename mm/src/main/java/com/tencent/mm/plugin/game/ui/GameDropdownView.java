package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements View.OnClickListener, PopupWindow.OnDismissListener {
    private Context mContext;
    private View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDropdownView.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(42084);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (GameDropdownView.this.xRU.getContentView() == null || !(GameDropdownView.this.xRU.getContentView() instanceof ViewGroup)) {
                GameDropdownView.this.xRU.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42084);
                return;
            }
            GameDropdownView.a(GameDropdownView.this, ((ViewGroup) GameDropdownView.this.xRU.getContentView()).indexOfChild(view));
            GameDropdownView.this.xRU.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42084);
        }
    };
    private b xRU;
    private LinkedList<String> xRV;
    private int xRW = 0;
    private int xRX = 0;
    private a xRY = null;
    private View xRZ = null;

    public interface a {
        void Ov(int i2);
    }

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i2) {
        AppMethodBeat.i(42092);
        gameDropdownView.setCurrentSelection(i2);
        AppMethodBeat.o(42092);
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42087);
        this.mContext = context;
        this.xRU = new b(context);
        setOnClickListener(this);
        AppMethodBeat.o(42087);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42088);
        super.onFinishInflate();
        setVisibility(8);
        AppMethodBeat.o(42088);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42089);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xRU.isShowing()) {
            this.xRU.dismiss();
        } else if (this.xRZ == null) {
            this.xRU.showAsDropDown(this);
        } else {
            this.xRU.showAsDropDown(this.xRZ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42089);
    }

    public void onDismiss() {
    }

    public void setAnchorView(View view) {
        this.xRZ = view;
    }

    public final void g(LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(42090);
        if (linkedList.size() == 0) {
            Log.i("MicroMsg.GameDropdownView", "No menu item");
            AppMethodBeat.o(42090);
            return;
        }
        this.xRV = linkedList;
        this.xRX = linkedList.size() - 1;
        if (i2 < 0 || i2 > this.xRX) {
            this.xRW = 0;
        } else {
            this.xRW = i2;
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.ar5, (ViewGroup) null);
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            String str = linkedList.get(i3);
            TextView textView = (TextView) layoutInflater.inflate(R.layout.ar6, (ViewGroup) linearLayout, false);
            textView.setText(str);
            textView.setOnClickListener(this.qOH);
            if (i3 == this.xRW) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                setText(str);
            }
            linearLayout.addView(textView);
        }
        this.xRU.setContentView(linearLayout);
        setVisibility(0);
        AppMethodBeat.o(42090);
    }

    private void setCurrentSelection(int i2) {
        AppMethodBeat.i(42091);
        if (this.xRU.getContentView() == null || !(this.xRU.getContentView() instanceof ViewGroup)) {
            AppMethodBeat.o(42091);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.xRU.getContentView();
        if (i2 > this.xRX || this.xRW > this.xRX || !(viewGroup.getChildAt(i2) instanceof TextView) || !(viewGroup.getChildAt(this.xRW) instanceof TextView)) {
            AppMethodBeat.o(42091);
            return;
        }
        ((TextView) viewGroup.getChildAt(this.xRW)).setTextColor(this.mContext.getResources().getColor(R.color.uj));
        ((TextView) viewGroup.getChildAt(i2)).setTextColor(this.mContext.getResources().getColor(R.color.a2x));
        setText(this.xRV.get(i2));
        if (!(this.xRY == null || this.xRW == i2)) {
            this.xRY.Ov(i2);
        }
        this.xRW = i2;
        AppMethodBeat.o(42091);
    }

    public void setOnSelectionChangedListener(a aVar) {
        this.xRY = aVar;
    }

    /* access modifiers changed from: package-private */
    public static class b extends PopupWindow {
        public b(Context context) {
            super(context);
            AppMethodBeat.i(42086);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.game.ui.GameDropdownView.b.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(42085);
                    if (motionEvent.getAction() == 4) {
                        b.this.dismiss();
                        AppMethodBeat.o(42085);
                        return true;
                    }
                    AppMethodBeat.o(42085);
                    return false;
                }
            });
            setAnimationStyle(R.anim.c5);
            AppMethodBeat.o(42086);
        }
    }
}
