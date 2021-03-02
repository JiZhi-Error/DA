package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.widget.h;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vending.d.b;
import com.tencent.mm.vending.j.a;
import java.util.HashMap;

public class SnsLikesTextView extends RelativeLayout implements bk.a {
    private j EBk;
    private ImageView EFG;
    private LinearLayout EFH;
    private MaskTextView EFI;
    private SpannableStringBuilder EFJ;
    private int EFK;
    private boolean EFL;
    private PBool EFM;
    protected HashMap<String, Integer> EFN;
    private Runnable EFO;
    private BaseTimeLineItem.BaseViewHolder Eon;
    private TextView Epm;
    private bl Epq;
    private String dJX;
    private boolean hasCheck;
    private int qcr;

    static /* synthetic */ void b(SnsLikesTextView snsLikesTextView) {
        AppMethodBeat.i(98847);
        snsLikesTextView.fiu();
        AppMethodBeat.o(98847);
    }

    public SnsLikesTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnsLikesTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98838);
        this.dJX = null;
        this.hasCheck = true;
        this.Epm = null;
        this.EFG = null;
        this.EFH = null;
        this.EFI = null;
        this.EFJ = new SpannableStringBuilder(" ");
        this.EFK = 0;
        this.EFL = false;
        this.qcr = 0;
        this.EBk = null;
        this.EFM = null;
        this.EFN = null;
        this.Eon = null;
        this.Epq = null;
        this.EFO = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLikesTextView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(98837);
                SnsLikesTextView.b(SnsLikesTextView.this);
                AppMethodBeat.o(98837);
            }
        };
        inflate(getContext(), R.layout.bw8, this);
        this.Epm = (TextView) findViewById(R.id.hyr);
        this.EFG = (ImageView) findViewById(R.id.hyp);
        this.EFH = (LinearLayout) findViewById(R.id.hyq);
        this.EFI = (MaskTextView) findViewById(R.id.hys);
        AppMethodBeat.o(98838);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(98839);
        super.onLayout(z, i2, i3, i4, i5);
        int lineCount = this.EFI.getLineCount();
        if (this.EFK > 0 && lineCount > this.EFK && this.EFM != null) {
            this.EFM.value = true;
        }
        if (this.EFK > 0 && this.EFN != null) {
            if (this.hasCheck) {
                AppMethodBeat.o(98839);
                return;
            }
            this.hasCheck = true;
            if (this.EFN.get(this.dJX) == null) {
                if (!this.EFL) {
                    this.EFN.put(this.dJX, 0);
                } else if (lineCount <= this.EFK) {
                    this.EFN.put(this.dJX, 0);
                } else {
                    this.EFN.put(this.dJX, 1);
                }
            }
            post(this.EFO);
        }
        AppMethodBeat.o(98839);
    }

    private void fiu() {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        AppMethodBeat.i(98840);
        Integer num = this.EFN.get(this.dJX);
        if (num != null) {
            switch (num.intValue()) {
                case 0:
                    int lineCount = this.EFI.getLayout().getLineCount();
                    this.EFH.setVisibility(8);
                    if (lineCount > this.EFK) {
                        e.DUQ.a(this.Eon.convertView, this.Epq, this.EFJ.toString(), this.EFJ.toString(), lineCount, lineCount, false, this.Eon.position, this.EFK);
                        AppMethodBeat.o(98840);
                        return;
                    }
                    break;
                case 1:
                    int lineCount2 = this.EFI.getLayout().getLineCount();
                    int max = Math.max(Math.min(this.EFK, lineCount2), 0);
                    CharSequence subSequence = this.EFJ.subSequence(0, this.EFI.getLayout().getLineVisibleEnd(max - 1));
                    int lastIndexOf = subSequence.toString().lastIndexOf(",");
                    if (lastIndexOf <= 0 || lastIndexOf >= subSequence.length()) {
                        spannableStringBuilder2 = new SpannableStringBuilder(subSequence);
                    } else {
                        spannableStringBuilder2 = new SpannableStringBuilder(subSequence.subSequence(0, lastIndexOf));
                    }
                    String spannableStringBuilder3 = spannableStringBuilder2.toString();
                    spannableStringBuilder2.append((CharSequence) ",...");
                    this.EFI.setText(spannableStringBuilder2, TextView.BufferType.SPANNABLE);
                    this.EFH.setVisibility(0);
                    this.Epm.setText(getContext().getString(R.string.h81));
                    this.EFG.setRotation(90.0f);
                    this.EFG.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_arrow, getContext().getResources().getColor(R.color.x0)));
                    e.DUQ.a(this.Eon.convertView, this.Epq, spannableStringBuilder3, this.EFJ.toString(), max, lineCount2, true, this.Eon.position, this.EFK);
                    AppMethodBeat.o(98840);
                    return;
                case 2:
                    int lineCount3 = this.EFI.getLayout().getLineCount();
                    this.EFI.setText(this.EFJ, TextView.BufferType.SPANNABLE);
                    this.EFH.setVisibility(0);
                    this.EFG.setRotation(-90.0f);
                    this.EFG.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_arrow, getContext().getResources().getColor(R.color.x0)));
                    this.Epm.setText(getContext().getString(R.string.h80));
                    e.DUQ.a(this.Eon.convertView, this.Epq, this.EFJ.toString(), this.EFJ.toString(), lineCount3, lineCount3, false, this.Eon.position, this.EFK);
                    AppMethodBeat.o(98840);
                    return;
                case 3:
                    int lineCount4 = this.EFI.getLayout().getLineCount();
                    final String str = (String) g.aAh().azQ().get(2, (Object) null);
                    SpannableString b2 = l.b(getContext(), (String) g.aAh().azQ().get(4, (Object) null), this.EFI.getTextSize());
                    int max2 = Math.max(Math.min(this.EFK, lineCount4), 0);
                    CharSequence subSequence2 = this.EFJ.subSequence(0, this.EFI.getLayout().getLineVisibleEnd(max2 - 1));
                    int lastIndexOf2 = subSequence2.toString().lastIndexOf(",");
                    if (lastIndexOf2 <= 0 || lastIndexOf2 >= subSequence2.length()) {
                        spannableStringBuilder = new SpannableStringBuilder(subSequence2);
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(subSequence2.subSequence(0, lastIndexOf2));
                    }
                    int i2 = this.qcr == 10 ? 3 : 2;
                    getContext();
                    b2.setSpan(new q(str, new q.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsLikesTextView.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.ui.span.q.a
                        public final void b(View view, Object obj) {
                            AppMethodBeat.i(98835);
                            if (SnsLikesTextView.this.EBk != null) {
                                SnsLikesTextView.this.EBk.source = 13;
                                SnsLikesTextView.this.EBk.b(view, obj);
                                ((c) g.ah(c.class)).report22210(str, 7);
                            }
                            AppMethodBeat.o(98835);
                        }
                    }, i2), 0, b2.length(), 33);
                    StringBuilder sb = new StringBuilder(spannableStringBuilder.toString());
                    spannableStringBuilder.append((CharSequence) ",...").append((CharSequence) ",").append((CharSequence) b2);
                    this.EFI.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    this.EFH.setVisibility(0);
                    this.Epm.setText(getContext().getString(R.string.h81));
                    this.EFG.setRotation(90.0f);
                    this.EFG.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_arrow, getContext().getResources().getColor(R.color.x0)));
                    e.DUQ.a(this.Eon.convertView, this.Epq, sb.append(",").append((CharSequence) b2).toString(), this.EFJ.toString(), max2, lineCount4, true, this.Eon.position, this.EFK);
                    break;
            }
        }
        AppMethodBeat.o(98840);
    }

    public void setOpClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(98841);
        if (this.EFH != null) {
            this.EFH.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(98841);
    }

    public void setLikedTextTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(98842);
        if (this.EFI != null) {
            this.EFI.setOnTouchListener(onTouchListener);
        }
        AppMethodBeat.o(98842);
    }

    public final boolean a(b<a> bVar, int i2, bk bkVar, String str, int i3, boolean z, PBool pBool, bl blVar, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        boolean z2;
        AppMethodBeat.i(98843);
        this.EFK = i3;
        this.dJX = str;
        this.qcr = i2;
        this.EBk = bkVar.EBk;
        this.EFM = pBool;
        this.EFL = z;
        this.Eon = baseViewHolder;
        this.Epq = blVar;
        this.EFN = bkVar.EFN;
        this.EFJ.clear();
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        boolean z3 = true;
        for (int i4 = 0; i4 < bVar.size(); i4++) {
            try {
                String str2 = (String) bVar.get(i4).get(1);
                SpannableString b2 = l.b(getContext(), str2, this.EFI.getTextSize());
                if (z3) {
                    this.EFJ.append((CharSequence) " ");
                    stringBuffer.append(" ");
                    z2 = false;
                } else {
                    this.EFJ.append((CharSequence) ", ");
                    stringBuffer.append(", ");
                    z2 = z3;
                }
                iArr[i4] = this.EFJ.length();
                iArr2[i4] = iArr[i4] + str2.length();
                stringBuffer.append(str2);
                this.EFJ.append((CharSequence) b2);
                String str3 = (String) bVar.get(i4).get(0);
                if (!com.tencent.mm.plugin.sns.f.a.aOD(str3) || !((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.TimeLine_Like) || !o.isShowStoryCheck()) {
                    ImageSpan textStatusSpanSync = ((c) g.ah(c.class)).getTextStatusSpanSync(str3, a.b.SNS_COMMENT, this.EFI.getTextSize());
                    if (textStatusSpanSync != null) {
                        this.EFJ.append((CharSequence) " ");
                        this.EFJ.setSpan(textStatusSpanSync, this.EFJ.length() - 1, this.EFJ.length(), 17);
                    }
                } else {
                    this.EFJ.append((CharSequence) "  ");
                    this.EFJ.setSpan(new h(((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true)), this.EFJ.length() - 1, this.EFJ.length(), 17);
                }
                z3 = z2;
            } catch (Exception e2) {
                Log.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", Util.stackTraceToString(e2));
            }
        }
        Drawable m = ar.m(getContext(), i2 == 10 ? R.drawable.a6x : R.drawable.an3, getContext().getResources().getColor(R.color.Link));
        m.setBounds(0, 0, m.getIntrinsicWidth(), m.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(m, 1);
        aVar.QBM = (int) (((((float) m.getIntrinsicHeight()) - this.EFI.getTextSize()) + ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 2))) / 2.0f);
        this.EFJ.setSpan(aVar, 0, 1, 33);
        int i5 = i2 == 10 ? 3 : 2;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            SpannableStringBuilder spannableStringBuilder = this.EFJ;
            getContext();
            spannableStringBuilder.setSpan(new q((String) bVar.get(i6).get(0), new q.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsLikesTextView.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.span.q.a
                public final void b(View view, Object obj) {
                    AppMethodBeat.i(98836);
                    if (SnsLikesTextView.this.EBk != null) {
                        SnsLikesTextView.this.EBk.source = 13;
                        SnsLikesTextView.this.EBk.b(view, obj);
                    }
                    AppMethodBeat.o(98836);
                }
            }, i5), iArr[i6], iArr2[i6], 33);
        }
        this.EFI.setText(this.EFJ, TextView.BufferType.SPANNABLE);
        this.EFI.setOriginText(stringBuffer.toString());
        if (i3 > 0) {
            if (getTag() == null || !(getTag() instanceof String) || !Util.isEqual((String) getTag(), this.EFJ.toString())) {
                setTag(this.EFJ.toString());
                this.EFH.setVisibility(8);
                this.hasCheck = false;
                requestLayout();
                AppMethodBeat.o(98843);
                return true;
            }
            this.hasCheck = true;
            fiu();
        }
        AppMethodBeat.o(98843);
        return true;
    }

    public void setLikeTvTag(Object obj) {
        AppMethodBeat.i(98844);
        if (this.EFI != null) {
            this.EFI.setTag(obj);
        }
        AppMethodBeat.o(98844);
    }

    public void setOpTvTag(Object obj) {
        AppMethodBeat.i(98845);
        if (this.EFH != null) {
            this.EFH.setTag(obj);
        }
        AppMethodBeat.o(98845);
    }

    @Override // com.tencent.mm.plugin.sns.ui.bk.a
    public final void vv(boolean z) {
        AppMethodBeat.i(98846);
        if (this.EFK > 0 && this.EFN != null) {
            Integer num = this.EFN.get(this.dJX);
            if (num == null) {
                this.EFN.put(this.dJX, 0);
            } else if (z) {
                if (num.intValue() == 1) {
                    this.EFN.put(this.dJX, 3);
                    fiu();
                    AppMethodBeat.o(98846);
                    return;
                }
            } else if (num.intValue() == 3) {
                this.EFN.put(this.dJX, 1);
                fiu();
                AppMethodBeat.o(98846);
                return;
            }
        }
        AppMethodBeat.o(98846);
    }

    @Override // com.tencent.mm.plugin.sns.ui.bk.a
    public String getKey() {
        return this.dJX;
    }
}
