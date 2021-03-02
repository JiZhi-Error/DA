package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager;
import com.tencent.mm.plugin.sns.ui.widget.ad.ViewPagerControlView;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.WebView;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class v extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a {
    private static final Map<String, Bitmap> Eer = new WeakHashMap();
    AutoPlayViewPager Ees;
    a Eet;
    ViewPagerControlView Eeu;
    private int Eev = 1;
    private ak Eew;
    private boolean autoCarousel = false;
    private int zaD = 0;

    static {
        AppMethodBeat.i(96612);
        AppMethodBeat.o(96612);
    }

    public v(Context context, ak akVar, ViewGroup viewGroup) {
        super(context, akVar, viewGroup);
        AppMethodBeat.i(96602);
        this.Eeu = new ViewPagerControlView(context);
        AppMethodBeat.o(96602);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96603);
        this.Eet.YV(this.zaD);
        this.Eet.YW(this.zaD);
        super.eWZ();
        AppMethodBeat.o(96603);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXb() {
        AppMethodBeat.i(202984);
        super.eXb();
        if (this.Ees != null) {
            this.Ees.startAutoPlay();
        }
        AppMethodBeat.o(202984);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96604);
        this.Eet.YW(-1);
        super.eXa();
        if (this.Ees != null) {
            this.Ees.pauseAutoPlay();
        }
        AppMethodBeat.o(96604);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final void eXc() {
        AppMethodBeat.i(96605);
        this.Eet.YW(this.zaD);
        AppMethodBeat.o(96605);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void aQ(Map<String, Object> map) {
        AppMethodBeat.i(96606);
        super.aQ(map);
        try {
            if (map.containsKey("startIndex")) {
                this.Eev = ((Integer) map.get("startIndex")).intValue() + 1;
            }
            if (this.Ees != null) {
                this.Ees.setCurrentItem(this.Eev, false);
                AppMethodBeat.o(96606);
                return;
            }
            Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "when setOriginState, but viewPager is null");
            AppMethodBeat.o(96606);
        } catch (Exception e2) {
            Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", e2.toString());
            AppMethodBeat.o(96606);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void fdq() {
        AppMethodBeat.i(96607);
        super.fdq();
        this.Ees.setCurrentItem(this.Eev, false);
        AppMethodBeat.o(96607);
    }

    private ak a(ak akVar) {
        AppMethodBeat.i(202985);
        this.Eew = new ak();
        if (akVar == null) {
            ak akVar2 = this.Eew;
            AppMethodBeat.o(202985);
            return akVar2;
        }
        this.Eew.DZi = akVar.DZi;
        this.Eew.DZj = akVar.DZj;
        this.Eew.paddingTop = akVar.paddingTop;
        this.Eew.paddingBottom = akVar.paddingBottom;
        this.Eew.paddingLeft = akVar.paddingLeft;
        this.Eew.paddingRight = akVar.paddingRight;
        this.Eew.DZk = akVar.DZk;
        this.Eew.DZl = akVar.DZl;
        this.Eew.DZm = akVar.DZm;
        this.Eew.subType = akVar.subType;
        this.Eew.type = akVar.type;
        this.Eew.DZn = akVar.DZn;
        this.Eew.width = akVar.width;
        this.Eew.height = akVar.height;
        this.Eew.DZo = akVar.DZo;
        this.Eew.DZp = akVar.DZp;
        this.Eew.DZq = akVar.DZq;
        this.Eew.DZr = akVar.DZr;
        this.Eew.Eac = akVar.Eac;
        this.Eew.onr = akVar.onr;
        this.Eew.autoCarousel = akVar.autoCarousel;
        this.Eew.DYI.add(akVar.DYI.getLast());
        this.Eew.DYI.addAll(akVar.DYI);
        this.Eew.DYI.add(akVar.DYI.getFirst());
        ak akVar3 = this.Eew;
        AppMethodBeat.o(202985);
        return akVar3;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        a aVar;
        int i2;
        int i3;
        int measuredHeight;
        AppMethodBeat.i(96608);
        int i4 = (this.mEX - ((int) ((ak) this.EcX).paddingLeft)) - ((int) ((ak) this.EcX).paddingRight);
        int i5 = this.mEY;
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        a((ak) this.EcX);
        if (this.Ees.getAdapter() == null) {
            final a aVar2 = new a(this.context, layoutInflater, this.Eew, this.backgroundColor, this.Ees);
            this.Ees.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.AnonymousClass1 */

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public final void onPageScrolled(int i2, float f2, int i3) {
                    AppMethodBeat.i(202981);
                    v.this.Eeu.v(i2, f2);
                    AppMethodBeat.o(202981);
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public final void onPageSelected(int i2) {
                    AppMethodBeat.i(96584);
                    Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", Integer.valueOf(i2));
                    v.this.zaD = i2;
                    if (v.this.EcZ) {
                        aVar2.YV(i2);
                        aVar2.YW(i2);
                    }
                    AppMethodBeat.o(96584);
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public final void onPageScrollStateChanged(int i2) {
                }
            });
            this.Ees.setAdapter(aVar2);
            aVar = aVar2;
        } else {
            a aVar3 = (a) this.Ees.getAdapter();
            aVar3.Eez = a((ak) this.EcX);
            aVar = aVar3;
        }
        this.autoCarousel = ((ak) this.EcX).autoCarousel;
        this.Eeu.aX(this.Eew.DYI.size(), this.autoCarousel);
        this.Ees.bindViewPagerControlView(this.Eeu, this.autoCarousel);
        if (((ak) this.EcX).onr) {
            this.Ees.setLayoutParams(new RelativeLayout.LayoutParams(i4, i5));
        } else if (((ak) this.EcX).DYI.size() > 0) {
            new LinearLayout(this.context).setOrientation(1);
            int i6 = 0;
            Iterator<z> it = ((ak) this.EcX).DYI.get(0).DYI.iterator();
            while (it.hasNext()) {
                z next = it.next();
                int i7 = (int) (((float) i6) + next.paddingTop);
                if (next instanceof ag) {
                    ag agVar = (ag) next;
                    View inflate = layoutInflater.inflate(R.layout.buq, (ViewGroup) null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    try {
                        TextView textView = (TextView) inflate.findViewById(R.id.hvk);
                        textView.setText(agVar.DZP);
                        if (agVar.textSize > 0.0f) {
                            textView.setTextSize(0, agVar.textSize);
                        }
                        if (agVar.DZT > 0.0f) {
                            textView.setLineSpacing(0.0f, agVar.DZT + 1.0f);
                        }
                        if (agVar.DZQ) {
                            textView.getPaint().setFakeBoldText(true);
                        }
                        textView.measure(View.MeasureSpec.makeMeasureSpec((int) ((((float) i4) - agVar.paddingLeft) - agVar.paddingRight), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                        i2 = textView.getPaddingBottom() + i7 + textView.getPaddingTop() + textView.getMeasuredHeight();
                    } catch (Exception e2) {
                        i2 = i7;
                        Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + e2.toString());
                    }
                } else if (next instanceof q) {
                    Button button = (Button) layoutInflater.inflate(R.layout.bub, (ViewGroup) null).findViewById(R.id.hvo);
                    button.setText(((q) next).title);
                    button.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i7;
                    if (next.DZl > 0.0f && ((int) next.DZl) != Integer.MAX_VALUE) {
                        measuredHeight = (int) (((float) paddingTop) + next.DZl);
                    } else if (next.height <= 0.0f || ((int) next.height) == Integer.MAX_VALUE) {
                        measuredHeight = paddingTop + button.getMeasuredHeight();
                    } else {
                        measuredHeight = (int) (((float) paddingTop) + next.height);
                    }
                    i2 = button.getPaddingBottom() + measuredHeight;
                } else if (next instanceof t) {
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    float f4 = next.paddingTop;
                    float f5 = next.paddingBottom;
                    if (next instanceof t) {
                        t tVar = (t) next;
                        f2 = tVar.height;
                        f3 = tVar.width;
                    }
                    if (((int) f2) == 0 || ((int) f3) == 0) {
                        i3 = i7 + i5;
                    } else {
                        i3 = (int) (((f2 * ((float) i4)) / f3) + ((float) i7));
                    }
                    i2 = (int) (((float) ((int) (((float) i3) + f4))) + f5);
                } else if (next instanceof s) {
                    i2 = i7 + i5;
                } else if (next instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v vVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) next;
                    if (vVar.DYW == 1) {
                        i2 = i7 + i5;
                    } else if (((int) vVar.width) > 0) {
                        i2 = ((((int) vVar.height) * i4) / ((int) vVar.width)) + i7;
                    } else {
                        i2 = (int) (vVar.height + ((float) i7));
                    }
                } else if (next instanceof am) {
                    am amVar = (am) next;
                    if (amVar.Eae != 1) {
                        i2 = i7 + i5;
                    } else if (((int) amVar.width) > 0) {
                        i2 = ((((int) amVar.height) * i4) / ((int) amVar.width)) + i7;
                    } else {
                        i2 = (int) (amVar.height + ((float) i7));
                    }
                } else if (next instanceof al) {
                    i2 = i7 + i5;
                } else {
                    i2 = i7;
                }
                i6 = (int) (next.paddingBottom + ((float) i2));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i6);
            layoutParams.leftMargin = (int) ((ak) this.EcX).paddingLeft;
            layoutParams.rightMargin = (int) ((ak) this.EcX).paddingRight;
            this.Ees.setLayoutParams(layoutParams);
        }
        this.Eet = aVar;
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(96608);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96609);
        View view = this.contentView;
        this.Ees = (AutoPlayViewPager) view.findViewById(R.id.hw3);
        this.Eeu = (ViewPagerControlView) view.findViewById(R.id.hvl);
        AppMethodBeat.o(96609);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bus;
    }

    static class a extends android.support.v4.view.q {
        private int EeA = 600;
        int EeB = 700;
        int EeC = 250;
        HashMap<Integer, View> EeD = new HashMap<>();
        HashMap<Integer, C1722a> EeE = new HashMap<>();
        Set<String> EeF = new HashSet();
        ak Eez;
        int backgroundColor;
        Context mContext;
        int mEX;
        int mEY;
        LayoutInflater mLayoutInflater;
        private ViewPager riH;

        public a(Context context, LayoutInflater layoutInflater, ak akVar, int i2, ViewPager viewPager) {
            AppMethodBeat.i(202982);
            this.mContext = context;
            this.mLayoutInflater = layoutInflater;
            this.Eez = akVar;
            this.backgroundColor = i2;
            int[] ha = ap.ha(context);
            this.mEX = ha[0];
            this.mEY = ha[1];
            this.riH = viewPager;
            AppMethodBeat.o(202982);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(96592);
            int size = this.Eez.DYI.size();
            AppMethodBeat.o(96592);
            return size;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        @Override // android.support.v4.view.q
        public final void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(96593);
            super.setPrimaryItem((View) viewGroup, i2, obj);
            AppMethodBeat.o(96593);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            int i3;
            AppMethodBeat.i(96594);
            Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", Integer.valueOf(i2));
            if (this.EeD.containsKey(Integer.valueOf(i2))) {
                View view = this.EeD.get(Integer.valueOf(i2));
                AppMethodBeat.o(96594);
                return view;
            }
            Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", Integer.valueOf(i2));
            View inflate = this.mLayoutInflater.inflate(R.layout.bur, viewGroup, false);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.hvx);
            linearLayout.setBackgroundColor(this.backgroundColor);
            C1722a aVar = this.EeE.get(Integer.valueOf(i2));
            LinkedList<z> linkedList = this.Eez.DYI.get(i2).DYI;
            if (aVar == null || aVar.EeL.size() == 0) {
                C1722a aVar2 = new C1722a();
                if (linkedList != null) {
                    for (int i4 = 0; i4 < linkedList.size(); i4++) {
                        z zVar = linkedList.get(i4);
                        Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", zVar.DZi);
                        aVar2.EeL.add(ay.a(this.mContext, zVar, linearLayout, this.backgroundColor));
                    }
                }
                this.EeE.put(Integer.valueOf(i2), aVar2);
                aVar = aVar2;
            }
            Iterator<m> it = aVar.EeL.iterator();
            while (it.hasNext()) {
                View view2 = it.next().getView();
                if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                linearLayout.addView(view2);
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.hvz);
            TextView textView = (TextView) inflate.findViewById(R.id.hvy);
            if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.drawable.cjm));
            } else {
                imageView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.drawable.cjn));
            }
            if (this.Eez.Eac == 1) {
                imageView.setVisibility(8);
                textView.setVisibility(8);
            } else {
                if (i2 == this.Eez.DYI.size() - 1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                int count = getCount() - 2;
                if (i2 == 0) {
                    imageView.setVisibility(8);
                    i3 = count;
                } else if (i2 >= getCount() - 1) {
                    imageView.setVisibility(0);
                    i3 = 1;
                } else {
                    if (i2 == count) {
                        imageView.setVisibility(8);
                    }
                    i3 = i2;
                }
                textView.setText(i3 + FilePathGenerator.ANDROID_DIR_SEP + count);
            }
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, linearLayout.getMeasuredHeight()));
            inflate.setBackgroundColor(this.backgroundColor);
            viewGroup.addView(inflate);
            viewGroup.setBackgroundColor(this.backgroundColor);
            this.EeD.put(Integer.valueOf(i2), inflate);
            AppMethodBeat.o(96594);
            return inflate;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(96595);
            viewGroup.removeView((View) obj);
            this.EeD.remove(Integer.valueOf(i2));
            AppMethodBeat.o(96595);
        }

        @Override // android.support.v4.view.q
        public final void finishUpdate(ViewGroup viewGroup) {
            AppMethodBeat.i(202983);
            super.finishUpdate(viewGroup);
            int currentItem = this.riH.getCurrentItem();
            if (currentItem == 0) {
                currentItem = getCount() - 2;
            } else if (currentItem >= getCount() - 1) {
                currentItem = 1;
            }
            this.riH.setCurrentItem(currentItem, false);
            AppMethodBeat.o(202983);
        }

        @Override // android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(96596);
            for (Integer num : this.EeD.keySet()) {
                int intValue = num.intValue();
                if (this.EeD.get(Integer.valueOf(intValue)) == obj) {
                    AppMethodBeat.o(96596);
                    return intValue;
                }
            }
            AppMethodBeat.o(96596);
            return -2;
        }

        private void k(final ImageView imageView) {
            AppMethodBeat.i(96597);
            imageView.setAlpha(0.0f);
            imageView.setTag("1");
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.EeA);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.a.AnonymousClass2 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(96589);
                    imageView.setAlpha(0.8f);
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.a.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(96588);
                            a.a(a.this, imageView);
                            AppMethodBeat.o(96588);
                        }
                    }, 200);
                    AppMethodBeat.o(96589);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(alphaAnimation);
            AppMethodBeat.o(96597);
        }

        public final void YV(int i2) {
            AppMethodBeat.i(96598);
            View view = this.EeD.get(Integer.valueOf(i2));
            if (view == null) {
                AppMethodBeat.o(96598);
                return;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.hvz);
            if (imageView != null && imageView.getVisibility() == 0) {
                k(imageView);
            }
            AppMethodBeat.o(96598);
        }

        public final void YW(int i2) {
            AppMethodBeat.i(96599);
            for (Integer num : this.EeE.keySet()) {
                C1722a aVar = this.EeE.get(num);
                if (!(aVar == null || aVar.EeL.size() == 0)) {
                    if (num.intValue() == i2) {
                        for (int i3 = 0; i3 < aVar.EeL.size(); i3++) {
                            m mVar = aVar.EeL.get(i3);
                            if (mVar.fdm()) {
                                mVar.eWZ();
                                mVar.eXb();
                                this.EeF.add(mVar.fdn());
                            } else if (this.EeF.contains(mVar.fdn())) {
                                mVar.eXa();
                                this.EeF.remove(mVar.fdn());
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < aVar.EeL.size(); i4++) {
                            m mVar2 = aVar.EeL.get(i4);
                            if (this.EeF.contains(mVar2.fdn())) {
                                mVar2.eXa();
                                this.EeF.remove(mVar2.fdn());
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(96599);
        }

        public final List<m> eXi() {
            AppMethodBeat.i(96600);
            ArrayList arrayList = new ArrayList();
            for (C1722a aVar : this.EeE.values()) {
                arrayList.addAll(aVar.EeL);
            }
            AppMethodBeat.o(96600);
            return arrayList;
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v$a$a  reason: collision with other inner class name */
        public class C1722a {
            public LinkedList<m> EeL = new LinkedList<>();

            public C1722a() {
                AppMethodBeat.i(96590);
                AppMethodBeat.o(96590);
            }
        }

        static /* synthetic */ void a(a aVar, final ImageView imageView) {
            AppMethodBeat.i(96601);
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) aVar.EeB);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.3f);
            alphaAnimation.setDuration((long) aVar.EeB);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.a.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(96587);
                    AnimationSet animationSet = new AnimationSet(true);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) a.this.EeB);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) a.this.EeB);
                    animationSet.addAnimation(translateAnimation);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 0.8f);
                    alphaAnimation.setDuration((long) a.this.EeB);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    alphaAnimation.setStartTime((long) a.this.EeB);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.a.AnonymousClass1.AnonymousClass1 */

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(96586);
                            long longValue = new BigInteger((String) imageView.getTag()).longValue();
                            if (longValue >= 3) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                                alphaAnimation.setDuration((long) a.this.EeC);
                                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        AppMethodBeat.i(96585);
                                        imageView.setAlpha(0.0f);
                                        AppMethodBeat.o(96585);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                imageView.startAnimation(alphaAnimation);
                                AppMethodBeat.o(96586);
                                return;
                            }
                            imageView.setTag(String.valueOf(longValue + 1));
                            a.a(a.this, imageView);
                            AppMethodBeat.o(96586);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(animationSet);
                    AppMethodBeat.o(96587);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
            AppMethodBeat.o(96601);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96610);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96610);
            return false;
        }
        AppMethodBeat.o(96610);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
    public final List<m> eWU() {
        AppMethodBeat.i(96611);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((a) this.Ees.getAdapter()).eXi());
        AppMethodBeat.o(96611);
        return arrayList;
    }
}
