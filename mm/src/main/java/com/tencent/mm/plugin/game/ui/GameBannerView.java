package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private float aTD = 0.0f;
    private float aTE = 0.0f;
    private Context mContext;
    private MMDotView oxc;
    private ViewPager riH;
    private int xGR = 0;
    private b xOD;
    LinkedList<a> xOE;
    MTimerHandler xOF = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.ui.GameBannerView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(41878);
            if (GameBannerView.this.riH == null || GameBannerView.this.xOE.size() <= 1) {
                GameBannerView.this.xOF.stopTimer();
                AppMethodBeat.o(41878);
                return false;
            }
            GameBannerView.this.riH.setCurrentItem(GameBannerView.this.riH.getCurrentItem() + 1, true);
            AppMethodBeat.o(41878);
            return true;
        }
    }, true);

    public static class a {
        public String iJx;
        public int index;
        public String xDX;
        public g xOH;
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41882);
        this.mContext = context;
        inflate(context, R.layout.aom, this);
        this.xOE = new LinkedList<>();
        AppMethodBeat.o(41882);
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41883);
        super.onFinishInflate();
        this.oxc = (MMDotView) findViewById(R.id.dcw);
        this.riH = (ViewPager) findViewById(R.id.dcx);
        this.riH.setOnPageChangeListener(this);
        this.xOD = new b(this, (byte) 0);
        AppMethodBeat.o(41883);
    }

    public void setBannerList(LinkedList<a> linkedList) {
        AppMethodBeat.i(41884);
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            AppMethodBeat.o(41884);
            return;
        }
        Log.i("MicroMsg.GameBannerView", "bannerList size", Integer.valueOf(linkedList.size()));
        this.xOF.stopTimer();
        this.xOE.clear();
        this.xOE.addAll(linkedList);
        this.riH.setAdapter(this.xOD);
        this.riH.setCurrentItem(linkedList.size() * 1000, false);
        if (this.xOE.size() > 1) {
            this.xOF.startTimer(5000);
        }
        this.oxc.setVisibility(8);
        setVisibility(0);
        AppMethodBeat.o(41884);
    }

    /* access modifiers changed from: package-private */
    public final class b extends q {
        private b() {
        }

        /* synthetic */ b(GameBannerView gameBannerView, byte b2) {
            this();
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(41879);
            viewGroup.removeView((View) obj);
            Log.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", Integer.valueOf(i2 % GameBannerView.this.xOE.size()), Integer.valueOf(i2));
            AppMethodBeat.o(41879);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(41880);
            int size = i2 % GameBannerView.this.xOE.size();
            View inflate = View.inflate(GameBannerView.this.mContext, R.layout.aon, null);
            inflate.setTag(GameBannerView.this.xOE.get(size));
            inflate.setOnClickListener(GameBannerView.this);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dcy);
            String str = ((a) GameBannerView.this.xOE.get(size)).iJx;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof j)) {
                imageView.setImageDrawable(new j(str, (byte) 0));
            } else {
                ((j) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e2) {
                Log.e("MicroMsg.GameBannerView", "add view failed, " + e2.getMessage());
            }
            Log.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i2));
            AppMethodBeat.o(41880);
            return inflate;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(41881);
            if (GameBannerView.this.xOE.size() <= 1) {
                int size = GameBannerView.this.xOE.size();
                AppMethodBeat.o(41881);
                return size;
            }
            int size2 = GameBannerView.this.xOE.size() * 1000 * 2;
            AppMethodBeat.o(41881);
            return size2;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(41885);
        int size = i2 % this.xOE.size();
        Log.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", Integer.valueOf(i2), Integer.valueOf(size));
        if (this.xOE.get(size).xOH != null && com.tencent.mm.kernel.g.aAc()) {
            f.a(this.mContext, 11, 1101, size + 1, 1, this.xGR, null);
        }
        AppMethodBeat.o(41885);
    }

    private void pT(boolean z) {
        AppMethodBeat.i(41887);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(41887);
    }

    public void onClick(View view) {
        AppMethodBeat.i(41888);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41888);
            return;
        }
        a aVar = (a) view.getTag();
        g gVar = aVar.xOH;
        if (!Util.isNullOrNil(aVar.xDX)) {
            f.a(this.mContext, 11, 1101, 1, c.aQ(this.mContext, aVar.xDX), this.xGR, null);
        } else {
            Log.i("MicroMsg.GameBannerView", "null or nil url");
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", gVar.field_appId);
            bundle.putInt("game_report_from_scene", 5);
            f.a(this.mContext, 11, 1101, 1, c.b(this.mContext, gVar.field_appId, null, bundle), this.xGR, null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41888);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(41886);
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.aTD = rawX;
                this.aTE = rawY;
                break;
            case 1:
            case 3:
                pT(false);
                this.aTD = 0.0f;
                this.aTE = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.aTD)) > Math.abs((int) (rawY - this.aTE))) {
                    pT(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xOF.stopTimer();
                break;
            case 1:
            case 3:
                this.xOF.startTimer(5000);
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(41886);
        return onInterceptTouchEvent;
    }
}
