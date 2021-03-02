package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap EvS;
    private static Bitmap EvT;
    private static Field EvU;
    private static Field EvV;
    private static boolean EvW = false;
    private boolean EvR = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98260);
        init();
        AppMethodBeat.o(98260);
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98261);
        init();
        AppMethodBeat.o(98261);
    }

    private static void init() {
        AppMethodBeat.i(98262);
        if (EvU == null || EvV == null) {
            try {
                EvU = View.class.getDeclaredField("mDrawingCache");
                EvV = View.class.getDeclaredField("mUnscaledDrawingCache");
                EvU.setAccessible(true);
                EvV.setAccessible(true);
                EvW = true;
                AppMethodBeat.o(98262);
            } catch (Exception e2) {
                Log.e("MicroMsg.ShowCommentImageView", "init error: %s", e2.getMessage());
                EvW = false;
                AppMethodBeat.o(98262);
            }
        } else {
            AppMethodBeat.o(98262);
        }
    }

    public void buildDrawingCache(boolean z) {
        Field field;
        boolean z2;
        AppMethodBeat.i(98263);
        if (EvW) {
            if (this.EvR) {
                ao(z, true);
            } else if (!vo(z)) {
                Bitmap bitmap = z ? EvT : EvS;
                if (bitmap == null || bitmap.isRecycled()) {
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = EvU;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", e2.getMessage());
                            AppMethodBeat.o(98263);
                            return;
                        }
                    } else {
                        field = EvV;
                    }
                    Bitmap bitmap2 = (Bitmap) field.get(this);
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    if (bitmap2 == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[1] = Boolean.valueOf(z2);
                    Log.d("MicroMsg.ShowCommentImageView", "getStaticDrawingCache, autoScale: %s, cache==null: %s", objArr);
                    if (bitmap2 != null) {
                        if (z) {
                            EvT = bitmap2;
                            AppMethodBeat.o(98263);
                            return;
                        }
                        EvS = bitmap2;
                    }
                    AppMethodBeat.o(98263);
                    return;
                }
                ao(z, false);
                AppMethodBeat.o(98263);
                return;
            } else {
                super.buildDrawingCache(z);
                AppMethodBeat.o(98263);
                return;
            }
        }
        super.buildDrawingCache(z);
        AppMethodBeat.o(98263);
    }

    private boolean vo(boolean z) {
        Field field;
        AppMethodBeat.i(98264);
        if (!EvW) {
            AppMethodBeat.o(98264);
            return false;
        }
        if (z) {
            try {
                field = EvU;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ShowCommentImageView", e2, "", new Object[0]);
                Log.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", e2.getMessage());
                AppMethodBeat.o(98264);
                return false;
            }
        } else {
            field = EvV;
        }
        if (((Bitmap) field.get(this)) != null) {
            AppMethodBeat.o(98264);
            return true;
        }
        AppMethodBeat.o(98264);
        return false;
    }

    private void ao(boolean z, boolean z2) {
        Field field;
        boolean z3;
        AppMethodBeat.i(98265);
        if (z) {
            try {
                field = EvU;
            } catch (Exception e2) {
                Log.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", e2.getMessage());
                AppMethodBeat.o(98265);
                return;
            }
        } else {
            field = EvV;
        }
        if (z2) {
            field.set(this, null);
            AppMethodBeat.o(98265);
            return;
        }
        Bitmap bitmap = z ? EvT : EvS;
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (bitmap == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        Log.d("MicroMsg.ShowCommentImageView", "setDrawingCache, autoScale: %s, cache==null: %s", objArr);
        if (bitmap != null) {
            field.set(this, bitmap);
        }
        AppMethodBeat.o(98265);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(98267);
        super.destroyDrawingCache();
        AppMethodBeat.o(98267);
    }

    public void setOnClickListener(final View.OnClickListener onClickListener) {
        AppMethodBeat.i(98268);
        super.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ShowCommentImageView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(98258);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/ShowCommentImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ShowCommentImageView.this.EvR = true;
                onClickListener.onClick(view);
                a.a(this, "com/tencent/mm/plugin/sns/ui/ShowCommentImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98258);
            }
        });
        AppMethodBeat.o(98268);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(98269);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.ShowCommentImageView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(98259);
                    ShowCommentImageView.this.EvR = false;
                    AppMethodBeat.o(98259);
                }
            }, 100);
        } else {
            this.EvR = true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(98269);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(98266);
        try {
            EvU.set(this, null);
            EvV.set(this, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", e2.getMessage());
        }
        super.onDetachedFromWindow();
        AppMethodBeat.o(98266);
    }
}
