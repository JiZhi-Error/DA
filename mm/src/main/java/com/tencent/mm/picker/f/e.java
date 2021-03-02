package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.a.c;
import com.tencent.mm.picker.base.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.a;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class e {
    public static DateFormat dateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS, Locale.ENGLISH);
    Context ctx;
    int endYear = 2100;
    int gravity;
    boolean[] jKX;
    private int jKu;
    WheelView jLQ;
    WheelView jLR;
    WheelView jLS;
    WheelView jLT;
    WheelView jLU;
    WheelView jLV;
    int jLW = 1;
    int jLX = 12;
    int jLY = 1;
    int jLZ = 31;
    float jLu;
    WheelView.b jLw;
    int jMa = 0;
    int jMb = 0;
    int jMc = 23;
    int jMd = 59;
    int jMe;
    a jMf;
    private String[] jMg = {"1", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "5", "7", "8", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"};
    private String[] jMh = {"4", "6", "9", "11"};
    final List<String> jMi = Arrays.asList(this.jMg);
    final List<String> jMj = Arrays.asList(this.jMh);
    int startYear = 1900;
    View view;

    static {
        AppMethodBeat.i(175380);
        AppMethodBeat.o(175380);
    }

    public e(Context context) {
        AppMethodBeat.i(175371);
        this.ctx = context;
        AppMethodBeat.o(175371);
    }

    public final List<WheelView> bll() {
        AppMethodBeat.i(175372);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 6; i2++) {
            switch (i2) {
                case 0:
                    this.jLQ.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLQ);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    this.jLR.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLR);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    this.jLS.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLS);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.jLT.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLT);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    this.jLU.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLU);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.jLV.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.jLV);
                        break;
                    } else {
                        break;
                    }
            }
        }
        AppMethodBeat.o(175372);
        return arrayList;
    }

    static void aP(List<WheelView> list) {
        AppMethodBeat.i(175373);
        for (WheelView wheelView : list) {
            wheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
        AppMethodBeat.o(175373);
    }

    /* access modifiers changed from: package-private */
    public final void b(WheelView wheelView) {
        AppMethodBeat.i(175374);
        if (this.jMf != null) {
            wheelView.setOnItemSelectedListener(new b() {
                /* class com.tencent.mm.picker.f.e.AnonymousClass4 */

                @Override // com.tencent.mm.picker.base.b.b
                public final void onItemSelected(int i2) {
                    AppMethodBeat.i(175370);
                    e.this.jMf.bla();
                    AppMethodBeat.o(175370);
                }
            });
        }
        AppMethodBeat.o(175374);
    }

    private void blj() {
        AppMethodBeat.i(175375);
        this.jLS.setDividerColor(this.jKu);
        this.jLR.setDividerColor(this.jKu);
        this.jLQ.setDividerColor(this.jKu);
        this.jLT.setDividerColor(this.jKu);
        this.jLU.setDividerColor(this.jKu);
        this.jLV.setDividerColor(this.jKu);
        AppMethodBeat.o(175375);
    }

    public final String getTime() {
        AppMethodBeat.i(175376);
        String valueOf = String.valueOf(c(this.jLQ) + "-" + c(this.jLR) + "-" + c(this.jLS) + " " + c(this.jLT) + ":" + c(this.jLU) + ":" + c(this.jLV));
        AppMethodBeat.o(175376);
        return valueOf;
    }

    private static int c(WheelView wheelView) {
        Object item;
        AppMethodBeat.i(175377);
        if (!(wheelView.getAdapter() instanceof c) || (item = wheelView.getAdapter().getItem(wheelView.getCurrentItem())) == null) {
            AppMethodBeat.o(175377);
            return 0;
        }
        int intValue = ((Integer) item).intValue();
        AppMethodBeat.o(175377);
        return intValue;
    }

    public final void setDividerColor(int i2) {
        AppMethodBeat.i(175378);
        this.jKu = i2;
        blj();
        AppMethodBeat.o(175378);
    }

    static /* synthetic */ void a(e eVar, int i2, int i3, int i4, int i5, List list, List list2) {
        AppMethodBeat.i(175379);
        int c2 = c(eVar.jLS);
        int currentItem = eVar.jLS.getCurrentItem();
        if (list.contains(String.valueOf(i3))) {
            if (i5 > 31) {
                i5 = 31;
            }
            eVar.jLS.setAdapter(new c(i4, i5));
        } else if (list2.contains(String.valueOf(i3))) {
            if (i5 > 30) {
                i5 = 30;
            }
            eVar.jLS.setAdapter(new c(i4, i5));
        } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
            if (i5 > 28) {
                i5 = 28;
            }
            eVar.jLS.setAdapter(new c(i4, i5));
        } else {
            if (i5 > 29) {
                i5 = 29;
            }
            eVar.jLS.setAdapter(new c(i4, i5));
        }
        if (currentItem > eVar.jLS.getAdapter().getItemsCount() - 1) {
            eVar.jLS.setCurrentItem(eVar.jLS.getAdapter().getItemsCount() - 1);
        }
        if (c(eVar.jLS) != c2) {
            int i6 = ((c) eVar.jLS.getAdapter()).jJX;
            int i7 = ((c) eVar.jLS.getAdapter()).jJW;
            if (c2 <= i7) {
                eVar.jLS.setCurrentItem(0);
                AppMethodBeat.o(175379);
                return;
            } else if (c2 >= i6) {
                eVar.jLS.setCurrentItem(eVar.jLS.getAdapter().getItemsCount() - 1);
                AppMethodBeat.o(175379);
                return;
            } else {
                eVar.jLS.setCurrentItem(c2 - i7);
            }
        }
        AppMethodBeat.o(175379);
    }
}
