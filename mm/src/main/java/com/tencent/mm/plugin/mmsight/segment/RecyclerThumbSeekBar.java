package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar extends RelativeLayout implements c {
    private RecyclerView hak;
    private int jkS = -1;
    private String path;
    private int thumbHeight;
    private int thumbWidth;
    private VideoTransPara zua;
    private int zyE;
    private c.a zyF;
    private c.b zyG;
    private c zyH;
    private SliderSeekBar zyI;
    private int zyJ;
    private d.a zyK = new d.a(4, new Callable<d>() {
        /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0077  */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ com.tencent.mm.plugin.mmsight.segment.d call() {
            /*
            // Method dump skipped, instructions count: 157
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass1.call():java.lang.Object");
        }
    });
    private Runnable zyL = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(94409);
            Log.i("RecyclerThumbSeekBar", "exec initAsyncTask");
            if (RecyclerThumbSeekBar.this.getHeight() == 0 || RecyclerThumbSeekBar.this.getWidth() == 0) {
                RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.this.zyL);
                AppMethodBeat.o(94409);
                return;
            }
            RecyclerThumbSeekBar.this.thumbHeight = RecyclerThumbSeekBar.this.getHeight();
            RecyclerThumbSeekBar.this.thumbWidth = (RecyclerThumbSeekBar.this.getWidth() - (RecyclerThumbSeekBar.this.zyJ * 2)) / 12;
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(94408);
                    try {
                        d ekq = RecyclerThumbSeekBar.this.zyK.ekq();
                        RecyclerThumbSeekBar.this.jkS = ekq.getDurationMs();
                        RecyclerThumbSeekBar.this.zyK.a(ekq);
                        z = true;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("RecyclerThumbSeekBar", e2, "Try to init fetcher error : %s", e2.getMessage());
                        z = false;
                    }
                    if (!z) {
                        RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
                        AppMethodBeat.o(94408);
                        return;
                    }
                    if (RecyclerThumbSeekBar.this.jkS >= 10000) {
                        RecyclerThumbSeekBar.this.zyE = (RecyclerThumbSeekBar.this.zua.duration * 1000) / 10;
                    } else if (RecyclerThumbSeekBar.this.jkS > 0) {
                        RecyclerThumbSeekBar.this.zyE = RecyclerThumbSeekBar.this.jkS / 10;
                    } else {
                        Log.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", Integer.valueOf(RecyclerThumbSeekBar.this.jkS));
                        RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
                        AppMethodBeat.o(94408);
                        return;
                    }
                    Log.d("RecyclerThumbSeekBar", "duration %d interval %d", Integer.valueOf(RecyclerThumbSeekBar.this.jkS), Integer.valueOf(RecyclerThumbSeekBar.this.zyE));
                    RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                    AppMethodBeat.o(94408);
                }
            }, "check duration of ");
            AppMethodBeat.o(94409);
        }
    };
    private RecyclerView.l zyM = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass5 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(187063);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(187063);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(94412);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            if (i2 == 0 && RecyclerThumbSeekBar.this.zyG != null) {
                RecyclerThumbSeekBar.this.zyG.W(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(94412);
        }
    };
    private SliderSeekBar.a zyN = new SliderSeekBar.a() {
        /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void eky() {
            AppMethodBeat.i(94413);
            if (!(RecyclerThumbSeekBar.this.zyG == null || RecyclerThumbSeekBar.this.zyH == null)) {
                RecyclerThumbSeekBar.this.zyG.X(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
            }
            AppMethodBeat.o(94413);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void ekz() {
            AppMethodBeat.i(94414);
            if (!(RecyclerThumbSeekBar.this.zyG == null || RecyclerThumbSeekBar.this.zyH == null)) {
                RecyclerThumbSeekBar.this.zyG.Y(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
            }
            AppMethodBeat.o(94414);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void rj(boolean z) {
            AppMethodBeat.i(94415);
            if (!(RecyclerThumbSeekBar.this.zyG == null || RecyclerThumbSeekBar.this.zyH == null)) {
                RecyclerThumbSeekBar.this.zyG.Z(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
            }
            if (z) {
                RecyclerThumbSeekBar.this.zyH.O(true, RecyclerThumbSeekBar.this.zyI.getLeftSliderBound());
                AppMethodBeat.o(94415);
                return;
            }
            RecyclerThumbSeekBar.this.zyH.O(false, RecyclerThumbSeekBar.this.zyI.getWidth() - RecyclerThumbSeekBar.this.zyI.getRightSliderBound());
            AppMethodBeat.o(94415);
        }
    };

    static /* synthetic */ void h(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.i(94440);
        recyclerThumbSeekBar.ekx();
        AppMethodBeat.o(94440);
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        AppMethodBeat.i(94427);
        init();
        AppMethodBeat.o(94427);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94428);
        init();
        AppMethodBeat.o(94428);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94429);
        init();
        AppMethodBeat.o(94429);
    }

    private void init() {
        AppMethodBeat.i(94430);
        this.hak = new RecyclerView(getContext());
        getContext();
        this.hak.setLayoutManager(new LinearLayoutManager(0, false));
        this.hak.setHasFixedSize(true);
        com.tencent.mm.cb.a.aG(getContext(), R.dimen.anl);
        this.zyJ = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ank);
        addView(this.hak, new RelativeLayout.LayoutParams(-1, -1));
        this.zyI = new SliderSeekBar(getContext());
        addView(this.zyI, new RelativeLayout.LayoutParams(-1, -1));
        this.zyI.setOnSliderTouchListener(this.zyN);
        this.hak.a(this.zyM);
        AppMethodBeat.o(94430);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public void setCurrentCursorPosition(float f2) {
        float f3 = 0.0f;
        AppMethodBeat.i(94431);
        SliderSeekBar sliderSeekBar = this.zyI;
        if (!(this.zyH == null || this.hak == null)) {
            float itemCount = ((float) (this.zyH.getItemCount() - 2)) * f2;
            int floor = (int) Math.floor((double) itemCount);
            float f4 = itemCount - ((float) floor);
            RecyclerView.v ch = this.hak.ch(floor + 1);
            if (ch != null) {
                View view = ch.aus;
                f3 = ((((float) view.getWidth()) * f4) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        sliderSeekBar.setCursorPos(f3);
        AppMethodBeat.o(94431);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public final void aFp(String str) {
        AppMethodBeat.i(94432);
        Log.i("RecyclerThumbSeekBar", "initAsync %s", str);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            ekx();
            AppMethodBeat.o(94432);
            return;
        }
        this.path = str;
        post(this.zyL);
        AppMethodBeat.o(94432);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public int getDurationMs() {
        return this.jkS;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public final void rh(boolean z) {
        if (z) {
            this.zyI.zxs = true;
        } else {
            this.zyI.zxs = false;
        }
    }

    public void setVideoTransPara(VideoTransPara videoTransPara) {
        this.zua = videoTransPara;
    }

    private void setViewWidth(int i2) {
        AppMethodBeat.i(94433);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
        AppMethodBeat.o(94433);
    }

    private void ekx() {
        AppMethodBeat.i(94434);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(94411);
                if (RecyclerThumbSeekBar.this.zyF != null) {
                    RecyclerThumbSeekBar.this.zyF.ri(true);
                }
                AppMethodBeat.o(94411);
            }
        });
        AppMethodBeat.o(94434);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public final void release() {
        AppMethodBeat.i(94435);
        this.jkS = -1;
        this.path = null;
        if (this.zyK != null) {
            this.zyK.destroy();
        }
        if (!(this.zyH == null || this.zyH.zyS == null)) {
            d dVar = this.zyH.zyS;
            if (!(dVar.zyX == null || dVar.zyX.length == 0)) {
                for (int i2 = 0; i2 < dVar.zyX.length; i2++) {
                    if (dVar.zyX[i2] != null) {
                        dVar.zyX[i2].getSerial().RUS.quit();
                        dVar.zyX[i2] = null;
                    }
                }
            }
            this.zyH.zyS = null;
            this.zyH = null;
        }
        if (this.zyI != null) {
            this.zyI.reset();
        }
        AppMethodBeat.o(94435);
    }

    public final void reset() {
        AppMethodBeat.i(94436);
        if (this.zyI != null) {
            this.zyI.reset();
        }
        AppMethodBeat.o(94436);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public void setOnPreparedListener(c.a aVar) {
        this.zyF = aVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public void setThumbBarSeekListener(c.b bVar) {
        this.zyG = bVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public final float eko() {
        AppMethodBeat.i(94437);
        if (this.zyI == null) {
            AppMethodBeat.o(94437);
            return 0.0f;
        }
        float aD = aD(this.zyI.getLeftSliderBound(), false);
        Log.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", Integer.valueOf(this.zyI.getLeftSliderBound()), Float.valueOf(aD), Integer.valueOf(Math.round(((float) this.jkS) * aD)), Integer.valueOf(this.jkS));
        AppMethodBeat.o(94437);
        return aD;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c
    public final float ekp() {
        AppMethodBeat.i(94438);
        if (this.zyI == null) {
            AppMethodBeat.o(94438);
            return 0.0f;
        }
        float aD = aD(this.zyI.getRightSliderBound(), true);
        Log.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", Integer.valueOf(this.zyI.getRightSliderBound()), Float.valueOf(aD), Integer.valueOf(Math.round(((float) this.jkS) * aD)));
        AppMethodBeat.o(94438);
        return aD;
    }

    private float aD(int i2, boolean z) {
        AppMethodBeat.i(94439);
        if (this.zyH == null || this.hak == null) {
            AppMethodBeat.o(94439);
            return 0.0f;
        }
        View o = this.hak.o((float) i2, 0.0f);
        if (o == null) {
            Log.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", Integer.valueOf(i2), Boolean.valueOf(z));
            AppMethodBeat.o(94439);
            return 0.0f;
        }
        int bw = RecyclerView.bw(o);
        int itemCount = this.zyH.getItemCount();
        if (bw <= 1) {
            AppMethodBeat.o(94439);
            return 0.0f;
        } else if (bw >= itemCount - 1) {
            AppMethodBeat.o(94439);
            return 1.0f;
        } else {
            float left = (((float) (bw - 1)) + (((float) (i2 - o.getLeft())) / ((float) o.getWidth()))) / ((float) (itemCount - 2));
            AppMethodBeat.o(94439);
            return left;
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends RecyclerView.a<e> {
        private d zyS;
        private int zyT;
        private int zyU;
        private View zyV;
        private View zyW;

        private c() {
            AppMethodBeat.i(94419);
            this.zyS = new d();
            this.zyT = RecyclerThumbSeekBar.this.zyJ;
            this.zyU = RecyclerThumbSeekBar.this.zyJ;
            AppMethodBeat.o(94419);
        }

        /* synthetic */ c(RecyclerThumbSeekBar recyclerThumbSeekBar, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(e eVar, int i2) {
            b bVar;
            Bitmap bitmap;
            AppMethodBeat.i(94423);
            e eVar2 = eVar;
            if (getItemViewType(i2) == 1 || getItemViewType(i2) == 2) {
                if (i2 == 0) {
                    eVar2.aus.setMinimumWidth(this.zyT);
                } else {
                    eVar2.aus.setMinimumWidth(this.zyU);
                }
                eVar2.aus.setBackgroundColor(0);
                eVar2.aus.setMinimumHeight(RecyclerThumbSeekBar.this.thumbHeight);
                AppMethodBeat.o(94423);
            } else if (this.zyS != null) {
                d dVar = this.zyS;
                int i3 = i2 * RecyclerThumbSeekBar.this.zyE;
                ImageView imageView = eVar2.dKU;
                if (imageView == null || i3 < 0) {
                    AppMethodBeat.o(94423);
                    return;
                }
                if (i3 > RecyclerThumbSeekBar.this.jkS) {
                    i3 = RecyclerThumbSeekBar.this.jkS;
                }
                Log.i("RecyclerThumbSeekBar", "loadImageAsync() called with: time = [" + i3 + "], view = [" + imageView + "]");
                Object tag = imageView.getTag();
                if (tag == null || !(tag instanceof b)) {
                    bVar = null;
                } else {
                    bVar = (b) tag;
                }
                if (bVar == null || bVar.hXs != i3) {
                    if (bVar != null) {
                        bVar.jcC = true;
                    }
                    if (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) {
                        bitmap = null;
                    } else {
                        bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    }
                    imageView.setImageBitmap(null);
                    b bVar2 = new b(i3, imageView, bitmap, dVar.handler);
                    imageView.setTag(bVar2);
                    int i4 = dVar.zyY % dVar.zvb;
                    dVar.zyY++;
                    if (dVar.zyX[i4] != null) {
                        new MMHandler(dVar.zyX[i4].getSerial()).post(bVar2);
                    }
                    AppMethodBeat.o(94423);
                    return;
                }
                Log.i("RecyclerThumbSeekBar", "SimpleImageLoader.loadImageAsync time equals %d return directly", Integer.valueOf(i3));
                AppMethodBeat.o(94423);
            } else {
                Log.e("RecyclerThumbSeekBar", "onBindViewHolder ImageLoader invoked after released.");
                AppMethodBeat.o(94423);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(94420);
            if (i2 == 0) {
                AppMethodBeat.o(94420);
                return 1;
            } else if (i2 == getItemCount() - 1) {
                AppMethodBeat.o(94420);
                return 2;
            } else {
                AppMethodBeat.o(94420);
                return 0;
            }
        }

        public final void O(boolean z, int i2) {
            AppMethodBeat.i(94421);
            if (z) {
                if (this.zyV != null) {
                    this.zyV.setMinimumWidth(i2);
                }
                if (((LinearLayoutManager) RecyclerThumbSeekBar.this.hak.getLayoutManager()).ks() == 0) {
                    RecyclerThumbSeekBar.this.hak.scrollBy(i2 - this.zyT, 0);
                }
                this.zyT = i2;
                AppMethodBeat.o(94421);
                return;
            }
            this.zyU = i2;
            if (this.zyW != null) {
                this.zyW.setMinimumWidth(this.zyU);
            }
            AppMethodBeat.o(94421);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(94422);
            if (RecyclerThumbSeekBar.this.jkS <= 0) {
                AppMethodBeat.o(94422);
                return 0;
            }
            int max = Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.this.jkS) / ((float) RecyclerThumbSeekBar.this.zyE)))) + 2;
            AppMethodBeat.o(94422);
            return max;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(94424);
            if (i2 == 1 || i2 == 2) {
                View view = new View(RecyclerThumbSeekBar.this.getContext());
                if (i2 == 1) {
                    this.zyV = view;
                } else {
                    this.zyW = view;
                }
                e eVar = new e(view, 1);
                AppMethodBeat.o(94424);
                return eVar;
            }
            ImageView imageView = new ImageView(RecyclerThumbSeekBar.this.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setMinimumWidth(RecyclerThumbSeekBar.this.thumbWidth);
            imageView.setMinimumHeight(RecyclerThumbSeekBar.this.thumbHeight);
            LinearLayout linearLayout = new LinearLayout(RecyclerThumbSeekBar.this.getContext());
            linearLayout.addView(imageView, RecyclerThumbSeekBar.this.thumbWidth, RecyclerThumbSeekBar.this.thumbHeight);
            e eVar2 = new e(linearLayout, 0);
            AppMethodBeat.o(94424);
            return eVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public class d {
        MMHandler handler = new MMHandler();
        int zvb = 4;
        MMHandler[] zyX = new MMHandler[this.zvb];
        int zyY = 0;
        private BlockingDeque<b> zyZ = new LinkedBlockingDeque();

        public d() {
            AppMethodBeat.i(94425);
            for (int i2 = 0; i2 < this.zyX.length; i2++) {
                this.zyX[i2] = new MMHandler("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i2)));
            }
            this.zyY = 0;
            AppMethodBeat.o(94425);
        }
    }

    class a implements Runnable {
        private Bitmap bitmap;
        private ImageView dKU;
        private b zyQ;

        a(Bitmap bitmap2, ImageView imageView, b bVar) {
            this.bitmap = bitmap2;
            this.dKU = imageView;
            this.zyQ = bVar;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(94416);
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", objArr);
                AppMethodBeat.o(94416);
            } else if (this.zyQ == null || this.zyQ.jcC || this.dKU == null) {
                Log.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
                AppMethodBeat.o(94416);
            } else {
                ImageView imageView = this.dKU;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", 50, 255).setDuration(200L).start();
                imageView.setImageBitmap(this.bitmap);
                AppMethodBeat.o(94416);
            }
        }
    }

    class b implements Runnable {
        private int hXs;
        private MMHandler handler;
        boolean jcC = false;
        private WeakReference<ImageView> oi;
        private Bitmap zyR;

        b(int i2, ImageView imageView, Bitmap bitmap, MMHandler mMHandler) {
            AppMethodBeat.i(94417);
            this.hXs = i2;
            this.oi = new WeakReference<>(imageView);
            this.handler = mMHandler;
            this.zyR = bitmap;
            AppMethodBeat.o(94417);
        }

        public final void run() {
            AppMethodBeat.i(94418);
            if (this.jcC) {
                o.itM.f(this.zyR);
                AppMethodBeat.o(94418);
            } else if (this.oi.get() == null) {
                o.itM.f(this.zyR);
                AppMethodBeat.o(94418);
            } else {
                try {
                    d ekq = RecyclerThumbSeekBar.this.zyK.ekq();
                    if (this.zyR == null) {
                        this.zyR = o.itM.a(new o.b(ekq.getScaledWidth(), ekq.getScaledHeight()));
                    }
                    ekq.reuseBitmap(this.zyR);
                    if (!this.jcC) {
                        this.zyR = ekq.getFrameAtTime((long) this.hXs);
                    }
                    RecyclerThumbSeekBar.this.zyK.a(ekq);
                    if (this.zyR == null || this.jcC || this.oi.get() == null) {
                        o.itM.f(this.zyR);
                        AppMethodBeat.o(94418);
                        return;
                    }
                    this.handler.post(new a(this.zyR, this.oi.get(), this));
                    AppMethodBeat.o(94418);
                } catch (Exception e2) {
                    Log.e("RecyclerThumbSeekBar", "get bitmap error " + e2.getMessage());
                    o.itM.f(this.zyR);
                    AppMethodBeat.o(94418);
                }
            }
        }
    }

    class e extends RecyclerView.v {
        ImageView dKU;

        e(View view, int i2) {
            super(view);
            AppMethodBeat.i(94426);
            if (i2 == 0) {
                this.dKU = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
            AppMethodBeat.o(94426);
        }
    }

    static /* synthetic */ void k(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.i(94441);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.AnonymousClass3 */

            public final void run() {
                int i2 = 1000;
                AppMethodBeat.i(94410);
                try {
                    RecyclerThumbSeekBar.this.zyI.setCursorPos(-1.0f);
                    RecyclerThumbSeekBar.this.zyH = new c(RecyclerThumbSeekBar.this, (byte) 0);
                    int e2 = RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.zua.duration * 1000) + 1000);
                    int max = Math.max(RecyclerThumbSeekBar.this.zua.minDuration * 1000, RecyclerThumbSeekBar.this.zyE);
                    RecyclerThumbSeekBar recyclerThumbSeekBar = RecyclerThumbSeekBar.this;
                    if (max > 1000) {
                        i2 = max;
                    }
                    int e3 = RecyclerThumbSeekBar.e(recyclerThumbSeekBar, i2);
                    RecyclerThumbSeekBar.this.zyJ = (RecyclerThumbSeekBar.this.getWidth() - e2) / 2;
                    RecyclerThumbSeekBar.this.zyI.ao(e2, e3, RecyclerThumbSeekBar.this.zyJ);
                    Log.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", Integer.valueOf(RecyclerThumbSeekBar.this.getWidth()));
                    RecyclerThumbSeekBar.this.zyH.zyU = (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.this.zyJ) - e2;
                    RecyclerThumbSeekBar.this.zyH.zyT = RecyclerThumbSeekBar.this.zyJ;
                    RecyclerThumbSeekBar.this.hak.setAdapter(RecyclerThumbSeekBar.this.zyH);
                    Log.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", Integer.valueOf(RecyclerThumbSeekBar.this.zyH.getItemCount()));
                    if (RecyclerThumbSeekBar.this.zyF != null) {
                        RecyclerThumbSeekBar.this.zyF.ri(false);
                    }
                    AppMethodBeat.o(94410);
                } catch (Exception e4) {
                    Log.printErrStackTrace("RecyclerThumbSeekBar", e4, "RecyclerThumbSeekBar notifySuccess error : %s", e4.getMessage());
                    if (RecyclerThumbSeekBar.this.zyF != null) {
                        RecyclerThumbSeekBar.this.zyF.ri(true);
                    }
                    AppMethodBeat.o(94410);
                }
            }
        });
        AppMethodBeat.o(94441);
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i2) {
        AppMethodBeat.i(94442);
        if (recyclerThumbSeekBar.zyH == null) {
            IllegalStateException illegalStateException = new IllegalStateException("recyclerAdapter is null");
            AppMethodBeat.o(94442);
            throw illegalStateException;
        } else if (recyclerThumbSeekBar.jkS <= 0) {
            IllegalStateException illegalStateException2 = new IllegalStateException("durationMs <= 0");
            AppMethodBeat.o(94442);
            throw illegalStateException2;
        } else {
            recyclerThumbSeekBar.zyH.getItemCount();
            int min = (int) (Math.min(Math.max(0.0f, ((float) i2) / ((float) recyclerThumbSeekBar.jkS)), 1.0f) * ((float) recyclerThumbSeekBar.thumbWidth) * ((float) (recyclerThumbSeekBar.zyH.getItemCount() - 2)));
            AppMethodBeat.o(94442);
            return min;
        }
    }
}
