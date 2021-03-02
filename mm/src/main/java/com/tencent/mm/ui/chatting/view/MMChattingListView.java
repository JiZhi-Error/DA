package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.a.a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class MMChattingListView extends MMPullDownView implements MMPullDownView.c, MMPullDownView.d, MMPullDownView.e, MMPullDownView.g {
    private Bundle PFm;
    private BaseAdapter PGo;
    private Rect PGp = new Rect();
    private Paint PGq;
    private boolean PGr;
    private boolean PGs;
    private boolean PGt = false;
    private int PGu;
    private a PlQ;
    private ListView mListView;

    public MMChattingListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(36708);
        init(context);
        AppMethodBeat.o(36708);
    }

    public MMChattingListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(36709);
        init(context);
        AppMethodBeat.o(36709);
    }

    private void init(final Context context) {
        AppMethodBeat.i(36710);
        this.PGq = new Paint();
        this.PGq.setColor(WebView.NIGHT_MODE_COLOR);
        this.mListView = new ListView(context) {
            /* class com.tencent.mm.ui.chatting.view.MMChattingListView.AnonymousClass1 */

            public final void onDrawForeground(Canvas canvas) {
                AppMethodBeat.i(36704);
                super.onDrawForeground(canvas);
                if (!MMChattingListView.this.PGp.isEmpty()) {
                    Rect rect = new Rect();
                    MMChattingListView.this.mListView.getLocalVisibleRect(rect);
                    Rect rect2 = new Rect(rect);
                    Rect rect3 = new Rect(rect);
                    if (!MMChattingListView.this.PGs) {
                        rect2.bottom = MMChattingListView.this.PGp.top;
                        rect3.top = MMChattingListView.this.PGp.bottom;
                        canvas.drawRect(rect2, MMChattingListView.this.PGq);
                        canvas.drawRect(rect3, MMChattingListView.this.PGq);
                    } else {
                        if (MMChattingListView.this.PGr) {
                            rect2.top = MMChattingListView.this.PGp.top + com.tencent.mm.cb.a.fromDPToPix(context, 35);
                        } else {
                            rect2.top = MMChattingListView.this.PGp.top;
                        }
                        rect2.bottom = MMChattingListView.this.PGp.bottom + com.tencent.mm.cb.a.fromDPToPix(context, 1);
                        canvas.drawRect(rect2, MMChattingListView.this.PGq);
                    }
                    Log.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", rect, MMChattingListView.this.PGp);
                }
                AppMethodBeat.o(36704);
            }
        };
        this.mListView.setBackgroundDrawable(null);
        this.mListView.setSelector(R.drawable.ahu);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(null);
        this.mListView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix(context, 6));
        this.mListView.setClipToPadding(false);
        this.mListView.setScrollBarStyle(TPMediaCodecProfileLevel.HEVCHighTierLevel62);
        this.mListView.setId(R.id.awv);
        setOverScrollMode(2);
        addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
        setCanOverScrool(false);
        Bx(false);
        By(false);
        setTopViewVisible(true);
        setOnBottomLoadDataListener(this);
        setOnTopLoadDataListener(this);
        setAtBottomCallBack(this);
        setAtTopCallBack(this);
        setIsBottomShowAll(true);
        setIsTopShowAll(false);
        setBottomViewVisible(true);
        this.PGs = false;
        AppMethodBeat.o(36710);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        AppMethodBeat.i(36711);
        this.PGo = baseAdapter;
        getListView().setAdapter((ListAdapter) this.PGo);
        AppMethodBeat.o(36711);
    }

    public void setLoadExecutor(a aVar) {
        this.PlQ = aVar;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public BaseAdapter getBaseAdapter() {
        return this.PGo;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.c
    public final boolean cAl() {
        AppMethodBeat.i(36712);
        View childAt = getListView().getChildAt(getListView().getChildCount() - 1);
        if (childAt == null) {
            AppMethodBeat.o(36712);
            return true;
        } else if (childAt.getBottom() > getListView().getHeight() - getListView().getPaddingBottom() || getListView().getLastVisiblePosition() != getListView().getAdapter().getCount() - 1) {
            AppMethodBeat.o(36712);
            return false;
        } else {
            AppMethodBeat.o(36712);
            return true;
        }
    }

    public int getBottomSpace() {
        AppMethodBeat.i(36713);
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (this.mListView.getChildCount() > 0) {
            View childAt = getListView().getChildAt(getListView().getChildCount() - 1);
            height = (childAt == null || this.mListView.getLastVisiblePosition() != this.mListView.getAdapter().getCount() + -1) ? 0 : height - childAt.getBottom();
        }
        AppMethodBeat.o(36713);
        return height;
    }

    public final void c(boolean z, Bundle bundle) {
        Object obj;
        AppMethodBeat.i(36714);
        StringBuilder append = new StringBuilder("[lockTopLoadDataForPosition] start:").append(z).append(" sourceArgs:");
        if (bundle == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = bundle;
        }
        Log.i("MicroMsg.MMChattingListView", append.append(obj).toString());
        this.PGt = z;
        this.PFm = bundle;
        super.Bx(z);
        AppMethodBeat.o(36714);
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView
    public final void Bx(boolean z) {
        AppMethodBeat.i(36715);
        Log.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + z + " isForceTopLoadDataForPosition:" + this.PGt);
        if (this.PGt) {
            AppMethodBeat.o(36715);
            return;
        }
        super.Bx(z);
        AppMethodBeat.o(36715);
    }

    public final void bs(Bundle bundle) {
        AppMethodBeat.i(36716);
        Log.i("MicroMsg.MMChattingListView", "[forceTopLoadData] sourceArgs:" + (bundle == null ? "" : bundle.toString()));
        this.PFm = bundle;
        super.By(true);
        AppMethodBeat.o(36716);
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.d
    public final boolean cAk() {
        AppMethodBeat.i(36717);
        View childAt = getListView().getChildAt(getListView().getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            AppMethodBeat.o(36717);
            return false;
        }
        AppMethodBeat.o(36717);
        return true;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.e
    public final boolean cAj() {
        AppMethodBeat.i(36718);
        this.PGu = getCurCount();
        Log.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.PGu);
        if (this.PlQ != null) {
            this.PlQ.a(d.a.ACTION_BOTTOM, false, this.PFm);
            this.PFm = null;
            this.PGt = false;
        }
        AppMethodBeat.o(36718);
        return false;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.g
    public final boolean cAm() {
        AppMethodBeat.i(36719);
        this.PGu = getCurCount();
        Log.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.PGu + " isForceTopLoadDataForPosition:" + this.PGt);
        if (this.PlQ != null) {
            if (this.PGt && this.PFm != null) {
                this.PFm.putInt("SCENE", 2);
            }
            this.PlQ.a(this.PGt ? d.a.ACTION_POSITION : d.a.ACTION_TOP, false, this.PFm);
        }
        this.PFm = null;
        this.PGt = false;
        AppMethodBeat.o(36719);
        return false;
    }

    public int getPreCount() {
        return this.PGu;
    }

    public int getCurCount() {
        AppMethodBeat.i(36720);
        if (this.PGo == null) {
            AppMethodBeat.o(36720);
            return 0;
        }
        int count = this.PGo.getCount();
        AppMethodBeat.o(36720);
        return count;
    }

    public void setHighLightChild(int i2) {
        AppMethodBeat.i(36721);
        int max = Math.max(0, i2);
        if (this.mListView == null) {
            Log.e("MicroMsg.MMChattingListView", "null == listView index:%s", Integer.valueOf(max));
            AppMethodBeat.o(36721);
            return;
        }
        final View childAt = this.mListView.getChildAt(max);
        if (childAt == null) {
            Log.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max));
            AppMethodBeat.o(36721);
            return;
        }
        if (childAt.getBottom() - childAt.getTop() <= 0) {
            ListView listView = this.mListView;
            childAt = listView.getChildAt(listView.getHeaderViewsCount() + max);
        }
        if (childAt == null) {
            Log.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max + this.mListView.getHeaderViewsCount()));
            AppMethodBeat.o(36721);
            return;
        }
        Log.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", Integer.valueOf(max), new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()));
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.85f, 0.85f, 0.85f, 0.85f, 0.85f, 0.0f));
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.chatting.view.MMChattingListView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(36706);
                childAt.getGlobalVisibleRect(MMChattingListView.this.PGp);
                MMChattingListView.this.PGp.top = childAt.getTop();
                MMChattingListView.this.PGp.bottom = childAt.getBottom();
                MMChattingListView.this.PGq.setAlpha((int) (((Float) valueAnimator.getAnimatedValue("alpha")).floatValue() * 255.0f));
                MMChattingListView.this.mListView.postInvalidate();
                AppMethodBeat.o(36706);
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.ui.chatting.view.MMChattingListView.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(36707);
                super.onAnimationEnd(animator);
                MMChattingListView.this.PGp.setEmpty();
                AppMethodBeat.o(36707);
            }
        });
        ofPropertyValuesHolder.setDuration(1600L);
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(36721);
    }

    public void setHighLightChildNew(int i2) {
        final View view;
        PropertyValuesHolder ofFloat;
        AppMethodBeat.i(233538);
        this.PGs = true;
        if (ao.isDarkMode()) {
            this.PGq.setColor(getResources().getColor(R.color.am));
        } else {
            this.PGq.setColor(getResources().getColor(R.color.fm));
        }
        Log.i("MicroMsg.MMChattingListView", "[newStyle] setfalse" + this.PGs);
        int max = Math.max(1, i2);
        if (this.mListView == null) {
            Log.e("MicroMsg.MMChattingListView", "null == listView index:%s", Integer.valueOf(max));
            AppMethodBeat.o(233538);
            return;
        }
        View childAt = this.mListView.getChildAt(max);
        if (childAt == null) {
            Log.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max));
            AppMethodBeat.o(233538);
            return;
        }
        if (childAt.getBottom() - childAt.getTop() <= 0) {
            ListView listView = this.mListView;
            view = listView.getChildAt(listView.getHeaderViewsCount() + max);
        } else {
            view = childAt;
        }
        if (view == null) {
            Log.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max + this.mListView.getHeaderViewsCount()));
            AppMethodBeat.o(233538);
            return;
        }
        Log.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", Integer.valueOf(max), new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()));
        if (ao.isDarkMode()) {
            ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.08f, 0.08f, 0.08f, 0.08f, 0.08f, 0.0f);
        } else {
            ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.0f);
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(ofFloat);
        TextView textView = (TextView) view.findViewById(R.id.ayf);
        if (textView == null || textView.getVisibility() != 0) {
            this.PGr = false;
        } else {
            this.PGr = true;
        }
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.chatting.view.MMChattingListView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(233536);
                view.getGlobalVisibleRect(MMChattingListView.this.PGp);
                MMChattingListView.this.PGp.top = view.getTop();
                MMChattingListView.this.PGp.bottom = view.getBottom();
                MMChattingListView.this.PGq.setAlpha((int) (((Float) valueAnimator.getAnimatedValue("alpha")).floatValue() * 255.0f));
                MMChattingListView.this.mListView.postInvalidate();
                AppMethodBeat.o(233536);
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.ui.chatting.view.MMChattingListView.AnonymousClass5 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(233537);
                super.onAnimationEnd(animator);
                MMChattingListView.this.PGp.setEmpty();
                MMChattingListView.this.PGs = false;
                AppMethodBeat.o(233537);
            }
        });
        ofPropertyValuesHolder.setDuration(1150L);
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(233538);
    }
}
