package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.co;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessShareMessageProxyUI extends MMActivity {
    private d nUK;
    private a nUL;

    /* access modifiers changed from: package-private */
    public interface b {
        void e(boolean z, String str, int i2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$1  reason: invalid class name */
    static class AnonymousClass1 extends ResultReceiver {
        final /* synthetic */ y.a nUM;

        /* access modifiers changed from: protected */
        public final void onReceiveResult(int i2, Bundle bundle) {
            AppMethodBeat.i(48686);
            if (-1 == i2 && this.nUM != null) {
                this.nUM.a(true, bundle == null ? null : bundle.getString("message"), 0);
            }
            if (-2 == i2 && this.nUM != null) {
                this.nUM.a(false, null, 0);
            }
            AppMethodBeat.o(48686);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(48699);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(48699);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        Bundle bundle2;
        AppMethodBeat.i(48700);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        y.e(getWindow());
        y.d(getWindow(), false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(48700);
            return;
        }
        String stringExtra = getIntent().getStringExtra("key_dialog_touser");
        if (Util.isNullOrNil(stringExtra)) {
            z = false;
        } else {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("key_dialog_params");
            boolean cg = co.cg(hashMap.get("is_video"));
            int i2 = co.getInt(hashMap.get("type"), 1);
            String c2 = co.c(hashMap.get("title"), "");
            String c3 = co.c(hashMap.get("img_url"), null);
            if (i2 == 2 || i2 == 3) {
                int i3 = co.getInt(hashMap.get("pkg_type"), 0);
                int i4 = co.getInt(hashMap.get("pkg_version"), 0);
                String c4 = co.c(hashMap.get("app_id"), null);
                String c5 = co.c(hashMap.get("cache_key"), null);
                String c6 = co.c(hashMap.get("path"), null);
                String c7 = co.c(hashMap.get("delay_load_img_path"), null);
                String c8 = co.c(hashMap.get("nickname"), "");
                boolean cg2 = co.cg(hashMap.get("is_dynamic"));
                int i5 = co.getInt(hashMap.get("biz"), k.a.BUSINESS_MAX.ordinal());
                if (k.a.isValid(i5)) {
                    String c9 = co.c(hashMap.get("tail_lang"), "");
                    String c10 = co.c(hashMap.get("icon_url"), "");
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("key_biz", i5);
                    bundle3.putString("key_footer_text_default", c8);
                    bundle3.putString("key_footer_text", k.a.b(i5, c9, getContext()));
                    bundle3.putString("key_footer_icon", c10);
                    Log.d("MicroMsg.AppBrandProcessShareMessageProxyUI", "defaultFooterTxt: %s, tailLang: %s.", c8, c9);
                    bundle2 = bundle3;
                } else if (cg) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putBoolean("is_video", true);
                    String c11 = co.c(hashMap.get("footer_icon"), "");
                    String c12 = co.c(hashMap.get("footer_text"), "");
                    bundle4.putString("key_footer_icon", c11);
                    bundle4.putString("key_footer_text", c12);
                    bundle2 = bundle4;
                } else {
                    Log.w("MicroMsg.AppBrandProcessShareMessageProxyUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i5));
                    bundle2 = null;
                }
                final View a2 = ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).a((Context) this, bundle2, false, (k.c) null);
                final String cO = n.cO(this);
                Bundle bundle5 = new Bundle();
                bundle5.putString("app_id", c4);
                bundle5.putString("msg_id", String.format("%d-%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                bundle5.putInt("msg_pkg_type", i3);
                bundle5.putInt("pkg_version", i4);
                bundle5.putString(MessengerShareContentUtility.IMAGE_URL, c3);
                bundle5.putBoolean("is_dynamic_page", cg2);
                bundle5.putString("title", c2);
                bundle5.putString("cache_key", c5);
                bundle5.putString("msg_path", c6);
                bundle5.putString("delay_load_img_path", c7);
                if (cg) {
                    String c13 = co.c(hashMap.get("video_path"), "");
                    String c14 = co.c(hashMap.get("video_thumb_path"), "");
                    bundle5.putBoolean("is_video", true);
                    bundle5.putString("video_path", c13);
                    bundle5.putString("video_thumb_path", c14);
                }
                final c cVar = new c(this);
                cVar.nUT = new b() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.b
                    public final void e(boolean z, String str, int i2) {
                        AppMethodBeat.i(48687);
                        Log.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", Boolean.valueOf(z));
                        if (AppBrandProcessShareMessageProxyUI.this.nUL != null) {
                            AppBrandProcessShareMessageProxyUI.this.nUL.a(z, str, i2);
                        }
                        ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2);
                        AppMethodBeat.o(48687);
                    }
                };
                ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2, bundle5, new k.b() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.AnonymousClass3 */

                    @Override // com.tencent.mm.modelappbrand.k.b
                    public final void sD(int i2) {
                        AppMethodBeat.i(48688);
                        Log.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", Integer.valueOf(i2));
                        c cVar = cVar;
                        cVar.nUQ = true;
                        if (cVar.rS()) {
                            MMHandlerThread.removeRunnable(cVar.lNe);
                            cVar.bXo();
                        }
                        AppMethodBeat.o(48688);
                    }
                });
                this.nUL = new a();
                this.nUK = ((j) g.af(j.class)).a(this, stringExtra, a2, getResources().getString(R.string.a3j), new y.a() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.AnonymousClass4 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        AppMethodBeat.i(48689);
                        AppBrandProcessShareMessageProxyUI.this.hideVKB();
                        cVar.f(z, str, i2);
                        AppMethodBeat.o(48689);
                    }
                });
                this.nUK.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.AnonymousClass5 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(48690);
                        ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2);
                        AppBrandProcessShareMessageProxyUI.this.finish();
                        AppMethodBeat.o(48690);
                    }
                });
                this.nUK.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.AnonymousClass6 */

                    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(48691);
                        if (i2 == 4 && keyEvent.getAction() == 1) {
                            cVar.f(false, null, 0);
                            dialogInterface.dismiss();
                        }
                        AppMethodBeat.o(48691);
                        return false;
                    }
                });
                this.nUK.show();
            }
            z = true;
        }
        if (!z) {
            finish();
        }
        AppMethodBeat.o(48700);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(48701);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(48701);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(48702);
        super.onDestroy();
        if (this.nUK != null && this.nUK.isShowing()) {
            this.nUK.dismiss();
            this.nUK = null;
            this.nUL = null;
        }
        AppMethodBeat.o(48702);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMOrientation() {
        AppMethodBeat.i(48703);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.o(48703);
    }

    /* access modifiers changed from: package-private */
    public class a implements y.a {
        private boolean lwr = false;

        a() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
        public final void a(boolean z, String str, int i2) {
            AppMethodBeat.i(48692);
            if (z) {
                av(-1, str);
                AppMethodBeat.o(48692);
                return;
            }
            av(-2, null);
            AppMethodBeat.o(48692);
        }

        private void av(int i2, String str) {
            AppMethodBeat.i(48693);
            if (this.lwr) {
                AppMethodBeat.o(48693);
                return;
            }
            this.lwr = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessShareMessageProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                Bundle bundle = null;
                if (!Util.isNullOrNil(str)) {
                    bundle = new Bundle();
                    bundle.putString("message", str);
                }
                resultReceiver.send(i2, bundle);
            }
            AppMethodBeat.o(48693);
        }
    }

    class c {
        private Context context;
        Runnable lNe = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(48694);
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.dismiss();
                }
                c.this.bXo();
                AppMethodBeat.o(48694);
            }
        };
        private boolean nUP;
        boolean nUQ;
        private boolean nUR;
        private int nUS;
        b nUT;
        private String text;
        q tipDialog;

        public c(Context context2) {
            AppMethodBeat.i(48695);
            this.context = context2;
            AppMethodBeat.o(48695);
        }

        public final void f(boolean z, String str, int i2) {
            AppMethodBeat.i(48696);
            this.nUP = true;
            this.nUR = z;
            this.text = str;
            this.nUS = i2;
            if (rS()) {
                bXo();
                AppMethodBeat.o(48696);
                return;
            }
            if (z) {
                this.tipDialog = h.a(this.context, this.context.getString(R.string.ys), true, (DialogInterface.OnCancelListener) null);
                MMHandlerThread.postToMainThreadDelayed(this.lNe, 5000);
            }
            AppMethodBeat.o(48696);
        }

        public final boolean rS() {
            return this.nUP && this.nUQ;
        }

        public final void bXo() {
            AppMethodBeat.i(48697);
            if (this.nUT != null) {
                this.nUT.e(this.nUR, this.text, this.nUS);
            }
            AppMethodBeat.o(48697);
        }
    }
}
