package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.SensorManager;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class k {
    private static p FjK;
    private static final String[] FjL = {"_id", "_begin_time", "_end_time", "_mode", "_steps"};
    private static final Uri FjM = Uri.parse("content://com.miui.providers.steps/item");

    public static long fmH() {
        AppMethodBeat.i(149351);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(149351);
        return timeInMillis;
    }

    public static int fmI() {
        AppMethodBeat.i(149352);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = ((!timeZone.useDaylightTime() || !timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 0 : 1) + ((timeZone.getRawOffset() / 1000) / LocalCache.TIME_HOUR);
        AppMethodBeat.o(149352);
        return rawOffset;
    }

    public static final String AF(long j2) {
        AppMethodBeat.i(149353);
        String format = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date(j2));
        AppMethodBeat.o(149353);
        return format;
    }

    public static boolean ar(long j2, long j3) {
        AppMethodBeat.i(149354);
        long j4 = Util.MILLSECONDS_OF_HOUR;
        try {
            JSONObject optJSONObject = g.fmy().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                j4 = ((long) (optJSONObject.optInt("backgroundTimeInterval", 60) * 60)) * 1000;
            }
        } catch (Exception e2) {
        }
        if (j3 - j2 >= j4) {
            AppMethodBeat.o(149354);
            return true;
        }
        AppMethodBeat.o(149354);
        return false;
    }

    public static boolean as(long j2, long j3) {
        int i2 = 500;
        AppMethodBeat.i(149355);
        if (j2 != 0 || j3 <= 0) {
            try {
                JSONObject optJSONObject = g.fmy().optJSONObject("stepCountUploadConfig");
                if (optJSONObject != null) {
                    i2 = optJSONObject.optInt("backgroundStepCountInterval", 500);
                }
            } catch (Exception e2) {
            }
            if (j3 - j2 >= ((long) i2)) {
                AppMethodBeat.o(149355);
                return true;
            }
            AppMethodBeat.o(149355);
            return false;
        }
        AppMethodBeat.o(149355);
        return true;
    }

    public static boolean hg(Context context) {
        AppMethodBeat.i(149356);
        if (d.oE(19)) {
            Log.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
            AppMethodBeat.o(149356);
            return false;
        } else if (!context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            Log.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
            AppMethodBeat.o(149356);
            return false;
        } else {
            try {
                if (((SensorManager) MMApplicationContext.getContext().getSystemService("sensor")).getDefaultSensor(19) == null) {
                    Log.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
                    AppMethodBeat.o(149356);
                    return false;
                } else if (g.fmy().optInt("deviceStepSwitch") != 1) {
                    Log.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
                    AppMethodBeat.o(149356);
                    return false;
                } else {
                    AppMethodBeat.o(149356);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(149356);
                return false;
            }
        }
    }

    public static boolean fmJ() {
        AppMethodBeat.i(149357);
        if (g.fmy().optInt("checkWeSportInstall") != 1) {
            Log.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
            AppMethodBeat.o(149357);
            return false;
        }
        AppMethodBeat.o(149357);
        return true;
    }

    public static boolean fmK() {
        AppMethodBeat.i(149358);
        if (g.fmy().optInt("extStepApiSwitch") != 1) {
            Log.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
            AppMethodBeat.o(149358);
            return false;
        }
        AppMethodBeat.o(149358);
        return true;
    }

    public static boolean fmg() {
        boolean z;
        AppMethodBeat.i(149359);
        as Kn = ((l) g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
        if (Kn != null) {
            z = c.oR(Kn.field_type);
        } else {
            z = false;
        }
        if (!z) {
            Log.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(149359);
        return z;
    }

    public static void l(Activity activity, String str) {
        AppMethodBeat.i(149360);
        if (FjK != null && FjK.isShowing()) {
            AppMethodBeat.o(149360);
        } else if (j.aJ(5, 1) == 0) {
            AppMethodBeat.o(149360);
        } else {
            if (z.aTY().equals(str) && !((b) g.af(b.class)).hg(MMApplicationContext.getContext())) {
                int color = activity.getResources().getColor(R.color.Red);
                String string = MMApplicationContext.getContext().getString(R.string.hds);
                AnonymousClass1 r3 = new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sport.model.k.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(149350);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        j.aK(5, 0);
                        a.a(this, "com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(149350);
                    }
                };
                View inflate = View.inflate(activity, R.layout.c3e, null);
                ((LinearLayout) inflate.findViewById(R.id.a2c)).setBackgroundResource(R.drawable.azx);
                TextView textView = (TextView) inflate.findViewById(R.id.ipl);
                textView.setText(string);
                textView.setOnClickListener(null);
                WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.ipj);
                weImageView.setImageResource(R.raw.icons_filled_info);
                weImageView.setIconColor(color);
                p pVar = new p(inflate);
                pVar.setWidth(-1);
                pVar.setHeight(-2);
                Rect rect = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int i2 = rect.top;
                int eu = au.eu(activity);
                if (i2 == 0) {
                    i2 = au.ay(activity);
                }
                pVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2 + eu);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.ipk);
                imageView.setImageResource(R.raw.icons_outlined_close);
                imageView.setOnClickListener(new View.OnClickListener(pVar, r3) {
                    /* class com.tencent.mm.ui.widget.a.h.AnonymousClass2 */
                    final /* synthetic */ p OTQ;
                    final /* synthetic */ View.OnClickListener QOV;

                    {
                        this.OTQ = r1;
                        this.QOV = r2;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(198282);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        this.OTQ.dismiss();
                        if (this.QOV != null) {
                            this.QOV.onClick(view);
                        }
                        a.a(this, "com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198282);
                    }
                });
                FjK = pVar;
            }
            AppMethodBeat.o(149360);
        }
    }

    public static void dYf() {
        AppMethodBeat.i(149361);
        if (FjK != null) {
            FjK.dismiss();
            FjK = null;
        }
        AppMethodBeat.o(149361);
    }

    public static long[] aRG(String str) {
        AppMethodBeat.i(149362);
        String[] split = str.split(",");
        long[] jArr = new long[split.length];
        jArr[0] = Util.getLong(split[0], 0);
        jArr[1] = Util.getLong(split[1], 0);
        jArr[2] = Util.getLong(split[2], 0);
        jArr[3] = Util.getLong(split[3], 0);
        jArr[4] = Util.getLong(split[4], 0);
        jArr[5] = Util.getLong(split[5], 0);
        jArr[6] = Util.getLong(split[6], 0);
        AppMethodBeat.o(149362);
        return jArr;
    }

    static {
        AppMethodBeat.i(149364);
        AppMethodBeat.o(149364);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int fmL() {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sport.model.k.fmL():int");
    }
}
