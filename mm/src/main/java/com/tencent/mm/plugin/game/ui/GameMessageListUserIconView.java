package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    private Context mContext;
    private p xUB;
    private f<String, Bitmap> xUC;

    public GameMessageListUserIconView(Context context) {
        super(context);
        AppMethodBeat.i(42287);
        this.mContext = context;
        init();
        AppMethodBeat.o(42287);
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42288);
        this.mContext = context;
        init();
        AppMethodBeat.o(42288);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42289);
        super.onFinishInflate();
        init();
        AppMethodBeat.o(42289);
    }

    private void init() {
        AppMethodBeat.i(42290);
        if (this.xUB == null) {
            this.xUB = new p(this.mContext);
        }
        AppMethodBeat.o(42290);
    }

    public void setSourceScene(int i2) {
        AppMethodBeat.i(42291);
        if (this.xUB != null) {
            this.xUB.xGR = i2;
            AppMethodBeat.o(42291);
            return;
        }
        this.xUB = new p(this.mContext, i2);
        AppMethodBeat.o(42291);
    }

    public final void a(o oVar, LinkedList<o.k> linkedList, f<String, Bitmap> fVar) {
        AppMethodBeat.i(42292);
        if (oVar == null || Util.isNullOrNil(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(42292);
            return;
        }
        this.xUC = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.h7);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.f3062g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(this.xUB);
            addView(imageView);
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ImageView imageView2 = (ImageView) getChildAt(i2);
            if (i2 < linkedList.size()) {
                imageView2.setVisibility(0);
                o.k kVar = linkedList.get(i2);
                if (!Util.isNullOrNil(kVar.xGp)) {
                    String str = kVar.xGp;
                    if (this.xUC.check(str)) {
                        Bitmap bitmap = this.xUC.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            n(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        n(imageView2, str);
                    }
                } else {
                    String str2 = kVar.userName;
                    if (Util.isNullOrNil(str2)) {
                        a.b.c(imageView2, str2);
                    } else if (!this.xUC.check(str2)) {
                        l(imageView2, str2);
                    } else {
                        Bitmap bitmap2 = this.xUC.get(str2);
                        if (bitmap2 == null || bitmap2.isRecycled()) {
                            l(imageView2, str2);
                        } else {
                            imageView2.setImageBitmap(bitmap2);
                        }
                    }
                }
                if (!Util.isNullOrNil(kVar.xGs)) {
                    imageView2.setTag(new p.a(oVar, kVar.xGs, 6));
                    imageView2.setEnabled(true);
                } else {
                    imageView2.setEnabled(false);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
        AppMethodBeat.o(42292);
    }

    private void n(ImageView imageView, final String str) {
        AppMethodBeat.i(42293);
        e.a.C1397a aVar = new e.a.C1397a();
        aVar.jbd = false;
        e.dWR().a(imageView, str, aVar.dWS(), new e.b() {
            /* class com.tencent.mm.plugin.game.ui.GameMessageListUserIconView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.e.e.b
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(42286);
                if (bitmap != null && !bitmap.isRecycled()) {
                    GameMessageListUserIconView.this.xUC.put(str, bitmap);
                }
                AppMethodBeat.o(42286);
            }
        });
        AppMethodBeat.o(42293);
    }

    private void l(ImageView imageView, String str) {
        AppMethodBeat.i(42294);
        Bitmap q = e.dWR().q(imageView, str);
        if (q != null) {
            this.xUC.put(str, q);
        }
        AppMethodBeat.o(42294);
    }
}
