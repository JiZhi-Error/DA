package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView extends LinearLayout {
    private List<View> EDW = new ArrayList();
    private volatile String Ffa;
    private Activity activity;
    private int tCv;

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100491);
        AppMethodBeat.o(100491);
    }

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100492);
        AppMethodBeat.o(100492);
    }

    public void setActivityContext(Activity activity2) {
        this.activity = activity2;
    }

    private void a(ADXml.d dVar, boolean z) {
        String str;
        int color;
        int color2;
        int i2;
        int color3;
        AppMethodBeat.i(203995);
        if (dVar == null) {
            AppMethodBeat.o(203995);
            return;
        }
        String str2 = dVar.DWn;
        if (ao.isDarkMode()) {
            str = dVar.DWp;
            try {
                color3 = Util.isNullOrNil(dVar.DWt) ? getContext().getResources().getColor(R.color.l4) : Color.parseColor(dVar.DWt);
            } catch (Throwable th) {
                color3 = getContext().getResources().getColor(R.color.l4);
                Log.e("MicroMsg.SnsCardTagListView", th.toString());
            }
            try {
                if (Util.isNullOrNil(dVar.DWr)) {
                    color2 = getContext().getResources().getColor(R.color.a8l);
                } else {
                    color2 = Color.parseColor(dVar.DWr);
                }
                i2 = color3;
            } catch (Throwable th2) {
                color2 = getContext().getResources().getColor(R.color.a8l);
                Log.e("MicroMsg.SnsCardTagListView", th2.toString());
                i2 = color3;
            }
        } else {
            str = dVar.DWo;
            try {
                color = Util.isNullOrNil(dVar.DWs) ? getContext().getResources().getColor(R.color.l4) : Color.parseColor(dVar.DWs);
            } catch (Throwable th3) {
                color = getContext().getResources().getColor(R.color.l4);
                Log.e("MicroMsg.SnsCardTagListView", th3.toString());
            }
            try {
                color2 = Util.isNullOrNil(dVar.DWq) ? getContext().getResources().getColor(R.color.a8l) : Color.parseColor(dVar.DWq);
                i2 = color;
            } catch (Throwable th4) {
                color2 = getContext().getResources().getColor(R.color.a8l);
                Log.e("MicroMsg.SnsCardTagListView", th4.toString());
                i2 = color;
            }
        }
        if (!Util.isNullOrNil(str2)) {
            View inflate = this.activity.getLayoutInflater().inflate(R.layout.c4, (ViewGroup) null);
            inflate.getBackground().setColorFilter(color2, PorterDuff.Mode.SRC);
            TextView textView = (TextView) inflate.findViewById(R.id.ak5);
            WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.ak3);
            weImageView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams.leftMargin = this.tCv;
            }
            textView.setText(str2);
            textView.setTextColor(i2);
            if (!Util.isNullOrNil(str) && !TextUtils.equals((String) weImageView.getTag(R.id.hu3), str)) {
                weImageView.setImageDrawable(null);
                if (!TextUtils.isEmpty(str)) {
                    Log.d("SnsCardAdTagUtils", "loadImage, hash=" + weImageView.hashCode() + ", url=" + str);
                    weImageView.setTag(R.id.hu3, str);
                    h.a(str, false, (f.a) new f.a(weImageView, str, textView) {
                        /* class com.tencent.mm.plugin.sns.ui.widget.b.AnonymousClass1 */
                        final /* synthetic */ String DzZ;
                        final /* synthetic */ TextView EJe;
                        final /* synthetic */ WeImageView Ffd;

                        {
                            this.Ffd = r1;
                            this.DzZ = r2;
                            this.EJe = r3;
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWN() {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWO() {
                            AppMethodBeat.i(203996);
                            this.Ffd.setTag(R.id.hu3, "");
                            this.Ffd.setVisibility(8);
                            Log.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.Ffd.hashCode() + ", url=" + this.DzZ);
                            AppMethodBeat.o(203996);
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void aNH(String str) {
                            String kz;
                            AppMethodBeat.i(203997);
                            try {
                                String str2 = (String) this.Ffd.getTag(R.id.hu3);
                                if (TextUtils.isEmpty(str2)) {
                                    kz = "";
                                } else {
                                    kz = h.kz("adId", str2);
                                }
                                if (TextUtils.isEmpty(str) || !str.equals(kz)) {
                                    Log.d("SnsCardAdTagUtils", "onDownloaded, url changed");
                                    AppMethodBeat.o(203997);
                                    return;
                                }
                                Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                                if (decodeFile != null) {
                                    this.Ffd.setImageBitmap(decodeFile);
                                    this.Ffd.setVisibility(0);
                                    if (this.EJe != null && (this.EJe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                                        ((LinearLayout.LayoutParams) this.EJe.getLayoutParams()).leftMargin = 0;
                                    }
                                    Log.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.Ffd.hashCode());
                                    AppMethodBeat.o(203997);
                                    return;
                                }
                                Log.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
                                AppMethodBeat.o(203997);
                            } catch (Throwable th) {
                                Log.e("SnsCardAdTagUtils", "onDownloaded, exp=" + th.toString());
                                AppMethodBeat.o(203997);
                            }
                        }
                    });
                }
            }
            addView(inflate, layoutParams);
            this.EDW.add(inflate);
        }
        AppMethodBeat.o(203995);
    }

    public final void ho(List<ADXml.d> list) {
        AppMethodBeat.i(100493);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                a(list.get(i2), i2 != 0);
            }
        }
        AppMethodBeat.o(100493);
    }

    public void setTagSpace(int i2) {
        this.tCv = i2;
    }

    public void removeAllViews() {
        AppMethodBeat.i(100494);
        super.removeAllViews();
        this.EDW.clear();
        AppMethodBeat.o(100494);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        AppMethodBeat.i(100495);
        super.onMeasure(i2, i3);
        int i7 = 0;
        while (true) {
            i4 = i6;
            if (i4 >= this.EDW.size()) {
                break;
            }
            if (i4 > 0) {
                i5 = i7 + this.tCv;
            } else {
                i5 = i7;
            }
            if (i5 >= getMeasuredWidth()) {
                i4--;
                break;
            }
            i7 = this.EDW.get(i4).getMeasuredWidth() + i5;
            if (i7 >= getMeasuredWidth()) {
                break;
            }
            i6 = i4 + 1;
        }
        if (i4 >= 0 && i4 < this.EDW.size()) {
            final View view = this.EDW.get(i4);
            final TextView textView = (TextView) view.findViewById(R.id.ak5);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView.AnonymousClass1 */

                public final boolean onPreDraw() {
                    AppMethodBeat.i(100490);
                    if (textView.getLayout() != null && !Util.isNullOrNil(textView.getLayout().getText()) && textView.getLayout().getText().charAt(0) == 8230) {
                        SnsCardAdTagListView.this.removeView(view);
                        SnsCardAdTagListView.this.EDW.remove(view);
                    }
                    SnsCardAdTagListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(100490);
                    return true;
                }
            });
            for (int i8 = i4 + 1; i8 < this.EDW.size(); i8++) {
                removeView(this.EDW.get(i8));
                this.EDW.remove(i8);
            }
        }
        AppMethodBeat.o(100495);
    }

    public String getOriginSnsId() {
        return this.Ffa;
    }

    public void setOriginSnsId(String str) {
        this.Ffa = str;
    }
}
