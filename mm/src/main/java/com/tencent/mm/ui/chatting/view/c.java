package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;

public final class c {
    ArrayList<Long> PGA = new ArrayList<>(42);
    OptionPicker PGx;
    OptionPicker PGy;
    public a PGz;
    private Button hPX;
    private Button hSq;
    private View lJI;
    Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    android.support.design.widget.a yfL;

    public interface a {
        void Nt(long j2);

        void onCancel();
    }

    public c(Context context) {
        AppMethodBeat.i(36725);
        this.mContext = context;
        this.lJI = View.inflate(this.mContext, R.layout.bmj, null);
        this.yfL = new android.support.design.widget.a(this.mContext);
        this.yfL.setContentView(this.lJI);
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.chatting.view.c.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                c.this.yfL = null;
            }
        });
        this.PGx = (OptionPicker) this.lJI.findViewById(R.id.g51);
        this.PGy = (OptionPicker) this.lJI.findViewById(R.id.g55);
        this.PGx.setValue(0);
        this.PGx.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
        this.PGy.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
        this.PGx.setOptionsArray(gTS());
        this.PGy.setOptionsArray(anz(0));
        this.PGx.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.tencent.mm.ui.chatting.view.c.AnonymousClass2 */

            public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                AppMethodBeat.i(36722);
                Log.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", Integer.valueOf(i2), Integer.valueOf(i3));
                c.this.PGy.setOptionsArray(c.this.anz(i3));
                int i4 = Calendar.getInstance().get(11);
                if (i3 == 0) {
                    c.this.PGy.setValue(0);
                    AppMethodBeat.o(36722);
                    return;
                }
                c.this.PGy.setValue(i4);
                AppMethodBeat.o(36722);
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
        layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 288);
        this.lJI.setLayoutParams(layoutParams);
        this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.hPX = (Button) this.lJI.findViewById(R.id.g3k);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.view.c.AnonymousClass3 */

            public final void onClick(View view) {
                long longValue;
                AppMethodBeat.i(36723);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.PGz != null) {
                    a aVar = c.this.PGz;
                    c cVar = c.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    int value = cVar.PGx.getValue();
                    int value2 = cVar.PGy.getValue();
                    if (value != 0) {
                        longValue = cVar.PGA.get(value).longValue() + (((long) (value2 + 1)) * Util.MILLSECONDS_OF_HOUR);
                    } else if (CrashReportFactory.hasDebuger()) {
                        longValue = currentTimeMillis + 30000;
                    } else {
                        longValue = currentTimeMillis + (((long) (value2 + 1)) * Util.MILLSECONDS_OF_HOUR);
                    }
                    Log.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", f.formatTime(cVar.mContext.getString(R.string.dew) + "HH:mm", longValue / 1000));
                    aVar.Nt(longValue);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36723);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.view.c.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(36724);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.PGz != null) {
                    c.this.PGz.onCancel();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36724);
            }
        });
        AppMethodBeat.o(36725);
    }

    public final void show() {
        AppMethodBeat.i(36726);
        if (this.yfL != null) {
            this.yfL.show();
        }
        AppMethodBeat.o(36726);
    }

    public final void hide() {
        AppMethodBeat.i(36727);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(36727);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final String[] anz(int i2) {
        int i3 = 1;
        AppMethodBeat.i(36728);
        ArrayList arrayList = new ArrayList();
        switch (i2 - (CrashReportFactory.hasDebuger() ? 1 : 0)) {
            case -1:
                arrayList.add("after 30 second");
                break;
            case 0:
                int i4 = Calendar.getInstance().get(11);
                for (int i5 = 1; i5 <= 24 - i4; i5++) {
                    arrayList.add(this.mContext.getResources().getString(R.string.ge, Integer.valueOf(i5)));
                }
                break;
            default:
                while (i3 <= 24) {
                    arrayList.add((i3 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i3)) : Integer.valueOf(i3)) + ":00");
                    i3++;
                }
                break;
        }
        String[] listToStrings = Util.listToStrings(arrayList);
        AppMethodBeat.o(36728);
        return listToStrings;
    }

    private String[] gTS() {
        AppMethodBeat.i(36729);
        this.PGA.clear();
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        for (int i2 = 0; i2 < instance.getActualMaximum(5); i2++) {
            if (CrashReportFactory.hasDebuger() && i2 == 0) {
                arrayList.add(APMidasPayAPI.ENV_TEST);
                this.PGA.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (Util.MILLSECONDS_OF_DAY * ((long) i2)));
                this.PGA.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (Util.MILLSECONDS_OF_DAY * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.PGA.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String formatTime = f.formatTime(this.mContext.getString(R.string.dec), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(R.string.dfl));
            } else if (i2 == 1) {
                arrayList.add(((Object) formatTime) + " " + this.mContext.getResources().getString(R.string.dfm));
            } else if (i2 == 2) {
                arrayList.add(((Object) formatTime) + " " + this.mContext.getResources().getString(R.string.dfc));
            } else {
                arrayList.add(((Object) formatTime) + " " + f.aA(this.mContext, instance.get(7)));
            }
        }
        int i3 = instance.get(1);
        int i4 = instance.get(2) + 1;
        for (int i5 = 0; i5 < 12; i5++) {
            if (i4 + i5 > 12) {
                instance.set(1, i3 + 1);
                instance.set(2, (i4 + i5) - 12);
            } else {
                instance.set(2, i4 + i5);
            }
            instance.set(5, 1);
            this.PGA.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(f.formatTime(this.mContext.getString(R.string.dew), instance.getTimeInMillis() / 1000)));
        }
        String[] listToStrings = Util.listToStrings(arrayList);
        AppMethodBeat.o(36729);
        return listToStrings;
    }
}
