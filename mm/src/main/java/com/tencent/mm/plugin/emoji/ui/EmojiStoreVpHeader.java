package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements ViewPager.OnPageChangeListener {
    private View jBN;
    private View kHq;
    private MMDotView oxc;
    private ViewPager riH;
    private LinkedList<com.tencent.mm.plugin.emoji.model.a> riI;
    private i riJ;
    private float riK;
    private float riL;
    private a riM;
    private volatile boolean riN;
    private final int riO = 5;
    private final int riP = 0;

    static /* synthetic */ void c(EmojiStoreVpHeader emojiStoreVpHeader) {
        AppMethodBeat.i(109083);
        emojiStoreVpHeader.cHM();
        AppMethodBeat.o(109083);
    }

    public EmojiStoreVpHeader(Context context) {
        super(context);
        AppMethodBeat.i(109071);
        setOrientation(1);
        AppMethodBeat.o(109071);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109072);
        setOrientation(1);
        AppMethodBeat.o(109072);
    }

    public static int[] getScreenWH(Context context) {
        AppMethodBeat.i(109073);
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(109073);
        return iArr;
    }

    private synchronized void cHL() {
        int size;
        AppMethodBeat.i(109074);
        if (this.riI == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji baner list first");
            AppMethodBeat.o(109074);
            throw illegalAccessError;
        }
        if (this.jBN == null) {
            this.jBN = inflate(getContext(), R.layout.a3l, null);
            this.kHq = this.jBN.findViewById(R.id.c1u);
            this.oxc = (MMDotView) this.jBN.findViewById(R.id.c1t);
            this.riH = (ViewPager) this.jBN.findViewById(R.id.c1v);
            this.riM = new a(this, (byte) 0);
            int i2 = ((getScreenWH(getContext())[0] * 3) / 8) + 1;
            if (this.kHq != null) {
                this.kHq.setLayoutParams(new LinearLayout.LayoutParams(-1, i2));
            }
            addView(this.jBN, new LinearLayout.LayoutParams(-1, -2));
        }
        if (this.oxc != null) {
            MMDotView mMDotView = this.oxc;
            if (this.riI == null) {
                size = 0;
            } else {
                size = this.riI.size();
            }
            mMDotView.setDotCount(size);
            this.oxc.setSelectedDot(0);
            this.oxc.setVisibility(8);
        }
        if (this.riH == null || this.riI == null) {
            AppMethodBeat.o(109074);
        } else if (this.riI.size() <= 0) {
            if (this.kHq != null) {
                this.kHq.setVisibility(8);
            }
            AppMethodBeat.o(109074);
        } else {
            if (this.kHq != null) {
                this.kHq.setVisibility(0);
            }
            this.riH.setOnPageChangeListener(this);
            if (this.riJ == null) {
                this.riJ = new i(getContext(), this.riI);
                this.riH.setAdapter(this.riJ);
                this.riH.setOffscreenPageLimit(1);
                cHM();
                AppMethodBeat.o(109074);
            } else {
                post(new Runnable() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(109068);
                        if (!(EmojiStoreVpHeader.this.riJ == null || EmojiStoreVpHeader.this.riI == null)) {
                            i iVar = EmojiStoreVpHeader.this.riJ;
                            LinkedList linkedList = EmojiStoreVpHeader.this.riI;
                            iVar.qXN.clear();
                            iVar.qXN.addAll(linkedList);
                            iVar.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(109068);
                    }
                });
                AppMethodBeat.o(109074);
            }
        }
    }

    private void cHM() {
        AppMethodBeat.i(109075);
        if (this.riH == null) {
            AppMethodBeat.o(109075);
            return;
        }
        this.riH.setCurrentItem((i.qXO / 2) * this.riI.size(), false);
        AppMethodBeat.o(109075);
    }

    public final void cHN() {
        AppMethodBeat.i(109076);
        if (this.riM == null) {
            this.riM = new a(this, (byte) 0);
        }
        this.riN = true;
        this.riM.removeMessages(0);
        this.riM.sendEmptyMessageDelayed(0, 5000);
        AppMethodBeat.o(109076);
    }

    public final void cHO() {
        AppMethodBeat.i(109077);
        if (this.riM == null) {
            AppMethodBeat.o(109077);
            return;
        }
        this.riN = false;
        this.riM.removeMessages(0);
        AppMethodBeat.o(109077);
    }

    public final void clear() {
        AppMethodBeat.i(109078);
        if (this.riJ != null) {
            this.riJ.clear();
            this.riJ = null;
        }
        this.riM = null;
        AppMethodBeat.o(109078);
    }

    public final void d(LinkedList<EmotionBanner> linkedList, LinkedList<EmotionBannerSet> linkedList2) {
        AppMethodBeat.i(109079);
        if (linkedList == null) {
            AppMethodBeat.o(109079);
            return;
        }
        if (this.riI == null) {
            this.riI = new LinkedList<>();
        } else {
            this.riI.clear();
        }
        Iterator<EmotionBannerSet> it = linkedList2.iterator();
        while (it.hasNext()) {
            EmotionBannerSet next = it.next();
            if (!(next == null || next.BannerImg == null || Util.isNullOrNil(next.BannerImg.StripUrl))) {
                this.riI.add(new com.tencent.mm.plugin.emoji.model.a(null, next, true));
            }
        }
        Iterator<EmotionBanner> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            EmotionBanner next2 = it2.next();
            if (!(next2 == null || next2.BannerImg == null || Util.isNullOrNil(next2.BannerImg.StripUrl))) {
                this.riI.add(new com.tencent.mm.plugin.emoji.model.a(next2, null, false));
            }
        }
        cHL();
        AppMethodBeat.o(109079);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(109080);
        if (this.riI == null || this.riI.size() <= 1) {
            AppMethodBeat.o(109080);
            return;
        }
        if (i2 == 0 || i2 == this.riJ.getCount() - 1) {
            this.jBN.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(109069);
                    EmojiStoreVpHeader.c(EmojiStoreVpHeader.this);
                    AppMethodBeat.o(109069);
                }
            }, 350);
        }
        AppMethodBeat.o(109080);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(109081);
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.riK = rawX;
                this.riL = rawY;
                break;
            case 1:
            case 3:
                this.riK = 0.0f;
                this.riL = 0.0f;
                lu(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.riK)) > Math.abs((int) (rawY - this.riL))) {
                    lu(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                cHO();
                break;
            case 1:
            case 3:
                cHN();
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(109081);
        return onInterceptTouchEvent;
    }

    private void lu(boolean z) {
        AppMethodBeat.i(109082);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(109082);
    }

    /* access modifiers changed from: package-private */
    public class a extends MMHandler {
        private a() {
        }

        /* synthetic */ a(EmojiStoreVpHeader emojiStoreVpHeader, byte b2) {
            this();
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109070);
            if (!EmojiStoreVpHeader.this.riN && message.what != 0) {
                AppMethodBeat.o(109070);
            } else if (EmojiStoreVpHeader.this.riI == null || EmojiStoreVpHeader.this.riI.size() <= 1) {
                Log.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
                AppMethodBeat.o(109070);
            } else if (EmojiStoreVpHeader.this.riJ == null) {
                Log.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
                AppMethodBeat.o(109070);
            } else {
                int currentItem = EmojiStoreVpHeader.this.riH.getCurrentItem() + 1;
                if (currentItem >= EmojiStoreVpHeader.this.riJ.getCount()) {
                    currentItem = (EmojiStoreVpHeader.this.riI.size() * i.qXO) / 2;
                }
                EmojiStoreVpHeader.this.riH.setCurrentItem(currentItem);
                if (EmojiStoreVpHeader.this.riN && EmojiStoreVpHeader.this.riM != null) {
                    sendMessageDelayed(EmojiStoreVpHeader.this.riM.obtainMessage(0), 5000);
                }
                AppMethodBeat.o(109070);
            }
        }
    }
}
