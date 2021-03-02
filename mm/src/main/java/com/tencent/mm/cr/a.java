package com.tencent.mm.cr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.b;
import com.tencent.xweb.f;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import com.tencent.xweb.y;
import java.util.HashMap;

public final class a {
    public static AbstractC0307a Rzb;

    /* renamed from: com.tencent.mm.cr.a$a  reason: collision with other inner class name */
    public interface AbstractC0307a {
        boolean bGw();

        boolean bGx();

        void bGy();

        void d(int i2, Context context, String str, String str2, String str3, boolean z, HashMap<String, String> hashMap, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2);

        void r(Context context, String str, String str2);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, f.a aVar, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, boolean z) {
        AppMethodBeat.i(223916);
        a(context, str, str2, str3, str4, false, (HashMap<String, String>) new HashMap(), aVar, valueCallback, valueCallback2, z);
        AppMethodBeat.o(223916);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z, HashMap<String, String> hashMap, f.a aVar, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, boolean z2) {
        String str5;
        AppMethodBeat.i(177306);
        hashMap.put("hide_title_bar_right_button", String.valueOf(!z2));
        String bpF = bpF(str);
        if (str3 != null) {
            str5 = str3.toLowerCase();
        } else {
            str5 = str3;
        }
        d.kT(MMApplicationContext.getContext());
        if (z) {
            a(40, context, bpF, str2, str5, str4, false, true, hashMap, valueCallback, valueCallback2, z2);
            AppMethodBeat.o(177306);
            return;
        }
        f.nX(bpF, str5);
        Intent intent = new Intent();
        switch (f.a(str5, aVar, true, intent)) {
            case XWEB:
                a(context, bpF, str2, str5, str4, false, b.hsm(), hashMap, valueCallback, valueCallback2, z2);
                AppMethodBeat.o(177306);
                return;
            default:
                a(intent.getIntExtra(f.SyS, 40), context, bpF, str2, str5, str4, false, false, hashMap, valueCallback, valueCallback2, z2);
                AppMethodBeat.o(177306);
                return;
        }
    }

    public static void Z(Context context, String str, String str2) {
        AppMethodBeat.i(152898);
        if (Rzb == null || !Rzb.bGw()) {
            String bpF = bpF(str2);
            h.nZ(str, bpF);
            g.o(context, str, bpF);
            AppMethodBeat.o(152898);
            return;
        }
        Rzb.r(context, str, str2);
        AppMethodBeat.o(152898);
    }

    public static String bpF(String str) {
        AppMethodBeat.i(152899);
        if (Util.isNullOrNil(str)) {
            Log.e("XFilesReaderLogic", "getSafeRealPath filePath is empty");
            AppMethodBeat.o(152899);
            return str;
        }
        try {
            String k = s.k(str, false);
            if (Util.isNullOrNil(k)) {
                Log.e("XFilesReaderLogic", "getSafeRealPath real path is empty, use old path %s", str);
                AppMethodBeat.o(152899);
                return str;
            } else if (k.equals(str)) {
                Log.i("XFilesReaderLogic", "getSafeRealPath real path is the same %s", k);
                AppMethodBeat.o(152899);
                return k;
            } else {
                Log.i("XFilesReaderLogic", "getSafeRealPath from %s to %s", str, k);
                AppMethodBeat.o(152899);
                return k;
            }
        } catch (Exception e2) {
            Log.e("XFilesReaderLogic", "getSafeRealPath error: %s", e2.getMessage());
            AppMethodBeat.o(152899);
            return str;
        }
    }

