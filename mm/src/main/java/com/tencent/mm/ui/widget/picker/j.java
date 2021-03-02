package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.a.d;
import com.tencent.mm.ui.widget.picker.a.f;
import com.tencent.mm.ui.widget.picker.d.a;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class j {
    public static DateFormat dateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS, Locale.ENGLISH);
    WheelView QTE;
    WheelView QTF;
    WheelView QTG;
    WheelView QTH;
    WheelView QTI;
    WheelView QTJ;
    f QTK;
    boolean QTL = false;
    WheelView.b QTM;
    a QTN;
    Context ctx;
    int endYear = 2100;
    int gravity;
    boolean[] jKX;
    private int jKu;
    int jLW = 1;
    int jLX = 12;
    int jLY = 1;
    int jLZ = 31;
    float jLu;
    int jMa = 0;
    int jMb = 0;
    int jMc = 23;
    int jMd = 59;
    int jMe;
    private String[] jMg = {"1", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "5", "7", "8", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"};
    private String[] jMh = {"4", "6", "9", "11"};
    final List<String> jMi = Arrays.asList(this.jMg);
    final List<String> jMj = Arrays.asList(this.jMh);
    int startYear = 1900;
    View view;

    static {
        AppMethodBeat.i(198466);
        AppMethodBeat.o(198466);
    }

    public j(Context context) {
        AppMethodBeat.i(198455);
        this.ctx = context;
        AppMethodBeat.o(198455);
    }

    public final List<WheelView> bll() {
        AppMethodBeat.i(198456);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 6; i2++) {
            switch (i2) {
                case 0:
                    this.QTE.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTE);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    this.QTF.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTF);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    this.QTG.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTG);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.QTH.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTH);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    this.QTI.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTI);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.QTJ.setVisibility(this.jKX[i2] ? 0 : 8);
                    if (this.jKX[i2]) {
                        arrayList.add(this.QTJ);
                        break;
                    } else {
                        break;
                    }
            }
        }
        AppMethodBeat.o(198456);
        return arrayList;
    }

    static void aP(List<WheelView> list) {
        AppMethodBeat.i(198457);
        for (WheelView wheelView : list) {
            wheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
        AppMethodBeat.o(198457);
    }

    /* access modifiers changed from: package-private */
    public final void a(WheelView wheelView) {
        AppMethodBeat.i(198458);
        if (this.QTN != null) {
            wheelView.setOnItemSelectedListener(new c() {
                /* class com.tencent.mm.ui.widget.picker.j.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.picker.d.c
                public final void onItemSelected(int i2) {
                    AppMethodBeat.i(198454);
                    j.this.QTN.bla();
                    AppMethodBeat.o(198454);
                }
            });
        }
        AppMethodBeat.o(198458);
    }

    private void blj() {
        AppMethodBeat.i(198459);
        this.QTG.setDividerColor(this.jKu);
        this.QTF.setDividerColor(this.jKu);
        this.QTE.setDividerColor(this.jKu);
        this.QTH.setDividerColor(this.jKu);
        this.QTI.setDividerColor(this.jKu);
        this.QTJ.setDividerColor(this.jKu);
        AppMethodBeat.o(198459);
    }

    public final String getTime() {
        AppMethodBeat.i(198460);
        String valueOf = String.valueOf(b(this.QTE) + "-" + b(this.QTF) + "-" + b(this.QTG) + " " + b(this.QTH) + ":" + b(this.QTI) + ":" + b(this.QTJ));
        AppMethodBeat.o(198460);
        return valueOf;
    }

    private static int b(WheelView wheelView) {
        Object item;
        AppMethodBeat.i(198461);
        if (!(wheelView.getAdapter() instanceof d) || (item = wheelView.getAdapter().getItem(wheelView.getCurrentItem())) == null) {
            AppMethodBeat.o(198461);
            return 0;
        }
        int intValue = ((Integer) item).intValue();
        AppMethodBeat.o(198461);
        return intValue;
    }

    public final void setDividerColor(int i2) {
        AppMethodBeat.i(198462);
        this.jKu = i2;
        blj();
        AppMethodBeat.o(198462);
    }

    public final void setDividerHeight(float f2) {
        AppMethodBeat.i(198463);
        this.QTG.setDividerHeight(f2);
        this.QTH.setDividerHeight(f2);
        this.QTI.setDividerHeight(f2);
        this.QTE.setDividerHeight(f2);
        this.QTF.setDividerHeight(f2);
        this.QTJ.setDividerHeight(f2);
        AppMethodBeat.o(198463);
    }

    public final void dE(int i2, int i3) {
        AppMethodBeat.i(198464);
        this.QTG.setPadding(0, i2, 0, i3);
        this.QTH.setPadding(0, i2, 0, i3);
        this.QTI.setPadding(0, i2, 0, i3);
        this.QTE.setPadding(0, i2, 0, i3);
        this.QTF.setPadding(0, i2, 0, i3);
        this.QTJ.setPadding(0, i2, 0, i3);
        AppMethodBeat.o(198464);
    }

    static /* synthetic */ void a(j jVar, int i2, int i3, int i4, int i5, List list, List list2) {
        AppMethodBeat.i(198465);
        int b2 = b(jVar.QTG);
        int currentItem = jVar.QTG.getCurrentItem();
        if (list.contains(String.valueOf(i3))) {
            if (i5 > 31) {
                i5 = 31;
            }
            jVar.QTG.setAdapter(new d(i4, i5));
        } else if (list2.contains(String.valueOf(i3))) {
            if (i5 > 30) {
                i5 = 30;
            }
            jVar.QTG.setAdapter(new d(i4, i5));
        } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
            if (i5 > 28) {
                i5 = 28;
            }
            jVar.QTG.setAdapter(new d(i4, i5));
        } else {
            if (i5 > 29) {
                i5 = 29;
            }
            jVar.QTG.setAdapter(new d(i4, i5));
        }
        if (currentItem > jVar.QTG.getAdapter().getItemsCount() - 1) {
            jVar.QTG.setCurrentItem(jVar.QTG.getAdapter().getItemsCount() - 1);
        }
        if (b(jVar.QTG) != b2) {
            int maxValue = ((d) jVar.QTG.getAdapter()).getMaxValue();
            int minValue = ((d) jVar.QTG.getAdapter()).getMinValue();
            if (b2 <= minValue) {
                jVar.QTG.setCurrentItem(0);
                AppMethodBeat.o(198465);
                return;
            } else if (b2 >= maxValue) {
                jVar.QTG.setCurrentItem(jVar.QTG.getAdapter().getItemsCount() - 1);
                AppMethodBeat.o(198465);
                return;
            } else {
                jVar.QTG.setCurrentItem(b2 - minValue);
            }
        }
        AppMethodBeat.o(198465);
    }
}
