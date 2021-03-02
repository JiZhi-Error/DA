package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class JsonRecyclerView extends RecyclerView {
    private a Qnj;
    float Qnk;
    private RecyclerView.k Qnl;
    int mode;

    public JsonRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JsonRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(38910);
        this.Qnl = new RecyclerView.k() {
            /* class com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.k
            public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(234461);
                switch (motionEvent.getAction() & motionEvent.getActionMasked()) {
                    case 0:
                        JsonRecyclerView.this.mode = 1;
                        break;
                    case 1:
                        JsonRecyclerView.this.mode = 0;
                        break;
                    case 2:
                        if (JsonRecyclerView.this.mode >= 2) {
                            float ak = JsonRecyclerView.ak(motionEvent);
                            if (Math.abs(ak - JsonRecyclerView.this.Qnk) > 0.5f) {
                                JsonRecyclerView.a(JsonRecyclerView.this, ak / JsonRecyclerView.this.Qnk);
                                JsonRecyclerView.this.Qnk = ak;
                                break;
                            }
                        }
                        break;
                    case 5:
                        JsonRecyclerView.this.Qnk = JsonRecyclerView.ak(motionEvent);
                        JsonRecyclerView.this.mode++;
                        break;
                    case 6:
                        JsonRecyclerView jsonRecyclerView = JsonRecyclerView.this;
                        jsonRecyclerView.mode--;
                        break;
                }
                AppMethodBeat.o(234461);
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(234462);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.bm(motionEvent);
                a.b("com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(234462);
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void ah(boolean z) {
            }
        };
        getContext();
        setLayoutManager(new LinearLayoutManager());
        AppMethodBeat.o(38910);
    }

    public void setKeyColor(int i2) {
        a.QmX = i2;
    }

    public void setValueTextColor(int i2) {
        a.QmY = i2;
    }

    public void setValueNumberColor(int i2) {
        a.QmZ = i2;
    }

    public void setValueBooleanColor(int i2) {
        a.Qna = i2;
    }

    public void setValueUrlColor(int i2) {
        a.Qnb = i2;
    }

    public void setValueNullColor(int i2) {
        a.QmZ = i2;
    }

    public void setBracesColor(int i2) {
        a.Qnd = i2;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(38911);
        if (f2 < 10.0f) {
            f2 = 10.0f;
        } else if (f2 > 30.0f) {
            f2 = 30.0f;
        }
        if (a.Qne != f2) {
            a.Qne = f2;
            if (this.Qnj != null) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                int childCount = layoutManager.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    C(layoutManager.getChildAt(i2), f2);
                }
            }
        }
        AppMethodBeat.o(38911);
    }

    public void setScaleEnable(boolean z) {
        AppMethodBeat.i(38912);
        if (z) {
            a(this.Qnl);
            AppMethodBeat.o(38912);
            return;
        }
        b(this.Qnl);
        AppMethodBeat.o(38912);
    }

    private void C(View view, float f2) {
        AppMethodBeat.i(38913);
        if (view instanceof JsonItemView) {
            JsonItemView jsonItemView = (JsonItemView) view;
            jsonItemView.setTextSize(f2);
            int childCount = jsonItemView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                C(jsonItemView.getChildAt(i2), f2);
            }
        }
        AppMethodBeat.o(38913);
    }

    static /* synthetic */ float ak(MotionEvent motionEvent) {
        AppMethodBeat.i(38914);
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        float sqrt = (float) Math.sqrt((double) ((x * x) + (y * y)));
        AppMethodBeat.o(38914);
        return sqrt;
    }

    static /* synthetic */ void a(JsonRecyclerView jsonRecyclerView, float f2) {
        AppMethodBeat.i(38915);
        jsonRecyclerView.setTextSize(a.Qne * f2);
        AppMethodBeat.o(38915);
    }
}