    static void a(int i2, final Context context, final String str, final String str2, final String str3, final String str4, final boolean z, boolean z2, final HashMap<String, String> hashMap, final ValueCallback<String> valueCallback, final ValueCallback<Integer> valueCallback2, final boolean z3) {
        AppMethodBeat.i(223917);
        if (z) {
            f.brZ(str3);
        }
        if (Rzb == null || !Rzb.bGw()) {
            g.e(i2, context, str, str3, str4, z2, hashMap, valueCallback, new ValueCallback<Integer>() {
                /* class com.tencent.mm.cr.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Integer num) {
                    boolean z;
                    AppMethodBeat.i(223907);
                    Integer num2 = num;
                    Log.i("XFilesReaderLogic", "readFileByX5 onReceiveValue: ".concat(String.valueOf(num2)));
                    if (num2.intValue() == -102) {
                        boolean hsn = b.hsn();
                        if (y.hsF() == null || !y.hsF().hsH()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            f.bsa(str3);
                        } else if (h.r(str3, z, hsn)) {
                            Log.i("XFilesReaderLogic", "try use xweb");
                            a.a(context, str, str2, str3, str4, true, hsn, (HashMap<String, String>) hashMap, (ValueCallback<String>) valueCallback, (ValueCallback<Integer>) valueCallback2, z3);
                            AppMethodBeat.o(223907);
                            return;
                        }
                    }
                    valueCallback2.onReceiveValue(num2);
                    AppMethodBeat.o(223907);
                }
            });
            AppMethodBeat.o(223917);
        } else if (Rzb.bGx()) {
            Log.i("XFilesReaderLogic", "need download miniqb to continue");
            Rzb.bGy();
            AppMethodBeat.o(223917);
        } else {
            Log.i("XFilesReaderLogic", "load by mini qb file loader");
            Rzb.d(i2, context, str, str3, str4, z2, hashMap, valueCallback, new ValueCallback<Integer>() {
                /* class com.tencent.mm.cr.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Integer num) {
                    AppMethodBeat.i(152891);
                    Integer num2 = num;
                    Log.i("XFilesReaderLogic", "load by mini qb file loader onReceiveValue: ".concat(String.valueOf(num2)));
                    if (num2.intValue() == -102 && z) {
                        f.bsa(str3);
                    }
                    valueCallback2.onReceiveValue(num2);
                    AppMethodBeat.o(152891);
                }
            });
            AppMethodBeat.o(223917);
        }
    }

    static void a(final Context context, final String str, final String str2, final String str3, final String str4, final boolean z, boolean z2, final HashMap<String, String> hashMap, final ValueCallback<String> valueCallback, final ValueCallback<Integer> valueCallback2, final boolean z3) {
        AppMethodBeat.i(223918);
        if (z) {
            f.bsb(str3);
        }
        if (!(context instanceof MMActivity)) {
            Log.e("XFilesReaderLogic", "readFileByXWeb not mmactivity, use x5");
            if (!z) {
                a(48, context, str, str2, str3, str4, true, false, hashMap, valueCallback, valueCallback2, z3);
            }
            AppMethodBeat.o(223918);
            return;
        }
        MMActivity mMActivity = (MMActivity) context;
        ViewGroup a2 = a(mMActivity, str2, valueCallback, z3);
        if (a2 == null) {
            Log.e("XFilesReaderLogic", "readFileByXWeb contentView is null, use x5");
            if (!z) {
                a(48, context, str, str2, str3, str4, true, false, hashMap, valueCallback, valueCallback2, z3);
            }
            AppMethodBeat.o(223918);
            return;
        }
        h.a(str, str3, str4, z2, h.c.ListView, mMActivity, a2, new h.a() {
            /* class com.tencent.mm.cr.a.AnonymousClass3 */

            @Override // com.tencent.xweb.h.a
            public final void cTA() {
            }

            @Override // com.tencent.xweb.h.a
            public final void Rz(int i2) {
            }

            @Override // com.tencent.xweb.h.a
            public final void ar(int i2, int i3, int i4) {
            }

            @Override // com.tencent.xweb.h.a
            public final void c(int i2, Bitmap bitmap) {
            }

            @Override // com.tencent.xweb.h.a
            public final void b(int i2, float f2, int i3, int i4, int i5, int i6) {
            }

            @Override // com.tencent.xweb.h.a
            public final void epv() {
                AppMethodBeat.i(223908);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("xwebFileReaderReachEnd");
                }
                AppMethodBeat.o(223908);
            }

            @Override // com.tencent.xweb.h.a
            public final void epw() {
                AppMethodBeat.i(223909);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("xwebFileReaderUserOperated");
                }
                AppMethodBeat.o(223909);
            }

            @Override // com.tencent.xweb.h.a
            public final void epu() {
            }
        }, new ValueCallback<Integer>() {
            /* class com.tencent.mm.cr.a.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Integer num) {
                AppMethodBeat.i(223910);
                Integer num2 = num;
                Log.i("XFilesReaderLogic", "readFileByXWeb onReceiveValue: ".concat(String.valueOf(num2)));
                if (num2.intValue() == 0) {
                    valueCallback2.onReceiveValue(0);
                    AppMethodBeat.o(223910);
                } else if (z) {
                    f.bsc(str3);
                    valueCallback2.onReceiveValue(-102);
                    AppMethodBeat.o(223910);
                } else if (num2.intValue() == -14 || num2.intValue() == -15) {
                    valueCallback2.onReceiveValue(-102);
                    AppMethodBeat.o(223910);
                } else {
                    Log.i("XFilesReaderLogic", "try use x5");
                    a.a(49, context, str, str2, str3, str4, true, false, hashMap, valueCallback, valueCallback2, z3);
                    AppMethodBeat.o(223910);
                }
            }
        });
        AppMethodBeat.o(223918);
    }

    private static ViewGroup a(MMActivity mMActivity, String str, final ValueCallback<String> valueCallback, boolean z) {
        AppMethodBeat.i(177308);
        View inflate = aa.jQ(mMActivity.getContext()).inflate(R.layout.cd6, (ViewGroup) new LinearLayout(mMActivity.getContext()), false);
        TextView textView = (TextView) inflate.findViewById(R.id.jsg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.jsh);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.jsi);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.jsj);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.jsk);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.jse);
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.jsd);
        if (textView == null || textView2 == null || linearLayout == null || linearLayout2 == null || imageButton == null || linearLayout3 == null || imageButton2 == null) {
            Log.e("XFilesReaderLogic", "initView can not find view");
            AppMethodBeat.o(177308);
            return null;
        }
        int color = mMActivity.getResources().getColor(R.color.a2r);
        if (ao.isDarkMode()) {
            c(mMActivity, color);
            imageButton.setImageResource(R.drawable.bwc);
            imageButton2.setImageResource(R.drawable.bwf);
        } else {
            imageButton.setImageResource(R.drawable.bw7);
            imageButton2.setImageResource(R.drawable.bw_);
        }
        linearLayout2.setVisibility(0);
        imageButton.setVisibility(0);
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.cr.a.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(223911);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                valueCallback.onReceiveValue("fileReaderClosed");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(223911);
            }
        });
        linearLayout3.setVisibility(0);
        if (z) {
            imageButton2.setVisibility(0);
            imageButton2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.cr.a.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(223912);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/xwebutil/FileReaderLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    valueCallback.onReceiveValue("fileReaderMenuClicked");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(223912);
                }
            });
        } else {
            imageButton2.setVisibility(8);
        }
        linearLayout.setVisibility(0);
        textView2.setVisibility(0);
        textView2.setText(R.string.j7m);
        textView.setVisibility(0);
        textView.setText(str);
        FrameLayout frameLayout = new FrameLayout(mMActivity);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (ao.isDarkMode()) {
            frameLayout.setBackgroundColor(-15132391);
        } else {
            frameLayout.setBackgroundColor(-3355444);
        }
        RelativeLayout relativeLayout = new RelativeLayout(mMActivity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setTag("view_tag_relative_layout");
        frameLayout.addView(relativeLayout);
        Toolbar toolbar = new Toolbar(mMActivity);
        toolbar.setLayoutParams(new Toolbar.LayoutParams(-1));
        toolbar.setBackgroundColor(color);
        toolbar.mY();
        toolbar.setTag("view_tag_toolbar");
        frameLayout.addView(toolbar);
        mMActivity.setContentView(frameLayout);
        mMActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = mMActivity.getSupportActionBar();
        if (supportActionBar == null) {
            AppMethodBeat.o(177308);
            return null;
        }
        supportActionBar.gt();
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        supportActionBar.gs();
        supportActionBar.gu();
        supportActionBar.setCustomView(inflate);
        AppMethodBeat.o(177308);
        return frameLayout;
    }

    private static void c(MMActivity mMActivity, int i2) {
        AppMethodBeat.i(177309);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = mMActivity.getWindow();
                if (window == null) {
                    AppMethodBeat.o(177309);
                    return;
                }
                window.clearFlags(201326592);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(i2);
                if (Build.VERSION.SDK_INT >= 23) {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -8193);
                }
            }
            AppMethodBeat.o(177309);
        } catch (Exception e2) {
            Log.e("XFilesReaderLogic", "updateStatusBarToDarkMode error ", e2);
            AppMethodBeat.o(177309);
        }
    }

    public static void e(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(152903);
        if (context == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            Log.e("XFilesReaderLogic", "sendResult wrong param");
            AppMethodBeat.o(152903);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("op_type", "NOTIFY_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.putExtra("MINIQB_OPEN_RET_VAL", i2 == 0);
        context.sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        AppMethodBeat.o(152903);
    }

    public static void a(final MMActivity mMActivity, final String str, final String str2, final String str3) {
        AppMethodBeat.i(152904);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("desc_title", str2);
        intent.putExtra("Retr_Msg_Type", 3);
        c.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
            /* class com.tencent.mm.cr.a.AnonymousClass7 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(223914);
                if (i2 != 1 || i3 != -1) {
                    AppMethodBeat.o(223914);
                } else if (intent == null) {
                    Log.e("XFilesReaderLogic", "mmOnActivityResult fail, retData is null");
                    AppMethodBeat.o(223914);
                } else {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        Log.e("XFilesReaderLogic", "mmOnActivityResult fail, toUser is null");
                        AppMethodBeat.o(223914);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("MINIQB_OPEN_RET");
                    intent2.putExtra("op_type", "SEND_TO_FRIENDS");
                    intent2.putExtra("file_path", str);
                    intent2.putExtra("file_name", str2);
                    intent2.putExtra("file_ext", str3);
                    intent2.putExtra("to_user", stringExtra);
                    intent2.putExtra("send_text", stringExtra2);
                    mMActivity.sendBroadcast(intent2, WeChatPermissions.PERMISSION_MM_MESSAGE());
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.cr.a.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(223913);
                            com.tencent.mm.ui.widget.snackbar.b.r(mMActivity, mMActivity.getString(R.string.j7l));
                            AppMethodBeat.o(223913);
                        }
                    });
                    AppMethodBeat.o(223914);
                }
            }
        });
        AppMethodBeat.o(152904);
    }
}
