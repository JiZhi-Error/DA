package com.tencent.mm.plugin.appbrand.keylogger;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.b;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.c;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.av;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KeyStepAnalyserDetailActivity extends KeyStepBaseActivity {
    private static int mOI = 3;
    private static SimpleDateFormat mOJ = new SimpleDateFormat("HH:mm:ss");
    private Class mOB;
    private String mOC;
    private View mOK;
    private View mOL;
    private LinearLayout mOM;
    private float mON;
    private float mOO;
    private float mOP;
    private float mOQ;
    private float mOR = 1.0f;
    private float mOS = 1.0f;
    private boolean mOT;
    private Map<String, c> mOU;
    private Map<String, Boolean> mOV;
    private ScaleGestureDetector.OnScaleGestureListener mOW = new ScaleGestureDetector.SimpleOnScaleGestureListener() {
        /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.AnonymousClass5 */

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            AppMethodBeat.i(221264);
            if (KeyStepAnalyserDetailActivity.this.mOM == null) {
                AppMethodBeat.o(221264);
                return true;
            }
            KeyStepAnalyserDetailActivity.this.mOR = scaleGestureDetector.getScaleFactor() * KeyStepAnalyserDetailActivity.this.mOS;
            if (KeyStepAnalyserDetailActivity.this.mOR > 5.0f || KeyStepAnalyserDetailActivity.this.mOR < 0.1f) {
                AppMethodBeat.o(221264);
                return true;
            }
            KeyStepAnalyserDetailActivity.this.mOM.setTranslationX(KeyStepAnalyserDetailActivity.this.mON);
            KeyStepAnalyserDetailActivity.this.mOM.setTranslationY(KeyStepAnalyserDetailActivity.this.mOO);
            KeyStepAnalyserDetailActivity.this.mOM.setPivotX(KeyStepAnalyserDetailActivity.this.mOP);
            KeyStepAnalyserDetailActivity.this.mOM.setPivotY(KeyStepAnalyserDetailActivity.this.mOQ);
            KeyStepAnalyserDetailActivity.this.mOM.setScaleX(KeyStepAnalyserDetailActivity.this.mOR);
            KeyStepAnalyserDetailActivity.this.mOM.setScaleY(KeyStepAnalyserDetailActivity.this.mOR);
            KeyStepAnalyserDetailActivity.this.mOS = KeyStepAnalyserDetailActivity.this.mOR;
            AppMethodBeat.o(221264);
            return false;
        }
    };
    private ScaleGestureDetector mScaleGestureDetector;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public KeyStepAnalyserDetailActivity() {
        AppMethodBeat.i(221265);
        AppMethodBeat.o(221265);
    }

    static {
        AppMethodBeat.i(221270);
        AppMethodBeat.o(221270);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(221266);
        super.onCreate(bundle);
        this.mOK = findViewById(R.id.bq1);
        this.mOL = findViewById(R.id.in4);
        this.mOB = (Class) getIntent().getSerializableExtra("key_process_class");
        this.mOC = getIntent().getStringExtra("key_process_category");
        setTitle(getString(R.string.e_n));
        View findViewById = findViewById(R.id.bq2);
        ((TextView) findViewById(R.id.e5z)).setText(getIntent().getStringExtra("key_info"));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.hl);
        String str = getString(R.string.e_t) + " ";
        String str2 = getString(R.string.e_r) + " ";
        String str3 = getString(R.string.e_s) + " ";
        String string = getString(R.string.e_u);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(str2).append(str3).append(string);
        SpannableString spannableString = new SpannableString(sb.toString());
        Drawable l = b.l(this, R.drawable.btl);
        l.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(l, 0), 0, 1, 17);
        int length = str.length() + 0;
        Drawable l2 = b.l(this, R.drawable.btk);
        l2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(l2, 0), length, length + 1, 17);
        int length2 = length + str2.length();
        Drawable l3 = b.l(this, R.drawable.btj);
        l3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(l3, 0), length2, length2 + 1, 17);
        int length3 = length2 + str3.length();
        Drawable l4 = b.l(this, R.drawable.btm);
        l4.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(l4, 0), length3, length3 + 1, 17);
        ((TextView) findViewById(R.id.dtp)).setText(spannableString);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(221261);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserDetailActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                KeyStepAnalyserDetailActivity.a(KeyStepAnalyserDetailActivity.this);
                a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserDetailActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(221261);
            }
        });
        bMN();
        AppMethodBeat.o(221266);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public final int getLayoutId() {
        return R.layout.bu;
    }

    private void bMN() {
        SpannableString spannableString;
        AppMethodBeat.i(221267);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("steps");
        LinkedList linkedList = new LinkedList(parcelableArrayListExtra);
        Collections.sort(linkedList, new Comparator<IKeyStepAnalyser.StepLogInfo>() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(IKeyStepAnalyser.StepLogInfo stepLogInfo, IKeyStepAnalyser.StepLogInfo stepLogInfo2) {
                IKeyStepAnalyser.StepLogInfo stepLogInfo3 = stepLogInfo;
                IKeyStepAnalyser.StepLogInfo stepLogInfo4 = stepLogInfo2;
                if (stepLogInfo3.cCv > stepLogInfo4.cCv) {
                    return -1;
                }
                if (stepLogInfo3.cCv < stepLogInfo4.cCv) {
                    return 1;
                }
                return 0;
            }
        });
        this.mOV = new HashMap();
        int i2 = 0;
        while (i2 < linkedList.size() && i2 <= mOI) {
            IKeyStepAnalyser.StepLogInfo stepLogInfo = (IKeyStepAnalyser.StepLogInfo) linkedList.get(i2);
            if (stepLogInfo.cCv > 0 && !stepLogInfo.bMX()) {
                this.mOV.put(((IKeyStepAnalyser.StepLogInfo) linkedList.get(i2)).mPw, Boolean.TRUE);
            }
            i2++;
        }
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < parcelableArrayListExtra.size(); i3++) {
            IKeyStepAnalyser.StepLogInfo stepLogInfo2 = (IKeyStepAnalyser.StepLogInfo) parcelableArrayListExtra.get(i3);
            hashMap.put(stepLogInfo2.mPw, stepLogInfo2);
        }
        List<j> g2 = f.g(this.mOB, this.mOC);
        this.mOU = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < g2.size(); i4++) {
            com.tencent.mm.plugin.appbrand.keylogger.base.a aVar = g2.get(i4).mPG;
            IKeyStepAnalyser.StepLogInfo stepLogInfo3 = (IKeyStepAnalyser.StepLogInfo) hashMap.get(aVar.name());
            int i5 = 0;
            if (stepLogInfo3 == null) {
                int i6 = aVar.FI() ? -2 : -1;
                spannableString = new SpannableString(Util.isNullOrNil(aVar.bMW()) ? aVar.name() : aVar.bMW());
                i5 = i6;
            } else {
                if (!stepLogInfo3.errMsg.equals("ok")) {
                    i5 = aVar.bMV() ? 1 : 2;
                }
                Object[] objArr = new Object[4];
                objArr[0] = mOJ.format(Long.valueOf(stepLogInfo3.time));
                objArr[1] = Util.isNullOrNil(aVar.bMW()) ? aVar.name() : aVar.bMW();
                objArr[2] = stepLogInfo3.errMsg;
                objArr[3] = stepLogInfo3.mPy;
                String format = String.format("%s %s:%s %s", objArr);
                int length = format.length();
                int i7 = 0;
                if (stepLogInfo3.cCv > 0) {
                    String format2 = String.format(" cost:%d ms", Long.valueOf(stepLogInfo3.cCv));
                    i7 = format2.length();
                    format = format + format2;
                }
                SpannableString spannableString2 = new SpannableString(format);
                if (this.mOV.containsKey(stepLogInfo3.mPw)) {
                    spannableString2.setSpan(new ForegroundColorSpan(-65536), length, i7 + length, 33);
                }
                spannableString = spannableString2;
            }
            c cVar = new c(spannableString, i5);
            arrayList.add(cVar);
            this.mOU.put(aVar.name(), cVar);
        }
        VerticalStepView verticalStepView = (VerticalStepView) findViewById(R.id.i5t);
        verticalStepView.mPM = arrayList;
        verticalStepView.mPL.setSteps(arrayList);
        AppMethodBeat.o(221267);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(221268);
        if (this.mScaleGestureDetector == null || this.mOK.getVisibility() != 0) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(221268);
            return dispatchTouchEvent;
        }
        super.dispatchTouchEvent(motionEvent);
        boolean onTouchEvent = this.mScaleGestureDetector.onTouchEvent(motionEvent);
        AppMethodBeat.o(221268);
        return onTouchEvent;
    }

    static /* synthetic */ void a(final KeyStepAnalyserDetailActivity keyStepAnalyserDetailActivity) {
        AppMethodBeat.i(221269);
        if (keyStepAnalyserDetailActivity.mOK.getVisibility() == 0) {
            keyStepAnalyserDetailActivity.mOK.setVisibility(8);
            keyStepAnalyserDetailActivity.mOL.setVisibility(0);
            AppMethodBeat.o(221269);
            return;
        }
        if (!keyStepAnalyserDetailActivity.mOT) {
            keyStepAnalyserDetailActivity.mOM = (LinearLayout) keyStepAnalyserDetailActivity.findViewById(R.id.bq0);
            keyStepAnalyserDetailActivity.mScaleGestureDetector = new ScaleGestureDetector(keyStepAnalyserDetailActivity, keyStepAnalyserDetailActivity.mOW);
            final HashMap hashMap = new HashMap();
            final com.tencent.mm.plugin.appbrand.keylogger.stepview.b bVar = new com.tencent.mm.plugin.appbrand.keylogger.stepview.b(keyStepAnalyserDetailActivity, false);
            bVar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.AnonymousClass3 */

                public final void onGlobalLayout() {
                    AppMethodBeat.i(221262);
                    bVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (bVar.getWidth() > 0) {
                        Point az = av.az(keyStepAnalyserDetailActivity);
                        KeyStepAnalyserDetailActivity.this.mON = (float) ((az.x / 2) - (bVar.getWidth() / 2));
                        KeyStepAnalyserDetailActivity.this.mOO = (float) ((((az.y / 2) - (bVar.getHeight() / 2)) - KeyStepAnalyserDetailActivity.this.findViewById(R.id.dnu).getHeight()) - KeyStepAnalyserDetailActivity.this.findViewById(R.id.c7).getHeight());
                        KeyStepAnalyserDetailActivity.this.mOP = ((float) bVar.getWidth()) / 2.0f;
                        KeyStepAnalyserDetailActivity.this.mOQ = ((float) bVar.getHeight()) / 2.0f;
                        KeyStepAnalyserDetailActivity.this.mOR = KeyStepAnalyserDetailActivity.this.mOS = ((float) az.x) / ((float) bVar.getWidth());
                        KeyStepAnalyserDetailActivity.this.mOM.setTranslationX(KeyStepAnalyserDetailActivity.this.mON);
                        KeyStepAnalyserDetailActivity.this.mOM.setTranslationY(KeyStepAnalyserDetailActivity.this.mOO);
                        KeyStepAnalyserDetailActivity.this.mOM.setPivotX(KeyStepAnalyserDetailActivity.this.mOP);
                        KeyStepAnalyserDetailActivity.this.mOM.setPivotY(KeyStepAnalyserDetailActivity.this.mOQ);
                        KeyStepAnalyserDetailActivity.this.mOM.setScaleX(KeyStepAnalyserDetailActivity.this.mOR);
                        KeyStepAnalyserDetailActivity.this.mOM.setScaleY(KeyStepAnalyserDetailActivity.this.mOR);
                        KeyStepAnalyserDetailActivity.this.mOK.requestLayout();
                    }
                    AppMethodBeat.o(221262);
                }
            });
            f.a(keyStepAnalyserDetailActivity.mOB, new h.b() {
                /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.keylogger.base.h.b
                public final void a(h hVar) {
                    AppMethodBeat.i(221263);
                    int type = hVar.mPD.getType();
                    int bMZ = hVar.mPD.bMZ();
                    com.tencent.mm.plugin.appbrand.keylogger.stepview.b bVar = hashMap.containsKey(Integer.valueOf(bMZ)) ? (com.tencent.mm.plugin.appbrand.keylogger.stepview.b) hashMap.get(Integer.valueOf(bMZ)) : bVar;
                    com.tencent.mm.plugin.appbrand.keylogger.base.a bNb = hVar.bNb();
                    if (type == 1) {
                        d dVar = new d(keyStepAnalyserDetailActivity);
                        dVar.setStep((c) KeyStepAnalyserDetailActivity.this.mOU.get(hVar.bNb().name()));
                        bVar.addView(dVar);
                        AppMethodBeat.o(221263);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.keylogger.stepview.b bVar2 = new com.tencent.mm.plugin.appbrand.keylogger.stepview.b(keyStepAnalyserDetailActivity, type == 3);
                    if (hashMap.size() > 0) {
                        bVar2.setHasBorder(true);
                    }
                    if (bNb != null) {
                        bVar2.setStep((c) KeyStepAnalyserDetailActivity.this.mOU.get(bNb.name()));
                    }
                    bVar.addView(bVar2);
                    hashMap.put(Integer.valueOf(hVar.mPD.bMY()), bVar2);
                    AppMethodBeat.o(221263);
                }
            }, keyStepAnalyserDetailActivity.mOC);
            keyStepAnalyserDetailActivity.mOM.addView(bVar);
            keyStepAnalyserDetailActivity.mOT = true;
        }
        keyStepAnalyserDetailActivity.mOK.setVisibility(0);
        keyStepAnalyserDetailActivity.mOL.setVisibility(8);
        AppMethodBeat.o(221269);
    }
}
