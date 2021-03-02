package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private Matrix mMatrix = new Matrix();
    private int rmI;
    private int rmJ = 0;
    private Bitmap rmK;
    private LinearLayout rmL;
    private ImageView rmM;
    private MMTabView rmN;
    private MMTabView rmO;
    private a rmP;
    protected View.OnClickListener rmQ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(109371);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            if (EmojiStoreV2TabView.this.rmP != null) {
                EmojiStoreV2TabView.this.rmP.onTabClick(intValue);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109371);
        }
    };
    IListener<dl> rmR = new IListener<dl>() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.AnonymousClass2 */

        {
            AppMethodBeat.i(161098);
            this.__eventId = dl.class.getName().hashCode();
            AppMethodBeat.o(161098);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dl dlVar) {
            AppMethodBeat.i(109373);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(109372);
                    try {
                        if (EmojiStoreV2TabView.this.rmN != null) {
                            if (!Util.isNullOrNil(e.cFX().rbo)) {
                                EmojiStoreV2TabView.this.rmN.setText(e.cFX().rbo);
                                AppMethodBeat.o(109372);
                                return;
                            } else if (e.cFX().rbn) {
                                EmojiStoreV2TabView.this.rmN.setText(R.string.bul);
                                AppMethodBeat.o(109372);
                                return;
                            } else {
                                EmojiStoreV2TabView.this.rmN.setText(R.string.buk);
                            }
                        }
                        AppMethodBeat.o(109372);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", e2, "event update error", new Object[0]);
                        AppMethodBeat.o(109372);
                    }
                }
            });
            AppMethodBeat.o(109373);
            return false;
        }
    };

    public interface a {
        void onTabClick(int i2);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109374);
        init();
        AppMethodBeat.o(109374);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109375);
        init();
        AppMethodBeat.o(109375);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(109376);
        super.onLayout(z, i2, i3, i4, i5);
        this.rmI = (i4 - i2) / 2;
        int i6 = this.rmI;
        if ((this.rmK == null || this.rmK.getWidth() != i6) && i6 > 0) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.rmK == null ? -1 : this.rmK.getWidth());
            objArr[1] = Integer.valueOf(i6);
            Log.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", objArr);
            this.rmK = Bitmap.createBitmap(i6, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
            new Canvas(this.rmK).drawColor(getResources().getColor(R.color.afp));
            p(this.rmJ, 0.0f);
            this.rmM.setImageBitmap(this.rmK);
        }
        setTo(this.rmJ);
        AppMethodBeat.o(109376);
    }

    private void init() {
        AppMethodBeat.i(109377);
        cIm();
        cIn();
        cIo();
        cIp();
        AppMethodBeat.o(109377);
    }

    private void cIm() {
        AppMethodBeat.i(109378);
        this.rmL = new LinearLayout(getContext());
        this.rmL.setBackgroundResource(R.color.afz);
        this.rmL.setId(R.id.c21);
        this.rmL.setOrientation(0);
        addView(this.rmL, new RelativeLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(109378);
    }

    private void cIn() {
        AppMethodBeat.i(109379);
        this.rmM = new ImageView(getContext());
        this.rmM.setImageMatrix(this.mMatrix);
        this.rmM.setScaleType(ImageView.ScaleType.MATRIX);
        this.rmM.setId(R.id.c22);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.id.c21);
        addView(this.rmM, layoutParams);
        AppMethodBeat.o(109379);
    }

    private void cIo() {
        AppMethodBeat.i(109380);
        this.rmN = Gd(0);
        if (!Util.isNullOrNil(e.cFX().rbo)) {
            this.rmN.setText(e.cFX().rbo);
        } else if (e.cFX().rbn) {
            this.rmN.setText(R.string.bul);
        } else {
            this.rmN.setText(R.string.buk);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        this.rmL.addView(this.rmN, layoutParams);
        AppMethodBeat.o(109380);
    }

    private void cIp() {
        AppMethodBeat.i(109381);
        this.rmO = Gd(1);
        this.rmO.setText(R.string.bus);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        this.rmL.addView(this.rmO, layoutParams);
        AppMethodBeat.o(109381);
    }

    private MMTabView Gd(int i2) {
        AppMethodBeat.i(109382);
        MMTabView mMTabView = new MMTabView(getContext(), i2);
        mMTabView.setTag(Integer.valueOf(i2));
        mMTabView.setOnClickListener(this.rmQ);
        AppMethodBeat.o(109382);
        return mMTabView;
    }

    public void setOnTabClickListener(a aVar) {
        this.rmP = aVar;
    }

    public int getCurentIndex() {
        return this.rmJ;
    }

    public final void p(int i2, float f2) {
        AppMethodBeat.i(109383);
        this.mMatrix.setTranslate(((float) this.rmI) * (((float) i2) + f2), 0.0f);
        this.rmM.setImageMatrix(this.mMatrix);
        AppMethodBeat.o(109383);
    }

    public void setTo(int i2) {
        AppMethodBeat.i(109384);
        this.rmJ = i2;
        this.rmN.setTextColor(this.rmJ == 0 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.rmO.setTextColor(this.rmJ == 1 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(109384);
    }

    public void setPersonTabUnReadCount(String str) {
        AppMethodBeat.i(109385);
        if (this.rmO != null) {
            this.rmO.setUnread(str);
        }
        AppMethodBeat.o(109385);
    }

    public final void lC(boolean z) {
        AppMethodBeat.i(109386);
        if (this.rmO != null) {
            this.rmO.Bk(z);
        }
        AppMethodBeat.o(109386);
    }
}
