package com.tencent.mm.plugin.sns.h;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class b implements e {
    private int CHZ = -1;
    private int[] DQA = this.DQy;
    private int[] DQB;
    private int[] DQC;
    Map<Long, C1714b> DQD = new HashMap();
    private Map<Long, C1714b> DQE = new HashMap();
    private HashSet<Long> DQF = new HashSet<>();
    h DQG = null;
    private HashMap<Long, Boolean> DQH = new HashMap<>();
    public final int DQr = 14;
    private c DQs;
    private FrameLayout DQt;
    AbsoluteLayout DQu = null;
    protected Animation DQv;
    protected Animation DQw;
    boolean DQx = false;
    int[] DQy = {R.string.h2z, R.string.h30, R.string.h31, R.string.h32};
    private int[] DQz = {R.raw.album_test_donotlook, R.raw.album_test_unlike, R.raw.album_test_open, R.raw.album_test_close};
    private boolean dGX = true;
    Context mContext;

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z, bq bqVar) {
        AppMethodBeat.i(96095);
        if (z && this.dGX && this.DQG != null && bqVar != null) {
            this.DQF.add(Long.valueOf(j2));
            this.DQE.put(Long.valueOf(j2), new C1714b(j2, this.DQG.DQS, this.DQG.DQT, bqVar.fjV()));
        }
        AppMethodBeat.o(96095);
    }

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z) {
        C1714b bVar;
        AppMethodBeat.i(96096);
        if (z && this.dGX) {
            if (this.DQF.contains(Long.valueOf(j2))) {
                boolean z2 = false;
                if (this.DQH.containsKey(Long.valueOf(j2))) {
                    z2 = this.DQH.get(Long.valueOf(j2)).booleanValue();
                }
                if (z2 && (bVar = this.DQE.get(Long.valueOf(j2))) != null) {
                    bVar.report();
                }
            }
            this.DQE.remove(Long.valueOf(j2));
            this.DQF.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(96096);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.sns.h.b$b  reason: collision with other inner class name */
    public static class C1714b {
        StringBuffer DQP = new StringBuffer();
        long DQQ;
        long DQR;
        String DQS;
        String DQT;
        long DuE;
        String uxInfo;

        public C1714b(long j2, String str, String str2, String str3, String str4) {
            AppMethodBeat.i(96089);
            this.uxInfo = str;
            this.DQS = str2;
            this.DQT = str3;
            this.DuE = j2;
            this.DQQ = System.currentTimeMillis();
            this.DQP.append("1:0:".concat(String.valueOf(str4)));
            AppMethodBeat.o(96089);
        }

        public C1714b(long j2, String str, String str2, String str3) {
            AppMethodBeat.i(96090);
            this.uxInfo = str;
            this.DQS = str2;
            this.DQT = str3;
            this.DuE = j2;
            this.DQQ = System.currentTimeMillis();
            this.DQP.append("0:0:");
            AppMethodBeat.o(96090);
        }

        public final void aPL(String str) {
            AppMethodBeat.i(96091);
            Log.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(str)));
            if (this.DQP.length() != 0) {
                this.DQP.append("|");
            }
            this.DQP.append(str);
            AppMethodBeat.o(96091);
        }

        public final boolean fcm() {
            AppMethodBeat.i(96092);
            if (this.DQP == null || this.DQP.length() == 0) {
                AppMethodBeat.o(96092);
                return false;
            } else if (this.DQP.toString().startsWith("1:0")) {
                AppMethodBeat.o(96092);
                return true;
            } else {
                AppMethodBeat.o(96092);
                return false;
            }
        }

        public final boolean fcn() {
            AppMethodBeat.i(96093);
            if (this.DQP == null || this.DQP.length() == 0) {
                AppMethodBeat.o(96093);
                return false;
            }
            AppMethodBeat.o(96093);
            return true;
        }

        public final void report() {
            AppMethodBeat.i(96094);
            this.DQR = System.currentTimeMillis();
            Log.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.DuE + " uxinfo:" + this.uxInfo + " actionresult: " + ((Object) this.DQP) + " " + this.DQQ + " " + this.DQR);
            h.INSTANCE.a(11988, this.DQT, this.DQS, "", "", r.Jb(this.DuE), this.uxInfo, this.DQP, Long.valueOf(this.DQQ / 1000), Long.valueOf(this.DQR / 1000));
            AppMethodBeat.o(96094);
        }
    }

    public final void a(C1714b bVar) {
        AppMethodBeat.i(96097);
        this.DQD.remove(Long.valueOf(bVar.DuE));
        bVar.report();
        AppMethodBeat.o(96097);
    }

    public b(Context context, c cVar, FrameLayout frameLayout) {
        AppMethodBeat.i(96098);
        g faG = aj.faG();
        h hVar = new h();
        com.tencent.mm.storage.c Fu = d.aXu().Fu("100007");
        if (!Fu.isValid()) {
            Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        } else {
            Map<String, String> gzz = Fu.gzz();
            if (gzz != null) {
                Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + Fu.field_expId + " " + Fu.field_layerId + " " + Fu.field_startTime + " " + Fu.field_endTime);
                hVar.f(Fu.field_layerId, Fu.field_expId, gzz);
            }
        }
        faG.DRF = hVar;
        this.DQG = aj.faG().fcp();
        if (this.DQG != null) {
            this.DQB = this.DQG.DRH;
            if (!this.DQG.fcq()) {
                this.dGX = false;
            }
        }
        this.mContext = context;
        this.DQs = cVar;
        this.DQt = frameLayout;
        this.DQv = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.DQv = AnimationUtils.loadAnimation(context, R.anim.ax);
        this.DQw = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.DQw = AnimationUtils.loadAnimation(context, R.anim.ay);
        AppMethodBeat.o(96098);
    }

    /* access modifiers changed from: package-private */
    public class a {
        View Atk = null;
        String DQN;
        ADXml DQO;
        long ece;

        public a(String str, View view, long j2, ADXml aDXml) {
            this.DQN = str;
            this.Atk = view;
            this.DQO = aDXml;
            this.ece = j2;
        }
    }

    public final int fk(final View view) {
        boolean z;
        int i2;
        AppMethodBeat.i(96099);
        if (this.DQx) {
            AppMethodBeat.o(96099);
            return 0;
        } else if (this.DQu != null) {
            if (this.DQu.getTag() instanceof a) {
                final View view2 = ((a) this.DQu.getTag()).Atk;
                this.DQx = true;
                view2.startAnimation(this.DQw);
                this.DQw.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.sns.h.b.AnonymousClass5 */

                    public final void onAnimationStart(Animation animation) {
                        b.this.DQx = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(96088);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            b.this.fcl();
                        }
                        b.this.DQx = false;
                        AppMethodBeat.o(96088);
                    }
                });
            } else {
                fcl();
            }
            AppMethodBeat.o(96099);
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.c)) {
            AppMethodBeat.o(96099);
            return 0;
        } else if (!this.dGX || this.DQG == null) {
            AppMethodBeat.o(96099);
            return 2;
        } else {
            final com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
            long j2 = cVar.ece;
            ADXml aDXml = cVar.DDr.EQY;
            if (this.DQH.containsKey(Long.valueOf(j2))) {
                z = this.DQH.get(Long.valueOf(j2)).booleanValue();
            } else if (this.DQG == null) {
                z = false;
            } else if (aDXml != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.DQG.DRu.size()) {
                        this.DQH.put(Long.valueOf(j2), Boolean.TRUE);
                        z = true;
                        break;
                    } else if (Util.isNullOrNil(a(this.DQG.DRu.get(i3), aDXml.adArgs))) {
                        this.DQH.put(Long.valueOf(j2), Boolean.FALSE);
                        z = false;
                        break;
                    } else {
                        i3++;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(96099);
                return 2;
            }
            String str = cVar.dHp;
            this.DQD.put(Long.valueOf(cVar.ece), new C1714b(cVar.ece, cVar.DDr.fjV(), this.DQG.DQS, this.DQG.DQT, this.mContext.getString(R.string.h4o)));
            if (this.DQF.contains(Long.valueOf(cVar.ece))) {
                this.DQF.remove(Long.valueOf(cVar.ece));
            }
            this.DQu = new AbsoluteLayout(this.mContext);
            this.DQu.setId(R.id.h2);
            new FrameLayout.LayoutParams(-1, -1);
            this.DQt.addView(this.DQu);
            final View inflate = aa.jQ(this.mContext).inflate(R.layout.ca, (ViewGroup) null);
            TextView[] textViewArr = {(TextView) inflate.findViewById(R.id.g3), (TextView) inflate.findViewById(R.id.g8), (TextView) inflate.findViewById(R.id.g7)};
            ImageView[] imageViewArr = {(ImageView) inflate.findViewById(R.id.g4), (ImageView) inflate.findViewById(R.id.g6), (ImageView) inflate.findViewById(R.id.g5)};
            int i4 = 0;
            if (!v.Jo(cVar.ece)) {
                for (int i5 = 0; i5 < this.DQB.length; i5++) {
                    if (this.DQB[i5] == 3) {
                        i4++;
                    }
                }
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.DQB.length; i7++) {
                if (this.DQB[i7] == 0) {
                    i6++;
                }
            }
            if (i6 + i4 > 0) {
                int length = (this.DQB.length - i6) - i4;
                if (length == 0) {
                    AppMethodBeat.o(96099);
                    return 2;
                }
                this.DQC = new int[length];
            } else {
                this.DQC = new int[this.DQB.length];
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.DQB.length; i9++) {
                if (this.DQB[i9] != 0 && (i4 <= 0 || this.DQB[i9] != 3)) {
                    this.DQC[i8] = this.DQB[i9];
                    i8++;
                }
            }
            if (v.Jn(cVar.ece)) {
                int i10 = 0;
                while (true) {
                    if (i10 >= this.DQC.length) {
                        break;
                    } else if (this.DQC[i10] == 3) {
                        this.DQC[i10] = 4;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int i11 = 0;
            int fromDPToPix = (com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8) * 2) + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
            int i12 = 0;
            while (i12 < this.DQC.length) {
                final int i13 = this.DQC[i12];
                int i14 = this.DQC[i12] - 1;
                textViewArr[i12].setText(this.DQA[i14]);
                TextView textView = textViewArr[i12];
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                int measureText = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                if (measureText > i11) {
                    i2 = measureText;
                } else {
                    i2 = i11;
                }
                textViewArr[i12].setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
                textViewArr[i12].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.DQz[i14]), (Drawable) null, (Drawable) null, (Drawable) null);
                if (i14 == 1) {
                    imageViewArr[i12].setVisibility(0);
                } else {
                    imageViewArr[i12].setVisibility(8);
                }
                textViewArr[i12].setTag(cVar);
                textViewArr[i12].setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.h.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        int i2;
                        AppMethodBeat.i(96085);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        b bVar2 = b.this;
                        int i3 = i13;
                        com.tencent.mm.plugin.sns.data.c cVar = cVar;
                        View view2 = inflate;
                        AbsoluteLayout absoluteLayout = b.this.DQu;
                        Log.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i3 + " " + cVar.ece);
                        C1714b bVar3 = bVar2.DQD.get(Long.valueOf(cVar.ece));
                        if (bVar3 != null) {
                            if (i3 == 4) {
                                i2 = 3;
                            } else {
                                i2 = i3;
                            }
                            bVar3.aPL("1:" + i2 + ":" + bVar2.mContext.getString(bVar2.DQy[i3 - 1]));
                        }
                        if (i3 == 1) {
                            SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                            if (aQm != null) {
                                if (aQm.isAd()) {
                                    ADInfo adInfo = aQm.getAdInfo();
                                    ((com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class)).a(11855, aQm.getAdRecSrc(), 3, adInfo == null ? "" : adInfo.viewId, Integer.valueOf(aQm.getAdRecSrc()));
                                }
                                aj.faR().delete(aQm.field_snsId);
                                aj.faT().JI(aQm.field_snsId);
                                com.tencent.mm.plugin.sns.storage.g.JH(aQm.field_snsId);
                                s sVar = new s(aQm.field_snsId, 8);
                                g.aAi();
                                g.aAg().hqi.a(sVar, 0);
                                bVar2.a(bVar3);
                                bVar2.fcl();
                            }
                        } else if (i3 == 2) {
                            bVar2.a(view2, absoluteLayout, cVar);
                        } else if (i3 == 3) {
                            if (!v.Jn(cVar.ece)) {
                                v.Jl(cVar.ece);
                            }
                            bVar2.a(bVar3);
                            bVar2.fcl();
                        } else if (i3 == 4) {
                            if (v.Jn(cVar.ece)) {
                                v.Jm(cVar.ece);
                            }
                            bVar2.a(bVar3);
                            bVar2.fcl();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(96085);
                    }
                });
                i12++;
                i11 = i2;
            }
            for (int i15 = 0; i15 < this.DQC.length; i15++) {
                textViewArr[i15].setMaxWidth(i11);
            }
            for (int length2 = this.DQC.length; length2 < 3; length2++) {
                textViewArr[length2].setVisibility(8);
            }
            new Rect();
            int im = com.tencent.mm.pluginsdk.h.im(this.mContext);
            int[] fjW = cVar.DDr.fjW();
            Log.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + fjW[0] + "  " + fjW[1] + " height: " + im);
            int fromDPToPix2 = i11 + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
            int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0f);
            int fromDPToPix4 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0f);
            this.CHZ = ao.jJ(this.mContext);
            AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(fromDPToPix2, -2, (fjW[0] - fromDPToPix2) - fromDPToPix4, ((fjW[1] - this.CHZ) - im) + fromDPToPix3);
            this.DQu.setTag(new a(str, inflate, cVar.ece, cVar.DDr.EQY));
            this.DQu.addView(inflate, layoutParams);
            inflate.setVisibility(8);
            this.DQx = true;
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.h.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(96086);
                    b.a(b.this, view, inflate);
                    AppMethodBeat.o(96086);
                }
            });
            AppMethodBeat.o(96099);
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, AbsoluteLayout absoluteLayout, final com.tencent.mm.plugin.sns.data.c cVar) {
        int i2;
        AppMethodBeat.i(96100);
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.DQG == null) {
            AppMethodBeat.o(96100);
        } else if (cVar.DDr == null || cVar.DDr.EQY == null) {
            AppMethodBeat.o(96100);
        } else {
            ADXml aDXml = cVar.DDr.EQY;
            int i3 = 0;
            Paint paint = new Paint(1);
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 12.0f);
            int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0f);
            int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0f);
            LinkedList<TextView> linkedList = new LinkedList();
            float fromDPToPix4 = (((float) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0f)) * com.tencent.mm.cb.a.ez(this.mContext)) + ((float) (fromDPToPix2 * 2));
            int i4 = (int) fromDPToPix4;
            for (int i5 = 0; i5 < this.DQG.DRu.size(); i5++) {
                final TextView textView = new TextView(this.mContext);
                textView.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.cb.a.ez(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(R.color.a7w));
                String a2 = a(this.DQG.DRu.get(i5), aDXml.adArgs);
                textView.setText(a2);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i3 = Math.max(i3, ((int) paint.measureText(a2)) + (fromDPToPix * 2));
                textView.setTag(Integer.valueOf(i5));
                linkedList.add(textView);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.h.b.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(96087);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int intValue = ((Integer) view.getTag()).intValue();
                        C1714b bVar2 = b.this.DQD.get(Long.valueOf(cVar.ece));
                        int i2 = b.this.DQG.DRu.get(intValue).DQm;
                        if (bVar2 != null) {
                            bVar2.aPL("3:" + i2 + ":" + ((Object) textView.getText()));
                        }
                        if (b.this.DQG.DRu.get(intValue).DQq == 1) {
                            Intent intent = new Intent();
                            intent.setClass(b.this.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", cVar.ece);
                            intent.putExtra("sns_uxinfo", bVar2.uxInfo);
                            intent.putExtra("action_st_time", bVar2.DQQ);
                            intent.putExtra("sns_actionresult", bVar2.DQP.toString());
                            MMActivity mMActivity = (MMActivity) b.this.mContext;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mMActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            b.this.DQD.remove(Long.valueOf(cVar.ece));
                            b.this.fcl();
                        } else {
                            b.this.a(bVar2);
                            b.this.fcl();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(96087);
                    }
                });
            }
            Log.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i3 + " " + i4);
            if (i3 < fromDPToPix3) {
                i3 = fromDPToPix3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = (int) fromDPToPix4;
                textView2.setLayoutParams(layoutParams);
            }
            new Rect();
            int im = com.tencent.mm.pluginsdk.h.im(this.mContext);
            int[] fjW = cVar.DDr.fjW();
            int fromDPToPix5 = (fjW[0] - i3) - BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0f);
            int i6 = ((fjW[1] - this.CHZ) - im) + i4;
            bq bqVar = cVar.DDr;
            if (bqVar.EQR != null) {
                i2 = bqVar.EQR.getHeight();
            } else {
                i2 = 0;
            }
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, fromDPToPix5, i6 - i2));
            AppMethodBeat.o(96100);
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        String str;
        AppMethodBeat.i(96101);
        if (aVar == null) {
            AppMethodBeat.o(96101);
            return "";
        }
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            str = aVar.DQn;
        } else if (LocaleUtil.isTraditionalChineseAppLang()) {
            str = aVar.DQo;
        } else {
            str = aVar.DQp;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '$') {
                if (stringBuffer2.length() == 0) {
                    stringBuffer2.append(charAt);
                } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                    stringBuffer.append('$');
                    stringBuffer2 = new StringBuffer();
                } else {
                    String str2 = map.get(stringBuffer2.substring(1));
                    if (str2 == null) {
                        AppMethodBeat.o(96101);
                        return "";
                    }
                    stringBuffer.append(str2);
                }
            } else if (stringBuffer2.length() == 0) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer2.append(charAt);
            }
        }
        String stringBuffer3 = stringBuffer.toString();
        AppMethodBeat.o(96101);
        return stringBuffer3;
    }

    public final boolean fcl() {
        C1714b bVar;
        AppMethodBeat.i(96102);
        if (this.DQu != null) {
            if ((this.DQu.getTag() instanceof a) && (bVar = this.DQD.get(Long.valueOf(((a) this.DQu.getTag()).ece))) != null) {
                if (bVar.fcn()) {
                    if (bVar.fcm()) {
                        bVar.aPL("2:0:");
                    }
                    a(bVar);
                } else {
                    bVar.aPL("2:0:");
                    a(bVar);
                }
            }
            this.DQt.removeView(this.DQu);
            this.DQu = null;
            AppMethodBeat.o(96102);
            return true;
        }
        this.DQx = false;
        AppMethodBeat.o(96102);
        return false;
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        AppMethodBeat.i(96103);
        view.getTag();
        view2.setVisibility(0);
        bVar.DQx = true;
        bVar.DQv.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.h.b.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                b.this.DQx = true;
            }

            public final void onAnimationEnd(Animation animation) {
                b.this.DQx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(bVar.DQv);
        AppMethodBeat.o(96103);
    }
}
